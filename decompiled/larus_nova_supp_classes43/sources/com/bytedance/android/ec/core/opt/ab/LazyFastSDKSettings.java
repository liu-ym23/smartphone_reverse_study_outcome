package com.bytedance.android.ec.core.opt.ab;

import com.bytedance.android.ec.ab.opt.LazyOptGetSettings;
import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.android.ec.hybrid.hostapi.IECHybridKevaService;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.services.apm.api.EnsureManager;
import com.google.gson.Gson;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class LazyFastSDKSettings<Config> extends LazyOptGetSettings<Config> {
    public static final AtomicBoolean j = null;
    public static boolean k;
    public final boolean d;
    public final Config e;
    public final com.bytedance.android.ec.ab.opt.a<Config> f;
    public final Function0<Boolean> g;
    public final Function2<Config, Continuation<? super Unit>, Object> h;
    public final Function0<Config> i;

    public static final class a {
    }

    static {
        j = new AtomicBoolean(false);
    }

    @Override // com.bytedance.android.ec.ab.opt.LazyOptGetSettings
    public final Config b() {
        return this.e;
    }

    @Override // com.bytedance.android.ec.ab.opt.LazyOptGetSettings
    public final com.bytedance.android.ec.ab.opt.a<Config> c() {
        return this.f;
    }

    @Override // com.bytedance.android.ec.ab.opt.LazyOptGetSettings
    public final Function2<Config, Continuation<? super Unit>, Object> d() {
        return this.h;
    }

    @Override // com.bytedance.android.ec.ab.opt.LazyOptGetSettings
    public final boolean f() {
        return this.d;
    }

    @Override // com.bytedance.android.ec.ab.opt.LazyOptGetSettings
    public final Function0<Boolean> g() {
        return this.g;
    }

    @Override // com.bytedance.android.ec.ab.opt.LazyOptGetSettings
    public final Object e(Continuation<? super Config> r10) {
        Object r0 = this.i.invoke();
        if (this.e.getClass().isAssignableFrom(r0.getClass()) == false) goto L5;
        return r0;
    L5:
        if (LazyOptGetSettings.h() == true) goto L15;
        Gson r11 = u0.c();     // Catch: Throwable -> L9
        return r11.fromJson(r11.toJson(r0), this.e.getClass());
    L9:
        th = move-exception;
        EnsureManager.ensureNotReachHere(th);
        return this.e;
    L15:
        return BuildersKt.withContext(Dispatchers.getIO(), new LazyFastSDKSettings$getSettingsValue$2(this, r0, null), r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LazyFastSDKSettings(String r10, Config r11, com.bytedance.android.ec.ab.opt.a<Config> r12, Function0<Boolean> r13, Function2<? super Config, ? super Continuation<? super Unit>, ? extends Object> r14, Function0<? extends Config> r15) {
        Intrinsics.checkNotNullParameter(r10, "configKey");
        Intrinsics.checkNotNullParameter(r11, "defaultConfig");
        Intrinsics.checkNotNullParameter(r13, "isEnable");
        Intrinsics.checkNotNullParameter(r15, "settingsProvider");
        this.e = r11;
        this.f = r12;
        this.g = r13;
        this.h = r14;
        this.i = r15;
        Lazy r16 = ECAppInfoService.a;     // Catch: Throwable -> L185
        if (ECAppInfoService.m() == true) goto L186;
        int r17 = com.bytedance.android.ec.base.settings.b.a;     // Catch: Throwable -> L185
        Object r18 = Boolean.FALSE;     // Catch: Throwable -> L185
        Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L174
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L174
        SDKSettingsCacheManager r20 = SDKSettingsCacheManager.e;     // Catch: Throwable -> L174
        Object r21 = null;
        r20.getClass();     // Catch: Throwable -> L61
        Object r22 = SDKSettingsCacheManager.b.get("ec_use_settings_default_local_config");     // Catch: Throwable -> L61
        if (r22 != null) goto L13;
    L58:
        Object r0 = null;
    L59:
        Object r23 = Result.constructor-impl(r0);     // Catch: Throwable -> L61
    L63:
        Throwable r1 = Result.exceptionOrNull-impl(r23);     // Catch: Throwable -> L174
        if (r1 == null) goto L67;
        EnsureManager.ensureNotReachHere(r1);     // Catch: Throwable -> L174
    L67:
        if (Result.isFailure-impl(r23) == false) goto L70;
        r23 = null;
    L70:
        if ((r23 instanceof Boolean) == true) goto L72;
        r23 = null;
    L72:
        Object r24 = (Boolean) r23;     // Catch: Throwable -> L174
        if (r24 != null) goto L79;
        r20.getClass();     // Catch: Throwable -> L174
        Object r25 = SDKSettingsCacheManager.a.get("ec_use_settings_default_local_config");     // Catch: Throwable -> L174
        if ((r25 instanceof Boolean) == true) goto L78;
        r25 = null;
    L78:
        r24 = (Boolean) r25;     // Catch: Throwable -> L174
    L79:
        if (r24 != null) goto L183;
        int r26 = com.bytedance.android.ec.base.settings.g.a;     // Catch: Throwable -> L174
    L161:
        th = move-exception;
        Result.Companion r27 = Result.Companion;     // Catch: Throwable -> L174
        Object r28 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L174
    L164:
        if (Result.exceptionOrNull-impl(r28) != null) goto L201;
    L171:
        r24 = r28;
    L172:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L174
        SDKSettingsCacheManager.e("ec_use_settings_default_local_config", r24);     // Catch: Throwable -> L174
    L201:
        r28 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("ec_use_settings_default_local_config", Boolean.class, r18);     // Catch: Throwable -> L168
    L169:
        if (r28 != null) goto L171;
        r24 = r18;
    L168:
        r28 = r18;
        goto L169
    L195:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L135
        Object r29 = SDKSettingsCacheManager.b.get("ec_use_settings_default_local_config");     // Catch: Throwable -> L135
        if (r29 != null) goto L87;
    L132:
        Object r30 = null;
    L133:
        Object r31 = Result.constructor-impl(r30);     // Catch: Throwable -> L135
    L137:
        Throwable r32 = Result.exceptionOrNull-impl(r31);     // Catch: Throwable -> L161
        if (r32 == null) goto L141;
        EnsureManager.ensureNotReachHere(r32);     // Catch: Throwable -> L161
    L141:
        if (Result.isFailure-impl(r31) == false) goto L144;
        r31 = null;
    L144:
        if ((r31 instanceof Boolean) == true) goto L146;
        r31 = null;
    L146:
        r28 = (Boolean) r31;     // Catch: Throwable -> L161
        if (r28 != null) goto L171;
        jj4.b r33 = jj4.b.b;     // Catch: Throwable -> L161
        Object r34 = jj4.a.a("ec_use_settings_default_local_config", Boolean.class, r18, false);     // Catch: Throwable -> L161
        if (r34 != null) goto L153;
        Intrinsics.throwNpe();     // Catch: Throwable -> L161
    L153:
        if ((r34 instanceof Boolean) == false) goto L156;
        r21 = r34;
    L156:
        Object r35 = (Boolean) r21;     // Catch: Throwable -> L161
        if (r35 != null) goto L159;
        r35 = r18;
    L159:
        r28 = Result.constructor-impl(r35);     // Catch: Throwable -> L161
    L87:
        if ((r29 instanceof Boolean) == true) goto L89;
        Object r36 = null;
    L90:
        r30 = (Boolean) r36;     // Catch: Throwable -> L135
        if (r30 != null) goto L133;
        if ((r29 instanceof Number) == false) goto L120;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L102;
        Float r37 = Float.valueOf(((Number) r29).floatValue());     // Catch: Throwable -> L135
        if ((r37 instanceof Boolean) == true) goto L100;
        r37 = null;
    L100:
        r30 = (Boolean) r37;     // Catch: Throwable -> L135
        goto L133
    L102:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L108;
        Double r38 = Double.valueOf(((Number) r29).doubleValue());     // Catch: Throwable -> L135
        if ((r38 instanceof Boolean) == true) goto L106;
        r38 = null;
    L106:
        r30 = (Boolean) r38;     // Catch: Throwable -> L135
        goto L133
    L108:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L114;
        Integer r39 = Integer.valueOf(((Number) r29).intValue());     // Catch: Throwable -> L135
        if ((r39 instanceof Boolean) == true) goto L112;
        r39 = null;
    L112:
        r30 = (Boolean) r39;     // Catch: Throwable -> L135
        goto L133
    L114:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L120;
        Long r40 = Long.valueOf(((Number) r29).longValue());     // Catch: Throwable -> L135
        if ((r40 instanceof Boolean) == true) goto L118;
        r40 = null;
    L118:
        r30 = (Boolean) r40;     // Catch: Throwable -> L135
    L120:
        if ((r29 instanceof JSONObject) == false) goto L122;
    L205:
        Object r41 = SDKSettingsCacheManager.a().fromJson(r29.toString(), Boolean.class);     // Catch: Throwable -> L128
        if ((r41 instanceof Boolean) == true) goto L126;
        r41 = null;
    L126:
        Object r42 = Result.constructor-impl((Boolean) r41);     // Catch: Throwable -> L128
    L130:
        r30 = r42;
        if (Result.isFailure-impl(r30) == false) goto L133;
    L128:
        th = move-exception;
        Result.Companion r43 = Result.Companion;     // Catch: Throwable -> L135
        r42 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L135
        goto L130
    L122:
        if ((r29 instanceof JSONArray) == false) goto L132;
    L89:
        r36 = r29;
    L135:
        th = move-exception;
        Result.Companion r44 = Result.Companion;     // Catch: Throwable -> L161
        r31 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L161
    L183:
        boolean r45 = ((Boolean) r24).booleanValue();     // Catch: Throwable -> L185
    L187:
        this.d = r45;
        if (k == false) goto L190;
        return;
    L190:
        if (j.compareAndSet(false, true) == false) goto L210;
        k = true;
        return;
    L210:
        return;
    L13:
        if ((r22 instanceof Boolean) == true) goto L15;
        Object r46 = null;
    L16:
        r0 = (Boolean) r46;     // Catch: Throwable -> L61
        if (r0 != null) goto L59;
        if ((r22 instanceof Number) == false) goto L46;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L28;
        Float r47 = Float.valueOf(((Number) r22).floatValue());     // Catch: Throwable -> L61
        if ((r47 instanceof Boolean) == true) goto L26;
        r47 = null;
    L26:
        r0 = (Boolean) r47;     // Catch: Throwable -> L61
        goto L59
    L28:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L34;
        Double r48 = Double.valueOf(((Number) r22).doubleValue());     // Catch: Throwable -> L61
        if ((r48 instanceof Boolean) == true) goto L32;
        r48 = null;
    L32:
        r0 = (Boolean) r48;     // Catch: Throwable -> L61
        goto L59
    L34:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L40;
        Integer r49 = Integer.valueOf(((Number) r22).intValue());     // Catch: Throwable -> L61
        if ((r49 instanceof Boolean) == true) goto L38;
        r49 = null;
    L38:
        r0 = (Boolean) r49;     // Catch: Throwable -> L61
        goto L59
    L40:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L46;
        Long r50 = Long.valueOf(((Number) r22).longValue());     // Catch: Throwable -> L61
        if ((r50 instanceof Boolean) == true) goto L44;
        r50 = null;
    L44:
        r0 = (Boolean) r50;     // Catch: Throwable -> L61
    L46:
        if ((r22 instanceof JSONObject) == false) goto L48;
    L193:
        Object r51 = SDKSettingsCacheManager.a().fromJson(r22.toString(), Boolean.class);     // Catch: Throwable -> L54
        if ((r51 instanceof Boolean) == true) goto L52;
        r51 = null;
    L52:
        Object r52 = Result.constructor-impl((Boolean) r51);     // Catch: Throwable -> L54
    L56:
        r0 = r52;
        if (Result.isFailure-impl(r0) == false) goto L59;
    L54:
        th = move-exception;
        Result.Companion r53 = Result.Companion;     // Catch: Throwable -> L61
        r52 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L61
        goto L56
    L48:
        if ((r22 instanceof JSONArray) == false) goto L58;
    L15:
        r46 = r22;
    L61:
        th = move-exception;
        Result.Companion r54 = Result.Companion;     // Catch: Throwable -> L174
        r23 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L174
    L174:
        th = move-exception;
        Result.Companion r55 = Result.Companion;     // Catch: Throwable -> L185
        Object r56 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L185
        Throwable r57 = Result.exceptionOrNull-impl(r56);     // Catch: Throwable -> L185
        if (r57 == null) goto L179;
        EnsureManager.ensureNotReachHere(r57);     // Catch: Throwable -> L185
    L179:
        if (Result.isFailure-impl(r56) == true) goto L182;
        r18 = r56;
    L182:
        r24 = r18;
    L186:
        r45 = false;
    L185:
        ECExceptionMonitor.c("LazyFastSDKSettings json error");
        goto L186
    }
}
