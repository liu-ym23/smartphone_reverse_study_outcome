package com.larus.bmhome.resource.access;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/bmhome/resource/access/ResourceNodeCompletionMode;", "", "<init>", "(Ljava/lang/String;I)V", "BLOCKING", "DETACHED", "image_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ResourceNodeCompletionMode extends Enum<ResourceNodeCompletionMode> {
    public static final ResourceNodeCompletionMode BLOCKING = null;
    public static final ResourceNodeCompletionMode DETACHED = null;
    public static final /* synthetic */ ResourceNodeCompletionMode[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ResourceNodeCompletionMode> getEntries() {
        return b;
    }

    static {
        ResourceNodeCompletionMode r0 = new ResourceNodeCompletionMode("BLOCKING", 0);
        BLOCKING = r0;
        ResourceNodeCompletionMode r1 = new ResourceNodeCompletionMode("DETACHED", 1);
        DETACHED = r1;
        ResourceNodeCompletionMode[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static ResourceNodeCompletionMode[] values() {
        return (ResourceNodeCompletionMode[]) a.clone();
    }

    public static ResourceNodeCompletionMode valueOf(String r1) {
        return (ResourceNodeCompletionMode) r27.a.a(ResourceNodeCompletionMode.class, r1);
    }

    public ResourceNodeCompletionMode(String r1, int r2) {
        super(r1, r2);
    }
}
