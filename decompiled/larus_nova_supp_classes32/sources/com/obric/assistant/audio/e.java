package com.obric.assistant.audio;

import android.media.AudioManager;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import java.lang.reflect.Method;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.SetsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class e {
    public static final Lazy a = null;
    public static final Set<String> b = null;

    static {
        a = LazyKt.lazy(new d());
        b = SetsKt.setOf(new String[]{"com.qti.phone", "com.android.phone", "com.android.server.telecom"});
    }

    public static Object a() {
        Lazy r0 = a;
        if (((AudioManager) r0.getValue()) != null) goto L6;
        return null;
    L6:
        Method r1 = AudioManager.class.getMethod("getCurrentAudioFocusOwner", new Class[0]);
        r1.setAccessible(true);
        return r1.invoke((AudioManager) r0.getValue(), new Object[0]);
    }

    public static String b() {
        FLogger.a.i("CurrentAudioFocusManager", "getCurrentFocusOwner");
        boolean r0 = d();
        Object r2 = NameKeys.UnloadStrategy_No_Strategy;
        if (r0 == true) goto L19;
        return NameKeys.UnloadStrategy_No_Strategy;
    L19:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L11
        Object r3 = a();     // Catch: Throwable -> L11
        if (r3 != null) goto L8;
        String r4 = NameKeys.UnloadStrategy_No_Strategy;
    L9:
        Object r5 = Result.constructor-impl(r4);     // Catch: Throwable -> L11
    L13:
        Throwable r6 = Result.exceptionOrNull-impl(r5);
        if (r6 != null) goto L16;
        r2 = r5;
    L18:
        return (String) r2;
    L16:
        FLogger.a.i("CurrentAudioFocusManager", "getCurrentFocusOwner error: " + r6.getMessage());
        goto L18
    L8:
        r4 = c(r3);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    }

    public static boolean d() {
        AudioManager.class.getMethod("getCurrentAudioFocusOwner", new Class[0]);     // Catch: Exception -> L5
        FLogger.a.i("CurrentAudioFocusManager", "isCustomRomSupported: true");     // Catch: Exception -> L5
        return true;
    L5:
        FLogger.a.i("CurrentAudioFocusManager", "isCustomRomSupported: false");
        return false;
    }

    public static String c(Object r4) {
        Method r0 = r4.getClass().getMethod("getPackageName", new Class[0]);
        r0.setAccessible(true);
        Object r5 = r0.invoke(r4, new Object[0]);
        if ((r5 instanceof String) == false) goto L5;
        String r6 = (String) r5;
    L6:
        if (r6 != null) goto L8;
        r6 = NameKeys.UnloadStrategy_No_Strategy;
    L8:
        FLogger.a.i("CurrentAudioFocusManager", "getPackageName: ".concat(r6));
        return r6;
    L5:
        r6 = null;
        goto L6
    }
}
