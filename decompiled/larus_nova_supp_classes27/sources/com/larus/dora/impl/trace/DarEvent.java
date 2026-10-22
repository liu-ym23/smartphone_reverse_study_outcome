package com.larus.dora.impl.trace;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b+\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B=\b\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R&\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\r\"\u0004\b\u0017\u0010\u000fj\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2¨\u00063"}, d2 = {"Lcom/larus/dora/impl/trace/DarEvent;", "", "event", "", "type", "", "extra", "", "", "message", "<init>", "(Ljava/lang/String;ILjava/lang/String;ILjava/util/Map;Ljava/lang/String;)V", "getEvent", "()Ljava/lang/String;", "setEvent", "(Ljava/lang/String;)V", "getType", "()I", "getExtra", "()Ljava/util/Map;", "setExtra", "(Ljava/util/Map;)V", "getMessage", "setMessage", "BudsActive", "OtaCheckUpdateResult", "OtaUpdateBegin", "OtaUpdatePreCheckBegin", "OtaUpdatePreCheck", "OtaDownloadEnd", "OtaUpdateCheck", "OtaConnectEnd", "OtaTransferStart", "OtaTransferEnd", "OtaVerifyEnd", "OtaRebootEnd", "OtaUpdateEnd", "OtaRetry", "BtConnectStateChanged", "DoraLinkStateChanged", "CallBegin", "CallEnd", "BluetoothTurnOn", "BluetoothTurnOFF", "TWSDisconnected", "TWSConnected", "BoxOpen", "BoxClose", "OtaRoleChangeRetry", "BudsBusy", "BudsIdle", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DarEvent extends Enum<DarEvent> {
    public static final DarEvent BluetoothTurnOFF = null;
    public static final DarEvent BluetoothTurnOn = null;
    public static final DarEvent BoxClose = null;
    public static final DarEvent BoxOpen = null;
    public static final DarEvent BtConnectStateChanged = null;
    public static final DarEvent BudsActive = null;
    public static final DarEvent BudsBusy = null;
    public static final DarEvent BudsIdle = null;
    public static final DarEvent CallBegin = null;
    public static final DarEvent CallEnd = null;
    public static final DarEvent DoraLinkStateChanged = null;
    public static final DarEvent OtaCheckUpdateResult = null;
    public static final DarEvent OtaConnectEnd = null;
    public static final DarEvent OtaDownloadEnd = null;
    public static final DarEvent OtaRebootEnd = null;
    public static final DarEvent OtaRetry = null;
    public static final DarEvent OtaRoleChangeRetry = null;
    public static final DarEvent OtaTransferEnd = null;
    public static final DarEvent OtaTransferStart = null;
    public static final DarEvent OtaUpdateBegin = null;
    public static final DarEvent OtaUpdateCheck = null;
    public static final DarEvent OtaUpdateEnd = null;
    public static final DarEvent OtaUpdatePreCheck = null;
    public static final DarEvent OtaUpdatePreCheckBegin = null;
    public static final DarEvent OtaVerifyEnd = null;
    public static final DarEvent TWSConnected = null;
    public static final DarEvent TWSDisconnected = null;
    public static final /* synthetic */ DarEvent[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private String event;
    private Map<String, Object> extra;
    private String message;
    private final int type;

    public DarEvent() {
        throw null;
    }

    public static EnumEntries<DarEvent> getEntries() {
        return b;
    }

    static {
        Lazy<b> r0 = b.f;
        DarEvent r9 = new DarEvent("BudsActive", 0, "BudsActive", 0, null, null, 12, null);
        BudsActive = r9;
        DarEvent r1 = new DarEvent("OtaCheckUpdateResult", 1, "CheckUpdateResult", 0, null, null, 12, null);
        OtaCheckUpdateResult = r1;
        DarEvent r2 = new DarEvent("OtaUpdateBegin", 2, "UpdateBegin", 0, null, null, 12, null);
        OtaUpdateBegin = r2;
        DarEvent r3 = new DarEvent("OtaUpdatePreCheckBegin", 3, "UpdatePreCheckBegin", 0, null, null, 12, null);
        OtaUpdatePreCheckBegin = r3;
        DarEvent r4 = new DarEvent("OtaUpdatePreCheck", 4, "UpdatePreCheck", 0, null, null, 12, null);
        OtaUpdatePreCheck = r4;
        DarEvent r5 = new DarEvent("OtaDownloadEnd", 5, "OnDownloadEnd", 0, null, null, 12, null);
        OtaDownloadEnd = r5;
        DarEvent r6 = new DarEvent("OtaUpdateCheck", 6, "UpdateCheck", 0, null, null, 12, null);
        OtaUpdateCheck = r6;
        DarEvent r7 = new DarEvent("OtaConnectEnd", 7, "OnConnectEnd", 0, null, null, 12, null);
        OtaConnectEnd = r7;
        DarEvent r8 = new DarEvent("OtaTransferStart", 8, "OtaTransferStart", 0, null, null, 12, null);
        OtaTransferStart = r8;
        DarEvent r10 = new DarEvent("OtaTransferEnd", 9, "OnTransferEnd", 0, null, null, 12, null);
        OtaTransferEnd = r10;
        DarEvent r11 = new DarEvent("OtaVerifyEnd", 10, "OnVerifyEnd", 0, null, null, 12, null);
        OtaVerifyEnd = r11;
        DarEvent r20 = new DarEvent("OtaRebootEnd", 11, "OnRebootEnd", 0, null, null, 12, null);
        OtaRebootEnd = r20;
        int r12 = b.g;
        DarEvent r13 = new DarEvent("OtaUpdateEnd", 12, "OnUpdateEnd", r12, null, null, 12, null);
        OtaUpdateEnd = r13;
        DarEvent r14 = new DarEvent("OtaRetry", 13, "OnRetry", r12, null, null, 12, null);
        OtaRetry = r14;
        DarEvent r15 = new DarEvent("BtConnectStateChanged", 14, "BtConnectStateChanged", r12, null, null, 12, null);
        BtConnectStateChanged = r15;
        DarEvent r16 = new DarEvent("DoraLinkStateChanged", 15, "DoraLinkStateChanged", r12, null, null, 12, null);
        DoraLinkStateChanged = r16;
        int r17 = b.h;
        DarEvent r18 = new DarEvent("CallBegin", 16, "CallBegin", r17, null, null, 12, null);
        CallBegin = r18;
        DarEvent r110 = new DarEvent("CallEnd", 17, "CallEnd", r17, null, null, 12, null);
        CallEnd = r110;
        DarEvent r111 = new DarEvent("BluetoothTurnOn", 18, "BluetoothTurnOn", r17, null, null, 12, null);
        BluetoothTurnOn = r111;
        DarEvent r34 = new DarEvent("BluetoothTurnOFF", 19, "BluetoothTurnOFF", r17, null, null, 12, null);
        BluetoothTurnOFF = r34;
        DarEvent r112 = new DarEvent("TWSDisconnected", 20, "TWSDisconnected", r12, null, null, 12, null);
        TWSDisconnected = r112;
        DarEvent r21 = new DarEvent("TWSConnected", 21, "TWSConnected", r12, null, null, 12, null);
        TWSConnected = r21;
        DarEvent r22 = new DarEvent("BoxOpen", 22, "BoxOpen", r12, null, null, 12, null);
        BoxOpen = r22;
        DarEvent r23 = new DarEvent("BoxClose", 23, "BoxClose", r12, null, null, 12, null);
        BoxClose = r23;
        DarEvent r24 = new DarEvent("OtaRoleChangeRetry", 24, "OtaRoleChangeRetry", r12, null, null, 12, null);
        OtaRoleChangeRetry = r24;
        DarEvent r35 = new DarEvent("BudsBusy", 25, "BudsBusy", r12, null, null, 12, null);
        BudsBusy = r35;
        DarEvent r36 = new DarEvent("BudsIdle", 26, "BudsIdle", r12, null, null, 12, null);
        BudsIdle = r36;
        DarEvent[] r113 = {r9, r1, r2, r3, r4, r5, r6, r7, r8, r10, r11, r20, r13, r14, r15, r16, r18, r110, r111, r34, r112, r21, r22, r23, r24, r35, r36};
        a = r113;
        b = EnumEntriesKt.enumEntries(r113);
    }

    public static DarEvent[] values() {
        return (DarEvent[]) a.clone();
    }

    public final String getEvent() {
        return this.event;
    }

    public final Map<String, Object> getExtra() {
        return this.extra;
    }

    public final String getMessage() {
        return this.message;
    }

    public final int getType() {
        return this.type;
    }

    public static DarEvent valueOf(String r1) {
        return (DarEvent) r27.a.a(DarEvent.class, r1);
    }

    public final void setEvent(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.event = r2;
    }

    public final void setExtra(Map<String, Object> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.extra = r2;
    }

    public final void setMessage(String r1) {
        this.message = r1;
    }

    public DarEvent(String r2, int r3, String r4, int r5, Map r6, String r7, int r8, DefaultConstructorMarker r9) {
        if ((r8 & 1) == 0) goto L6;
        r4 = "";
    L6:
        if ((r8 & 4) == 0) goto L9;
        r6 = new LinkedHashMap();
    L9:
        if ((r8 & 8) == 0) goto L11;
        r7 = "";
    L11:
        super(r2, r3);
        this.event = r4;
        this.type = r5;
        this.extra = r6;
        this.message = r7;
    }
}
