package l9;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.webkit.WebView;
import androidx.room.jarjarred.org.antlr.v4.analysis.LeftRecursiveRuleTransformer;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.entity.Header;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import com.bytedance.pia.core.bridge.methods.l0;
import com.bytedance.pia.core.bridge.methods.n0;
import com.google.gson.JsonObject;
import com.lynx.tasm.TemplateData;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.ui.image.v;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import m.f0;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class l implements z2.g, hh.a {
    public static l f;
    public static volatile l g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19573a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f19574b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f19575c;
    public final Object d;
    public Object e;

    public l() {
        this.f19573a = 0;
        io.reactivex.exceptions.a.i("KeyEventRecorder:init");
        File r5 = new File(com.bytedance.crash.util.g.h(com.bytedance.crash.n.f4057a), x8.a.f22997u);
        this.d = r5;
        this.e = new ArrayList();
        this.f19574b = String.valueOf(Process.myPid());
        this.f19575c = ym.m.o(com.bytedance.crash.n.f4057a);
    L9:
        th = move-exception;
        cl.a.C((File) this.d);
        io.reactivex.exceptions.a.f(th);
    L11:
        f = this;
        return;
    L4:
        if (r5.exists() == false) goto L11;
        if (r5.length() < 5000) goto L11;
        cl.a.C(r5);     // Catch: Throwable -> L9
        goto L11
    }

    public static final b4.d c(l r5, Uri r10) {
        b4.d r11 = (b4.d) r5.f19575c;
        TraceEvent.c("AnnieXLynxModelBuilder:updateLynxViewBuilderParams");
    L12:
        th = move-exception;
        TraceEvent.a(0, "AnnieXLynxModelBuilder:updateLynxViewBuilderParams");
        throw th;
    L4:
        if (r11.s == false) goto L18;
        b4.d r12 = b4.d.a(r11, null, com.bytedance.android.anniex.utils.e.i(r10), 14680063);     // Catch: Throwable -> L12
        ConcurrentHashMap r13 = yc.a.f23246a;     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter(xc.e.class, "cls");     // Catch: Throwable -> L12
        xc.e r14 = (xc.e) yc.a.a(xc.e.class, "default_bid");     // Catch: Throwable -> L12
        if (r14 == null) goto L14;
        xc.d r15 = (xc.d) r14.a(xc.d.class);     // Catch: Throwable -> L12
        if (r15 == null) goto L14;
        Boolean r16 = r15.s0();     // Catch: Throwable -> L12
        if (r16 == null) goto L14;
        boolean r17 = r16.booleanValue();     // Catch: Throwable -> L12
    L15:
        if (r17 == false) goto L17;
        r11.getClass();     // Catch: Throwable -> L12
    L17:
        r11 = r12;
    L14:
        r17 = true;
    L18:
        TraceEvent.a(0, "AnnieXLynxModelBuilder:updateLynxViewBuilderParams");
        return r11;
    }

    public static final TemplateData e(l r16, Uri r17, String r18) {
        TraceEvent.c("AnnieXLynxModelBuilder:mergeGlobalProps");
        int r10 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;     // Catch: Throwable -> L11
        com.bytedance.ies.bullet.base.utils.logger.a.g("AnnieX", "mergeGlobalProps:" + r18, null, 12);     // Catch: Throwable -> L11
        Map r5 = (Map) r16.e;     // Catch: Throwable -> L11
        Map r15 = (Map) r16.d;
        String r11 = (String) r16.f19574b;
        if (r5 != null) goto L25;
        ConcurrentHashMap r12 = o3.a.f20403a;     // Catch: Throwable -> L11
        Map r13 = o3.a.f(KitType.d, r11);     // Catch: Throwable -> L11
        r13.put("useXBridge3", Boolean.TRUE);     // Catch: Throwable -> L11
        r13.put("usePiperData", Boolean.FALSE);     // Catch: Throwable -> L11
        ConcurrentHashMap r14 = yc.a.f23246a;     // Catch: Throwable -> L11
        Intrinsics.checkNotNullParameter(xc.e.class, "cls");     // Catch: Throwable -> L11
        xc.e r19 = (xc.e) yc.a.a(xc.e.class, "default_bid");     // Catch: Throwable -> L11
        if (r19 == null) goto L13;
        xc.d r20 = (xc.d) r19.a(xc.d.class);     // Catch: Throwable -> L11
        if (r20 == null) goto L13;
        boolean r21 = r20.E();     // Catch: Throwable -> L11
    L14:
        if (r21 == true) goto L20;
        Iterator r22 = r15.entrySet().iterator();     // Catch: Throwable -> L11
    L17:
        if (r22.hasNext() == false) goto L20;
        Map.Entry r23 = (Map.Entry) r22.next();     // Catch: Throwable -> L11
        r13.put(r23.getKey(), r23.getValue());     // Catch: Throwable -> L11
    L20:
        if (r13.get("osVersion") != null) goto L22;
    L23:
        List r24 = nb.a.f20224a;     // Catch: Throwable -> L11
        String r25 = Build.VERSION.RELEASE;     // Catch: Throwable -> L11
        String r26 = "get osVersion by cache == null, osVersion is" + r25;     // Catch: Throwable -> L11
        com.bytedance.ies.bullet.base.utils.logger.a.g("AnnieX", r26, null, 12);     // Catch: Throwable -> L11
        r13.put("osVersion", r25);     // Catch: Throwable -> L11
        f0.j(r26);     // Catch: Throwable -> L11
    L24:
        r16.e = r13;     // Catch: Throwable -> L11
        goto L25
    L22:
        if (String.valueOf(r13.get("osVersion")).length() != 0) goto L24;
    L13:
        r21 = true;
    L25:
        TemplateData r27 = new TemplateData();     // Catch: Throwable -> L11
        Map r28 = (Map) r16.e;     // Catch: Throwable -> L11
        if (r28 == null) goto L36;
        Intrinsics.checkNotNull(r28);     // Catch: Throwable -> L11
        r27.l(r28);     // Catch: Throwable -> L11
        ConcurrentHashMap r29 = yc.a.f23246a;     // Catch: Throwable -> L11
        Intrinsics.checkNotNullParameter(xc.e.class, "cls");     // Catch: Throwable -> L11
        xc.e r30 = (xc.e) yc.a.a(xc.e.class, "default_bid");     // Catch: Throwable -> L11
        if (r30 == null) goto L32;
        xc.d r31 = (xc.d) r30.a(xc.d.class);     // Catch: Throwable -> L11
        if (r31 == null) goto L32;
        boolean r32 = r31.E();     // Catch: Throwable -> L11
    L33:
        if (r32 == false) goto L35;
        r27.l(r15);     // Catch: Throwable -> L11
    L35:
        ConcurrentHashMap r33 = o3.a.f20403a;     // Catch: Throwable -> L11
        r27.l(o3.a.i(KitType.d, r17, r11, r18));     // Catch: Throwable -> L11
        r27.i("containerID", r18);     // Catch: Throwable -> L11
        com.bytedance.android.anniex.assemble.a.b(p3.b.class, r11);     // Catch: Throwable -> L11
    L32:
        r32 = true;
    L36:
        TraceEvent.c("TemplateData:flush");     // Catch: Throwable -> L11
        r27.k();     // Catch: Throwable -> L44
        Unit r34 = Unit.INSTANCE;     // Catch: Throwable -> L44
    L50:
        TraceEvent.a(0, "TemplateData:flush");     // Catch: Throwable -> L42
        TraceEvent.a(0, "AnnieXLynxModelBuilder:mergeGlobalProps");
        return r27;
    L42:
        th = th;
        long r35 = 0;
    L48:
        TraceEvent.a(r35, "AnnieXLynxModelBuilder:mergeGlobalProps");
        throw th;
    L44:
        th = move-exception;
        TraceEvent.a(0, "TemplateData:flush");     // Catch: Throwable -> L11
        throw th;     // Catch: Throwable -> L11
    L11:
        th = th;
        r35 = 0;
        goto L48
    }

    public static l f() {
        if (g != null) goto L10;
        Context r5 = com.bytedance.crash.n.f4057a;
        if (r5 == null) goto L8;
        g = new l(r5);
        goto L10
    L8:
        throw new IllegalArgumentException("NpthBus not init");
    L10:
        return g;
    }

    public static z8.c h(LinkedList r5) {
        if (r5.isEmpty() == false) goto L6;
        return null;
    L6:
        z8.c r10 = new z8.c();
        JSONArray r11 = new JSONArray();
        Iterator r12 = r5.iterator();
    L8:
        if (r12.hasNext() == false) goto L10;
        r11.put(((z8.c) r12.next()).f23416a);
        goto L8
    L10:
        JSONObject r13 = r10.f23416a;
        mh.e.g(r11, "data", r13);
        Header r14 = Header.a();
        JSONObject r15 = r14.f4029a;
        Header.addRuntimeHeader(r15);
        r14.b(com.bytedance.crash.n.d().u());
        r14.j();
        r14.k();
        Header.d(r14);
        mh.e.g(r15, "header", r13);
        r10.f23417b = r14;
        return r10;
    }

    public static void i(String r5, String r10) {
        l r11 = f;
        if (r11 == null) goto L55;
        monitor-enter(r11);
    L38:
        th = move-exception;
        io.reactivex.exceptions.a.f(th);     // Catch: Throwable -> L9
    L51:
        monitor-exit(r11);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    L6:
        if (TextUtils.isEmpty(r5) == false) goto L11;
        monitor-exit(r11);     // Catch: Throwable -> L9
        return;
    L11:
        File r12 = (File) r11.d;     // Catch: Throwable -> L38
        if (r12 != null) goto L14;
    L40:
        k r13 = new k(r5, (String) r11.f19574b, (String) r11.f19575c, r10);     // Catch: Throwable -> L38
        File r14 = new File(new File(com.bytedance.crash.util.g.h(com.bytedance.crash.n.f4057a), x8.a.s), "keyEventLock");     // Catch: Throwable -> L38
        if (r14.exists() == false) goto L62;
    L46:
        boolean r15 = !cl.a.E(r14);     // Catch: Throwable -> L38
    L47:
        if (r15 == false) goto L51;
        io.reactivex.exceptions.a.i("KeyEventRecorder:add key event:" + r13.toString());     // Catch: Throwable -> L38
        ((ArrayList) r11.e).add(r13);     // Catch: Throwable -> L38
        cl.a.u(r13.toString(), (File) r11.d, true);     // Catch: Throwable -> L38
        goto L51
    L62:
        r14.createNewFile();     // Catch: Throwable -> L38 IOException -> L45
    L45:
        r15 = true;
        goto L47
    L14:
        if (r12.exists() == false) goto L40;
        if (((File) r11.d).length() < 5000) goto L40;
        io.reactivex.exceptions.a.i("KeyEventRecorder:buffer overflow");     // Catch: Throwable -> L38
        int r16 = ((ArrayList) r11.e).size() / 2;     // Catch: Throwable -> L23
        int r17 = 0;
    L20:
        if (r17 >= r16) goto L25;
        ((ArrayList) r11.e).remove(r17);     // Catch: Throwable -> L23
        r17 = r17 + 1;
        goto L20
    L25:
        monitor-enter(r11);     // Catch: Throwable -> L38
        File r18 = (File) r11.d;     // Catch: Throwable -> L30 IOException -> L32
        if (r18 == null) goto L34;
        cl.a.u(r11.toString(), r18, false);     // Catch: Throwable -> L30 IOException -> L32
    L34:
        monitor-exit(r11);     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        throw th;     // Catch: Throwable -> L38
    L32:
        e = move-exception;
        cl.a.C((File) r11.d);     // Catch: Throwable -> L30
        io.reactivex.exceptions.a.f(e);     // Catch: Throwable -> L30
    L23:
        th = move-exception;
        cl.a.C((File) r11.d);     // Catch: Throwable -> L38
        io.reactivex.exceptions.a.f(th);     // Catch: Throwable -> L38
        goto L25
    }

    @Override // hh.a
    public void a(JsonObject r5) {
        ((com.bytedance.pia.core.utils.a) this.d).c(r5);
    }

    @Override // z2.g
    public void b(z2.f r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        r5.f = (String) this.f19574b;
        String r10 = (String) this.f19575c;
        if (r10 == null) goto L5;
        r5.c("message_id", r10);
    L5:
        String r11 = (String) this.d;
        if (r11 == null) goto L8;
        r5.c("botId", r11);
    L8:
        String r12 = (String) this.e;
        if (r12 == null) goto L12;
        r5.c("replyFor", r12);
        return;
    }

    @Override // hh.a
    public void close() {
        com.bytedance.pia.core.utils.a r5 = (com.bytedance.pia.core.utils.a) this.d;
        r5.d = true;
        r5.a();
        r5.f7139a.set(null);
        com.bytedance.pia.core.utils.a r10 = (com.bytedance.pia.core.utils.a) this.f19574b;
        r10.d = true;
        r10.a();
        r10.f7139a.set(null);
        com.bytedance.pia.core.utils.m.b(new com.obric.oui.lisitem.a(this, 9));
    }

    @Override // hh.a
    public void d(l0 r5) {
        n0 r10 = new n0(3, this, r5);
        ((com.bytedance.pia.core.utils.a) this.f19574b).b(r10);
    }

    public z8.c g(CrashType r12, z8.c r13, m9.d r14, boolean r15) {
        if (r12 == null) goto L40;
        HashMap r5 = (HashMap) this.f19574b;
        m9.e r10 = (m9.e) r5.get(r12);
        int r11 = 0;
        if (r10 != null) goto L20;
        int r16 = m9.g.f20053a[r12.ordinal()];
        com.bytedance.crash.upload.k r17 = (com.bytedance.crash.upload.k) this.e;
        m9.c r18 = (m9.c) this.f19575c;
        Context r19 = (Context) this.d;
        switch(r16) {
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L12;
            case 7: goto L11;
            case 8: goto L10;
            default: goto L18;
        };
    L10:
        r10 = new m9.f(CrashType.ENSURE, r19, r18, r17, 1);
        goto L18
    L11:
        r10 = new m9.f(CrashType.CUSTOM_JAVA, r19, r18, r17, 0);
        goto L18
    L12:
        r10 = new m9.f(CrashType.GAME, r19, r18, r17, 0);
        goto L18
    L13:
        r10 = new m9.f(CrashType.DART, r19, r18, r17, 0);
        goto L18
    L14:
        r10 = new m9.f(CrashType.ANR, r19, r18, r17, 0);
        goto L18
    L15:
        r10 = new m9.h(CrashType.NATIVE, r19, r18, r17);
        goto L18
    L16:
        r10 = new m9.f(r19, r18, r17, true);
        goto L18
    L17:
        r10 = new m9.f(r19, r18, r17, false);
    L18:
        if (r10 == null) goto L20;
        r5.put(r12, r10);
    L20:
        if (r10 == null) goto L40;
        if (r13 != null) goto L23;
        r13 = new z8.c();
    L23:
        z8.c r110 = r13;
    L25:
        if (r11 >= 6) goto L39;
        long r20 = SystemClock.uptimeMillis();
        if (r14 == null) goto L46;
        r110 = r14.c(r11, r110);     // Catch: Throwable -> L41
    L46:
        r110 = r10.a(r11, r110);     // Catch: Throwable -> L42
    L30:
        if (r14 == null) goto L37;
        r110 = r14.d(r11, r110);     // Catch: Throwable -> L43
    L32:
        if (r15 == false) goto L37;
        if (r11 == 0) goto L35;
        JSONObject r111 = r110.f23416a;
        z8.c.n(r13.f23416a, r111);
    L36:
        r110 = new z8.c();
        goto L37
    L35:
        r13 = r110;
    L37:
        String r112 = com.lynx.jsbridge.a.d(r11, "step_cost_");
        String r21 = String.valueOf(SystemClock.uptimeMillis() - r20);
        z8.c.l(r13.b(), "custom", r112, r21);
        r11 = r11 + 1;
        goto L25
    L39:
        return r10.b(r13);
    L40:
        return r13;
    }

    public String toString() {
        switch(this.f19573a) {
            case 0: goto L6;
            default: goto L5;
        };
    L6:
        ArrayList r5 = (ArrayList) this.e;
        String r10 = "";
        if (r5 != null) goto L9;
    L14:
        return r10;
    L9:
        if (r5.size() <= 0) goto L14;
        int r11 = 0;
    L12:
        if (r11 >= r5.size()) goto L14;
        StringBuilder r12 = sk.a.a(r10);
        r12.append(((k) r5.get(r11)).toString());
        r10 = r12.toString();
        r11 = r11 + 1;
        goto L12
    L5:
        return super.toString();
    }

    public l(Context r5) {
        this.f19573a = 5;
        this.f19574b = new HashMap();
        this.d = r5;
        this.f19575c = m9.c.e();     // Catch: Throwable -> L5
        com.bytedance.crash.upload.k r10 = new com.bytedance.crash.upload.k();     // Catch: Throwable -> L5
        o.e().b(new v(19, r10, r5));     // Catch: Throwable -> L5
        this.e = r10;     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        com.bytedance.crash.c.f4025a.getClass();
        m.b.h("NPTH_CATCH", th);
    }

    public l(WebView r5, com.bytedance.pia.core.utils.a r10) {
        this.f19573a = 3;
        this.d = new com.bytedance.pia.core.utils.a();
        this.f19574b = r10;
        this.e = new WeakReference(r5);
    }

    public l(com.lynx.component.svg.parser.q r5, com.lynx.component.svg.parser.q r10, com.lynx.component.svg.parser.q r11, com.lynx.component.svg.parser.q r12) {
        this.f19573a = 2;
        this.d = r5;
        this.f19574b = r10;
        this.f19575c = r11;
        this.e = r12;
    }

    public l(String r5, b4.d r10) {
        this.f19573a = 6;
        Map r11 = MapsKt.emptyMap();
        Intrinsics.checkNotNullParameter(r5, "bid");
        Intrinsics.checkNotNullParameter(r11, "globalProps");
        Intrinsics.checkNotNullParameter(r10, "lynxViewBuilderParams");
        this.f19574b = r5;
        this.d = r11;
        this.f19575c = r10;
    }

    public l(String r5, String r10, String r11, String r12) {
        this.f19573a = 1;
        this.f19574b = r5;
        this.f19575c = r10;
        this.d = r11;
        this.e = r12;
    }

    public l(Map r5) {
        this.f19573a = 4;
        Intrinsics.checkNotNullParameter(r5, "field");
        Object r10 = r5.get("$t");
        String r11 = null;
        if ((r10 instanceof String) == false) goto L5;
        String r12 = (String) r10;
    L6:
        this.f19574b = r12;
        Object r13 = r5.get("n");
        if ((r13 instanceof String) == false) goto L9;
        String r14 = (String) r13;
    L10:
        this.f19575c = r14;
        Object r15 = r5.get(LeftRecursiveRuleTransformer.PRECEDENCE_OPTION_NAME);
        if ((r15 instanceof String) == false) goto L13;
        r11 = (String) r15;
    L13:
        this.d = r11;
        this.e = r5.get("d");
        return;
    L9:
        r14 = null;
        goto L10
    L5:
        r12 = null;
        goto L6
    }
}
