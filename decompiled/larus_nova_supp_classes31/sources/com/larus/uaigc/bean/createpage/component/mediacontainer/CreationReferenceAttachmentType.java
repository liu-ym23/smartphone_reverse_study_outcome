package com.larus.uaigc.bean.createpage.component.mediacontainer;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/uaigc/bean/createpage/component/mediacontainer/CreationReferenceAttachmentType;", "", "<init>", "(Ljava/lang/String;I)V", "IMAGE", "VIDEO", "AUDIO", "UNKNOWN", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum CreationReferenceAttachmentType extends Enum<CreationReferenceAttachmentType> {
    public static final CreationReferenceAttachmentType AUDIO = null;
    public static final CreationReferenceAttachmentType IMAGE = null;
    public static final CreationReferenceAttachmentType UNKNOWN = null;
    public static final CreationReferenceAttachmentType VIDEO = null;
    public static final /* synthetic */ CreationReferenceAttachmentType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<CreationReferenceAttachmentType> getEntries() {
        return b;
    }

    static {
        CreationReferenceAttachmentType r0 = new CreationReferenceAttachmentType("IMAGE", 0);
        IMAGE = r0;
        CreationReferenceAttachmentType r1 = new CreationReferenceAttachmentType("VIDEO", 1);
        VIDEO = r1;
        CreationReferenceAttachmentType r3 = new CreationReferenceAttachmentType("AUDIO", 2);
        AUDIO = r3;
        CreationReferenceAttachmentType r5 = new CreationReferenceAttachmentType("UNKNOWN", 3);
        UNKNOWN = r5;
        CreationReferenceAttachmentType[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static CreationReferenceAttachmentType[] values() {
        return (CreationReferenceAttachmentType[]) a.clone();
    }

    public static CreationReferenceAttachmentType valueOf(String r1) {
        return (CreationReferenceAttachmentType) a.a(CreationReferenceAttachmentType.class, r1);
    }

    public CreationReferenceAttachmentType(String r1, int r2) {
        super(r1, r2);
    }
}
