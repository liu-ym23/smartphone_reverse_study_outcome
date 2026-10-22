package com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.model.BizType;
import com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.vm.MultiAnchorPkInviteViewModel;
import com.bytedance.android.live.revlink.impl.multianchor.match.MultiPkMatchContext;
import com.bytedance.android.live.revlink.impl.multianchor.pk.pklaunch.MultiAnchorPkLaunchContext;
import com.bytedance.android.live.revlink.impl.multianchor.ui.MultiAnchorRandomView;
import com.bytedance.android.live.revlink.impl.multianchor.vm.LinkingInvitePreloadUtils;
import com.bytedance.android.live.revlink.impl.pk.randompkcheck.RandomCheckDataContext;
import com.bytedance.android.live.revlink.impl.pk.ui.LinkCommonDialogFragment;
import com.bytedance.android.live.revlink.impl.pk.ui.PkItemExposeRecyclerView;
import com.bytedance.android.live.ui.PkInviteUserListRefreshLayout;
import com.bytedance.android.livesdk.link.model.m2;
import com.bytedance.android.livesdk.link.model.o2;
import com.bytedance.android.livesdk.link.model.w3;
import com.bytedance.android.livesdk.utils.t6;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.kmp.core.KmpEnv;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.HashSet;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/dialog/linkopt/MultiAnchorLinkUserInviteDialog;", "Lcom/bytedance/android/live/revlink/impl/pk/ui/LinkCommonDialogFragment;", "Lx31/m;", "Lcom/bytedance/android/live/revlink/impl/multianchor/ui/MultiAnchorRandomView$a;", "<init>", "()V", "a", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MultiAnchorLinkUserInviteDialog extends LinkCommonDialogFragment implements x31.m, MultiAnchorRandomView.a {
    public static final /* synthetic */ int w = 0;
    public Map<Integer, View> e;
    public DataCenter f;
    public Boolean g;
    public View h;
    public View i;
    public boolean j;
    public final Lazy k;
    public final CompositeDisposable l;
    public int m;
    public MultiTypeAdapter n;
    public final IRoom o;
    public final Handler p;
    public long q;
    public boolean r;
    public final com.bytedance.android.live.revlink.impl.multianchor.match.c s;
    public boolean t;
    public final com.bytedance.android.live.revlink.impl.pk.utils.k u;
    public boolean v;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ MultiPkMatchContext a;
        public final /* synthetic */ MultiAnchorLinkUserInviteDialog b;

        public b(MultiPkMatchContext r1, MultiAnchorLinkUserInviteDialog r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r3) {
            com.bytedance.android.live.revlink.impl.multianchor.match.c r4 = (com.bytedance.android.live.revlink.impl.multianchor.match.c) r3;
            r4.getClass();
            boolean r1 = true;
            if ((r4 instanceof com.bytedance.android.live.revlink.impl.multianchor.match.c.C0146c) == false) goto L6;
            this.b.t = true;
        L6:
            if (this.a.isLastStatusMatching() == false) goto L8;
            return;
        L8:
            if (r4.a == true) goto L10;
        L12:
            r1 = false;
        L13:
            if (r1 == true) goto L15;
            return;
        L15:
            if (r4.c == false) goto L17;
            return;
        L17:
            if (com.bytedance.android.live.revlink.impl.global.b.H() == null) goto L23;
            com.bytedance.android.live.revlink.impl.multianchor.match.f.k();
            return;
        L23:
            return;
        L10:
            if (r4.d == true) goto L12;
            goto L12
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ MultiAnchorLinkUserInviteDialog a;

        public c(MultiAnchorLinkUserInviteDialog r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            com.bytedance.android.live.revlink.impl.multianchor.match.d r2 = (com.bytedance.android.live.revlink.impl.multianchor.match.d) r1;
            MultiAnchorLinkUserInviteDialog.T90(this.a);
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
            com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.link.model.b0> r2 = r1.getSelfAutoMatchInfo();
            if (r2 == null) goto L19;
            com.bytedance.android.livesdk.link.model.b0 r3 = (com.bytedance.android.livesdk.link.model.b0) r2.getValue();
            if (r3 == null) goto L20;
            com.bytedance.android.live.revlink.impl.multianchor.match.a r4 = com.bytedance.android.live.revlink.impl.global.b.I();
            if (r4 == null) goto L21;
            com.bytedance.android.live.revlink.impl.multianchor.match.a.C0145a.a(r4, r3, 0, false, 0, new MultiAnchorLinkUserInviteDialog$onCreate$2$$special$$inlined$let$lambda$1(r10), 30);
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

    public static final class e<T> implements Consumer {
        public final /* synthetic */ MultiPkMatchContext a;

        public e(MultiPkMatchContext r1) {
            this.a = r1;
        }

        public final void accept(Object r7) {
            Long r8 = (Long) r7;
            if (r8 != null) goto L6;
            return;
        L6:
            if (r8.longValue() != 1) goto L9;
            UtilityKotlinExtentionsKt.s(1000, false, false, new MultiAnchorLinkUserInviteDialog$onCreate$3$3$1(this), 6);
            return;
        }
    }

    static {
    }

    public final MultiAnchorPkInviteViewModel U90() {
        return (MultiAnchorPkInviteViewModel) this.k.getValue();
    }

    public final String getDegradeTag() {
        return "anchor_link_invite_panel";
    }

    public MultiAnchorLinkUserInviteDialog() {
        this.e = new LinkedHashMap();
        this.k = LazyKt.lazy(new MultiAnchorLinkUserInviteDialog$multiViewModel$2(this));
        this.l = new CompositeDisposable();
        yz0.k r0 = (yz0.k) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        if (r0 == null) goto L5;
        IRoom r1 = r0.getRoom();
    L6:
        this.o = r1;
        this.p = new Handler();
        this.r = true;
        com.bytedance.android.live.revlink.impl.multianchor.match.c r2 = com.bytedance.android.live.revlink.impl.multianchor.match.m.a();
        this.s = r2;
        this.t = r2 instanceof com.bytedance.android.live.revlink.impl.multianchor.match.c.C0146c;
        this.u = new com.bytedance.android.live.revlink.impl.pk.utils.k(com.bytedance.android.live.revlink.impl.global.b.k(), "find");
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.ui.MultiAnchorRandomView.a
    public final com.bytedance.android.live.revlink.impl.pk.utils.i NS() {
        return U90().getListExtraInfo();
    }

    public final void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        this.u.c();
        this.u.b();
        this.p.removeCallbacksAndMessages(null);
    }

    public final void onDestroyView() {
        super.onDestroyView();
        this.l.dispose();
        com.bytedance.android.live.revlink.impl.multianchor.match.c r0 = this.s;
        com.bytedance.android.live.revlink.impl.multianchor.match.c r1 = com.bytedance.android.live.revlink.impl.multianchor.match.m.a();
        boolean r3 = true;
        if (this.t == true) goto L5;
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
        ((LinkedHashMap) this.e).clear();
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

    public static final void T90(MultiAnchorLinkUserInviteDialog r1) {
        r1.getClass();
        r1.dismiss();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L12;
        com.bytedance.crash.d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public final View S90(int r3) {
        if (this.e != null) goto L5;
        this.e = new LinkedHashMap();
    L5:
        View r0 = this.e.get(Integer.valueOf(r3));
        if (r0 != null) goto L14;
        View r1 = getView();
        if (r1 == null) goto L12;
        View r2 = r1.findViewById(r3);
        if (r2 == null) goto L12;
        this.e.put(Integer.valueOf(r3), r2);
        return r2;
    L12:
        return null;
    L14:
        return r0;
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.ui.LinkCommonDialogFragment
    public final void onCreate(Bundle r4) {
        super.onCreate(r4);
        Pair r5 = com.bytedance.live.datacontext.d.a(AnonymousClass1.INSTANCE);
        RandomCheckDataContext r0 = (RandomCheckDataContext) r5.component1();
        Disposable r6 = (Disposable) r5.component2();
        r0.getRandomChecked().setValue(Boolean.valueOf(l51.a.d()));
        com.bytedance.live.datacontext.b.a(r0, RandomCheckDataContext.TAG);
        this.l.add(r6);
        this.l.add(r0.getStartRandomMatch().onEvent().subscribe(d.a));
        MultiPkMatchContext r7 = com.bytedance.android.live.revlink.impl.global.b.G();
        if (r7 == null) goto L10;
        Disposable r1 = r7.getMatchStatus().a().subscribe(new b(r7, this));
        if (r1 == null) goto L7;
        this.l.add(r1);
    L7:
        Disposable r2 = r7.getCountDownTime().a().subscribe(new e(r7));
        this.l.add(r2);
        Disposable r8 = r7.getMatchSuccessEvent().onEvent().subscribe(new c(this));
        if (r8 == null) goto L10;
        this.l.add(r8);
    L10:
        this.q = System.currentTimeMillis();
        this.u.e();
    }

    public final void setUserVisibleHint(boolean r3) {
        super/*androidx.fragment.app.Fragment*/.setUserVisibleHint(r3);
        if (S90(2131384076) == null) goto L6;
        ((PkItemExposeRecyclerView) S90(2131384076)).setNestedScrollingEnabled(r3);
        ((PkItemExposeRecyclerView) S90(2131384076)).requestLayout();
        return;
    }

    @Override // x31.m
    public final void UC(String r2, int r3) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (r3 == 1) goto L19;
        com.bytedance.android.live.revlink.impl.multianchor.vm.f r4 = com.bytedance.android.live.revlink.impl.global.b.p();
        if (r4 == null) goto L20;
        com.bytedance.android.live.revlink.impl.global.c r5 = r4.a;
        LinkingInvitePreloadUtils r0 = null;
        if (r5 == null) goto L10;
        MultiAnchorPkLaunchContext r6 = r5.Ib();
    L11:
        if (r6 == null) goto L15;
        com.bytedance.live.datacontext.j<LinkingInvitePreloadUtils> r7 = r6.getLinkingInvitePreloadUtils();
        if (r7 == null) goto L15;
        r0 = (LinkingInvitePreloadUtils) r7.getValue();
    L15:
        if (r0 == null) goto L21;
        Intrinsics.checkNotNullParameter(r2, "roomId");
        ((HashSet) r0.j.getValue()).add(r2);
        return;
    L21:
        return;
    L10:
        r6 = null;
        goto L11
    L20:
        return;
    }

    @Override // x31.m
    public final void l30(IRoom r22, m2 r23) {
        h41.f r1 = com.bytedance.android.live.revlink.impl.global.b.V();
        if (r1 == null) goto L6;
        r1.e(U90().getNpkInvitePageSource());
    L6:
        if (r22 == null) goto L10;
        IBaseUser r3 = r22.getOwner();
        if (r3 == null) goto L10;
        Intrinsics.checkNotNullParameter(r3, "$this$secUidExt");
        String r4 = r3.getCastSecUid();
    L11:
        if (r4 != null) goto L17;
        if (r22 == null) goto L16;
        IBaseUser r5 = r22.getOwner();
        if (r5 == null) goto L16;
        Intrinsics.checkNotNullParameter(r5, "$this$secUidExt");
        r4 = r5.getCastSecUid();
    L16:
        String r12 = null;
    L18:
        List r2 = r23.getParticipantRooms();
        String r6 = "";
        if (r2 == null) goto L28;
        List r7 = r2;
        ArrayList r13 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
        Iterator r8 = r7.iterator();
    L22:
        if (r8.hasNext() == false) goto L24;
        r13.add(iz.a.a(((IRoom) r8.next()).getOwner()));
        goto L22
    L24:
        String r9 = CollectionsKt.joinToString$default(r13, null, null, null, 0, null, null, 63, null);
        if (r9 == null) goto L28;
        String r14 = r9;
    L29:
        if (r22 != null) goto L31;
        return;
    L31:
        if (U90().getCurrentScene() != 1) goto L46;
        com.bytedance.android.live.revlink.impl.pk.service.b r10 = com.bytedance.android.live.revlink.impl.global.b.N();
        if (r10 == null) goto L60;
        com.bytedance.android.live.revenuelink.connect.n r15 = r10.getLinkOutManagerFn();
        if (r15 == null) goto L60;
        LinkCrossRoomDataHolder r16 = com.bytedance.android.live.revlink.impl.global.b.j();
        if (r16 == null) goto L39;
        long r17 = r16.c();
    L40:
        long r18 = r22.getId();
        IBaseUser r19 = r22.getOwner();
        if (r19 == null) goto L43;
        String r110 = iz.a.a(r19);
    L44:
        r15.e(new d11.c(1, r17, r18, r110, r12, 0, "click_item_cancel", r14), null);
        goto L60
    L43:
        r110 = null;
        goto L44
    L39:
        r17 = 0;
    L60:
        com.bytedance.android.live.revlink.impl.multianchor.utils.q r20 = com.bytedance.android.live.revlink.impl.global.b.v();
        if (r20 == null) goto L72;
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.e r24 = com.bytedance.android.live.revlink.impl.global.b.l();
        if (r24 == null) goto L68;
        String r25 = r24.a;
        if (r25 == null) goto L68;
        r6 = r25;
    L68:
        com.bytedance.android.live.revlink.impl.multianchor.utils.q.u(r20, r22, r23, r6);
        return;
    L72:
        return;
    L46:
        if (U90().getCurrentScene() != 7) goto L60;
        com.bytedance.android.live.revlink.impl.multianchor.service.a r26 = com.bytedance.android.live.revlink.impl.global.b.t();
        if (r26 == null) goto L60;
        com.bytedance.android.live.revenuelink.connect.n r27 = r26.getLinkOutManagerFn();
        if (r27 == null) goto L60;
        LinkCrossRoomDataHolder r28 = com.bytedance.android.live.revlink.impl.global.b.j();
        if (r28 == null) goto L54;
        long r29 = r28.c();
    L55:
        long r111 = r22.getId();
        IBaseUser r30 = r22.getOwner();
        if (r30 == null) goto L58;
        String r112 = iz.a.a(r30);
    L59:
        r27.e(new d11.c(7, r29, r111, r112, r12, 0, "click_item_cancel", r14), null);
        goto L60
    L58:
        r112 = null;
        goto L59
    L54:
        r29 = 0;
    L28:
        r14 = "";
    L17:
        r12 = r4;
    L10:
        r4 = null;
        goto L11
    }

    public final void onViewCreated(View r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r8, "view");
        super.onViewCreated(r8, r9);
        r11.p r10 = b51.b.c0.j();
        if (r10 != null) goto L5;
    L7:
        float r12 = 488.0f;
    L8:
        int r13 = s1.f(r12);
        ViewGroup.LayoutParams r0 = ((LinearLayout) S90(2131367728)).getLayoutParams();
        if (r0.height == r13) goto L11;
        r0.height = r13;
        ((LinearLayout) S90(2131367728)).setLayoutParams(r0);
    L11:
        PkItemExposeRecyclerView r14 = (PkItemExposeRecyclerView) S90(2131384076);
        if (r14 == null) goto L14;
        r14.setInviteIconPanelType("find");
    L14:
        S90(2131385286).setOnClickListener(new n(this));
        S90(2131392080).setRecyclerView(S90(2131384076));
        S90(2131392080).setFirstView(S90(2131363087));
        KmpEnv r1 = KmpEnv.a;
        if (KmpEnv.a() == false) goto L25;
        View r2 = getView();
        if (r2 == null) goto L19;
        View r3 = r2.findViewById(2131392078);
    L20:
        this.h = r3;
        View r4 = getView();
        if (r4 == null) goto L23;
        View r5 = r4.findViewById(2131382879);
    L24:
        this.i = r5;
    L34:
        View r6 = this.h;
        if (r6 == null) goto L37;
        r6.setVisibility(4);
    L37:
        View r7 = this.i;
        if (r7 == null) goto L40;
        r7.setVisibility(0);
    L40:
        Toolbar r15 = S90(2131385286);
        if (r15 == null) goto L43;
        r15.setVisibility(8);
    L43:
        ConstraintLayout r16 = (MultiAnchorRandomView) S90(2131362584);
        if (r16 == null) goto L46;
        r16.setVisibility(8);
    L46:
        View r17 = getView();
        if (r17 == null) goto L49;
        TextView r18 = (TextView) r17.findViewById(2131392041);
    L50:
        if (r18 != null) goto L52;
    L56:
        this.g = Boolean.TRUE;
        ((MultiAnchorRandomView) S90(2131362584)).setLogCallback(this);
        PkInviteUserListRefreshLayout r19 = S90(2131392080);
        if (r19 == null) goto L59;
        r19.setOnRefreshListener(new o(this));
    L59:
        PkItemExposeRecyclerView r20 = (PkItemExposeRecyclerView) S90(2131384076);
        if (r20 == null) goto L62;
        r20.setLayoutManager(new LinearLayoutManager(getContext()));
    L62:
        MultiTypeAdapter r22 = new MultiTypeAdapter();
        this.n = r22;
        DataCenter r23 = this.f;
        if (r23 == null) goto L67;
        r22.z2(y31.k.class, new q21.i(new com.bytedance.android.live.revlink.impl.pk.utils.m(), this, r23));
        MultiTypeAdapter r24 = this.n;
        if (r24 == null) goto L67;
        r24.z2(y31.s.a.class, new y31.s(false));
    L67:
        PkInviteUserListRefreshLayout r25 = S90(2131392080);
        if (r25 == null) goto L70;
        r25.setmIsDisable(false);
    L70:
        PkItemExposeRecyclerView r26 = (PkItemExposeRecyclerView) S90(2131384076);
        if (r26 == null) goto L73;
        r26.setAdapter(this.n);
    L73:
        PkItemExposeRecyclerView r27 = (PkItemExposeRecyclerView) S90(2131384076);
        if (r27 == null) goto L76;
        r27.addOnScrollListener(new MultiAnchorLinkUserInviteDialog$initViews$4(this));
    L76:
        ((ImageView) S90(2131363762)).setOnClickListener(new p(this));
        S90(2131381758).setOnClickListener(new q(this));
        U90().getFinishState().observe(this, new r(this));
        U90().getListDataModel().observe(this, new t(this));
        U90().getTopBar().observe(this, new u(this));
        U90().getSearchBar().observe(this, new j(this));
        U90().getAnchorOverLimit().observe(this, new k(this));
        U90().getRandomMatchDataModel().observe(this, new l(this));
        Disposable r28 = U90().getOnDataFirstLoadEvent().subscribe(m.a);
        if (r28 == null) goto L79;
        this.l.add(r28);
    L79:
        MultiAnchorPkInviteViewModel.requestUpdatePage$default(U90(), null, 1, null);
        MultiPkMatchContext r29 = com.bytedance.android.live.revlink.impl.global.b.G();
        if (r29 == null) goto L88;
        com.bytedance.live.datacontext.m<com.bytedance.android.live.revlink.impl.multianchor.match.c> r30 = r29.getMatchStatus();
        if (r30 == null) goto L88;
        Observable r32 = r30.a();
        if (r32 == null) goto L88;
        Disposable r33 = r32.subscribe(new h(this));
        if (r33 == null) goto L88;
        this.l.add(r33);
    L88:
        MultiPkMatchContext r34 = com.bytedance.android.live.revlink.impl.global.b.G();
        if (r34 == null) goto L98;
        com.bytedance.live.datacontext.m<Long> r35 = r34.getCountDownTime();
        if (r35 == null) goto L99;
        Observable r36 = r35.a();
        if (r36 == null) goto L100;
        Disposable r37 = r36.subscribe(new i(this));
        if (r37 == null) goto L101;
        this.l.add(r37);
        return;
    L101:
        return;
    L100:
        return;
    L99:
        return;
    L98:
        return;
    L52:
        if (this.m != 3) goto L54;
        int r38 = 2131919452;
    L55:
        r18.setText(getText(r38));
        goto L56
    L54:
        r38 = 2131919451;
        goto L55
    L49:
        r18 = null;
        goto L50
    L23:
        r5 = null;
        goto L24
    L19:
        r3 = null;
        goto L20
    L25:
        View r39 = getView();
        if (r39 == null) goto L28;
        View r40 = r39.findViewById(2131392079);
    L29:
        this.h = r40;
        View r42 = getView();
        if (r42 == null) goto L32;
        View r43 = r42.findViewById(2131382880);
    L33:
        this.i = r43;
        goto L34
    L32:
        r43 = null;
        goto L33
    L28:
        r40 = null;
        goto L29
    L5:
        if (r10.getEnable() == false) goto L7;
        r12 = t6.d(s1.getContext(), (t6.b(s1.getContext()) * r11.q.a(r10)) + 26);
        goto L8
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131566034, r3, false);
    }

    @Override // x31.m
    public final void zC(IRoom r55, int r56, m2 r57, int r58, Boolean r59, int r60, String r62) {
        boolean r35 = r59.booleanValue();
        if (r56 != 101) goto L7;
        h41.f r1 = com.bytedance.android.live.revlink.impl.global.b.V();
        if (r1 == null) goto L11;
        r1.f("followed", U90().getNpkInvitePageSource());
    L11:
        if (com.bytedance.android.live.revlink.impl.multianchor.match.b.a(com.bytedance.android.live.revlink.impl.global.b.I()) == false) goto L16;
        jy0.b.d("ttlive_anchor_link", "multiPkPanel intercept invite when random matching");
        ToastUtil.a(2131920598, 0);
        k21.a r2 = com.bytedance.android.live.revlink.impl.global.b.E();
        if (r2 == null) goto L157;
        r2.m();
        return;
    L157:
        return;
    L16:
        if (o2.a(r57) != true) goto L18;
        int r14 = 5;
    L19:
        int r13 = r57.getRoomScene();
        List r3 = r57.getParticipantRooms();
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
        if (o2.a(r57) != true) goto L32;
        int r10 = 2;
    L33:
        ALogger.w("ttlive_anchor_link", "multiPkPanel inviteeScene=" + r13 + " inviteeUserIds=" + r12 + " inviteSource=" + r10 + " currentScene=" + U90().getCurrentScene());
        if (r41.f.a == false) goto L39;
        com.bytedance.tools.kcp.spongepreference.runtime.a r7 = l51.a.j0;
        KProperty[] r8 = l51.a.a;
        if (((Boolean) r7.getValue(null, r8[71])).booleanValue() == true) goto L39;
        ToastUtil.a(2131914801, 0);
        r7.setValue(null, r8[71], Boolean.TRUE);
    L39:
        if (U90().getCurrentScene() != 1) goto L83;
        IRoom r9 = this.o;
        if (r9 == null) goto L82;
        if (r55 == null) goto L82;
        com.bytedance.android.live.revlink.impl.pk.service.b r15 = com.bytedance.android.live.revlink.impl.global.b.N();
        if (r15 == null) goto L82;
        com.bytedance.android.live.revenuelink.connect.n r16 = r15.getLinkOutManagerFn();
        if (r16 == null) goto L82;
        long r17 = r9.getId();
        long r18 = r55.getId();
        IBaseUser r19 = r55.getOwner();
        if (r19 == null) goto L50;
        String r110 = iz.a.a(r19);
    L51:
        IBaseUser r20 = r55.getOwner();
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
        if (r42 != null) goto L62;
        String r24 = null;
    L78:
        if (r24 != null) goto L80;
        String r43 = "";
    L81:
        int r510 = r10;
        int r44 = r14;
        String r112 = null;
        r16.d(new d11.d(7, r17, r18, r56, r14, r110, r111, r55, r22, "", 0, "", 0, r510, 1, r13, r12, null, "linking_invite", null, r30, 0, 0, null, r43, null, null, null, 518651904), null);
    L122:
        String r25 = r112;
    L123:
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.e r26 = com.bytedance.android.live.revlink.impl.global.b.l();
        if (r26 == null) goto L126;
        r26.b(r25);
    L126:
        if (r55 == null) goto L137;
        com.bytedance.android.live.revlink.impl.multianchor.utils.q r27 = com.bytedance.android.live.revlink.impl.global.b.v();
        if (r27 == null) goto L137;
        long r28 = this.u.a();
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.e r29 = com.bytedance.android.live.revlink.impl.global.b.l();
        if (r29 == null) goto L135;
        String r32 = r29.a;
        if (r32 == null) goto L135;
        String r33 = r32;
    L136:
        r27.y(r55, r57, r56, r60, r28, r33, r35);
    L135:
        r33 = "";
    L137:
        d31.f r34 = com.bytedance.android.live.revlink.impl.global.b.e0();
        if (r34 == null) goto L140;
        StringBuilder r36 = new StringBuilder("match_type=");
        int r37 = r44;
        r36.append(r37);
        r36.append(",inviteSource=");
        int r38 = r510;
        r36.append(r38);
        d31.f.h(r34, "linking_invite", r36.toString());
    L141:
        com.bytedance.android.live.revlink.impl.multianchor.utils.v r39 = com.bytedance.android.live.revlink.impl.global.b.C();
        if (r39 != null) goto L144;
    L148:
        d31.e r40 = com.bytedance.android.live.revlink.impl.global.b.d0();
        if (r40 == null) goto L159;
        r40.b(r58);
        return;
    L159:
        return;
    L144:
        if (r55 == null) goto L146;
        long r45 = r55.getId();
    L147:
        r39.v("linking_invite", r37, r38, r56, r45);
        goto L148
    L146:
        r45 = 0;
        goto L147
    L140:
        r38 = r510;
        r37 = r44;
        goto L141
    L80:
        r43 = r24;
        goto L81
    L62:
        if (U90().getCurrentScene() != 1) goto L64;
        com.bytedance.android.live.revlink.impl.pk.utils.l r46 = com.bytedance.android.live.revlink.impl.pk.utils.l.f.c;
    L65:
        com.bytedance.android.live.revlink.impl.pk.utils.l r47 = r46;
        String r48 = String.valueOf(r60 + 1);
        d31.d r49 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r49 == null) goto L71;
        String r50 = r49.a();
        if (r50 == null) goto L71;
        String r410 = r50;
    L72:
        d31.d r52 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r52 == null) goto L75;
        String r411 = r52.s();
    L76:
        r24 = w3.a(e21.b.b(r42, r47, "connection", r62, r48, r411, r410, 16));
        goto L78
    L75:
        r411 = "";
    L71:
        r410 = "";
        goto L72
    L64:
        r46 = com.bytedance.android.live.revlink.impl.pk.utils.l.c.c;
        goto L65
    L58:
        r30 = 0;
        goto L59
    L54:
        r111 = null;
        goto L55
    L50:
        r110 = null;
    L82:
        r510 = r10;
        r112 = null;
        r44 = r14;
        goto L122
    L83:
        r510 = r10;
        ArrayList r412 = r12;
        r112 = null;
        r44 = r14;
        IRoom r53 = this.o;
        if (r53 == null) goto L122;
        if (r55 == null) goto L122;
        com.bytedance.android.live.revlink.impl.multianchor.service.a r54 = com.bytedance.android.live.revlink.impl.global.b.t();
        if (r54 == null) goto L122;
        com.bytedance.android.live.revenuelink.connect.n r113 = r54.getLinkOutManagerFn();
        if (r113 == null) goto L122;
        long r63 = r53.getId();
        long r64 = r55.getId();
        IBaseUser r65 = r55.getOwner();
        if (r65 == null) goto L93;
        String r114 = iz.a.a(r65);
    L94:
        IBaseUser r66 = r55.getOwner();
        if (r66 == null) goto L97;
        Intrinsics.checkNotNullParameter(r66, "$this$secUidExt");
        String r115 = r66.getCastSecUid();
    L98:
        int r116 = BizType.AnchorLink.ordinal();
        w31.c r67 = com.bytedance.android.live.revlink.impl.global.b.T();
        if (r67 == null) goto L101;
        int r210 = r67.d();
    L102:
        e21.b r413 = com.bytedance.android.live.revlink.impl.global.b.h();
        if (r413 != null) goto L105;
        String r310 = "";
    L121:
        r25 = null;
        r113.d(new d11.d(7, r63, r64, r56, r44, r114, r115, r55, r116, "", 0, "", 0, r510, 1, r13, r412, null, "linking_invite", null, r210, 0, 0, null, r310, null, null, null, 518651904), null);
        goto L123
    L105:
        if (U90().getCurrentScene() != 1) goto L107;
        com.bytedance.android.live.revlink.impl.pk.utils.l r68 = com.bytedance.android.live.revlink.impl.pk.utils.l.f.c;
    L108:
        com.bytedance.android.live.revlink.impl.pk.utils.l r414 = r68;
        String r415 = String.valueOf(r60 + 1);
        d31.d r69 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r69 == null) goto L114;
        String r70 = r69.a();
        if (r70 == null) goto L114;
        String r511 = r70;
    L115:
        d31.d r72 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r72 == null) goto L118;
        String r416 = r72.s();
    L119:
        r310 = w3.a(e21.b.b(r413, r414, "connection", r62, r415, r416, r511, 16));
        goto L121
    L118:
        r416 = "";
    L114:
        r511 = "";
        goto L115
    L107:
        r68 = com.bytedance.android.live.revlink.impl.pk.utils.l.c.c;
        goto L108
    L101:
        r210 = 0;
        goto L102
    L97:
        r115 = null;
        goto L98
    L93:
        r114 = null;
        goto L94
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
        r73.f("recommend", U90().getNpkInvitePageSource());
        goto L11
    }
}
