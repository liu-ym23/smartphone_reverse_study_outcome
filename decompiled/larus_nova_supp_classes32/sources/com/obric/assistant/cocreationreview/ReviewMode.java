package com.obric.assistant.cocreationreview;

import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/obric/assistant/cocreationreview/ReviewMode;", NameKeys.UnloadStrategy_No_Strategy, "label", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getLabel", "()Ljava/lang/String;", "QUEUE", "HISTORY", "cocreationreview_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ReviewMode extends Enum<ReviewMode> {
    public static final ReviewMode HISTORY = null;
    public static final ReviewMode QUEUE = null;
    public static final /* synthetic */ ReviewMode[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String label;

    public static EnumEntries<ReviewMode> getEntries() {
        return b;
    }

    static {
        ReviewMode r0 = new ReviewMode("QUEUE", 0, "待反馈");
        QUEUE = r0;
        ReviewMode r1 = new ReviewMode("HISTORY", 1, "已反馈");
        HISTORY = r1;
        ReviewMode[] r2 = {r0, r1};
        a = r2;
        b = EnumEntriesKt.enumEntries(r2);
    }

    public static ReviewMode[] values() {
        return (ReviewMode[]) a.clone();
    }

    public final String getLabel() {
        return this.label;
    }

    public static ReviewMode valueOf(String r1) {
        return (ReviewMode) r27.a.a(ReviewMode.class, r1);
    }

    public ReviewMode(String r1, int r2, String r3) {
        super(r1, r2);
        this.label = r3;
    }
}
