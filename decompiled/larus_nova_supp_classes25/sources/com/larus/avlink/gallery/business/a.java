package com.larus.avlink.gallery.business;

import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a {
    public static final CopyOnWriteArraySet<c> a = null;

    static {
        a = new CopyOnWriteArraySet();
    }

    public static void b(c r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        a.add(r2);
        FLogger.a.d("AlbumMediaChangeDispatcher", "Registered listener: ".concat(r2.getClass().getSimpleName()));
    }

    public static void c(c r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        a.remove(r2);
        FLogger.a.d("AlbumMediaChangeDispatcher", "Unregistered listener: ".concat(r2.getClass().getSimpleName()));
    }

    public static void a(List r3, List r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "uniqIds");
        Intrinsics.checkNotNullParameter(r4, "paths");
        Intrinsics.checkNotNullParameter(r5, "source");
        if (r3.isEmpty() == true) goto L5;
    L7:
        List r6 = CollectionsKt.distinct(r3);
        ArrayList r0 = new ArrayList();
        Iterator r7 = r4.iterator();
    L9:
        if (r7.hasNext() == false) goto L13;
        Object r1 = r7.next();
        if ((!StringsKt.isBlank((String) r1)) == false) goto L9;
        r0.add(r1);
        goto L9
    L13:
        b.a r2 = new b.a(r6, CollectionsKt.distinct(r0), r5);
        Intrinsics.checkNotNullParameter(r2, "event");
        FLogger r8 = FLogger.a;
        StringBuilder r9 = new StringBuilder("notifyChanged: event=");
        r9.append(r2);
        r9.append(", listenerCount=");
        CopyOnWriteArraySet<c> r10 = a;
        r9.append(r10.size());
        r8.i("AlbumMediaChangeDispatcher", r9.toString());
        Iterator<c> r11 = r10.iterator();
    L15:
        if (r11.hasNext() == false) goto L24;
        c r12 = r11.next();
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L19
        r12.a(r2);     // Catch: Throwable -> L19
        Object r14 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L19
    L21:
        Throwable r15 = Result.exceptionOrNull-impl(r14);
        if (r15 == null) goto L15;
        FLogger.a.e("AlbumMediaChangeDispatcher", "notifyChanged listener failed", r15);
    L19:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L21
    L24:
        return;
    L5:
        if (r4.isEmpty() == false) goto L7;
    }
}
