package com.bytedance.android.livesdk.chatroom.widget;

import android.graphics.drawable.GradientDrawable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class DecorationView$setCancelReserveStatus$1 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ GradientDrawable $drawable;

    public DecorationView$setCancelReserveStatus$1(GradientDrawable r1) {
        this.$drawable = r1;
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke(((Number) r1).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int r2) {
        this.$drawable.setColor(r2);
    }
}
