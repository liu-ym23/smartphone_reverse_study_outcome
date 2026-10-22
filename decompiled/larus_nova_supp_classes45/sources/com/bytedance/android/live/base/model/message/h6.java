package com.bytedance.android.live.base.model.message;

import com.bytedance.android.livesdk.message.model.b7;
import com.bytedance.android.livesdk.message.model.ib;
import com.bytedance.android.livesdk.message.model.lk;
import com.bytedance.android.livesdk.message.model.mk;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class h6 {
    public static final HashMap<String, Class<? extends c3>> a = null;

    static {
        HashMap<String, Class<? extends c3>> r0 = new HashMap();
        a = r0;
        r0.put("WebcastCarnivalMessage", u.class);
        r0.put("WebcastRoomAppConfigMessage", y3.class);
        r0.put("WebcastHotChatMessage", f1.class);
        r0.put("WebcastMatchHotMessage", g3.class);
        r0.put("WebcastTrayEffectMessage", n5.class);
        r0.put("WebcastActivityEmojiGroupsMessage", l.class);
        r0.put("WebcastRoomAnswerCommonMessage", p.class);
        r0.put("WebcastDslMockMessage", t0.class);
        r0.put("WebcastAIBootMessage", k.class);
        r0.put("WebcastTogetherLiveChangeMemberMessage", j5.class);
        r0.put("WebcastCloudCollaborateMemberMessage", i0.class);
        r0.put("WebcastLinkmicAnnounceMessage", ILinkmicAnnounceMessage.class);
        r0.put("WebcastOpenLinkmicAnnounceMessage", ILinkmicAnnounceMessage.class);
        r0.put("WebcastLinkmicAnchorSettingMessage", ILinkmicAnchorSettingMessage.class);
        r0.put("WebcastOpenLinkmicAnchorSettingMessage", ILinkmicAnchorSettingMessage.class);
        r0.put("WebcastLowPcuGuideChatMessage", e3.class);
        r0.put("WebcastCommonCardAreaMessage", b7.class);
        r0.put("WebcastTrafficSceneMessage", m5.class);
        r0.put("WebcastDouplusIndicatorMessage", s0.class);
        r0.put("WebcastFreshmanSupportMessage", x0.class);
        r0.put("WebcastRoomStatsMessage", mk.class);
        r0.put("WebcastRoomRankMessage", lk.class);
        r0.put("WebcastProjectDModifyH5", ib.class);
        r0.put("WebcastInteractionPluginGamePlusContainerMessage", k1.class);
    }
}
