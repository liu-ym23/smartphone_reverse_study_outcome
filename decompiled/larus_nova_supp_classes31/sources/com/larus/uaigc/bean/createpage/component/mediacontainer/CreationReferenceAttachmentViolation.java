package com.larus.uaigc.bean.createpage.component.mediacontainer;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/larus/uaigc/bean/createpage/component/mediacontainer/CreationReferenceAttachmentViolation;", "", "<init>", "(Ljava/lang/String;I)V", "UNSUPPORTED_TYPE", "METADATA_UNAVAILABLE", "TYPE_COUNT", "MIXED_COUNT", "SINGLE_DURATION", "TOTAL_DURATION", "FILE_SIZE", "RESOLUTION", "RATIO", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum CreationReferenceAttachmentViolation extends Enum<CreationReferenceAttachmentViolation> {
    public static final CreationReferenceAttachmentViolation FILE_SIZE = null;
    public static final CreationReferenceAttachmentViolation METADATA_UNAVAILABLE = null;
    public static final CreationReferenceAttachmentViolation MIXED_COUNT = null;
    public static final CreationReferenceAttachmentViolation RATIO = null;
    public static final CreationReferenceAttachmentViolation RESOLUTION = null;
    public static final CreationReferenceAttachmentViolation SINGLE_DURATION = null;
    public static final CreationReferenceAttachmentViolation TOTAL_DURATION = null;
    public static final CreationReferenceAttachmentViolation TYPE_COUNT = null;
    public static final CreationReferenceAttachmentViolation UNSUPPORTED_TYPE = null;
    public static final /* synthetic */ CreationReferenceAttachmentViolation[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<CreationReferenceAttachmentViolation> getEntries() {
        return b;
    }

    static {
        CreationReferenceAttachmentViolation r0 = new CreationReferenceAttachmentViolation("UNSUPPORTED_TYPE", 0);
        UNSUPPORTED_TYPE = r0;
        CreationReferenceAttachmentViolation r1 = new CreationReferenceAttachmentViolation("METADATA_UNAVAILABLE", 1);
        METADATA_UNAVAILABLE = r1;
        CreationReferenceAttachmentViolation r3 = new CreationReferenceAttachmentViolation("TYPE_COUNT", 2);
        TYPE_COUNT = r3;
        CreationReferenceAttachmentViolation r5 = new CreationReferenceAttachmentViolation("MIXED_COUNT", 3);
        MIXED_COUNT = r5;
        CreationReferenceAttachmentViolation r7 = new CreationReferenceAttachmentViolation("SINGLE_DURATION", 4);
        SINGLE_DURATION = r7;
        CreationReferenceAttachmentViolation r9 = new CreationReferenceAttachmentViolation("TOTAL_DURATION", 5);
        TOTAL_DURATION = r9;
        CreationReferenceAttachmentViolation r11 = new CreationReferenceAttachmentViolation("FILE_SIZE", 6);
        FILE_SIZE = r11;
        CreationReferenceAttachmentViolation r13 = new CreationReferenceAttachmentViolation("RESOLUTION", 7);
        RESOLUTION = r13;
        CreationReferenceAttachmentViolation r15 = new CreationReferenceAttachmentViolation("RATIO", 8);
        RATIO = r15;
        CreationReferenceAttachmentViolation[] r14 = {r0, r1, r3, r5, r7, r9, r11, r13, r15};
        a = r14;
        b = EnumEntriesKt.enumEntries(r14);
    }

    public static CreationReferenceAttachmentViolation[] values() {
        return (CreationReferenceAttachmentViolation[]) a.clone();
    }

    public static CreationReferenceAttachmentViolation valueOf(String r1) {
        return (CreationReferenceAttachmentViolation) a.a(CreationReferenceAttachmentViolation.class, r1);
    }

    public CreationReferenceAttachmentViolation(String r1, int r2) {
        super(r1, r2);
    }
}
