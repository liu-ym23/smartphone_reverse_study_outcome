package com.bytedance.android.live.liveinteract.linkpanel.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.linkpanel.viewbinder.TalkRoomSearchFootViewBinder;
import com.bytedance.android.live.liveinteract.linkpanel.viewbinder.TalkRoomSearchResultViewBinder;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.service.LinkPanelTransitService;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.ui.SSLinearLayoutManager;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.disposables.Disposable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/liveinteract/linkpanel/fragment/TalkRoomSearchFragment;", "Lcom/bytedance/android/live/liveinteract/linkpanel/fragment/TalkRoomSearchContract$View;", "Lcom/bytedance/android/live/liveinteract/linkpanel/viewbinder/TalkRoomSearchResultViewBinder$a;", "<init>", "()V", "a", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class TalkRoomSearchFragment extends TalkRoomSearchContract$View implements TalkRoomSearchResultViewBinder.a {
    public static final /* synthetic */ int t = 0;
    public int g;
    public int h;
    public n0 i;
    public ViewGroup j;
    public EditText k;
    public View l;
    public View m;
    public RecyclerView n;
    public TextView o;
    public final LinkedList<Object> p;
    public final Lazy q;
    public int r;
    public boolean s;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.contract.InteractDialogFragmentBaseContract$View
    public final String W90() {
        return "";
    }

    public final void da0() {
        this.r = 0;
        this.s = true;
        this.p.clear();
        RecyclerView r1 = this.n;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("searchResultView");
    L5:
        r1.scrollToPosition(0);
        n0 r0 = this.i;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("presenter");
    L8:
        Disposable r2 = r0.c;
        if (r2 == null) goto L12;
        r2.dispose();
        return;
    }

    public final MultiTypeAdapter ea0() {
        return (MultiTypeAdapter) this.q.getValue();
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.contract.InteractDialogFragmentBaseContract$View
    public final ViewGroup X90() {
        ViewGroup r0 = this.j;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mTopView");
    L5:
        return r0;
    }

    public TalkRoomSearchFragment() {
        this.g = -1;
        this.h = -1;
        this.p = new LinkedList();
        this.q = LazyKt.lazy(LazyThreadSafetyMode.NONE, TalkRoomSearchFragment$searchResultAdapter$2.INSTANCE);
        this.s = true;
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.contract.InteractDialogFragmentBaseContract$View
    public final float T90() {
        return UtilityKotlinExtentionsKt.j(com.bytedance.android.live.core.utils.s1.w() * 0.73f);
    }

    public final void onDestroy() {
        super.onDestroy();
        n0 r0 = this.i;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("presenter");
    L5:
        ((com.bytedance.android.livesdk.common.c) r0).a = null;
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.fragment.TalkRoomSearchContract$View
    public final void aa0(List<? extends com.bytedance.android.live.liveinteract.plantform.model.u> r7) {
        Intrinsics.checkNotNullParameter(r7, "users");
        da0();
        boolean r0 = false;
        this.s = false;
        Iterator<T> r8 = r7.iterator();
    L4:
        if (r8.hasNext() == false) goto L8;
        com.bytedance.android.live.liveinteract.plantform.model.u r1 = (com.bytedance.android.live.liveinteract.plantform.model.u) r8.next();
        if (fa0(r1) == false) goto L4;
        this.p.add(new TalkRoomSearchResultViewBinder.b(r1, "", true));
        goto L4
    L8:
        TalkRoomSearchFootViewBinder.b r9 = new TalkRoomSearchFootViewBinder.b(1);
        this.p.add(r9);
        ea0().A2(this.p);
        ea0().notifyDataSetChanged();
        TextView r10 = this.o;
        if (r10 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("historyTv");
    L11:
        r10.setText(com.bytedance.android.live.core.utils.s1.B(2131918766));
        if (this.p.size() <= 1) goto L20;
        TextView r11 = this.o;
        if (r11 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("historyTv");
    L16:
        UtilityKotlinExtentionsKt.w(r11);
        RecyclerView r12 = this.n;
        if (r12 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("searchResultView");
    L19:
        UtilityKotlinExtentionsKt.w(r12);
    L27:
        com.bytedance.live.datacontext.i r13 = com.bytedance.android.live.liveinteract.api.utils.m.i().getLiveMode();
        if (r13 == null) goto L30;
        LiveMode r14 = (LiveMode) r13.getValue();
    L32:
        if (r14 != LiveMode.AUDIO) goto L34;
        r0 = true;
    L34:
        com.bytedance.android.live.liveinteract.linkpanel.util.m.s(r0, this.g, "0", this.p.size() - 1);
        return;
    L30:
        r14 = null;
        goto L32
    L20:
        TextView r15 = this.o;
        if (r15 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("historyTv");
    L23:
        UtilityKotlinExtentionsKt.t(r15);
        RecyclerView r16 = this.n;
        if (r16 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("searchResultView");
    L26:
        UtilityKotlinExtentionsKt.t(r16);
        goto L27
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.fragment.TalkRoomSearchContract$View
    public final void ba0(Throwable r3) {
        Intrinsics.checkNotNullParameter(r3, "throwable");
        if ((r3 instanceof ApiServerException) == false) goto L7;
        ApiServerException r0 = (ApiServerException) r3;
        if (TextUtils.isEmpty(r0.getPrompt()) == true) goto L7;
        f2.c(r0.getPrompt(), 0);
    L7:
        ALogger.e("TalkRoomSearchFragment", r3);
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.fragment.TalkRoomSearchContract$View
    public final void ca0(com.bytedance.android.live.liveinteract.plantform.model.t r9) {
        Intrinsics.checkNotNullParameter(r9, "result");
        this.r++;
        this.s = r9.getHasMore();
        if (this.p.size() <= 0) goto L7;
        LinkedList<Object> r0 = this.p;
        if ((ListProtector.get(r0, r0.size() - 1) instanceof TalkRoomSearchFootViewBinder.b) == false) goto L7;
        this.p.removeLast();
    L7:
        int r1 = this.p.size();
        List<com.bytedance.android.live.liveinteract.plantform.model.u> r10 = r9.getUsers();
        boolean r2 = false;
        if (r10 == null) goto L18;
        Iterator<T> r11 = r10.iterator();
    L11:
        if (r11.hasNext() == false) goto L18;
        com.bytedance.android.live.liveinteract.plantform.model.u r3 = (com.bytedance.android.live.liveinteract.plantform.model.u) r11.next();
        if (fa0(r3) == false) goto L11;
        LinkedList<Object> r4 = this.p;
        EditText r6 = this.k;
        if (r6 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("searchEt");
    L17:
        r4.add(new TalkRoomSearchResultViewBinder.b(r3, r6.getText().toString(), false));
    L18:
        this.p.add(new TalkRoomSearchFootViewBinder.b(!this.s ? 1 : 0));
        ea0().A2(this.p);
        if (r1 <= 0) goto L21;
        ea0().notifyItemInserted(r1);
    L22:
        TextView r12 = this.o;
        if (r12 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("historyTv");
    L25:
        r12.setText(com.bytedance.android.live.core.utils.s1.B(2131918768));
        if (this.p.size() <= 1) goto L34;
        TextView r13 = this.o;
        if (r13 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("historyTv");
    L30:
        UtilityKotlinExtentionsKt.t(r13);
        RecyclerView r14 = this.n;
        if (r14 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("searchResultView");
    L33:
        UtilityKotlinExtentionsKt.w(r14);
    L41:
        com.bytedance.live.datacontext.i r15 = com.bytedance.android.live.liveinteract.api.utils.m.i().getLiveMode();
        if (r15 == null) goto L44;
        LiveMode r16 = (LiveMode) r15.getValue();
    L46:
        if (r16 != LiveMode.AUDIO) goto L48;
        r2 = true;
    L48:
        com.bytedance.android.live.liveinteract.linkpanel.util.m.s(r2, this.g, "1", this.p.size() - 1);
        return;
    L44:
        r16 = null;
        goto L46
    L34:
        TextView r17 = this.o;
        if (r17 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("historyTv");
    L37:
        UtilityKotlinExtentionsKt.w(r17);
        RecyclerView r18 = this.n;
        if (r18 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("searchResultView");
    L40:
        UtilityKotlinExtentionsKt.t(r18);
        goto L41
    L21:
        ea0().notifyDataSetChanged();
        goto L22
    }

    public final boolean fa0(com.bytedance.android.live.liveinteract.plantform.model.u r6) {
        Iterator<T> r0 = this.p.iterator();
    L3:
        Object r2 = null;
        if (r0.hasNext() == false) goto L23;
        Object r1 = r0.next();
        if ((r1 instanceof TalkRoomSearchResultViewBinder.b) == true) goto L8;
        Object r3 = null;
    L9:
        TalkRoomSearchResultViewBinder.b r4 = (TalkRoomSearchResultViewBinder.b) r3;
        if (r4 == null) goto L16;
        com.bytedance.android.live.liveinteract.plantform.model.u r5 = r4.a;
        if (r5 == null) goto L16;
        IBaseUser r7 = r5.getUser();
        if (r7 == null) goto L16;
        String r8 = r7.getIdString();
    L17:
        IBaseUser r9 = r6.getUser();
        if (r9 == null) goto L21;
        r2 = r9.getIdString();
    L21:
        if (Intrinsics.areEqual(r8, r2) == false) goto L3;
        r2 = r1;
    L16:
        r8 = null;
        goto L17
    L8:
        r3 = r1;
    L23:
        if (r2 != null) goto L25;
        return true;
    L25:
        return false;
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        n0 r3 = this.i;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("presenter");
    L5:
        ((com.bytedance.android.livesdk.common.c) r3).a = this;
    }

    public final void onViewCreated(View r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        super.onViewCreated(r4, r5);
        this.n = r4.findViewById(2131385573);
        this.o = (TextView) r4.findViewById(2131390746);
        View r6 = this.m;
        if (r6 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("cancelBtn");
    L5:
        r6.setOnClickListener(com.bytedance.android.livesdk.utils.x0.a(new TalkRoomSearchFragment$initView$1(this)));
        View r7 = this.l;
        if (r7 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("clearBtn");
    L8:
        r7.setOnClickListener(com.bytedance.android.livesdk.utils.x0.a(new TalkRoomSearchFragment$initView$2(this)));
        EditText r8 = this.k;
        if (r8 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("searchEt");
    L11:
        r8.setOnEditorActionListener(new l0(this));
        EditText r9 = this.k;
        if (r9 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("searchEt");
    L14:
        r9.addTextChangedListener(new m0(this));
        if (this.g != 1) goto L17;
        String r10 = "invite";
    L18:
        ea0().z2(TalkRoomSearchResultViewBinder.b.class, new TalkRoomSearchResultViewBinder(r10, this));
        ea0().z2(TalkRoomSearchFootViewBinder.b.class, new TalkRoomSearchFootViewBinder());
        RecyclerView r11 = this.n;
        if (r11 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("searchResultView");
    L21:
        r11.setAdapter(ea0());
        RecyclerView r12 = this.n;
        if (r12 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("searchResultView");
    L24:
        r12.setLayoutManager(new SSLinearLayoutManager(getContext(), 1));
        RecyclerView r13 = this.n;
        if (r13 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("searchResultView");
    L27:
        r13.setItemViewCacheSize(8);
        RecyclerView r14 = this.n;
        if (r14 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("searchResultView");
    L30:
        r14.setItemAnimator(null);
        RecyclerView r15 = this.n;
        if (r15 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("searchResultView");
    L33:
        r15.addOnScrollListener(new TalkRoomSearchFragment$initView$5(this));
        n0 r16 = this.i;
        if (r16 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("presenter");
    L36:
        r16.d();
        return;
    L17:
        r10 = "apply";
        goto L18
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.viewbinder.TalkRoomSearchResultViewBinder.a
    public final void wJ(com.bytedance.android.live.liveinteract.plantform.model.u r6, int r7) {
        Intrinsics.checkNotNullParameter(r6, "user");
        ea0().notifyItemChanged(r7);
        h0.a(r6);
        com.bytedance.live.datacontext.i r8 = com.bytedance.android.live.liveinteract.api.utils.m.i().getLiveMode();
        if (r8 == null) goto L5;
        LiveMode r9 = (LiveMode) r8.getValue();
    L7:
        if (r9 != LiveMode.VIDEO) goto L25;
        com.bytedance.android.live.liveinteract.plantform.model.n0 r10 = r6.getWaitingInfo();
        if (r10 == null) goto L42;
        ILinkPlayerInfoBridge r11 = com.bytedance.android.live.liveinteract.linkpanel.util.o.M(r10);
        if (gh0.a.d() == false) goto L13;
    L19:
        gd0.m r12 = ((IInteractService) jc1.k.n(IInteractService.class)).getLinkPanelTransitService();
        if (r12 == null) goto L45;
        IBaseUser r13 = r11.getUser();
        if (r13 != null) goto L24;
        r13 = (IBaseUser) vh7.f.c(IBaseUser.class);
    L24:
        ((LinkPanelTransitService) r12).i(r13, null);
        return;
    L45:
        return;
    L13:
        if (jc1.k.n(IMiddlewareUserService.class).user().c() == true) goto L19;
        if (jc1.k.n(IMiddlewareUserService.class).user().isAdmin() == false) goto L18;
        f2.b(2131914522, 0);
        return;
    L18:
        f2.b(2131917298, 0);
        return;
    L42:
        return;
    L25:
        com.bytedance.android.live.liveinteract.plantform.model.n0 r14 = r6.getWaitingInfo();
        if (r14 == null) goto L47;
        IBaseUser r15 = com.bytedance.android.live.liveinteract.linkpanel.util.o.M(r14).getUser();
        if (r15 != null) goto L31;
        return;
    L31:
        if (gh0.a.d() == false) goto L33;
    L38:
        gd0.m r16 = ((IInteractService) jc1.k.n(IInteractService.class)).getLinkPanelTransitService();
        if (r16 == null) goto L50;
        ((LinkPanelTransitService) r16).i(r15, null);
        return;
    L50:
        return;
    L33:
        if (jc1.k.n(IMiddlewareUserService.class).user().c() == true) goto L38;
        if (jc1.k.n(IMiddlewareUserService.class).user().isAdmin() == false) goto L37;
        f2.b(2131914522, 0);
        return;
    L37:
        f2.b(2131917298, 0);
        return;
    L47:
        return;
    L5:
        r9 = null;
        goto L7
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.viewbinder.TalkRoomSearchResultViewBinder.a
    public final void xW(com.bytedance.android.live.liveinteract.plantform.model.u r8, int r9) {
        Intrinsics.checkNotNullParameter(r8, "user");
        ea0().notifyItemChanged(r9);
        h0.a(r8);
        com.bytedance.live.datacontext.i r10 = com.bytedance.android.live.liveinteract.api.utils.m.i().getLiveMode();
        IBaseUser r0 = null;
        if (r10 == null) goto L5;
        LiveMode r11 = (LiveMode) r10.getValue();
    L6:
        boolean r2 = false;
        if (r11 != LiveMode.VIDEO) goto L50;
        com.bytedance.live.datacontext.m r12 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r12 == null) goto L11;
        IRoom r13 = (IRoom) r12.getValue();
    L12:
        ILinkPlayerInfoBridge r14 = r8.getInviteInfo();
        if (r14 == null) goto L15;
        r0 = r14.getUser();
    L15:
        if (r13 == null) goto L82;
        if (r0 != null) goto L18;
        return;
    L18:
        if (gh0.a.d() == false) goto L32;
        gd0.m r15 = ((IInteractService) jc1.k.n(IInteractService.class)).getLinkPanelTransitService();
        if (r15 == null) goto L84;
        IRoomBase r16 = (IRoomBase) r13;
        if (com.bytedance.android.live.liveinteract.linkpanel.util.o.c() != 12) goto L24;
        r2 = true;
    L24:
        if (r2 == false) goto L26;
    L29:
        int r3 = this.h;
    L30:
        com.bytedance.android.live.liveinteract.videolink.a r4 = new com.bytedance.android.live.liveinteract.videolink.a(r16, r0, r3);
        r4.e = 4;
        ((LinkPanelTransitService) r15).g(r4);
        return;
    L26:
        if (com.bytedance.android.live.liveinteract.linkpanel.util.o.C() == true) goto L29;
        r3 = this.h + 1;
        goto L30
    L84:
        return;
    L32:
        if (jc1.k.n(IMiddlewareUserService.class).user().c() == false) goto L46;
        gd0.m r17 = ((IInteractService) jc1.k.n(IInteractService.class)).getLinkPanelTransitService();
        if (r17 == null) goto L86;
        IRoomBase r18 = (IRoomBase) r13;
        if (com.bytedance.android.live.liveinteract.linkpanel.util.o.c() != 12) goto L38;
        r2 = true;
    L38:
        if (r2 == false) goto L40;
    L43:
        int r5 = this.h;
    L44:
        com.bytedance.android.live.liveinteract.videolink.a r6 = new com.bytedance.android.live.liveinteract.videolink.a(r18, r0, r5);
        r6.e = 4;
        ((LinkPanelTransitService) r17).g(r6);
        return;
    L40:
        if (com.bytedance.android.live.liveinteract.linkpanel.util.o.C() == true) goto L43;
        r5 = this.h + 1;
        goto L44
    L86:
        return;
    L46:
        if (jc1.k.n(IMiddlewareUserService.class).user().isAdmin() == false) goto L48;
        f2.b(2131914522, 0);
        return;
    L48:
        f2.b(2131917298, 0);
        return;
    L82:
        return;
    L11:
        r13 = null;
        goto L12
    L50:
        if (gh0.a.d() == false) goto L52;
    L57:
        com.bytedance.live.datacontext.m r19 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r19 == null) goto L60;
        IRoom r20 = (IRoom) r19.getValue();
    L61:
        ILinkPlayerInfoBridge r21 = r8.getInviteInfo();
        if (r21 == null) goto L64;
        r0 = r21.getUser();
    L64:
        if (r20 == null) goto L92;
        if (r0 == null) goto L93;
        gd0.m r22 = ((IInteractService) jc1.k.n(IInteractService.class)).getLinkPanelTransitService();
        if (r22 == null) goto L94;
        IRoomBase r7 = (IRoomBase) r20;
        if (this.h >= 0) goto L72;
        int r23 = -1;
    L80:
        ((LinkPanelTransitService) r22).g(new com.bytedance.android.live.liveinteract.videolink.a(r7, r0, r23));
        return;
    L72:
        if (com.bytedance.android.livesdk.chatroom.interact.model.d0.h(r20) == false) goto L74;
    L79:
        r23 = this.h;
        goto L80
    L74:
        if (com.bytedance.android.live.liveinteract.linkpanel.util.o.l() == true) goto L79;
        if (com.bytedance.android.live.liveinteract.linkpanel.util.o.d() == 26) goto L79;
        r23 = this.h + 1;
        goto L80
    L94:
        return;
    L93:
        return;
    L92:
        return;
    L60:
        r20 = null;
        goto L61
    L52:
        if (jc1.k.n(IMiddlewareUserService.class).user().c() == true) goto L57;
        if (jc1.k.n(IMiddlewareUserService.class).user().isAdmin() == false) goto L56;
        f2.b(2131914522, 0);
        return;
    L56:
        f2.b(2131917298, 0);
        return;
    L5:
        r11 = null;
        goto L6
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        View r5 = r2.inflate(2131566089, r3, false);
        View r6 = LayoutInflater.from(getContext()).inflate(2131565782, null);
        if (r6 == null) goto L13;
        ViewGroup r7 = (ViewGroup) r6;
        this.j = r7;
        this.k = (EditText) r7.findViewById(2131385411);
        ViewGroup r8 = this.j;
        if (r8 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mTopView");
    L7:
        this.l = r8.findViewById(2131384416);
        ViewGroup r9 = this.j;
        if (r9 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mTopView");
    L10:
        this.m = r9.findViewById(2131365123);
        return r5;
    L13:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }
}
