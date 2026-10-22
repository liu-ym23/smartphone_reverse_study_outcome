package com.larus.uaigc.helper;

import com.larus.bmhome.rc.FlowResourceScene;
import com.larus.bmhome.rc.ResourceCenter;
import com.larus.bmhome.resource.access.ResourceUploadSceneResolver;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0012\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/larus/uaigc/helper/CreationUploadSceneResolver;", "Lcom/larus/bmhome/resource/access/ResourceUploadSceneResolver;", "<init>", "()V", "key", "", "getKey", "()Ljava/lang/String;", "supports", "", "context", "Lcom/larus/bmhome/resource/access/ResourceContext;", "resolve", "Lcom/larus/bmhome/rc/FlowResourceScene;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class CreationUploadSceneResolver implements ResourceUploadSceneResolver {
    public final String a;

    public final void getPriority() {
    }

    public CreationUploadSceneResolver() {
        this.a = "creation_upload_scene";
    }

    public final String getKey() {
        return this.a;
    }

    public final FlowResourceScene a(com.larus.bmhome.resource.access.h0 r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        ResourceCenter r0 = ResourceCenter.a;
        String r1 = r3.a.d.a;
        r0.getClass();
        FlowResourceScene r2 = ResourceCenter.g(r1);
        if (r2 == FlowResourceScene.Unknown) goto L5;
        return r2;
    L5:
        com.larus.bmhome.resource.access.x r4 = r3.a.a;
        if (Intrinsics.areEqual(r4, com.larus.uaigc.service.f.a) == true) goto L15;
        if (Intrinsics.areEqual(r4, com.larus.uaigc.service.f.b) == true) goto L15;
        if (Intrinsics.areEqual(r4, com.larus.uaigc.service.f.c) == true) goto L16;
        return null;
    L16:
        return FlowResourceScene.CreationUserVideo;
    L15:
        return FlowResourceScene.ImageVLM;
    }

    public final boolean b(com.larus.bmhome.resource.access.h0 r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        com.larus.bmhome.resource.access.x r1 = com.larus.uaigc.service.f.a;
        return SetsKt.setOf(new com.larus.bmhome.resource.access.x[]{com.larus.uaigc.service.f.a, com.larus.uaigc.service.f.b, com.larus.uaigc.service.f.c}).contains(r4.a.a);
    }
}
