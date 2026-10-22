package com.bytedance.android.live.revlink.impl.pk.dialog.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.ui.BaseFragment;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.revenue.common.x0;
import com.bytedance.android.live.revenue.platform.hybrid.impl.ui.HybridDialogImpl;
import com.bytedance.android.live.revlink.impl.constants.RandomMatchCheckSource;
import com.bytedance.android.live.revlink.impl.control.dialog.LinkRevPanelDataContext;
import com.bytedance.android.live.revlink.impl.monitor.LiveFullLinkPKMonitor;
import com.bytedance.android.live.revlink.impl.multianchor.dialog.fragment.AnchorInteractContainerFragment;
import com.bytedance.android.live.revlink.impl.multianchor.service.RevLinkLayoutPreloadContext;
import com.bytedance.android.live.revlink.impl.pk.dialog.viewholder.PKExpandCollapseViewHolder;
import com.bytedance.android.live.revlink.impl.pk.dialog.vm.RevLinkAnchorBaseViewModel;
import com.bytedance.android.live.revlink.impl.pk.dialog.vm.RevLinkAnchorSubViewModel;
import com.bytedance.android.live.revlink.impl.pk.dialog.vm.RevLinkAnchorViewModel;
import com.bytedance.android.live.revlink.impl.pk.randompkcheck.RandomCheckDataContext;
import com.bytedance.android.live.revlink.impl.pk.randompkcheck.RandomPKCheckFragment;
import com.bytedance.android.live.revlink.impl.pk.ui.PKRankUnlockView;
import com.bytedance.android.live.revlink.impl.pk.ui.PkRandomView;
import com.bytedance.android.live.revlink.impl.pk.ui.PkTopTipView;
import com.bytedance.android.live.revlink.impl.pk.ui.TouchConflictPkExposeRecyclerView;
import com.bytedance.android.live.revlink.impl.pk.ui.TouchUpConflictTabLayout;
import com.bytedance.android.live.revlink.impl.pk.utils.FixedForAppBarLayoutManager;
import com.bytedance.android.live.ui.PkInviteUserListRefreshLayout;
import com.bytedance.android.live.uikit.viewpager.SSViewPager;
import com.bytedance.android.livesdk.chatroom.ui.LiveDoubleColorBallAnimationView;
import com.bytedance.android.livesdk.link.model.IPkSubTabKey;
import com.bytedance.android.livesdk.link.model.IRivalExtraInfo;
import com.bytedance.android.livesdk.link.model.IRivalRankRecommendResponse;
import com.bytedance.android.livesdk.link.model.m2;
import com.bytedance.android.livesdk.link.model.r8;
import com.bytedance.android.livesdk.link.model.s8;
import com.bytedance.android.livesdk.link.model.u8;
import com.bytedance.android.livesdk.link.model.v7;
import com.bytedance.android.livesdk.link.model.y7;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.google.android.material.tabs.TabLayout;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\t2\u00020\n2\u00020\u000b:\u0001\u000eB\u0007¢\u0006\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/dialog/fragment/RevLinkAnchorListFragment;", "Lcom/bytedance/android/live/core/ui/BaseFragment;", "Lcom/bytedance/android/live/revlink/impl/pk/dialog/fragment/d;", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "Lcom/google/android/material/tabs/TabLayout$OnTabSelectedListener;", "Lcom/bytedance/android/live/ui/PkInviteUserListRefreshLayout$k;", "Lcom/bytedance/android/live/revlink/impl/pk/ui/x;", "Lx31/k;", "Lx31/l;", "Lcom/bytedance/android/live/revlink/impl/pk/dialog/viewholder/PKExpandCollapseViewHolder$a;", "Lcom/bytedance/android/live/revlink/impl/pk/dialog/fragment/PkSubTabPagerAdapter$a;", "Lcom/bytedance/android/live/revlink/impl/pk/dialog/fragment/c;", "<init>", "()V", "a", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RevLinkAnchorListFragment extends BaseFragment implements com.bytedance.android.live.revlink.impl.pk.dialog.fragment.d, ViewPager.OnPageChangeListener, TabLayout.OnTabSelectedListener, PkInviteUserListRefreshLayout.k, com.bytedance.android.live.revlink.impl.pk.ui.x, x31.k, x31.l, PKExpandCollapseViewHolder.a, PkSubTabPagerAdapter.a, com.bytedance.android.live.revlink.impl.pk.dialog.fragment.c {
    public static final /* synthetic */ int F = 0;
    public String A;
    public String B;
    public boolean C;
    public long D;
    public zy0.d E;
    public Map<Integer, View> d;
    public String e;
    public MultiTypeAdapter f;
    public float g;
    public float h;
    public boolean i;
    public boolean j;
    public zy0.b k;
    public zy0.b l;
    public com.bytedance.android.live.revlink.impl.control.dialog.r m;
    public final Lazy n;
    public com.bytedance.android.live.revlink.impl.pk.utils.m o;
    public DataCenter p;
    public AnchorInteractContainerFragment.c q;
    public AnchorInteractContainerFragment.b r;
    public final CompositeDisposable s;
    public PkSubTabPagerAdapter t;
    public boolean u;
    public View v;
    public TextView w;
    public v x;
    public final Lazy y;
    public String z;

    public static final class a {
    }

    public static final class b implements View.OnTouchListener {
        public final /* synthetic */ RevLinkAnchorListFragment a;

        public b(RevLinkAnchorListFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r2, MotionEvent r3) {
            if (r3.getAction() != 0) goto L5;
            RevLinkAnchorListFragment r4 = this.a;
            int r0 = RevLinkAnchorListFragment.F;
            r4.V90().setEnableCheckPos(false);
            this.a.V90().setSubTabAction("click");
        L5:
            return false;
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ RevLinkAnchorListFragment a;

        public c(RevLinkAnchorListFragment r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            com.bytedance.android.live.revlink.impl.pk.dialog.vm.a r3 = (com.bytedance.android.live.revlink.impl.pk.dialog.vm.a) r2;
            if (r3 == null) goto L8;
            RevLinkAnchorListFragment.T90(this.a, r3);
            CoordinatorLayout r4 = this.a.S90(2131366849);
            if (r4 == null) goto L9;
            r4.setVisibility(0);
            return;
        L9:
            return;
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ RevLinkAnchorListFragment a;

        public d(RevLinkAnchorListFragment r1) {
            this.a = r1;
        }

        public final void onChanged(Object r4) {
            s8 r5 = (s8) r4;
            RevLinkAnchorListFragment r0 = this.a;
            if (r0.u == true) goto L5;
            Function1 r1 = new RevLinkAnchorListFragment$handleRankSeasonUpdate$render$1(r0);
        L10:
            r1.invoke(r5);
            return;
        L5:
            if (r5 != null) goto L7;
        L9:
            r1 = new RevLinkAnchorListFragment$handleRankSeasonUpdate$render$3(r0);
            goto L10
        L7:
            if (r5.isUnlockedRank() != true) goto L9;
            r1 = new RevLinkAnchorListFragment$handleRankSeasonUpdate$render$2(r0);
            goto L10
        }
    }

    public static final class e<T> implements Observer {
        public final /* synthetic */ RevLinkAnchorListFragment a;

        public e(RevLinkAnchorListFragment r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            if (Intrinsics.areEqual((Boolean) r2, Boolean.TRUE) == false) goto L12;
            LiveDoubleColorBallAnimationView r3 = this.a.S90(2131382879);
            if (r3 == null) goto L7;
            r3.setVisibility(8);
        L7:
            CoordinatorLayout r4 = this.a.S90(2131366849);
            if (r4 == null) goto L10;
            r4.setVisibility(0);
        L10:
            this.a.X90(true);
            return;
        }
    }

    public static final class f<T> implements Observer {
        public final /* synthetic */ RevLinkAnchorListFragment a;

        public f(RevLinkAnchorListFragment r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            Integer r4 = (Integer) r3;
            if (r4 == null) goto L8;
            SSViewPager r0 = this.a.S90(2131387583);
            if (r0 == null) goto L9;
            r0.setCurrentItem(r4.intValue(), false);
            return;
        L9:
            return;
        }
    }

    public static final class g<T> implements Observer {
        public final /* synthetic */ RevLinkAnchorListFragment a;

        public g(RevLinkAnchorListFragment r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            if (Intrinsics.areEqual((Boolean) r2, Boolean.TRUE) == false) goto L8;
            AnchorInteractContainerFragment.c r3 = this.a.q;
            if (r3 == null) goto L9;
            r3.e();
            return;
        L9:
            return;
        }
    }

    public static final class h<T> implements Observer {
        public final /* synthetic */ RevLinkAnchorListFragment a;

        public h(RevLinkAnchorListFragment r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            Boolean r3 = (Boolean) r2;
            if (r3 == null) goto L8;
            AnchorInteractContainerFragment.c r0 = this.a.q;
            if (r0 == null) goto L9;
            r0.b(r3.booleanValue());
            return;
        L9:
            return;
        }
    }

    public static final class i<T> implements Observer {
        public final /* synthetic */ RevLinkAnchorListFragment a;

        public i(RevLinkAnchorListFragment r1) {
            this.a = r1;
        }

        public final void onChanged(Object r8) {
            Unit r9 = (Unit) r8;
            Context r10 = this.a.getContext();
            if (r10 != null) goto L5;
            return;
        L5:
            if ((r10 instanceof FragmentActivity) == true) goto L7;
            r10 = null;
        L7:
            FragmentActivity r12 = (FragmentActivity) r10;
            if (r12 == null) goto L21;
            FragmentManager r13 = r12.getSupportFragmentManager();
            if (r13 == null) goto L22;
            int r0 = RandomPKCheckFragment.m;
            RandomPKCheckFragment r1 = RandomPKCheckFragment.a.a(RandomMatchCheckSource.PKUserListFragment, null, null, null, this.a, 14);
            LandscapeRestrictionOperation r2 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r1, "random_pk_check_fragment", r2);
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r13, r1, r2) == true) goto L23;
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L17
        L15:
            r1.show(r13, "random_pk_check_fragment");
            return;
        L23:
            return;
        L22:
            return;
        }
    }

    public static final class j<T> implements Observer {
        public final /* synthetic */ RevLinkAnchorListFragment a;

        public j(RevLinkAnchorListFragment r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            List r4 = (List) r3;
            if (r4 == null) goto L16;
            TouchConflictPkExposeRecyclerView r0 = (TouchConflictPkExposeRecyclerView) this.a.S90(2131389150);
            if (r0 == null) goto L7;
            r0.r();
        L7:
            RecyclerView r1 = (TouchConflictPkExposeRecyclerView) this.a.S90(2131389150);
            if (r1 == null) goto L10;
            this.a.getClass();
            r1.setVisibility(0);
        L10:
            MultiTypeAdapter r2 = this.a.f;
            if (r2 == null) goto L13;
            r2.a = r4;
        L13:
            if (r2 == null) goto L17;
            r2.notifyDataSetChanged();
            return;
        L17:
            return;
        }
    }

    public static final class k<T> implements Observer {
        public final /* synthetic */ RevLinkAnchorListFragment a;

        public k(RevLinkAnchorListFragment r1) {
            this.a = r1;
        }

        public final void onChanged(Object r5) {
            y31.s.a r6 = (y31.s.a) r5;
            if (r6 == null) goto L16;
            RevLinkAnchorListFragment r0 = this.a;
            int r1 = RevLinkAnchorListFragment.F;
            List r2 = (List) r0.V90().getFollowListData().getValue();
            if (r2 == null) goto L20;
            int r3 = r2.size();
            if ((CollectionsKt.lastOrNull(r2) instanceof y31.s.a) == false) goto L12;
            int r4 = r3 - 1;
            ListProtector.set(r2, r4, r6);
            MultiTypeAdapter r7 = r0.f;
            if (r7 == null) goto L17;
            r7.notifyItemChanged(r4);
            return;
        L17:
            return;
        L12:
            r2.add(r6);
            MultiTypeAdapter r8 = r0.f;
            if (r8 == null) goto L19;
            r8.notifyItemInserted(r3);
            return;
        L19:
            return;
        L20:
            return;
        }
    }

    public static final class l implements View.OnClickListener {
        public final /* synthetic */ RevLinkAnchorListFragment a;

        public l(RevLinkAnchorListFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r6) {
            Context r7 = this.a.getContext();
            if (r7 == null) goto L8;
            zz0.g r0 = (zz0.g) com.bytedance.android.live.revenue.core.util.f.a(zz0.g.class);
            f51.a r1 = f51.a.e;
            r1.getClass();
            r0.S2(r7, (String) f51.a.c.getValue(r1, f51.a.a[1]));
            RevLinkAnchorListFragment r8 = this.a;
            int r2 = RevLinkAnchorListFragment.F;
            if (r8.V90().getReporter() == null) goto L9;
            Intrinsics.checkNotNullParameter("banner", "from");
            HashMap r3 = new HashMap();
            r3.put("action_from", "banner");
            mz0.n r9 = new mz0.n();
            Map<String, String> r4 = r9.a;
            Intrinsics.checkNotNullParameter(r4, "map");
            Intrinsics.checkNotNullParameter(r3, "map");
            r4.putAll(r3);
            mz0.m r5 = new mz0.m();
            r5.b(LogCommon.ROOM);
            List<Object> r10 = r9.b;
            ArrayList r12 = (ArrayList) r10;
            r12.addAll(r5.a);
            cy0.e.a.getClass();
            cy0.j r13 = cy0.e.a.a;
            com.bytedance.android.scope.m.e.getClass();
            Object r14 = com.bytedance.android.scope.m.b(r13).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
            Intrinsics.checkNotNull(r14);
            ((mz0.i) ((f80.a) r14)).w3("livesdk_pk_rule_click", r9.a, r9.b);
            return;
        L9:
            return;
        }
    }

    public static final class m implements Action {
        public final /* synthetic */ RevLinkAnchorListFragment a;

        public m(RevLinkAnchorListFragment r1) {
            this.a = r1;
        }

        public final void run() {
            com.bytedance.android.live.revlink.impl.control.dialog.r r0 = this.a.m;
            if (r0 == null) goto L6;
            r0.dismiss();
            return;
        }
    }

    public static final class n implements PkInviteUserListRefreshLayout.j {
        public final /* synthetic */ RevLinkAnchorListFragment a;

        public n(RevLinkAnchorListFragment r1) {
            this.a = r1;
        }

        public final boolean a(MotionEvent r10) {
            RevLinkAnchorListFragment r0 = this.a;
            int r1 = RevLinkAnchorListFragment.F;
            PagerAdapter r2 = r0.S90(2131387583).getAdapter();
            Integer r4 = null;
            if ((r2 instanceof PkSubTabPagerAdapter) == true) goto L5;
            r2 = null;
        L5:
            PkSubTabPagerAdapter r3 = (PkSubTabPagerAdapter) r2;
            if (r3 == null) goto L8;
            Fragment r5 = r3.f(r0.S90(2131387583).getCurrentItem());
        L10:
            if ((r5 instanceof RevLinkSubListFragment) == true) goto L12;
            r5 = null;
        L12:
            RevLinkSubListFragment r6 = (RevLinkSubListFragment) r5;
            if (r6 == null) goto L39;
            Intrinsics.checkNotNullParameter(r10, "motionEvent");
            TouchConflictPkExposeRecyclerView r7 = (TouchConflictPkExposeRecyclerView) r6.S90(2131384076);
            if (r7 == null) goto L17;
            RecyclerView.LayoutManager r8 = r7.getLayoutManager();
        L19:
            if ((r8 instanceof LinearLayoutManager) == true) goto L21;
            r8 = null;
        L21:
            LinearLayoutManager r9 = (LinearLayoutManager) r8;
            if (r9 == null) goto L24;
            int r12 = r9.findFirstVisibleItemPosition();
        L25:
            if (r12 > 0) goto L36;
            RecyclerView r13 = (TouchConflictPkExposeRecyclerView) r6.S90(2131384076);
            if (r13 == null) goto L31;
            View r14 = r13.getChildAt(0);
            if (r14 == null) goto L31;
            float r15 = r14.getY();
        L33:
            if (r15 != 0.0f) goto L36;
            boolean r16 = false;
        L37:
            if (r16 != true) goto L39;
        L40:
            boolean r17 = true;
        L42:
            if (r17 == true) goto L62;
            RevLinkAnchorListFragment r18 = this.a;
            r18.getClass();
            if (r10 == null) goto L46;
            Float r19 = Float.valueOf(r10.getX());
        L47:
            float r20 = r19.floatValue();
            if (r10 == null) goto L50;
            Float r22 = Float.valueOf(r10.getY());
        L51:
            float r23 = r22.floatValue();
            if (r10 == null) goto L55;
            r4 = Integer.valueOf(r10.getAction());
        L55:
            if (r4.intValue() == 2) goto L58;
            r18.g = r20;
            r18.h = r23;
        L60:
            boolean r110 = false;
        L61:
            if (r110 == true) goto L62;
            return false;
        L58:
            if (Math.abs(r20 - r18.g) <= Math.abs(r23 - r18.h)) goto L60;
            r110 = true;
            goto L61
        L50:
            r22 = null;
            goto L51
        L46:
            r19 = null;
        L62:
            return true;
        L31:
            r15 = 0.0f;
        L36:
            r16 = true;
            goto L37
        L24:
            r12 = -1;
            goto L25
        L17:
            r8 = null;
        L39:
            if (r0.S90(2131363087).getY() < 0.0f) goto L40;
            r17 = false;
            goto L42
        L8:
            r5 = null;
            goto L10
        }
    }

    public static final class o implements View.OnTouchListener {
        public final /* synthetic */ RevLinkAnchorListFragment a;

        public o(RevLinkAnchorListFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r1, MotionEvent r2) {
            if (r2.getAction() != 0) goto L5;
        L6:
            RevLinkAnchorListFragment r3 = this.a;
            int r4 = RevLinkAnchorListFragment.F;
            r3.V90().setSubTabAction("draw");
            return false;
        L5:
            if (r2.getAction() == 2) goto L6;
            return false;
        }
    }

    public static final class p<T> implements Observer {
        public final /* synthetic */ RevLinkAnchorListFragment a;

        public p(RevLinkAnchorListFragment r1) {
            this.a = r1;
        }

        public final void onChanged(Object r4) {
            if (((Boolean) r4).booleanValue() == false) goto L31;
            MultiTypeAdapter r5 = this.a.f;
            if (r5 == null) goto L7;
            r5.notifyDataSetChanged();
        L7:
            RevLinkAnchorListFragment r6 = this.a;
            PkSubTabPagerAdapter r0 = r6.t;
            Fragment r1 = null;
            if (r0 == null) goto L14;
            SSViewPager r7 = r6.S90(2131387583);
            if (r7 == null) goto L12;
            Integer r8 = Integer.valueOf(r7.getCurrentItem());
        L13:
            Fragment r9 = r0.f(r8.intValue());
        L16:
            if ((r9 instanceof RevLinkSubListFragment) == false) goto L19;
            r1 = r9;
        L19:
            RevLinkSubListFragment r2 = (RevLinkSubListFragment) r1;
            if (r2 == null) goto L32;
            RevLinkAnchorSubViewModel r10 = (RevLinkAnchorSubViewModel) r2.j.getValue();
            if (r10 != null) goto L25;
            return;
        L25:
            if (r10.isAct() == true) goto L35;
            MultiTypeAdapter r12 = r2.l;
            if (r12 == null) goto L33;
            r12.notifyDataSetChanged();
            return;
        L33:
            return;
        L35:
            return;
        L32:
            return;
        L12:
            r8 = null;
            goto L13
        L14:
            r9 = null;
            goto L16
        }
    }

    public static final class q<T> implements Observer {
        public final /* synthetic */ RevLinkAnchorListFragment a;

        public q(RevLinkAnchorListFragment r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            if (((Boolean) r2).booleanValue() == false) goto L6;
            RevLinkAnchorListFragment r3 = this.a;
            int r0 = RevLinkAnchorListFragment.F;
            r3.X90(true);
            return;
        }
    }

    public static final class r<T> implements Observer {
        public final /* synthetic */ RevLinkAnchorListFragment a;

        public r(RevLinkAnchorListFragment r1) {
            this.a = r1;
        }

        public final void onChanged(Object r4) {
            com.bytedance.android.live.revlink.impl.control.dialog.f r5 = (com.bytedance.android.live.revlink.impl.control.dialog.f) r4;
            if (r5 == null) goto L16;
            RevLinkAnchorListFragment r0 = this.a;
            int r1 = RevLinkAnchorListFragment.F;
            r0.X90(false);
            com.bytedance.android.live.revenue.common.k.d(r5.c, s1.B(2131917879));
            RevLinkAnchorListFragment r6 = this.a;
            if (r6.i == false) goto L17;
            FrameLayout r7 = (FrameLayout) r6.S90(2131389115);
            if (r7 == null) goto L9;
            r7.setVisibility(8);
        L9:
            LiveDoubleColorBallAnimationView r8 = this.a.S90(2131382879);
            if (r8 == null) goto L12;
            r8.setVisibility(8);
        L12:
            CoordinatorLayout r9 = this.a.S90(2131366849);
            if (r9 == null) goto L18;
            r9.setVisibility(0);
            return;
        L18:
            return;
        L17:
            return;
        }
    }

    public static final class s<T> implements Observer {
        public final /* synthetic */ RevLinkAnchorListFragment a;

        public s(RevLinkAnchorListFragment r1) {
            this.a = r1;
        }

        public final void onChanged(Object r13) {
            List<? extends y7> r14 = (List) r13;
            if (r14 == null) goto L168;
            SSViewPager r0 = this.a.S90(2131387583);
            ViewGroup.LayoutParams r2 = null;
            if (r0 == null) goto L7;
            PagerAdapter r1 = r0.getAdapter();
        L8:
            int r4 = 0;
            if (r1 == null) goto L83;
            RevLinkAnchorListFragment r3 = this.a;
            PkSubTabPagerAdapter r7 = r3.t;
            if (r7 == null) goto L13;
            r7.h(r14);
        L13:
            SSViewPager r8 = r3.S90(2131387583);
            if (r8 == null) goto L21;
            PkSubTabPagerAdapter r9 = r3.t;
            if (r9 == null) goto L18;
            int r10 = r9.getCount();
        L19:
            r8.setOffscreenPageLimit(r10 - 1);
            goto L21
        L18:
            r10 = 0;
        L21:
            if (r14.isEmpty() == false) goto L25;
            TouchUpConflictTabLayout r15 = (TouchUpConflictTabLayout) r3.S90(2131387986);
            if (r15 == null) goto L169;
            r15.removeAllTabs();
            return;
        L169:
            return;
        L25:
            int r12 = r14.size();
            TouchUpConflictTabLayout r16 = (TouchUpConflictTabLayout) r3.S90(2131387986);
            if (r16 == null) goto L28;
            Integer r17 = Integer.valueOf(r16.getTabCount());
        L29:
            int r18 = r17.intValue();
            if (r12 >= r18) goto L38;
            int r19 = r18 - 1;
            if (r19 < r12) goto L45;
        L33:
            TouchUpConflictTabLayout r5 = (TouchUpConflictTabLayout) r3.S90(2131387986);
            if (r5 == null) goto L36;
            r5.removeTabAt(r19);
        L36:
            if (r19 == r12) goto L45;
            r19 = r19 - 1;
        L45:
            SSViewPager r6 = r3.S90(2131387583);
            if (r6 == null) goto L50;
            PagerAdapter r20 = r6.getAdapter();
            if (r20 == null) goto L50;
            int r22 = r20.getCount();
        L51:
            if (r4 >= r22) goto L173;
            TouchUpConflictTabLayout r23 = (TouchUpConflictTabLayout) r3.S90(2131387986);
            if (r23 == null) goto L55;
            TabLayout.Tab r24 = r23.getTabAt(r4);
        L56:
            if (r24 == null) goto L58;
            View r25 = r24.getCustomView();
        L59:
            if (r25 != null) goto L67;
            if (r24 == null) goto L82;
            y7 r26 = (y7) ListProtector.get(r14, r4);
            if (r26 == null) goto L65;
            String r27 = r26.getName();
            if (r27 == null) goto L65;
        L66:
            r24.setCustomView(r3.W90(r27));
        L65:
            r27 = "";
        L82:
            r4 = r4 + 1;
            goto L51
        L67:
            if (r24 == null) goto L69;
            View r28 = r24.getCustomView();
        L71:
            if ((r28 instanceof TextView) == true) goto L73;
            r28 = null;
        L73:
            TextView r29 = (TextView) r28;
            if (r29 == null) goto L82;
            y7 r30 = (y7) ListProtector.get(r14, r4);
            if (r30 == null) goto L80;
            String r32 = r30.getName();
            if (r32 == null) goto L80;
        L81:
            r29.setText(r32);
        L80:
            r32 = "";
            goto L81
        L69:
            r28 = null;
            goto L71
        L58:
            r25 = null;
            goto L59
        L55:
            r24 = null;
            goto L56
        L173:
            return;
        L50:
            r22 = 0;
            goto L51
        L38:
            if (r12 <= r18) goto L45;
            int r33 = r12 - r18;
            int r34 = 0;
        L40:
            if (r34 >= r33) goto L45;
            TouchUpConflictTabLayout r35 = (TouchUpConflictTabLayout) r3.S90(2131387986);
            if (r35 == null) goto L44;
            r35.addTab(new TabLayout.Tab());
        L44:
            r34 = r34 + 1;
            goto L40
        L28:
            r17 = null;
            goto L29
        L83:
            RevLinkAnchorListFragment r36 = this.a;
            r36.getClass();
            ArrayList r37 = new ArrayList();
            Iterator<T> r38 = r14.iterator();
            int r39 = 0;
        L85:
            if (r38.hasNext() == false) goto L90;
            T r110 = r38.next();
            int r111 = r39 + 1;
            if (r39 >= 0) goto L89;
            CollectionsKt.throwIndexOverflow();
        L89:
            r37.add(r36.zy((y7) r110));
            r39 = r111;
            goto L85
        L90:
            PkSubTabPagerAdapter r40 = r36.t;
            if (r40 != null) goto L93;
        L102:
            r36.t = new PkSubTabPagerAdapter(r36.getChildFragmentManager(), r36);
            SSViewPager r42 = r36.S90(2131387583);
            if (r42 == null) goto L105;
            r42.setAdapter(r36.t);
        L105:
            PkSubTabPagerAdapter r43 = r36.t;
            if (r43 == null) goto L108;
            r43.h(r14);
        L108:
            b51.b r44 = b51.b.c0;
            r44.getClass();
            if (((Boolean) b51.b.r.getValue(r44, b51.b.a[16])).booleanValue() == true) goto L117;
            SSViewPager r45 = r36.S90(2131387583);
            if (r45 == null) goto L117;
            PkSubTabPagerAdapter r46 = r36.t;
            if (r46 == null) goto L115;
            int r47 = r46.getCount();
        L116:
            r45.setOffscreenPageLimit(r47 - 1);
            goto L117
        L115:
            r47 = 0;
        L117:
            TouchUpConflictTabLayout r48 = (TouchUpConflictTabLayout) r36.S90(2131387986);
            if (r48 == null) goto L120;
            r48.setupWithViewPager(r36.S90(2131387583));
        L120:
            SSViewPager r49 = r36.S90(2131387583);
            if (r49 == null) goto L125;
            PagerAdapter r50 = r49.getAdapter();
            if (r50 == null) goto L125;
            int r52 = r50.getCount();
        L126:
            int r53 = 0;
        L127:
            if (r53 >= r52) goto L140;
            TouchUpConflictTabLayout r54 = (TouchUpConflictTabLayout) r36.S90(2131387986);
            if (r54 == null) goto L138;
            TabLayout.Tab r55 = r54.getTabAt(r53);
            if (r55 == null) goto L138;
            y7 r56 = (y7) ListProtector.get(r14, r53);
            if (r56 == null) goto L136;
            String r57 = r56.getName();
            if (r57 == null) goto L136;
        L137:
            r55.setCustomView(r36.W90(r57));
        L136:
            r57 = "";
        L138:
            r53 = r53 + 1;
            goto L127
        L140:
            if (this.a.V90().isListOpt() == false) goto L142;
            ((TouchUpConflictTabLayout) this.a.S90(2131387986)).setSelectedTabIndicator(2131252611);
            ((TouchUpConflictTabLayout) this.a.S90(2131387986)).setSelectedTabIndicatorColor(ColorProtector.parseColor("#e3161823"));
            return;
        L142:
            ((TouchUpConflictTabLayout) this.a.S90(2131387986)).setSelectedTabIndicatorHeight(0);
            ViewGroup.LayoutParams r112 = ((TouchUpConflictTabLayout) this.a.S90(2131387986)).getLayoutParams();
            if ((r112 instanceof LinearLayout.LayoutParams) == false) goto L146;
            r2 = r112;
        L146:
            LinearLayout.LayoutParams r58 = (LinearLayout.LayoutParams) r2;
            if (r58 == null) goto L172;
            r58.leftMargin = UtilityKotlinExtentionsKt.i(10);
            r58.rightMargin = UtilityKotlinExtentionsKt.i(10);
            ((TouchUpConflictTabLayout) this.a.S90(2131387986)).setLayoutParams(r58);
            return;
        L172:
            return;
        L125:
            r52 = 0;
            goto L126
        L93:
            if ((true ^ r40.g().isEmpty()) == false) goto L99;
            FragmentTransaction r59 = r40.d.beginTransaction();
            Iterator<T> r60 = r40.g().iterator();
        L96:
            if (r60.hasNext() == false) goto L98;
            r59.remove((BaseSubFragment) r60.next());
            goto L96
        L98:
            r59.commitNowAllowingStateLoss();
        L99:
            SSViewPager r62 = r36.S90(2131387583);
            if (r62 == null) goto L102;
            r62.setAdapter(null);
            goto L102
        L7:
            r1 = null;
            goto L8
        }
    }

    public static final class t<T> implements Observer {
        public final /* synthetic */ RevLinkAnchorListFragment a;

        public t(RevLinkAnchorListFragment r1) {
            this.a = r1;
        }

        public final void onChanged(Object r20) {
            Pair r1 = (Pair) r20;
            if (r1 == null) goto L146;
            IRivalRankRecommendResponse r2 = ((com.bytedance.android.live.revlink.impl.control.dialog.e) r1.getSecond()).c;
            RevLinkAnchorListFragment r3 = this.a;
            int r4 = RevLinkAnchorListFragment.F;
            if (r3.V90().isAudioRoom() == true) goto L10;
            if (r3.U90(r2.getRivalsExtra(), true) == true) goto L10;
            KProperty[] r5 = com.bytedance.android.live.revlink.impl.behavior.o.a;
            r3.onUpdate(2);
        L14:
            RevLinkAnchorListFragment r6 = this.a;
            String r7 = (String) r1.getFirst();
            r6.getClass();
            if (r2.getDurationTime() <= 0) goto L17;
            boolean r8 = true;
        L18:
            int r9 = com.bytedance.android.live.revlink.impl.pk.utils.o.a;
            String r10 = String.valueOf(Calendar.getInstance().get(6));
            c51.a r12 = c51.a.h;
            r12.getClass();
            ReadOnlyProperty r13 = c51.a.e;
            KProperty[] r14 = c51.a.a;
            boolean r15 = ((Boolean) r13.getValue(r12, r14[3])).booleanValue();
            boolean r16 = com.bytedance.android.live.revlink.impl.pk.utils.o.a(System.currentTimeMillis());
            if (l51.a.o() == false) goto L23;
            if (l51.a.l() > 1) goto L23;
        L26:
            boolean r17 = true;
        L28:
            com.bytedance.tools.kcp.spongepreference.runtime.a r18 = l51.a.q0;
            KProperty[] r19 = l51.a.a;
            String r22 = null;
            boolean r110 = !TextUtils.equals((String) r18.getValue(null, r19[78]), r10);
            if (r12.a() == true) goto L31;
        L40:
            boolean r23 = true;
        L41:
            boolean r24 = !TextUtils.equals((String) l51.a.r0.getValue(null, r19[79]), r10);
            if (r15 == false) goto L50;
            if (r8 == false) goto L50;
            if (r16 == false) goto L50;
            if (r17 == false) goto L50;
            if (r110 == false) goto L50;
            if (r23 == false) goto L50;
            if (r24 == false) goto L50;
            boolean r25 = true;
        L52:
            if (r25 == false) goto L68;
            Intrinsics.checkNotNullParameter(r7, "$this$isFromRefresh");
            if (Intrinsics.areEqual(r7, "refresh") == false) goto L56;
        L57:
            com.bytedance.android.live.revlink.impl.pk.utils.o.c(600, 2, true);
        L58:
            PkTopTipView r26 = (PkTopTipView) r6.S90(2131389231);
            if (r26 == null) goto L66;
            a1.k(r26._$_findCachedViewById(2131384838), UtilityKotlinExtentionsKt.i(38));
            r26._$_findCachedViewById(2131384838).setVisibility(0);
            r26._$_findCachedViewById(2131376699).setVisibility(8);
            ((TextView) r26._$_findCachedViewById(2131391645)).setVisibility(0);
            TextView r27 = (TextView) r26._$_findCachedViewById(2131391645);
            String r28 = (String) c51.a.d.getValue(r12, r14[2]);
            if (r28 != null) goto L64;
            r28 = s1.B(2131917852);
        L64:
            r27.setText(r28);
            ((TextView) r26._$_findCachedViewById(2131391645)).setFocusable(false);
            ((TextView) r26._$_findCachedViewById(2131391645)).setFocusableInTouchMode(false);
            ((TextView) r26._$_findCachedViewById(2131391645)).postDelayed(new com.bytedance.android.live.revlink.impl.pk.ui.u(r26), 2000);
            ((TextView) r26._$_findCachedViewById(2131390704)).setVisibility(0);
            r26._$_findCachedViewById(2131376681).setVisibility(0);
            r26._$_findCachedViewById(2131376681).setOnClickListener(new com.bytedance.android.live.revlink.impl.pk.ui.v(r26));
            ((TextView) r26._$_findCachedViewById(2131390704)).setOnClickListener(new com.bytedance.android.live.revlink.impl.pk.ui.w(r26, r6));
        L66:
            if (((PkTopTipView) r6.S90(2131389231)) == null) goto L82;
            HashMap r29 = new HashMap();
            r29.put("hint_type", DataType.TRUE);
            r29.put("located_tab", "pk_tab");
            mz0.n r30 = new mz0.n();
            Map<String, String> r32 = r30.a;
            Intrinsics.checkNotNullParameter(r32, "map");
            Intrinsics.checkNotNullParameter(r29, "map");
            r32.putAll(r29);
            mz0.m r33 = new mz0.m();
            r33.b(LogCommon.ROOM);
            ((ArrayList) r30.b).addAll(r33.a);
            cy0.e.a.getClass();
            cy0.j r34 = cy0.e.a.a;
            com.bytedance.android.scope.m.e.getClass();
            Object r35 = com.bytedance.android.scope.m.b(r34).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
            Intrinsics.checkNotNull(r35);
            ((mz0.i) ((f80.a) r35)).w3("livesdk_hint_bar_show", r30.a, r30.b);
        L82:
            RevLinkAnchorListFragment r36 = this.a;
            r36.getClass();
            v7 r37 = r2.getCommonBanner();
            if (r37 == null) goto L85;
            String r38 = r37.getBannerInfo();
        L86:
            v7 r39 = r2.getCommonBanner();
            if (r39 == null) goto L89;
            String r40 = r39.getBannerArea();
        L90:
            FrameLayout r42 = (FrameLayout) r36.S90(2131389115);
            FrameLayout r43 = (FrameLayout) r36.S90(2131389117);
            r42.removeAllViews();
            r43.removeAllViews();
            if (r38 != null) goto L93;
        L96:
            boolean r44 = true;
        L97:
            if (r44 == false) goto L105;
            if (r40 != null) goto L100;
        L103:
            boolean r45 = true;
        L104:
            if (r45 == false) goto L105;
        L144:
            r42.setVisibility(8);
            r43.setVisibility(8);
            return;
        L100:
            if (StringsKt.isBlank(r40) == true) goto L103;
            r45 = false;
        L105:
            b51.b r46 = b51.b.c0;
            r46.getClass();
            ReadOnlyProperty r111 = b51.b.e;
            KProperty[] r112 = b51.b.a;
            if (TextUtils.isEmpty((String) r111.getValue(r46, r112[3])) == true) goto L144;
            if (r36.u == false) goto L115;
            s8 r47 = r2.getRankSeasonInfo();
            if (r47 != null) goto L112;
        L114:
            r42.setVisibility(8);
            r42 = r43;
        L116:
            r42.setVisibility(0);
            if (r38 != null) goto L119;
            r38 = "";
        L119:
            if (r40 != null) goto L121;
            r40 = "";
        L121:
            Context r48 = r36.getContext();
            if (r48 == null) goto L150;
            final String r49 = (String) r111.getValue(r46, r112[3]);
            com.bytedance.android.live.revenue.platform.hybrid.impl.ui.e r50 = ((vy0.c) com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class)).J8(r48, null, new RevLinkAnchorListFragment$loadTopBanner$1(r49));
            if (r50 == null) goto L147;
            zy0.b r52 = r36.k;
            if (r52 == null) goto L129;
            r52.dispose();
        L129:
            r36.k = r50;
            r42.removeAllViews();
            r42.addView(r50.d, new ViewGroup.LayoutParams(-1, -1));
            HashMap r53 = new HashMap();
            if ((!StringsKt.isBlank(r38)) == false) goto L133;
            r53.put("banner_info", r38);
        L133:
            if ((!StringsKt.isBlank(r40)) == false) goto L135;
            r53.put("banner_area", r40);
        L135:
            com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.e r54 = com.bytedance.android.live.revlink.impl.global.b.l();
            if (r54 == null) goto L138;
            r22 = r54.b;
        L138:
            r53.put("source", r22);
            if (TextUtils.isEmpty(r36.z) == true) goto L141;
            r53.put("source", "guide");
            r53.put("guide_type", r36.z);
        L141:
            r53.put("to_user_group", r36.A);
            xy0.a<?> r55 = r50.g();
            if (r55 == null) goto L148;
            ((com.bytedance.android.live.revenue.platform.hybrid.impl.component.b) r55).load(r49, r53);
            return;
        L148:
            return;
        L147:
            return;
        L150:
            return;
        L112:
            if (r47.isUnlockedRank() != true) goto L114;
        L115:
            r43.setVisibility(8);
            goto L116
        L93:
            if (StringsKt.isBlank(r38) == true) goto L96;
            r44 = false;
            goto L97
        L89:
            r40 = null;
            goto L90
        L85:
            r38 = null;
            goto L86
        L56:
            if (((int) r2.getTabLocate()) != 0) goto L58;
        L68:
            Intrinsics.checkNotNullParameter(r7, "$this$isFromRefresh");
            if (Intrinsics.areEqual(r7, "refresh") == true) goto L73;
            if (((int) r2.getTabLocate()) == 0) goto L73;
        L79:
            PkTopTipView r56 = (PkTopTipView) r6.S90(2131389231);
            if (r56 == null) goto L82;
            r56.setData(r2.getTopTip());
        L73:
            if (l51.a.o() == false) goto L79;
            if (com.bytedance.android.live.revlink.impl.pk.utils.o.a(System.currentTimeMillis()) == true) goto L79;
            l51.a.I(((Number) l51.a.m0.getValue(null, r19[74])).intValue());
            l51.a.J(l51.a.l());
        L50:
            r25 = false;
            goto L52
        L31:
            if (r12.a() == false) goto L35;
            if (l51.a.o() == false) goto L40;
        L35:
            if (r12.a() == true) goto L37;
        L39:
            r23 = false;
            goto L41
        L37:
            if (TextUtils.equals((String) l51.a.o0.getValue(null, r19[76]), r10) == false) goto L39;
        L23:
            if (l51.a.o() == false) goto L25;
        L27:
            r17 = false;
            goto L28
        L25:
            if (l51.a.k() > 1) goto L27;
        L17:
            r8 = false;
        L10:
            if (r3.C == true) goto L14;
            if (r2.getTabLocate() != 1) goto L14;
            KProperty[] r57 = com.bytedance.android.live.revlink.impl.behavior.o.a;
            r3.onUpdate(1);
            r3.C = true;
            goto L14
        }
    }

    public static final class u<T> implements Observer {
        public final /* synthetic */ RevLinkAnchorListFragment a;

        public u(RevLinkAnchorListFragment r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            com.bytedance.android.live.revlink.impl.pk.dialog.vm.a r3 = (com.bytedance.android.live.revlink.impl.pk.dialog.vm.a) r2;
            if (r3 == null) goto L6;
            RevLinkAnchorListFragment.T90(this.a, r3);
            return;
        }
    }

    public static final class v implements Runnable {
        public final /* synthetic */ RevLinkAnchorListFragment a;

        public v(RevLinkAnchorListFragment r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            LiveDoubleColorBallAnimationView r0 = this.a.S90(2131382372);     // Catch: Throwable -> L13
            if (r0 == null) goto L5;
            r0.setVisibility(4);     // Catch: Throwable -> L13
        L5:
            PkInviteUserListRefreshLayout r1 = this.a.S90(2131387827);     // Catch: Throwable -> L13
            if (r1 != null) goto L8;
            return;
        L8:
            if (r1.e != true) goto L20;
            PkInviteUserListRefreshLayout r2 = this.a.S90(2131387827);     // Catch: Throwable -> L13
            if (r2 == null) goto L21;
            r2.g();     // Catch: Throwable -> L13
            return;
        L21:
            return;
        L20:
            return;
        L13:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L22;
            throw th;
        }
    }

    public static final class w implements View.OnClickListener {
        public static final w a = null;

        static {
            a = new w();
        }

        public w() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            r2.setVisibility(8);
        }
    }

    public static final class x<T> implements Consumer {
        public final /* synthetic */ RevLinkAnchorListFragment a;

        public x(RevLinkAnchorListFragment r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Long r3 = (Long) r2;
            View r4 = this.a.v;
            if (r4 == null) goto L6;
            r4.setVisibility(8);
            return;
        }
    }

    static {
    }

    public final RevLinkAnchorViewModel V90() {
        return (RevLinkAnchorViewModel) this.n.getValue();
    }

    public final void onFinish() {
        this.i = true;
    }

    public final void onPageScrollStateChanged(int r1) {
    }

    public final void onPageScrolled(int r1, float r2, int r3) {
    }

    public final void onTabReselected(TabLayout.Tab r1) {
    }

    public final void onTabSelected(TabLayout.Tab r1) {
    }

    public final void onTabUnselected(TabLayout.Tab r1) {
    }

    public final void y0() {
    }

    public final void onRefresh() {
        PkSubTabPagerAdapter r0 = this.t;
        Fragment r1 = null;
        if (r0 == null) goto L5;
        Fragment r2 = r0.f(S90(2131387583).getCurrentItem());
    L7:
        if ((r2 instanceof RevLinkSubListFragment) == false) goto L10;
        r1 = r2;
    L10:
        RevLinkSubListFragment r3 = (RevLinkSubListFragment) r1;
        if (r3 == null) goto L14;
        String r4 = r3.e;
        if (r4 == null) goto L14;
    L15:
        String r5 = r4;
        if (this.u == false) goto L18;
        RevLinkAnchorViewModel.fetchUserListDataWithLoadType$default(V90(), 5, 0, r5, "refresh", IRivalRankRecommendResponse.LoadType.All.ordinal(), null, 32, null);
    L23:
        d31.e r6 = com.bytedance.android.live.revlink.impl.global.b.d0();
        if (r6 == null) goto L27;
        r6.c++;
        return;
    L27:
        return;
    L18:
        RevLinkAnchorViewModel r7 = V90();
        int r8 = com.bytedance.android.live.revlink.impl.utils.x.a;
        IRivalRankRecommendResponse.LoadType r9 = IRivalRankRecommendResponse.LoadType.All;
        if (com.bytedance.android.live.revlink.impl.utils.x.a(r5, r9.ordinal()) == false) goto L21;
        int r10 = IRivalRankRecommendResponse.LoadType.OnlyCommonPanel.ordinal();
    L22:
        RevLinkAnchorBaseViewModel.fetchPiece$default(r7, r10, "refresh", r5, null, 8, null);
        goto L23
    L21:
        r10 = r9.ordinal();
    L14:
        r4 = DataType.FALSE;
        goto L15
    L5:
        r2 = null;
        goto L7
    }

    public final void z1() {
        if (this.i == false) goto L9;
        LiveDoubleColorBallAnimationView r0 = S90(2131382372);
        if (r0 == null) goto L7;
        r0.setVisibility(0);
    L7:
        this.i = false;
        return;
    }

    public RevLinkAnchorListFragment() {
        this.d = new LinkedHashMap();
        this.e = "";
        this.i = true;
        this.j = true;
        this.n = LazyKt.lazy(new RevLinkAnchorListFragment$vm$2(this));
        this.s = new CompositeDisposable();
        this.y = LazyKt.lazy(RevLinkAnchorListFragment$mainHandler$2.INSTANCE);
        this.z = "";
        this.A = "";
        this.B = "";
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.dialog.fragment.d
    public final void Dz() {
        V90().onTabIn();
        r8 r0 = (r8) V90().getPopInfo().getValue();
        if (r0 == null) goto L34;
        String r1 = r0.getKey();
        final String r2 = r0.getLynxData();
        if (this.u == false) goto L35;
        boolean r3 = false;
        if (r1 != null) goto L9;
    L12:
        boolean r4 = true;
    L13:
        if (r4 == true) goto L36;
        if (r2 != null) goto L16;
    L17:
        r3 = true;
    L18:
        if (r3 == true) goto L37;
        com.bytedance.tools.kcp.spongepreference.runtime.a r5 = l51.a.e;
        KProperty[] r6 = l51.a.a;
        if ((true ^ Intrinsics.areEqual((String) r5.getValue(null, r6[3]), r1)) == false) goto L38;
        Context r7 = getContext();
        if (r7 == null) goto L32;
        d51.c r8 = d51.c.A0;
        r8.getClass();
        String r9 = (String) d51.c.u.getValue(r8, d51.c.a[19]);
        if (TextUtils.isEmpty(r9) == true) goto L32;
        x0 r10 = new x0(r9);
        HybridDialogImpl r12 = ((vy0.b) com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class)).U0(r7, r10.c(), null);
        this.E = r12;
        if (r12 == null) goto L29;
        r12.j(new RevLinkAnchorListFragment$openSeasonPopDialog$1(this, r2));
    L29:
        zy0.d r13 = this.E;
        if (r13 == null) goto L32;
        r13.j0(new RevLinkAnchorListFragment$openSeasonPopDialog$2(this));
    L32:
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        r5.setValue(null, r6[3], r1);
        return;
    L38:
        return;
    L37:
        return;
    L16:
        if (StringsKt.isBlank(r2) == false) goto L18;
    L36:
        return;
    L9:
        if (StringsKt.isBlank(r1) == true) goto L12;
        r4 = false;
        goto L13
    L35:
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.dialog.viewholder.PKExpandCollapseViewHolder.a
    public final void Ew() {
        V90().toggleExpand();
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.dialog.fragment.d
    public final boolean FL() {
        return V90().isInviteRequesting();
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.dialog.fragment.d
    public final String ZP() {
        return V90().getSearchHintStr();
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.dialog.fragment.d
    public final int getSkinType() {
        return (int) V90().getSkinType();
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.dialog.fragment.d
    public final void jw() {
        V90().onTabOut();
    }

    @Override // x31.k
    public final void onConfirm() {
        PkTopTipView r0 = (PkTopTipView) S90(2131389231);
        if (r0 == null) goto L6;
        r0._$_findCachedViewById(2131384838).setVisibility(8);
        return;
    }

    public final void onDestroyView() {
        super.onDestroyView();
        com.bytedance.android.live.revlink.impl.multianchor.service.f.a.getClass();
        com.bytedance.android.live.revlink.impl.preload.a r1 = null;
        RevLinkLayoutPreloadContext r0 = RevLinkLayoutPreloadContext.Companion.getContext(null);
        if (r0 == null) goto L7;
        com.bytedance.live.datacontext.j<com.bytedance.android.live.revlink.impl.preload.a> r2 = r0.getAnchorService();
        if (r2 == null) goto L7;
        r1 = (com.bytedance.android.live.revlink.impl.preload.a) r2.getValue();
    L7:
        if (r1 == null) goto L9;
        r1.ze();
    L9:
        this.s.dispose();
        zy0.d r3 = this.E;
        if (r3 == null) goto L12;
        r3.dispose();
    L12:
        zy0.b r4 = this.k;
        if (r4 == null) goto L15;
        r4.dispose();
    L15:
        zy0.b r5 = this.l;
        if (r5 == null) goto L18;
        r5.dispose();
    L18:
        LinkRevPanelDataContext r6 = LinkRevPanelDataContext.Companion.getContext();
        if (r6 == null) goto L30;
        r6.asyncInflate(getContext());
        com.bytedance.live.datacontext.j<com.bytedance.android.live.revlink.impl.control.dialog.b> r7 = r6.getLoader();
        if (r7 == null) goto L25;
        com.bytedance.android.live.revlink.impl.control.dialog.b r8 = (com.bytedance.android.live.revlink.impl.control.dialog.b) r7.getValue();
        if (r8 == null) goto L25;
        r8.f("close");
    L25:
        com.bytedance.live.datacontext.j<com.bytedance.android.live.revlink.impl.control.dialog.b> r9 = r6.getLoader();
        if (r9 == null) goto L30;
        com.bytedance.android.live.revlink.impl.control.dialog.b r10 = (com.bytedance.android.live.revlink.impl.control.dialog.b) r9.getValue();
        if (r10 == null) goto L30;
        r10.n("live");
    L30:
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.e r12 = com.bytedance.android.live.revlink.impl.global.b.l();
        if (r12 == null) goto L34;
        Intrinsics.checkNotNullParameter("live_pk_icon", "<set-?>");
        r12.b = "live_pk_icon";
    L34:
        if (this.x == null) goto L36;
        Handler r13 = (Handler) this.y.getValue();
        v r14 = this.x;
        Intrinsics.checkNotNull(r14);
        r13.removeCallbacks(r14);
    L36:
        ((LinkedHashMap) this.d).clear();
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.dialog.fragment.c
    public final boolean vr() {
        return V90().isInviteRequesting();
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.dialog.fragment.d
    public final boolean EV(boolean r2) {
        return U90(V90().getInvalidExtra(), r2);
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.ui.x
    public final void Fy(String r8) {
        if (V90().isInviteRequesting() == false) goto L9;
        ToastUtil.a(2131921457, 0);
        LiveFullLinkPKMonitor r9 = com.bytedance.android.live.revlink.impl.global.b.q();
        if (r9 == null) goto L30;
        r9.k("random_click");
        return;
    L30:
        return;
    L9:
        if (RandomCheckDataContext.Companion.b() == true) goto L23;
        Context r0 = getContext();
        if ((r0 instanceof FragmentActivity) == true) goto L13;
        r0 = null;
    L13:
        FragmentActivity r1 = (FragmentActivity) r0;
        if (r1 == null) goto L23;
        FragmentManager r2 = r1.getSupportFragmentManager();
        if (r2 == null) goto L23;
        int r10 = RandomPKCheckFragment.m;
        RandomPKCheckFragment r12 = RandomPKCheckFragment.a.a(RandomMatchCheckSource.PKUserListFragment, null, null, null, this, 14);
        LandscapeRestrictionOperation r3 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r12, "random_pk_check_fragment", r3);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r2, r12, r3) == true) goto L31;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L27
    L21:
        r12.show(r2, "random_pk_check_fragment");
        return;
    L31:
        return;
    L23:
        if (r8 == null) goto L25;
        V90().doRandom(r8);
        return;
    L25:
        RevLinkAnchorViewModel.doRandom$default(V90(), null, 1, null);
    }

    public final View S90(int r3) {
        if (this.d != null) goto L5;
        this.d = new LinkedHashMap();
    L5:
        View r0 = this.d.get(Integer.valueOf(r3));
        if (r0 != null) goto L14;
        View r1 = getView();
        if (r1 == null) goto L12;
        View r2 = r1.findViewById(r3);
        if (r2 == null) goto L12;
        this.d.put(Integer.valueOf(r3), r2);
        return r2;
    L12:
        return null;
    L14:
        return r0;
    }

    public final View W90(String r6) {
        TextView r0 = new TextView(getContext());
        r0.setLayoutParams(new ViewGroup.LayoutParams(-2, UtilityKotlinExtentionsKt.i(28)));
        r0.setGravity(17);
        if (V90().isListOpt() == false) goto L5;
        r0.setTextSize(1, 13.0f);
        r0.setTextColor(ResourcesCompat.getColorStateList(r0.getContext().getResources(), 2131108043, null));
        r0.setPadding(UtilityKotlinExtentionsKt.i(0), 0, UtilityKotlinExtentionsKt.i(0), 0);
    L6:
        r0.setOnTouchListener(new b(this));
        r0.setText(r6);
        return r0;
    L5:
        r0.setTextAppearance(r0.getContext(), 2131953380);
        r0.setBackgroundResource(2131252906);
        r0.setPadding(UtilityKotlinExtentionsKt.i(12), 0, UtilityKotlinExtentionsKt.i(12), 0);
        goto L6
    }

    public final void X90(boolean r4) {
        if (this.x == null) goto L5;
        Handler r0 = (Handler) this.y.getValue();
        v r1 = this.x;
        Intrinsics.checkNotNull(r1);
        r0.removeCallbacks(r1);
    L5:
        if (r4 == false) goto L7;
        v r5 = new v(this);
        ((Handler) this.y.getValue()).postDelayed(r5, 700);
        this.x = r5;
        return;
    L7:
        LiveDoubleColorBallAnimationView r6 = S90(2131382372);
        if (r6 == null) goto L10;
        r6.setVisibility(4);
    L10:
        PkInviteUserListRefreshLayout r2 = S90(2131387827);
        if (r2 != null) goto L13;
        return;
    L13:
        if (r2.e != true) goto L20;
        PkInviteUserListRefreshLayout r7 = S90(2131387827);
        if (r7 == null) goto L21;
        r7.g();
        return;
    L21:
        return;
    }

    @Override // x31.l
    public final boolean isRequesting(IRoom r2) {
        return V90().isRequesting(r2);
    }

    @Override // x31.l
    public final void onCancel(IRoom r2) {
        V90().onCancel(r2);
    }

    public final void onCreate(Bundle r1) {
        super.onCreate(r1);
    }

    public final void onPageSelected(int r2) {
        V90().onPageSelected(r2);
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dialog.fragment.AnchorInteractContainerFragment.b
    public final void onUpdate(int r2) {
        AnchorInteractContainerFragment.b r0 = this.r;
        if (r0 == null) goto L6;
        r0.onUpdate(r2);
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dialog.fragment.AnchorInteractContainerFragment.b
    public final void q60(boolean r2) {
        AnchorInteractContainerFragment.b r0 = this.r;
        if (r0 == null) goto L6;
        r0.q60(r2);
        return;
    }

    public final void setUserVisibleHint(boolean r4) {
        super/*androidx.fragment.app.Fragment*/.setUserVisibleHint(r4);
        if (this.j == false) goto L9;
        if (r4 == false) goto L9;
        com.bytedance.android.live.revlink.impl.pk.utils.m r0 = this.o;
        if (r0 == null) goto L8;
        r0.c();
    L8:
        this.j = false;
    L9:
        if (r4 == false) goto L13;
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.e r1 = com.bytedance.android.live.revlink.impl.global.b.l();
        if (r1 == null) goto L13;
        Intrinsics.checkNotNullParameter("pk_banner", "<set-?>");
        r1.a = "pk_banner";
    L13:
        if (r4 == false) goto L19;
        LinkRevPanelDataContext r5 = LinkRevPanelDataContext.Companion.getContext();
        if (r5 == null) goto L25;
        com.bytedance.android.live.revlink.impl.pk.utils.k r6 = r5.getMetricUtil();
        if (r6 == null) goto L26;
        r6.e();
        return;
    L26:
        return;
    L25:
        return;
    L19:
        LinkRevPanelDataContext r7 = LinkRevPanelDataContext.Companion.getContext();
        if (r7 == null) goto L28;
        com.bytedance.android.live.revlink.impl.pk.utils.k r8 = r7.getMetricUtil();
        if (r8 == null) goto L29;
        r8.c();
        return;
    L29:
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.dialog.fragment.PkSubTabPagerAdapter.a
    public final RevLinkSubListFragment zy(y7 r9) {
        Intrinsics.checkNotNullParameter(r9, "tab");
        int r0 = RevLinkSubListFragment.t;
        int r1 = com.bytedance.android.live.revlink.impl.pk.dialog.vm.b.a(r9.getKey());
        String r2 = r9.getName();
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        IPkSubTabKey r3 = r9.getKey();
        if (r3 == null) goto L9;
        String r4 = r3.getActivityId();
        if (r4 == null) goto L9;
    L10:
        boolean r5 = this.u;
        IPkSubTabKey r10 = r9.getKey();
        if (r10 == null) goto L13;
        Integer r12 = Integer.valueOf(r10.getInviteType());
    L14:
        com.bytedance.android.live.revlink.impl.pk.utils.m r6 = this.o;
        DataCenter r7 = this.p;
        RevLinkAnchorViewModel r8 = V90();
        Intrinsics.checkNotNullParameter(r2, "name");
        Intrinsics.checkNotNullParameter(r4, "activityId");
        Intrinsics.checkNotNullParameter(r8, "inviteListener");
        RevLinkSubListFragment r13 = new RevLinkSubListFragment(r8);
        r13.m = r6;
        r13.n = r7;
        r13.f = r1;
        r13.h = r12;
        r13.e = r4;
        r13.g = "loadType-" + r1 + "-actId-" + r4 + '-' + r2 + '-' + r5;
        r13.o = this;
        r13.r = r5;
        return r13;
    L13:
        r12 = null;
    L9:
        r4 = DataType.FALSE;
        goto L10
    }

    public static final void T90(RevLinkAnchorListFragment r3, com.bytedance.android.live.revlink.impl.pk.dialog.vm.a r4) {
        PkRandomView r1 = (PkRandomView) r3.S90(2131382360);
        if (r1 == null) goto L6;
        r1.update(r4.a, r4.b);
    L6:
        if (r3.V90().isRandomOpt() == true) goto L11;
        PkRandomView r5 = (PkRandomView) r3.S90(2131382360);
        if (r5 == null) goto L12;
        r5.setRandomBtnTxt(s1.B(2131917847));
        return;
    L12:
        return;
    }

    public final boolean U90(u8 r9, boolean r10) {
        if (r9 != null) goto L5;
        return true;
    L5:
        if (r9.isHitPunish() == true) goto L7;
        return true;
    L7:
        if (V90().isAudioRoom() == true) goto L12;
        if (r10 == false) goto L12;
        long r2 = SystemClock.elapsedRealtime();
        if ((r2 - this.D) < 2000) goto L12;
        this.D = r2;
        int r12 = ToastUtil.a;
        ToastUtil.b(r9.getPunishTip(), 0);
    L12:
        return false;
    }

    public final boolean Y90(String r4, String r5) {
        com.bytedance.android.livesdk.sharedpref.e r0 = new com.bytedance.android.livesdk.sharedpref.e(r4, Boolean.FALSE);
        Boolean r6 = (Boolean) r0.getValue();
        Boolean r1 = Boolean.TRUE;
        if (Intrinsics.areEqual(r6, r1) == false) goto L5;
        return false;
    L5:
        View r7 = this.v;
        if (r7 == null) goto L8;
        r7.setVisibility(0);
    L8:
        View r8 = this.v;
        if (r8 == null) goto L11;
        r8.setOnClickListener(w.a);
    L11:
        TextView r9 = this.w;
        if (r9 == null) goto L14;
        r9.setText(r5);
    L14:
        Disposable r10 = Observable.timer(3, TimeUnit.SECONDS).compose(RxUtil.rxSchedulerHelper()).subscribe(new x(this));
        this.s.add(r10);
        com.bytedance.android.livesdk.sharedpref.f.d(r0, r1);
        return true;
    }

    public final void onViewCreated(View r12, Bundle r13) {
        Intrinsics.checkNotNullParameter(r12, "view");
        super.onViewCreated(r12, r13);
        d31.e r14 = com.bytedance.android.live.revlink.impl.global.b.d0();
        if (r14 == null) goto L5;
        i97.a r1 = i97.a.a;
        r14.a = System.currentTimeMillis();
        r14.c = 0;
    L5:
        AnchorInteractContainerFragment.c r15 = this.q;
        if (r15 == null) goto L8;
        r15.c();
    L8:
        S90(2131382372).setVisibility(4);
        S90(2131382879).setVisibility(0);
        ((TextView) S90(2131382364)).setOnClickListener(new l(this));
        S90(2131387827).setCallBack(new n(this));
        S90(2131387827).setFirstView(S90(2131363087));
        S90(2131387827).setOnRefreshListener(this);
        ((TouchUpConflictTabLayout) S90(2131387986)).addOnTabSelectedListener(this);
        S90(2131387583).addOnPageChangeListener(this);
        S90(2131387583).setOnTouchListener(new o(this));
        ((PkRandomView) S90(2131382360)).setListener(this);
        V90().getNotifyListEvent().observe(getViewLifecycleOwner(), new p(this));
        V90().getStopRefreshEvent().observe(getViewLifecycleOwner(), new q(this));
        V90().getErrorData().observe(getViewLifecycleOwner(), new r(this));
        V90().getTabs().observe(getViewLifecycleOwner(), new s(this));
        V90().getData().observe(getViewLifecycleOwner(), new t(this));
        V90().getRandomData().observe(getViewLifecycleOwner(), new u(this));
        V90().getDefaultRandomPkData().observe(getViewLifecycleOwner(), new c(this));
        V90().getRankSeasonInfo().observe(getViewLifecycleOwner(), new d(this));
        V90().getDataLoadFinish().observe(getViewLifecycleOwner(), new e(this));
        V90().getSelectedPos().observe(getViewLifecycleOwner(), new f(this));
        ((TouchConflictPkExposeRecyclerView) S90(2131389150)).setLayoutManager(new FixedForAppBarLayoutManager(getContext()));
        ((TouchConflictPkExposeRecyclerView) S90(2131389150)).setInviteIconPanelType("PK");
        RecyclerView.Adapter<?> r2 = new MultiTypeAdapter();
        r2.z2(y31.s.a.class, new y31.x());
        r2.z2(y31.m.a.class, new y31.m());
        com.bytedance.android.live.revlink.impl.pk.utils.m r4 = this.o;
        DataCenter r6 = this.p;
        Intrinsics.checkNotNull(r6);
        r2.z2(y31.k.class, new y31.j(r4, this, r6, this.u, 16));
        r2.z2(y31.i.a.class, new y31.i(this));
        ((TouchConflictPkExposeRecyclerView) S90(2131389150)).setAdapter(r2);
        Unit r16 = Unit.INSTANCE;
        this.f = r2;
        V90().isSeasonUnlock().observe(getViewLifecycleOwner(), new g(this));
        V90().isSeasonTabEnable().observe(getViewLifecycleOwner(), new h(this));
        V90().getShowRandomCheckDialogEvent().observe(getViewLifecycleOwner(), new i(this));
        V90().getFollowListData().observe(getViewLifecycleOwner(), new j(this));
        V90().getRecTitleData().observe(getViewLifecycleOwner(), new k(this));
        RxUtilKt.c(V90().getOnDismissEvent().subscribe(new m(this)), this.s);
        V90().doInit(this.p, this.e, this.z, this.A, this.B, this.u);
        this.v = r12.findViewById(2131374426);
        this.w = (TextView) r12.findViewById(2131364329);
        Context r17 = getContext();
        com.bytedance.android.live.revlink.impl.preload.a r3 = null;
        if (r17 == null) goto L27;
        IBaseUser r5 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.user.a.class).b();
        if (r5 == null) goto L14;
        Integer r7 = Integer.valueOf(r5.getSecret());
    L16:
        if (r7 != null) goto L19;
    L26:
        ((TextView) S90(2131383050)).setVisibility(8);
        goto L27
    L19:
        if (r7.intValue() != 1) goto L26;
        TextView r8 = (TextView) S90(2131383050);
        if (r8 == null) goto L23;
        r8.setVisibility(0);
    L23:
        String r9 = f51.a.e.a();
        if (TextUtils.isEmpty(r9) == true) goto L27;
        TextView r10 = (TextView) S90(2131383050);
        StringCompanionObject r18 = StringCompanionObject.INSTANCE;
        r10.setText(String.format(r9, Arrays.copyOf(new Object[]{r17.getString(2131914452)}, 1)));
        goto L27
    L14:
        r7 = null;
    L27:
        com.bytedance.android.live.revlink.impl.multianchor.service.f.a.getClass();
        RevLinkLayoutPreloadContext r19 = RevLinkLayoutPreloadContext.Companion.getContext(null);
        if (r19 == null) goto L32;
        com.bytedance.live.datacontext.j<com.bytedance.android.live.revlink.impl.preload.a> r110 = r19.getAnchorService();
        if (r110 == null) goto L32;
        r3 = (com.bytedance.android.live.revlink.impl.preload.a) r110.getValue();
    L32:
        if (r3 == null) goto L34;
        r3.Tm();
    L34:
        b51.b r111 = b51.b.c0;
        r111.getClass();
        if (((Boolean) b51.b.n.getValue(r111, b51.b.a[12])).booleanValue() == true) goto L37;
    L39:
        ImageView r112 = (ImageView) r12.findViewById(2131375994);
        if (r112 == null) goto L46;
        r112.setBackground(s1.m(2131249444));
        r112.setRotation(180.0f);
        r112.getLayoutParams().width = s1.f(12.0f);
        r112.getLayoutParams().height = s1.f(6.0f);
        ConstraintLayout.LayoutParams r113 = r112.getLayoutParams();
        if (r113 == null) goto L45;
        ((ViewGroup.MarginLayoutParams) r113).rightMargin = s1.f(40.0f);
        goto L46
    L45:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L46:
        TextView r114 = this.w;
        if (r114 == null) goto L49;
        r114.setBackground(s1.m(2131249447));
    L49:
        TextView r115 = this.w;
        if (r115 == null) goto L53;
        r115.setTextColor(s1.h(2131109391));
    L53:
        if (r111.c() == false) goto L55;
        Y90("pk_reserve_has_show", "可在这里查看PK邀约记录");
    L55:
        LinearLayout r116 = (LinearLayout) S90(2131362585);
        if (r116 == null) goto L58;
        UtilityKotlinExtentionsKt.z(r116, true);
    L58:
        PKRankUnlockView r117 = (PKRankUnlockView) S90(2131362602);
        if (r117 == null) goto L61;
        UtilityKotlinExtentionsKt.z(r117, false);
    L61:
        PKRankUnlockView r118 = (PKRankUnlockView) S90(2131362602);
        if (r118 == null) goto L65;
        r118.setOnRandomMatchBtnClick(new AnonymousClass21(this));
        return;
    L65:
        return;
    L37:
        if (Y90("pk_history_has_show", "可在这里查看PK记录并发表评价") == false) goto L39;
        goto L39
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.dialog.fragment.d
    public final void V80(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "guideType");
        Intrinsics.checkNotNullParameter(r3, "toUserGroup");
        Intrinsics.checkNotNullParameter(r4, "source");
        this.z = r2;
        this.A = r3;
        this.B = r4;
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131566085, r3, false);
    }

    @Override // x31.l
    public final void onInvite(IRoom r13, int r14, IRivalExtraInfo r15, int r16, m2 r17, List r18, int r19, int r20, String r22, HashMap r23, Boolean r24) {
        boolean r12 = r24.booleanValue();
        Intrinsics.checkNotNullParameter(r23, "logMap");
        V90().onInvite(r13, r14, r15, r16, r17, r18, r19, r20, r22, r23, r12);
        com.bytedance.android.live.revlink.impl.utils.x.b("live_link_last_invite_source", "pk_banner");
    }
}
