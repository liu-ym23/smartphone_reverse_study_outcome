package com.obric.livecard.api.entity;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/livecard/api/entity/SceneType;", "", "(Ljava/lang/String;I)V", "AI_SUGGESTION", "AI_TASK", "NOTIFICATION", "LiveCard-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final enum SceneType extends Enum<SceneType> {
    private static final /* synthetic */ SceneType[] $VALUES = null;
    public static final SceneType AI_SUGGESTION = null;
    public static final SceneType AI_TASK = null;
    public static final SceneType NOTIFICATION = null;

    private static final /* synthetic */ SceneType[] $values() {
        return new SceneType[]{AI_SUGGESTION, AI_TASK, NOTIFICATION};
    }

    static {
        AI_SUGGESTION = new SceneType("AI_SUGGESTION", 0);
        AI_TASK = new SceneType("AI_TASK", 1);
        NOTIFICATION = new SceneType("NOTIFICATION", 2);
        $VALUES = $values();
    }

    private SceneType(String r1, int r2) {
        super(r1, r2);
    }

    public static SceneType valueOf(String r2) {
        return (SceneType) ZeusTransformUtils.preCheckCast(Enum.valueOf(SceneType.class, r2), SceneType.class, "com.obric.memorydata.plugin");
    }

    public static SceneType[] values() {
        return (SceneType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), SceneType[].class, "com.obric.memorydata.plugin");
    }
}
