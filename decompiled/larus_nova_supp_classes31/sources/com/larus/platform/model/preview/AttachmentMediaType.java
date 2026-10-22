package com.larus.platform.model.preview;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/platform/model/preview/AttachmentMediaType;", "", "<init>", "(Ljava/lang/String;I)V", "IMAGE", "VIDEO", "FILE", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum AttachmentMediaType extends Enum<AttachmentMediaType> {
    public static final AttachmentMediaType FILE = null;
    public static final AttachmentMediaType IMAGE = null;
    public static final AttachmentMediaType VIDEO = null;
    public static final /* synthetic */ AttachmentMediaType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<AttachmentMediaType> getEntries() {
        return b;
    }

    static {
        AttachmentMediaType r0 = new AttachmentMediaType("IMAGE", 0);
        IMAGE = r0;
        AttachmentMediaType r1 = new AttachmentMediaType("VIDEO", 1);
        VIDEO = r1;
        AttachmentMediaType r3 = new AttachmentMediaType("FILE", 2);
        FILE = r3;
        AttachmentMediaType[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static AttachmentMediaType[] values() {
        return (AttachmentMediaType[]) a.clone();
    }

    public static AttachmentMediaType valueOf(String r1) {
        return (AttachmentMediaType) a.a(AttachmentMediaType.class, r1);
    }

    public AttachmentMediaType(String r1, int r2) {
        super(r1, r2);
    }
}
