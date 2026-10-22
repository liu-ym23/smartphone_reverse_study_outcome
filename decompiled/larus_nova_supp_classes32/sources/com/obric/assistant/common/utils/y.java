package com.obric.assistant.common.utils;

import android.content.pm.PackageManager;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.AudioPlaybackConfiguration;
import android.media.AudioRecordingConfiguration;
import android.os.Build;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.common.apphost.AppHost;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.utils.logger.FLogger;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.assistant.common.spi.audio.ObricAudioServiceDelegate;
import com.obric.assistant.wakeup.bluetooth_headset.api.IBluetoothHeadSetAPI;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class y {
    public static final y a = null;
    public static final AudioManager b = null;
    public static final Lazy c = null;
    public static final Method d = null;
    public static final Method e = null;
    public static final Method f = null;
    public static final Lazy g = null;
    public static final Lazy h = null;
    public static final Lazy i = null;
    public static final Lazy j = null;

    public y() {
    }

    static {
        a = new y();
        Object r0 = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L9
        Object r2 = AppHost.a.getApplication().getSystemService(LynxResourceModule.AUDIO_TYPE);     // Catch: Throwable -> L9
        if ((r2 instanceof AudioManager) == false) goto L6;
        AudioManager r3 = (AudioManager) r2;     // Catch: Throwable -> L9
    L7:
        Object r4 = Result.constructor-impl(r3);     // Catch: Throwable -> L9
    L12:
        if (Result.isFailure-impl(r4) == false) goto L14;
        r4 = null;
    L14:
        b = (AudioManager) r4;
        c = LazyKt.lazy(new t());
        Object r5 = Result.constructor-impl(AudioPlaybackConfiguration.class.getMethod("getClientUid", new Class[0]));     // Catch: Throwable -> L17
    L19:
        Throwable r6 = Result.exceptionOrNull-impl(r5);
        if (r6 == null) goto L23;
        FLogger.a.e("RomWakeupOptimizeUtils", "reflect getMethod(getClientUid) failed", r6);
    L23:
        if (Result.isFailure-impl(r5) == false) goto L25;
        r5 = null;
    L25:
        d = (Method) r5;
        Object r7 = Result.constructor-impl(AudioPlaybackConfiguration.class.getMethod("isActive", new Class[0]));     // Catch: Throwable -> L28
    L30:
        Throwable r8 = Result.exceptionOrNull-impl(r7);
        if (r8 == null) goto L34;
        FLogger.a.e("RomWakeupOptimizeUtils", "reflect getMethod(isActive) failed", r8);
    L34:
        if (Result.isFailure-impl(r7) == false) goto L36;
        r7 = null;
    L36:
        e = (Method) r7;
        Object r9 = Result.constructor-impl(AudioPlaybackConfiguration.class.getMethod("isPlaying", new Class[0]));     // Catch: Throwable -> L39
    L41:
        Throwable r10 = Result.exceptionOrNull-impl(r9);
        if (r10 == null) goto L45;
        FLogger.a.e("RomWakeupOptimizeUtils", "reflect getMethod(isPlaying) failed", r10);
    L45:
        if (Result.isFailure-impl(r9) == true) goto L48;
        r0 = r9;
    L48:
        f = (Method) r0;
        g = LazyKt.lazy(new u());
        h = LazyKt.lazy(new v());
        i = LazyKt.lazy(new w());
        j = LazyKt.lazy(new x());
        return;
    L39:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
    L28:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
    L17:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L19
    L6:
        r3 = null;
    L9:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    }

    @JvmStatic
    public static final Set<Integer> b() {
        if (Build.VERSION.SDK_INT < 29) goto L5;
        AudioManager r0 = b;
        if (r0 != null) goto L52;
        return SetsKt.emptySet();
    L52:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L17
        if (r0 == null) goto L14;
        List<AudioPlaybackConfiguration> r1 = r0.getActivePlaybackConfigurations();     // Catch: Throwable -> L17
    L15:
        Object r3 = Result.constructor-impl(r1);     // Catch: Throwable -> L17
    L20:
        if (Result.isFailure-impl(r3) == false) goto L22;
        r3 = null;
    L22:
        List r4 = (List) r3;
        List r5 = r4;
        if (r5 != null) goto L25;
    L28:
        boolean r6 = true;
    L29:
        if (r6 == true) goto L31;
        HashSet r7 = new HashSet();
        Iterator r8 = r4.iterator();
    L34:
        if (r8.hasNext() == false) goto L50;
        AudioPlaybackConfiguration r9 = (AudioPlaybackConfiguration) r8.next();
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L42
        AudioAttributes r11 = r9.getAudioAttributes();     // Catch: Throwable -> L42
        if (r11 == null) goto L39;
        Integer r12 = Integer.valueOf(r11.getUsage());     // Catch: Throwable -> L42
    L40:
        Object r13 = Result.constructor-impl(r12);     // Catch: Throwable -> L42
    L45:
        if (Result.isFailure-impl(r13) == false) goto L47;
        r13 = null;
    L47:
        Integer r14 = (Integer) r13;
        if (r14 == null) goto L34;
        r7.add(r14);
        goto L34
    L39:
        r12 = null;
    L42:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L45
    L50:
        FLogger.a.i("RomWakeupOptimizeUtils", "getActivePlaybackUsages -> " + r7);
        return r7;
    L31:
        return SetsKt.emptySet();
    L25:
        if (r5.isEmpty() == true) goto L28;
        r6 = false;
        goto L29
    L14:
        r1 = null;
    L17:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L20
    L5:
        return SetsKt.emptySet();
    }

    @JvmStatic
    public static final List<String> c() {
        if (Build.VERSION.SDK_INT < 29) goto L5;
        AudioManager r0 = b;
        if (r0 != null) goto L68;
        return CollectionsKt.emptyList();
    L68:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L17
        if (r0 == null) goto L14;
        List<AudioRecordingConfiguration> r1 = r0.getActiveRecordingConfigurations();     // Catch: Throwable -> L17
    L15:
        Object r3 = Result.constructor-impl(r1);     // Catch: Throwable -> L17
    L20:
        if (Result.isFailure-impl(r3) == false) goto L22;
        r3 = null;
    L22:
        List r4 = (List) r3;
        FLogger r5 = FLogger.a;
        StringBuilder r6 = new StringBuilder("getActiveRecordingPackages -> size:");
        if (r4 == null) goto L25;
        Integer r7 = Integer.valueOf(r4.size());
    L26:
        r6.append(r7);
        r5.i("RomWakeupOptimizeUtils", r6.toString());
        List r8 = r4;
        if (r8 != null) goto L29;
    L32:
        boolean r9 = true;
    L33:
        if (r9 == true) goto L35;
        a.getClass();
        Method r10 = (Method) j.getValue();
        if (r10 == null) goto L39;
        LinkedHashSet r11 = new LinkedHashSet();
        Iterator r12 = r4.iterator();
    L42:
        if (r12.hasNext() == false) goto L64;
        AudioRecordingConfiguration r13 = (AudioRecordingConfiguration) r12.next();
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L50
        Object r15 = r10.invoke(r13, new Object[0]);     // Catch: Throwable -> L50
        if ((r15 instanceof String) == false) goto L47;
        String r16 = (String) r15;     // Catch: Throwable -> L50
    L48:
        Object r17 = Result.constructor-impl(r16);     // Catch: Throwable -> L50
    L53:
        if (Result.isFailure-impl(r17) == false) goto L55;
        r17 = null;
    L55:
        String r18 = (String) r17;
        if (r18 != null) goto L58;
    L61:
        boolean r19 = true;
    L62:
        if (r19 == true) goto L42;
        r11.add(r18);
        goto L42
    L58:
        if (r18.length() == 0) goto L61;
        r19 = false;
        goto L62
    L47:
        r16 = null;
    L50:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r17 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L53
    L64:
        FLogger.a.i("RomWakeupOptimizeUtils", "getActiveRecordingPackages -> size=" + r11.size());
        return CollectionsKt.toList(r11);
    L39:
        return CollectionsKt.emptyList();
    L35:
        return CollectionsKt.emptyList();
    L29:
        if (r8.isEmpty() == true) goto L32;
        r9 = false;
        goto L33
    L25:
        r7 = null;
        goto L26
    L14:
        r1 = null;
    L17:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L20
    L5:
        return CollectionsKt.emptyList();
    }

    @JvmStatic
    public static final boolean e() {
        AudioManager r0 = b;
        boolean r1 = false;
        if (r0 != null) goto L6;
        return false;
    L6:
        if (f() == false) goto L9;
        FLogger.a.i("RomWakeupOptimizeUtils", "hitOptimizeScene skipped: bluetooth connected but concurrent btmic not supported");
        return false;
    L9:
        int r2 = r0.getMode();
        List<String> r3 = c();
        boolean r4 = i(r3);
        boolean r5 = h();
        boolean r6 = g(r3);
        if (r4 == true) goto L13;
        if (r5 == true) goto L13;
        if (r6 == true) goto L13;
    L14:
        FLogger.a.i("RomWakeupOptimizeUtils", "hitOptimizeScene hit=" + r1 + ", voipCall=" + r4 + ", voiceCall=" + r5 + ", micInUse=" + r6 + ", mode=" + r2 + ", recordingPkgs=" + r3);
        return r1;
    L13:
        r1 = true;
        goto L14
    }

    @JvmStatic
    public static final boolean f() {
        IBluetoothHeadSetAPI r0 = tha.c.a();
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L13;
        a.getClass();
        if (d("ro.obric.assistant.concurrent_btmic_in_use") == true) goto L14;
        return true;
    L14:
        return false;
    L13:
        return false;
    L5:
        if (r0.a() != true) goto L7;
        r1 = true;
        goto L8
    }

    @JvmStatic
    public static final boolean h() {
        boolean r2 = false;
        if (f() == false) goto L6;
        FLogger.a.i("RomWakeupOptimizeUtils", "isSupportVoiceCallOpt skipped: bluetooth connected but concurrent btmic not supported");
        return false;
    L6:
        a.getClass();
        if (d("ro.obric.soundtrigger.concurrent_voice_call") == true) goto L9;
        return false;
    L9:
        AudioManager r0 = b;
        if (r0 != null) goto L12;
        return false;
    L12:
        int r1 = r0.getMode();
        if (r1 != 2) goto L15;
        boolean r3 = true;
    L16:
        String r5 = ObricAudioServiceDelegate.a.c();
        if (Intrinsics.areEqual(r5, "com.android.server.telecom") == false) goto L20;
        if (r3 == false) goto L20;
        r2 = true;
    L20:
        FLogger.a.i("RomWakeupOptimizeUtils", "isSupportVoiceCallopt hit=" + r2 + ", mode=" + r1 + ", focusOwner=" + r5);
        return r2;
    L15:
        r3 = false;
        goto L16
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a(String r3) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r2 = Class.forName(r3);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r3);
    L12:
        throw th;
    L34:
        Class<?> r4 = Class.forName(r3);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L17
    L16:
        return r4;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r3);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r3);
    }

    public static boolean d(String r5) {
        Method r0 = (Method) c.getValue();
        boolean r1 = false;
        if (r0 != null) goto L22;
        return false;
    L22:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L12
        Boolean r3 = null;
        Object r4 = r0.invoke(null, new Object[]{r5, Boolean.FALSE});     // Catch: Throwable -> L12
        if ((r4 instanceof Boolean) == false) goto L8;
        r3 = (Boolean) r4;     // Catch: Throwable -> L12
    L8:
        if (r3 == null) goto L10;
        r1 = r3.booleanValue();     // Catch: Throwable -> L12
    L10:
        Object r6 = Result.constructor-impl(Boolean.valueOf(r1));     // Catch: Throwable -> L12
    L14:
        Throwable r7 = Result.exceptionOrNull-impl(r6);
        if (r7 == null) goto L17;
        FLogger.a.w("RomWakeupOptimizeUtils", "getSystemProperty " + r5 + " failed: " + r7);
    L17:
        Boolean r8 = Boolean.FALSE;
        if (Result.isFailure-impl(r6) == false) goto L21;
        r6 = r8;
    L21:
        return ((Boolean) r6).booleanValue();
    L12:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    }

    @JvmStatic
    public static final boolean g(List<String> r7) {
        a.getClass();
        boolean r1 = false;
        if (d("ro.obric.assistant.concurrent_mic_in_use") == true) goto L5;
        return false;
    L5:
        AudioManager r0 = b;
        if (r0 != null) goto L8;
        return false;
    L8:
        int r2 = r0.getMode();
        Set<Integer> r3 = b();
        if (r2 != 1) goto L11;
    L14:
        boolean r4 = true;
    L15:
        List<String> r5 = r7;
        if ((r5 instanceof Collection) == true) goto L18;
    L20:
        Iterator<T> r6 = r5.iterator();
    L22:
        if (r6.hasNext() == false) goto L26;
        String r8 = (String) r6.next();
        a.getClass();
        if (((List) g.getValue()).contains(r8) == false) goto L22;
        boolean r9 = true;
    L27:
        if (r9 == true) goto L29;
        if (r4 == true) goto L29;
    L30:
        FLogger.a.i("RomWakeupOptimizeUtils", "isSupportMicInUseOpt hit=" + r1 + ", mode=" + r2 + ", ringtone=" + r4 + ", recordingPkgs=" + r7);
        return r1;
    L29:
        r1 = true;
    L26:
        r9 = false;
        goto L27
    L18:
        if (r5.isEmpty() == false) goto L20;
    L11:
        if (r3.contains(6) == true) goto L14;
        r4 = false;
        goto L15
    }

    @JvmStatic
    public static final boolean i(List<String> r11) {
        a.getClass();
        boolean r1 = false;
        if (d("ro.obric.soundtrigger.concurrent_voip_call") == true) goto L5;
        return false;
    L5:
        AudioManager r0 = b;
        if (r0 != null) goto L9;
        return false;
    L9:
        if (r0.getMode() == 3) goto L11;
        return false;
    L11:
        List<String> r2 = r11;
        if ((r2 instanceof Collection) == true) goto L14;
    L16:
        Iterator<T> r3 = r2.iterator();
    L18:
        if (r3.hasNext() == false) goto L22;
        String r4 = (String) r3.next();
        a.getClass();
        if (((List) i.getValue()).contains(r4) == false) goto L18;
        boolean r5 = true;
    L24:
        if (r5 == true) goto L120;
        a.getClass();
        List r6 = (List) i.getValue();
        Intrinsics.checkNotNullParameter(r6, "packageSet");
        if (Build.VERSION.SDK_INT < 29) goto L61;
        AudioManager r7 = b;
        if (r7 == null) goto L61;
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L33
        Object r9 = Result.constructor-impl(r7.getActivePlaybackConfigurations());     // Catch: Throwable -> L33
    L36:
        if (Result.isFailure-impl(r9) == false) goto L38;
        r9 = null;
    L38:
        List r10 = (List) r9;
        List r12 = r10;
        if (r12 != null) goto L41;
    L44:
        boolean r13 = true;
    L45:
        if (r13 == true) goto L61;
        ArrayList r14 = new ArrayList();
        Iterator r15 = r6.iterator();
    L49:
        if (r15.hasNext() == false) goto L59;
        String r16 = (String) r15.next();
        a.getClass();
        Integer r17 = Integer.valueOf(AppHost.a.getApplication().getPackageManager().getApplicationInfo(r16, 0).uid);     // Catch: Throwable -> L53 PackageManager.NameNotFoundException -> L55
    L57:
        if (r17 == null) goto L49;
        r14.add(r17);
        goto L49
    L53:
        th = move-exception;
        FLogger.a.e("RomWakeupOptimizeUtils", "getAppUid failed: " + th);
    L56:
        r17 = null;
        goto L57
    L59:
        Set r18 = CollectionsKt.toSet(r14);
        if (r18.isEmpty() == true) goto L61;
        List r19 = r10;
        if ((r19 instanceof Collection) == true) goto L65;
    L67:
        Iterator r20 = r19.iterator();
    L69:
        if (r20.hasNext() == false) goto L117;
        AudioPlaybackConfiguration r21 = (AudioPlaybackConfiguration) r20.next();
        y r22 = a;
        Intrinsics.checkNotNull(r21);
        r22.getClass();
        Method r23 = d;     // Catch: Throwable -> L79
        if (r23 == null) goto L74;
        Object r24 = r23.invoke(r21, new Object[0]);     // Catch: Throwable -> L79
    L76:
        if ((r24 instanceof Integer) == false) goto L81;
        Integer r25 = (Integer) r24;     // Catch: Throwable -> L79
    L82:
        if (r25 != null) goto L84;
    L114:
        boolean r26 = false;
    L115:
        if (r26 == false) goto L69;
        boolean r27 = true;
    L118:
        FLogger.a.i("RomWakeupOptimizeUtils", "isVoipCallPackagePlaying -> hit=" + r27 + ", voipUids=" + r18);
    L119:
        if (r27 == true) goto L120;
    L121:
        FLogger.a.i("RomWakeupOptimizeUtils", "isSupportVoipCallOpt hit=" + r1 + ", recordingPkgs=" + r11);
        return r1;
    L84:
        if (r18.contains(Integer.valueOf(r25.intValue())) == false) goto L114;
        a.getClass();
        Method r28 = e;     // Catch: Throwable -> L94
        if (r28 == null) goto L89;
        Object r29 = r28.invoke(r21, new Object[0]);     // Catch: Throwable -> L94
    L91:
        if ((r29 instanceof Boolean) == false) goto L96;
        Boolean r30 = (Boolean) r29;     // Catch: Throwable -> L94
    L98:
        if (Intrinsics.areEqual(r30, Boolean.TRUE) == false) goto L114;
        a.getClass();
        Method r31 = f;     // Catch: Throwable -> L108
        if (r31 == null) goto L103;
        Object r32 = r31.invoke(r21, new Object[0]);     // Catch: Throwable -> L108
    L105:
        if ((r32 instanceof Boolean) == false) goto L110;
        Boolean r33 = (Boolean) r32;     // Catch: Throwable -> L108
    L112:
        if (Intrinsics.areEqual(r33, Boolean.TRUE) == false) goto L114;
        r26 = true;
    L110:
        r33 = null;
        goto L112
    L103:
        r32 = null;
    L108:
        th = move-exception;
        FLogger.a.e("RomWakeupOptimizeUtils", "reflect isPlaying failed: " + th);
    L96:
        r30 = null;
        goto L98
    L89:
        r29 = null;
    L94:
        th = move-exception;
        FLogger.a.e("RomWakeupOptimizeUtils", "reflect isActive failed: " + th);
    L81:
        r25 = null;
        goto L82
    L74:
        r24 = null;
    L79:
        th = move-exception;
        FLogger.a.e("RomWakeupOptimizeUtils", "reflect getClientUid failed: " + th);
    L117:
        r27 = false;
        goto L118
    L65:
        if (r19.isEmpty() == false) goto L67;
    L41:
        if (r12.isEmpty() == true) goto L44;
        r13 = false;
    L33:
        th = move-exception;
        Result.Companion r34 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
    L61:
        r27 = false;
    L120:
        r1 = true;
    L22:
        r5 = false;
        goto L24
    L14:
        if (r2.isEmpty() == false) goto L16;
        goto L16
    }
}
