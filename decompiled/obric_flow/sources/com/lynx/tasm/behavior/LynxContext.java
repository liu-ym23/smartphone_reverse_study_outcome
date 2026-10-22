package com.lynx.tasm.behavior;

import android.content.Context;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import androidx.room.writer.DaoWriter;
import com.lynx.base.log.LynxLog;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.tasm.LynxBooleanOption;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.UIBody;
import com.lynx.tasm.core.JSProxy;
import com.lynx.tasm.utils.DisplayMetricsHolder;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public abstract class LynxContext extends q implements f {
    public int A;
    public String B;
    public qn.a C;
    public wn.h D;
    public com.bytedance.ies.bullet.base.utils.b E;
    public dn.a F;
    public final HashMap G;
    public Float H;
    public boolean I;
    public boolean J;
    public com.lynx.tasm.u0 K;
    public boolean L;
    public boolean M;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public k f10139c;
    public k d;
    public JavaOnlyMap e;
    public final HashMap f;
    public com.lynx.tasm.r g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public a1 f10140h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public com.lynx.tasm.i f10141i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public WeakReference f10142j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public WeakReference f10143k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public WeakReference f10144l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public UIBody f10145m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public HashMap f10146n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public WeakReference f10147o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public WeakReference f10148p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f10149q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public com.lynx.tasm.p0 f10150r;
    public WeakReference s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public WeakReference f10151t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final DisplayMetrics f10152u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public x0 f10153v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public ArrayList f10154w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public com.lynx.tasm.behavior.ui.y f10155x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public LynxBooleanOption f10156y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f10157z;

    public LynxContext(Context r5, DisplayMetrics r10) {
        super(r5);
        this.e = null;
        this.f = new HashMap();
        this.f10140h = null;
        this.f10143k = null;
        this.f10149q = null;
        this.f10150r = null;
        this.s = null;
        this.f10155x = null;
        this.f10156y = LynxBooleanOption.f9962a;
        this.A = -1;
        this.G = new HashMap();
        this.L = false;
        this.M = false;
        DisplayMetrics r11 = new DisplayMetrics();
        this.f10152u = r11;
        r11.setTo(r10);
    }

    public final Context a() {
        if (this.f10313a == false) goto L7;
        return getBaseContext();
    L7:
        return this.f10314b;
    }

    public abstract void b(LynxError r5);

    public final void c(LynxBaseUI r5) {
        if (r5.getEvents() == null) goto L13;
        if (r5.getEvents().containsKey("uiappear") == true) goto L9;
        if (r5.getEvents().containsKey("uidisappear") == false) goto L13;
    L9:
        if (this.f10155x != null) goto L11;
        m();
    L11:
        this.f10155x.j(String.valueOf(r5.getSign()), r5);
    L13:
        if (r5.getExposureID() != null) goto L15;
        return;
    L15:
        if (this.f10155x != null) goto L17;
        m();
    L17:
        this.f10155x.j(null, r5);
    }

    public final void d(UIBody.UIBodyView r5) {
        if (r5 == null) goto L4;
        boolean r10 = true;
    L5:
        this.f10313a = r10;
        LynxLog.b(2, "LynxUIRenderer", "lynxContext setUIBodyView" + r5 + this);
        this.s = new WeakReference(r5);
        if (TextUtils.isEmpty(this.B) == false) goto L9;
        TraceEvent.c("LynxContext.updateLynxSessionID");
        this.B = ai.j0.D(String.valueOf(System.currentTimeMillis()), DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD, String.valueOf(System.identityHashCode(r5)));
        TraceEvent.a(0, "LynxContext.updateLynxSessionID");
        return;
    L9:
        return;
    L4:
        r10 = false;
        goto L5
    }

    public final void e(String r5, JavaOnlyArray r10) {
        StringBuilder r11 = com.lynx.tasm.utils.e.b("LynxContext sendGlobalEvent ", r5, " with this: ");
        r11.append(toString());
        LynxLog.b(2, "LynxContext", r11.toString());
        WeakReference r12 = this.f10142j;
        if (r12 == null) goto L8;
        JSProxy r13 = (JSProxy) r12.get();
        if (r13 == null) goto L8;
        com.lynx.jsbridge.b r14 = new com.lynx.jsbridge.b("GlobalEventEmitter", r13);
    L9:
        if (r14 != null) goto L12;
        LynxLog.b(4, "LynxContext", "LynxContext sendGlobalEvent failed since eventEmitter is null with this: " + toString());
        return;
    L12:
        JavaOnlyArray r15 = new JavaOnlyArray();
        r15.pushString(r5);
        r15.pushArray(r10);
        r14.f9902b.f(r14.f9901a, r15);
        return;
    L8:
        r14 = null;
        goto L9
    }

    public final void f(String r5, String r10, LynxError r11) {
        if (this.f10150r == null) goto L6;
        String r12 = this.f10149q;
        r11.g = null;
        r11.f9994i = r12;
        r11.b("src", r5);
        r11.b("type", r10);
        this.f10150r.onReceivedError(r11);
        return;
    }

    public final boolean g() {
        com.lynx.tasm.u0 r5 = this.K;
        if (r5 != null) goto L5;
        return false;
    L5:
        return r5.f10969c;
    }

    public final boolean h() {
        com.lynx.tasm.u0 r5 = this.K;
        if (r5 != null) goto L5;
        return true;
    L5:
        return r5.f10986y;
    }

    public final w i() {
        WeakReference r5 = this.f10148p;
        if (r5 != null) goto L7;
        return null;
    L7:
        return (w) r5.get();
    }

    public final com.lynx.tasm.behavior.ui.accessibility.d j() {
        UIBody r5 = this.f10145m;
        if (r5 != null) goto L5;
        return null;
    L5:
        return r5.d;
    }

    public final LynxView k() {
        UIBody.UIBodyView r5 = l();
        if ((r5 instanceof LynxView) == false) goto L7;
        return (LynxView) r5;
    L7:
        if ((r5 instanceof cn.a) == true) goto L9;
        return null;
    L9:
        return ((cn.a) r5).getRootView();
    }

    public final UIBody.UIBodyView l() {
        WeakReference r5 = this.s;
        if (r5 != null) goto L5;
        return null;
    L5:
        return (UIBody.UIBodyView) r5.get();
    }

    public final void m() {
        this.f10155x = new com.lynx.tasm.behavior.ui.y();
        n0 r5 = (n0) this.f10147o.get();
        if (r5 == null) goto L5;
        com.lynx.tasm.behavior.ui.y r10 = this.f10155x;
        r10.getClass();
        r10.f10198a = new WeakReference(r5.f10288b);
    L5:
        WeakReference r11 = new WeakReference(this);
        com.lynx.tasm.behavior.ui.y r12 = this.f10155x;
        r12.A = new com.lynx.tasm.behavior.ui.w(r11);
        DisplayMetrics r13 = DisplayMetricsHolder.b(this);
        int r14 = r13.widthPixels;
        int[] r15 = r12.f10212t;
        r15[0] = r14;
        r15[1] = r13.heightPixels;
    }

    public final void n() {
        HashMap r5 = this.f;
        monitor-enter(r5);
        this.f.clear();     // Catch: Throwable -> L23
        monitor-exit(r5);     // Catch: Throwable -> L23
        a1 r10 = this.f10140h;
        if (r10 == null) goto L9;
        r10.f10179c = null;
        r10.g = null;
        r10.f10180h.clear();
    L9:
        com.lynx.tasm.behavior.ui.y r11 = this.f10155x;
        if (r11 == null) goto L12;
        com.lynx.tasm.utils.j.f(new com.lynx.tasm.behavior.ui.l(r11, 1));
    L12:
        com.lynx.tasm.u0 r12 = this.K;
        if (r12 == null) goto L15;
        boolean r13 = r12.E;
    L16:
        if (r13 == false) goto L28;
        WeakReference r14 = this.f10148p;
        if (r14 == null) goto L29;
        w r15 = (w) r14.get();
        if (r15 == null) goto L30;
        com.lynx.tasm.utils.j.f(new v(r15, 1));
        return;
    L30:
        return;
    L29:
        return;
    L28:
        return;
    L15:
        r13 = false;
    L23:
        th = move-exception;
        throw th;
    }
}
