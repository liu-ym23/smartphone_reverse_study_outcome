package androidx.core.provider;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.provider.DocumentsContract;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.io.FileNotFoundException;

/* JADX INFO: loaded from: classes.dex */
public final class DocumentsContractCompat {
    private static final String PATH_TREE = "tree";

    public static final class DocumentCompat {
        public static final int FLAG_VIRTUAL_DOCUMENT = 512;

        private DocumentCompat() {
        }
    }

    @RequiresApi(21)
    public static class DocumentsContractApi21Impl {
        private DocumentsContractApi21Impl() {
        }

        @DoNotInline
        public static Uri buildChildDocumentsUri(String r5, String r10) {
            return DocumentsContract.buildChildDocumentsUri(r5, r10);
        }

        @DoNotInline
        public static Uri buildChildDocumentsUriUsingTree(Uri r5, String r10) {
            return DocumentsContract.buildChildDocumentsUriUsingTree(r5, r10);
        }

        @DoNotInline
        public static Uri buildDocumentUriUsingTree(Uri r5, String r10) {
            return DocumentsContract.buildDocumentUriUsingTree(r5, r10);
        }

        @DoNotInline
        public static Uri buildTreeDocumentUri(String r5, String r10) {
            return DocumentsContract.buildTreeDocumentUri(r5, r10);
        }

        @DoNotInline
        public static Uri createDocument(ContentResolver r5, Uri r10, String r11, String r12) throws FileNotFoundException {
            return DocumentsContract.createDocument(r5, r10, r11, r12);
        }

        @DoNotInline
        public static String getTreeDocumentId(Uri r5) {
            return DocumentsContract.getTreeDocumentId(r5);
        }

        @DoNotInline
        public static Uri renameDocument(@NonNull ContentResolver r5, @NonNull Uri r10, @NonNull String r11) throws FileNotFoundException {
            return DocumentsContract.renameDocument(r5, r10, r11);
        }
    }

    @RequiresApi(24)
    public static class DocumentsContractApi24Impl {
        private DocumentsContractApi24Impl() {
        }

        @DoNotInline
        public static boolean isTreeUri(@NonNull Uri r5) {
            return DocumentsContract.isTreeUri(r5);
        }

        @DoNotInline
        public static boolean removeDocument(ContentResolver r5, Uri r10, Uri r11) throws FileNotFoundException {
            return DocumentsContract.removeDocument(r5, r10, r11);
        }
    }

    private DocumentsContractCompat() {
    }

    @Nullable
    public static Uri buildChildDocumentsUri(@NonNull String r5, @Nullable String r10) {
        return DocumentsContractApi21Impl.buildChildDocumentsUri(r5, r10);
    }

    @Nullable
    public static Uri buildChildDocumentsUriUsingTree(@NonNull Uri r5, @NonNull String r10) {
        return DocumentsContractApi21Impl.buildChildDocumentsUriUsingTree(r5, r10);
    }

    @Nullable
    public static Uri buildDocumentUri(@NonNull String r5, @NonNull String r10) {
        return DocumentsContract.buildDocumentUri(r5, r10);
    }

    @Nullable
    public static Uri buildDocumentUriUsingTree(@NonNull Uri r5, @NonNull String r10) {
        return DocumentsContractApi21Impl.buildDocumentUriUsingTree(r5, r10);
    }

    @Nullable
    public static Uri buildTreeDocumentUri(@NonNull String r5, @NonNull String r10) {
        return DocumentsContractApi21Impl.buildTreeDocumentUri(r5, r10);
    }

    @Nullable
    public static Uri createDocument(@NonNull ContentResolver r5, @NonNull Uri r10, @NonNull String r11, @NonNull String r12) throws FileNotFoundException {
        return DocumentsContractApi21Impl.createDocument(r5, r10, r11, r12);
    }

    @Nullable
    public static String getDocumentId(@NonNull Uri r5) {
        return DocumentsContract.getDocumentId(r5);
    }

    @Nullable
    public static String getTreeDocumentId(@NonNull Uri r5) {
        return DocumentsContractApi21Impl.getTreeDocumentId(r5);
    }

    public static boolean isDocumentUri(@NonNull Context r5, @Nullable Uri r10) {
        return DocumentsContract.isDocumentUri(r5, r10);
    }

    public static boolean isTreeUri(@NonNull Uri r5) {
        return DocumentsContractApi24Impl.isTreeUri(r5);
    }

    public static boolean removeDocument(@NonNull ContentResolver r5, @NonNull Uri r10, @NonNull Uri r11) throws FileNotFoundException {
        return DocumentsContractApi24Impl.removeDocument(r5, r10, r11);
    }

    @Nullable
    public static Uri renameDocument(@NonNull ContentResolver r5, @NonNull Uri r10, @NonNull String r11) throws FileNotFoundException {
        return DocumentsContractApi21Impl.renameDocument(r5, r10, r11);
    }
}
