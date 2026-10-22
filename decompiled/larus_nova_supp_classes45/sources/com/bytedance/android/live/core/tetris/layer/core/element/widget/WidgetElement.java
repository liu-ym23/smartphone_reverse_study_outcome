package com.bytedance.android.live.core.tetris.layer.core.element.widget;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.tetris.componentx.component.b;
import com.bytedance.android.live.core.tetris.layer.core.element.Element;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.tetris.widgets.RecyclableWidgetManager;
import com.bytedance.ies.sdk.widgets.Widget;
import j70.o;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/core/tetris/layer/core/element/widget/WidgetElement;", "Lcom/bytedance/android/live/core/tetris/layer/core/element/Element;", "Lcom/bytedance/ies/sdk/widgets/Widget;", "tetris_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WidgetElement extends Element<Widget> {
    public final Lazy l;
    public Widget m;
    public final RecyclableWidgetManager n;
    public final o o;

    @Override // com.bytedance.android.live.core.tetris.layer.core.element.Element
    public final Lifecycle g() {
        return this.n.getLifecycle();
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.element.Element
    public final Widget i() {
        Widget r0 = this.m;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("widget");
    L5:
        return r0;
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.element.Element
    public final o70.a j() {
        Widget r0 = this.m;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("widget");
    L6:
        if ((r0 instanceof o70.a) == false) goto L15;
        o70.a r1 = this.m;
        if (r1 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("widget");
    L10:
        if (r1 == null) goto L14;
        return r1;
    L14:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.core.tetris.layer.core.event.ElementEventResolver");
    L15:
        return null;
    }

    public final void l() {
        RecyclableWidgetManager r0 = this.n;
        Widget r1 = this.m;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("widget");
    L5:
        r0.unload(r1);
        b r2 = this.c;
        if (r2 == null) goto L12;
        Widget r3 = this.m;
        if (r3 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("widget");
    L10:
        r2.e(this, r3);
        return;
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.element.Element
    public final void k() {
        l();
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.element.Element
    public final void onViewCreated(View r7) {
        if ((r7 instanceof ViewGroup) == false) goto L62;
        w70.a<? extends h70.b> r0 = this.o.j();
        z70.a r2 = null;
        if ((r0 instanceof w70.a) == true) goto L7;
        r0 = null;
    L7:
        if (r0 == null) goto L9;
        Widget r1 = r0.a(this.k);
    L10:
        if (r1 != null) goto L18;
        Class<? extends Widget> r3 = this.o.c();
        if (r3 != null) goto L14;
        r1 = null;
        goto L18
    L14:
        if (LiveRecyclableWidget.class.isAssignableFrom(r3) == false) goto L16;
        r1 = (Widget) this.n.W90(r3);
        goto L18
    L16:
        r1 = r3.newInstance();
    L18:
        if (r1 == null) goto L20;
    L22:
        if (r1 == null) goto L61;
        this.m = r1;
        b r4 = this.c;
        if (r4 == null) goto L26;
        r4.d(this, r1);
    L26:
        b r5 = this.c;
        if (r5 == null) goto L32;
        Widget r6 = this.m;
        if (r6 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("widget");
    L31:
        r5.c(this, r6);
    L32:
        LiveRecyclableWidget r8 = this.m;
        if (r8 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("widget");
    L35:
        ViewGroup r9 = (ViewGroup) r7;
        if ((r8 instanceof LiveRecyclableWidget) == false) goto L38;
        boolean r11 = this.o.h();
        this.o.f();
        this.n.fa0(r9, r8, r11, this.o.a());
    L63:
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L58
        Widget r13 = this.m;     // Catch: Throwable -> L58
        if (r13 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("widget");     // Catch: Throwable -> L58
    L43:
        if ((r13 instanceof z70.a) == false) goto L56;
        Map<String, String> r14 = this.g;     // Catch: Throwable -> L58
        if (r14 == null) goto L56;
        z70.a r15 = this.m;     // Catch: Throwable -> L58
        if (r15 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("widget");     // Catch: Throwable -> L58
    L50:
        if ((r15 instanceof z70.a) == false) goto L53;
        r2 = r15;
    L53:
        z70.a r16 = r2;     // Catch: Throwable -> L58
        if (r16 == null) goto L56;
        r16.setExtraInfo(r14);     // Catch: Throwable -> L58
    L56:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L58
        return;
    L58:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return;
    L38:
        this.n.da0(r9, r8, this.o.h(), this.o.f());
        goto L63
    L61:
        throw new NullPointerException("create widget error, element type is " + this.d);
    L20:
        if (((Boolean) this.l.getValue()).booleanValue() == false) goto L22;
        SafetyGuard.a(null, null, "create widget error, element is " + this.d);
        r1 = new EmptyWidget();
        goto L22
    L9:
        r1 = null;
        goto L10
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.element.Element
    public final View c(Context r5, ViewGroup r6) {
        Intrinsics.checkNotNullParameter(r5, "context");
        ViewGroup r0 = this.o.e(r5);
        if (r0 == null) goto L5;
        return r0;
    L5:
        if (r6 == null) goto L9;
        return (View) r6.getClass().getConstructor(new Class[]{Context.class}).newInstance(new Object[]{r5});
    L9:
        return new FrameLayout(r5);
    }

    public WidgetElement(RecyclableWidgetManager r2, o r3, h70.b r4) {
        Intrinsics.checkNotNullParameter(r2, "widgetManager");
        Intrinsics.checkNotNullParameter(r3, "widgetAttribute");
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4);
        this.n = r2;
        this.o = r3;
        this.a = r3.g();
        this.l = LazyKt.lazy(WidgetElement$enableEmptyWidgetOpt$2.INSTANCE);
    }
}
