package com.bytedance.android.live.liveinteract.feed;

import com.bytedance.android.live.liveinteract.plantform.commonwindow.BaseLinkSeatWindowView;
import io.reactivex.functions.Consumer;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class v<T> implements Consumer {
    public final /* synthetic */ MultiLinkVoiceChatFeedView a;

    public v(MultiLinkVoiceChatFeedView r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        List<? extends tf0.e> r4 = (List) r3;
        MultiLinkVoiceChatFeedView r0 = this.a;
        int r1 = MultiLinkVoiceChatFeedView.P1;
        r0.z(r4);
        BaseLinkSeatWindowView r2 = this.a.getBaseWindowView();
        if (r2 == null) goto L6;
        r2.O7(r4);
        return;
    }
}
