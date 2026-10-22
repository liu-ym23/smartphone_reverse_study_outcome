package com.bytedance.android.ec.core.hybrid.prefetch;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/ec/core/hybrid/prefetch/ParamsType;", "", "", com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE, "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "Header", "Params", "Data", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ParamsType extends Enum<ParamsType> {
    public static final ParamsType Data = null;
    public static final ParamsType Header = null;
    public static final ParamsType Params = null;
    public static final /* synthetic */ ParamsType[] a = null;
    private final String value;

    static {
        ParamsType r1 = new ParamsType("Header", 0, "header");
        Header = r1;
        ParamsType r10 = new ParamsType("Params", 1, "params");
        Params = r10;
        ParamsType r11 = new ParamsType("Data", 2, "data");
        Data = r11;
        a = new ParamsType[]{r1, r10, r11};
    }

    public static ParamsType valueOf(String r1) {
        return (ParamsType) r27.a.a(ParamsType.class, r1);
    }

    public static ParamsType[] values() {
        return (ParamsType[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public ParamsType(String r1, int r10, String r11) {
        super(r1, r10);
        this.value = r11;
    }
}
