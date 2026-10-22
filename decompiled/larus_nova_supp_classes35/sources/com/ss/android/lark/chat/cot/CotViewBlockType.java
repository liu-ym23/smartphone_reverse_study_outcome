package com.ss.android.lark.chat.cot;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/chat/cot/CotViewBlockType;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "RUN", "STEP", "TEXT", "TOOL_CALL", "ACTIVITY", "REASONING", "RAW", "CUSTOM", "chat-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CotViewBlockType extends Enum<CotViewBlockType> {
    public static final CotViewBlockType ACTIVITY = null;
    public static final CotViewBlockType CUSTOM = null;
    public static final CotViewBlockType RAW = null;
    public static final CotViewBlockType REASONING = null;
    public static final CotViewBlockType RUN = null;
    public static final CotViewBlockType STEP = null;
    public static final CotViewBlockType TEXT = null;
    public static final CotViewBlockType TOOL_CALL = null;
    public static final /* synthetic */ CotViewBlockType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<CotViewBlockType> getEntries() {
        return b;
    }

    static {
        CotViewBlockType r0 = new CotViewBlockType("RUN", 0);
        RUN = r0;
        CotViewBlockType r1 = new CotViewBlockType("STEP", 1);
        STEP = r1;
        CotViewBlockType r3 = new CotViewBlockType("TEXT", 2);
        TEXT = r3;
        CotViewBlockType r5 = new CotViewBlockType("TOOL_CALL", 3);
        TOOL_CALL = r5;
        CotViewBlockType r7 = new CotViewBlockType("ACTIVITY", 4);
        ACTIVITY = r7;
        CotViewBlockType r9 = new CotViewBlockType("REASONING", 5);
        REASONING = r9;
        CotViewBlockType r11 = new CotViewBlockType("RAW", 6);
        RAW = r11;
        CotViewBlockType r13 = new CotViewBlockType("CUSTOM", 7);
        CUSTOM = r13;
        CotViewBlockType[] r15 = {r0, r1, r3, r5, r7, r9, r11, r13};
        a = r15;
        b = EnumEntriesKt.enumEntries(r15);
    }

    public static CotViewBlockType[] values() {
        return (CotViewBlockType[]) a.clone();
    }

    public static CotViewBlockType valueOf(String r1) {
        return (CotViewBlockType) r27.a.a(CotViewBlockType.class, r1);
    }

    public CotViewBlockType(String r1, int r2) {
        super(r1, r2);
    }
}
