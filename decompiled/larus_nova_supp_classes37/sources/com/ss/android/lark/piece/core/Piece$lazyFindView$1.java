package com.ss.android.lark.piece.core;

import android.view.View;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "T", "Landroid/view/View;", "invoke", "()Landroid/view/View;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
final class Piece$lazyFindView$1 extends Lambda implements Function0<View> {
    final /* synthetic */ int $id;
    final /* synthetic */ Piece<View> this$0;

    public Piece$lazyFindView$1(Piece<View> r1, int r2) {
        this.this$0 = r1;
        this.$id = r2;
        super(0);
    }

    public final View invoke() {
        this.this$0.getClass();
        Intrinsics.throwUninitializedPropertyAccessException("contentView");
        throw null;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m3401invoke() {
        return invoke();
    }
}
