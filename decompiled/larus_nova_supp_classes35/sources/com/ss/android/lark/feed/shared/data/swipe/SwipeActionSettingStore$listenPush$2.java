package com.ss.android.lark.feed.shared.data.swipe;

import com.bytedance.lark.pb.feed.v1.FeedSlideActionSetting;
import com.bytedance.lark.pb.feed.v1.PushFeedActionSetting;
import com.ss.android.lark.log.Log;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "pushData", "Lcom/bytedance/lark/pb/feed/v1/PushFeedActionSetting;", "invoke"}, k = 3, mv = {2, 1, 0}, xi = 48)
final class SwipeActionSettingStore$listenPush$2 extends Lambda implements Function1<PushFeedActionSetting, Unit> {
    final /* synthetic */ a this$0;

    public SwipeActionSettingStore$listenPush$2(a r1) {
        this.this$0 = r1;
        super(1);
    }

    public final void invoke(PushFeedActionSetting r5) {
        Intrinsics.checkNotNullParameter(r5, "pushData");
        StringBuilder r0 = new StringBuilder("PUSH_FEED_ACTION_SETTING changed:\n ");
        FeedSlideActionSetting r1 = r5.slide_action;
        if (r1 == null) goto L5;
        Intrinsics.checkNotNullParameter(r1, "<this>");
        String r2 = "left_slide_action_on:" + r1.left_slide_action_on + "\nleft_slide_action:" + r1.left_slide_action + "\nright_slide_action_on:" + r1.right_slide_action_on + "\nright_slide_action:" + r1.right_slide_action;
    L6:
        r0.append(r2);
        Log.i("SwipeActionSettingStore", r0.toString());
        FeedSlideActionSetting r6 = r5.slide_action;
        if (r6 == null) goto L10;
        a.b(this.this$0, r6);
        return;
    L10:
        return;
    L5:
        r2 = null;
        goto L6
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((PushFeedActionSetting) r1);
        return Unit.INSTANCE;
    }
}
