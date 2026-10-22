package androidx.documentfile.provider;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.util.Log;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
class TreeDocumentFile extends DocumentFile {
    private Context mContext;
    private Uri mUri;

    TreeDocumentFile(DocumentFile r3, Context r4, Uri r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        super(r3);
        this.mContext = ZeusTransformUtils.wrapperContext(r6, "com.obric.memorydata.plugin");
        this.mUri = r5;
    }

    private static void closeQuietly(AutoCloseable r2) {
        AutoCloseable r3 = (AutoCloseable) ZeusTransformUtils.wrapperContextForParams(r2, AutoCloseable.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L10;
        return;
    L10:
        r3.close();     // Catch: RuntimeException -> L6 Exception -> L9
        goto L13
    L12:
        return;
    L6:
        e = move-exception;
        throw e;
    }

    private static Uri createFile(Context r2, Uri r3, String r4, String r5) {
        return DocumentsContract.createDocument(((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).getContentResolver(), r3, r4, r5);
    L5:
        return null;
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public boolean canRead() {
        return DocumentsContractApi19.canRead(this.mContext, this.mUri);
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public boolean canWrite() {
        return DocumentsContractApi19.canWrite(this.mContext, this.mUri);
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public DocumentFile createDirectory(String r4) {
        Uri r5 = createFile(this.mContext, this.mUri, "vnd.android.document/directory", r4);
        if (r5 != null) goto L7;
        return null;
    L7:
        return new TreeDocumentFile(this, this.mContext, r5);
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public DocumentFile createFile(String r3, String r4) {
        Uri r5 = createFile(this.mContext, this.mUri, r3, r4);
        if (r5 != null) goto L7;
        return null;
    L7:
        return new TreeDocumentFile(this, this.mContext, r5);
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public boolean delete() {
        return DocumentsContract.deleteDocument(this.mContext.getContentResolver(), this.mUri);
    L4:
        return false;
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public boolean exists() {
        return DocumentsContractApi19.exists(this.mContext, this.mUri);
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public String getName() {
        return DocumentsContractApi19.getName(this.mContext, this.mUri);
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public String getType() {
        return DocumentsContractApi19.getType(this.mContext, this.mUri);
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public Uri getUri() {
        return this.mUri;
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public boolean isDirectory() {
        return DocumentsContractApi19.isDirectory(this.mContext, this.mUri);
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public boolean isFile() {
        return DocumentsContractApi19.isFile(this.mContext, this.mUri);
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public boolean isVirtual() {
        return DocumentsContractApi19.isVirtual(this.mContext, this.mUri);
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public long lastModified() {
        return DocumentsContractApi19.lastModified(this.mContext, this.mUri);
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public long length() {
        return DocumentsContractApi19.length(this.mContext, this.mUri);
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public DocumentFile[] listFiles() {
        ContentResolver r1 = this.mContext.getContentResolver();
        Uri r0 = this.mUri;
        Uri r2 = DocumentsContract.buildChildDocumentsUriUsingTree(r0, DocumentsContract.getDocumentId(r0));
        ArrayList r3 = new ArrayList();
        int r8 = 0;
        Cursor r9 = null;
        r9 = ZeusProviderTransform.query(r1, r2, new String[]{"document_id"}, null, null, null, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9 Exception -> L11
    L5:
        if (r9.moveToNext() == false) goto L8;
        r3.add(DocumentsContract.buildDocumentUriUsingTree(this.mUri, r9.getString(0)));     // Catch: Throwable -> L9 Exception -> L11
    L8:
        closeQuietly(r9);
        Uri[] r4 = (Uri[]) ZeusTransformUtils.preCheckCast(r3.toArray(new Uri[r3.size()]), Uri[].class, "com.obric.memorydata.plugin");
        DocumentFile[] r5 = new DocumentFile[r4.length];
    L16:
        if (r8 >= r4.length) goto L18;
        r5[r8] = new TreeDocumentFile(this, this.mContext, r4[r8]);
        r8 = r8 + 1;
        goto L16
    L18:
        return r5;
    L11:
        e = move-exception;
        Log.w("DocumentFile", "Failed query: " + e);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        closeQuietly(r9);
        throw th;
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public boolean renameTo(String r4) {
        Uri r5 = DocumentsContract.renameDocument(this.mContext.getContentResolver(), this.mUri, r4);     // Catch: Exception -> L9
        if (r5 == null) goto L8;
        this.mUri = r5;     // Catch: Exception -> L9
        return true;
    L8:
        return false;
    }
}
