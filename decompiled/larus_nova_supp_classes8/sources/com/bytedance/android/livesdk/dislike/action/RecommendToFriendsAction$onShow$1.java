package com.bytedance.android.livesdk.dislike.action;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livehostapi.business.depend.dislike.ILiveRecommendToFriendsCallback;
import com.bytedance.android.livesdk.dislike.recommendlive.RecommendLiveHelper;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import java.util.HashMap;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class RecommendToFriendsAction$onShow$1 implements ILiveRecommendToFriendsCallback {
    public final /* synthetic */ RecommendToFriendsAction a;
    public final /* synthetic */ Function1 b;

    public final void onFailed() {
        Function1 r0 = this.b;
        if (r0 == null) goto L6;
        Unit r1 = (Unit) r0.invoke(new HashMap());
        return;
    }

    public final void onLiveRecommendSuccess(long r3) {
        int r0 = RecommendLiveHelper.a;
        final boolean r4 = RecommendLiveHelper.b(r3);
        Pair[] r5 = new Pair[2];
        if (r4 == false) goto L5;
        int r1 = 2131921924;
    L6:
        r5[0] = TuplesKt.to(LiveEndPageData.TAG_TITLE, s1.B(r1));
        r5[1] = TuplesKt.to("option_action", new RecommendToFriendsAction$onShow$1$onLiveRecommendSuccess$reloadMap$1(this, r4));
        HashMap r6 = MapsKt.hashMapOf(r5);
        Function1 r7 = this.b;
        if (r7 == null) goto L10;
        Unit r8 = (Unit) r7.invoke(r6);
        return;
    L10:
        return;
    L5:
        r1 = 2131921932;
        goto L6
    }

    public final void onSuccess(long r3) {
        int r0 = RecommendLiveHelper.a;
        final boolean r4 = RecommendLiveHelper.b(r3);
        Pair[] r5 = new Pair[2];
        if (r4 == false) goto L5;
        int r1 = 2131921924;
    L6:
        r5[0] = TuplesKt.to(LiveEndPageData.TAG_TITLE, s1.B(r1));
        r5[1] = TuplesKt.to("option_action", new RecommendToFriendsAction$onShow$1$onSuccess$reloadMap$1(this, r4));
        HashMap r6 = MapsKt.hashMapOf(r5);
        Function1 r7 = this.b;
        if (r7 == null) goto L10;
        Unit r8 = (Unit) r7.invoke(r6);
        return;
    L10:
        return;
    L5:
        r1 = 2131921932;
        goto L6
    }

    public RecommendToFriendsAction$onShow$1(RecommendToFriendsAction r1, Function1 r2) {
        this.a = r1;
        this.b = r2;
    }
}
