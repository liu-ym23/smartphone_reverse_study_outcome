package com.larus.platform.model.preview;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/platform/model/preview/AttachmentUploadState;", "", "<init>", "(Ljava/lang/String;I)V", "NOT_UPLOADED", "UPLOADING", "UPLOADED", "SEND_PIPELINE_OWNED", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum AttachmentUploadState extends Enum<AttachmentUploadState> {
    public static final AttachmentUploadState NOT_UPLOADED = null;
    public static final AttachmentUploadState SEND_PIPELINE_OWNED = null;
    public static final AttachmentUploadState UPLOADED = null;
    public static final AttachmentUploadState UPLOADING = null;
    public static final /* synthetic */ AttachmentUploadState[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<AttachmentUploadState> getEntries() {
        return b;
    }

    static {
        AttachmentUploadState r0 = new AttachmentUploadState("NOT_UPLOADED", 0);
        NOT_UPLOADED = r0;
        AttachmentUploadState r1 = new AttachmentUploadState("UPLOADING", 1);
        UPLOADING = r1;
        AttachmentUploadState r3 = new AttachmentUploadState("UPLOADED", 2);
        UPLOADED = r3;
        AttachmentUploadState r5 = new AttachmentUploadState("SEND_PIPELINE_OWNED", 3);
        SEND_PIPELINE_OWNED = r5;
        AttachmentUploadState[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static AttachmentUploadState[] values() {
        return (AttachmentUploadState[]) a.clone();
    }

    public static AttachmentUploadState valueOf(String r1) {
        return (AttachmentUploadState) a.a(AttachmentUploadState.class, r1);
    }

    public AttachmentUploadState(String r1, int r2) {
        super(r1, r2);
    }
}
