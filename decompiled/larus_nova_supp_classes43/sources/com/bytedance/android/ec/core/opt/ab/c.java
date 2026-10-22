package com.bytedance.android.ec.core.opt.ab;

import com.bytedance.android.ec.ab.opt.HostExperimentKey;
import com.bytedance.android.ec.ab.opt.OptSetting;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.hybrid.hostapi.IECHybridKevaService;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.dataplatform.config.SettingPanel;
import com.bytedance.services.apm.api.EnsureManager;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@OptSetting(business = "大佬们，拆分出去吧，特别是交易的人！！！诶...")
public final class c {
    public static final /* synthetic */ int a = 0;

    @HostExperimentKey
    public static final int a() {
        int r0 = m.a;
        Object r1 = 0;
        boolean r10 = ECServiceManager.a;
        s83.g r11 = (s83.g) ECServiceManager.c(s83.g.class);
        if (r11 == null) goto L8;
        s83.a r12 = r11.q();
        if (r12 == null) goto L8;
        Object r13 = r12.e("ec_anim_delay");
        if (r13 == null) goto L8;
    L175:
        return ((Number) r13).intValue();
    L8:
        int r14 = n.a;
        int r15 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L165
        Object r17 = null;
        Object r18 = com.bytedance.android.ec.base.settings.d.c.get("ec_anim_delay");     // Catch: Throwable -> L60
        if (r18 != null) goto L15;
    L57:
        Object r19 = null;
    L58:
        Object r20 = Result.constructor-impl(r19);     // Catch: Throwable -> L60
    L62:
        Throwable r21 = Result.exceptionOrNull-impl(r20);     // Catch: Throwable -> L165
        if (r21 == null) goto L66;
        EnsureManager.ensureNotReachHere(r21);     // Catch: Throwable -> L165
    L66:
        if (Result.isFailure-impl(r20) == false) goto L69;
        r20 = null;
    L69:
        if ((r20 instanceof Integer) == true) goto L71;
        r20 = null;
    L71:
        Integer r22 = (Integer) r20;     // Catch: Throwable -> L165
        if (r22 != null) goto L78;
        Object r23 = com.bytedance.android.ec.base.settings.d.a.get("ec_anim_delay");     // Catch: Throwable -> L165
        if ((r23 instanceof Integer) == true) goto L77;
        r23 = null;
    L77:
        r22 = (Integer) r23;     // Catch: Throwable -> L165
    L78:
        if (r22 == null) goto L80;
        r13 = r22;
        goto L175
    L80:
        int r24 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L165
        Object r25 = com.bytedance.android.ec.base.settings.d.c.get("ec_anim_delay");     // Catch: Throwable -> L130
        if (r25 != null) goto L85;
    L127:
        Object r26 = null;
    L128:
        Object r27 = Result.constructor-impl(r26);     // Catch: Throwable -> L130
    L132:
        Throwable r28 = Result.exceptionOrNull-impl(r27);     // Catch: Throwable -> L156
        if (r28 == null) goto L136;
        EnsureManager.ensureNotReachHere(r28);     // Catch: Throwable -> L156
    L136:
        if (Result.isFailure-impl(r27) == false) goto L139;
        r27 = null;
    L139:
        if ((r27 instanceof Integer) == true) goto L141;
        r27 = null;
    L141:
        Integer r29 = (Integer) r27;     // Catch: Throwable -> L156
        if (r29 == null) goto L144;
        r13 = r29;
    L163:
        com.bytedance.android.ec.base.settings.d.d("ec_anim_delay", r13);     // Catch: Throwable -> L165
        goto L175
    L144:
        IHybridHostService r30 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L156
        if (r30 == null) goto L147;
        Object r31 = r30.getHostABValue("ec_anim_delay", r1);     // Catch: Throwable -> L156
    L148:
        if (r31 != null) goto L150;
    L162:
        r13 = r1;
        goto L163
    L150:
        if ((r31 instanceof Integer) == false) goto L153;
        r17 = r31;
    L153:
        r13 = (Integer) r17;     // Catch: Throwable -> L156
        if (r13 != null) goto L163;
    L147:
        r31 = null;
        goto L148
    L85:
        if ((r25 instanceof Integer) == true) goto L87;
        Object r32 = null;
    L88:
        r26 = (Integer) r32;     // Catch: Throwable -> L130
        if (r26 != null) goto L128;
        if ((r25 instanceof Number) == false) goto L115;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L100;
        Float r33 = Float.valueOf(((Number) r25).floatValue());     // Catch: Throwable -> L130
        if ((r33 instanceof Integer) == true) goto L98;
        r33 = null;
    L98:
        r26 = (Integer) r33;     // Catch: Throwable -> L130
        goto L128
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L106;
        Double r34 = Double.valueOf(((Number) r25).doubleValue());     // Catch: Throwable -> L130
        if ((r34 instanceof Integer) == true) goto L104;
        r34 = null;
    L104:
        r26 = (Integer) r34;     // Catch: Throwable -> L130
        goto L128
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L109;
        r26 = Integer.valueOf(((Number) r25).intValue());     // Catch: Throwable -> L130
        goto L128
    L109:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L115;
        Long r35 = Long.valueOf(((Number) r25).longValue());     // Catch: Throwable -> L130
        if ((r35 instanceof Integer) == true) goto L113;
        r35 = null;
    L113:
        r26 = (Integer) r35;     // Catch: Throwable -> L130
    L115:
        if ((r25 instanceof JSONObject) == false) goto L117;
    L183:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L123
        Object r36 = SDKSettingsCacheManager.a().fromJson(r25.toString(), Integer.class);     // Catch: Throwable -> L123
        if ((r36 instanceof Integer) == true) goto L121;
        r36 = null;
    L121:
        Object r37 = Result.constructor-impl((Integer) r36);     // Catch: Throwable -> L123
    L125:
        r26 = r37;
        if (Result.isFailure-impl(r26) == false) goto L128;
    L123:
        th = move-exception;
        Result.Companion r38 = Result.Companion;     // Catch: Throwable -> L130
        r37 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L130
        goto L125
    L117:
        if ((r25 instanceof JSONArray) == false) goto L127;
    L87:
        r32 = r25;
    L156:
        th = move-exception;
        Result.Companion r39 = Result.Companion;     // Catch: Throwable -> L165
        r13 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L165
        Throwable r40 = Result.exceptionOrNull-impl(r13);     // Catch: Throwable -> L165
        if (r40 == null) goto L161;
        EnsureManager.ensureNotReachHere(r40);     // Catch: Throwable -> L165
    L161:
        if (Result.isFailure-impl(r13) == false) goto L163;
    L130:
        th = move-exception;
        Result.Companion r41 = Result.Companion;     // Catch: Throwable -> L156
        r27 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L156
        goto L132
    L15:
        if ((r18 instanceof Integer) == true) goto L17;
        Object r42 = null;
    L18:
        r19 = (Integer) r42;     // Catch: Throwable -> L60
        if (r19 != null) goto L58;
        if ((r18 instanceof Number) == false) goto L45;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L30;
        Float r43 = Float.valueOf(((Number) r18).floatValue());     // Catch: Throwable -> L60
        if ((r43 instanceof Integer) == true) goto L28;
        r43 = null;
    L28:
        r19 = (Integer) r43;     // Catch: Throwable -> L60
        goto L58
    L30:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L36;
        Double r44 = Double.valueOf(((Number) r18).doubleValue());     // Catch: Throwable -> L60
        if ((r44 instanceof Integer) == true) goto L34;
        r44 = null;
    L34:
        r19 = (Integer) r44;     // Catch: Throwable -> L60
        goto L58
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L39;
        r19 = Integer.valueOf(((Number) r18).intValue());     // Catch: Throwable -> L60
        goto L58
    L39:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L45;
        Long r45 = Long.valueOf(((Number) r18).longValue());     // Catch: Throwable -> L60
        if ((r45 instanceof Integer) == true) goto L43;
        r45 = null;
    L43:
        r19 = (Integer) r45;     // Catch: Throwable -> L60
    L45:
        if ((r18 instanceof JSONObject) == false) goto L47;
    L181:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L53
        Object r46 = SDKSettingsCacheManager.a().fromJson(r18.toString(), Integer.class);     // Catch: Throwable -> L53
        if ((r46 instanceof Integer) == true) goto L51;
        r46 = null;
    L51:
        Object r47 = Result.constructor-impl((Integer) r46);     // Catch: Throwable -> L53
    L55:
        r19 = r47;
        if (Result.isFailure-impl(r19) == false) goto L58;
    L53:
        th = move-exception;
        Result.Companion r48 = Result.Companion;     // Catch: Throwable -> L60
        r47 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L60
        goto L55
    L47:
        if ((r18 instanceof JSONArray) == false) goto L57;
    L17:
        r42 = r18;
    L60:
        th = move-exception;
        Result.Companion r49 = Result.Companion;     // Catch: Throwable -> L165
        r20 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L165
    L165:
        th = move-exception;
        Result.Companion r50 = Result.Companion;
        Object r51 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r52 = Result.exceptionOrNull-impl(r51);
        if (r52 == null) goto L170;
        EnsureManager.ensureNotReachHere(r52);
    L170:
        if (Result.isFailure-impl(r51) == true) goto L173;
        r1 = r51;
    L173:
        r13 = r1;
        goto L175
    }

    @HostExperimentKey
    public static final boolean b() {
        int r0 = m.a;
        Object r1 = 0;
        boolean r10 = ECServiceManager.a;
        s83.g r11 = (s83.g) ECServiceManager.c(s83.g.class);
        if (r11 == null) goto L8;
        s83.a r12 = r11.q();
        if (r12 == null) goto L8;
        Object r13 = r12.e("ec_half_detail_query_entry_show");
        if (r13 == null) goto L8;
    L175:
        if (((Number) r13).intValue() != 1) goto L189;
        return true;
    L189:
        return false;
    L8:
        int r14 = n.a;
        int r15 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L165
        Object r17 = null;
        Object r18 = com.bytedance.android.ec.base.settings.d.c.get("ec_half_detail_query_entry_show");     // Catch: Throwable -> L60
        if (r18 != null) goto L15;
    L57:
        Object r19 = null;
    L58:
        Object r20 = Result.constructor-impl(r19);     // Catch: Throwable -> L60
    L62:
        Throwable r21 = Result.exceptionOrNull-impl(r20);     // Catch: Throwable -> L165
        if (r21 == null) goto L66;
        EnsureManager.ensureNotReachHere(r21);     // Catch: Throwable -> L165
    L66:
        if (Result.isFailure-impl(r20) == false) goto L69;
        r20 = null;
    L69:
        if ((r20 instanceof Integer) == true) goto L71;
        r20 = null;
    L71:
        Integer r22 = (Integer) r20;     // Catch: Throwable -> L165
        if (r22 != null) goto L78;
        Object r23 = com.bytedance.android.ec.base.settings.d.a.get("ec_half_detail_query_entry_show");     // Catch: Throwable -> L165
        if ((r23 instanceof Integer) == true) goto L77;
        r23 = null;
    L77:
        r22 = (Integer) r23;     // Catch: Throwable -> L165
    L78:
        if (r22 == null) goto L80;
        r13 = r22;
        goto L175
    L80:
        int r24 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L165
        Object r25 = com.bytedance.android.ec.base.settings.d.c.get("ec_half_detail_query_entry_show");     // Catch: Throwable -> L130
        if (r25 != null) goto L85;
    L127:
        Object r26 = null;
    L128:
        Object r27 = Result.constructor-impl(r26);     // Catch: Throwable -> L130
    L132:
        Throwable r28 = Result.exceptionOrNull-impl(r27);     // Catch: Throwable -> L156
        if (r28 == null) goto L136;
        EnsureManager.ensureNotReachHere(r28);     // Catch: Throwable -> L156
    L136:
        if (Result.isFailure-impl(r27) == false) goto L139;
        r27 = null;
    L139:
        if ((r27 instanceof Integer) == true) goto L141;
        r27 = null;
    L141:
        Integer r29 = (Integer) r27;     // Catch: Throwable -> L156
        if (r29 == null) goto L144;
        r13 = r29;
    L163:
        com.bytedance.android.ec.base.settings.d.d("ec_half_detail_query_entry_show", r13);     // Catch: Throwable -> L165
        goto L175
    L144:
        IHybridHostService r30 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L156
        if (r30 == null) goto L147;
        Object r31 = r30.getHostABValue("ec_half_detail_query_entry_show", r1);     // Catch: Throwable -> L156
    L148:
        if (r31 != null) goto L150;
    L162:
        r13 = r1;
        goto L163
    L150:
        if ((r31 instanceof Integer) == false) goto L153;
        r17 = r31;
    L153:
        r13 = (Integer) r17;     // Catch: Throwable -> L156
        if (r13 != null) goto L163;
    L147:
        r31 = null;
        goto L148
    L85:
        if ((r25 instanceof Integer) == true) goto L87;
        Object r32 = null;
    L88:
        r26 = (Integer) r32;     // Catch: Throwable -> L130
        if (r26 != null) goto L128;
        if ((r25 instanceof Number) == false) goto L115;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L100;
        Float r33 = Float.valueOf(((Number) r25).floatValue());     // Catch: Throwable -> L130
        if ((r33 instanceof Integer) == true) goto L98;
        r33 = null;
    L98:
        r26 = (Integer) r33;     // Catch: Throwable -> L130
        goto L128
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L106;
        Double r34 = Double.valueOf(((Number) r25).doubleValue());     // Catch: Throwable -> L130
        if ((r34 instanceof Integer) == true) goto L104;
        r34 = null;
    L104:
        r26 = (Integer) r34;     // Catch: Throwable -> L130
        goto L128
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L109;
        r26 = Integer.valueOf(((Number) r25).intValue());     // Catch: Throwable -> L130
        goto L128
    L109:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L115;
        Long r35 = Long.valueOf(((Number) r25).longValue());     // Catch: Throwable -> L130
        if ((r35 instanceof Integer) == true) goto L113;
        r35 = null;
    L113:
        r26 = (Integer) r35;     // Catch: Throwable -> L130
    L115:
        if ((r25 instanceof JSONObject) == false) goto L117;
    L185:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L123
        Object r36 = SDKSettingsCacheManager.a().fromJson(r25.toString(), Integer.class);     // Catch: Throwable -> L123
        if ((r36 instanceof Integer) == true) goto L121;
        r36 = null;
    L121:
        Object r37 = Result.constructor-impl((Integer) r36);     // Catch: Throwable -> L123
    L125:
        r26 = r37;
        if (Result.isFailure-impl(r26) == false) goto L128;
    L123:
        th = move-exception;
        Result.Companion r38 = Result.Companion;     // Catch: Throwable -> L130
        r37 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L130
        goto L125
    L117:
        if ((r25 instanceof JSONArray) == false) goto L127;
    L87:
        r32 = r25;
    L156:
        th = move-exception;
        Result.Companion r39 = Result.Companion;     // Catch: Throwable -> L165
        r13 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L165
        Throwable r40 = Result.exceptionOrNull-impl(r13);     // Catch: Throwable -> L165
        if (r40 == null) goto L161;
        EnsureManager.ensureNotReachHere(r40);     // Catch: Throwable -> L165
    L161:
        if (Result.isFailure-impl(r13) == false) goto L163;
    L130:
        th = move-exception;
        Result.Companion r41 = Result.Companion;     // Catch: Throwable -> L156
        r27 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L156
        goto L132
    L15:
        if ((r18 instanceof Integer) == true) goto L17;
        Object r42 = null;
    L18:
        r19 = (Integer) r42;     // Catch: Throwable -> L60
        if (r19 != null) goto L58;
        if ((r18 instanceof Number) == false) goto L45;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L30;
        Float r43 = Float.valueOf(((Number) r18).floatValue());     // Catch: Throwable -> L60
        if ((r43 instanceof Integer) == true) goto L28;
        r43 = null;
    L28:
        r19 = (Integer) r43;     // Catch: Throwable -> L60
        goto L58
    L30:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L36;
        Double r44 = Double.valueOf(((Number) r18).doubleValue());     // Catch: Throwable -> L60
        if ((r44 instanceof Integer) == true) goto L34;
        r44 = null;
    L34:
        r19 = (Integer) r44;     // Catch: Throwable -> L60
        goto L58
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L39;
        r19 = Integer.valueOf(((Number) r18).intValue());     // Catch: Throwable -> L60
        goto L58
    L39:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L45;
        Long r45 = Long.valueOf(((Number) r18).longValue());     // Catch: Throwable -> L60
        if ((r45 instanceof Integer) == true) goto L43;
        r45 = null;
    L43:
        r19 = (Integer) r45;     // Catch: Throwable -> L60
    L45:
        if ((r18 instanceof JSONObject) == false) goto L47;
    L183:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L53
        Object r46 = SDKSettingsCacheManager.a().fromJson(r18.toString(), Integer.class);     // Catch: Throwable -> L53
        if ((r46 instanceof Integer) == true) goto L51;
        r46 = null;
    L51:
        Object r47 = Result.constructor-impl((Integer) r46);     // Catch: Throwable -> L53
    L55:
        r19 = r47;
        if (Result.isFailure-impl(r19) == false) goto L58;
    L53:
        th = move-exception;
        Result.Companion r48 = Result.Companion;     // Catch: Throwable -> L60
        r47 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L60
        goto L55
    L47:
        if ((r18 instanceof JSONArray) == false) goto L57;
    L17:
        r42 = r18;
    L60:
        th = move-exception;
        Result.Companion r49 = Result.Companion;     // Catch: Throwable -> L165
        r20 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L165
    L165:
        th = move-exception;
        Result.Companion r50 = Result.Companion;
        Object r51 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r52 = Result.exceptionOrNull-impl(r51);
        if (r52 == null) goto L170;
        EnsureManager.ensureNotReachHere(r52);
    L170:
        if (Result.isFailure-impl(r51) == true) goto L173;
        r1 = r51;
    L173:
        r13 = r1;
        goto L175
    }

    public static final int c() {
        int r0 = n.a;
        Object r1 = 0;
        int r10 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L160
        Object r12 = null;
        Object r13 = com.bytedance.android.ec.base.settings.d.c.get("iesec_ad_popup");     // Catch: Throwable -> L54
        if (r13 != null) goto L9;
    L51:
        Object r14 = null;
    L52:
        Object r15 = Result.constructor-impl(r14);     // Catch: Throwable -> L54
    L56:
        Throwable r16 = Result.exceptionOrNull-impl(r15);     // Catch: Throwable -> L160
        if (r16 == null) goto L60;
        EnsureManager.ensureNotReachHere(r16);     // Catch: Throwable -> L160
    L60:
        if (Result.isFailure-impl(r15) == false) goto L63;
        r15 = null;
    L63:
        if ((r15 instanceof Integer) == true) goto L65;
        r15 = null;
    L65:
        Object r17 = (Integer) r15;     // Catch: Throwable -> L160
        if (r17 != null) goto L72;
        Object r18 = com.bytedance.android.ec.base.settings.d.a.get("iesec_ad_popup");     // Catch: Throwable -> L160
        if ((r18 instanceof Integer) == true) goto L71;
        r18 = null;
    L71:
        r17 = (Integer) r18;     // Catch: Throwable -> L160
    L72:
        if (r17 != null) goto L170;
        int r19 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L160
        Object r20 = com.bytedance.android.ec.base.settings.d.c.get("iesec_ad_popup");     // Catch: Throwable -> L124
        if (r20 != null) goto L79;
    L121:
        Object r21 = null;
    L122:
        Object r22 = Result.constructor-impl(r21);     // Catch: Throwable -> L124
    L126:
        Throwable r23 = Result.exceptionOrNull-impl(r22);     // Catch: Throwable -> L150
        if (r23 == null) goto L130;
        EnsureManager.ensureNotReachHere(r23);     // Catch: Throwable -> L150
    L130:
        if (Result.isFailure-impl(r22) == false) goto L133;
        r22 = null;
    L133:
        if ((r22 instanceof Integer) == true) goto L135;
        r22 = null;
    L135:
        r17 = (Integer) r22;     // Catch: Throwable -> L150
        if (r17 != null) goto L158;
        IHybridHostService r24 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L150
        if (r24 == null) goto L141;
        Object r25 = r24.getHostABValue("iesec_ad_popup", r1);     // Catch: Throwable -> L150
    L142:
        if (r25 != null) goto L144;
    L149:
        r17 = r1;
        goto L158
    L144:
        if ((r25 instanceof Integer) == false) goto L147;
        r12 = r25;
    L147:
        Object r26 = (Integer) r12;     // Catch: Throwable -> L150
        if (r26 == null) goto L149;
    L157:
        r17 = r26;
        goto L158
    L141:
        r25 = null;
    L158:
        com.bytedance.android.ec.base.settings.d.d("iesec_ad_popup", r17);     // Catch: Throwable -> L160
        goto L170
    L79:
        if ((r20 instanceof Integer) == true) goto L81;
        Object r27 = null;
    L82:
        r21 = (Integer) r27;     // Catch: Throwable -> L124
        if (r21 != null) goto L122;
        if ((r20 instanceof Number) == false) goto L109;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L94;
        Float r28 = Float.valueOf(((Number) r20).floatValue());     // Catch: Throwable -> L124
        if ((r28 instanceof Integer) == true) goto L92;
        r28 = null;
    L92:
        r21 = (Integer) r28;     // Catch: Throwable -> L124
        goto L122
    L94:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L100;
        Double r29 = Double.valueOf(((Number) r20).doubleValue());     // Catch: Throwable -> L124
        if ((r29 instanceof Integer) == true) goto L98;
        r29 = null;
    L98:
        r21 = (Integer) r29;     // Catch: Throwable -> L124
        goto L122
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L103;
        r21 = Integer.valueOf(((Number) r20).intValue());     // Catch: Throwable -> L124
        goto L122
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L109;
        Long r30 = Long.valueOf(((Number) r20).longValue());     // Catch: Throwable -> L124
        if ((r30 instanceof Integer) == true) goto L107;
        r30 = null;
    L107:
        r21 = (Integer) r30;     // Catch: Throwable -> L124
    L109:
        if ((r20 instanceof JSONObject) == false) goto L111;
    L180:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L117
        Object r31 = SDKSettingsCacheManager.a().fromJson(r20.toString(), Integer.class);     // Catch: Throwable -> L117
        if ((r31 instanceof Integer) == true) goto L115;
        r31 = null;
    L115:
        Object r32 = Result.constructor-impl((Integer) r31);     // Catch: Throwable -> L117
    L119:
        r21 = r32;
        if (Result.isFailure-impl(r21) == false) goto L122;
    L117:
        th = move-exception;
        Result.Companion r33 = Result.Companion;     // Catch: Throwable -> L124
        r32 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L124
        goto L119
    L111:
        if ((r20 instanceof JSONArray) == false) goto L121;
    L81:
        r27 = r20;
    L150:
        th = move-exception;
        Result.Companion r34 = Result.Companion;     // Catch: Throwable -> L160
        r26 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L160
        Throwable r35 = Result.exceptionOrNull-impl(r26);     // Catch: Throwable -> L160
        if (r35 == null) goto L155;
        EnsureManager.ensureNotReachHere(r35);     // Catch: Throwable -> L160
    L155:
        if (Result.isFailure-impl(r26) == false) goto L157;
        r26 = r1;
    L124:
        th = move-exception;
        Result.Companion r36 = Result.Companion;     // Catch: Throwable -> L150
        r22 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L150
    L170:
        return ((Number) r17).intValue();
    L9:
        if ((r13 instanceof Integer) == true) goto L11;
        Object r37 = null;
    L12:
        r14 = (Integer) r37;     // Catch: Throwable -> L54
        if (r14 != null) goto L52;
        if ((r13 instanceof Number) == false) goto L39;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L24;
        Float r38 = Float.valueOf(((Number) r13).floatValue());     // Catch: Throwable -> L54
        if ((r38 instanceof Integer) == true) goto L22;
        r38 = null;
    L22:
        r14 = (Integer) r38;     // Catch: Throwable -> L54
        goto L52
    L24:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L30;
        Double r39 = Double.valueOf(((Number) r13).doubleValue());     // Catch: Throwable -> L54
        if ((r39 instanceof Integer) == true) goto L28;
        r39 = null;
    L28:
        r14 = (Integer) r39;     // Catch: Throwable -> L54
        goto L52
    L30:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L33;
        r14 = Integer.valueOf(((Number) r13).intValue());     // Catch: Throwable -> L54
        goto L52
    L33:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L39;
        Long r40 = Long.valueOf(((Number) r13).longValue());     // Catch: Throwable -> L54
        if ((r40 instanceof Integer) == true) goto L37;
        r40 = null;
    L37:
        r14 = (Integer) r40;     // Catch: Throwable -> L54
    L39:
        if ((r13 instanceof JSONObject) == false) goto L41;
    L178:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L47
        Object r41 = SDKSettingsCacheManager.a().fromJson(r13.toString(), Integer.class);     // Catch: Throwable -> L47
        if ((r41 instanceof Integer) == true) goto L45;
        r41 = null;
    L45:
        Object r42 = Result.constructor-impl((Integer) r41);     // Catch: Throwable -> L47
    L49:
        r14 = r42;
        if (Result.isFailure-impl(r14) == false) goto L52;
    L47:
        th = move-exception;
        Result.Companion r43 = Result.Companion;     // Catch: Throwable -> L54
        r42 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L54
        goto L49
    L41:
        if ((r13 instanceof JSONArray) == false) goto L51;
    L11:
        r37 = r13;
    L54:
        th = move-exception;
        Result.Companion r44 = Result.Companion;     // Catch: Throwable -> L160
        r15 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L160
    L160:
        th = move-exception;
        Result.Companion r45 = Result.Companion;
        Object r46 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r47 = Result.exceptionOrNull-impl(r46);
        if (r47 == null) goto L165;
        EnsureManager.ensureNotReachHere(r47);
    L165:
        if (Result.isFailure-impl(r46) == true) goto L168;
        r1 = r46;
    L168:
        r17 = r1;
        goto L170
    }

    @SettingPanel("商详顶部测评视频交互优化-已固化")
    public static final boolean d() {
        int r0 = com.bytedance.android.ec.base.settings.b.a;
        int r1 = com.bytedance.android.ec.core.abtest.e.a;
        Object r10 = com.bytedance.android.ec.core.abtest.e.a(1, 0);
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L166
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L166
        SDKSettingsCacheManager r12 = SDKSettingsCacheManager.e;     // Catch: Throwable -> L166
        Object r13 = null;
        r12.getClass();     // Catch: Throwable -> L56
        Object r14 = SDKSettingsCacheManager.b.get("iesec_kol_video_evaluation_detail");     // Catch: Throwable -> L56
        if (r14 != null) goto L11;
    L53:
        Object r15 = null;
    L54:
        Object r16 = Result.constructor-impl(r15);     // Catch: Throwable -> L56
    L58:
        Throwable r17 = Result.exceptionOrNull-impl(r16);     // Catch: Throwable -> L166
        if (r17 == null) goto L62;
        EnsureManager.ensureNotReachHere(r17);     // Catch: Throwable -> L166
    L62:
        if (Result.isFailure-impl(r16) == false) goto L65;
        r16 = null;
    L65:
        if ((r16 instanceof Integer) == true) goto L67;
        r16 = null;
    L67:
        Object r18 = (Integer) r16;     // Catch: Throwable -> L166
        if (r18 != null) goto L74;
        r12.getClass();     // Catch: Throwable -> L166
        Object r19 = SDKSettingsCacheManager.a.get("iesec_kol_video_evaluation_detail");     // Catch: Throwable -> L166
        if ((r19 instanceof Integer) == true) goto L73;
        r19 = null;
    L73:
        r18 = (Integer) r19;     // Catch: Throwable -> L166
    L74:
        if (r18 != null) goto L176;
        int r20 = com.bytedance.android.ec.base.settings.g.a;     // Catch: Throwable -> L166
    L153:
        th = move-exception;
        Result.Companion r21 = Result.Companion;     // Catch: Throwable -> L166
        Object r22 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
    L156:
        if (Result.exceptionOrNull-impl(r22) != null) goto L188;
    L163:
        r18 = r22;
    L164:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L166
        SDKSettingsCacheManager.e("iesec_kol_video_evaluation_detail", r18);     // Catch: Throwable -> L166
        goto L176
    L188:
        r22 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("iesec_kol_video_evaluation_detail", Integer.class, r10);     // Catch: Throwable -> L160
    L161:
        if (r22 != null) goto L163;
        r18 = r10;
    L160:
        r22 = r10;
        goto L161
    L182:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L127
        Object r23 = SDKSettingsCacheManager.b.get("iesec_kol_video_evaluation_detail");     // Catch: Throwable -> L127
        if (r23 != null) goto L82;
    L124:
        Object r24 = null;
    L125:
        Object r25 = Result.constructor-impl(r24);     // Catch: Throwable -> L127
    L129:
        Throwable r26 = Result.exceptionOrNull-impl(r25);     // Catch: Throwable -> L153
        if (r26 == null) goto L133;
        EnsureManager.ensureNotReachHere(r26);     // Catch: Throwable -> L153
    L133:
        if (Result.isFailure-impl(r25) == false) goto L136;
        r25 = null;
    L136:
        if ((r25 instanceof Integer) == true) goto L138;
        r25 = null;
    L138:
        r22 = (Integer) r25;     // Catch: Throwable -> L153
        if (r22 != null) goto L163;
        jj4.b r27 = jj4.b.b;     // Catch: Throwable -> L153
        Object r28 = jj4.a.a("iesec_kol_video_evaluation_detail", Integer.class, r10, false);     // Catch: Throwable -> L153
        if (r28 != null) goto L145;
        Intrinsics.throwNpe();     // Catch: Throwable -> L153
    L145:
        if ((r28 instanceof Integer) == false) goto L148;
        r13 = r28;
    L148:
        Object r29 = (Integer) r13;     // Catch: Throwable -> L153
        if (r29 != null) goto L151;
        r29 = r10;
    L151:
        r22 = Result.constructor-impl(r29);     // Catch: Throwable -> L153
    L82:
        if ((r23 instanceof Integer) == true) goto L84;
        Object r30 = null;
    L85:
        r24 = (Integer) r30;     // Catch: Throwable -> L127
        if (r24 != null) goto L125;
        if ((r23 instanceof Number) == false) goto L112;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r31 = Float.valueOf(((Number) r23).floatValue());     // Catch: Throwable -> L127
        if ((r31 instanceof Integer) == true) goto L95;
        r31 = null;
    L95:
        r24 = (Integer) r31;     // Catch: Throwable -> L127
        goto L125
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r32 = Double.valueOf(((Number) r23).doubleValue());     // Catch: Throwable -> L127
        if ((r32 instanceof Integer) == true) goto L101;
        r32 = null;
    L101:
        r24 = (Integer) r32;     // Catch: Throwable -> L127
        goto L125
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L106;
        r24 = Integer.valueOf(((Number) r23).intValue());     // Catch: Throwable -> L127
        goto L125
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L112;
        Long r33 = Long.valueOf(((Number) r23).longValue());     // Catch: Throwable -> L127
        if ((r33 instanceof Integer) == true) goto L110;
        r33 = null;
    L110:
        r24 = (Integer) r33;     // Catch: Throwable -> L127
    L112:
        if ((r23 instanceof JSONObject) == false) goto L114;
    L192:
        Object r34 = SDKSettingsCacheManager.a().fromJson(r23.toString(), Integer.class);     // Catch: Throwable -> L120
        if ((r34 instanceof Integer) == true) goto L118;
        r34 = null;
    L118:
        Object r35 = Result.constructor-impl((Integer) r34);     // Catch: Throwable -> L120
    L122:
        r24 = r35;
        if (Result.isFailure-impl(r24) == false) goto L125;
    L120:
        th = move-exception;
        Result.Companion r36 = Result.Companion;     // Catch: Throwable -> L127
        r35 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L127
        goto L122
    L114:
        if ((r23 instanceof JSONArray) == false) goto L124;
    L84:
        r30 = r23;
    L127:
        th = move-exception;
        Result.Companion r37 = Result.Companion;     // Catch: Throwable -> L153
        r25 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L153
    L176:
        if (((Number) r18).intValue() == 1) goto L194;
        return false;
    L194:
        return true;
    L11:
        if ((r14 instanceof Integer) == true) goto L13;
        Object r38 = null;
    L14:
        r15 = (Integer) r38;     // Catch: Throwable -> L56
        if (r15 != null) goto L54;
        if ((r14 instanceof Number) == false) goto L41;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L26;
        Float r39 = Float.valueOf(((Number) r14).floatValue());     // Catch: Throwable -> L56
        if ((r39 instanceof Integer) == true) goto L24;
        r39 = null;
    L24:
        r15 = (Integer) r39;     // Catch: Throwable -> L56
        goto L54
    L26:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L32;
        Double r40 = Double.valueOf(((Number) r14).doubleValue());     // Catch: Throwable -> L56
        if ((r40 instanceof Integer) == true) goto L30;
        r40 = null;
    L30:
        r15 = (Integer) r40;     // Catch: Throwable -> L56
        goto L54
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L35;
        r15 = Integer.valueOf(((Number) r14).intValue());     // Catch: Throwable -> L56
        goto L54
    L35:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L41;
        Long r41 = Long.valueOf(((Number) r14).longValue());     // Catch: Throwable -> L56
        if ((r41 instanceof Integer) == true) goto L39;
        r41 = null;
    L39:
        r15 = (Integer) r41;     // Catch: Throwable -> L56
    L41:
        if ((r14 instanceof JSONObject) == false) goto L43;
    L186:
        Object r42 = SDKSettingsCacheManager.a().fromJson(r14.toString(), Integer.class);     // Catch: Throwable -> L49
        if ((r42 instanceof Integer) == true) goto L47;
        r42 = null;
    L47:
        Object r43 = Result.constructor-impl((Integer) r42);     // Catch: Throwable -> L49
    L51:
        r15 = r43;
        if (Result.isFailure-impl(r15) == false) goto L54;
    L49:
        th = move-exception;
        Result.Companion r44 = Result.Companion;     // Catch: Throwable -> L56
        r43 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L56
        goto L51
    L43:
        if ((r14 instanceof JSONArray) == false) goto L53;
    L13:
        r38 = r14;
    L56:
        th = move-exception;
        Result.Companion r45 = Result.Companion;     // Catch: Throwable -> L166
        r16 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
    L166:
        th = move-exception;
        Result.Companion r46 = Result.Companion;
        Object r47 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r48 = Result.exceptionOrNull-impl(r47);
        if (r48 == null) goto L171;
        EnsureManager.ensureNotReachHere(r48);
    L171:
        if (Result.isFailure-impl(r47) == true) goto L174;
        r10 = r47;
    L174:
        r18 = r10;
        goto L176
    }

    public static final boolean e() {
        int r0 = n.a;
        Object r1 = Boolean.FALSE;
        int r10 = com.bytedance.android.ec.base.settings.a.a;
        Object r11 = null;
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L163
        Object r13 = com.bytedance.android.ec.base.settings.d.c.get("detail_favorite_bff");     // Catch: Throwable -> L56
        if (r13 != null) goto L8;
    L53:
        Object r14 = null;
    L54:
        Object r15 = Result.constructor-impl(r14);     // Catch: Throwable -> L56
    L58:
        Throwable r16 = Result.exceptionOrNull-impl(r15);     // Catch: Throwable -> L163
        if (r16 == null) goto L62;
        EnsureManager.ensureNotReachHere(r16);     // Catch: Throwable -> L163
    L62:
        if (Result.isFailure-impl(r15) == false) goto L65;
        r15 = null;
    L65:
        if ((r15 instanceof Boolean) == true) goto L67;
        r15 = null;
    L67:
        Object r17 = (Boolean) r15;     // Catch: Throwable -> L163
        if (r17 != null) goto L74;
        Object r18 = com.bytedance.android.ec.base.settings.d.a.get("detail_favorite_bff");     // Catch: Throwable -> L163
        if ((r18 instanceof Boolean) == true) goto L73;
        r18 = null;
    L73:
        r17 = (Boolean) r18;     // Catch: Throwable -> L163
    L74:
        if (r17 != null) goto L173;
        int r19 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L163
        Object r20 = com.bytedance.android.ec.base.settings.d.c.get("detail_favorite_bff");     // Catch: Throwable -> L129
        if (r20 != null) goto L81;
    L126:
        Object r21 = null;
    L127:
        Object r22 = Result.constructor-impl(r21);     // Catch: Throwable -> L129
    L131:
        Throwable r23 = Result.exceptionOrNull-impl(r22);     // Catch: Throwable -> L154
        if (r23 == null) goto L135;
        EnsureManager.ensureNotReachHere(r23);     // Catch: Throwable -> L154
    L135:
        if (Result.isFailure-impl(r22) == false) goto L138;
        r22 = null;
    L138:
        if ((r22 instanceof Boolean) == true) goto L140;
        r22 = null;
    L140:
        r17 = (Boolean) r22;     // Catch: Throwable -> L154
        if (r17 != null) goto L161;
        IHybridHostService r24 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L154
        if (r24 == null) goto L146;
        Object r25 = r24.getHostABValue("detail_favorite_bff", r1);     // Catch: Throwable -> L154
    L147:
        if (r25 != null) goto L149;
    L160:
        r17 = r1;
        goto L161
    L149:
        if ((r25 instanceof Boolean) == true) goto L151;
        r25 = null;
    L151:
        r17 = (Boolean) r25;     // Catch: Throwable -> L154
        if (r17 != null) goto L161;
    L146:
        r25 = null;
    L161:
        com.bytedance.android.ec.base.settings.d.d("detail_favorite_bff", r17);     // Catch: Throwable -> L163
        goto L173
    L81:
        if ((r20 instanceof Boolean) == true) goto L83;
        Object r26 = null;
    L84:
        r21 = (Boolean) r26;     // Catch: Throwable -> L129
        if (r21 != null) goto L127;
        if ((r20 instanceof Number) == false) goto L114;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L96;
        Float r27 = Float.valueOf(((Number) r20).floatValue());     // Catch: Throwable -> L129
        if ((r27 instanceof Boolean) == true) goto L94;
        r27 = null;
    L94:
        r21 = (Boolean) r27;     // Catch: Throwable -> L129
        goto L127
    L96:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L102;
        Double r28 = Double.valueOf(((Number) r20).doubleValue());     // Catch: Throwable -> L129
        if ((r28 instanceof Boolean) == true) goto L100;
        r28 = null;
    L100:
        r21 = (Boolean) r28;     // Catch: Throwable -> L129
        goto L127
    L102:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L108;
        Integer r29 = Integer.valueOf(((Number) r20).intValue());     // Catch: Throwable -> L129
        if ((r29 instanceof Boolean) == true) goto L106;
        r29 = null;
    L106:
        r21 = (Boolean) r29;     // Catch: Throwable -> L129
        goto L127
    L108:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L114;
        Long r30 = Long.valueOf(((Number) r20).longValue());     // Catch: Throwable -> L129
        if ((r30 instanceof Boolean) == true) goto L112;
        r30 = null;
    L112:
        r21 = (Boolean) r30;     // Catch: Throwable -> L129
    L114:
        if ((r20 instanceof JSONObject) == false) goto L116;
    L365:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L122
        Object r31 = SDKSettingsCacheManager.a().fromJson(r20.toString(), Boolean.class);     // Catch: Throwable -> L122
        if ((r31 instanceof Boolean) == true) goto L120;
        r31 = null;
    L120:
        Object r32 = Result.constructor-impl((Boolean) r31);     // Catch: Throwable -> L122
    L124:
        r21 = r32;
        if (Result.isFailure-impl(r21) == false) goto L127;
    L122:
        th = move-exception;
        Result.Companion r33 = Result.Companion;     // Catch: Throwable -> L129
        r32 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L129
        goto L124
    L116:
        if ((r20 instanceof JSONArray) == false) goto L126;
    L83:
        r26 = r20;
    L154:
        th = move-exception;
        Result.Companion r34 = Result.Companion;     // Catch: Throwable -> L163
        r17 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
        Throwable r35 = Result.exceptionOrNull-impl(r17);     // Catch: Throwable -> L163
        if (r35 == null) goto L159;
        EnsureManager.ensureNotReachHere(r35);     // Catch: Throwable -> L163
    L159:
        if (Result.isFailure-impl(r17) == false) goto L161;
    L129:
        th = move-exception;
        Result.Companion r36 = Result.Companion;     // Catch: Throwable -> L154
        r22 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L154
    L173:
        if (((Boolean) r17).booleanValue() == true) goto L352;
        int r37 = com.bytedance.android.ec.base.settings.b.a;
        Object r38 = Boolean.FALSE;
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L341
        SDKSettingsCacheManager r39 = SDKSettingsCacheManager.e;     // Catch: Throwable -> L341
        r39.getClass();     // Catch: Throwable -> L228
        Object r40 = SDKSettingsCacheManager.b.get("detail_favorite_bff");     // Catch: Throwable -> L228
        if (r40 != null) goto L180;
    L225:
        Object r41 = null;
    L226:
        Object r42 = Result.constructor-impl(r41);     // Catch: Throwable -> L228
    L230:
        Throwable r43 = Result.exceptionOrNull-impl(r42);     // Catch: Throwable -> L341
        if (r43 == null) goto L234;
        EnsureManager.ensureNotReachHere(r43);     // Catch: Throwable -> L341
    L234:
        if (Result.isFailure-impl(r42) == false) goto L237;
        r42 = null;
    L237:
        if ((r42 instanceof Boolean) == true) goto L239;
        r42 = null;
    L239:
        Object r44 = (Boolean) r42;     // Catch: Throwable -> L341
        if (r44 != null) goto L246;
        r39.getClass();     // Catch: Throwable -> L341
        Object r45 = SDKSettingsCacheManager.a.get("detail_favorite_bff");     // Catch: Throwable -> L341
        if ((r45 instanceof Boolean) == true) goto L245;
        r45 = null;
    L245:
        r44 = (Boolean) r45;     // Catch: Throwable -> L341
    L246:
        if (r44 != null) goto L351;
        int r46 = com.bytedance.android.ec.base.settings.g.a;     // Catch: Throwable -> L341
    L328:
        th = move-exception;
        Result.Companion r47 = Result.Companion;     // Catch: Throwable -> L341
        Object r48 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L341
    L331:
        if (Result.exceptionOrNull-impl(r48) != null) goto L371;
    L338:
        r44 = r48;
    L339:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L341
        SDKSettingsCacheManager.e("detail_favorite_bff", r44);     // Catch: Throwable -> L341
        goto L351
    L371:
        r48 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("detail_favorite_bff", Boolean.class, r38);     // Catch: Throwable -> L335
    L336:
        if (r48 != null) goto L338;
        r44 = r38;
    L335:
        r48 = r38;
        goto L336
    L363:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L302
        Object r49 = SDKSettingsCacheManager.b.get("detail_favorite_bff");     // Catch: Throwable -> L302
        if (r49 != null) goto L254;
    L299:
        Object r50 = null;
    L300:
        Object r51 = Result.constructor-impl(r50);     // Catch: Throwable -> L302
    L304:
        Throwable r52 = Result.exceptionOrNull-impl(r51);     // Catch: Throwable -> L328
        if (r52 == null) goto L308;
        EnsureManager.ensureNotReachHere(r52);     // Catch: Throwable -> L328
    L308:
        if (Result.isFailure-impl(r51) == false) goto L311;
        r51 = null;
    L311:
        if ((r51 instanceof Boolean) == true) goto L313;
        r51 = null;
    L313:
        Boolean r53 = (Boolean) r51;     // Catch: Throwable -> L328
        if (r53 == null) goto L316;
        r44 = r53;
        goto L339
    L316:
        jj4.b r54 = jj4.b.b;     // Catch: Throwable -> L328
        Object r55 = jj4.a.a("detail_favorite_bff", Boolean.class, r38, false);     // Catch: Throwable -> L328
        if (r55 != null) goto L320;
        Intrinsics.throwNpe();     // Catch: Throwable -> L328
    L320:
        if ((r55 instanceof Boolean) == false) goto L323;
        r11 = r55;
    L323:
        Object r56 = (Boolean) r11;     // Catch: Throwable -> L328
        if (r56 != null) goto L326;
        r56 = r38;
    L326:
        r48 = Result.constructor-impl(r56);     // Catch: Throwable -> L328
    L254:
        if ((r49 instanceof Boolean) == true) goto L256;
        Object r57 = null;
    L257:
        r50 = (Boolean) r57;     // Catch: Throwable -> L302
        if (r50 != null) goto L300;
        if ((r49 instanceof Number) == false) goto L287;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L269;
        Float r58 = Float.valueOf(((Number) r49).floatValue());     // Catch: Throwable -> L302
        if ((r58 instanceof Boolean) == true) goto L267;
        r58 = null;
    L267:
        r50 = (Boolean) r58;     // Catch: Throwable -> L302
        goto L300
    L269:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L275;
        Double r59 = Double.valueOf(((Number) r49).doubleValue());     // Catch: Throwable -> L302
        if ((r59 instanceof Boolean) == true) goto L273;
        r59 = null;
    L273:
        r50 = (Boolean) r59;     // Catch: Throwable -> L302
        goto L300
    L275:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L281;
        Integer r60 = Integer.valueOf(((Number) r49).intValue());     // Catch: Throwable -> L302
        if ((r60 instanceof Boolean) == true) goto L279;
        r60 = null;
    L279:
        r50 = (Boolean) r60;     // Catch: Throwable -> L302
        goto L300
    L281:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L287;
        Long r61 = Long.valueOf(((Number) r49).longValue());     // Catch: Throwable -> L302
        if ((r61 instanceof Boolean) == true) goto L285;
        r61 = null;
    L285:
        r50 = (Boolean) r61;     // Catch: Throwable -> L302
    L287:
        if ((r49 instanceof JSONObject) == false) goto L289;
    L369:
        Object r62 = SDKSettingsCacheManager.a().fromJson(r49.toString(), Boolean.class);     // Catch: Throwable -> L295
        if ((r62 instanceof Boolean) == true) goto L293;
        r62 = null;
    L293:
        Object r63 = Result.constructor-impl((Boolean) r62);     // Catch: Throwable -> L295
    L297:
        r50 = r63;
        if (Result.isFailure-impl(r50) == false) goto L300;
    L295:
        th = move-exception;
        Result.Companion r64 = Result.Companion;     // Catch: Throwable -> L302
        r63 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L302
        goto L297
    L289:
        if ((r49 instanceof JSONArray) == false) goto L299;
    L256:
        r57 = r49;
    L302:
        th = move-exception;
        Result.Companion r65 = Result.Companion;     // Catch: Throwable -> L328
        r51 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L328
    L351:
        if (((Boolean) r44).booleanValue() == true) goto L352;
        return false;
    L180:
        if ((r40 instanceof Boolean) == true) goto L182;
        Object r66 = null;
    L183:
        r41 = (Boolean) r66;     // Catch: Throwable -> L228
        if (r41 != null) goto L226;
        if ((r40 instanceof Number) == false) goto L213;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L195;
        Float r67 = Float.valueOf(((Number) r40).floatValue());     // Catch: Throwable -> L228
        if ((r67 instanceof Boolean) == true) goto L193;
        r67 = null;
    L193:
        r41 = (Boolean) r67;     // Catch: Throwable -> L228
        goto L226
    L195:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L201;
        Double r68 = Double.valueOf(((Number) r40).doubleValue());     // Catch: Throwable -> L228
        if ((r68 instanceof Boolean) == true) goto L199;
        r68 = null;
    L199:
        r41 = (Boolean) r68;     // Catch: Throwable -> L228
        goto L226
    L201:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L207;
        Integer r69 = Integer.valueOf(((Number) r40).intValue());     // Catch: Throwable -> L228
        if ((r69 instanceof Boolean) == true) goto L205;
        r69 = null;
    L205:
        r41 = (Boolean) r69;     // Catch: Throwable -> L228
        goto L226
    L207:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L213;
        Long r70 = Long.valueOf(((Number) r40).longValue());     // Catch: Throwable -> L228
        if ((r70 instanceof Boolean) == true) goto L211;
        r70 = null;
    L211:
        r41 = (Boolean) r70;     // Catch: Throwable -> L228
    L213:
        if ((r40 instanceof JSONObject) == false) goto L215;
    L361:
        Object r71 = SDKSettingsCacheManager.a().fromJson(r40.toString(), Boolean.class);     // Catch: Throwable -> L221
        if ((r71 instanceof Boolean) == true) goto L219;
        r71 = null;
    L219:
        Object r72 = Result.constructor-impl((Boolean) r71);     // Catch: Throwable -> L221
    L223:
        r41 = r72;
        if (Result.isFailure-impl(r41) == false) goto L226;
    L221:
        th = move-exception;
        Result.Companion r73 = Result.Companion;     // Catch: Throwable -> L228
        r72 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L228
        goto L223
    L215:
        if ((r40 instanceof JSONArray) == false) goto L225;
    L182:
        r66 = r40;
    L228:
        th = move-exception;
        Result.Companion r74 = Result.Companion;     // Catch: Throwable -> L341
        r42 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L341
    L341:
        th = move-exception;
        Result.Companion r75 = Result.Companion;
        Object r76 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r77 = Result.exceptionOrNull-impl(r76);
        if (r77 == null) goto L346;
        EnsureManager.ensureNotReachHere(r77);
    L346:
        if (Result.isFailure-impl(r76) == true) goto L349;
        r38 = r76;
    L349:
        r44 = r38;
    L352:
        return true;
    L8:
        if ((r13 instanceof Boolean) == true) goto L10;
        Object r78 = null;
    L11:
        r14 = (Boolean) r78;     // Catch: Throwable -> L56
        if (r14 != null) goto L54;
        if ((r13 instanceof Number) == false) goto L41;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L23;
        Float r79 = Float.valueOf(((Number) r13).floatValue());     // Catch: Throwable -> L56
        if ((r79 instanceof Boolean) == true) goto L21;
        r79 = null;
    L21:
        r14 = (Boolean) r79;     // Catch: Throwable -> L56
        goto L54
    L23:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L29;
        Double r80 = Double.valueOf(((Number) r13).doubleValue());     // Catch: Throwable -> L56
        if ((r80 instanceof Boolean) == true) goto L27;
        r80 = null;
    L27:
        r14 = (Boolean) r80;     // Catch: Throwable -> L56
        goto L54
    L29:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L35;
        Integer r81 = Integer.valueOf(((Number) r13).intValue());     // Catch: Throwable -> L56
        if ((r81 instanceof Boolean) == true) goto L33;
        r81 = null;
    L33:
        r14 = (Boolean) r81;     // Catch: Throwable -> L56
        goto L54
    L35:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L41;
        Long r82 = Long.valueOf(((Number) r13).longValue());     // Catch: Throwable -> L56
        if ((r82 instanceof Boolean) == true) goto L39;
        r82 = null;
    L39:
        r14 = (Boolean) r82;     // Catch: Throwable -> L56
    L41:
        if ((r13 instanceof JSONObject) == false) goto L43;
    L358:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L49
        Object r83 = SDKSettingsCacheManager.a().fromJson(r13.toString(), Boolean.class);     // Catch: Throwable -> L49
        if ((r83 instanceof Boolean) == true) goto L47;
        r83 = null;
    L47:
        Object r84 = Result.constructor-impl((Boolean) r83);     // Catch: Throwable -> L49
    L51:
        r14 = r84;
        if (Result.isFailure-impl(r14) == false) goto L54;
    L49:
        th = move-exception;
        Result.Companion r85 = Result.Companion;     // Catch: Throwable -> L56
        r84 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L56
        goto L51
    L43:
        if ((r13 instanceof JSONArray) == false) goto L53;
    L10:
        r78 = r13;
    L56:
        th = move-exception;
        Result.Companion r86 = Result.Companion;     // Catch: Throwable -> L163
        r15 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L163
    L163:
        th = move-exception;
        Result.Companion r87 = Result.Companion;
        Object r88 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r89 = Result.exceptionOrNull-impl(r88);
        if (r89 == null) goto L168;
        EnsureManager.ensureNotReachHere(r89);
    L168:
        if (Result.isFailure-impl(r88) == true) goto L171;
        r1 = r88;
    L171:
        r17 = r1;
        goto L173
    }

    @HostExperimentKey
    public static final int f() {
        int r0 = n.a;
        Object r1 = 0;
        int r10 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L160
        Object r12 = null;
        Object r13 = com.bytedance.android.ec.base.settings.d.c.get("ec_video_performance_opt");     // Catch: Throwable -> L54
        if (r13 != null) goto L9;
    L51:
        Object r14 = null;
    L52:
        Object r15 = Result.constructor-impl(r14);     // Catch: Throwable -> L54
    L56:
        Throwable r16 = Result.exceptionOrNull-impl(r15);     // Catch: Throwable -> L160
        if (r16 == null) goto L60;
        EnsureManager.ensureNotReachHere(r16);     // Catch: Throwable -> L160
    L60:
        if (Result.isFailure-impl(r15) == false) goto L63;
        r15 = null;
    L63:
        if ((r15 instanceof Integer) == true) goto L65;
        r15 = null;
    L65:
        Object r17 = (Integer) r15;     // Catch: Throwable -> L160
        if (r17 != null) goto L72;
        Object r18 = com.bytedance.android.ec.base.settings.d.a.get("ec_video_performance_opt");     // Catch: Throwable -> L160
        if ((r18 instanceof Integer) == true) goto L71;
        r18 = null;
    L71:
        r17 = (Integer) r18;     // Catch: Throwable -> L160
    L72:
        if (r17 != null) goto L170;
        int r19 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L160
        Object r20 = com.bytedance.android.ec.base.settings.d.c.get("ec_video_performance_opt");     // Catch: Throwable -> L124
        if (r20 != null) goto L79;
    L121:
        Object r21 = null;
    L122:
        Object r22 = Result.constructor-impl(r21);     // Catch: Throwable -> L124
    L126:
        Throwable r23 = Result.exceptionOrNull-impl(r22);     // Catch: Throwable -> L150
        if (r23 == null) goto L130;
        EnsureManager.ensureNotReachHere(r23);     // Catch: Throwable -> L150
    L130:
        if (Result.isFailure-impl(r22) == false) goto L133;
        r22 = null;
    L133:
        if ((r22 instanceof Integer) == true) goto L135;
        r22 = null;
    L135:
        r17 = (Integer) r22;     // Catch: Throwable -> L150
        if (r17 != null) goto L158;
        IHybridHostService r24 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L150
        if (r24 == null) goto L141;
        Object r25 = r24.getHostABValue("ec_video_performance_opt", r1);     // Catch: Throwable -> L150
    L142:
        if (r25 != null) goto L144;
    L149:
        r17 = r1;
        goto L158
    L144:
        if ((r25 instanceof Integer) == false) goto L147;
        r12 = r25;
    L147:
        Object r26 = (Integer) r12;     // Catch: Throwable -> L150
        if (r26 == null) goto L149;
    L157:
        r17 = r26;
        goto L158
    L141:
        r25 = null;
    L158:
        com.bytedance.android.ec.base.settings.d.d("ec_video_performance_opt", r17);     // Catch: Throwable -> L160
        goto L170
    L79:
        if ((r20 instanceof Integer) == true) goto L81;
        Object r27 = null;
    L82:
        r21 = (Integer) r27;     // Catch: Throwable -> L124
        if (r21 != null) goto L122;
        if ((r20 instanceof Number) == false) goto L109;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L94;
        Float r28 = Float.valueOf(((Number) r20).floatValue());     // Catch: Throwable -> L124
        if ((r28 instanceof Integer) == true) goto L92;
        r28 = null;
    L92:
        r21 = (Integer) r28;     // Catch: Throwable -> L124
        goto L122
    L94:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L100;
        Double r29 = Double.valueOf(((Number) r20).doubleValue());     // Catch: Throwable -> L124
        if ((r29 instanceof Integer) == true) goto L98;
        r29 = null;
    L98:
        r21 = (Integer) r29;     // Catch: Throwable -> L124
        goto L122
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L103;
        r21 = Integer.valueOf(((Number) r20).intValue());     // Catch: Throwable -> L124
        goto L122
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L109;
        Long r30 = Long.valueOf(((Number) r20).longValue());     // Catch: Throwable -> L124
        if ((r30 instanceof Integer) == true) goto L107;
        r30 = null;
    L107:
        r21 = (Integer) r30;     // Catch: Throwable -> L124
    L109:
        if ((r20 instanceof JSONObject) == false) goto L111;
    L180:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L117
        Object r31 = SDKSettingsCacheManager.a().fromJson(r20.toString(), Integer.class);     // Catch: Throwable -> L117
        if ((r31 instanceof Integer) == true) goto L115;
        r31 = null;
    L115:
        Object r32 = Result.constructor-impl((Integer) r31);     // Catch: Throwable -> L117
    L119:
        r21 = r32;
        if (Result.isFailure-impl(r21) == false) goto L122;
    L117:
        th = move-exception;
        Result.Companion r33 = Result.Companion;     // Catch: Throwable -> L124
        r32 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L124
        goto L119
    L111:
        if ((r20 instanceof JSONArray) == false) goto L121;
    L81:
        r27 = r20;
    L150:
        th = move-exception;
        Result.Companion r34 = Result.Companion;     // Catch: Throwable -> L160
        r26 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L160
        Throwable r35 = Result.exceptionOrNull-impl(r26);     // Catch: Throwable -> L160
        if (r35 == null) goto L155;
        EnsureManager.ensureNotReachHere(r35);     // Catch: Throwable -> L160
    L155:
        if (Result.isFailure-impl(r26) == false) goto L157;
        r26 = r1;
    L124:
        th = move-exception;
        Result.Companion r36 = Result.Companion;     // Catch: Throwable -> L150
        r22 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L150
    L170:
        return ((Number) r17).intValue();
    L9:
        if ((r13 instanceof Integer) == true) goto L11;
        Object r37 = null;
    L12:
        r14 = (Integer) r37;     // Catch: Throwable -> L54
        if (r14 != null) goto L52;
        if ((r13 instanceof Number) == false) goto L39;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L24;
        Float r38 = Float.valueOf(((Number) r13).floatValue());     // Catch: Throwable -> L54
        if ((r38 instanceof Integer) == true) goto L22;
        r38 = null;
    L22:
        r14 = (Integer) r38;     // Catch: Throwable -> L54
        goto L52
    L24:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L30;
        Double r39 = Double.valueOf(((Number) r13).doubleValue());     // Catch: Throwable -> L54
        if ((r39 instanceof Integer) == true) goto L28;
        r39 = null;
    L28:
        r14 = (Integer) r39;     // Catch: Throwable -> L54
        goto L52
    L30:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L33;
        r14 = Integer.valueOf(((Number) r13).intValue());     // Catch: Throwable -> L54
        goto L52
    L33:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L39;
        Long r40 = Long.valueOf(((Number) r13).longValue());     // Catch: Throwable -> L54
        if ((r40 instanceof Integer) == true) goto L37;
        r40 = null;
    L37:
        r14 = (Integer) r40;     // Catch: Throwable -> L54
    L39:
        if ((r13 instanceof JSONObject) == false) goto L41;
    L178:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L47
        Object r41 = SDKSettingsCacheManager.a().fromJson(r13.toString(), Integer.class);     // Catch: Throwable -> L47
        if ((r41 instanceof Integer) == true) goto L45;
        r41 = null;
    L45:
        Object r42 = Result.constructor-impl((Integer) r41);     // Catch: Throwable -> L47
    L49:
        r14 = r42;
        if (Result.isFailure-impl(r14) == false) goto L52;
    L47:
        th = move-exception;
        Result.Companion r43 = Result.Companion;     // Catch: Throwable -> L54
        r42 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L54
        goto L49
    L41:
        if ((r13 instanceof JSONArray) == false) goto L51;
    L11:
        r37 = r13;
    L54:
        th = move-exception;
        Result.Companion r44 = Result.Companion;     // Catch: Throwable -> L160
        r15 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L160
    L160:
        th = move-exception;
        Result.Companion r45 = Result.Companion;
        Object r46 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r47 = Result.exceptionOrNull-impl(r46);
        if (r47 == null) goto L165;
        EnsureManager.ensureNotReachHere(r47);
    L165:
        if (Result.isFailure-impl(r46) == true) goto L168;
        r1 = r46;
    L168:
        r17 = r1;
        goto L170
    }

    @HostExperimentKey
    public static final boolean g() {
        int r0 = m.a;
        Object r1 = 0;
        boolean r10 = ECServiceManager.a;
        s83.g r11 = (s83.g) ECServiceManager.c(s83.g.class);
        if (r11 == null) goto L8;
        s83.a r12 = r11.q();
        if (r12 == null) goto L8;
        Object r13 = r12.e("order_list_cache_android");
        if (r13 == null) goto L8;
    L175:
        if (((Number) r13).intValue() != 1) goto L189;
        return true;
    L189:
        return false;
    L8:
        int r14 = n.a;
        int r15 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L165
        Object r17 = null;
        Object r18 = com.bytedance.android.ec.base.settings.d.c.get("order_list_cache_android");     // Catch: Throwable -> L60
        if (r18 != null) goto L15;
    L57:
        Object r19 = null;
    L58:
        Object r20 = Result.constructor-impl(r19);     // Catch: Throwable -> L60
    L62:
        Throwable r21 = Result.exceptionOrNull-impl(r20);     // Catch: Throwable -> L165
        if (r21 == null) goto L66;
        EnsureManager.ensureNotReachHere(r21);     // Catch: Throwable -> L165
    L66:
        if (Result.isFailure-impl(r20) == false) goto L69;
        r20 = null;
    L69:
        if ((r20 instanceof Integer) == true) goto L71;
        r20 = null;
    L71:
        Integer r22 = (Integer) r20;     // Catch: Throwable -> L165
        if (r22 != null) goto L78;
        Object r23 = com.bytedance.android.ec.base.settings.d.a.get("order_list_cache_android");     // Catch: Throwable -> L165
        if ((r23 instanceof Integer) == true) goto L77;
        r23 = null;
    L77:
        r22 = (Integer) r23;     // Catch: Throwable -> L165
    L78:
        if (r22 == null) goto L80;
        r13 = r22;
        goto L175
    L80:
        int r24 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L165
        Object r25 = com.bytedance.android.ec.base.settings.d.c.get("order_list_cache_android");     // Catch: Throwable -> L130
        if (r25 != null) goto L85;
    L127:
        Object r26 = null;
    L128:
        Object r27 = Result.constructor-impl(r26);     // Catch: Throwable -> L130
    L132:
        Throwable r28 = Result.exceptionOrNull-impl(r27);     // Catch: Throwable -> L156
        if (r28 == null) goto L136;
        EnsureManager.ensureNotReachHere(r28);     // Catch: Throwable -> L156
    L136:
        if (Result.isFailure-impl(r27) == false) goto L139;
        r27 = null;
    L139:
        if ((r27 instanceof Integer) == true) goto L141;
        r27 = null;
    L141:
        Integer r29 = (Integer) r27;     // Catch: Throwable -> L156
        if (r29 == null) goto L144;
        r13 = r29;
    L163:
        com.bytedance.android.ec.base.settings.d.d("order_list_cache_android", r13);     // Catch: Throwable -> L165
        goto L175
    L144:
        IHybridHostService r30 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L156
        if (r30 == null) goto L147;
        Object r31 = r30.getHostABValue("order_list_cache_android", r1);     // Catch: Throwable -> L156
    L148:
        if (r31 != null) goto L150;
    L162:
        r13 = r1;
        goto L163
    L150:
        if ((r31 instanceof Integer) == false) goto L153;
        r17 = r31;
    L153:
        r13 = (Integer) r17;     // Catch: Throwable -> L156
        if (r13 != null) goto L163;
    L147:
        r31 = null;
        goto L148
    L85:
        if ((r25 instanceof Integer) == true) goto L87;
        Object r32 = null;
    L88:
        r26 = (Integer) r32;     // Catch: Throwable -> L130
        if (r26 != null) goto L128;
        if ((r25 instanceof Number) == false) goto L115;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L100;
        Float r33 = Float.valueOf(((Number) r25).floatValue());     // Catch: Throwable -> L130
        if ((r33 instanceof Integer) == true) goto L98;
        r33 = null;
    L98:
        r26 = (Integer) r33;     // Catch: Throwable -> L130
        goto L128
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L106;
        Double r34 = Double.valueOf(((Number) r25).doubleValue());     // Catch: Throwable -> L130
        if ((r34 instanceof Integer) == true) goto L104;
        r34 = null;
    L104:
        r26 = (Integer) r34;     // Catch: Throwable -> L130
        goto L128
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L109;
        r26 = Integer.valueOf(((Number) r25).intValue());     // Catch: Throwable -> L130
        goto L128
    L109:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L115;
        Long r35 = Long.valueOf(((Number) r25).longValue());     // Catch: Throwable -> L130
        if ((r35 instanceof Integer) == true) goto L113;
        r35 = null;
    L113:
        r26 = (Integer) r35;     // Catch: Throwable -> L130
    L115:
        if ((r25 instanceof JSONObject) == false) goto L117;
    L185:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L123
        Object r36 = SDKSettingsCacheManager.a().fromJson(r25.toString(), Integer.class);     // Catch: Throwable -> L123
        if ((r36 instanceof Integer) == true) goto L121;
        r36 = null;
    L121:
        Object r37 = Result.constructor-impl((Integer) r36);     // Catch: Throwable -> L123
    L125:
        r26 = r37;
        if (Result.isFailure-impl(r26) == false) goto L128;
    L123:
        th = move-exception;
        Result.Companion r38 = Result.Companion;     // Catch: Throwable -> L130
        r37 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L130
        goto L125
    L117:
        if ((r25 instanceof JSONArray) == false) goto L127;
    L87:
        r32 = r25;
    L156:
        th = move-exception;
        Result.Companion r39 = Result.Companion;     // Catch: Throwable -> L165
        r13 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L165
        Throwable r40 = Result.exceptionOrNull-impl(r13);     // Catch: Throwable -> L165
        if (r40 == null) goto L161;
        EnsureManager.ensureNotReachHere(r40);     // Catch: Throwable -> L165
    L161:
        if (Result.isFailure-impl(r13) == false) goto L163;
    L130:
        th = move-exception;
        Result.Companion r41 = Result.Companion;     // Catch: Throwable -> L156
        r27 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L156
        goto L132
    L15:
        if ((r18 instanceof Integer) == true) goto L17;
        Object r42 = null;
    L18:
        r19 = (Integer) r42;     // Catch: Throwable -> L60
        if (r19 != null) goto L58;
        if ((r18 instanceof Number) == false) goto L45;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L30;
        Float r43 = Float.valueOf(((Number) r18).floatValue());     // Catch: Throwable -> L60
        if ((r43 instanceof Integer) == true) goto L28;
        r43 = null;
    L28:
        r19 = (Integer) r43;     // Catch: Throwable -> L60
        goto L58
    L30:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L36;
        Double r44 = Double.valueOf(((Number) r18).doubleValue());     // Catch: Throwable -> L60
        if ((r44 instanceof Integer) == true) goto L34;
        r44 = null;
    L34:
        r19 = (Integer) r44;     // Catch: Throwable -> L60
        goto L58
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L39;
        r19 = Integer.valueOf(((Number) r18).intValue());     // Catch: Throwable -> L60
        goto L58
    L39:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L45;
        Long r45 = Long.valueOf(((Number) r18).longValue());     // Catch: Throwable -> L60
        if ((r45 instanceof Integer) == true) goto L43;
        r45 = null;
    L43:
        r19 = (Integer) r45;     // Catch: Throwable -> L60
    L45:
        if ((r18 instanceof JSONObject) == false) goto L47;
    L183:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L53
        Object r46 = SDKSettingsCacheManager.a().fromJson(r18.toString(), Integer.class);     // Catch: Throwable -> L53
        if ((r46 instanceof Integer) == true) goto L51;
        r46 = null;
    L51:
        Object r47 = Result.constructor-impl((Integer) r46);     // Catch: Throwable -> L53
    L55:
        r19 = r47;
        if (Result.isFailure-impl(r19) == false) goto L58;
    L53:
        th = move-exception;
        Result.Companion r48 = Result.Companion;     // Catch: Throwable -> L60
        r47 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L60
        goto L55
    L47:
        if ((r18 instanceof JSONArray) == false) goto L57;
    L17:
        r42 = r18;
    L60:
        th = move-exception;
        Result.Companion r49 = Result.Companion;     // Catch: Throwable -> L165
        r20 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L165
    L165:
        th = move-exception;
        Result.Companion r50 = Result.Companion;
        Object r51 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r52 = Result.exceptionOrNull-impl(r51);
        if (r52 == null) goto L170;
        EnsureManager.ensureNotReachHere(r52);
    L170:
        if (Result.isFailure-impl(r51) == true) goto L173;
        r1 = r51;
    L173:
        r13 = r1;
        goto L175
    }

    @HostExperimentKey
    public static final boolean h() {
        int r0 = m.a;
        Object r1 = 0;
        boolean r10 = ECServiceManager.a;
        s83.g r11 = (s83.g) ECServiceManager.c(s83.g.class);
        if (r11 == null) goto L8;
        s83.a r12 = r11.q();
        if (r12 == null) goto L8;
        Object r13 = r12.e("order_list_stream_request_android");
        if (r13 == null) goto L8;
    L175:
        if (((Number) r13).intValue() != 1) goto L189;
        return true;
    L189:
        return false;
    L8:
        int r14 = n.a;
        int r15 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L165
        Object r17 = null;
        Object r18 = com.bytedance.android.ec.base.settings.d.c.get("order_list_stream_request_android");     // Catch: Throwable -> L60
        if (r18 != null) goto L15;
    L57:
        Object r19 = null;
    L58:
        Object r20 = Result.constructor-impl(r19);     // Catch: Throwable -> L60
    L62:
        Throwable r21 = Result.exceptionOrNull-impl(r20);     // Catch: Throwable -> L165
        if (r21 == null) goto L66;
        EnsureManager.ensureNotReachHere(r21);     // Catch: Throwable -> L165
    L66:
        if (Result.isFailure-impl(r20) == false) goto L69;
        r20 = null;
    L69:
        if ((r20 instanceof Integer) == true) goto L71;
        r20 = null;
    L71:
        Integer r22 = (Integer) r20;     // Catch: Throwable -> L165
        if (r22 != null) goto L78;
        Object r23 = com.bytedance.android.ec.base.settings.d.a.get("order_list_stream_request_android");     // Catch: Throwable -> L165
        if ((r23 instanceof Integer) == true) goto L77;
        r23 = null;
    L77:
        r22 = (Integer) r23;     // Catch: Throwable -> L165
    L78:
        if (r22 == null) goto L80;
        r13 = r22;
        goto L175
    L80:
        int r24 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L165
        Object r25 = com.bytedance.android.ec.base.settings.d.c.get("order_list_stream_request_android");     // Catch: Throwable -> L130
        if (r25 != null) goto L85;
    L127:
        Object r26 = null;
    L128:
        Object r27 = Result.constructor-impl(r26);     // Catch: Throwable -> L130
    L132:
        Throwable r28 = Result.exceptionOrNull-impl(r27);     // Catch: Throwable -> L156
        if (r28 == null) goto L136;
        EnsureManager.ensureNotReachHere(r28);     // Catch: Throwable -> L156
    L136:
        if (Result.isFailure-impl(r27) == false) goto L139;
        r27 = null;
    L139:
        if ((r27 instanceof Integer) == true) goto L141;
        r27 = null;
    L141:
        Integer r29 = (Integer) r27;     // Catch: Throwable -> L156
        if (r29 == null) goto L144;
        r13 = r29;
    L163:
        com.bytedance.android.ec.base.settings.d.d("order_list_stream_request_android", r13);     // Catch: Throwable -> L165
        goto L175
    L144:
        IHybridHostService r30 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L156
        if (r30 == null) goto L147;
        Object r31 = r30.getHostABValue("order_list_stream_request_android", r1);     // Catch: Throwable -> L156
    L148:
        if (r31 != null) goto L150;
    L162:
        r13 = r1;
        goto L163
    L150:
        if ((r31 instanceof Integer) == false) goto L153;
        r17 = r31;
    L153:
        r13 = (Integer) r17;     // Catch: Throwable -> L156
        if (r13 != null) goto L163;
    L147:
        r31 = null;
        goto L148
    L85:
        if ((r25 instanceof Integer) == true) goto L87;
        Object r32 = null;
    L88:
        r26 = (Integer) r32;     // Catch: Throwable -> L130
        if (r26 != null) goto L128;
        if ((r25 instanceof Number) == false) goto L115;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L100;
        Float r33 = Float.valueOf(((Number) r25).floatValue());     // Catch: Throwable -> L130
        if ((r33 instanceof Integer) == true) goto L98;
        r33 = null;
    L98:
        r26 = (Integer) r33;     // Catch: Throwable -> L130
        goto L128
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L106;
        Double r34 = Double.valueOf(((Number) r25).doubleValue());     // Catch: Throwable -> L130
        if ((r34 instanceof Integer) == true) goto L104;
        r34 = null;
    L104:
        r26 = (Integer) r34;     // Catch: Throwable -> L130
        goto L128
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L109;
        r26 = Integer.valueOf(((Number) r25).intValue());     // Catch: Throwable -> L130
        goto L128
    L109:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L115;
        Long r35 = Long.valueOf(((Number) r25).longValue());     // Catch: Throwable -> L130
        if ((r35 instanceof Integer) == true) goto L113;
        r35 = null;
    L113:
        r26 = (Integer) r35;     // Catch: Throwable -> L130
    L115:
        if ((r25 instanceof JSONObject) == false) goto L117;
    L185:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L123
        Object r36 = SDKSettingsCacheManager.a().fromJson(r25.toString(), Integer.class);     // Catch: Throwable -> L123
        if ((r36 instanceof Integer) == true) goto L121;
        r36 = null;
    L121:
        Object r37 = Result.constructor-impl((Integer) r36);     // Catch: Throwable -> L123
    L125:
        r26 = r37;
        if (Result.isFailure-impl(r26) == false) goto L128;
    L123:
        th = move-exception;
        Result.Companion r38 = Result.Companion;     // Catch: Throwable -> L130
        r37 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L130
        goto L125
    L117:
        if ((r25 instanceof JSONArray) == false) goto L127;
    L87:
        r32 = r25;
    L156:
        th = move-exception;
        Result.Companion r39 = Result.Companion;     // Catch: Throwable -> L165
        r13 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L165
        Throwable r40 = Result.exceptionOrNull-impl(r13);     // Catch: Throwable -> L165
        if (r40 == null) goto L161;
        EnsureManager.ensureNotReachHere(r40);     // Catch: Throwable -> L165
    L161:
        if (Result.isFailure-impl(r13) == false) goto L163;
    L130:
        th = move-exception;
        Result.Companion r41 = Result.Companion;     // Catch: Throwable -> L156
        r27 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L156
        goto L132
    L15:
        if ((r18 instanceof Integer) == true) goto L17;
        Object r42 = null;
    L18:
        r19 = (Integer) r42;     // Catch: Throwable -> L60
        if (r19 != null) goto L58;
        if ((r18 instanceof Number) == false) goto L45;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L30;
        Float r43 = Float.valueOf(((Number) r18).floatValue());     // Catch: Throwable -> L60
        if ((r43 instanceof Integer) == true) goto L28;
        r43 = null;
    L28:
        r19 = (Integer) r43;     // Catch: Throwable -> L60
        goto L58
    L30:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L36;
        Double r44 = Double.valueOf(((Number) r18).doubleValue());     // Catch: Throwable -> L60
        if ((r44 instanceof Integer) == true) goto L34;
        r44 = null;
    L34:
        r19 = (Integer) r44;     // Catch: Throwable -> L60
        goto L58
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L39;
        r19 = Integer.valueOf(((Number) r18).intValue());     // Catch: Throwable -> L60
        goto L58
    L39:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L45;
        Long r45 = Long.valueOf(((Number) r18).longValue());     // Catch: Throwable -> L60
        if ((r45 instanceof Integer) == true) goto L43;
        r45 = null;
    L43:
        r19 = (Integer) r45;     // Catch: Throwable -> L60
    L45:
        if ((r18 instanceof JSONObject) == false) goto L47;
    L183:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L53
        Object r46 = SDKSettingsCacheManager.a().fromJson(r18.toString(), Integer.class);     // Catch: Throwable -> L53
        if ((r46 instanceof Integer) == true) goto L51;
        r46 = null;
    L51:
        Object r47 = Result.constructor-impl((Integer) r46);     // Catch: Throwable -> L53
    L55:
        r19 = r47;
        if (Result.isFailure-impl(r19) == false) goto L58;
    L53:
        th = move-exception;
        Result.Companion r48 = Result.Companion;     // Catch: Throwable -> L60
        r47 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L60
        goto L55
    L47:
        if ((r18 instanceof JSONArray) == false) goto L57;
    L17:
        r42 = r18;
    L60:
        th = move-exception;
        Result.Companion r49 = Result.Companion;     // Catch: Throwable -> L165
        r20 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L165
    L165:
        th = move-exception;
        Result.Companion r50 = Result.Companion;
        Object r51 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r52 = Result.exceptionOrNull-impl(r51);
        if (r52 == null) goto L170;
        EnsureManager.ensureNotReachHere(r52);
    L170:
        if (Result.isFailure-impl(r51) == true) goto L173;
        r1 = r51;
    L173:
        r13 = r1;
        goto L175
    }

    @HostExperimentKey
    public static final boolean i() {
        int r0 = m.a;
        Object r1 = 0;
        boolean r10 = ECServiceManager.a;
        s83.g r11 = (s83.g) ECServiceManager.c(s83.g.class);
        if (r11 == null) goto L8;
        s83.a r12 = r11.q();
        if (r12 == null) goto L8;
        Object r13 = r12.e("order_list_stream_request_android_v2");
        if (r13 == null) goto L8;
    L175:
        if (((Number) r13).intValue() != 1) goto L189;
        return true;
    L189:
        return false;
    L8:
        int r14 = n.a;
        int r15 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L165
        Object r17 = null;
        Object r18 = com.bytedance.android.ec.base.settings.d.c.get("order_list_stream_request_android_v2");     // Catch: Throwable -> L60
        if (r18 != null) goto L15;
    L57:
        Object r19 = null;
    L58:
        Object r20 = Result.constructor-impl(r19);     // Catch: Throwable -> L60
    L62:
        Throwable r21 = Result.exceptionOrNull-impl(r20);     // Catch: Throwable -> L165
        if (r21 == null) goto L66;
        EnsureManager.ensureNotReachHere(r21);     // Catch: Throwable -> L165
    L66:
        if (Result.isFailure-impl(r20) == false) goto L69;
        r20 = null;
    L69:
        if ((r20 instanceof Integer) == true) goto L71;
        r20 = null;
    L71:
        Integer r22 = (Integer) r20;     // Catch: Throwable -> L165
        if (r22 != null) goto L78;
        Object r23 = com.bytedance.android.ec.base.settings.d.a.get("order_list_stream_request_android_v2");     // Catch: Throwable -> L165
        if ((r23 instanceof Integer) == true) goto L77;
        r23 = null;
    L77:
        r22 = (Integer) r23;     // Catch: Throwable -> L165
    L78:
        if (r22 == null) goto L80;
        r13 = r22;
        goto L175
    L80:
        int r24 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L165
        Object r25 = com.bytedance.android.ec.base.settings.d.c.get("order_list_stream_request_android_v2");     // Catch: Throwable -> L130
        if (r25 != null) goto L85;
    L127:
        Object r26 = null;
    L128:
        Object r27 = Result.constructor-impl(r26);     // Catch: Throwable -> L130
    L132:
        Throwable r28 = Result.exceptionOrNull-impl(r27);     // Catch: Throwable -> L156
        if (r28 == null) goto L136;
        EnsureManager.ensureNotReachHere(r28);     // Catch: Throwable -> L156
    L136:
        if (Result.isFailure-impl(r27) == false) goto L139;
        r27 = null;
    L139:
        if ((r27 instanceof Integer) == true) goto L141;
        r27 = null;
    L141:
        Integer r29 = (Integer) r27;     // Catch: Throwable -> L156
        if (r29 == null) goto L144;
        r13 = r29;
    L163:
        com.bytedance.android.ec.base.settings.d.d("order_list_stream_request_android_v2", r13);     // Catch: Throwable -> L165
        goto L175
    L144:
        IHybridHostService r30 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L156
        if (r30 == null) goto L147;
        Object r31 = r30.getHostABValue("order_list_stream_request_android_v2", r1);     // Catch: Throwable -> L156
    L148:
        if (r31 != null) goto L150;
    L162:
        r13 = r1;
        goto L163
    L150:
        if ((r31 instanceof Integer) == false) goto L153;
        r17 = r31;
    L153:
        r13 = (Integer) r17;     // Catch: Throwable -> L156
        if (r13 != null) goto L163;
    L147:
        r31 = null;
        goto L148
    L85:
        if ((r25 instanceof Integer) == true) goto L87;
        Object r32 = null;
    L88:
        r26 = (Integer) r32;     // Catch: Throwable -> L130
        if (r26 != null) goto L128;
        if ((r25 instanceof Number) == false) goto L115;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L100;
        Float r33 = Float.valueOf(((Number) r25).floatValue());     // Catch: Throwable -> L130
        if ((r33 instanceof Integer) == true) goto L98;
        r33 = null;
    L98:
        r26 = (Integer) r33;     // Catch: Throwable -> L130
        goto L128
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L106;
        Double r34 = Double.valueOf(((Number) r25).doubleValue());     // Catch: Throwable -> L130
        if ((r34 instanceof Integer) == true) goto L104;
        r34 = null;
    L104:
        r26 = (Integer) r34;     // Catch: Throwable -> L130
        goto L128
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L109;
        r26 = Integer.valueOf(((Number) r25).intValue());     // Catch: Throwable -> L130
        goto L128
    L109:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L115;
        Long r35 = Long.valueOf(((Number) r25).longValue());     // Catch: Throwable -> L130
        if ((r35 instanceof Integer) == true) goto L113;
        r35 = null;
    L113:
        r26 = (Integer) r35;     // Catch: Throwable -> L130
    L115:
        if ((r25 instanceof JSONObject) == false) goto L117;
    L185:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L123
        Object r36 = SDKSettingsCacheManager.a().fromJson(r25.toString(), Integer.class);     // Catch: Throwable -> L123
        if ((r36 instanceof Integer) == true) goto L121;
        r36 = null;
    L121:
        Object r37 = Result.constructor-impl((Integer) r36);     // Catch: Throwable -> L123
    L125:
        r26 = r37;
        if (Result.isFailure-impl(r26) == false) goto L128;
    L123:
        th = move-exception;
        Result.Companion r38 = Result.Companion;     // Catch: Throwable -> L130
        r37 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L130
        goto L125
    L117:
        if ((r25 instanceof JSONArray) == false) goto L127;
    L87:
        r32 = r25;
    L156:
        th = move-exception;
        Result.Companion r39 = Result.Companion;     // Catch: Throwable -> L165
        r13 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L165
        Throwable r40 = Result.exceptionOrNull-impl(r13);     // Catch: Throwable -> L165
        if (r40 == null) goto L161;
        EnsureManager.ensureNotReachHere(r40);     // Catch: Throwable -> L165
    L161:
        if (Result.isFailure-impl(r13) == false) goto L163;
    L130:
        th = move-exception;
        Result.Companion r41 = Result.Companion;     // Catch: Throwable -> L156
        r27 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L156
        goto L132
    L15:
        if ((r18 instanceof Integer) == true) goto L17;
        Object r42 = null;
    L18:
        r19 = (Integer) r42;     // Catch: Throwable -> L60
        if (r19 != null) goto L58;
        if ((r18 instanceof Number) == false) goto L45;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L30;
        Float r43 = Float.valueOf(((Number) r18).floatValue());     // Catch: Throwable -> L60
        if ((r43 instanceof Integer) == true) goto L28;
        r43 = null;
    L28:
        r19 = (Integer) r43;     // Catch: Throwable -> L60
        goto L58
    L30:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L36;
        Double r44 = Double.valueOf(((Number) r18).doubleValue());     // Catch: Throwable -> L60
        if ((r44 instanceof Integer) == true) goto L34;
        r44 = null;
    L34:
        r19 = (Integer) r44;     // Catch: Throwable -> L60
        goto L58
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L39;
        r19 = Integer.valueOf(((Number) r18).intValue());     // Catch: Throwable -> L60
        goto L58
    L39:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L45;
        Long r45 = Long.valueOf(((Number) r18).longValue());     // Catch: Throwable -> L60
        if ((r45 instanceof Integer) == true) goto L43;
        r45 = null;
    L43:
        r19 = (Integer) r45;     // Catch: Throwable -> L60
    L45:
        if ((r18 instanceof JSONObject) == false) goto L47;
    L183:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L53
        Object r46 = SDKSettingsCacheManager.a().fromJson(r18.toString(), Integer.class);     // Catch: Throwable -> L53
        if ((r46 instanceof Integer) == true) goto L51;
        r46 = null;
    L51:
        Object r47 = Result.constructor-impl((Integer) r46);     // Catch: Throwable -> L53
    L55:
        r19 = r47;
        if (Result.isFailure-impl(r19) == false) goto L58;
    L53:
        th = move-exception;
        Result.Companion r48 = Result.Companion;     // Catch: Throwable -> L60
        r47 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L60
        goto L55
    L47:
        if ((r18 instanceof JSONArray) == false) goto L57;
    L17:
        r42 = r18;
    L60:
        th = move-exception;
        Result.Companion r49 = Result.Companion;     // Catch: Throwable -> L165
        r20 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L165
    L165:
        th = move-exception;
        Result.Companion r50 = Result.Companion;
        Object r51 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r52 = Result.exceptionOrNull-impl(r51);
        if (r52 == null) goto L170;
        EnsureManager.ensureNotReachHere(r52);
    L170:
        if (Result.isFailure-impl(r51) == true) goto L173;
        r1 = r51;
    L173:
        r13 = r1;
        goto L175
    }

    @HostExperimentKey
    public static final int j() {
        int r0 = n.a;
        Object r1 = 0;
        int r10 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L160
        Object r12 = null;
        Object r13 = com.bytedance.android.ec.base.settings.d.c.get("iesec_pdp_bottom_nav_slice");     // Catch: Throwable -> L54
        if (r13 != null) goto L9;
    L51:
        Object r14 = null;
    L52:
        Object r15 = Result.constructor-impl(r14);     // Catch: Throwable -> L54
    L56:
        Throwable r16 = Result.exceptionOrNull-impl(r15);     // Catch: Throwable -> L160
        if (r16 == null) goto L60;
        EnsureManager.ensureNotReachHere(r16);     // Catch: Throwable -> L160
    L60:
        if (Result.isFailure-impl(r15) == false) goto L63;
        r15 = null;
    L63:
        if ((r15 instanceof Integer) == true) goto L65;
        r15 = null;
    L65:
        Object r17 = (Integer) r15;     // Catch: Throwable -> L160
        if (r17 != null) goto L72;
        Object r18 = com.bytedance.android.ec.base.settings.d.a.get("iesec_pdp_bottom_nav_slice");     // Catch: Throwable -> L160
        if ((r18 instanceof Integer) == true) goto L71;
        r18 = null;
    L71:
        r17 = (Integer) r18;     // Catch: Throwable -> L160
    L72:
        if (r17 != null) goto L170;
        int r19 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L160
        Object r20 = com.bytedance.android.ec.base.settings.d.c.get("iesec_pdp_bottom_nav_slice");     // Catch: Throwable -> L124
        if (r20 != null) goto L79;
    L121:
        Object r21 = null;
    L122:
        Object r22 = Result.constructor-impl(r21);     // Catch: Throwable -> L124
    L126:
        Throwable r23 = Result.exceptionOrNull-impl(r22);     // Catch: Throwable -> L150
        if (r23 == null) goto L130;
        EnsureManager.ensureNotReachHere(r23);     // Catch: Throwable -> L150
    L130:
        if (Result.isFailure-impl(r22) == false) goto L133;
        r22 = null;
    L133:
        if ((r22 instanceof Integer) == true) goto L135;
        r22 = null;
    L135:
        r17 = (Integer) r22;     // Catch: Throwable -> L150
        if (r17 != null) goto L158;
        IHybridHostService r24 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L150
        if (r24 == null) goto L141;
        Object r25 = r24.getHostABValue("iesec_pdp_bottom_nav_slice", r1);     // Catch: Throwable -> L150
    L142:
        if (r25 != null) goto L144;
    L149:
        r17 = r1;
        goto L158
    L144:
        if ((r25 instanceof Integer) == false) goto L147;
        r12 = r25;
    L147:
        Object r26 = (Integer) r12;     // Catch: Throwable -> L150
        if (r26 == null) goto L149;
    L157:
        r17 = r26;
        goto L158
    L141:
        r25 = null;
    L158:
        com.bytedance.android.ec.base.settings.d.d("iesec_pdp_bottom_nav_slice", r17);     // Catch: Throwable -> L160
        goto L170
    L79:
        if ((r20 instanceof Integer) == true) goto L81;
        Object r27 = null;
    L82:
        r21 = (Integer) r27;     // Catch: Throwable -> L124
        if (r21 != null) goto L122;
        if ((r20 instanceof Number) == false) goto L109;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L94;
        Float r28 = Float.valueOf(((Number) r20).floatValue());     // Catch: Throwable -> L124
        if ((r28 instanceof Integer) == true) goto L92;
        r28 = null;
    L92:
        r21 = (Integer) r28;     // Catch: Throwable -> L124
        goto L122
    L94:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L100;
        Double r29 = Double.valueOf(((Number) r20).doubleValue());     // Catch: Throwable -> L124
        if ((r29 instanceof Integer) == true) goto L98;
        r29 = null;
    L98:
        r21 = (Integer) r29;     // Catch: Throwable -> L124
        goto L122
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L103;
        r21 = Integer.valueOf(((Number) r20).intValue());     // Catch: Throwable -> L124
        goto L122
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L109;
        Long r30 = Long.valueOf(((Number) r20).longValue());     // Catch: Throwable -> L124
        if ((r30 instanceof Integer) == true) goto L107;
        r30 = null;
    L107:
        r21 = (Integer) r30;     // Catch: Throwable -> L124
    L109:
        if ((r20 instanceof JSONObject) == false) goto L111;
    L180:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L117
        Object r31 = SDKSettingsCacheManager.a().fromJson(r20.toString(), Integer.class);     // Catch: Throwable -> L117
        if ((r31 instanceof Integer) == true) goto L115;
        r31 = null;
    L115:
        Object r32 = Result.constructor-impl((Integer) r31);     // Catch: Throwable -> L117
    L119:
        r21 = r32;
        if (Result.isFailure-impl(r21) == false) goto L122;
    L117:
        th = move-exception;
        Result.Companion r33 = Result.Companion;     // Catch: Throwable -> L124
        r32 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L124
        goto L119
    L111:
        if ((r20 instanceof JSONArray) == false) goto L121;
    L81:
        r27 = r20;
    L150:
        th = move-exception;
        Result.Companion r34 = Result.Companion;     // Catch: Throwable -> L160
        r26 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L160
        Throwable r35 = Result.exceptionOrNull-impl(r26);     // Catch: Throwable -> L160
        if (r35 == null) goto L155;
        EnsureManager.ensureNotReachHere(r35);     // Catch: Throwable -> L160
    L155:
        if (Result.isFailure-impl(r26) == false) goto L157;
        r26 = r1;
    L124:
        th = move-exception;
        Result.Companion r36 = Result.Companion;     // Catch: Throwable -> L150
        r22 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L150
    L170:
        return ((Number) r17).intValue();
    L9:
        if ((r13 instanceof Integer) == true) goto L11;
        Object r37 = null;
    L12:
        r14 = (Integer) r37;     // Catch: Throwable -> L54
        if (r14 != null) goto L52;
        if ((r13 instanceof Number) == false) goto L39;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L24;
        Float r38 = Float.valueOf(((Number) r13).floatValue());     // Catch: Throwable -> L54
        if ((r38 instanceof Integer) == true) goto L22;
        r38 = null;
    L22:
        r14 = (Integer) r38;     // Catch: Throwable -> L54
        goto L52
    L24:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L30;
        Double r39 = Double.valueOf(((Number) r13).doubleValue());     // Catch: Throwable -> L54
        if ((r39 instanceof Integer) == true) goto L28;
        r39 = null;
    L28:
        r14 = (Integer) r39;     // Catch: Throwable -> L54
        goto L52
    L30:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L33;
        r14 = Integer.valueOf(((Number) r13).intValue());     // Catch: Throwable -> L54
        goto L52
    L33:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L39;
        Long r40 = Long.valueOf(((Number) r13).longValue());     // Catch: Throwable -> L54
        if ((r40 instanceof Integer) == true) goto L37;
        r40 = null;
    L37:
        r14 = (Integer) r40;     // Catch: Throwable -> L54
    L39:
        if ((r13 instanceof JSONObject) == false) goto L41;
    L178:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L47
        Object r41 = SDKSettingsCacheManager.a().fromJson(r13.toString(), Integer.class);     // Catch: Throwable -> L47
        if ((r41 instanceof Integer) == true) goto L45;
        r41 = null;
    L45:
        Object r42 = Result.constructor-impl((Integer) r41);     // Catch: Throwable -> L47
    L49:
        r14 = r42;
        if (Result.isFailure-impl(r14) == false) goto L52;
    L47:
        th = move-exception;
        Result.Companion r43 = Result.Companion;     // Catch: Throwable -> L54
        r42 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L54
        goto L49
    L41:
        if ((r13 instanceof JSONArray) == false) goto L51;
    L11:
        r37 = r13;
    L54:
        th = move-exception;
        Result.Companion r44 = Result.Companion;     // Catch: Throwable -> L160
        r15 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L160
    L160:
        th = move-exception;
        Result.Companion r45 = Result.Companion;
        Object r46 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r47 = Result.exceptionOrNull-impl(r46);
        if (r47 == null) goto L165;
        EnsureManager.ensureNotReachHere(r47);
    L165:
        if (Result.isFailure-impl(r46) == true) goto L168;
        r1 = r46;
    L168:
        r17 = r1;
        goto L170
    }

    @HostExperimentKey
    public static final int k() {
        int r0 = n.a;
        Object r1 = 0;
        int r10 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L160
        Object r12 = null;
        Object r13 = com.bytedance.android.ec.base.settings.d.c.get("iesec_pdp_new_style_bottom");     // Catch: Throwable -> L54
        if (r13 != null) goto L9;
    L51:
        Object r14 = null;
    L52:
        Object r15 = Result.constructor-impl(r14);     // Catch: Throwable -> L54
    L56:
        Throwable r16 = Result.exceptionOrNull-impl(r15);     // Catch: Throwable -> L160
        if (r16 == null) goto L60;
        EnsureManager.ensureNotReachHere(r16);     // Catch: Throwable -> L160
    L60:
        if (Result.isFailure-impl(r15) == false) goto L63;
        r15 = null;
    L63:
        if ((r15 instanceof Integer) == true) goto L65;
        r15 = null;
    L65:
        Object r17 = (Integer) r15;     // Catch: Throwable -> L160
        if (r17 != null) goto L72;
        Object r18 = com.bytedance.android.ec.base.settings.d.a.get("iesec_pdp_new_style_bottom");     // Catch: Throwable -> L160
        if ((r18 instanceof Integer) == true) goto L71;
        r18 = null;
    L71:
        r17 = (Integer) r18;     // Catch: Throwable -> L160
    L72:
        if (r17 != null) goto L170;
        int r19 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L160
        Object r20 = com.bytedance.android.ec.base.settings.d.c.get("iesec_pdp_new_style_bottom");     // Catch: Throwable -> L124
        if (r20 != null) goto L79;
    L121:
        Object r21 = null;
    L122:
        Object r22 = Result.constructor-impl(r21);     // Catch: Throwable -> L124
    L126:
        Throwable r23 = Result.exceptionOrNull-impl(r22);     // Catch: Throwable -> L150
        if (r23 == null) goto L130;
        EnsureManager.ensureNotReachHere(r23);     // Catch: Throwable -> L150
    L130:
        if (Result.isFailure-impl(r22) == false) goto L133;
        r22 = null;
    L133:
        if ((r22 instanceof Integer) == true) goto L135;
        r22 = null;
    L135:
        r17 = (Integer) r22;     // Catch: Throwable -> L150
        if (r17 != null) goto L158;
        IHybridHostService r24 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L150
        if (r24 == null) goto L141;
        Object r25 = r24.getHostABValue("iesec_pdp_new_style_bottom", r1);     // Catch: Throwable -> L150
    L142:
        if (r25 != null) goto L144;
    L149:
        r17 = r1;
        goto L158
    L144:
        if ((r25 instanceof Integer) == false) goto L147;
        r12 = r25;
    L147:
        Object r26 = (Integer) r12;     // Catch: Throwable -> L150
        if (r26 == null) goto L149;
    L157:
        r17 = r26;
        goto L158
    L141:
        r25 = null;
    L158:
        com.bytedance.android.ec.base.settings.d.d("iesec_pdp_new_style_bottom", r17);     // Catch: Throwable -> L160
        goto L170
    L79:
        if ((r20 instanceof Integer) == true) goto L81;
        Object r27 = null;
    L82:
        r21 = (Integer) r27;     // Catch: Throwable -> L124
        if (r21 != null) goto L122;
        if ((r20 instanceof Number) == false) goto L109;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L94;
        Float r28 = Float.valueOf(((Number) r20).floatValue());     // Catch: Throwable -> L124
        if ((r28 instanceof Integer) == true) goto L92;
        r28 = null;
    L92:
        r21 = (Integer) r28;     // Catch: Throwable -> L124
        goto L122
    L94:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L100;
        Double r29 = Double.valueOf(((Number) r20).doubleValue());     // Catch: Throwable -> L124
        if ((r29 instanceof Integer) == true) goto L98;
        r29 = null;
    L98:
        r21 = (Integer) r29;     // Catch: Throwable -> L124
        goto L122
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L103;
        r21 = Integer.valueOf(((Number) r20).intValue());     // Catch: Throwable -> L124
        goto L122
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L109;
        Long r30 = Long.valueOf(((Number) r20).longValue());     // Catch: Throwable -> L124
        if ((r30 instanceof Integer) == true) goto L107;
        r30 = null;
    L107:
        r21 = (Integer) r30;     // Catch: Throwable -> L124
    L109:
        if ((r20 instanceof JSONObject) == false) goto L111;
    L180:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L117
        Object r31 = SDKSettingsCacheManager.a().fromJson(r20.toString(), Integer.class);     // Catch: Throwable -> L117
        if ((r31 instanceof Integer) == true) goto L115;
        r31 = null;
    L115:
        Object r32 = Result.constructor-impl((Integer) r31);     // Catch: Throwable -> L117
    L119:
        r21 = r32;
        if (Result.isFailure-impl(r21) == false) goto L122;
    L117:
        th = move-exception;
        Result.Companion r33 = Result.Companion;     // Catch: Throwable -> L124
        r32 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L124
        goto L119
    L111:
        if ((r20 instanceof JSONArray) == false) goto L121;
    L81:
        r27 = r20;
    L150:
        th = move-exception;
        Result.Companion r34 = Result.Companion;     // Catch: Throwable -> L160
        r26 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L160
        Throwable r35 = Result.exceptionOrNull-impl(r26);     // Catch: Throwable -> L160
        if (r35 == null) goto L155;
        EnsureManager.ensureNotReachHere(r35);     // Catch: Throwable -> L160
    L155:
        if (Result.isFailure-impl(r26) == false) goto L157;
        r26 = r1;
    L124:
        th = move-exception;
        Result.Companion r36 = Result.Companion;     // Catch: Throwable -> L150
        r22 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L150
    L170:
        return ((Number) r17).intValue();
    L9:
        if ((r13 instanceof Integer) == true) goto L11;
        Object r37 = null;
    L12:
        r14 = (Integer) r37;     // Catch: Throwable -> L54
        if (r14 != null) goto L52;
        if ((r13 instanceof Number) == false) goto L39;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L24;
        Float r38 = Float.valueOf(((Number) r13).floatValue());     // Catch: Throwable -> L54
        if ((r38 instanceof Integer) == true) goto L22;
        r38 = null;
    L22:
        r14 = (Integer) r38;     // Catch: Throwable -> L54
        goto L52
    L24:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L30;
        Double r39 = Double.valueOf(((Number) r13).doubleValue());     // Catch: Throwable -> L54
        if ((r39 instanceof Integer) == true) goto L28;
        r39 = null;
    L28:
        r14 = (Integer) r39;     // Catch: Throwable -> L54
        goto L52
    L30:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L33;
        r14 = Integer.valueOf(((Number) r13).intValue());     // Catch: Throwable -> L54
        goto L52
    L33:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L39;
        Long r40 = Long.valueOf(((Number) r13).longValue());     // Catch: Throwable -> L54
        if ((r40 instanceof Integer) == true) goto L37;
        r40 = null;
    L37:
        r14 = (Integer) r40;     // Catch: Throwable -> L54
    L39:
        if ((r13 instanceof JSONObject) == false) goto L41;
    L178:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L47
        Object r41 = SDKSettingsCacheManager.a().fromJson(r13.toString(), Integer.class);     // Catch: Throwable -> L47
        if ((r41 instanceof Integer) == true) goto L45;
        r41 = null;
    L45:
        Object r42 = Result.constructor-impl((Integer) r41);     // Catch: Throwable -> L47
    L49:
        r14 = r42;
        if (Result.isFailure-impl(r14) == false) goto L52;
    L47:
        th = move-exception;
        Result.Companion r43 = Result.Companion;     // Catch: Throwable -> L54
        r42 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L54
        goto L49
    L41:
        if ((r13 instanceof JSONArray) == false) goto L51;
    L11:
        r37 = r13;
    L54:
        th = move-exception;
        Result.Companion r44 = Result.Companion;     // Catch: Throwable -> L160
        r15 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L160
    L160:
        th = move-exception;
        Result.Companion r45 = Result.Companion;
        Object r46 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r47 = Result.exceptionOrNull-impl(r46);
        if (r47 == null) goto L165;
        EnsureManager.ensureNotReachHere(r47);
    L165:
        if (Result.isFailure-impl(r46) == true) goto L168;
        r1 = r46;
    L168:
        r17 = r1;
        goto L170
    }

    @HostExperimentKey
    public static final int l() {
        int r0 = n.a;
        Object r1 = 0;
        int r10 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L160
        Object r12 = null;
        Object r13 = com.bytedance.android.ec.base.settings.d.c.get("iesec_ecom_pdp_update_exp");     // Catch: Throwable -> L54
        if (r13 != null) goto L9;
    L51:
        Object r14 = null;
    L52:
        Object r15 = Result.constructor-impl(r14);     // Catch: Throwable -> L54
    L56:
        Throwable r16 = Result.exceptionOrNull-impl(r15);     // Catch: Throwable -> L160
        if (r16 == null) goto L60;
        EnsureManager.ensureNotReachHere(r16);     // Catch: Throwable -> L160
    L60:
        if (Result.isFailure-impl(r15) == false) goto L63;
        r15 = null;
    L63:
        if ((r15 instanceof Integer) == true) goto L65;
        r15 = null;
    L65:
        Object r17 = (Integer) r15;     // Catch: Throwable -> L160
        if (r17 != null) goto L72;
        Object r18 = com.bytedance.android.ec.base.settings.d.a.get("iesec_ecom_pdp_update_exp");     // Catch: Throwable -> L160
        if ((r18 instanceof Integer) == true) goto L71;
        r18 = null;
    L71:
        r17 = (Integer) r18;     // Catch: Throwable -> L160
    L72:
        if (r17 != null) goto L170;
        int r19 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L160
        Object r20 = com.bytedance.android.ec.base.settings.d.c.get("iesec_ecom_pdp_update_exp");     // Catch: Throwable -> L124
        if (r20 != null) goto L79;
    L121:
        Object r21 = null;
    L122:
        Object r22 = Result.constructor-impl(r21);     // Catch: Throwable -> L124
    L126:
        Throwable r23 = Result.exceptionOrNull-impl(r22);     // Catch: Throwable -> L150
        if (r23 == null) goto L130;
        EnsureManager.ensureNotReachHere(r23);     // Catch: Throwable -> L150
    L130:
        if (Result.isFailure-impl(r22) == false) goto L133;
        r22 = null;
    L133:
        if ((r22 instanceof Integer) == true) goto L135;
        r22 = null;
    L135:
        r17 = (Integer) r22;     // Catch: Throwable -> L150
        if (r17 != null) goto L158;
        IHybridHostService r24 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L150
        if (r24 == null) goto L141;
        Object r25 = r24.getHostABValue("iesec_ecom_pdp_update_exp", r1);     // Catch: Throwable -> L150
    L142:
        if (r25 != null) goto L144;
    L149:
        r17 = r1;
        goto L158
    L144:
        if ((r25 instanceof Integer) == false) goto L147;
        r12 = r25;
    L147:
        Object r26 = (Integer) r12;     // Catch: Throwable -> L150
        if (r26 == null) goto L149;
    L157:
        r17 = r26;
        goto L158
    L141:
        r25 = null;
    L158:
        com.bytedance.android.ec.base.settings.d.d("iesec_ecom_pdp_update_exp", r17);     // Catch: Throwable -> L160
        goto L170
    L79:
        if ((r20 instanceof Integer) == true) goto L81;
        Object r27 = null;
    L82:
        r21 = (Integer) r27;     // Catch: Throwable -> L124
        if (r21 != null) goto L122;
        if ((r20 instanceof Number) == false) goto L109;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L94;
        Float r28 = Float.valueOf(((Number) r20).floatValue());     // Catch: Throwable -> L124
        if ((r28 instanceof Integer) == true) goto L92;
        r28 = null;
    L92:
        r21 = (Integer) r28;     // Catch: Throwable -> L124
        goto L122
    L94:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L100;
        Double r29 = Double.valueOf(((Number) r20).doubleValue());     // Catch: Throwable -> L124
        if ((r29 instanceof Integer) == true) goto L98;
        r29 = null;
    L98:
        r21 = (Integer) r29;     // Catch: Throwable -> L124
        goto L122
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L103;
        r21 = Integer.valueOf(((Number) r20).intValue());     // Catch: Throwable -> L124
        goto L122
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L109;
        Long r30 = Long.valueOf(((Number) r20).longValue());     // Catch: Throwable -> L124
        if ((r30 instanceof Integer) == true) goto L107;
        r30 = null;
    L107:
        r21 = (Integer) r30;     // Catch: Throwable -> L124
    L109:
        if ((r20 instanceof JSONObject) == false) goto L111;
    L180:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L117
        Object r31 = SDKSettingsCacheManager.a().fromJson(r20.toString(), Integer.class);     // Catch: Throwable -> L117
        if ((r31 instanceof Integer) == true) goto L115;
        r31 = null;
    L115:
        Object r32 = Result.constructor-impl((Integer) r31);     // Catch: Throwable -> L117
    L119:
        r21 = r32;
        if (Result.isFailure-impl(r21) == false) goto L122;
    L117:
        th = move-exception;
        Result.Companion r33 = Result.Companion;     // Catch: Throwable -> L124
        r32 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L124
        goto L119
    L111:
        if ((r20 instanceof JSONArray) == false) goto L121;
    L81:
        r27 = r20;
    L150:
        th = move-exception;
        Result.Companion r34 = Result.Companion;     // Catch: Throwable -> L160
        r26 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L160
        Throwable r35 = Result.exceptionOrNull-impl(r26);     // Catch: Throwable -> L160
        if (r35 == null) goto L155;
        EnsureManager.ensureNotReachHere(r35);     // Catch: Throwable -> L160
    L155:
        if (Result.isFailure-impl(r26) == false) goto L157;
        r26 = r1;
    L124:
        th = move-exception;
        Result.Companion r36 = Result.Companion;     // Catch: Throwable -> L150
        r22 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L150
    L170:
        return ((Number) r17).intValue();
    L9:
        if ((r13 instanceof Integer) == true) goto L11;
        Object r37 = null;
    L12:
        r14 = (Integer) r37;     // Catch: Throwable -> L54
        if (r14 != null) goto L52;
        if ((r13 instanceof Number) == false) goto L39;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L24;
        Float r38 = Float.valueOf(((Number) r13).floatValue());     // Catch: Throwable -> L54
        if ((r38 instanceof Integer) == true) goto L22;
        r38 = null;
    L22:
        r14 = (Integer) r38;     // Catch: Throwable -> L54
        goto L52
    L24:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L30;
        Double r39 = Double.valueOf(((Number) r13).doubleValue());     // Catch: Throwable -> L54
        if ((r39 instanceof Integer) == true) goto L28;
        r39 = null;
    L28:
        r14 = (Integer) r39;     // Catch: Throwable -> L54
        goto L52
    L30:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L33;
        r14 = Integer.valueOf(((Number) r13).intValue());     // Catch: Throwable -> L54
        goto L52
    L33:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L39;
        Long r40 = Long.valueOf(((Number) r13).longValue());     // Catch: Throwable -> L54
        if ((r40 instanceof Integer) == true) goto L37;
        r40 = null;
    L37:
        r14 = (Integer) r40;     // Catch: Throwable -> L54
    L39:
        if ((r13 instanceof JSONObject) == false) goto L41;
    L178:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L47
        Object r41 = SDKSettingsCacheManager.a().fromJson(r13.toString(), Integer.class);     // Catch: Throwable -> L47
        if ((r41 instanceof Integer) == true) goto L45;
        r41 = null;
    L45:
        Object r42 = Result.constructor-impl((Integer) r41);     // Catch: Throwable -> L47
    L49:
        r14 = r42;
        if (Result.isFailure-impl(r14) == false) goto L52;
    L47:
        th = move-exception;
        Result.Companion r43 = Result.Companion;     // Catch: Throwable -> L54
        r42 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L54
        goto L49
    L41:
        if ((r13 instanceof JSONArray) == false) goto L51;
    L11:
        r37 = r13;
    L54:
        th = move-exception;
        Result.Companion r44 = Result.Companion;     // Catch: Throwable -> L160
        r15 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L160
    L160:
        th = move-exception;
        Result.Companion r45 = Result.Companion;
        Object r46 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r47 = Result.exceptionOrNull-impl(r46);
        if (r47 == null) goto L165;
        EnsureManager.ensureNotReachHere(r47);
    L165:
        if (Result.isFailure-impl(r46) == true) goto L168;
        r1 = r46;
    L168:
        r17 = r1;
        goto L170
    }

    @HostExperimentKey
    public static final int m() {
        int r0 = n.a;
        Object r1 = 0;
        int r10 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L160
        Object r12 = null;
        Object r13 = com.bytedance.android.ec.base.settings.d.c.get("iesec_pdp_fit_width");     // Catch: Throwable -> L54
        if (r13 != null) goto L9;
    L51:
        Object r14 = null;
    L52:
        Object r15 = Result.constructor-impl(r14);     // Catch: Throwable -> L54
    L56:
        Throwable r16 = Result.exceptionOrNull-impl(r15);     // Catch: Throwable -> L160
        if (r16 == null) goto L60;
        EnsureManager.ensureNotReachHere(r16);     // Catch: Throwable -> L160
    L60:
        if (Result.isFailure-impl(r15) == false) goto L63;
        r15 = null;
    L63:
        if ((r15 instanceof Integer) == true) goto L65;
        r15 = null;
    L65:
        Object r17 = (Integer) r15;     // Catch: Throwable -> L160
        if (r17 != null) goto L72;
        Object r18 = com.bytedance.android.ec.base.settings.d.a.get("iesec_pdp_fit_width");     // Catch: Throwable -> L160
        if ((r18 instanceof Integer) == true) goto L71;
        r18 = null;
    L71:
        r17 = (Integer) r18;     // Catch: Throwable -> L160
    L72:
        if (r17 != null) goto L170;
        int r19 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L160
        Object r20 = com.bytedance.android.ec.base.settings.d.c.get("iesec_pdp_fit_width");     // Catch: Throwable -> L124
        if (r20 != null) goto L79;
    L121:
        Object r21 = null;
    L122:
        Object r22 = Result.constructor-impl(r21);     // Catch: Throwable -> L124
    L126:
        Throwable r23 = Result.exceptionOrNull-impl(r22);     // Catch: Throwable -> L150
        if (r23 == null) goto L130;
        EnsureManager.ensureNotReachHere(r23);     // Catch: Throwable -> L150
    L130:
        if (Result.isFailure-impl(r22) == false) goto L133;
        r22 = null;
    L133:
        if ((r22 instanceof Integer) == true) goto L135;
        r22 = null;
    L135:
        r17 = (Integer) r22;     // Catch: Throwable -> L150
        if (r17 != null) goto L158;
        IHybridHostService r24 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L150
        if (r24 == null) goto L141;
        Object r25 = r24.getHostABValue("iesec_pdp_fit_width", r1);     // Catch: Throwable -> L150
    L142:
        if (r25 != null) goto L144;
    L149:
        r17 = r1;
        goto L158
    L144:
        if ((r25 instanceof Integer) == false) goto L147;
        r12 = r25;
    L147:
        Object r26 = (Integer) r12;     // Catch: Throwable -> L150
        if (r26 == null) goto L149;
    L157:
        r17 = r26;
        goto L158
    L141:
        r25 = null;
    L158:
        com.bytedance.android.ec.base.settings.d.d("iesec_pdp_fit_width", r17);     // Catch: Throwable -> L160
        goto L170
    L79:
        if ((r20 instanceof Integer) == true) goto L81;
        Object r27 = null;
    L82:
        r21 = (Integer) r27;     // Catch: Throwable -> L124
        if (r21 != null) goto L122;
        if ((r20 instanceof Number) == false) goto L109;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L94;
        Float r28 = Float.valueOf(((Number) r20).floatValue());     // Catch: Throwable -> L124
        if ((r28 instanceof Integer) == true) goto L92;
        r28 = null;
    L92:
        r21 = (Integer) r28;     // Catch: Throwable -> L124
        goto L122
    L94:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L100;
        Double r29 = Double.valueOf(((Number) r20).doubleValue());     // Catch: Throwable -> L124
        if ((r29 instanceof Integer) == true) goto L98;
        r29 = null;
    L98:
        r21 = (Integer) r29;     // Catch: Throwable -> L124
        goto L122
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L103;
        r21 = Integer.valueOf(((Number) r20).intValue());     // Catch: Throwable -> L124
        goto L122
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L109;
        Long r30 = Long.valueOf(((Number) r20).longValue());     // Catch: Throwable -> L124
        if ((r30 instanceof Integer) == true) goto L107;
        r30 = null;
    L107:
        r21 = (Integer) r30;     // Catch: Throwable -> L124
    L109:
        if ((r20 instanceof JSONObject) == false) goto L111;
    L180:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L117
        Object r31 = SDKSettingsCacheManager.a().fromJson(r20.toString(), Integer.class);     // Catch: Throwable -> L117
        if ((r31 instanceof Integer) == true) goto L115;
        r31 = null;
    L115:
        Object r32 = Result.constructor-impl((Integer) r31);     // Catch: Throwable -> L117
    L119:
        r21 = r32;
        if (Result.isFailure-impl(r21) == false) goto L122;
    L117:
        th = move-exception;
        Result.Companion r33 = Result.Companion;     // Catch: Throwable -> L124
        r32 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L124
        goto L119
    L111:
        if ((r20 instanceof JSONArray) == false) goto L121;
    L81:
        r27 = r20;
    L150:
        th = move-exception;
        Result.Companion r34 = Result.Companion;     // Catch: Throwable -> L160
        r26 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L160
        Throwable r35 = Result.exceptionOrNull-impl(r26);     // Catch: Throwable -> L160
        if (r35 == null) goto L155;
        EnsureManager.ensureNotReachHere(r35);     // Catch: Throwable -> L160
    L155:
        if (Result.isFailure-impl(r26) == false) goto L157;
        r26 = r1;
    L124:
        th = move-exception;
        Result.Companion r36 = Result.Companion;     // Catch: Throwable -> L150
        r22 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L150
    L170:
        return ((Number) r17).intValue();
    L9:
        if ((r13 instanceof Integer) == true) goto L11;
        Object r37 = null;
    L12:
        r14 = (Integer) r37;     // Catch: Throwable -> L54
        if (r14 != null) goto L52;
        if ((r13 instanceof Number) == false) goto L39;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L24;
        Float r38 = Float.valueOf(((Number) r13).floatValue());     // Catch: Throwable -> L54
        if ((r38 instanceof Integer) == true) goto L22;
        r38 = null;
    L22:
        r14 = (Integer) r38;     // Catch: Throwable -> L54
        goto L52
    L24:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L30;
        Double r39 = Double.valueOf(((Number) r13).doubleValue());     // Catch: Throwable -> L54
        if ((r39 instanceof Integer) == true) goto L28;
        r39 = null;
    L28:
        r14 = (Integer) r39;     // Catch: Throwable -> L54
        goto L52
    L30:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L33;
        r14 = Integer.valueOf(((Number) r13).intValue());     // Catch: Throwable -> L54
        goto L52
    L33:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L39;
        Long r40 = Long.valueOf(((Number) r13).longValue());     // Catch: Throwable -> L54
        if ((r40 instanceof Integer) == true) goto L37;
        r40 = null;
    L37:
        r14 = (Integer) r40;     // Catch: Throwable -> L54
    L39:
        if ((r13 instanceof JSONObject) == false) goto L41;
    L178:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L47
        Object r41 = SDKSettingsCacheManager.a().fromJson(r13.toString(), Integer.class);     // Catch: Throwable -> L47
        if ((r41 instanceof Integer) == true) goto L45;
        r41 = null;
    L45:
        Object r42 = Result.constructor-impl((Integer) r41);     // Catch: Throwable -> L47
    L49:
        r14 = r42;
        if (Result.isFailure-impl(r14) == false) goto L52;
    L47:
        th = move-exception;
        Result.Companion r43 = Result.Companion;     // Catch: Throwable -> L54
        r42 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L54
        goto L49
    L41:
        if ((r13 instanceof JSONArray) == false) goto L51;
    L11:
        r37 = r13;
    L54:
        th = move-exception;
        Result.Companion r44 = Result.Companion;     // Catch: Throwable -> L160
        r15 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L160
    L160:
        th = move-exception;
        Result.Companion r45 = Result.Companion;
        Object r46 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r47 = Result.exceptionOrNull-impl(r46);
        if (r47 == null) goto L165;
        EnsureManager.ensureNotReachHere(r47);
    L165:
        if (Result.isFailure-impl(r46) == true) goto L168;
        r1 = r46;
    L168:
        r17 = r1;
        goto L170
    }

    @HostExperimentKey
    public static final int n() {
        int r0 = n.a;
        Object r1 = 0;
        int r10 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L160
        Object r12 = null;
        Object r13 = com.bytedance.android.ec.base.settings.d.c.get("iesec_pdp_new_style_top");     // Catch: Throwable -> L54
        if (r13 != null) goto L9;
    L51:
        Object r14 = null;
    L52:
        Object r15 = Result.constructor-impl(r14);     // Catch: Throwable -> L54
    L56:
        Throwable r16 = Result.exceptionOrNull-impl(r15);     // Catch: Throwable -> L160
        if (r16 == null) goto L60;
        EnsureManager.ensureNotReachHere(r16);     // Catch: Throwable -> L160
    L60:
        if (Result.isFailure-impl(r15) == false) goto L63;
        r15 = null;
    L63:
        if ((r15 instanceof Integer) == true) goto L65;
        r15 = null;
    L65:
        Object r17 = (Integer) r15;     // Catch: Throwable -> L160
        if (r17 != null) goto L72;
        Object r18 = com.bytedance.android.ec.base.settings.d.a.get("iesec_pdp_new_style_top");     // Catch: Throwable -> L160
        if ((r18 instanceof Integer) == true) goto L71;
        r18 = null;
    L71:
        r17 = (Integer) r18;     // Catch: Throwable -> L160
    L72:
        if (r17 != null) goto L170;
        int r19 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L160
        Object r20 = com.bytedance.android.ec.base.settings.d.c.get("iesec_pdp_new_style_top");     // Catch: Throwable -> L124
        if (r20 != null) goto L79;
    L121:
        Object r21 = null;
    L122:
        Object r22 = Result.constructor-impl(r21);     // Catch: Throwable -> L124
    L126:
        Throwable r23 = Result.exceptionOrNull-impl(r22);     // Catch: Throwable -> L150
        if (r23 == null) goto L130;
        EnsureManager.ensureNotReachHere(r23);     // Catch: Throwable -> L150
    L130:
        if (Result.isFailure-impl(r22) == false) goto L133;
        r22 = null;
    L133:
        if ((r22 instanceof Integer) == true) goto L135;
        r22 = null;
    L135:
        r17 = (Integer) r22;     // Catch: Throwable -> L150
        if (r17 != null) goto L158;
        IHybridHostService r24 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L150
        if (r24 == null) goto L141;
        Object r25 = r24.getHostABValue("iesec_pdp_new_style_top", r1);     // Catch: Throwable -> L150
    L142:
        if (r25 != null) goto L144;
    L149:
        r17 = r1;
        goto L158
    L144:
        if ((r25 instanceof Integer) == false) goto L147;
        r12 = r25;
    L147:
        Object r26 = (Integer) r12;     // Catch: Throwable -> L150
        if (r26 == null) goto L149;
    L157:
        r17 = r26;
        goto L158
    L141:
        r25 = null;
    L158:
        com.bytedance.android.ec.base.settings.d.d("iesec_pdp_new_style_top", r17);     // Catch: Throwable -> L160
        goto L170
    L79:
        if ((r20 instanceof Integer) == true) goto L81;
        Object r27 = null;
    L82:
        r21 = (Integer) r27;     // Catch: Throwable -> L124
        if (r21 != null) goto L122;
        if ((r20 instanceof Number) == false) goto L109;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L94;
        Float r28 = Float.valueOf(((Number) r20).floatValue());     // Catch: Throwable -> L124
        if ((r28 instanceof Integer) == true) goto L92;
        r28 = null;
    L92:
        r21 = (Integer) r28;     // Catch: Throwable -> L124
        goto L122
    L94:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L100;
        Double r29 = Double.valueOf(((Number) r20).doubleValue());     // Catch: Throwable -> L124
        if ((r29 instanceof Integer) == true) goto L98;
        r29 = null;
    L98:
        r21 = (Integer) r29;     // Catch: Throwable -> L124
        goto L122
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L103;
        r21 = Integer.valueOf(((Number) r20).intValue());     // Catch: Throwable -> L124
        goto L122
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L109;
        Long r30 = Long.valueOf(((Number) r20).longValue());     // Catch: Throwable -> L124
        if ((r30 instanceof Integer) == true) goto L107;
        r30 = null;
    L107:
        r21 = (Integer) r30;     // Catch: Throwable -> L124
    L109:
        if ((r20 instanceof JSONObject) == false) goto L111;
    L180:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L117
        Object r31 = SDKSettingsCacheManager.a().fromJson(r20.toString(), Integer.class);     // Catch: Throwable -> L117
        if ((r31 instanceof Integer) == true) goto L115;
        r31 = null;
    L115:
        Object r32 = Result.constructor-impl((Integer) r31);     // Catch: Throwable -> L117
    L119:
        r21 = r32;
        if (Result.isFailure-impl(r21) == false) goto L122;
    L117:
        th = move-exception;
        Result.Companion r33 = Result.Companion;     // Catch: Throwable -> L124
        r32 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L124
        goto L119
    L111:
        if ((r20 instanceof JSONArray) == false) goto L121;
    L81:
        r27 = r20;
    L150:
        th = move-exception;
        Result.Companion r34 = Result.Companion;     // Catch: Throwable -> L160
        r26 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L160
        Throwable r35 = Result.exceptionOrNull-impl(r26);     // Catch: Throwable -> L160
        if (r35 == null) goto L155;
        EnsureManager.ensureNotReachHere(r35);     // Catch: Throwable -> L160
    L155:
        if (Result.isFailure-impl(r26) == false) goto L157;
        r26 = r1;
    L124:
        th = move-exception;
        Result.Companion r36 = Result.Companion;     // Catch: Throwable -> L150
        r22 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L150
    L170:
        return ((Number) r17).intValue();
    L9:
        if ((r13 instanceof Integer) == true) goto L11;
        Object r37 = null;
    L12:
        r14 = (Integer) r37;     // Catch: Throwable -> L54
        if (r14 != null) goto L52;
        if ((r13 instanceof Number) == false) goto L39;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L24;
        Float r38 = Float.valueOf(((Number) r13).floatValue());     // Catch: Throwable -> L54
        if ((r38 instanceof Integer) == true) goto L22;
        r38 = null;
    L22:
        r14 = (Integer) r38;     // Catch: Throwable -> L54
        goto L52
    L24:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L30;
        Double r39 = Double.valueOf(((Number) r13).doubleValue());     // Catch: Throwable -> L54
        if ((r39 instanceof Integer) == true) goto L28;
        r39 = null;
    L28:
        r14 = (Integer) r39;     // Catch: Throwable -> L54
        goto L52
    L30:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L33;
        r14 = Integer.valueOf(((Number) r13).intValue());     // Catch: Throwable -> L54
        goto L52
    L33:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L39;
        Long r40 = Long.valueOf(((Number) r13).longValue());     // Catch: Throwable -> L54
        if ((r40 instanceof Integer) == true) goto L37;
        r40 = null;
    L37:
        r14 = (Integer) r40;     // Catch: Throwable -> L54
    L39:
        if ((r13 instanceof JSONObject) == false) goto L41;
    L178:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L47
        Object r41 = SDKSettingsCacheManager.a().fromJson(r13.toString(), Integer.class);     // Catch: Throwable -> L47
        if ((r41 instanceof Integer) == true) goto L45;
        r41 = null;
    L45:
        Object r42 = Result.constructor-impl((Integer) r41);     // Catch: Throwable -> L47
    L49:
        r14 = r42;
        if (Result.isFailure-impl(r14) == false) goto L52;
    L47:
        th = move-exception;
        Result.Companion r43 = Result.Companion;     // Catch: Throwable -> L54
        r42 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L54
        goto L49
    L41:
        if ((r13 instanceof JSONArray) == false) goto L51;
    L11:
        r37 = r13;
    L54:
        th = move-exception;
        Result.Companion r44 = Result.Companion;     // Catch: Throwable -> L160
        r15 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L160
    L160:
        th = move-exception;
        Result.Companion r45 = Result.Companion;
        Object r46 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r47 = Result.exceptionOrNull-impl(r46);
        if (r47 == null) goto L165;
        EnsureManager.ensureNotReachHere(r47);
    L165:
        if (Result.isFailure-impl(r46) == true) goto L168;
        r1 = r46;
    L168:
        r17 = r1;
        goto L170
    }

    @HostExperimentKey
    public static final int o() {
        int r0 = n.a;
        Object r1 = 0;
        int r10 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L160
        Object r12 = null;
        Object r13 = com.bytedance.android.ec.base.settings.d.c.get("iesec_pdp_top_nav_slice");     // Catch: Throwable -> L54
        if (r13 != null) goto L9;
    L51:
        Object r14 = null;
    L52:
        Object r15 = Result.constructor-impl(r14);     // Catch: Throwable -> L54
    L56:
        Throwable r16 = Result.exceptionOrNull-impl(r15);     // Catch: Throwable -> L160
        if (r16 == null) goto L60;
        EnsureManager.ensureNotReachHere(r16);     // Catch: Throwable -> L160
    L60:
        if (Result.isFailure-impl(r15) == false) goto L63;
        r15 = null;
    L63:
        if ((r15 instanceof Integer) == true) goto L65;
        r15 = null;
    L65:
        Object r17 = (Integer) r15;     // Catch: Throwable -> L160
        if (r17 != null) goto L72;
        Object r18 = com.bytedance.android.ec.base.settings.d.a.get("iesec_pdp_top_nav_slice");     // Catch: Throwable -> L160
        if ((r18 instanceof Integer) == true) goto L71;
        r18 = null;
    L71:
        r17 = (Integer) r18;     // Catch: Throwable -> L160
    L72:
        if (r17 != null) goto L170;
        int r19 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L160
        Object r20 = com.bytedance.android.ec.base.settings.d.c.get("iesec_pdp_top_nav_slice");     // Catch: Throwable -> L124
        if (r20 != null) goto L79;
    L121:
        Object r21 = null;
    L122:
        Object r22 = Result.constructor-impl(r21);     // Catch: Throwable -> L124
    L126:
        Throwable r23 = Result.exceptionOrNull-impl(r22);     // Catch: Throwable -> L150
        if (r23 == null) goto L130;
        EnsureManager.ensureNotReachHere(r23);     // Catch: Throwable -> L150
    L130:
        if (Result.isFailure-impl(r22) == false) goto L133;
        r22 = null;
    L133:
        if ((r22 instanceof Integer) == true) goto L135;
        r22 = null;
    L135:
        r17 = (Integer) r22;     // Catch: Throwable -> L150
        if (r17 != null) goto L158;
        IHybridHostService r24 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L150
        if (r24 == null) goto L141;
        Object r25 = r24.getHostABValue("iesec_pdp_top_nav_slice", r1);     // Catch: Throwable -> L150
    L142:
        if (r25 != null) goto L144;
    L149:
        r17 = r1;
        goto L158
    L144:
        if ((r25 instanceof Integer) == false) goto L147;
        r12 = r25;
    L147:
        Object r26 = (Integer) r12;     // Catch: Throwable -> L150
        if (r26 == null) goto L149;
    L157:
        r17 = r26;
        goto L158
    L141:
        r25 = null;
    L158:
        com.bytedance.android.ec.base.settings.d.d("iesec_pdp_top_nav_slice", r17);     // Catch: Throwable -> L160
        goto L170
    L79:
        if ((r20 instanceof Integer) == true) goto L81;
        Object r27 = null;
    L82:
        r21 = (Integer) r27;     // Catch: Throwable -> L124
        if (r21 != null) goto L122;
        if ((r20 instanceof Number) == false) goto L109;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L94;
        Float r28 = Float.valueOf(((Number) r20).floatValue());     // Catch: Throwable -> L124
        if ((r28 instanceof Integer) == true) goto L92;
        r28 = null;
    L92:
        r21 = (Integer) r28;     // Catch: Throwable -> L124
        goto L122
    L94:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L100;
        Double r29 = Double.valueOf(((Number) r20).doubleValue());     // Catch: Throwable -> L124
        if ((r29 instanceof Integer) == true) goto L98;
        r29 = null;
    L98:
        r21 = (Integer) r29;     // Catch: Throwable -> L124
        goto L122
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L103;
        r21 = Integer.valueOf(((Number) r20).intValue());     // Catch: Throwable -> L124
        goto L122
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L109;
        Long r30 = Long.valueOf(((Number) r20).longValue());     // Catch: Throwable -> L124
        if ((r30 instanceof Integer) == true) goto L107;
        r30 = null;
    L107:
        r21 = (Integer) r30;     // Catch: Throwable -> L124
    L109:
        if ((r20 instanceof JSONObject) == false) goto L111;
    L180:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L117
        Object r31 = SDKSettingsCacheManager.a().fromJson(r20.toString(), Integer.class);     // Catch: Throwable -> L117
        if ((r31 instanceof Integer) == true) goto L115;
        r31 = null;
    L115:
        Object r32 = Result.constructor-impl((Integer) r31);     // Catch: Throwable -> L117
    L119:
        r21 = r32;
        if (Result.isFailure-impl(r21) == false) goto L122;
    L117:
        th = move-exception;
        Result.Companion r33 = Result.Companion;     // Catch: Throwable -> L124
        r32 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L124
        goto L119
    L111:
        if ((r20 instanceof JSONArray) == false) goto L121;
    L81:
        r27 = r20;
    L150:
        th = move-exception;
        Result.Companion r34 = Result.Companion;     // Catch: Throwable -> L160
        r26 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L160
        Throwable r35 = Result.exceptionOrNull-impl(r26);     // Catch: Throwable -> L160
        if (r35 == null) goto L155;
        EnsureManager.ensureNotReachHere(r35);     // Catch: Throwable -> L160
    L155:
        if (Result.isFailure-impl(r26) == false) goto L157;
        r26 = r1;
    L124:
        th = move-exception;
        Result.Companion r36 = Result.Companion;     // Catch: Throwable -> L150
        r22 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L150
    L170:
        return ((Number) r17).intValue();
    L9:
        if ((r13 instanceof Integer) == true) goto L11;
        Object r37 = null;
    L12:
        r14 = (Integer) r37;     // Catch: Throwable -> L54
        if (r14 != null) goto L52;
        if ((r13 instanceof Number) == false) goto L39;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L24;
        Float r38 = Float.valueOf(((Number) r13).floatValue());     // Catch: Throwable -> L54
        if ((r38 instanceof Integer) == true) goto L22;
        r38 = null;
    L22:
        r14 = (Integer) r38;     // Catch: Throwable -> L54
        goto L52
    L24:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L30;
        Double r39 = Double.valueOf(((Number) r13).doubleValue());     // Catch: Throwable -> L54
        if ((r39 instanceof Integer) == true) goto L28;
        r39 = null;
    L28:
        r14 = (Integer) r39;     // Catch: Throwable -> L54
        goto L52
    L30:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L33;
        r14 = Integer.valueOf(((Number) r13).intValue());     // Catch: Throwable -> L54
        goto L52
    L33:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L39;
        Long r40 = Long.valueOf(((Number) r13).longValue());     // Catch: Throwable -> L54
        if ((r40 instanceof Integer) == true) goto L37;
        r40 = null;
    L37:
        r14 = (Integer) r40;     // Catch: Throwable -> L54
    L39:
        if ((r13 instanceof JSONObject) == false) goto L41;
    L178:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L47
        Object r41 = SDKSettingsCacheManager.a().fromJson(r13.toString(), Integer.class);     // Catch: Throwable -> L47
        if ((r41 instanceof Integer) == true) goto L45;
        r41 = null;
    L45:
        Object r42 = Result.constructor-impl((Integer) r41);     // Catch: Throwable -> L47
    L49:
        r14 = r42;
        if (Result.isFailure-impl(r14) == false) goto L52;
    L47:
        th = move-exception;
        Result.Companion r43 = Result.Companion;     // Catch: Throwable -> L54
        r42 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L54
        goto L49
    L41:
        if ((r13 instanceof JSONArray) == false) goto L51;
    L11:
        r37 = r13;
    L54:
        th = move-exception;
        Result.Companion r44 = Result.Companion;     // Catch: Throwable -> L160
        r15 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L160
    L160:
        th = move-exception;
        Result.Companion r45 = Result.Companion;
        Object r46 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r47 = Result.exceptionOrNull-impl(r46);
        if (r47 == null) goto L165;
        EnsureManager.ensureNotReachHere(r47);
    L165:
        if (Result.isFailure-impl(r46) == true) goto L168;
        r1 = r46;
    L168:
        r17 = r1;
        goto L170
    }

    @HostExperimentKey
    public static final boolean p() {
        int r0 = n.a;
        Object r1 = Boolean.FALSE;
        int r10 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L166
        Object r12 = null;
        Object r13 = com.bytedance.android.ec.base.settings.d.c.get("detail_first_render_opt_chunk");     // Catch: Throwable -> L57
        if (r13 != null) goto L9;
    L54:
        Object r14 = null;
    L55:
        Object r15 = Result.constructor-impl(r14);     // Catch: Throwable -> L57
    L59:
        Throwable r16 = Result.exceptionOrNull-impl(r15);     // Catch: Throwable -> L166
        if (r16 == null) goto L63;
        EnsureManager.ensureNotReachHere(r16);     // Catch: Throwable -> L166
    L63:
        if (Result.isFailure-impl(r15) == false) goto L66;
        r15 = null;
    L66:
        if ((r15 instanceof Boolean) == true) goto L68;
        r15 = null;
    L68:
        Object r17 = (Boolean) r15;     // Catch: Throwable -> L166
        if (r17 != null) goto L75;
        Object r18 = com.bytedance.android.ec.base.settings.d.a.get("detail_first_render_opt_chunk");     // Catch: Throwable -> L166
        if ((r18 instanceof Boolean) == true) goto L74;
        r18 = null;
    L74:
        r17 = (Boolean) r18;     // Catch: Throwable -> L166
    L75:
        if (r17 != null) goto L176;
        int r19 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L166
        Object r20 = com.bytedance.android.ec.base.settings.d.c.get("detail_first_render_opt_chunk");     // Catch: Throwable -> L130
        if (r20 != null) goto L82;
    L127:
        Object r21 = null;
    L128:
        Object r22 = Result.constructor-impl(r21);     // Catch: Throwable -> L130
    L132:
        Throwable r23 = Result.exceptionOrNull-impl(r22);     // Catch: Throwable -> L156
        if (r23 == null) goto L136;
        EnsureManager.ensureNotReachHere(r23);     // Catch: Throwable -> L156
    L136:
        if (Result.isFailure-impl(r22) == false) goto L139;
        r22 = null;
    L139:
        if ((r22 instanceof Boolean) == true) goto L141;
        r22 = null;
    L141:
        r17 = (Boolean) r22;     // Catch: Throwable -> L156
        if (r17 != null) goto L164;
        IHybridHostService r24 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L156
        if (r24 == null) goto L147;
        Object r25 = r24.getHostABValue("detail_first_render_opt_chunk", r1);     // Catch: Throwable -> L156
    L148:
        if (r25 != null) goto L150;
    L155:
        r17 = r1;
        goto L164
    L150:
        if ((r25 instanceof Boolean) == false) goto L153;
        r12 = r25;
    L153:
        Object r26 = (Boolean) r12;     // Catch: Throwable -> L156
        if (r26 == null) goto L155;
    L163:
        r17 = r26;
        goto L164
    L147:
        r25 = null;
    L164:
        com.bytedance.android.ec.base.settings.d.d("detail_first_render_opt_chunk", r17);     // Catch: Throwable -> L166
        goto L176
    L82:
        if ((r20 instanceof Boolean) == true) goto L84;
        Object r27 = null;
    L85:
        r21 = (Boolean) r27;     // Catch: Throwable -> L130
        if (r21 != null) goto L128;
        if ((r20 instanceof Number) == false) goto L115;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r28 = Float.valueOf(((Number) r20).floatValue());     // Catch: Throwable -> L130
        if ((r28 instanceof Boolean) == true) goto L95;
        r28 = null;
    L95:
        r21 = (Boolean) r28;     // Catch: Throwable -> L130
        goto L128
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r29 = Double.valueOf(((Number) r20).doubleValue());     // Catch: Throwable -> L130
        if ((r29 instanceof Boolean) == true) goto L101;
        r29 = null;
    L101:
        r21 = (Boolean) r29;     // Catch: Throwable -> L130
        goto L128
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L109;
        Integer r30 = Integer.valueOf(((Number) r20).intValue());     // Catch: Throwable -> L130
        if ((r30 instanceof Boolean) == true) goto L107;
        r30 = null;
    L107:
        r21 = (Boolean) r30;     // Catch: Throwable -> L130
        goto L128
    L109:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L115;
        Long r31 = Long.valueOf(((Number) r20).longValue());     // Catch: Throwable -> L130
        if ((r31 instanceof Boolean) == true) goto L113;
        r31 = null;
    L113:
        r21 = (Boolean) r31;     // Catch: Throwable -> L130
    L115:
        if ((r20 instanceof JSONObject) == false) goto L117;
    L184:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L123
        Object r32 = SDKSettingsCacheManager.a().fromJson(r20.toString(), Boolean.class);     // Catch: Throwable -> L123
        if ((r32 instanceof Boolean) == true) goto L121;
        r32 = null;
    L121:
        Object r33 = Result.constructor-impl((Boolean) r32);     // Catch: Throwable -> L123
    L125:
        r21 = r33;
        if (Result.isFailure-impl(r21) == false) goto L128;
    L123:
        th = move-exception;
        Result.Companion r34 = Result.Companion;     // Catch: Throwable -> L130
        r33 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L130
        goto L125
    L117:
        if ((r20 instanceof JSONArray) == false) goto L127;
    L84:
        r27 = r20;
    L156:
        th = move-exception;
        Result.Companion r35 = Result.Companion;     // Catch: Throwable -> L166
        r26 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
        Throwable r36 = Result.exceptionOrNull-impl(r26);     // Catch: Throwable -> L166
        if (r36 == null) goto L161;
        EnsureManager.ensureNotReachHere(r36);     // Catch: Throwable -> L166
    L161:
        if (Result.isFailure-impl(r26) == false) goto L163;
        r26 = r1;
    L130:
        th = move-exception;
        Result.Companion r37 = Result.Companion;     // Catch: Throwable -> L156
        r22 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L156
    L176:
        return ((Boolean) r17).booleanValue();
    L9:
        if ((r13 instanceof Boolean) == true) goto L11;
        Object r38 = null;
    L12:
        r14 = (Boolean) r38;     // Catch: Throwable -> L57
        if (r14 != null) goto L55;
        if ((r13 instanceof Number) == false) goto L42;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L24;
        Float r39 = Float.valueOf(((Number) r13).floatValue());     // Catch: Throwable -> L57
        if ((r39 instanceof Boolean) == true) goto L22;
        r39 = null;
    L22:
        r14 = (Boolean) r39;     // Catch: Throwable -> L57
        goto L55
    L24:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L30;
        Double r40 = Double.valueOf(((Number) r13).doubleValue());     // Catch: Throwable -> L57
        if ((r40 instanceof Boolean) == true) goto L28;
        r40 = null;
    L28:
        r14 = (Boolean) r40;     // Catch: Throwable -> L57
        goto L55
    L30:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L36;
        Integer r41 = Integer.valueOf(((Number) r13).intValue());     // Catch: Throwable -> L57
        if ((r41 instanceof Boolean) == true) goto L34;
        r41 = null;
    L34:
        r14 = (Boolean) r41;     // Catch: Throwable -> L57
        goto L55
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L42;
        Long r42 = Long.valueOf(((Number) r13).longValue());     // Catch: Throwable -> L57
        if ((r42 instanceof Boolean) == true) goto L40;
        r42 = null;
    L40:
        r14 = (Boolean) r42;     // Catch: Throwable -> L57
    L42:
        if ((r13 instanceof JSONObject) == false) goto L44;
    L181:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L50
        Object r43 = SDKSettingsCacheManager.a().fromJson(r13.toString(), Boolean.class);     // Catch: Throwable -> L50
        if ((r43 instanceof Boolean) == true) goto L48;
        r43 = null;
    L48:
        Object r44 = Result.constructor-impl((Boolean) r43);     // Catch: Throwable -> L50
    L52:
        r14 = r44;
        if (Result.isFailure-impl(r14) == false) goto L55;
    L50:
        th = move-exception;
        Result.Companion r45 = Result.Companion;     // Catch: Throwable -> L57
        r44 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L57
        goto L52
    L44:
        if ((r13 instanceof JSONArray) == false) goto L54;
    L11:
        r38 = r13;
    L57:
        th = move-exception;
        Result.Companion r46 = Result.Companion;     // Catch: Throwable -> L166
        r15 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
    L166:
        th = move-exception;
        Result.Companion r47 = Result.Companion;
        Object r48 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r49 = Result.exceptionOrNull-impl(r48);
        if (r49 == null) goto L171;
        EnsureManager.ensureNotReachHere(r49);
    L171:
        if (Result.isFailure-impl(r48) == true) goto L174;
        r1 = r48;
    L174:
        r17 = r1;
        goto L176
    }

    @HostExperimentKey
    public static final int q() {
        int r0 = m.a;
        Object r1 = 0;
        boolean r10 = ECServiceManager.a;
        s83.g r11 = (s83.g) ECServiceManager.c(s83.g.class);
        if (r11 == null) goto L8;
        s83.a r12 = r11.q();
        if (r12 == null) goto L8;
        Object r13 = r12.e("ec_live_promotion_item_async_event");
        if (r13 == null) goto L8;
    L175:
        return ((Number) r13).intValue();
    L8:
        int r14 = n.a;
        int r15 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L165
        Object r17 = null;
        Object r18 = com.bytedance.android.ec.base.settings.d.c.get("ec_live_promotion_item_async_event");     // Catch: Throwable -> L60
        if (r18 != null) goto L15;
    L57:
        Object r19 = null;
    L58:
        Object r20 = Result.constructor-impl(r19);     // Catch: Throwable -> L60
    L62:
        Throwable r21 = Result.exceptionOrNull-impl(r20);     // Catch: Throwable -> L165
        if (r21 == null) goto L66;
        EnsureManager.ensureNotReachHere(r21);     // Catch: Throwable -> L165
    L66:
        if (Result.isFailure-impl(r20) == false) goto L69;
        r20 = null;
    L69:
        if ((r20 instanceof Integer) == true) goto L71;
        r20 = null;
    L71:
        Integer r22 = (Integer) r20;     // Catch: Throwable -> L165
        if (r22 != null) goto L78;
        Object r23 = com.bytedance.android.ec.base.settings.d.a.get("ec_live_promotion_item_async_event");     // Catch: Throwable -> L165
        if ((r23 instanceof Integer) == true) goto L77;
        r23 = null;
    L77:
        r22 = (Integer) r23;     // Catch: Throwable -> L165
    L78:
        if (r22 == null) goto L80;
        r13 = r22;
        goto L175
    L80:
        int r24 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L165
        Object r25 = com.bytedance.android.ec.base.settings.d.c.get("ec_live_promotion_item_async_event");     // Catch: Throwable -> L130
        if (r25 != null) goto L85;
    L127:
        Object r26 = null;
    L128:
        Object r27 = Result.constructor-impl(r26);     // Catch: Throwable -> L130
    L132:
        Throwable r28 = Result.exceptionOrNull-impl(r27);     // Catch: Throwable -> L156
        if (r28 == null) goto L136;
        EnsureManager.ensureNotReachHere(r28);     // Catch: Throwable -> L156
    L136:
        if (Result.isFailure-impl(r27) == false) goto L139;
        r27 = null;
    L139:
        if ((r27 instanceof Integer) == true) goto L141;
        r27 = null;
    L141:
        Integer r29 = (Integer) r27;     // Catch: Throwable -> L156
        if (r29 == null) goto L144;
        r13 = r29;
    L163:
        com.bytedance.android.ec.base.settings.d.d("ec_live_promotion_item_async_event", r13);     // Catch: Throwable -> L165
        goto L175
    L144:
        IHybridHostService r30 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L156
        if (r30 == null) goto L147;
        Object r31 = r30.getHostABValue("ec_live_promotion_item_async_event", r1);     // Catch: Throwable -> L156
    L148:
        if (r31 != null) goto L150;
    L162:
        r13 = r1;
        goto L163
    L150:
        if ((r31 instanceof Integer) == false) goto L153;
        r17 = r31;
    L153:
        r13 = (Integer) r17;     // Catch: Throwable -> L156
        if (r13 != null) goto L163;
    L147:
        r31 = null;
        goto L148
    L85:
        if ((r25 instanceof Integer) == true) goto L87;
        Object r32 = null;
    L88:
        r26 = (Integer) r32;     // Catch: Throwable -> L130
        if (r26 != null) goto L128;
        if ((r25 instanceof Number) == false) goto L115;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L100;
        Float r33 = Float.valueOf(((Number) r25).floatValue());     // Catch: Throwable -> L130
        if ((r33 instanceof Integer) == true) goto L98;
        r33 = null;
    L98:
        r26 = (Integer) r33;     // Catch: Throwable -> L130
        goto L128
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L106;
        Double r34 = Double.valueOf(((Number) r25).doubleValue());     // Catch: Throwable -> L130
        if ((r34 instanceof Integer) == true) goto L104;
        r34 = null;
    L104:
        r26 = (Integer) r34;     // Catch: Throwable -> L130
        goto L128
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L109;
        r26 = Integer.valueOf(((Number) r25).intValue());     // Catch: Throwable -> L130
        goto L128
    L109:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L115;
        Long r35 = Long.valueOf(((Number) r25).longValue());     // Catch: Throwable -> L130
        if ((r35 instanceof Integer) == true) goto L113;
        r35 = null;
    L113:
        r26 = (Integer) r35;     // Catch: Throwable -> L130
    L115:
        if ((r25 instanceof JSONObject) == false) goto L117;
    L183:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L123
        Object r36 = SDKSettingsCacheManager.a().fromJson(r25.toString(), Integer.class);     // Catch: Throwable -> L123
        if ((r36 instanceof Integer) == true) goto L121;
        r36 = null;
    L121:
        Object r37 = Result.constructor-impl((Integer) r36);     // Catch: Throwable -> L123
    L125:
        r26 = r37;
        if (Result.isFailure-impl(r26) == false) goto L128;
    L123:
        th = move-exception;
        Result.Companion r38 = Result.Companion;     // Catch: Throwable -> L130
        r37 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L130
        goto L125
    L117:
        if ((r25 instanceof JSONArray) == false) goto L127;
    L87:
        r32 = r25;
    L156:
        th = move-exception;
        Result.Companion r39 = Result.Companion;     // Catch: Throwable -> L165
        r13 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L165
        Throwable r40 = Result.exceptionOrNull-impl(r13);     // Catch: Throwable -> L165
        if (r40 == null) goto L161;
        EnsureManager.ensureNotReachHere(r40);     // Catch: Throwable -> L165
    L161:
        if (Result.isFailure-impl(r13) == false) goto L163;
    L130:
        th = move-exception;
        Result.Companion r41 = Result.Companion;     // Catch: Throwable -> L156
        r27 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L156
        goto L132
    L15:
        if ((r18 instanceof Integer) == true) goto L17;
        Object r42 = null;
    L18:
        r19 = (Integer) r42;     // Catch: Throwable -> L60
        if (r19 != null) goto L58;
        if ((r18 instanceof Number) == false) goto L45;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L30;
        Float r43 = Float.valueOf(((Number) r18).floatValue());     // Catch: Throwable -> L60
        if ((r43 instanceof Integer) == true) goto L28;
        r43 = null;
    L28:
        r19 = (Integer) r43;     // Catch: Throwable -> L60
        goto L58
    L30:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L36;
        Double r44 = Double.valueOf(((Number) r18).doubleValue());     // Catch: Throwable -> L60
        if ((r44 instanceof Integer) == true) goto L34;
        r44 = null;
    L34:
        r19 = (Integer) r44;     // Catch: Throwable -> L60
        goto L58
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L39;
        r19 = Integer.valueOf(((Number) r18).intValue());     // Catch: Throwable -> L60
        goto L58
    L39:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L45;
        Long r45 = Long.valueOf(((Number) r18).longValue());     // Catch: Throwable -> L60
        if ((r45 instanceof Integer) == true) goto L43;
        r45 = null;
    L43:
        r19 = (Integer) r45;     // Catch: Throwable -> L60
    L45:
        if ((r18 instanceof JSONObject) == false) goto L47;
    L181:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L53
        Object r46 = SDKSettingsCacheManager.a().fromJson(r18.toString(), Integer.class);     // Catch: Throwable -> L53
        if ((r46 instanceof Integer) == true) goto L51;
        r46 = null;
    L51:
        Object r47 = Result.constructor-impl((Integer) r46);     // Catch: Throwable -> L53
    L55:
        r19 = r47;
        if (Result.isFailure-impl(r19) == false) goto L58;
    L53:
        th = move-exception;
        Result.Companion r48 = Result.Companion;     // Catch: Throwable -> L60
        r47 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L60
        goto L55
    L47:
        if ((r18 instanceof JSONArray) == false) goto L57;
    L17:
        r42 = r18;
    L60:
        th = move-exception;
        Result.Companion r49 = Result.Companion;     // Catch: Throwable -> L165
        r20 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L165
    L165:
        th = move-exception;
        Result.Companion r50 = Result.Companion;
        Object r51 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r52 = Result.exceptionOrNull-impl(r51);
        if (r52 == null) goto L170;
        EnsureManager.ensureNotReachHere(r52);
    L170:
        if (Result.isFailure-impl(r51) == true) goto L173;
        r1 = r51;
    L173:
        r13 = r1;
        goto L175
    }

    static {
    }
}
