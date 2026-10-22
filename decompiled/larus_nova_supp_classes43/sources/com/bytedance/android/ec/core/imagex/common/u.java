package com.bytedance.android.ec.core.imagex.common;

import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.core.imagex.opt.h0;
import com.bytedance.android.ec.hybrid.hostapi.IECHybridKevaService;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.services.apm.api.EnsureManager;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class u {
    public static final <T extends z> List<T> a(List<? extends T> r10) {
        if (r10 == null) goto L219;
        ArrayList r1 = new ArrayList();
        Iterator<T> r11 = r10.iterator();
    L6:
        if (r11.hasNext() == false) goto L199;
        Object r12 = r11.next();
        z r13 = (z) r12;
        Boolean r14 = r13.b();
        boolean r15 = true;
        if (Intrinsics.areEqual(r14, Boolean.TRUE) == false) goto L193;
        String r16 = r13.a();
        if (r16 != null) goto L12;
    L15:
        boolean r17 = true;
    L16:
        if (r17 == true) goto L195;
        int r18 = h0.a;
        String r19 = r13.a();
        Object r20 = 0;
        if (com.bytedance.android.ec.core.imagex.opt.z.b() == false) goto L105;
        int r21 = com.bytedance.android.ec.base.settings.g.a;
        Result.Companion r22 = Result.Companion;     // Catch: Throwable -> L95
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L70
        Object r23 = SDKSettingsCacheManager.b.get(r19);     // Catch: Throwable -> L70
        if (r23 != null) goto L25;
    L67:
        Object r24 = null;
    L68:
        Object r25 = Result.constructor-impl(r24);     // Catch: Throwable -> L70
    L72:
        Throwable r26 = Result.exceptionOrNull-impl(r25);     // Catch: Throwable -> L95
        if (r26 == null) goto L76;
        EnsureManager.ensureNotReachHere(r26);     // Catch: Throwable -> L95
    L76:
        if (Result.isFailure-impl(r25) == false) goto L79;
        r25 = null;
    L79:
        if ((r25 instanceof Integer) == true) goto L81;
        r25 = null;
    L81:
        Object r27 = (Integer) r25;     // Catch: Throwable -> L95
        if (r27 != null) goto L99;
        jj4.b r28 = jj4.b.b;     // Catch: Throwable -> L95
        Object r29 = jj4.a.a(r19, Integer.class, r20, false);     // Catch: Throwable -> L95
        if (r29 != null) goto L88;
        Intrinsics.throwNpe();     // Catch: Throwable -> L95
    L88:
        if ((r29 instanceof Integer) == true) goto L90;
        r29 = null;
    L90:
        Object r30 = (Integer) r29;     // Catch: Throwable -> L95
        if (r30 != null) goto L93;
        r30 = r20;
    L93:
        r27 = Result.constructor-impl(r30);     // Catch: Throwable -> L95
    L98:
        if (Result.exceptionOrNull-impl(r27) == null) goto L99;
        Object r31 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo(r19, Integer.class, r20);     // Catch: Throwable -> L102
    L103:
        if (r31 == null) goto L190;
    L188:
        r20 = r31;
    L190:
        if (((Number) r20).intValue() != 1) goto L195;
    L196:
        if (r15 == false) goto L6;
        r1.add(r12);
    L102:
        r31 = r20;
    L99:
        r20 = r27;
        goto L190
    L25:
        if ((r23 instanceof Integer) == true) goto L27;
        Object r32 = null;
    L28:
        r24 = (Integer) r32;     // Catch: Throwable -> L70
        if (r24 != null) goto L68;
        if ((r23 instanceof Number) == false) goto L55;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L40;
        Float r33 = Float.valueOf(((Number) r23).floatValue());     // Catch: Throwable -> L70
        if ((r33 instanceof Integer) == true) goto L38;
        r33 = null;
    L38:
        r24 = (Integer) r33;     // Catch: Throwable -> L70
        goto L68
    L40:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L46;
        Double r34 = Double.valueOf(((Number) r23).doubleValue());     // Catch: Throwable -> L70
        if ((r34 instanceof Integer) == true) goto L44;
        r34 = null;
    L44:
        r24 = (Integer) r34;     // Catch: Throwable -> L70
        goto L68
    L46:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L49;
        r24 = Integer.valueOf(((Number) r23).intValue());     // Catch: Throwable -> L70
        goto L68
    L49:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L55;
        Long r35 = Long.valueOf(((Number) r23).longValue());     // Catch: Throwable -> L70
        if ((r35 instanceof Integer) == true) goto L53;
        r35 = null;
    L53:
        r24 = (Integer) r35;     // Catch: Throwable -> L70
    L55:
        if ((r23 instanceof JSONObject) == false) goto L57;
    L210:
        Object r36 = SDKSettingsCacheManager.a().fromJson(r23.toString(), Integer.class);     // Catch: Throwable -> L63
        if ((r36 instanceof Integer) == true) goto L61;
        r36 = null;
    L61:
        Object r37 = Result.constructor-impl((Integer) r36);     // Catch: Throwable -> L63
    L65:
        r24 = r37;
        if (Result.isFailure-impl(r24) == false) goto L68;
    L63:
        th = move-exception;
        Result.Companion r38 = Result.Companion;     // Catch: Throwable -> L70
        r37 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L70
        goto L65
    L57:
        if ((r23 instanceof JSONArray) == false) goto L67;
    L27:
        r32 = r23;
        goto L28
    L70:
        th = move-exception;
        Result.Companion r39 = Result.Companion;     // Catch: Throwable -> L95
        r25 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L95
    L95:
        th = move-exception;
        Result.Companion r40 = Result.Companion;
        r27 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L98
    L105:
        int r41 = com.bytedance.android.ec.core.opt.ab.n.a;
        int r42 = com.bytedance.android.ec.base.settings.c.a;
        Result.Companion r43 = Result.Companion;     // Catch: Throwable -> L181
        Object r44 = com.bytedance.android.ec.base.settings.d.c.get(r19);     // Catch: Throwable -> L156
        if (r44 != null) goto L111;
    L153:
        Object r45 = null;
    L154:
        Object r46 = Result.constructor-impl(r45);     // Catch: Throwable -> L156
    L158:
        Throwable r47 = Result.exceptionOrNull-impl(r46);     // Catch: Throwable -> L181
        if (r47 == null) goto L162;
        EnsureManager.ensureNotReachHere(r47);     // Catch: Throwable -> L181
    L162:
        if (Result.isFailure-impl(r46) == false) goto L165;
        r46 = null;
    L165:
        if ((r46 instanceof Integer) == true) goto L167;
        r46 = null;
    L167:
        r27 = (Integer) r46;     // Catch: Throwable -> L181
        if (r27 != null) goto L99;
        IHybridHostService r48 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L181
        if (r48 == null) goto L173;
        Object r49 = r48.getHostABValue(r19, r20);     // Catch: Throwable -> L181
    L174:
        if (r49 == null) goto L190;
        if ((r49 instanceof Integer) == true) goto L178;
        r49 = null;
    L178:
        r31 = (Integer) r49;     // Catch: Throwable -> L181
        if (r31 != null) goto L188;
    L173:
        r49 = null;
        goto L174
    L111:
        if ((r44 instanceof Integer) == true) goto L113;
        Object r50 = null;
    L114:
        r45 = (Integer) r50;     // Catch: Throwable -> L156
        if (r45 != null) goto L154;
        if ((r44 instanceof Number) == false) goto L141;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L126;
        Float r51 = Float.valueOf(((Number) r44).floatValue());     // Catch: Throwable -> L156
        if ((r51 instanceof Integer) == true) goto L124;
        r51 = null;
    L124:
        r45 = (Integer) r51;     // Catch: Throwable -> L156
        goto L154
    L126:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L132;
        Double r52 = Double.valueOf(((Number) r44).doubleValue());     // Catch: Throwable -> L156
        if ((r52 instanceof Integer) == true) goto L130;
        r52 = null;
    L130:
        r45 = (Integer) r52;     // Catch: Throwable -> L156
        goto L154
    L132:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L135;
        r45 = Integer.valueOf(((Number) r44).intValue());     // Catch: Throwable -> L156
        goto L154
    L135:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L141;
        Long r53 = Long.valueOf(((Number) r44).longValue());     // Catch: Throwable -> L156
        if ((r53 instanceof Integer) == true) goto L139;
        r53 = null;
    L139:
        r45 = (Integer) r53;     // Catch: Throwable -> L156
    L141:
        if ((r44 instanceof JSONObject) == false) goto L143;
    L208:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L149
        Object r54 = SDKSettingsCacheManager.a().fromJson(r44.toString(), Integer.class);     // Catch: Throwable -> L149
        if ((r54 instanceof Integer) == true) goto L147;
        r54 = null;
    L147:
        Object r55 = Result.constructor-impl((Integer) r54);     // Catch: Throwable -> L149
    L151:
        r45 = r55;
        if (Result.isFailure-impl(r45) == false) goto L154;
    L149:
        th = move-exception;
        Result.Companion r56 = Result.Companion;     // Catch: Throwable -> L156
        r55 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L156
        goto L151
    L143:
        if ((r44 instanceof JSONArray) == false) goto L153;
    L113:
        r50 = r44;
        goto L114
    L156:
        th = move-exception;
        Result.Companion r57 = Result.Companion;     // Catch: Throwable -> L181
        r46 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L181
    L181:
        th = move-exception;
        Result.Companion r58 = Result.Companion;
        r31 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r59 = Result.exceptionOrNull-impl(r31);
        if (r59 == null) goto L186;
        EnsureManager.ensureNotReachHere(r59);
    L186:
        if (Result.isFailure-impl(r31) == false) goto L188;
    L195:
        r15 = false;
        goto L196
    L12:
        if (r16.length() == 0) goto L15;
        r17 = false;
        goto L16
    L193:
        if (Intrinsics.areEqual(r14, Boolean.FALSE) == false) goto L195;
    L199:
        return r1;
    L219:
        return null;
    }

    public static final <T extends z> p<T> b(r<T> r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$map");
        HashMap r0 = new HashMap();
        if (r10.c() == null) goto L34;
        Iterator<y<T>> r1 = r10.c().iterator();
    L6:
        if (r1.hasNext() == false) goto L34;
        y<T> r11 = r1.next();
        List<String> r12 = r11.b();
        if (r12 != null) goto L13;
        String r13 = r11.a();
        if (r13 == null) goto L12;
        r12 = CollectionsKt.listOf(r13);
        goto L13
    L12:
        r12 = null;
    L13:
        if (r12 != null) goto L15;
        r12 = CollectionsKt.emptyList();
    L15:
        Iterator<String> r14 = r12.iterator();
    L17:
        if (r14.hasNext() == false) goto L6;
        String r15 = r14.next();
        List<T> r16 = r11.c();
        if (r16 == null) goto L21;
        List r17 = a(r16);
    L22:
        if (r17 == null) goto L17;
        List r18 = (List) r0.get(r15);
        if (r18 != null) goto L26;
    L29:
        boolean r19 = true;
    L30:
        if (r19 == true) goto L31;
        r0.put(r15, CollectionsKt.plus(r18, r17));
        goto L17
    L31:
        r0.put(r15, r17);
        goto L17
    L26:
        if (r18.isEmpty() == true) goto L29;
        r19 = false;
        goto L30
    L21:
        r17 = null;
    L34:
        return new p(r0, a(r10.b()), a(r10.a()));
    }
}
