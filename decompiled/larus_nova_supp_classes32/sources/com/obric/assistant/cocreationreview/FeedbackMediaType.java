package com.obric.assistant.cocreationreview;

import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/assistant/cocreationreview/FeedbackMediaType;", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Ljava/lang/String;I)V", "IMAGE", "VIDEO", "cocreationreview_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FeedbackMediaType extends Enum<FeedbackMediaType> {
    public static final FeedbackMediaType IMAGE = null;
    public static final FeedbackMediaType VIDEO = null;
    public static final /* synthetic */ FeedbackMediaType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<FeedbackMediaType> getEntries() {
        return b;
    }

    static {
        FeedbackMediaType r0 = new FeedbackMediaType("IMAGE", 0);
        IMAGE = r0;
        FeedbackMediaType r1 = new FeedbackMediaType("VIDEO", 1);
        VIDEO = r1;
        FeedbackMediaType[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static FeedbackMediaType[] values() {
        return (FeedbackMediaType[]) a.clone();
    }

    public static FeedbackMediaType valueOf(String r1) {
        return (FeedbackMediaType) r27.a.a(FeedbackMediaType.class, r1);
    }

    public FeedbackMediaType(String r1, int r2) {
        super(r1, r2);
    }
}
