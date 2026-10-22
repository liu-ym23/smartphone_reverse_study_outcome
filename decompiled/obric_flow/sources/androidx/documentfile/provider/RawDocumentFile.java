package androidx.documentfile.provider;

import ai.j0;
import android.net.Uri;
import android.util.Log;
import android.webkit.MimeTypeMap;
import androidx.annotation.Nullable;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
class RawDocumentFile extends DocumentFile {
    private File mFile;

    public RawDocumentFile(@Nullable DocumentFile r5, File r10) {
        super(r5);
        this.mFile = r10;
    }

    private static boolean deleteContents(File r10) {
        File[] r11 = r10.listFiles();
        boolean r5 = true;
        if (r11 == null) goto L13;
        int r12 = r11.length;
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L13;
        File r14 = r11[r13];
        if (r14.isDirectory() == false) goto L10;
        r5 = r5 & deleteContents(r14);
    L10:
        if (r14.delete() == true) goto L12;
        Log.w("DocumentFile", "Failed to delete " + r14);
        r5 = false;
    L12:
        r13 = r13 + 1;
    L13:
        return r5;
    }

    private static String getTypeForName(String r5) {
        int r10 = r5.lastIndexOf(46);
        if (r10 < 0) goto L7;
        String r11 = r5.substring(r10 + 1).toLowerCase();
        String r12 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(r11);
        if (r12 == null) goto L9;
        return r12;
    L9:
        return "application/octet-stream";
    L7:
        return "application/octet-stream";
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public boolean canRead() {
        return this.mFile.canRead();
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public boolean canWrite() {
        return this.mFile.canWrite();
    }

    @Override // androidx.documentfile.provider.DocumentFile
    @Nullable
    public DocumentFile createDirectory(String r5) {
        File r10 = new File(this.mFile, r5);
        if (r10.isDirectory() == true) goto L10;
        if (r10.mkdir() == true) goto L10;
        return null;
    L10:
        return new RawDocumentFile(this, r10);
    }

    @Override // androidx.documentfile.provider.DocumentFile
    @Nullable
    public DocumentFile createFile(String r5, String r10) {
        String r11 = MimeTypeMap.getSingleton().getExtensionFromMimeType(r5);
        if (r11 == null) goto L5;
        r10 = j0.D(r10, ".", r11);
    L5:
        File r12 = new File(this.mFile, r10);
        r12.createNewFile();     // Catch: IOException -> L8
        return new RawDocumentFile(this, r12);
    L8:
        e = move-exception;
        Log.w("DocumentFile", "Failed to createFile: " + e);
        return null;
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public boolean delete() {
        deleteContents(this.mFile);
        return this.mFile.delete();
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public boolean exists() {
        return this.mFile.exists();
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public String getName() {
        return this.mFile.getName();
    }

    @Override // androidx.documentfile.provider.DocumentFile
    @Nullable
    public String getType() {
        if (this.mFile.isDirectory() == false) goto L7;
        return null;
    L7:
        return getTypeForName(this.mFile.getName());
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public Uri getUri() {
        return Uri.fromFile(this.mFile);
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public boolean isDirectory() {
        return this.mFile.isDirectory();
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public boolean isFile() {
        return this.mFile.isFile();
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public boolean isVirtual() {
        return false;
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public long lastModified() {
        return this.mFile.lastModified();
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public long length() {
        return this.mFile.length();
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public DocumentFile[] listFiles() {
        ArrayList r5 = new ArrayList();
        File[] r10 = this.mFile.listFiles();
        if (r10 == null) goto L8;
        int r11 = r10.length;
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L8;
        r5.add(new RawDocumentFile(this, r10[r12]));
        r12 = r12 + 1;
    L8:
        return (DocumentFile[]) r5.toArray(new DocumentFile[r5.size()]);
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public boolean renameTo(String r5) {
        File r10 = new File(this.mFile.getParentFile(), r5);
        if (this.mFile.renameTo(r10) == false) goto L6;
        this.mFile = r10;
        return true;
    L6:
        return false;
    }
}
