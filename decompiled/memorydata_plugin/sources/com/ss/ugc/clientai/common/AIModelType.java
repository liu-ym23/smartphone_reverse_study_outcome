package com.ss.ugc.clientai.common;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/ss/ugc/clientai/common/AIModelType;", "", "(Ljava/lang/String;I)V", "ByteNN", "Pitaya", "core-common_release"}, k = 1, mv = {1, 4, 1})
public final enum AIModelType extends Enum<AIModelType> {
    private static final /* synthetic */ AIModelType[] $VALUES = null;
    public static final AIModelType ByteNN = null;
    public static final AIModelType Pitaya = null;

    static {
        AIModelType r1 = new AIModelType("ByteNN", 0);
        ByteNN = r1;
        AIModelType r2 = new AIModelType("Pitaya", 1);
        Pitaya = r2;
        $VALUES = new AIModelType[]{r1, r2};
    }

    private AIModelType(String r1, int r2) {
        super(r1, r2);
    }

    public static AIModelType valueOf(String r2) {
        return (AIModelType) ZeusTransformUtils.preCheckCast(Enum.valueOf(AIModelType.class, r2), AIModelType.class, "com.obric.memorydata.plugin");
    }

    public static AIModelType[] values() {
        return (AIModelType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), AIModelType[].class, "com.obric.memorydata.plugin");
    }
}
