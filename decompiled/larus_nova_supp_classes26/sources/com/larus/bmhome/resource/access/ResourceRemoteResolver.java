package com.larus.bmhome.resource.access;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&J\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H¦@¢\u0006\u0002\u0010\u0012R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0013"}, d2 = {"Lcom/larus/bmhome/resource/access/ResourceRemoteResolver;", "", "key", "", "getKey", "()Ljava/lang/String;", "supports", "", "scene", "Lcom/larus/bmhome/resource/access/ResourceAccessScene;", "resourceInputType", "Lcom/larus/bmhome/resource/access/ResourceInputType;", "mediaType", "Lcom/larus/bmhome/resource/access/ResourceMediaType;", "resolve", "Lcom/larus/bmhome/resource/access/NodeResult;", "context", "Lcom/larus/bmhome/resource/access/ResourceContext;", "(Lcom/larus/bmhome/resource/access/ResourceContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "image_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ResourceRemoteResolver {
    Object a(h0 r1, Continuation<? super g> r2);

    boolean b(x r1, ResourceInputType r2, ResourceMediaType r3);

    String getKey();
}
