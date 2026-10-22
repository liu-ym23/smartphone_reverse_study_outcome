package com.bytedance.android.live.liveinteract.feed;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.BaseLinkSeatWindowView;
import io.reactivex.functions.Consumer;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class x<T> implements Consumer {
    public final /* synthetic */ MultiLinkVoiceChatFeedView a;

    public x(MultiLinkVoiceChatFeedView r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        List r4 = (List) r3;
        BaseLinkSeatWindowView r0 = this.a.getBaseWindowView();
        if (r0 == null) goto L8;
        RecyclerView r1 = r0.getRecyclerView();
        if (r1 == null) goto L9;
        r1.post(new w(this, r4));
        return;
    L9:
        return;
    }
}
