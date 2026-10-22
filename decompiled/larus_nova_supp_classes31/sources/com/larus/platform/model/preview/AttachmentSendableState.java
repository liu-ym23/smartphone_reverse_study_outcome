package com.larus.platform.model.preview;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/platform/model/preview/AttachmentSendableState;", "", "<init>", "(Ljava/lang/String;I)V", "SENDABLE", "NEEDS_MATERIALIZE", "NOT_SENDABLE", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum AttachmentSendableState extends Enum<AttachmentSendableState> {
    public static final AttachmentSendableState NEEDS_MATERIALIZE = null;
    public static final AttachmentSendableState NOT_SENDABLE = null;
    public static final AttachmentSendableState SENDABLE = null;
    public static final /* synthetic */ AttachmentSendableState[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<AttachmentSendableState> getEntries() {
        return b;
    }

    static {
        AttachmentSendableState r0 = new AttachmentSendableState("SENDABLE", 0);
        SENDABLE = r0;
        AttachmentSendableState r1 = new AttachmentSendableState("NEEDS_MATERIALIZE", 1);
        NEEDS_MATERIALIZE = r1;
        AttachmentSendableState r3 = new AttachmentSendableState("NOT_SENDABLE", 2);
        NOT_SENDABLE = r3;
        AttachmentSendableState[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static AttachmentSendableState[] values() {
        return (AttachmentSendableState[]) a.clone();
    }

    public static AttachmentSendableState valueOf(String r1) {
        return (AttachmentSendableState) a.a(AttachmentSendableState.class, r1);
    }

    public AttachmentSendableState(String r1, int r2) {
        super(r1, r2);
    }
}
