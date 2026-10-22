package com.bytedance.ies.argus.base;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"com/bytedance/ies/argus/base/ArgusInitializer$ResourceType", "", "Lcom/bytedance/ies/argus/base/ArgusInitializer$ResourceType;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final enum ArgusInitializer$ResourceType extends Enum<ArgusInitializer$ResourceType> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ArgusInitializer$ResourceType f4999b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ArgusInitializer$ResourceType f5000c = null;
    public static final ArgusInitializer$ResourceType d = null;
    public static final ArgusInitializer$ResourceType e = null;
    public static final /* synthetic */ ArgusInitializer$ResourceType[] f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5001a;

    static {
        ArgusInitializer$ResourceType r5 = new ArgusInitializer$ResourceType("TEMPLATE", 0, "template");
        f4999b = r5;
        ArgusInitializer$ResourceType r10 = new ArgusInitializer$ResourceType("HTML", 1, "html");
        f5000c = r10;
        ArgusInitializer$ResourceType r11 = new ArgusInitializer$ResourceType("IMAGE", 2, "img");
        ArgusInitializer$ResourceType r12 = new ArgusInitializer$ResourceType("VIDEO", 3, "video");
        ArgusInitializer$ResourceType r13 = new ArgusInitializer$ResourceType("FILE", 4, "file");
        d = r13;
        ArgusInitializer$ResourceType r14 = new ArgusInitializer$ResourceType("OTHER", 5, "other");
        e = r14;
        f = new ArgusInitializer$ResourceType[]{r5, r10, r11, r12, r13, r14};
    }

    public ArgusInitializer$ResourceType(String r5, int r10, String r11) {
        super(r5, r10);
        this.f5001a = r11;
    }

    public static ArgusInitializer$ResourceType valueOf(String r5) {
        return (ArgusInitializer$ResourceType) Enum.valueOf(ArgusInitializer$ResourceType.class, r5);
    }

    public static ArgusInitializer$ResourceType[] values() {
        return (ArgusInitializer$ResourceType[]) f.clone();
    }
}
