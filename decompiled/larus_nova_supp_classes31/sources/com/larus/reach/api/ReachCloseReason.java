package com.larus.reach.api;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lcom/larus/reach/api/ReachCloseReason;", "", "closeType", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getCloseType", "()Ljava/lang/String;", "AUTO_DISMISS", "BUSINESS_NOT_ALLOWED", "SWIPE", "CLICK_CLOSE", "MESSAGE_DONE", "SEND_MESSAGE", "CLICK_DISMISSAL", "HOST_NOT_READY", "CLIENT_EXCEPTION", "PAGE_LEAVE", "REVOKED", "NEWER_ARRIVED", "api_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum ReachCloseReason extends Enum<ReachCloseReason> {
    public static final ReachCloseReason AUTO_DISMISS = null;
    public static final ReachCloseReason BUSINESS_NOT_ALLOWED = null;
    public static final ReachCloseReason CLICK_CLOSE = null;
    public static final ReachCloseReason CLICK_DISMISSAL = null;
    public static final ReachCloseReason CLIENT_EXCEPTION = null;
    public static final ReachCloseReason HOST_NOT_READY = null;
    public static final ReachCloseReason MESSAGE_DONE = null;
    public static final ReachCloseReason NEWER_ARRIVED = null;
    public static final ReachCloseReason PAGE_LEAVE = null;
    public static final ReachCloseReason REVOKED = null;
    public static final ReachCloseReason SEND_MESSAGE = null;
    public static final ReachCloseReason SWIPE = null;
    public static final /* synthetic */ ReachCloseReason[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String closeType;

    public static EnumEntries<ReachCloseReason> getEntries() {
        return b;
    }

    static {
        ReachCloseReason r0 = new ReachCloseReason("AUTO_DISMISS", 0, "auto_timeout");
        AUTO_DISMISS = r0;
        ReachCloseReason r1 = new ReachCloseReason("BUSINESS_NOT_ALLOWED", 1, "business_filtered");
        BUSINESS_NOT_ALLOWED = r1;
        ReachCloseReason r2 = new ReachCloseReason("SWIPE", 2, "swipe");
        SWIPE = r2;
        ReachCloseReason r4 = new ReachCloseReason("CLICK_CLOSE", 3, "click_close");
        CLICK_CLOSE = r4;
        ReachCloseReason r6 = new ReachCloseReason("MESSAGE_DONE", 4, "message_done");
        MESSAGE_DONE = r6;
        ReachCloseReason r8 = new ReachCloseReason("SEND_MESSAGE", 5, "send_message");
        SEND_MESSAGE = r8;
        ReachCloseReason r10 = new ReachCloseReason("CLICK_DISMISSAL", 6, "click_dismissal");
        CLICK_DISMISSAL = r10;
        ReachCloseReason r12 = new ReachCloseReason("HOST_NOT_READY", 7, "host_not_ready");
        HOST_NOT_READY = r12;
        ReachCloseReason r14 = new ReachCloseReason("CLIENT_EXCEPTION", 8, "client_exception");
        CLIENT_EXCEPTION = r14;
        ReachCloseReason r13 = new ReachCloseReason("PAGE_LEAVE", 9, "page_leave");
        PAGE_LEAVE = r13;
        ReachCloseReason r11 = new ReachCloseReason("REVOKED", 10, "revoked");
        REVOKED = r11;
        ReachCloseReason r9 = new ReachCloseReason("NEWER_ARRIVED", 11, "newer_arrived");
        NEWER_ARRIVED = r9;
        ReachCloseReason[] r7 = {r0, r1, r2, r4, r6, r8, r10, r12, r14, r13, r11, r9};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static ReachCloseReason[] values() {
        return (ReachCloseReason[]) a.clone();
    }

    public final String getCloseType() {
        return this.closeType;
    }

    public static ReachCloseReason valueOf(String r1) {
        return (ReachCloseReason) a.a(ReachCloseReason.class, r1);
    }

    public ReachCloseReason(String r1, int r2, String r3) {
        super(r1, r2);
        this.closeType = r3;
    }
}
