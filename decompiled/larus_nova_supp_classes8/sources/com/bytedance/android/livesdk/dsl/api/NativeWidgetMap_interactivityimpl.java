package com.bytedance.android.livesdk.dsl.api;

import com.bytedance.android.livesdk.interactivity.PublicScreenBottomPlaceHolder;
import com.bytedance.android.livesdk.interactivity.asr.widget.AnchorAsrHintWidget;
import com.bytedance.android.livesdk.interactivity.asr.widget.AnchorAsrServiceWidget;
import com.bytedance.android.livesdk.interactivity.chatchannel.v2.widget.ChatChannelLandscapeWidgetV2;
import com.bytedance.android.livesdk.interactivity.chatchannel.v2.widget.ChatChannelWidgetV2;
import com.bytedance.android.livesdk.interactivity.chatchannel.widget.AbsChatChannelCommentWidget;
import com.bytedance.android.livesdk.interactivity.chatchannel.widget.AbsChatChannelInviteButtonWidget;
import com.bytedance.android.livesdk.interactivity.chatchannel.widget.ChatChannelAtmosphereWidget;
import com.bytedance.android.livesdk.interactivity.chatchannel.widget.ChatChannelCommentWidget;
import com.bytedance.android.livesdk.interactivity.chatchannel.widget.ChatChannelIMEmojiAnimWidget;
import com.bytedance.android.livesdk.interactivity.chatchannel.widget.ChatChannelInviteButtonWidget;
import com.bytedance.android.livesdk.interactivity.chatchannel.widget.ChatChannelLandscapeCommentWidget;
import com.bytedance.android.livesdk.interactivity.chatchannel.widget.ChatChannelLandscapeInviteButtonWidget;
import com.bytedance.android.livesdk.interactivity.chatchannel.widget.ChatChannelServiceWidget;
import com.bytedance.android.livesdk.interactivity.chatchannel.widget.invite.ChannelEmptyWidget;
import com.bytedance.android.livesdk.interactivity.common.cleanarch.ext.CompatLiveRecyclableWidget;
import com.bytedance.android.livesdk.interactivity.common.cleanarch.widgetcompat.CleanWidget;
import com.bytedance.android.livesdk.interactivity.grouplive.CollaborateWidget;
import com.bytedance.android.livesdk.interactivity.im.IMServiceWidget;
import com.bytedance.android.livesdk.interactivity.imagerecognition.ImageRecognitionServiceWidget;
import com.bytedance.android.livesdk.interactivity.like.DigAccessibilityWidget;
import com.bytedance.android.livesdk.interactivity.like.DiggWidget;
import com.bytedance.android.livesdk.interactivity.medialink.intercomment.MediaInteractCommentWidget;
import com.bytedance.android.livesdk.interactivity.medialink.ui.window.MediaMultiEnlargeWidget;
import com.bytedance.android.livesdk.interactivity.medialink.ui.window.MediaMultiLayoutManagerWidget;
import com.bytedance.android.livesdk.interactivity.medialink.widget.MediaLinkControlWidget;
import com.bytedance.android.livesdk.interactivity.medialink.widget.MediaMultiLinkAnchorControlWidget;
import com.bytedance.android.livesdk.interactivity.medialink.widget.MediaMultiLinkAnchorWidget;
import com.bytedance.android.livesdk.interactivity.medialink.widget.MediaMultiLinkAudienceControlWidget;
import com.bytedance.android.livesdk.interactivity.medialink.widget.MediaMultiLinkAudienceWidget;
import com.bytedance.android.livesdk.interactivity.medialink.widget.RevMediaLinkControlWidget;
import com.bytedance.android.livesdk.interactivity.notifications.LiveRoomNotifyWidget;
import com.bytedance.android.livesdk.interactivity.pin.container.v2.PSPinWidget;
import com.bytedance.android.livesdk.interactivity.pin.container.v2.PinWidget;
import com.bytedance.android.livesdk.interactivity.seek.EpisodePlayEventNotifyWidget;
import com.bytedance.android.livesdk.interactivity.seek.EpisodeSeekMessageServiceWidget;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class NativeWidgetMap_interactivityimpl {
    public NativeWidgetMap_interactivityimpl() {
    }

    public static Map<String, Class> collectWidgetClassMap() {
        HashMap r0 = new HashMap();
        r0.put("PublicScreenBottomPlaceHolder", PublicScreenBottomPlaceHolder.class);
        r0.put("AnchorAsrHintWidget", AnchorAsrHintWidget.class);
        r0.put("AnchorAsrServiceWidget", AnchorAsrServiceWidget.class);
        r0.put("ChatChannelLandscapeWidgetV2", ChatChannelLandscapeWidgetV2.class);
        r0.put("ChatChannelWidgetV2", ChatChannelWidgetV2.class);
        r0.put("AbsChatChannelCommentWidget", AbsChatChannelCommentWidget.class);
        r0.put("AbsChatChannelInviteButtonWidget", AbsChatChannelInviteButtonWidget.class);
        r0.put("ChatChannelAtmosphereWidget", ChatChannelAtmosphereWidget.class);
        r0.put("ChatChannelCommentWidget", ChatChannelCommentWidget.class);
        r0.put("ChatChannelIMEmojiAnimWidget", ChatChannelIMEmojiAnimWidget.class);
        r0.put("ChatChannelInviteButtonWidget", ChatChannelInviteButtonWidget.class);
        r0.put("ChatChannelLandscapeCommentWidget", ChatChannelLandscapeCommentWidget.class);
        r0.put("ChatChannelLandscapeInviteButtonWidget", ChatChannelLandscapeInviteButtonWidget.class);
        r0.put("ChatChannelServiceWidget", ChatChannelServiceWidget.class);
        r0.put("ChannelEmptyWidget", ChannelEmptyWidget.class);
        r0.put("CompatLiveRecyclableWidget", CompatLiveRecyclableWidget.class);
        r0.put("CleanWidget", CleanWidget.class);
        r0.put("CollaborateWidget", CollaborateWidget.class);
        r0.put("IMServiceWidget", IMServiceWidget.class);
        r0.put("ImageRecognitionServiceWidget", ImageRecognitionServiceWidget.class);
        r0.put("DigAccessibilityWidget", DigAccessibilityWidget.class);
        r0.put("DiggWidget", DiggWidget.class);
        r0.put("MediaInteractCommentWidget", MediaInteractCommentWidget.class);
        r0.put("MediaMultiEnlargeWidget", MediaMultiEnlargeWidget.class);
        r0.put("MediaMultiLayoutManagerWidget", MediaMultiLayoutManagerWidget.class);
        r0.put("MediaLinkControlWidget", MediaLinkControlWidget.class);
        r0.put("MediaMultiLinkAnchorControlWidget", MediaMultiLinkAnchorControlWidget.class);
        r0.put("MediaMultiLinkAnchorWidget", MediaMultiLinkAnchorWidget.class);
        r0.put("MediaMultiLinkAudienceControlWidget", MediaMultiLinkAudienceControlWidget.class);
        r0.put("MediaMultiLinkAudienceWidget", MediaMultiLinkAudienceWidget.class);
        r0.put("RevMediaLinkControlWidget", RevMediaLinkControlWidget.class);
        r0.put("LiveRoomNotifyWidget", LiveRoomNotifyWidget.class);
        r0.put("PSPinWidget", PSPinWidget.class);
        r0.put("PinWidget", PinWidget.class);
        r0.put("EpisodePlayEventNotifyWidget", EpisodePlayEventNotifyWidget.class);
        r0.put("EpisodeSeekMessageServiceWidget", EpisodeSeekMessageServiceWidget.class);
        return r0;
    }
}
