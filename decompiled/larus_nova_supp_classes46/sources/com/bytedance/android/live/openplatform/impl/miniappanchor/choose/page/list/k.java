package com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.list;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.broadcastgame.api.model.response.MiniAppEntrancePermissionResponse;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.openplatform.api.model.datacontext.AnchorMiniAppDataContext;
import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.model.MiniAppEntranceCell;
import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.list.adapter.RecentlyUsedListAdapter;
import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.utils.RecyclerViewScrollReportHelper;
import com.bytedance.android.livesdk.chatroom.ui.r5;
import com.bytedance.live.datacontext.n;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class k<T> implements Observer {
    public final /* synthetic */ MiniAppChooseListFragment a;

    public k(MiniAppChooseListFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r9) {
        b r10 = (b) r9;
        if ((r10 instanceof b.c) == false) goto L8;
        ((LinearLayout) this.a.T90(2131372192)).setVisibility(8);
        ((LinearLayout) this.a.T90(2131383873)).setVisibility(0);
        b.c r11 = (b.c) r10;
        ((TextView) this.a.T90(2131383874)).setText(r11.b.name);
        RecentlyUsedListAdapter r0 = (RecentlyUsedListAdapter) this.a.i.getValue();
        List<MiniAppEntranceCell> r2 = r11.a;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r2, "data");
        r0.a = r2;
        r0.notifyDataSetChanged();
        RecyclerViewScrollReportHelper<MiniAppEntranceCell> r1 = this.a.j;
        if (r1 == null) goto L7;
        r1.d(r11.a);
    L7:
        this.a.T90(2131383875).post(new j(this));
        return;
    L8:
        boolean r3 = r10 instanceof b.a;
        if (r3 == false) goto L11;
    L12:
        ((LinearLayout) this.a.T90(2131383873)).setVisibility(8);
        String r4 = "";
        ((TextView) this.a.T90(2131383874)).setText("");
        RecentlyUsedListAdapter r12 = (RecentlyUsedListAdapter) this.a.i.getValue();
        List<MiniAppEntranceCell> r5 = CollectionsKt.emptyList();
        r12.getClass();
        Intrinsics.checkNotNullParameter(r5, "data");
        r12.a = r5;
        r12.notifyDataSetChanged();
        if (r3 == false) goto L49;
        AnchorMiniAppDataContext.Companion.getClass();
        AnchorMiniAppDataContext r13 = AnchorMiniAppDataContext.a.a();
        String r6 = null;
        if (r13 == null) goto L19;
        n<MiniAppEntrancePermissionResponse> r14 = r13.getEntranceInfo();
        if (r14 == null) goto L19;
        MiniAppEntrancePermissionResponse r15 = (MiniAppEntrancePermissionResponse) r14.getValue();
    L20:
        if (r15 != null) goto L22;
    L26:
        final MiniAppChooseListFragment r16 = this.a;
        MiniAppChooseListViewModel r7 = r16.h;
        if (r7 == null) goto L33;
        String r8 = r7.getFeatureTipContent();
        if (r8 == null) goto L33;
        r4 = r8;
    L33:
        if (TextUtils.isEmpty(r4) == false) goto L35;
        ((LinearLayout) r16.T90(2131372192)).setVisibility(8);
        return;
    L35:
        SpannableStringBuilder r17 = new SpannableStringBuilder();
        SpannableStringBuilder r18 = r17.append(r4);
        Context r19 = r16.getContext();
        if (r19 == null) goto L40;
        Resources r20 = r19.getResources();
        if (r20 == null) goto L40;
        r6 = r20.getString(2131920373);
    L40:
        r18.append(r6).append(".");
        Drawable r21 = s1.m(2131252372);
        r21.setBounds(0, 0, s1.f(6.0f), s1.f(6.0f));
        r17.setSpan(new ap0.a(r21), r17.length() - 1, r17.length(), 18);
        r17.setSpan(new r5(ColorProtector.parseColor("#FE2C55"), new MiniAppChooseListFragment$updateFeatureTip$clickableSpan$1(r16)), r17.length() - 5, r17.length(), 18);
        ((LinearLayout) r16.T90(2131372192)).setVisibility(0);
        TextView r22 = (TextView) ((LinearLayout) r16.T90(2131372192)).findViewById(2131372193);
        if (r22 == null) goto L43;
        r22.setMovementMethod(LinkMovementMethod.getInstance());
    L43:
        TextView r23 = (TextView) ((LinearLayout) r16.T90(2131372192)).findViewById(2131372193);
        if (r23 == null) goto L52;
        r23.setText(r17);
        return;
    L52:
        return;
    L22:
        if (r15.getPermitStatus() == 0) goto L26;
        if (r15.getPermitStatus() == 1) goto L26;
        ((LinearLayout) this.a.T90(2131372192)).setVisibility(8);
        return;
    L19:
        r15 = null;
        goto L20
    L49:
        return;
    L11:
        if (Intrinsics.areEqual(r10, b.C0144b.a) == true) goto L12;
    }
}
