package com.larus.voice_setting;

import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/voice_setting/UgcVoiceRecommendScene;", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Ljava/lang/String;I)V", "NULL", "BOT_FIRST_MET", "REAL_TIME", "CHAT_SETTING", "BOT_CREATE", "BOT_UPDATE", "ROUTER", "flow-voice-setting-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum UgcVoiceRecommendScene extends Enum<UgcVoiceRecommendScene> {
    public static final UgcVoiceRecommendScene BOT_CREATE = null;
    public static final UgcVoiceRecommendScene BOT_FIRST_MET = null;
    public static final UgcVoiceRecommendScene BOT_UPDATE = null;
    public static final UgcVoiceRecommendScene CHAT_SETTING = null;
    public static final UgcVoiceRecommendScene NULL = null;
    public static final UgcVoiceRecommendScene REAL_TIME = null;
    public static final UgcVoiceRecommendScene ROUTER = null;
    public static final /* synthetic */ UgcVoiceRecommendScene[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<UgcVoiceRecommendScene> getEntries() {
        return b;
    }

    static {
        UgcVoiceRecommendScene r0 = new UgcVoiceRecommendScene("NULL", 0);
        NULL = r0;
        UgcVoiceRecommendScene r1 = new UgcVoiceRecommendScene("BOT_FIRST_MET", 1);
        BOT_FIRST_MET = r1;
        UgcVoiceRecommendScene r3 = new UgcVoiceRecommendScene("REAL_TIME", 2);
        REAL_TIME = r3;
        UgcVoiceRecommendScene r5 = new UgcVoiceRecommendScene("CHAT_SETTING", 3);
        CHAT_SETTING = r5;
        UgcVoiceRecommendScene r7 = new UgcVoiceRecommendScene("BOT_CREATE", 4);
        BOT_CREATE = r7;
        UgcVoiceRecommendScene r9 = new UgcVoiceRecommendScene("BOT_UPDATE", 5);
        BOT_UPDATE = r9;
        UgcVoiceRecommendScene r11 = new UgcVoiceRecommendScene("ROUTER", 6);
        ROUTER = r11;
        UgcVoiceRecommendScene[] r13 = {r0, r1, r3, r5, r7, r9, r11};
        a = r13;
        b = EnumEntriesKt.enumEntries(r13);
    }

    public static UgcVoiceRecommendScene[] values() {
        return (UgcVoiceRecommendScene[]) a.clone();
    }

    public static UgcVoiceRecommendScene valueOf(String r1) {
        return (UgcVoiceRecommendScene) a.a(UgcVoiceRecommendScene.class, r1);
    }

    public UgcVoiceRecommendScene(String r1, int r2) {
        super(r1, r2);
    }
}
