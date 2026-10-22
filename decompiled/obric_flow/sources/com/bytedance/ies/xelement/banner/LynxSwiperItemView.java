package com.bytedance.ies.xelement.banner;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.view.ViewCompat;
import com.lynx.tasm.b0;
import com.lynx.tasm.behavior.ui.view.UIView;
import com.lynx.tasm.behavior.ui.view.b;
import com.lynx.tasm.behavior.ui.z;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qe.d;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/ies/xelement/banner/LynxSwiperItemView;", "Lcom/lynx/tasm/behavior/ui/view/UIView;", "bf/b", "x-element-swiper_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LynxSwiperItemView extends UIView {
    public LynxSwiperItemView(b0 r5, z r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10);
    }

    @Override // com.lynx.tasm.behavior.ui.view.UIView, com.lynx.tasm.behavior.ui.LynxUI
    public final /* bridge */ /* synthetic */ View createView(Context r5) {
        return createView(r5);
    }

    public final void i() {
        if ((((b) this.mView).getParent() instanceof ViewGroup) == false) goto L13;
        ViewParent r5 = ((b) this.mView).getParent();
        if (r5 == null) goto L12;
        ViewGroup r10 = (ViewGroup) r5;
        if (getOverflow() == 0) goto L9;
        r10.setClipChildren(false);
    L9:
        ViewCompat.setClipBounds(this.mView, getBoundRectForOverflow());
        return;
    L12:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void setOverflow(int r5) {
        super.setOverflow(r5);
        ((b) this.mView).addOnAttachStateChangeListener(new bf.b(this));
        i();
    }

    @Override // com.lynx.tasm.behavior.ui.view.UIView, com.lynx.tasm.behavior.ui.LynxUI
    public final b createView(Context r5) {
        b r10 = super.createView(r5);
        r10.addOnAttachStateChangeListener(new d());
        return r10;
    }
}
