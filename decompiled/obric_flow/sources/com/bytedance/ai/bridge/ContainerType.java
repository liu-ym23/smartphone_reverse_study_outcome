package com.bytedance.ai.bridge;

import kotlin.Metadata;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ai/bridge/ContainerType;", "", "applet-bridge_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum ContainerType extends Enum<ContainerType> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ContainerType f1800b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ContainerType f1801c = null;
    public static final ContainerType d = null;
    public static final ContainerType e = null;
    public static final /* synthetic */ ContainerType[] f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1802a;

    static {
        ContainerType r5 = new ContainerType("WIDGET", 0, "widget");
        f1800b = r5;
        ContainerType r10 = new ContainerType("PAGE", 1, "page");
        f1801c = r10;
        ContainerType r11 = new ContainerType("WORKER", 2, "worker");
        d = r11;
        ContainerType r12 = new ContainerType("NONE", 3, "unknown");
        e = r12;
        ContainerType[] r13 = {r5, r10, r11, r12};
        f = r13;
        EnumEntriesKt.enumEntries(r13);
    }

    public ContainerType(String r5, int r10, String r11) {
        super(r5, r10);
        this.f1802a = r11;
    }

    public static ContainerType valueOf(String r5) {
        return (ContainerType) Enum.valueOf(ContainerType.class, r5);
    }

    public static ContainerType[] values() {
        return (ContainerType[]) f.clone();
    }
}
