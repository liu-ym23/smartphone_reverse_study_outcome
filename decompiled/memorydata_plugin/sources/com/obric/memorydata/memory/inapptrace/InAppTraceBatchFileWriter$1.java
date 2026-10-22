package com.obric.memorydata.memory.inapptrace;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* synthetic */ class InAppTraceBatchFileWriter$1 extends FunctionReferenceImpl implements Function0<Long> {
    public static final InAppTraceBatchFileWriter$1 INSTANCE = null;

    static {
        INSTANCE = new InAppTraceBatchFileWriter$1();
    }

    InAppTraceBatchFileWriter$1() {
        super(0, System.class, "currentTimeMillis", "currentTimeMillis()J", 0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Long invoke() {
        return Long.valueOf(System.currentTimeMillis());
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Long invoke() {
        return invoke();
    }
}
