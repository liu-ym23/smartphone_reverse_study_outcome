package com.bytedance.android.monitorV2.dataprocessor;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"com/bytedance/android/monitorV2/dataprocessor/TypedDataDispatcher$DataType", "", "Lcom/bytedance/android/monitorV2/dataprocessor/TypedDataDispatcher$DataType;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final enum TypedDataDispatcher$DataType extends Enum<TypedDataDispatcher$DataType> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TypedDataDispatcher$DataType f3525a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final TypedDataDispatcher$DataType f3526b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final TypedDataDispatcher$DataType f3527c = null;
    public static final /* synthetic */ TypedDataDispatcher$DataType[] d = null;

    static {
        TypedDataDispatcher$DataType r5 = new TypedDataDispatcher$DataType("WEB_VIEW", 0);
        f3525a = r5;
        TypedDataDispatcher$DataType r10 = new TypedDataDispatcher$DataType("LYNX_VIEW", 1);
        f3526b = r10;
        TypedDataDispatcher$DataType r11 = new TypedDataDispatcher$DataType("REPORT_DATA", 2);
        f3527c = r11;
        d = new TypedDataDispatcher$DataType[]{r5, r10, r11};
    }

    public TypedDataDispatcher$DataType(String r5, int r10) {
        super(r5, r10);
    }

    public static TypedDataDispatcher$DataType valueOf(String r5) {
        return (TypedDataDispatcher$DataType) Enum.valueOf(TypedDataDispatcher$DataType.class, r5);
    }

    public static TypedDataDispatcher$DataType[] values() {
        return (TypedDataDispatcher$DataType[]) d.clone();
    }
}
