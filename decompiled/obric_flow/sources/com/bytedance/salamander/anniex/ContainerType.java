package com.bytedance.salamander.anniex;

import com.bytedance.lynx.service.monitor.LynxMonitorService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/salamander/anniex/ContainerType;", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final enum ContainerType extends Enum<ContainerType> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ContainerType f7214a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ContainerType f7215b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ ContainerType[] f7216c = null;

    static {
        ContainerType r5 = new ContainerType(LynxMonitorService.DEFAULT_PID, 0);
        f7214a = r5;
        ContainerType r10 = new ContainerType("Web", 1);
        f7215b = r10;
        f7216c = new ContainerType[]{r5, r10, new ContainerType("Unknown", 2)};
    }

    public ContainerType(String r5, int r10) {
        super(r5, r10);
    }

    public static ContainerType valueOf(String r5) {
        return (ContainerType) Enum.valueOf(ContainerType.class, r5);
    }

    public static ContainerType[] values() {
        return (ContainerType[]) f7216c.clone();
    }
}
