package com.larus.audio.bean;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/audio/bean/RecommendScene;", "", "<init>", "(Ljava/lang/String;I)V", "NULL", "BOT_FIRST_MET", "REAL_TIME", "CHAT_SETTING", "BOT_CREATE", "BOT_UPDATE", "ROUTER", "api_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum RecommendScene extends Enum<RecommendScene> {
    public static final RecommendScene BOT_CREATE = null;
    public static final RecommendScene BOT_FIRST_MET = null;
    public static final RecommendScene BOT_UPDATE = null;
    public static final RecommendScene CHAT_SETTING = null;
    public static final RecommendScene NULL = null;
    public static final RecommendScene REAL_TIME = null;
    public static final RecommendScene ROUTER = null;
    public static final /* synthetic */ RecommendScene[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<RecommendScene> getEntries() {
        return b;
    }

    static {
        RecommendScene r0 = new RecommendScene("NULL", 0);
        NULL = r0;
        RecommendScene r1 = new RecommendScene("BOT_FIRST_MET", 1);
        BOT_FIRST_MET = r1;
        RecommendScene r3 = new RecommendScene("REAL_TIME", 2);
        REAL_TIME = r3;
        RecommendScene r5 = new RecommendScene("CHAT_SETTING", 3);
        CHAT_SETTING = r5;
        RecommendScene r7 = new RecommendScene("BOT_CREATE", 4);
        BOT_CREATE = r7;
        RecommendScene r9 = new RecommendScene("BOT_UPDATE", 5);
        BOT_UPDATE = r9;
        RecommendScene r11 = new RecommendScene("ROUTER", 6);
        ROUTER = r11;
        RecommendScene[] r13 = {r0, r1, r3, r5, r7, r9, r11};
        a = r13;
        b = EnumEntriesKt.enumEntries(r13);
    }

    public static RecommendScene[] values() {
        return (RecommendScene[]) a.clone();
    }

    public static RecommendScene valueOf(String r1) {
        return (RecommendScene) a.a(RecommendScene.class, r1);
    }

    public RecommendScene(String r1, int r2) {
        super(r1, r2);
    }
}
