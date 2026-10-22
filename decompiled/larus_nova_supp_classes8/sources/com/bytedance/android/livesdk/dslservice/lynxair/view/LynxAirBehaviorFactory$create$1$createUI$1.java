package com.bytedance.android.livesdk.dslservice.lynxair.view;

import android.content.Context;
import com.bytedance.android.livesdk.dslservice.util.m;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.ui.view.UIView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import yt1.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/bytedance/android/livesdk/dslservice/lynxair/view/LynxAirBehaviorFactory$create$1$createUI$1", "Lcom/lynx/tasm/behavior/ui/view/UIView;", "dslservice-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LynxAirBehaviorFactory$create$1$createUI$1 extends UIView {
    public final /* synthetic */ LynxAirBehaviorFactory$create$1 a;

    public final void handleLayout() {
        super/*com.lynx.tasm.behavior.ui.LynxUI*/.handleLayout();
        m.h.a(new LynxAirBehaviorFactory$create$1$createUI$1$handleLayout$1(this));
        f r0 = this.a.a;
        if (r0 == null) goto L7;
        r0.a(new e(this, getView()), getProps());
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.dsl.api.DSLCustomViewInterface<com.lynx.tasm.behavior.ui.view.AndroidView>");
    }

    public final com.lynx.tasm.behavior.ui.view.a onCreateView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        f r0 = this.a.a;
        if (r0 == null) goto L7;
        return r0.createView(r2);
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.dsl.api.DSLCustomViewInterface<com.lynx.tasm.behavior.ui.view.AndroidView>");
    }

    public LynxAirBehaviorFactory$create$1$createUI$1(LynxAirBehaviorFactory$create$1 r1, LynxContext r2) {
        this.a = r1;
        super(r2);
    }
}
