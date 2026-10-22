package com.larus.dora.impl.device.settings.lab;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\b"}, d2 = {"Lcom/larus/dora/impl/device/settings/lab/RTCTransportMode;", "", "<init>", "(Ljava/lang/String;I)V", "OFF", "BLUETOOTH", "WIFI", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum RTCTransportMode extends Enum<RTCTransportMode> {
    public static final RTCTransportMode BLUETOOTH = null;
    public static final a Companion = null;
    public static final RTCTransportMode OFF = null;
    public static final RTCTransportMode WIFI = null;
    public static final /* synthetic */ RTCTransportMode[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<RTCTransportMode> getEntries() {
        return b;
    }

    static {
        RTCTransportMode r0 = new RTCTransportMode("OFF", 0);
        OFF = r0;
        RTCTransportMode r1 = new RTCTransportMode("BLUETOOTH", 1);
        BLUETOOTH = r1;
        RTCTransportMode r3 = new RTCTransportMode("WIFI", 2);
        WIFI = r3;
        RTCTransportMode[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
        Companion = new a();
    }

    public static RTCTransportMode[] values() {
        return (RTCTransportMode[]) a.clone();
    }

    public static RTCTransportMode valueOf(String r1) {
        return (RTCTransportMode) r27.a.a(RTCTransportMode.class, r1);
    }

    public RTCTransportMode(String r1, int r2) {
        super(r1, r2);
    }
}
