package com.ss.android.lark.keyboard.ime;

import java.util.LinkedList;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d implements c {
    public final LinkedList<a> a;
    public final LinkedList<a> b;
    public final LinkedList<a> c;
    public final LinkedList<a> d;

    public static final class a {
        public final boolean a;
        public final Function0<Unit> b;

        public /* synthetic */ a() {
            throw null;
        }

        public a(boolean r2, Function0<Unit> r3) {
            Intrinsics.checkNotNullParameter(r3, "action");
            this.a = r2;
            this.b = r3;
        }
    }

    @Override // com.ss.android.lark.keyboard.ime.c
    public final void clear() {
        this.a.clear();
        this.b.clear();
        this.c.clear();
        this.d.clear();
    }

    public d() {
        this.a = new LinkedList();
        this.b = new LinkedList();
        this.c = new LinkedList();
        this.d = new LinkedList();
    }

    @Override // com.ss.android.lark.keyboard.ime.c
    public final void a(Function0<Unit> r4) {
        Intrinsics.checkNotNullParameter(r4, "action");
        this.c.add(new a(false, r4));
    }

    @Override // com.ss.android.lark.keyboard.ime.c
    public final void b(Function0<Unit> r4) {
        Intrinsics.checkNotNullParameter(r4, "action");
        this.a.add(new a(true, r4));
    }

    @Override // com.ss.android.lark.keyboard.ime.c
    public final void c(Function0<Unit> r4) {
        Intrinsics.checkNotNullParameter(r4, "action");
        this.b.add(new a(false, r4));
    }

    @Override // com.ss.android.lark.keyboard.ime.c
    public final void d(Function0<Unit> r4) {
        Intrinsics.checkNotNullParameter(r4, "action");
        this.d.add(new a(false, r4));
    }

    @Override // com.ss.android.lark.keyboard.ime.c
    public final void e(Function0<Unit> r4) {
        Intrinsics.checkNotNullParameter(r4, "action");
        this.d.add(new a(true, r4));
    }

    @Override // com.ss.android.lark.keyboard.ime.c
    public final void f(Function0<Unit> r4) {
        Intrinsics.checkNotNullParameter(r4, "action");
        this.a.add(new a(false, r4));
    }

    @Override // com.ss.android.lark.keyboard.ime.c
    public final void g(Function0<Unit> r4) {
        Intrinsics.checkNotNullParameter(r4, "action");
        this.b.add(new a(true, r4));
    }
}
