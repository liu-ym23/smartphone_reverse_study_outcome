package com.larus.uaigc.helper;

import com.larus.bmhome.resource.access.ResourceNodeHandler;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\rH\u0096@¢\u0006\u0002\u0010\u0010R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/larus/uaigc/helper/CreationResourceCacheHandler;", "Lcom/larus/bmhome/resource/access/ResourceNodeHandler;", "<init>", "()V", "key", "", "getKey", "()Ljava/lang/String;", "nodeKey", "getNodeKey", "supports", "", "context", "Lcom/larus/bmhome/resource/access/ResourceContext;", "execute", "Lcom/larus/bmhome/resource/access/NodeResult;", "(Lcom/larus/bmhome/resource/access/ResourceContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class CreationResourceCacheHandler implements ResourceNodeHandler {
    public final String a;
    public final String b;

    public final void getPriority() {
    }

    public CreationResourceCacheHandler() {
        this.a = "creation_resource_cache";
        this.b = "cache";
    }

    public final String a() {
        return this.b;
    }

    public final String getKey() {
        return this.a;
    }

    public final boolean b(com.larus.bmhome.resource.access.h0 r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        if (a0.b(r3) == true) goto L5;
        return false;
    L5:
        if (r3.h == null) goto L17;
        CharSequence r4 = (CharSequence) r3.b().get("preprocess_result");
        if (r4 != null) goto L9;
    L12:
        boolean r5 = true;
    L13:
        if (r5 == true) goto L18;
        return true;
    L18:
        return false;
    L9:
        if (r4.length() == 0) goto L12;
        r5 = false;
        goto L13
    L17:
        return false;
    }

    public final Object c(com.larus.bmhome.resource.access.h0 r10, Continuation<? super com.larus.bmhome.resource.access.g> r11) {
        return new com.larus.bmhome.resource.access.g.a(new com.larus.bmhome.resource.access.i0(null, null, null, null, null, null, MapsKt.mapOf(TuplesKt.to("cache_stage", CreationCacheStage.PREPROCESS_REUSE_CHECKED.getValue())), 63));
    }
}
