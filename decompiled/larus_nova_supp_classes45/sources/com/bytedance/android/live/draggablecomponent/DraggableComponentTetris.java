package com.bytedance.android.live.draggablecomponent;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.layer.core.tetris.LiveTetris;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001\u0007B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/draggablecomponent/DraggableComponentTetris;", "Lcom/bytedance/android/live/core/tetris/layer/core/tetris/LiveTetris;", "Ld90/a;", "Lc61/d;", "Lc61/f;", "<init>", "()V", "a", "experience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DraggableComponentTetris extends LiveTetris<d90.a> implements c61.d<c61.f> {
    public DraggableConstraintLayout o;
    public final DraggableWindowContext p;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris
    public final void O() {
        DraggableWindowContext r0 = this.p;
        if (r0 == null) goto L6;
        r0.setContainer(this);
        return;
    }

    public DraggableComponentTetris() {
        DraggableWindowContext.Companion.getClass();
        c61.g r0 = DraggableWindowContext.b.a();
        if ((r0 instanceof DraggableWindowContext) == true) goto L5;
        r0 = null;
    L5:
        this.p = (DraggableWindowContext) r0;
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris
    public final void onDestroy() {
        super.onDestroy();
        DraggableConstraintLayout r0 = this.o;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L5:
        r0.removeAllViews();
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris
    public final View G(t70.k r2) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        View r3 = r2.b(2131567651);
        if (r3 == null) goto L9;
        this.o = (DraggableConstraintLayout) r3;
        ALogger.i("DraggableComponentTetris", "Tetris created");
        DraggableConstraintLayout r4 = this.o;
        if (r4 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L7:
        return r4;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.draggablecomponent.DraggableConstraintLayout");
    }

    public final boolean v(c61.c r4) {
        DraggableConstraintLayout r0 = this.o;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L5:
        if (r0 == null) goto L16;
        Sequence<View> r1 = UtilityKotlinExtentionsKt.g(r0);
        if (r1 == null) goto L24;
        Iterator r2 = r1.iterator();
    L10:
        if (r2.hasNext() == false) goto L25;
        Object r3 = ((View) r2.next()).getTag();
        if (r3 == null) goto L10;
        if (r3.equals(r4) != true) goto L10;
        return true;
    L25:
        return false;
    L24:
        return false;
    L16:
        return false;
    }

    public final void u(LiveAnchorTeleprompterView r5, Function0 r6) {
        Intrinsics.checkNotNullParameter(r6, "finish");
        if (r5 == null) goto L21;
        View r0 = r5.getMView();
        if (r0 == null) goto L21;
        ViewParent r1 = r0.getParent();
        if ((r1 instanceof ViewGroup) == true) goto L9;
        r1 = null;
    L9:
        ViewGroup r2 = (ViewGroup) r1;
        if (r2 == null) goto L12;
        r2.removeView(r0);
    L12:
        FrameLayout.LayoutParams r3 = new FrameLayout.LayoutParams(-2, -2);
        r3.gravity = r5.getDraggableConfig().a;
        DraggableConstraintLayout r4 = this.o;
        if (r4 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L15:
        r4.addView(r0, r3);
        Float r7 = r5.getDraggableConfig().b;
        if (r7 == null) goto L18;
        r0.setX(r7.floatValue());
    L18:
        Float r8 = r5.getDraggableConfig().c;
        if (r8 == null) goto L21;
        r0.setY(r8.floatValue());
    L21:
        r6.invoke();
    }

    public final void g(c61.c r5, int r6, Function0<Unit> r7) {
        Intrinsics.checkNotNullParameter(r7, "finish");
        DraggableConstraintLayout r0 = this.o;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L5:
        if (r0 == null) goto L19;
        Sequence<View> r1 = UtilityKotlinExtentionsKt.g(r0);
        if (r1 == null) goto L27;
        Iterator r2 = r1.iterator();
    L10:
        if (r2.hasNext() == false) goto L28;
        View r3 = (View) r2.next();
        Object r4 = r3.getTag();
        if (r4 == null) goto L10;
        if (r4.equals(r5) != true) goto L10;
        if ((r3 instanceof c61.f) == true) goto L18;
        r3 = null;
    L18:
        p((c61.f) r3, r6, r7);
        goto L10
    L28:
        return;
    L27:
        return;
    }

    public final void p(c61.f r9, int r11, Function0<Unit> r12) {
        Intrinsics.checkNotNullParameter(r12, "finish");
        DraggableConstraintLayout r0 = this.o;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L5:
        if (r0 == null) goto L41;
        Sequence<View> r1 = UtilityKotlinExtentionsKt.g(r0);
        if (r1 == null) goto L41;
        Iterator r2 = r1.iterator();
    L10:
        if (r2.hasNext() == false) goto L41;
        View r3 = (View) r2.next();
        if (Intrinsics.areEqual(r3, r9) == false) goto L10;
        Object r4 = null;
        if ((r3 instanceof c61.f) == true) goto L16;
        View r5 = null;
    L17:
        c61.f r6 = (c61.f) r5;
        if (r6 == null) goto L20;
        r6.onDestroy();
    L20:
        DraggableConstraintLayout r7 = this.o;
        if (r7 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L23:
        r7.removeView(r3);
        DraggableWindowContext r8 = this.p;
        if (r8 == null) goto L10;
        c61.e r13 = r8.monitor();
        if (r13 == null) goto L10;
        c61.b r14 = new c61.b("livesdk_draggable_component_destroy");
        if (r9 == null) goto L30;
        Long r15 = Long.valueOf(r9.getIdentity());
    L31:
        r14.b("type", String.valueOf(r15.longValue()));
        Object r16 = r3.getTag();
        if ((r16 instanceof c61.c) == false) goto L35;
        r4 = r16;
    L35:
        c61.c r17 = (c61.c) r4;
        if (r17 == null) goto L39;
        String r18 = r17.b;
        if (r18 == null) goto L39;
    L40:
        r14.b("scene", r18);
        r14.b("reason", String.valueOf(r11));
        Unit r19 = Unit.INSTANCE;
        r13.a(r14.a());
    L39:
        r18 = "";
        goto L40
    L30:
        r15 = null;
        goto L31
    L16:
        r5 = r3;
    L41:
        r12.invoke();
    }
}
