package pa8;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.supervisor.token.Token;
import com.larus.office.base.location.FlowShowLocationFragment;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.integrator.ccm.dependency.di.a1;
import com.ss.android.lark.integrator.ccm.dependency.di.b1;
import com.ss.android.lark.integrator.ccm.dependency.di.z0;
import com.ss.android.lark.location.dto.LarkLocation;
import com.ss.android.lark.location.dto.POIConfig;
import com.ss.android.lark.location.dto.Scene;
import com.ss.android.lark.location.listener.LocationRequestOption;
import ew4.a0;
import ew4.o;
import ew4.p;
import ew4.q;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class g implements a0 {
    public final Handler a;

    public static final class a {
    }

    static {
    }

    public g() {
        this.a = new Handler(Looper.getMainLooper());
    }

    public static POIConfig X0(FragmentActivity r5) {
        POIConfig r0 = new POIConfig();
        int r1 = r5.getResources().getIdentifier("Bitable_Common_ButtonSave", "string", r5.getPackageName());
        if (r1 == 0) goto L5;
        String r6 = r5.getString(r1);
    L6:
        if (r6 == null) goto L8;
        r0.setActionText(r6);
    L8:
        r0.setSnapshot(false);
        r0.setSelfDefine(false);
        return r0;
    L5:
        FLogger.a.w("FlowLocationHostService", "Bitable save text resource not found");
        r6 = null;
        goto L6
    }

    public static boolean Z1(q r9) {
        double r0 = r9.c;
        if ((-90.0d) <= r0) goto L5;
    L7:
        boolean r3 = false;
    L8:
        if (r3 == false) goto L26;
        double r4 = r9.d;
        if ((-180.0d) <= r4) goto L12;
    L14:
        boolean r5 = false;
    L15:
        if (r5 == true) goto L17;
        return false;
    L17:
        if (Double.isNaN(r0) == false) goto L19;
        return false;
    L19:
        if (Double.isNaN(r9.d) == false) goto L21;
        return false;
    L21:
        if (Double.isInfinite(r9.c) == false) goto L23;
        return false;
    L23:
        if (Double.isInfinite(r9.d) == true) goto L31;
        return true;
    L31:
        return false;
    L12:
        if (r4 > 180.0d) goto L14;
        r5 = true;
        goto L15
    L26:
        return false;
    L5:
        if (r0 > 90.0d) goto L7;
        r3 = true;
        goto L8
    }

    public static o b2(LarkLocation r15) {
        double r1 = r15.getLatitude();
        double r3 = r15.getLongitude();
        String r6 = r15.a;
        String r7 = r15.b;
        String r8 = r15.c;
        String r9 = r15.d;
        String r10 = r15.e;
        String r11 = r15.f;
        int r0 = r15.g;
        if (r0 != 40100) goto L5;
        int r12 = 2;
    L10:
        return new o(r1, r3, null, r6, r7, r8, r9, r10, r11, r12, r15.i);
    L5:
        if (r0 == 40400) goto L7;
        r12 = 0;
        goto L10
    L7:
        r12 = 3;
        goto L10
    }

    public final void a2(final Function0<Unit> r3) {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
        r3.invoke();
        return;
    L5:
        this.a.post(new f(r3));
    }

    public final void I(Activity r5, final String r6, final z0.a r7) {
        Intrinsics.checkNotNullParameter(r6, "sceneToken");
        Intrinsics.checkNotNullParameter(r7, "callback");
        FLogger r0 = FLogger.a;
        r0.i("FlowLocationHostService", "selectMapLocation, sceneToken=".concat(r6));
        if ((r5 instanceof FragmentActivity) == false) goto L5;
        final FragmentActivity r8 = (FragmentActivity) r5;
    L6:
        if (r8 != null) goto L9;
        r0.w("FlowLocationHostService", "selectMapLocation skipped, activity is not FragmentActivity");
        r7.a(null);
        return;
    L9:
        a2(new c(this, r8, r7, r6));
        return;
    L5:
        r8 = null;
        goto L6
    }

    public final Fragment U1(FragmentActivity r4, String r5, a1 r6) {
        Intrinsics.checkNotNullParameter(r5, "sceneToken");
        Intrinsics.checkNotNullParameter(r6, "callback");
        FLogger.a.i("FlowLocationHostService", "selectMapLocationFragment, sceneToken=".concat(r5));
        if (r4 != null) goto L7;
        return null;
    L7:
        return fqb.a.a(X0(r4), new Token(r5), Scene.Base.INSTANCE, new h(r6, this), true);
    }

    public final Fragment V1(FragmentActivity r8, String r9, q r10) {
        Intrinsics.checkNotNullParameter(r9, "sceneToken");
        Intrinsics.checkNotNullParameter(r10, "params");
        FLogger.a.i("FlowLocationHostService", "getShowLocationFragment, sceneToken=".concat(r9));
        if (r8 != null) goto L5;
        return null;
    L5:
        if (Z1(r10) == false) goto L11;
        int r11 = FlowShowLocationFragment.e;
        return FlowShowLocationFragment.a.a(r9, r10.a, r10.b, r10.c, r10.d);
    L11:
        return null;
    }

    public final void w1(Context r3, String r4, p r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "sceneToken");
        Intrinsics.checkNotNullParameter(r5, "callback");
        FLogger.a.i("FlowLocationHostService", "getLocation, sceneToken=".concat(r4));
        new um9.a();
        final z0.c r6 = (z0.c) r5;
        um9.a.a(new Token(r4), Scene.Base.INSTANCE, new b(r6, this));
    }

    public final void x1(Activity r4, final String r5, final q r6) {
        Intrinsics.checkNotNullParameter(r5, "sceneToken");
        Intrinsics.checkNotNullParameter(r6, "params");
        FLogger r0 = FLogger.a;
        r0.i("FlowLocationHostService", "showLocation, sceneToken=".concat(r5));
        if ((r4 instanceof FragmentActivity) == false) goto L5;
        final FragmentActivity r7 = (FragmentActivity) r4;
    L6:
        if (r7 != null) goto L10;
        r0.w("FlowLocationHostService", "showLocation skipped, activity is not FragmentActivity");
        return;
    L10:
        if (Z1(r6) == true) goto L13;
        r0.w("FlowLocationHostService", "showLocation skipped, invalid coordinate");
        return;
    L13:
        a2(new pa8.a(this, r7, r5, r6));
        return;
    L5:
        r7 = null;
        goto L6
    }

    public final void J1(Context r9, double r10, double r12, final z0.b r14) {
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r14, "callback");
        FLogger.a.i("FlowLocationHostService", "getAddressFromLocation");
        new um9.f();
        Scene.Base r1 = Scene.Base.INSTANCE;
        com.ss.android.lark.location.service.h.a r7 = new e(r14, this);
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r1, "scene");
        Intrinsics.checkNotNullParameter(r7, "listener");
        um9.f.a(r9, r10, r12, r7);
    }

    public final void b0(Context r3, String r4, String r5, final b1 r6) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "sceneToken");
        Intrinsics.checkNotNullParameter(r5, "accuracy");
        Intrinsics.checkNotNullParameter(r6, "callback");
        FLogger.a.i("FlowLocationHostService", "getLocationWithOption, sceneToken=" + r4 + ", accuracy=" + r5);
        new um9.a();
        Token r7 = new Token(r4);
        Scene.Base r8 = Scene.Base.INSTANCE;
        dqb.c r9 = new d(r6, this);
        LarkLocation.CoordinateSystem r10 = LarkLocation.CoordinateSystem.DEFAULT;
        LocationRequestOption.LocationPriority r11 = LocationRequestOption.LocationPriority.PRIORITY_HIGH_ACCURACY;
        Intrinsics.checkNotNullParameter(r7, "token");
        Intrinsics.checkNotNullParameter(r8, "scene");
        um9.a.a(r7, r8, r9);
    }
}
