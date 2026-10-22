package nh;

import ai.p;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import com.bytedance.pia.core.api.bridge.PiaMethod$Scope;
import com.bytedance.pia.core.tracing.EventName;
import com.bytedance.pia.core.utils.j;
import com.bytedance.pia.core.utils.m;
import com.google.common.reflect.w;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends a {
    public static Context E;
    public final AtomicBoolean A;
    public final AtomicBoolean B;
    public final AtomicBoolean C;
    public volatile a D;
    public final com.bytedance.pia.core.setting.a d;
    public final String e;
    public final String f;
    public final Uri g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f20237h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final gh.a f20238i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final kh.c f20239j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final com.bytedance.pia.core.utils.f f20240k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final com.bytedance.ai.resource.core.net.a f20241l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f20242m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final com.bytedance.ies.bullet.web.pia.c f20243n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Map f20244o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final p f20245p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final kh.d f20246q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final w f20247r;
    public final com.bytedance.pia.core.tracing.b s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final ConcurrentLinkedQueue f20248t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public volatile WeakReference f20249u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final gh.c f20250v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final boolean f20251w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final long f20252x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final AtomicBoolean f20253y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final AtomicBoolean f20254z;

    public d(Uri r11, String r12, String r13, com.bytedance.ies.bullet.web.pia.c r14, boolean r15, com.bytedance.pia.core.utils.f r16, com.bytedance.ai.resource.core.net.a r17, String r18, com.bytedance.pia.core.setting.a r19, Map r20, bh.b r21) {
        gh.a r5 = new gh.a();
        this.f20238i = r5;
        w r10 = new w(13);
        this.f20247r = r10;
        com.bytedance.pia.core.tracing.d r22 = new com.bytedance.pia.core.tracing.d(r10, EventName.f7091a, System.currentTimeMillis());
        r22.d.put("url", r11.toString());
        r22.a();
        this.d = r19;
        this.e = r13;
        this.f = r12;
        if (r11.getQueryParameterNames().contains("_pia_") == false) goto L5;
        this.g = r11;
    L6:
        this.f20237h = j.k(r11, null);
        this.f20243n = r14;
        this.f20240k = r16;
        this.f20241l = r17;
        kh.c r23 = new kh.c(r11.toString());
        this.f20239j = r23;
        if (this.f20231b.get() == true) goto L12;
        String r24 = r23.hashCode() + String.valueOf(hashCode());
        if (TextUtils.isEmpty(r24) == true) goto L12;
        this.f20232c.putIfAbsent(r24, r23);
    L12:
        this.f20244o = r20;
        this.f20245p = new p(r12);
        kh.d r25 = new kh.d(r21);
        this.f20246q = r25;
        this.s = new com.bytedance.pia.core.tracing.b(r12);
        this.f20242m = androidx.constraintlayout.motion.widget.a.t(new StringBuilder(), lh.h.f19632a, " ", r18);
        m.b(new kh.b(11, this, r13));
        this.f20248t = new ConcurrentLinkedQueue();
        this.f20249u = null;
        this.f20250v = new gh.c(PiaMethod$Scope.f6953b, this, r5);
        this.f20253y = new AtomicBoolean(false);
        this.f20254z = new AtomicBoolean(false);
        this.A = new AtomicBoolean(false);
        this.B = new AtomicBoolean(false);
        this.C = new AtomicBoolean(false);
        this.D = null;
        this.f20251w = r15;
        j.A("[Runtime] created runtime. url=" + r11);
        long r26 = System.currentTimeMillis();
        this.f20252x = r26;
        r25.a("initialize.end", r26);
        return;
    L5:
        this.g = j.b(r11);
        goto L6
    }

    public final View c() {
        if (this.f20249u != null) goto L5;
        return null;
    L5:
        return (View) this.f20249u.get();
    }

    public final void d(View r10) {
        if (this.C.get() == false) goto L7;
        Intrinsics.checkNotNullParameter("[Runtime] call onBindView after release.", "message");
        j.x("[Runtime] call onBindView after release.", null);
        return;
    L7:
        if (this.f20254z.compareAndSet(false, true) == true) goto L11;
        Intrinsics.checkNotNullParameter("[Runtime] onBindView more than once!", "message");
        j.x("[Runtime] onBindView more than once!", null);
        return;
    L11:
        if ((r10 instanceof WebView) == false) goto L13;
        kh.c r5 = this.f20239j;
        r5.getClass();
        m.b(new a2.b(29, r5, (WebView) r10));
    L13:
        this.f20249u = new WeakReference(r10);
        Iterator r11 = this.f20248t.iterator();
    L15:
        if (r11.hasNext() == false) goto L21;
        c r12 = (c) r11.next();
        r12.d(r10);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        String r13 = "[Runtime] " + r12.c() + " onBindView error:";
        Intrinsics.checkNotNullParameter(r13, "message");
        j.w(4, r13, th);
        goto L15
    }

    public final void e(com.bytedance.ies.bullet.web.pia.f r5) {
        if (r5 != null) goto L15;
    L7:
        HashSet r10 = null;
    L8:
        if (r10 == null) goto L14;
        Iterator r11 = r10.iterator();
    L12:
        if (r11.hasNext() == false) goto L18;
        ah.b r12 = (ah.b) r11.next();
        gh.a r13 = this.f20238i;
        r13.getClass();
        m.b(new a2.b(20, r13, r12));
        goto L12
    L18:
        return;
    L14:
        return;
    L15:
        r10 = r5.f6229b.f6225c;     // Catch: Throwable -> L5
    L5:
        th = move-exception;
        Intrinsics.checkNotNullParameter("[Runtime] create bridge method error:", "message");
        j.x("[Runtime] create bridge method error:", th);
        goto L7
    }

    public final void f(Class r10, yg.b r11) {
        if (this.f20253y.get() == false) goto L7;
        Intrinsics.checkNotNullParameter("[Runtime] can not install plugin after initialized!", "message");
        j.x("[Runtime] can not install plugin after initialized!", null);
        return;
    L7:
        if (this.C.get() == false) goto L24;
        Intrinsics.checkNotNullParameter("[Runtime] call installPlugin after release.", "message");
        j.x("[Runtime] call installPlugin after release.", null);
        return;
    L24:
        if (r11 != null) goto L15;
        c r12 = (c) r10.getConstructor(new Class[]{d.class}).newInstance(new Object[]{this});     // Catch: Throwable -> L13
    L17:
        if (a(r12.c()) == null) goto L20;
        j.A("[Runtime] duplicate plugin registered, name=".concat(r12.c()));     // Catch: Throwable -> L13
        return;
    L20:
        b(r12, r12.c());     // Catch: Throwable -> L13
        this.f20248t.add(r12);     // Catch: Throwable -> L13
        j.A("[Runtime] install plugin success, name=".concat(r12.c()));     // Catch: Throwable -> L13
        return;
    L15:
        r12 = (c) r10.getConstructor(new Class[]{d.class, yg.b.class}).newInstance(new Object[]{this, r11});     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        Intrinsics.checkNotNullParameter("[Runtime] install plugin error:", "message");
        j.x("[Runtime] install plugin error:", th);
    }

    public final void g(String r10, Object... r11) {
        if (this.f20253y.get() == true) goto L7;
        Intrinsics.checkNotNullParameter("[Runtime] can not send event before initialize!", "message");
        j.x("[Runtime] can not send event before initialize!", null);
        return;
    L7:
        if (this.C.get() == false) goto L10;
        Intrinsics.checkNotNullParameter("[Runtime] can not send event after released!", "message");
        j.x("[Runtime] can not send event after released!", null);
        return;
    L10:
        Iterator r5 = this.f20248t.iterator();
    L12:
        if (r5.hasNext() == false) goto L18;
        c r12 = (c) r5.next();
        r12.e(r10, r11);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        String r13 = "[Runtime] " + r12.c() + " onEvent error:";
        Intrinsics.checkNotNullParameter(r13, "message");
        j.w(4, r13, th);
        goto L12
    }

    public final void h(ArrayList r5) {
        if (r5 == null) goto L15;
        Iterator r10 = r5.iterator();
    L6:
        if (r10.hasNext() == false) goto L25;
        fh.b r11 = (fh.b) r10.next();
    L13:
        th = move-exception;
        Intrinsics.checkNotNullParameter("[Runtime] create MetricsObserver error:", "message");
        j.x("[Runtime] create MetricsObserver error:", th);
        goto L6
    L9:
        if (r11.a(this.f20243n) == null) goto L6;
        throw new ClassCastException();     // Catch: Throwable -> L13
    L25:
        return;
    }

    public final void i() {
        if (this.C.get() == false) goto L7;
        Intrinsics.checkNotNullParameter("[Runtime] call initialize after release.", "message");
        j.x("[Runtime] call initialize after release.", null);
        return;
    L7:
        if (this.f20253y.compareAndSet(false, true) == true) goto L10;
        Intrinsics.checkNotNullParameter("[Runtime] initialize more than once!", "message");
        j.x("[Runtime] initialize more than once!", null);
        return;
    L10:
        ConcurrentLinkedQueue r10 = this.f20248t;
        Iterator r5 = r10.iterator();
    L12:
        if (r5.hasNext() == false) goto L18;
        c r11 = (c) r5.next();
        r11.f();     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        String r12 = "[Runtime] " + r11.c() + "initialize error:";
        Intrinsics.checkNotNullParameter(r12, "message");
        j.w(4, r12, th);
        r10.remove(r11);
        goto L12
    }

    public final c j(String r5) {
        if (this.C.get() == false) goto L7;
        Intrinsics.checkNotNullParameter("[Runtime] call getPlugin after release.", "message");
        j.x("[Runtime] call getPlugin after release.", null);
        return null;
    L7:
        if (r5.isEmpty() == false) goto L9;
        return null;
    L9:
        Object r10 = a(r5);
        if ((r10 instanceof c) == true) goto L12;
        return null;
    L12:
        return (c) r10;
    }

    public final boolean k() {
        com.bytedance.pia.core.setting.a r5 = this.d;
        r5.getClass();
        return !Intrinsics.areEqual(r5, com.bytedance.pia.core.setting.a.f);
    }

    @Override // nh.a, fh.c
    public final void release() {
        if (this.C.compareAndSet(false, true) == true) goto L6;
        Intrinsics.checkNotNullParameter("[Runtime] release more than once!", "message");
        j.x("[Runtime] release more than once!", null);
        return;
    L6:
        a r5 = this.D;
        if (r5.f20231b.get() == false) goto L10;
    L13:
        this.D = null;
        super.release();
        Iterator r10 = this.f20248t.iterator();
    L15:
        if (r10.hasNext() == false) goto L17;
        ((c) r10.next()).release();
        goto L15
    L17:
        this.f20248t.clear();
        gh.c r11 = this.f20250v;
        r11.getClass();
        m.b(new com.obric.oui.lisitem.a(r11, 7));
        j.A("[Runtime] release runtime. url=" + this.g);
        return;
    L10:
        if (TextUtils.isEmpty("ctx-pia-runtime") == true) goto L13;
        r5.f20232c.remove("ctx-pia-runtime");
        goto L13
    }
}
