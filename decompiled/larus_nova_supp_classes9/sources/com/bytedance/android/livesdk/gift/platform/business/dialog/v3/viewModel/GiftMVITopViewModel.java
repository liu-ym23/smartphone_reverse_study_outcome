package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.viewModel;

import ca0.s;
import com.bytedance.android.anya.BaseMVIDataStore;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.j0;
import com.bytedance.android.anya.k0;
import com.bytedance.android.anya.l0;
import com.bytedance.android.anya.p;
import com.bytedance.android.anya.r;
import com.bytedance.android.anya.r0;
import com.bytedance.android.anya.t0;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.profit.fansclub.FansClubUserStatus;
import com.bytedance.android.livesdk.gift.configmodel.v1;
import com.bytedance.android.livesdk.gift.configmodel.x0;
import com.bytedance.android.livesdk.gift.model.IGiftMarketingInfo;
import com.bytedance.android.livesdk.gift.model.d2;
import com.bytedance.android.livesdk.gift.model.g0;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.k3;
import com.bytedance.android.livesdk.gift.model.l1;
import com.bytedance.android.livesdk.gift.model.l2;
import com.bytedance.android.livesdk.gift.model.l3;
import com.bytedance.android.livesdk.gift.model.q3;
import com.bytedance.android.livesdk.gift.model.t1;
import com.bytedance.android.livesdk.gift.model.x1;
import com.bytedance.android.livesdk.gift.model.x2;
import com.bytedance.android.livesdk.gift.platform.business.config.m;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.GiftListSortDataStore;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.GiftMVICarnivalDataStore;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.GiftScrollDataStore;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.GiftSearchDataStore;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.GiftTopicDataStore;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.h0;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.u;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.GiftExtraRepo;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.d0;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ChangeAllMic;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ClickSearchBack;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ClickTopCloseBtn;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftListBusinessState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftPanelState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftSearchBusinessState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftSearchViewState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftTabBusinessState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftTabViewState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftTopContractKt;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftTopViewState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftTopVisibleChanged;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftVerticalState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.LynxTouchViewVisibleChange;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.PagerListData;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.RefreshGiftExtra;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.SelectedStatus;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.SendGiftSuccess;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.UpdateTopViewSource;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.AssetsUtils;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.android.livesdk.gift.platform.core.a0;
import com.bytedance.android.livesdk.gift.platform.core.giftlist.GiftListRepository;
import com.bytedance.android.livesdk.gift.platform.core.manager.GiftManagerKt;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.GiftMostlyUsedDataStore;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.OpenDialogService;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.PropListService;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.e1;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.u1;
import com.bytedance.android.livesdk.message.model.GiftTouchAction;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.scope.o;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftMVITopViewModel extends com.bytedance.android.anya.g<GiftPanelState, GiftTopViewState, GiftAction> implements o, s {
    public boolean A;
    public final Set<BaseMVIDataStore<?>> B;
    public final v1 C;
    public String D;
    public final Lazy E;
    public x2 F;
    public int G;
    public boolean H;
    public final GiftSearchDataStore H0;
    public GiftTabViewState I;
    public Pair<Long, ? extends d2> J;
    public h1 K;
    public GiftListBusinessState.GiftSelected L;
    public final GiftMostlyUsedDataStore L0;
    public long M;
    public HashMap<Integer, Boolean> N;
    public boolean O;
    public final boolean P;
    public final PropListService P0;
    public final DataCenter Q;
    public final OpenDialogService R;
    public final u1 S;
    public final GiftExtraRepo T;
    public final com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.a U;
    public final com.bytedance.android.livesdk.gift.platform.core.giftlist.h V;
    public final GiftListRepository W;
    public final GiftMVICarnivalDataStore X;
    public final GiftListSortDataStore Y;
    public final GiftTopicDataStore Z;
    public final GiftScrollDataStore k0;
    public final com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f p0;
    public final String z;

    public final boolean z1() {
        return ((Boolean) this.E.getValue()).booleanValue();
    }

    public final void onStart() {
        GiftContext r0 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r0 == null) goto L10;
        com.bytedance.live.datacontext.i<Set<s>> r1 = r0.getGiftSendResultListeners();
        if (r1 == null) goto L11;
        Set r2 = (Set) r1.getValue();
        if (r2 == null) goto L12;
        r2.add(this);
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void onStop() {
        GiftContext r0 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r0 == null) goto L10;
        com.bytedance.live.datacontext.i<Set<s>> r1 = r0.getGiftSendResultListeners();
        if (r1 == null) goto L11;
        Set r2 = (Set) r1.getValue();
        if (r2 == null) goto L12;
        r2.remove(this);
        return;
    L12:
        return;
    L11:
        return;
    }

    public final Set<BaseMVIDataStore<?>> I() {
        return this.B;
    }

    public final boolean B1(int r4) {
        List<l2> r0 = this.P0.a;
        if (r4 == 5) goto L5;
    L15:
        return false;
    L5:
        if (z1() == false) goto L15;
        if (r0 != null) goto L9;
    L12:
        boolean r1 = true;
    L13:
        if (r1 == false) goto L15;
        return true;
    L9:
        if (r0.isEmpty() == true) goto L12;
        r1 = false;
        goto L13
    }

    public final MVIState F(l0 r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$createState");
        GiftTopViewState r0 = new GiftTopViewState();
        if (v.e() == false) goto L5;
        r0<GiftTopViewState, GiftTopViewState.Mode> r1 = r0.getMode();
        GiftTopViewState.Mode r2 = GiftTopViewState.Mode.Collection;
        r4.getClass();
        l0.h(r1, r2);
    L6:
        return r0;
    L5:
        r0<GiftTopViewState, GiftTopViewState.Mode> r3 = r0.getMode();
        GiftTopViewState.Mode r5 = GiftTopViewState.Mode.Banner;
        r4.getClass();
        l0.h(r3, r5);
        goto L6
    }

    public final boolean V1(int r4) {
        if (((Boolean) this.Q.get("data_is_anchor", Boolean.FALSE)).booleanValue() == false) goto L5;
        return false;
    L5:
        com.bytedance.android.live.profit.fansclub.o r0 = yt0.c.c();
        if (r0 == null) goto L8;
        boolean r1 = r0.isMember();
    L10:
        if (r4 != 2) goto L18;
        if (r1 == true) goto L13;
    L16:
        return true;
    L13:
        if (this.P == true) goto L16;
        if (((Boolean) com.bytedance.android.livesdk.gift.platform.core.h.b0.getValue(null, com.bytedance.android.livesdk.gift.platform.core.h.a[52])).booleanValue() == true) goto L16;
        return false;
    L18:
        return false;
    L8:
        r1 = false;
        goto L10
    }

    public final void d(com.bytedance.android.anya.dsl.h<GiftPanelState, GiftAction> r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$bindToParent");
        GiftMVITopViewModel$bindToParent$1 r0 = GiftMVITopViewModel$bindToParent$1.INSTANCE;
        List r5 = r4.a;
        ArrayList r6 = (ArrayList) r5;
        r6.add(new com.bytedance.android.anya.dsl.i(this, r0, GiftAction.class));
    }

    public final void j(com.bytedance.android.livesdk.gift.platform.business.sendGift.f r7) {
        Intrinsics.checkNotNullParameter(r7, "result");
        if (r7.c == false) goto L14;
        Set<Long> r0 = r7.a;
        if (r0 != null) goto L7;
        return;
    L7:
        if (r0.size() != 1) goto L17;
        Set<Long> r1 = r7.a;
        if (r1 == null) goto L18;
        Iterator<T> r2 = r1.iterator();
    L12:
        if (r2.hasNext() == false) goto L19;
        K0(new SendGiftSuccess(((Number) r2.next()).longValue(), r7.b));
        goto L12
    L19:
        return;
    L18:
        return;
    L17:
        return;
    }

    public final void w1(UpdateTopViewSource r3) {
        if (z1() == true) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(this.N.get(Integer.valueOf(this.G)), Boolean.FALSE) == false) goto L9;
        if (r3 != null) goto L8;
        r3 = UpdateTopViewSource.OTHERS;
    L8:
        J1(false, r3, this.K);
        return;
    L9:
        if (r3 != null) goto L11;
        r3 = UpdateTopViewSource.OTHERS;
    L11:
        J1(true, r3, this.K);
    }

    public static boolean x1(h1 r0, g0 r1) {
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.b.a(r0.getBannerScheme()) == true) goto L5;
    L12:
        return false;
    L5:
        if (v.e() == false) goto L12;
        if (r1 == null) goto L8;
        String r2 = r1.getBannerGiftInfo();
    L10:
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.b.a(r2) == false) goto L12;
        return true;
    L8:
        r2 = null;
        goto L10
    }

    public final void C1(x2 r7, GiftTopViewState.Mode r8) {
        if (r8 != GiftTopViewState.Mode.Activity) goto L10;
        if (r7 == null) goto L21;
        x2 r9 = this.F;
        if (r9 != null) goto L8;
        boolean r10 = true;
    L9:
        if (r10 == false) goto L10;
        return;
    L8:
        r10 = StringsKt.equals$default(r9.getTitle(), r7.getTitle(), false, 2, null);
        goto L9
    L21:
        return;
    L10:
        this.F = r7;
        u1 r11 = this.S;
        if (r7 == null) goto L14;
        String r2 = r7.getTitle();
        if (r2 == null) goto L14;
    L15:
        if (r7 == null) goto L18;
        Map<String, String> r13 = r7.getExtra();
        if (r13 == null) goto L18;
    L19:
        r11.getClass();
        Intrinsics.checkNotNullParameter("doudi", "topSceneType");
        Intrinsics.checkNotNullParameter(r2, "topSceneTitle");
        Intrinsics.checkNotNullParameter(r13, "extra");
        LinkedHashMap r4 = new LinkedHashMap();
        r4.put("top_scene_type", "doudi");
        r4.put("top_scene_title", r2);
        r4.put("top_scene_sub_type", BuildConfig.FLAVOR);
        r4.put("top_scene_icon_gift_id", BuildConfig.FLAVOR);
        r4.put("top_scene_gift_list", BuildConfig.FLAVOR);
        r4.putAll(r13);
        r11.p1("gift_top_scene_show", r4, true);
        return;
    L18:
        r13 = MapsKt.emptyMap();
    L14:
        r2 = BuildConfig.FLAVOR;
        goto L15
    }

    public final void E1(String r4, String r5) {
        if ((!Intrinsics.areEqual(this.D, r5)) == false) goto L6;
        jy0.b.d(this.z, "state after " + r4 + ": " + r5);
        this.D = r5;
        return;
    }

    public final void J0(com.bytedance.android.anya.internal.e r4, MVIState r5) {
        final GiftTopViewState r6 = (GiftTopViewState) r5;
        Intrinsics.checkNotNullParameter(r4, "$this$reduce");
        Intrinsics.checkNotNullParameter(r6, "state");
        r4.e(this.T.R(), new GiftMVITopViewModel$reduce$1(this, r6));
        r4.e(this.Z.w(), new GiftMVITopViewModel$reduce$2(this, r6));
        r4.d(this.k0.k(), this.k0.n(), new GiftMVITopViewModel$reduce$3(this, r6));
        r4.e(this.H0.o(), new GiftMVITopViewModel$reduce$4(this));
        r4.e(this.L0.w(), new GiftMVITopViewModel$reduce$5(this, r6));
    }

    public final void J1(boolean r7, UpdateTopViewSource r8, h1 r9) {
        if (z1() == true) goto L8;
        if (this.H0.s() == true) goto L8;
        return;
    L8:
        if (v.a() == false) goto L11;
        return;
    L11:
        if (r8 != UpdateTopViewSource.SELECT_GIFT) goto L24;
        if (r9 == null) goto L14;
        Object r10 = Long.valueOf(r9.getReqExtraType());
    L16:
        if (Intrinsics.areEqual(r10, 2L) == false) goto L24;
        GiftListBusinessState.GiftSelected r11 = this.L;
        if (r11 == null) goto L20;
        SelectedStatus r13 = r11.getSelectedStatus();
    L22:
        if (r13 == SelectedStatus.GROUP) goto L24;
        return;
    L20:
        r13 = null;
        goto L22
    L14:
        r10 = 0;
    L24:
        Objects.toString(r8);
        this.H0.s();
        int r2 = this.G;
        GiftListBusinessState.GiftSelected r0 = this.L;
        if (r0 == null) goto L27;
        int r3 = r0.getSelectedPosition();
    L28:
        K0(new GiftTopVisibleChanged(r7, r2, r3, r8, this.H0.s()));
        return;
    L27:
        r3 = -1;
        goto L28
    }

    public final boolean K1(l0<GiftTopViewState> r7, GiftTopViewState r8, boolean r9, GiftTabViewState r10) {
        if (v.e() == true) goto L5;
    L43:
        boolean r11 = com.bytedance.android.live.revenue.core.util.f.a(l01.d.class).isLogin();
        m r0 = (m) com.bytedance.android.livesdk.gift.util.b.a().d(m.class);
        Room r4 = null;
        IRoom r2 = (IRoom) this.Q.get("data_room", null);
        if ((r2 instanceof Room) == true) goto L46;
        r2 = null;
    L46:
        Room r3 = (Room) r2;
        if (r0.j(r11) == false) goto L49;
        r0<GiftTopViewState, GiftTopViewState.Mode> r13 = r8.getMode();
        GiftTopViewState.Mode r1 = GiftTopViewState.Mode.Default;
        r7.getClass();
        l0.h(r13, r1);
        l0.h(r8.getShowDetail(), Boolean.FALSE);
        l0.h(r8.getMarketingHiddenAnim(), Boolean.valueOf(r9));
    L56:
        return true;
    L49:
        m r14 = (m) com.bytedance.android.livesdk.gift.util.b.a().d(m.class);
        Room r5 = (IRoom) this.Q.get("data_room", null);
        if ((r5 instanceof Room) == false) goto L54;
        r4 = r5;
    L54:
        if (r14.h() == false) goto L56;
        r0<GiftTopViewState, GiftTopViewState.Mode> r15 = r8.getMode();
        GiftTopViewState.Mode r6 = GiftTopViewState.Mode.LynxGrowthTouch;
        r7.getClass();
        l0.h(r15, r6);
        l0.h(r8.getShowDetail(), Boolean.valueOf(this.A));
        l0.h(r8.getMarketingHiddenAnim(), Boolean.valueOf(r9));
        goto L56
    L5:
        if (r10 == null) goto L22;
        r0<GiftTabViewState, Integer> r16 = r10.getTabType();
        if (r16 == null) goto L22;
        r7.getClass();
        if (((Number) com.bytedance.android.anya.h.b(r16)).intValue() != 5) goto L22;
        if (z1() == true) goto L15;
        l0.h(r8.getMode(), GiftTopViewState.Mode.Collection);
        r0<GiftTopViewState, Boolean> r17 = r8.getVisibility();
        Boolean r18 = Boolean.FALSE;
        l0.h(r17, r18);
        l0.h(r8.getShowDetail(), r18);
        l0.h(r8.getMarketingHiddenAnim(), Boolean.valueOf(r9));
        return false;
    L15:
        if (z1() == false) goto L22;
        if (this.H == false) goto L19;
    L20:
        J1(false, UpdateTopViewSource.OTHERS, this.K);
        return false;
    L19:
        if (B1(5) == true) goto L20;
    L22:
        if (r10 == null) goto L36;
        r0<GiftTabViewState, Integer> r19 = r10.getTabType();
        if (r19 == null) goto L36;
        r7.getClass();
        if (((Number) com.bytedance.android.anya.h.b(r19)).intValue() != 17) goto L36;
        if (this.L0.s() == false) goto L36;
        if (this.L0.y() == false) goto L36;
        if (z1() == true) goto L34;
        l0.h(r8.getMode(), GiftTopViewState.Mode.Collection);
        r0<GiftTopViewState, Boolean> r20 = r8.getVisibility();
        Boolean r110 = Boolean.FALSE;
        l0.h(r20, r110);
        l0.h(r8.getShowDetail(), r110);
        l0.h(r8.getMarketingHiddenAnim(), Boolean.valueOf(r9));
    L35:
        return false;
    L34:
        J1(false, UpdateTopViewSource.OTHERS, this.K);
    L36:
        if (r10 == null) goto L41;
        r0<GiftTabViewState, Integer> r111 = r10.getTabType();
        if (r111 == null) goto L41;
        r7.getClass();
        if (((Number) com.bytedance.android.anya.h.b(r111)).intValue() == 3) goto L43;
    L41:
        r0<GiftTopViewState, GiftTopViewState.Mode> r112 = r8.getMode();
        GiftTopViewState.Mode r21 = GiftTopViewState.Mode.Collection;
        r7.getClass();
        l0.h(r112, r21);
        l0.h(r8.getShowDetail(), Boolean.FALSE);
        l0.h(r8.getMarketingHiddenAnim(), Boolean.valueOf(r9));
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v32 */
    /* JADX WARN: Type inference failed for: r0v35 */
    /* JADX WARN: Type inference failed for: r0v9, types: [com.bytedance.android.livesdk.gift.model.h1, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftListBusinessState$GiftSelected] */
    public final void h1(j0 r26, MVIState r27, p r28, Function2 r29) {
        GiftTopViewState r11 = (GiftTopViewState) r27;
        com.bytedance.android.anya.internal.c r13 = (GiftAction) r28;
        Intrinsics.checkNotNullParameter(r26, "$this$postReduce");
        Intrinsics.checkNotNullParameter(r11, "state");
        Intrinsics.checkNotNullParameter(r13, "action");
        Intrinsics.checkNotNullParameter(r29, "dispatchPostReduce");
        com.bytedance.android.anya.internal.p r1 = r26.getContext();
        com.bytedance.android.anya.internal.c r14 = 0;
        com.bytedance.android.anya.internal.c r2 = (com.bytedance.android.anya.v) r1.b(r1.c(GiftPanelState.class), GiftMVITopViewModel$postReduce$1$1.INSTANCE).a.invoke();
        if (r2 == null) goto L25;
        com.bytedance.android.anya.internal.c r3 = r2;
        Object r4 = r2.c();     // Catch: Throwable -> L22
        int r5 = r2.c;     // Catch: Throwable -> L22
        Object r6 = ((LinkedHashMap) r26.d).get(r2);     // Catch: Throwable -> L22
        if (r6 != null) goto L10;
        r6 = r14;
    L10:
        if (r5 <= ((Number) r6).intValue()) goto L12;
        boolean r7 = true;
    L13:
        if (r7 == false) goto L19;
        k0<GiftTabViewState, ?> r8 = j0.a.a;     // Catch: Throwable -> L22
        GiftTabViewState r9 = (GiftTabViewState) r4;     // Catch: Throwable -> L22
        r8.getClass();     // Catch: Throwable -> L22
        r r10 = r9.toBusinessState(r8);     // Catch: Throwable -> L22
        this.I = r9;     // Catch: Throwable -> L22
        l0 r15 = r26.g;     // Catch: Throwable -> L22
        GiftTopViewState r16 = (GiftTopViewState) r15.f();     // Catch: Throwable -> L22
        if ((r10 instanceof GiftTabBusinessState.TabSelected) == false) goto L19;
        if (((GiftTabBusinessState.TabSelected) r10).getPosition() == this.G) goto L19;
        this.G = ((GiftTabBusinessState.TabSelected) r10).getPosition();     // Catch: Throwable -> L22
        u1(this, r15, r9, r11, this.J);     // Catch: Throwable -> L22
    L19:
        if (r7 == false) goto L24;
        r26.a();     // Catch: Throwable -> L22
    L24:
        r26.c.put(r2, Integer.valueOf(r3.c));
        goto L25
    L12:
        r7 = false;
    L22:
        th = move-exception;
        r26.c.put(r2, Integer.valueOf(r3.c));
        throw th;
    L25:
        com.bytedance.android.anya.internal.p r17 = r26.getContext();
        com.bytedance.android.anya.internal.c r18 = (com.bytedance.android.anya.v) r17.a(r17.b(r17.c(GiftPanelState.class), GiftMVITopViewModel$postReduce$3$wrapped$1.INSTANCE), GiftMVITopViewModel$postReduce$3$wrapped$2.INSTANCE).a.invoke();
        if (r18 != null) goto L28;
        com.bytedance.android.anya.internal.c r210 = r13;
        com.bytedance.android.anya.internal.c r19 = r14;
        ?? r0 = 0;
    L64:
        com.bytedance.android.anya.internal.p r20 = r26.getContext();
        com.bytedance.android.anya.internal.c r110 = (com.bytedance.android.anya.v) r20.b(r20.c(GiftPanelState.class), GiftMVITopViewModel$postReduce$5$1.INSTANCE).a.invoke();
        if (r110 == null) goto L92;
        com.bytedance.android.anya.internal.c r111 = r110;
        Object r21 = r110.c();     // Catch: Throwable -> L94
        int r23 = r110.c;     // Catch: Throwable -> L94
        Object r24 = ((LinkedHashMap) r26.d).get(r110);     // Catch: Throwable -> L94
        if (r24 != null) goto L71;
        Object r112 = r19;
    L73:
        if (r23 <= ((Number) r112).intValue()) goto L75;
        boolean r113 = true;
    L76:
        if (r113 == false) goto L89;
        k0 r25 = j0.a.a;     // Catch: Throwable -> L94
        r25.getClass();     // Catch: Throwable -> L94
        r r30 = ((GiftSearchViewState) r21).toBusinessState(r25);     // Catch: Throwable -> L94
        l0 r31 = r26.g;     // Catch: Throwable -> L94
        GiftTopViewState r33 = (GiftTopViewState) r31.f();     // Catch: Throwable -> L94
        if ((r30 instanceof GiftSearchBusinessState.GiftSelected) == false) goto L87;
        if (((GiftSearchBusinessState.GiftSelected) r30).getIconModel() == null) goto L87;
        this.K = ((GiftSearchBusinessState.GiftSelected) r30).getIconModel().a;     // Catch: Throwable -> L94
        if (this.M == ((GiftSearchBusinessState.GiftSelected) r30).getIconModel().a.getId()) goto L84;
        boolean r34 = true;
    L85:
        this.M = ((GiftSearchBusinessState.GiftSelected) r30).getIconModel().a.getId();     // Catch: Throwable -> L94
        GiftListBusinessState.GiftSelected r35 = new GiftListBusinessState.GiftSelected(-1, ((GiftSearchBusinessState.GiftSelected) r30).getSelectedPosition(), ((GiftSearchBusinessState.GiftSelected) r30).getIconModel(), ((GiftSearchBusinessState.GiftSelected) r30).getSelectedStatus(), -1, -1, -1, ((GiftSearchBusinessState.GiftSelected) r30).getSelectedVisualStatus());     // Catch: Throwable -> L94
        this.L = r35;     // Catch: Throwable -> L94
        A1(r31, r35, r11, this.I, 0, UpdateTopViewSource.SELECT_GIFT, r34);     // Catch: Throwable -> L94
        goto L89
    L84:
        r34 = false;
    L87:
        if ((r30 instanceof GiftSearchBusinessState.Idle) == false) goto L89;
        this.L = r0;     // Catch: Throwable -> L94
        this.K = r0;     // Catch: Throwable -> L94
        J1(false, UpdateTopViewSource.SELECT_GIFT, r0);     // Catch: Throwable -> L94
    L89:
        if (r113 == false) goto L91;
        r26.a();     // Catch: Throwable -> L94
    L91:
        r26.c.put(r110, Integer.valueOf(r111.c));
        goto L92
    L75:
        r113 = false;
        goto L76
    L71:
        r112 = r24;
    L94:
        th = move-exception;
        r26.c.put(r110, Integer.valueOf(r111.c));
        throw th;
    L92:
        r29.invoke(r26, r210);
        return;
    L28:
        com.bytedance.android.anya.internal.c r36 = r18;
        Object r37 = r18.c();     // Catch: Throwable -> L48
        int r38 = r18.c;     // Catch: Throwable -> L48
        Object r39 = ((LinkedHashMap) r26.d).get(r18);     // Catch: Throwable -> L48
        if (r39 != null) goto L33;
        r39 = r14;
    L33:
        if (r38 <= ((Number) r39).intValue()) goto L35;
        boolean r114 = true;
    L103:
        if (r114 == false) goto L60;
        k0 r40 = j0.a.a;     // Catch: Throwable -> L48
        GiftVerticalState r41 = (GiftVerticalState) r37;     // Catch: Throwable -> L48
        r40.getClass();     // Catch: Throwable -> L48
        r r43 = r41.toBusinessState(r40);     // Catch: Throwable -> L48
        l0 r44 = r26.g;     // Catch: Throwable -> L48
        GiftTopViewState r45 = (GiftTopViewState) r44.f();     // Catch: Throwable -> L48
        if ((r43 instanceof GiftListBusinessState.GiftSelected) == true) goto L40;
    L50:
        l0 r115 = r44;
        GiftVerticalState r211 = r41;
        r210 = r13;
        r19 = r14;
        boolean r46 = false;
        r46 = false;
        r14 = r36;
        r13 = r18;
        if ((r43 instanceof GiftListBusinessState.Idle) == false) goto L53;
        this.L = null;     // Catch: Throwable -> L58
        this.K = null;     // Catch: Throwable -> L58
        u1(this, r115, this.I, r11, this.J);     // Catch: Throwable -> L58
    L53:
        k0 r47 = r115.b;     // Catch: Throwable -> L58
        t0<GiftVerticalState, PagerListData> r48 = r211.getPanelList();     // Catch: Throwable -> L58
        r0<GiftVerticalState, Integer> r49 = r211.getCurrentPagePosition();     // Catch: Throwable -> L58
        r47.getClass();     // Catch: Throwable -> L58
        if (com.bytedance.android.anya.h.a(((PagerListData) k0.d(r48, ((Number) com.bytedance.android.anya.h.b(r49)).intValue())).getItemDataList()) > 0) goto L56;
        boolean r50 = true;
    L57:
        this.H = r50;     // Catch: Throwable -> L58
        boolean r51 = r46;
    L61:
        if (r114 == false) goto L63;
        r26.a();     // Catch: Throwable -> L58
    L63:
        r26.c.put(r13, Integer.valueOf(r14.c));
        r0 = r51;
        goto L64
    L56:
        r50 = false;
        goto L57
    L40:
        if (((GiftListBusinessState.GiftSelected) r43).getIconModel() == null) goto L50;
        this.L = (GiftListBusinessState.GiftSelected) r43;     // Catch: Throwable -> L48
        this.K = ((GiftListBusinessState.GiftSelected) r43).getIconModel().a;     // Catch: Throwable -> L48
        k0 r53 = r44.b;     // Catch: Throwable -> L48
        t0<GiftVerticalState, PagerListData> r54 = r41.getPanelList();     // Catch: Throwable -> L48
        int r55 = ((GiftListBusinessState.GiftSelected) r43).getSelectedPagePosition();     // Catch: Throwable -> L48
        r53.getClass();     // Catch: Throwable -> L48
        int r56 = ((Number) com.bytedance.android.anya.h.b(((PagerListData) k0.d(r54, r55)).getTabType())).intValue();     // Catch: Throwable -> L48
        if (this.M == ((GiftListBusinessState.GiftSelected) r43).getIconModel().a.getId()) goto L44;
        boolean r116 = true;
    L45:
        this.M = ((GiftListBusinessState.GiftSelected) r43).getIconModel().a.getId();     // Catch: Throwable -> L48
        r115 = r44;
        r211 = r41;
        r19 = r14;
        r14 = r36;
        r46 = false;
        r210 = r13;
        r13 = r18;
        A1(r44, (GiftListBusinessState.GiftSelected) r43, r11, this.I, r56, UpdateTopViewSource.SELECT_GIFT, r116);     // Catch: Throwable -> L58
        goto L53
    L44:
        r116 = false;
        goto L45
    L60:
        r210 = r13;
        r19 = r14;
        r51 = false;
        r14 = r36;
        r13 = r18;
    L58:
        th = th;
    L97:
        r26.c.put(r13, Integer.valueOf(r14.c));
        throw th;
    L35:
        r114 = false;
    L48:
        th = th;
        r14 = r36;
        r13 = r18;
        goto L97
    }

    public final void s1(l0 r8, MVIState r9, p r10, Function1 r11) {
        GiftTopViewState r13 = (GiftTopViewState) r9;
        GiftAction r14 = (GiftAction) r10;
        Intrinsics.checkNotNullParameter(r8, "$this$reduce");
        Intrinsics.checkNotNullParameter(r13, "state");
        Intrinsics.checkNotNullParameter(r14, "action");
        Intrinsics.checkNotNullParameter(r11, "dispatchReduce");
        boolean r1 = false;
        if ((r14 instanceof LynxTouchViewVisibleChange) == false) goto L40;
        LynxTouchViewVisibleChange r0 = (LynxTouchViewVisibleChange) r14;
        if (r0.getTopDetailVisible() == true) goto L7;
    L9:
        this.A = r1;
        r0<GiftTopViewState, GiftTopViewState.Mode> r2 = r13.getMode();
        r8.getClass();
        if (((GiftTopViewState.Mode) com.bytedance.android.anya.h.b(r2)) != GiftTopViewState.Mode.BuffCard) goto L12;
    L38:
        jy0.b.d(this.z, "intercept " + r14 + " since " + GiftTopContractKt.simpleStateString(r8, r13));
        return;
    L12:
        if (((GiftTopViewState.Mode) com.bytedance.android.anya.h.b(r13.getMode())) == GiftTopViewState.Mode.DIY) goto L38;
        if (((GiftTopViewState.Mode) com.bytedance.android.anya.h.b(r13.getMode())) == GiftTopViewState.Mode.FansClub) goto L38;
        if (((GiftTopViewState.Mode) com.bytedance.android.anya.h.b(r13.getMode())) == GiftTopViewState.Mode.Activity) goto L38;
        if (((GiftTopViewState.Mode) com.bytedance.android.anya.h.b(r13.getMode())) == GiftTopViewState.Mode.BuffContainer) goto L38;
        if (((GiftTopViewState.Mode) com.bytedance.android.anya.h.b(r13.getMode())) == GiftTopViewState.Mode.DIYContainer) goto L38;
        if (((GiftTopViewState.Mode) com.bytedance.android.anya.h.b(r13.getMode())) == GiftTopViewState.Mode.GroupContainer) goto L38;
        if (((GiftTopViewState.Mode) com.bytedance.android.anya.h.b(r13.getMode())) == GiftTopViewState.Mode.Banner) goto L38;
        if (((GiftTopViewState.Mode) com.bytedance.android.anya.h.b(r13.getMode())) == GiftTopViewState.Mode.Collection) goto L38;
        if (((GiftTopViewState.Mode) com.bytedance.android.anya.h.b(r13.getMode())) != GiftTopViewState.Mode.Group) goto L33;
        if (v.e() == true) goto L38;
    L33:
        if (r0.getLynxTouchViewVisible() == false) goto L37;
        l0.h(r13.getMode(), GiftTopViewState.Mode.LynxGrowthTouch);
        r0<GiftTopViewState, Boolean> r3 = r13.getShowAnim();
        Boolean r4 = Boolean.TRUE;
        l0.h(r3, r4);
        l0.h(r13.getShowDetail(), Boolean.valueOf(r0.getTopDetailVisible()));
        l0.h(r13.getVisibility(), r4);
        if (z1() == false) goto L37;
        J1(true, UpdateTopViewSource.OTHERS, this.K);
    L37:
        E1(r14.toString(), GiftTopContractKt.simpleStateString(r8, r13));
    L63:
        r11.invoke(r14);
        return;
    L7:
        if (v.e() == true) goto L9;
        r1 = true;
        goto L9
    L40:
        if ((r14 instanceof ClickTopCloseBtn) == false) goto L42;
        OpenDialogService.d(this.R, 0, null, 3);
        goto L63
    L42:
        boolean r5 = r14 instanceof RefreshGiftExtra;
        if (r5 == false) goto L45;
    L50:
        r0<GiftTopViewState, GiftTopViewState.Mode> r6 = r13.getMode();
        r8.getClass();
        if (GiftTopContractKt.isGroupMode((GiftTopViewState.Mode) com.bytedance.android.anya.h.b(r6)) == true) goto L63;
        h1 r7 = this.K;
        if (r7 == null) goto L63;
        if (r5 == false) goto L56;
        boolean r15 = ((RefreshGiftExtra) r14).getNeedMarketingAnim();
    L57:
        GiftTabViewState r16 = this.I;
        if (r16 == null) goto L62;
        r0<GiftTabViewState, Integer> r17 = r16.getTabType();
        if (r17 == null) goto L62;
        ((Integer) com.bytedance.android.anya.h.b(r17)).intValue();
    L62:
        d2(r8, r7, r16, r13, r15, UpdateTopViewSource.EXTRA_UPDATE);
        E1(r14.toString(), GiftTopContractKt.simpleStateString(r8, r13));
        goto L63
    L56:
        r15 = false;
        goto L57
    L45:
        if ((r14 instanceof ChangeAllMic) == true) goto L50;
        if ((r14 instanceof ClickSearchBack) == false) goto L63;
        this.K = null;
        this.L = null;
        u1(this, r8, this.I, r13, this.J);
        goto L63
    }

    public static /* synthetic */ void u1(GiftMVITopViewModel r7, l0 r8, GiftTabViewState r9, GiftTopViewState r10, Pair r11) {
        r7.t1(r8, r9, r10, r11, false, UpdateTopViewSource.OTHERS);
    }

    public final void d2(l0 r13, h1 r14, GiftTabViewState r15, GiftTopViewState r16, boolean r17, UpdateTopViewSource r18) {
        r0<GiftTopViewState, Boolean> r2 = r16.getVisibility();
        Boolean r3 = Boolean.TRUE;
        r13.getClass();
        l0.h(r2, r3);
        g0 r4 = this.T.q(r14.getId());
        if (r4 == null) goto L5;
        r4.getGiftMarketingInfo();
    L5:
        g0 r5 = this.T.q(r14.getId());
        if (r5 == null) goto L8;
        com.bytedance.android.livesdk.gift.model.p r6 = r5.getDiyGiftToolbarInfo();
    L10:
        if (r6 != null) goto L12;
        boolean r7 = AssetsUtils.b;
        boolean r8 = AssetsUtils.b(com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.h());
        if (GiftManagerKt.l(r14.getId()) != null) goto L20;
    L44:
        int r9 = u.a;
        this.Y.n(r14.getId());
        this.Y.getClass();
        g0 r10 = this.T.q(r14.getId());
        if (r10 == null) goto L47;
        IGiftMarketingInfo r11 = r10.getGiftMarketingInfo();
    L48:
        if (r11 != null) goto L50;
    L55:
        boolean r19 = false;
    L56:
        if (r19 == false) goto L64;
        if (x1(r14, this.T.q(r14.getId())) == false) goto L60;
        l0.h(r16.getMode(), GiftTopViewState.Mode.Banner);
    L61:
        l0.h(r16.getShowDetail(), Boolean.FALSE);
        l0.h(r16.getMarketingHiddenAnim(), Boolean.valueOf(r17));
        J1(true, r18, r14);
        return;
    L60:
        l0.h(r16.getMode(), GiftTopViewState.Mode.Marketing);
        goto L61
    L64:
        if (GiftManagerKt.l(r14.getId()) == null) goto L106;
        if (this.U.j() == true) goto L106;
        if (this.H0.s() == true) goto L106;
        if (((x0) nz1.a.w.getValue(null, nz1.a.a[21])).a() == false) goto L106;
        g0 r20 = this.T.q(r14.getId());
        if (r20 == null) goto L74;
        l3 r21 = r20.getSeriesGift();
    L75:
        if (r21 == null) goto L106;
        int r23 = h0.a;
        List<k3> r24 = r21.getSeriesGiftList();
        if (r24 != null) goto L79;
        r24 = CollectionsKt.emptyList();
    L79:
        com.bytedance.android.livesdk.gift.platform.core.model.l r25 = this.V.M4().get(this.p0.b);
        if (r25 == null) goto L82;
        List<com.bytedance.android.livesdk.gift.platform.core.giftlist.j> r26 = r25.a;
    L83:
        Map r27 = h0.a(r24, r26, this.W);
        List<k3> r28 = r21.getSeriesGiftList();
        if (r28 != null) goto L86;
        r28 = CollectionsKt.emptyList();
    L86:
        Iterator<k3> r29 = r28.iterator();
    L88:
        if (r29.hasNext() == false) goto L94;
        h1 r110 = (h1) ((LinkedHashMap) r27).get(Long.valueOf(r29.next().getGiftId()));
        if (r110 == null) goto L93;
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.i(r110.getPrimaryEffectId()) == true) goto L88;
    L93:
        boolean r30 = false;
    L95:
        if (r30 == false) goto L97;
    L99:
        int r31 = r27.size();
        List<k3> r33 = r21.getSeriesGiftList();
        if (r33 == null) goto L106;
        if (r31 != r33.size()) goto L106;
        l0.h(r16.getMode(), GiftTopViewState.Mode.Series);
        l0.h(r16.getShowDetail(), Boolean.FALSE);
        l0.h(r16.getMarketingHiddenAnim(), Boolean.valueOf(r17));
        J1(true, r18, r14);
        return;
    L97:
        if (this.C.getEnable() == true) goto L99;
        if (r8 == false) goto L106;
    L94:
        r30 = true;
        goto L95
    L82:
        r26 = null;
        goto L83
    L74:
        r21 = null;
    L106:
        if (x1(r14, this.T.q(r14.getId())) == false) goto L110;
        l0.h(r16.getMode(), GiftTopViewState.Mode.Banner);
        l0.h(r16.getShowDetail(), Boolean.FALSE);
        l0.h(r16.getMarketingHiddenAnim(), Boolean.valueOf(r17));
        J1(true, r18, r14);
        return;
    L110:
        if (GiftManagerKt.l(r14.getId()) == null) goto L127;
        g0 r34 = this.T.q(r14.getId());
        if (r34 == null) goto L114;
        q3 r35 = r34.getSubscribeGiftPackInfo();
    L115:
        if (r35 == null) goto L127;
        g0 r36 = this.T.q(r14.getId());
        if (r36 == null) goto L121;
        q3 r37 = r36.getSubscribeGiftPackInfo();
        if (r37 == null) goto L121;
        long r38 = r37.getRelatedGiftId();
    L123:
        if (GiftManagerKt.l(r38) == null) goto L127;
        l0.h(r16.getMode(), GiftTopViewState.Mode.CustomGiftBagEntrance);
        l0.h(r16.getShowDetail(), Boolean.FALSE);
        l0.h(r16.getMarketingHiddenAnim(), Boolean.valueOf(r17));
        J1(true, r18, r14);
        return;
    L121:
        r38 = 0;
        goto L123
    L114:
        r35 = null;
    L127:
        if (this.H0.s() == false) goto L129;
        J1(false, r18, r14);
        return;
    L129:
        Pair<Long, ? extends d2> r39 = this.J;
        if (this.L0.s() == false) goto L132;
        UpdateTopViewSource r40 = r18;
    L133:
        t1(r13, r15, r16, r39, r17, r40);
        return;
    L132:
        r40 = null;
        goto L133
    L50:
        if (v.e() == false) goto L55;
        if (this.U.j() == true) goto L55;
        r19 = u.d(r11);
        goto L56
    L47:
        r11 = null;
        goto L48
    L20:
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.i(r14.getPrimaryEffectId()) == false) goto L22;
    L26:
        g0 r41 = this.T.q(r14.getId());
        if (r41 == null) goto L29;
        List<l1> r43 = r41.getGiftBuffInfos();
    L30:
        List<l1> r44 = r43;
        if (r44 != null) goto L33;
    L36:
        boolean r45 = true;
    L37:
        if (r45 == true) goto L44;
        if (nz1.a.h().c() == false) goto L41;
        l0.h(r16.getMode(), GiftTopViewState.Mode.BuffContainer);
    L42:
        l0.h(r16.getShowDetail(), Boolean.FALSE);
        l0.h(r16.getMarketingHiddenAnim(), Boolean.valueOf(r17));
        J1(true, r18, r14);
        return;
    L41:
        l0.h(r16.getMode(), GiftTopViewState.Mode.BuffCard);
        goto L42
    L33:
        if (r44.isEmpty() == true) goto L36;
        r45 = false;
        goto L37
    L29:
        r43 = null;
        goto L30
    L22:
        if (a0.c() == true) goto L26;
        if (this.C.getEnable() == true) goto L26;
        if (r8 == false) goto L44;
    L12:
        if (nz1.a.h().d() == false) goto L14;
        l0.h(r16.getMode(), GiftTopViewState.Mode.DIYContainer);
    L15:
        l0.h(r16.getShowDetail(), Boolean.FALSE);
        l0.h(r16.getMarketingHiddenAnim(), Boolean.valueOf(r17));
        J1(true, r18, r14);
        return;
    L14:
        l0.h(r16.getMode(), GiftTopViewState.Mode.DIY);
        goto L15
    L8:
        r6 = null;
        goto L10
    }

    public final void t1(l0<GiftTopViewState> r17, GiftTabViewState r18, GiftTopViewState r19, Pair<Long, ? extends d2> r20, boolean r21, UpdateTopViewSource r23) {
        if (this.H0.s() == false) goto L5;
        return;
    L5:
        UpdateTopViewSource r5 = null;
        if (r18 == null) goto L8;
        r0<GiftTabViewState, Integer> r6 = r18.getTabType();
        r17.getClass();
        int r7 = ((Number) com.bytedance.android.anya.h.b(r6)).intValue();
        boolean r8 = com.bytedance.android.live.revenue.core.util.f.a(l01.d.class).isLogin();
        r0<GiftTopViewState, Boolean> r9 = r19.getShowDetail();
        Boolean r10 = Boolean.FALSE;
        l0.h(r9, r10);
        l0.h(r19.getMarketingHiddenAnim(), Boolean.valueOf(r21));
        l0.h(r19.getVisibility(), Boolean.TRUE);
        int r11 = 0;
        boolean r13 = true;
        String r14 = BuildConfig.FLAVOR;
        if (r7 != 2) goto L36;
        if (r8 == true) goto L18;
    L32:
        if (r8 == false) goto L34;
        l0.h(r19.getMode(), GiftTopViewState.Mode.LynxGrowthTouch);
        l0.h(r19.getShowDetail(), Boolean.valueOf(this.A));
    L131:
        if (r13 == true) goto L133;
    L136:
        E1("changeStateMode", GiftTopContractKt.simpleStateString(r17, r19));
        return;
    L133:
        if (this.L0.s() == false) goto L135;
        r5 = r23;
    L135:
        w1(r5);
        goto L136
    L34:
        r13 = K1(r17, r19, r21, r18);
        goto L131
    L18:
        if (V1(r7) == false) goto L32;
        IBaseUser r2 = (IBaseUser) this.Q.get("data_user_in_room", null);
        GiftTopViewState.Mode r4 = (GiftTopViewState.Mode) com.bytedance.android.anya.h.b(r19.getMode());
        GiftTopViewState.Mode r15 = GiftTopViewState.Mode.FansClub;
        if (r4 == r15) goto L31;
        u1 r16 = this.S;
        if (r2 == null) goto L27;
        String r3 = r2.getIdString();
        if (r3 == null) goto L27;
        r14 = r3;
    L27:
        com.bytedance.android.live.profit.fansclub.o r24 = yt0.c.c();
        if (r24 == null) goto L30;
        r11 = r24.R2();
    L30:
        r16.Y(r14, r11);
    L31:
        l0.h(r19.getMode(), r15);
        goto L131
    L36:
        if (r7 != 23) goto L45;
        x1 r25 = this.X.n();
        if (r25 != null) goto L40;
    L44:
        l0.h(r19.getMode(), GiftTopViewState.Mode.Activity);
        l0.h(r19.getShowDetail(), r10);
        goto L131
    L40:
        if (r25.getTopBarAction() == GiftTouchAction.Hide.getValue()) goto L44;
        if (nz1.a.b().a() == false) goto L44;
        l0.h(r19.getMode(), GiftTopViewState.Mode.Carnival);
        goto L131
    L45:
        if (r20 == null) goto L60;
        Long r110 = (Long) r20.getFirst();
        if (r110 == null) goto L60;
        if (r7 != ((int) r110.longValue())) goto L60;
        d2 r111 = (d2) r20.getSecond();
        if (r111 == null) goto L53;
        x2 r112 = r111.getPageInfo();
    L54:
        if (r112 == null) goto L60;
        k0 r26 = r17.b;
        r0<GiftTopViewState, GiftTopViewState.Mode> r27 = r19.getMode();
        r26.getClass();
        GiftTopViewState.Mode r28 = (GiftTopViewState.Mode) com.bytedance.android.anya.h.b(r27);
        l0.h(r19.getMode(), GiftTopViewState.Mode.Activity);
        l0.h(r19.getShowDetail(), r10);
        d2 r29 = (d2) r20.getSecond();
        if (r29 == null) goto L58;
        x2 r30 = r29.getPageInfo();
    L59:
        C1(r30, r28);
        goto L131
    L58:
        r30 = null;
        goto L59
    L53:
        r112 = null;
    L60:
        Iterator<T> r31 = this.W.b.a.iterator();
    L62:
        if (r31.hasNext() == false) goto L69;
        Object r113 = r31.next();
        if (((com.bytedance.android.livesdk.gift.platform.core.giftlist.j) r113).a != r7) goto L66;
        boolean r114 = true;
    L67:
        if (r114 == false) goto L62;
    L70:
        com.bytedance.android.livesdk.gift.platform.core.giftlist.j r115 = (com.bytedance.android.livesdk.gift.platform.core.giftlist.j) r113;
        if (r115 == null) goto L73;
        x2 r33 = r115.i;
    L74:
        if (r33 == null) goto L76;
        boolean r34 = true;
    L77:
        if (r34 == false) goto L94;
        k0 r35 = r17.b;
        r0<GiftTopViewState, GiftTopViewState.Mode> r36 = r19.getMode();
        r35.getClass();
        GiftTopViewState.Mode r37 = (GiftTopViewState.Mode) com.bytedance.android.anya.h.b(r36);
        l0.h(r19.getMode(), GiftTopViewState.Mode.Activity);
        l0.h(r19.getShowDetail(), Boolean.FALSE);
        Iterator<T> r38 = this.W.b.a.iterator();
    L80:
        if (r38.hasNext() == false) goto L87;
        Object r39 = r38.next();
        if (((com.bytedance.android.livesdk.gift.platform.core.giftlist.j) r39).a != r7) goto L84;
        boolean r40 = true;
    L85:
        if (r40 == false) goto L80;
    L88:
        com.bytedance.android.livesdk.gift.platform.core.giftlist.j r41 = (com.bytedance.android.livesdk.gift.platform.core.giftlist.j) r39;
        if (r41 == null) goto L91;
        x2 r43 = r41.i;
    L92:
        C1(r43, r37);
        goto L131
    L91:
        r43 = null;
        goto L92
    L84:
        r40 = false;
        goto L85
    L87:
        r39 = null;
        goto L88
    L94:
        if (v.e() == true) goto L96;
    L112:
        if (r8 == true) goto L114;
        if (r8 == true) goto L119;
    L130:
        r13 = K1(r17, r19, r21, r18);
        goto L131
    L119:
        if (V1(r7) == false) goto L130;
        l0.h(r19.getMode(), GiftTopViewState.Mode.FansClub);
        IBaseUser r44 = (IBaseUser) this.Q.get("data_user_in_room", null);
        u1 r45 = this.S;
        if (r44 == null) goto L126;
        String r46 = r44.getIdString();
        if (r46 == null) goto L126;
        r14 = r46;
    L126:
        com.bytedance.android.live.profit.fansclub.o r47 = yt0.c.c();
        if (r47 == null) goto L129;
        r11 = r47.R2();
    L129:
        r45.Y(r14, r11);
        goto L131
    L114:
        if (v.e() == false) goto L116;
        r13 = K1(r17, r19, r21, r18);
        goto L131
    L116:
        l0.h(r19.getMode(), GiftTopViewState.Mode.LynxGrowthTouch);
        l0.h(r19.getShowDetail(), Boolean.valueOf(this.A));
        goto L131
    L96:
        if (((Number) com.bytedance.android.anya.h.b(r18.getTabType())).intValue() == 3) goto L112;
        if (((Number) com.bytedance.android.anya.h.b(r18.getTabType())).intValue() != 5) goto L106;
        if (z1() == false) goto L112;
        if (this.H == true) goto L112;
        if (B1(((Number) com.bytedance.android.anya.h.b(r18.getTabType())).intValue()) == true) goto L112;
    L106:
        if (((Number) com.bytedance.android.anya.h.b(r18.getTabType())).intValue() == 17) goto L108;
    L111:
        l0.h(r19.getMode(), GiftTopViewState.Mode.Collection);
        l0.h(r19.getShowDetail(), Boolean.FALSE);
        l0.h(r19.getMarketingHiddenAnim(), Boolean.valueOf(r21));
        goto L131
    L108:
        if (this.L0.s() == false) goto L111;
        if (this.L0.y() == true) goto L112;
    L76:
        r34 = false;
        goto L77
    L73:
        r33 = null;
        goto L74
    L66:
        r114 = false;
        goto L67
    L69:
        r113 = null;
        goto L70
    L8:
        if (K1(r17, r19, r21, r18) == true) goto L10;
        return;
    L10:
        if (this.L0.s() == false) goto L12;
        r5 = r23;
    L12:
        w1(r5);
    }

    public final void A1(l0<GiftTopViewState> r34, GiftListBusinessState.GiftSelected r35, GiftTopViewState r36, GiftTabViewState r37, int r38, UpdateTopViewSource r39, boolean r40) {
        vz1.e r0 = r35.getIconModel();
        if (r0 != null) goto L6;
        r0 = new vz1.e((h1) vh7.f.c(h1.class), 0, null, 0, false, false, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, 67108862);
    L6:
        if (r35.getSelectedStatus() == SelectedStatus.GROUP) goto L8;
    L50:
        d2(r34, r0.a, r37, r36, false, r39);
        E1("handleSelected", GiftTopContractKt.simpleStateString(r34, r36));
        return;
    L8:
        if (this.L0.s() == true) goto L14;
        if (t1.a(r0.a) == false) goto L50;
        if (r0.a.getType() == 5) goto L50;
    L14:
        if (v.e() == false) goto L45;
        r0<GiftTopViewState, Boolean> r1 = r36.getVisibility();
        Boolean r3 = Boolean.TRUE;
        r34.getClass();
        l0.h(r1, r3);
        if (v.e() == false) goto L18;
        l0.h(r36.getMode(), GiftTopViewState.Mode.Group);
    L19:
        u1 r2 = this.S;
        long r4 = r0.a.getId();
        int r5 = r35.getSelectedPosition();
        int r6 = r35.getSelectedPagePosition();
        boolean r8 = false;
        if (r37 == null) goto L24;
        r0<GiftTabViewState, Integer> r9 = r37.getTabType();
        if (r9 == null) goto L24;
        int r10 = ((Integer) com.bytedance.android.anya.h.b(r9)).intValue();
    L25:
        r2.getClass();
        LinkedHashMap r11 = new LinkedHashMap();
        r11.put("gift_id", String.valueOf(r4));
        GiftContext r7 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r7 == null) goto L31;
        com.bytedance.live.datacontext.m<String> r13 = r7.getGiftListResultLogId();
        if (r13 == null) goto L31;
        String r14 = (String) r13.getValue();
        if (r14 == null) goto L31;
    L32:
        r11.put("gift_dialog_request_id", r14);
        r11.put("tab_location", String.valueOf(r6 + 1));
        int r15 = 8;
        int r16 = (r5 + 1) % 8;
        if (r16 == 0) goto L36;
        r8 = true;
    L36:
        int[] r17 = r2.e;
        if (r8 == false) goto L40;
        r15 = r16;
    L40:
        r11.put("gift_location", String.valueOf(r17[r15]));
        r11.put("tab_name", ((e1) com.bytedance.android.live.revenue.core.util.f.a(e1.class)).F5(r10));
        r2.p1("livesdk_giftgroup_show", r11, true);
        if (z1() == false) goto L43;
    L44:
        J1(true, r39, this.K);
    L48:
        r0<GiftTopViewState, Boolean> r18 = r36.getShowDetail();
        Boolean r19 = Boolean.FALSE;
        r34.getClass();
        l0.h(r18, r19);
        return;
    L43:
        if (this.H0.s() == false) goto L48;
    L31:
        r14 = BuildConfig.FLAVOR;
    L24:
        r10 = 0;
        goto L25
    L18:
        l0.h(r36.getMode(), GiftTopViewState.Mode.GroupContainer);
        goto L19
    L45:
        r0<GiftTopViewState, GiftTopViewState.Mode> r20 = r36.getMode();
        GiftTopViewState.Mode r21 = GiftTopViewState.Mode.Group;
        r34.getClass();
        l0.h(r20, r21);
        if (this.H0.s() == false) goto L48;
        J1(true, r39, this.K);
        goto L48
    }

    public static /* synthetic */ void f2(GiftMVITopViewModel r7, l0 r8, h1 r9, GiftTabViewState r10, GiftTopViewState r11, boolean r13, int r14, UpdateTopViewSource r15) {
        r7.d2(r8, r9, r10, r11, r13, r15);
    }

    public GiftMVITopViewModel(e33.a r17, DataCenter r18, OpenDialogService r19, u1 r20, e1 r21, GiftExtraRepo r23, d0 r24, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.a r25, com.bytedance.android.livesdk.gift.platform.core.giftlist.h r26, GiftListRepository r27, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.f r28, GiftMVICarnivalDataStore r29, GiftListSortDataStore r210, GiftTopicDataStore r30, GiftScrollDataStore r31, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f r33, GiftSearchDataStore r34, GiftMostlyUsedDataStore r35, PropListService r36) {
        Intrinsics.checkNotNullParameter(r17, "topViewModels");
        Intrinsics.checkNotNullParameter(r18, "dataCenter");
        Intrinsics.checkNotNullParameter(r19, "dialogService");
        Intrinsics.checkNotNullParameter(r20, "giftPanelLogService");
        Intrinsics.checkNotNullParameter(r21, "giftListService");
        Intrinsics.checkNotNullParameter(r23, "giftExtraRepo");
        Intrinsics.checkNotNullParameter(r24, "giftPanelListTempRepo");
        Intrinsics.checkNotNullParameter(r25, "giftAllMicService");
        Intrinsics.checkNotNullParameter(r26, "giftListPanelRepository");
        Intrinsics.checkNotNullParameter(r27, "giftListRepository");
        Intrinsics.checkNotNullParameter(r28, "giftDiyDataStore");
        Intrinsics.checkNotNullParameter(r29, "giftMVICarnivalDataStore");
        Intrinsics.checkNotNullParameter(r210, "listSortDataStore");
        Intrinsics.checkNotNullParameter(r30, "giftTopicDataStore");
        Intrinsics.checkNotNullParameter(r31, "giftScrollDataStore");
        Intrinsics.checkNotNullParameter(r33, "receiverService");
        Intrinsics.checkNotNullParameter(r34, "giftSearchDataStore");
        Intrinsics.checkNotNullParameter(r35, "giftMostlyUsedDataStore");
        Intrinsics.checkNotNullParameter(r36, "propListService");
        super(r17);
        this.Q = r18;
        this.R = r19;
        this.S = r20;
        this.T = r23;
        this.U = r25;
        this.V = r26;
        this.W = r27;
        this.X = r29;
        this.Y = r210;
        this.Z = r30;
        this.k0 = r31;
        this.p0 = r33;
        this.H0 = r34;
        this.L0 = r35;
        this.P0 = r36;
        this.z = "ttlive_gift_panel_top";
        boolean r2 = true;
        this.A = !v.e();
        this.B = SetsKt.setOf(new BaseMVIDataStore[]{r23, r30, r31, r34, r35});
        this.C = com.bytedance.android.livesdk.gift.platform.business.i.m();
        this.D = BuildConfig.FLAVOR;
        this.E = LazyKt.lazy(GiftMVITopViewModel$enableScrollAnimationOpt$2.INSTANCE);
        this.N = new HashMap();
        this.O = true;
        com.bytedance.android.live.profit.fansclub.o r1 = yt0.c.c();
        if (r1 != null) goto L5;
    L7:
        r2 = false;
    L8:
        this.P = r2;
        return;
    L5:
        if (r1.R2() != FansClubUserStatus.Inactive.getValue()) goto L7;
        goto L7
    }
}
