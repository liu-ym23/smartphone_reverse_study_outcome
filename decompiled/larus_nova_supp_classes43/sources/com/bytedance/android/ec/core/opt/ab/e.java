package com.bytedance.android.ec.core.opt.ab;

import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.core.imagex.common.z;
import com.bytedance.android.ec.core.utils.t0;
import com.bytedance.android.ec.hybrid.hostapi.IECHybridKevaService;
import com.bytedance.services.apm.api.EnsureManager;
import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class e<T extends z> implements ReadOnlyProperty<Object, com.bytedance.android.ec.core.imagex.common.p<T>> {
    public final LinkedTreeMap<String, Object> a;
    public com.bytedance.android.ec.core.imagex.common.p<T> b;
    public boolean c;
    public final String d;
    public final Function0<Boolean> e;
    public final Type f;

    public e(Function0 r10, Type r11) {
        Intrinsics.checkNotNullParameter("ec_image_tmpl_modify_config", "configKey");
        Intrinsics.checkNotNullParameter(r10, "isEnable");
        Intrinsics.checkNotNullParameter(r11, "type");
        this.d = "ec_image_tmpl_modify_config";
        this.e = r10;
        this.f = r11;
        this.a = new LinkedTreeMap();
    }

    public final Object getValue(Object r11, KProperty r12) {
        Intrinsics.checkNotNullParameter(r11, "thisRef");
        Intrinsics.checkNotNullParameter(r12, "property");
        if (this.c == true) goto L230;
        if (((Boolean) this.e.invoke()).booleanValue() == false) goto L259;
        int r13 = com.bytedance.android.ec.base.settings.b.a;
        String r14 = this.d;
        Object r0 = this.a;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L173
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L173
        SDKSettingsCacheManager r15 = SDKSettingsCacheManager.e;     // Catch: Throwable -> L173
        r15.getClass();     // Catch: Throwable -> L61
        Object r16 = SDKSettingsCacheManager.b.get(r14);     // Catch: Throwable -> L61
        if (r16 != null) goto L13;
    L58:
        Object r17 = null;
    L59:
        Object r18 = Result.constructor-impl(r17);     // Catch: Throwable -> L61
    L63:
        Throwable r19 = Result.exceptionOrNull-impl(r18);     // Catch: Throwable -> L173
        if (r19 == null) goto L67;
        EnsureManager.ensureNotReachHere(r19);     // Catch: Throwable -> L173
    L67:
        if (Result.isFailure-impl(r18) == false) goto L70;
        r18 = null;
    L70:
        if ((r18 instanceof LinkedTreeMap) == true) goto L72;
        r18 = null;
    L72:
        Object r20 = (LinkedTreeMap) r18;     // Catch: Throwable -> L173
        if (r20 != null) goto L79;
        r15.getClass();     // Catch: Throwable -> L173
        Object r21 = SDKSettingsCacheManager.a.get(r14);     // Catch: Throwable -> L173
        if ((r21 instanceof LinkedTreeMap) == true) goto L78;
        r21 = null;
    L78:
        r20 = (LinkedTreeMap) r21;     // Catch: Throwable -> L173
    L79:
        if (r20 != null) goto L182;
        int r22 = com.bytedance.android.ec.base.settings.g.a;     // Catch: Throwable -> L173
    L160:
        th = move-exception;
        Result.Companion r23 = Result.Companion;     // Catch: Throwable -> L173
        Object r24 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L173
    L163:
        if (Result.exceptionOrNull-impl(r24) != null) goto L243;
    L170:
        r20 = r24;
    L171:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L173
        SDKSettingsCacheManager.e(r14, r20);     // Catch: Throwable -> L173
        goto L182
    L243:
        r24 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo(r14, LinkedTreeMap.class, r0);     // Catch: Throwable -> L167
    L168:
        if (r24 != null) goto L170;
        r20 = r0;
    L167:
        r24 = r0;
        goto L168
    L235:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L135
        Object r25 = SDKSettingsCacheManager.b.get(r14);     // Catch: Throwable -> L135
        if (r25 != null) goto L87;
    L132:
        Object r26 = null;
    L133:
        Object r27 = Result.constructor-impl(r26);     // Catch: Throwable -> L135
    L137:
        Throwable r28 = Result.exceptionOrNull-impl(r27);     // Catch: Throwable -> L160
        if (r28 == null) goto L141;
        EnsureManager.ensureNotReachHere(r28);     // Catch: Throwable -> L160
    L141:
        if (Result.isFailure-impl(r27) == false) goto L144;
        r27 = null;
    L144:
        if ((r27 instanceof LinkedTreeMap) == true) goto L146;
        r27 = null;
    L146:
        r24 = (LinkedTreeMap) r27;     // Catch: Throwable -> L160
        if (r24 != null) goto L170;
        jj4.b r29 = jj4.b.b;     // Catch: Throwable -> L160
        Object r30 = jj4.a.a(r14, LinkedTreeMap.class, r0, false);     // Catch: Throwable -> L160
        if (r30 != null) goto L153;
        Intrinsics.throwNpe();     // Catch: Throwable -> L160
    L153:
        if ((r30 instanceof LinkedTreeMap) == true) goto L155;
        r30 = null;
    L155:
        Object r31 = (LinkedTreeMap) r30;     // Catch: Throwable -> L160
        if (r31 != null) goto L158;
        r31 = r0;
    L158:
        r24 = Result.constructor-impl(r31);     // Catch: Throwable -> L160
    L87:
        if ((r25 instanceof LinkedTreeMap) == true) goto L89;
        Object r32 = null;
    L90:
        r26 = (LinkedTreeMap) r32;     // Catch: Throwable -> L135
        if (r26 != null) goto L133;
        if ((r25 instanceof Number) == false) goto L120;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(LinkedTreeMap.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L102;
        Float r33 = Float.valueOf(((Number) r25).floatValue());     // Catch: Throwable -> L135
        if ((r33 instanceof LinkedTreeMap) == true) goto L100;
        r33 = null;
    L100:
        r26 = (LinkedTreeMap) r33;     // Catch: Throwable -> L135
        goto L133
    L102:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(LinkedTreeMap.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L108;
        Double r34 = Double.valueOf(((Number) r25).doubleValue());     // Catch: Throwable -> L135
        if ((r34 instanceof LinkedTreeMap) == true) goto L106;
        r34 = null;
    L106:
        r26 = (LinkedTreeMap) r34;     // Catch: Throwable -> L135
        goto L133
    L108:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(LinkedTreeMap.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L114;
        Integer r35 = Integer.valueOf(((Number) r25).intValue());     // Catch: Throwable -> L135
        if ((r35 instanceof LinkedTreeMap) == true) goto L112;
        r35 = null;
    L112:
        r26 = (LinkedTreeMap) r35;     // Catch: Throwable -> L135
        goto L133
    L114:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(LinkedTreeMap.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L120;
        Long r36 = Long.valueOf(((Number) r25).longValue());     // Catch: Throwable -> L135
        if ((r36 instanceof LinkedTreeMap) == true) goto L118;
        r36 = null;
    L118:
        r26 = (LinkedTreeMap) r36;     // Catch: Throwable -> L135
    L120:
        if ((r25 instanceof JSONObject) == false) goto L122;
    L247:
        Object r37 = SDKSettingsCacheManager.a().fromJson(r25.toString(), LinkedTreeMap.class);     // Catch: Throwable -> L128
        if ((r37 instanceof LinkedTreeMap) == true) goto L126;
        r37 = null;
    L126:
        Object r38 = Result.constructor-impl((LinkedTreeMap) r37);     // Catch: Throwable -> L128
    L130:
        r26 = r38;
        if (Result.isFailure-impl(r26) == false) goto L133;
    L128:
        th = move-exception;
        Result.Companion r39 = Result.Companion;     // Catch: Throwable -> L135
        r38 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L135
        goto L130
    L122:
        if ((r25 instanceof JSONArray) == false) goto L132;
    L89:
        r32 = r25;
    L135:
        th = move-exception;
        Result.Companion r40 = Result.Companion;     // Catch: Throwable -> L160
        r27 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L160
    L182:
        LinkedTreeMap<String, Object> r41 = (LinkedTreeMap) r20;
        if (r41 == this.a) goto L228;
        this.c = true;
        int r110 = t0.a;
        Gson r111 = t0.a.a;
        Result.Companion r42 = Result.Companion;     // Catch: Throwable -> L187
        Object r112 = Result.constructor-impl((com.bytedance.android.ec.core.imagex.common.r) r111.fromJson(r111.toJson(r41), this.f));     // Catch: Throwable -> L187
    L190:
        if (Result.isFailure-impl(r112) == false) goto L192;
        r112 = null;
    L192:
        com.bytedance.android.ec.core.imagex.common.r r113 = (com.bytedance.android.ec.core.imagex.common.r) r112;
        if (r113 == null) goto L226;
        Intrinsics.checkNotNullParameter(r113, "$this$mapFastSdk");
        HashMap r43 = new HashMap();
        if (r113.c() == null) goto L225;
        Iterator<com.bytedance.android.ec.core.imagex.common.y<T>> r44 = r113.c().iterator();
    L198:
        if (r44.hasNext() == false) goto L225;
        com.bytedance.android.ec.core.imagex.common.y<T> r45 = r44.next();
        List<String> r46 = r45.b();
        if (r46 != null) goto L205;
        String r47 = r45.a();
        if (r47 == null) goto L204;
        r46 = CollectionsKt.listOf(r47);
        goto L205
    L204:
        r46 = null;
    L205:
        if (r46 != null) goto L207;
        r46 = CollectionsKt.emptyList();
    L207:
        Iterator<String> r48 = r46.iterator();
    L209:
        if (r48.hasNext() == false) goto L198;
        String r49 = r48.next();
        List<T> r50 = r45.c();
        if (r50 == null) goto L213;
        List r51 = g.a(r50);
    L214:
        if (r51 == null) goto L209;
        List r52 = (List) r43.get(r49);
        if (r52 != null) goto L218;
    L221:
        boolean r53 = true;
    L222:
        if (r53 == true) goto L223;
        r43.put(r49, CollectionsKt.plus(r52, r51));
        goto L209
    L223:
        r43.put(r49, r51);
        goto L209
    L218:
        if (r52.isEmpty() == true) goto L221;
        r53 = false;
        goto L222
    L213:
        r51 = null;
    L225:
        com.bytedance.android.ec.core.imagex.common.p<T> r1 = new com.bytedance.android.ec.core.imagex.common.p(r43, g.a(r113.b()), g.a(r113.a()));
    L227:
        this.b = r1;
        goto L230
    L226:
        r1 = null;
    L187:
        th = move-exception;
        Result.Companion r54 = Result.Companion;
        r112 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L190
    L228:
        this.c = true;
        goto L230
    L13:
        if ((r16 instanceof LinkedTreeMap) == true) goto L15;
        Object r55 = null;
    L16:
        r17 = (LinkedTreeMap) r55;     // Catch: Throwable -> L61
        if (r17 != null) goto L59;
        if ((r16 instanceof Number) == false) goto L46;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(LinkedTreeMap.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L28;
        Float r56 = Float.valueOf(((Number) r16).floatValue());     // Catch: Throwable -> L61
        if ((r56 instanceof LinkedTreeMap) == true) goto L26;
        r56 = null;
    L26:
        r17 = (LinkedTreeMap) r56;     // Catch: Throwable -> L61
        goto L59
    L28:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(LinkedTreeMap.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L34;
        Double r57 = Double.valueOf(((Number) r16).doubleValue());     // Catch: Throwable -> L61
        if ((r57 instanceof LinkedTreeMap) == true) goto L32;
        r57 = null;
    L32:
        r17 = (LinkedTreeMap) r57;     // Catch: Throwable -> L61
        goto L59
    L34:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(LinkedTreeMap.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L40;
        Integer r58 = Integer.valueOf(((Number) r16).intValue());     // Catch: Throwable -> L61
        if ((r58 instanceof LinkedTreeMap) == true) goto L38;
        r58 = null;
    L38:
        r17 = (LinkedTreeMap) r58;     // Catch: Throwable -> L61
        goto L59
    L40:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(LinkedTreeMap.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L46;
        Long r59 = Long.valueOf(((Number) r16).longValue());     // Catch: Throwable -> L61
        if ((r59 instanceof LinkedTreeMap) == true) goto L44;
        r59 = null;
    L44:
        r17 = (LinkedTreeMap) r59;     // Catch: Throwable -> L61
    L46:
        if ((r16 instanceof JSONObject) == false) goto L48;
    L233:
        Object r60 = SDKSettingsCacheManager.a().fromJson(r16.toString(), LinkedTreeMap.class);     // Catch: Throwable -> L54
        if ((r60 instanceof LinkedTreeMap) == true) goto L52;
        r60 = null;
    L52:
        Object r61 = Result.constructor-impl((LinkedTreeMap) r60);     // Catch: Throwable -> L54
    L56:
        r17 = r61;
        if (Result.isFailure-impl(r17) == false) goto L59;
    L54:
        th = move-exception;
        Result.Companion r62 = Result.Companion;     // Catch: Throwable -> L61
        r61 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L61
        goto L56
    L48:
        if ((r16 instanceof JSONArray) == false) goto L58;
    L15:
        r55 = r16;
    L61:
        th = move-exception;
        Result.Companion r63 = Result.Companion;     // Catch: Throwable -> L173
        r18 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L173
    L173:
        th = move-exception;
        Result.Companion r64 = Result.Companion;
        Object r114 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r65 = Result.exceptionOrNull-impl(r114);
        if (r65 == null) goto L178;
        EnsureManager.ensureNotReachHere(r65);
    L178:
        if (Result.isFailure-impl(r114) == true) goto L181;
        r0 = r114;
    L181:
        r20 = r0;
        goto L182
    L259:
        return null;
    L230:
        if (this.c == true) goto L232;
        return null;
    L232:
        return this.b;
    }
}
