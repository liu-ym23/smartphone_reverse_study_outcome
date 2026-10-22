package com.larus.bmhome.chat.banner;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/bmhome/chat/banner/ActiveSwitchBannerIconType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "Default", "Percent", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum ActiveSwitchBannerIconType extends Enum<ActiveSwitchBannerIconType> {
    public static final ActiveSwitchBannerIconType Default = null;
    public static final ActiveSwitchBannerIconType Percent = null;
    public static final /* synthetic */ ActiveSwitchBannerIconType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static EnumEntries<ActiveSwitchBannerIconType> getEntries() {
        return b;
    }

    static {
        ActiveSwitchBannerIconType r0 = new ActiveSwitchBannerIconType("Default", 0, 0);
        Default = r0;
        ActiveSwitchBannerIconType r1 = new ActiveSwitchBannerIconType("Percent", 1, 1);
        Percent = r1;
        ActiveSwitchBannerIconType[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static ActiveSwitchBannerIconType[] values() {
        return (ActiveSwitchBannerIconType[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ActiveSwitchBannerIconType valueOf(String r1) {
        return (ActiveSwitchBannerIconType) a.a(ActiveSwitchBannerIconType.class, r1);
    }

    public ActiveSwitchBannerIconType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
