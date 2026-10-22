package com.ss.ugc.effectplatform.task.algorithm;

import android.util.Log;
import bytekn.foundation.logger.Logger;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import com.ss.ugc.effectplatform.EffectConfig;
import com.ss.ugc.effectplatform.model.Effect;
import com.ss.ugc.effectplatform.model.ExceptionResult;
import com.ss.ugc.effectplatform.task.o1;
import com.ss.ugc.effectplatform.task.x0;
import com.ss.ugc.effectplatform.task.y;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class c extends o1<nlc.a> {
    public final f d;
    public final h e;
    public FetchModelTask f;
    public final o1<nlc.a> g;
    public final blc.b h;
    public final x0 i;
    public final com.ss.ugc.effectplatform.algorithm.d j;
    public final com.ss.ugc.effectplatform.cache.a k;
    public final EffectConfig l;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.ugc.effectplatform.task.o1
    public final void a() {
        this.b = true;
        o1<nlc.a> r0 = this.g;
        if (r0 == null) goto L5;
        r0.a();
    L5:
        FetchModelTask r1 = this.f;
        if (r1 == null) goto L9;
        r1.cancel();
        return;
    }

    @Override // com.ss.ugc.effectplatform.task.o1
    public final void j() {
        this.c = true;
        o1<nlc.a> r0 = this.g;
        if (r0 == null) goto L5;
        r0.j();
    L5:
        FetchModelTask r1 = this.f;
        if (r1 == null) goto L9;
        r1.pause();
        return;
    }

    @Override // com.ss.ugc.effectplatform.task.o1
    public final void b() {
        boolean r4 = true;
        blc.b r5 = this.h;     // Catch: Exception -> L41
        if (r5 == null) goto L8;
        Effect r6 = r5.a;     // Catch: Exception -> L41
        if (r6 == null) goto L8;
        com.ss.ugc.effectplatform.task.algorithm.a.d.c(r6);     // Catch: Exception -> L41
    L8:
        i(this);     // Catch: Exception -> L41
        int r7 = b0.a.a;     // Catch: Exception -> L41
        long r8 = System.currentTimeMillis();     // Catch: Exception -> L41
        blc.b r9 = this.h;     // Catch: Exception -> L41
        if (r9 == null) goto L19;
        com.ss.ugc.effectplatform.a r10 = r9.d;     // Catch: Exception -> L41
        if (r10 != null) goto L13;
    L15:
        this.f = k(this, r9);     // Catch: Exception -> L41
    L16:
        FetchModelTask r11 = this.f;     // Catch: Exception -> L41
        if (r11 == null) goto L19;
        r11.k = this.e;     // Catch: Exception -> L41
        goto L19
    L13:
        if (r10.a(r9.a) != true) goto L15;
        this.f = l(this, r9);     // Catch: Exception -> L41
    L19:
        o1<nlc.a> r12 = this.g;     // Catch: Exception -> L41
        if ((r12 instanceof y) == false) goto L22;
        ((y) r12).i = this.d;     // Catch: Exception -> L41
        ((y) r12).j = this.e;     // Catch: Exception -> L41
    L22:
        if (r12 == null) goto L24;
        r12.b();     // Catch: Exception -> L41
    L24:
        blc.b r13 = this.h;     // Catch: Exception -> L41
        if (r13 == null) goto L39;
        com.ss.ugc.effectplatform.a r14 = r13.d;     // Catch: Exception -> L41
        if (r14 != null) goto L29;
    L34:
        com.ss.ugc.effectplatform.a r15 = r13.d;     // Catch: Exception -> L41
        if (r15 == null) goto L39;
        if (r15.a(r13.a) != true) goto L39;
        Logger.INSTANCE.d("JKL", "[Mob][" + this.h.a.getName() + "][Effect+Model][Duration:" + (System.currentTimeMillis() - r8) + ']');     // Catch: Exception -> L41
        goto L39
    L29:
        if (r14.a(r13.a) != true) goto L34;
        Exception r16 = this.e.a;     // Catch: Exception -> L41
        if (r16 == null) goto L34;
        throw r16;     // Catch: Exception -> L41
    L39:
        n(System.currentTimeMillis() - r8);     // Catch: Exception -> L41
        return;
    L41:
        e = move-exception;
        ExceptionResult r17 = new ExceptionResult(e);     // Catch: Throwable -> L59
        String r18 = r17.getMsg();     // Catch: Throwable -> L59
        if (r18 != null) goto L45;
    L48:
        if (r4 == false) goto L50;
        r17.setMsg(bytekn.foundation.utils.b.a(e, 2));     // Catch: Throwable -> L59
    L50:
        Logger r19 = Logger.INSTANCE;     // Catch: Throwable -> L59
        StringBuilder r1 = new StringBuilder("[流程][结束][失败][Effect+Model][");     // Catch: Throwable -> L59
        blc.b r2 = this.h;     // Catch: Throwable -> L59
        if (r2 == null) goto L55;
        Effect r3 = r2.a;     // Catch: Throwable -> L59
        if (r3 == null) goto L55;
        String r20 = r3.getName();     // Catch: Throwable -> L59
    L56:
        r1.append(r20);     // Catch: Throwable -> L59
        r1.append("][");     // Catch: Throwable -> L59
        r1.append(r17.getErrorCode());     // Catch: Throwable -> L59
        r1.append("][");     // Catch: Throwable -> L59
        r1.append(r17.getMsg());     // Catch: Throwable -> L59
        r1.append(']');     // Catch: Throwable -> L59
        Logger.e$default(r19, "JKL", r1.toString(), null, 4, null);     // Catch: Throwable -> L59
        d(this, r17);     // Catch: Throwable -> L59
        m(r17);     // Catch: Throwable -> L59
        e(this);
        return;
    L55:
        r20 = null;
        goto L56
    L45:
        if (r18.length() == 0) goto L48;
        r4 = false;
    L59:
        th = move-exception;
        e(this);
        throw th;
    }

    public final void m(ExceptionResult r9) {
        blc.b r0 = this.h;
        String r1 = null;
        if (r0 == null) goto L7;
        Effect r2 = r0.a;
        if (r2 == null) goto L7;
        b r3 = com.ss.ugc.effectplatform.task.algorithm.a.d.a(r2);
    L8:
        Pair[] r4 = new Pair[7];
        blc.b r5 = this.h;
        String r6 = "";
        if (r5 == null) goto L15;
        Effect r7 = r5.a;
        if (r7 == null) goto L15;
        String r8 = r7.getEffect_id();
        if (r8 == null) goto L15;
    L16:
        r4[0] = TuplesKt.to("effect_id", r8);
        blc.b r10 = this.h;
        if (r10 == null) goto L23;
        Effect r11 = r10.a;
        if (r11 == null) goto L23;
        String r12 = r11.getName();
        if (r12 == null) goto L23;
    L24:
        r4[1] = TuplesKt.to("effect_name", r12);
        blc.b r13 = this.h;
        String r14 = "null";
        if (r13 == null) goto L31;
        Effect r15 = r13.a;
        if (r15 == null) goto L31;
        String r16 = r15.getPanel();
        if (r16 == null) goto L31;
    L32:
        r4[2] = TuplesKt.to(EffectConfiguration.KEY_PANEL, r16);
        blc.b r17 = this.h;
        if (r17 == null) goto L44;
        Effect r18 = r17.a;
        if (r18 == null) goto L44;
        if (r3 != null) goto L38;
        String r19 = null;
    L42:
        if (r19 == null) goto L44;
    L45:
        r4[3] = TuplesKt.to("block", r19);
        blc.b r20 = this.h;
        if (r20 == null) goto L53;
        Effect r21 = r20.a;
        if (r21 == null) goto L53;
        if (r3 == null) goto L51;
        r1 = r3.c(r21.getName(), r21.getPanel());
    L51:
        if (r1 == null) goto L53;
        r14 = r1;
    L53:
        r4[4] = TuplesKt.to("block_list", r14);
        r4[5] = TuplesKt.to("error_code", String.valueOf(r9.getErrorCode()));
        String r22 = r9.getMsg();
        if (r22 == null) goto L56;
        r6 = r22;
    L56:
        r4[6] = TuplesKt.to("error_msg", r6);
        Map r23 = MapsKt.mapOf(r4);
        EffectConfig r24 = this.l;
        klc.a r25 = (klc.a) r24.v.a;
        if (r25 == null) goto L60;
        klc.b.e(r25, false, r24, r23);
        return;
    L60:
        return;
    L38:
        if (com.ss.ugc.effectplatform.task.algorithm.a.c == true) goto L40;
        r19 = "null";
        goto L42
    L40:
        r19 = r3.b(r18.getName(), r18.getPanel());
    L44:
        r19 = "null";
    L31:
        r16 = "null";
    L23:
        r12 = "";
    L15:
        r8 = "";
    L7:
        r3 = null;
        goto L8
    }

    public final void n(long r22) {
        o1<nlc.a> r1 = this.g;
        if ((r1 instanceof y) == false) goto L5;
        long r2 = ((Number) ((y) r1).g.a).longValue();
        long r5 = ((Number) ((y) this.g).e.a).longValue();
    L6:
        FetchModelTask r7 = this.f;
        if (r7 == null) goto L13;
        a0.b<Long> r8 = r7.h;
        if (r8 == null) goto L13;
        Long r9 = (Long) r8.a;
        if (r9 == null) goto L13;
        long r10 = r9.longValue();
    L14:
        long r11 = r2 + r10;
        blc.b r12 = this.h;
        String r13 = null;
        if (r12 == null) goto L19;
        Effect r14 = r12.a;
        if (r14 == null) goto L19;
        b r15 = com.ss.ugc.effectplatform.task.algorithm.a.d.a(r14);
    L21:
        if (r11 != 0) goto L41;
        Logger r16 = Logger.INSTANCE;
        StringBuilder r3 = new StringBuilder("[Mob][Effect&Model][重复触发下载][Name:");
        blc.b r4 = this.h;
        if (r4 == null) goto L27;
        Effect r6 = r4.a;
        if (r6 == null) goto L27;
        String r17 = r6.getName();
    L28:
        r3.append(r17);
        r3.append("][EffectID:");
        blc.b r18 = this.h;
        if (r18 == null) goto L33;
        Effect r19 = r18.a;
        if (r19 == null) goto L33;
        String r20 = r19.getEffect_id();
    L34:
        r3.append(r20);
        r3.append("][Panel:");
        blc.b r21 = this.h;
        if (r21 == null) goto L39;
        Effect r23 = r21.a;
        if (r23 == null) goto L39;
        r13 = r23.getPanel();
    L39:
        r3.append(r13);
        r3.append(']');
        Logger.e$default(r16, "JKL", r3.toString(), null, 4, null);
        return;
    L33:
        r20 = null;
    L27:
        r17 = null;
        goto L28
    L41:
        Pair[] r110 = new Pair[13];
        int r24 = 0;
        r110[0] = TuplesKt.to("total_duration", Long.valueOf(r22));
        r110[1] = TuplesKt.to("total_size", Long.valueOf(r11));
        blc.b r25 = this.h;
        String r111 = "";
        if (r25 == null) goto L48;
        Effect r26 = r25.a;
        if (r26 == null) goto L48;
        String r27 = r26.getEffect_id();
        if (r27 == null) goto L48;
    L49:
        r110[2] = TuplesKt.to("effect_id", r27);
        blc.b r28 = this.h;
        if (r28 == null) goto L56;
        Effect r29 = r28.a;
        if (r29 == null) goto L56;
        String r30 = r29.getName();
        if (r30 == null) goto L56;
    L57:
        r110[3] = TuplesKt.to("effect_name", r30);
        r110[4] = TuplesKt.to("effect_duration", Long.valueOf(r5));
        r110[5] = TuplesKt.to("effect_size", Long.valueOf(r2));
        r110[6] = TuplesKt.to("model_size", Long.valueOf(r10));
        FetchModelTask r31 = this.f;
        if (r31 == null) goto L64;
        a0.b<Long> r32 = r31.g;
        if (r32 == null) goto L64;
        Long r33 = (Long) r32.a;
        if (r33 == null) goto L64;
        long r112 = r33.longValue();
    L65:
        r110[7] = TuplesKt.to("model_duration", Long.valueOf(r112));
        FetchModelTask r34 = this.f;
        if (r34 == null) goto L72;
        a0.b<Integer> r35 = r34.i;
        if (r35 == null) goto L72;
        Integer r36 = (Integer) r35.a;
        if (r36 == null) goto L72;
        int r37 = r36.intValue();
    L73:
        r110[8] = TuplesKt.to("dependent_model_count", Integer.valueOf(r37));
        FetchModelTask r38 = this.f;
        if (r38 == null) goto L80;
        a0.b<Integer> r39 = r38.j;
        if (r39 == null) goto L80;
        Integer r40 = (Integer) r39.a;
        if (r40 == null) goto L80;
        r24 = r40.intValue();
    L80:
        r110[9] = TuplesKt.to("download_model_count", Integer.valueOf(r24));
        blc.b r41 = this.h;
        if (r41 == null) goto L87;
        Effect r42 = r41.a;
        if (r42 == null) goto L87;
        String r43 = r42.getPanel();
        if (r43 == null) goto L87;
        r111 = r43;
    L87:
        r110[10] = TuplesKt.to(EffectConfiguration.KEY_PANEL, r111);
        blc.b r44 = this.h;
        String r45 = "null";
        if (r44 == null) goto L99;
        Effect r46 = r44.a;
        if (r46 == null) goto L99;
        if (r15 != null) goto L93;
        String r47 = null;
    L97:
        if (r47 == null) goto L99;
    L100:
        r110[11] = TuplesKt.to("block", r47);
        blc.b r48 = this.h;
        if (r48 == null) goto L108;
        Effect r49 = r48.a;
        if (r49 == null) goto L108;
        if (r15 == null) goto L106;
        r13 = r15.c(r49.getName(), r49.getPanel());
    L106:
        if (r13 == null) goto L108;
        r45 = r13;
    L108:
        r110[12] = TuplesKt.to("block_list", r45);
        Map r50 = MapsKt.mapOf(r110);
        EffectConfig r51 = this.l;
        klc.a r52 = (klc.a) r51.v.a;
        if (r52 == null) goto L111;
        klc.b.e(r52, true, r51, r50);
    L111:
        Logger.INSTANCE.d("JKL", "[Mob][Effect&Model][" + r50 + ']');
        return;
    L93:
        if (com.ss.ugc.effectplatform.task.algorithm.a.c == true) goto L95;
        r47 = "null";
        goto L97
    L95:
        r47 = r15.b(r46.getName(), r46.getPanel());
    L99:
        r47 = "null";
    L72:
        r37 = 0;
    L64:
        r112 = 0;
    L56:
        r30 = "";
    L48:
        r27 = "";
    L19:
        r15 = null;
    L13:
        r10 = 0;
        goto L14
    L5:
        r2 = 0;
        r5 = 0;
        goto L6
    }

    public static FetchModelTask k(c r19, blc.b r20) {
        r19.getClass();
        Effect r14 = r20.a;
    L13:
        e = move-exception;
        ExceptionResult r3 = new ExceptionResult(e);
        String r4 = e.getMessage();
        boolean r5 = true;
        if (r4 != null) goto L17;
    L20:
        boolean r6 = true;
    L21:
        if (r6 == false) goto L23;
        String r7 = Log.getStackTraceString(e);
    L24:
        Logger.e$default(Logger.INSTANCE, "JKL", "[流程][结束][失败][模型][" + r20.a.getName() + "][" + r3.getErrorCode() + "][" + r7 + ']', null, 4, null);
        if (r3.getErrorCode() != 10001) goto L27;
    L28:
        r5 = false;
    L29:
        if (r5 == true) goto L31;
    L42:
        throw e;
    L31:
        if (Intrinsics.areEqual(r14.getEffect_id(), "1111111") == false) goto L39;
        EffectConfig r12 = r19.l;
        klc.a r10 = (klc.a) r12.v.a;
        if (r10 == null) goto L42;
        String r2 = r14.getModel_names();
        if (r2 != null) goto L38;
        r2 = "";
    L38:
        klc.b.i(r10, false, r12, r14, r2, "unknown", r19.l.H.toString(), MapsKt.mapOf(TuplesKt.to("error_code", 10026)), String.valueOf(r7));
        goto L42
    L39:
        EffectConfig r8 = r19.l;
        klc.a r1 = (klc.a) r8.v.a;
        if (r1 == null) goto L42;
        klc.b.d(r1, false, r8, r14, MapsKt.mapOf(TuplesKt.to("error_code", 10018)), "Download Model Failed: " + r7);
        goto L42
    L27:
        if (r3.getErrorCode() != 10019) goto L29;
    L23:
        r7 = e.getMessage();
        goto L24
    L17:
        if (r4.length() == 0) goto L20;
        r6 = false;
        goto L21
    L4:
        if (com.ss.ugc.effectplatform.util.a.b(r14) == false) goto L11;
        StringBuilder r9 = new StringBuilder("Effect Requirements Decrypt Failed, effect: ");     // Catch: Exception -> L13
        r9.append(r14.getEffect_id());     // Catch: Exception -> L13
        r9.append(", name: ");     // Catch: Exception -> L13
        r9.append(r14.getName());     // Catch: Exception -> L13
        r9.append(", toDownloadRequirements: ");     // Catch: Exception -> L13
        List<String> r0 = r14.getRequirements_sec();     // Catch: Exception -> L13
        if (r0 == null) goto L8;
        List r11 = CollectionsKt.toList(r0);     // Catch: Exception -> L13
    L9:
        r9.append(r11);     // Catch: Exception -> L13
        throw new IllegalArgumentException(r9.toString());     // Catch: Exception -> L13
    L8:
        r11 = null;
        goto L9
    L11:
        Effect r13 = r20.a;     // Catch: Exception -> L13
        EffectConfig r15 = r19.l;     // Catch: Exception -> L13
        FetchModelTask r16 = new FetchModelTask(r19.l, r19.i, r19.j, r19.k, com.ss.ugc.effectplatform.util.a.a(r13, r15.t, r15.G), 0, r14.getName(), r20.d, r14, 768);     // Catch: Exception -> L13
        r16.run();     // Catch: Exception -> L13
        return r16;
    }

    public static FetchModelTask l(c r14, blc.b r15) {
        r14.getClass();
        Effect r12 = r15.a;
    L13:
        e = move-exception;
        e.printStackTrace();
        ExceptionResult r1 = new ExceptionResult(e);
        String r2 = e.getMessage();
        boolean r3 = true;
        if (r2 != null) goto L17;
    L20:
        boolean r4 = true;
    L21:
        if (r4 == false) goto L23;
        String r5 = Log.getStackTraceString(e);
    L24:
        Logger.e$default(Logger.INSTANCE, "JKL", "[流程][结束][失败][模型][" + r15.a.getName() + "][" + r1.getErrorCode() + "][" + r5 + ']', null, 4, null);
        if (r1.getErrorCode() != 10001) goto L27;
    L28:
        r3 = false;
    L29:
        if (r3 == false) goto L33;
        EffectConfig r9 = r14.l;
        klc.a r7 = (klc.a) r9.v.a;
        if (r7 == null) goto L33;
        klc.b.d(r7, false, r9, r12, MapsKt.mapOf(TuplesKt.to("error_code", 10018)), "download effect failed because of model fetcher failed! detail: " + r5);
    L33:
        throw e;
    L27:
        if (r1.getErrorCode() != 10019) goto L29;
    L23:
        r5 = e.getMessage();
        goto L24
    L17:
        if (r2.length() == 0) goto L20;
        r4 = false;
        goto L21
    L4:
        if (com.ss.ugc.effectplatform.util.a.b(r12) == false) goto L11;
        StringBuilder r6 = new StringBuilder("Effect Requirements Decrypt Failed, effect: ");     // Catch: Exception -> L13
        r6.append(r12.getEffect_id());     // Catch: Exception -> L13
        r6.append(", name: ");     // Catch: Exception -> L13
        r6.append(r12.getName());     // Catch: Exception -> L13
        r6.append(", toDownloadRequirements: ");     // Catch: Exception -> L13
        List<String> r0 = r12.getRequirements_sec();     // Catch: Exception -> L13
        if (r0 == null) goto L8;
        List r8 = CollectionsKt.toList(r0);     // Catch: Exception -> L13
    L9:
        r6.append(r8);     // Catch: Exception -> L13
        throw new IllegalArgumentException(r6.toString());     // Catch: Exception -> L13
    L8:
        r8 = null;
        goto L9
    L11:
        Effect r10 = r15.a;     // Catch: Exception -> L13
        EffectConfig r11 = r14.l;     // Catch: Exception -> L13
        FetchModelTask r13 = new FetchModelTask(r14.l, r14.i, r14.j, r14.k, com.ss.ugc.effectplatform.util.a.a(r10, r11.t, r11.G), 0, r12.getName(), r15.d, r14.d, r15.e, r12);     // Catch: Exception -> L13
        r13.run();     // Catch: Exception -> L13
        return r13;
    }

    public c(y r1, blc.b r2, x0 r3, com.ss.ugc.effectplatform.algorithm.d r4, com.ss.ugc.effectplatform.cache.a r5, EffectConfig r6) {
        this.g = r1;
        this.h = r2;
        this.i = r3;
        this.j = r4;
        this.k = r5;
        this.l = r6;
        if (r1 == null) goto L5;
        r1.a.a = new d(this);
    L5:
        this.d = new f();
        this.e = new h();
    }
}
