package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.business.button;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.s;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a implements g {
    public static final /* synthetic */ int e = 0;
    public final h a;
    public View b;
    public final jp1.b c;
    public final lp1.a d;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.business.button.a$a, reason: collision with other inner class name */
    public static final class C0075a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.core.recycle.b
    public final void f() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.business.button.g
    public final void release() {
        this.a.j();
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.core.recycle.b
    public final /* bridge */ /* synthetic */ Integer g() {
        return k();
    }

    public final Integer k() {
        return Integer.valueOf(j().getButton().g);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.business.button.g
    public final View a() {
        return this.b;
    }

    public final lp1.a j() {
        return this.d;
    }

    public a(jp1.b r2, lp1.a r3) {
        Intrinsics.checkNotNullParameter(r2, "session");
        Intrinsics.checkNotNullParameter(r3, "model");
        this.c = r2;
        this.d = r3;
        this.a = new h(r2);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.business.button.g
    public final View b(ViewGroup r3, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e r4) {
        Intrinsics.checkNotNullParameter(r3, "parentView");
        Intrinsics.checkNotNullParameter(r3, "parentView");
        View r5 = this.a.x(r3, 5.35f, r4);
        this.b = r5;
        return r5;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.business.button.g
    public final void d(final lp1.a r3, final View r4, final int r5) {
        Intrinsics.checkNotNullParameter(r3, "model");
        Intrinsics.checkNotNullParameter(r4, "itemView");
        h r0 = this.a;
        Function1<s<lp1.a>, Unit> r1 = new ButtonHolder$bindData$1(this, r3, r4, r5);
        Intrinsics.checkNotNullParameter(r0, "$this$use");
        if (r0 == null) goto L6;
        Unit r6 = (Unit) r1.invoke(r0);
        return;
    }
}
