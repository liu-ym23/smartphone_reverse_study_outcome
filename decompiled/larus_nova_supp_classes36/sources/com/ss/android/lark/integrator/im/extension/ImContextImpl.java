package com.ss.android.lark.integrator.im.extension;

import com.ss.android.lark.biz.im.api.extension.ImExtensionType;
import com.ss.android.lark.chat.export.entity.message.Content;
import com.ss.android.lark.chat.export.entity.message.MessageType;
import com.ss.android.lark.locationmessage.message.g;
import com.ss.android.lark.message.card.view.d;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import lqb.b;
import qbc.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class ImContextImpl {
    public final CopyOnWriteArrayList<Object> a;
    public final CopyOnWriteArrayList<rxa.a> b;
    public final CopyOnWriteArrayList<gya.a<? extends Content>> c;
    public final Map<MessageType, gya.a<? extends Content>> d;
    public final Lazy e;

    public ImContextImpl() {
        this.a = new CopyOnWriteArrayList();
        new CopyOnWriteArrayList();
        CopyOnWriteArrayList<rxa.a> r0 = new CopyOnWriteArrayList();
        r0.add(new d());
        this.b = r0;
        g r1 = new g();
        com.ss.android.lark.message.card.parser.a r2 = new com.ss.android.lark.message.card.parser.a();
        gya.a<? extends Content> r3 = new c6b.a();
        gya.a<? extends Content> r4 = new c();
        CopyOnWriteArrayList<gya.a<? extends Content>> r5 = new CopyOnWriteArrayList();
        new b(com.ss.android.lark.integrator.im.message.d.a);
        r5.add(r1);
        r5.add(r2);
        r5.add(r3);
        r5.add(r4);
        this.c = r5;
        ConcurrentHashMap r6 = new ConcurrentHashMap();
        r6.put(MessageType.LOCATION, r1);
        r6.put(MessageType.CARD, r2);
        r6.put(MessageType.MERGE_FORWARD, r3);
        r6.put(MessageType.VOTE, r4);
        this.d = r6;
        new CopyOnWriteArrayList();
        this.e = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, ImContextImpl$multiSelectProviders$2.INSTANCE);
    }

    public final void a(com.ss.android.lark.vote.message.cell.c r3) {
        Intrinsics.checkNotNullParameter(r3, "factory");
        CopyOnWriteArrayList<Object> r0 = this.a;
        if (r0.contains(r3) == true) goto L6;
        r0.add(r3);
        return;
    }

    public final void b(com.ss.android.lark.vote.message.cell.g r3) {
        Intrinsics.checkNotNullParameter(r3, "factory");
        CopyOnWriteArrayList<rxa.a> r0 = this.b;
        if (r0.contains(r3) == true) goto L6;
        r0.add(r3);
        return;
    }

    public final void c(qxa.a<Unit, Collection<gya.a<? extends Content>>> r4) {
        Intrinsics.checkNotNullParameter(r4, "factory");
        Iterator r5 = ((Iterable) r4.a(Unit.INSTANCE)).iterator();
    L4:
        if (r5.hasNext() == false) goto L11;
        gya.a<? extends Content> r0 = (gya.a) r5.next();
        CopyOnWriteArrayList<gya.a<? extends Content>> r1 = this.c;
        if (r1.contains(r0) == true) goto L9;
        r1.add(r0);
    L9:
        if (r0.a() == MessageType.UNKNOWN) goto L4;
        Map<MessageType, gya.a<? extends Content>> r2 = this.d;
        ConcurrentHashMap r3 = (ConcurrentHashMap) r2;
        r3.put(r0.a(), r0);
        goto L4
    }

    public final void d(ImExtensionType r4, Collection<? extends Class<?>> r5) {
        Intrinsics.checkNotNullParameter(r4, "extensionType");
        Intrinsics.checkNotNullParameter(r5, "factoryClasses");
        Map<ImExtensionType, List<Class<?>>> r2 = com.ss.android.lark.im.base.d.a;
        Intrinsics.checkNotNullParameter(r4, "extensionType");
        Intrinsics.checkNotNullParameter(r5, "factoryClasses");
        Iterator<T> r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        com.ss.android.lark.im.base.d.d(r4, (Class) r6.next());
        goto L4
    }

    public final void e(ImExtensionType r2, Class<?> r3) {
        Intrinsics.checkNotNullParameter(r2, "extensionType");
        Intrinsics.checkNotNullParameter(r3, "factoryClass");
        com.ss.android.lark.im.base.d.d(r2, r3);
    }
}
