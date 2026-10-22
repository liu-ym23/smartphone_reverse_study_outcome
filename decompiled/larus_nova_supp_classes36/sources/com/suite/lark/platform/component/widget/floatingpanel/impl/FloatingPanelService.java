package com.suite.lark.platform.component.widget.floatingpanel.impl;

import android.os.Handler;
import android.os.Looper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.api.s;
import com.ss.android.lark.passportc.dwarf.UserScope;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import yoc.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@UserScope
public final class FloatingPanelService extends c0c.c implements h {
    public final com.suite.lark.platform.component.widget.floatingpanel.impl.a b;
    public final Handler c;

    public static final class a implements Runnable {
        public final /* synthetic */ Function1<com.suite.lark.platform.component.widget.floatingpanel.impl.a, Unit> a;
        public final /* synthetic */ FloatingPanelService b;

        /* JADX WARN: Multi-variable type inference failed */
        public a(Function1<? super com.suite.lark.platform.component.widget.floatingpanel.impl.a, Unit> r1, FloatingPanelService r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.invoke(this.b.b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // yoc.h
    public final void G6() {
        m(FloatingPanelService$collapseCardList$1.INSTANCE);
    }

    @Override // yoc.h
    public final int c8() {
        return this.b.c8();
    }

    @Inject
    public FloatingPanelService(m r2) {
        Intrinsics.checkNotNullParameter(r2, "passport");
        super(r2);
        this.b = new com.suite.lark.platform.component.widget.floatingpanel.impl.a();
        this.c = new Handler(Looper.getMainLooper());
        s.a(this);
    }

    public final void d(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
        Intrinsics.checkNotNullParameter(r2, "state");
        m(new FloatingPanelService$destroy$1(this));
    }

    public final void m(Function1<? super com.suite.lark.platform.component.widget.floatingpanel.impl.a, Unit> r3) {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L6;
        r3.invoke(this.b);
        return;
    L6:
        this.c.post(new a(r3, this));
    }

    @Override // yoc.h
    public final void ra(final yoc.c r2) {
        Intrinsics.checkNotNullParameter(r2, "card");
        m(new FloatingPanelService$showCard$1(r2));
    }

    @Override // yoc.h
    public final void y2(final int r2, final String r3) {
        Intrinsics.checkNotNullParameter(r3, "id");
        m(new FloatingPanelService$removeCard$1(r2, r3));
    }
}
