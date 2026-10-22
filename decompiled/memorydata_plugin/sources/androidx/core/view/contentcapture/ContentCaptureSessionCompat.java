package androidx.core.view.contentcapture;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStructure;
import android.view.autofill.AutofillId;
import android.view.contentcapture.ContentCaptureSession;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewStructureCompat;
import androidx.core.view.autofill.AutofillIdCompat;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class ContentCaptureSessionCompat {
    private static final String KEY_VIEW_TREE_APPEARED = "TREAT_AS_VIEW_TREE_APPEARED";
    private static final String KEY_VIEW_TREE_APPEARING = "TREAT_AS_VIEW_TREE_APPEARING";
    private final View mView;
    private final Object mWrappedObj;

    private static class Api23Impl {
        private Api23Impl() {
        }

        static Bundle getExtras(ViewStructure r0) {
            return r0.getExtras();
        }
    }

    private static class Api29Impl {
        private Api29Impl() {
        }

        static AutofillId newAutofillId(ContentCaptureSession r0, AutofillId r1, long r2) {
            return r0.newAutofillId(r1, r2);
        }

        static ViewStructure newViewStructure(ContentCaptureSession r0, View r1) {
            return r0.newViewStructure(r1);
        }

        static ViewStructure newVirtualViewStructure(ContentCaptureSession r0, AutofillId r1, long r2) {
            return r0.newVirtualViewStructure(r1, r2);
        }

        static void notifyViewAppeared(ContentCaptureSession r0, ViewStructure r1) {
            r0.notifyViewAppeared(r1);
        }

        public static void notifyViewTextChanged(ContentCaptureSession r2, AutofillId r3, CharSequence r4) {
            r2.notifyViewTextChanged(r3, (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.memorydata.plugin"));
        }

        static void notifyViewsDisappeared(ContentCaptureSession r0, AutofillId r1, long[] r2) {
            r0.notifyViewsDisappeared(r1, r2);
        }
    }

    private static class Api34Impl {
        private Api34Impl() {
        }

        static void notifyViewsAppeared(ContentCaptureSession r2, List<ViewStructure> r3) {
            r2.notifyViewsAppeared((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
        }
    }

    private ContentCaptureSessionCompat(ContentCaptureSession r1, View r2) {
        this.mWrappedObj = r1;
        this.mView = r2;
    }

    public static ContentCaptureSessionCompat toContentCaptureSessionCompat(ContentCaptureSession r1, View r2) {
        return new ContentCaptureSessionCompat(r1, r2);
    }

    public AutofillId newAutofillId(long r4) {
        if (Build.VERSION.SDK_INT >= 29) goto L5;
        return null;
    L5:
        return Api29Impl.newAutofillId((ContentCaptureSession) ZeusTransformUtils.preCheckCast(this.mWrappedObj, ContentCaptureSession.class, "com.obric.memorydata.plugin"), ((AutofillIdCompat) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(ViewCompat.getAutofillId(this.mView)), AutofillIdCompat.class, "com.obric.memorydata.plugin")).toAutofillId(), r4);
    }

    public ViewStructureCompat newVirtualViewStructure(AutofillId r3, long r4) {
        if (Build.VERSION.SDK_INT >= 29) goto L5;
        return null;
    L5:
        return ViewStructureCompat.toViewStructureCompat(Api29Impl.newVirtualViewStructure((ContentCaptureSession) ZeusTransformUtils.preCheckCast(this.mWrappedObj, ContentCaptureSession.class, "com.obric.memorydata.plugin"), r3, r4));
    }

    public void notifyViewTextChanged(AutofillId r4, CharSequence r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r5, CharSequence.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 29) goto L6;
        Api29Impl.notifyViewTextChanged((ContentCaptureSession) ZeusTransformUtils.preCheckCast(this.mWrappedObj, ContentCaptureSession.class, "com.obric.memorydata.plugin"), r4, r6);
        return;
    }

    public void notifyViewsAppeared(List<ViewStructure> r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 34) goto L6;
        Api34Impl.notifyViewsAppeared((ContentCaptureSession) ZeusTransformUtils.preCheckCast(this.mWrappedObj, ContentCaptureSession.class, "com.obric.memorydata.plugin"), r8);
        return;
    L6:
        if (Build.VERSION.SDK_INT < 29) goto L15;
        ViewStructure r0 = Api29Impl.newViewStructure((ContentCaptureSession) ZeusTransformUtils.preCheckCast(this.mWrappedObj, ContentCaptureSession.class, "com.obric.memorydata.plugin"), this.mView);
        Api23Impl.getExtras(r0).putBoolean(KEY_VIEW_TREE_APPEARING, true);
        Api29Impl.notifyViewAppeared((ContentCaptureSession) ZeusTransformUtils.preCheckCast(this.mWrappedObj, ContentCaptureSession.class, "com.obric.memorydata.plugin"), r0);
        int r1 = 0;
    L9:
        if (r1 >= r8.size()) goto L11;
        Api29Impl.notifyViewAppeared((ContentCaptureSession) ZeusTransformUtils.preCheckCast(this.mWrappedObj, ContentCaptureSession.class, "com.obric.memorydata.plugin"), (ViewStructure) ZeusTransformUtils.preCheckCast(r8.get(r1), ViewStructure.class, "com.obric.memorydata.plugin"));
        r1 = r1 + 1;
        goto L9
    L11:
        ViewStructure r9 = Api29Impl.newViewStructure((ContentCaptureSession) ZeusTransformUtils.preCheckCast(this.mWrappedObj, ContentCaptureSession.class, "com.obric.memorydata.plugin"), this.mView);
        Api23Impl.getExtras(r9).putBoolean(KEY_VIEW_TREE_APPEARED, true);
        Api29Impl.notifyViewAppeared((ContentCaptureSession) ZeusTransformUtils.preCheckCast(this.mWrappedObj, ContentCaptureSession.class, "com.obric.memorydata.plugin"), r9);
        return;
    }

    public void notifyViewsDisappeared(long[] r6) {
        if (Build.VERSION.SDK_INT < 34) goto L6;
        Api29Impl.notifyViewsDisappeared((ContentCaptureSession) ZeusTransformUtils.preCheckCast(this.mWrappedObj, ContentCaptureSession.class, "com.obric.memorydata.plugin"), ((AutofillIdCompat) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(ViewCompat.getAutofillId(this.mView)), AutofillIdCompat.class, "com.obric.memorydata.plugin")).toAutofillId(), r6);
        return;
    L6:
        if (Build.VERSION.SDK_INT < 29) goto L10;
        ViewStructure r0 = Api29Impl.newViewStructure((ContentCaptureSession) ZeusTransformUtils.preCheckCast(this.mWrappedObj, ContentCaptureSession.class, "com.obric.memorydata.plugin"), this.mView);
        Api23Impl.getExtras(r0).putBoolean(KEY_VIEW_TREE_APPEARING, true);
        Api29Impl.notifyViewAppeared((ContentCaptureSession) ZeusTransformUtils.preCheckCast(this.mWrappedObj, ContentCaptureSession.class, "com.obric.memorydata.plugin"), r0);
        Api29Impl.notifyViewsDisappeared((ContentCaptureSession) ZeusTransformUtils.preCheckCast(this.mWrappedObj, ContentCaptureSession.class, "com.obric.memorydata.plugin"), ((AutofillIdCompat) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(ViewCompat.getAutofillId(this.mView)), AutofillIdCompat.class, "com.obric.memorydata.plugin")).toAutofillId(), r6);
        ViewStructure r7 = Api29Impl.newViewStructure((ContentCaptureSession) ZeusTransformUtils.preCheckCast(this.mWrappedObj, ContentCaptureSession.class, "com.obric.memorydata.plugin"), this.mView);
        Api23Impl.getExtras(r7).putBoolean(KEY_VIEW_TREE_APPEARED, true);
        Api29Impl.notifyViewAppeared((ContentCaptureSession) ZeusTransformUtils.preCheckCast(this.mWrappedObj, ContentCaptureSession.class, "com.obric.memorydata.plugin"), r7);
        return;
    }

    public ContentCaptureSession toContentCaptureSession() {
        return (ContentCaptureSession) ZeusTransformUtils.preCheckCast(this.mWrappedObj, ContentCaptureSession.class, "com.obric.memorydata.plugin");
    }
}
