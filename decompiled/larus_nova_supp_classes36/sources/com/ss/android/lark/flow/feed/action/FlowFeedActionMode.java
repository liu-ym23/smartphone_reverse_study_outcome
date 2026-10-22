package com.ss.android.lark.flow.feed.action;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\rj\u0002\b\u0004j\u0002\b\u0005¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/flow/feed/action/FlowFeedActionMode;", "", "<init>", "(Ljava/lang/String;I)V", "MAIN_FEED", "SIDEBAR", "sourceTag", "", "getSourceTag", "()Ljava/lang/String;", "supportLeftSwipe", "", "getSupportLeftSwipe", "()Z", "flow-feed_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final enum FlowFeedActionMode extends Enum<FlowFeedActionMode> {
    public static final FlowFeedActionMode MAIN_FEED = null;
    public static final FlowFeedActionMode SIDEBAR = null;
    public static final /* synthetic */ FlowFeedActionMode[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[FlowFeedActionMode.values().length];
            r0[FlowFeedActionMode.MAIN_FEED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[FlowFeedActionMode.SIDEBAR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public static EnumEntries<FlowFeedActionMode> getEntries() {
        return b;
    }

    static {
        FlowFeedActionMode r0 = new FlowFeedActionMode("MAIN_FEED", 0);
        MAIN_FEED = r0;
        FlowFeedActionMode r1 = new FlowFeedActionMode("SIDEBAR", 1);
        SIDEBAR = r1;
        FlowFeedActionMode[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static FlowFeedActionMode[] values() {
        return (FlowFeedActionMode[]) a.clone();
    }

    public final String getSourceTag() {
        int r0 = a.a[ordinal()];
        if (r0 != 1) goto L5;
        return "feed";
    L5:
        if (r0 != 2) goto L8;
        return "feed_sidebar";
    L8:
        throw new NoWhenBranchMatchedException();
    }

    public final boolean getSupportLeftSwipe() {
        if (this != MAIN_FEED) goto L5;
        return true;
    L5:
        return false;
    }

    public static FlowFeedActionMode valueOf(String r1) {
        return (FlowFeedActionMode) r27.a.a(FlowFeedActionMode.class, r1);
    }

    public FlowFeedActionMode(String r1, int r2) {
        super(r1, r2);
    }
}
