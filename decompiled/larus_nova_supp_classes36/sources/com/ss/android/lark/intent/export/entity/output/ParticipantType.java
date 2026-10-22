package com.ss.android.lark.intent.export.entity.output;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/intent/export/entity/output/ParticipantType;", "", "<init>", "(Ljava/lang/String;I)V", "CHATTER", "CHAT", "intent-export_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final enum ParticipantType extends Enum<ParticipantType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ ParticipantType[] $VALUES = null;
    public static final ParticipantType CHAT = null;
    public static final ParticipantType CHATTER = null;

    private static final /* synthetic */ ParticipantType[] $values() {
        return new ParticipantType[]{CHATTER, CHAT};
    }

    public static EnumEntries<ParticipantType> getEntries() {
        return $ENTRIES;
    }

    static {
        CHATTER = new ParticipantType("CHATTER", 0);
        CHAT = new ParticipantType("CHAT", 1);
        ParticipantType[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries(r0);
    }

    public static ParticipantType[] values() {
        return (ParticipantType[]) $VALUES.clone();
    }

    public static ParticipantType valueOf(String r1) {
        return (ParticipantType) a.a(ParticipantType.class, r1);
    }

    private ParticipantType(String r1, int r2) {
        super(r1, r2);
    }
}
