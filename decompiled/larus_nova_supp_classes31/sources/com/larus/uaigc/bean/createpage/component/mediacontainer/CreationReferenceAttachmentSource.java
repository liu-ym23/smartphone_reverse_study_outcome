package com.larus.uaigc.bean.createpage.component.mediacontainer;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/uaigc/bean/createpage/component/mediacontainer/CreationReferenceAttachmentSource;", "", "<init>", "(Ljava/lang/String;I)V", "MANUAL", "DO_SAME", "UNKNOWN", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum CreationReferenceAttachmentSource extends Enum<CreationReferenceAttachmentSource> {
    public static final CreationReferenceAttachmentSource DO_SAME = null;
    public static final CreationReferenceAttachmentSource MANUAL = null;
    public static final CreationReferenceAttachmentSource UNKNOWN = null;
    public static final /* synthetic */ CreationReferenceAttachmentSource[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<CreationReferenceAttachmentSource> getEntries() {
        return b;
    }

    static {
        CreationReferenceAttachmentSource r0 = new CreationReferenceAttachmentSource("MANUAL", 0);
        MANUAL = r0;
        CreationReferenceAttachmentSource r1 = new CreationReferenceAttachmentSource("DO_SAME", 1);
        DO_SAME = r1;
        CreationReferenceAttachmentSource r3 = new CreationReferenceAttachmentSource("UNKNOWN", 2);
        UNKNOWN = r3;
        CreationReferenceAttachmentSource[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static CreationReferenceAttachmentSource[] values() {
        return (CreationReferenceAttachmentSource[]) a.clone();
    }

    public static CreationReferenceAttachmentSource valueOf(String r1) {
        return (CreationReferenceAttachmentSource) a.a(CreationReferenceAttachmentSource.class, r1);
    }

    public CreationReferenceAttachmentSource(String r1, int r2) {
        super(r1, r2);
    }
}
