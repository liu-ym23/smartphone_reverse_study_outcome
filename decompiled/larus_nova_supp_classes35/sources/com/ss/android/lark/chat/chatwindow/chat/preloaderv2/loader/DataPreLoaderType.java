package com.ss.android.lark.chat.chatwindow.chat.preloaderv2.loader;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/preloaderv2/loader/DataPreLoaderType;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "CHAT_DATA", "CHAT_WINDOW", "CHAT_DESTINATION", "TEAM_VISITOR_CHAT", "MY_AI_THREAD", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DataPreLoaderType extends Enum<DataPreLoaderType> {
    public static final DataPreLoaderType CHAT_DATA = null;
    public static final DataPreLoaderType CHAT_DESTINATION = null;
    public static final DataPreLoaderType CHAT_WINDOW = null;
    public static final DataPreLoaderType MY_AI_THREAD = null;
    public static final DataPreLoaderType TEAM_VISITOR_CHAT = null;
    public static final /* synthetic */ DataPreLoaderType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<DataPreLoaderType> getEntries() {
        return b;
    }

    static {
        DataPreLoaderType r0 = new DataPreLoaderType("CHAT_DATA", 0);
        CHAT_DATA = r0;
        DataPreLoaderType r1 = new DataPreLoaderType("CHAT_WINDOW", 1);
        CHAT_WINDOW = r1;
        DataPreLoaderType r3 = new DataPreLoaderType("CHAT_DESTINATION", 2);
        CHAT_DESTINATION = r3;
        DataPreLoaderType r5 = new DataPreLoaderType("TEAM_VISITOR_CHAT", 3);
        TEAM_VISITOR_CHAT = r5;
        DataPreLoaderType r7 = new DataPreLoaderType("MY_AI_THREAD", 4);
        MY_AI_THREAD = r7;
        DataPreLoaderType[] r9 = {r0, r1, r3, r5, r7};
        a = r9;
        b = EnumEntriesKt.enumEntries(r9);
    }

    public static DataPreLoaderType[] values() {
        return (DataPreLoaderType[]) a.clone();
    }

    public static DataPreLoaderType valueOf(String r1) {
        return (DataPreLoaderType) r27.a.a(DataPreLoaderType.class, r1);
    }

    public DataPreLoaderType(String r1, int r2) {
        super(r1, r2);
    }
}
