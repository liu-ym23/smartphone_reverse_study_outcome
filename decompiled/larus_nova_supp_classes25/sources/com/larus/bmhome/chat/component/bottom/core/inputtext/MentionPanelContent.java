package com.larus.bmhome.chat.component.bottom.core.inputtext;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.markdown.memory.MemoryActionTag;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0080\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/larus/bmhome/chat/component/bottom/core/inputtext/MentionPanelContent;", "", "configValue", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getConfigValue", "()Ljava/lang/String;", "ADD", "ATTACHMENT", "CONTACT", "DRIVE", "CONVERSATION", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum MentionPanelContent extends Enum<MentionPanelContent> {
    public static final MentionPanelContent ADD = null;
    public static final MentionPanelContent ATTACHMENT = null;
    public static final MentionPanelContent CONTACT = null;
    public static final MentionPanelContent CONVERSATION = null;
    public static final a Companion = null;
    public static final MentionPanelContent DRIVE = null;
    public static final /* synthetic */ MentionPanelContent[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String configValue;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<MentionPanelContent> getEntries() {
        return b;
    }

    static {
        MentionPanelContent r0 = new MentionPanelContent("ADD", 0, MemoryActionTag.MEMORY_ACTION_TAG_ADD);
        ADD = r0;
        MentionPanelContent r1 = new MentionPanelContent("ATTACHMENT", 1, "attachment");
        ATTACHMENT = r1;
        MentionPanelContent r3 = new MentionPanelContent("CONTACT", 2, "contact");
        CONTACT = r3;
        MentionPanelContent r5 = new MentionPanelContent("DRIVE", 3, "drive");
        DRIVE = r5;
        MentionPanelContent r7 = new MentionPanelContent("CONVERSATION", 4, "conversation");
        CONVERSATION = r7;
        MentionPanelContent[] r9 = {r0, r1, r3, r5, r7};
        a = r9;
        b = EnumEntriesKt.enumEntries(r9);
        Companion = new a();
    }

    public static MentionPanelContent[] values() {
        return (MentionPanelContent[]) a.clone();
    }

    public final String getConfigValue() {
        return this.configValue;
    }

    public static MentionPanelContent valueOf(String r1) {
        return (MentionPanelContent) r27.a.a(MentionPanelContent.class, r1);
    }

    public MentionPanelContent(String r1, int r2, String r3) {
        super(r1, r2);
        this.configValue = r3;
    }
}
