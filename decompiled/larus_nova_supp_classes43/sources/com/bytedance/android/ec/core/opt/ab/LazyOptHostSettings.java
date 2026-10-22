package com.bytedance.android.ec.core.opt.ab;

import com.bytedance.android.ec.ab.opt.LazyOptGetSettings;
import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.core.imagex.ImageExperiments;
import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.services.apm.api.EnsureManager;
import com.google.gson.Gson;
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
public final class LazyOptHostSettings<Config> extends LazyOptGetSettings<Config> {
    public static final AtomicBoolean j = null;
    public static boolean k;
    public final boolean d;
    public final String e;
    public final Config f;
    public final com.bytedance.android.ec.ab.opt.a<Config> g;
    public final Function0<Boolean> h;
    public final Function2<Config, Continuation<? super Unit>, Object> i;

    public static final class a {
    }

    static {
        j = new AtomicBoolean(false);
    }

    @Override // com.bytedance.android.ec.ab.opt.LazyOptGetSettings
    public final boolean i() {
        ImageExperiments.G.getClass();
        if (((Boolean) ImageExperiments.k.getValue()).booleanValue() == false) goto L9;
        cj.b r0 = (cj.b) h.b.getValue(null, h.a[0]);
        if (r0 == null) goto L10;
        r0.k(this.e);
        return true;
    L10:
        return true;
    L9:
        return true;
    }

    @Override // com.bytedance.android.ec.ab.opt.LazyOptGetSettings
    public final Config b() {
        return this.f;
    }

    @Override // com.bytedance.android.ec.ab.opt.LazyOptGetSettings
    public final com.bytedance.android.ec.ab.opt.a<Config> c() {
        return this.g;
    }

    @Override // com.bytedance.android.ec.ab.opt.LazyOptGetSettings
    public final Function2<Config, Continuation<? super Unit>, Object> d() {
        return this.i;
    }

    @Override // com.bytedance.android.ec.ab.opt.LazyOptGetSettings
    public final boolean f() {
        return this.d;
    }

    @Override // com.bytedance.android.ec.ab.opt.LazyOptGetSettings
    public final Function0<Boolean> g() {
        return this.h;
    }

    @Override // com.bytedance.android.ec.ab.opt.LazyOptGetSettings
    public final Object e(Continuation<? super Config> r10) {
        cj.b r0 = (cj.b) h.b.getValue(null, h.a[0]);
        if (r0 == null) goto L6;
        Object r1 = r0.a(this.e, this.f);
        if (r1 == null) goto L6;
    L8:
        if (this.f.getClass().isAssignableFrom(r1.getClass()) == false) goto L10;
        return r1;
    L10:
        if (LazyOptGetSettings.h() == false) goto L18;
        Object r11 = BuildersKt.withContext(Dispatchers.getIO(), new LazyOptHostSettings$getSettingsValue$2(this, r1, null), r10);
    L17:
        return r11;
    L18:
        Gson r12 = u0.c();     // Catch: Throwable -> L14
        r11 = r12.fromJson(r12.toJson(r1), this.f.getClass());     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        EnsureManager.ensureNotReachHere(th);
        r11 = this.f;
    L6:
        r1 = this.f;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LazyOptHostSettings(String r10, Object r11, com.bytedance.android.ec.core.imagex.opt.w.b r12, Function0 r13, Function2 r14) {
        Intrinsics.checkNotNullParameter(r10, "configKey");
        Intrinsics.checkNotNullParameter(r11, "defaultConfig");
        Intrinsics.checkNotNullParameter(r13, "isEnable");
        this.e = r10;
        this.f = r11;
        this.g = r12;
        this.h = r13;
        this.i = r14;
        Lazy r15 = ECAppInfoService.a;     // Catch: Throwable -> L181
        if (ECAppInfoService.m() == true) goto L182;
        int r16 = n.a;     // Catch: Throwable -> L181
        Object r17 = Boolean.FALSE;     // Catch: Throwable -> L181
        int r18 = com.bytedance.android.ec.base.settings.a.a;     // Catch: Throwable -> L181
        Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L170
        Object r20 = null;
        Object r21 = com.bytedance.android.ec.base.settings.d.c.get("ec_use_settings_default_local_config");     // Catch: Throwable -> L61
        if (r21 != null) goto L13;
    L58:
        Object r0 = null;
    L59:
        Object r22 = Result.constructor-impl(r0);     // Catch: Throwable -> L61
    L63:
        Throwable r1 = Result.exceptionOrNull-impl(r22);     // Catch: Throwable -> L170
        if (r1 == null) goto L67;
        EnsureManager.ensureNotReachHere(r1);     // Catch: Throwable -> L170
    L67:
        if (Result.isFailure-impl(r22) == false) goto L70;
        r22 = null;
    L70:
        if ((r22 instanceof Boolean) == true) goto L72;
        r22 = null;
    L72:
        Object r23 = (Boolean) r22;     // Catch: Throwable -> L170
        if (r23 != null) goto L79;
        Object r24 = com.bytedance.android.ec.base.settings.d.a.get("ec_use_settings_default_local_config");     // Catch: Throwable -> L170
        if ((r24 instanceof Boolean) == true) goto L78;
        r24 = null;
    L78:
        r23 = (Boolean) r24;     // Catch: Throwable -> L170
    L79:
        if (r23 != null) goto L179;
        int r25 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L170
        Object r26 = com.bytedance.android.ec.base.settings.d.c.get("ec_use_settings_default_local_config");     // Catch: Throwable -> L134
        if (r26 != null) goto L86;
    L131:
        Object r27 = null;
    L132:
        Object r28 = Result.constructor-impl(r27);     // Catch: Throwable -> L134
    L136:
        Throwable r29 = Result.exceptionOrNull-impl(r28);     // Catch: Throwable -> L160
        if (r29 == null) goto L140;
        EnsureManager.ensureNotReachHere(r29);     // Catch: Throwable -> L160
    L140:
        if (Result.isFailure-impl(r28) == false) goto L143;
        r28 = null;
    L143:
        if ((r28 instanceof Boolean) == true) goto L145;
        r28 = null;
    L145:
        r23 = (Boolean) r28;     // Catch: Throwable -> L160
        if (r23 != null) goto L168;
        IHybridHostService r30 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L160
        if (r30 == null) goto L151;
        Object r31 = r30.getHostABValue("ec_use_settings_default_local_config", r17);     // Catch: Throwable -> L160
    L152:
        if (r31 != null) goto L154;
    L159:
        r23 = r17;
        goto L168
    L154:
        if ((r31 instanceof Boolean) == false) goto L157;
        r20 = r31;
    L157:
        Object r32 = (Boolean) r20;     // Catch: Throwable -> L160
        if (r32 == null) goto L159;
    L167:
        r23 = r32;
        goto L168
        goto L182
    L151:
        r31 = null;
    L168:
        com.bytedance.android.ec.base.settings.d.d("ec_use_settings_default_local_config", r23);     // Catch: Throwable -> L170
        goto L182
        goto L182
    L86:
        if ((r26 instanceof Boolean) == true) goto L88;
        Object r33 = null;
    L89:
        r27 = (Boolean) r33;     // Catch: Throwable -> L134
        if (r27 != null) goto L132;
        if ((r26 instanceof Number) == false) goto L119;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L101;
        Float r34 = Float.valueOf(((Number) r26).floatValue());     // Catch: Throwable -> L134
        if ((r34 instanceof Boolean) == true) goto L99;
        r34 = null;
    L99:
        r27 = (Boolean) r34;     // Catch: Throwable -> L134
        goto L132
    L101:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L107;
        Double r35 = Double.valueOf(((Number) r26).doubleValue());     // Catch: Throwable -> L134
        if ((r35 instanceof Boolean) == true) goto L105;
        r35 = null;
    L105:
        r27 = (Boolean) r35;     // Catch: Throwable -> L134
        goto L132
    L107:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L113;
        Integer r36 = Integer.valueOf(((Number) r26).intValue());     // Catch: Throwable -> L134
        if ((r36 instanceof Boolean) == true) goto L111;
        r36 = null;
    L111:
        r27 = (Boolean) r36;     // Catch: Throwable -> L134
        goto L132
    L113:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L119;
        Long r37 = Long.valueOf(((Number) r26).longValue());     // Catch: Throwable -> L134
        if ((r37 instanceof Boolean) == true) goto L117;
        r37 = null;
    L117:
        r27 = (Boolean) r37;     // Catch: Throwable -> L134
    L119:
        if ((r26 instanceof JSONObject) == false) goto L121;
    L189:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L127
        Object r38 = SDKSettingsCacheManager.a().fromJson(r26.toString(), Boolean.class);     // Catch: Throwable -> L127
        if ((r38 instanceof Boolean) == true) goto L125;
        r38 = null;
    L125:
        Object r39 = Result.constructor-impl((Boolean) r38);     // Catch: Throwable -> L127
    L129:
        r27 = r39;
        if (Result.isFailure-impl(r27) == false) goto L132;
    L127:
        th = move-exception;
        Result.Companion r40 = Result.Companion;     // Catch: Throwable -> L134
        r39 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L134
        goto L129
    L121:
        if ((r26 instanceof JSONArray) == false) goto L131;
    L88:
        r33 = r26;
    L160:
        th = move-exception;
        Result.Companion r41 = Result.Companion;     // Catch: Throwable -> L170
        r32 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L170
        Throwable r42 = Result.exceptionOrNull-impl(r32);     // Catch: Throwable -> L170
        if (r42 == null) goto L165;
        EnsureManager.ensureNotReachHere(r42);     // Catch: Throwable -> L170
    L165:
        if (Result.isFailure-impl(r32) == false) goto L167;
        r32 = r17;
    L134:
        th = move-exception;
        Result.Companion r43 = Result.Companion;     // Catch: Throwable -> L160
        r28 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L160
    L179:
        boolean r44 = ((Boolean) r23).booleanValue();     // Catch: Throwable -> L181
    L183:
        this.d = r44;
        if (k == false) goto L186;
        return;
    L186:
        if (j.compareAndSet(false, true) == false) goto L203;
        k = true;
        return;
    L203:
        return;
        goto L182
    L13:
        if ((r21 instanceof Boolean) == true) goto L15;
        Object r45 = null;
    L16:
        r0 = (Boolean) r45;     // Catch: Throwable -> L61
        if (r0 != null) goto L59;
        if ((r21 instanceof Number) == false) goto L46;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L28;
        Float r46 = Float.valueOf(((Number) r21).floatValue());     // Catch: Throwable -> L61
        if ((r46 instanceof Boolean) == true) goto L26;
        r46 = null;
    L26:
        r0 = (Boolean) r46;     // Catch: Throwable -> L61
        goto L59
    L28:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L34;
        Double r47 = Double.valueOf(((Number) r21).doubleValue());     // Catch: Throwable -> L61
        if ((r47 instanceof Boolean) == true) goto L32;
        r47 = null;
    L32:
        r0 = (Boolean) r47;     // Catch: Throwable -> L61
        goto L59
    L34:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L40;
        Integer r48 = Integer.valueOf(((Number) r21).intValue());     // Catch: Throwable -> L61
        if ((r48 instanceof Boolean) == true) goto L38;
        r48 = null;
    L38:
        r0 = (Boolean) r48;     // Catch: Throwable -> L61
        goto L59
    L40:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L46;
        Long r49 = Long.valueOf(((Number) r21).longValue());     // Catch: Throwable -> L61
        if ((r49 instanceof Boolean) == true) goto L44;
        r49 = null;
    L44:
        r0 = (Boolean) r49;     // Catch: Throwable -> L61
    L46:
        if ((r21 instanceof JSONObject) == false) goto L48;
    L197:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L54
        Object r50 = SDKSettingsCacheManager.a().fromJson(r21.toString(), Boolean.class);     // Catch: Throwable -> L54
        if ((r50 instanceof Boolean) == true) goto L52;
        r50 = null;
    L52:
        Object r51 = Result.constructor-impl((Boolean) r50);     // Catch: Throwable -> L54
    L56:
        r0 = r51;
        if (Result.isFailure-impl(r0) == false) goto L59;
    L54:
        th = move-exception;
        Result.Companion r52 = Result.Companion;     // Catch: Throwable -> L61
        r51 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L61
        goto L56
    L48:
        if ((r21 instanceof JSONArray) == false) goto L58;
    L15:
        r45 = r21;
    L61:
        th = move-exception;
        Result.Companion r53 = Result.Companion;     // Catch: Throwable -> L170
        r22 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L170
    L170:
        th = move-exception;
        Result.Companion r54 = Result.Companion;     // Catch: Throwable -> L181
        Object r55 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L181
        Throwable r56 = Result.exceptionOrNull-impl(r55);     // Catch: Throwable -> L181
        if (r56 == null) goto L175;
        EnsureManager.ensureNotReachHere(r56);     // Catch: Throwable -> L181
    L175:
        if (Result.isFailure-impl(r55) == true) goto L178;
        r17 = r55;
    L178:
        r23 = r17;
    L182:
        r44 = false;
        goto L183
    }
}
