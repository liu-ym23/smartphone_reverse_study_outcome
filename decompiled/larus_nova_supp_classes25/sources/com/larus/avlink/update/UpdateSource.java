package com.larus.avlink.update;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/avlink/update/UpdateSource;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "CHAT", "SETTING", "APPFOREGROUND", "OTHER", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum UpdateSource extends Enum<UpdateSource> {
    public static final UpdateSource APPFOREGROUND = null;
    public static final UpdateSource CHAT = null;
    public static final UpdateSource OTHER = null;
    public static final UpdateSource SETTING = null;
    public static final /* synthetic */ UpdateSource[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static EnumEntries<UpdateSource> getEntries() {
        return b;
    }

    static {
        UpdateSource r0 = new UpdateSource("CHAT", 0, 0);
        CHAT = r0;
        UpdateSource r1 = new UpdateSource("SETTING", 1, 1);
        SETTING = r1;
        UpdateSource r3 = new UpdateSource("APPFOREGROUND", 2, 2);
        APPFOREGROUND = r3;
        UpdateSource r5 = new UpdateSource("OTHER", 3, 3);
        OTHER = r5;
        UpdateSource[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static UpdateSource[] values() {
        return (UpdateSource[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static UpdateSource valueOf(String r1) {
        return (UpdateSource) r27.a.a(UpdateSource.class, r1);
    }

    public UpdateSource(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
