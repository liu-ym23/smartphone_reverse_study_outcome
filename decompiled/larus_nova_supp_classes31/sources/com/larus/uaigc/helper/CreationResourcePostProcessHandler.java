package com.larus.uaigc.helper;

import com.larus.bmhome.resource.access.ResourceNodeHandler;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\rH\u0096@¢\u0006\u0002\u0010\u0010R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/larus/uaigc/helper/CreationResourcePostProcessHandler;", "Lcom/larus/bmhome/resource/access/ResourceNodeHandler;", "<init>", "()V", "key", "", "getKey", "()Ljava/lang/String;", "nodeKey", "getNodeKey", "supports", "", "context", "Lcom/larus/bmhome/resource/access/ResourceContext;", "execute", "Lcom/larus/bmhome/resource/access/NodeResult;", "(Lcom/larus/bmhome/resource/access/ResourceContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class CreationResourcePostProcessHandler implements ResourceNodeHandler {
    public final String a;
    public final String b;

    public final void getPriority() {
    }

    public CreationResourcePostProcessHandler() {
        this.a = "creation_resource_post_process";
        this.b = "post_process";
    }

    public final String a() {
        return this.b;
    }

    public final String getKey() {
        return this.a;
    }

    public final boolean b(com.larus.bmhome.resource.access.h0 r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        if (a0.b(r2) == true) goto L5;
    L7:
        return false;
    L5:
        if (r2.h == null) goto L7;
        return true;
    }

    public final Object c(com.larus.bmhome.resource.access.h0 r3, Continuation<? super com.larus.bmhome.resource.access.g> r4) {
        FLogger.a.i("CreationResourceNodeCommon", "[postProcess] artifact ready, scene=" + r3.a.a);
        return new com.larus.bmhome.resource.access.g.a(0);
    }
}
