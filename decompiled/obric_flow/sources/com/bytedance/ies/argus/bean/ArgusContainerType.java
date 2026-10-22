package com.bytedance.ies.argus.bean;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ies/argus/bean/ArgusContainerType;", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final enum ArgusContainerType extends Enum<ArgusContainerType> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ArgusContainerType f5033a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ArgusContainerType f5034b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ ArgusContainerType[] f5035c = null;

    static {
        ArgusContainerType r5 = new ArgusContainerType("WEB", 0, "web");
        f5033a = r5;
        ArgusContainerType r10 = new ArgusContainerType("LYNX", 1, "lynx");
        f5034b = r10;
        f5035c = new ArgusContainerType[]{r5, r10};
    }

    public ArgusContainerType(String r5, int r10, String r11) {
        super(r5, r10);
    }

    public static ArgusContainerType valueOf(String r5) {
        return (ArgusContainerType) Enum.valueOf(ArgusContainerType.class, r5);
    }

    public static ArgusContainerType[] values() {
        return (ArgusContainerType[]) f5035c.clone();
    }
}
