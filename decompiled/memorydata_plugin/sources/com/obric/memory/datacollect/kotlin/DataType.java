package com.obric.memory.datacollect.kotlin;

import com.bytedance.crash.entity.EventBody;
import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0087\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\n"}, d2 = {"Lcom/obric/memory/datacollect/kotlin/DataType;", "", EventBody.KEY_VALUE, "", "(Ljava/lang/String;II)V", "getValue", "()I", "WechatChat", "Common", "Companion", "com.bytedance.upc"}, k = 1, mv = {1, 1, 16})
public final enum DataType extends Enum<DataType> {
    private static final /* synthetic */ DataType[] $VALUES = null;

    @SerializedName("1")
    public static final DataType Common = null;
    public static final a Companion = null;

    @SerializedName("0")
    public static final DataType WechatChat = null;
    private final int value;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/obric/memory/datacollect/kotlin/DataType$Companion;", "", "()V", "findByValue", "Lcom/obric/memory/datacollect/kotlin/DataType;", "i", "", "com.bytedance.upc"}, k = 1, mv = {1, 1, 16})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        @JvmStatic
        public final DataType a(int r1) {
            if (r1 == 0) goto L8;
            if (r1 == 1) goto L10;
            return null;
        L10:
            return DataType.Common;
        L8:
            return DataType.WechatChat;
        }
    }

    static {
        DataType r1 = new DataType("WechatChat", 0, 0);
        WechatChat = r1;
        DataType r2 = new DataType("Common", 1, 1);
        Common = r2;
        $VALUES = new DataType[]{r1, r2};
        Companion = new a(null);
    }

    private DataType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    @JvmStatic
    public static final DataType findByValue(int r1) {
        return Companion.a(r1);
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
