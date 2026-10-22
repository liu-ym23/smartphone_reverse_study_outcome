package com.bytedance.android.livesdk.interactivity.chatchannel.v2.widget;

import android.content.Context;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.livesdk.interactivity.chatchannel.widget.ChatChannelLandscapeCommentWidget;
import com.bytedance.android.livesdk.interactivity.chatchannel.widget.ChatChannelLandscapeInviteButtonWidget;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/chatchannel/v2/widget/ChatChannelLandscapeWidgetV2;", "Lcom/bytedance/android/livesdk/interactivity/chatchannel/v2/widget/ChatChannelWidgetV2;", "<init>", "()V", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ChatChannelLandscapeWidgetV2 extends ChatChannelWidgetV2 {
    public ChatChannelLandscapeInviteButtonWidget w;
    public ChatChannelLandscapeCommentWidget x;

    @Override // com.bytedance.android.livesdk.interactivity.chatchannel.v2.widget.ChatChannelWidgetV2
    public final int getLayoutId() {
        return 2131565299;
    }

    @Override // com.bytedance.android.livesdk.interactivity.chatchannel.v2.widget.ChatChannelWidgetV2
    public final void onUnload() {
        super.onUnload();
        enableSubWidgetManager();
        ChatChannelLandscapeInviteButtonWidget r0 = this.w;
        if (r0 == null) goto L5;
        ((Widget) this).subWidgetManager.unload(r0);
    L5:
        enableSubWidgetManager();
        ChatChannelLandscapeCommentWidget r1 = this.x;
        if (r1 == null) goto L9;
        ((Widget) this).subWidgetManager.unload(r1);
        return;
    }

    public ChatChannelLandscapeWidgetV2() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.chatchannel.v2.widget.ChatChannelWidgetV2
    public final void onInit(Object[] r1) {
        super.onInit(r1);
    }

    @Override // com.bytedance.android.livesdk.interactivity.chatchannel.v2.widget.ChatChannelWidgetV2
    public final void onLoad(Object[] r3) {
        super.onLoad(r3);
        enableSubWidgetManager();
        if (this.w != null) goto L5;
        ChatChannelLandscapeInviteButtonWidget r4 = new ChatChannelLandscapeInviteButtonWidget();
        this.w = r4;
        ((Widget) this).subWidgetManager.load(2131365484, r4);
    L5:
        enableSubWidgetManager();
        if (this.x != null) goto L9;
        ChatChannelLandscapeCommentWidget r5 = new ChatChannelLandscapeCommentWidget();
        this.x = r5;
        ((Widget) this).subWidgetManager.load(2131367328, r5);
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.chatchannel.v2.widget.ChatChannelWidgetV2
    public final void zq(Context r1, long r2, s22.a r4, s22.e r5) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r4, "chatChannel");
        Intrinsics.checkNotNullParameter(r5, "chatManager");
        DataCenter r3 = ((Widget) this).dataCenter;
        if (r3 != null) goto L5;
        return;
    L5:
        int r6 = e62.d.a;
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        r3.put("cmd_chat_channel_close_landscape_dialog", Boolean.TRUE);
        MainThreadPostUtils.c(e62.c.a, 200);
    }
}
