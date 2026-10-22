package com.ss.android.lark.flow.feed.sidebar.view;

import aeb.f;
import android.view.View;
import com.ss.android.lark.biz.im.api.FeedCard;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.feed.shared.hitpoint.FeedHitPointNew;
import com.ss.android.lark.statistics.Statistics;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.collections.CollectionsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c implements View.OnLongClickListener {
    public final /* synthetic */ UIFeedCard a;
    public final /* synthetic */ FeedSidebarCommonViewHolder b;
    public final /* synthetic */ seb.b c;
    public final /* synthetic */ ueb.a d;
    public final /* synthetic */ aeb.a e;

    public c(UIFeedCard r1, FeedSidebarCommonViewHolder r2, seb.b r3, ueb.a r4, FeedSidebarCommonViewHolder.d r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r12) {
        if (this.a.getType() != FeedCard.Type.DOUBAO_CONVERSATION) goto L8;
        deb.d r13 = this.b.a.b();
        if (r13 == null) goto L7;
        r13.a(this.b.c, this.a);
    L7:
        return true;
    L8:
        f r14 = this.b.l;
        if (r14 == null) goto L11;
        r14.a(this.a);
    L11:
        f r15 = this.b.l;
        if (r15 == null) goto L14;
        List r16 = r15.n(this.a);
    L15:
        if (r16 == null) goto L31;
        List r17 = CollectionsKt.toMutableList(r16);
        seb.b r2 = this.c;
        ueb.a r3 = this.d;
        int r4 = seb.b.d;
        r2.getClass();
        seb.b.b(r17, r3, true);
        seb.b r5 = this.c;
        f r6 = this.b.l;
        if (r6 == null) goto L19;
        List r7 = r6.c();
    L20:
        LinkedHashMap r8 = r5.a(r17, r7);
        if ((!r8.isEmpty()) == false) goto L31;
        FeedSidebarCommonViewHolder r18 = this.b;
        UIFeedCard r9 = this.a;
        ueb.a r10 = this.d;
        aeb.a r11 = this.e;
        r18.getClass();
        zeb.a r19 = r10.z();
        if (r19 == null) goto L25;
        r19.pauseDataChange();
    L25:
        zeb.b r20 = r10.f2();
        if (r20 == null) goto L28;
        r20.a();
    L28:
        r18.c.postDelayed(new d(r10, r18, r9, r8, r11), 50);
        int r21 = qeb.a.a;
        Statistics.sendEvent("feed_press_view", new JSONObject().put("action_location", "feed_item"));
        int r22 = com.ss.android.lark.feed.shared.hitpoint.a.a;
        FeedHitPointNew.c(FeedHitPointNew.FeedMainClickParam.FEED_PRESS, null, false, 14);
        if (((Boolean) r18.p.getValue()).booleanValue() == false) goto L31;
        r10.G1(new e(r18));
        goto L31
    L19:
        r7 = null;
    L31:
        return true;
    L14:
        r16 = null;
        goto L15
    }
}
