package com.bytedance.android.livesdk.config.setting;

import com.bytedance.android.live.base.model.longpresspanel.ItemConfig;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.BubbleId;
import com.bytedance.android.livesdk.config.zc0;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class l {
    public static final /* synthetic */ int a = 0;

    @JvmStatic
    public static final List<ItemConfig> a() {
        List<ItemConfig> r0 = zc0.a.getValue().liveFeedItemList;
        if (r0 == null) goto L5;
        return r0;
    L5:
        if (tb1.c.c == false) goto L7;
        ItemConfig r1 = new ItemConfig();
        r1.setIdentity("live_notification");
        r1.setType(2);
        r1.setPriority(1900);
        Unit r7 = Unit.INSTANCE;
        ItemConfig r2 = new ItemConfig();
        r2.setIdentity("dislike_current_live");
        r2.setType(2);
        r2.setPriority(2000);
        ItemConfig r3 = new ItemConfig();
        r3.setIdentity("report");
        r3.setType(2);
        r3.setPriority(1600);
        ItemConfig r4 = new ItemConfig();
        r4.setIdentity("recommend_to_friends");
        r4.setType(1);
        r4.setPriority(2000);
        ItemConfig r5 = new ItemConfig();
        r5.setIdentity("follow");
        r5.setType(2);
        r5.setPriority(1800);
        ItemConfig r6 = new ItemConfig();
        r6.setIdentity("unfollow");
        r6.setType(2);
        r6.setPriority(1500);
        ItemConfig r8 = new ItemConfig();
        r8.setIdentity("feed_live_share");
        r8.setType(2);
        r8.setPriority(1200);
        ItemConfig r9 = new ItemConfig();
        r9.setIdentity("im_message");
        r9.setType(0);
        r9.setPriority(2000);
        return CollectionsKt.mutableListOf(new ItemConfig[]{r1, r2, r3, r4, r5, r6, r8, r9});
    L7:
        ItemConfig r10 = new ItemConfig();
        r10.setIdentity("live_notification");
        r10.setType(2);
        r10.setPriority(1900);
        Unit r11 = Unit.INSTANCE;
        ItemConfig r12 = new ItemConfig();
        r12.setIdentity("opt_recommend");
        r12.setType(2);
        r12.setPriority(1700);
        ItemConfig r13 = new ItemConfig();
        r13.setIdentity("dislike_current_live");
        r13.setType(2);
        r13.setPriority(2000);
        ItemConfig r14 = new ItemConfig();
        r14.setIdentity("report");
        r14.setType(2);
        r14.setPriority(1600);
        ItemConfig r15 = new ItemConfig();
        r15.setIdentity("recommend_to_friends");
        r15.setType(1);
        r15.setPriority(2000);
        ItemConfig r16 = new ItemConfig();
        r16.setIdentity("follow");
        r16.setType(2);
        r16.setPriority(1800);
        ItemConfig r17 = new ItemConfig();
        r17.setIdentity("unfollow");
        r17.setType(2);
        r17.setPriority(1500);
        ItemConfig r18 = new ItemConfig();
        r18.setIdentity("feed_live_share");
        r18.setType(2);
        r18.setPriority(1200);
        ItemConfig r19 = new ItemConfig();
        r19.setIdentity("im_message");
        r19.setType(0);
        r19.setPriority(2000);
        return CollectionsKt.mutableListOf(new ItemConfig[]{r10, r12, r13, r14, r15, r16, r17, r18, r19});
    }

    @JvmStatic
    public static final List<ItemConfig> b() {
        List<ItemConfig> r0 = zc0.a.getValue().liveRoomItemList;
        if (r0 == null) goto L5;
        return r0;
    L5:
        if (tb1.c.c == false) goto L7;
        ItemConfig r7 = new ItemConfig();
        r7.setIdentity("live_notification");
        r7.setType(2);
        r7.setPriority(1900);
        Unit r4 = Unit.INSTANCE;
        ItemConfig r5 = new ItemConfig();
        r5.setIdentity("dislike_current_live");
        r5.setType(2);
        r5.setPriority(2000);
        ItemConfig r1 = new ItemConfig();
        r1.setIdentity("report");
        r1.setType(2);
        r1.setPriority(1600);
        ItemConfig r2 = new ItemConfig();
        r2.setIdentity("recommend_to_friends");
        r2.setType(1);
        r2.setPriority(2000);
        ItemConfig r3 = new ItemConfig();
        r3.setIdentity("follow");
        r3.setType(2);
        r3.setPriority(1800);
        ItemConfig r6 = new ItemConfig();
        r6.setIdentity("unfollow");
        r6.setType(2);
        r6.setPriority(1500);
        ItemConfig r8 = new ItemConfig();
        r8.setIdentity("float_window");
        r8.setType(2);
        r8.setPriority(1400);
        ItemConfig r9 = new ItemConfig();
        r9.setIdentity("feed_live_share");
        r9.setType(2);
        r9.setPriority(1200);
        ItemConfig r10 = new ItemConfig();
        r10.setIdentity("pk_feedback");
        r10.setType(2);
        r10.setPriority(900);
        ItemConfig r11 = new ItemConfig();
        r11.setIdentity("im_message");
        r11.setType(0);
        r11.setPriority(2000);
        ItemConfig r12 = new ItemConfig();
        r12.setIdentity("screen_record");
        r12.setType(2);
        r12.setPriority(Integer.valueOf(BubbleId.PadCast));
        return CollectionsKt.mutableListOf(new ItemConfig[]{r7, r5, r1, r2, r3, r6, r8, r9, r10, r11, r12});
    L7:
        ItemConfig r13 = new ItemConfig();
        r13.setIdentity("live_notification");
        r13.setType(2);
        r13.setPriority(1900);
        Unit r14 = Unit.INSTANCE;
        ItemConfig r15 = new ItemConfig();
        r15.setIdentity("opt_recommend");
        r15.setType(2);
        r15.setPriority(1700);
        ItemConfig r16 = new ItemConfig();
        r16.setIdentity("dislike_current_live");
        r16.setType(2);
        r16.setPriority(2000);
        ItemConfig r17 = new ItemConfig();
        r17.setIdentity("report");
        r17.setType(2);
        r17.setPriority(1600);
        ItemConfig r18 = new ItemConfig();
        r18.setIdentity("recommend_to_friends");
        r18.setType(1);
        r18.setPriority(2000);
        ItemConfig r19 = new ItemConfig();
        r19.setIdentity("follow");
        r19.setType(2);
        r19.setPriority(1800);
        ItemConfig r20 = new ItemConfig();
        r20.setIdentity("unfollow");
        r20.setType(2);
        r20.setPriority(1500);
        ItemConfig r21 = new ItemConfig();
        r21.setIdentity("float_window");
        r21.setType(2);
        r21.setPriority(1400);
        ItemConfig r22 = new ItemConfig();
        r22.setIdentity("add_to_desktop");
        r22.setType(2);
        r22.setPriority(1300);
        ItemConfig r23 = new ItemConfig();
        r23.setIdentity("feed_live_share");
        r23.setType(2);
        r23.setPriority(1200);
        ItemConfig r24 = new ItemConfig();
        r24.setIdentity("audio_feedback");
        r24.setType(2);
        r24.setPriority(1100);
        ItemConfig r25 = new ItemConfig();
        r25.setIdentity("pk_feedback");
        r25.setType(2);
        r25.setPriority(900);
        ItemConfig r26 = new ItemConfig();
        r26.setIdentity("im_message");
        r26.setType(0);
        r26.setPriority(2000);
        ItemConfig r27 = new ItemConfig();
        r27.setIdentity("screen_record");
        r27.setType(2);
        r27.setPriority(Integer.valueOf(BubbleId.PadCast));
        return CollectionsKt.mutableListOf(new ItemConfig[]{r13, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27});
    }

    @JvmStatic
    public static final boolean c() {
        Integer r0 = zc0.a.getValue().style;
        if (r0 != null) goto L6;
    L7:
        return true;
    L6:
        if (r0.intValue() != 0) goto L7;
        return false;
    }

    static {
    }
}
