package com.larus.bmhome.resource.access;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/bmhome/resource/access/ResourceInputType;", "", "<init>", "(Ljava/lang/String;I)V", "LOCAL_PATH", "CONTENT_URI", "TOS_KEY", "REMOTE_URL", "image_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ResourceInputType extends Enum<ResourceInputType> {
    public static final ResourceInputType CONTENT_URI = null;
    public static final ResourceInputType LOCAL_PATH = null;
    public static final ResourceInputType REMOTE_URL = null;
    public static final ResourceInputType TOS_KEY = null;
    public static final /* synthetic */ ResourceInputType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ResourceInputType> getEntries() {
        return b;
    }

    static {
        ResourceInputType r0 = new ResourceInputType("LOCAL_PATH", 0);
        LOCAL_PATH = r0;
        ResourceInputType r1 = new ResourceInputType("CONTENT_URI", 1);
        CONTENT_URI = r1;
        ResourceInputType r3 = new ResourceInputType("TOS_KEY", 2);
        TOS_KEY = r3;
        ResourceInputType r5 = new ResourceInputType("REMOTE_URL", 3);
        REMOTE_URL = r5;
        ResourceInputType[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static ResourceInputType[] values() {
        return (ResourceInputType[]) a.clone();
    }

    public static ResourceInputType valueOf(String r1) {
        return (ResourceInputType) r27.a.a(ResourceInputType.class, r1);
    }

    public ResourceInputType(String r1, int r2) {
        super(r1, r2);
    }
}
