package hy0;

import com.bytedance.android.live.profit.scoreboard.dto.h;
import com.bytedance.android.live.profit.scoreboard.dto.j;
import com.bytedance.android.livesdk.message.model.EcomFansClubMessage;
import com.bytedance.android.livesdk.message.model.GiftConsumeRemindMessage;
import com.bytedance.android.livesdk.message.model.LotteryEventMessage;
import com.bytedance.android.livesdk.message.model.RankListAwardMessage;
import com.bytedance.android.livesdk.message.model.a0;
import com.bytedance.android.livesdk.message.model.a2;
import com.bytedance.android.livesdk.message.model.b;
import com.bytedance.android.livesdk.message.model.b0;
import com.bytedance.android.livesdk.message.model.c;
import com.bytedance.android.livesdk.message.model.f4;
import com.bytedance.android.livesdk.message.model.gm;
import com.bytedance.android.livesdk.message.model.hi;
import com.bytedance.android.livesdk.message.model.i1;
import com.bytedance.android.livesdk.message.model.l4;
import com.bytedance.android.livesdk.message.model.li;
import com.bytedance.android.livesdk.message.model.ml;
import com.bytedance.android.livesdk.message.model.mn;
import com.bytedance.android.livesdk.message.model.n5;
import com.bytedance.android.livesdk.message.model.o0;
import com.bytedance.android.livesdk.message.model.o5;
import com.bytedance.android.livesdk.message.model.p5;
import com.bytedance.android.livesdk.message.model.q5;
import com.bytedance.android.livesdk.message.model.qf;
import com.bytedance.android.livesdk.message.model.r5;
import com.bytedance.android.livesdk.message.model.rf;
import com.bytedance.android.livesdk.message.model.s;
import com.bytedance.android.livesdk.message.model.s0;
import com.bytedance.android.livesdk.message.model.s4;
import com.bytedance.android.livesdk.message.model.sf;
import com.bytedance.android.livesdk.message.model.t5;
import com.bytedance.android.livesdk.message.model.tf;
import com.bytedance.android.livesdk.message.model.u5;
import com.bytedance.android.livesdk.message.model.uf;
import com.bytedance.android.livesdk.message.model.vf;
import com.bytedance.android.livesdk.message.model.w5;
import com.bytedance.android.livesdk.message.model.wf;
import com.bytedance.android.livesdk.message.model.wl;
import com.bytedance.android.livesdk.message.model.x3;
import com.bytedance.android.livesdk.message.model.x5;
import com.bytedance.android.livesdk.message.model.xd;
import com.bytedance.android.livesdk.message.model.xf;
import com.bytedance.android.livesdk.message.model.y3;
import com.bytedance.android.livesdk.message.model.z;
import com.bytedance.android.livesdk.message.model.z5;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public static final Map<String, Class<? extends o0>> a = null;

    static {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put(MessageType.GIFT.getWsMethod(), n5.class);
        r0.put(MessageType.GUIDE_MESSAGE.getWsMethod(), z5.class);
        r0.put(MessageType.DOODLE_GIFT.getWsMethod(), y3.class);
        r0.put(MessageType.ASSET_MESSAGE.getWsMethod(), a0.class);
        r0.put(MessageType.ASSET_EFFECT_UTIL_MESSAGE.getWsMethod(), z.class);
        r0.put(MessageType.GIFT_UPDATE.getWsMethod(), q5.class);
        r0.put(MessageType.GIFT_SORT.getWsMethod(), p5.class);
        r0.put(MessageType.FREE_CELL_GIFT_MESSAGE.getWsMethod(), s4.class);
        r0.put(MessageType.BINDING_GIFT_MESSAGE.getWsMethod(), i1.class);
        r0.put(MessageType.GIFT_VOTE_MESSAGE.getWsMethod(), r5.class);
        r0.put(MessageType.LUCKY_BOX_END.getWsMethod(), uf.class);
        r0.put(MessageType.LUCKY_BOX.getWsMethod(), vf.class);
        r0.put(MessageType.LUCKY_BOX_TEMP_STATUS.getWsMethod(), xf.class);
        r0.put(MessageType.LUCKY_BOX_REWARD_MESSAGE.getWsMethod(), wf.class);
        r0.put(MessageType.LOTTERY_V2_EVENT.getWsMethod(), LotteryEventMessage.class);
        r0.put(MessageType.LOTTERY_CANDIDATE_EVENT.getWsMethod(), rf.class);
        r0.put(MessageType.LOTTERY_DRAW_RESULT_EVENT.getWsMethod(), sf.class);
        r0.put(MessageType.LOTTERY_LOTTERY_STATUS_REFRESH_EVENT.getWsMethod(), tf.class);
        r0.put(MessageType.FANS_CLUB.getWsMethod(), l4.class);
        r0.put(MessageType.ECOM_FANS_CLUB.getWsMethod(), EcomFansClubMessage.class);
        r0.put(MessageType.GIFT_CONSUMER_REMAIN_MESSAGE.getWsMethod(), GiftConsumeRemindMessage.class);
        r0.put(MessageType.GAME_UPDATE_PRESENT_MESSAGE.getWsMethod(), mn.class);
        r0.put(MessageType.GROUP_SHOW_USER_UPDATE.getWsMethod(), w5.class);
        r0.put(MessageType.TASK_REWARD_TOAST_MESSAGE.getWsMethod(), wl.class);
        r0.put(MessageType.DRESS_DOWNLOAD_MESSAGE.getWsMethod(), f4.class);
        r0.put(MessageType.SUBSCRIBE_INFO.getWsMethod(), ml.class);
        r0.put(MessageType.PRIZE_NOTICE_MESSAGE.getWsMethod(), hi.class);
        r0.put(MessageType.LIGHT_GIFT_MESSAGE.getWsMethod(), xd.class);
        r0.put(MessageType.GAME_TOOL_ROUND_MESSAGE.getWsMethod(), j.class);
        r0.put(MessageType.GAME_TOOL_COUNTER_MESSAGE.getWsMethod(), h.class);
        r0.put(MessageType.PROFIT_REPORT_MESSAGE.getWsMethod(), li.class);
        r0.put(MessageType.BATTLE_DRAW_PROP_CARD_MESSAGE.getWsMethod(), s0.class);
        r0.put(MessageType.CARNIVAL_TOUCH_MESSAGE.getWsMethod(), a2.class);
        r0.put(MessageType.GROUP_MEMBER_UPDATE_MESSAGE.getWsMethod(), x5.class);
        r0.put(MessageType.GROUP_COMPONENT_CONTAINER_MESSAGE.getWsMethod(), t5.class);
        r0.put(MessageType.LIVE_DIAMOND_SCORE_MESSAGE.getWsMethod(), x3.class);
        r0.put(MessageType.GROUP_LIVE_GIFT_RECIPIENT_RECOMMEND_MESSAGE.getWsMethod(), u5.class);
        r0.put(MessageType.DAILY_RANK_AWARD.getWsMethod(), RankListAwardMessage.class);
        r0.put(MessageType.TOP_EFFECT_MESSAGE.getWsMethod(), gm.class);
        r0.put(MessageType.ATMOSPHERE_EFFECT_MESSAGE.getWsMethod(), b0.class);
        r0.put(MessageType.OPEN_PLATFORM_LIVE_PLAY_HONOR_MESSAGE.getWsMethod(), qf.class);
        r0.put(MessageType.GIFT_PLAY_EVENT_MESSAGE.getWsMethod(), o5.class);
        r0.put(MessageType.ANCHOR_LINK_MIC_BACKSTAGE_INVITE_MESSAGE.getWsMethod(), s.class);
        r0.put(MessageType.AI_ASSISTANT_JOIN_MESSAGE.getWsMethod(), com.bytedance.android.livesdk.message.model.a.class);
        r0.put(MessageType.AI_ASSISTANT_LEAVE_MESSAGE.getWsMethod(), b.class);
        r0.put(MessageType.AI_ASSISTANT_SILENCE_STATUS_MESSAGE.getWsMethod(), c.class);
        a = r0;
    }

    public static Map a() {
        return a;
    }
}
