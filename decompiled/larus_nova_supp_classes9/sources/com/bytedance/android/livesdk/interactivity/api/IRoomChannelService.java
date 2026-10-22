package com.bytedance.android.livesdk.interactivity.api;

import android.content.Context;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.tetris.widgets.LiveWidget;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@ServiceLookup("com.bytedance.android.livesdk.interactivity.api.RoomChannelService")
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0004\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0003\u0018\u00010\u0002H&J\u0012\u0010\u0006\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00050\u0002H&J\u0012\u0010\u0007\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00050\u0002H&J\u0012\u0010\b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00050\u0002H&J(\u0010\u0012\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH&J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0013H&J\u0012\u0010\u0018\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00170\u0002H&J\u0010\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0019H&J \u0010\u001e\u001a\u00020\u001d2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u0011H&J\b\u0010\u001f\u001a\u00020\u0003H&J\u0010\u0010 \u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0002H&¨\u0006!"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/IRoomChannelService;", "Lcom/bytedance/android/live/base/IService;", "Ljava/lang/Class;", "Lcom/bytedance/ies/sdk/widgets/Widget;", "getChatChannelServiceWidget", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "getChannelInviteWidget", "getChannelCommentWidget", "getChannelEmptyWidget", "Lcom/bytedance/android/livesdk/chatroom/RoomContext;", "roomContext", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Landroid/content/Context;", "context", "Ls22/e$b;", "config", "Ls22/e;", "createChatChannelManager", "Ls22/a;", "chatChannel", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/viewpager/c;", "createChatChannelPage", "Lcom/bytedance/android/live/core/tetris/widgets/LiveWidget;", "getChatChannelWidget", BuildConfig.FLAVOR, "channelId", "createChatChannelLandscapeWidget", "manager", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/c0$b;", "createChatChannelLandscapeToolbarBehavior", "getChatChannelAtmosphereWidget", "getChatChannelIMEmojiAnimWidget", "interactivity-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IRoomChannelService extends IService {
    c0.b createChatChannelLandscapeToolbarBehavior(RoomContext r1, DataCenter r2, s22.e r3);

    LiveWidget createChatChannelLandscapeWidget(long r1);

    s22.e createChatChannelManager(RoomContext r1, DataCenter r2, Context r3, s22.e.b r4);

    com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.c createChatChannelPage(s22.a r1);

    Class<? extends LiveRecyclableWidget> getChannelCommentWidget();

    Class<? extends LiveRecyclableWidget> getChannelEmptyWidget();

    Class<? extends LiveRecyclableWidget> getChannelInviteWidget();

    Widget getChatChannelAtmosphereWidget();

    Class<? extends LiveRecyclableWidget> getChatChannelIMEmojiAnimWidget();

    Class<? extends Widget> getChatChannelServiceWidget();

    Class<? extends LiveWidget> getChatChannelWidget();
}
