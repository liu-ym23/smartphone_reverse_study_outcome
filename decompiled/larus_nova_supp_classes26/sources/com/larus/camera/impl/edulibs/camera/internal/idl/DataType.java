package com.larus.camera.impl.edulibs.camera.internal.idl;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/larus/camera/impl/edulibs/camera/internal/idl/DataType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "FLOAT32", "INT32", "INT64", "UINT8", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DataType extends Enum<DataType> {
    public static final a Companion = null;

    @SerializedName("1")
    public static final DataType FLOAT32 = null;

    @SerializedName("2")
    public static final DataType INT32 = null;

    @SerializedName("3")
    public static final DataType INT64 = null;

    @SerializedName("4")
    public static final DataType UINT8 = null;
    public static final /* synthetic */ DataType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static EnumEntries<DataType> getEntries() {
        return b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.camera.impl.edulibs.camera.internal.idl.DataType$a] */
    static {
        DataType r0 = new DataType("FLOAT32", 0, 1);
        FLOAT32 = r0;
        DataType r1 = new DataType("INT32", 1, 2);
        INT32 = r1;
        DataType r4 = new DataType("INT64", 2, 3);
        INT64 = r4;
        DataType r6 = new DataType("UINT8", 3, 4);
        UINT8 = r6;
        DataType[] r8 = {r0, r1, r4, r6};
        a = r8;
        b = EnumEntriesKt.enumEntries(r8);
        Companion = new a();
    }

    public static DataType[] values() {
        return (DataType[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static DataType valueOf(String r1) {
        return (DataType) r27.a.a(DataType.class, r1);
    }

    public DataType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
