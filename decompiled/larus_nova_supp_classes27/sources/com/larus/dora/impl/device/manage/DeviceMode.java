package com.larus.dora.impl.device.manage;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u001b\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/larus/dora/impl/device/manage/DeviceMode;", "", "modeName", "", "isHighlight", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;Z)V", "getModeName", "()Ljava/lang/String;", "()Z", "NORMAL", "EARPHONE", "VIDEO_CALL", "INTERPRET", "RECORDING", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DeviceMode extends Enum<DeviceMode> {
    public static final DeviceMode EARPHONE = null;
    public static final DeviceMode INTERPRET = null;
    public static final DeviceMode NORMAL = null;
    public static final DeviceMode RECORDING = null;
    public static final DeviceMode VIDEO_CALL = null;
    public static final /* synthetic */ DeviceMode[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final boolean isHighlight;
    private final String modeName;

    public static EnumEntries<DeviceMode> getEntries() {
        return b;
    }

    static {
        int r0 = com.larus.utils.j0.a;
        DeviceMode r7 = new DeviceMode("NORMAL", 0, com.larus.utils.j0.d(2131902454), false, 2, null);
        NORMAL = r7;
        DeviceMode r1 = new DeviceMode("EARPHONE", 1, com.larus.utils.j0.d(2131903018), false, 2, null);
        EARPHONE = r1;
        DeviceMode r2 = new DeviceMode("VIDEO_CALL", 2, com.larus.utils.j0.d(2131900525), true);
        VIDEO_CALL = r2;
        DeviceMode r3 = new DeviceMode("INTERPRET", 3, com.larus.utils.j0.d(2131902683), true);
        INTERPRET = r3;
        DeviceMode r4 = new DeviceMode("RECORDING", 4, com.larus.utils.j0.d(2131902639), true);
        RECORDING = r4;
        DeviceMode[] r6 = {r7, r1, r2, r3, r4};
        a = r6;
        b = EnumEntriesKt.enumEntries(r6);
    }

    public static DeviceMode[] values() {
        return (DeviceMode[]) a.clone();
    }

    public final String getModeName() {
        return this.modeName;
    }

    public final boolean isHighlight() {
        return this.isHighlight;
    }

    public static DeviceMode valueOf(String r1) {
        return (DeviceMode) r27.a.a(DeviceMode.class, r1);
    }

    public DeviceMode(String r1, int r2, String r3, boolean r4) {
        super(r1, r2);
        this.modeName = r3;
        this.isHighlight = r4;
    }

    public /* synthetic */ DeviceMode(String r1, int r2, String r3, boolean r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 2) == 0) goto L5;
        r4 = false;
    L5:
        this(r1, r2, r3, r4);
    }
}
