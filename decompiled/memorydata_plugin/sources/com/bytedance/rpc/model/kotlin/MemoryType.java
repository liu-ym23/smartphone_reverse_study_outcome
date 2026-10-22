package com.bytedance.rpc.model.kotlin;

import com.bytedance.crash.entity.EventBody;
import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0087\u0001\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/rpc/model/kotlin/MemoryType;", "", EventBody.KEY_VALUE, "", "(Ljava/lang/String;II)V", "getValue", "()I", "OBSERVATION", "REFLECTION", "DEFINED_MEMORY", "Companion", "com.bytedance.upc"}, k = 1, mv = {1, 1, 16})
public final enum MemoryType extends Enum<MemoryType> {
    private static final /* synthetic */ MemoryType[] $VALUES = null;
    public static final Companion Companion = null;

    @SerializedName("10001")
    public static final MemoryType DEFINED_MEMORY = null;

    @SerializedName("1")
    public static final MemoryType OBSERVATION = null;

    @SerializedName("2")
    public static final MemoryType REFLECTION = null;
    private final int value;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/bytedance/rpc/model/kotlin/MemoryType$Companion;", "", "()V", "findByValue", "Lcom/bytedance/rpc/model/kotlin/MemoryType;", "i", "", "com.bytedance.upc"}, k = 1, mv = {1, 1, 16})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        @JvmStatic
        public final MemoryType findByValue(int r1) {
            if (r1 == 1) goto L12;
            if (r1 == 2) goto L15;
            if (r1 == 10001) goto L14;
            return null;
        L14:
            return MemoryType.DEFINED_MEMORY;
        L15:
            return MemoryType.REFLECTION;
        L12:
            return MemoryType.OBSERVATION;
        }
    }

    static {
        MemoryType r1 = new MemoryType("OBSERVATION", 0, 1);
        OBSERVATION = r1;
        MemoryType r2 = new MemoryType("REFLECTION", 1, 2);
        REFLECTION = r2;
        MemoryType r3 = new MemoryType("DEFINED_MEMORY", 2, 10001);
        DEFINED_MEMORY = r3;
        $VALUES = new MemoryType[]{r1, r2, r3};
        Companion = new Companion(null);
    }

    private MemoryType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    @JvmStatic
    public static final MemoryType findByValue(int r1) {
        return Companion.findByValue(r1);
    }

    public static MemoryType valueOf(String r2) {
        return (MemoryType) ZeusTransformUtils.preCheckCast(Enum.valueOf(MemoryType.class, r2), MemoryType.class, "com.obric.memorydata.plugin");
    }

    public static MemoryType[] values() {
        return (MemoryType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), MemoryType[].class, "com.obric.memorydata.plugin");
    }

    public final int getValue() {
        return this.value;
    }
}
