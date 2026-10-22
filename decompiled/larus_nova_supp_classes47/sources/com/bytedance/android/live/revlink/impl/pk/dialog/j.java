package com.bytedance.android.live.revlink.impl.pk.dialog;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.revlink.impl.pk.ui.PkItemExposeRecyclerView;
import com.bytedance.android.livesdk.link.model.IGroupRivals;
import com.bytedance.android.livesdk.link.model.IRivalRankRecommendResponse;
import com.bytedance.android.livesdk.link.model.m2;
import com.bytedance.android.livesdk.link.model.s2;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.multitype.MultiTypeAdapter;
import y31.v;
import y31.y;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class j<T> implements Consumer {
    public final /* synthetic */ PkRandomMatchDialogV2 a;

    public j(PkRandomMatchDialogV2 r1) {
        this.a = r1;
    }

    public final void accept(Object r13) {
        ExtraResponse r14 = (ExtraResponse) r13;
        PkRandomMatchDialogV2 r0 = this.a;
        if (r14 == null) goto L5;
        IRivalRankRecommendResponse r15 = (IRivalRankRecommendResponse) r14.data;
    L6:
        String r2 = PkRandomMatchDialogV2.r;
        r0.getClass();
        if (r15 == null) goto L48;
        ArrayList r3 = new ArrayList();
        s2 r4 = r15.getTabRivals();
        if (r4 == null) goto L13;
        Map r5 = r4.getGroupRivals();
        if (r5 == null) goto L13;
        IGroupRivals r6 = (IGroupRivals) r5.get(Long.valueOf(IGroupRivals.GroupType.GroupRivalsFeedAutoMatchSelfIn.ordinal()));
    L14:
        int r7 = 0;
        if (r6 == null) goto L30;
        List r8 = r6.getRivals();
        String r9 = r6.getGroupName();
        if (r9 != null) goto L19;
        r9 = s1.B(2131917920);
    L19:
        if (r9 != null) goto L21;
    L24:
        boolean r10 = true;
    L25:
        if (r10 == false) goto L27;
        r9 = s1.B(2131917920);
    L27:
        String r12 = r6.getImprId();
        if (r12 == null) goto L31;
    L32:
        y.a r16 = new y.a();
        r16.a = r9;
        r3.add(r16);
        if (r8 == null) goto L38;
        Iterator r17 = r8.iterator();
    L36:
        if (r17.hasNext() == false) goto L38;
        m2 r18 = (m2) r17.next();
        y31.k r19 = new y31.k();
        r19.b = r18.getRoom();
        r19.e = r18.getServerInviteType();
        r19.f = r18.getRivalExtraInfo();
        r19.h = r18.getBattleRivalTagList();
        r19.a = r18;
        r19.j = true;
        Intrinsics.checkNotNullParameter("", "<set-?>");
        r19.k = "";
        r19.l = null;
        r19.n = 2;
        r19.g = 2;
        r15.getSkinType();
        Intrinsics.checkNotNullParameter(r12, "<set-?>");
        r19.i = r12;
        r19.r = r7;
        r19.s = r18.getRankSeasonInfo();
        r3.add(r19);
        r7 = r7 + 1;
    L38:
        v.a r110 = new v.a();
        r110.a = s1.B(2131921491);
        r3.add(r110);
        r0.k = r3;
        PkItemExposeRecyclerView r111 = r0.i;
        if (r111 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
    L41:
        r111.r();
        MultiTypeAdapter r112 = r0.j;
        if (r112 == null) goto L44;
        r112.a = r3;
    L44:
        if (r112 == null) goto L49;
        r112.notifyDataSetChanged();
        return;
    L49:
        return;
    L31:
        r12 = "";
        goto L32
    L21:
        if (r9.length() == 0) goto L24;
        r10 = false;
        goto L25
    L30:
        r8 = null;
        r9 = null;
    L13:
        r6 = null;
        goto L14
    L48:
        return;
    L5:
        r15 = null;
        goto L6
    }
}
