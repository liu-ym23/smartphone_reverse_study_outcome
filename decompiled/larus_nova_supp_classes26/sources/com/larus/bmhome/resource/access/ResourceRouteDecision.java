package com.larus.bmhome.resource.access;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/bmhome/resource/access/ResourceRouteDecision;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "DIRECT", "FALLBACK_DOWNLOAD", "REJECT", "SKIP", "image_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ResourceRouteDecision extends Enum<ResourceRouteDecision> {
    public static final ResourceRouteDecision DIRECT = null;
    public static final ResourceRouteDecision FALLBACK_DOWNLOAD = null;
    public static final ResourceRouteDecision REJECT = null;
    public static final ResourceRouteDecision SKIP = null;
    public static final /* synthetic */ ResourceRouteDecision[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String value;

    public static EnumEntries<ResourceRouteDecision> getEntries() {
        return b;
    }

    static {
        ResourceRouteDecision r0 = new ResourceRouteDecision("DIRECT", 0, "direct");
        DIRECT = r0;
        ResourceRouteDecision r1 = new ResourceRouteDecision("FALLBACK_DOWNLOAD", 1, "fallback_download");
        FALLBACK_DOWNLOAD = r1;
        ResourceRouteDecision r2 = new ResourceRouteDecision("REJECT", 2, "reject");
        REJECT = r2;
        ResourceRouteDecision r4 = new ResourceRouteDecision("SKIP", 3, "skip");
        SKIP = r4;
        ResourceRouteDecision[] r6 = {r0, r1, r2, r4};
        a = r6;
        b = EnumEntriesKt.enumEntries(r6);
    }

    public static ResourceRouteDecision[] values() {
        return (ResourceRouteDecision[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static ResourceRouteDecision valueOf(String r1) {
        return (ResourceRouteDecision) r27.a.a(ResourceRouteDecision.class, r1);
    }

    public ResourceRouteDecision(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
