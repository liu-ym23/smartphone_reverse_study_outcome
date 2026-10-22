package mw1;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.bytedance.android.livesdk.feed.fragment.FeedLiveFragment;
import com.bytedance.android.livesdk.feed.openui.view.HSLargeLiveCardView;
import com.bytedance.android.livesdk.feed.openui.view.HorizontalLiveListView;
import com.bytedance.android.livesdk.feed.openui.view.LiveListBlock;
import com.bytedance.android.livesdk.feed.squarefeed.OpenFeedFragment;
import com.bytedance.android.livesdk.feed.squarefeed.OpenRankFragment;
import com.bytedance.android.livesdk.feed.squarefeed.o;
import com.bytedance.android.livesdkapi.feed.constant.CardStyle;
import com.bytedance.android.livesdkapi.feed.constant.FeedStyle;
import com.bytedance.android.livesdkapi.feed.constant.FeedType;
import com.bytedance.android.livesdkapi.feed.manager.ILiveListManager;
import com.bytedance.android.livesdkapi.feed.model.HorFollowListParams;
import com.bytedance.android.livesdkapi.feed.model.OpenFeedParams;
import com.bytedance.android.livesdkapi.feed.open.IOpenLiveListFactory;
import com.bytedance.android.livesdkapi.feed.ui.ILiveBlock;
import com.bytedance.android.livesdkapi.feed.ui.ILiveCardView;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e implements IOpenLiveListFactory {
    public static final e a = null;

    public e() {
    }

    static {
        a = new e();
    }

    public final ILiveListManager createLiveCardManager(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return ow1.b.a;
    }

    public final Fragment createLiveFragment(OpenFeedParams r5) {
        Intrinsics.checkNotNullParameter(r5, "params");
        FeedStyle r1 = r5.getFeedStyle();
        if (r1 == null) goto L11;
        int r2 = d.a[r1.ordinal()];
        if (r2 != 1) goto L8;
        int r0 = tb1.a.a;
        o.a();
        r5.setDoubleColumnLayoutId(2131566261);
        return FeedLiveFragment.la0(r5);
    L8:
        if (r2 != 2) goto L10;
        int r3 = tb1.a.a;
        o.a();
        r5.setDoubleColumnLayoutId(2131566261);
        return FeedLiveFragment.la0(r5);
    L10:
        if (r2 != 3) goto L11;
        int r4 = tb1.a.a;
        if (r5.getFeedType() != FeedType.HOT_FEED) goto L15;
        int r6 = OpenRankFragment.C;
        Intrinsics.checkNotNullParameter(r5, "params");
        OpenRankFragment r7 = new OpenRankFragment();
        r7.o = r5;
        return r7;
    L15:
        int r8 = OpenFeedFragment.C;
        Intrinsics.checkNotNullParameter(r5, "params");
        OpenFeedFragment r9 = new OpenFeedFragment();
        r9.o = r5;
        return r9;
    L11:
        return null;
    }

    public final ILiveBlock createHorizontalLiveBlock(Context r4, HorFollowListParams r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "params");
        int r0 = tb1.a.a;
        return new HorizontalLiveListView(r5, r4, null, 0);
    }

    public final ILiveBlock createLiveBlock(Context r3, OpenFeedParams r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "params");
        if (r4.getFeedStyle() != FeedStyle.DOUBLE_LIST_D) goto L7;
        int r0 = tb1.a.a;
        o.a();
        return new LiveListBlock(r4, r3);
    L7:
        throw new IllegalArgumentException("feedStyle参数配置错误，仅支持FeedStyle.DOUBLE_LIST_D");
    }

    public final ILiveCardView createSingleLiveCard(Context r3, OpenFeedParams r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "params");
        CardStyle r5 = r4.getCardStyle();
        if (r5 == null) goto L9;
        if (d.b[r5.ordinal()] != 1) goto L9;
        int r6 = tb1.a.a;
        return new HSLargeLiveCardView(r3, null, 0);
    L9:
        throw new NotImplementedError("暂未支持");
    }
}
