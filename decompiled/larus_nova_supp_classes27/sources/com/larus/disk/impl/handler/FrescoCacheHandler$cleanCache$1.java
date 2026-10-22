package com.larus.disk.impl.handler;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class FrescoCacheHandler$cleanCache$1 extends FunctionReferenceImpl implements Function0<Long> {
    public FrescoCacheHandler$cleanCache$1(Object r8) {
        super(0, r8, FrescoCacheHandler.class, "getManualCleanableSize", "getManualCleanableSize()J", 0);
    }

    public final Long invoke() {
        return Long.valueOf(((FrescoCacheHandler) ((CallableReference) this).receiver).d());
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m31invoke() {
        return invoke();
    }
}
