package com.obric.assistant.audio;

import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.media.AudioPlaybackConfiguration;
import android.os.Handler;
import android.os.Looper;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class c {
    public final Lazy a;
    public final Method b;
    public final Method c;
    public final Method d;
    public final Handler e;
    public boolean f;
    public Function0<Unit> g;
    public Function0<Unit> h;
    public final Lazy i;

    public static final class a {
    }

    public static final class b extends AudioManager.AudioPlaybackCallback {
        public final /* synthetic */ c a;

        public b(c r1) {
            this.a = r1;
        }

        @Override // android.media.AudioManager.AudioPlaybackCallback
        public final void onPlaybackConfigChanged(List<AudioPlaybackConfiguration> r12) {
            FLogger r0 = FLogger.a;
            StringBuilder r1 = new StringBuilder("onPlaybackConfigChanged configs: ");
            if (r12 == null) goto L5;
            Integer r3 = Integer.valueOf(r12.size());
        L6:
            r1.append(r3);
            r1.append(", isBaiduMapPlaying: ");
            r1.append(this.a.f);
            r0.i("BaiduMapTtsManager", r1.toString());
            this.a.getClass();
            boolean r2 = false;
            Integer r4 = Integer.valueOf(AppHost.a.getApplication().getPackageManager().getApplicationInfo("com.baidu.BaiduMap", 0).uid);     // Catch: Throwable -> L9 PackageManager.NameNotFoundException -> L83
        L12:
            if (r4 == null) goto L97;
            int r5 = r4.intValue();
            if (r12 != null) goto L16;
            return;
        L16:
            List<AudioPlaybackConfiguration> r13 = r12;
            c r6 = this.a;
            if ((r13 instanceof Collection) == true) goto L19;
        L21:
            Iterator<T> r14 = r13.iterator();
        L23:
            if (r14.hasNext() == false) goto L71;
            AudioPlaybackConfiguration r7 = (AudioPlaybackConfiguration) r14.next();
            r6.getClass();
            Method r8 = r6.b;     // Catch: Throwable -> L33
            if (r8 == null) goto L28;
            Object r9 = r8.invoke(r7, new Object[0]);     // Catch: Throwable -> L33
        L30:
            if ((r9 instanceof Integer) == false) goto L35;
            Integer r10 = (Integer) r9;     // Catch: Throwable -> L33
        L37:
            if (r10 != null) goto L40;
        L68:
            boolean r11 = false;
        L69:
            if (r11 == false) goto L23;
            r2 = true;
            goto L71
        L40:
            if (r10.intValue() != r5) goto L68;
            Method r15 = r6.c;     // Catch: Throwable -> L49
            if (r15 == null) goto L44;
            Object r16 = r15.invoke(r7, new Object[0]);     // Catch: Throwable -> L49
        L46:
            if ((r16 instanceof Boolean) == false) goto L51;
            Boolean r17 = (Boolean) r16;     // Catch: Throwable -> L49
        L53:
            if (Intrinsics.areEqual(r17, Boolean.TRUE) == false) goto L68;
            Method r18 = r6.d;     // Catch: Throwable -> L62
            if (r18 == null) goto L57;
            Object r19 = r18.invoke(r7, new Object[0]);     // Catch: Throwable -> L62
        L59:
            if ((r19 instanceof Boolean) == false) goto L64;
            Boolean r20 = (Boolean) r19;     // Catch: Throwable -> L62
        L66:
            if (Intrinsics.areEqual(r20, Boolean.TRUE) == false) goto L68;
            r11 = true;
        L64:
            r20 = null;
            goto L66
        L57:
            r19 = null;
        L62:
            th = move-exception;
            FLogger.a.e("BaiduMapTtsManager", "reflect isPlaying failed: " + th);
        L51:
            r17 = null;
            goto L53
        L44:
            r16 = null;
        L49:
            th = move-exception;
            FLogger.a.e("BaiduMapTtsManager", "reflect isActive failed: " + th);
        L35:
            r10 = null;
            goto L37
        L28:
            r9 = null;
        L33:
            th = move-exception;
            FLogger.a.e("BaiduMapTtsManager", "reflect getClientUid failed: " + th);
        L71:
            c r110 = this.a;
            if (r2 != r110.f) goto L74;
            return;
        L74:
            r110.f = r2;
            FLogger r111 = FLogger.a;
            r111.i("BaiduMapTtsManager", "onPlaybackConfigChanged baiduMap playing changed -> " + r2);
            if (r2 == false) goto L79;
            r111.i("BaiduMapTtsManager", "[TTS] BaiduMap navi START, invoke pauseTtsCallback");
            Function0<Unit> r112 = this.a.g;
            if (r112 == null) goto L98;
            r112.invoke();
            return;
        L98:
            return;
        L79:
            r111.i("BaiduMapTtsManager", "[TTS] BaiduMap navi END, invoke resumeTtsCallback");
            Function0<Unit> r113 = this.a.h;
            if (r113 == null) goto L100;
            r113.invoke();
            return;
        L100:
            return;
        L19:
            if (r13.isEmpty() == false) goto L21;
        L97:
            return;
        L9:
            th = move-exception;
            FLogger.a.e("BaiduMapTtsManager", "getBaiduMapUid failed: " + th);
        L11:
            r4 = null;
            goto L12
        L5:
            r3 = null;
            goto L6
        }
    }

    static {
    }

    public c() {
        this.a = LazyKt.lazy(new com.obric.assistant.audio.a());
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        Object r2 = Result.constructor-impl(AudioPlaybackConfiguration.class.getMethod("getClientUid", new Class[0]));     // Catch: Throwable -> L5
    L7:
        Throwable r3 = Result.exceptionOrNull-impl(r2);
        if (r3 == null) goto L10;
        FLogger.a.e("BaiduMapTtsManager", "reflect getMethod(getClientUid) failed", r3);
    L10:
        Object r4 = null;
        if (Result.isFailure-impl(r2) == false) goto L13;
        r2 = null;
    L13:
        this.b = (Method) r2;
        Object r5 = Result.constructor-impl(AudioPlaybackConfiguration.class.getMethod("isActive", new Class[0]));     // Catch: Throwable -> L16
    L18:
        Throwable r6 = Result.exceptionOrNull-impl(r5);
        if (r6 == null) goto L22;
        FLogger.a.e("BaiduMapTtsManager", "reflect getMethod(isActive) failed", r6);
    L22:
        if (Result.isFailure-impl(r5) == false) goto L24;
        r5 = null;
    L24:
        this.c = (Method) r5;
        Object r0 = Result.constructor-impl(AudioPlaybackConfiguration.class.getMethod("isPlaying", new Class[0]));     // Catch: Throwable -> L27
    L29:
        Throwable r7 = Result.exceptionOrNull-impl(r0);
        if (r7 == null) goto L33;
        FLogger.a.e("BaiduMapTtsManager", "reflect getMethod(isPlaying) failed", r7);
    L33:
        if (Result.isFailure-impl(r0) == true) goto L36;
        r4 = r0;
    L36:
        this.d = (Method) r4;
        this.e = new Handler(Looper.getMainLooper());
        this.i = LazyKt.lazy(new com.obric.assistant.audio.b(this));
        return;
    L27:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r0 = Result.constructor-impl(ResultKt.createFailure(th));
    L16:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
    L5:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }
}
