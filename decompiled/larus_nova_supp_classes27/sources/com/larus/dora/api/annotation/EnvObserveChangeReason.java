package com.larus.dora.api.annotation;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/larus/dora/api/annotation/EnvObserveChangeReason;", "", "reason", "", "<init>", "(Ljava/lang/String;II)V", "getReason", "()I", "setReason", "(I)V", "SWITCH_CHANGE", "TIMER_CHANGE", "WIFI_CHANGE", "CONNECT_CHANGE", "DEVICE_CHANGE", "NETWORK_CHANGE", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum EnvObserveChangeReason extends Enum<EnvObserveChangeReason> {
    public static final EnvObserveChangeReason CONNECT_CHANGE = null;
    public static final EnvObserveChangeReason DEVICE_CHANGE = null;
    public static final EnvObserveChangeReason NETWORK_CHANGE = null;
    public static final EnvObserveChangeReason SWITCH_CHANGE = null;
    public static final EnvObserveChangeReason TIMER_CHANGE = null;
    public static final EnvObserveChangeReason WIFI_CHANGE = null;
    public static final /* synthetic */ EnvObserveChangeReason[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private int reason;

    public static EnumEntries<EnvObserveChangeReason> getEntries() {
        return b;
    }

    static {
        EnvObserveChangeReason r0 = new EnvObserveChangeReason("SWITCH_CHANGE", 0);
        SWITCH_CHANGE = r0;
        EnvObserveChangeReason r1 = new EnvObserveChangeReason("TIMER_CHANGE", 1);
        TIMER_CHANGE = r1;
        EnvObserveChangeReason r3 = new EnvObserveChangeReason("WIFI_CHANGE", 2);
        WIFI_CHANGE = r3;
        EnvObserveChangeReason r5 = new EnvObserveChangeReason("CONNECT_CHANGE", 3);
        CONNECT_CHANGE = r5;
        EnvObserveChangeReason r7 = new EnvObserveChangeReason("DEVICE_CHANGE", 4);
        DEVICE_CHANGE = r7;
        EnvObserveChangeReason r9 = new EnvObserveChangeReason("NETWORK_CHANGE", 5);
        NETWORK_CHANGE = r9;
        EnvObserveChangeReason[] r11 = {r0, r1, r3, r5, r7, r9};
        a = r11;
        b = EnumEntriesKt.enumEntries(r11);
    }

    public static EnvObserveChangeReason[] values() {
        return (EnvObserveChangeReason[]) a.clone();
    }

    public final int getReason() {
        return this.reason;
    }

    public static EnvObserveChangeReason valueOf(String r1) {
        return (EnvObserveChangeReason) a.a(EnvObserveChangeReason.class, r1);
    }

    public final void setReason(int r1) {
        this.reason = r1;
    }

    public EnvObserveChangeReason(String r1, int r2) {
        super(r1, r2);
        this.reason = 0;
    }
}
