package com.larus.avlink.activeSummary;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/avlink/activeSummary/ProactiveSummaryStartVuiStatus;", "", "code", "", "<init>", "(Ljava/lang/String;II)V", "getCode", "()I", "SUCCESS", "FAIL", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum ProactiveSummaryStartVuiStatus extends Enum<ProactiveSummaryStartVuiStatus> {
    public static final ProactiveSummaryStartVuiStatus FAIL = null;
    public static final ProactiveSummaryStartVuiStatus SUCCESS = null;
    public static final /* synthetic */ ProactiveSummaryStartVuiStatus[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int code;

    public static EnumEntries<ProactiveSummaryStartVuiStatus> getEntries() {
        return b;
    }

    static {
        ProactiveSummaryStartVuiStatus r0 = new ProactiveSummaryStartVuiStatus("SUCCESS", 0, 1);
        SUCCESS = r0;
        ProactiveSummaryStartVuiStatus r1 = new ProactiveSummaryStartVuiStatus("FAIL", 1, 0);
        FAIL = r1;
        ProactiveSummaryStartVuiStatus[] r4 = {r0, r1};
        a = r4;
        b = EnumEntriesKt.enumEntries(r4);
    }

    public static ProactiveSummaryStartVuiStatus[] values() {
        return (ProactiveSummaryStartVuiStatus[]) a.clone();
    }

    public final int getCode() {
        return this.code;
    }

    public static ProactiveSummaryStartVuiStatus valueOf(String r1) {
        return (ProactiveSummaryStartVuiStatus) r27.a.a(ProactiveSummaryStartVuiStatus.class, r1);
    }

    public ProactiveSummaryStartVuiStatus(String r1, int r2, int r3) {
        super(r1, r2);
        this.code = r3;
    }
}
