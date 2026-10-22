package com.larus.bmhome.view;

import android.view.View;
import com.lynx.lottieadapter.LottieAdapterView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class f1 implements Function1 {
    public final /* synthetic */ ChatTitleAlignLeftStyle a;
    public final /* synthetic */ View.OnClickListener b;

    public /* synthetic */ f1(ChatTitleAlignLeftStyle r1, View.OnClickListener r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r4) {
        ChatTitleAlignLeftStyle r0 = this.a;
        View.OnClickListener r1 = this.b;
        LottieAdapterView r5 = (LottieAdapterView) r4;
        int r2 = ChatTitleAlignLeftStyle.T;
        Intrinsics.checkNotNullParameter(r5, "it");
        r0.getClass();
        ChatTitleAlignLeftStyle.b6();
        r1.onClick(r5);
        return Unit.INSTANCE;
    }
}
