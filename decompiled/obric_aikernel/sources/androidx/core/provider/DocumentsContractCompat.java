package androidx.core.provider;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.provider.DocumentsContract;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class DocumentsContractCompat {
    private static final String PATH_TREE = "tree";

    public static final class DocumentCompat {
        public static final int FLAG_VIRTUAL_DOCUMENT = 512;

        private DocumentCompat() {
        }
    }

    @RequiresApi(19)
    private static class DocumentsContractApi19Impl {
        private DocumentsContractApi19Impl() {
        }

        @DoNotInline
        public static Uri buildDocumentUri(String r10, String r11) {
            return DocumentsContract.buildDocumentUri(r10, r11);
        }

        @DoNotInline
        static boolean deleteDocument(ContentResolver r10, Uri r11) {
            return DocumentsContract.deleteDocument(r10, r11);
        }

        @DoNotInline
        static String getDocumentId(Uri r10) {
            return DocumentsContract.getDocumentId(r10);
        }

        @DoNotInline
        static boolean isDocumentUri(Context r10, @Nullable Uri r11) {
            return DocumentsContract.isDocumentUri(r10, r11);
        }
    }

    @RequiresApi(21)
    private static class DocumentsContractApi21Impl {
        private DocumentsContractApi21Impl() {
        }

        @DoNotInline
        static Uri buildChildDocumentsUri(String r10, String r11) {
            return DocumentsContract.buildChildDocumentsUri(r10, r11);
        }

        @DoNotInline
        static Uri buildChildDocumentsUriUsingTree(Uri r10, String r11) {
            return DocumentsContract.buildChildDocumentsUriUsingTree(r10, r11);
        }

        @DoNotInline
        static Uri buildDocumentUriUsingTree(Uri r10, String r11) {
            return DocumentsContract.buildDocumentUriUsingTree(r10, r11);
        }

        @DoNotInline
        public static Uri buildTreeDocumentUri(String r10, String r11) {
            return DocumentsContract.buildTreeDocumentUri(r10, r11);
        }

        @DoNotInline
        static Uri createDocument(ContentResolver r10, Uri r11, String r12, String r13) {
            return DocumentsContract.createDocument(r10, r11, r12, r13);
        }

        @DoNotInline
        static String getTreeDocumentId(Uri r10) {
            return DocumentsContract.getTreeDocumentId(r10);
        }

        @DoNotInline
        static Uri renameDocument(@NonNull ContentResolver r10, @NonNull Uri r11, @NonNull String r12) {
            return DocumentsContract.renameDocument(r10, r11, r12);
        }
    }

    @RequiresApi(24)
    private static class DocumentsContractApi24Impl {
        private DocumentsContractApi24Impl() {
        }

        @DoNotInline
        static boolean isTreeUri(@NonNull Uri r10) {
            return DocumentsContract.isTreeUri(r10);
        }

        @DoNotInline
        static boolean removeDocument(ContentResolver r10, Uri r11, Uri r12) {
            return DocumentsContract.removeDocument(r10, r11, r12);
        }
    }

    private DocumentsContractCompat() {
    }

    @Nullable
    public static Uri buildChildDocumentsUri(@NonNull String r10, @Nullable String r11) {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return null;
    L5:
        return DocumentsContractApi21Impl.buildChildDocumentsUri(r10, r11);
    }

    @Nullable
    public static Uri buildChildDocumentsUriUsingTree(@NonNull Uri r10, @NonNull String r11) {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return null;
    L5:
        return DocumentsContractApi21Impl.buildChildDocumentsUriUsingTree(r10, r11);
    }

    @Nullable
    public static Uri buildDocumentUri(@NonNull String r10, @NonNull String r11) {
        if (Build.VERSION.SDK_INT >= 19) goto L5;
        return null;
    L5:
        return DocumentsContractApi19Impl.buildDocumentUri(r10, r11);
    }

    @Nullable
    public static Uri buildDocumentUriUsingTree(@NonNull Uri r10, @NonNull String r11) {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return null;
    L5:
        return DocumentsContractApi21Impl.buildDocumentUriUsingTree(r10, r11);
    }

    @Nullable
    public static Uri buildTreeDocumentUri(@NonNull String r10, @NonNull String r11) {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return null;
    L5:
        return DocumentsContractApi21Impl.buildTreeDocumentUri(r10, r11);
    }

    @Nullable
    public static Uri createDocument(@NonNull ContentResolver r10, @NonNull Uri r11, @NonNull String r12, @NonNull String r13) {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return null;
    L5:
        return DocumentsContractApi21Impl.createDocument(r10, r11, r12, r13);
    }

    @Nullable
    public static String getDocumentId(@NonNull Uri r10) {
        if (Build.VERSION.SDK_INT >= 19) goto L5;
        return null;
    L5:
        return DocumentsContractApi19Impl.getDocumentId(r10);
    }

    @Nullable
    public static String getTreeDocumentId(@NonNull Uri r10) {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return null;
    L5:
        return DocumentsContractApi21Impl.getTreeDocumentId(r10);
    }

    public static boolean isDocumentUri(@NonNull Context r10, @Nullable Uri r11) {
        if (Build.VERSION.SDK_INT >= 19) goto L5;
        return false;
    L5:
        return DocumentsContractApi19Impl.isDocumentUri(r10, r11);
    }

    public static boolean isTreeUri(@NonNull Uri r10) {
        int r11 = Build.VERSION.SDK_INT;
        if (r11 >= 21) goto L6;
        return false;
    L6:
        if (r11 >= 24) goto L14;
        List<String> r12 = r10.getPathSegments();
        if (r12.size() >= 2) goto L10;
        return false;
    L10:
        if (PATH_TREE.equals(r12.get(0)) == false) goto L16;
        return true;
    L16:
        return false;
    L14:
        return DocumentsContractApi24Impl.isTreeUri(r10);
    }

    public static boolean removeDocument(@NonNull ContentResolver r10, @NonNull Uri r11, @NonNull Uri r12) {
        int r13 = Build.VERSION.SDK_INT;
        if (r13 < 24) goto L7;
        return DocumentsContractApi24Impl.removeDocument(r10, r11, r12);
    L7:
        if (r13 >= 19) goto L9;
        return false;
    L9:
        return DocumentsContractApi19Impl.deleteDocument(r10, r11);
    }

    @Nullable
    public static Uri renameDocument(@NonNull ContentResolver r10, @NonNull Uri r11, @NonNull String r12) {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return null;
    L5:
        return DocumentsContractApi21Impl.renameDocument(r10, r11, r12);
    }
}
