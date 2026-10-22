package com.larus.bmhome.resource.access;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/bmhome/resource/access/ResourcePipelineRoute;", "", "<init>", "(Ljava/lang/String;I)V", "LOCAL", "REMOTE", "image_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
final enum ResourcePipelineRoute extends Enum<ResourcePipelineRoute> {
    public static final ResourcePipelineRoute LOCAL = null;
    public static final ResourcePipelineRoute REMOTE = null;
    public static final /* synthetic */ ResourcePipelineRoute[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ResourcePipelineRoute> getEntries() {
        return b;
    }

    static {
        ResourcePipelineRoute r0 = new ResourcePipelineRoute("LOCAL", 0);
        LOCAL = r0;
        ResourcePipelineRoute r1 = new ResourcePipelineRoute("REMOTE", 1);
        REMOTE = r1;
        ResourcePipelineRoute[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static ResourcePipelineRoute[] values() {
        return (ResourcePipelineRoute[]) a.clone();
    }

    public static ResourcePipelineRoute valueOf(String r1) {
        return (ResourcePipelineRoute) r27.a.a(ResourcePipelineRoute.class, r1);
    }

    public ResourcePipelineRoute(String r1, int r2) {
        super(r1, r2);
    }
}
