package com.ss.android.lark.reaction.widget.flowlayout.reaction;

import android.graphics.drawable.Drawable;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/ss/android/lark/reaction/widget/flowlayout/reaction/ClickableDrawableSpan$1", "Lcom/larksuite/framework/callback/IGetDataCallback;", "Landroid/graphics/drawable/Drawable;", "onSuccess", "", "data", "onError", "err", "Lcom/larksuite/framework/callback/Entity/ErrorResult;", "reaction-component_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class ClickableDrawableSpan$1 implements IGetDataCallback<Drawable> {
    final /* synthetic */ a this$0;

    public ClickableDrawableSpan$1(a r1) {
        this.this$0 = r1;
    }

    public void onError(ErrorResult r2) {
        Intrinsics.checkNotNullParameter(r2, "err");
        a r3 = this.this$0;
        int r0 = a.m;
        r3.d(null);
    }

    public void onSuccess(Drawable r3) {
        Intrinsics.checkNotNullParameter(r3, "data");
        a r0 = this.this$0;
        int r1 = a.m;
        r0.d(r3);
    }

    public /* bridge */ /* synthetic */ void onError(Object r1) {
        onError((ErrorResult) r1);
    }

    public /* bridge */ /* synthetic */ void onSuccess(Object r1) {
        onSuccess((Drawable) r1);
    }
}
