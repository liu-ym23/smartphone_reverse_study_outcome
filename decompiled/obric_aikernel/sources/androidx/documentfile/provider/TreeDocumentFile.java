package androidx.documentfile.provider;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
class TreeDocumentFile extends DocumentFile {
    private Context mContext;
    private Uri mUri;

    TreeDocumentFile(@Nullable DocumentFile r10, Context r11, Uri r12) {
        super(r10);
        this.mContext = r11;
        this.mUri = r12;
    }

    private static void closeQuietly(@Nullable AutoCloseable r10) {
        if (r10 != null) goto L9;
        return;
    L9:
        r10.close();     // Catch: RuntimeException -> L5 Exception -> L8
        goto L12
    L11:
        return;
    L5:
        e = move-exception;
        throw e;
    }

    @Nullable
    private static Uri createFile(Context r10, Uri r11, String r12, String r13) {
        return DocumentsContract.createDocument(r10.getContentResolver(), r11, r12, r13);
    L4:
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
    @Nullable
    public DocumentFile createDirectory(String r10) {
        Uri r11 = createFile(this.mContext, this.mUri, "vnd.android.document/directory", r10);
        if (r11 != null) goto L7;
        return null;
    L7:
        return new TreeDocumentFile(this, this.mContext, r11);
    }

    @Override // androidx.documentfile.provider.DocumentFile
    @Nullable
    public DocumentFile createFile(String r10, String r11) {
        Uri r12 = createFile(this.mContext, this.mUri, r10, r11);
        if (r12 != null) goto L7;
        return null;
    L7:
        return new TreeDocumentFile(this, this.mContext, r12);
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
    @Nullable
    public String getName() {
        return DocumentsContractApi19.getName(this.mContext, this.mUri);
    }

    @Override // androidx.documentfile.provider.DocumentFile
    @Nullable
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
        ContentResolver r10 = this.mContext.getContentResolver();
        Uri r11 = this.mUri;
        Uri r12 = DocumentsContract.buildChildDocumentsUriUsingTree(r11, DocumentsContract.getDocumentId(r11));
        ArrayList r13 = new ArrayList();
        int r14 = 0;
        Cursor r15 = null;
        r15 = r10.query(r12, new String[]{"document_id"}, null, null, null);     // Catch: Throwable -> L9 Exception -> L11
    L5:
        if (r15.moveToNext() == false) goto L8;
        r13.add(DocumentsContract.buildDocumentUriUsingTree(this.mUri, r15.getString(0)));     // Catch: Throwable -> L9 Exception -> L11
    L8:
        closeQuietly(r15);
        Uri[] r16 = (Uri[]) r13.toArray(new Uri[r13.size()]);
        DocumentFile[] r17 = new DocumentFile[r16.length];
    L16:
        if (r14 >= r16.length) goto L18;
        r17[r14] = new TreeDocumentFile(this, this.mContext, r16[r14]);
        r14 = r14 + 1;
        goto L16
    L18:
        return r17;
    L11:
        e = move-exception;
        Log.w("DocumentFile", "Failed query: " + e);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        closeQuietly(r15);
        throw th;
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public boolean renameTo(String r10) {
        Uri r11 = DocumentsContract.renameDocument(this.mContext.getContentResolver(), this.mUri, r10);     // Catch: Exception -> L9
        if (r11 == null) goto L8;
        this.mUri = r11;     // Catch: Exception -> L9
        return true;
    L8:
        return false;
    }
}
