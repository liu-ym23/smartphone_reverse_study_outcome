package aeb;

import android.view.View;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.feed.export.feedcard.action.ActionScene;
import com.ss.android.lark.feed.export.feedcard.action.FeedActionStatus;
import com.ss.android.lark.feed.export.feedcard.action.FeedActionType;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface f {
    void a(UIFeedCard r1);

    void b(FeedActionType r1, FeedActionStatus r2, UIFeedCard r3);

    List<c> c();

    List<FeedActionType> e(UIFeedCard r1);

    List<FeedActionType> f(UIFeedCard r1);

    void g(UIFeedCard r1);

    List<FeedActionType> h(UIFeedCard r1);

    void j(UIFeedCard r1, View r2, int r3, ActionScene r4);

    List<FeedActionType> k(UIFeedCard r1);

    void l(UIFeedCard r1);

    List<FeedActionType> n(UIFeedCard r1);
}
