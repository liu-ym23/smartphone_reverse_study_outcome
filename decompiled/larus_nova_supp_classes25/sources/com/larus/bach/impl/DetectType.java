package com.larus.bach.impl;

import com.larus.bmhome.chat.bean.SuggestActionType;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/larus/bach/impl/DetectType;", "", "<init>", "(Ljava/lang/String;I)V", SuggestActionType.AVATAR, "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum DetectType extends Enum<DetectType> {
    public static final DetectType AVATAR = null;
    public static final /* synthetic */ DetectType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<DetectType> getEntries() {
        return b;
    }

    static {
        DetectType r0 = new DetectType();
        AVATAR = r0;
        DetectType[] r1 = {r0};
        a = r1;
        b = EnumEntriesKt.enumEntries(r1);
    }

    public DetectType() {
        super(SuggestActionType.AVATAR, 0);
    }

    public static DetectType[] values() {
        return (DetectType[]) a.clone();
    }

    public static DetectType valueOf(String r1) {
        return (DetectType) r27.a.a(DetectType.class, r1);
    }
}
