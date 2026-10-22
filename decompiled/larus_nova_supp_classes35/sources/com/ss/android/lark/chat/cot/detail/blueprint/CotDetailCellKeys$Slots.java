package com.ss.android.lark.chat.cot.detail.blueprint;

import com.ss.android.lark.blueprint.v;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/chat/cot/detail/blueprint/CotDetailCellKeys$Slots;", "Lcom/ss/android/lark/blueprint/ISlotId;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "CONTENT", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CotDetailCellKeys$Slots extends Enum<CotDetailCellKeys$Slots> implements v {
    public static final CotDetailCellKeys$Slots CONTENT = null;
    public static final /* synthetic */ CotDetailCellKeys$Slots[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<CotDetailCellKeys$Slots> getEntries() {
        return b;
    }

    static {
        CotDetailCellKeys$Slots r0 = new CotDetailCellKeys$Slots();
        CONTENT = r0;
        CotDetailCellKeys$Slots[] r1 = {r0};
        a = r1;
        b = EnumEntriesKt.enumEntries(r1);
    }

    public CotDetailCellKeys$Slots() {
        super("CONTENT", 0);
    }

    public static CotDetailCellKeys$Slots[] values() {
        return (CotDetailCellKeys$Slots[]) a.clone();
    }

    public static CotDetailCellKeys$Slots valueOf(String r1) {
        return (CotDetailCellKeys$Slots) r27.a.a(CotDetailCellKeys$Slots.class, r1);
    }
}
