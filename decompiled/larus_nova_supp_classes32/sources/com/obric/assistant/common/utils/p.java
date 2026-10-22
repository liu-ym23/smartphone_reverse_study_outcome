package com.obric.assistant.common.utils;

import android.content.Context;
import android.media.AudioManager;
import android.media.AudioRecordingConfiguration;
import android.os.Build;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.common.apphost.AppHost;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.lynx.jsbridge.LynxResourceModule;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class p {
    public static final Set<String> a = null;
    public static final Lazy b = null;
    public static final Lazy c = null;

    static {
        a = SetsKt.setOf(new String[]{"com.obric.camera2", "com.android.camera", "com.android.camera2"});
        b = LazyKt.lazy(new n());
        c = LazyKt.lazy(new o());
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r2 = Class.forName("android.media.AudioRecordingConfiguration");     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("android.media.AudioRecordingConfiguration");     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("android.media.AudioRecordingConfiguration");
    L12:
        throw th;
    L34:
        Class<?> r3 = Class.forName("android.media.AudioRecordingConfiguration");     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("android.media.AudioRecordingConfiguration");     // Catch: Throwable -> L17
    L16:
        return r3;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("android.media.AudioRecordingConfiguration");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("android.media.AudioRecordingConfiguration");
    }

    public static boolean c() {
        ArrayList r0 = (ArrayList) b(AppHost.a.getApplication());
        if (r0.isEmpty() == true) goto L11;
        Iterator r1 = r0.iterator();
    L7:
        if (r1.hasNext() == false) goto L11;
        String r2 = (String) r1.next();
        if (a.contains(r2) == false) goto L7;
        return true;
    L11:
        return false;
    }

    public static boolean g() {
        AppHost.Companion r0 = AppHost.a;
        List r1 = b(r0.getApplication());
        ArrayList r2 = (ArrayList) r1;
        if (r2.contains("com.obric.screenrecorder") == false) goto L8;
        if (Intrinsics.areEqual(r0.getBuildChannel(), "auto_test") == false) goto L8;
        return false;
    L8:
        if ((!r2.isEmpty()) == true) goto L10;
        return false;
    L10:
        if (r2.size() == 1) goto L12;
    L14:
        boolean r3 = false;
    L15:
        if (r3 == false) goto L17;
        return false;
    L17:
        if (d(r1) == true) goto L22;
        return true;
    L22:
        return false;
    L12:
        if (Intrinsics.areEqual(ListProtector.get(r1, 0), r0.getApplication().getPackageName()) == false) goto L14;
        r3 = true;
        goto L15
    }

    public static List b(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        FLogger.a.i("OrionMicUtils", "getCurrentMicInUsePkgName checking...");
        ArrayList r0 = new ArrayList();
        if (Build.VERSION.SDK_INT < 29) goto L17;
        Object r2 = r8.getSystemService(LynxResourceModule.AUDIO_TYPE);
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type android.media.AudioManager");
        Iterator<AudioRecordingConfiguration> r3 = ((AudioManager) r2).getActiveRecordingConfigurations().iterator();
    L6:
        if (r3.hasNext() == false) goto L17;
        AudioRecordingConfiguration r4 = r3.next();
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L15
        Method r6 = a().getMethod("getClientPackageName", new Class[0]);     // Catch: Throwable -> L15
        r6.setAccessible(true);     // Catch: Throwable -> L15
        Object r7 = r6.invoke(r4, new Object[0]);     // Catch: Throwable -> L15
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type kotlin.String");     // Catch: Throwable -> L15
        String r9 = (String) r7;     // Catch: Throwable -> L15
        FLogger.a.i("OrionMicUtils", "getCurrentMicInUsePkgName end with packageName is " + r9);     // Catch: Throwable -> L15
        if (o0.d(r9) == true) goto L11;
    L13:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L15
        goto L6
    L11:
        if (Intrinsics.areEqual(r9, r8.getPackageName()) == true) goto L13;
        r0.add(r9);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L17:
        FLogger.a.i("OrionMicUtils", "getCurrentMicInUsePkgName end with the package list " + r0.size());
        Iterator r11 = r0.iterator();
    L19:
        if (r11.hasNext() == false) goto L21;
        String r12 = (String) r11.next();
        FLogger.a.i("OrionMicUtils", "getCurrentMicInUsePkgName end with the package " + r12);
        goto L19
    L21:
        return r0;
    }

    public static boolean d(List r2) {
        if (((ArrayList) r2).isEmpty() == false) goto L6;
        return false;
    L6:
        if (h(r2, ((Map) c.getValue()).keySet()) == false) goto L9;
        return false;
    L9:
        return h(r2, ((Map) b.getValue()).keySet());
    }

    public static boolean e(Context r6) {
        Intrinsics.checkNotNullParameter(r6, "context");
        List r0 = b(r6);
        ArrayList r1 = (ArrayList) r0;
        if (r1.contains("com.obric.screenrecorder") == false) goto L8;
        if (Intrinsics.areEqual(AppHost.a.getBuildChannel(), "auto_test") == false) goto L8;
        return false;
    L8:
        if ((!r1.isEmpty()) == true) goto L10;
        return false;
    L10:
        if (r1.isEmpty() == true) goto L18;
        Iterator r2 = r1.iterator();
    L14:
        if (r2.hasNext() == false) goto L18;
        if (Intrinsics.areEqual((String) r2.next(), r6.getPackageName()) == false) goto L14;
        boolean r7 = true;
    L19:
        if (r7 == false) goto L21;
        return false;
    L21:
        if (d(r0) == true) goto L29;
        return true;
    L29:
        return false;
    L18:
        r7 = false;
        goto L19
    }

    public static boolean f(Context r5, List r6) {
        Intrinsics.checkNotNullParameter(r5, "context");
        if ((!r6.isEmpty()) != true) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
    L21:
        return false;
    L8:
        if (r6.isEmpty() == true) goto L16;
        Iterator r1 = r6.iterator();
    L12:
        if (r1.hasNext() == false) goto L16;
        if (Intrinsics.areEqual((String) r1.next(), r5.getPackageName()) == false) goto L12;
        boolean r7 = true;
    L17:
        if (r7 == true) goto L21;
        if (d(r6) == true) goto L21;
        return true;
    L16:
        r7 = false;
        goto L17
    L5:
        r0 = false;
        goto L6
    }

    public static boolean h(List r1, Collection r2) {
        if (r1.isEmpty() == true) goto L11;
        Iterator r3 = r1.iterator();
    L7:
        if (r3.hasNext() == false) goto L11;
        if (r2.contains((String) r3.next()) == false) goto L7;
        return true;
    L11:
        return false;
    }
}
