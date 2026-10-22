package com.larus.bmhome.chat.component.bottom.core.inputtext.mention;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0082\u0081\u0002\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0011B\u001b\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0012"}, d2 = {"Lcom/larus/bmhome/chat/component/bottom/core/inputtext/mention/MentionSearchResultType;", "", "protocolValue", "", "domain", "Lcom/larus/bmhome/chat/component/bottom/core/inputtext/mention/MentionSearchDomain;", "<init>", "(Ljava/lang/String;IILcom/larus/bmhome/chat/component/bottom/core/inputtext/mention/MentionSearchDomain;)V", "getProtocolValue", "()I", "getDomain", "()Lcom/larus/bmhome/chat/component/bottom/core/inputtext/mention/MentionSearchDomain;", "UNKNOWN", "DRIVE", "CONTACT", "CONVERSATION", "GROUP", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
final enum MentionSearchResultType extends Enum<MentionSearchResultType> {
    public static final MentionSearchResultType CONTACT = null;
    public static final MentionSearchResultType CONVERSATION = null;
    public static final a Companion = null;
    public static final MentionSearchResultType DRIVE = null;
    public static final MentionSearchResultType GROUP = null;
    public static final MentionSearchResultType UNKNOWN = null;
    public static final /* synthetic */ MentionSearchResultType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final MentionSearchDomain domain;
    private final int protocolValue;

    public static final class a {
        public a() {
        }

        public static MentionSearchResultType a(int r6) {
            MentionSearchResultType[] r0 = MentionSearchResultType.values();
            int r1 = r0.length;
            int r3 = 0;
        L3:
            if (r3 >= r1) goto L11;
            MentionSearchResultType r4 = r0[r3];
            if (r4.getProtocolValue() != r6) goto L7;
            boolean r5 = true;
        L8:
            if (r5 == true) goto L12;
            r3 = r3 + 1;
        L12:
            if (r4 == null) goto L14;
            return r4;
        L14:
            return MentionSearchResultType.UNKNOWN;
        L7:
            r5 = false;
            goto L8
        L11:
            r4 = null;
            goto L12
        }
    }

    public static EnumEntries<MentionSearchResultType> getEntries() {
        return b;
    }

    static {
        MentionSearchResultType r0 = new MentionSearchResultType("UNKNOWN", 0, 0, null);
        UNKNOWN = r0;
        MentionSearchResultType r1 = new MentionSearchResultType("DRIVE", 1, 2, MentionSearchDomain.DRIVE);
        DRIVE = r1;
        MentionSearchResultType r2 = new MentionSearchResultType("CONTACT", 2, 4, MentionSearchDomain.CONTACT);
        CONTACT = r2;
        MentionSearchResultType r4 = new MentionSearchResultType("CONVERSATION", 3, 5, MentionSearchDomain.CONVERSATION);
        CONVERSATION = r4;
        MentionSearchResultType r7 = new MentionSearchResultType("GROUP", 4, 6, MentionSearchDomain.GROUP);
        GROUP = r7;
        MentionSearchResultType[] r9 = {r0, r1, r2, r4, r7};
        a = r9;
        b = EnumEntriesKt.enumEntries(r9);
        Companion = new a();
    }

    public static MentionSearchResultType[] values() {
        return (MentionSearchResultType[]) a.clone();
    }

    public final MentionSearchDomain getDomain() {
        return this.domain;
    }

    public final int getProtocolValue() {
        return this.protocolValue;
    }

    public static MentionSearchResultType valueOf(String r1) {
        return (MentionSearchResultType) r27.a.a(MentionSearchResultType.class, r1);
    }

    public MentionSearchResultType(String r1, int r2, int r3, MentionSearchDomain r4) {
        super(r1, r2);
        this.protocolValue = r3;
        this.domain = r4;
    }
}
