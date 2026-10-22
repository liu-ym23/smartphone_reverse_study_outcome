package com.larus.bmhome.music.player;

import com.larus.platform.api.IVideoController;
import com.larus.platform.service.q3;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class i {
    public static final Lazy a = null;
    public static final Lazy b = null;

    static {
        a = LazyKt.lazy(new g());
        b = LazyKt.lazy(new h());
    }

    public static ConcurrentHashMap c() {
        return (ConcurrentHashMap) a.getValue();
    }

    public static ConcurrentHashMap d() {
        return (ConcurrentHashMap) b.getValue();
    }

    public static IVideoController a(String r6) {
        ConcurrentHashMap r0 = c();
        monitor-enter(r0);
        IVideoController r1 = (IVideoController) c().get(r6);     // Catch: Throwable -> L22
        int r2 = 0;
        if (r1 != null) goto L7;
    L8:
        r1 = q3.b("", null, 6);     // Catch: Throwable -> L22
        if (r1 == null) goto L11;
        ((com.larus.video.impl.sdk.o) r1).I(true);     // Catch: Throwable -> L22
    L12:
        if (r1 == null) goto L14;
        c().put(r6, r1);     // Catch: Throwable -> L22
    L14:
        d().put(r6, 0);     // Catch: Throwable -> L22
    L15:
        if (r1 == null) goto L20;
        ConcurrentHashMap r4 = d();     // Catch: Throwable -> L22
        Integer r5 = (Integer) d().get(r6);     // Catch: Throwable -> L22
        if (r5 == null) goto L19;
        r2 = r5.intValue();     // Catch: Throwable -> L22
    L19:
        r4.put(r6, Integer.valueOf(r2 + 1));     // Catch: Throwable -> L22
    L20:
        monitor-exit(r0);
        return r1;
    L11:
        r1 = null;
        goto L12
    L7:
        if (r1.isReleased() == false) goto L15;
    L22:
        th = move-exception;
        throw th;
    }

    public static IVideoController b(String r6) {
        Intrinsics.checkNotNullParameter(r6, "engineKey");
        com.larus.video.impl.sdk.o r1 = null;
        boolean r2 = false;
        if (r6 != null) goto L5;
    L7:
        if (r2 == true) goto L9;
        Ref.ObjectRef r3 = new Ref.ObjectRef();
        Object r4 = c().get(r6);
        r3.element = r4;
        if (r4 != null) goto L13;
    L14:
        ConcurrentHashMap r5 = c();
        monitor-enter(r5);
        Object r7 = c().get(r6);     // Catch: Throwable -> L28
        r3.element = r7;     // Catch: Throwable -> L28
        if (r7 != null) goto L24;
        com.larus.video.impl.sdk.o r8 = q3.b("", null, 6);     // Catch: Throwable -> L28
        if (r8 == null) goto L21;
        r8.I(true);     // Catch: Throwable -> L28
        r1 = r8;
    L21:
        r3.element = r1;     // Catch: Throwable -> L28
        if (r1 == null) goto L24;
        c().put(r6, r1);     // Catch: Throwable -> L28
    L24:
        Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L28
        monitor-exit(r5);
    L27:
        return (IVideoController) r3.element;
    L28:
        th = move-exception;
        throw th;
    L13:
        if (((IVideoController) r4).isReleased() == false) goto L27;
    L9:
        return a(r6);
    L5:
        if (StringsKt.startsWith$default(r6, "music_applet:", false, 2, null) != true) goto L7;
        r2 = true;
        goto L7
    }

    public static void e(String r4) {
        ConcurrentHashMap r0 = c();
        monitor-enter(r0);
        IVideoController r1 = (IVideoController) c().get(r4);     // Catch: Throwable -> L23
        if (r1 != null) goto L8;
        monitor-exit(r0);
        return;
    L8:
        Integer r2 = (Integer) d().get(r4);     // Catch: Throwable -> L23
        if (r2 == null) goto L11;
        int r3 = r2.intValue();     // Catch: Throwable -> L23
    L12:
        int r5 = r3 - 1;     // Catch: Throwable -> L23
        if (r5 <= 0) goto L18;
        Integer r6 = Integer.valueOf(r5);     // Catch: Throwable -> L23
        d().put(r4, r6);     // Catch: Throwable -> L23
        monitor-exit(r0);
        return;
    L18:
        if (r1.isReleased() == true) goto L20;
        r1.release();     // Catch: Throwable -> L23
    L20:
        c().remove(r4);     // Catch: Throwable -> L23
        Integer r7 = (Integer) d().remove(r4);     // Catch: Throwable -> L23
        monitor-exit(r0);
        return;
    L11:
        r3 = 1;
    L23:
        th = move-exception;
        throw th;
    }

    public static void f(String r4) {
        Intrinsics.checkNotNullParameter(r4, "engineKey");
        boolean r2 = false;
        if (StringsKt.startsWith$default(r4, "music_applet:", false, 2, null) != true) goto L5;
        r2 = true;
    L5:
        if (r2 == false) goto L8;
        e(r4);
        return;
    L8:
        IVideoController r0 = (IVideoController) c().get(r4);
        if (r0 != null) goto L11;
        return;
    L11:
        ConcurrentHashMap r1 = c();
        monitor-enter(r1);
    L19:
        th = move-exception;
        throw th;
    L14:
        if (r0.isReleased() == true) goto L16;
        r0.release();     // Catch: Throwable -> L19
    L16:
        IVideoController r5 = (IVideoController) c().remove(r4);     // Catch: Throwable -> L19
        monitor-exit(r1);
    }
}
