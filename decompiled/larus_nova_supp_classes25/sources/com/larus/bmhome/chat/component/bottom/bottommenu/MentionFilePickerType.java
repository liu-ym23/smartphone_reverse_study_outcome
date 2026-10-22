package com.larus.bmhome.chat.component.bottom.bottommenu;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/bmhome/chat/component/bottom/bottommenu/MentionFilePickerType;", "", "<init>", "(Ljava/lang/String;I)V", "CAMERA", "ALBUM", "FILE", "api_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum MentionFilePickerType extends Enum<MentionFilePickerType> {
    public static final MentionFilePickerType ALBUM = null;
    public static final MentionFilePickerType CAMERA = null;
    public static final MentionFilePickerType FILE = null;
    public static final /* synthetic */ MentionFilePickerType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<MentionFilePickerType> getEntries() {
        return b;
    }

    static {
        MentionFilePickerType r0 = new MentionFilePickerType("CAMERA", 0);
        CAMERA = r0;
        MentionFilePickerType r1 = new MentionFilePickerType("ALBUM", 1);
        ALBUM = r1;
        MentionFilePickerType r3 = new MentionFilePickerType("FILE", 2);
        FILE = r3;
        MentionFilePickerType[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static MentionFilePickerType[] values() {
        return (MentionFilePickerType[]) a.clone();
    }

    public static MentionFilePickerType valueOf(String r1) {
        return (MentionFilePickerType) r27.a.a(MentionFilePickerType.class, r1);
    }

    public MentionFilePickerType(String r1, int r2) {
        super(r1, r2);
    }
}
