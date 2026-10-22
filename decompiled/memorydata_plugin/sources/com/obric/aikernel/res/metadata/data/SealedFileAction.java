package com.obric.aikernel.res.metadata.data;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/obric/aikernel/res/metadata/data/SealedFileAction;", "", "(Ljava/lang/String;I)V", "HEALTHY", "DEFER_FULL_VERIFY", "VERIFY", "VERIFY_AND_RESEAL", "NEEDS_DOWNLOAD", "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final enum SealedFileAction extends Enum<SealedFileAction> {
    private static final /* synthetic */ SealedFileAction[] $VALUES = null;
    public static final SealedFileAction DEFER_FULL_VERIFY = null;
    public static final SealedFileAction HEALTHY = null;
    public static final SealedFileAction NEEDS_DOWNLOAD = null;
    public static final SealedFileAction VERIFY = null;
    public static final SealedFileAction VERIFY_AND_RESEAL = null;

    private static final /* synthetic */ SealedFileAction[] $values() {
        return new SealedFileAction[]{HEALTHY, DEFER_FULL_VERIFY, VERIFY, VERIFY_AND_RESEAL, NEEDS_DOWNLOAD};
    }

    static {
        HEALTHY = new SealedFileAction("HEALTHY", 0);
        DEFER_FULL_VERIFY = new SealedFileAction("DEFER_FULL_VERIFY", 1);
        VERIFY = new SealedFileAction("VERIFY", 2);
        VERIFY_AND_RESEAL = new SealedFileAction("VERIFY_AND_RESEAL", 3);
        NEEDS_DOWNLOAD = new SealedFileAction("NEEDS_DOWNLOAD", 4);
        $VALUES = $values();
    }

    private SealedFileAction(String r1, int r2) {
        super(r1, r2);
    }

    public static SealedFileAction valueOf(String r2) {
        return (SealedFileAction) ZeusTransformUtils.preCheckCast(Enum.valueOf(SealedFileAction.class, r2), SealedFileAction.class, "com.obric.memorydata.plugin");
    }

    public static SealedFileAction[] values() {
        return (SealedFileAction[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), SealedFileAction[].class, "com.obric.memorydata.plugin");
    }
}
