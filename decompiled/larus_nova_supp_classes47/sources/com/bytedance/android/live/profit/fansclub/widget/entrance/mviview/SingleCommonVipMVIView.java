package com.bytedance.android.live.profit.fansclub.widget.entrance.mviview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.widget.HSImageView;
import eu0.k0;
import eu0.m0;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class SingleCommonVipMVIView extends com.bytedance.android.anya.d<m0, k0, eu0.h> {
    public final View h;
    public final HSImageView i;
    public final Context j;
    public final ViewGroup k;

    public final Context getContext() {
        return this.j;
    }

    public final void a(com.bytedance.android.anya.dsl.f<m0> r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$bindToParent");
        SingleCommonVipMVIView$bindToParent$1 r0 = SingleCommonVipMVIView$bindToParent$1.INSTANCE;
        List r5 = r4.a;
        ArrayList r6 = (ArrayList) r5;
        r6.add(new com.bytedance.android.anya.dsl.j(this, r0));
    }

    public SingleCommonVipMVIView(Context r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "containerView");
        this.j = r3;
        this.k = r4;
        View r5 = LayoutInflater.from(r3).inflate(2131567559, r4, true);
        this.h = r5;
        if (r5 == null) goto L5;
        HSImageView r6 = (HSImageView) r5.findViewById(2131392626);
    L6:
        this.i = r6;
        return;
    L5:
        r6 = null;
        goto L6
    }

    public final void b(com.bytedance.android.anya.k r6, MVIState r7) {
        k0 r8 = (k0) r7;
        Intrinsics.checkNotNullParameter(r6, "$this$handleDiff");
        Intrinsics.checkNotNullParameter(r8, "state");
        com.bytedance.android.anya.internal.r r0 = r8.a;
        KProperty[] r1 = k0.c;
        KProperty r3 = r1[0];
        r0.getClass();
        Object r4 = r6.c.a(r0);
        if (r4 == null) goto L9;
        r6.b.a.invoke(r0);
        boolean r2 = ((Boolean) r4).booleanValue();
        ViewGroup r5 = this.k;
        if (r2 == false) goto L7;
        int r9 = 0;
    L8:
        r5.setVisibility(r9);
        goto L9
    L7:
        r9 = 8;
    L9:
        com.bytedance.android.anya.internal.r r10 = r8.b;
        KProperty r12 = r1[1];
        r10.getClass();
        Object r13 = r6.c.a(r10);
        if (r13 == null) goto L13;
        r6.b.a.invoke(r10);
        HSImageView r14 = this.i;
        ImageUtil.loadImage(r14, (py.k) r13, 0);
        return;
    }
}
