package com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/v2/plugin/stranger/StrangerBannerType;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "UNKNOWN", "NONE", "TOTAL_BLOCK", "STRANGER", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum StrangerBannerType extends Enum<StrangerBannerType> {
    public static final StrangerBannerType NONE = null;
    public static final StrangerBannerType STRANGER = null;
    public static final StrangerBannerType TOTAL_BLOCK = null;
    public static final StrangerBannerType UNKNOWN = null;
    public static final /* synthetic */ StrangerBannerType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<StrangerBannerType> getEntries() {
        return b;
    }

    static {
        StrangerBannerType r0 = new StrangerBannerType("UNKNOWN", 0);
        UNKNOWN = r0;
        StrangerBannerType r1 = new StrangerBannerType("NONE", 1);
        NONE = r1;
        StrangerBannerType r3 = new StrangerBannerType("TOTAL_BLOCK", 2);
        TOTAL_BLOCK = r3;
        StrangerBannerType r5 = new StrangerBannerType("STRANGER", 3);
        STRANGER = r5;
        StrangerBannerType[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static StrangerBannerType[] values() {
        return (StrangerBannerType[]) a.clone();
    }

    public static StrangerBannerType valueOf(String r1) {
        return (StrangerBannerType) a.a(StrangerBannerType.class, r1);
    }

    public StrangerBannerType(String r1, int r2) {
        super(r1, r2);
    }
}
