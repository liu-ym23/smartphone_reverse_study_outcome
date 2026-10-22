package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.viewModel.topViewModel;

import android.text.TextUtils;
import com.bytedance.android.anya.BaseMVIDataStore;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.dsl.h;
import com.bytedance.android.anya.dsl.i;
import com.bytedance.android.anya.internal.t;
import com.bytedance.android.anya.internal.u;
import com.bytedance.android.anya.j0;
import com.bytedance.android.anya.k0;
import com.bytedance.android.anya.l0;
import com.bytedance.android.anya.p;
import com.bytedance.android.anya.r;
import com.bytedance.android.anya.r0;
import com.bytedance.android.anya.s0;
import com.bytedance.android.anya.t0;
import com.bytedance.android.anya.v;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.livesdk.chatroom.event.LocateGiftInfo;
import com.bytedance.android.livesdk.gift.model.CardLockInfo;
import com.bytedance.android.livesdk.gift.model.IGiftMarketingInfo;
import com.bytedance.android.livesdk.gift.model.e3;
import com.bytedance.android.livesdk.gift.model.g0;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.n;
import com.bytedance.android.livesdk.gift.model.o;
import com.bytedance.android.livesdk.gift.model.q;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datalayer.GiftMVIMarketingUseCase;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.GiftDialogStateDataStore;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.GiftExtraRepo;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ClickCustomDIYButton;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.DIYCardSelectType;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftDIYCardBusinessState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftDIYCardItem;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftDIYViewState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftListBusinessState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftPanelState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftTopViewState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftVerticalState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.OnLocateGiftRequestReceived;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.PagerListData;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.viewModel.l;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.AssetDownloadPriority;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.gift.platform.core.d0;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.AssetsService;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.g1;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.m0;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.u1;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.common.utility.Lists;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import yz0.k;
import zz0.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftMVIDIYTopViewModel extends com.bytedance.android.anya.f<GiftTopViewState, GiftDIYViewState, GiftAction> implements l<GiftDIYViewState, GiftAction> {
    public final ArrayList<n> A;
    public final u1 B;
    public final g1 C;
    public final AssetsService D;
    public final DataCenter E;
    public final k F;
    public final LocateGiftInfo G;
    public final GiftExtraRepo H;
    public final m0 I;
    public final com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f J;
    public final GiftMVIMarketingUseCase K;
    public final GiftDialogStateDataStore L;
    public long u;
    public h1 v;
    public String w;
    public final com.bytedance.android.livesdk.gift.platform.business.config.a x;
    public int y;
    public final Set<BaseMVIDataStore<?>> z;

    public final void onStart() {
    }

    public final void onStop() {
    }

    public final boolean z1() {
        if ((this.v.getReqExtraType() & 2) != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public final Set<BaseMVIDataStore<?>> I() {
        return this.z;
    }

    public static List x1(ArrayList r3) {
        ArrayList r0 = new ArrayList();
        Iterator r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        r0.add(Integer.valueOf((int) ((e3) r4.next()).getPluginId()));
        goto L4
    L6:
        return r0;
    }

    public final boolean A1(n r6) {
        int r0 = this.A.size();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L11;
        if (gz1.c.h(gz1.c.g((n) ListProtector.get(this.A, r2)), gz1.c.g(r6)) == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return true;
    L11:
        return false;
    }

    public final boolean B1(n r9) {
        if (r9.getCardType() != 1) goto L5;
        String r0 = this.J.a.getIdString();
    L6:
        ArrayList<e3> r3 = gz1.c.g(r9);
        String r4 = r9.getCardName();
        if (r4 != null) goto L9;
        r4 = BuildConfig.FLAVOR;
    L9:
        String r1 = gz1.c.f(r3, r4, r0);
        long r5 = r9.getUpdateTime();
        String r2 = (String) ((HashMap) ay1.b.n0.getValue(null, ay1.b.a[77])).get(r1);
        if (r2 != null) goto L13;
        r2 = "0";
    L13:
        if (r5 < CastLongProtector.parseLong(r2)) goto L15;
        boolean r6 = true;
    L17:
        if (r9.getShowRemindDot() == false) goto L20;
        if (r6 == false) goto L20;
        return true;
    L20:
        return false;
    L15:
        r6 = false;
        goto L17
    L5:
        r0 = null;
        goto L6
    }

    public final MVIState F(l0 r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$createState");
        return new GiftDIYViewState();
    }

    public final void J1(n r8) {
        if (r8.getCardType() != 1) goto L5;
        String r0 = this.J.a.getIdString();
    L6:
        ArrayList<e3> r1 = gz1.c.g(r8);
        String r9 = r8.getCardName();
        if (r9 != null) goto L9;
        r9 = BuildConfig.FLAVOR;
    L9:
        String r10 = gz1.c.f(r1, r9, r0);
        long r2 = System.currentTimeMillis() / ((long) IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW);
        com.bytedance.tools.kcp.spongepreference.runtime.a r3 = ay1.b.n0;
        KProperty[] r4 = ay1.b.a;
        HashMap r6 = (HashMap) r3.getValue(null, r4[77]);
        r6.put(r10, String.valueOf(r2));
        Intrinsics.checkNotNullParameter(r6, "<set-?>");
        r3.setValue(null, r4[77], r6);
        return;
    L5:
        r0 = null;
        goto L6
    }

    public final void d(h<GiftTopViewState, GiftAction> r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$bindToParent");
        GiftMVIDIYTopViewModel$bindToParent$1 r0 = GiftMVIDIYTopViewModel$bindToParent$1.INSTANCE;
        List r5 = r4.a;
        ArrayList r6 = (ArrayList) r5;
        r6.add(new i(this, r0, GiftAction.class));
    }

    public final void q(com.bytedance.android.anya.dsl.l<GiftDIYViewState, r, GiftAction> r5) {
        Intrinsics.checkNotNullParameter(r5, "$this$buildStateMachine");
        Function1<com.bytedance.android.anya.dsl.l<GiftDIYViewState, r, GiftAction>.a<GiftDIYCardBusinessState.Idle>, Unit> r0 = new GiftMVIDIYTopViewModel$buildStateMachine$1(this);
        LinkedHashMap r1 = r5.a;
        com.bytedance.android.anya.dsl.l.a r3 = new com.bytedance.android.anya.dsl.l.a();
        r0.invoke(r3);
        r1.put(GiftDIYCardBusinessState.Idle.class, r3.a);
        Function1<com.bytedance.android.anya.dsl.l<GiftDIYViewState, r, GiftAction>.a<GiftDIYCardBusinessState.DIYSelected>, Unit> r2 = new GiftMVIDIYTopViewModel$buildStateMachine$2(this);
        LinkedHashMap r6 = r5.a;
        com.bytedance.android.anya.dsl.l.a r4 = new com.bytedance.android.anya.dsl.l.a();
        r2.invoke(r4);
        r6.put(GiftDIYCardBusinessState.DIYSelected.class, r4.a);
    }

    public final Map<String, String> w1(n r6) {
        LinkedHashMap r0 = new LinkedHashMap();
        boolean r1 = this.F.isAnchor();
        CardLockInfo r2 = r6.getLockInfo();
        if (r2 == null) goto L5;
        int r3 = r2.getLockStatus();
    L6:
        r0.put("card_lock_status", String.valueOf(r3));
        String r4 = "1";
        if (r1 == false) goto L9;
        Object r5 = "1";
    L10:
        r0.put("is_anchor", r5);
        if (B1(r6) == true) goto L14;
        r4 = "0";
    L14:
        r0.put("whether_mark", r4);
        return r0;
    L9:
        r5 = "0";
        goto L10
    L5:
        r3 = 0;
        goto L6
    }

    public final void J0(com.bytedance.android.anya.internal.e r4, MVIState r5) {
        final GiftDIYViewState r6 = (GiftDIYViewState) r5;
        Intrinsics.checkNotNullParameter(r4, "$this$reduce");
        Intrinsics.checkNotNullParameter(r6, "state");
        r4.d(this.L.o(), this.K.k(), new GiftMVIDIYTopViewModel$reduce$1(this, r6));
    }

    public final void u1(l0<GiftDIYViewState> r9, GiftDIYViewState r10) {
        u r0 = r10.getDiyCardList();
        Iterator r1 = ((Iterable) r0.c()).iterator();
        int r2 = 0;
    L4:
        if (r1.hasNext() == false) goto L19;
        Object r3 = r1.next();
        int r4 = r2 + 1;
        if (r2 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        MVIState r5 = (MVIState) r3;
        new k0.a();     // Catch: Throwable -> L14
        GiftDIYCardItem r6 = (GiftDIYCardItem) r5;     // Catch: Throwable -> L14
        r6.getSelected().a(Boolean.FALSE);     // Catch: Throwable -> L14
        r6.getSelectType().a(DIYCardSelectType.IDLE);     // Catch: Throwable -> L14
        if ((!r5.modifiedProperties.isEmpty()) == false) goto L13;
        ((t) r0.c()).d(r2);
    L13:
        r2 = r4;
    L14:
        th = move-exception;
        if ((!r5.modifiedProperties.isEmpty()) == false) goto L18;
        ((t) r0.c()).d(r2);
    L18:
        throw th;
    L19:
        this.w = BuildConfig.FLAVOR;
        r0<GiftDIYViewState, Integer> r11 = r10.getSelectedPosition();
        r9.getClass();
        l0.h(r11, -1);
        this.C.f(-1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean t1(sz1.a r6, ArrayList<n> r7, ArrayList<n> r8) {
        int r0 = r8.size();
        boolean r1 = false;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L19;
        if (gz1.c.h(gz1.c.g(r6), gz1.c.g((n) ListProtector.get(r8, r2))) == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        r1 = true;
        if (r6.isRecommend() == false) goto L17;
        n r9 = (n) ListProtector.get(r8, r2);
        Intrinsics.checkNotNullParameter(r9, "card");
        if ((!r9.getNotCache()) == false) goto L17;
        n r10 = (n) ListProtector.get(r8, r2);
        if (TextUtils.isEmpty(((n) ListProtector.get(r8, r2)).getMainTextAfterSend()) == true) goto L15;
        String r3 = ((n) ListProtector.get(r8, r2)).getMainTextAfterSend();
        if (r3 != null) goto L16;
        r3 = s1.B(2131916247);
    L16:
        r10.setMainText(r3);
        goto L17
    L15:
        r3 = s1.B(2131916247);
    L17:
        r7.add(ListProtector.get(r8, r2));
    L20:
        if (r2 >= 0) goto L22;
    L24:
        return r1;
    L22:
        if (r2 >= r8.size()) goto L24;
        ListProtector.remove(r8, r2);
        goto L24
    L19:
        r2 = -1;
        goto L20
    }

    public final void w0(j0 r11, MVIState r13, p r14) {
        GiftDIYViewState r3 = (GiftDIYViewState) r13;
        GiftAction r15 = (GiftAction) r14;
        Intrinsics.checkNotNullParameter(r11, "$this$postReduce");
        Intrinsics.checkNotNullParameter(r3, "state");
        Intrinsics.checkNotNullParameter(r15, "action");
        if (nz1.a.h().d() == true) goto L107;
        com.bytedance.android.livesdk.gift.model.p r0 = null;
        if ((r15 instanceof ClickCustomDIYButton) == false) goto L70;
        h1 r16 = (h1) vh7.f.c(h1.class);
        IBaseUser r4 = vh7.f.c(IBaseUser.class);
        com.bytedance.android.anya.internal.p r5 = r11.getContext();
        Object r6 = 0;
        com.bytedance.android.anya.internal.c r7 = (v) r5.a(r5.b(r5.c(GiftPanelState.class), GiftMVIDIYTopViewModel$handleClickCustomButton$1$wrapped$1.INSTANCE), GiftMVIDIYTopViewModel$handleClickCustomButton$1$wrapped$2.INSTANCE).a.invoke();
        if (r7 == null) goto L27;
        com.bytedance.android.anya.internal.c r8 = r7;
        Object r9 = r7.c();     // Catch: Throwable -> L67
        int r10 = r7.c;     // Catch: Throwable -> L67
        Object r17 = ((LinkedHashMap) r11.d).get(r7);     // Catch: Throwable -> L67
        if (r17 == null) goto L16;
        r6 = r17;
    L16:
        if (r10 <= ((Number) r6).intValue()) goto L18;
        boolean r18 = true;
    L19:
        k0 r19 = j0.a.a;     // Catch: Throwable -> L67
        r19.getClass();     // Catch: Throwable -> L67
        r r20 = ((GiftVerticalState) r9).toBusinessState(r19);     // Catch: Throwable -> L67
        if ((r20 instanceof GiftListBusinessState.GiftSelected) == true) goto L22;
    L24:
        if (r18 == false) goto L26;
        r11.a();     // Catch: Throwable -> L67
    L26:
        r11.c.put(r7, Integer.valueOf(r8.c));
        goto L27
    L22:
        if (((GiftListBusinessState.GiftSelected) r20).getIconModel() == null) goto L24;
        r16 = ((GiftListBusinessState.GiftSelected) r20).getIconModel().a;     // Catch: Throwable -> L67
        goto L24
    L18:
        r18 = false;
    L67:
        th = move-exception;
        r11.c.put(r7, Integer.valueOf(r8.c));
        throw th;
    L27:
        IBaseUser r21 = this.J.a;
        if (j0.a.a == null) goto L66;
        String r23 = (String) com.bytedance.android.anya.h.b(r3.getSchema());
        DataCenter r24 = this.E;
        Boolean r25 = Boolean.TRUE;
        if ((!Intrinsics.areEqual((Boolean) r24.get("data_is_portrait", r25), r25)) == false) goto L32;
        ToastUtil.a(2131916246, 0);
    L37:
        g0 r26 = this.H.q(r16.getId());
        if (r26 == null) goto L40;
        com.bytedance.android.livesdk.gift.model.p r27 = r26.getDiyGiftToolbarInfo();
    L41:
        LinkedHashMap r28 = new LinkedHashMap();
        if (r27 == null) goto L61;
        q r29 = r27.getButton();
        if (r29 == null) goto L61;
        if (r29.getLocked() == false) goto L48;
        r28.put("entrance_status", "locked");
    L49:
        q r30 = r27.getButton();
        if (r30 == null) goto L55;
        a5 r31 = r30.getText();
        if (r31 == null) goto L55;
        String r33 = r31.getDefaultPattern();
        if (r33 == null) goto L55;
    L56:
        r28.put("show_info", r33);
        if (this.F.isAnchor() != true) goto L59;
        String r34 = "1";
    L60:
        r28.put("is_anchor", r34);
        goto L61
    L59:
        r34 = "0";
    L55:
        r33 = BuildConfig.FLAVOR;
        goto L56
    L48:
        r28.put("entrance_status", q.UNLOCKED);
    L61:
        u1 r35 = this.B;
        long r36 = r16.getId();
        r35.getClass();
        LinkedHashMap r110 = new LinkedHashMap();
        r110.putAll(r28);
        r110.put("gift_id", String.valueOf(r36));
        r110.put("user_id", com.bytedance.android.live.revenue.core.util.f.a(l01.d.class).getCurrentUserId());
        IRoom r37 = r35.o.getRoom();
        String r38 = r37.getAnchorId();
        if (r38 != null) goto L64;
        r38 = BuildConfig.FLAVOR;
    L64:
        r110.put("anchor_id", r38);
        r110.put("room_id", String.valueOf(r37.getRoomId()));
        r35.q(r110);
        r35.p1("customize_entrance_click", r110, true);
        goto L70
    L40:
        r27 = null;
        goto L41
    L32:
        ArrayList r39 = new ArrayList();
        List r40 = r16.getAssetIds();
        if (r40 == null) goto L35;
        List r41 = r40;
    L36:
        r39.addAll(r41);
        com.bytedance.android.livesdk.gift.platform.business.effect.assets.k.a(this.D, r39, new b(r23, this, r16, r21), 3, AssetDownloadPriority.OPEN_DIY_PAGE);
        goto L37
    L35:
        r41 = new ArrayList();
        goto L36
    L66:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.android.anya.ReadOnlyStateContext<STATE, *>");
    L70:
        com.bytedance.android.anya.internal.p r111 = r11.getContext();
        com.bytedance.android.anya.internal.c r112 = (v) r111.a(r111.b(r111.c(GiftPanelState.class), GiftMVIDIYTopViewModel$postReduce$1$wrapped$1.INSTANCE), GiftMVIDIYTopViewModel$postReduce$1$wrapped$2.INSTANCE).a.invoke();
        if (r112 == null) goto L108;
        com.bytedance.android.anya.internal.c r43 = r112;
        Object r44 = r112.c();     // Catch: Throwable -> L100
        int r45 = r112.c;     // Catch: Throwable -> L100
        Object r46 = ((LinkedHashMap) r11.d).get(r112);     // Catch: Throwable -> L100
        if (r46 != null) goto L78;
        r46 = 0;     // Catch: Throwable -> L100
    L78:
        if (r45 <= ((Number) r46).intValue()) goto L80;
        boolean r47 = true;
    L81:
        if (r47 == false) goto L96;
        k0 r1 = j0.a.a;     // Catch: Throwable -> L100
        GiftVerticalState r48 = (GiftVerticalState) r44;     // Catch: Throwable -> L100
        r1.getClass();     // Catch: Throwable -> L100
        r r2 = r48.toBusinessState(r1);     // Catch: Throwable -> L100
        if ((r2 instanceof GiftListBusinessState.GiftSelected) == true) goto L85;
    L95:
        GiftDIYViewState r49 = (GiftDIYViewState) r11.g.f();     // Catch: Throwable -> L100
        l0.h(r3.getSchema(), BuildConfig.FLAVOR);     // Catch: Throwable -> L100
        l0.d(r3.getDiyCardList());     // Catch: Throwable -> L100
        l0.h(r3.getOriginId(), 0L);     // Catch: Throwable -> L100
        l0.h(r3.getButtonText(), vh7.f.c(a5.class));     // Catch: Throwable -> L100
        l0.h(r3.getButtonVisibility(), Boolean.FALSE);     // Catch: Throwable -> L100
        l0.h(r3.getSelectedPosition(), -1);     // Catch: Throwable -> L100
        this.u = -1;     // Catch: Throwable -> L100
        this.y = -1;     // Catch: Throwable -> L100
        goto L96
    L85:
        if (((GiftListBusinessState.GiftSelected) r2).getIconModel() == null) goto L95;
        this.y = ((Number) com.bytedance.android.anya.h.b(((PagerListData) k0.d(r48.getPanelList(), ((GiftListBusinessState.GiftSelected) r2).getSelectedPagePosition())).getTabType())).intValue();     // Catch: Throwable -> L100
        l0<GiftDIYViewState> r113 = r11.g;     // Catch: Throwable -> L100
        GiftDIYViewState r50 = (GiftDIYViewState) r113.f();     // Catch: Throwable -> L100
        h1 r51 = ((GiftListBusinessState.GiftSelected) r2).getIconModel().a;     // Catch: Throwable -> L100
        if (this.u == r51.getId()) goto L96;
        this.u = r51.getId();     // Catch: Throwable -> L100
        l0.h(r3.getOriginId(), Long.valueOf(r51.getId()));     // Catch: Throwable -> L100
        this.v = r51;     // Catch: Throwable -> L100
        g0 r53 = this.H.q(r51.getId());     // Catch: Throwable -> L100
        if (r53 == null) goto L92;
        r0 = r53.getDiyGiftToolbarInfo();     // Catch: Throwable -> L100
    L92:
        com.bytedance.android.livesdk.gift.model.p r54 = r0;
        if (r54 == null) goto L96;
        C1(r113, r51, r3, r54, false);     // Catch: Throwable -> L100
    L96:
        if (r47 == false) goto L98;
        r11.a();     // Catch: Throwable -> L100
    L98:
        r11.c.put(r112, Integer.valueOf(r43.c));
        return;
    L80:
        r47 = false;
    L100:
        th = move-exception;
        r11.c.put(r112, Integer.valueOf(r43.c));
        throw th;
    L108:
        return;
    }

    public static final void e1(GiftMVIDIYTopViewModel r6, l0 r7, OnLocateGiftRequestReceived r8, GiftDIYViewState r9) {
        r6.getClass();
        if (r8.getLocateGiftInfo().getTargetGiftId() != r6.v.getId()) goto L33;
        k0 r0 = r7.b;
        t0<GiftDIYViewState, GiftDIYCardItem> r1 = r9.getDiyCardList();
        r0.getClass();
        List r2 = k0.c(r1);
        String r10 = r8.getLocateGiftInfo().getCardName();
        Iterator r3 = r2.iterator();
        boolean r4 = false;
        int r5 = 0;
    L6:
        if (r3.hasNext() == false) goto L24;
        n r11 = (n) com.bytedance.android.anya.h.b(((GiftDIYCardItem) r3.next()).getDiyCardInfo());
        String r13 = r11.getCardName();
        if (r13 != null) goto L10;
    L13:
        boolean r14 = true;
    L14:
        if (r14 == false) goto L16;
    L20:
        boolean r15 = false;
    L21:
        if (r15 == true) goto L25;
        r5 = r5 + 1;
    L25:
        Integer r16 = Integer.valueOf(r5);
        if (r16.intValue() < 0) goto L28;
        r4 = true;
    L28:
        if (r4 == true) goto L31;
        r16 = null;
    L31:
        if (r16 == null) goto L37;
        int r17 = r16.intValue();
        r6.E1(r7, r9, r17, DIYCardSelectType.CARD_NAME_SELECT);
        l0.h(r9.getSelectedPosition(), Integer.valueOf(r17));
        return;
    L37:
        return;
    L16:
        if (Intrinsics.areEqual(r11.getCardName(), r10) == false) goto L20;
        if (gz1.a.c(r11) == false) goto L20;
        r15 = true;
        goto L21
    L10:
        if (r13.length() == 0) goto L13;
        r14 = false;
        goto L14
    L24:
        r5 = -1;
        goto L25
    L33:
        r6.w = r8.getLocateGiftInfo().getCardName();
    }

    public final void E1(l0<GiftDIYViewState> r5, GiftDIYViewState r6, int r7, DIYCardSelectType r8) {
        u1(r5, r6);
        u r9 = r6.getDiyCardList();
        MVIState r0 = (MVIState) ((s0) r9.c()).get(r7);
        new k0.a();     // Catch: Throwable -> L9
        GiftDIYCardItem r1 = (GiftDIYCardItem) r0;     // Catch: Throwable -> L9
        r1.getSelected().a(Boolean.TRUE);     // Catch: Throwable -> L9
        r1.getSelectType().a(r8);     // Catch: Throwable -> L9
        r1.getShowRemindDot().a(Boolean.FALSE);     // Catch: Throwable -> L9
        J1((n) r1.getDiyCardInfo().c());     // Catch: Throwable -> L9
        if ((!r0.modifiedProperties.isEmpty()) == false) goto L7;
        ((t) r9.c()).d(r7);
    L7:
        l0.h(r6.getSelectedPosition(), Integer.valueOf(r7));
        this.C.f(r8.ordinal());
        return;
    L9:
        th = move-exception;
        if ((!r0.modifiedProperties.isEmpty()) == false) goto L13;
        ((t) r9.c()).d(r7);
    L13:
        throw th;
    }

    public static final void h1(GiftMVIDIYTopViewModel r2, l0 r3, GiftDIYViewState r4, h1 r5, IGiftMarketingInfo r6) {
        r2.getClass();
        if (r5 == null) goto L23;
        if (r6 == null) goto L24;
        int r0 = com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.u.a;
        GiftExtraRepo r7 = r2.H;
        if (r7 == null) goto L8;
        g0 r8 = r7.q(r5.getId());
    L9:
        Intrinsics.checkNotNullParameter(r6, "$this$isMergeTypeDIY");
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.u.d(r6) == false) goto L18;
        if (r8 == null) goto L18;
        if (r6.getBuffMergeType() != IGiftMarketingInfo.BuffMergeType.Both.getValue()) goto L18;
        if (r8.getDiyGiftToolbarInfo() == null) goto L18;
        boolean r9 = true;
    L19:
        if (r9 == false) goto L21;
        Map r10 = com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.u.b(r5, r6);
        r0<GiftDIYViewState, Map<String, Object>> r11 = r4.getGiftMarketingInfo();
        r3.getClass();
        l0.h(r11, r10);
        return;
    L21:
        r0<GiftDIYViewState, Map<String, Object>> r13 = r4.getGiftMarketingInfo();
        Map r14 = MapsKt.emptyMap();
        r3.getClass();
        l0.h(r13, r14);
        return;
    L18:
        r9 = false;
        goto L19
    L8:
        r8 = null;
        goto L9
    L24:
        return;
    }

    public final void C1(l0<GiftDIYViewState> r31, h1 r33, GiftDIYViewState r34, com.bytedance.android.livesdk.gift.model.p r35, boolean r36) {
        q r0 = r35.getButton();
        if (r0 == null) goto L7;
        String r1 = r0.getSchema();
        if (r1 == null) goto L7;
        r0<GiftDIYViewState, String> r2 = r34.getSchema();
        r31.getClass();
        l0.h(r2, r1);
        Unit r3 = Unit.INSTANCE;
    L7:
        q r4 = r35.getButton();
        if (r4 == null) goto L12;
        a5 r5 = r4.getText();
        if (r5 == null) goto L12;
        r0<GiftDIYViewState, a5> r6 = r34.getButtonText();
        r31.getClass();
        l0.h(r6, r5);
        Unit r7 = Unit.INSTANCE;
    L12:
        q r8 = r35.getButton();
        if (r8 == null) goto L26;
        a5 r9 = r8.getText();
        if (r9 == null) goto L26;
        q r10 = r35.getButton();
        if (r10 == null) goto L19;
        String r11 = r10.getSchema();
    L21:
        if ((!TextUtils.isEmpty(r11)) == true) goto L24;
        r9 = null;
    L24:
        if (r9 == null) goto L26;
        r0<GiftDIYViewState, Boolean> r13 = r34.getButtonVisibility();
        Boolean r14 = Boolean.TRUE;
        r31.getClass();
        l0.h(r13, r14);
        Unit r15 = Unit.INSTANCE;
    L27:
        ArrayList r16 = new ArrayList();
        this.A.clear();
        ArrayList<n> r17 = new ArrayList();
        if (Lists.isEmpty(r35.getForceIndexCards()) == false) goto L30;
        ArrayList<n> r18 = new ArrayList();
    L31:
        ArrayList<n> r19 = r18;
        if (Lists.isEmpty(r35.getCards()) == false) goto L34;
        ArrayList<n> r20 = new ArrayList();
    L35:
        ArrayList<n> r110 = r20;
        this.A.addAll(r35.getForceIndexCards());
        this.A.addAll(r35.getCards());
        String r21 = String.valueOf(r33.getId());
        ArrayList<String> r23 = ay1.b.b().get(r21);
        if (r23 == null) goto L51;
        Iterator<n> r24 = this.A.iterator();
    L39:
        if (r24.hasNext() == false) goto L49;
        n r25 = r24.next();
        if (r25.getNotCache() == false) goto L39;
        int r26 = r23.size();
    L43:
        r26 = r26 - 1;
        if (r26 < 0) goto L39;
        sz1.a r27 = new sz1.a();
        r27.convertFromString((String) ListProtector.get(r23, r26));
        if (gz1.c.h(gz1.c.g(r27), gz1.c.g(r25)) == false) goto L43;
        ListProtector.remove(r23, r26);
    L49:
        if (r23.size() <= r35.getMaxLocalCardNumber()) goto L51;
        ListProtector.remove(r23, r23.size() - 1);
    L51:
        Single.create(new c(r23, r21)).subscribeOn(Schedulers.io()).subscribe(new com.bytedance.android.livesdk.user.h());
        if (r23 == null) goto L64;
        Iterator<T> r28 = r23.iterator();
    L55:
        if (r28.hasNext() == false) goto L64;
        String r29 = (String) r28.next();
        sz1.a r30 = new sz1.a();
        r30.convertFromString(r29);
        if (t1(r30, r17, r19) == true) goto L55;
        if (t1(r30, r17, r110) == true) goto L55;
        if (r30.isNewCard() == true) goto L62;
        this.I.c(gz1.c.g(r30), r33.getId(), true);
        goto L55
    L62:
        r17.add(r30);
    L64:
        s1(r35.getMaxTotalCardNumber(), r19, r33, r16, true, r36);
        s1(r35.getMaxTotalCardNumber() - r16.size(), r17, r33, r16, false, r36);
        s1(r35.getMaxTotalCardNumber() - r16.size(), r110, r33, r16, true, r36);
        ArrayList r37 = new ArrayList();
        if (r35.getForceIndexCards().size() <= 0) goto L67;
        n r38 = (n) ListProtector.get(r35.getForceIndexCards(), 0);
    L68:
        String r39 = this.G.getCardName();
        boolean r40 = TextUtils.isEmpty(r39);
        String r41 = BuildConfig.FLAVOR;
        if (r40 == true) goto L118;
        Iterator r43 = r16.iterator();
        int r44 = 0;
    L72:
        if (r43.hasNext() == false) goto L77;
        if (Intrinsics.areEqual(((n) r43.next()).getCardName(), r39) == true) goto L78;
        r44 = r44 + 1;
    L78:
        if (r44 != (-1)) goto L97;
        Iterator r45 = r16.iterator();
        int r46 = 0;
    L81:
        if (r45.hasNext() == false) goto L88;
        CardLockInfo r47 = ((n) r45.next()).getLockInfo();
        if (r47 == null) goto L87;
        if (r47.getLockStatus() != CardLockInfo.Companion.LockStatus.UNLOCKED.getV()) goto L87;
        r44 = r46;
    L87:
        r46 = r46 + 1;
    L88:
        String r48 = this.G.getJumpSchema();
        if (r48.length() <= 0) goto L91;
        boolean r49 = true;
    L92:
        if (r49 == true) goto L95;
        r48 = null;
    L95:
        if (r48 == null) goto L97;
        com.bytedance.android.live.revenue.core.util.f.a(g.class).S2(s1.getContext(), r48);
        goto L97
    L91:
        r49 = false;
    L97:
        Iterator r50 = r16.iterator();
        int r51 = 0;
    L99:
        if (r50.hasNext() == false) goto L109;
        n r53 = (n) r50.next();
        GiftDIYCardItem r54 = new GiftDIYCardItem();
        new k0.a();
        r54.getDiyCardInfo().a(r53);
        com.bytedance.android.anya.internal.c r55 = r54.getSelected();
        if (r51 != r44) goto L103;
        boolean r111 = true;
    L104:
        r55.a(Boolean.valueOf(r111));
        com.bytedance.android.anya.internal.c r56 = r54.getGiftIcon();
        py.k r112 = r33.getImage();
        Intrinsics.checkNotNull(r112);
        r56.a(r112);
        com.bytedance.android.anya.internal.c r57 = r54.getSelectType();
        if (r51 != r44) goto L107;
        DIYCardSelectType r113 = DIYCardSelectType.CARD_NAME_SELECT;
    L108:
        r57.a(r113);
        Unit r58 = Unit.INSTANCE;
        r37.add(r54);
        r51 = r51 + 1;
        goto L99
    L107:
        r113 = DIYCardSelectType.IDLE;
        goto L108
    L103:
        r111 = false;
        goto L104
    L109:
        if (r44 == (-1)) goto L266;
        g1 r59 = this.C;
        DIYCardSelectType r60 = DIYCardSelectType.CARD_NAME_SELECT;
        r59.f(r60.ordinal());
        n r61 = (n) ListProtector.get(r16, r44);
        if (z1() == false) goto L113;
        if (r36 == false) goto L266;
    L113:
        u1 r114 = this.B;
        long r115 = this.v.getId();
        int r116 = this.v.getDiamondCount();
        boolean r117 = A1(r61);
        long r210 = r61.getTotalDiamonds();
        List<Integer> r211 = x1(gz1.c.g(r61));
        int r212 = r60.ordinal();
        Map<String, String> r213 = w1(r61);
        String r63 = r61.getCardName();
        if (r63 != null) goto L116;
        String r214 = BuildConfig.FLAVOR;
    L117:
        r114.U(r115, r116, r117, r44, r210, r211, "default", false, r212, r213, r214, r61.getLabelText());
        goto L266
    L116:
        r214 = r63;
    L266:
        t0<GiftDIYViewState, GiftDIYCardItem> r64 = r34.getDiyCardList();
        r31.getClass();
        l0.d(r64);
        l0.c(r34.getDiyCardList(), r37);
        String r65 = this.w;
        if ((!Intrinsics.areEqual(r65, BuildConfig.FLAVOR)) == true) goto L270;
        r65 = null;
    L270:
        if (r65 == null) goto L294;
        k0 r66 = r31.b;
        t0<GiftDIYViewState, GiftDIYCardItem> r67 = r34.getDiyCardList();
        r66.getClass();
        Iterator r68 = k0.c(r67).iterator();
        int r69 = 0;
    L273:
        if (r68.hasNext() == false) goto L283;
        n r70 = (n) com.bytedance.android.anya.h.b(((GiftDIYCardItem) r68.next()).getDiyCardInfo());
        if (Intrinsics.areEqual(r70.getCardName(), r65) == true) goto L277;
    L279:
        boolean r71 = false;
    L280:
        if (r71 == true) goto L281;
        r69 = r69 + 1;
        goto L273
    L281:
        int r118 = r69;
    L284:
        Integer r73 = Integer.valueOf(r118);
        if (r73.intValue() < 0) goto L287;
        boolean r74 = true;
    L288:
        if (r74 == true) goto L291;
        r73 = null;
    L291:
        if (r73 == null) goto L294;
        r44 = r73.intValue();
        E1(r31, r34, r44, DIYCardSelectType.CARD_NAME_SELECT);
        Unit r75 = Unit.INSTANCE;
        goto L294
    L287:
        r74 = false;
        goto L288
    L277:
        if (gz1.a.c(r70) == false) goto L279;
        r71 = true;
        goto L280
    L283:
        r118 = -1;
    L294:
        l0.h(r34.getSelectedPosition(), Integer.valueOf(r44));
        if ((!r37.isEmpty()) == false) goto L323;
        LinkedHashMap r76 = new LinkedHashMap();
        q r77 = r35.getButton();
        if (r77 != null) goto L299;
    L307:
        q r78 = r35.getButton();
        if (r78 == null) goto L313;
        a5 r79 = r78.getText();
        if (r79 == null) goto L313;
        String r80 = r79.getDefaultPattern();
        if (r80 == null) goto L313;
    L314:
        r76.put("show_info", r80);
        if (z1() == false) goto L317;
        if (r36 == false) goto L323;
    L317:
        u1 r81 = this.B;
        long r83 = r33.getId();
        r81.getClass();
        Intrinsics.checkNotNullParameter(r76, "param");
        LinkedHashMap r84 = new LinkedHashMap();
        r84.putAll(r76);
        r84.put("gift_id", String.valueOf(r83));
        r84.put("user_id", com.bytedance.android.live.revenue.core.util.f.a(l01.d.class).getCurrentUserId());
        IRoom r85 = r81.o.getRoom();
        String r86 = r85.getAnchorId();
        if (r86 == null) goto L321;
        r41 = r86;
    L321:
        r84.put("anchor_id", r41);
        r84.put("room_id", String.valueOf(r85.getRoomId()));
        r81.q(r84);
        r81.p1("customize_entrance_show", r84, true);
    L313:
        r80 = BuildConfig.FLAVOR;
        goto L314
    L299:
        if (r77.getLocked() == false) goto L301;
        r76.put("entrance_status", "locked");
    L303:
        if (this.F.isAnchor() != true) goto L305;
        String r87 = "1";
    L306:
        r76.put("is_anchor", r87);
        Unit r88 = Unit.INSTANCE;
        goto L307
    L305:
        r87 = "0";
        goto L306
    L301:
        r76.put("entrance_status", q.UNLOCKED);
    L323:
        if ((!r16.isEmpty()) == false) goto L325;
        ArrayList r89 = r16;
    L326:
        if (r89 == null) goto L370;
        boolean r90 = d0.a;
        d0.j(r33.getId(), null, r16);
        Unit r91 = Unit.INSTANCE;
        return;
    L370:
        return;
    L325:
        r89 = null;
        goto L326
    L77:
        r44 = -1;
        goto L78
    L118:
        Iterator r93 = r16.iterator();
        int r94 = 0;
    L120:
        if (r93.hasNext() == false) goto L144;
        n r95 = (n) r93.next();
        if (o.c(r95) == false) goto L124;
    L126:
        n.a r96 = n.Companion;
        int r119 = this.y;
        r96.getClass();
        if (n.a.c(r119, r95) == true) goto L135;
        if ((n.a.f(this.y, r95) & 32) != 32) goto L131;
        boolean r97 = true;
    L132:
        if (r97 == true) goto L135;
    L134:
        r94 = r94 + 1;
        goto L120
    L131:
        r97 = false;
    L135:
        Map<String, String> r215 = w1(r95);
        if (z1() == false) goto L138;
        if (r36 == true) goto L138;
    L143:
        Pair r98 = TuplesKt.to(Integer.valueOf(r94), Boolean.TRUE);
    L146:
        if (((Number) r98.getFirst()).intValue() == (-1)) goto L149;
    L193:
        Iterator r99 = r16.iterator();
        int r100 = -1;
        int r101 = 0;
    L195:
        if (r99.hasNext() == false) goto L265;
        Object r102 = r99.next();
        int r120 = r101 + 1;
        if (r101 >= 0) goto L199;
        CollectionsKt.throwIndexOverflow();
    L199:
        n r121 = (n) r102;
        GiftDIYCardItem r103 = new GiftDIYCardItem();
        new k0.a();
        if (((Boolean) r98.getSecond()).booleanValue() == false) goto L203;
    L223:
        r121 = r121;
        boolean r104 = false;
    L235:
        r103.getDiyCardInfo().a(r121);
        com.bytedance.android.anya.internal.c r122 = r103.getSelected();
        if (((Number) r98.getFirst()).intValue() == r101) goto L238;
    L240:
        boolean r123 = r104;
    L241:
        r122.a(Boolean.valueOf(r123));
        com.bytedance.android.anya.internal.c r124 = r103.getGiftIcon();
        py.k r125 = r33.getImage();
        if (r125 != null) goto L244;
        r125 = (py.k) vh7.f.c(py.k.class);
    L244:
        r124.a(r125);
        com.bytedance.android.anya.internal.c r126 = r103.getSelectType();
        if (((Boolean) r98.getSecond()).booleanValue() == true) goto L247;
    L249:
        if (r104 == false) goto L251;
        DIYCardSelectType r105 = DIYCardSelectType.DEFAULT_SELECT;
    L252:
        r126.a(r105);
        r103.getShowRemindDot().a(Boolean.valueOf(B1(r121)));
        com.bytedance.android.anya.internal.c r106 = r103.getExpireTime();
        String r127 = r121.getLabelText();
        if (r127 != null) goto L255;
        r127 = BuildConfig.FLAVOR;
    L255:
        r106.a(r127);
        if (((Boolean) r103.getSelected().c()).booleanValue() == false) goto L264;
        DIYCardSelectType r107 = (DIYCardSelectType) r103.getSelectType().c();
        DIYCardSelectType r108 = DIYCardSelectType.DEFAULT_SELECT;
        if (r107 != r108) goto L260;
        this.C.f(r108.ordinal());
    L263:
        r100 = r101;
        goto L264
    L260:
        DIYCardSelectType r109 = (DIYCardSelectType) r103.getSelectType().c();
        DIYCardSelectType r128 = DIYCardSelectType.RECOMMEND_SELECT;
        if (r109 != r128) goto L263;
        this.C.f(r128.ordinal());
    L264:
        Unit r129 = Unit.INSTANCE;
        r37.add(r103);
        r101 = r120;
        goto L195
    L251:
        r105 = DIYCardSelectType.IDLE;
        goto L252
    L247:
        if (((Number) r98.getFirst()).intValue() != r101) goto L249;
        r105 = DIYCardSelectType.RECOMMEND_SELECT;
        goto L252
    L238:
        if (((Boolean) r98.getSecond()).booleanValue() == false) goto L240;
        r123 = true;
        goto L241
    L203:
        if (r121.getLockInfo() == null) goto L329;
        CardLockInfo r130 = r121.getLockInfo();
        if (r130 == null) goto L223;
        if (r130.getLockStatus() != CardLockInfo.Companion.LockStatus.UNLOCKED.getV()) goto L223;
    L329:
        ArrayList<e3> r131 = gz1.c.d(new JSONArray(ay1.b.g().get(String.valueOf(r33.getId()))));     // Catch: Exception -> L212
    L214:
        String r132 = ay1.b.f().get(String.valueOf(r33.getId()));
        if (gz1.c.h(gz1.c.g(r121), r131) == false) goto L217;
    L224:
        Map<String, String> r216 = w1(r121);
        if (z1() == false) goto L229;
        if (r36 == true) goto L229;
    L234:
        r104 = true;
    L229:
        u1 r133 = this.B;
        long r134 = this.v.getId();
        int r135 = this.v.getDiamondCount();
        boolean r136 = A1(r121);
        long r217 = r121.getTotalDiamonds();
        List<Integer> r218 = x1(gz1.c.g(r121));
        int r219 = DIYCardSelectType.DEFAULT_SELECT.ordinal();
        if (r132 != null) goto L232;
        String r220 = BuildConfig.FLAVOR;
    L233:
        r133.U(r134, r135, r136, r101, r217, r218, "default", false, r219, r216, r220, r121.getLabelText());
        goto L234
    L232:
        r220 = r132;
        goto L233
    L217:
        if (TextUtils.isEmpty(r132) == true) goto L223;
        if (TextUtils.isEmpty(r121.getCardName()) == true) goto L223;
        if (TextUtils.equals(r132, r121.getCardName()) == false) goto L223;
    L212:
        e = move-exception;
        e.printStackTrace();
        r131 = null;
        goto L214
    L265:
        r44 = r100;
        goto L266
    L149:
        if ((!r16.isEmpty()) == false) goto L192;
        n r137 = (n) ListProtector.get(r16, 0);
        if (r38 == null) goto L181;
        if (r137 == null) goto L181;
        String r138 = ay1.b.h().get(String.valueOf(r33.getId()));
        if (r138 == null) goto L158;
        Long r139 = StringsKt.toLongOrNull(r138);
    L159:
        if (r139 != null) goto L161;
    L162:
        CardLockInfo r140 = r38.getLockInfo();
        if (r140 != null) goto L165;
    L168:
        boolean r141 = true;
    L169:
        if (r141 == true) goto L173;
        if (com.bytedance.android.livesdk.gift.platform.business.config.b.a(this.x, this.y) == false) goto L181;
    L173:
        if (gz1.c.h(gz1.c.g(r38), gz1.c.g(r137)) == false) goto L175;
    L182:
        Map<String, String> r221 = w1(r137);
        if (z1() == false) goto L185;
        if (r36 == true) goto L185;
    L190:
        boolean r142 = true;
    L191:
        r98 = TuplesKt.to(0, Boolean.valueOf(r142));
    L185:
        u1 r143 = this.B;
        long r144 = this.v.getId();
        int r145 = this.v.getDiamondCount();
        boolean r146 = A1(r38);
        long r222 = r38.getTotalDiamonds();
        List<Integer> r223 = x1(gz1.c.g(r38));
        int r224 = DIYCardSelectType.RECOMMEND_SELECT.ordinal();
        String r147 = r137.getCardName();
        if (r147 != null) goto L188;
        String r225 = BuildConfig.FLAVOR;
    L189:
        r143.U(r144, r145, r146, 0, r222, r223, "default", false, r224, r221, r225, r137.getLabelText());
        goto L190
    L188:
        r225 = r147;
        goto L189
    L175:
        if (TextUtils.isEmpty(r38.getCardName()) == true) goto L181;
        if (TextUtils.isEmpty(r137.getCardName()) == true) goto L181;
        if (TextUtils.equals(r38.getCardName(), r137.getCardName()) == false) goto L181;
    L165:
        if (r140.getLockStatus() == CardLockInfo.Companion.LockStatus.UNLOCKED.getV()) goto L168;
        r141 = false;
        goto L169
    L161:
        if (r38.getStartTime() <= r139.longValue()) goto L181;
    L158:
        r139 = null;
    L181:
        r142 = false;
        goto L191
    L192:
        r98 = TuplesKt.to(0, Boolean.FALSE);
    L138:
        u1 r148 = this.B;
        long r149 = this.v.getId();
        int r150 = this.v.getDiamondCount();
        boolean r151 = A1(r95);
        long r226 = r95.getTotalDiamonds();
        List<Integer> r227 = x1(gz1.c.g(r95));
        int r228 = DIYCardSelectType.RECOMMEND_SELECT.ordinal();
        String r152 = r95.getCardName();
        if (r152 != null) goto L141;
        String r229 = BuildConfig.FLAVOR;
    L142:
        r148.U(r149, r150, r151, r94, r226, r227, "default", false, r228, r215, r229, r95.getLabelText());
        goto L143
    L141:
        r229 = r152;
        goto L142
    L124:
        if (com.bytedance.android.livesdk.gift.platform.business.config.b.a(this.x, this.y) == true) goto L126;
    L144:
        r98 = TuplesKt.to(-1, Boolean.FALSE);
        goto L146
    L67:
        r38 = null;
        goto L68
    L34:
        r20 = new ArrayList(r35.getCards());
        goto L35
    L30:
        r18 = new ArrayList(r35.getForceIndexCards());
        goto L31
    L19:
        r11 = null;
    L26:
        r0<GiftDIYViewState, Boolean> r153 = r34.getButtonVisibility();
        Boolean r154 = Boolean.FALSE;
        r31.getClass();
        l0.h(r153, r154);
        Unit r155 = Unit.INSTANCE;
        goto L27
    }

    public final void s1(int r18, ArrayList<n> r19, h1 r20, List<n> r21, boolean r23, boolean r24) {
        Iterator r1 = CollectionsKt.take(r19, r18).iterator();
    L4:
        if (r1.hasNext() == false) goto L30;
        n r2 = (n) r1.next();
        ArrayList r3 = (ArrayList) r21;
        r3.add(r2);
        Map<String, String> r4 = w1(r2);
        if (z1() == false) goto L8;
        if (r24 == false) goto L4;
    L8:
        u1 r5 = this.B;
        long r6 = r20.getId();
        int r8 = r20.getDiamondCount();
        int r7 = r3.size();
        long r9 = r2.getTotalDiamonds();
        List r11 = x1(gz1.c.g(r2));
        String r13 = r2.getCardName();
        String r14 = BuildConfig.FLAVOR;
        if (r13 != null) goto L11;
        r13 = BuildConfig.FLAVOR;
    L11:
        String r10 = r2.getLabelText();
        r5.getClass();
        Intrinsics.checkNotNullParameter(r11, "customizeItem");
        Intrinsics.checkNotNullParameter(r13, "cardName");
        LinkedHashMap r15 = new LinkedHashMap();
        r15.putAll(r4);
        IRoom r16 = r5.o.getRoom();
        String r17 = r16.getAnchorId();
        if (r17 == null) goto L15;
        r14 = r17;
    L15:
        r15.put("anchor_id", r14);
        r15.put("room_id", String.valueOf(r16.getRoomId()));
        r15.put("user_id", com.bytedance.android.live.revenue.core.util.f.a(l01.d.class).getCurrentUserId());
        r15.put("gift_id", String.valueOf(r6));
        r15.put("price", String.valueOf(r8));
        if (r23 == false) goto L18;
        String r25 = "recommend";
    L19:
        r15.put("card_type", r25);
        r15.put("card_location", String.valueOf(r7));
        r15.put("customize_item", GsonProtectorUtils.toJson(GsonHelper.get(), r11));
        r15.put("customize_price", String.valueOf(r9));
        r15.put("card_name", r13);
        if (r10 != null) goto L22;
    L25:
        boolean r26 = true;
    L26:
        if (r26 == false) goto L28;
        String r27 = "null";
    L29:
        r15.put("tag_type", r27);
        r5.q(r15);
        r5.p1("customize_gift_buff_show", r15, true);
        goto L4
    L28:
        r27 = "countdown";
        goto L29
    L22:
        if (r10.length() == 0) goto L25;
        r26 = false;
        goto L26
    L18:
        r25 = "lately_setting";
        goto L19
    }

    public GiftMVIDIYTopViewModel(u1 r2, g1 r3, AssetsService r4, DataCenter r5, k r6, LocateGiftInfo r7, GiftExtraRepo r8, m0 r9, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f r10, GiftMVIMarketingUseCase r11, GiftDialogStateDataStore r13) {
        Intrinsics.checkNotNullParameter(r2, "giftPanelLogService");
        Intrinsics.checkNotNullParameter(r3, "giftLogService");
        Intrinsics.checkNotNullParameter(r4, "assertService");
        Intrinsics.checkNotNullParameter(r5, "dataCenter");
        Intrinsics.checkNotNullParameter(r6, "roomDataService");
        Intrinsics.checkNotNullParameter(r7, "locateGiftInfo");
        Intrinsics.checkNotNullParameter(r8, "giftExtraRepo");
        Intrinsics.checkNotNullParameter(r9, "giftDIYService");
        Intrinsics.checkNotNullParameter(r10, "receiverService");
        Intrinsics.checkNotNullParameter(r11, "giftMarketingUseCase");
        Intrinsics.checkNotNullParameter(r13, "giftDialogStateDataStore");
        this.B = r2;
        this.C = r3;
        this.D = r4;
        this.E = r5;
        this.F = r6;
        this.G = r7;
        this.H = r8;
        this.I = r9;
        this.J = r10;
        this.K = r11;
        this.L = r13;
        this.u = -1;
        this.v = (h1) vh7.f.c(h1.class);
        this.w = BuildConfig.FLAVOR;
        this.x = nz1.b.a();
        this.z = SetsKt.setOf(new BaseMVIDataStore[]{r11, r13});
        this.A = new ArrayList();
    }
}
