package com.obric.aiproactive.ui.entry;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¨\u0006\u0004"}, d2 = {"resolveNowVisualConfig", "Lcom/obric/aiproactive/ui/entry/NowVisualConfig;", "state", "Lcom/obric/aiproactive/ui/entry/NowFeedPageFragment$NowVisualState;", "ai_proactive_ui_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class t {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6636a = null;

        static {
            int[] r0 = new int[NowFeedPageFragment.NowVisualState.values().length];
            r0[NowFeedPageFragment.NowVisualState.SLEEP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[NowFeedPageFragment.NowVisualState.SENSING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[NowFeedPageFragment.NowVisualState.SUGGESTION.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[NowFeedPageFragment.NowVisualState.CELEBRATION.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f6636a = r0;
        }
    }

    public static final s a(NowFeedPageFragment.NowVisualState r1) {
        Intrinsics.checkNotNullParameter(r1, "state");
        int r2 = a.f6636a[r1.ordinal()];
        if (r2 == 1) goto L15;
        if (r2 == 2) goto L15;
        if (r2 == 3) goto L16;
        if (r2 == 4) goto L16;
        throw new NoWhenBranchMatchedException();
    L16:
        return s.f6634a.b();
    L15:
        return s.f6634a.a();
    }
}
