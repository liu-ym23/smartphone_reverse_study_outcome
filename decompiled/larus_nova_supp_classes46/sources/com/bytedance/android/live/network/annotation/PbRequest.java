package com.bytedance.android.live.network.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface PbRequest {

    public @interface PBSwitchType {
    }

    public interface SwitchType {
        public static final String COMMENT = "comment";
        public static final String DYNAMIC_STRATEGY = "dynamic_strategy";
        public static final String FANS_CLUB = "fans_club";
        public static final String FEED = "feed";
        public static final String GIFT = "gift";
        public static final String GIFT_SWITCH_V2 = "gift_switch_v2";
        public static final String LINKMIC_AUDIENCE = "linkmic_audience";
        public static final String LIVE_GAME = "live_game";
        public static final String LUCKY_BOX = "lucky_box";
        public static final String MULTI_LINK = "multi_link";
        public static final String OTHER = "other";
        public static final String PK = "pk";
        public static final String PK_OR_MULTI = "pk_or_multi";
        public static final String POPULAR = "popular";
        public static final String PREVIEW = "preview";
        public static final String RANK_LIST = "rank_list";
        public static final String RECHARGE = "recharge";
        public static final String REPORT = "report";
        public static final String ROOM = "room";
        public static final String SCREEN_CHAT = "screen_chat";
    }

    String value() default "";
}
