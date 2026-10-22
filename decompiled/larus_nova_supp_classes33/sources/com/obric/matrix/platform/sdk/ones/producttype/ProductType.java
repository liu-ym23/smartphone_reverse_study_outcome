package com.obric.matrix.platform.sdk.ones.producttype;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/producttype/ProductType;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "Companion", "a", "PACIFIC", "NERIDA", "PIKE", "UNKNOWN", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0})
public final enum ProductType extends Enum<ProductType> {
    public static final a Companion = null;
    public static final ProductType NERIDA = null;
    public static final ProductType PACIFIC = null;
    public static final ProductType PIKE = null;
    public static final ProductType UNKNOWN = null;
    public static final /* synthetic */ ProductType[] a = null;
    private final String value;

    public static ProductType valueOf(String r1) {
        return (ProductType) r27.a.a(ProductType.class, r1);
    }

    public static ProductType[] values() {
        return (ProductType[]) a.clone();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.obric.matrix.platform.sdk.ones.producttype.ProductType$a] */
    static {
        ProductType r0 = new ProductType("PACIFIC", 0, "pacific");
        PACIFIC = r0;
        ProductType r1 = new ProductType("NERIDA", 1, "nerida");
        NERIDA = r1;
        ProductType r3 = new ProductType("PIKE", 2, "pike");
        PIKE = r3;
        ProductType r5 = new ProductType("UNKNOWN", 3, "");
        UNKNOWN = r5;
        a = new ProductType[]{r0, r1, r3, r5};
        Companion = new a();
    }

    public final String getValue() {
        return this.value;
    }

    public ProductType(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
