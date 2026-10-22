package com.larus.bmhome.resource.access;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/bmhome/resource/access/ResourceCancelReason;", "", "<init>", "(Ljava/lang/String;I)V", "USER_CANCEL", "PAGE_DESTROY", "REPLACED", "UNKNOWN", "image_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ResourceCancelReason extends Enum<ResourceCancelReason> {
    public static final ResourceCancelReason PAGE_DESTROY = null;
    public static final ResourceCancelReason REPLACED = null;
    public static final ResourceCancelReason UNKNOWN = null;
    public static final ResourceCancelReason USER_CANCEL = null;
    public static final /* synthetic */ ResourceCancelReason[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ResourceCancelReason> getEntries() {
        return b;
    }

    static {
        ResourceCancelReason r0 = new ResourceCancelReason("USER_CANCEL", 0);
        USER_CANCEL = r0;
        ResourceCancelReason r1 = new ResourceCancelReason("PAGE_DESTROY", 1);
        PAGE_DESTROY = r1;
        ResourceCancelReason r3 = new ResourceCancelReason("REPLACED", 2);
        REPLACED = r3;
        ResourceCancelReason r5 = new ResourceCancelReason("UNKNOWN", 3);
        UNKNOWN = r5;
        ResourceCancelReason[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static ResourceCancelReason[] values() {
        return (ResourceCancelReason[]) a.clone();
    }

    public static ResourceCancelReason valueOf(String r1) {
        return (ResourceCancelReason) r27.a.a(ResourceCancelReason.class, r1);
    }

    public ResourceCancelReason(String r1, int r2) {
        super(r1, r2);
    }
}
