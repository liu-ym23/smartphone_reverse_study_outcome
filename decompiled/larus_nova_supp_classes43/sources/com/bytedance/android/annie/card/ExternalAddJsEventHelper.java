package com.bytedance.android.annie.card;

import com.bytedance.android.annie.Annie;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class ExternalAddJsEventHelper {
    public static final List<Disposable> a = null;
    public static final Object b = null;
    public static int c;

    static {
        a = new ArrayList();
        b = new Object();
    }

    public static void a() {
        if (c <= 0) goto L23;
        Object r0 = b;
        monitor-enter(r0);
        int r1 = c;     // Catch: Throwable -> L20
        if (r1 <= 0) goto L17;
        int r10 = r1 - 1;     // Catch: Throwable -> L20
        c = r10;     // Catch: Throwable -> L20
        if (r10 != 0) goto L17;
        Iterator r11 = ((ArrayList) a).iterator();     // Catch: Throwable -> L20
    L12:
        if (r11.hasNext() == false) goto L16;
        Disposable r12 = (Disposable) r11.next();     // Catch: Throwable -> L20
        if (r12.isDisposed() == true) goto L12;
        r12.dispose();     // Catch: Throwable -> L20
        goto L12
    L16:
        ((ArrayList) a).clear();     // Catch: Throwable -> L20
    L17:
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L20
        monitor-exit(r0);
        return;
    L20:
        th = move-exception;
        throw th;
    }

    public static void b() {
        Object r0 = b;
        monitor-enter(r0);
    L18:
        th = move-exception;
        throw th;
    L5:
        if (c != 0) goto L15;
        List<Disposable> r1 = ((w8.c) Annie.getService$default(w8.c.class, null, 2, null)).Y(ExternalAddJsEventHelper$start$1$1.INSTANCE);     // Catch: Throwable -> L18
        if (r1 == null) goto L15;
        List<Disposable> r10 = r1;     // Catch: Throwable -> L18
        Iterator<T> r11 = r10.iterator();     // Catch: Throwable -> L18
    L10:
        if (r11.hasNext() == false) goto L14;
        Disposable r12 = (Disposable) r11.next();     // Catch: Throwable -> L18
        if (r12.isDisposed() == true) goto L10;
        ((ArrayList) a).add(r12);     // Catch: Throwable -> L18
        goto L10
    L14:
        List<Disposable> r13 = r10;     // Catch: Throwable -> L18
    L15:
        c++;     // Catch: Throwable -> L18
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L18
        monitor-exit(r0);
    }
}
