package com.obric.memorydata.database.index;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/obric/memorydata/database/index/IndexDashboardReportProgress;", "", "<init>", "()V", "nextPayloadIndex", "", "report", "", "payloadCount", "send", "Lkotlin/Function1;", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class am {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f9363a;

    public am() {
    }

    public final boolean a(int r5, Function1<? super Integer, Boolean> r6) {
        Function1 r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r6, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "send");
    L3:
        int r0 = this.f9363a;
        if (r0 >= r5) goto L10;
        if (((Boolean) ZeusTransformUtils.preCheckCast(r7.invoke(Integer.valueOf(r0)), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L7;
        this.f9363a++;
        goto L3
    L7:
        return false;
    L10:
        return true;
    }
}
