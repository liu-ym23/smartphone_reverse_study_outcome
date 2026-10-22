package com.larus.platform.model.preview;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/platform/model/preview/AttachmentEditType;", "", "<init>", "(Ljava/lang/String;I)V", "MARK", "CROP", "OTHER", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum AttachmentEditType extends Enum<AttachmentEditType> {
    public static final AttachmentEditType CROP = null;
    public static final AttachmentEditType MARK = null;
    public static final AttachmentEditType OTHER = null;
    public static final /* synthetic */ AttachmentEditType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<AttachmentEditType> getEntries() {
        return b;
    }

    static {
        AttachmentEditType r0 = new AttachmentEditType("MARK", 0);
        MARK = r0;
        AttachmentEditType r1 = new AttachmentEditType("CROP", 1);
        CROP = r1;
        AttachmentEditType r3 = new AttachmentEditType("OTHER", 2);
        OTHER = r3;
        AttachmentEditType[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static AttachmentEditType[] values() {
        return (AttachmentEditType[]) a.clone();
    }

    public static AttachmentEditType valueOf(String r1) {
        return (AttachmentEditType) a.a(AttachmentEditType.class, r1);
    }

    public AttachmentEditType(String r1, int r2) {
        super(r1, r2);
    }
}
