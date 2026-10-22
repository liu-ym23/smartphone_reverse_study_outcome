package com.obric.assistant.remote_card_container.manager;

import com.obric.assistant.remote_card_container.cache.CardCacheManager;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class c {
    public static final Set<a> a = null;

    public interface a {
        void a(String r1);
    }

    static {
        a = Collections.newSetFromMap(new ConcurrentHashMap());
    }

    public static void a(final String r2, final String r3, final boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "cardUri");
        p9a.e r0 = p9a.b.a;
        p9a.b.a("CardChangeListener", "notifyCardChanged: cardUri = " + r2 + ", extraParams = " + r3 + ", updateExtraParams = " + r4);
        CardCacheManager r1 = CardCacheManager.a;
        Runnable r5 = new com.obric.assistant.remote_card_container.manager.a(r2, r4, r3);
        Intrinsics.checkNotNullParameter(r5, "action");
        monitor-enter(r1);
        r5.run();     // Catch: Throwable -> L11
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r1);
        Iterator<T> r7 = a.iterator();
    L8:
        if (r7.hasNext() == false) goto L10;
        ((a) r7.next()).a(r2);
        goto L8
    L10:
        return;
    L11:
        th = move-exception;
        throw th;
    }
}
