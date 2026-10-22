package com.ss.android.lark.feed.shared.page;

import com.ss.android.eventbus.BaseEvent;
import com.ss.android.eventbus.BaseEventListener;
import com.ss.android.eventbus.EventBus;
import com.ss.android.eventbus.ThreadMode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class FeedItemsFragment_Subscriber {

    public class a extends BaseEventListener {
        public final /* synthetic */ Object a;

        public a(Object r1) {
            this.a = r1;
        }

        public void onEvent(BaseEvent r2) {
            ((FeedItemsFragment) this.a).onChatActivityDestroyEvent((zdb.a) r2);
        }
    }

    public class b extends BaseEventListener {
        public final /* synthetic */ Object a;

        public b(Object r1) {
            this.a = r1;
        }

        public void onEvent(BaseEvent r2) {
            ((FeedItemsFragment) this.a).onChatPageResumeNotifyFeedEvent((zdb.c) r2);
        }
    }

    public class c extends BaseEventListener {
        public final /* synthetic */ Object a;

        public c(Object r1) {
            this.a = r1;
        }

        public void onEvent(BaseEvent r2) {
            ((FeedItemsFragment) this.a).onForsetiPlaceHolderResumeNoticeFeedEvent((wua.a) r2);
        }
    }

    public FeedItemsFragment_Subscriber() {
    }

    public static void register(Object r4) {
        EventBus r0 = EventBus.getDefault();
        a r2 = new a(r4);
        ThreadMode r3 = ThreadMode.POSTING;
        r0.register(r4, zdb.a.class, r2, r3);
        EventBus.getDefault().register(r4, zdb.c.class, new b(r4), r3);
        EventBus.getDefault().register(r4, wua.a.class, new c(r4), r3);
    }
}
