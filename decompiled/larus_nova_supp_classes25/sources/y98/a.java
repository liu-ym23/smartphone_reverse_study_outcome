package y98;

import com.larus.api.CoordinateType;
import com.larus.api.LocationService;
import com.larus.common.apphost.AppHost;
import com.larus.dora.api.DoraEnableScope;
import com.larus.dora.api.IDoraService;
import com.larus.platform.model.LocateScene;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import h49.k;
import h49.m;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;
import t39.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a {
    public static final AtomicBoolean a = null;
    public static final b b = null;
    public static final C0096a c = null;
    public static final d d = null;
    public static final c e = null;
    public static final e f = null;

    /* JADX INFO: renamed from: y98.a$a, reason: collision with other inner class name */
    public static final class C0096a implements f09.a.b {
        public C0096a() {
        }

        public final void onAllActivityDestroyed() {
        }

        public final void onAppBackground() {
            AtomicBoolean r0 = a.a;
            if (a.c() == true) goto L7;
            FLogger.a.i("DoraGLocationClient", "onAppBackground, DoraG is disabled");
            return;
        L7:
            if (a.a() == true) goto L10;
            FLogger.a.i("DoraGLocationClient", "onAppBackground, canEnableLocationPoll is false stop poll");
            LocationService.a.t("enter_bg");
            return;
        L10:
            FLogger.a.i("DoraGLocationClient", "onAppBackground, canEnableLocationPoll is true");
        }

        public final void onAppForeground() {
            AtomicBoolean r0 = a.a;
            if (a.c() == true) goto L7;
            FLogger.a.i("DoraGLocationClient", "onAppForeground, DoraG is disabled");
            return;
        L7:
            if (a.a() == false) goto L9;
            FLogger.a.i("DoraGLocationClient", "onAppForeground, canEnableLocationPoll is true");
            LocationService.a.k(LocateScene.DORA_G_CONNECT, CoordinateType.WGS_84);
            return;
        L9:
            FLogger.a.i("DoraGLocationClient", "onAppForeground, canEnableLocationPoll is false start hot launch");
            LocationService.a.a(LocationService.a, LocateScene.HOT_LAUNCH, null, null, 30);
        }
    }

    public static final class b implements l48.c {
        public final boolean c() {
            AtomicBoolean r0 = a.a;
            return a.c();
        }

        public b() {
        }

        public final Boolean a(LocateScene r5, boolean r6) {
            Intrinsics.checkNotNullParameter(r5, "scene");
            if (r5.isDoraGStrategy() == true) goto L7;
            return null;
        L7:
            if (r5.canTriggerPoll(r6) == false) goto L12;
            if (r6 == true) goto L10;
        L11:
            boolean r0 = true;
        L13:
            FLogger.a.i("DoraGLocationClient", "canContinueAutoPoll scene:" + r5.name() + " isBackground:" + r6 + " canContinue:" + r0);
            return Boolean.valueOf(r0);
        L10:
            if (a.a() == true) goto L11;
        L12:
            r0 = false;
            goto L13
        }

        public final Boolean b(LocateScene r5, boolean r6) {
            Intrinsics.checkNotNullParameter(r5, "scene");
            if (r5.isDoraGStrategy() == true) goto L7;
            return null;
        L7:
            if (r5.canTriggerPoll(r6) == true) goto L9;
        L13:
            boolean r0 = false;
        L14:
            FLogger.a.i("DoraGLocationClient", "canStartAutoPoll scene:" + r5.name() + " isBackground:" + r6 + " canStart:" + r0);
            return Boolean.valueOf(r0);
        L9:
            if (r5.isDoraGRadicalStrategy() == true) goto L11;
        L12:
            r0 = true;
            goto L14
        L11:
            if (a.a() == false) goto L13;
            goto L12
        }
    }

    public static final class c implements n {
        public c() {
        }

        public final void e(int r4, int r5, String r6, String r7) {
            Intrinsics.checkNotNullParameter(r6, "productName");
            if (a.a.get() == true) goto L5;
            return;
        L5:
            FLogger.a.i("DoraGLocationClient", "onDoraLinkChanged state:" + r4 + " productId:" + r5 + " productName:" + r6 + " fwVersion:" + r7);
            if (r4 != 0) goto L8;
            a.b("dora_link_disconnected");
            return;
        L8:
            if (r4 != 2) goto L14;
            LocationService.a.a(LocationService.a, LocateScene.DORA_G_CONNECT, null, null, 30);
            return;
        }
    }

    public static final class d implements k {
        public d() {
        }

        public final void a(int r1) {
        }

        public final void onStateChange(int r4) {
            if (a.a.get() == true) goto L6;
            return;
        L6:
            if (r4 == 2) goto L8;
            return;
        L8:
            AtomicBoolean r5 = a.a;
            if (a.c() == false) goto L11;
        L13:
            LocationService.a.a(LocationService.a, LocateScene.VUI_AWAKE, null, null, 30);
            return;
        L11:
            if (AppHost.a.a().isAppBackground() == true) goto L13;
        }
    }

    public static final class e implements m {
        public e() {
        }

        public final void a(boolean r4, boolean r5) {
            if (a.a.get() == true) goto L5;
            return;
        L5:
            FLogger.a.i("DoraGLocationClient", "onWearStateChanged leftOn:" + r4 + " rightOn:" + r5);
            if (r4 == true) goto L10;
            if (r5 == true) goto L10;
            a.b("dora_unwear");
            return;
        L10:
            LocationService.a.a(LocationService.a, LocateScene.DORA_G_WEAR, null, null, 30);
        }
    }

    public a() {
    }

    static {
        a = new AtomicBoolean(false);
        b = new b();
        c = new C0096a();
        d = new d();
        e = new c();
        f = new e();
    }

    public static final boolean a() {
        IDoraService r0 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.B0() != true) goto L7;
        return true;
    }

    public static boolean c() {
        IDoraService r0 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.T0(DoraEnableScope.G_SERIES) != true) goto L7;
        return true;
    }

    public static final void b(String r3) {
        FLogger.a.i("DoraGLocationClient", "stopDoraGAutoPoll reason:".concat(r3));
        LocationService.a.t(r3);
    }
}
