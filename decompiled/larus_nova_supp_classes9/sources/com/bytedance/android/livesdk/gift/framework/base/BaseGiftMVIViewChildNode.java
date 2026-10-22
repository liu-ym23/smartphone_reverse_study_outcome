package com.bytedance.android.livesdk.gift.framework.base;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.d;
import com.bytedance.android.anya.p;
import com.bytedance.android.livesdk.gift.configmodel.j1;
import com.bytedance.android.livesdk.gift.platform.core.a0;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public abstract class BaseGiftMVIViewChildNode<SUPER_STATE extends MVIState<SUPER_STATE>, STATE extends MVIState<STATE>, ACTION extends p> extends d<SUPER_STATE, STATE, ACTION> {
    public boolean h;
    public final j1 i;
    public final Lazy j;
    public final Context k;
    public final ViewGroup l;

    public void q() {
    }

    public final View r() {
        return (View) this.j.getValue();
    }

    public abstract int s();

    public final Context getContext() {
        return this.k;
    }

    public void p(int r2) {
        r().setVisibility(r2);
        if (this.h == true) goto L6;
        this.h = true;
        q();
        return;
    }

    public BaseGiftMVIViewChildNode(Context r2, ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "containerView");
        this.k = r2;
        this.l = r3;
        this.i = a0.e();
        this.j = LazyKt.lazy(new BaseGiftMVIViewChildNode$contentView$2(this));
    }
}
