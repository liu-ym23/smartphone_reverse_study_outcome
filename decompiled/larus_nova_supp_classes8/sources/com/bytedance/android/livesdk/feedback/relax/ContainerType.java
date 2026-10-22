package com.bytedance.android.livesdk.feedback.relax;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/feedback/relax/ContainerType;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "Small", "Big", "Four", "SmallScreenSmall", "SmallScreenBig", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ContainerType extends Enum<ContainerType> {
    public static final ContainerType Big = null;
    public static final ContainerType Four = null;
    public static final ContainerType Small = null;
    public static final ContainerType SmallScreenBig = null;
    public static final ContainerType SmallScreenSmall = null;
    public static final /* synthetic */ ContainerType[] a = null;
    private final String value;

    static {
        ContainerType r1 = new ContainerType("Small", 0, "small");
        Small = r1;
        ContainerType r2 = new ContainerType("Big", 1, "big");
        Big = r2;
        ContainerType r3 = new ContainerType("Four", 2, "four");
        Four = r3;
        ContainerType r4 = new ContainerType("SmallScreenSmall", 3, "smallScreenSmall");
        SmallScreenSmall = r4;
        ContainerType r5 = new ContainerType("SmallScreenBig", 4, "smallScreenBig");
        SmallScreenBig = r5;
        a = new ContainerType[]{r1, r2, r3, r4, r5};
    }

    public static ContainerType valueOf(String r1) {
        return (ContainerType) r27.a.a(ContainerType.class, r1);
    }

    public static ContainerType[] values() {
        return (ContainerType[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public ContainerType(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
