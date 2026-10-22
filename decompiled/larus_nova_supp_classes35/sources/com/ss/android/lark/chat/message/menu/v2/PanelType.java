package com.ss.android.lark.chat.message.menu.v2;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/chat/message/menu/v2/PanelType;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "EMOJI", "ACTION", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PanelType extends Enum<PanelType> {
    public static final PanelType ACTION = null;
    public static final PanelType EMOJI = null;
    public static final /* synthetic */ PanelType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<PanelType> getEntries() {
        return b;
    }

    static {
        PanelType r0 = new PanelType("EMOJI", 0);
        EMOJI = r0;
        PanelType r1 = new PanelType("ACTION", 1);
        ACTION = r1;
        PanelType[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static PanelType[] values() {
        return (PanelType[]) a.clone();
    }

    public static PanelType valueOf(String r1) {
        return (PanelType) r27.a.a(PanelType.class, r1);
    }

    public PanelType(String r1, int r2) {
        super(r1, r2);
    }
}
