package com.ss.android.lark.flow.feed.cell.contact;

import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/flow/feed/cell/contact/ContactUiFeedCard;", "Lcom/ss/android/lark/feed/app/entity/UIFeedCard;", "Lcom/ss/android/lark/feed/shared/data/IJumpInfo;", "<init>", "()V", "getJumpPriority", "", "flow-feed_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class ContactUiFeedCard extends UIFeedCard implements ieb.a {
    public int getJumpPriority() {
        if (isRemind() == false) goto L9;
        if (((UIFeedCard) this).unreadCount <= 0) goto L9;
        return 2;
    L9:
        if (isRemind() == false) goto L11;
        return 0;
    L11:
        if (((UIFeedCard) this).unreadCount <= 0) goto L16;
        return 1;
    L16:
        return 0;
    }

    public ContactUiFeedCard() {
    }
}
