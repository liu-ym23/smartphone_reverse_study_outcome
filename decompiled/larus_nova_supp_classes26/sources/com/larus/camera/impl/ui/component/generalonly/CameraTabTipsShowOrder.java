package com.larus.camera.impl.ui.component.generalonly;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/larus/camera/impl/ui/component/generalonly/CameraTabTipsShowOrder;", "", "type", "", "mobStr", "", "<init>", "(Ljava/lang/String;IILjava/lang/String;)V", "getType", "()I", "getMobStr", "()Ljava/lang/String;", "ORDER", "RANDOM", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CameraTabTipsShowOrder extends Enum<CameraTabTipsShowOrder> {
    public static final CameraTabTipsShowOrder ORDER = null;
    public static final CameraTabTipsShowOrder RANDOM = null;
    public static final /* synthetic */ CameraTabTipsShowOrder[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String mobStr;
    private final int type;

    public static EnumEntries<CameraTabTipsShowOrder> getEntries() {
        return b;
    }

    static {
        CameraTabTipsShowOrder r0 = new CameraTabTipsShowOrder("ORDER", 0, 0, "order");
        ORDER = r0;
        CameraTabTipsShowOrder r1 = new CameraTabTipsShowOrder("RANDOM", 1, 1, "random");
        RANDOM = r1;
        CameraTabTipsShowOrder[] r2 = {r0, r1};
        a = r2;
        b = EnumEntriesKt.enumEntries(r2);
    }

    public static CameraTabTipsShowOrder[] values() {
        return (CameraTabTipsShowOrder[]) a.clone();
    }

    public final String getMobStr() {
        return this.mobStr;
    }

    public final int getType() {
        return this.type;
    }

    public static CameraTabTipsShowOrder valueOf(String r1) {
        return (CameraTabTipsShowOrder) r27.a.a(CameraTabTipsShowOrder.class, r1);
    }

    public CameraTabTipsShowOrder(String r1, int r2, int r3, String r4) {
        super(r1, r2);
        this.type = r3;
        this.mobStr = r4;
    }
}
