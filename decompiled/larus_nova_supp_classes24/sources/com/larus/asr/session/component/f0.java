package com.larus.asr.session.component;

import com.larus.im.bean.message.Message;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class f0 {
    public final String a;
    public final Function0<Boolean> b;
    public k0 c;
    public volatile Message d;
    public final AtomicBoolean e;
    public final AtomicBoolean f;
    public final AtomicBoolean g;
    public final AtomicBoolean h;
    public volatile String i;
    public final CopyOnWriteArraySet<com.larus.bmhome.chat.component.bottom.core.speaker.h> j;
    public final CopyOnWriteArraySet<com.larus.bmhome.chat.component.bottom.core.speaker.b> k;
    public final AtomicReference<com.larus.bmhome.chat.component.bottom.core.speaker.g> l;
    public volatile String m;
    public volatile long n;
    public volatile AsrEngineRoute o;
    public final Lazy p;
    public boolean q;

    public final boolean a() {
        if (((Boolean) this.b.invoke()).booleanValue() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.h.get() == true) goto L7;
        return true;
    }

    public final k0 b() {
        k0 r0 = this.c;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("request");
        return null;
    }

    public final boolean c() {
        return this.e.get();
    }

    public final void d() {
        this.f.set(false);
    }

    public final void e(com.larus.bmhome.chat.component.bottom.core.speaker.g r4) {
        Intrinsics.checkNotNullParameter(r4, "state");
        this.l.set(r4);
        Iterator<T> r0 = this.j.iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        com.larus.bmhome.chat.component.bottom.core.speaker.h r1 = (com.larus.bmhome.chat.component.bottom.core.speaker.h) r0.next();
        if (((Boolean) this.b.invoke()).booleanValue() == false) goto L7;
        r1.a(r4);
        goto L4
    L7:
        return;
    }

    public final boolean f(boolean r4) {
        if (this.g.compareAndSet(false, true) == true) goto L5;
        return false;
    L5:
        if (r4 == false) goto L7;
        this.f.set(false);
    L7:
        return true;
    }

    public f0(String r2, Function0<Boolean> r3) {
        Intrinsics.checkNotNullParameter(r2, "sessionId");
        Intrinsics.checkNotNullParameter(r3, "isCurrentSession");
        this.a = r2;
        this.b = r3;
        this.e = new AtomicBoolean(false);
        this.f = new AtomicBoolean(false);
        this.g = new AtomicBoolean(false);
        this.h = new AtomicBoolean(false);
        this.j = new CopyOnWriteArraySet();
        this.k = new CopyOnWriteArraySet();
        this.l = new AtomicReference();
        this.o = AsrEngineRoute.NONE;
        this.p = LazyKt.lazy(new e0());
    }
}
