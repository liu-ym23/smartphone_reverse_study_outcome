package com.obric.assistant.cocreationreview;

import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0080\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/obric/assistant/cocreationreview/CocreationReviewEntrySource;", NameKeys.UnloadStrategy_No_Strategy, "trackValue", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getTrackValue", "()Ljava/lang/String;", "PUSH", "NORMAL", "Companion", "cocreationreview_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CocreationReviewEntrySource extends Enum<CocreationReviewEntrySource> {
    public static final a Companion = null;
    public static final CocreationReviewEntrySource NORMAL = null;
    public static final CocreationReviewEntrySource PUSH = null;
    public static final /* synthetic */ CocreationReviewEntrySource[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String trackValue;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<CocreationReviewEntrySource> getEntries() {
        return b;
    }

    static {
        CocreationReviewEntrySource r0 = new CocreationReviewEntrySource("PUSH", 0, "outer_push");
        PUSH = r0;
        CocreationReviewEntrySource r1 = new CocreationReviewEntrySource("NORMAL", 1, "normal");
        NORMAL = r1;
        CocreationReviewEntrySource[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
        Companion = new a();
    }

    public static CocreationReviewEntrySource[] values() {
        return (CocreationReviewEntrySource[]) a.clone();
    }

    public final String getTrackValue() {
        return this.trackValue;
    }

    public static CocreationReviewEntrySource valueOf(String r1) {
        return (CocreationReviewEntrySource) r27.a.a(CocreationReviewEntrySource.class, r1);
    }

    public CocreationReviewEntrySource(String r1, int r2, String r3) {
        super(r1, r2);
        this.trackValue = r3;
    }
}
