package com.larus.bmhome.chat.component.bottom.voice;

import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import com.larus.bmhome.view.ChatConstraintLayout;
import com.larus.common_ui.view.TouchInterceptingView;
import com.obric.assistant.interaction.impl.window.helpers.WindowManagerLancet;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class i0 implements c {
    public final c0 a;
    public final ViewGroup b;
    public final WindowManager.LayoutParams c;
    public TouchInterceptingView d;
    public WindowManager e;
    public Function0<Unit> f;

    @Override // com.larus.bmhome.chat.component.bottom.voice.c
    public final void c() {
        f(this.e, this.d);
        c0 r0 = this.a;
        if (r0 == null) goto L6;
        r0.c = false;
        return;
    }

    @Override // com.larus.bmhome.chat.component.bottom.voice.c
    public final void d() {
        TouchInterceptingView r0 = this.d;
        if (r0 == null) goto L5;
        ViewParent r1 = r0.getParent();
    L6:
        if (r1 == null) goto L8;
        f(this.e, this.d);
    L8:
        WindowManager r2 = this.e;
        TouchInterceptingView r3 = this.d;
        WindowManager.LayoutParams r4 = this.c;
        if (r2 == null) goto L20;
        if (r3 == null) goto L20;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L15
        WindowManagerLancet.bindToAssistantWindowIfNeeded(r3, r4);     // Catch: Throwable -> L15
        r2.addView(r3, r4);     // Catch: Throwable -> L15
        Object r6 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L15
    L17:
        Throwable r7 = Result.exceptionOrNull-impl(r6);
        if (r7 == null) goto L20;
        int r8 = d0.d;
        d0.a.a("addWindowView failed view=" + r3 + ", lp=" + r4 + ", throwable=" + r7 + ", message=" + r7.getMessage());
    L15:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
    L20:
        c0 r10 = this.a;
        if (r10 == null) goto L26;
        r10.c = true;
        r10.d = false;
        return;
    L26:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public i0(c0 r3) {
        this.a = r3;
        this.b = null;
        WindowManager.LayoutParams r4 = new WindowManager.LayoutParams();
        r4.type = 2;
        r4.flags = 552;
        r4.format = -2;
        r4.gravity = 8388691;
        r4.width = -1;
        r4.height = -2;
        this.c = r4;
        this.f = new h0();
    }

    @Override // com.larus.bmhome.chat.component.bottom.voice.c
    public final void a(int r4) {
        WindowManager.LayoutParams r0 = this.c;
        c0 r1 = this.a;
        if (r1 == null) goto L5;
        int r5 = RangesKt.coerceAtMost(RangesKt.coerceAtLeast(r4, 0), r1.e);
    L6:
        r0.height = r5;
        return;
    L5:
        r5 = RangesKt.coerceAtLeast(r4, 0);
        goto L6
    }

    @Override // com.larus.bmhome.chat.component.bottom.voice.c
    public final void b(boolean r2) {
        c0 r0 = this.a;
        if (r0 == null) goto L5;
        r0.d = r2;
    L5:
        c();
    }

    public final void e(b r7) {
        Intrinsics.checkNotNullParameter(r7, "dependency");
        int r1 = d0.d;
        d0.a.a("VoiceMixInputUIController2: initController");
        Object r2 = r7.getActivity().getSystemService("window");
        if ((r2 instanceof WindowManager) == false) goto L5;
        WindowManager r3 = (WindowManager) r2;
    L6:
        this.e = r3;
        TouchInterceptingView r4 = new TouchInterceptingView(r7.getActivity(), null, 6, 0);
        r4.setEventHandler(new f0(this));
        this.d = r4;
        c0 r5 = this.a;
        if (r5 == null) goto L13;
        Intrinsics.checkNotNullParameter(r7, "dependency");
        ChatConstraintLayout r0 = r5.a;
        if (r0 == null) goto L11;
        r0.setInterruptBottomPaddingUpdate(new b0(r7, r5));
    L11:
        Function1<? super Integer, Unit> r8 = new g0(this);
        Intrinsics.checkNotNullParameter(r8, "<set-?>");
        r5.f = r8;
        return;
    L13:
        return;
    L5:
        r3 = null;
        goto L6
    }

    public static void f(WindowManager r2, TouchInterceptingView r3) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (r3 != null) goto L14;
        return;
    L14:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L8
        r2.removeViewImmediate(r3);     // Catch: Throwable -> L8
        Object r4 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r5 = Result.exceptionOrNull-impl(r4);
        if (r5 == null) goto L16;
        int r1 = d0.d;
        d0.a.a("removeWindowView failed view=" + r3 + ", throwable=" + r5 + ", message=" + r5.getMessage());
        return;
    L16:
        return;
    L8:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }
}
