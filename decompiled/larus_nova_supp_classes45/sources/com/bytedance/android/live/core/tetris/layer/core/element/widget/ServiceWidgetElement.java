package com.bytedance.android.live.core.tetris.layer.core.element.widget;

import androidx.lifecycle.Lifecycle;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.tetris.layer.core.element.service.ServiceElement;
import com.bytedance.android.live.core.tetris.widgets.RecyclableWidgetManager;
import com.bytedance.ies.sdk.widgets.Widget;
import h70.b;
import j70.o;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/core/tetris/layer/core/element/widget/ServiceWidgetElement;", "Lcom/bytedance/android/live/core/tetris/layer/core/element/service/ServiceElement;", "Lcom/bytedance/ies/sdk/widgets/Widget;", "tetris_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ServiceWidgetElement extends ServiceElement<Widget> {
    public final Lazy l;
    public Widget m;
    public final RecyclableWidgetManager n;
    public final o o;

    @Override // com.bytedance.android.live.core.tetris.layer.core.element.Element
    public final Lifecycle g() {
        return this.n.getLifecycle();
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.element.Element
    public final Object i() {
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
        if ((r0 instanceof o70.a) == false) goto L14;
        o70.a r1 = this.m;
        if (r1 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("widget");
    L10:
        if (r1 == null) goto L13;
        return r1;
    L13:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.core.tetris.layer.core.event.ElementEventResolver");
    L14:
        return null;
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.element.Element
    public final void k() {
        StringBuilder r0 = new StringBuilder("element onDetachedFromLayer descriptor ");
        r0.append(this.o.getClass().getCanonicalName());
        r0.append(" -> ");
        Widget r1 = this.m;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("widget");
    L5:
        r0.append(r1.getClass().getCanonicalName());
        ALogger.i("【widget】", r0.toString());
        m();
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.element.service.ServiceElement
    public final void l() {
        w70.a<? extends b> r0 = this.o.j();
        if ((r0 instanceof w70.a) == true) goto L5;
        r0 = null;
    L5:
        if (r0 == null) goto L7;
        Widget r1 = r0.a(this.k);
    L8:
        if (r1 != null) goto L13;
        Class<? extends Widget> r2 = this.o.c();
        if (r2 == null) goto L12;
        r1 = r2.newInstance();
        goto L13
    L12:
        r1 = null;
    L13:
        if (r1 == null) goto L15;
    L17:
        if (r1 == null) goto L39;
        this.m = r1;
        StringBuilder r3 = new StringBuilder("element onAttachToLayer descriptor ");
        r3.append(this.o.getClass().getCanonicalName());
        r3.append(" -> ");
        Widget r4 = this.m;
        if (r4 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("widget");
    L21:
        r3.append(r4.getClass().getCanonicalName());
        ALogger.i("【widget】", r3.toString());
        com.bytedance.android.live.core.tetris.componentx.component.b r5 = this.c;
        if (r5 == null) goto L27;
        Widget r6 = this.m;
        if (r6 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("widget");
    L26:
        r5.d(this, r6);
    L27:
        com.bytedance.android.live.core.tetris.componentx.component.b r7 = this.c;
        if (r7 == null) goto L33;
        Widget r8 = this.m;
        if (r8 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("widget");
    L32:
        r7.c(this, r8);
    L33:
        RecyclableWidgetManager r9 = this.n;
        Widget r11 = this.m;
        if (r11 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("widget");
    L36:
        r9.load(r11);
        return;
    L39:
        throw new NullPointerException("create widget error, element type is " + this.d);
    L15:
        if (((Boolean) this.l.getValue()).booleanValue() == false) goto L17;
        SafetyGuard.a(null, null, "create widget error, element is " + this.d);
        r1 = new EmptyWidget();
        goto L17
    L7:
        r1 = null;
        goto L8
    }

    public final void m() {
        RecyclableWidgetManager r0 = this.n;
        Widget r1 = this.m;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("widget");
    L5:
        r0.unload(r1);
        com.bytedance.android.live.core.tetris.componentx.component.b r2 = this.c;
        if (r2 == null) goto L12;
        Widget r3 = this.m;
        if (r3 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("widget");
    L10:
        r2.e(this, r3);
        return;
    }

    public ServiceWidgetElement(RecyclableWidgetManager r2, o r3, b r4) {
        Intrinsics.checkNotNullParameter(r2, "widgetManager");
        Intrinsics.checkNotNullParameter(r3, "widgetAttribute");
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4);
        this.n = r2;
        this.o = r3;
        this.l = LazyKt.lazy(ServiceWidgetElement$enableEmptyWidgetOpt$2.INSTANCE);
    }
}
