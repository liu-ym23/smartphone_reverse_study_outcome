package com.obric.memorydata.middleware.api.app;

import com.bytedance.bdlocation.monitor.LBSLightLocationTraceLogger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u001c\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00050\u0007H&¨\u0006\t"}, d2 = {"Lcom/obric/memorydata/middleware/api/app/TaskControllerPrerequisite;", "", "isReady", "", LBSLightLocationTraceLogger.PREPARE, "", "onFinished", "Lkotlin/Function1;", "Lcom/obric/memorydata/middleware/api/app/TaskControllerPrerequisiteResult;", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface g {
    void a(Function1<? super h, Unit> r1);

    boolean a();
}
