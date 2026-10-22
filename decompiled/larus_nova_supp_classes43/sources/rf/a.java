package rf;

import com.bytedance.android.ec.ab.opt.HostExperimentKey;
import com.bytedance.android.ec.ab.opt.OptSetting;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.base.settings.c;
import com.bytedance.android.ec.base.settings.d;
import com.bytedance.android.ec.core.opt.ab.m;
import com.bytedance.android.ec.core.opt.ab.n;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.services.apm.api.EnsureManager;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONArray;
import org.json.JSONObject;
import s83.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@OptSetting(business = "")
public final class a {
    public static final /* synthetic */ int a = 0;

    @HostExperimentKey
    public static final int a() {
        int r0 = m.a;
        Object r1 = 0;
        boolean r10 = ECServiceManager.a;
        g r11 = (g) ECServiceManager.c(g.class);
        if (r11 == null) goto L8;
        s83.a r12 = r11.q();
        if (r12 == null) goto L8;
        Object r13 = r12.e("ab_sku_prerender_v2");
        if (r13 == null) goto L8;
    L175:
        return ((Number) r13).intValue();
    L8:
        int r14 = n.a;
        int r15 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L165
        Object r17 = null;
        Object r18 = d.c.get("ab_sku_prerender_v2");     // Catch: Throwable -> L60
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
        Object r23 = d.a.get("ab_sku_prerender_v2");     // Catch: Throwable -> L165
        if ((r23 instanceof Integer) == true) goto L77;
        r23 = null;
    L77:
        r22 = (Integer) r23;     // Catch: Throwable -> L165
    L78:
        if (r22 == null) goto L80;
        r13 = r22;
        goto L175
    L80:
        int r24 = c.a;     // Catch: Throwable -> L165
        Object r25 = d.c.get("ab_sku_prerender_v2");     // Catch: Throwable -> L130
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
        d.d("ab_sku_prerender_v2", r13);     // Catch: Throwable -> L165
        goto L175
    L144:
        IHybridHostService r30 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L156
        if (r30 == null) goto L147;
        Object r31 = r30.getHostABValue("ab_sku_prerender_v2", r1);     // Catch: Throwable -> L156
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
