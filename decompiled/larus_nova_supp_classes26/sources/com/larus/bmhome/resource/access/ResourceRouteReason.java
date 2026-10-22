package com.larus.bmhome.resource.access;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/larus/bmhome/resource/access/ResourceRouteReason;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "ARTIFACT_READY", "TOS_KEY_DIRECT", "REMOTE_URL_NEEDS_LOCAL_SOURCE", "REMOTE_RESOLVE_DISABLED", "REMOTE_FALLBACK_DISABLED", "UNSUPPORTED_REMOTE_INPUT", "image_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ResourceRouteReason extends Enum<ResourceRouteReason> {
    public static final ResourceRouteReason ARTIFACT_READY = null;
    public static final ResourceRouteReason REMOTE_FALLBACK_DISABLED = null;
    public static final ResourceRouteReason REMOTE_RESOLVE_DISABLED = null;
    public static final ResourceRouteReason REMOTE_URL_NEEDS_LOCAL_SOURCE = null;
    public static final ResourceRouteReason TOS_KEY_DIRECT = null;
    public static final ResourceRouteReason UNSUPPORTED_REMOTE_INPUT = null;
    public static final /* synthetic */ ResourceRouteReason[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String value;

    public static EnumEntries<ResourceRouteReason> getEntries() {
        return b;
    }

    static {
        ResourceRouteReason r0 = new ResourceRouteReason("ARTIFACT_READY", 0, "artifact_ready");
        ARTIFACT_READY = r0;
        ResourceRouteReason r1 = new ResourceRouteReason("TOS_KEY_DIRECT", 1, "tos_key_direct");
        TOS_KEY_DIRECT = r1;
        ResourceRouteReason r2 = new ResourceRouteReason("REMOTE_URL_NEEDS_LOCAL_SOURCE", 2, "remote_url_needs_local_source");
        REMOTE_URL_NEEDS_LOCAL_SOURCE = r2;
        ResourceRouteReason r4 = new ResourceRouteReason("REMOTE_RESOLVE_DISABLED", 3, "remote_resolve_disabled");
        REMOTE_RESOLVE_DISABLED = r4;
        ResourceRouteReason r6 = new ResourceRouteReason("REMOTE_FALLBACK_DISABLED", 4, "remote_fallback_disabled");
        REMOTE_FALLBACK_DISABLED = r6;
        ResourceRouteReason r8 = new ResourceRouteReason("UNSUPPORTED_REMOTE_INPUT", 5, "unsupported_remote_input");
        UNSUPPORTED_REMOTE_INPUT = r8;
        ResourceRouteReason[] r10 = {r0, r1, r2, r4, r6, r8};
        a = r10;
        b = EnumEntriesKt.enumEntries(r10);
    }

    public static ResourceRouteReason[] values() {
        return (ResourceRouteReason[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static ResourceRouteReason valueOf(String r1) {
        return (ResourceRouteReason) r27.a.a(ResourceRouteReason.class, r1);
    }

    public ResourceRouteReason(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
