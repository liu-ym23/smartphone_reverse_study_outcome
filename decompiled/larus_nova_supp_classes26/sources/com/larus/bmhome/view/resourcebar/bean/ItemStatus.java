package com.larus.bmhome.view.resourcebar.bean;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/larus/bmhome/view/resourcebar/bean/ItemStatus;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UPLINKING", "UPLINK_SUCCESS", "UPLINK_FAILED", "PARSE_FAILED", "INSPECT_FAILED", "SUCCESS", "EXPIRED", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ItemStatus extends Enum<ItemStatus> {
    public static final ItemStatus EXPIRED = null;
    public static final ItemStatus INSPECT_FAILED = null;
    public static final ItemStatus PARSE_FAILED = null;
    public static final ItemStatus SUCCESS = null;
    public static final ItemStatus UPLINKING = null;
    public static final ItemStatus UPLINK_FAILED = null;
    public static final ItemStatus UPLINK_SUCCESS = null;
    public static final /* synthetic */ ItemStatus[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static EnumEntries<ItemStatus> getEntries() {
        return b;
    }

    static {
        ItemStatus r0 = new ItemStatus("UPLINKING", 0, 0);
        UPLINKING = r0;
        ItemStatus r1 = new ItemStatus("UPLINK_SUCCESS", 1, 1);
        UPLINK_SUCCESS = r1;
        ItemStatus r3 = new ItemStatus("UPLINK_FAILED", 2, 2);
        UPLINK_FAILED = r3;
        ItemStatus r5 = new ItemStatus("PARSE_FAILED", 3, 3);
        PARSE_FAILED = r5;
        ItemStatus r7 = new ItemStatus("INSPECT_FAILED", 4, 4);
        INSPECT_FAILED = r7;
        ItemStatus r9 = new ItemStatus("SUCCESS", 5, 5);
        SUCCESS = r9;
        ItemStatus r11 = new ItemStatus("EXPIRED", 6, 6);
        EXPIRED = r11;
        ItemStatus[] r13 = {r0, r1, r3, r5, r7, r9, r11};
        a = r13;
        b = EnumEntriesKt.enumEntries(r13);
    }

    public static ItemStatus[] values() {
        return (ItemStatus[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ItemStatus valueOf(String r1) {
        return (ItemStatus) a.a(ItemStatus.class, r1);
    }

    public ItemStatus(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
