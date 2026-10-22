package yf;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.ec.common.api.feedback.IECFeedbackService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements IECFeedbackService {
    public a() {
    }

    @Override // com.bytedance.android.ec.common.api.feedback.IECFeedbackService
    public final void registerScreenCapture(Context r1, Fragment r10) {
    }

    @Override // com.bytedance.android.ec.common.api.feedback.IECFeedbackService
    public final void registerScreenCaptureForMall(Context r1, LifecycleOwner r10, Fragment r11) {
        Intrinsics.checkNotNullParameter(r10, "lifecycleOwner");
    }
}
