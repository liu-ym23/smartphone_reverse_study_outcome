package bhb;

import com.ss.android.lark.biz.im.api.extension.ImExtensionType;
import com.ss.android.lark.biz.im.api.extension.ImPlugin;
import com.ss.android.lark.flow.feed.cell.chat.c;
import com.ss.android.lark.flow.feed.long_click.e;
import com.ss.android.lark.integrator.im.extension.ImContextImpl;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import qxa.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@ImPlugin
public final class a implements b {
    public a() {
    }

    public final void a(ImContextImpl r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        r10.d(ImExtensionType.FEED_CARD_FACTORY, CollectionsKt.listOf(new Class[]{c.class, com.ss.android.lark.flow.feed.cell.thread.a.class, com.ss.android.lark.flow.feed.cell.thread.c.class, com.ss.android.lark.flow.feed.cell.doc.b.class, com.ss.android.lark.flow.feed.cell.contact.b.class}));
        r10.d(ImExtensionType.FEED_SIDEBAR_CARD_FACTORY, CollectionsKt.listOf(new Class[]{com.ss.android.lark.flow.feed.sidebar.cell.chat.a.class, jhb.b.class, khb.a.class, khb.c.class}));
        r10.e(ImExtensionType.FEED_ITEM_LAYOUT_STRATEGY, ghb.a.class);
        r10.e(ImExtensionType.FEED_SWIPE_ACTION_VIEW, com.ss.android.lark.flow.feed.action.b.class);
        r10.d(ImExtensionType.FEED_SWIPE_ACTION_PROVIDER, CollectionsKt.listOf(new Class[]{com.ss.android.lark.flow.feed.action.clearunread.b.class, com.ss.android.lark.flow.feed.action.done.b.class, com.ss.android.lark.flow.feed.action.markunread.b.class, com.ss.android.lark.flow.feed.action.mute.b.class, com.ss.android.lark.flow.feed.action.topping_in_list.b.class}));
        r10.e(ImExtensionType.FEED_ITEM_LONG_CLICK_DIALOG, e.class);
        r10.e(ImExtensionType.FEED_BACKGROUND_STATUS_VIEW, lhb.a.class);
    }
}
