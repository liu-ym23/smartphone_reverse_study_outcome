package com.bytedance.android.livesdk.interactivity.api.degrade.model;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0010\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/degrade/model/DegradeScene;", BuildConfig.FLAVOR, "PERFORMANCE_FRAME", "ECOM", "GAME", "LOW_PERFORMANCE_PHONE", "STRATEGY_PLATFORM_FLOW_LIKE_DEGRADE", "STRATEGY_PLATFORM_TAP_LIKE_DEGRADE", "ENTER_ROOM_DURATION", "AUDIENCE_EXP_HIGH_LEVEL_ENTER_ANIM", "AUDIENCE_EXP_HIGH_LEVEL_ECOM_ANIM", "AUDIENCE_EXP_DISABLE_HIGH_LEVEL_ENTER", "AUDIENCE_EXP_HOT_COMMENT_TRAY", "AUDIENCE_EXP_PORTRAIT_DANMAKU", "AUDIENCE_EXP_LIKE_FLOW", "AUDIENCE_EXP_COMMENT_CARNIVAL", "AUDIENCE_EXP_PUBLIC_SCREEN_ANIM", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum DegradeScene extends Enum<DegradeScene> {
    public static final DegradeScene AUDIENCE_EXP_COMMENT_CARNIVAL = null;
    public static final DegradeScene AUDIENCE_EXP_DISABLE_HIGH_LEVEL_ENTER = null;
    public static final DegradeScene AUDIENCE_EXP_HIGH_LEVEL_ECOM_ANIM = null;
    public static final DegradeScene AUDIENCE_EXP_HIGH_LEVEL_ENTER_ANIM = null;
    public static final DegradeScene AUDIENCE_EXP_HOT_COMMENT_TRAY = null;
    public static final DegradeScene AUDIENCE_EXP_LIKE_FLOW = null;
    public static final DegradeScene AUDIENCE_EXP_PORTRAIT_DANMAKU = null;
    public static final DegradeScene AUDIENCE_EXP_PUBLIC_SCREEN_ANIM = null;
    public static final DegradeScene ECOM = null;
    public static final DegradeScene ENTER_ROOM_DURATION = null;
    public static final DegradeScene GAME = null;
    public static final DegradeScene LOW_PERFORMANCE_PHONE = null;
    public static final DegradeScene PERFORMANCE_FRAME = null;
    public static final DegradeScene STRATEGY_PLATFORM_FLOW_LIKE_DEGRADE = null;
    public static final DegradeScene STRATEGY_PLATFORM_TAP_LIKE_DEGRADE = null;
    public static final /* synthetic */ DegradeScene[] a = null;

    static {
        DegradeScene r1 = new DegradeScene("PERFORMANCE_FRAME", 0);
        PERFORMANCE_FRAME = r1;
        DegradeScene r2 = new DegradeScene("ECOM", 1);
        ECOM = r2;
        DegradeScene r3 = new DegradeScene("GAME", 2);
        GAME = r3;
        DegradeScene r4 = new DegradeScene("LOW_PERFORMANCE_PHONE", 3);
        LOW_PERFORMANCE_PHONE = r4;
        DegradeScene r5 = new DegradeScene("STRATEGY_PLATFORM_FLOW_LIKE_DEGRADE", 4);
        STRATEGY_PLATFORM_FLOW_LIKE_DEGRADE = r5;
        DegradeScene r6 = new DegradeScene("STRATEGY_PLATFORM_TAP_LIKE_DEGRADE", 5);
        STRATEGY_PLATFORM_TAP_LIKE_DEGRADE = r6;
        DegradeScene r7 = new DegradeScene("ENTER_ROOM_DURATION", 6);
        ENTER_ROOM_DURATION = r7;
        DegradeScene r8 = new DegradeScene("AUDIENCE_EXP_HIGH_LEVEL_ENTER_ANIM", 7);
        AUDIENCE_EXP_HIGH_LEVEL_ENTER_ANIM = r8;
        DegradeScene r9 = new DegradeScene("AUDIENCE_EXP_HIGH_LEVEL_ECOM_ANIM", 8);
        AUDIENCE_EXP_HIGH_LEVEL_ECOM_ANIM = r9;
        DegradeScene r10 = new DegradeScene("AUDIENCE_EXP_DISABLE_HIGH_LEVEL_ENTER", 9);
        AUDIENCE_EXP_DISABLE_HIGH_LEVEL_ENTER = r10;
        DegradeScene r11 = new DegradeScene("AUDIENCE_EXP_HOT_COMMENT_TRAY", 10);
        AUDIENCE_EXP_HOT_COMMENT_TRAY = r11;
        DegradeScene r13 = new DegradeScene("AUDIENCE_EXP_PORTRAIT_DANMAKU", 11);
        AUDIENCE_EXP_PORTRAIT_DANMAKU = r13;
        DegradeScene r14 = new DegradeScene("AUDIENCE_EXP_LIKE_FLOW", 12);
        AUDIENCE_EXP_LIKE_FLOW = r14;
        DegradeScene r15 = new DegradeScene("AUDIENCE_EXP_COMMENT_CARNIVAL", 13);
        AUDIENCE_EXP_COMMENT_CARNIVAL = r15;
        DegradeScene r16 = new DegradeScene("AUDIENCE_EXP_PUBLIC_SCREEN_ANIM", 14);
        AUDIENCE_EXP_PUBLIC_SCREEN_ANIM = r16;
        a = new DegradeScene[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r13, r14, r15, r16};
    }

    public static DegradeScene valueOf(String r1) {
        return (DegradeScene) a.a(DegradeScene.class, r1);
    }

    public static DegradeScene[] values() {
        return (DegradeScene[]) a.clone();
    }

    public DegradeScene(String r1, int r2) {
        super(r1, r2);
    }
}
