package com.larus.platform.model;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u001f\b\u0086\u0081\u0002\u0018\u0000 !2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001!B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b ¨\u0006\""}, d2 = {"Lcom/larus/platform/model/TriggerLoginScene;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "TRIGGER_LOGIN_LANDING", "TRIGGER_LOGIN_CREATE_BOT", "TRIGGER_LOGIN_MESSAGE_LIMITED", "TRIGGER_LOGIN_CLICK_TAB", "TRIGGER_LOGIN_CLICK_CALL", "TRIGGER_LOGIN_CLICK_INPUT", "TRIGGER_LOGIN_CLICK_OTHERS", "TRIGGER_LOGIN_TOURIST_AUTH", "TRIGGER_LOGIN_FIRST_APPLICATION_MUSIC_QUERY", "TRIGGER_LOGIN_FIRST_APPLICATION_MUSIC_HISTORY_CLICK", "TRIGGER_LOGIN_CHAT_LIST_GUIDE_BANNER", "TRIGGER_LOGIN_DISABLE_TOURIST_CREATION", "TRIGGER_LOGIN_COMMERCE_CREDIT_TOURIST_GUIDE", "TRIGGER_LOGIN_DISABLE_TOURIST_TUTOR", "TRIGGER_LOGIN_ENTER_SPRING_MAIN_VENUE", "TRIGGER_LOGIN_AWEME_RED_PACKET", "TRIGGER_LOGIN_ECOMMERCE_PRODUCT_DETAIL", "TRIGGER_LOGIN_BD_TURING", "TRIGGER_LOGIN_ADD_ACCOUNT", "TRIGGER_LOGIN_INVALID_RELOGIN", "TRIGGER_LOGIN_LOCAL_LIFE", "TRIGGER_LOGIN_EC_SEARCH_SAAS_CARD", "TRIGGER_LOGIN_ENTER_COMMON_MAIN_VENUE", "TRIGGER_LOGIN_PARSE_NEED_LOGIN_ROUTER", "TRIGGER_LOGIN_AUDIO_RECORD", "Companion", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum TriggerLoginScene extends Enum<TriggerLoginScene> {
    public static final a Companion = null;
    public static final TriggerLoginScene TRIGGER_LOGIN_ADD_ACCOUNT = null;
    public static final TriggerLoginScene TRIGGER_LOGIN_AUDIO_RECORD = null;
    public static final TriggerLoginScene TRIGGER_LOGIN_AWEME_RED_PACKET = null;
    public static final TriggerLoginScene TRIGGER_LOGIN_BD_TURING = null;
    public static final TriggerLoginScene TRIGGER_LOGIN_CHAT_LIST_GUIDE_BANNER = null;
    public static final TriggerLoginScene TRIGGER_LOGIN_CLICK_CALL = null;
    public static final TriggerLoginScene TRIGGER_LOGIN_CLICK_INPUT = null;
    public static final TriggerLoginScene TRIGGER_LOGIN_CLICK_OTHERS = null;
    public static final TriggerLoginScene TRIGGER_LOGIN_CLICK_TAB = null;
    public static final TriggerLoginScene TRIGGER_LOGIN_COMMERCE_CREDIT_TOURIST_GUIDE = null;
    public static final TriggerLoginScene TRIGGER_LOGIN_CREATE_BOT = null;
    public static final TriggerLoginScene TRIGGER_LOGIN_DISABLE_TOURIST_CREATION = null;
    public static final TriggerLoginScene TRIGGER_LOGIN_DISABLE_TOURIST_TUTOR = null;
    public static final TriggerLoginScene TRIGGER_LOGIN_ECOMMERCE_PRODUCT_DETAIL = null;
    public static final TriggerLoginScene TRIGGER_LOGIN_EC_SEARCH_SAAS_CARD = null;
    public static final TriggerLoginScene TRIGGER_LOGIN_ENTER_COMMON_MAIN_VENUE = null;
    public static final TriggerLoginScene TRIGGER_LOGIN_ENTER_SPRING_MAIN_VENUE = null;
    public static final TriggerLoginScene TRIGGER_LOGIN_FIRST_APPLICATION_MUSIC_HISTORY_CLICK = null;
    public static final TriggerLoginScene TRIGGER_LOGIN_FIRST_APPLICATION_MUSIC_QUERY = null;
    public static final TriggerLoginScene TRIGGER_LOGIN_INVALID_RELOGIN = null;
    public static final TriggerLoginScene TRIGGER_LOGIN_LANDING = null;
    public static final TriggerLoginScene TRIGGER_LOGIN_LOCAL_LIFE = null;
    public static final TriggerLoginScene TRIGGER_LOGIN_MESSAGE_LIMITED = null;
    public static final TriggerLoginScene TRIGGER_LOGIN_PARSE_NEED_LOGIN_ROUTER = null;
    public static final TriggerLoginScene TRIGGER_LOGIN_TOURIST_AUTH = null;
    public static final /* synthetic */ TriggerLoginScene[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static EnumEntries<TriggerLoginScene> getEntries() {
        return b;
    }

    /* JADX WARN: Type inference failed for: r0v25, types: [com.larus.platform.model.TriggerLoginScene$a] */
    static {
        TriggerLoginScene r0 = new TriggerLoginScene("TRIGGER_LOGIN_LANDING", 0, 0);
        TRIGGER_LOGIN_LANDING = r0;
        TriggerLoginScene r1 = new TriggerLoginScene("TRIGGER_LOGIN_CREATE_BOT", 1, 1);
        TRIGGER_LOGIN_CREATE_BOT = r1;
        TriggerLoginScene r3 = new TriggerLoginScene("TRIGGER_LOGIN_MESSAGE_LIMITED", 2, 2);
        TRIGGER_LOGIN_MESSAGE_LIMITED = r3;
        TriggerLoginScene r5 = new TriggerLoginScene("TRIGGER_LOGIN_CLICK_TAB", 3, 3);
        TRIGGER_LOGIN_CLICK_TAB = r5;
        TriggerLoginScene r7 = new TriggerLoginScene("TRIGGER_LOGIN_CLICK_CALL", 4, 4);
        TRIGGER_LOGIN_CLICK_CALL = r7;
        TriggerLoginScene r9 = new TriggerLoginScene("TRIGGER_LOGIN_CLICK_INPUT", 5, 5);
        TRIGGER_LOGIN_CLICK_INPUT = r9;
        TriggerLoginScene r11 = new TriggerLoginScene("TRIGGER_LOGIN_CLICK_OTHERS", 6, 6);
        TRIGGER_LOGIN_CLICK_OTHERS = r11;
        TriggerLoginScene r13 = new TriggerLoginScene("TRIGGER_LOGIN_TOURIST_AUTH", 7, 7);
        TRIGGER_LOGIN_TOURIST_AUTH = r13;
        TriggerLoginScene r15 = new TriggerLoginScene("TRIGGER_LOGIN_FIRST_APPLICATION_MUSIC_QUERY", 8, 8);
        TRIGGER_LOGIN_FIRST_APPLICATION_MUSIC_QUERY = r15;
        TriggerLoginScene r14 = new TriggerLoginScene("TRIGGER_LOGIN_FIRST_APPLICATION_MUSIC_HISTORY_CLICK", 9, 9);
        TRIGGER_LOGIN_FIRST_APPLICATION_MUSIC_HISTORY_CLICK = r14;
        TriggerLoginScene r12 = new TriggerLoginScene("TRIGGER_LOGIN_CHAT_LIST_GUIDE_BANNER", 10, 10);
        TRIGGER_LOGIN_CHAT_LIST_GUIDE_BANNER = r12;
        TriggerLoginScene r10 = new TriggerLoginScene("TRIGGER_LOGIN_DISABLE_TOURIST_CREATION", 11, 11);
        TRIGGER_LOGIN_DISABLE_TOURIST_CREATION = r10;
        TriggerLoginScene r8 = new TriggerLoginScene("TRIGGER_LOGIN_COMMERCE_CREDIT_TOURIST_GUIDE", 12, 12);
        TRIGGER_LOGIN_COMMERCE_CREDIT_TOURIST_GUIDE = r8;
        TriggerLoginScene r6 = new TriggerLoginScene("TRIGGER_LOGIN_DISABLE_TOURIST_TUTOR", 13, 13);
        TRIGGER_LOGIN_DISABLE_TOURIST_TUTOR = r6;
        TriggerLoginScene r4 = new TriggerLoginScene("TRIGGER_LOGIN_ENTER_SPRING_MAIN_VENUE", 14, 14);
        TRIGGER_LOGIN_ENTER_SPRING_MAIN_VENUE = r4;
        TriggerLoginScene r2 = new TriggerLoginScene("TRIGGER_LOGIN_AWEME_RED_PACKET", 15, 15);
        TRIGGER_LOGIN_AWEME_RED_PACKET = r2;
        TriggerLoginScene r16 = new TriggerLoginScene("TRIGGER_LOGIN_ECOMMERCE_PRODUCT_DETAIL", 16, 16);
        TRIGGER_LOGIN_ECOMMERCE_PRODUCT_DETAIL = r16;
        TriggerLoginScene r17 = new TriggerLoginScene("TRIGGER_LOGIN_BD_TURING", 17, 17);
        TRIGGER_LOGIN_BD_TURING = r17;
        TriggerLoginScene r18 = new TriggerLoginScene("TRIGGER_LOGIN_ADD_ACCOUNT", 18, 18);
        TRIGGER_LOGIN_ADD_ACCOUNT = r18;
        TriggerLoginScene r19 = new TriggerLoginScene("TRIGGER_LOGIN_INVALID_RELOGIN", 19, 19);
        TRIGGER_LOGIN_INVALID_RELOGIN = r19;
        TriggerLoginScene r20 = new TriggerLoginScene("TRIGGER_LOGIN_LOCAL_LIFE", 20, 20);
        TRIGGER_LOGIN_LOCAL_LIFE = r20;
        TriggerLoginScene r21 = new TriggerLoginScene("TRIGGER_LOGIN_EC_SEARCH_SAAS_CARD", 21, 21);
        TRIGGER_LOGIN_EC_SEARCH_SAAS_CARD = r21;
        TriggerLoginScene r22 = new TriggerLoginScene("TRIGGER_LOGIN_ENTER_COMMON_MAIN_VENUE", 22, 22);
        TRIGGER_LOGIN_ENTER_COMMON_MAIN_VENUE = r22;
        TriggerLoginScene r23 = new TriggerLoginScene("TRIGGER_LOGIN_PARSE_NEED_LOGIN_ROUTER", 23, 23);
        TRIGGER_LOGIN_PARSE_NEED_LOGIN_ROUTER = r23;
        TriggerLoginScene r24 = new TriggerLoginScene("TRIGGER_LOGIN_AUDIO_RECORD", 24, 24);
        TRIGGER_LOGIN_AUDIO_RECORD = r24;
        TriggerLoginScene[] r25 = {r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4, r2, r16, r17, r18, r19, r20, r21, r22, r23, r24};
        a = r25;
        b = EnumEntriesKt.enumEntries(r25);
        Companion = new a();
    }

    public static TriggerLoginScene[] values() {
        return (TriggerLoginScene[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static TriggerLoginScene valueOf(String r1) {
        return (TriggerLoginScene) r27.a.a(TriggerLoginScene.class, r1);
    }

    public TriggerLoginScene(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
