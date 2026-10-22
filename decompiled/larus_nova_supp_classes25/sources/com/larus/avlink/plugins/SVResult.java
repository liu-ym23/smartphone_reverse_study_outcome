package com.larus.avlink.plugins;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/avlink/plugins/SVResult;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "NONE", "TRUE", "FALSE", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum SVResult extends Enum<SVResult> {
    public static final SVResult FALSE = null;
    public static final SVResult NONE = null;
    public static final SVResult TRUE = null;
    public static final /* synthetic */ SVResult[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String value;

    public static EnumEntries<SVResult> getEntries() {
        return b;
    }

    static {
        SVResult r0 = new SVResult("NONE", 0, "none");
        NONE = r0;
        SVResult r1 = new SVResult("TRUE", 1, "true");
        TRUE = r1;
        SVResult r2 = new SVResult("FALSE", 2, "false");
        FALSE = r2;
        SVResult[] r4 = {r0, r1, r2};
        a = r4;
        b = EnumEntriesKt.enumEntries(r4);
    }

    public static SVResult[] values() {
        return (SVResult[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static SVResult valueOf(String r1) {
        return (SVResult) r27.a.a(SVResult.class, r1);
    }

    public SVResult(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
