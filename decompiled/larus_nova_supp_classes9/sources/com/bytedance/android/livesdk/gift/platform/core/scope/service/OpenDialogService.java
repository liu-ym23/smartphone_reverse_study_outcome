package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.DigHoleScreenUtil;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.uikit.util.IESUIUtils;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.chatroom.event.LocateGiftInfo;
import com.bytedance.android.livesdk.config.ti1;
import com.bytedance.android.livesdk.gift.model.IGiftMarketingInfo;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftViewModelManager;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.GiftDialogFragmentV3;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.GiftSearchDataStore;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.GiftPanelViewPreloadService;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.p000new.GiftPreloadManager;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.p000new.GiftPreloadResType;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.GiftExtraRepo;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.GiftListRepo;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.GiftReceiverRepoService;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.OnLocateGiftRequestReceived;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.android.livesdk.gift.platform.core.manager.GiftManagerKt;
import com.bytedance.android.livesdk.gift.platform.core.model.ReceiverType;
import com.bytedance.android.livesdk.gift.util.FetchOpenGiftPanelFrom;
import com.bytedance.android.livesdk.init.I18nInitTask;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.BehaviorSubject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.reflect.KProperty;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004:\u0001\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/core/scope/service/OpenDialogService;", "Lcom/bytedance/android/scope/o;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Lcom/bytedance/revenue/platform/api/core/android/lifecycle/Observer;", "a", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OpenDialogService implements com.bytedance.android.scope.o, Observer<KVData> {
    public static final /* synthetic */ int r = 0;
    public Disposable a;
    public GiftDialogFragmentV3 b;
    public LiveDialogFragment c;
    public LocateGiftInfo d;
    public final BehaviorSubject<Long> e;
    public long f;
    public final i12.e g;
    public final Context h;
    public final DataCenter i;
    public final com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.a j;
    public final GiftReceiverRepoService k;
    public final GiftPanelViewPreloadService l;
    public final yz0.k m;
    public final GiftExtraRepo n;
    public final com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.x o;
    public final com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.y p;
    public final GiftClientAIIntegratedService q;

    public static final class a {
    }

    static {
    }

    public final void j() {
        LocateGiftInfo r0 = this.d;
        if (r0 == null) goto L11;
        Intrinsics.checkNotNull(r0);
        if (r0.getTargetPropDefId() <= 0) goto L12;
        uz1.a r1 = com.bytedance.android.livesdk.gift.platform.core.utils.b0.a();
        if (r1 == null) goto L9;
        LocateGiftInfo r2 = this.d;
        Intrinsics.checkNotNull(r2);
        r1.a(new OnLocateGiftRequestReceived(r2, 1));
    L9:
        this.d = null;
        return;
    L12:
        return;
    }

    public final void onStart() {
        this.i.observe("cmd_show_gift_relay_dialog", this);
    }

    public final void onStop() {
        GiftDialogFragmentV3 r0 = this.b;
        if (r0 != null) goto L5;
    L14:
        ((com.bytedance.android.livesdk.gift.configmodel.l1) nz1.a.b.getValue(null, nz1.a.a[0])).getClass();
        LiveDialogFragment r1 = this.c;
        if (r1 != null) goto L17;
    L26:
        a(BuildConfig.FLAVOR);
        Disposable r2 = this.a;
        if (r2 != null) goto L29;
    L33:
        this.i.removeObserver(this);
        return;
    L29:
        if (r2.isDisposed() == true) goto L33;
        Disposable r3 = this.a;
        if (r3 == null) goto L33;
        r3.dispose();
        goto L33
    L17:
        if (r1.isShowing() != true) goto L26;
        LiveDialogFragment r4 = this.c;
        if (r4 == null) goto L26;
        r4.dismiss();     // Catch: Exception -> L22
    L22:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r5 = DialogFragmentLancet.sLastShowStack;
        if (r5 == null) goto L26;
        com.bytedance.crash.d.d(r5, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L26
    L5:
        if (r0.isShowing() != true) goto L14;
        GiftDialogFragmentV3 r6 = this.b;
        if (r6 == null) goto L14;
        r6.dismiss();     // Catch: Exception -> L10
    L10:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r7 = DialogFragmentLancet.sLastShowStack;
        if (r7 == null) goto L14;
        com.bytedance.crash.d.d(r7, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L14
    }

    public final void a(String r5) {
        if (TextUtils.equals(r5, "banner") == false) goto L5;
    L8:
        boolean r6 = true;
    L9:
        GiftDialogFragmentV3 r0 = this.b;
        if (r0 != null) goto L12;
        return;
    L12:
        if (r0.isViewValid() != true) goto L42;
        GiftDialogFragmentV3 r1 = this.b;
        if (r1 != null) goto L16;
    L37:
        this.b = null;
        return;
    L16:
        if (r1.u == false) goto L39;
        DataCenter r2 = r1.i;
        if (r2 == null) goto L23;
        Long r3 = (Long) r2.get("data_room_id", 0L);
        if (r3 == null) goto L23;
        String r4 = String.valueOf(r3.longValue());
        if (r4 == null) goto L23;
    L24:
        if (r6 == false) goto L28;
        nq2.a r7 = vh6.c.b(nq2.a.class);
        if (r7 == null) goto L39;
        r7.excActionBySetting(r4);
        goto L39
    L28:
        nq2.a r8 = vh6.c.b(nq2.a.class);
        if (r8 == null) goto L39;
        r8.showInteractionAndEnterRoom(r4);
    L23:
        r4 = "0";
    L39:
        r1.dismissAllowingStateLoss();     // Catch: Exception -> L33
    L33:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r9 = DialogFragmentLancet.sLastShowStack;
        if (r9 == null) goto L37;
        com.bytedance.crash.d.d(r9, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L37
    L42:
        return;
    L5:
        if (TextUtils.equals(r5, "top_container") == true) goto L8;
        r6 = false;
        goto L9
    }

    public final IBaseUser c(String r5) {
        IBaseUser r0 = null;
        if (r5 != null) goto L5;
        return null;
    L5:
        IBaseUser r1 = this.m.getRoom().getOwner();
        if (r1 == null) goto L12;
        String r2 = r1.getIdString();
        if (r2 == null) goto L12;
        if (Intrinsics.areEqual(r2, r5) == false) goto L12;
        r0 = this.m.getRoom().getOwner();
    L12:
        Iterator<IBaseUser> r3 = this.k.k().a.iterator();
    L14:
        if (r3.hasNext() == false) goto L22;
        IBaseUser r4 = r3.next();
        if (Intrinsics.areEqual(r4.getIdString(), r5) == false) goto L14;
        return r4;
    L22:
        return r0;
    }

    public final boolean f(FetchOpenGiftPanelFrom r7) {
        Intrinsics.checkNotNullParameter(r7, "from");
        if (r7 != FetchOpenGiftPanelFrom.TOUCH_DOWN) goto L5;
    L8:
        long r0 = System.currentTimeMillis();
        long r2 = this.f;
        long r1 = r0 - r2;
        if (r2 > 0) goto L11;
    L14:
        this.f = System.currentTimeMillis();
        return false;
    L11:
        if (r1 >= I18nInitTask.DELAY_TS_MS) goto L14;
        return true;
    L5:
        if (r7 == FetchOpenGiftPanelFrom.DIALOG_CREATE_BEFORE) goto L8;
        if (r7 != FetchOpenGiftPanelFrom.GIFT_PANEL_CREATE) goto L14;
        goto L8
    }

    public final void onChanged(Object r3) {
        KVData r4 = (KVData) r3;
        if (r4 != null) goto L5;
        return;
    L5:
        if (r4.getKey().length() != 0) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == true) goto L19;
        String r5 = r4.getKey();
        if (r5.hashCode() == (-171438776)) goto L14;
        return;
    L14:
        if (r5.equals("cmd_show_gift_relay_dialog") == false) goto L18;
        a(BuildConfig.FLAVOR);
        return;
    L18:
        return;
    L19:
        return;
    L7:
        r0 = false;
        goto L8
    }

    public static void d(OpenDialogService r3, long r4, String r6, int r7) {
        if ((r7 & 1) == 0) goto L6;
        r4 = 0;
    L6:
        if ((r7 & 2) == 0) goto L8;
        r6 = BuildConfig.FLAVOR;
    L8:
        r3.getClass();
        Intrinsics.checkNotNullParameter(r6, "source");
        if (r4 > 0) goto L11;
    L31:
        r3.a(r6);
        return;
    L11:
        if (nz1.a.l().e() == false) goto L31;
        i12.e r8 = i12.o.b();
        IGiftMarketingInfo r0 = null;
        if (r8 == null) goto L16;
        Object r9 = com.bytedance.android.scope.m.e.d(r8, GiftExtraRepo.class);
    L17:
        GiftExtraRepo r10 = (GiftExtraRepo) r9;
        if (r10 == null) goto L22;
        com.bytedance.android.livesdk.gift.model.g0 r1 = r10.q(r4);
        if (r1 == null) goto L22;
        r0 = r1.getGiftMarketingInfo();
    L22:
        if (r0 == null) goto L31;
        Disposable r2 = r3.a;
        if (r2 != null) goto L26;
    L30:
        r3.a = Observable.timer(nz1.a.l().d(), TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new h3(r10, r4));
        goto L31
    L26:
        if (r2.isDisposed() == true) goto L30;
        Disposable r5 = r3.a;
        if (r5 == null) goto L30;
        r5.dispose();
        goto L30
    L16:
        r9 = null;
        goto L17
    }

    public final void g(IBaseUser r27, LocateGiftInfo r28, Bundle r29, zg1.o3 r30) {
        Intrinsics.checkNotNullParameter(r28, "locateGiftInfo");
        Intrinsics.checkNotNullParameter(r30, "originEvent");
        if (this.g.m() == true) goto L5;
        return;
    L5:
        IRoom r7 = com.bytedance.android.livesdk.gift.platform.core.utils.x.a();
        Disposable r8 = this.a;
        if (r8 != null) goto L8;
    L12:
        if (r7 != null) goto L15;
        return;
    L15:
        if (r7.getOwner() != null) goto L17;
        return;
    L17:
        IRoomAuthStatus r9 = r7.getRoomAuthStatus();
        String r10 = null;
        boolean r11 = true;
        if (r9 != null) goto L20;
    L35:
        LiveDialogFragment r13 = this.c;
        if (r13 != null) goto L38;
    L41:
        GiftDialogFragmentV3 r14 = this.b;
        if (r14 == null) goto L59;
        if (r14.isShowing() != true) goto L59;
        i12.d r15 = i12.m.e2.a();
        if (r15 == null) goto L48;
        Object r16 = com.bytedance.android.scope.m.e.d(r15, GiftSearchDataStore.class);
    L49:
        GiftSearchDataStore r17 = (GiftSearchDataStore) r16;
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v.c() == false) goto L55;
        if (r17 == null) goto L55;
        if (r17.s() != true) goto L55;
        r17.back();
    L55:
        uz1.a r18 = com.bytedance.android.livesdk.gift.platform.core.utils.b0.a();
        if (r18 == null) goto L59;
        r18.a(new OnLocateGiftRequestReceived(r28, 2));
        goto L59
    L48:
        r16 = null;
    L59:
        if (r28.getTargetPageType() != 100) goto L62;
        return;
    L62:
        if (com.bytedance.android.live.revenue.core.util.f.a(l01.d.class).b().childrenManagerForbidWalletFunctions() == false) goto L66;
        IESUIUtils.displayToast(this.h, 2131915786);
        return;
    L66:
        if (vh6.c.b(wh6.a.class).isNeedProtectUnderage() == false) goto L69;
        ToastUtil.a(2131919796, 0);
        return;
    L69:
        vh6.c.b(wr2.a.class).I7(((ti1) com.bytedance.android.livesdk.gift.platform.core.g.b.getValue(null, com.bytedance.android.livesdk.gift.platform.core.g.a[0])).mTimeoutOpenGiftDialog);
        FragmentActivity r19 = this.h;
        if (r19 == null) goto L194;
        GiftViewModelManager r20 = (GiftViewModelManager) ViewModelProviders.of(r19).get(GiftViewModelManager.class);
        r20.setAllCommonData(this.h, this.i);
        com.bytedance.android.livesdk.gift.util.b.f(GiftStateMachineConfig.Event.l.b);
        if (r27 == null) goto L75;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.y.d(this.p, r27);
    L85:
        if (com.bytedance.android.livesdk.gift.util.b.c(false) != null) goto L87;
    L112:
        this.i.put("data_gift_group_id", 0L);
        if ((this.h instanceof FragmentActivity) == false) goto L210;
        this.k.getClass();
        GiftDialogFragmentV3 r0 = this.b;
        if (r0 != null) goto L117;
    L118:
        if (r29 == null) goto L132;
        String r1 = r29.getString("gift_show_from");
        if (r1 == null) goto L132;
        if ((!Intrinsics.areEqual(r1, "bottom_tab")) == true) goto L124;
    L126:
        boolean r110 = false;
    L127:
        if (r110 == true) goto L130;
        r1 = null;
    L130:
        if (r1 == null) goto L132;
        HashMap<GiftPreloadResType, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.p000new.k<?>> r2 = GiftPreloadManager.a;
        GiftPreloadManager.b(com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.new.h.d.a);
        goto L132
    L124:
        if ((!Intrinsics.areEqual(r1, "recharge_panel")) == false) goto L126;
        r110 = true;
    L132:
        IBaseUser r3 = this.p.i();
        if (r3 != null) goto L135;
        r3 = this.o.a();
    L135:
        GiftExtraRepo.a r111 = GiftExtraRepo.v;
        r111.getClass();
        if (((Boolean) GiftExtraRepo.t.getValue(r111, GiftExtraRepo.a.a[1])).booleanValue() == false) goto L138;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.r0.a.a(this.n, CollectionsKt.emptyList(), "giftPanelOpen", r3, 8);
    L138:
        GiftListRepo.k.getClass();
        if (((Boolean) GiftListRepo.h.getValue()).booleanValue() == true) goto L141;
    L159:
        GiftDialogFragmentV3 r4 = this.b;
        if (r4 != null) goto L197;
    L167:
        this.b = null;
        int r5 = GiftDialogFragmentV3.z;
        Context r6 = this.h;
        boolean r21 = com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.k();
        boolean r112 = com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.h();
        DataCenter r113 = this.i;
        i12.e r114 = this.g;
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r28, "locateGiftInfo");
        Intrinsics.checkNotNullParameter(r113, "liveDataCenter");
        Intrinsics.checkNotNullParameter(r114, "scope");
        Intrinsics.checkNotNullParameter(r30, "originEvent");
        GiftDialogFragmentV3 r23 = new GiftDialogFragmentV3();
        r23.d = r6;
        r23.setVertical(r21);
        r23.e = r28;
        r23.g = r112;
        if (r21 == false) goto L173;
        if (r112 == false) goto L171;
    L172:
        boolean r24 = true;
    L174:
        r23.h = r24;
        r23.i = r113;
        r23.q = r114;
        r23.f = r29;
        r23.l = r30.f;
        if (r29 == null) goto L177;
        String r25 = r29.getString("gift_show_from");
    L178:
        r23.u = TextUtils.equals(r25, "icon_feed");
        this.b = r23;
        FragmentManager r26 = this.h.getSupportFragmentManager();
        LandscapeRestrictionOperation r31 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r23, "GiftDialogFragmentV3", r31);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r26, r23, r31) == false) goto L201;
    L183:
        xs2.b.a().post(new zg1.g0(1, 2));
        ay1.b.C.setValue(null, ay1.b.a[33], Boolean.TRUE);
        if (r29 == null) goto L186;
        String r33 = r29.getString("gift_show_from");
    L188:
        if (TextUtils.equals(r33, "icon_feed") == false) goto L211;
        nq2.a r34 = vh6.c.b(nq2.a.class);
        if (r34 == null) goto L212;
        r34.showInteractionMask(r7.getIdStr());
        return;
    L212:
        return;
    L211:
        return;
    L186:
        r33 = null;
        goto L188
    L201:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L196
    L182:
        r23.show(r26, "GiftDialogFragmentV3");
        goto L183
    L177:
        r25 = null;
        goto L178
    L171:
        if (DigHoleScreenUtil.isNeedStatusBarAdapt(r6, r21, r112) == true) goto L172;
    L173:
        r24 = false;
        goto L174
    L197:
        r4.dismiss();     // Catch: Exception -> L163
    L163:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r35 = DialogFragmentLancet.sLastShowStack;
        if (r35 == null) goto L167;
        com.bytedance.crash.d.d(r35, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L167
    L141:
        if (f(FetchOpenGiftPanelFrom.DIALOG_CREATE_BEFORE) == true) goto L159;
        ReceiverType r115 = this.p.h(r3);
        Boolean r116 = (Boolean) this.i.get("data_is_anchor", Boolean.FALSE);
        if (r116 == null) goto L145;
        boolean r210 = r116.booleanValue();
    L146:
        int r211 = com.bytedance.android.livesdk.gift.platform.core.utils.u.c(r115);
        long r117 = r28.getTargetGiftId();
        if (r117 != (-1)) goto L156;
        GiftContext r118 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r118 == null) goto L157;
        com.bytedance.live.datacontext.m<GiftContext.a> r119 = r118.getLastSendGiftId();
        if (r119 == null) goto L157;
        GiftContext.a r120 = (GiftContext.a) r119.getValue();
        if (r120 == null) goto L157;
        r117 = r120.a;
    L157:
        long r212 = -1;
    L158:
        int r121 = z1.a;
        z1.a(3, this.m.getRoom(), r210, r211, r212, r3, null);
    L156:
        r212 = r117;
        goto L158
    L145:
        r210 = false;
        goto L146
    L117:
        if (r0.isShowing() == true) goto L183;
    L210:
        return;
    L87:
        if ((this.h instanceof FragmentActivity) == false) goto L112;
        LiveDialogFragment r36 = this.c;
        if (r36 != null) goto L203;
    L96:
        com.bytedance.android.livesdk.gift.platform.business.g r37 = com.bytedance.android.livesdk.gift.util.b.c(false);
        if (r37 == null) goto L99;
        LiveDialogFragment r38 = r37.f(this.i, this.h, r20, r28);
    L100:
        this.c = r38;
        if (r38 == null) goto L112;
        Intrinsics.checkNotNull(r38);
        FragmentActivity r39 = this.h;
        if (r39 == null) goto L111;
        FragmentManager r40 = r39.getSupportFragmentManager();
        LandscapeRestrictionOperation r41 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r38, "ReplaceGiftDialog", r41);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r40, r38, r41) == true) goto L209;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L195
    L108:
        r38.show(r40, "ReplaceGiftDialog");
        return;
    L209:
        return;
    L111:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    L99:
        r38 = null;
        goto L100
    L203:
        r36.dismiss();     // Catch: Exception -> L92
    L92:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r43 = DialogFragmentLancet.sLastShowStack;
        if (r43 == null) goto L96;
        com.bytedance.crash.d.d(r43, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L96
    L75:
        if (this.j.j() == false) goto L85;
        String r44 = com.bytedance.android.live.revenue.core.util.f.a(l01.d.class).b().getIdString();
        List<IBaseUser> r122 = this.k.k().a;
        ArrayList r123 = new ArrayList();
        Iterator<T> r124 = r122.iterator();
    L78:
        if (r124.hasNext() == false) goto L83;
        Object r125 = r124.next();
        if ((!Intrinsics.areEqual(((IBaseUser) r125).getIdString(), r44)) == false) goto L78;
        r123.add(r125);
        goto L78
    L83:
        this.j.c(r123);
        goto L85
    L194:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    L38:
        if (r13.isShowing() != true) goto L41;
        com.bytedance.android.livesdk.gift.util.b.f(new GiftStateMachineConfig.Event.j(r28));
        return;
    L20:
        if (r9.getEnableGift() == true) goto L35;
        IRoomAuthStatus r45 = r7.getRoomAuthStatus();
        if (r45 == null) goto L26;
        IRoomAuthStatus.IOffReason r46 = r45.getOffReason();
        if (r46 == null) goto L26;
        r10 = r46.getGift();
    L26:
        if (r10 != null) goto L28;
    L31:
        if (r11 == true) goto L33;
        ToastUtil.b(r10, 0);
        return;
    L33:
        ToastUtil.a(2131916225, 0);
        return;
    L28:
        if (r10.length() == 0) goto L31;
        r11 = false;
        goto L31
    L8:
        if (r8.isDisposed() == true) goto L12;
        Disposable r47 = this.a;
        if (r47 == null) goto L12;
        r47.dispose();
        goto L12
    }

    public final void i(zg1.x2 r33, final boolean r34, boolean r35, com.bytedance.android.livesdk.gift.platform.core.model.b0 r36) {
        Intrinsics.checkNotNullParameter(r33, "event");
        if (TextUtils.isEmpty(r33.d) == false) goto L5;
    L76:
        ALogger.e("ttlive_gift_open_dialog", "charge_reason or charge_scene is empty!");
        return;
    L5:
        if (TextUtils.isEmpty(r33.e) == true) goto L76;
        if (com.bytedance.android.live.revenue.core.util.f.a(l01.d.class).isLogin() == true) goto L19;
        i12.e r1 = i12.o.b();
        if (r1 == null) goto L12;
        Object r3 = com.bytedance.android.scope.m.e.d(r1, GiftInRoomService.class);
    L13:
        GiftInRoomService r4 = (GiftInRoomService) r3;
        if (r4 == null) goto L16;
        r4.a(1002);
        return;
    L16:
        com.bytedance.android.livesdk.gift.util.b.f(new GiftStateMachineConfig.Event.k(1002));
        return;
    L12:
        r3 = null;
        goto L13
    L19:
        if (vh6.c.b(com.bytedance.android.livesdk.revenue.service.user.a.class).interceptOperation("recharge") == false) goto L21;
        return;
    L21:
        com.bytedance.android.live.recharge.model.a r14 = new com.bytedance.android.live.recharge.model.a(0);
        i12.d r5 = i12.m.e2.a();
        if (r5 == null) goto L24;
        Object r6 = com.bytedance.android.scope.m.e.d(r5, w0.class);
    L25:
        w0 r7 = (w0) r6;
        String r8 = BuildConfig.FLAVOR;
        if (r7 == null) goto L29;
        String r9 = r7.a;
        if (r9 == null) goto L29;
    L30:
        Intrinsics.checkNotNullParameter(r9, "<set-?>");
        com.bytedance.android.live.revenue.common.s r10 = r14.b;
        KProperty r11 = com.bytedance.android.live.recharge.model.a.d[2];
        r10.getClass();
        Intrinsics.checkNotNullParameter(r14, "thisRef");
        Intrinsics.checkNotNullParameter(r11, "property");
        r14.put(r10.a, r9);
        Map r13 = r33.q;
        if (r13 == null) goto L34;
        r14.putAll(r13);
    L34:
        if (com.bytedance.android.livesdk.gift.platform.core.g.a() != com.bytedance.android.livesdk.gift.platform.core.g.e) goto L67;
        String r15 = r33.d;
        String r16 = r33.e;
        long r17 = r33.h;
        int r18 = r33.j;
        long r19 = r33.i;
        long r2 = r33.k;
        long r110 = r33.g;
        String r20 = r33.l;
        final Ref.ObjectRef r21 = new Ref.ObjectRef();
        r21.element = null;
        com.bytedance.android.livesdk.gift.platform.business.g r23 = com.bytedance.android.livesdk.gift.util.b.c(r35);
        if (r23 == null) goto L80;
        FragmentActivity r24 = r23.getContext();
        if (r24 == null) goto L80;
        if ((r24 instanceof FragmentActivity) == false) goto L44;
        r21.element = r24;
    L44:
        if (((FragmentActivity) r21.element) == null) goto L80;
        this.m.isAnchor();
        if (TextUtils.equals("gift_recharge", r16) == false) goto L49;
        String r25 = "click";
    L50:
        String r26 = r25;
        if (r110 <= 0) goto L53;
        boolean r27 = true;
    L54:
        GiftContext r28 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r28 == null) goto L62;
        com.bytedance.live.datacontext.m<String> r29 = r28.getGiftListResultLogId();
        if (r29 == null) goto L62;
        String r210 = (String) r29.getValue();
        if (r210 == null) goto L62;
        r8 = r210;
    L62:
        final com.bytedance.android.live.recharge.model.d r111 = new com.bytedance.android.live.recharge.model.d(true, r15, null, r110, r27, 0, 0, r16, r26, new com.bytedance.android.live.recharge.model.b(r8, r20, r2, r19, r17, r18, r14, r36), null, null, null, 31844);
        GiftDialogFragmentV3 r30 = this.b;
        if (r30 == null) goto L65;
        r30.v = true;
    L65:
        v02.b.a(0, false, new OpenDialogService$showRechargeDialog$1(this, r21, r111, r34), 7);
        return;
    L53:
        r27 = false;
        goto L54
    L49:
        r25 = "call";
    L80:
        return;
    L67:
        com.bytedance.android.livesdk.gift.platform.business.g r0 = com.bytedance.android.livesdk.gift.util.b.c(false);
        if (r0 == null) goto L81;
        Context r31 = r0.getContext();
        if (r31 != null) goto L73;
        return;
    L73:
        if ((r31 instanceof Activity) == false) goto L82;
        vh6.c.b(wh6.a.class).openWallet((Activity) r31);
        return;
    L82:
        return;
    L81:
        return;
    L29:
        r9 = BuildConfig.FLAVOR;
        goto L30
    L24:
        r6 = null;
        goto L25
    }

    public OpenDialogService(i12.e r2, Context r3, DataCenter r4, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.a r5, GiftReceiverRepoService r6, GiftPanelViewPreloadService r7, yz0.k r8, GiftExtraRepo r9, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.x r10, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.y r11, GiftClientAIIntegratedService r13) {
        Intrinsics.checkNotNullParameter(r2, "scope");
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "dataCenter");
        Intrinsics.checkNotNullParameter(r5, "allMicService");
        Intrinsics.checkNotNullParameter(r6, "receiverRepoService");
        Intrinsics.checkNotNullParameter(r7, "panelPreloadService");
        Intrinsics.checkNotNullParameter(r8, "roomDataService");
        Intrinsics.checkNotNullParameter(r9, "giftExtraRepo");
        Intrinsics.checkNotNullParameter(r10, "recommendReceiverService");
        Intrinsics.checkNotNullParameter(r11, "selectReceiverService");
        Intrinsics.checkNotNullParameter(r13, "giftClientAiIntegratedService");
        this.g = r2;
        this.h = r3;
        this.i = r4;
        this.j = r5;
        this.k = r6;
        this.l = r7;
        this.m = r8;
        this.n = r9;
        this.o = r10;
        this.p = r11;
        this.q = r13;
        this.e = BehaviorSubject.create();
    }

    public static void h(OpenDialogService r23, int r24, long r25, String r26, Bundle r27, int r28, JSONObject r29, String r30, boolean r31, String r33, long r34, int r35) {
        if ((r35 & 128) == 0) goto L5;
        boolean r13 = false;
    L7:
        if ((r35 & 256) == 0) goto L9;
        String r11 = BuildConfig.FLAVOR;
    L11:
        if ((r35 & 512) == 0) goto L13;
        long r1 = -1;
    L14:
        r23.getClass();
        Intrinsics.checkNotNullParameter(r26, "toUserId");
        Intrinsics.checkNotNullParameter(r11, "refId");
        if (r25 <= 0) goto L28;
        com.bytedance.android.livesdk.gift.model.h2 r16 = GiftManagerKt.l(r25);
        if (r30 != null) goto L19;
        String r9 = BuildConfig.FLAVOR;
    L20:
        boolean r21 = r13;
        LocateGiftInfo r10 = new LocateGiftInfo(r24, r25, BuildConfig.FLAVOR, 2, true, r28, r9, null, r11, 128, null);
        if (r16 != null) goto L23;
    L26:
        LocateGiftInfo r2 = r10;
        r23.d = r2;
    L27:
        LocateGiftInfo r14 = r2;
    L40:
        LocateGiftInfo r3 = r14;
    L41:
        StringBuilder r4 = new StringBuilder("openGiftDialog giftId=");
        r4.append(r25);
        r4.append(" extra=");
        r4.append(r27);
        r4.append(", ");
        r4.append(r29);
        r4.append(" syncOpen=");
        boolean r5 = r21;
        r4.append(r5);
        jy0.b.a("ttlive_gift_open_dialog", r4.toString());
        if (r5 == false) goto L59;
        zg1.o3 r6 = new zg1.o3(null, r3, r27, r26, r29);
        Bundle r7 = r6.b;
        if (r7 == null) goto L51;
        GiftContext r8 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r8 == null) goto L51;
        com.bytedance.live.datacontext.n<Bundle> r15 = r8.getGiftLogExtra();
        if (r15 == null) goto L51;
        r15.setValue(r7);
    L51:
        if (r6.e == false) goto L55;
        IBaseUser r17 = r23.c(r6.d);
        if (r17 != null) goto L58;
        r17 = r6.a;
    L58:
        r23.g(r17, r6.g, r6.b, r6);
        r23.i.put("data_gift_send_extra", r6.c);
        return;
    L55:
        r17 = r6.a;
        if (r17 != null) goto L58;
        r17 = r23.c(r6.d);
        goto L58
    L59:
        xs2.b.a().post(new zg1.o3(null, r3, r27, r26, r29));
        return;
    L23:
        if (r16.isDisplayedOnPanel() == false) goto L26;
        r2 = r10;
        goto L27
    L19:
        r9 = r30;
        goto L20
    L28:
        r21 = r13;
        if (r1 <= 0) goto L39;
        r3 = new LocateGiftInfo(r24, BuildConfig.FLAVOR, 2, true, r1);
        GiftManagerKt.z.getClass();
        i12.e r18 = i12.o.b();
        com.bytedance.android.livesdk.gift.model.l2 r19 = null;
        if (r18 == null) goto L33;
        Object r20 = com.bytedance.android.scope.m.e.d(r18, PropListService.class);
    L34:
        PropListService r36 = (PropListService) r20;
        if (r36 == null) goto L37;
        r19 = r36.f(Long.valueOf(r1));
    L37:
        if (r19 != null) goto L41;
        r23.d = r3;
        goto L41
    L33:
        r20 = null;
        goto L34
    L39:
        LocateGiftInfo.Companion.getClass();
        r14 = LocateGiftInfo.a.b(r24);
        r23.q.getClass();
        goto L40
    L13:
        r1 = r34;
        goto L14
    L9:
        r11 = r33;
        goto L11
    L5:
        r13 = r31;
        goto L7
    }
}
