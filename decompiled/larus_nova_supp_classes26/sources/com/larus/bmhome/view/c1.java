package com.larus.bmhome.view;

import android.view.View;
import android.widget.FrameLayout;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class c1 implements Function1 {
    public final /* synthetic */ View.OnClickListener a;
    public final /* synthetic */ ChatTitleAlignLeftStyle b;

    public /* synthetic */ c1(View.OnClickListener r1, ChatTitleAlignLeftStyle r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r4) {
        View.OnClickListener r0 = this.a;
        ChatTitleAlignLeftStyle r1 = this.b;
        FrameLayout r5 = (FrameLayout) r4;
        int r2 = ChatTitleAlignLeftStyle.T;
        Intrinsics.checkNotNullParameter(r5, "it");
        r0.onClick(r5);
        r1.b.u.setVisibility(8);
        return Unit.INSTANCE;
    }
}
