package com.bytedance.android.live.base.model.longpresspanel;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import q61.b;
import q61.c;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\"\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(¨\u0006)"}, d2 = {"Lcom/bytedance/android/live/base/model/longpresspanel/ItemIdentity;", "", "", "Lq61/b;", "entrance", "Lq61/b$a;", "entranceBuilder", "", "key", "Ljava/lang/String;", "getKey", "()Ljava/lang/String;", "BLANK", "FLOAT_WINDOW", "FEED_LIVE_SHARE", "ADD_TO_DESKTOP", "REPORT", "SCREEN_RECORD", "AUDIO_FEEDBACK", "DISLIKE", "DISLIKE_CURRENT_LIVE", "DISLIKE_CONTENT", "DISLIKE_TYPE", "DISLIKE_ANCHOR", "SHARE", "OPT_RECOMMEND", "LIVE_AI_WATCH_ASSISTANT", "LIVE_NOTIFICATION", "FOLLOW", "UNFOLLOW", "IM_MESSAGE", "SHARE_FANS", "RECOMMEND_TO_FRIENDS", "SHARE_LIVE_TO_DAILY", "DANMAKU_SETTING", "MORE_FRIENDS", "PK_FEEDBACK", "CLEAR_SCREEN", "DOU_PLUS", "IMAGE_RECOGNITION", "WATCH_LATER", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ItemIdentity extends Enum<ItemIdentity> {
    public static final ItemIdentity ADD_TO_DESKTOP = null;
    public static final ItemIdentity AUDIO_FEEDBACK = null;
    public static final ItemIdentity BLANK = null;
    public static final ItemIdentity CLEAR_SCREEN = null;
    public static final ItemIdentity DANMAKU_SETTING = null;
    public static final ItemIdentity DISLIKE = null;
    public static final ItemIdentity DISLIKE_ANCHOR = null;
    public static final ItemIdentity DISLIKE_CONTENT = null;
    public static final ItemIdentity DISLIKE_CURRENT_LIVE = null;
    public static final ItemIdentity DISLIKE_TYPE = null;
    public static final ItemIdentity DOU_PLUS = null;
    public static final ItemIdentity FEED_LIVE_SHARE = null;
    public static final ItemIdentity FLOAT_WINDOW = null;
    public static final ItemIdentity FOLLOW = null;
    public static final ItemIdentity IMAGE_RECOGNITION = null;
    public static final ItemIdentity IM_MESSAGE = null;
    public static final ItemIdentity LIVE_AI_WATCH_ASSISTANT = null;
    public static final ItemIdentity LIVE_NOTIFICATION = null;
    public static final ItemIdentity MORE_FRIENDS = null;
    public static final ItemIdentity OPT_RECOMMEND = null;
    public static final ItemIdentity PK_FEEDBACK = null;
    public static final ItemIdentity RECOMMEND_TO_FRIENDS = null;
    public static final ItemIdentity REPORT = null;
    public static final ItemIdentity SCREEN_RECORD = null;
    public static final ItemIdentity SHARE = null;
    public static final ItemIdentity SHARE_FANS = null;
    public static final ItemIdentity SHARE_LIVE_TO_DAILY = null;
    public static final ItemIdentity UNFOLLOW = null;
    public static final ItemIdentity WATCH_LATER = null;
    public static final /* synthetic */ ItemIdentity[] a = null;
    private final String key;

    public static ItemIdentity valueOf(String r1) {
        return (ItemIdentity) a.a(ItemIdentity.class, r1);
    }

    public static ItemIdentity[] values() {
        return (ItemIdentity[]) a.clone();
    }

    static {
        ItemIdentity r1 = new ItemIdentity("BLANK", 0, "blank");
        BLANK = r1;
        ItemIdentity r2 = new ItemIdentity("FLOAT_WINDOW", 1, "float_window");
        FLOAT_WINDOW = r2;
        ItemIdentity r3 = new ItemIdentity("FEED_LIVE_SHARE", 2, "feed_live_share");
        FEED_LIVE_SHARE = r3;
        ItemIdentity r4 = new ItemIdentity("ADD_TO_DESKTOP", 3, "add_to_desktop");
        ADD_TO_DESKTOP = r4;
        ItemIdentity r5 = new ItemIdentity("REPORT", 4, "report");
        REPORT = r5;
        ItemIdentity r6 = new ItemIdentity("SCREEN_RECORD", 5, "screen_record");
        SCREEN_RECORD = r6;
        ItemIdentity r7 = new ItemIdentity("AUDIO_FEEDBACK", 6, "audio_feedback");
        AUDIO_FEEDBACK = r7;
        ItemIdentity r8 = new ItemIdentity("DISLIKE", 7, "dislike");
        DISLIKE = r8;
        ItemIdentity r9 = new ItemIdentity("DISLIKE_CURRENT_LIVE", 8, "dislike_current_live");
        DISLIKE_CURRENT_LIVE = r9;
        ItemIdentity r11 = new ItemIdentity("DISLIKE_CONTENT", 9, "dislike_content");
        DISLIKE_CONTENT = r11;
        ItemIdentity r12 = new ItemIdentity("DISLIKE_TYPE", 10, "dislike_type");
        DISLIKE_TYPE = r12;
        ItemIdentity r13 = new ItemIdentity("DISLIKE_ANCHOR", 11, "dislike_anchor");
        DISLIKE_ANCHOR = r13;
        ItemIdentity r14 = new ItemIdentity("SHARE", 12, "share");
        SHARE = r14;
        ItemIdentity r15 = new ItemIdentity("OPT_RECOMMEND", 13, "opt_recommend");
        OPT_RECOMMEND = r15;
        ItemIdentity r16 = new ItemIdentity("LIVE_AI_WATCH_ASSISTANT", 14, "live_ai_watch_assistant");
        LIVE_AI_WATCH_ASSISTANT = r16;
        ItemIdentity r17 = new ItemIdentity("LIVE_NOTIFICATION", 15, "live_notification");
        LIVE_NOTIFICATION = r17;
        ItemIdentity r18 = new ItemIdentity("FOLLOW", 16, "follow");
        FOLLOW = r18;
        ItemIdentity r19 = new ItemIdentity("UNFOLLOW", 17, "unfollow");
        UNFOLLOW = r19;
        ItemIdentity r21 = new ItemIdentity("IM_MESSAGE", 18, "im_message");
        IM_MESSAGE = r21;
        ItemIdentity r22 = new ItemIdentity("SHARE_FANS", 19, "share_fans");
        SHARE_FANS = r22;
        ItemIdentity r23 = new ItemIdentity("RECOMMEND_TO_FRIENDS", 20, "recommend_to_friends");
        RECOMMEND_TO_FRIENDS = r23;
        ItemIdentity r24 = new ItemIdentity("SHARE_LIVE_TO_DAILY", 21, "share_live_to_daily");
        SHARE_LIVE_TO_DAILY = r24;
        ItemIdentity r25 = new ItemIdentity("DANMAKU_SETTING", 22, "danmaku_setting");
        DANMAKU_SETTING = r25;
        ItemIdentity r26 = new ItemIdentity("MORE_FRIENDS", 23, "more_friends");
        MORE_FRIENDS = r26;
        ItemIdentity r27 = new ItemIdentity("PK_FEEDBACK", 24, "pk_feedback");
        PK_FEEDBACK = r27;
        ItemIdentity r28 = new ItemIdentity("CLEAR_SCREEN", 25, "clear_screen");
        CLEAR_SCREEN = r28;
        ItemIdentity r29 = new ItemIdentity("DOU_PLUS", 26, "dou_plus");
        DOU_PLUS = r29;
        ItemIdentity r31 = new ItemIdentity("IMAGE_RECOGNITION", 27, "image_recognition");
        IMAGE_RECOGNITION = r31;
        ItemIdentity r32 = new ItemIdentity("WATCH_LATER", 28, "watch_later");
        WATCH_LATER = r32;
        a = new ItemIdentity[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r12, r13, r14, r15, r16, r17, r18, r19, r21, r22, r23, r24, r25, r26, r27, r28, r29, r31, r32};
    }

    public b entrance() {
        int r0 = cz.b.a;
        Intrinsics.checkNotNullParameter(this, "identity");
        return new c(cz.b.a(this));
    }

    public b.a entranceBuilder() {
        return cz.b.a(this);
    }

    public final String getKey() {
        return this.key;
    }

    public ItemIdentity(String r1, int r2, String r3) {
        super(r1, r2);
        this.key = r3;
    }
}
