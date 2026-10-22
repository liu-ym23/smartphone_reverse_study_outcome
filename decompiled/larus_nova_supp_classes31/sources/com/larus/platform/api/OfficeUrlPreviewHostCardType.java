package com.larus.platform.api;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/platform/api/OfficeUrlPreviewHostCardType;", "", "<init>", "(Ljava/lang/String;I)V", "DEFAULT", "COMPACT", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum OfficeUrlPreviewHostCardType extends Enum<OfficeUrlPreviewHostCardType> {
    public static final OfficeUrlPreviewHostCardType COMPACT = null;
    public static final OfficeUrlPreviewHostCardType DEFAULT = null;
    public static final /* synthetic */ OfficeUrlPreviewHostCardType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<OfficeUrlPreviewHostCardType> getEntries() {
        return b;
    }

    static {
        OfficeUrlPreviewHostCardType r0 = new OfficeUrlPreviewHostCardType("DEFAULT", 0);
        DEFAULT = r0;
        OfficeUrlPreviewHostCardType r1 = new OfficeUrlPreviewHostCardType("COMPACT", 1);
        COMPACT = r1;
        OfficeUrlPreviewHostCardType[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static OfficeUrlPreviewHostCardType[] values() {
        return (OfficeUrlPreviewHostCardType[]) a.clone();
    }

    public static OfficeUrlPreviewHostCardType valueOf(String r1) {
        return (OfficeUrlPreviewHostCardType) r27.a.a(OfficeUrlPreviewHostCardType.class, r1);
    }

    public OfficeUrlPreviewHostCardType(String r1, int r2) {
        super(r1, r2);
    }
}
