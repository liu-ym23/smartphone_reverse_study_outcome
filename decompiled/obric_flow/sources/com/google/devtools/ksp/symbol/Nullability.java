package com.google.devtools.ksp.symbol;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/google/devtools/ksp/symbol/Nullability;", "", "NULLABLE", "NOT_NULL", "PLATFORM", "api"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final enum Nullability extends Enum<Nullability> {
    public static final Nullability NOT_NULL = null;
    public static final Nullability NULLABLE = null;
    public static final Nullability PLATFORM = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Nullability[] f9454a = null;

    static {
        Nullability r5 = new Nullability("NULLABLE", 0);
        NULLABLE = r5;
        Nullability r10 = new Nullability("NOT_NULL", 1);
        NOT_NULL = r10;
        Nullability r11 = new Nullability("PLATFORM", 2);
        PLATFORM = r11;
        f9454a = new Nullability[]{r5, r10, r11};
    }

    public static Nullability valueOf(String r5) {
        return (Nullability) Enum.valueOf(Nullability.class, r5);
    }

    public static Nullability[] values() {
        return (Nullability[]) f9454a.clone();
    }
}
