package com.bytedance.rpc.model.kotlin;

import com.bytedance.crash.entity.EventBody;
import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0087\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\n"}, d2 = {"Lcom/bytedance/rpc/model/kotlin/CloudMemoryItemType;", "", EventBody.KEY_VALUE, "", "(Ljava/lang/String;II)V", "getValue", "()I", "CLIENT_SOURCE", "CLOUD_SOURCE", "Companion", "com.bytedance.upc"}, k = 1, mv = {1, 1, 16})
public final enum CloudMemoryItemType extends Enum<CloudMemoryItemType> {
    private static final /* synthetic */ CloudMemoryItemType[] $VALUES = null;

    @SerializedName("1")
    public static final CloudMemoryItemType CLIENT_SOURCE = null;

    @SerializedName("2")
    public static final CloudMemoryItemType CLOUD_SOURCE = null;
    public static final Companion Companion = null;
    private final int value;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/bytedance/rpc/model/kotlin/CloudMemoryItemType$Companion;", "", "()V", "findByValue", "Lcom/bytedance/rpc/model/kotlin/CloudMemoryItemType;", "i", "", "com.bytedance.upc"}, k = 1, mv = {1, 1, 16})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        @JvmStatic
        public final CloudMemoryItemType findByValue(int r1) {
            if (r1 == 1) goto L9;
            if (r1 == 2) goto L11;
            return null;
        L11:
            return CloudMemoryItemType.CLOUD_SOURCE;
        L9:
            return CloudMemoryItemType.CLIENT_SOURCE;
        }
    }

    static {
        CloudMemoryItemType r2 = new CloudMemoryItemType("CLIENT_SOURCE", 0, 1);
        CLIENT_SOURCE = r2;
        CloudMemoryItemType r3 = new CloudMemoryItemType("CLOUD_SOURCE", 1, 2);
        CLOUD_SOURCE = r3;
        $VALUES = new CloudMemoryItemType[]{r2, r3};
        Companion = new Companion(null);
    }

    private CloudMemoryItemType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    @JvmStatic
    public static final CloudMemoryItemType findByValue(int r1) {
        return Companion.findByValue(r1);
    }

    public static CloudMemoryItemType valueOf(String r2) {
        return (CloudMemoryItemType) ZeusTransformUtils.preCheckCast(Enum.valueOf(CloudMemoryItemType.class, r2), CloudMemoryItemType.class, "com.obric.memorydata.plugin");
    }

    public static CloudMemoryItemType[] values() {
        return (CloudMemoryItemType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), CloudMemoryItemType[].class, "com.obric.memorydata.plugin");
    }

    public final int getValue() {
        return this.value;
    }
}
