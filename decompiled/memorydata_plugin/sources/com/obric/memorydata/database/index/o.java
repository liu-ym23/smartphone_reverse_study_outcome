package com.obric.memorydata.database.index;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\b\u001a\u00020\u0004R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/obric/memorydata/database/index/DatabasePendingOnlyReplayReceipt;", "Lcom/obric/memorydata/database/index/PendingOnlyReplayReceipt;", "isCommitted", "Lkotlin/Function0;", "", "finalizeAfterCommit", "<init>", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "finalizeOnce", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class o implements ba {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function0<Boolean> f9429a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function0<Boolean> f9430b;

    public o(Function0<Boolean> r3, Function0<Boolean> r4) {
        Function0<Boolean> r5 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        Function0<Boolean> r6 = (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "isCommitted");
        Intrinsics.checkNotNullParameter(r6, "finalizeAfterCommit");
        this.f9429a = r5;
        this.f9430b = r6;
    }

    public final boolean a() {
        if (((Boolean) ZeusTransformUtils.preCheckCast(this.f9429a.invoke(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L5;
    L7:
        return false;
    L5:
        if (((Boolean) ZeusTransformUtils.preCheckCast(this.f9430b.invoke(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L7;
        return true;
    }
}
