package com.bytedance.android.live.livepkaudience.dialog;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.utils.ListUtils;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.banner.BannerWidget;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.LinkPlayerInfo;
import com.bytedance.android.live.liveinteract.plantform.model.WaitingListType;
import com.bytedance.android.live.livepkaudience.view.BaseRefreshLayout;
import com.bytedance.android.live.livepkaudience.view.PkOnlineFriendsCircleContainer;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.live.utils.HostEnv;
import com.bytedance.android.livesdk.utils.d5;
import com.bytedance.android.livesdk.utils.t6;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.common.utility.Lists;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/livepkaudience/dialog/BasePkAudienceApplyListFragment;", "Lcom/bytedance/android/live/livepkaudience/dialog/BasePkAudienceApplyListContract$View;", "<init>", "()V", "a", "livepkaudience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class BasePkAudienceApplyListFragment extends BasePkAudienceApplyListContract$View {
    public static final /* synthetic */ int I = 0;
    public boolean A;
    public final CompositeDisposable B;
    public boolean C;
    public Room D;
    public boolean E;
    public final Handler F;
    public final boolean G;
    public BannerWidget H;
    public BaseRefreshLayout g;
    public final LinkedList<Object> h;
    public final LinkedList<LinkPlayerInfo> i;
    public boolean j;
    public View k;
    public RecyclerView l;
    public LinearLayout m;
    public LinearLayout n;
    public TextView o;
    public TextView p;
    public ImageView q;
    public TextView r;
    public PkOnlineFriendsCircleContainer s;
    public MultiTypeAdapter t;
    public DataCenter u;
    public ViewGroup v;
    public TextView w;
    public ImageView x;
    public String y;
    public int z;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ BaseRefreshLayout a;

        public b(BaseRefreshLayout r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.A.run();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements BaseRefreshLayout.c {
        public final /* synthetic */ BasePkAudienceApplyListFragment a;

        @Override // com.bytedance.android.live.livepkaudience.view.BaseRefreshLayout.c
        public final void onFinish() {
        }

        @Override // com.bytedance.android.live.livepkaudience.view.BaseRefreshLayout.c
        public final void y0() {
        }

        @Override // com.bytedance.android.live.livepkaudience.view.BaseRefreshLayout.c
        public final void onRefresh() {
            this.a.h.clear();
            BasePkAudienceApplyListFragment r0 = this.a;
            com.bytedance.android.live.livepkaudience.dialog.a.g((com.bytedance.android.live.livepkaudience.dialog.a) r0.f, true, "linkListDownRefresh", 0, null, r0.z, 12);
            HashMap r1 = new HashMap();
            com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r2 = ((IInteractService) jc1.k.n(IInteractService.class)).getLinkUserInfoCenter();
            if (r2 != null) goto L5;
            int r3 = 0;
        L6:
            r1.put("apply_list_num", String.valueOf(r3));
            r1.put("refresh_type", "draw");
            el0.j.k(r1);
            el0.j.n(r1, Integer.valueOf(dl0.n.a()));
            com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_anchor_audience_apply_panel_show", r1, new Object[]{am2.x.class, Room.class});
            return;
        L5:
            r3 = r2.a().size();
            goto L6
        }

        @Override // com.bytedance.android.live.livepkaudience.view.BaseRefreshLayout.c
        public final void z1() {
            View r0 = this.a.k;
            if (r0 == null) goto L6;
            r0.setVisibility(0);
            return;
        }

        public c(BasePkAudienceApplyListFragment r1) {
            this.a = r1;
        }
    }

    public static final class d implements BannerWidget.a {
        public final /* synthetic */ BasePkAudienceApplyListFragment a;

        @Override // com.bytedance.android.live.liveinteract.banner.BannerWidget.a
        public final void b(boolean r1, Map<String, String> r2) {
        }

        @Override // com.bytedance.android.live.liveinteract.banner.BannerWidget.a
        public final boolean a() {
            return this.a.getUserVisibleHint();
        }

        public d(BasePkAudienceApplyListFragment r1) {
            this.a = r1;
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.livepkaudience.dialog.RevInteractDialogFragmentBaseContract$View
    public final String T90() {
        return "";
    }

    public void ea0(int r1) {
    }

    public void fa0(boolean r1, boolean r2) {
    }

    public final void da0() {
        HashMap r0 = new HashMap();
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r1 = ((IInteractService) jc1.k.n(IInteractService.class)).getLinkUserInfoCenter();
        if (r1 != null) goto L5;
        int r2 = 0;
    L6:
        r0.put("apply_list_num", String.valueOf(r2));
        r0.put("refresh_type", "click_icon");
        el0.j.j(r0, Integer.valueOf(dl0.n.a()));
        el0.j.n(r0, Integer.valueOf(dl0.n.a()));
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_anchor_audience_apply_panel_show", r0, new Object[]{am2.x.class, Room.class});
        return;
    L5:
        r2 = r1.a().size();
        goto L6
    }

    public void onDestroy() {
        if (this.B.isDisposed() == true) goto L5;
        this.B.dispose();
    L5:
        super.onDestroy();
        this.F.removeCallbacksAndMessages(null);
        this.h.clear();
        this.i.clear();
        this.j = true;
        this.A = false;
    }

    public BasePkAudienceApplyListFragment() {
        this.h = new LinkedList();
        this.i = new LinkedList();
        this.j = true;
        this.y = "";
        this.z = WaitingListType.UNKNOWN.ordinal();
        this.B = new CompositeDisposable();
        this.F = new Handler();
        this.G = jc1.k.n(IUserService.class).user().c();
    }

    @Override // com.bytedance.android.live.livepkaudience.dialog.RevInteractDialogFragmentBaseContract$View
    public final float S90() {
        return UtilityKotlinExtentionsKt.j(t6.c(s1.getContext()) * 1.2f) - 48;
    }

    public final void onResume() {
        super.onResume();
        ((com.bytedance.android.live.livepkaudience.dialog.a) this.f).d();
    }

    @Override // com.bytedance.android.live.livepkaudience.dialog.BasePkAudienceApplyListContract$View
    public final void V90(boolean r2) {
        TextView r0 = this.r;
        if (r0 == null) goto L9;
        if (r2 == false) goto L6;
        String r3 = s1.B(2131918110);
    L7:
        r0.setText(r3);
        return;
    L6:
        r3 = s1.B(2131918109);
        goto L7
    }

    @Override // com.bytedance.android.live.livepkaudience.dialog.BasePkAudienceApplyListContract$View
    public final void W90(boolean r2) {
        if (r2 == true) goto L4;
        return;
    L4:
        if (this.h.isEmpty() == true) goto L10;
        LinkedList<Object> r3 = this.h;
        if ((ListProtector.get(r3, r3.size() - 1) instanceof yk0.a.C0295a) == false) goto L11;
        this.h.removeLast();
        return;
    L11:
        return;
    }

    @Override // com.bytedance.android.live.livepkaudience.dialog.BasePkAudienceApplyListContract$View
    public final void X90(List<? extends LinkPlayerInfo> r9) {
        Intrinsics.checkNotNullParameter(r9, "linkPlayerInfos");
        ea0(((ArrayList) r9).size());
        if (Lists.isEmpty(r9) == false) goto L5;
        ((com.bytedance.android.live.livepkaudience.dialog.a) this.f).e();
        return;
    L5:
        com.bytedance.android.live.livepkaudience.dialog.a.g((com.bytedance.android.live.livepkaudience.dialog.a) this.f, true, "onCheckApplySuccessListNotEmpty", 0, null, this.z, 12);
    }

    @Override // com.bytedance.android.live.livepkaudience.dialog.BasePkAudienceApplyListContract$View
    public final void Y90(List<? extends LinkPlayerInfo> r4) {
        Intrinsics.checkNotNullParameter(r4, "linkPlayerInfos");
        if (Lists.isEmpty(r4) == false) goto L5;
        ((com.bytedance.android.live.livepkaudience.dialog.a) this.f).h();
    L22:
        if (this.A == true) goto L25;
        this.A = true;
        da0();
        return;
    L25:
        return;
    L5:
        this.C = false;
        LinearLayout r1 = this.m;
        if (r1 == null) goto L8;
        r1.setVisibility(0);
    L8:
        RecyclerView r2 = this.l;
        if (r2 == null) goto L11;
        r2.setVisibility(8);
    L11:
        LinearLayout r3 = this.n;
        if (r3 == null) goto L14;
        r3.setVisibility(8);
    L14:
        TextView r5 = this.o;
        if (r5 == null) goto L17;
        r5.setText(s1.B(2131917667));
    L17:
        TextView r6 = this.p;
        if (r6 == null) goto L20;
        r6.setText(s1.B(2131917668));
    L20:
        fa0(false, true);
        goto L22
    }

    @Override // com.bytedance.android.live.livepkaudience.dialog.BasePkAudienceApplyListContract$View
    public final void Z90(Throwable r3) {
        Intrinsics.checkNotNullParameter(r3, "throwable");
        if (getView() != null) goto L5;
        return;
    L5:
        r3.printStackTrace();
        this.C = false;
        RecyclerView r0 = this.l;
        if (r0 == null) goto L8;
        r0.setVisibility(8);
    L8:
        LinearLayout r1 = this.m;
        if (r1 == null) goto L11;
        r1.setVisibility(8);
    L11:
        LinearLayout r2 = this.n;
        if (r2 == null) goto L14;
        r2.setVisibility(0);
    L14:
        fa0(true, false);
    }

    @Override // com.bytedance.android.live.livepkaudience.dialog.BasePkAudienceApplyListContract$View
    public final void ba0(final bl0.b r6) {
        Intrinsics.checkNotNullParameter(r6, "body");
        LinearLayout r0 = this.m;
        if (r0 == null) goto L5;
        r0.setVisibility(0);
    L5:
        LinearLayout r1 = this.n;
        if (r1 == null) goto L8;
        r1.setVisibility(8);
    L8:
        RecyclerView r2 = this.l;
        if (r2 == null) goto L11;
        r2.setVisibility(8);
    L11:
        fa0(false, true);
        Room r3 = this.D;
        if (r3 == null) goto L18;
        User r4 = r3.getOwner();
        if (r4 == null) goto L18;
        if (r4.getSecret() != 1) goto L18;
    L21:
        ImageView r7 = this.q;
        if (r7 == null) goto L24;
        r7.setVisibility(0);
    L24:
        PkOnlineFriendsCircleContainer r8 = this.s;
        if (r8 == null) goto L60;
        r8.setVisibility(8);
        return;
    L60:
        return;
    L18:
        if (this.E == false) goto L20;
    L28:
        this.C = true;
        List<bl0.a> r5 = r6.user;
        if (r5 != null) goto L31;
    L50:
        TextView r9 = this.p;
        if (r9 == null) goto L53;
        r9.setText(r6.notice);
    L53:
        TextView r10 = this.o;
        if (r10 == null) goto L56;
        r10.setText(s1.B(2131917671));
    L56:
        TextView r11 = this.o;
        if (r11 == null) goto L61;
        r11.setOnClickListener(x0.a(new BasePkAudienceApplyListFragment$onFetchOnlineFriendsSuccess$$inlined$let$lambda$1(this, r6)));
        return;
    L61:
        return;
    L31:
        if (Lists.isEmpty(r5) == false) goto L38;
        ImageView r12 = this.q;
        if (r12 == null) goto L35;
        r12.setVisibility(0);
    L35:
        TextView r13 = this.o;
        if (r13 == null) goto L50;
        r13.setText(s1.B(2131917667));
        goto L50
    L38:
        ImageView r14 = this.q;
        if (r14 == null) goto L41;
        r14.setVisibility(8);
    L41:
        PkOnlineFriendsCircleContainer r15 = this.s;
        if (r15 == null) goto L44;
        r15.a(r5);
    L44:
        PkOnlineFriendsCircleContainer r16 = this.s;
        if (r16 == null) goto L47;
        r16.setVisibility(0);
    L47:
        TextView r17 = this.o;
        if (r17 == null) goto L50;
        r17.setText(s1.B(2131917671));
        goto L50
    L20:
        if (this.G == false) goto L28;
        goto L21
    }

    public final List<Long> ca0(List<? extends LinkPlayerInfo> r4) {
        ArrayList r0 = new ArrayList();
        if (r4 == null) goto L14;
        Iterator<T> r5 = r4.iterator();
    L6:
        if (r5.hasNext() == false) goto L14;
        IBaseUser r1 = ((LinkPlayerInfo) r5.next()).getUser();
        if (r1 == null) goto L12;
        String r2 = r1.getIdString();
        if (r2 == null) goto L12;
        long r3 = d5.c(r2);
    L13:
        r0.add(Long.valueOf(r3));
    L12:
        r3 = 0;
    L14:
        return r0;
    }

    public void onCreate(Bundle r2) {
        super.onCreate(r2);
        Room r3 = jc1.k.n(IRoomService.class).getCurrentRoom();
        this.D = r3;
        if (r3 == null) goto L5;
        String r4 = r3.getOwnerUserIdString();
    L6:
        this.E = Intrinsics.areEqual(r4, jc1.k.n(IUserService.class).user().n());
        return;
    L5:
        r4 = null;
        goto L6
    }

    public void setUserVisibleHint(boolean r2) {
        super/*androidx.fragment.app.Fragment*/.setUserVisibleHint(r2);
        RecyclerView r0 = this.l;
        if (r0 == null) goto L5;
        r0.setNestedScrollingEnabled(r2);
    L5:
        RecyclerView r1 = this.l;
        if (r1 == null) goto L8;
        r1.requestLayout();
    L8:
        if (r2 == false) goto L13;
        BannerWidget r3 = this.H;
        if (r3 == null) goto L14;
        r3.wq();
        return;
    L14:
        return;
    }

    public void onViewCreated(View r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r8, "view");
        super.onViewCreated(r8, r9);
        this.g = (BaseRefreshLayout) r8.findViewById(2131392080);
        this.l = r8.findViewById(2131384731);
        this.k = r8.findViewById(2131392077);
        this.m = (LinearLayout) r8.findViewById(2131371557);
        this.n = (LinearLayout) r8.findViewById(2131371744);
        this.o = (TextView) r8.findViewById(2131375618);
        this.p = (TextView) r8.findViewById(2131375606);
        this.q = (ImageView) r8.findViewById(2131371586);
        this.r = (TextView) r8.findViewById(2131390161);
        this.s = (PkOnlineFriendsCircleContainer) r8.findViewById(2131373315);
        MultiTypeAdapter r10 = new MultiTypeAdapter();
        this.t = r10;
        RecyclerView r0 = this.l;
        if (r0 == null) goto L5;
        r0.setAdapter(r10);
    L5:
        RecyclerView r11 = this.l;
        if (r11 == null) goto L8;
        r11.setLayoutManager(new LinearLayoutManager(getContext()));
    L8:
        MultiTypeAdapter r12 = this.t;
        if (r12 == null) goto L11;
        r12.z2(yk0.a.C0295a.class, new yk0.a());
    L11:
        MultiTypeAdapter r13 = this.t;
        if (r13 == null) goto L17;
        Object r2 = this.f;
        if ((r2 instanceof com.bytedance.android.live.livepkaudience.presenter.b) == true) goto L16;
        r2 = null;
    L16:
        r13.z2(com.bytedance.android.live.livepkaudience.list.l.a.class, new com.bytedance.android.live.livepkaudience.list.l((com.bytedance.android.live.livepkaudience.presenter.b) r2, this.h));
    L17:
        MultiTypeAdapter r14 = this.t;
        if (r14 == null) goto L20;
        r14.z2(com.bytedance.android.live.livepkaudience.list.a.class, new com.bytedance.android.live.livepkaudience.list.r());
    L20:
        MultiTypeAdapter r15 = this.t;
        if (r15 == null) goto L24;
        r15.A2(this.h);
    L24:
        if (this.E == false) goto L26;
    L30:
        TextView r16 = this.o;
        if (r16 == null) goto L33;
        r16.setText(s1.B(2131917667));
    L33:
        Context r17 = getContext();
        if (r17 == null) goto L38;
        TextView r1 = this.o;
        if (r1 == null) goto L38;
        r1.setBackground(ContextCompat.getDrawable(r17, 2131249992));
    L38:
        BaseRefreshLayout r18 = this.g;
        if (r18 == null) goto L41;
        r18.setmIsDisable(false);
    L41:
        BaseRefreshLayout r19 = this.g;
        if (r19 == null) goto L44;
        r19.setOnRefreshListener(new c(this));
    L44:
        RecyclerView r20 = this.l;
        if (r20 == null) goto L47;
        r20.addOnScrollListener(new AnonymousClass3(this));
    L47:
        this.w = (TextView) r8.findViewById(2131364776);
        this.x = (ImageView) r8.findViewById(2131364681);
        this.v = (ViewGroup) r8.findViewById(2131363189);
        this.H = new BannerWidget(jc1.k.n(IRoomService.class).getCurrentRoom(), 21, "apply_message_panel", null, new d(this));
        WidgetManager.of(this, r8).load(2131372686, this.H);
        return;
    L26:
        if (this.G == false) goto L30;
        TextView r21 = this.o;
        if (r21 == null) goto L30;
        r21.setVisibility(8);
        goto L30
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131565509, r3, false);
    }

    @Override // com.bytedance.android.live.livepkaudience.dialog.BasePkAudienceApplyListContract$View
    public final void aa0(List<? extends LinkPlayerInfo> r6, int r7, boolean r8, String r9, String r10, int r11) {
        Intrinsics.checkNotNullParameter(r6, "linkPlayerInfos");
        Intrinsics.checkNotNullParameter(r9, "cursor");
        Intrinsics.checkNotNullParameter(r10, "reqSource");
        if (getView() != null) goto L6;
        return;
    L6:
        if (this.z != WaitingListType.UNKNOWN.ordinal()) goto L8;
        this.z = r11;
    L8:
        BaseRefreshLayout r12 = this.g;
        if (r12 != null) goto L11;
    L18:
        this.C = false;
        if (Intrinsics.areEqual(r10, "anchorChangeSortType") == false) goto L21;
        this.h.clear();
    L21:
        boolean r13 = this.j;
        if (r7 <= r6.size()) goto L31;
        if (r13 == false) goto L31;
        if (ListUtils.isEmpty(this.i) == false) goto L27;
    L32:
        this.i.addAll(r6);
        MultiTypeAdapter r14 = this.t;
        if (r14 == null) goto L49;
        LinkedList<LinkPlayerInfo> r15 = this.i;
        if (Lists.isEmpty(r15) == false) goto L37;
        LinkedList<Object> r16 = this.h;
    L48:
        r14.a = r16;
        goto L49
    L37:
        yk0.a.C0295a r1 = new yk0.a.C0295a();
        this.h.clear();
        this.h.addAll(r15);
        if (this.h.size() <= 0) goto L40;
        this.h.add(0, new com.bytedance.android.live.livepkaudience.list.l.a());
    L40:
        if (r8 == true) goto L42;
        r1.a = 1;
    L44:
        if ((this.h.getLast() instanceof yk0.a.C0295a) == true) goto L46;
        this.h.add(r1);
    L47:
        this.j = r8;
        r16 = this.h;
        goto L48
    L46:
        this.h.removeLast();
        this.h.add(r1);
        goto L47
    L42:
        r1.a = 0;
    L49:
        MultiTypeAdapter r17 = this.t;
        if (r17 == null) goto L53;
        r17.notifyDataSetChanged();
    L53:
        if (Lists.isEmpty(this.h) == false) goto L63;
        RecyclerView r18 = this.l;
        if (r18 == null) goto L57;
        r18.setVisibility(8);
    L57:
        LinearLayout r19 = this.m;
        if (r19 == null) goto L60;
        r19.setVisibility(0);
    L60:
        LinearLayout r20 = this.n;
        if (r20 == null) goto L72;
        r20.setVisibility(8);
    L72:
        fa0(false, Lists.isEmpty(this.h));
        this.y = r9;
        if (this.A == true) goto L76;
        this.A = true;
        da0();
        return;
    L76:
        return;
    L63:
        RecyclerView r21 = this.l;
        if (r21 == null) goto L66;
        r21.setVisibility(0);
    L66:
        LinearLayout r22 = this.m;
        if (r22 == null) goto L69;
        r22.setVisibility(8);
    L69:
        LinearLayout r23 = this.n;
        if (r23 == null) goto L72;
        r23.setVisibility(8);
        goto L72
    L27:
        if (ListUtils.isEmpty(r6) == true) goto L32;
        List<Long> r24 = ca0(this.i);
        ArrayList r25 = (ArrayList) r24;
        r25.retainAll(ca0(r6));
        if (r25.size() <= 0) goto L32;
        this.i.clear();
    L31:
        this.i.clear();
        goto L32
    L11:
        if (r12.e == false) goto L18;
        if (HostEnv.b() == true) goto L17;
        View r2 = this.k;
        if (r2 == null) goto L17;
        r2.setVisibility(8);
    L17:
        this.F.postDelayed(new b(r12), 1000);
        goto L18
    }
}
