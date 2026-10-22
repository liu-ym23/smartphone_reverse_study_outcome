package com.ss.android.lark.inline.ai.logic;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/inline/ai/logic/InlineAIStatus;", "", "<init>", "(Ljava/lang/String;I)V", "Init", "Waiting", "PrepareWaiting", "Writing", "Finished", "Closed", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final enum InlineAIStatus extends Enum<InlineAIStatus> {
    public static final InlineAIStatus Closed = null;
    public static final InlineAIStatus Finished = null;
    public static final InlineAIStatus Init = null;
    public static final InlineAIStatus PrepareWaiting = null;
    public static final InlineAIStatus Waiting = null;
    public static final InlineAIStatus Writing = null;
    public static final /* synthetic */ InlineAIStatus[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<InlineAIStatus> getEntries() {
        return b;
    }

    static {
        InlineAIStatus r0 = new InlineAIStatus("Init", 0);
        Init = r0;
        InlineAIStatus r1 = new InlineAIStatus("Waiting", 1);
        Waiting = r1;
        InlineAIStatus r3 = new InlineAIStatus("PrepareWaiting", 2);
        PrepareWaiting = r3;
        InlineAIStatus r5 = new InlineAIStatus("Writing", 3);
        Writing = r5;
        InlineAIStatus r7 = new InlineAIStatus("Finished", 4);
        Finished = r7;
        InlineAIStatus r9 = new InlineAIStatus("Closed", 5);
        Closed = r9;
        InlineAIStatus[] r11 = {r0, r1, r3, r5, r7, r9};
        a = r11;
        b = EnumEntriesKt.enumEntries(r11);
    }

    public static InlineAIStatus[] values() {
        return (InlineAIStatus[]) a.clone();
    }

    public static InlineAIStatus valueOf(String r1) {
        return (InlineAIStatus) r27.a.a(InlineAIStatus.class, r1);
    }

    public InlineAIStatus(String r1, int r2) {
        super(r1, r2);
    }
}
