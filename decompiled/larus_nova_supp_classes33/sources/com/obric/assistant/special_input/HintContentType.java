package com.obric.assistant.special_input;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/obric/assistant/special_input/HintContentType;", "", "<init>", "(Ljava/lang/String;I)V", "OAUTO_CLARIFY_NO_BOLD", "OAUTO_CLARIFY_BOLD", "COMPLEX_TASK_NO_BOLD", "COMPLEX_TASK_CLARIFY_BOLD", "ADDITION", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum HintContentType extends Enum<HintContentType> {
    public static final HintContentType ADDITION = null;
    public static final HintContentType COMPLEX_TASK_CLARIFY_BOLD = null;
    public static final HintContentType COMPLEX_TASK_NO_BOLD = null;
    public static final HintContentType OAUTO_CLARIFY_BOLD = null;
    public static final HintContentType OAUTO_CLARIFY_NO_BOLD = null;
    public static final /* synthetic */ HintContentType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<HintContentType> getEntries() {
        return b;
    }

    static {
        HintContentType r0 = new HintContentType("OAUTO_CLARIFY_NO_BOLD", 0);
        OAUTO_CLARIFY_NO_BOLD = r0;
        HintContentType r1 = new HintContentType("OAUTO_CLARIFY_BOLD", 1);
        OAUTO_CLARIFY_BOLD = r1;
        HintContentType r3 = new HintContentType("COMPLEX_TASK_NO_BOLD", 2);
        COMPLEX_TASK_NO_BOLD = r3;
        HintContentType r5 = new HintContentType("COMPLEX_TASK_CLARIFY_BOLD", 3);
        COMPLEX_TASK_CLARIFY_BOLD = r5;
        HintContentType r7 = new HintContentType("ADDITION", 4);
        ADDITION = r7;
        HintContentType[] r9 = {r0, r1, r3, r5, r7};
        a = r9;
        b = EnumEntriesKt.enumEntries(r9);
    }

    public static HintContentType[] values() {
        return (HintContentType[]) a.clone();
    }

    public static HintContentType valueOf(String r1) {
        return (HintContentType) r27.a.a(HintContentType.class, r1);
    }

    public HintContentType(String r1, int r2) {
        super(r1, r2);
    }
}
