package com.larus.bmhome.chat.trace.multimodal;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/bmhome/chat/trace/multimodal/AttachmentAreaType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "NO_CLEAR", "NO_ATTACHMENT", "SINGLE_ATTACHMENT", "MULTI_ATTACHMENT", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AttachmentAreaType extends Enum<AttachmentAreaType> {
    public static final AttachmentAreaType MULTI_ATTACHMENT = null;
    public static final AttachmentAreaType NO_ATTACHMENT = null;
    public static final AttachmentAreaType NO_CLEAR = null;
    public static final AttachmentAreaType SINGLE_ATTACHMENT = null;
    public static final /* synthetic */ AttachmentAreaType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static EnumEntries<AttachmentAreaType> getEntries() {
        return b;
    }

    static {
        AttachmentAreaType r0 = new AttachmentAreaType("NO_CLEAR", 0, -1);
        NO_CLEAR = r0;
        AttachmentAreaType r1 = new AttachmentAreaType("NO_ATTACHMENT", 1, 0);
        NO_ATTACHMENT = r1;
        AttachmentAreaType r2 = new AttachmentAreaType("SINGLE_ATTACHMENT", 2, 1);
        SINGLE_ATTACHMENT = r2;
        AttachmentAreaType r5 = new AttachmentAreaType("MULTI_ATTACHMENT", 3, 2);
        MULTI_ATTACHMENT = r5;
        AttachmentAreaType[] r7 = {r0, r1, r2, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static AttachmentAreaType[] values() {
        return (AttachmentAreaType[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static AttachmentAreaType valueOf(String r1) {
        return (AttachmentAreaType) r27.a.a(AttachmentAreaType.class, r1);
    }

    public AttachmentAreaType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
