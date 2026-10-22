package com.larus.uaigc.bean.createpage.component.mediacontainer;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/larus/uaigc/bean/createpage/component/mediacontainer/CreationReferenceAttachmentState;", "", "<init>", "(Ljava/lang/String;I)V", "SELECTED", "COMPRESSING", "UPLOADING", "UPLOAD_SUCCESS", "UPLOAD_FAILED", "PARSE_FAILED", "INSPECT_FAILED", "EXPIRED", "UNKNOWN", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum CreationReferenceAttachmentState extends Enum<CreationReferenceAttachmentState> {
    public static final CreationReferenceAttachmentState COMPRESSING = null;
    public static final CreationReferenceAttachmentState EXPIRED = null;
    public static final CreationReferenceAttachmentState INSPECT_FAILED = null;
    public static final CreationReferenceAttachmentState PARSE_FAILED = null;
    public static final CreationReferenceAttachmentState SELECTED = null;
    public static final CreationReferenceAttachmentState UNKNOWN = null;
    public static final CreationReferenceAttachmentState UPLOADING = null;
    public static final CreationReferenceAttachmentState UPLOAD_FAILED = null;
    public static final CreationReferenceAttachmentState UPLOAD_SUCCESS = null;
    public static final /* synthetic */ CreationReferenceAttachmentState[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<CreationReferenceAttachmentState> getEntries() {
        return b;
    }

    static {
        CreationReferenceAttachmentState r0 = new CreationReferenceAttachmentState("SELECTED", 0);
        SELECTED = r0;
        CreationReferenceAttachmentState r1 = new CreationReferenceAttachmentState("COMPRESSING", 1);
        COMPRESSING = r1;
        CreationReferenceAttachmentState r3 = new CreationReferenceAttachmentState("UPLOADING", 2);
        UPLOADING = r3;
        CreationReferenceAttachmentState r5 = new CreationReferenceAttachmentState("UPLOAD_SUCCESS", 3);
        UPLOAD_SUCCESS = r5;
        CreationReferenceAttachmentState r7 = new CreationReferenceAttachmentState("UPLOAD_FAILED", 4);
        UPLOAD_FAILED = r7;
        CreationReferenceAttachmentState r9 = new CreationReferenceAttachmentState("PARSE_FAILED", 5);
        PARSE_FAILED = r9;
        CreationReferenceAttachmentState r11 = new CreationReferenceAttachmentState("INSPECT_FAILED", 6);
        INSPECT_FAILED = r11;
        CreationReferenceAttachmentState r13 = new CreationReferenceAttachmentState("EXPIRED", 7);
        EXPIRED = r13;
        CreationReferenceAttachmentState r15 = new CreationReferenceAttachmentState("UNKNOWN", 8);
        UNKNOWN = r15;
        CreationReferenceAttachmentState[] r14 = {r0, r1, r3, r5, r7, r9, r11, r13, r15};
        a = r14;
        b = EnumEntriesKt.enumEntries(r14);
    }

    public static CreationReferenceAttachmentState[] values() {
        return (CreationReferenceAttachmentState[]) a.clone();
    }

    public static CreationReferenceAttachmentState valueOf(String r1) {
        return (CreationReferenceAttachmentState) a.a(CreationReferenceAttachmentState.class, r1);
    }

    public CreationReferenceAttachmentState(String r1, int r2) {
        super(r1, r2);
    }
}
