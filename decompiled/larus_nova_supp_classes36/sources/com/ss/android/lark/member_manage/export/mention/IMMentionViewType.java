package com.ss.android.lark.member_manage.export.mention;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0014\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0015"}, d2 = {"Lcom/ss/android/lark/member_manage/export/mention/IMMentionViewType;", "", "<init>", "(Ljava/lang/String;I)V", "ALL", "SECTION_TITLE", "SUPER_GROUP_TIPS", "LETTER", "AT_ALL", "CONTACT", "WIKI", "SIMPLE_TEXT", "INLINE_AI_ALL", "INLINE_AI_CONTRACT", "INLINE_AI_DOC", "AI_KNOWLEDGE_ALL", "AI_KNOWLEDGE_CONTRACT", "AI_KNOWLEDGE_DOC", "AI_KNOWLEDGE_GROUP", "AI_KNOWLEDGE_DEPARTMENT", "LOADING", "group-member-manage-export_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final enum IMMentionViewType extends Enum<IMMentionViewType> {
    public static final IMMentionViewType AI_KNOWLEDGE_ALL = null;
    public static final IMMentionViewType AI_KNOWLEDGE_CONTRACT = null;
    public static final IMMentionViewType AI_KNOWLEDGE_DEPARTMENT = null;
    public static final IMMentionViewType AI_KNOWLEDGE_DOC = null;
    public static final IMMentionViewType AI_KNOWLEDGE_GROUP = null;
    public static final IMMentionViewType ALL = null;
    public static final IMMentionViewType AT_ALL = null;
    public static final IMMentionViewType CONTACT = null;
    public static final IMMentionViewType INLINE_AI_ALL = null;
    public static final IMMentionViewType INLINE_AI_CONTRACT = null;
    public static final IMMentionViewType INLINE_AI_DOC = null;
    public static final IMMentionViewType LETTER = null;
    public static final IMMentionViewType LOADING = null;
    public static final IMMentionViewType SECTION_TITLE = null;
    public static final IMMentionViewType SIMPLE_TEXT = null;
    public static final IMMentionViewType SUPER_GROUP_TIPS = null;
    public static final IMMentionViewType WIKI = null;
    public static final /* synthetic */ IMMentionViewType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<IMMentionViewType> getEntries() {
        return b;
    }

    static {
        IMMentionViewType r0 = new IMMentionViewType("ALL", 0);
        ALL = r0;
        IMMentionViewType r1 = new IMMentionViewType("SECTION_TITLE", 1);
        SECTION_TITLE = r1;
        IMMentionViewType r3 = new IMMentionViewType("SUPER_GROUP_TIPS", 2);
        SUPER_GROUP_TIPS = r3;
        IMMentionViewType r5 = new IMMentionViewType("LETTER", 3);
        LETTER = r5;
        IMMentionViewType r7 = new IMMentionViewType("AT_ALL", 4);
        AT_ALL = r7;
        IMMentionViewType r9 = new IMMentionViewType("CONTACT", 5);
        CONTACT = r9;
        IMMentionViewType r11 = new IMMentionViewType("WIKI", 6);
        WIKI = r11;
        IMMentionViewType r13 = new IMMentionViewType("SIMPLE_TEXT", 7);
        SIMPLE_TEXT = r13;
        IMMentionViewType r15 = new IMMentionViewType("INLINE_AI_ALL", 8);
        INLINE_AI_ALL = r15;
        IMMentionViewType r14 = new IMMentionViewType("INLINE_AI_CONTRACT", 9);
        INLINE_AI_CONTRACT = r14;
        IMMentionViewType r12 = new IMMentionViewType("INLINE_AI_DOC", 10);
        INLINE_AI_DOC = r12;
        IMMentionViewType r10 = new IMMentionViewType("AI_KNOWLEDGE_ALL", 11);
        AI_KNOWLEDGE_ALL = r10;
        IMMentionViewType r8 = new IMMentionViewType("AI_KNOWLEDGE_CONTRACT", 12);
        AI_KNOWLEDGE_CONTRACT = r8;
        IMMentionViewType r6 = new IMMentionViewType("AI_KNOWLEDGE_DOC", 13);
        AI_KNOWLEDGE_DOC = r6;
        IMMentionViewType r4 = new IMMentionViewType("AI_KNOWLEDGE_GROUP", 14);
        AI_KNOWLEDGE_GROUP = r4;
        IMMentionViewType r2 = new IMMentionViewType("AI_KNOWLEDGE_DEPARTMENT", 15);
        AI_KNOWLEDGE_DEPARTMENT = r2;
        IMMentionViewType r16 = new IMMentionViewType("LOADING", 16);
        LOADING = r16;
        IMMentionViewType[] r17 = {r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4, r2, r16};
        a = r17;
        b = EnumEntriesKt.enumEntries(r17);
    }

    public static IMMentionViewType[] values() {
        return (IMMentionViewType[]) a.clone();
    }

    public static IMMentionViewType valueOf(String r1) {
        return (IMMentionViewType) a.a(IMMentionViewType.class, r1);
    }

    public IMMentionViewType(String r1, int r2) {
        super(r1, r2);
    }
}
