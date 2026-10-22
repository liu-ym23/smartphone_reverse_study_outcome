package io.reactivex.parallel;

import com.bytedance.security.dbcipher.utils.CipherConst;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.b.c;

/* JADX INFO: loaded from: classes6.dex */
public final enum ParallelFailureHandling extends Enum<ParallelFailureHandling> implements c<Long, Throwable, ParallelFailureHandling> {
    private static final /* synthetic */ ParallelFailureHandling[] $VALUES = null;
    public static final ParallelFailureHandling ERROR = null;
    public static final ParallelFailureHandling RETRY = null;
    public static final ParallelFailureHandling SKIP = null;
    public static final ParallelFailureHandling STOP = null;

    static {
        ParallelFailureHandling r0 = new ParallelFailureHandling("STOP", 0);
        STOP = r0;
        ParallelFailureHandling r1 = new ParallelFailureHandling(CipherConst.LEVEL_ERROR, 1);
        ERROR = r1;
        ParallelFailureHandling r3 = new ParallelFailureHandling("SKIP", 2);
        SKIP = r3;
        ParallelFailureHandling r5 = new ParallelFailureHandling("RETRY", 3);
        RETRY = r5;
        $VALUES = new ParallelFailureHandling[]{r0, r1, r3, r5};
    }

    private ParallelFailureHandling(String r1, int r2) {
        super(r1, r2);
    }

    public static ParallelFailureHandling valueOf(String r2) {
        return (ParallelFailureHandling) ZeusTransformUtils.preCheckCast(Enum.valueOf(ParallelFailureHandling.class, r2), ParallelFailureHandling.class, "com.obric.memorydata.plugin");
    }

    public static ParallelFailureHandling[] values() {
        return (ParallelFailureHandling[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ParallelFailureHandling[].class, "com.obric.memorydata.plugin");
    }

    /* JADX INFO: renamed from: apply, reason: avoid collision after fix types in other method */
    public ParallelFailureHandling apply2(Long r1, Throwable r2) {
        return this;
    }

    @Override // io.reactivex.b.c
    public /* synthetic */ ParallelFailureHandling apply(Long r3, Throwable r4) {
        return apply2((Long) ZeusTransformUtils.preCheckCast(r3, Long.class, "com.obric.memorydata.plugin"), (Throwable) ZeusTransformUtils.preCheckCast(r4, Throwable.class, "com.obric.memorydata.plugin"));
    }
}
