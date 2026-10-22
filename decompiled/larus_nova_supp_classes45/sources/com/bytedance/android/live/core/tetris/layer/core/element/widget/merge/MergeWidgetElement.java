package com.bytedance.android.live.core.tetris.layer.core.element.widget.merge;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.componentx.component.b;
import com.bytedance.android.live.core.tetris.layer.core.ViewLayer;
import com.bytedance.android.live.core.tetris.layer.core.element.Element;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.livesdk.preview.merge.AbsMergeWidget;
import com.bytedance.livesdk.preview.merge.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/core/tetris/layer/core/element/widget/merge/MergeWidgetElement;", "Lcom/bytedance/android/live/core/tetris/layer/core/element/Element;", "Lcom/bytedance/livesdk/preview/merge/AbsMergeWidget;", "tetris_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MergeWidgetElement extends Element<AbsMergeWidget> {
    public AbsMergeWidget l;
    public final a m;
    public final n70.a n;

    @Override // com.bytedance.android.live.core.tetris.layer.core.element.Element
    public final Lifecycle g() {
        return null;
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.element.Element
    public final AbsMergeWidget i() {
        AbsMergeWidget r0 = this.l;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("widget");
    L5:
        return r0;
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.element.Element
    public final o70.a j() {
        AbsMergeWidget r0 = this.l;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("widget");
    L6:
        if ((r0 instanceof o70.a) == false) goto L15;
        o70.a r1 = this.l;
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

    @Override // com.bytedance.android.live.core.tetris.layer.core.element.Element
    public final void k() {
        a r0 = this.m;
        AbsMergeWidget r1 = this.l;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("widget");
    L5:
        r0.ME(r1);
        b r2 = this.c;
        if (r2 == null) goto L12;
        AbsMergeWidget r3 = this.l;
        if (r3 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("widget");
    L10:
        r2.e(this, r3);
        return;
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.element.Element
    public final void onViewCreated(View r11) {
        AbsMergeWidget r1 = null;
        if (this.a == true) goto L20;
        if (r11 == null) goto L10;
        Intrinsics.checkNotNullParameter(r11, "$this$parentView");
        ViewParent r2 = r11.getParent();
        if ((r2 instanceof ViewGroup) == true) goto L9;
        r2 = null;
    L9:
        ViewGroup r3 = (ViewGroup) r2;
    L12:
        if ((r3 instanceof ViewLayer) == false) goto L20;
        if (r11 == null) goto L18;
        Intrinsics.checkNotNullParameter(r11, "$this$parentView");
        ViewParent r12 = r11.getParent();
        if ((r12 instanceof ViewGroup) == true) goto L17;
        r12 = null;
    L17:
        r11 = (ViewGroup) r12;
        goto L20
    L18:
        r11 = null;
        goto L20
    L10:
        r3 = null;
    L20:
        if ((r11 instanceof ViewGroup) == false) goto L56;
        this.n.j();
        Class<? extends AbsMergeWidget> r0 = this.n.c();
        if (r0 != null) goto L27;
        if (v.a() == true) goto L27;
        ALogger.i("MergeWidgetElement", "elementClass is null, widgetAttribute=" + this.n);
        AbsMergeWidget r4 = null;
    L32:
        if (r4 != null) goto L34;
        return;
    L34:
        this.l = r4;
        b r5 = this.c;
        if (r5 == null) goto L37;
        r5.d(this, r4);
    L37:
        b r6 = this.c;
        if (r6 == null) goto L43;
        AbsMergeWidget r7 = this.l;
        if (r7 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("widget");
    L42:
        r6.c(this, r7);
    L43:
        AbsMergeWidget r8 = this.l;
        if (r8 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("widget");
    L46:
        ViewGroup r9 = (ViewGroup) r11;
        boolean r13 = r8 instanceof LiveRecyclableWidget;
        if (r13 == false) goto L53;
        a r14 = this.m;
        if (r13 == false) goto L52;
        r1 = r8;
    L52:
        Intrinsics.checkNotNull(r14.Gq(r9, (LiveRecyclableWidget) r1, this.n.h(), this.n.f(), this.n.a()));
        return;
    L53:
        this.m.li(r9, r8, this.n.h(), this.n.f());
        return;
    L27:
        if (r0 == null) goto L55;
        if (LiveRecyclableWidget.class.isAssignableFrom(r0) == false) goto L31;
        r4 = (AbsMergeWidget) this.m.eW(r0);
        goto L32
    L31:
        r4 = r0.newInstance();
        goto L32
    L55:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<*>");
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.element.Element
    public final View c(Context r5, ViewGroup r6) {
        Intrinsics.checkNotNullParameter(r5, "context");
        ViewGroup r0 = this.n.e(r5);
        if (r0 == null) goto L5;
        return r0;
    L5:
        if (r6 == null) goto L9;
        return (View) r6.getClass().getConstructor(new Class[]{Context.class}).newInstance(new Object[]{r5});
    L9:
        return new FrameLayout(r5);
    }

    public MergeWidgetElement(a r2, n70.a r3, h70.b r4) {
        Intrinsics.checkNotNullParameter(r2, "widgetManager");
        Intrinsics.checkNotNullParameter(r3, "widgetAttribute");
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4);
        this.m = r2;
        this.n = r3;
        this.a = r3.g();
    }
}
