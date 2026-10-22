package com.bytedance.android.livesdk.interactivity.chatchannel.widget;

import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.ChatChannelUtils;
import com.bytedance.android.livesdk.interactivity.api.comment.event.OpenInputSource;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/chatchannel/widget/ChatChannelCommentWidget;", "Lcom/bytedance/android/livesdk/interactivity/chatchannel/widget/AbsChatChannelCommentWidget;", "<init>", "()V", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ChatChannelCommentWidget extends AbsChatChannelCommentWidget {
    @Override // com.bytedance.android.livesdk.interactivity.chatchannel.widget.AbsChatChannelCommentWidget
    public final void xq() {
        com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.a r0 = ChatChannelUtils.f(getRoomContext());
        if (r0 == null) goto L10;
        com.bytedance.live.datacontext.m<com.bytedance.android.livesdk.interactivity.api.base.d> r1 = r0.getState();
        if (r1 == null) goto L11;
        Disposable r2 = i80.a.a(r1, new ChatChannelCommentWidget$onInitView$1(this));
        if (r2 == null) goto L12;
        RxUtilKt.c(r2, this.f);
        return;
    L12:
        return;
    L11:
        return;
    }

    public ChatChannelCommentWidget() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.chatchannel.widget.AbsChatChannelCommentWidget
    public final void yq(boolean r4) {
        com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.a r0 = ChatChannelUtils.f(getRoomContext());
        if (r0 == null) goto L7;
        com.bytedance.live.datacontext.m<com.bytedance.android.livesdk.interactivity.api.base.d> r1 = r0.getState();
        if (r1 == null) goto L7;
        com.bytedance.android.livesdk.interactivity.api.base.d r2 = (com.bytedance.android.livesdk.interactivity.api.base.d) r1.getValue();
    L9:
        if (com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.b.a(r2) == false) goto L12;
        int r3 = e62.d.a;
        long r5 = ChatChannelUtils.d(getDataContext());
        u22.m r6 = new u22.m();
        r6.d = r4;
        r6.m = 1;
        r6.n = r5;
        r6.l = OpenInputSource.ChatChannel;
        xs2.b.a().post(r6);
        return;
    L12:
        return;
    L7:
        r2 = null;
        goto L9
    }
}
