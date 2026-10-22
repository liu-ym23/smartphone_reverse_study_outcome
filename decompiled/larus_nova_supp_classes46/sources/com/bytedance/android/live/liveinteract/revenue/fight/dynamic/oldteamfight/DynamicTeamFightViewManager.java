package com.bytedance.android.live.liveinteract.revenue.fight.dynamic.oldteamfight;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.user.UserAttr;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.liveinteract.api.fulllink.revenue.h;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.LinkMicRecyclerView;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.empty.MultiLinkCommonEmptyMicSeatBasicLayer;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.MultiLinkCommonGuestMicSeatBasicLayer;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g;
import com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r;
import com.bytedance.android.live.liveinteract.revenue.fight.view.TeamFightPKProgressLayout;
import com.bytedance.android.live.liveinteract.revenue.fight.view.TeamFightTitleLayout;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.LiveRoomPermission;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.List;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nh0.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/liveinteract/revenue/fight/dynamic/oldteamfight/DynamicTeamFightViewManager;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class DynamicTeamFightViewManager implements Observer<KVData> {
    public static final /* synthetic */ int s = 0;
    public final View a;
    public final FrameLayout b;
    public final ViewGroup c;
    public final ViewGroup d;
    public final TeamFightPKProgressLayout e;
    public final TeamFightTitleLayout f;
    public final IRoom g;
    public final boolean h;
    public boolean i;
    public long j;
    public final CompositeDisposable k;
    public Disposable l;
    public Disposable m;
    public String n;
    public final com.bytedance.android.live.liveinteract.revenue.fight.c o;
    public final LinkMicRecyclerView p;
    public final ViewGroup q;
    public final DataCenter r;

    public static final class a {
    }

    static {
    }

    public static boolean d() {
        boolean r0 = k.n(IMiddlewareUserService.class).user().isAdmin();
        IMiddlewareUserService r1 = k.f(IMiddlewareUserService.class);
        if (r1 == null) goto L12;
        com.bytedance.android.livesdk.user.e r2 = r1.user();
        if (r2 == null) goto L12;
        UserAttr r3 = r2.q();
        if (r3 == null) goto L12;
        List r4 = r3.getAdminPrivileges();
        if (r4 == null) goto L12;
        LiveRoomPermission.D.getClass();
        if (r4.contains(Integer.valueOf(LiveRoomPermission.u.a)) != true) goto L12;
    L22:
        if (r0 == true) goto L26;
    L24:
        return false;
    L26:
        return true;
    L12:
        IMiddlewareUserService r5 = k.f(IMiddlewareUserService.class);
        if (r5 == null) goto L24;
        com.bytedance.android.livesdk.user.e r6 = r5.user();
        if (r6 == null) goto L24;
        UserAttr r7 = r6.q();
        if (r7 == null) goto L24;
        List r8 = r7.getAdminPrivileges();
        if (r8 == null) goto L24;
        LiveRoomPermission.D.getClass();
        if (r8.contains(Integer.valueOf(LiveRoomPermission.r.a)) != true) goto L24;
        goto L22
    }

    public final void a() {
        Disposable r0 = this.l;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        Disposable r1 = this.m;
        if (r1 == null) goto L9;
        r1.dispose();
        return;
    }

    public static void e(MultiLinkCommonEmptyMicSeatBasicLayer r3) {
        Intrinsics.checkNotNullParameter(r3, "layer");
        if (gh0.a.d() == false) goto L5;
        View r0 = r3.m(2131389540);
        View r1 = r3.m(2131389534);
        UIUtils.setViewVisibility(r0, 8);
        UIUtils.setViewVisibility(r1, 0);
    L5:
        View r4 = r3.m(2131389701);
        if (r4 == null) goto L9;
        r4.setAlpha(0.0f);
        return;
    }

    public static void g(pg0.b r2) {
        Intrinsics.checkNotNullParameter(r2, "layer");
        View r0 = r2.m(2131389701);
        if (r0 == null) goto L5;
        r0.setAlpha(0.0f);
    L5:
        View r1 = r2.m(2131389764);
        if (r1 == null) goto L8;
        r1.setAlpha(0.0f);
    L8:
        View r3 = r2.m(2131389660);
        if (r3 == null) goto L12;
        r3.setAlpha(0.0f);
        return;
    }

    public final void b(String r3) {
        Intrinsics.checkNotNullParameter(r3, "reason");
        ALogger.i("DynamicTeamFightViewManager", "clearTeamFightState fightShowing:" + this.i + " reason:" + r3);
        if (this.i == true) goto L5;
        return;
    L5:
        a();
        this.c.setVisibility(8);
        ViewGroup r4 = this.d;
        if (r4 == null) goto L8;
        r4.setVisibility(8);
    L8:
        this.e.setVisibility(8);
        this.e.f();
        this.i = false;
    }

    public final void onChanged(Object r5) {
        KVData r6 = (KVData) r5;
        ConstraintLayout.LayoutParams r0 = null;
        if (r6 == null) goto L5;
        String r1 = r6.getKey();
    L7:
        if (Intrinsics.areEqual(r1, "data_multi_link_dynamic_layout_info_change") == true) goto L9;
        return;
    L9:
        if (this.b == null) goto L32;
        f r7 = (f) r6.getData();
        if (r7 == null) goto L33;
        sf0.b r8 = r7.e;
        if (r8 == null) goto L27;
        ConstraintLayout.LayoutParams r2 = this.b.getLayoutParams();
        if ((r2 instanceof ConstraintLayout.LayoutParams) == false) goto L19;
        r0 = r2;
    L19:
        ConstraintLayout.LayoutParams r3 = r0;
        if (r3 == null) goto L29;
        int r4 = ((ViewGroup.MarginLayoutParams) r3).topMargin;
        sf0.c r9 = r8.c;
        if (r4 == r9.c) goto L24;
    L25:
        ConstraintLayout.LayoutParams r10 = new ConstraintLayout.LayoutParams(-1, r8.c.e);
        r10.topToTop = 0;
        r10.leftToLeft = 0;
        r10.rightToRight = 0;
        ((ViewGroup.MarginLayoutParams) r10).topMargin = r8.c.c;
        this.b.setLayoutParams(r10);
        return;
    L24:
        if (((ViewGroup.MarginLayoutParams) r3).height != r9.e) goto L25;
        return;
    L29:
        return;
    L27:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.linkbase.DynamicFrameInfo");
    L33:
        return;
    L32:
        return;
    L5:
        r1 = null;
        goto L7
    }

    public static void f(MultiLinkCommonGuestMicSeatBasicLayer r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "layer");
        if (((r5 - 1) % 4) >= 2) goto L5;
        boolean r0 = true;
    L6:
        if (r5 == 0) goto L36;
        ViewGroup.LayoutParams r3 = null;
        if (r0 == false) goto L22;
        FrameLayout r6 = (FrameLayout) r4.m(2131389577);
        if (r6 == null) goto L12;
        ViewGroup.LayoutParams r1 = r6.getLayoutParams();
    L14:
        if ((r1 instanceof ConstraintLayout.LayoutParams) == false) goto L17;
        r3 = r1;
    L17:
        ConstraintLayout.LayoutParams r7 = (ConstraintLayout.LayoutParams) r3;
        if (r7 == null) goto L37;
        r7.leftToLeft = 2131374064;
        r7.rightToRight = -1;
        if (r6 == null) goto L38;
        r6.setLayoutParams(r7);
        return;
    L38:
        return;
    L37:
        return;
    L12:
        r1 = null;
        goto L14
    L22:
        FrameLayout r8 = (FrameLayout) r4.m(2131389577);
        if (r8 == null) goto L25;
        ViewGroup.LayoutParams r2 = r8.getLayoutParams();
    L27:
        if ((r2 instanceof ConstraintLayout.LayoutParams) == false) goto L30;
        r3 = r2;
    L30:
        ConstraintLayout.LayoutParams r9 = (ConstraintLayout.LayoutParams) r3;
        if (r9 == null) goto L40;
        r9.rightToRight = 2131374064;
        r9.leftToLeft = -1;
        if (r8 == null) goto L41;
        r8.setLayoutParams(r9);
        return;
    L41:
        return;
    L40:
        return;
    L25:
        r2 = null;
        goto L27
    L36:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void c(com.bytedance.android.live.liveinteract.multiscene.a r5, String r6) {
        if (this.i == false) goto L6;
        return;
    L6:
        if (li0.d.g(r5) == false) goto L8;
        return;
    L8:
        ALogger.w("DynamicTeamFightViewManager", "首次创建团战:上报uiRenderStart from=".concat(r6));
        int r7 = h.a;
        int r8 = 0;
        UIUtils.setViewVisibility(this.c, 0);
        UIUtils.setViewVisibility(this.d, 0);
        this.i = true;
        h.b(this.e);
        RecyclerView r9 = this.p;
        if (r9 == null) goto L30;
        int r0 = r9.getChildCount();
    L11:
        if (r8 >= r0) goto L36;
        hg0.b r1 = r9.findViewHolderForAdapterPosition(r8);
        if ((r1 instanceof hg0.b) == false) goto L29;
        hg0.b r2 = r1;
        g r3 = r2.l().h();
        if (r3 != null) goto L17;
    L19:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.empty.b r4 = r2.l().g();
        if (r4 != null) goto L22;
    L24:
        pg0.e r10 = r2.l().s();
        if (r10 == null) goto L29;
        if ((r10 instanceof pg0.b) == false) goto L29;
        g((pg0.b) r10);
        goto L29
    L22:
        if ((r4 instanceof MultiLinkCommonEmptyMicSeatBasicLayer) == false) goto L24;
        e((MultiLinkCommonEmptyMicSeatBasicLayer) r4);
        goto L24
    L17:
        if ((r3 instanceof MultiLinkCommonGuestMicSeatBasicLayer) == false) goto L19;
        f((MultiLinkCommonGuestMicSeatBasicLayer) r3, r8);
    L29:
        r8 = r8 + 1;
        goto L11
    L36:
        return;
    }

    public DynamicTeamFightViewManager(com.bytedance.android.live.liveinteract.revenue.fight.c r5, LinkMicRecyclerView r6, ViewGroup r7, DataCenter r8) {
        Intrinsics.checkNotNullParameter(r5, "widget");
        Intrinsics.checkNotNullParameter(r7, "rootView");
        Intrinsics.checkNotNullParameter(r8, "dataCenter");
        this.o = r5;
        this.p = r6;
        this.q = r7;
        this.r = r8;
        View r9 = r7.findViewById(2131376695);
        this.a = r9;
        this.b = (FrameLayout) r7.findViewById(2131372816);
        this.c = (ViewGroup) r7.findViewById(2131388289);
        this.d = (ViewGroup) r7.findViewById(2131392767);
        TeamFightPKProgressLayout r10 = (TeamFightPKProgressLayout) r7.findViewById(2131388290);
        this.e = r10;
        TeamFightTitleLayout r11 = (TeamFightTitleLayout) r7.findViewById(2131388293);
        this.f = r11;
        IRoom r0 = a0.n(r8);
        this.g = r0;
        boolean r2 = a0.d(r8, false);
        this.h = r2;
        this.k = new CompositeDisposable();
        this.n = "";
        r10.e(r2);
        if (r2 == false) goto L5;
    L8:
        boolean r3 = true;
    L9:
        r11.b = r3;
        r11.setOnClickListener(x0.a(new AnonymousClass1(this)));
        r8.observe("data_multi_fight_profit_egg", new com.bytedance.android.live.liveinteract.revenue.fight.dynamic.oldteamfight.a(this));
        ConstraintLayout.LayoutParams r12 = r9.getLayoutParams();
        if (r12 == null) goto L20;
        ConstraintLayout.LayoutParams r13 = r12;
        if (r0.isLiveTypeAudio() == false) goto L14;
        r13.matchConstraintPercentHeight = 0.379f;
        r9.setLayoutParams(r13);
    L16:
        if (r.j(null, 0, 7) == false) goto L21;
        r8.observe("data_multi_link_dynamic_layout_info_change", this, true);
        return;
    L21:
        return;
    L14:
        r13.matchConstraintPercentHeight = 0.333f;
        r9.setLayoutParams(r13);
        goto L16
    L20:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L5:
        if (d() == true) goto L8;
        r3 = false;
        goto L9
    }
}
