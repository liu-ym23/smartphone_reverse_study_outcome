package com.larus.bmhome.chat.component.bottom.core.inputtext.mention;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/bmhome/chat/component/bottom/core/inputtext/mention/MentionSearchDomain;", "", "key", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getKey", "()Ljava/lang/String;", "CONTACT", "GROUP", "DRIVE", "CONVERSATION", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum MentionSearchDomain extends Enum<MentionSearchDomain> {
    public static final MentionSearchDomain CONTACT = null;
    public static final MentionSearchDomain CONVERSATION = null;
    public static final MentionSearchDomain DRIVE = null;
    public static final MentionSearchDomain GROUP = null;
    public static final /* synthetic */ MentionSearchDomain[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String key;

    public static EnumEntries<MentionSearchDomain> getEntries() {
        return b;
    }

    static {
        MentionSearchDomain r0 = new MentionSearchDomain("CONTACT", 0, "contact");
        CONTACT = r0;
        MentionSearchDomain r1 = new MentionSearchDomain("GROUP", 1, "group");
        GROUP = r1;
        MentionSearchDomain r2 = new MentionSearchDomain("DRIVE", 2, "drive");
        DRIVE = r2;
        MentionSearchDomain r4 = new MentionSearchDomain("CONVERSATION", 3, "conversation");
        CONVERSATION = r4;
        MentionSearchDomain[] r6 = {r0, r1, r2, r4};
        a = r6;
        b = EnumEntriesKt.enumEntries(r6);
    }

    public static MentionSearchDomain[] values() {
        return (MentionSearchDomain[]) a.clone();
    }

    public final String getKey() {
        return this.key;
    }

    public static MentionSearchDomain valueOf(String r1) {
        return (MentionSearchDomain) r27.a.a(MentionSearchDomain.class, r1);
    }

    public MentionSearchDomain(String r1, int r2, String r3) {
        super(r1, r2);
        this.key = r3;
    }
}
