package com.bytedance.android.livesdk.interactivity.comment.input.wordassociation.ui;

import android.content.Context;
import android.text.SpannableString;
import android.view.View;
import c32.d;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "it", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 4, 3})
final class WordAssociationResultViewHolder$bind$2$onDone$1 extends Lambda implements Function1<View, Unit> {
    final /* synthetic */ SpannableString $spannable;
    final /* synthetic */ WordAssociationResultViewHolder$bind$2 this$0;

    public WordAssociationResultViewHolder$bind$2$onDone$1(WordAssociationResultViewHolder$bind$2 r1, SpannableString r2) {
        this.this$0 = r1;
        this.$spannable = r2;
        super(1);
    }

    public final void invoke(View r5) {
        Intrinsics.checkNotNullParameter(r5, "it");
        WordAssociationResultViewHolder r0 = this.this$0.a;
        Context r6 = r5.getContext();
        d r1 = this.this$0.b;
        String r2 = this.$spannable.toString();
        if (r2 == null) goto L7;
        WordAssociationResultViewHolder.T3(r0, r6, r1, StringsKt.trim(r2).toString(), this.this$0.a.f);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((View) r1);
        return Unit.INSTANCE;
    }
}
