package com.larus.audio.call.common;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/audio/call/common/AvKitPlatform;", "", "osName", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getOsName$avkit_release", "()Ljava/lang/String;", "Android", "iOS", "HarmonyOS", "avkit_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum AvKitPlatform extends Enum<AvKitPlatform> {
    public static final AvKitPlatform Android = null;
    public static final AvKitPlatform HarmonyOS = null;
    public static final /* synthetic */ AvKitPlatform[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    public static final AvKitPlatform iOS = null;
    private final String osName;

    public static EnumEntries<AvKitPlatform> getEntries() {
        return b;
    }

    static {
        AvKitPlatform r0 = new AvKitPlatform("Android", 0, "Android");
        Android = r0;
        AvKitPlatform r1 = new AvKitPlatform("iOS", 1, "iOS");
        iOS = r1;
        AvKitPlatform r3 = new AvKitPlatform("HarmonyOS", 2, "openHarmony");
        HarmonyOS = r3;
        AvKitPlatform[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static AvKitPlatform[] values() {
        return (AvKitPlatform[]) a.clone();
    }

    public final String getOsName$avkit_release() {
        return this.osName;
    }

    public static AvKitPlatform valueOf(String r1) {
        return (AvKitPlatform) r27.a.a(AvKitPlatform.class, r1);
    }

    public AvKitPlatform(String r1, int r2, String r3) {
        super(r1, r2);
        this.osName = r3;
    }
}
