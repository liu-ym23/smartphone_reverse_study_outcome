package com.bytedance.android.livesdk.dslservice.lynxair.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.livesdk.dslservice.util.m;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.ui.UIGroup;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import yt1.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"com/bytedance/android/livesdk/dslservice/lynxair/view/LynxAirBehaviorFactory$create$2$createUI$1", "Lcom/lynx/tasm/behavior/ui/UIGroup;", "Landroid/view/ViewGroup;", "dslservice-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LynxAirBehaviorFactory$create$2$createUI$1 extends UIGroup<ViewGroup> {
    public final /* synthetic */ c a;

    public final void handleLayout() {
        super/*com.lynx.tasm.behavior.ui.LynxUI*/.handleLayout();
        m.h.a(new LynxAirBehaviorFactory$create$2$createUI$1$handleLayout$1(this));
        f r0 = this.a.a;
        if (r0 == null) goto L7;
        r0.a(new e(this, getView()), getProps());
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.dsl.api.DSLCustomViewInterface<android.view.ViewGroup>");
    }

    public final View createView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        View r3 = this.a.a.createView(r2);
        if (r3 == null) goto L7;
        return (ViewGroup) r3;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    public LynxAirBehaviorFactory$create$2$createUI$1(c r1, LynxContext r2) {
        this.a = r1;
        super(r2);
    }
}
