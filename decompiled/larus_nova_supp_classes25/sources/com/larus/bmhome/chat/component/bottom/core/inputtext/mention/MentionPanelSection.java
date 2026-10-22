package com.larus.bmhome.chat.component.bottom.core.inputtext.mention;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/bmhome/chat/component/bottom/core/inputtext/mention/MentionPanelSection;", "", "<init>", "(Ljava/lang/String;I)V", "ATTACHMENT", "CONTACT", "GROUP", "DRIVE", "CONVERSATION", "SKILL", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum MentionPanelSection extends Enum<MentionPanelSection> {
    public static final MentionPanelSection ATTACHMENT = null;
    public static final MentionPanelSection CONTACT = null;
    public static final MentionPanelSection CONVERSATION = null;
    public static final MentionPanelSection DRIVE = null;
    public static final MentionPanelSection GROUP = null;
    public static final MentionPanelSection SKILL = null;
    public static final /* synthetic */ MentionPanelSection[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<MentionPanelSection> getEntries() {
        return b;
    }

    static {
        MentionPanelSection r0 = new MentionPanelSection("ATTACHMENT", 0);
        ATTACHMENT = r0;
        MentionPanelSection r1 = new MentionPanelSection("CONTACT", 1);
        CONTACT = r1;
        MentionPanelSection r3 = new MentionPanelSection("GROUP", 2);
        GROUP = r3;
        MentionPanelSection r5 = new MentionPanelSection("DRIVE", 3);
        DRIVE = r5;
        MentionPanelSection r7 = new MentionPanelSection("CONVERSATION", 4);
        CONVERSATION = r7;
        MentionPanelSection r9 = new MentionPanelSection("SKILL", 5);
        SKILL = r9;
        MentionPanelSection[] r11 = {r0, r1, r3, r5, r7, r9};
        a = r11;
        b = EnumEntriesKt.enumEntries(r11);
    }

    public static MentionPanelSection[] values() {
        return (MentionPanelSection[]) a.clone();
    }

    public static MentionPanelSection valueOf(String r1) {
        return (MentionPanelSection) r27.a.a(MentionPanelSection.class, r1);
    }

    public MentionPanelSection(String r1, int r2) {
        super(r1, r2);
    }
}
