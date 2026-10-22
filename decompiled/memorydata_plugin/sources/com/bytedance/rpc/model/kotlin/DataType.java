package com.bytedance.rpc.model.kotlin;

import com.bytedance.crash.entity.EventBody;
import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0087\u0001\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/bytedance/rpc/model/kotlin/DataType;", "", EventBody.KEY_VALUE, "", "(Ljava/lang/String;II)V", "getValue", "()I", "INT", "FLOAT", "BOOL", "STRING", "JSON", "Companion", "com.bytedance.upc"}, k = 1, mv = {1, 1, 16})
public final enum DataType extends Enum<DataType> {
    private static final /* synthetic */ DataType[] $VALUES = null;

    @SerializedName("2")
    public static final DataType BOOL = null;
    public static final Companion Companion = null;

    @SerializedName("1")
    public static final DataType FLOAT = null;

    @SerializedName("0")
    public static final DataType INT = null;

    @SerializedName("4")
    public static final DataType JSON = null;

    @SerializedName("3")
    public static final DataType STRING = null;
    private final int value;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/bytedance/rpc/model/kotlin/DataType$Companion;", "", "()V", "findByValue", "Lcom/bytedance/rpc/model/kotlin/DataType;", "i", "", "com.bytedance.upc"}, k = 1, mv = {1, 1, 16})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        @JvmStatic
        public final DataType findByValue(int r1) {
            if (r1 == 0) goto L17;
            if (r1 == 1) goto L22;
            if (r1 == 2) goto L21;
            if (r1 == 3) goto L20;
            if (r1 == 4) goto L19;
            return null;
        L19:
            return DataType.JSON;
        L20:
            return DataType.STRING;
        L21:
            return DataType.BOOL;
        L22:
            return DataType.FLOAT;
        L17:
            return DataType.INT;
        }
    }

    static {
        DataType r1 = new DataType("INT", 0, 0);
        INT = r1;
        DataType r2 = new DataType("FLOAT", 1, 1);
        FLOAT = r2;
        DataType r3 = new DataType("BOOL", 2, 2);
        BOOL = r3;
        DataType r4 = new DataType("STRING", 3, 3);
        STRING = r4;
        DataType r5 = new DataType("JSON", 4, 4);
        JSON = r5;
        $VALUES = new DataType[]{r1, r2, r3, r4, r5};
        Companion = new Companion(null);
    }

    private DataType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    @JvmStatic
    public static final DataType findByValue(int r1) {
        return Companion.findByValue(r1);
    }

    public static DataType valueOf(String r2) {
        return (DataType) ZeusTransformUtils.preCheckCast(Enum.valueOf(DataType.class, r2), DataType.class, "com.obric.memorydata.plugin");
    }

    public static DataType[] values() {
        return (DataType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), DataType[].class, "com.obric.memorydata.plugin");
    }

    public final int getValue() {
        return this.value;
    }
}
