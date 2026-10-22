package bh;

import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.base.settings.g;
import com.bytedance.android.ec.base.settings.h;
import com.bytedance.android.ec.core.abtest.j;
import com.bytedance.android.ec.core.hybrid.model.ECPreProcessorJsbOptConfig;
import com.bytedance.android.ec.core.hybrid.prefetch.NativePrefetch;
import com.bytedance.android.ec.core.hybrid.prefetch.NativePrefetchUtil;
import com.bytedance.android.ec.core.hybrid.prefetch.u;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.hybrid.hostapi.IECHybridKevaService;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.services.apm.api.EnsureManager;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import nj.d;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b {
    public String a;
    public String b;
    public boolean c;
    public boolean d;
    public final int e;

    public final Integer b() {
        String r0 = this.a;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L8:
        boolean r10 = true;
    L9:
        if (r10 == false) goto L12;
        a(false);
        return -100;
    L12:
        ECPreProcessorJsbOptConfig.a r11 = ECPreProcessorJsbOptConfig.Companion;
        String r12 = this.a;
        r11.getClass();
        Integer r13 = ECPreProcessorJsbOptConfig.access$getCONFIG$cp().getOpen();
        if (r13 == null) goto L15;
        int r14 = r13.intValue();
    L17:
        if (r14 <= 0) goto L28;
        List<String> r15 = ECPreProcessorJsbOptConfig.access$getCONFIG$cp().getBlackList();
        if (r15 == null) goto L29;
        Iterator<T> r16 = r15.iterator();
    L23:
        if (r16.hasNext() == false) goto L29;
        String r17 = (String) r16.next();
        if (r12 == null) goto L23;
        if (StringsKt.contains$default(r12, r17, false, 2, null) != true) goto L23;
    L29:
        boolean r18 = true;
    L30:
        if (r18 == true) goto L34;
        a(false);
        return 100;
    L34:
        if ((this.e & 1) <= 0) goto L37;
        ECLiveHybridUtil.a r19 = ECLiveHybridUtil.a;
        ECLiveHybridUtil.l(this.a, true);
        this.c = true;
    L37:
        if ((this.e & 2) <= 0) goto L266;
        String r20 = this.b;
        if (r20 != null) goto L41;
    L44:
        boolean r21 = true;
    L45:
        if (r21 == false) goto L48;
        a(false);
        return 101;
    L48:
        String r22 = this.a;
        if (r22 != null) goto L51;
        r22 = "";
    L51:
        String r23 = r22;
        int r24 = zg.a.a;
        int r25 = j.a;
        Object r26 = Boolean.TRUE;
        int r27 = com.bytedance.android.ec.base.settings.b.a;
        Result.Companion r28 = Result.Companion;     // Catch: Throwable -> L219
        h.a();     // Catch: Throwable -> L219
        SDKSettingsCacheManager r29 = SDKSettingsCacheManager.e;     // Catch: Throwable -> L219
        r29.getClass();     // Catch: Throwable -> L107
        Object r30 = SDKSettingsCacheManager.b.get("ec_fold_prefetch_opt_disable");     // Catch: Throwable -> L107
        if (r30 != null) goto L59;
    L104:
        Object r31 = null;
    L105:
        Object r32 = Result.constructor-impl(r31);     // Catch: Throwable -> L107
    L109:
        Throwable r33 = Result.exceptionOrNull-impl(r32);     // Catch: Throwable -> L219
        if (r33 == null) goto L113;
        EnsureManager.ensureNotReachHere(r33);     // Catch: Throwable -> L219
    L113:
        if (Result.isFailure-impl(r32) == false) goto L116;
        r32 = null;
    L116:
        if ((r32 instanceof Boolean) == true) goto L118;
        r32 = null;
    L118:
        Object r34 = (Boolean) r32;     // Catch: Throwable -> L219
        if (r34 != null) goto L125;
        r29.getClass();     // Catch: Throwable -> L219
        Object r35 = SDKSettingsCacheManager.a.get("ec_fold_prefetch_opt_disable");     // Catch: Throwable -> L219
        if ((r35 instanceof Boolean) == true) goto L124;
        r35 = null;
    L124:
        r34 = (Boolean) r35;     // Catch: Throwable -> L219
    L125:
        if (r34 != null) goto L229;
        int r36 = g.a;     // Catch: Throwable -> L219
    L206:
        th = move-exception;
        Result.Companion r37 = Result.Companion;     // Catch: Throwable -> L219
        Object r38 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L219
    L209:
        if (Result.exceptionOrNull-impl(r38) != null) goto L268;
    L216:
        r34 = r38;
    L217:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L219
        SDKSettingsCacheManager.e("ec_fold_prefetch_opt_disable", r34);     // Catch: Throwable -> L219
        goto L229
    L268:
        r38 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("ec_fold_prefetch_opt_disable", Boolean.class, r26);     // Catch: Throwable -> L213
    L214:
        if (r38 != null) goto L216;
        r34 = r26;
    L213:
        r38 = r26;
        goto L214
    L276:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L181
        Object r39 = SDKSettingsCacheManager.b.get("ec_fold_prefetch_opt_disable");     // Catch: Throwable -> L181
        if (r39 != null) goto L133;
    L178:
        Object r40 = null;
    L179:
        Object r41 = Result.constructor-impl(r40);     // Catch: Throwable -> L181
    L183:
        Throwable r42 = Result.exceptionOrNull-impl(r41);     // Catch: Throwable -> L206
        if (r42 == null) goto L187;
        EnsureManager.ensureNotReachHere(r42);     // Catch: Throwable -> L206
    L187:
        if (Result.isFailure-impl(r41) == false) goto L190;
        r41 = null;
    L190:
        if ((r41 instanceof Boolean) == true) goto L192;
        r41 = null;
    L192:
        r38 = (Boolean) r41;     // Catch: Throwable -> L206
        if (r38 != null) goto L216;
        jj4.b r43 = jj4.b.b;     // Catch: Throwable -> L206
        Object r44 = jj4.a.a("ec_fold_prefetch_opt_disable", Boolean.class, r26, false);     // Catch: Throwable -> L206
        if (r44 != null) goto L199;
        Intrinsics.throwNpe();     // Catch: Throwable -> L206
    L199:
        if ((r44 instanceof Boolean) == true) goto L201;
        r44 = null;
    L201:
        Object r45 = (Boolean) r44;     // Catch: Throwable -> L206
        if (r45 != null) goto L204;
        r45 = r26;
    L204:
        r38 = Result.constructor-impl(r45);     // Catch: Throwable -> L206
    L133:
        if ((r39 instanceof Boolean) == true) goto L135;
        Object r46 = null;
    L136:
        r40 = (Boolean) r46;     // Catch: Throwable -> L181
        if (r40 != null) goto L179;
        if ((r39 instanceof Number) == false) goto L166;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L148;
        Float r47 = Float.valueOf(((Number) r39).floatValue());     // Catch: Throwable -> L181
        if ((r47 instanceof Boolean) == true) goto L146;
        r47 = null;
    L146:
        r40 = (Boolean) r47;     // Catch: Throwable -> L181
        goto L179
    L148:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L154;
        Double r48 = Double.valueOf(((Number) r39).doubleValue());     // Catch: Throwable -> L181
        if ((r48 instanceof Boolean) == true) goto L152;
        r48 = null;
    L152:
        r40 = (Boolean) r48;     // Catch: Throwable -> L181
        goto L179
    L154:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L160;
        Integer r49 = Integer.valueOf(((Number) r39).intValue());     // Catch: Throwable -> L181
        if ((r49 instanceof Boolean) == true) goto L158;
        r49 = null;
    L158:
        r40 = (Boolean) r49;     // Catch: Throwable -> L181
        goto L179
    L160:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L166;
        Long r50 = Long.valueOf(((Number) r39).longValue());     // Catch: Throwable -> L181
        if ((r50 instanceof Boolean) == true) goto L164;
        r50 = null;
    L164:
        r40 = (Boolean) r50;     // Catch: Throwable -> L181
    L166:
        if ((r39 instanceof JSONObject) == false) goto L168;
    L272:
        Object r51 = SDKSettingsCacheManager.a().fromJson(r39.toString(), Boolean.class);     // Catch: Throwable -> L174
        if ((r51 instanceof Boolean) == true) goto L172;
        r51 = null;
    L172:
        Object r52 = Result.constructor-impl((Boolean) r51);     // Catch: Throwable -> L174
    L176:
        r40 = r52;
        if (Result.isFailure-impl(r40) == false) goto L179;
    L174:
        th = move-exception;
        Result.Companion r53 = Result.Companion;     // Catch: Throwable -> L181
        r52 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L181
        goto L176
    L168:
        if ((r39 instanceof JSONArray) == false) goto L178;
    L135:
        r46 = r39;
    L181:
        th = move-exception;
        Result.Companion r54 = Result.Companion;     // Catch: Throwable -> L206
        r41 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L206
    L229:
        if (((Boolean) r34).booleanValue() == true) goto L231;
    L235:
        ConcurrentHashMap<String, NativePrefetch> r55 = NativePrefetchUtil.a;
        String r56 = this.b;
        Intrinsics.checkNotNullParameter(r23, com.bytedance.android.ec.core.event.a.KEY_URL);
        Result.Companion r57 = Result.Companion;     // Catch: Throwable -> L261
        if (r56 != null) goto L239;
    L242:
        boolean r58 = true;
    L243:
        if (r58 == true) goto L263;
        String r59 = UriProtector.getQueryParameter(UriProtector.parse(r23), "ec_request_id");     // Catch: Throwable -> L261
        if (r59 != null) goto L248;
    L251:
        boolean r60 = true;
    L252:
        if (r60 == false) goto L263;
        if (NativePrefetchUtil.l(r56) == false) goto L258;
        u.b(r23, false);     // Catch: Throwable -> L261
        goto L263
    L258:
        if (NativePrefetchUtil.b(r23, false, 6) == false) goto L263;
        r1 = true;
        goto L263
    L248:
        if (StringsKt.isBlank(r59) == true) goto L251;
        r60 = false;
    L263:
        if (r1 == false) goto L265;
        ConcurrentHashMap<String, NativePrefetch> r61 = NativePrefetchUtil.a;
        NativePrefetchUtil.n(r23, new JSONObject(), this.b, true, true, true, 64);
    L265:
        this.d = true;
        goto L266
    L239:
        if (StringsKt.isBlank(r56) == true) goto L242;
        r58 = false;
    L261:
        th = move-exception;
        Result.Companion r62 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L263
    L231:
        if (ECSdk.c() == false) goto L235;
        d r63 = com.bytedance.android.ec.sdk.helper.d.b.getPadSplitService();
        if (r63 == null) goto L235;
        r63.isFold();
        goto L235
    L59:
        if ((r30 instanceof Boolean) == true) goto L61;
        Object r64 = null;
    L62:
        r31 = (Boolean) r64;     // Catch: Throwable -> L107
        if (r31 != null) goto L105;
        if ((r30 instanceof Number) == false) goto L92;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L74;
        Float r65 = Float.valueOf(((Number) r30).floatValue());     // Catch: Throwable -> L107
        if ((r65 instanceof Boolean) == true) goto L72;
        r65 = null;
    L72:
        r31 = (Boolean) r65;     // Catch: Throwable -> L107
        goto L105
    L74:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L80;
        Double r66 = Double.valueOf(((Number) r30).doubleValue());     // Catch: Throwable -> L107
        if ((r66 instanceof Boolean) == true) goto L78;
        r66 = null;
    L78:
        r31 = (Boolean) r66;     // Catch: Throwable -> L107
        goto L105
    L80:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L86;
        Integer r67 = Integer.valueOf(((Number) r30).intValue());     // Catch: Throwable -> L107
        if ((r67 instanceof Boolean) == true) goto L84;
        r67 = null;
    L84:
        r31 = (Boolean) r67;     // Catch: Throwable -> L107
        goto L105
    L86:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L92;
        Long r68 = Long.valueOf(((Number) r30).longValue());     // Catch: Throwable -> L107
        if ((r68 instanceof Boolean) == true) goto L90;
        r68 = null;
    L90:
        r31 = (Boolean) r68;     // Catch: Throwable -> L107
    L92:
        if ((r30 instanceof JSONObject) == false) goto L94;
    L274:
        Object r69 = SDKSettingsCacheManager.a().fromJson(r30.toString(), Boolean.class);     // Catch: Throwable -> L100
        if ((r69 instanceof Boolean) == true) goto L98;
        r69 = null;
    L98:
        Object r70 = Result.constructor-impl((Boolean) r69);     // Catch: Throwable -> L100
    L102:
        r31 = r70;
        if (Result.isFailure-impl(r31) == false) goto L105;
    L100:
        th = move-exception;
        Result.Companion r71 = Result.Companion;     // Catch: Throwable -> L107
        r70 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L107
        goto L102
    L94:
        if ((r30 instanceof JSONArray) == false) goto L104;
    L61:
        r64 = r30;
    L107:
        th = move-exception;
        Result.Companion r72 = Result.Companion;     // Catch: Throwable -> L219
        r32 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L219
    L219:
        th = move-exception;
        Result.Companion r73 = Result.Companion;
        Object r74 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r75 = Result.exceptionOrNull-impl(r74);
        if (r75 == null) goto L224;
        EnsureManager.ensureNotReachHere(r75);
    L224:
        if (Result.isFailure-impl(r74) == true) goto L227;
        r26 = r74;
    L227:
        r34 = r26;
        goto L229
    L41:
        if (StringsKt.isBlank(r20) == true) goto L44;
        r21 = false;
    L266:
        a(true);
        return null;
    L28:
        r18 = false;
        goto L30
    L15:
        r14 = 0;
        goto L17
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r10 = false;
        goto L9
    }

    public b(int r1) {
        this.e = r1;
    }

    public final void a(boolean r10) {
        com.bytedance.android.ec.sdk.helper.g r0 = com.bytedance.android.ec.sdk.helper.g.a;
        JSONObject r1 = new JSONObject();
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L24
        String r12 = this.a;     // Catch: Throwable -> L24
        String r13 = "";
        if (r12 == null) goto L10;
        String r14 = StringsKt.substringBefore(r12, "?", "");     // Catch: Throwable -> L24
        if (r14 == null) goto L10;
        r13 = r14;
    L10:
        r1.putOpt(com.bytedance.android.ec.core.event.a.KEY_URL, r13);     // Catch: Throwable -> L24
        int r15 = 1;
        if (this.c == false) goto L13;
        int r16 = 1;
    L14:
        r1.putOpt("enable_preload_gecko", Integer.valueOf(r16));     // Catch: Throwable -> L24
        if (this.d == false) goto L17;
        int r17 = 1;
    L18:
        r1.putOpt("enable_native_prefetch", Integer.valueOf(r17));     // Catch: Throwable -> L24
        if (r10 == true) goto L22;
        r15 = 0;
    L22:
        Result.constructor-impl(r1.putOpt("success", Integer.valueOf(r15)));     // Catch: Throwable -> L24
    L26:
        Unit r18 = Unit.INSTANCE;
        r0.logV3("ies_ecommerce_perf_preprocessor_jsb_monitor", r1);
        return;
    L17:
        r17 = 0;
        goto L18
    L13:
        r16 = 0;
    L24:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L26
    }
}
