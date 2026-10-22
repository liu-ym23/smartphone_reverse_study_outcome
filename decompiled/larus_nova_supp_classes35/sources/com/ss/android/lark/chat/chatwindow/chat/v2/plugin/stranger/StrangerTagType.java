package com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/v2/plugin/stranger/StrangerTagType;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "NONE", "STRANGER", "TOTAL_BLOCK", "BLOCK", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum StrangerTagType extends Enum<StrangerTagType> {
    public static final StrangerTagType BLOCK = null;
    public static final StrangerTagType NONE = null;
    public static final StrangerTagType STRANGER = null;
    public static final StrangerTagType TOTAL_BLOCK = null;
    public static final /* synthetic */ StrangerTagType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<StrangerTagType> getEntries() {
        return b;
    }

    static {
        StrangerTagType r0 = new StrangerTagType("NONE", 0);
        NONE = r0;
        StrangerTagType r1 = new StrangerTagType("STRANGER", 1);
        STRANGER = r1;
        StrangerTagType r3 = new StrangerTagType("TOTAL_BLOCK", 2);
        TOTAL_BLOCK = r3;
        StrangerTagType r5 = new StrangerTagType("BLOCK", 3);
        BLOCK = r5;
        StrangerTagType[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static StrangerTagType[] values() {
        return (StrangerTagType[]) a.clone();
    }

    public static StrangerTagType valueOf(String r1) {
        return (StrangerTagType) a.a(StrangerTagType.class, r1);
    }

    public StrangerTagType(String r1, int r2) {
        super(r1, r2);
    }
}
