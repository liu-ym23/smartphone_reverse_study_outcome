package com.bytedance.android.livesdk.chatroom.vs.gesture;

import android.view.MotionEvent;
import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.vs_base.base.ReplayDataContext;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import java.math.BigDecimal;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class g implements bq1.a {
    public final Map<String, String> a;
    public Map<String, Float> b;
    public int c;
    public Long d;
    public final DataCenter e;
    public final View f;
    public final m<Boolean> g;

    public final Map<String, Float> e() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("scale", Float.valueOf(this.f.getScaleX())), TuplesKt.to("translationX", Float.valueOf(this.f.getTranslationX())), TuplesKt.to("translationY", Float.valueOf(this.f.getTranslationY()))});
    }

    @Override // bq1.a
    public final boolean a(MotionEvent r10, Function1<? super MotionEvent, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "event");
        Intrinsics.checkNotNullParameter(r11, "sp");
        if (r10.getAction() != 0) goto L6;
        this.b = e();
        return ((Boolean) r11.invoke(r10)).booleanValue();
    L6:
        float r1 = 1.0f;
        if (r10.getAction() != 1) goto L9;
    L39:
        boolean r12 = ((Boolean) r11.invoke(r10)).booleanValue();
        Map<String, Float> r13 = e();
        Float r0 = this.b.get("scale");
        if (r0 == null) goto L42;
        float r2 = r0.floatValue();
    L44:
        if (r2 < 1.0f) goto L86;
        Float r3 = r13.get("scale");
        if (r3 == null) goto L48;
        float r4 = r3.floatValue();
    L50:
        if (r4 < 1.0f) goto L86;
        if (Intrinsics.areEqual(this.b.get("scale"), 1.0f) == false) goto L58;
        if (Intrinsics.areEqual(r13.get("scale"), 1.0f) == false) goto L58;
        return r12;
    L58:
        if ((!Intrinsics.areEqual(r13.get("scale"), this.b.get("scale"))) == false) goto L71;
        if (Intrinsics.areEqual(r13.get("scale"), 1.0f) == false) goto L62;
        g("finger", this.b);
        goto L86
    L62:
        Map<String, Float> r5 = this.b;
        DataCenter r6 = this.e;
        Pair[] r7 = new Pair[1];
        Float r8 = r13.get("scale");
        if (r8 == null) goto L65;
        float r9 = r8.floatValue();
    L66:
        r7[0] = TuplesKt.to("enlarge_ratio", String.valueOf(Math.abs(r9)));
        Map r14 = MapsKt.mutableMapOf(r7);
        r14.putAll(this.a);
        Unit r15 = Unit.INSTANCE;
        h(r6, "livesdk_vs_enlarge", r14);
        if ((!Intrinsics.areEqual(r5.get("scale"), 1.0f)) == false) goto L69;
        f(r5, r13);
        goto L86
    L69:
        this.d = Long.valueOf(System.currentTimeMillis());
        goto L86
    L65:
        r9 = 1.0f;
        goto L66
    L71:
        if ((!Intrinsics.areEqual(r13.get("translationX"), this.b.get("translationX"))) == false) goto L73;
    L74:
        Map<String, Float> r16 = this.b;
        Map<String, Float> r17 = d(r16, r13);
        DataCenter r18 = this.e;
        Pair[] r19 = new Pair[3];
        Float r20 = r13.get("scale");
        if (r20 == null) goto L77;
        r1 = r20.floatValue();
    L77:
        r19[0] = TuplesKt.to("enlarge_ratio", String.valueOf(Math.abs(r1)));
        Float r21 = r17.get("x");
        if (r21 == null) goto L80;
        Number r22 = new BigDecimal(String.valueOf(r21.floatValue()));
    L81:
        r19[1] = TuplesKt.to("move_distance_x", r22.toString());
        Float r23 = r17.get("y");
        if (r23 == null) goto L84;
        Number r24 = new BigDecimal(String.valueOf(r23.floatValue()));
    L85:
        r19[2] = TuplesKt.to("move_distance_y", r24.toString());
        Map r25 = MapsKt.mutableMapOf(r19);
        r25.putAll(this.a);
        Unit r26 = Unit.INSTANCE;
        h(r18, "livesdk_vs_enlarge_move", r25);
        f(r16, r13);
        goto L86
    L84:
        r24 = Float.valueOf(0.0f);
        goto L85
    L80:
        r22 = Float.valueOf(0.0f);
        goto L81
    L73:
        if ((!Intrinsics.areEqual(r13.get("translationY"), this.b.get("translationY"))) == false) goto L86;
    L48:
        r4 = 1.0f;
    L86:
        return r12;
    L42:
        r2 = 1.0f;
        goto L44
    L9:
        if (r10.getAction() == 3) goto L39;
        boolean r110 = ((Boolean) r11.invoke(r10)).booleanValue();
        Map<String, Float> r111 = e();
        Float r27 = this.b.get("scale");
        if (r27 == null) goto L14;
        float r28 = r27.floatValue();
    L16:
        if (r28 < 1.0f) goto L38;
        Float r29 = r111.get("scale");
        if (r29 == null) goto L20;
        float r30 = r29.floatValue();
    L22:
        if (r30 < 1.0f) goto L38;
        Float r31 = this.b.get("scale");
        if (r31 == null) goto L27;
        float r32 = r31.floatValue();
    L29:
        if (r32 != 1.0f) goto L31;
        return r110;
    L31:
        Float r112 = r111.get("scale");
        if (r112 == null) goto L34;
        float r113 = r112.floatValue();
    L36:
        if (r113 != 1.0f) goto L38;
        g("finger", this.b);
        this.c = this.b.hashCode();
        goto L38
    L34:
        r113 = 1.0f;
        goto L36
    L27:
        r32 = 1.0f;
        goto L29
    L20:
        r30 = 1.0f;
    L38:
        return r110;
    L14:
        r28 = 1.0f;
        goto L16
    }

    @Override // bq1.a
    public final void b(boolean r2, Function1<? super Boolean, Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "sp");
        m<Boolean> r4 = this.g;
        if (r4 == null) goto L6;
        r4.setValue(Boolean.valueOf(r2));
        return;
    }

    @Override // bq1.a
    public final boolean c(String r2, Function1<? super String, Boolean> r3) {
        Intrinsics.checkNotNullParameter(r2, "resetType");
        Intrinsics.checkNotNullParameter(r3, "sp");
        Map<String, Float> r0 = e();
        boolean r4 = ((Boolean) r3.invoke(r2)).booleanValue();
        if (r4 == true) goto L6;
        return false;
    L6:
        g(r2, r0);
        return r4;
    }

    public final Map<String, Float> d(Map<String, Float> r11, Map<String, Float> r12) {
        Float r3 = r11.get("translationX");
        float r4 = 0.0f;
        Float r5 = Float.valueOf(0.0f);
        if (r3 == null) goto L5;
        float r6 = r3.floatValue();
    L6:
        Float r7 = r11.get("translationY");
        if (r7 == null) goto L9;
        float r8 = r7.floatValue();
    L10:
        Float r13 = r11.get("scale");
        float r9 = 1.0f;
        if (r13 == null) goto L13;
        float r14 = r13.floatValue();
    L14:
        if (r12 == null) goto L32;
        Float r15 = r12.get("translationX");
        if (r15 == null) goto L18;
        float r16 = r15.floatValue();
    L19:
        r6 = r16 - r6;
        Float r17 = r12.get("translationY");
        if (r17 == null) goto L22;
        r4 = r17.floatValue();
    L22:
        r8 = r4 - r8;
        Float r18 = r12.get("scale");
        if (r18 == null) goto L25;
        r9 = r18.floatValue();
    L25:
        r14 = r9;
        goto L32
    L18:
        r16 = 0.0f;
    L32:
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("x", Float.valueOf((r6 / r14) / this.f.getWidth())), TuplesKt.to("y", Float.valueOf((r8 / r14) / this.f.getHeight()))});
    L29:
        th = move-exception;
        ALogger.e("getMoveDistance", th);
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("x", r5), TuplesKt.to("y", r5)});
    L13:
        r14 = 1.0f;
        goto L14
    L9:
        r8 = 0.0f;
        goto L10
    L5:
        r6 = 0.0f;
        goto L6
    }

    public final void f(Map<String, Float> r8, Map<String, Float> r9) {
        Long r0 = this.d;
        long r1 = 0;
        if (r0 == null) goto L5;
        long r3 = r0.longValue();
    L7:
        if (r3 > 0) goto L10;
        this.d = Long.valueOf(System.currentTimeMillis());
        return;
    L10:
        Map<String, Float> r10 = d(r8, r9);
        DataCenter r2 = this.e;
        Pair[] r4 = new Pair[4];
        long r5 = System.currentTimeMillis();
        Long r6 = this.d;
        if (r6 == null) goto L13;
        r1 = r6.longValue();
    L13:
        r4[0] = TuplesKt.to("enlarge_duartion", String.valueOf(r5 - r1));
        Float r11 = r8.get("scale");
        if (r11 == null) goto L16;
        float r12 = r11.floatValue();
    L17:
        r4[1] = TuplesKt.to("previous_enlarge_ratio", String.valueOf(Math.abs(r12)));
        Float r13 = r10.get("x");
        if (r13 == null) goto L20;
        Number r7 = new BigDecimal(String.valueOf(r13.floatValue()));
    L21:
        r4[2] = TuplesKt.to("move_distance_x", r7.toString());
        Float r14 = r10.get("y");
        if (r14 == null) goto L24;
        Number r15 = new BigDecimal(String.valueOf(r14.floatValue()));
    L25:
        r4[3] = TuplesKt.to("move_distance_y", r15.toString());
        Map r16 = MapsKt.mutableMapOf(r4);
        r16.putAll(this.a);
        Unit r17 = Unit.INSTANCE;
        h(r2, "livesdk_vs_enlarge_duration", r16);
        this.d = Long.valueOf(System.currentTimeMillis());
        return;
    L24:
        r15 = Float.valueOf(0.0f);
        goto L25
    L20:
        r7 = Float.valueOf(0.0f);
        goto L21
    L16:
        r12 = 1.0f;
        goto L17
    L5:
        r3 = 0;
        goto L7
    }

    public final void g(String r7, Map<String, Float> r8) {
        if (r8.hashCode() != this.c) goto L5;
        return;
    L5:
        Map<String, Float> r1 = d(r8, null);
        DataCenter r2 = this.e;
        Pair[] r3 = new Pair[4];
        r3[0] = TuplesKt.to("restore_type", r7);
        Float r9 = r8.get("scale");
        if (r9 == null) goto L8;
        float r10 = r9.floatValue();
    L9:
        r3[1] = TuplesKt.to("previous_enlarge_ratio", String.valueOf(Math.abs(r10)));
        Float r11 = r1.get("x");
        if (r11 == null) goto L12;
        Number r5 = new BigDecimal(String.valueOf(r11.floatValue()));
    L13:
        r3[2] = TuplesKt.to("move_distance_x", r5.toString());
        Float r12 = r1.get("y");
        if (r12 == null) goto L16;
        Number r4 = new BigDecimal(String.valueOf(r12.floatValue()));
    L17:
        r3[3] = TuplesKt.to("move_distance_y", r4.toString());
        Map r13 = MapsKt.mutableMapOf(r3);
        r13.putAll(this.a);
        Unit r6 = Unit.INSTANCE;
        h(r2, "livesdk_vs_enlarge_restore", r13);
        f(r8, null);
        return;
    L16:
        r4 = Float.valueOf(0.0f);
        goto L17
    L12:
        r5 = Float.valueOf(0.0f);
        goto L13
    L8:
        r10 = 1.0f;
        goto L9
    }

    public g(DataCenter r2, View r3, m<Boolean> r4) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        Intrinsics.checkNotNullParameter(r3, "targetView");
        this.e = r2;
        this.f = r3;
        this.g = r4;
        Map<String, String> r5 = r.l().g(r2);
        this.a = r5;
        r5.put("vs_screen_type", "landscape");
        this.b = MapsKt.emptyMap();
        this.c = -1;
        this.d = 0L;
    }

    public static void h(DataCenter r3, String r4, Map r5) {
        ReplayDataContext.Companion.getClass();
        if (ReplayDataContext.a.b(r3) != null) goto L5;
        r5.put("is_replay", "0");
        r.l().sendLog(r4, r5, new Object[]{IRoom.class});
        return;
    L5:
        r5.put("is_replay", "1");
        com.bytedance.android.livesdk.chatroom.vs_base.log.d.a(r3).e(r4, r5, new Object[0]);
    }
}
