package com.larus.bmhome.instruction.handler;

import androidx.fragment.app.Fragment;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public abstract class i implements m {
    public final com.larus.bmhome.instruction.p a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public final Lazy h;
    public final Lazy i;

    public final com.larus.bmhome.chat.component.cvs.y b() {
        return (com.larus.bmhome.chat.component.cvs.y) this.b.getValue();
    }

    public final ICoreInputAbility c() {
        return (ICoreInputAbility) this.h.getValue();
    }

    public final Fragment d() {
        return s1a.a.c(this.a.a);
    }

    public final t1a.b e() {
        return s1a.d.a(this.a.a);
    }

    public i(com.larus.bmhome.instruction.p r2) {
        Intrinsics.checkNotNullParameter(r2, "instructionCoreAbility");
        this.a = r2;
        this.b = LazyKt.lazy(new a(this));
        this.c = LazyKt.lazy(new b(this));
        this.d = LazyKt.lazy(new c(this));
        this.e = LazyKt.lazy(new d(this));
        this.f = LazyKt.lazy(new e(this));
        this.g = LazyKt.lazy(new f(this));
        this.h = LazyKt.lazy(new g(this));
        this.i = LazyKt.lazy(new h(this));
    }
}
