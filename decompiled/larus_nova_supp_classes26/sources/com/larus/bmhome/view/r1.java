package com.larus.bmhome.view;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class r1 implements Function1 {
    public final /* synthetic */ View.OnClickListener a;

    public /* synthetic */ r1(View.OnClickListener r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3) {
        View.OnClickListener r0 = this.a;
        AppCompatImageView r4 = (AppCompatImageView) r3;
        int r1 = ChatTitleAlignLeftStyle.T;
        Intrinsics.checkNotNullParameter(r4, "it");
        r0.onClick(r4);
        return Unit.INSTANCE;
    }
}
