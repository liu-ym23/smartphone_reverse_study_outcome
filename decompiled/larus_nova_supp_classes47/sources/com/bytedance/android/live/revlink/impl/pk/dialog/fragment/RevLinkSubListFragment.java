package com.bytedance.android.live.revlink.impl.pk.dialog.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.revlink.impl.monitor.LiveFullLinkPKMonitor;
import com.bytedance.android.live.revlink.impl.pk.dialog.vm.RevLinkAnchorSubViewModel;
import com.bytedance.android.live.revlink.impl.pk.dialog.vm.RevLinkAnchorViewModel;
import com.bytedance.android.live.revlink.impl.pk.flexactivity.ActContentAreaViewBinder;
import com.bytedance.android.live.revlink.impl.pk.flexactivity.ActTitleInfoView;
import com.bytedance.android.live.revlink.impl.pk.flexactivity.FlexActivityTitleViewBinder;
import com.bytedance.android.live.revlink.impl.pk.ui.TouchConflictPkExposeRecyclerView;
import com.bytedance.android.live.revlink.impl.pk.utils.FixedForAppBarLayoutManager;
import com.bytedance.android.live.revlink.impl.ui.LiveLoadingLayout;
import com.bytedance.android.livesdk.link.model.IBattleRivalTag;
import com.bytedance.android.livesdk.link.model.IPanelArea;
import com.bytedance.android.livesdk.link.model.IRivalExtraInfo;
import com.bytedance.android.livesdk.link.model.m2;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.multitype.MultiTypeAdapter;
import y31.r;
import y31.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/dialog/fragment/RevLinkSubListFragment;", "Lcom/bytedance/android/live/revlink/impl/pk/dialog/fragment/BaseSubFragment;", "Lx31/l;", "Lcom/bytedance/android/live/revlink/impl/pk/flexactivity/ActTitleInfoView$b;", "a", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RevLinkSubListFragment extends BaseSubFragment implements x31.l, ActTitleInfoView.b {
    public static final /* synthetic */ int t = 0;
    public Map<Integer, View> d;
    public String e;
    public int f;
    public String g;
    public Integer h;
    public boolean i;
    public final Lazy j;
    public final Lazy k;
    public MultiTypeAdapter l;
    public com.bytedance.android.live.revlink.impl.pk.utils.m m;
    public DataCenter n;
    public com.bytedance.android.live.revlink.impl.pk.dialog.fragment.c o;
    public e p;
    public final Lazy q;
    public boolean r;
    public final x31.l s;

    public static final class a {
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ RevLinkSubListFragment a;

        public b(RevLinkSubListFragment r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            Boolean r4 = (Boolean) r3;
            if (r4 == null) goto L6;
            RevLinkSubListFragment r0 = this.a;
            boolean r5 = r4.booleanValue();
            int r1 = RevLinkSubListFragment.t;
            r0.T90(r5);
            return;
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ RevLinkSubListFragment a;

        public c(RevLinkSubListFragment r1) {
            this.a = r1;
        }

        public final void onChanged(Object r4) {
            List<? extends IPanelArea> r5 = (List) r4;
            RevLinkSubListFragment r0 = this.a;
            int r1 = RevLinkSubListFragment.t;
            r0.T90(false);
            if (r5 == null) goto L9;
            RecyclerView r2 = (TouchConflictPkExposeRecyclerView) this.a.S90(2131384076);
            if (r2 == null) goto L7;
            r2.setVisibility(0);
        L7:
            ((com.bytedance.android.live.revlink.impl.pk.flexactivity.d) this.a.k.getValue()).update(this.a.e, r5);
            return;
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ RevLinkSubListFragment a;

        public d(RevLinkSubListFragment r1) {
            this.a = r1;
        }

        public final void onChanged(Object r6) {
            List r7 = (List) r6;
            if (r7 == null) goto L36;
            RevLinkSubListFragment r0 = this.a;
            int r1 = RevLinkSubListFragment.t;
            r0.T90(false);
            if (r7.isEmpty() == false) goto L16;
            MultiTypeAdapter r2 = this.a.l;
            if (r2 == null) goto L16;
            if (r2.getItemCount() != 0) goto L16;
            NestedScrollView r3 = this.a.S90(2131378674);
            if (r3 == null) goto L13;
            r3.setVisibility(0);
        L13:
            RecyclerView r4 = (TouchConflictPkExposeRecyclerView) this.a.S90(2131384076);
            if (r4 == null) goto L22;
            r4.setVisibility(4);
        L22:
            TouchConflictPkExposeRecyclerView r5 = (TouchConflictPkExposeRecyclerView) this.a.S90(2131384076);
            if (r5 == null) goto L26;
            r5.r();
        L26:
            if ((!r7.isEmpty()) == false) goto L32;
            MultiTypeAdapter r8 = this.a.l;
            if (r8 == null) goto L30;
            r8.a = r7;
        L30:
            if (r8 == null) goto L32;
            r8.notifyDataSetChanged();
        L32:
            d31.e r9 = com.bytedance.android.live.revlink.impl.global.b.d0();
            if (r9 == null) goto L37;
            r9.c();
            return;
        L37:
            return;
        L16:
            NestedScrollView r10 = this.a.S90(2131378674);
            if (r10 == null) goto L19;
            r10.setVisibility(4);
        L19:
            RecyclerView r12 = (TouchConflictPkExposeRecyclerView) this.a.S90(2131384076);
            if (r12 == null) goto L22;
            r12.setVisibility(0);
            goto L22
        }
    }

    public static final class e implements Runnable {
        public final /* synthetic */ RevLinkSubListFragment a;

        public e(RevLinkSubListFragment r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            LiveLoadingLayout r0 = (LiveLoadingLayout) this.a.S90(2131382352);     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            r0.setVisibility(0);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    static {
    }

    @Override // x31.l
    public final boolean isRequesting(IRoom r2) {
        return this.s.isRequesting(r2);
    }

    @Override // x31.l
    public final void onCancel(IRoom r2) {
        this.s.onCancel(r2);
    }

    @Override // x31.l
    public final void onInvite(IRoom r14, int r15, IRivalExtraInfo r16, int r17, m2 r18, List<IBattleRivalTag> r19, int r20, int r22, String r23, HashMap<String, String> r24, Boolean r25) {
        this.s.onInvite(r14, r15, r16, r17, r18, r19, r20, r22, r23, r24, r25);
    }

    public final void onDestroyView() {
        super.onDestroyView();
        this.i = false;
        T90(false);
        ((LinkedHashMap) this.d).clear();
    }

    public final void onResume() {
        super.onResume();
        if (this.i == true) goto L9;
        this.i = true;
        RevLinkAnchorSubViewModel r0 = (RevLinkAnchorSubViewModel) this.j.getValue();
        if (r0 != null) goto L7;
        return;
    L7:
        r0.initData();
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.dialog.fragment.BaseSubFragment
    public final String getUniqueId() {
        return this.g;
    }

    public RevLinkSubListFragment(RevLinkAnchorViewModel r2) {
        Intrinsics.checkNotNullParameter(r2, "inviteListener");
        this.s = r2;
        this.d = new LinkedHashMap();
        this.e = DataType.FALSE;
        this.g = "";
        this.j = LazyKt.lazy(new RevLinkSubListFragment$vm$2(this));
        this.k = LazyKt.lazy(RevLinkSubListFragment$actWidget$2.INSTANCE);
        this.q = LazyKt.lazy(RevLinkSubListFragment$mainHandler$2.INSTANCE);
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

    public final void T90(boolean r4) {
        if (this.p == null) goto L5;
        Handler r0 = (Handler) this.q.getValue();
        e r1 = this.p;
        Intrinsics.checkNotNull(r1);
        r0.removeCallbacks(r1);
    L5:
        if (r4 == false) goto L7;
        e r5 = new e(this);
        ((Handler) this.q.getValue()).postDelayed(r5, 500);
        this.p = r5;
        return;
    L7:
        LiveLoadingLayout r6 = (LiveLoadingLayout) S90(2131382352);
        if (r6 == null) goto L12;
        r6.setVisibility(8);
        return;
    }

    public final void setUserVisibleHint(boolean r3) {
        super/*androidx.fragment.app.Fragment*/.setUserVisibleHint(r3);
        TouchConflictPkExposeRecyclerView r1 = (TouchConflictPkExposeRecyclerView) S90(2131384076);
        if (r1 == null) goto L5;
        r1.setNestedScrollingEnabled(r3);
    L5:
        TouchConflictPkExposeRecyclerView r4 = (TouchConflictPkExposeRecyclerView) S90(2131384076);
        if (r4 == null) goto L9;
        r4.requestLayout();
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.flexactivity.ActTitleInfoView.b
    public final void Kv(String r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "activityId");
        com.bytedance.android.live.revlink.impl.pk.dialog.fragment.c r0 = this.o;
        if (r0 != null) goto L5;
    L10:
        RevLinkAnchorSubViewModel r1 = (RevLinkAnchorSubViewModel) this.j.getValue();
        if (r1 != null) goto L13;
        return;
    L13:
        r1.reqAction(r3, r4);
        return;
    L5:
        if (r0.vr() != true) goto L10;
        ToastUtil.a(2131921457, 0);
        LiveFullLinkPKMonitor r5 = com.bytedance.android.live.revlink.impl.global.b.q();
        if (r5 == null) goto L15;
        r5.k("sub_tab_select");
        return;
    }

    public final void onViewCreated(View r12, Bundle r13) {
        Intrinsics.checkNotNullParameter(r12, "view");
        super.onViewCreated(r12, r13);
        final RevLinkAnchorSubViewModel r14 = (RevLinkAnchorSubViewModel) this.j.getValue();
        if (r14 != null) goto L5;
        return;
    L5:
        r14.setArgument(this.f, this.e, this.r);
        r14.getLoading().observe(getViewLifecycleOwner(), new b(this));
        if (r14.isAct() == false) goto L8;
        ((TouchConflictPkExposeRecyclerView) S90(2131384076)).setVisibility(8);
        com.bytedance.android.live.revlink.impl.pk.flexactivity.d r0 = (com.bytedance.android.live.revlink.impl.pk.flexactivity.d) this.k.getValue();
        Integer r2 = this.h;
        DataCenter r6 = this.n;
        com.bytedance.android.live.revlink.impl.pk.dialog.fragment.c r3 = this.o;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r12, "container");
        r0.e = r2;
        r0.c = r12;
        r0.getClass();
        ((TouchConflictPkExposeRecyclerView) r12.findViewById(2131384076)).setLayoutManager(new FixedForAppBarLayoutManager(r12.getContext()));
        RecyclerView.Adapter<?> r4 = new MultiTypeAdapter();
        r4.z2(y31.e.a.class, new y31.e(this));
        r4.z2(y31.f.a.class, new y31.f());
        r4.z2(y31.g.a.class, new y31.g(r3));
        r4.z2(ActContentAreaViewBinder.a.class, new ActContentAreaViewBinder());
        r4.z2(FlexActivityTitleViewBinder.a.class, new FlexActivityTitleViewBinder());
        r4.z2(com.bytedance.android.live.revlink.impl.pk.flexactivity.a.C0171a.class, new com.bytedance.android.live.revlink.impl.pk.flexactivity.a());
        r4.z2(y31.k.class, new y31.j(null, new com.bytedance.android.live.revlink.impl.pk.flexactivity.c(r0, r3), r6, false, 48));
        ((TouchConflictPkExposeRecyclerView) r12.findViewById(2131384076)).setAdapter(r4);
        r0.d = r4;
        r14.getActAreaData().observe(getViewLifecycleOwner(), new c(this));
        return;
    L8:
        RecyclerView r15 = (TouchConflictPkExposeRecyclerView) S90(2131384076);
        if (r15 == null) goto L11;
        r15.setVisibility(0);
    L11:
        TouchConflictPkExposeRecyclerView r16 = (TouchConflictPkExposeRecyclerView) S90(2131384076);
        if (r16 == null) goto L14;
        r16.setHasFixedSize(true);
    L14:
        TouchConflictPkExposeRecyclerView r17 = (TouchConflictPkExposeRecyclerView) S90(2131384076);
        if (r17 == null) goto L17;
        r17.setInviteIconPanelType("PK");
    L17:
        TouchConflictPkExposeRecyclerView r18 = (TouchConflictPkExposeRecyclerView) S90(2131384076);
        if (r18 == null) goto L20;
        r18.setLayoutManager(new FixedForAppBarLayoutManager(getContext()));
    L20:
        TouchConflictPkExposeRecyclerView r19 = (TouchConflictPkExposeRecyclerView) S90(2131384076);
        if (r19 == null) goto L23;
        r19.addOnScrollListener(new AnonymousClass3(r14));
    L23:
        RecyclerView.Adapter<?> r110 = new MultiTypeAdapter();
        r110.z2(s.a.class, new r());
        r110.z2(y31.m.a.class, new y31.m());
        com.bytedance.android.live.revlink.impl.pk.utils.m r5 = this.m;
        DataCenter r7 = this.n;
        Intrinsics.checkNotNull(r7);
        r110.z2(y31.k.class, new y31.j(r5, this, r7, false, true, this.r));
        TouchConflictPkExposeRecyclerView r1 = (TouchConflictPkExposeRecyclerView) S90(2131384076);
        if (r1 == null) goto L26;
        r1.setAdapter(r110);
    L26:
        Unit r8 = Unit.INSTANCE;
        this.l = r110;
        r14.getListData().observe(getViewLifecycleOwner(), new d(this));
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131566086, r3, false);
    }
}
