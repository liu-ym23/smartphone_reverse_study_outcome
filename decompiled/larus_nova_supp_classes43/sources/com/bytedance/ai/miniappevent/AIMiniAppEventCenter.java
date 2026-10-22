package com.bytedance.ai.miniappevent;

import com.bytedance.ai.applet.app.AppletApplication;
import com.bytedance.ai.applet.app.OnlineAppletApplication;
import com.bytedance.ai.applet.services.AppletAppManagerService;
import com.bytedance.ai.model.AppletRuntime;
import com.bytedance.ai.model.LynxWorkerRuntime;
import com.bytedance.ai.utils.g;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class AIMiniAppEventCenter {
    public static final AIMiniAppEventCenter a = null;
    public static final Set<String> b = null;
    public static final CoroutineScope c = null;
    public static final Object d = null;
    public static final LinkedHashMap<String, Long> e = null;

    public static final class a {
        public final String a;
        public final String b;

        public final boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof a) == true) goto L8;
            return false;
        L8:
            a r11 = (a) r10;
            if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r11.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "MiniAppEvent(name=" + this.a + ", payloadJson=" + this.b + ')';
        }

        public a(String r10, String r11) {
            Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME);
            Intrinsics.checkNotNullParameter(r11, "payloadJson");
            this.a = r10;
            this.b = r11;
        }
    }

    public static final class b {
        public final String a;
        public final String b;
        public final boolean c;

        public final boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof b) == true) goto L8;
            return false;
        L8:
            b r11 = (b) r10;
            if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r11.b) == true) goto L15;
            return false;
        L15:
            if (this.c == r11.c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            String r1 = this.b;
            if (r1 != null) goto L5;
            int r10 = 0;
        L6:
            int r11 = (r0 + r10) * 31;
            if (this.c == false) goto L9;
            int r12 = 1231;
        L11:
            return r11 + r12;
        L9:
            r12 = 1237;
            goto L11
        L5:
            r10 = r1.hashCode();
            goto L6
        }

        public final String toString() {
            return "MiniAppEventDispatchContext(source=" + this.a + ", nativeTrigger=" + this.b + ", startRuntimeIfNeeded=" + this.c + ')';
        }

        public b(String r10, String r11, boolean r12) {
            Intrinsics.checkNotNullParameter(r10, "source");
            this.a = r10;
            this.b = r11;
            this.c = r12;
        }
    }

    public static final class c {
        public final int a;
        public final String b;
        public final String c;
        public final String d;
        public final String e;
        public final long f;
        public final long g;
        public final a h;
        public final String i;

        public final boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof c) == true) goto L8;
            return false;
        L8:
            c r11 = (c) r10;
            if (this.a == r11.a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r11.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r11.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r11.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r11.e) == true) goto L24;
            return false;
        L24:
            if (this.f == r11.f) goto L27;
            return false;
        L27:
            if (this.g == r11.g) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.h, r11.h) == true) goto L33;
            return false;
        L33:
            if (Intrinsics.areEqual(this.i, r11.i) == true) goto L35;
            return false;
        L35:
            return true;
        }

        public final int hashCode() {
            int r0 = ((((((((this.a * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31;
            long r1 = this.f;
            int r10 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
            long r11 = this.g;
            return ((((r10 + ((int) (r11 ^ (r11 >>> 32)))) * 31) + this.h.hashCode()) * 31) + this.i.hashCode();
        }

        public final String toString() {
            return "MiniAppEventNotify(protocolVersion=" + this.a + ", eventType=" + this.b + ", eventId=" + this.c + ", msgId=" + this.d + ", appKey=" + this.e + ", timestamp=" + this.f + ", expireAt=" + this.g + ", event=" + this.h + ", logId=" + this.i + ')';
        }

        public c(int r10, String r11, String r12, String r13, String r14, long r15, long r16, a r17, String r18) {
            Intrinsics.checkNotNullParameter(r11, "eventType");
            Intrinsics.checkNotNullParameter(r12, "eventId");
            Intrinsics.checkNotNullParameter(r13, "msgId");
            Intrinsics.checkNotNullParameter(r14, "appKey");
            Intrinsics.checkNotNullParameter(r17, "event");
            Intrinsics.checkNotNullParameter(r18, "logId");
            this.a = r10;
            this.b = r11;
            this.c = r12;
            this.d = r13;
            this.e = r14;
            this.f = r15;
            this.g = r16;
            this.h = r17;
            this.i = r18;
        }
    }

    public AIMiniAppEventCenter() {
    }

    static {
        a = new AIMiniAppEventCenter();
        b = SetsKt.setOf("page_event");
        c = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(com.bytedance.ai.infra.thread_pool.b.c));
        d = new Object();
        e = new LinkedHashMap();
    }

    public static void b(String r10) {
        Intrinsics.checkNotNullParameter(r10, "rawValue");
        BuildersKt.launch$default(c, null, null, new AIMiniAppEventCenter$enqueue$1(r10, null), 3, null);
    }

    public static void c(com.bytedance.ai.miniappevent.a r21) {
        Intrinsics.checkNotNullParameter(r21, "event");
        if (r21.h > 0) goto L6;
        g.a.w("AIMiniAppEventCenter", "reject event, stage=native_ingress, reason=invalid_ttl");
        return;
    L6:
        long r10 = System.currentTimeMillis();
        long r11 = Long.MAX_VALUE - r10;
        long r12 = r21.h;
        if (r11 >= r12) goto L9;
        long r13 = Long.MAX_VALUE;
    L10:
        String r14 = r21.b;
        String r1 = r21.f;
        if (r1 != null) goto L13;
    L17:
        r1 = r21.b;
    L18:
        String r15 = r1;
        String r16 = r21.a;
        a r17 = new a(r21.c, r21.d.toString());
        String r18 = r21.g;
        if (r18 != null) goto L21;
    L25:
        r18 = r21.b;
    L26:
        BuildersKt.launch$default(c, null, null, new AIMiniAppEventCenter$enqueueNative$1(new c(1, "page_event", r14, r15, r16, r10, r13, r17, r18), r21, null), 3, null);
        return;
    L21:
        if ((!StringsKt.isBlank(r18)) == true) goto L24;
        r18 = null;
    L24:
        if (r18 != null) goto L26;
    L13:
        if ((!StringsKt.isBlank(r1)) == true) goto L16;
        r1 = null;
    L16:
        if (r1 != null) goto L18;
    L9:
        r13 = r12 + r10;
        goto L10
    }

    public static String d(c r10) {
        return "eventId=" + r10.c + ", appKey=" + r10.e + ", logId=" + r10.i + ", eventName=" + r10.h.a;
    }

    public static JsonPrimitive e(JsonElement r1) {
        if (r1 == null) goto L10;
        if (r1.isJsonPrimitive() == false) goto L8;
        return r1.getAsJsonPrimitive();
    L8:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L10:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public static int f(JsonObject r1) {
        JsonPrimitive r10 = e(r1.get("protocol_version"));
        if (r10.isNumber() == false) goto L11;
        Integer r11 = StringsKt.toIntOrNull(r10.getAsString());
        if (r11 == null) goto L9;
        return r11.intValue();
    L9:
        throw new IllegalArgumentException("Required value was null.".toString());
    L11:
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public static long g(JsonObject r0, String r1) {
        JsonPrimitive r10 = e(r0.get(r1));
        if (r10.isNumber() == false) goto L11;
        Long r11 = StringsKt.toLongOrNull(r10.getAsString());
        if (r11 == null) goto L9;
        return r11.longValue();
    L9:
        throw new IllegalArgumentException("Required value was null.".toString());
    L11:
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public static String h(JsonObject r1, String r10) {
        JsonPrimitive r11 = e(r1.get(r10));
        if (r11.isString() == false) goto L10;
        String r12 = r11.getAsString();
        Intrinsics.checkNotNull(r12);
        if ((!StringsKt.isBlank(r12)) == false) goto L8;
        return r12;
    L8:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L10:
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public final Object i(String r10, boolean r11, Continuation<? super AppletRuntime> r12) {
        if ((r12 instanceof AIMiniAppEventCenter$resolveAppletRuntime$1) == false) goto L7;
        AIMiniAppEventCenter$resolveAppletRuntime$1 r0 = (AIMiniAppEventCenter$resolveAppletRuntime$1) r12;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r13 = r0.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r0.label;
        boolean r16 = false;
        Boolean r17 = null;
        if (r15 == 0) goto L14;
        if (r15 != 1) goto L13;
        r10 = (String) r0.L$0;
        ResultKt.throwOnFailure(r13);
    L19:
        AppletApplication r18 = (AppletApplication) r13;
        g r19 = g.a;
        StringBuilder r20 = new StringBuilder("resolve runtime, stage=provide_app, appletId=");
        r20.append(r10);
        r20.append(", found=");
        if (r18 == null) goto L22;
        boolean r21 = true;
    L23:
        r20.append(r21);
        r19.i("AIMiniAppEventCenter", r20.toString());
        if ((r18 instanceof OnlineAppletApplication) == false) goto L26;
        OnlineAppletApplication r110 = (OnlineAppletApplication) r18;
    L27:
        if (r110 == null) goto L29;
        LynxWorkerRuntime r111 = r110.K();
    L30:
        StringBuilder r22 = new StringBuilder("resolve runtime, stage=wake_runtime, appletId=");
        r22.append(r10);
        r22.append(", found=");
        if (r111 == null) goto L33;
        r16 = true;
    L33:
        r22.append(r16);
        r22.append(", terminated=");
        if (r111 == null) goto L36;
        r17 = Boxing.boxBoolean(r111.H());
    L36:
        r22.append(r17);
        r19.i("AIMiniAppEventCenter", r22.toString());
        return r111;
    L29:
        r111 = null;
        goto L30
    L26:
        r110 = null;
        goto L27
    L22:
        r21 = false;
        goto L23
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r13);
        if (r11 == false) goto L37;
        AppletAppManagerService r112 = AppletAppManagerService.INSTANCE;
        r0.L$0 = r10;
        r0.label = 1;
        r13 = r112.d(r10, r0);
        if (r13 != r14) goto L19;
        return r14;
    L37:
        AppletAppManagerService.INSTANCE.getClass();
        OnlineAppletApplication r113 = AppletAppManagerService.b(r10);
        g r114 = g.a;
        StringBuilder r23 = new StringBuilder("resolve runtime, stage=find_app, appletId=");
        r23.append(r10);
        r23.append(", found=");
        if (r113 == null) goto L40;
        boolean r24 = true;
    L41:
        r23.append(r24);
        r114.i("AIMiniAppEventCenter", r23.toString());
        if (r113 != null) goto L44;
    L46:
        LynxWorkerRuntime r115 = null;
    L47:
        StringBuilder r25 = new StringBuilder("resolve runtime, stage=find_runtime, appletId=");
        r25.append(r10);
        r25.append(", found=");
        if (r115 == null) goto L50;
        r16 = true;
    L50:
        r25.append(r16);
        r25.append(", terminated=");
        if (r115 == null) goto L53;
        Boolean r116 = Boxing.boxBoolean(r115.H());
    L54:
        r25.append(r116);
        r114.i("AIMiniAppEventCenter", r25.toString());
        if (r115 != null) goto L57;
        return null;
    L57:
        if (r115.H() == false) goto L59;
        return null;
    L59:
        return r115;
    L53:
        r116 = null;
        goto L54
    L44:
        if (r113.v.isInitialized() == false) goto L46;
        r115 = (LynxWorkerRuntime) r113.v.getValue();
        goto L47
    L40:
        r24 = false;
    L7:
        r0 = new AIMiniAppEventCenter$resolveAppletRuntime$1(this, r12);
        goto L8
    }

    public static final Object a(AIMiniAppEventCenter r19, c r20, b r21, Continuation r22) {
        c r10 = r20;
        b r11 = r21;
        r19.getClass();
        if ((r22 instanceof AIMiniAppEventCenter$process$1) == false) goto L7;
        AIMiniAppEventCenter$process$1 r12 = (AIMiniAppEventCenter$process$1) r22;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r0 = r12.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r12.label;
        if (r15 == 0) goto L14;
        if (r15 != 1) goto L13;
        JsonObject r1 = (JsonObject) r12.L$2;
        b r16 = (b) r12.L$1;
        c r17 = (c) r12.L$0;
        ResultKt.throwOnFailure(r0);
        r11 = r16;
        r10 = r17;
    L86:
        AppletRuntime r18 = (AppletRuntime) r0;
        if (r10.g > System.currentTimeMillis()) goto L89;
        g.a.i("AIMiniAppEventCenter", "drop event, stage=route, reason=expired, " + d(r10));
    L113:
        return Unit.INSTANCE;
    L89:
        if (r18 != null) goto L91;
    L111:
        g.a.i("AIMiniAppEventCenter", "drop event, stage=route, reason=runtime_not_found, " + d(r10));
        goto L113
    L91:
        if (r18.H() == true) goto L111;
        JsonObject r23 = new JsonObject();
        r23.addProperty("source", r11.a);
        String r24 = r11.b;
        if (r24 == null) goto L96;
        r23.addProperty("native_trigger", r24);
    L96:
        r23.addProperty("event_id", r10.c);
        r23.addProperty("protocol_version", Integer.valueOf(r10.a));
        Result.Companion r25 = Result.Companion;     // Catch: Throwable -> L99
        Object r26 = Result.constructor-impl(Boolean.valueOf(r18.C(r10.h.a, r1, r23)));     // Catch: Throwable -> L99
    L102:
        if (Result.exceptionOrNull-impl(r26) == null) goto L104;
        g r27 = g.a;
        StringBuilder r28 = new StringBuilder("drop event, stage=bridge, reason=send_failed, ");
        a.getClass();
        r28.append(d(r10));
        r27.e("AIMiniAppEventCenter", r28.toString());
        goto L113
    L104:
        if (((Boolean) r26).booleanValue() == true) goto L107;
        g.a.i("AIMiniAppEventCenter", "drop event, stage=route, reason=bridge_not_ready, " + d(r10));
        goto L113
    L107:
        if (Intrinsics.areEqual(r10.b, "page_event") == false) goto L109;
        BuildersKt.launch$default(c, com.bytedance.ai.infra.thread_pool.b.e, null, new AIMiniAppEventCenter$dispatch$1(r10, null), 2, null);
    L109:
        g.a.i("AIMiniAppEventCenter", "dispatch event, stage=bridge, result=scheduled, " + d(r10));
    L99:
        th = move-exception;
        Result.Companion r29 = Result.Companion;
        r26 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L102
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r0);
        if (r10.a == 1) goto L18;
        String r30 = "unsupported_protocol_version";
    L38:
        if (r30 == null) goto L119;
        g.a.w("AIMiniAppEventCenter", "reject event, stage=validate, reason=" + r30 + ", " + d(r20));
        return Unit.INSTANCE;
    L119:
        Result.Companion r31 = Result.Companion;     // Catch: Throwable -> L49
        JsonElement r32 = GsonProtectorUtils.parse(new JsonParser(), r10.h.b);     // Catch: Throwable -> L49
        if (r32.isJsonObject() == true) goto L44;
        r32 = null;
    L44:
        if (r32 == null) goto L46;
        JsonObject r33 = r32.getAsJsonObject();     // Catch: Throwable -> L49
    L47:
        Object r34 = Result.constructor-impl(r33);     // Catch: Throwable -> L49
    L52:
        if (Result.isFailure-impl(r34) == false) goto L54;
        r34 = null;
    L54:
        JsonObject r35 = (JsonObject) r34;
        if (r35 != null) goto L57;
        g.a.w("AIMiniAppEventCenter", "reject event, stage=parse_payload, reason=payload_not_object, " + d(r20));
        return Unit.INSTANCE;
    L57:
        long r36 = System.currentTimeMillis();
        String r37 = r10.c;
        long r110 = r10.g;
        Object r111 = d;
        monitor-enter(r111);
        Iterator<Map.Entry<String, Long>> r112 = e.entrySet().iterator();     // Catch: Throwable -> L114
    L61:
        if (r112.hasNext() == false) goto L65;
        if (r112.next().getValue().longValue() > r36) goto L61;
        r112.remove();     // Catch: Throwable -> L114
        goto L61
    L65:
        LinkedHashMap<String, Long> r38 = e;     // Catch: Throwable -> L114
        if (r38.containsKey(r37) == false) goto L70;
        monitor-exit(r111);
        boolean r39 = false;
    L80:
        if (r39 == true) goto L82;
        g.a.i("AIMiniAppEventCenter", "drop event, stage=deduplicate, reason=duplicate, " + d(r20));
        return Unit.INSTANCE;
    L82:
        g.a.i("AIMiniAppEventCenter", "process event, stage=preprocess, result=accepted, " + d(r20));
        String r40 = r10.e;
        boolean r41 = r11.c;
        r12.L$0 = r10;
        r12.L$1 = r11;
        r12.L$2 = r35;
        r12.label = 1;
        Object r42 = r19.i(r40, r41, r12);
        if (r42 == r14) goto L131;
        r1 = r35;
        r0 = r42;
        goto L86
    L131:
        return r14;
    L70:
        if (r38.size() < 256) goto L77;
        Map.Entry r113 = (Map.Entry) CollectionsKt.firstOrNull(r38.entrySet());     // Catch: Throwable -> L114
        if (r113 == null) goto L74;
        String r114 = (String) r113.getKey();     // Catch: Throwable -> L114
    L75:
        if (r114 == null) goto L77;
        r38.remove(r114);     // Catch: Throwable -> L114
        goto L77
    L74:
        r114 = null;
    L77:
        r38.put(r37, Long.valueOf(r110));     // Catch: Throwable -> L114
        monitor-exit(r111);
        r39 = true;
    L114:
        th = move-exception;
        throw th;
    L46:
        r33 = null;
    L49:
        th = move-exception;
        Result.Companion r43 = Result.Companion;
        r34 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L52
    L18:
        if (b.contains(r10.b) == true) goto L21;
        r30 = "unsupported_event_type";
        goto L38
    L21:
        if (StringsKt.isBlank(r10.c) == false) goto L23;
    L37:
        r30 = "missing_required_field";
        goto L38
    L23:
        if (StringsKt.isBlank(r10.d) == true) goto L37;
        if (StringsKt.isBlank(r10.e) == true) goto L37;
        if (StringsKt.isBlank(r10.h.a) == true) goto L37;
        if (StringsKt.isBlank(r10.h.b) == true) goto L37;
        if (StringsKt.isBlank(r10.i) == true) goto L37;
        if (r10.g > System.currentTimeMillis()) goto L36;
        r30 = "expired";
        goto L38
    L36:
        r30 = null;
    L7:
        r12 = new AIMiniAppEventCenter$process$1(r19, r22);
        goto L8
    }
}
