package com.larus.bmhome.resource.access;

import com.larus.bmhome.instruction.handler.InstructionHandlerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/bmhome/resource/access/ResourceMediaType;", "", "<init>", "(Ljava/lang/String;I)V", "IMAGE", InstructionHandlerType.VIDEO, "FILE", "image_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ResourceMediaType extends Enum<ResourceMediaType> {
    public static final ResourceMediaType FILE = null;
    public static final ResourceMediaType IMAGE = null;
    public static final ResourceMediaType VIDEO = null;
    public static final /* synthetic */ ResourceMediaType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ResourceMediaType> getEntries() {
        return b;
    }

    static {
        ResourceMediaType r0 = new ResourceMediaType("IMAGE", 0);
        IMAGE = r0;
        ResourceMediaType r1 = new ResourceMediaType(InstructionHandlerType.VIDEO, 1);
        VIDEO = r1;
        ResourceMediaType r3 = new ResourceMediaType("FILE", 2);
        FILE = r3;
        ResourceMediaType[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static ResourceMediaType[] values() {
        return (ResourceMediaType[]) a.clone();
    }

    public static ResourceMediaType valueOf(String r1) {
        return (ResourceMediaType) r27.a.a(ResourceMediaType.class, r1);
    }

    public ResourceMediaType(String r1, int r2) {
        super(r1, r2);
    }
}
