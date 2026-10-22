package com.ss.android.lark.feed.shared.page.binder2;

import android.view.View;
import com.h6ah4i.android.widget.advrecyclerview.utils.AbstractSwipeableItemViewHolder;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/ss/android/lark/feed/shared/page/binder2/BaseFeedSwipeableViewHolder;", "Lcom/h6ah4i/android/widget/advrecyclerview/utils/AbstractSwipeableItemViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "isSwipeLeftPinned", BuildConfig.FLAVOR, "()Z", "setSwipeLeftPinned", "(Z)V", "isSwipeRightPinned", "setSwipeRightPinned", "onViewRecycled", BuildConfig.FLAVOR, "onRightRemoveAction", Keys.API_RETURN_KEY_DATA, "Lcom/ss/android/lark/feed/app/entity/UIFeedCard;", "getSwipeReactionType", BuildConfig.FLAVOR, "feed-shared_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class BaseFeedSwipeableViewHolder extends AbstractSwipeableItemViewHolder {
    public boolean k;
    public boolean l;

    public int T3() {
        return 0;
    }

    public void U3(UIFeedCard r2) {
        Intrinsics.checkNotNullParameter(r2, Keys.API_RETURN_KEY_DATA);
    }

    public void onViewRecycled() {
    }

    public BaseFeedSwipeableViewHolder(View r2) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2);
    }
}
