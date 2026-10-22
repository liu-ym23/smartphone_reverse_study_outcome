package com.google.common.util.concurrent;

import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.bj;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.Future;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
abstract class AggregateFuture<InputT, OutputT> extends d<OutputT> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Logger f4803b = null;
    private ImmutableCollection<? extends l<? extends InputT>> c;

    static final enum ReleaseResourcesReason extends Enum<ReleaseResourcesReason> {
        private static final /* synthetic */ ReleaseResourcesReason[] $VALUES = null;
        public static final ReleaseResourcesReason ALL_INPUT_FUTURES_PROCESSED = null;
        public static final ReleaseResourcesReason OUTPUT_FUTURE_DONE = null;

        private static /* synthetic */ ReleaseResourcesReason[] $values() {
            return new ReleaseResourcesReason[]{OUTPUT_FUTURE_DONE, ALL_INPUT_FUTURES_PROCESSED};
        }

        static {
            OUTPUT_FUTURE_DONE = new ReleaseResourcesReason("OUTPUT_FUTURE_DONE", 0);
            ALL_INPUT_FUTURES_PROCESSED = new ReleaseResourcesReason("ALL_INPUT_FUTURES_PROCESSED", 1);
            $VALUES = $values();
        }

        private ReleaseResourcesReason(String r1, int r2) {
            super(r1, r2);
        }

        public static ReleaseResourcesReason valueOf(String r2) {
            return (ReleaseResourcesReason) ZeusTransformUtils.preCheckCast(Enum.valueOf(ReleaseResourcesReason.class, r2), ReleaseResourcesReason.class, "com.obric.memorydata.plugin");
        }

        public static ReleaseResourcesReason[] values() {
            return (ReleaseResourcesReason[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ReleaseResourcesReason[].class, "com.obric.memorydata.plugin");
        }
    }

    static {
        f4803b = Logger.getLogger(AggregateFuture.class.getName());
    }

    void a(ReleaseResourcesReason r1) {
        com.google.common.base.n.a(r1);
        this.c = null;
    }

    @Override // com.google.common.util.concurrent.a
    public final void c() {
        super.c();
        ImmutableCollection<? extends l<? extends InputT>> r0 = this.c;
        a(ReleaseResourcesReason.OUTPUT_FUTURE_DONE);
        boolean r1 = isCancelled();
        if (r0 == null) goto L5;
        boolean r2 = true;
    L7:
        if ((r1 & r2) == false) goto L12;
        boolean r4 = b();
        bj<? extends l<? extends InputT>> r3 = r0.iterator();
    L10:
        if (r3.hasNext() == false) goto L14;
        ((Future) ZeusTransformUtils.preCheckCast(r3.next(), Future.class, "com.obric.memorydata.plugin")).cancel(r4);
        goto L10
    L14:
        return;
    L12:
        return;
    L5:
        r2 = false;
        goto L7
    }

    @Override // com.google.common.util.concurrent.a
    public final String e() {
        ImmutableCollection<? extends l<? extends InputT>> r0 = this.c;
        if (r0 == null) goto L7;
        return "futures=" + r0;
    L7:
        return super.e();
    }
}
