package com.bytedance.android.livesdk.interactivity.chatchannel.widget;

import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.ChatChannelUtils;
import com.bytedance.android.livesdk.interactivity.api.comment.event.OpenInputSource;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/chatchannel/widget/ChatChannelLandscapeCommentWidget;", "Lcom/bytedance/android/livesdk/interactivity/chatchannel/widget/AbsChatChannelCommentWidget;", "<init>", "()V", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ChatChannelLandscapeCommentWidget extends AbsChatChannelCommentWidget {
    @Override // com.bytedance.android.livesdk.interactivity.chatchannel.widget.AbsChatChannelCommentWidget
    public final void xq() {
        UtilityKotlinExtentionsKt.w(((Widget) this).containerView);
    }

    public ChatChannelLandscapeCommentWidget() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.chatchannel.widget.AbsChatChannelCommentWidget
    public final void yq(boolean r4) {
        int r0 = e62.d.a;
        long r1 = ChatChannelUtils.d(getDataContext());
        u22.m r2 = new u22.m();
        r2.d = r4;
        r2.m = 1;
        r2.n = r1;
        r2.l = OpenInputSource.ChatChannel;
        xs2.b.a().post(r2);
    }
}
