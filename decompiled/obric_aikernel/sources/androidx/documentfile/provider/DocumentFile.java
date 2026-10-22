package androidx.documentfile.provider;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.provider.DocumentsContract;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public abstract class DocumentFile {
    static final String TAG = "DocumentFile";

    @Nullable
    private final DocumentFile mParent;

    DocumentFile(@Nullable DocumentFile r10) {
        this.mParent = r10;
    }

    @NonNull
    public static DocumentFile fromFile(@NonNull File r10) {
        return new RawDocumentFile(null, r10);
    }

    @Nullable
    public static DocumentFile fromSingleUri(@NonNull Context r10, @NonNull Uri r11) {
        if (Build.VERSION.SDK_INT >= 19) goto L5;
        return null;
    L5:
        return new SingleDocumentFile(null, r10, r11);
    }

    @Nullable
    public static DocumentFile fromTreeUri(@NonNull Context r10, @NonNull Uri r11) {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return null;
    L5:
        return new TreeDocumentFile(null, r10, DocumentsContract.buildDocumentUriUsingTree(r11, DocumentsContract.getTreeDocumentId(r11)));
    }

    public static boolean isDocumentUri(@NonNull Context r10, @Nullable Uri r11) {
        if (Build.VERSION.SDK_INT >= 19) goto L5;
        return false;
    L5:
        return DocumentsContract.isDocumentUri(r10, r11);
    }

    public abstract boolean canRead();

    public abstract boolean canWrite();

    @Nullable
    public abstract DocumentFile createDirectory(@NonNull String r10);

    @Nullable
    public abstract DocumentFile createFile(@NonNull String r10, @NonNull String r11);

    public abstract boolean delete();

    public abstract boolean exists();

    @Nullable
    public DocumentFile findFile(@NonNull String r10) {
        DocumentFile[] r11 = listFiles();
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L8;
        DocumentFile r14 = r11[r13];
        if (r10.equals(r14.getName()) == true) goto L6;
        r13 = r13 + 1;
        goto L3
    L6:
        return r14;
    L8:
        return null;
    }

    @Nullable
    public abstract String getName();

    @Nullable
    public DocumentFile getParentFile() {
        return this.mParent;
    }

    @Nullable
    public abstract String getType();

    @NonNull
    public abstract Uri getUri();

    public abstract boolean isDirectory();

    public abstract boolean isFile();

    public abstract boolean isVirtual();

    public abstract long lastModified();

    public abstract long length();

    @NonNull
    public abstract DocumentFile[] listFiles();

    public abstract boolean renameTo(@NonNull String r10);
}
