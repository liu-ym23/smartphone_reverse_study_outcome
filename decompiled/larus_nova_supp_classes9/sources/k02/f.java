package k02;

import ca0.h;
import ca0.i;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.plugin_api.LivePluginSPIManager;
import com.bytedance.bdlocation.BuildConfig;
import fr2.i0;
import fr2.p;
import fr2.w1;
import fr2.y1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import or2.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f implements i {
    public static final /* synthetic */ int e = 0;
    public final k02.a a;
    public final c b;
    public final Set<String> c;
    public final Set<String> d;

    public static final class a {
    }

    public static final class b implements js0.b {
        public final /* synthetic */ f a;
        public final /* synthetic */ vc0.a b;

        public final void onSuccess(String r3) {
            Intrinsics.checkNotNullParameter(r3, "track");
            k02.a r4 = this.a.a;
            p r0 = i0.a(this.b);
            Intrinsics.checkNotNull(r0);
            r4.getClass();
            Intrinsics.checkNotNullParameter(r0, "livecore");
            r4.a = r0;
        }

        public b(f r1, vc0.a r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
    }

    public final boolean d() {
        Intrinsics.checkNotNullParameter(BuildConfig.FLAVOR, "exculdeScene");
        Iterator<T> r0 = this.c.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Object r2 = r0.next();
        if ((!Intrinsics.areEqual((String) r2, BuildConfig.FLAVOR)) == false) goto L4;
    L9:
        if (r2 != null) goto L16;
        return false;
    L16:
        return true;
    L8:
        r2 = null;
        goto L9
    }

    public final boolean f() {
        Intrinsics.checkNotNullParameter(BuildConfig.FLAVOR, "scene");
        return this.c.contains(BuildConfig.FLAVOR);
    }

    public f() {
        this.a = new k02.a();
        this.b = new c();
        this.c = new LinkedHashSet();
        this.d = new LinkedHashSet();
    }

    public final void e(vc0.a r3) {
        Intrinsics.checkNotNullParameter(r3, "livecore");
        LivePluginSPIManager.e.getClass();
        LivePluginSPIManager.a().addOnSuccess(new b(this, r3)).syncCallbackIfReady(true).callbackOnMainThread().requireByUser("GiftRenderFilterWrapper");
    }

    public final void g(boolean r3) {
        if (r3 == false) goto L20;
        k02.a r4 = this.a;
        if (r4.b(false) == true) goto L7;
    L31:
        this.c.clear();
        this.d.clear();
        return;
    L7:
        if (r4.b == false) goto L31;
        p r1 = r4.a;
        if (r1 == null) goto L14;
        w1 r2 = r1.E();
        if (r2 == null) goto L14;
        r2.m(false);
    L14:
        p r5 = r4.a;
        if (r5 == null) goto L19;
        w1 r6 = r5.E();
        if (r6 == null) goto L19;
        r6.release();
    L19:
        r4.b = false;
        r4.a = null;
        goto L31
    L20:
        c r7 = this.b;
        if (r7.a == false) goto L31;
        if (c.b() == false) goto L31;
        or2.e r8 = vh6.c.b(or2.e.class);
        if (r8 == null) goto L30;
        j r9 = r8.getCurrentClient();
        if (r9 == null) goto L30;
        r9.g();
    L30:
        r7.a = false;
        goto L31
    }

    public final void h(boolean r6) {
        k02.a r0 = this.a;
        p r1 = r0.a;
        if (r1 == null) goto L5;
        w1 r2 = r1.E();
    L7:
        if (r2 == null) goto L13;
        int r3 = x8.a.a;
        x8.a.d("zsben", "setEffectEnable enable:" + r6, false);
        p r4 = r0.a;
        if (r4 == null) goto L15;
        w1 r5 = r4.E();
        if (r5 == null) goto L16;
        r5.e(r6);
        return;
    L16:
        return;
    L15:
        return;
    L13:
        x8.a.b("zsben", "livecore?.renderFilter is null", false);
        return;
    L5:
        r2 = null;
        goto L7
    }

    public final boolean i(boolean r2) {
        if (r2 == false) goto L11;
        k02.a r3 = this.a;
        if (r3.b(true) == false) goto L11;
        p r4 = r3.a;
        if (r4 == null) goto L11;
        w1 r5 = r4.E();
        if (r5 == null) goto L11;
        return r5.y0();
    L11:
        return false;
    }

    public final void j(String r4, boolean r5) {
        Intrinsics.checkNotNullParameter("LiveGrids", "key");
        Intrinsics.checkNotNullParameter(r4, "value");
        if (r5 == false) goto L14;
        k02.a r6 = this.a;
        r6.getClass();
        Intrinsics.checkNotNullParameter("LiveGrids", "key");
        Intrinsics.checkNotNullParameter(r4, "value");
        if (r6.b(true) == false) goto L30;
        p r7 = r6.a;
        if (r7 == null) goto L23;
        w1 r8 = r7.E();
        if (r8 == null) goto L24;
        y1 r9 = r8.j0();
        if (r9 == null) goto L25;
        r9.e0("LiveGrids", r4);
        return;
    L25:
        return;
    L24:
        return;
    L23:
        return;
    L30:
        return;
    L14:
        this.b.getClass();
        Intrinsics.checkNotNullParameter("LiveGrids", "key");
        Intrinsics.checkNotNullParameter(r4, "value");
        if (c.b() == true) goto L17;
        ALogger.i("zsben", "setRenderCacheStringValue error not init. isInit:" + c.b() + ", isEnable:" + c.a() + ", value:" + r4);
        return;
    L17:
        or2.e r10 = vh6.c.b(or2.e.class);
        if (r10 == null) goto L28;
        j r11 = r10.getCurrentClient();
        if (r11 == null) goto L29;
        r11.j(r4);
        return;
    L29:
        return;
    }

    public final void c(String[] r4, h r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r4, "nodes");
        Intrinsics.checkNotNullParameter(r5, "callback");
        if (r6 == false) goto L11;
        k02.a r7 = this.a;
        r7.getClass();
        Intrinsics.checkNotNullParameter(r4, "nodes");
        Intrinsics.checkNotNullParameter(r5, "callback");
        if (r7.b(true) == true) goto L7;
        r5.onResult(-1);
        return;
    L7:
        r4.toString();
        ca0.b r8 = k02.a.a();
        if (r8 == null) goto L10;
        r8.x(r4);
    L10:
        r5.onResult(0);
        return;
    L11:
        this.b.getClass();
        Intrinsics.checkNotNullParameter(r4, "nodes");
        Intrinsics.checkNotNullParameter(r5, "callback");
        if (c.b() == true) goto L14;
    L21:
        r5.onResult(-1);
        return;
    L14:
        if (c.a() == false) goto L21;
        r4.toString();
        String[] r9 = c.c(r4);
        or2.e r10 = vh6.c.b(or2.e.class);
        if (r10 == null) goto L25;
        j r11 = r10.getCurrentClient();
        if (r11 == null) goto L26;
        r11.h(r9, new e(r5));
        return;
    L26:
        return;
    }

    public final void k(int r5, int r6, boolean r7) {
        if (r7 == false) goto L18;
        k02.a r8 = this.a;
        if (r8.b(true) == false) goto L24;
        p r0 = r8.a;
        if (r0 == null) goto L9;
        w1 r1 = r0.E();
    L11:
        if (r1 == null) goto L17;
        int r2 = x8.a.a;
        x8.a.d("zsben", "setMixOutput livecore:" + r8.a, false);
        p r9 = r8.a;
        if (r9 == null) goto L20;
        w1 r10 = r9.E();
        if (r10 == null) goto L21;
        r10.M3(r5, r6);
        return;
    L21:
        return;
    L20:
        return;
    L17:
        x8.a.b("zsben", "livecore?.renderFilter is null", false);
        return;
    L9:
        r1 = null;
        goto L11
    L24:
        return;
    L18:
        this.b.getClass();
    }

    public final void a(String[] r10, String[] r11, h r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r10, "nodes");
        Intrinsics.checkNotNullParameter(r11, "tags");
        Intrinsics.checkNotNullParameter(r13, "callback");
        if (r14 == false) goto L18;
        k02.a r15 = this.a;
        r15.getClass();
        Intrinsics.checkNotNullParameter(r10, "nodes");
        Intrinsics.checkNotNullParameter(r11, "tags");
        Intrinsics.checkNotNullParameter(r13, "callback");
        if (r15.b(true) == true) goto L7;
        r13.onResult(-1);
    L7:
        r10.toString();
        Intrinsics.checkNotNullParameter(r10, "nodes");
        ArrayList r16 = new ArrayList();
        int r0 = r10.length;
        int r2 = 0;
    L8:
        if (r2 >= r0) goto L10;
        r16.add(StringsKt.replace$default(r10[r2], "file://", BuildConfig.FLAVOR, false, 4, null));
        r2 = r2 + 1;
        goto L8
    L10:
        Object[] r17 = r16.toArray(new String[0]);
        if (r17 == null) goto L17;
        String[] r18 = (String[]) r17;
        ca0.b r19 = k02.a.a();
        if (r19 == null) goto L15;
        r19.d(r18, r11);
    L15:
        r13.onResult(0);
        return;
    L17:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L18:
        this.b.getClass();
        Intrinsics.checkNotNullParameter(r10, "nodes");
        Intrinsics.checkNotNullParameter(r11, "tags");
        Intrinsics.checkNotNullParameter(r13, "callback");
        if (c.b() == true) goto L21;
    L28:
        r13.onResult(-1);
        return;
    L21:
        if (c.a() == false) goto L28;
        r10.toString();
        String[] r110 = c.c(r10);
        or2.e r111 = vh6.c.b(or2.e.class);
        if (r111 == null) goto L32;
        j r112 = r111.getCurrentClient();
        if (r112 == null) goto L33;
        r112.a(r110, r11, new d(r13));
        return;
    L33:
        return;
    }

    public final void m(boolean r3, boolean r4, String r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r5, "scene");
        if (r3 == false) goto L5;
        this.d.add(r5);
    L10:
        if (r4 == false) goto L27;
        k02.a r7 = this.a;
        if (r7.b(true) == false) goto L31;
        String.valueOf(r3);
        p r8 = r7.a;
        if (r8 == null) goto L17;
        w1 r9 = r8.E();
    L19:
        if (r9 == null) goto L25;
        int r10 = x8.a.a;
        x8.a.d("zsben", "singleinput livecore:" + r7.a, false);
        p r11 = r7.a;
        if (r11 == null) goto L28;
        w1 r13 = r11.E();
        if (r13 == null) goto L29;
        r13.m(r3);
        return;
    L29:
        return;
    L28:
        return;
    L25:
        x8.a.b("zsben", "livecore?.renderFilter is null", false);
        return;
    L17:
        r9 = null;
        goto L19
    L31:
        return;
    L27:
        return;
    L5:
        if (r6 == false) goto L7;
        this.d.clear();
        goto L10
    L7:
        this.d.remove(r5);
        if ((!this.d.isEmpty()) == false) goto L10;
    }

    public final void b(int r2, int r3, int r4, String r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r5, "arg3");
        if (r6 == false) goto L10;
        k02.a r7 = this.a;
        r7.getClass();
        Intrinsics.checkNotNullParameter(r5, "arg3");
        if (r7.b(true) == false) goto L26;
        ca0.b r8 = k02.a.a();
        if (r8 == null) goto L21;
        r8.j(r2, r3, r4, r5);
        return;
    L21:
        return;
    L26:
        return;
    L10:
        this.b.getClass();
        Intrinsics.checkNotNullParameter(r5, "arg3");
        if (c.b() == true) goto L13;
        return;
    L13:
        if (c.a() == false) goto L27;
        or2.e r9 = vh6.c.b(or2.e.class);
        if (r9 == null) goto L24;
        j r10 = r9.getCurrentClient();
        if (r10 == null) goto L25;
        r10.sendMessage(r2, r3, r4, r5);
        return;
    L25:
        return;
    L24:
        return;
    }

    public final void l(boolean r4, ca0.f r5, h r6, boolean r7, String r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r6, "callback");
        Intrinsics.checkNotNullParameter(r8, "scene");
        if (r4 == false) goto L5;
        this.c.add(r8);
    L11:
        w1 r10 = null;
        if (r7 == false) goto L39;
        k02.a r11 = this.a;
        r11.getClass();
        Intrinsics.checkNotNullParameter(r6, "callback");
        if (r5 == null) goto L16;
        r11.getClass();
    L16:
        p r13 = r11.a;
        if (r13 == null) goto L19;
        r10 = r13.E();
    L19:
        if (r4 == true) goto L24;
        if (r11.b(true) == true) goto L24;
        r6.onResult(-1);
        return;
    L24:
        if (r11.b(true) == true) goto L36;
        ca0.b r14 = k02.a.a();
        if (r14 == null) goto L28;
        r14.h(new k02.b());
    L28:
        ca0.b r15 = k02.a.a();
        if (r15 == null) goto L31;
        r15.g();
    L31:
        r11.b = true;
        if (r10 == null) goto L34;
        r10.l(r4);
    L34:
        r6.onResult(0);
        return;
    L36:
        if (r10 == null) goto L38;
        r10.l(r4);
    L38:
        r6.onResult(0);
        return;
    L39:
        c r16 = this.b;
        r16.getClass();
        Intrinsics.checkNotNullParameter(r6, "callback");
        jy0.b.a("GiftPlayerRenderFilter", "setEnable, enable = " + r4 + ", listener = " + r5 + ", callback = " + r6);
        if (r5 == null) goto L42;
        r16.getClass();
    L42:
        boolean r17 = c.b();
        if (r4 == true) goto L46;
        if (r17 == true) goto L46;
        jy0.b.c("GiftPlayerRenderFilter", "setEnable fail because isInit == false and enable == false", null, 4);
        r6.onResult(-1);
        return;
    L46:
        if (r17 == true) goto L51;
        jy0.b.a("GiftPlayerRenderFilter", "isInit == false, begin setup");
        com.bytedance.android.livesdk.revenue.service.effect.c r18 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.effect.c.class);
        if (r18 == null) goto L50;
        r18.providerResourceFinder();
    L50:
        jy0.b.c("GiftPlayerRenderFilter", "setEnable fail because resourceFinder is null", null, 4);
        r6.onResult(-1);
        return;
    L51:
        jy0.b.a("GiftPlayerRenderFilter", "isInit == true, proceed");
        j r19 = vh6.c.b(or2.e.class).getCurrentClient();
        if (r19 != null) goto L54;
        jy0.b.c("GiftPlayerRenderFilter", "setEnable fail, currentClient is null", null, 4);
    L54:
        if (r19 == null) goto L56;
        r19.i(r4);
    L56:
        r6.onResult(0);
        return;
    L5:
        if (r9 == false) goto L7;
        this.c.clear();
    L10:
        this.d.clear();
        goto L11
    L7:
        this.c.remove(r8);
        if ((!this.c.isEmpty()) == false) goto L10;
    }
}
