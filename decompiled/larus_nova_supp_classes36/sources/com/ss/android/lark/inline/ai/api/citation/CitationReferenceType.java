package com.ss.android.lark.inline.ai.api.citation;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0015"}, d2 = {"Lcom/ss/android/lark/inline/ai/api/citation/CitationReferenceType;", "", "type", "", "<init>", "(Ljava/lang/String;II)V", "getType", "()I", "Unknown", "Doc", "Message", "Lingo", "Helpdesk", "Outlink", "Minutes", "Comment", "Base", "Sheet", "Excel", "Mail", "People", "inline-ai-api_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final enum CitationReferenceType extends Enum<CitationReferenceType> {
    public static final CitationReferenceType Base = null;
    public static final CitationReferenceType Comment = null;
    public static final CitationReferenceType Doc = null;
    public static final CitationReferenceType Excel = null;
    public static final CitationReferenceType Helpdesk = null;
    public static final CitationReferenceType Lingo = null;
    public static final CitationReferenceType Mail = null;
    public static final CitationReferenceType Message = null;
    public static final CitationReferenceType Minutes = null;
    public static final CitationReferenceType Outlink = null;
    public static final CitationReferenceType People = null;
    public static final CitationReferenceType Sheet = null;
    public static final CitationReferenceType Unknown = null;
    public static final /* synthetic */ CitationReferenceType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int type;

    public static EnumEntries<CitationReferenceType> getEntries() {
        return b;
    }

    static {
        CitationReferenceType r0 = new CitationReferenceType("Unknown", 0, 0);
        Unknown = r0;
        CitationReferenceType r1 = new CitationReferenceType("Doc", 1, 1);
        Doc = r1;
        CitationReferenceType r3 = new CitationReferenceType("Message", 2, 2);
        Message = r3;
        CitationReferenceType r5 = new CitationReferenceType("Lingo", 3, 3);
        Lingo = r5;
        CitationReferenceType r7 = new CitationReferenceType("Helpdesk", 4, 4);
        Helpdesk = r7;
        CitationReferenceType r9 = new CitationReferenceType("Outlink", 5, 5);
        Outlink = r9;
        CitationReferenceType r11 = new CitationReferenceType("Minutes", 6, 6);
        Minutes = r11;
        CitationReferenceType r13 = new CitationReferenceType("Comment", 7, 7);
        Comment = r13;
        CitationReferenceType r15 = new CitationReferenceType("Base", 8, 8);
        Base = r15;
        CitationReferenceType r14 = new CitationReferenceType("Sheet", 9, 9);
        Sheet = r14;
        CitationReferenceType r12 = new CitationReferenceType("Excel", 10, 10);
        Excel = r12;
        CitationReferenceType r10 = new CitationReferenceType("Mail", 11, 11);
        Mail = r10;
        CitationReferenceType r8 = new CitationReferenceType("People", 12, 13);
        People = r8;
        CitationReferenceType[] r2 = {r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8};
        a = r2;
        b = EnumEntriesKt.enumEntries(r2);
    }

    public static CitationReferenceType[] values() {
        return (CitationReferenceType[]) a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public static CitationReferenceType valueOf(String r1) {
        return (CitationReferenceType) a.a(CitationReferenceType.class, r1);
    }

    public CitationReferenceType(String r1, int r2, int r3) {
        super(r1, r2);
        this.type = r3;
    }
}
