package com.ss.android.lark.inline.ai.logic;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/inline/ai/logic/FeedBackChoice;", "", "<init>", "(Ljava/lang/String;I)V", "Unselected", "Like", "Unlike", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final enum FeedBackChoice extends Enum<FeedBackChoice> {
    public static final FeedBackChoice Like = null;
    public static final FeedBackChoice Unlike = null;
    public static final FeedBackChoice Unselected = null;
    public static final /* synthetic */ FeedBackChoice[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<FeedBackChoice> getEntries() {
        return b;
    }

    static {
        FeedBackChoice r0 = new FeedBackChoice("Unselected", 0);
        Unselected = r0;
        FeedBackChoice r1 = new FeedBackChoice("Like", 1);
        Like = r1;
        FeedBackChoice r3 = new FeedBackChoice("Unlike", 2);
        Unlike = r3;
        FeedBackChoice[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static FeedBackChoice[] values() {
        return (FeedBackChoice[]) a.clone();
    }

    public static FeedBackChoice valueOf(String r1) {
        return (FeedBackChoice) r27.a.a(FeedBackChoice.class, r1);
    }

    public FeedBackChoice(String r1, int r2) {
        super(r1, r2);
    }
}
