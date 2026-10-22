package com.larus.bmhome.chat.component.bottom.core.inputtext;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0080\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/larus/bmhome/chat/component/bottom/core/inputtext/SlashPanelContent;", "", "configValue", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getConfigValue", "()Ljava/lang/String;", "QUOTA", "PROJECT", "SKILL", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum SlashPanelContent extends Enum<SlashPanelContent> {
    public static final a Companion = null;
    public static final SlashPanelContent PROJECT = null;
    public static final SlashPanelContent QUOTA = null;
    public static final SlashPanelContent SKILL = null;
    public static final /* synthetic */ SlashPanelContent[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String configValue;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<SlashPanelContent> getEntries() {
        return b;
    }

    static {
        SlashPanelContent r0 = new SlashPanelContent("QUOTA", 0, "quota");
        QUOTA = r0;
        SlashPanelContent r1 = new SlashPanelContent("PROJECT", 1, "project");
        PROJECT = r1;
        SlashPanelContent r3 = new SlashPanelContent("SKILL", 2, "skill");
        SKILL = r3;
        SlashPanelContent[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
        Companion = new a();
    }

    public static SlashPanelContent[] values() {
        return (SlashPanelContent[]) a.clone();
    }

    public final String getConfigValue() {
        return this.configValue;
    }

    public static SlashPanelContent valueOf(String r1) {
        return (SlashPanelContent) r27.a.a(SlashPanelContent.class, r1);
    }

    public SlashPanelContent(String r1, int r2, String r3) {
        super(r1, r2);
        this.configValue = r3;
    }
}
