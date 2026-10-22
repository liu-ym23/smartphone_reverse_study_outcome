package androidx.documentfile.provider;

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

    RawDocumentFile(@Nullable DocumentFile r10, File r11) {
        super(r10);
        this.mFile = r11;
    }

    private static boolean deleteContents(File r10) {
        File[] r11 = r10.listFiles();
        boolean r12 = true;
        if (r11 == null) goto L13;
        int r13 = r11.length;
        int r14 = 0;
    L5:
        if (r14 >= r13) goto L13;
        File r15 = r11[r14];
        if (r15.isDirectory() == false) goto L10;
        r12 = r12 & deleteContents(r15);
    L10:
        if (r15.delete() == true) goto L12;
        Log.w("DocumentFile", "Failed to delete " + r15);
        r12 = false;
    L12:
        r14 = r14 + 1;
    L13:
        return r12;
    }

    private static String getTypeForName(String r10) {
        int r11 = r10.lastIndexOf(46);
        if (r11 < 0) goto L7;
        String r12 = r10.substring(r11 + 1).toLowerCase();
        String r13 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(r12);
        if (r13 == null) goto L9;
        return r13;
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
    public DocumentFile createDirectory(String r10) {
        File r11 = new File(this.mFile, r10);
        if (r11.isDirectory() == true) goto L10;
        if (r11.mkdir() == true) goto L10;
        return null;
    L10:
        return new RawDocumentFile(this, r11);
    }

    @Override // androidx.documentfile.provider.DocumentFile
    @Nullable
    public DocumentFile createFile(String r10, String r11) {
        String r12 = MimeTypeMap.getSingleton().getExtensionFromMimeType(r10);
        if (r12 == null) goto L5;
        r11 = r11 + "." + r12;
    L5:
        File r13 = new File(this.mFile, r11);
        r13.createNewFile();     // Catch: IOException -> L8
        return new RawDocumentFile(this, r13);
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
        ArrayList r10 = new ArrayList();
        File[] r11 = this.mFile.listFiles();
        if (r11 == null) goto L8;
        int r12 = r11.length;
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L8;
        r10.add(new RawDocumentFile(this, r11[r13]));
        r13 = r13 + 1;
    L8:
        return (DocumentFile[]) r10.toArray(new DocumentFile[r10.size()]);
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public boolean renameTo(String r10) {
        File r11 = new File(this.mFile.getParentFile(), r10);
        if (this.mFile.renameTo(r11) == false) goto L6;
        this.mFile = r11;
        return true;
    L6:
        return false;
    }
}
