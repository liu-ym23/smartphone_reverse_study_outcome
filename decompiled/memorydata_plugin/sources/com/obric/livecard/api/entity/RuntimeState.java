package com.obric.livecard.api.entity;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/obric/livecard/api/entity/RuntimeState;", "", "(Ljava/lang/String;I)V", "ANSWER", "PROCESSING", "PENDING", "FINISHED", "SINGLE", "LiveCard-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final enum RuntimeState extends Enum<RuntimeState> {
    private static final /* synthetic */ RuntimeState[] $VALUES = null;
    public static final RuntimeState ANSWER = null;
    public static final RuntimeState FINISHED = null;
    public static final RuntimeState PENDING = null;
    public static final RuntimeState PROCESSING = null;
    public static final RuntimeState SINGLE = null;

    private static final /* synthetic */ RuntimeState[] $values() {
        return new RuntimeState[]{ANSWER, PROCESSING, PENDING, FINISHED, SINGLE};
    }

    static {
        ANSWER = new RuntimeState("ANSWER", 0);
        PROCESSING = new RuntimeState("PROCESSING", 1);
        PENDING = new RuntimeState("PENDING", 2);
        FINISHED = new RuntimeState("FINISHED", 3);
        SINGLE = new RuntimeState("SINGLE", 4);
        $VALUES = $values();
    }

    private RuntimeState(String r1, int r2) {
        super(r1, r2);
    }

    public static RuntimeState valueOf(String r2) {
        return (RuntimeState) ZeusTransformUtils.preCheckCast(Enum.valueOf(RuntimeState.class, r2), RuntimeState.class, "com.obric.memorydata.plugin");
    }

    public static RuntimeState[] values() {
        return (RuntimeState[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), RuntimeState[].class, "com.obric.memorydata.plugin");
    }
}
