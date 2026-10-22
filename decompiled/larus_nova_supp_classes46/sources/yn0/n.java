package yn0;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.livesdk.projectmode.ILiveSdkProjectModeService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class n implements l81.n {
    public static final n a = null;

    public n() {
    }

    static {
        a = new n();
    }

    public final Boolean isPerfToolsDebug() {
        ILiveSdkProjectModeService r0 = jc1.k.f(ILiveSdkProjectModeService.class);
        if (r0 != null) goto L7;
        return null;
    L7:
        return Boolean.valueOf(r0.isPerfToolsDebug());
    }

    public final void a(FragmentActivity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        ILiveSdkProjectModeService r0 = jc1.k.f(ILiveSdkProjectModeService.class);
        if (r0 == null) goto L6;
        r0.initAndShowPerfTools(r2);
        return;
    }
}
