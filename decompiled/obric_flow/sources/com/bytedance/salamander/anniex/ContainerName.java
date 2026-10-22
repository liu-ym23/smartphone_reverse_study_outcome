package com.bytedance.salamander.anniex;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/salamander/anniex/ContainerName;", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final enum ContainerName extends Enum<ContainerName> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ContainerName f7212a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ ContainerName[] f7213b = null;

    static {
        ContainerName r5 = new ContainerName();
        f7212a = r5;
        f7213b = new ContainerName[]{r5};
    }

    public ContainerName() {
        super("AnnieX", 0);
    }

    public static ContainerName valueOf(String r5) {
        return (ContainerName) Enum.valueOf(ContainerName.class, r5);
    }

    public static ContainerName[] values() {
        return (ContainerName[]) f7213b.clone();
    }
}
