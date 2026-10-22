package pa8;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.FragmentActivity;
import com.larus.camera.api.IFlowCamera;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.integrator.ccm.dependency.di.s0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import ew4.c0;
import ew4.d0;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class n implements c0 {
    public final Handler a;

    public static final class a {
    }

    static {
    }

    public n() {
        this.a = new Handler(Looper.getMainLooper());
    }

    public final boolean Z1(final Function0<Unit> r3) {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L6;
        r3.invoke();
        return true;
    L6:
        return this.a.post(new l(r3));
    }

    public final void X0(final d0 r2, final String r3) {
        if (Z1(new m(this, r2, r3)) == true) goto L6;
        FLogger.a.e("FlowQRCodeHostService", "dispatchResult failed, post main thread failed");
        return;
    }

    public final void I0(Context r17, int[] r18, final s0 r19) {
        Intrinsics.checkNotNullParameter(r17, "context");
        Intrinsics.checkNotNullParameter(r18, "formats");
        Intrinsics.checkNotNullParameter(r19, "handler");
        FLogger.a.i("FlowQRCodeHostService", "startScanQRCodeActivity, formats=" + ArraysKt.joinToString$default(r18, null, null, null, 0, null, null, 63, null));
        boolean r3 = false;
        if (r18.length != 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == true) goto L20;
        int r4 = r18.length;
        int r5 = 0;
    L8:
        if (r5 >= r4) goto L18;
        int r6 = r18[r5];
        if (r6 == 0) goto L14;
        if (r6 == 1) goto L14;
        boolean r7 = false;
    L15:
        if (r7 == true) goto L16;
        r5 = r5 + 1;
        goto L8
    L16:
        boolean r8 = true;
    L19:
        if (r8 == true) goto L20;
    L22:
        if (r3 == true) goto L26;
        FLogger.a.w("FlowQRCodeHostService", "startScanQRCodeActivity skipped, unsupported formats=" + ArraysKt.joinToString$default(r18, null, null, null, 0, null, null, 63, null));
        X0(r19, null);
        return;
    L26:
        if ((r17 instanceof FragmentActivity) == false) goto L28;
        final FragmentActivity r1 = (FragmentActivity) r17;
    L29:
        if (r1 != null) goto L34;
        Activity r9 = AppHost.a.a().getCurrentActivity();
        if ((r9 instanceof FragmentActivity) == false) goto L33;
        r1 = (FragmentActivity) r9;
        goto L34
    L33:
        r1 = null;
    L34:
        if (r1 != null) goto L37;
        FLogger.a.w("FlowQRCodeHostService", "startScanQRCodeActivity skipped, activity is null");
        X0(r19, null);
        return;
    L37:
        final IFlowCamera r10 = (IFlowCamera) ServiceManager.get().getService(IFlowCamera.class);
        if (r10 != null) goto L42;
        FLogger.a.w("FlowQRCodeHostService", "startScanQRCodeActivity skipped, camera service is null");
        X0(r19, null);
        return;
    L42:
        if (r10.s(true, new i(this, r19), new j(this, r19)) == true) goto L46;
        FLogger.a.w("FlowQRCodeHostService", "startScanQRCodeActivity skipped, scanCode is running");
        X0(r19, null);
        return;
    L46:
        if (Z1(new k(r1, r10, this)) == true) goto L51;
        FLogger.a.w("FlowQRCodeHostService", "startScanQRCodeActivity failed, post main thread failed");
        r10.h("scanCode post to main thread failed");
        return;
    L51:
        return;
    L28:
        r1 = null;
    L14:
        r7 = true;
        goto L15
    L18:
        r8 = false;
    L20:
        r3 = true;
        goto L22
    L5:
        r2 = false;
        goto L6
    }
}
