package androidx.core.provider;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.provider.DocumentsContract;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class DocumentsContractCompat {
    private static final String PATH_TREE = "tree";

    public static final class DocumentCompat {
        public static final int FLAG_VIRTUAL_DOCUMENT = 512;

        private DocumentCompat() {
        }
    }

    private static class DocumentsContractApi19Impl {
        private DocumentsContractApi19Impl() {
        }

        public static Uri buildDocumentUri(String r0, String r1) {
            return DocumentsContract.buildDocumentUri(r0, r1);
        }

        static boolean deleteDocument(ContentResolver r0, Uri r1) {
            return DocumentsContract.deleteDocument(r0, r1);
        }

        static String getDocumentId(Uri r0) {
            return DocumentsContract.getDocumentId(r0);
        }

        static boolean isDocumentUri(Context r2, Uri r3) {
            return DocumentsContract.isDocumentUri((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), r3);
        }
    }

    private static class DocumentsContractApi21Impl {
        private DocumentsContractApi21Impl() {
        }

        static Uri buildChildDocumentsUri(String r0, String r1) {
            return DocumentsContract.buildChildDocumentsUri(r0, r1);
        }

        static Uri buildChildDocumentsUriUsingTree(Uri r0, String r1) {
            return DocumentsContract.buildChildDocumentsUriUsingTree(r0, r1);
        }

        static Uri buildDocumentUriUsingTree(Uri r0, String r1) {
            return DocumentsContract.buildDocumentUriUsingTree(r0, r1);
        }

        public static Uri buildTreeDocumentUri(String r0, String r1) {
            return DocumentsContract.buildTreeDocumentUri(r0, r1);
        }

        static Uri createDocument(ContentResolver r0, Uri r1, String r2, String r3) {
            return DocumentsContract.createDocument(r0, r1, r2, r3);
        }

        static String getTreeDocumentId(Uri r0) {
            return DocumentsContract.getTreeDocumentId(r0);
        }

        static Uri renameDocument(ContentResolver r0, Uri r1, String r2) {
            return DocumentsContract.renameDocument(r0, r1, r2);
        }
    }

    private static class DocumentsContractApi24Impl {
        private DocumentsContractApi24Impl() {
        }

        static boolean isTreeUri(Uri r0) {
            return DocumentsContract.isTreeUri(r0);
        }

        static boolean removeDocument(ContentResolver r0, Uri r1, Uri r2) {
            return DocumentsContract.removeDocument(r0, r1, r2);
        }
    }

    private DocumentsContractCompat() {
    }

    public static Uri buildChildDocumentsUri(String r2, String r3) {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return null;
    L5:
        return DocumentsContractApi21Impl.buildChildDocumentsUri(r2, r3);
    }

    public static Uri buildChildDocumentsUriUsingTree(Uri r2, String r3) {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return null;
    L5:
        return DocumentsContractApi21Impl.buildChildDocumentsUriUsingTree(r2, r3);
    }

    public static Uri buildDocumentUri(String r2, String r3) {
        if (Build.VERSION.SDK_INT >= 19) goto L5;
        return null;
    L5:
        return DocumentsContractApi19Impl.buildDocumentUri(r2, r3);
    }

    public static Uri buildDocumentUriUsingTree(Uri r2, String r3) {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return null;
    L5:
        return DocumentsContractApi21Impl.buildDocumentUriUsingTree(r2, r3);
    }

    public static Uri buildTreeDocumentUri(String r2, String r3) {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return null;
    L5:
        return DocumentsContractApi21Impl.buildTreeDocumentUri(r2, r3);
    }

    public static Uri createDocument(ContentResolver r2, Uri r3, String r4, String r5) {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return null;
    L5:
        return DocumentsContractApi21Impl.createDocument(r2, r3, r4, r5);
    }

    public static String getDocumentId(Uri r2) {
        if (Build.VERSION.SDK_INT >= 19) goto L5;
        return null;
    L5:
        return DocumentsContractApi19Impl.getDocumentId(r2);
    }

    public static String getTreeDocumentId(Uri r2) {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return null;
    L5:
        return DocumentsContractApi21Impl.getTreeDocumentId(r2);
    }

    public static boolean isDocumentUri(Context r2, Uri r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT >= 19) goto L5;
        return false;
    L5:
        return DocumentsContractApi19Impl.isDocumentUri(r4, r3);
    }

    public static boolean isTreeUri(Uri r3) {
        if (Build.VERSION.SDK_INT >= 21) goto L6;
        return false;
    L6:
        if (Build.VERSION.SDK_INT >= 24) goto L14;
        List<String> r4 = r3.getPathSegments();
        if (r4.size() >= 2) goto L10;
        return false;
    L10:
        if (PATH_TREE.equals(r4.get(0)) == false) goto L16;
        return true;
    L16:
        return false;
    L14:
        return DocumentsContractApi24Impl.isTreeUri(r3);
    }

    public static boolean removeDocument(ContentResolver r2, Uri r3, Uri r4) {
        if (Build.VERSION.SDK_INT < 24) goto L7;
        return DocumentsContractApi24Impl.removeDocument(r2, r3, r4);
    L7:
        if (Build.VERSION.SDK_INT >= 19) goto L9;
        return false;
    L9:
        return DocumentsContractApi19Impl.deleteDocument(r2, r3);
    }

    public static Uri renameDocument(ContentResolver r2, Uri r3, String r4) {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return null;
    L5:
        return DocumentsContractApi21Impl.renameDocument(r2, r3, r4);
    }
}
