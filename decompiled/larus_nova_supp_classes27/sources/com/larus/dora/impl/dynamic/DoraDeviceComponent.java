package com.larus.dora.impl.dynamic;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/dora/impl/dynamic/DoraDeviceComponent;", "", "<init>", "(Ljava/lang/String;I)V", "LEFT", "RIGHT", "BOX", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraDeviceComponent extends Enum<DoraDeviceComponent> {
    public static final DoraDeviceComponent BOX = null;
    public static final DoraDeviceComponent LEFT = null;
    public static final DoraDeviceComponent RIGHT = null;
    public static final /* synthetic */ DoraDeviceComponent[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<DoraDeviceComponent> getEntries() {
        return b;
    }

    static {
        DoraDeviceComponent r0 = new DoraDeviceComponent("LEFT", 0);
        LEFT = r0;
        DoraDeviceComponent r1 = new DoraDeviceComponent("RIGHT", 1);
        RIGHT = r1;
        DoraDeviceComponent r3 = new DoraDeviceComponent("BOX", 2);
        BOX = r3;
        DoraDeviceComponent[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static DoraDeviceComponent[] values() {
        return (DoraDeviceComponent[]) a.clone();
    }

    public static DoraDeviceComponent valueOf(String r1) {
        return (DoraDeviceComponent) r27.a.a(DoraDeviceComponent.class, r1);
    }

    public DoraDeviceComponent(String r1, int r2) {
        super(r1, r2);
    }
}
