package eb;

import com.bytedance.android.monitorV2.lynx.LynxViewMonitor;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.sdk.xbridge.cn.platform.lynx.LynxBDXBridge;
import com.bytedance.sdk.xbridge.cn.protocol.d;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.tasm.LynxView;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import jz2.j;
import jz2.k;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public final LynxView a;
    public final LynxBDXBridge b;

    /* JADX INFO: renamed from: eb.a$a, reason: collision with other inner class name */
    public static final class C0154a {
    }

    public static final class b {
        public final /* synthetic */ bb.b a;
        public final /* synthetic */ gb.a.c b;
        public final /* synthetic */ String c;
        public final /* synthetic */ a d;
        public final /* synthetic */ Map<String, Object> e;
        public final /* synthetic */ String f;

        public b(bb.b r1, gb.a.c r10, String r11, a r12, Map<String, ? extends Object> r13, String r14) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
            this.d = r12;
            this.e = r13;
            this.f = r14;
        }
    }

    public static final class c extends d<Object> {
        public final /* synthetic */ com.bytedance.sdk.xbridge.cn.platform.lynx.a c;
        public final /* synthetic */ b d;
        public final /* synthetic */ a e;

        public final JSONObject a() {
            return new JSONObject();
        }

        public final void b(Object r10) {
            Intrinsics.checkNotNullParameter(r10, "data");
            Map r11 = (Map) r10;
            if (Intrinsics.areEqual(r11.get("code"), 1) == true) goto L14;
            Object r1 = r11.get("__jsb2__data__");
            if ((r1 instanceof JSONObject) == false) goto L7;
            JSONObject r12 = (JSONObject) r1;
        L8:
            if (r12 == null) goto L10;
            boolean r13 = Intrinsics.areEqual(r12.get("code"), 1);
        L11:
            if (r13 == true) goto L14;
            boolean r14 = false;
        L15:
            if (r14 == false) goto L19;
            b r15 = this.d;
            r15.getClass();
            Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_RESULT);
            r15.a.c.c.put(r15.c, r11);
            gb.a.c r16 = r15.b;
            if (r16 == null) goto L20;
            r15.d.a(r15.e, r16, r15.a);
        L20:
            com.bytedance.sdk.xbridge.cn.platform.lynx.b r17 = this.e.b.D();
            com.bytedance.sdk.xbridge.cn.platform.lynx.a r18 = this.c;
            Intrinsics.checkNotNull(r18, "null cannot be cast to non-null type com.bytedance.sdk.xbridge.cn.protocol.entity.BaseBridgeCall<kotlin.Any>");
            LynxView r19 = ((me7.c) r17).b;
            if (r19 != null) goto L23;
            return;
        L23:
            if (((le7.a) r18).k != 1) goto L25;
            LynxViewMonitor r0 = LynxViewMonitor.b;
            k r20 = new k();
            r20.b = ((le7.a) r18).a;
            r20.c = 0;
            r20.d = System.currentTimeMillis() - ((le7.a) r18).f;
            Unit r21 = Unit.INSTANCE;
            r0.getClass();
            LynxViewMonitor.o(r19, r20);
            return;
        L25:
            LynxViewMonitor r22 = LynxViewMonitor.b;
            j r23 = new j();
            r23.d = ((le7.a) r18).a;
            int r24 = ((le7.a) r18).k;
            r23.b = r24;
            String r25 = ((le7.a) r18).l;
            Result.Companion r26 = Result.Companion;     // Catch: Throwable -> L28
            r25 = new JSONObject().putOpt(com.bytedance.android.ec.core.event.a.KEY_MSG, r25).putOpt("code", Integer.valueOf(r24)).toString();     // Catch: Throwable -> L28
        L30:
            r23.c = r25;
            Unit r27 = Unit.INSTANCE;
            r22.getClass();
            LynxViewMonitor.m(r19, r23);
            return;
        L28:
            th = move-exception;
            Result.Companion r28 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
            goto L30
        L19:
            b r29 = this.d;
            String r30 = ((le7.a) this.c).l;
            r29.getClass();
            Intrinsics.checkNotNullParameter(r30, "reason");
            HybridLogger r31 = HybridLogger.a;
            HybridLogger.i("AirSolution_ActionDispatcher", "jsb action failed, bridge name: " + r29.f + ", reason: " + r30, null, 12);
            goto L20
        L10:
            r13 = false;
            goto L11
        L7:
            r12 = null;
        L14:
            r14 = true;
            goto L15
        }

        public c(com.bytedance.sdk.xbridge.cn.platform.lynx.a r1, b r10, a r11) {
            this.c = r1;
            this.d = r10;
            this.e = r11;
            Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.bytedance.sdk.xbridge.cn.protocol.entity.BaseBridgeCall<kotlin.Any>");
            super(r1);
        }
    }

    static {
    }

    public a(LynxView r10, LynxBDXBridge r11) {
        Intrinsics.checkNotNullParameter(r10, "lynxView");
        Intrinsics.checkNotNullParameter(r11, "lynxBDXBridge");
        this.a = r10;
        this.b = r11;
    }

    public final void a(Map<String, ? extends Object> r10, gb.a.c r11, bb.b r12) {
        Intrinsics.checkNotNullParameter(r11, "highExec");
        Intrinsics.checkNotNullParameter(r12, "airSolutionContext");
        fb.c r13 = r12.e;
        r13.getClass();
        Intrinsics.checkNotNullParameter(this, "actionDispatcher");
        Intrinsics.checkNotNullParameter(r11, "highExec");
        List<gb.b> r0 = r11.b();
        if (r0 == null) goto L8;
        Iterator<T> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L8;
        gb.b r14 = (gb.b) r1.next();
        r13.a.f.a(this, r14, r10);
    L8:
        gb.a.b r15 = r11.c();
        if (r15 == null) goto L47;
        fb.b r16 = r13.a.f;
        List<gb.b> r17 = r15.a();
        r16.getClass();
        boolean r18 = false;
        if (r17 == null) goto L30;
        gb.b r19 = (gb.b) ListProtector.get(r17, 0);
        if (Intrinsics.areEqual("op", r19.a()) == false) goto L30;
        fb.d r20 = r16.a.d;
        LinkedHashMap r21 = new LinkedHashMap();
        String r22 = r19.a();
        if (r22 == null) goto L18;
        r21.put("$t", r22);
    L18:
        String r23 = r19.b();
        if (r23 == null) goto L21;
        r21.put("n", r23);
    L21:
        Object r24 = r19.c();
        if (r24 == null) goto L24;
        r21.put("p", r24);
    L24:
        Object r25 = r20.b(new JSONObject(r21).toString(), r10);
        if ((r25 instanceof Boolean) == false) goto L27;
        Boolean r26 = (Boolean) r25;
    L28:
        if (r26 == null) goto L30;
        r18 = r26.booleanValue();
        goto L30
    L27:
        r26 = null;
    L30:
        if (r18 == false) goto L39;
        gb.a.b r27 = r11.d();
        if (r27 == null) goto L51;
        List<gb.b> r28 = r27.a();
        if (r28 == null) goto L52;
        Iterator<T> r29 = r28.iterator();
    L37:
        if (r29.hasNext() == false) goto L55;
        gb.b r30 = (gb.b) r29.next();
        r13.a.f.a(this, r30, r10);
        goto L37
    L55:
        return;
    L52:
        return;
    L51:
        return;
    L39:
        gb.a.b r31 = r11.a();
        if (r31 == null) goto L53;
        List<gb.b> r32 = r31.a();
        if (r32 == null) goto L54;
        Iterator<T> r33 = r32.iterator();
    L45:
        if (r33.hasNext() == false) goto L56;
        gb.b r34 = (gb.b) r33.next();
        r13.a.f.a(this, r34, r10);
        goto L45
    L56:
        return;
    L54:
        return;
    L53:
        return;
    }

    public final void b(String r14, Map<String, ? extends Object> r15, bb.b r16) {
        Intrinsics.checkNotNullParameter(r14, "actionName");
        Intrinsics.checkNotNullParameter(r15, "realArguments");
        Intrinsics.checkNotNullParameter(r16, "airSolutionContext");
        boolean r1 = true;
        if (r14.length() != 0) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L10;
        HybridLogger.i("AirSolution_ActionDispatcher", "jsb action failed, reason: action name is empty", null, 12);
        return;
    L10:
        HybridLogger r10 = HybridLogger.a;
        HybridLogger.m("AirSolution_ActionDispatcher", "handleLifecycle: annieXLynxView: " + this.a + ", actionName: " + r14 + ", realArguments: " + r15, null, null, 12);
        Map<String, gb.a.d> r11 = r16.a;
        if (r11 != null) goto L13;
    L15:
        boolean r12 = false;
    L16:
        if (r12 == false) goto L31;
        Map<String, gb.a.d> r13 = r16.a;
        if (r13 == null) goto L45;
        gb.a.d r17 = r13.get(r14);
        if (r17 == null) goto L46;
        HybridLogger.m("AirSolution_ActionDispatcher", "handleJSBAction, actionName:" + r14 + ", jsb:" + r17, null, null, 12);
        String r18 = r17.b();
        if (r18 == null) goto L28;
        fb.d r19 = r16.d;
        r19.getClass();
        Intrinsics.checkNotNullParameter(r17, "jsb");
        LinkedHashMap r20 = new LinkedHashMap();
        Map<String, ? extends Object> r110 = r17.c();
        if (r110 == null) goto L26;
        JavaOnlyMap r21 = r19.c(r110, r15);
    L27:
        c(r14, r18, r21, r15, r17.a(), r16);
        Unit r22 = Unit.INSTANCE;
    L29:
        if (r22 != null) goto L47;
        HybridLogger.i("AirSolution_ActionDispatcher", "invalid jsb: " + r17, null, 12);
        return;
    L47:
        return;
    L26:
        r21 = com.bytedance.sdk.xbridge.cn.platform.lynx.d.h(r20, 0);
        goto L27
    L28:
        r22 = null;
        goto L29
    L46:
        return;
    L45:
        return;
    L31:
        Map<String, gb.a.c> r23 = r16.b;
        if (r23 != null) goto L34;
    L36:
        r1 = false;
    L37:
        if (r1 == false) goto L43;
        Map<String, gb.a.c> r24 = r16.b;
        if (r24 == null) goto L49;
        gb.a.c r25 = r24.get(r14);
        if (r25 == null) goto L50;
        a(r15, r25, r16);
        return;
    L50:
        return;
    L49:
        return;
    L43:
        c(r14, r14, JavaOnlyMap.from(r15), r15, null, r16);
        return;
    L34:
        if (r23.containsKey(r14) != true) goto L36;
    L13:
        if (r11.containsKey(r14) != true) goto L15;
        r12 = true;
        goto L16
    L5:
        r0 = false;
        goto L7
    }

    public final void c(String r10, String r11, JavaOnlyMap r12, Map<String, ? extends Object> r13, gb.a.c r14, bb.b r15) {
        LynxView r1 = ((me7.c) this.b.D()).b;
        if (r1 == null) goto L6;
        String r16 = r1.getTemplateUrl();
        if (r16 == null) goto L6;
    L7:
        com.bytedance.sdk.xbridge.cn.platform.lynx.a r0 = new com.bytedance.sdk.xbridge.cn.platform.lynx.a(r11, r12, r16);
        c r17 = new c(r0, new b(r15, r14, r10, this, r13, r11), this);
        this.b.p(r0, r17);
        return;
    L6:
        r16 = "";
        goto L7
    }
}
