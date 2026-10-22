package com.bytedance.android.anniex.container;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.lynx.tasm.LynxView;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class h implements com.bytedance.android.anniex.container.popup.e {
    public final /* synthetic */ d a;

    @Override // com.bytedance.android.anniex.container.popup.e
    public final boolean disableDragDown() {
        ab.a r0 = this.a.j;
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L15;
        ab.a r10 = this.a.j;
        if (r10 == null) goto L12;
        int r11 = r10.p();
    L13:
        if (r11 > 0) goto L15;
    L45:
        return true;
    L12:
        r11 = 0;
    L15:
        if (this.a.t() == true) goto L45;
        d r12 = this.a;
        ab.a r13 = r12.j;
        if (r13 == null) goto L26;
        y36.a r14 = r13.Z;
        if (r14 == null) goto L23;
        Boolean r15 = (Boolean) ((y36.i) r14).b;
        if (r15 == null) goto L23;
        boolean r16 = r15.booleanValue();
    L24:
        if (r16 != true) goto L26;
        boolean r17 = true;
    L27:
        if (r17 == false) goto L41;
        if (r12.s <= 0) goto L31;
    L42:
        boolean r18 = true;
    L44:
        if (r18 == true) goto L45;
        return false;
    L31:
        if (r12.getKitView() != null) goto L33;
    L37:
        boolean r19 = false;
    L38:
        if (r19 == false) goto L42;
    L43:
        r18 = false;
        goto L44
    L33:
        if ((r12.getKitView() instanceof LynxView) == false) goto L37;
        View r20 = r12.getKitView();
        Intrinsics.checkNotNull(r20);
        if (r20.canScrollVertically(-1) == true) goto L37;
        r19 = true;
        goto L38
    L41:
        if (r12.s <= 0) goto L43;
    L23:
        r16 = false;
    L26:
        r17 = false;
        goto L27
    L5:
        if (r0.o() == true) goto L7;
        r1 = true;
        goto L8
    }

    public h(d r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.anniex.container.popup.e
    public final boolean a(MotionEvent r10) {
        Intrinsics.checkNotNullParameter(r10, "event");
        View r1 = this.a.getRootView();     // Catch: Exception -> L21
        if (r1 == null) goto L6;
        FrameLayout r11 = (FrameLayout) r1.findViewById(2131363008);     // Catch: Exception -> L21
    L7:
        Rect r12 = new Rect();     // Catch: Exception -> L21
        if (r11 == null) goto L11;
        r11.getGlobalVisibleRect(r12);     // Catch: Exception -> L21
    L11:
        if (r10.getRawX() >= r12.left) goto L13;
        return false;
    L13:
        if (r10.getRawX() <= r12.right) goto L15;
        return false;
    L15:
        if (r10.getRawY() < r12.top) goto L26;
        if (r10.getRawY() <= r12.bottom) goto L20;
        return false;
    L20:
        return true;
    L26:
        return false;
    L6:
        r11 = null;
    L28:
        return false;
    }

    @Override // com.bytedance.android.anniex.container.popup.e
    public final boolean shouldInterceptSlide(int r10) {
        d r0 = this.a;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L23
        ab.a r12 = r0.j;     // Catch: Throwable -> L23
        boolean r13 = false;
        if (r12 == null) goto L14;
        int r14 = r12.p();     // Catch: Throwable -> L23
        if (r14 != 0) goto L11;
        FrameLayout r15 = r0.q;     // Catch: Throwable -> L23
        if (r15 == null) goto L10;
        Integer r16 = Integer.valueOf(r15.getHeight());     // Catch: Throwable -> L23
    L12:
        if (r16 == null) goto L14;
        int r1 = r16.intValue();     // Catch: Throwable -> L23
    L19:
        if (r10 <= (com.bytedance.android.anniex.container.util.i.a.d() - r1)) goto L21;
        r13 = true;
    L21:
        Object r17 = Result.constructor-impl(Boolean.valueOf(r13));     // Catch: Throwable -> L23
    L26:
        if (Result.isSuccess-impl(r17) == true) goto L28;
        Result.exceptionOrNull-impl(r17);
        return true;
    L28:
        return ((Boolean) r17).booleanValue();
    L10:
        r16 = null;
        goto L12
    L11:
        r16 = Integer.valueOf(com.bytedance.android.anniex.container.util.i.a.a(r14));     // Catch: Throwable -> L23
    L14:
        FrameLayout r18 = r0.q;     // Catch: Throwable -> L23
        if (r18 == null) goto L17;
        r1 = r18.getHeight();     // Catch: Throwable -> L23
        goto L19
    L17:
        r1 = 0;
    L23:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r17 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L26
    }
}
