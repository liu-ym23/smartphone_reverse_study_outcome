package com.bytedance.android.ec.core.cps;

import android.util.SparseBooleanArray;
import com.bytedance.ai.bridge.service.IHostStyleUIDepend;
import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.services.apm.api.EnsureManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class CyberProtectionInjector implements com.bytedance.android.ec.sdk.helper.u {
    public static volatile boolean a;
    public static String b;
    public static List<Integer> c;
    public static f d;
    public static d e;
    public static k f;
    public static String g;
    public static String h;
    public static long i;
    public static int j;
    public static int k;
    public static final CyberProtectionInjector l = null;

    public CyberProtectionInjector() {
    }

    static {
        l = new CyberProtectionInjector();
        c = CollectionsKt.emptyList();
        g = "none";
        h = "none";
    }

    public static void d() {
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), Dispatchers.getDefault(), null, new CyberProtectionInjector$initCollectorData$1(null), 2, null);
    }

    public static String c(String r22) {
        Intrinsics.checkNotNullParameter(r22, "eventName");
        String r10 = "none";
        int r11 = 0;
        if (a == true) goto L21;
        CyberProtectionConfig.c.getClass();
        if (((Number) CyberProtectionConfig.b.getValue()).intValue() != 1) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == false) goto L128;
        String r12 = String.valueOf(System.currentTimeMillis());
        String r13 = j.c(i.b, CollectionsKt.joinToString$default(CollectionsKt.listOf(new String[]{"init", "none", "0x91f4f5a0", "none", r22, r12}), "|", null, null, 0, null, null, 62, null));
        if (r13 == null) goto L129;
        d r1 = e;
        if (r1 == null) goto L18;
        String r14 = r1.g();
        if (r14 == null) goto L18;
        String r15 = r14;
    L20:
        return e.a(new h(r15, r22, "0x91f4f5a0|none", r12, r13, 0, 0)).toString();
    L18:
        r15 = "999999";
        goto L20
    L129:
        return null;
    L128:
        return null;
    L7:
        r0 = false;
        goto L8
    L21:
        String r16 = b;
        if (r16 == null) goto L43;
        String r17 = String.valueOf(System.currentTimeMillis());
        Object[] r18 = new Object[6];
        r18[0] = IHostStyleUIDepend.TOAST_TYPE_ERROR;
        CyberProtectionCollector r19 = CyberProtectionCollector.a;
        String r110 = ECAppInfoService.e.getServerDeviceId();
        if (r110 != null) goto L26;
    L27:
        r11 = 1;
    L28:
        if (r11 != 0) goto L31;
        r10 = r110;
    L31:
        r18[1] = r10;
        r18[2] = r16;
        r18[3] = Long.valueOf(i);
        r18[4] = r22;
        r18[5] = r17;
        String r20 = j.c(i.b, CollectionsKt.joinToString$default(CollectionsKt.listOf(r18), "|", null, null, 0, null, null, 62, null));
        if (r20 == null) goto L130;
        d r21 = e;
        if (r21 == null) goto L40;
        String r23 = r21.g();
        if (r23 == null) goto L40;
        String r24 = r23;
    L42:
        return e.a(new h(r24, r22, h, r17, r20, j, k)).toString();
    L40:
        r24 = "999999";
        goto L42
    L130:
        return null;
    L26:
        if (StringsKt.isBlank(r110) == false) goto L28;
    L43:
        String r25 = String.valueOf(System.currentTimeMillis());
        ArrayList r111 = new ArrayList();
        r111.add("success");
        d r26 = e;
        if (r26 == null) goto L47;
        String r27 = r26.f();
        if (r27 == null) goto L47;
    L48:
        r111.add(r27);
        r111.add(g);
        r111.add(r22);
        r111.add(r25);
        d r28 = e;
        if (r28 == null) goto L51;
        Integer r29 = r28.getType();
    L52:
        if (r29 != null) goto L55;
    L102:
        d r30 = e;
        if (r30 == null) goto L108;
        String r31 = r30.g();
        if (r31 == null) goto L108;
        String r32 = r31;
    L110:
        return e.a(new h(r32, r22, h, r25, r10, j, k)).toString();
    L108:
        r32 = "999999";
        goto L110
    L55:
        if (r29.intValue() != 2) goto L102;
        k r33 = f;
        if (r33 == null) goto L59;
        String r34 = j.c(r33, CollectionsKt.joinToString$default(r111, "|", null, null, 0, null, null, 62, null));
    L60:
        if (r34 != null) goto L62;
    L101:
        return null;
    L62:
        if (32 != r34.length()) goto L101;
        f r35 = d;
        if (r35 == null) goto L77;
        g r36 = r35.c();
        if (r36 == null) goto L77;
        Map<String, String> r37 = r36.a();
        if (r37 == null) goto L77;
        Iterator<Map.Entry<String, String>> r38 = r37.entrySet().iterator();
        String r112 = r34;
    L72:
        if (r38.hasNext() == false) goto L76;
        Map.Entry<String, String> r39 = r38.next();
        String r113 = r39.getValue();
        if (r113 == null) goto L72;
        r112 = StringsKt.replace$default(r112, r39.getKey(), r113, false, 4, null);
        goto L72
    L76:
        r34 = r112;
    L77:
        ArrayList r40 = new ArrayList();
        IntProgression r41 = RangesKt.step(StringsKt.getIndices(r34), 4);
        int r42 = r41.getFirst();
        int r43 = r41.getLast();
        int r44 = r41.getStep();
        if (r44 < 0) goto L81;
        if (r42 <= r43) goto L82;
    L85:
        ArrayList r114 = new ArrayList(r40.size());
        SparseBooleanArray r45 = new SparseBooleanArray();
        Iterator<Integer> r46 = c.iterator();
    L87:
        if (r46.hasNext() == false) goto L93;
        int r47 = r46.next().intValue();
        int r48 = r40.size();
        if (r47 < 0) goto L87;
        if (r48 <= r47) goto L87;
        r114.add(ListProtector.get(r40, r47));
        r45.put(r47, true);
        goto L87
    L93:
        Iterator r49 = r40.iterator();
    L95:
        if (r49.hasNext() == false) goto L100;
        String r50 = (String) r49.next();
        if (r45.get(r11) == true) goto L99;
        r114.add(r50);
    L99:
        r11 = r11 + 1;
        goto L95
    L100:
        r10 = CollectionsKt.joinToString$default(r114, "", null, null, 0, null, null, 62, null);
    L82:
        r40.add(r34.substring(r42, Math.min(r42 + 4, r34.length())));
        if (r42 == r43) goto L85;
        r42 = r42 + r44;
        goto L82
    L81:
        if (r42 < r43) goto L85;
    L59:
        r34 = null;
        goto L60
    L51:
        r29 = null;
    L47:
        r27 = "none";
        goto L48
    }

    public static final Object b(CyberProtectionInjector r18, Continuation r19) {
        r18.getClass();
        if ((r19 instanceof CyberProtectionInjector$initConfig$1) == false) goto L7;
        CyberProtectionInjector$initConfig$1 r10 = (CyberProtectionInjector$initConfig$1) r19;
        int r11 = r10.label;
        if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
        r10.label = r11 - Integer.MIN_VALUE;
    L8:
        Object r0 = r10.result;
        Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r13 = r10.label;
        if (r13 == 0) goto L16;
        if (r13 == 1) goto L15;
        if (r13 != 2) goto L14;
        String r1 = (String) r10.L$0;
        ResultKt.throwOnFailure(r0);
    L411:
        String r14 = (String) r0;
        if (r14 == null) goto L414;
        g = r1;
    L415:
        h = r14;
    L416:
        a = true;
        return Unit.INSTANCE;
    L414:
        r14 = "0x4aaec536|" + i;
        g = r14;
        goto L415
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r0);
    L407:
        if (b == null) goto L416;
        r1 = b + '|' + i;
        r10.L$0 = r1;
        r10.label = 2;
        r0 = c.b(r1, r10);
        if (r0 != r12) goto L411;
        return r12;
    L16:
        ResultKt.throwOnFailure(r0);
        if (a == true) goto L438;
        i = System.currentTimeMillis();
        r10.label = 1;
        CyberProtectionConfig.c.getClass();
        int r15 = com.bytedance.android.ec.core.opt.ab.n.a;
        int r16 = com.bytedance.android.ec.base.settings.a.a;
        CyberProtectionConfig.ConfigError r17 = null;
        Result.Companion r20 = Result.Companion;     // Catch: Throwable -> L180
        Object r21 = com.bytedance.android.ec.base.settings.d.c.get("ecom_track_config");     // Catch: Throwable -> L73
        if (r21 != null) goto L25;
    L70:
        Object r22 = null;
    L71:
        Object r23 = Result.constructor-impl(r22);     // Catch: Throwable -> L73
    L75:
        Throwable r24 = Result.exceptionOrNull-impl(r23);     // Catch: Throwable -> L180
        if (r24 == null) goto L79;
        EnsureManager.ensureNotReachHere(r24);     // Catch: Throwable -> L180
    L79:
        if (Result.isFailure-impl(r23) == false) goto L82;
        r23 = null;
    L82:
        if ((r23 instanceof String) == true) goto L84;
        r23 = null;
    L84:
        Object r25 = (String) r23;     // Catch: Throwable -> L180
        if (r25 != null) goto L91;
        Object r26 = com.bytedance.android.ec.base.settings.d.a.get("ecom_track_config");     // Catch: Throwable -> L180
        if ((r26 instanceof String) == true) goto L90;
        r26 = null;
    L90:
        r25 = (String) r26;     // Catch: Throwable -> L180
    L91:
        if (r25 != null) goto L187;
        int r27 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L180
        Object r28 = com.bytedance.android.ec.base.settings.d.c.get("ecom_track_config");     // Catch: Throwable -> L146
        if (r28 != null) goto L98;
    L143:
        Object r29 = null;
    L144:
        Object r30 = Result.constructor-impl(r29);     // Catch: Throwable -> L146
    L148:
        Throwable r31 = Result.exceptionOrNull-impl(r30);     // Catch: Throwable -> L171
        if (r31 == null) goto L152;
        EnsureManager.ensureNotReachHere(r31);     // Catch: Throwable -> L171
    L152:
        if (Result.isFailure-impl(r30) == false) goto L155;
        r30 = null;
    L155:
        if ((r30 instanceof String) == true) goto L157;
        r30 = null;
    L157:
        r25 = (String) r30;     // Catch: Throwable -> L171
        if (r25 != null) goto L178;
        IHybridHostService r32 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L171
        if (r32 == null) goto L163;
        Object r33 = r32.getHostABValue("ecom_track_config", "VALUE_EC_DYNAMIC_EVENT_CONFIG_NULL");     // Catch: Throwable -> L171
    L164:
        if (r33 != null) goto L166;
    L177:
        r25 = "VALUE_EC_DYNAMIC_EVENT_CONFIG_NULL";
        goto L178
    L166:
        if ((r33 instanceof String) == true) goto L168;
        r33 = null;
    L168:
        r25 = (String) r33;     // Catch: Throwable -> L171
        if (r25 != null) goto L178;
    L171:
        th = move-exception;
        Result.Companion r34 = Result.Companion;     // Catch: Throwable -> L180
        r25 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L180
        Throwable r35 = Result.exceptionOrNull-impl(r25);     // Catch: Throwable -> L180
        if (r35 == null) goto L176;
        EnsureManager.ensureNotReachHere(r35);     // Catch: Throwable -> L180
    L176:
        if (Result.isFailure-impl(r25) == false) goto L178;
    L163:
        r33 = null;
    L178:
        com.bytedance.android.ec.base.settings.d.d("ecom_track_config", r25);     // Catch: Throwable -> L180
        goto L187
    L98:
        if ((r28 instanceof String) == true) goto L100;
        Object r36 = null;
    L101:
        r29 = (String) r36;     // Catch: Throwable -> L146
        if (r29 != null) goto L144;
        if ((r28 instanceof Number) == false) goto L131;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L113;
        Float r37 = Float.valueOf(((Number) r28).floatValue());     // Catch: Throwable -> L146
        if ((r37 instanceof String) == true) goto L111;
        r37 = null;
    L111:
        r29 = (String) r37;     // Catch: Throwable -> L146
        goto L144
    L113:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L119;
        Double r38 = Double.valueOf(((Number) r28).doubleValue());     // Catch: Throwable -> L146
        if ((r38 instanceof String) == true) goto L117;
        r38 = null;
    L117:
        r29 = (String) r38;     // Catch: Throwable -> L146
        goto L144
    L119:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L125;
        Integer r39 = Integer.valueOf(((Number) r28).intValue());     // Catch: Throwable -> L146
        if ((r39 instanceof String) == true) goto L123;
        r39 = null;
    L123:
        r29 = (String) r39;     // Catch: Throwable -> L146
        goto L144
    L125:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L131;
        Long r40 = Long.valueOf(((Number) r28).longValue());     // Catch: Throwable -> L146
        if ((r40 instanceof String) == true) goto L129;
        r40 = null;
    L129:
        r29 = (String) r40;     // Catch: Throwable -> L146
    L131:
        if ((r28 instanceof JSONObject) == false) goto L133;
    L426:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L139
        Object r41 = SDKSettingsCacheManager.a().fromJson(r28.toString(), String.class);     // Catch: Throwable -> L139
        if ((r41 instanceof String) == true) goto L137;
        r41 = null;
    L137:
        Object r42 = Result.constructor-impl((String) r41);     // Catch: Throwable -> L139
    L141:
        r29 = r42;
        if (Result.isFailure-impl(r29) == false) goto L144;
    L139:
        th = move-exception;
        Result.Companion r43 = Result.Companion;     // Catch: Throwable -> L146
        r42 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L146
        goto L141
    L133:
        if ((r28 instanceof JSONArray) == false) goto L143;
    L100:
        r36 = r28;
    L146:
        th = move-exception;
        Result.Companion r44 = Result.Companion;     // Catch: Throwable -> L171
        r30 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L171
    L187:
        String r45 = (String) r25;
        int r110 = 3;
        boolean r111 = false;
        if (Intrinsics.areEqual(r45, "VALUE_EC_DYNAMIC_EVENT_CONFIG_NULL") == false) goto L191;
        String[] r46 = null;
        int r47 = 2;
    L213:
        if (r46 == null) goto L424;
        r110 = 0;
    L230:
        Pair r48 = new Pair(r46, new CyberProtectionConfig.a(r47, r110, null));
        String[] r49 = (String[]) r48.component1();
        CyberProtectionConfig.a r50 = (CyberProtectionConfig.a) r48.component2();
        int r51 = r50.b;
        if (r51 <= 0) goto L233;
        boolean r112 = true;
    L234:
        if (r49 != null) goto L236;
    L257:
        Triple r52 = new Triple(null, null, new CyberProtectionConfig.a(r50.a, r51, CyberProtectionConfig.ConfigError.Lack));
    L258:
        f r53 = (f) r52.component1();
        d r54 = (d) r52.component2();
        CyberProtectionConfig.a r55 = (CyberProtectionConfig.a) r52.component3();
        CyberProtectionConfig.ConfigError r56 = r55.c;
        j = r55.a;
        k = r55.b;
        if (r56 != CyberProtectionConfig.ConfigError.JSON) goto L262;
        b = "0x796127e5";
        Object r57 = Unit.INSTANCE;
    L404:
        if (r57 != r12) goto L407;
        return r12;
    L262:
        if (r56 != CyberProtectionConfig.ConfigError.Decode) goto L265;
        b = "0x596077f5";
        r57 = Unit.INSTANCE;
        goto L404
    L265:
        if (r56 == CyberProtectionConfig.ConfigError.Lack) goto L403;
        if (r53 == null) goto L403;
        if (r54 == null) goto L403;
        d = r53;
        e = r54;
        if ((!Intrinsics.areEqual(r53.d(), r54.g())) == false) goto L272;
        b = "0x14ba792b";
        r57 = Unit.INSTANCE;
        goto L404
    L272:
        String r113 = r54.e();
        if (r113 == null) goto L276;
        List r58 = StringsKt.split$default(r113, new String[]{","}, false, 0, 6, null);
        if (r58 == null) goto L276;
    L277:
        List<String> r59 = CollectionsKt.toMutableList(r58);
        int r60 = r59.size();
        Integer r61 = r54.a();
        if (r61 != null) goto L281;
    L282:
        b = "0x3b671cfe";
        r57 = Unit.INSTANCE;
        goto L404
    L281:
        if (r60 != r61.intValue()) goto L282;
        Intrinsics.checkNotNullParameter(r54, "$this$notNull");
        if (r54.c() != null) goto L286;
    L300:
        boolean r62 = false;
    L301:
        if (r62 == true) goto L303;
        b = "0x91fff2c6";
        r57 = Unit.INSTANCE;
        goto L404
    L303:
        Intrinsics.checkNotNullParameter(r54, "$this$hasEmpty");
        String r63 = r54.g();
        if (r63 != null) goto L306;
    L309:
        boolean r64 = true;
    L310:
        if (r64 == true) goto L337;
        String r65 = r54.b();
        if (r65 != null) goto L314;
    L317:
        boolean r66 = true;
    L318:
        if (r66 == true) goto L337;
        String r67 = r54.f();
        if (r67 != null) goto L322;
    L325:
        boolean r68 = true;
    L326:
        if (r68 == true) goto L337;
        String r69 = r54.e();
        if (r69 != null) goto L330;
    L333:
        boolean r70 = true;
    L334:
        if (r70 == true) goto L337;
        boolean r71 = false;
    L338:
        if (r71 == false) goto L340;
        b = "0xff488464";
        r57 = Unit.INSTANCE;
        goto L404
    L340:
        Integer r72 = r54.getType();
        if (r72 != null) goto L344;
    L345:
        Integer r73 = r54.getType();
        if (r73 != null) goto L349;
    L350:
        b = "0xa07da6e8";
        r57 = Unit.INSTANCE;
        goto L404
    L349:
        if (r73.intValue() != 2) goto L350;
    L351:
        Integer r74 = r54.getType();
        if (r74 != null) goto L355;
    L365:
        Integer r75 = r54.getType();
        if (r75 != null) goto L369;
    L373:
        Intrinsics.checkNotNullParameter(r53, "$this$notNull");
        if (r53.d() != null) goto L376;
    L389:
        boolean r76 = false;
    L390:
        if (r76 == true) goto L392;
        b = "0x7f063672";
        r57 = Unit.INSTANCE;
        goto L404
    L392:
        String r77 = r53.d();
        if (r77 != null) goto L395;
    L396:
        r111 = true;
    L397:
        if (r111 == false) goto L399;
        b = "0x73cb043e";
        r57 = Unit.INSTANCE;
        goto L404
    L399:
        r57 = r18.e(r54, r53, r59, r10);
        if (r57 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L404;
        r57 = Unit.INSTANCE;
        goto L404
    L395:
        if (StringsKt.isBlank(r77) == false) goto L397;
    L376:
        if (r53.a() == null) goto L389;
        if (r53.b() == null) goto L389;
        g r78 = r53.c();
        if (r78 == null) goto L389;
        Intrinsics.checkNotNullParameter(r78, "$this$notNull");
        if (r78.b() != null) goto L384;
    L386:
        boolean r79 = false;
    L387:
        if (r79 != true) goto L389;
        r76 = true;
        goto L390
    L384:
        if (r78.a() == null) goto L386;
        r79 = true;
        goto L387
    L369:
        if (r75.intValue() != 2) goto L373;
        if (r54.a().intValue() > 0) goto L373;
        b = "0xdd1ca9ef";
        r57 = Unit.INSTANCE;
        goto L404
    L355:
        if (r74.intValue() != 2) goto L365;
        String r80 = r54.d();
        if (r80 != null) goto L359;
    L362:
        boolean r81 = true;
    L363:
        if (r81 == false) goto L365;
        b = "0xc665b5ff";
        r57 = Unit.INSTANCE;
        goto L404
    L359:
        if (StringsKt.isBlank(r80) == true) goto L362;
        r81 = false;
        goto L363
    L344:
        if (r72.intValue() == 1) goto L351;
    L330:
        if (StringsKt.isBlank(r69) == true) goto L333;
        r70 = false;
        goto L334
    L322:
        if (StringsKt.isBlank(r67) == true) goto L325;
        r68 = false;
        goto L326
    L314:
        if (StringsKt.isBlank(r65) == true) goto L317;
        r66 = false;
    L337:
        r71 = true;
        goto L338
    L306:
        if (StringsKt.isBlank(r63) == true) goto L309;
        r64 = false;
        goto L310
    L286:
        if (r54.g() == null) goto L300;
        if (r54.b() == null) goto L300;
        if (r54.f() == null) goto L300;
        if (r54.getType() == null) goto L300;
        if (r54.d() == null) goto L300;
        if (r54.a() == null) goto L300;
        if (r54.e() == null) goto L300;
        r62 = true;
    L276:
        r58 = CollectionsKt.emptyList();
    L403:
        b = "0xc4f37df9";
        r57 = Unit.INSTANCE;
        goto L404
    L236:
        if (r49.length < 2) goto L257;
        Pair r82 = CyberProtectionConfig.a(r49[0], d.class);
        d r114 = (d) r82.component1();
        CyberProtectionConfig.ConfigError r83 = (CyberProtectionConfig.ConfigError) r82.component2();
        Pair r115 = CyberProtectionConfig.a(r49[1], f.class);
        f r116 = (f) r115.component1();
        CyberProtectionConfig.ConfigError r117 = (CyberProtectionConfig.ConfigError) r115.component2();
        CyberProtectionConfig.ConfigError r118 = CyberProtectionConfig.ConfigError.Lack;
        if (r117 == r118) goto L249;
        if (r83 == r118) goto L249;
        r118 = CyberProtectionConfig.ConfigError.Decode;
        if (r117 == r118) goto L249;
        if (r83 == r118) goto L249;
        r118 = CyberProtectionConfig.ConfigError.JSON;
        if (r117 == r118) goto L249;
        if (r83 == r118) goto L249;
    L250:
        if (r17 != null) goto L256;
        if (r112 == true) goto L256;
        Result.Companion r84 = Result.Companion;     // Catch: Throwable -> L254
        ((Keva) CyberProtectionConfig.a.getValue()).storeString("ecom_track_config", u0.d(r49));     // Catch: Throwable -> L254
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L254
    L254:
        th = move-exception;
        Result.Companion r85 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L256:
        r52 = new Triple(r116, r114, new CyberProtectionConfig.a(r50.a, r50.b, r17));
    L249:
        r17 = r118;
        goto L250
    L233:
        r112 = false;
        goto L234
    L424:
        String r119 = ((Keva) CyberProtectionConfig.a.getValue()).getString("ecom_track_config", "VALUE_EC_DYNAMIC_EVENT_CONFIG_NULL");     // Catch: Throwable -> L216
    L217:
        if (r119 != null) goto L219;
    L228:
        r110 = 2;
        goto L230
    L219:
        if (Intrinsics.areEqual(r119, "VALUE_EC_DYNAMIC_EVENT_CONFIG_NULL") == true) goto L228;
        String[] r86 = (String[]) u0.b(r119, String[].class);     // Catch: Throwable -> L223
    L224:
        if (r86 == null) goto L230;
        if (r86.length < 2) goto L230;
        r46 = r86;
        r110 = 1;
    L223:
        r86 = null;
    L216:
        r119 = null;
        goto L217
    L191:
        if (Intrinsics.areEqual(r45, "None") == false) goto L428;
        r46 = null;
        r47 = 3;
        goto L213
    L428:
        r46 = (String[]) u0.b(r45, String[].class);     // Catch: Throwable -> L195
    L196:
        if (r46 != null) goto L198;
    L200:
        if (r46 != null) goto L203;
        int r87 = 4;
    L212:
        r47 = r87;
        r46 = null;
        goto L213
    L203:
        if (r46.length != 0) goto L205;
        boolean r88 = true;
    L206:
        if (r88 == false) goto L209;
        r87 = 5;
        goto L212
    L209:
        if (1 != r46.length) goto L211;
        r87 = 6;
        goto L212
    L211:
        r87 = 1;
        goto L212
    L205:
        r88 = false;
        goto L206
    L198:
        if (r46.length < 2) goto L200;
        r47 = 0;
    L195:
        r46 = null;
        goto L196
    L25:
        if ((r21 instanceof String) == true) goto L27;
        Object r89 = null;
    L28:
        r22 = (String) r89;     // Catch: Throwable -> L73
        if (r22 != null) goto L71;
        if ((r21 instanceof Number) == false) goto L58;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L40;
        Float r90 = Float.valueOf(((Number) r21).floatValue());     // Catch: Throwable -> L73
        if ((r90 instanceof String) == true) goto L38;
        r90 = null;
    L38:
        r22 = (String) r90;     // Catch: Throwable -> L73
        goto L71
    L40:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L46;
        Double r91 = Double.valueOf(((Number) r21).doubleValue());     // Catch: Throwable -> L73
        if ((r91 instanceof String) == true) goto L44;
        r91 = null;
    L44:
        r22 = (String) r91;     // Catch: Throwable -> L73
        goto L71
    L46:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L52;
        Integer r92 = Integer.valueOf(((Number) r21).intValue());     // Catch: Throwable -> L73
        if ((r92 instanceof String) == true) goto L50;
        r92 = null;
    L50:
        r22 = (String) r92;     // Catch: Throwable -> L73
        goto L71
    L52:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(String.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L58;
        Long r93 = Long.valueOf(((Number) r21).longValue());     // Catch: Throwable -> L73
        if ((r93 instanceof String) == true) goto L56;
        r93 = null;
    L56:
        r22 = (String) r93;     // Catch: Throwable -> L73
    L58:
        if ((r21 instanceof JSONObject) == false) goto L60;
    L418:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L66
        Object r94 = SDKSettingsCacheManager.a().fromJson(r21.toString(), String.class);     // Catch: Throwable -> L66
        if ((r94 instanceof String) == true) goto L64;
        r94 = null;
    L64:
        Object r95 = Result.constructor-impl((String) r94);     // Catch: Throwable -> L66
    L68:
        r22 = r95;
        if (Result.isFailure-impl(r22) == false) goto L71;
    L66:
        th = move-exception;
        Result.Companion r96 = Result.Companion;     // Catch: Throwable -> L73
        r95 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L73
        goto L68
    L60:
        if ((r21 instanceof JSONArray) == false) goto L70;
    L27:
        r89 = r21;
    L73:
        th = move-exception;
        Result.Companion r97 = Result.Companion;     // Catch: Throwable -> L180
        r23 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L180
    L180:
        th = move-exception;
        Result.Companion r98 = Result.Companion;
        r25 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r99 = Result.exceptionOrNull-impl(r25);
        if (r99 == null) goto L185;
        EnsureManager.ensureNotReachHere(r99);
    L185:
        if (Result.isFailure-impl(r25) == false) goto L187;
        r25 = "VALUE_EC_DYNAMIC_EVENT_CONFIG_NULL";
        goto L187
    L438:
        return Unit.INSTANCE;
    L7:
        r10 = new CyberProtectionInjector$initConfig$1(r18, r19);
        goto L8
    }

    public final void a(String r10, JSONObject r11) {
        Intrinsics.checkNotNullParameter(r10, "eventName");
        Intrinsics.checkNotNullParameter(r11, "params");
        String r12 = c(r10);
        if (r12 == null) goto L6;
        r11.put("ecom_track_param", r12);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v5, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.util.List<java.lang.Integer>] */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:117:0x0223 -> B:118:0x0227). Please report as a decompilation issue!!! */
    public final Object e(d r21, f r22, List<String> r23, Continuation<? super Unit> r24) {
        if ((r24 instanceof CyberProtectionInjector$parseInitConfig$1) == false) goto L7;
        CyberProtectionInjector$parseInitConfig$1 r10 = (CyberProtectionInjector$parseInitConfig$1) r24;
        int r11 = r10.label;
        if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
        r10.label = r11 - Integer.MIN_VALUE;
    L8:
        Object r1 = r10.result;
        Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r13 = r10.label;
        if (r13 == 0) goto L16;
        if (r13 == 1) goto L15;
        if (r13 != 2) goto L14;
        String r0 = (String) r10.L$2;
        List r14 = (List) r10.L$1;
        k r15 = (k) r10.L$0;
        ResultKt.throwOnFailure(r1);
        ?? r16 = r14;
    L123:
        String r17 = (String) r1;
        if (r17 != null) goto L127;
        b = "0x4aaec536";
        return Unit.INSTANCE;
    L127:
        f = r15;
        c = r16;
        g = r0;
        h = r17;
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        Collection r18 = (Collection) r10.L$4;
        Iterator r19 = (Iterator) r10.L$3;
        Collection r20 = (Collection) r10.L$2;
        List r110 = (List) r10.L$1;
        k r111 = (k) r10.L$0;
        ResultKt.throwOnFailure(r1);
        Object r25 = r12;
        ?? r26 = r110;
        Iterator r112 = r19;
    L118:
        r18.add((String) r1);
        r18 = r20;
        Iterator r27 = r112;
        k r28 = r111;
        ?? r29 = r26;
    L113:
        if (r27.hasNext() == false) goto L119;
        String r113 = (String) r27.next();
        r10.L$0 = r28;
        r10.L$1 = r29;
        r10.L$2 = r18;
        r10.L$3 = r27;
        r10.L$4 = r18;
        r10.label = 1;
        Object r114 = c.c(r113, r10);
        if (r114 != r25) goto L117;
        return r25;
    L117:
        r111 = r28;
        r1 = r114;
        r112 = r27;
        r20 = r18;
        r26 = r29;
        goto L118
    L119:
        r0 = CollectionsKt.joinToString$default((List) r18, "|", null, null, 0, null, null, 62, null);
        r10.L$0 = r28;
        r10.L$1 = r29;
        r10.L$2 = r0;
        r10.L$3 = null;
        r10.L$4 = null;
        r10.label = 2;
        Object r30 = c.b(r0, r10);
        if (r30 != r25) goto L122;
        return r25;
    L122:
        r15 = r28;
        r1 = r30;
        r16 = r29;
        goto L123
    L16:
        ResultKt.throwOnFailure(r1);
        Map<String, String> r31 = r22.b();
        if (r31 != null) goto L19;
        r31 = MapsKt.emptyMap();
    L19:
        List<String> r32 = r23;
        Iterator r33 = r32.iterator();
        int r115 = 0;
    L21:
        if (r33.hasNext() == false) goto L35;
        String r116 = (String) r33.next();
        String r117 = r31.get(r116);
        if (r117 == null) goto L27;
        r116 = r117;
    L27:
        if (c.a(r116) == false) goto L28;
        if (Intrinsics.areEqual(r116, "none") == true) goto L32;
        ListProtector.set(r23, r115, r116);
        r115 = r115 + 1;
        goto L21
    L32:
        b = "0x073f8321";
        return Unit.INSTANCE;
    L28:
        b = "0x8ab62d69";
        return Unit.INSTANCE;
    L35:
        String r34 = r21.d();
        if (r34 == null) goto L43;
        Map<String, String> r35 = r22.a();
        if (r35 == null) goto L44;
        String r36 = r35.get(r34);
        if (r36 == null) goto L44;
        r34 = r36;
    L44:
        if (r34 != null) goto L46;
    L129:
        b = "0xd0b2dce3";
        return Unit.INSTANCE;
    L46:
        if (c.a(r34) == false) goto L129;
        a r37 = i.a;
        int r38 = r34.hashCode();
        switch(r38) {
            case 2281: goto L77;
            case 2282: goto L74;
            case 2283: goto L71;
            case 2284: goto L68;
            case 2285: goto L65;
            case 2286: goto L62;
            case 2287: goto L59;
            case 2288: goto L56;
            case 2289: goto L53;
            default: goto L50;
        };
    L50:
        switch(r38) {
            case 70759: goto L86;
            case 70760: goto L83;
            case 70761: goto L80;
            default: goto L148;
        };
    L148:
        k r39 = null;
    L89:
        if (r39 != null) goto L92;
        b = "0x88748f85";
        return Unit.INSTANCE;
    L92:
        g r40 = r22.c();
        if (r40 == null) goto L110;
        String r118 = r40.b();
        if (r118 == null) goto L110;
        List r41 = StringsKt.split$default(r118, new String[]{","}, false, 0, 6, null);
        if (r41 == null) goto L110;
        List r42 = r41;
        ?? r119 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r42, 10));
        Iterator r43 = r42.iterator();
    L100:
        if (r43.hasNext() == false) goto L111;
        String r120 = (String) r43.next();
        Locale r121 = Locale.ROOT;
        if (r120 == null) goto L109;
        String r122 = StringsKt.replace$default(r120.toUpperCase(r121), "B", "", false, 4, null);
        if (r122 == null) goto L107;
        r119.add(Boxing.boxInt(CastIntegerProtector.parseInt(StringsKt.trim(r122).toString())));
        goto L100
    L107:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    L109:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L111:
        ArrayList r44 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r32, 10));
        r27 = r32.iterator();
        r25 = r12;
        r29 = r119;
        r28 = r39;
        r18 = r44;
    L110:
        r119 = CollectionsKt.emptyList();
        goto L111
    L80:
        if (r34.equals("H12") == false) goto L145;
        r39 = i.l;
        goto L89
    L145:
        r39 = null;
        goto L89
    L83:
        if (r34.equals("H11") == false) goto L146;
        r39 = i.k;
        goto L89
    L146:
        r39 = null;
        goto L89
    L86:
        if (r34.equals("H10") == false) goto L147;
        r39 = i.j;
        goto L89
    L147:
        r39 = null;
        goto L89
    L53:
        if (r34.equals("H9") == false) goto L88;
        r39 = i.i;
        goto L89
    L88:
        r39 = null;
        goto L89
    L56:
        if (r34.equals("H8") == false) goto L137;
        r39 = i.h;
        goto L89
    L137:
        r39 = null;
        goto L89
    L59:
        if (r34.equals("H7") == false) goto L138;
        r39 = i.g;
        goto L89
    L138:
        r39 = null;
        goto L89
    L62:
        if (r34.equals("H6") == false) goto L139;
        r39 = i.f;
        goto L89
    L139:
        r39 = null;
        goto L89
    L65:
        if (r34.equals("H5") == false) goto L140;
        r39 = i.e;
        goto L89
    L140:
        r39 = null;
        goto L89
    L68:
        if (r34.equals("H4") == false) goto L141;
        r39 = i.d;
        goto L89
    L141:
        r39 = null;
        goto L89
    L71:
        if (r34.equals("H3") == false) goto L142;
        r39 = i.c;
        goto L89
    L142:
        r39 = null;
        goto L89
    L74:
        if (r34.equals("H2") == false) goto L143;
        r39 = i.b;
        goto L89
    L143:
        r39 = null;
        goto L89
    L77:
        if (r34.equals("H1") == false) goto L144;
        r39 = i.a;
        goto L89
    L144:
        r39 = null;
        goto L89
    L43:
        r34 = null;
    L7:
        r10 = new CyberProtectionInjector$parseInitConfig$1(this, r24);
        goto L8
    }
}
