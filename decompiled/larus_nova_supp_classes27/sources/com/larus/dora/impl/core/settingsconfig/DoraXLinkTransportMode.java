package com.larus.dora.impl.core.settingsconfig;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\b"}, d2 = {"Lcom/larus/dora/impl/core/settingsconfig/DoraXLinkTransportMode;", "", "<init>", "(Ljava/lang/String;I)V", "OFF", "BLUETOOTH", "WIFI", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraXLinkTransportMode extends Enum<DoraXLinkTransportMode> {
    public static final DoraXLinkTransportMode BLUETOOTH = null;
    public static final a Companion = null;
    public static final DoraXLinkTransportMode OFF = null;
    public static final DoraXLinkTransportMode WIFI = null;
    public static final /* synthetic */ DoraXLinkTransportMode[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<DoraXLinkTransportMode> getEntries() {
        return b;
    }

    static {
        DoraXLinkTransportMode r0 = new DoraXLinkTransportMode("OFF", 0);
        OFF = r0;
        DoraXLinkTransportMode r1 = new DoraXLinkTransportMode("BLUETOOTH", 1);
        BLUETOOTH = r1;
        DoraXLinkTransportMode r3 = new DoraXLinkTransportMode("WIFI", 2);
        WIFI = r3;
        DoraXLinkTransportMode[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
        Companion = new a();
    }

    public static DoraXLinkTransportMode[] values() {
        return (DoraXLinkTransportMode[]) a.clone();
    }

    public static DoraXLinkTransportMode valueOf(String r1) {
        return (DoraXLinkTransportMode) r27.a.a(DoraXLinkTransportMode.class, r1);
    }

    public DoraXLinkTransportMode(String r1, int r2) {
        super(r1, r2);
    }
}
