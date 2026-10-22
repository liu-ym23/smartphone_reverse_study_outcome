package com.ss.android.lark.feed.shared.page.binder2;

import android.view.View;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.feed.export.feedcard.action.FeedActionType;
import com.ss.android.lark.feed.shared.hitpoint.FeedHitPointNew;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.Statistics;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.collections.CollectionsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class f implements View.OnLongClickListener {
    public final /* synthetic */ FeedCommonViewHolder a;
    public final /* synthetic */ UIFeedCard b;
    public final /* synthetic */ seb.b c;
    public final /* synthetic */ ueb.a d;
    public final /* synthetic */ aeb.a e;

    public f(FeedCommonViewHolder r1, UIFeedCard r2, seb.b r3, ueb.a r4, e r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r13) {
        aeb.f r14 = this.a.z;
        if (r14 == null) goto L5;
        List<FeedActionType> r15 = r14.n(this.b);
    L7:
        if (r15 == null) goto L34;
        List<? extends FeedActionType> r16 = CollectionsKt.toMutableList(r15);
        if (this.c != null) goto L12;
        Log.e("FeedSharedModule_FeedCommonViewHolder", "manager is null");
        return true;
    L12:
        seb.b.b(r16, this.d, true);
        seb.b r2 = this.c;
        aeb.f r3 = this.a.z;
        if (r3 == null) goto L15;
        List<aeb.c> r4 = r3.c();
    L16:
        LinkedHashMap<FeedActionType, aeb.c> r8 = r2.a(r16, r4);
        if (this.b.isSwipedLeftPinned() == true) goto L34;
        if (this.b.isSwipeRightPinned() == true) goto L34;
        if ((!r8.isEmpty()) == false) goto L34;
        FeedCommonViewHolder r17 = this.a;
        UIFeedCard r5 = this.b;
        ueb.a r6 = this.d;
        aeb.a r9 = this.e;
        r17.getClass();
        zeb.a r7 = r6.z();
        if (r7 == null) goto L25;
        r7.pauseDataChange();
    L25:
        zeb.b r10 = r6.f2();
        if (r10 == null) goto L28;
        r10.a();
    L28:
        r17.s.postDelayed(new g(r6, r17, r5, r8, r9), 50);
        int r11 = qeb.a.a;
        Statistics.sendEvent("feed_press_view", new JSONObject().put("action_location", "feed_item"));
        int r12 = com.ss.android.lark.feed.shared.hitpoint.a.a;
        FeedHitPointNew.c(FeedHitPointNew.FeedMainClickParam.FEED_PRESS, null, false, 14);
        aeb.f r0 = r17.z;
        if (r0 == null) goto L32;
        r0.a(r5);
    L32:
        if (((Boolean) r17.G.getValue()).booleanValue() == false) goto L34;
        r6.G1(new h(r17));
        goto L34
    L15:
        r4 = null;
    L34:
        return true;
    L5:
        r15 = null;
        goto L7
    }
}
