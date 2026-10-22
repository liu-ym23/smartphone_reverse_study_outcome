package com.larus.video.impl.sdk;

import com.larus.settings.value.e10;
import com.larus.settings.value.ih;
import com.larus.utils.l0;
import com.ss.ttvideoengine.TTVideoEngine;
import com.ss.ttvideoengine.VideoEngineStateListener;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class r implements VideoEngineStateListener {
    public static final r a = null;
    public static final boolean b = false;
    public static final Object c = null;
    public static final LinkedList<WeakReference<VideoEngineStateListener>> d = null;
    public static final LinkedList<VideoEngineStateListener> e = null;

    public r() {
    }

    static {
        a = new r();
        e10 r0 = e10.a;
        int r1 = l0.a;
        boolean r2 = ((Boolean) l0.a(Boolean.TRUE, new ih())).booleanValue();
        b = r2;
        c = new Object();
        LinkedList<VideoEngineStateListener> r3 = null;
        if (r2 == false) goto L5;
        LinkedList<WeakReference<VideoEngineStateListener>> r4 = new LinkedList();
    L6:
        d = r4;
        if (r2 == true) goto L10;
        r3 = new LinkedList();
    L10:
        e = r3;
        return;
    L5:
        r4 = null;
        goto L6
    }

    public static void a(VideoEngineStateListener r4) {
        Intrinsics.checkNotNullParameter(r4, "listener");
        Object r0 = c;
        monitor-enter(r0);
        LinkedList<VideoEngineStateListener> r1 = e;     // Catch: Throwable -> L20
        if (r1 == null) goto L7;
        r1.remove(r4);     // Catch: Throwable -> L20
    L7:
        LinkedList<WeakReference<VideoEngineStateListener>> r2 = d;     // Catch: Throwable -> L20
        if (r2 == null) goto L18;
        Iterator<T> r3 = r2.iterator();     // Catch: Throwable -> L20
    L11:
        if (r3.hasNext() == false) goto L17;
        WeakReference r5 = (WeakReference) r3.next();     // Catch: Throwable -> L20
        if (Intrinsics.areEqual(r5.get(), r4) == true) goto L16;
        if (r5.get() != null) goto L11;
    L16:
        d.remove(r5);     // Catch: Throwable -> L20
        goto L11
    L17:
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L20
    L18:
        monitor-exit(r0);
        return;
    L20:
        th = move-exception;
        throw th;
    }

    public final void onEnginePlay(TTVideoEngine r5) {
        if (b == true) goto L19;
        LinkedList<VideoEngineStateListener> r0 = e;
        if (r0 != null) goto L7;
        return;
    L7:
        Object r1 = c;
        monitor-enter(r1);
        LinkedList r2 = new LinkedList(r0);     // Catch: Throwable -> L16
        monitor-exit(r1);
        Iterator r3 = r2.iterator();
    L13:
        if (r3.hasNext() == false) goto L15;
        ((VideoEngineStateListener) r3.next()).onEnginePlay(r5);
        goto L13
    L15:
        return;
    L16:
        th = move-exception;
        throw th;
    L19:
        LinkedList<WeakReference<VideoEngineStateListener>> r4 = d;
        if (r4 != null) goto L22;
        return;
    L22:
        Object r6 = c;
        monitor-enter(r6);
        LinkedList r7 = new LinkedList(r4);     // Catch: Throwable -> L41
        monitor-exit(r6);
        Iterator r8 = r7.iterator();
    L28:
        if (r8.hasNext() == false) goto L40;
        WeakReference r9 = (WeakReference) r8.next();
        VideoEngineStateListener r10 = (VideoEngineStateListener) r9.get();
        if (r10 == null) goto L31;
        r10.onEnginePlay(r5);
        goto L28
    L31:
        Object r11 = c;
        monitor-enter(r11);
        d.remove(r9);     // Catch: Throwable -> L36
        monitor-exit(r11);
    L36:
        th = move-exception;
        throw th;
    L40:
        return;
    L41:
        th = move-exception;
        throw th;
    }

    public final void onEngineStop(TTVideoEngine r5) {
        if (b == true) goto L19;
        LinkedList<VideoEngineStateListener> r0 = e;
        if (r0 != null) goto L7;
        return;
    L7:
        Object r1 = c;
        monitor-enter(r1);
        LinkedList r2 = new LinkedList(r0);     // Catch: Throwable -> L16
        monitor-exit(r1);
        Iterator r3 = r2.iterator();
    L13:
        if (r3.hasNext() == false) goto L15;
        ((VideoEngineStateListener) r3.next()).onEngineStop(r5);
        goto L13
    L15:
        return;
    L16:
        th = move-exception;
        throw th;
    L19:
        LinkedList<WeakReference<VideoEngineStateListener>> r4 = d;
        if (r4 != null) goto L22;
        return;
    L22:
        Object r6 = c;
        monitor-enter(r6);
        LinkedList r7 = new LinkedList(r4);     // Catch: Throwable -> L41
        monitor-exit(r6);
        Iterator r8 = r7.iterator();
    L28:
        if (r8.hasNext() == false) goto L40;
        WeakReference r9 = (WeakReference) r8.next();
        VideoEngineStateListener r10 = (VideoEngineStateListener) r9.get();
        if (r10 == null) goto L31;
        r10.onEngineStop(r5);
        goto L28
    L31:
        Object r11 = c;
        monitor-enter(r11);
        d.remove(r9);     // Catch: Throwable -> L36
        monitor-exit(r11);
    L36:
        th = move-exception;
        throw th;
    L40:
        return;
    L41:
        th = move-exception;
        throw th;
    }
}
