package com.ss.android.lark.flow.feed.base;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.lark.rustclient.api.l;
import com.larksuite.arch.jack.f;
import com.ss.android.lark.feed.app.entity.FeedFolder;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.feed.shared.data.UpdateRecord;
import com.ss.android.lark.feed.shared.page.adapter.LarkFeedInBoxListAdapter;
import com.ss.android.lark.feed.shared.page.s;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public interface b<VM extends s> {
    VM a1();

    void b1(l r1, VM r2, com.ss.android.lark.flow.feed.data.a r3);

    boolean c1();

    void d1(UpdateRecord r1);

    f e1();

    void f1();

    FeedFolder g1();

    LarkFeedInBoxListAdapter getAdapter();

    LifecycleOwner getLifecycleOwner();

    List<UIFeedCard> h1(List<? extends UIFeedCard> r1);

    void i1();

    void j1(VM r1);

    String t();
}
