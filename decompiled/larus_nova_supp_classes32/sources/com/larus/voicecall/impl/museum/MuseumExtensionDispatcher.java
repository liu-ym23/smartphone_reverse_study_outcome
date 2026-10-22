package com.larus.voicecall.impl.museum;

import com.larus.utils.logger.FLogger;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class MuseumExtensionDispatcher {
    public static final CopyOnWriteArrayList<z2a.d> a = null;
    public static volatile long b;

    static {
        a = new CopyOnWriteArrayList();
    }

    public static void a(a r9, boolean r10, Function0 r11, Function1 r12, Function2 r13) {
        if (f.a() == true) goto L6;
        FLogger.a.i("MuseumExtensionDebug", "[shortLink][click][ignore] stage=" + r9.e + ", museum=" + r9.d + ", reason=setting_disabled");
        return;
    L6:
        long r3 = System.currentTimeMillis();
        if ((r3 - b) >= 1000) goto L10;
        FLogger.a.i("MuseumExtensionDebug", "[shortLink][click][debounce] stage=" + r9.e + ", museum=" + r9.d);
        return;
    L10:
        b = r3;
        FLogger.a.i("MuseumExtensionDebug", "[shortLink][click] stage=" + r9.e + ", museum=" + r9.d + ", sendLongLinkAfterSuccess=" + r10);
        if (r12 == null) goto L13;
        r12.invoke(r9.e);
    L13:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new MuseumExtensionDispatcher$pickExtension$1(r9, r10, r11, r13, null), 3, null);
    }
}
