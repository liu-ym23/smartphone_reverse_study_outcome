package com.bytedance.android.livesdk.interactivity.publicscreen.repository;

import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import vlc.d;
import vlc.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a {
    public static final <T> void a(Collection<T> r1, T r2, Function0<Boolean> r3) {
        Intrinsics.checkNotNullParameter(r1, "$this$addIf");
        Intrinsics.checkNotNullParameter(r3, "predicate");
        if (((Boolean) r3.invoke()).booleanValue() == false) goto L6;
        r1.add(r2);
        return;
    }

    public static final void b(d r1, Collection<String> r2, l r3) {
        Intrinsics.checkNotNullParameter(r1, "$this$addMessageListenerByType");
        Intrinsics.checkNotNullParameter(r2, "methods");
        Intrinsics.checkNotNullParameter(r3, "listener");
        Iterator<T> r4 = r2.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        r1.addMessageListener((String) r4.next(), r3);
        goto L4
    }
}
