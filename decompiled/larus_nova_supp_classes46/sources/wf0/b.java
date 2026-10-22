package wf0;

import com.bytedance.android.live.broadcast.api.IMiddlewareBroadcastService;
import com.bytedance.android.live.broadcast.api.model.t;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.linkcast.i;
import com.bytedance.android.live.liveinteract.model.LinkScreenCastType;
import com.bytedance.android.live.openplatform.api.IMiddlewareOpenPlatformAnchorService;
import com.bytedance.live.datacontext.m;
import kotlin.Pair;
import kotlin.math.MathKt;
import rj0.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b {

    public static final class a implements IMiddlewareOpenPlatformAnchorService.a {
        public a() {
        }
    }

    /* JADX INFO: renamed from: wf0.b$b, reason: collision with other inner class name */
    public static final class C0286b implements IMiddlewareOpenPlatformAnchorService.a {
        public C0286b() {
        }
    }

    public static final class c implements IMiddlewareOpenPlatformAnchorService.a {
        public c() {
        }
    }

    public static final Integer b() {
        IMiddlewareBroadcastService r0 = (IMiddlewareBroadcastService) va1.b.a.a.a(IMiddlewareBroadcastService.class);
        if (r0 != null) goto L7;
        return null;
    L7:
        return Integer.valueOf(r0.getCastingType());
    }

    public static final t.b c() {
        k.m2.getClass();
        k r0 = k.a.a();
        if (r0 == null) goto L7;
        t r1 = r0.Hk();
        if (r1 == null) goto L7;
        t.b r2 = r1.d;
    L8:
        if (r2 != null) goto L14;
        k r3 = k.a.a();
        if (r3 == null) goto L14;
        t r4 = r3.Hk();
        if (r4 == null) goto L14;
        r4.d = new t.b();
    L14:
        k r5 = k.a.a();
        if (r5 == null) goto L20;
        t r6 = r5.Hk();
        if (r6 != null) goto L19;
        return null;
    L19:
        return r6.d;
    L20:
        return null;
    L7:
        r2 = null;
        goto L8
    }

    public static final boolean f() {
        IInteractService r0 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isLinkCasting() != true) goto L7;
        return true;
    }

    public static final void a() {
        m r0 = com.bytedance.android.live.liveinteract.api.utils.m.d().n();
        if (r0 != null) goto L5;
        return;
    L5:
        if (((Boolean) r0.getValue()).booleanValue() != true) goto L12;
        m r1 = com.bytedance.android.live.liveinteract.api.utils.m.d().n();
        if (r1 == null) goto L9;
        r1.setValue(Boolean.FALSE);
    L9:
        IMiddlewareBroadcastService.b.b((IMiddlewareBroadcastService) va1.b.a.a.a(IMiddlewareBroadcastService.class));
        int r2 = i.a;
        i.a.c(LinkScreenCastType.CAST_TYPE_MINI_APP, false, "force_stop_cast", true);
        return;
    }

    public static final boolean e() {
        Integer r0 = je0.d.h();
        if (r0 != null) goto L6;
    L8:
        return false;
    L6:
        if (r0.intValue() != 7) goto L8;
        return true;
    }

    public static final void h() {
        if (f() == false) goto L14;
        Integer r0 = b();
        if (r0 != null) goto L8;
        return;
    L8:
        if (r0.intValue() != 2) goto L15;
        m r1 = com.bytedance.android.live.liveinteract.api.utils.m.d().n();
        if (r1 == null) goto L12;
        r1.setValue(Boolean.TRUE);
    L12:
        ((IMiddlewareOpenPlatformAnchorService) jc1.k.n(IMiddlewareOpenPlatformAnchorService.class)).pauseLinkCastWhenSceneSwitched(0, new C0286b());
        return;
    L15:
        return;
    }

    public static final void g(int r3) {
        m r0 = com.bytedance.android.live.liveinteract.api.utils.m.d().n();
        if (r0 == null) goto L21;
        boolean r1 = true;
        if (((Boolean) r0.getValue()).booleanValue() != true) goto L22;
        m r2 = com.bytedance.android.live.liveinteract.api.utils.m.d().n();
        if (r2 == null) goto L10;
        r2.setValue(Boolean.FALSE);
    L10:
        if (r3 != 12) goto L12;
    L18:
        if (r1 == false) goto L23;
        ((IMiddlewareOpenPlatformAnchorService) jc1.k.n(IMiddlewareOpenPlatformAnchorService.class)).resumeLinkCastWhenSceneSwitched(new a());
        return;
    L23:
        return;
    L12:
        if (r3 == 16) goto L18;
        if (r3 == 0) goto L18;
        if (r3 == 8) goto L18;
        r1 = false;
        goto L18
    L22:
        return;
    }

    public static final void i(int r2) {
        if (f() == false) goto L14;
        Integer r0 = b();
        if (r0 != null) goto L8;
        return;
    L8:
        if (r0.intValue() != 2) goto L15;
        m r1 = com.bytedance.android.live.liveinteract.api.utils.m.d().n();
        if (r1 == null) goto L12;
        r1.setValue(Boolean.TRUE);
    L12:
        ((IMiddlewareOpenPlatformAnchorService) jc1.k.n(IMiddlewareOpenPlatformAnchorService.class)).pauseLinkCastWhenSceneSwitched(r2, new c());
        return;
    L15:
        return;
    }

    public static final void d(int r1, boolean r2) {
        if (r2 == true) goto L4;
        return;
    L4:
        if (f() == false) goto L16;
        Integer r3 = b();
        if (r3 != null) goto L9;
        return;
    L9:
        if (r3.intValue() != 2) goto L17;
        if (r1 <= 0) goto L18;
        t.b r4 = j(r1, 2);
        k.m2.getClass();
        k r5 = k.a.a();
        if (r5 == null) goto L19;
        r5.kh(r4);
        return;
    L19:
        return;
    L18:
        return;
    L17:
        return;
    }

    public static final t.b j(int r7, int r8) {
        if (r8 != 1) goto L6;
        r7 = 6;
    L9:
        Pair r9 = new Pair(Double.valueOf(0.7638888888888888d), Double.valueOf(1.0d - ((((double) ((r7 - 1) + 1)) * 0.1171875d) + 0.0875d)));
        Double r10 = (Double) r9.getFirst();
        Double r11 = (Double) r9.getSecond();
        t.b r2 = c();
        if (r2 == null) goto L12;
        r2.a = MathKt.roundToInt(((double) s1.y()) * 0.20833333333333334d);
        r2.b = MathKt.roundToInt(((double) s1.w()) * 0.1171875d);
        r2.c = MathKt.roundToInt(r10.doubleValue() * ((double) s1.y()));
        r2.d = MathKt.roundToInt(r11.doubleValue() * ((double) s1.w()));
        return r2;
    L12:
        return null;
    L6:
        if (r8 != 2) goto L8;
        if (r7 != 1) goto L9;
    L8:
        r7 = 2;
        goto L9
    }
}
