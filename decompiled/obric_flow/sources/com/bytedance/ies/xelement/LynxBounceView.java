package com.bytedance.ies.xelement;

import android.content.Context;
import android.view.View;
import com.lynx.react.bridge.ReadableType;
import com.lynx.tasm.b0;
import com.lynx.tasm.behavior.c0;
import com.lynx.tasm.behavior.ui.view.UISimpleView;
import com.lynx.tasm.behavior.ui.view.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import pm.a;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ies/xelement/LynxBounceView;", "Lcom/lynx/tasm/behavior/ui/view/UISimpleView;", "Lcom/lynx/tasm/behavior/ui/view/b;", "Lpm/a;", "direction", "", "setDirection", "(Lpm/a;)V", "x-element-scroll_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LynxBounceView extends UISimpleView<b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f6359a;

    public LynxBounceView(b0 r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, null);
        this.f6359a = "right";
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public final View createView(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        return new b(r5);
    }

    @c0(customType = "right", name = "direction")
    public final void setDirection(a r5) {
        Intrinsics.checkNotNullParameter(r5, "direction");
        if (r5.getType() != ReadableType.String) goto L6;
        this.f6359a = r5.asString();
        return;
    }
}
