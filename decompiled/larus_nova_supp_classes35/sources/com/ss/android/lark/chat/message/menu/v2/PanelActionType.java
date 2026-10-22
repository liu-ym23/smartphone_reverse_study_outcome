package com.ss.android.lark.chat.message.menu.v2;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/chat/message/menu/v2/PanelActionType;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "ALL_ACTION", "PARTIAL_ACTION", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PanelActionType extends Enum<PanelActionType> {
    public static final PanelActionType ALL_ACTION = null;
    public static final PanelActionType PARTIAL_ACTION = null;
    public static final /* synthetic */ PanelActionType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<PanelActionType> getEntries() {
        return b;
    }

    static {
        PanelActionType r0 = new PanelActionType("ALL_ACTION", 0);
        ALL_ACTION = r0;
        PanelActionType r1 = new PanelActionType("PARTIAL_ACTION", 1);
        PARTIAL_ACTION = r1;
        PanelActionType[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static PanelActionType[] values() {
        return (PanelActionType[]) a.clone();
    }

    public static PanelActionType valueOf(String r1) {
        return (PanelActionType) r27.a.a(PanelActionType.class, r1);
    }

    public PanelActionType(String r1, int r2) {
        super(r1, r2);
    }
}
