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

    public TreeDocumentFile(@Nullable DocumentFile r5, Context r10, Uri r11) {
        super(r5);
        this.mContext = r10;
        this.mUri = r11;
    }

    private static void closeQuietly(@Nullable AutoCloseable r5) {
        if (r5 != null) goto L9;
        return;
    L9:
        r5.close();     // Catch: RuntimeException -> L5 Exception -> L8
        goto L12
    L11:
        return;
    L5:
        e = move-exception;
        throw e;
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
    public DocumentFile createDirectory(String r5) {
        Uri r10 = createFile(this.mContext, this.mUri, "vnd.android.document/directory", r5);
        if (r10 != null) goto L7;
        return null;
    L7:
        return new TreeDocumentFile(this, this.mContext, r10);
    }

    @Override // androidx.documentfile.provider.DocumentFile
    @Nullable
    public DocumentFile createFile(String r5, String r10) {
        Uri r11 = createFile(this.mContext, this.mUri, r5, r10);
        if (r11 != null) goto L7;
        return null;
    L7:
        return new TreeDocumentFile(this, this.mContext, r11);
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
        ContentResolver r5 = this.mContext.getContentResolver();
        Uri r10 = this.mUri;
        Uri r11 = DocumentsContract.buildChildDocumentsUriUsingTree(r10, DocumentsContract.getDocumentId(r10));
        ArrayList r12 = new ArrayList();
        int r13 = 0;
        Cursor r14 = null;
        r14 = r5.query(r11, new String[]{"document_id"}, null, null, null);     // Catch: Throwable -> L8 Exception -> L10
    L5:
        if (r14.moveToNext() == false) goto L12;
        r12.add(DocumentsContract.buildDocumentUriUsingTree(this.mUri, r14.getString(0)));     // Catch: Throwable -> L8 Exception -> L10
    L12:
        closeQuietly(r14);
        Uri[] r15 = (Uri[]) r12.toArray(new Uri[r12.size()]);
        DocumentFile[] r16 = new DocumentFile[r15.length];
    L17:
        if (r13 >= r15.length) goto L19;
        r16[r13] = new TreeDocumentFile(this, this.mContext, r15[r13]);
        r13 = r13 + 1;
        goto L17
    L19:
        return r16;
    L10:
        e = move-exception;
        Log.w("DocumentFile", "Failed query: " + e);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        closeQuietly(r14);
        throw th;
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public boolean renameTo(String r5) {
        Uri r10 = DocumentsContract.renameDocument(this.mContext.getContentResolver(), this.mUri, r5);     // Catch: Exception -> L9
        if (r10 == null) goto L8;
        this.mUri = r10;     // Catch: Exception -> L9
        return true;
    L8:
        return false;
    }

    @Nullable
    private static Uri createFile(Context r5, Uri r10, String r11, String r12) {
        return DocumentsContract.createDocument(r5.getContentResolver(), r10, r11, r12);
    L4:
        return null;
    }
}
