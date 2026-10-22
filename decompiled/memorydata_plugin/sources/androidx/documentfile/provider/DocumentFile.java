package androidx.documentfile.provider;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.provider.DocumentsContract;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public abstract class DocumentFile {
    static final String TAG = "DocumentFile";
    private final DocumentFile mParent;

    DocumentFile(DocumentFile r1) {
        this.mParent = r1;
    }

    public static DocumentFile fromFile(File r2) {
        return new RawDocumentFile(null, r2);
    }

    public static DocumentFile fromSingleUri(Context r3, Uri r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT >= 19) goto L5;
        return null;
    L5:
        return new SingleDocumentFile(null, r5, r4);
    }

    public static DocumentFile fromTreeUri(Context r3, Uri r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return null;
    L5:
        return new TreeDocumentFile(null, r5, DocumentsContract.buildDocumentUriUsingTree(r4, DocumentsContract.getTreeDocumentId(r4)));
    }

    public static boolean isDocumentUri(Context r2, Uri r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT >= 19) goto L5;
        return false;
    L5:
        return DocumentsContract.isDocumentUri(r4, r3);
    }

    public abstract boolean canRead();

    public abstract boolean canWrite();

    public abstract DocumentFile createDirectory(String r1);

    public abstract DocumentFile createFile(String r1, String r2);

    public abstract boolean delete();

    public abstract boolean exists();

    public DocumentFile findFile(String r5) {
        DocumentFile[] r4 = listFiles();
        int r0 = r4.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        DocumentFile r2 = r4[r1];
        if (r5.equals(r2.getName()) == true) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        return r2;
    L8:
        return null;
    }

    public abstract String getName();

    public DocumentFile getParentFile() {
        return this.mParent;
    }

    public abstract String getType();

    public abstract Uri getUri();

    public abstract boolean isDirectory();

    public abstract boolean isFile();

    public abstract boolean isVirtual();

    public abstract long lastModified();

    public abstract long length();

    public abstract DocumentFile[] listFiles();

    public abstract boolean renameTo(String r1);
}
