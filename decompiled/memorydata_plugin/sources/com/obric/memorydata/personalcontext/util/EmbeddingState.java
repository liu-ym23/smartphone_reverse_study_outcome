package com.obric.memorydata.personalcontext.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/obric/memorydata/personalcontext/util/EmbeddingState;", "", "code", "", "<init>", "(Ljava/lang/String;II)V", "getCode", "()I", "USE_VLM", "USE_LITTLE_MODEL", "USE_VLM_AND_LITTLE_MODEL", "personal_context_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum EmbeddingState extends Enum<EmbeddingState> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ EmbeddingState[] $VALUES = null;
    public static final EmbeddingState USE_LITTLE_MODEL = null;
    public static final EmbeddingState USE_VLM = null;
    public static final EmbeddingState USE_VLM_AND_LITTLE_MODEL = null;
    private final int code;

    private static final /* synthetic */ EmbeddingState[] $values() {
        return new EmbeddingState[]{USE_VLM, USE_LITTLE_MODEL, USE_VLM_AND_LITTLE_MODEL};
    }

    static {
        USE_VLM = new EmbeddingState("USE_VLM", 0, 1);
        USE_LITTLE_MODEL = new EmbeddingState("USE_LITTLE_MODEL", 1, 2);
        USE_VLM_AND_LITTLE_MODEL = new EmbeddingState("USE_VLM_AND_LITTLE_MODEL", 2, 3);
        EmbeddingState[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private EmbeddingState(String r1, int r2, int r3) {
        super(r1, r2);
        this.code = r3;
    }

    public static EnumEntries<EmbeddingState> getEntries() {
        return $ENTRIES;
    }

    public static EmbeddingState valueOf(String r2) {
        return (EmbeddingState) ZeusTransformUtils.preCheckCast(Enum.valueOf(EmbeddingState.class, r2), EmbeddingState.class, "com.obric.memorydata.plugin");
    }

    public static EmbeddingState[] values() {
        return (EmbeddingState[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), EmbeddingState[].class, "com.obric.memorydata.plugin");
    }

    public final int getCode() {
        return this.code;
    }
}
