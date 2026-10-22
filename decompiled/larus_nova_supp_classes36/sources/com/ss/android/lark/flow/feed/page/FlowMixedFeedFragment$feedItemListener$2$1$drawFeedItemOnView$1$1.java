package com.ss.android.lark.flow.feed.page;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/ss/android/lark/flow/feed/page/FlowMixedFeedFragment$feedItemListener$2$1$drawFeedItemOnView$1$1", "Lcom/larksuite/framework/callback/IGetDataCallback;", "Landroid/graphics/Bitmap;", "onSuccess", "", "bitmap", "onError", "err", "Lcom/larksuite/framework/callback/Entity/ErrorResult;", "flow-feed_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class FlowMixedFeedFragment$feedItemListener$2$1$drawFeedItemOnView$1$1 implements IGetDataCallback<Bitmap> {
    final /* synthetic */ AppCompatImageView $containerView;
    final /* synthetic */ View $contentView;

    public void onError(ErrorResult r2) {
        Intrinsics.checkNotNullParameter(r2, "err");
        this.$contentView.buildDrawingCache();
        this.$containerView.setImageBitmap(this.$contentView.getDrawingCache());
    }

    public void onSuccess(Bitmap r6) {
        Intrinsics.checkNotNullParameter(r6, "bitmap");
        Bitmap.Config r0 = r6.getConfig();
        if (r0 == null) goto L6;
        View r1 = this.$contentView;
        AppCompatImageView r2 = this.$containerView;
        com.ss.android.lark.forsetiutils.b r3 = com.ss.android.lark.forsetiutils.b.a;
        Context r4 = r1.getContext();
        r3.getClass();
        com.ss.android.lark.forsetiutils.b.c(r4);
        r2.setImageDrawable(new ukb.a(r2.getResources(), r6.copy(r0, true)));
        return;
    }

    public /* bridge */ /* synthetic */ void onError(Object r1) {
        onError((ErrorResult) r1);
    }

    public /* bridge */ /* synthetic */ void onSuccess(Object r1) {
        onSuccess((Bitmap) r1);
    }

    public FlowMixedFeedFragment$feedItemListener$2$1$drawFeedItemOnView$1$1(View r1, AppCompatImageView r2) {
        this.$contentView = r1;
        this.$containerView = r2;
    }
}
