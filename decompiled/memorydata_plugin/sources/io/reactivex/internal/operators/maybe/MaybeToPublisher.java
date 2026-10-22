package io.reactivex.internal.operators.maybe;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.b.h;
import io.reactivex.o;

/* JADX INFO: loaded from: classes6.dex */
public final enum MaybeToPublisher extends Enum<MaybeToPublisher> implements h<o<Object>, org.a.b<Object>> {
    private static final /* synthetic */ MaybeToPublisher[] $VALUES = null;
    public static final MaybeToPublisher INSTANCE = null;

    static {
        MaybeToPublisher r0 = new MaybeToPublisher("INSTANCE", 0);
        INSTANCE = r0;
        $VALUES = new MaybeToPublisher[]{r0};
    }

    private MaybeToPublisher(String r1, int r2) {
        super(r1, r2);
    }

    public static <T> h<o<T>, org.a.b<T>> instance() {
        return INSTANCE;
    }

    public static MaybeToPublisher valueOf(String r2) {
        return (MaybeToPublisher) ZeusTransformUtils.preCheckCast(Enum.valueOf(MaybeToPublisher.class, r2), MaybeToPublisher.class, "com.obric.memorydata.plugin");
    }

    public static MaybeToPublisher[] values() {
        return (MaybeToPublisher[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), MaybeToPublisher[].class, "com.obric.memorydata.plugin");
    }

    @Override // io.reactivex.b.h
    public /* synthetic */ org.a.b<Object> apply(o<Object> r3) {
        return apply2((o) ZeusTransformUtils.preCheckCast(r3, o.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: apply, reason: avoid collision after fix types in other method */
    public org.a.b<Object> apply2(o<Object> r2) {
        return new MaybeToFlowable((o) ZeusTransformUtils.wrapperContextForParams(r2, o.class, "com.obric.memorydata.plugin"));
    }
}
