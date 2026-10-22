package com.larus.agents.impl.webfetch;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/agents/impl/webfetch/WebFetchReportAck;", "", "<init>", "(Ljava/lang/String;I)V", "ACCEPTED", "RETRYABLE", "REJECTED", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum WebFetchReportAck extends Enum<WebFetchReportAck> {
    public static final WebFetchReportAck ACCEPTED = null;
    public static final WebFetchReportAck REJECTED = null;
    public static final WebFetchReportAck RETRYABLE = null;
    public static final /* synthetic */ WebFetchReportAck[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<WebFetchReportAck> getEntries() {
        return b;
    }

    static {
        WebFetchReportAck r0 = new WebFetchReportAck("ACCEPTED", 0);
        ACCEPTED = r0;
        WebFetchReportAck r1 = new WebFetchReportAck("RETRYABLE", 1);
        RETRYABLE = r1;
        WebFetchReportAck r3 = new WebFetchReportAck("REJECTED", 2);
        REJECTED = r3;
        WebFetchReportAck[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static WebFetchReportAck[] values() {
        return (WebFetchReportAck[]) a.clone();
    }

    public static WebFetchReportAck valueOf(String r1) {
        return (WebFetchReportAck) a.a(WebFetchReportAck.class, r1);
    }

    public WebFetchReportAck(String r1, int r2) {
        super(r1, r2);
    }
}
