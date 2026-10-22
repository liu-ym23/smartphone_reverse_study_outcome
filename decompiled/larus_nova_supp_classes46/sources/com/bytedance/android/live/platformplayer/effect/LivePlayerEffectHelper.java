package com.bytedance.android.live.platformplayer.effect;

import com.bytedance.android.annie.util.ThreadUtils;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.v0;
import com.bytedance.android.live.core.setting.v2.update.SettingIncStrategy;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.config.or;
import com.bytedance.android.livesdk.live.extension.plugin.api.effectsdk.ILiveWrappedEffectSDKService;
import com.bytedance.android.livesdk.utils.EnterOptimizeUtil;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.live.config.setting.LiveVr6DofEffectConfig;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.performance.task.AtlasAsyncExecutor;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.performance.task.AtlasAsyncExtKt;
import com.bytedance.android.livesdkapi.roomplayer.PlayerEffectLogLevel;
import com.bytedance.android.livesdkapi.roomplayer.VideoEffectCallback;
import com.bytedance.android.livesdkapi.roomplayer.VideoEffectInitConfigBuilder;
import com.bytedance.android.livesdkapi.roomplayer.VideoEffectMessageListener;
import com.bytedance.android.livesdkapi.roomplayer.VideoEffectResourceFinder;
import com.bytedance.common.utility.concurrent.TTExecutors;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.videoarch.liveplayer.log.VeLivePlayerLogConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class LivePlayerEffectHelper implements com.bytedance.android.live.platformplayer.effect.b {
    public final Lazy a;
    public final Lazy b;
    public List<com.bytedance.android.live.platformplayer.effect.a> c;
    public Map<String, ? extends Object> d;
    public String e;
    public final Object f;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ LivePlayerEffectHelper a;

        public b(LivePlayerEffectHelper r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L11;
            return;
        L11:
            throw th;
        L3:
            if (EnterOptimizeUtil.b() == false) goto L5;
            ALogger.d("EnterOptimizeUtil", "live player effect prepare on sub thread");     // Catch: Throwable -> L7
            this.a.d();     // Catch: Throwable -> L7
            this.a.c();     // Catch: Throwable -> L7
        L5:
            this.a.b();     // Catch: Throwable -> L7
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ LivePlayerEffectHelper a;

        public c(LivePlayerEffectHelper r1) {
            this.a = r1;
        }

        public final void a() {
            LivePlayerEffectHelper r0 = this.a;
            if (r0.e != null) goto L5;
            return;
        L5:
            Object r1 = r0.f;
            monitor-enter(r1);
            LivePlayerEffectHelper r2 = this.a;     // Catch: Throwable -> L14
            if (r2.e != null) goto L11;
            monitor-exit(r1);
            return;
        L11:
            r2.d();     // Catch: Throwable -> L14
            this.a.c();     // Catch: Throwable -> L14
            this.a.b();     // Catch: Throwable -> L14
            Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L14
            monitor-exit(r1);
            return;
        L14:
            th = move-exception;
            throw th;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
        VeLivePlayerLogConfig.VeLivePlayerLogLevel r0 = VeLivePlayerLogConfig.VeLivePlayerLogLevel.VeLivePlayerLogLevelVerbose;
    }

    public final void b() {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L21
        JSONArray r2 = new JSONArray();     // Catch: Throwable -> L21
        int r3 = this.c.size();     // Catch: Throwable -> L21
        int r4 = 0;
    L4:
        if (r4 >= r3) goto L19;
        com.bytedance.android.live.platformplayer.effect.a r5 = (com.bytedance.android.live.platformplayer.effect.a) ListProtector.get(this.c, r4);     // Catch: Throwable -> L21
        String r6 = r5.a;     // Catch: Throwable -> L21
        if (this.d.containsKey(r6) == false) goto L12;
        Object r7 = this.d.get(r6);     // Catch: Throwable -> L21
        if (r7 == null) goto L12;
        ALogger.i("LivePlayerEffectAbHelper", "put via setting, " + r6 + ": " + r7);     // Catch: Throwable -> L21
        JSONObject r11 = new JSONObject();     // Catch: Throwable -> L21
        r11.put("key", r6);     // Catch: Throwable -> L21
        r11.put("data_type", r5.getType());     // Catch: Throwable -> L21
        r11.put("value", r7);     // Catch: Throwable -> L21
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L21
        r2.put(r11);     // Catch: Throwable -> L21
    L12:
        if (v.a() == false) goto L18;
        v60.a r9 = v60.a.a;     // Catch: Throwable -> L21
        Intrinsics.checkNotNullParameter(r6, "key");     // Catch: Throwable -> L21
        if (SettingIncStrategy.a.a(r6) == false) goto L18;
        Object r10 = v60.a.g(r6);     // Catch: Throwable -> L21
        if (r10 == null) goto L18;
        ALogger.i("LivePlayerEffectAbHelper", "put via local, " + r6 + ": " + r10);     // Catch: Throwable -> L21
        JSONObject r12 = new JSONObject();     // Catch: Throwable -> L21
        r12.put("key", r6);     // Catch: Throwable -> L21
        r12.put("data_type", r5.getType());     // Catch: Throwable -> L21
        r12.put("value", r10);     // Catch: Throwable -> L21
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L21
        r2.put(r12);     // Catch: Throwable -> L21
    L18:
        r4 = r4 + 1;     // Catch: Throwable -> L21
        goto L4
    L19:
        Object r14 = Result.constructor-impl(r2);     // Catch: Throwable -> L21
    L23:
        Throwable r15 = Result.exceptionOrNull-impl(r14);
        if (r15 == null) goto L27;
        ALogger.e("LivePlayerEffectAbHelper", "load effect ab from config failed: " + r15);
    L27:
        if (Result.isFailure-impl(r14) == false) goto L29;
        r14 = null;
    L29:
        JSONArray r16 = (JSONArray) r14;
        if (r16 == null) goto L35;
        if (r16.length() <= 0) goto L35;
        this.e = r16.toString();
    L35:
        return;
    L21:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L23
    }

    public final void c() {
        String r0 = (String) v0.a.getValue();
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L11
        JSONObject r2 = new JSONObject(r0);     // Catch: Throwable -> L11
        HashMap r3 = new HashMap();     // Catch: Throwable -> L11
        Iterator<String> r4 = r2.keys();     // Catch: Throwable -> L11
    L5:
        if (r4.hasNext() == false) goto L9;
        String r5 = r4.next();     // Catch: Throwable -> L11
        Object r6 = r2.opt(r5);     // Catch: Throwable -> L11
        if (r6 == null) goto L5;
        r3.put(r5, r6);     // Catch: Throwable -> L11
        goto L5
    L9:
        Object r7 = Result.constructor-impl(r3);     // Catch: Throwable -> L11
    L14:
        if (Result.isFailure-impl(r7) == false) goto L16;
        r7 = null;
    L16:
        Map<String, ? extends Object> r8 = (HashMap) r7;
        if (r8 != null) goto L20;
        r8 = MapsKt.emptyMap();
    L20:
        this.d = r8;
        return;
    L11:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    }

    public final void d() {
        ILiveWrappedEffectSDKService.Companion.getClass();
        ILiveWrappedEffectSDKService r0 = ILiveWrappedEffectSDKService.a.a();
        if (r0 == null) goto L34;
        String r1 = r0.requestABInfoWithLicense("live");
        if (r1 == null) goto L35;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L17
        JSONArray r3 = new JSONArray(r1);     // Catch: Throwable -> L17
        ArrayList r4 = new ArrayList();     // Catch: Throwable -> L17
        int r5 = r3.length();     // Catch: Throwable -> L17
        int r6 = 0;
    L8:
        if (r6 >= r5) goto L15;
        JSONObject r7 = r3.optJSONObject(r6);     // Catch: Throwable -> L17
        if (r7 == null) goto L14;
        String r8 = r7.optString("key");     // Catch: Throwable -> L17
        if (r8 == null) goto L14;
        r4.add(new com.bytedance.android.live.platformplayer.effect.a(r8, r7.optInt("dataType", -1), r7.optString("description", "")));     // Catch: Throwable -> L17
    L14:
        r6 = r6 + 1;     // Catch: Throwable -> L17
        goto L8
    L15:
        Object r9 = Result.constructor-impl(r4);     // Catch: Throwable -> L17
    L20:
        if (Result.isFailure-impl(r9) == false) goto L22;
        r9 = null;
    L22:
        List<com.bytedance.android.live.platformplayer.effect.a> r10 = (ArrayList) r9;
        if (r10 != null) goto L26;
        r10 = CollectionsKt.emptyList();
    L26:
        this.c = r10;
        return;
    L17:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L20
    L35:
        return;
    }

    @Override // com.bytedance.android.live.platformplayer.effect.b
    public final void prepare() {
        if ((!LiveVr6DofEffectConfig.INSTANCE.getDisable()) == true) goto L5;
        return;
    L5:
        ALogger.i("LivePlayerEffectAbHelper", "begin build data");
        if (((Boolean) or.a.getValue()).booleanValue() == false) goto L18;
        if (this.e == null) goto L11;
        ALogger.i("LivePlayerEffectAbHelper", "hit cache: " + this.e + ", return");
        return;
    L11:
        c r1 = new c(this);
        if (ThreadUtils.b() == false) goto L14;
        TTExecutors.getNormalExecutor().submit(r1);
    L15:
        ALogger.i("LivePlayerEffectAbHelper", "end build data");
        return;
    L14:
        r1.run();
        goto L15
    L18:
        if (EnterOptimizeUtil.b() == true) goto L20;
        ALogger.d("EnterOptimizeUtil", "live player effect prepare on main thread");
        d();
        c();
    L20:
        final b r2 = new b(this);
        AtlasAsyncExtKt.executeTask(AtlasAsyncExecutor.INSTANCE, "LivePlayerEffectHelper", r2, new AnonymousClass1(r2));
        ALogger.i("LivePlayerEffectAbHelper", "end build data");
    }

    @Override // com.bytedance.android.live.platformplayer.effect.b
    public final void release() {
        if ((!LiveVr6DofEffectConfig.INSTANCE.getDisable()) == true) goto L6;
        return;
    L6:
        if (((Boolean) or.a.getValue()).booleanValue() == true) goto L9;
        this.e = null;
        return;
    }

    public LivePlayerEffectHelper() {
        this.a = LazyKt.lazy(LivePlayerEffectHelper$platformConfig$2.INSTANCE);
        this.b = LazyKt.lazy(LivePlayerEffectHelper$cachePath$2.INSTANCE);
        this.c = CollectionsKt.emptyList();
        this.d = MapsKt.emptyMap();
        this.f = new Object();
    }

    @Override // com.bytedance.android.live.platformplayer.effect.b
    public final VideoEffectInitConfigBuilder a(String r5, boolean r6, String r7, String r8, PlayerEffectLogLevel r9, VideoEffectMessageListener r10, VideoEffectCallback r11, VideoEffectResourceFinder r12) {
        Intrinsics.checkNotNullParameter(r5, "license");
        Intrinsics.checkNotNullParameter(r7, "deviceName");
        Intrinsics.checkNotNullParameter(r8, "logKey");
        Intrinsics.checkNotNullParameter(r9, "logLevel");
        String r1 = (String) this.a.getValue();
        String r2 = (String) this.b.getValue();
        if ((!LiveVr6DofEffectConfig.INSTANCE.getDisable()) == true) goto L6;
    L10:
        String r3 = "";
    L12:
        return new VideoEffectInitConfigBuilder(r1, r2, r3).license(r5).useGL30(r6).deviceName(r7).logKey(r8).logLevel(r9).callBack(r11).messageListener(r10).videoEffectResourceFinder(r12);
    L6:
        if (this.e != null) goto L8;
        b();
    L8:
        r3 = this.e;
        if (r3 != null) goto L12;
        goto L10
    }
}
