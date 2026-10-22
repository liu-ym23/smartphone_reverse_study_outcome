package com.bytedance.android.livesdk.drawer.relax;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\t\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/drawer/relax/SugTextType;", "", "", "value", "J", "getValue", "()J", "Prefix", "Middle", "Suffix", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum SugTextType extends Enum<SugTextType> {
    public static final SugTextType Middle = null;
    public static final SugTextType Prefix = null;
    public static final SugTextType Suffix = null;
    public static final /* synthetic */ SugTextType[] a = null;
    private final long value;

    static {
        SugTextType r1 = new SugTextType("Prefix", 0, 0);
        Prefix = r1;
        SugTextType r2 = new SugTextType("Middle", 1, 1);
        Middle = r2;
        SugTextType r3 = new SugTextType("Suffix", 2, 2);
        Suffix = r3;
        a = new SugTextType[]{r1, r2, r3};
    }

    public static SugTextType valueOf(String r1) {
        return (SugTextType) r27.a.a(SugTextType.class, r1);
    }

    public static SugTextType[] values() {
        return (SugTextType[]) a.clone();
    }

    public final long getValue() {
        return this.value;
    }

    public SugTextType(String r1, int r2, long r3) {
        super(r1, r2);
        this.value = r3;
    }
}
