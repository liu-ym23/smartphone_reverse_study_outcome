package com.bytedance.android.live.revlink.impl.multianchor.dialog.pk;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.model.BizType;
import com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.vm.MultiAnchorPkInviteViewModel;
import com.bytedance.android.live.revlink.impl.multianchor.match.MultiPkMatchContext;
import com.bytedance.android.live.revlink.impl.multianchor.ui.MultiAnchorTeamPkRandomView;
import com.bytedance.android.live.revlink.impl.multianchor.utils.q;
import com.bytedance.android.live.revlink.impl.multianchor.utils.v;
import com.bytedance.android.live.revlink.impl.pk.randompkcheck.RandomCheckDataContext;
import com.bytedance.android.live.revlink.impl.pk.ui.PkItemExposeRecyclerView;
import com.bytedance.android.live.ui.PkInviteUserListRefreshLayout;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.link.model.b0;
import com.bytedance.android.livesdk.link.model.m2;
import com.bytedance.android.livesdk.link.model.o2;
import com.bytedance.android.livesdk.link.model.w3;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.kmp.core.KmpEnv;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import me.drakeet.multitype.MultiTypeAdapter;
import y31.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/dialog/pk/MultiAnchorTeamPkUserInviteDialog;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "Lx31/m;", "<init>", "()V", "a", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MultiAnchorTeamPkUserInviteDialog extends LiveDialogFragment implements x31.m {
    public static final /* synthetic */ int u = 0;
    public Map<Integer, View> d;
    public DataCenter e;
    public Boolean f;
    public View g;
    public View h;
    public boolean i;
    public final Lazy j;
    public final CompositeDisposable k;
    public int l;
    public MultiTypeAdapter m;
    public final IRoom n;
    public final Handler o;
    public final com.bytedance.android.live.revlink.impl.multianchor.match.c p;
    public boolean q;
    public boolean r;
    public final com.bytedance.android.live.revlink.impl.pk.utils.k s;
    public final com.bytedance.android.live.revlink.impl.pk.utils.l.k t;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ MultiAnchorTeamPkUserInviteDialog a;

        public b(MultiAnchorTeamPkUserInviteDialog r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            com.bytedance.android.live.revlink.impl.multianchor.match.c r4 = (com.bytedance.android.live.revlink.impl.multianchor.match.c) r3;
            r4.getClass();
            if ((r4 instanceof com.bytedance.android.live.revlink.impl.multianchor.match.c.C0146c) == false) goto L6;
            this.a.q = true;
        L6:
            if (r4.a == true) goto L15;
            return;
        L15:
            this.a.dismiss();     // Catch: Exception -> L10
            return;
        L10:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r5 = DialogFragmentLancet.sLastShowStack;
            if (r5 == null) goto L18;
            com.bytedance.crash.d.d(r5, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ MultiAnchorTeamPkUserInviteDialog a;

        public c(MultiAnchorTeamPkUserInviteDialog r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            com.bytedance.android.live.revlink.impl.multianchor.match.d r3 = (com.bytedance.android.live.revlink.impl.multianchor.match.d) r2;
            this.a.dismiss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r4 = DialogFragmentLancet.sLastShowStack;
            if (r4 == null) goto L12;
            com.bytedance.crash.d.d(r4, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public static final class d<T> implements Consumer {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final void accept(Object r9) {
            final String r10 = (String) r9;
            Intrinsics.checkNotNullParameter(r10, "source");
            if (r10.length() <= 0) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == false) goto L17;
            MultiPkMatchContext r1 = com.bytedance.android.live.revlink.impl.global.b.G();
            if (r1 == null) goto L18;
            com.bytedance.live.datacontext.n<b0> r2 = r1.getSelfAutoMatchInfo();
            if (r2 == null) goto L19;
            b0 r3 = (b0) r2.getValue();
            if (r3 == null) goto L20;
            com.bytedance.android.live.revlink.impl.multianchor.match.a r4 = com.bytedance.android.live.revlink.impl.global.b.I();
            if (r4 == null) goto L21;
            com.bytedance.android.live.revlink.impl.multianchor.match.a.C0145a.a(r4, r3, 6, false, 0, new MultiAnchorTeamPkUserInviteDialog$onCreate$2$$special$$inlined$let$lambda$1(r10), 28);
            return;
        L21:
            return;
        L20:
            return;
        L19:
            return;
        L18:
            return;
        L17:
            return;
        L5:
            r0 = false;
            goto L6
        }
    }

    static {
    }

    public final MultiAnchorPkInviteViewModel T90() {
        return (MultiAnchorPkInviteViewModel) this.j.getValue();
    }

    @Override // x31.m
    public final void UC(String r1, int r2) {
    }

    public final String getDegradeTag() {
        return "anchor_link_invite_panel";
    }

    public MultiAnchorTeamPkUserInviteDialog() {
        this.d = new LinkedHashMap();
        this.j = LazyKt.lazy(new MultiAnchorTeamPkUserInviteDialog$multiViewModel$2(this));
        this.k = new CompositeDisposable();
        yz0.k r0 = (yz0.k) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        if (r0 == null) goto L5;
        IRoom r1 = r0.getRoom();
    L6:
        this.n = r1;
        this.o = new Handler();
        com.bytedance.android.live.revlink.impl.multianchor.match.c r2 = com.bytedance.android.live.revlink.impl.multianchor.match.m.a();
        this.p = r2;
        this.q = r2 instanceof com.bytedance.android.live.revlink.impl.multianchor.match.c.C0146c;
        this.s = new com.bytedance.android.live.revlink.impl.pk.utils.k(com.bytedance.android.live.revlink.impl.global.b.k(), "team");
        this.t = com.bytedance.android.live.revlink.impl.pk.utils.l.k.c;
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        this.o.removeCallbacksAndMessages(null);
        this.s.c();
        this.s.b();
    }

    public final void onDestroyView() {
        super.onDestroyView();
        this.k.dispose();
        com.bytedance.android.live.revlink.impl.multianchor.match.c r0 = this.p;
        com.bytedance.android.live.revlink.impl.multianchor.match.c r1 = com.bytedance.android.live.revlink.impl.multianchor.match.m.a();
        boolean r3 = true;
        if (this.q == true) goto L5;
    L7:
        boolean r2 = false;
    L9:
        if (r0.a == true) goto L11;
    L15:
        r3 = false;
    L16:
        if (r2 == true) goto L18;
        if (r3 == true) goto L18;
    L21:
        int r4 = com.bytedance.android.live.revlink.impl.pk.utils.e.a;
        IPerformanceManager r5 = jc1.k.f(IPerformanceManager.class);
        if (r5 == null) goto L24;
        r5.onModuleStop("revlink_invite_panel");
    L24:
        ((LinkedHashMap) this.d).clear();
        return;
    L18:
        com.bytedance.android.live.revlink.impl.multianchor.match.a r6 = com.bytedance.android.live.revlink.impl.global.b.I();
        if (r6 == null) goto L21;
        r6.y8(null);
        goto L21
    L11:
        if (r0.c == true) goto L15;
        if (r1.c == false) goto L15;
    L5:
        if (r1.a == false) goto L7;
        r2 = true;
        goto L9
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

    public final void onActivityCreated(Bundle r5) {
        super.onActivityCreated(r5);
        Dialog r6 = getDialog();
        if (r6 == null) goto L5;
        Window r7 = r6.getWindow();
    L6:
        if (r7 == null) goto L14;
        View r0 = r7.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L12;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r1 = ThreadMethodProxy.currentThread();
        if (r1 == com.larus.home.impl.utils.c.a) goto L12;
        com.larus.home.impl.utils.c.a(r1, "getDecorView");
    L12:
        r0.setPadding(0, 0, 0, 0);
        r7.setLayout(-1, -1);
        r7.setGravity(80);
        r7.setBackgroundDrawable(new ColorDrawable(0));
        r7.setSoftInputMode(48);
        return;
    L14:
        return;
    L5:
        r7 = null;
        goto L6
    }

    public final void onCreate(Bundle r4) {
        super.onCreate(r4);
        setStyle(1, 2131954578);
        Pair r5 = com.bytedance.live.datacontext.d.a(AnonymousClass1.INSTANCE);
        RandomCheckDataContext r0 = (RandomCheckDataContext) r5.component1();
        Disposable r6 = (Disposable) r5.component2();
        r0.getRandomChecked().setValue(Boolean.valueOf(l51.a.d()));
        com.bytedance.live.datacontext.b.a(r0, RandomCheckDataContext.TAG);
        this.k.add(r6);
        this.k.add(r0.getStartRandomMatch().onEvent().subscribe(d.a));
        MultiPkMatchContext r7 = com.bytedance.android.live.revlink.impl.global.b.G();
        if (r7 == null) goto L10;
        Disposable r1 = r7.getMatchStatus().a().subscribe(new b(this));
        if (r1 == null) goto L7;
        this.k.add(r1);
    L7:
        Disposable r8 = r7.getMatchSuccessEvent().onEvent().subscribe(new c(this));
        if (r8 == null) goto L10;
        this.k.add(r8);
    L10:
        this.s.e();
    }

    public final void setUserVisibleHint(boolean r3) {
        super/*androidx.fragment.app.Fragment*/.setUserVisibleHint(r3);
        if (S90(2131384076) == null) goto L6;
        ((PkItemExposeRecyclerView) S90(2131384076)).setNestedScrollingEnabled(r3);
        ((PkItemExposeRecyclerView) S90(2131384076)).requestLayout();
        return;
    }

    @Override // x31.m
    public final void l30(IRoom r25, m2 r26) {
        h41.f r1 = com.bytedance.android.live.revlink.impl.global.b.V();
        if (r1 == null) goto L6;
        r1.e(T90().getNpkInvitePageSource());
    L6:
        if (r25 == null) goto L10;
        IBaseUser r2 = r25.getOwner();
        if (r2 == null) goto L10;
        Intrinsics.checkNotNullParameter(r2, "$this$secUidExt");
        String r10 = r2.getCastSecUid();
    L11:
        List r3 = r26.getParticipantRooms();
        String r14 = "";
        if (r3 == null) goto L26;
        ArrayList r15 = new ArrayList();
        Iterator r4 = r3.iterator();
    L15:
        if (r4.hasNext() == false) goto L22;
        IBaseUser r5 = ((IRoom) r4.next()).getOwner();
        if (r5 == null) goto L19;
        String r6 = iz.a.a(r5);
    L20:
        if (r6 == null) goto L15;
        r15.add(r6);
        goto L15
    L19:
        r6 = null;
        goto L20
    L22:
        String r7 = CollectionsKt.joinToString$default(r15, null, null, null, 0, null, null, 63, null);
        if (r7 == null) goto L26;
        String r13 = r7;
    L27:
        if (r25 != null) goto L29;
        return;
    L29:
        if (T90().getCurrentScene() != 1) goto L44;
        com.bytedance.android.live.revlink.impl.pk.service.b r8 = com.bytedance.android.live.revlink.impl.global.b.N();
        if (r8 == null) goto L54;
        com.bytedance.android.live.revenuelink.connect.n r9 = r8.getLinkOutManagerFn();
        if (r9 == null) goto L54;
        LinkCrossRoomDataHolder r12 = com.bytedance.android.live.revlink.impl.global.b.j();
        if (r12 == null) goto L37;
        long r16 = r12.c();
    L38:
        long r17 = r25.getId();
        IBaseUser r18 = r25.getOwner();
        if (r18 == null) goto L41;
        String r19 = iz.a.a(r18);
    L42:
        r9.e(new d11.c(1, r16, r17, r19, r10, 0, "click_item_cancel", r13), null);
        goto L54
    L41:
        r19 = null;
        goto L42
    L37:
        r16 = 0;
    L54:
        q r20 = com.bytedance.android.live.revlink.impl.global.b.v();
        if (r20 == null) goto L70;
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.e r22 = com.bytedance.android.live.revlink.impl.global.b.l();
        if (r22 == null) goto L62;
        String r23 = r22.a;
        if (r23 == null) goto L62;
        r14 = r23;
    L62:
        q.u(r20, r25, r26, r14);
        return;
    L70:
        return;
    L44:
        if (T90().getCurrentScene() != 7) goto L54;
        com.bytedance.android.live.revlink.impl.multianchor.service.a r24 = com.bytedance.android.live.revlink.impl.global.b.t();
        if (r24 == null) goto L54;
        com.bytedance.android.live.revenuelink.connect.n r27 = r24.getLinkOutManagerFn();
        if (r27 == null) goto L54;
        LinkCrossRoomDataHolder r28 = com.bytedance.android.live.revlink.impl.global.b.j();
        if (r28 == null) goto L52;
        long r29 = r28.c();
    L53:
        r27.e(new d11.c(7, r29, r25.getId(), iz.a.a(r25.getOwner()), r10, 0, "click_item_cancel", r13), null);
        goto L54
    L52:
        r29 = 0;
    L26:
        r13 = "";
    L10:
        r10 = null;
        goto L11
    }

    public final void onViewCreated(View r9, Bundle r10) {
        Intrinsics.checkNotNullParameter(r9, "view");
        super.onViewCreated(r9, r10);
        PkItemExposeRecyclerView r12 = (PkItemExposeRecyclerView) S90(2131384076);
        if (r12 == null) goto L5;
        r12.setInviteIconPanelType("team");
    L5:
        S90(2131385286).setOnClickListener(new g(this));
        S90(2131392080).setRecyclerView(S90(2131384076));
        S90(2131392080).setFirstView(S90(2131363087));
        KmpEnv r1 = KmpEnv.a;
        TextView r2 = null;
        if (KmpEnv.a() == false) goto L16;
        View r3 = getView();
        if (r3 == null) goto L10;
        View r4 = r3.findViewById(2131392078);
    L11:
        this.g = r4;
        View r5 = getView();
        if (r5 == null) goto L14;
        View r6 = r5.findViewById(2131382879);
    L15:
        this.h = r6;
    L25:
        View r7 = this.g;
        if (r7 == null) goto L28;
        r7.setVisibility(4);
    L28:
        View r8 = this.h;
        if (r8 == null) goto L31;
        r8.setVisibility(0);
    L31:
        Toolbar r13 = S90(2131385286);
        if (r13 == null) goto L34;
        r13.setVisibility(8);
    L34:
        ConstraintLayout r14 = (MultiAnchorTeamPkRandomView) S90(2131362584);
        if (r14 == null) goto L37;
        r14.setVisibility(8);
    L37:
        View r15 = getView();
        if (r15 == null) goto L40;
        r2 = (TextView) r15.findViewById(2131392041);
    L40:
        if (r2 != null) goto L42;
    L46:
        this.f = Boolean.TRUE;
        PkInviteUserListRefreshLayout r16 = S90(2131392080);
        if (r16 == null) goto L49;
        r16.setOnRefreshListener(new h(this));
    L49:
        PkItemExposeRecyclerView r17 = (PkItemExposeRecyclerView) S90(2131384076);
        if (r17 == null) goto L52;
        r17.setLayoutManager(new LinearLayoutManager(getContext()));
    L52:
        MultiTypeAdapter r18 = new MultiTypeAdapter();
        this.m = r18;
        DataCenter r19 = this.e;
        if (r19 == null) goto L57;
        r18.z2(y31.k.class, new q21.i(new com.bytedance.android.live.revlink.impl.pk.utils.m(), this, r19));
        MultiTypeAdapter r110 = this.m;
        if (r110 == null) goto L57;
        r110.z2(s.a.class, new s(true));
    L57:
        PkInviteUserListRefreshLayout r111 = S90(2131392080);
        if (r111 == null) goto L60;
        r111.setmIsDisable(false);
    L60:
        PkItemExposeRecyclerView r112 = (PkItemExposeRecyclerView) S90(2131384076);
        if (r112 == null) goto L63;
        r112.setAdapter(this.m);
    L63:
        PkItemExposeRecyclerView r20 = (PkItemExposeRecyclerView) S90(2131384076);
        if (r20 == null) goto L66;
        r20.addOnScrollListener(new MultiAnchorTeamPkUserInviteDialog$initViews$4(this));
    L66:
        ((ImageView) S90(2131363762)).setOnClickListener(new i(this));
        S90(2131381758).setOnClickListener(j.a);
        T90().setTeamPkInvitePanel(true);
        T90().getFinishState().observe(this, new k(this));
        T90().getListDataModel().observe(this, new m(this));
        T90().getTopBar().observe(this, new n(this));
        T90().getSearchBar().observe(this, new com.bytedance.android.live.revlink.impl.multianchor.dialog.pk.d(this));
        T90().getRandomMatchDataModel().observe(this, new e(this));
        Disposable r22 = T90().getOnDataFirstLoadEvent().subscribe(f.a);
        if (r22 == null) goto L69;
        this.k.add(r22);
    L69:
        T90().requestUpdatePage(4);
        return;
    L42:
        if (this.l != 3) goto L44;
        int r113 = 2131919452;
    L45:
        r2.setText(getText(r113));
        goto L46
    L44:
        r113 = 2131919451;
        goto L45
    L14:
        r6 = null;
        goto L15
    L10:
        r4 = null;
        goto L11
    L16:
        View r23 = getView();
        if (r23 == null) goto L19;
        View r24 = r23.findViewById(2131392079);
    L20:
        this.g = r24;
        View r25 = getView();
        if (r25 == null) goto L23;
        View r26 = r25.findViewById(2131382880);
    L24:
        this.h = r26;
        goto L25
    L23:
        r26 = null;
        goto L24
    L19:
        r24 = null;
        goto L20
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131566035, r3, false);
    }

    @Override // x31.m
    public final void zC(IRoom r54, int r55, m2 r56, int r57, Boolean r58, int r59, String r60) {
        boolean r35 = r58.booleanValue();
        if (r55 != 101) goto L7;
        h41.f r1 = com.bytedance.android.live.revlink.impl.global.b.V();
        if (r1 == null) goto L11;
        r1.f("followed", T90().getNpkInvitePageSource());
    L11:
        if (com.bytedance.android.live.revlink.impl.multianchor.match.b.a(com.bytedance.android.live.revlink.impl.global.b.I()) == false) goto L16;
        jy0.b.d("ttlive_anchor_link", "multiPkPanel intercept invite when random matching");
        ToastUtil.a(2131920598, 0);
        k21.a r2 = com.bytedance.android.live.revlink.impl.global.b.E();
        if (r2 == null) goto L146;
        r2.m();
        return;
    L146:
        return;
    L16:
        if (o2.a(r56) != true) goto L18;
        int r14 = 5;
    L19:
        int r13 = r56.getRoomScene();
        List r3 = r56.getParticipantRooms();
        if (r3 == null) goto L28;
        ArrayList r5 = new ArrayList();
        Iterator r4 = r3.iterator();
    L23:
        if (r4.hasNext() == false) goto L27;
        String r6 = iz.a.a(((IRoom) r4.next()).getOwner());
        if (r6 == null) goto L23;
        r5.add(r6);
        goto L23
    L27:
        ArrayList r12 = r5;
    L30:
        if (o2.a(r56) != true) goto L32;
        int r10 = 2;
    L33:
        ALogger.w("ttlive_anchor_link", "multiTeamPkPanel inviteeScene=" + r13 + " inviteeUserIds=" + r12 + " inviteSource=" + r10 + " currentScene=" + T90().getCurrentScene());
        if (r41.f.a == false) goto L39;
        com.bytedance.tools.kcp.spongepreference.runtime.a r7 = l51.a.j0;
        KProperty[] r8 = l51.a.a;
        if (((Boolean) r7.getValue(null, r8[71])).booleanValue() == true) goto L39;
        ToastUtil.a(2131914801, 0);
        r7.setValue(null, r8[71], Boolean.TRUE);
    L39:
        if (T90().getCurrentScene() != 1) goto L76;
        IRoom r9 = this.n;
        if (r9 == null) goto L75;
        if (r54 == null) goto L75;
        com.bytedance.android.live.revlink.impl.pk.service.b r15 = com.bytedance.android.live.revlink.impl.global.b.N();
        if (r15 == null) goto L75;
        com.bytedance.android.live.revenuelink.connect.n r16 = r15.getLinkOutManagerFn();
        if (r16 == null) goto L75;
        long r17 = r9.getId();
        long r18 = r54.getId();
        IBaseUser r19 = r54.getOwner();
        if (r19 == null) goto L50;
        String r110 = iz.a.a(r19);
    L51:
        IBaseUser r20 = r54.getOwner();
        if (r20 == null) goto L54;
        Intrinsics.checkNotNullParameter(r20, "$this$secUidExt");
        String r111 = r20.getCastSecUid();
    L55:
        int r22 = BizType.PK.ordinal();
        w31.c r23 = com.bytedance.android.live.revlink.impl.global.b.T();
        if (r23 == null) goto L58;
        int r30 = r23.d();
    L59:
        e21.b r42 = com.bytedance.android.live.revlink.impl.global.b.h();
        if (r42 == null) goto L73;
        com.bytedance.android.live.revlink.impl.pk.utils.l.k r24 = this.t;
        String r44 = String.valueOf(r59 + 1);
        d31.d r25 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r25 == null) goto L67;
        String r26 = r25.a();
        if (r26 == null) goto L67;
        String r47 = r26;
    L68:
        d31.d r27 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r27 == null) goto L71;
        String r46 = r27.s();
    L72:
        String r43 = w3.a(e21.b.b(r42, r24, "team_pk", r44, null, r46, r47, 24));
    L74:
        int r510 = r10;
        int r62 = r14;
        String r112 = null;
        r16.d(new d11.d(7, r17, r18, r55, r14, r110, r111, r54, r22, "", 0, "", 0, r510, 1, r13, r12, null, "team_pk_invite", null, r30, 0, 0, null, r43, null, null, null, 518651904), null);
    L111:
        String r28 = r112;
    L112:
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.e r29 = com.bytedance.android.live.revlink.impl.global.b.l();
        if (r29 == null) goto L115;
        r29.b(r28);
    L115:
        if (r54 == null) goto L126;
        q r32 = com.bytedance.android.live.revlink.impl.global.b.v();
        if (r32 == null) goto L126;
        long r33 = this.s.a();
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.e r34 = com.bytedance.android.live.revlink.impl.global.b.l();
        if (r34 == null) goto L124;
        String r36 = r34.a;
        if (r36 == null) goto L124;
        String r37 = r36;
    L125:
        r32.y(r54, r56, r55, r59, r33, r37, r35);
    L124:
        r37 = "";
    L126:
        d31.f r38 = com.bytedance.android.live.revlink.impl.global.b.e0();
        if (r38 == null) goto L129;
        StringBuilder r39 = new StringBuilder("match_type=");
        int r40 = r62;
        r39.append(r40);
        r39.append(",inviteSource=");
        int r45 = r510;
        r39.append(r45);
        d31.f.h(r38, "team_pk_invite", r39.toString());
    L130:
        v r48 = com.bytedance.android.live.revlink.impl.global.b.C();
        if (r48 != null) goto L133;
    L137:
        d31.e r49 = com.bytedance.android.live.revlink.impl.global.b.d0();
        if (r49 == null) goto L148;
        r49.b(r57);
        return;
    L148:
        return;
    L133:
        if (r54 == null) goto L135;
        long r50 = r54.getId();
    L136:
        r48.v("team_pk_invite", r40, r45, r55, r50);
        goto L137
    L135:
        r50 = 0;
        goto L136
    L129:
        r45 = r510;
        r40 = r62;
        goto L130
    L71:
        r46 = "";
    L67:
        r47 = "";
        goto L68
    L73:
        r43 = "";
        goto L74
    L58:
        r30 = 0;
        goto L59
    L54:
        r111 = null;
        goto L55
    L50:
        r110 = null;
    L75:
        r510 = r10;
        r112 = null;
        r62 = r14;
        goto L111
    L76:
        r510 = r10;
        ArrayList r410 = r12;
        r112 = null;
        r62 = r14;
        IRoom r52 = this.n;
        if (r52 == null) goto L111;
        if (r54 == null) goto L111;
        com.bytedance.android.live.revlink.impl.multianchor.service.a r53 = com.bytedance.android.live.revlink.impl.global.b.t();
        if (r53 == null) goto L111;
        com.bytedance.android.live.revenuelink.connect.n r113 = r53.getLinkOutManagerFn();
        if (r113 == null) goto L111;
        long r63 = r52.getId();
        long r64 = r54.getId();
        IBaseUser r65 = r54.getOwner();
        if (r65 == null) goto L86;
        String r114 = iz.a.a(r65);
    L87:
        IBaseUser r66 = r54.getOwner();
        if (r66 == null) goto L90;
        Intrinsics.checkNotNullParameter(r66, "$this$secUidExt");
        String r115 = r66.getCastSecUid();
    L91:
        int r116 = BizType.AnchorLink.ordinal();
        w31.c r67 = com.bytedance.android.live.revlink.impl.global.b.T();
        if (r67 == null) goto L94;
        int r210 = r67.d();
    L95:
        e21.b r411 = com.bytedance.android.live.revlink.impl.global.b.h();
        if (r411 == null) goto L109;
        com.bytedance.android.live.revlink.impl.pk.utils.l.k r68 = this.t;
        String r412 = String.valueOf(r59 + 1);
        d31.d r69 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r69 == null) goto L103;
        String r70 = r69.a();
        if (r70 == null) goto L103;
        String r413 = r70;
    L104:
        d31.d r72 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r72 == null) goto L107;
        String r414 = r72.s();
    L108:
        String r310 = w3.a(e21.b.b(r411, r68, "team_pk", r412, null, r414, r413, 24));
    L110:
        r28 = null;
        r113.d(new d11.d(7, r63, r64, r55, r62, r114, r115, r54, r116, "", 0, "", 0, r510, 1, r13, r410, null, "team_pk_invite", null, r210, 0, 0, null, r310, null, null, null, 518651904), null);
        goto L112
    L107:
        r414 = "";
    L103:
        r413 = "";
        goto L104
    L109:
        r310 = "";
        goto L110
    L94:
        r210 = 0;
        goto L95
    L90:
        r115 = null;
        goto L91
    L86:
        r114 = null;
        goto L87
    L32:
        r10 = 1;
        goto L33
    L28:
        r12 = null;
        goto L30
    L18:
        r14 = 0;
        goto L19
    L7:
        h41.f r73 = com.bytedance.android.live.revlink.impl.global.b.V();
        if (r73 == null) goto L11;
        r73.f("recommend", T90().getNpkInvitePageSource());
        goto L11
    }
}
