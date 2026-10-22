package com.larus.bmhome.chat.component.bottom.attachment.entity;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0017B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0010J\u0006\u0010\u0012\u001a\u00020\u0010J\u0006\u0010\u0013\u001a\u00020\u0010J\u0006\u0010\u0014\u001a\u00020\u0010J\u0006\u0010\u0015\u001a\u00020\u0010J\u0006\u0010\u0016\u001a\u00020\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0018"}, d2 = {"Lcom/larus/bmhome/chat/component/bottom/attachment/entity/AttachmentPanelType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "Unknown", "SingleImage", "MultiImage", "MultiFile", "MixImageFile", "MultiAudio", "SingleFile", "isSingleImage", "", "isUnknown", "isMultiImage", "isMultiFile", "isMultiAudio", "isMixImageFile", "isSingleFile", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum AttachmentPanelType extends Enum<AttachmentPanelType> {
    public static final a Companion = null;
    public static final AttachmentPanelType MixImageFile = null;
    public static final AttachmentPanelType MultiAudio = null;
    public static final AttachmentPanelType MultiFile = null;
    public static final AttachmentPanelType MultiImage = null;
    public static final AttachmentPanelType SingleFile = null;
    public static final AttachmentPanelType SingleImage = null;
    public static final AttachmentPanelType Unknown = null;
    public static final /* synthetic */ AttachmentPanelType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static EnumEntries<AttachmentPanelType> getEntries() {
        return b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.bmhome.chat.component.bottom.attachment.entity.AttachmentPanelType$a] */
    static {
        AttachmentPanelType r0 = new AttachmentPanelType("Unknown", 0, 0);
        Unknown = r0;
        AttachmentPanelType r1 = new AttachmentPanelType("SingleImage", 1, 1);
        SingleImage = r1;
        AttachmentPanelType r3 = new AttachmentPanelType("MultiImage", 2, 2);
        MultiImage = r3;
        AttachmentPanelType r5 = new AttachmentPanelType("MultiFile", 3, 3);
        MultiFile = r5;
        AttachmentPanelType r7 = new AttachmentPanelType("MixImageFile", 4, 4);
        MixImageFile = r7;
        AttachmentPanelType r9 = new AttachmentPanelType("MultiAudio", 5, 5);
        MultiAudio = r9;
        AttachmentPanelType r11 = new AttachmentPanelType("SingleFile", 6, 6);
        SingleFile = r11;
        AttachmentPanelType[] r13 = {r0, r1, r3, r5, r7, r9, r11};
        a = r13;
        b = EnumEntriesKt.enumEntries(r13);
        Companion = new a();
    }

    public static AttachmentPanelType[] values() {
        return (AttachmentPanelType[]) a.clone();
    }

    public final boolean isMixImageFile() {
        if (this != MixImageFile) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isMultiAudio() {
        if (this != MultiAudio) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isMultiFile() {
        if (this != MultiFile) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isMultiImage() {
        if (this != MultiImage) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isSingleFile() {
        if (this != SingleFile) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isSingleImage() {
        if (this != SingleImage) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isUnknown() {
        if (this != Unknown) goto L5;
        return true;
    L5:
        return false;
    }

    public final int getValue() {
        return this.value;
    }

    public static AttachmentPanelType valueOf(String r1) {
        return (AttachmentPanelType) r27.a.a(AttachmentPanelType.class, r1);
    }

    public AttachmentPanelType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
