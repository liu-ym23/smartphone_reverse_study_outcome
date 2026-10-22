package com.larus.bmhome.view;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class d1 implements Function1 {
    public final /* synthetic */ ChatTitleAlignLeftStyle a;
    public final /* synthetic */ View.OnClickListener b;

    public /* synthetic */ d1(ChatTitleAlignLeftStyle r1, View.OnClickListener r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r4) {
        ChatTitleAlignLeftStyle r0 = this.a;
        View.OnClickListener r1 = this.b;
        ConstraintLayout r5 = (ConstraintLayout) r4;
        int r2 = ChatTitleAlignLeftStyle.T;
        Intrinsics.checkNotNullParameter(r5, "it");
        if (r0.h == true) goto L7;
        r1.onClick(r5);
        return Unit.INSTANCE;
    L7:
        return Unit.INSTANCE;
    }
}
