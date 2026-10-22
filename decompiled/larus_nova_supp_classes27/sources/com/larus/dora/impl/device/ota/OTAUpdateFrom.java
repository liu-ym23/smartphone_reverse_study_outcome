package com.larus.dora.impl.device.ota;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/larus/dora/impl/device/ota/OTAUpdateFrom;", "", "scene", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getScene", "()Ljava/lang/String;", "UI", "StartAutoOta", "DoraLinkStateChanged", "BudsChanged", "AutoSwitch", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OTAUpdateFrom extends Enum<OTAUpdateFrom> {
    public static final OTAUpdateFrom AutoSwitch = null;
    public static final OTAUpdateFrom BudsChanged = null;
    public static final OTAUpdateFrom DoraLinkStateChanged = null;
    public static final OTAUpdateFrom StartAutoOta = null;
    public static final OTAUpdateFrom UI = null;
    public static final /* synthetic */ OTAUpdateFrom[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String scene;

    public static EnumEntries<OTAUpdateFrom> getEntries() {
        return b;
    }

    static {
        OTAUpdateFrom r0 = new OTAUpdateFrom("UI", 0, "UI");
        UI = r0;
        OTAUpdateFrom r1 = new OTAUpdateFrom("StartAutoOta", 1, "StartAutoOta");
        StartAutoOta = r1;
        OTAUpdateFrom r3 = new OTAUpdateFrom("DoraLinkStateChanged", 2, "onDoraLinkStateChanged");
        DoraLinkStateChanged = r3;
        OTAUpdateFrom r5 = new OTAUpdateFrom("BudsChanged", 3, "BudsChanged");
        BudsChanged = r5;
        OTAUpdateFrom r6 = new OTAUpdateFrom("AutoSwitch", 4, "AutoSwitch");
        AutoSwitch = r6;
        OTAUpdateFrom[] r9 = {r0, r1, r3, r5, r6};
        a = r9;
        b = EnumEntriesKt.enumEntries(r9);
    }

    public static OTAUpdateFrom[] values() {
        return (OTAUpdateFrom[]) a.clone();
    }

    public final String getScene() {
        return this.scene;
    }

    public static OTAUpdateFrom valueOf(String r1) {
        return (OTAUpdateFrom) r27.a.a(OTAUpdateFrom.class, r1);
    }

    public OTAUpdateFrom(String r1, int r2, String r3) {
        super(r1, r2);
        this.scene = r3;
    }
}
