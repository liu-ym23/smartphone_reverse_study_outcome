package androidx.core.view.contentcapture;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStructure;
import android.view.autofill.AutofillId;
import android.view.contentcapture.ContentCaptureSession;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewStructureCompat;
import androidx.core.view.autofill.AutofillIdCompat;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class ContentCaptureSessionCompat {
    private static final String KEY_VIEW_TREE_APPEARED = "TREAT_AS_VIEW_TREE_APPEARED";
    private static final String KEY_VIEW_TREE_APPEARING = "TREAT_AS_VIEW_TREE_APPEARING";
    private final View mView;
    private final Object mWrappedObj;

    @RequiresApi(23)
    public static class Api23Impl {
        private Api23Impl() {
        }

        @DoNotInline
        public static Bundle getExtras(ViewStructure r5) {
            return r5.getExtras();
        }
    }

    @RequiresApi(29)
    public static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        public static AutofillId newAutofillId(ContentCaptureSession r5, AutofillId r10, long r11) {
            return r5.newAutofillId(r10, r11);
        }

        @DoNotInline
        public static ViewStructure newViewStructure(ContentCaptureSession r5, View r10) {
            return r5.newViewStructure(r10);
        }

        @DoNotInline
        public static ViewStructure newVirtualViewStructure(ContentCaptureSession r5, AutofillId r10, long r11) {
            return r5.newVirtualViewStructure(r10, r11);
        }

        @DoNotInline
        public static void notifyViewAppeared(ContentCaptureSession r5, ViewStructure r10) {
            r5.notifyViewAppeared(r10);
        }

        @DoNotInline
        public static void notifyViewTextChanged(ContentCaptureSession r5, AutofillId r10, CharSequence r11) {
            r5.notifyViewTextChanged(r10, r11);
        }

        @DoNotInline
        public static void notifyViewsDisappeared(ContentCaptureSession r5, AutofillId r10, long[] r11) {
            r5.notifyViewsDisappeared(r10, r11);
        }
    }

    @RequiresApi(34)
    public static class Api34Impl {
        private Api34Impl() {
        }

        @DoNotInline
        public static void notifyViewsAppeared(ContentCaptureSession r5, List<ViewStructure> r10) {
            r5.notifyViewsAppeared(r10);
        }
    }

    @RequiresApi(29)
    private ContentCaptureSessionCompat(@NonNull ContentCaptureSession r5, @NonNull View r10) {
        this.mWrappedObj = r5;
        this.mView = r10;
    }

    @NonNull
    @RequiresApi(29)
    public static ContentCaptureSessionCompat toContentCaptureSessionCompat(@NonNull ContentCaptureSession r5, @NonNull View r10) {
        return new ContentCaptureSessionCompat(r5, r10);
    }

    @Nullable
    public AutofillId newAutofillId(long r5) {
        ContentCaptureSession r10 = (ContentCaptureSession) this.mWrappedObj;
        AutofillIdCompat r11 = ViewCompat.getAutofillId(this.mView);
        Objects.requireNonNull(r11);
        return Api29Impl.newAutofillId(r10, r11.toAutofillId(), r5);
    }

    @Nullable
    public ViewStructureCompat newVirtualViewStructure(@NonNull AutofillId r5, long r10) {
        return ViewStructureCompat.toViewStructureCompat(Api29Impl.newVirtualViewStructure((ContentCaptureSession) this.mWrappedObj, r5, r10));
    }

    public void notifyViewTextChanged(@NonNull AutofillId r5, @Nullable CharSequence r10) {
        Api29Impl.notifyViewTextChanged((ContentCaptureSession) this.mWrappedObj, r5, r10);
    }

    public void notifyViewsAppeared(@NonNull List<ViewStructure> r5) {
        if (Build.VERSION.SDK_INT < 34) goto L5;
        Api34Impl.notifyViewsAppeared((ContentCaptureSession) this.mWrappedObj, r5);
        return;
    L5:
        ViewStructure r10 = Api29Impl.newViewStructure((ContentCaptureSession) this.mWrappedObj, this.mView);
        Api23Impl.getExtras(r10).putBoolean(KEY_VIEW_TREE_APPEARING, true);
        Api29Impl.notifyViewAppeared((ContentCaptureSession) this.mWrappedObj, r10);
        int r11 = 0;
    L7:
        if (r11 >= r5.size()) goto L9;
        Api29Impl.notifyViewAppeared((ContentCaptureSession) this.mWrappedObj, r5.get(r11));
        r11 = r11 + 1;
        goto L7
    L9:
        ViewStructure r12 = Api29Impl.newViewStructure((ContentCaptureSession) this.mWrappedObj, this.mView);
        Api23Impl.getExtras(r12).putBoolean(KEY_VIEW_TREE_APPEARED, true);
        Api29Impl.notifyViewAppeared((ContentCaptureSession) this.mWrappedObj, r12);
    }

    public void notifyViewsDisappeared(@NonNull long[] r5) {
        if (Build.VERSION.SDK_INT < 34) goto L5;
        ContentCaptureSession r10 = (ContentCaptureSession) this.mWrappedObj;
        AutofillIdCompat r11 = ViewCompat.getAutofillId(this.mView);
        Objects.requireNonNull(r11);
        Api29Impl.notifyViewsDisappeared(r10, r11.toAutofillId(), r5);
        return;
    L5:
        ViewStructure r12 = Api29Impl.newViewStructure((ContentCaptureSession) this.mWrappedObj, this.mView);
        Api23Impl.getExtras(r12).putBoolean(KEY_VIEW_TREE_APPEARING, true);
        Api29Impl.notifyViewAppeared((ContentCaptureSession) this.mWrappedObj, r12);
        ContentCaptureSession r13 = (ContentCaptureSession) this.mWrappedObj;
        AutofillIdCompat r14 = ViewCompat.getAutofillId(this.mView);
        Objects.requireNonNull(r14);
        Api29Impl.notifyViewsDisappeared(r13, r14.toAutofillId(), r5);
        ViewStructure r15 = Api29Impl.newViewStructure((ContentCaptureSession) this.mWrappedObj, this.mView);
        Api23Impl.getExtras(r15).putBoolean(KEY_VIEW_TREE_APPEARED, true);
        Api29Impl.notifyViewAppeared((ContentCaptureSession) this.mWrappedObj, r15);
    }

    @NonNull
    @RequiresApi(29)
    public ContentCaptureSession toContentCaptureSession() {
        return (ContentCaptureSession) this.mWrappedObj;
    }
}
