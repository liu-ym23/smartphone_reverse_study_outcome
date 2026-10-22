package com.larus.bmhome.resource.access;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/bmhome/resource/access/ResourceNodeStatus;", "", "<init>", "(Ljava/lang/String;I)V", "RUNNING", "SKIPPED", "CONTINUED", "READY", "FAILED", "FALLBACK", "CANCELLED", "image_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ResourceNodeStatus extends Enum<ResourceNodeStatus> {
    public static final ResourceNodeStatus CANCELLED = null;
    public static final ResourceNodeStatus CONTINUED = null;
    public static final ResourceNodeStatus FAILED = null;
    public static final ResourceNodeStatus FALLBACK = null;
    public static final ResourceNodeStatus READY = null;
    public static final ResourceNodeStatus RUNNING = null;
    public static final ResourceNodeStatus SKIPPED = null;
    public static final /* synthetic */ ResourceNodeStatus[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ResourceNodeStatus> getEntries() {
        return b;
    }

    static {
        ResourceNodeStatus r0 = new ResourceNodeStatus("RUNNING", 0);
        RUNNING = r0;
        ResourceNodeStatus r1 = new ResourceNodeStatus("SKIPPED", 1);
        SKIPPED = r1;
        ResourceNodeStatus r3 = new ResourceNodeStatus("CONTINUED", 2);
        CONTINUED = r3;
        ResourceNodeStatus r5 = new ResourceNodeStatus("READY", 3);
        READY = r5;
        ResourceNodeStatus r7 = new ResourceNodeStatus("FAILED", 4);
        FAILED = r7;
        ResourceNodeStatus r9 = new ResourceNodeStatus("FALLBACK", 5);
        FALLBACK = r9;
        ResourceNodeStatus r11 = new ResourceNodeStatus("CANCELLED", 6);
        CANCELLED = r11;
        ResourceNodeStatus[] r13 = {r0, r1, r3, r5, r7, r9, r11};
        a = r13;
        b = EnumEntriesKt.enumEntries(r13);
    }

    public static ResourceNodeStatus[] values() {
        return (ResourceNodeStatus[]) a.clone();
    }

    public static ResourceNodeStatus valueOf(String r1) {
        return (ResourceNodeStatus) r27.a.a(ResourceNodeStatus.class, r1);
    }

    public ResourceNodeStatus(String r1, int r2) {
        super(r1, r2);
    }
}
