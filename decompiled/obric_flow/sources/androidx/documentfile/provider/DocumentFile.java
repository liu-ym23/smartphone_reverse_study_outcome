package androidx.documentfile.provider;

import android.content.Context;
import android.net.Uri;
import android.provider.DocumentsContract;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public abstract class DocumentFile {
    static final String TAG = "DocumentFile";

    @Nullable
    private final DocumentFile mParent;

    public DocumentFile(@Nullable DocumentFile r5) {
        this.mParent = r5;
    }

    @NonNull
    public static DocumentFile fromFile(@NonNull File r5) {
        return new RawDocumentFile(null, r5);
    }

    @Nullable
    public static DocumentFile fromSingleUri(@NonNull Context r5, @NonNull Uri r10) {
        return new SingleDocumentFile(null, r5, r10);
    }

    @Nullable
    public static DocumentFile fromTreeUri(@NonNull Context r5, @NonNull Uri r10) {
        return new TreeDocumentFile(null, r5, DocumentsContract.buildDocumentUriUsingTree(r10, DocumentsContract.getTreeDocumentId(r10)));
    }

    public static boolean isDocumentUri(@NonNull Context r5, @Nullable Uri r10) {
        return DocumentsContract.isDocumentUri(r5, r10);
    }

    public abstract boolean canRead();

    public abstract boolean canWrite();

    @Nullable
    public abstract DocumentFile createDirectory(@NonNull String r5);

    @Nullable
    public abstract DocumentFile createFile(@NonNull String r5, @NonNull String r10);

    public abstract boolean delete();

    public abstract boolean exists();

    @Nullable
    public DocumentFile findFile(@NonNull String r5) {
        DocumentFile[] r10 = listFiles();
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L8;
        DocumentFile r13 = r10[r12];
        if (r5.equals(r13.getName()) == true) goto L6;
        r12 = r12 + 1;
        goto L3
    L6:
        return r13;
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

    public abstract boolean renameTo(@NonNull String r5);
}
