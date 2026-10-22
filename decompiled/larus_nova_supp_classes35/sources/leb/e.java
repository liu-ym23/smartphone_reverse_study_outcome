package leb;

import com.ss.android.lark.biz.im.api.FeedCard;
import com.ss.android.lark.biz.im.api.FeedPreviewInfo;
import com.ss.android.lark.feed.shared.data.preview.FeedPreview;
import com.ss.android.lark.feed.shared.data.preview.ThreadFeedPreview;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class e extends b<ThreadFeedPreview> {
    public e() {
    }

    @Override // leb.b
    public final ThreadFeedPreview e(FeedPreviewInfo r3) {
        ThreadFeedPreview r0 = new ThreadFeedPreview();
        f(r0, r3);
        r0.setChatId(r3.b2);
        r0.setP2pChatterId(r3.J);
        r0.setChatType(r3.G);
        if (r3.d != FeedCard.Type.MSG_THREAD) goto L5;
        boolean r4 = true;
    L6:
        r0.setMsgThread(r4);
        return r0;
    L5:
        r4 = false;
        goto L6
    }

    @Override // leb.b
    public final void d(FeedPreview r1, FeedPreviewInfo r2) {
        a(r1, r2);
        b.b(r1);
    }
}
