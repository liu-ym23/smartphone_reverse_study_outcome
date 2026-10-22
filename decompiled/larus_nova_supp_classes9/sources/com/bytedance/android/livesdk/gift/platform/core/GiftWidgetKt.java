package com.bytedance.android.livesdk.gift.platform.core;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.android.GiftRecyclableWidget;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.gift.IGiftService;
import com.bytedance.android.live.recharge.IRechargeService;
import com.bytedance.android.live.revenue.common.ViewUtilsKt;
import com.bytedance.android.live.revenue.model.extension.IMainRoom;
import com.bytedance.android.livesdk.gift.configmodel.n0;
import com.bytedance.android.livesdk.gift.configmodel.x1;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftViewModelManager;
import com.bytedance.android.livesdk.gift.platform.business.effect.CommonPlayerControllerManager;
import com.bytedance.android.livesdk.gift.platform.business.effect.giftview.VideoGiftView;
import com.bytedance.android.livesdk.gift.platform.business.effect.widget.BaseVideoGiftWidget;
import com.bytedance.android.livesdk.gift.platform.business.effect.widget.VideoGiftWidgetV2;
import com.bytedance.android.livesdk.gift.platform.business.effect.widget.VideoGiftWidgetVS;
import com.bytedance.android.livesdk.gift.platform.business.tray.GiftTrayWidget;
import com.bytedance.android.livesdk.gift.platform.core.manager.GiftEffectManager;
import com.bytedance.android.livesdk.gift.platform.core.manager.GiftManagerKt;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.AssetsService;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.GiftDataStorageService;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.GiftMessageService;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.OpenDialogService;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.SendGiftRelationService;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.e1;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.i2;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.r0;
import com.bytedance.android.livesdk.message.model.i6;
import com.bytedance.android.livesdk.message.model.k6;
import com.bytedance.android.livesdk.message.model.o7;
import com.bytedance.android.livesdk.message.model.q8;
import com.bytedance.android.livesdk.revenue.interactivity.PublicScreenMessageType;
import com.bytedance.android.livesdk.revenue.monitor.EventModule;
import com.bytedance.android.livesdk.revenue.toolbar.RevToolbarButton;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomIMInfo;
import com.bytedance.android.livesdkapi.depend.model.live.IToolbarComponentData;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.kmp.core.KmpEnv;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.live.alphaplayer.controller.PlayerController;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
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
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import org.json.JSONObject;
import zg1.h2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u00042\u00020\u0005:\u0001\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/core/GiftWidgetKt;", "Lcom/bytedance/android/GiftRecyclableWidget;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Lf6/c;", "Lcom/bytedance/android/livesdk/common/i;", "a", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GiftWidgetKt extends GiftRecyclableWidget implements Observer<KVData>, f6.c, com.bytedance.android.livesdk.common.i {
    public Boolean b;
    public IRoom c;
    public GiftMessageService d;
    public BaseVideoGiftWidget e;
    public com.bytedance.android.livesdk.gift.platform.business.tray.k f;
    public GiftTrayWidget g;
    public com.bytedance.android.livesdk.gift.platform.business.toolbar.f h;
    public final CompositeDisposable i;
    public Disposable j;
    public Disposable k;
    public int l;
    public int m;
    public long n;
    public long o;
    public boolean p;
    public boolean q;
    public boolean r;
    public final Lazy s;
    public final i12.e t;
    public final int u;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ GiftWidgetKt a;
        public final /* synthetic */ Ref.ObjectRef b;

        public b(GiftWidgetKt r1, Ref.ObjectRef r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r2) {
            Long r3 = (Long) r2;
            GiftWidgetKt r4 = this.a;
            r4.m = 2;
            if (r4.r == false) goto L10;
            GiftDataStorageService r0 = (GiftDataStorageService) this.b.element;
            if (r0 == null) goto L7;
            int r1 = r0.p;
        L8:
            if (r1 > 0) goto L12;
            GiftWidgetKt.wq(r4);
            return;
        L12:
            return;
        L7:
            r1 = 0;
            goto L8
        L10:
            GiftWidgetKt.wq(r4);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ GiftWidgetKt a;
        public final /* synthetic */ Ref.ObjectRef b;

        public c(GiftWidgetKt r1, Ref.ObjectRef r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r4) {
            Long r5 = (Long) r4;
            GiftWidgetKt r6 = this.a;
            if (r6.r == false) goto L22;
            int r0 = 0;
            if (com.bytedance.android.livesdk.gift.platform.business.i.l().m0() == false) goto L15;
            i12.e r7 = i12.o.b();
            if (r7 == null) goto L9;
            Object r8 = com.bytedance.android.scope.m.e.d(r7, com.bytedance.android.livesdk.gift.platform.core.giftlist.h.class);
        L10:
            com.bytedance.android.livesdk.gift.platform.core.giftlist.h r9 = (com.bytedance.android.livesdk.gift.platform.core.giftlist.h) r8;
            if (r9 == null) goto L15;
            boolean r1 = true;
            if (r9.Si() != true) goto L15;
        L16:
            GiftDataStorageService r10 = (GiftDataStorageService) this.b.element;
            if (r10 == null) goto L19;
            r0 = r10.p;
        L19:
            if (r0 > 0) goto L23;
            if (r1 == true) goto L23;
            this.a.zq();
        L23:
            this.a.l = 2;
            return;
        L9:
            r8 = null;
        L15:
            r1 = false;
            goto L16
        L22:
            r6.zq();
            goto L23
        }
    }

    static {
    }

    public final Widget De() {
        return this;
    }

    public final /* synthetic */ String Lg() {
        return com.bytedance.android.livesdk.common.h.b(this);
    }

    public final /* synthetic */ String cg() {
        return com.bytedance.android.livesdk.common.h.c(this);
    }

    public final int getLayoutId() {
        return 2131568011;
    }

    public final String nc() {
        return "GiftWidgetKt";
    }

    public final /* synthetic */ boolean nq() {
        return com.bytedance.android.livesdk.common.h.a();
    }

    public final void onInit(Object[] r1) {
    }

    public final int supportClearScene() {
        return 341;
    }

    public final GiftTrayWidget hd() {
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.j(((Widget) this).dataCenter) == true) goto L5;
        return null;
    L5:
        if (this.g != null) goto L8;
        this.g = new GiftTrayWidget();
    L8:
        return this.g;
    }

    public final void onUnload() {
        GiftMessageService r0 = this.d;
        int r1 = 0;
        if (r0 == null) goto L5;
        r0.r = false;
    L5:
        com.bytedance.android.scope.j r2 = ((GiftRecyclableWidget) this).a;
        if (r2 == null) goto L10;
        OpenDialogService r3 = (OpenDialogService) com.bytedance.android.scope.m.e.d(r2, OpenDialogService.class);
        if (r3 == null) goto L10;
        r3.onStop();
    L10:
        ((GiftRecyclableWidget) this).a = null;
        zr2.c r4 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.toolbar.e.class).b9(((Widget) this).dataCenter);
        this.b = Boolean.FALSE;
        if (com.bytedance.android.livesdk.gift.platform.core.utils.u.t() == false) goto L13;
        com.bytedance.android.livesdk.gift.platform.business.toolbar.c.c();
    L13:
        com.bytedance.android.livesdk.gift.platform.business.toolbar.f r5 = this.h;
        if (r5 == null) goto L16;
        r4.c(RevToolbarButton.GiftAnimation, r5);
    L16:
        com.bytedance.android.livesdk.gift.platform.business.g r6 = com.bytedance.android.livesdk.gift.util.b.c(false);
        if (r6 == null) goto L19;
        r6.g();
    L19:
        BaseVideoGiftWidget r7 = this.e;
        if (r7 == null) goto L23;
        r7.Cq();
    L23:
        if (this.i.isDisposed() == true) goto L25;
        this.i.dispose();
    L25:
        DataCenter r8 = ((Widget) this).dataCenter;
        if (r8 == null) goto L28;
        r8.removeObserver(this);
    L28:
        String r9 = com.bytedance.android.livesdk.gift.platform.core.utils.h.a;
        Intrinsics.checkNotNullParameter("GiftWidget unLoad", "desc");
        com.bytedance.android.livesdk.gift.platform.core.utils.h.z("GiftWidget unLoad", null, null);
        boolean r10 = GiftEffectManager.a;
        DataCenter r11 = ((Widget) this).dataCenter;
        Intrinsics.checkNotNullParameter(r11, "dataCenter");
        WeakReference<DataCenter> r13 = GiftEffectManager.b;
        if (r13 == null) goto L32;
        DataCenter r14 = r13.get();
    L32:
        if (com.bytedance.android.livesdk.gift.platform.core.utils.x.b() == true) goto L34;
        r11.removeObserver("cmd_gift_effect_is_open", (Observer) GiftEffectManager.g.getValue());
    L34:
        GiftEffectManager.f.clear();
        GiftEffectManager.b = null;
        ((HashMap) GiftManagerKt.o).clear();
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.d.getClass();
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.a.C0075a.e.a.c();
        CommonPlayerControllerManager r15 = (CommonPlayerControllerManager) CommonPlayerControllerManager.b.getValue();
        PlayerController r16 = r15.a;
        if (r16 == null) goto L37;
        r16.release();
    L37:
        PlayerController r17 = r15.a;
        if (r17 == null) goto L40;
        r17.h = null;
    L40:
        if (r17 == null) goto L42;
        r17.g = null;
    L42:
        r15.a = null;
        boolean r18 = d0.a;
        IRoom r19 = this.c;
        if (r19 == null) goto L45;
        r1 = (int) r19.getRoomLayout();
    L45:
        long r20 = this.n;
        long r21 = this.o;
        yz0.k r23 = d0.b();
        if (r23 == null) goto L48;
        long r24 = r23.Hl();
    L49:
        LinkedHashMap r25 = new LinkedHashMap();
        r25.put("room_type", Integer.valueOf(r1));
        LinkedHashMap r26 = new LinkedHashMap();
        r26.put("widget_load", Long.valueOf(r20));
        r26.put("first_chat", Long.valueOf(r21));
        r26.put("room_duration", Long.valueOf(System.currentTimeMillis() - r24));
        String r27 = com.bytedance.android.livesdk.gift.platform.core.utils.z.a("ttlive_room_load_time_status");
        JSONObject r28 = new JSONObject();
        JSONObject r29 = new JSONObject();
        JSONObject r30 = new JSONObject();
        Intrinsics.checkNotNullParameter(r30, "extra");
        Intrinsics.checkNotNullParameter(r29, "metric");
        EventModule r31 = EventModule.LIVE_GIFT;
        Intrinsics.checkNotNullParameter(r31, "eventModule");
        String r33 = r31.getValue();
        Intrinsics.checkNotNullParameter(r28, "map");
        Intrinsics.checkNotNullParameter(r25, "value");
        Iterator r34 = r25.entrySet().iterator();
    L51:
        if (r34.hasNext() == false) goto L53;
        Map.Entry r110 = (Map.Entry) r34.next();
        r28.put((String) r110.getKey(), r110.getValue());
        goto L51
    L53:
        Intrinsics.checkNotNullParameter(r29, "map");
        Intrinsics.checkNotNullParameter(r26, "value");
        Iterator r35 = r26.entrySet().iterator();
    L55:
        if (r35.hasNext() == false) goto L57;
        Map.Entry r36 = (Map.Entry) r35.next();
        r29.put((String) r36.getKey(), r36.getValue());
        goto L55
    L57:
        cy0.e.a.getClass();
        cy0.j r37 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r38 = com.bytedance.android.scope.m.b(r37).b(n97.a.class);
        Intrinsics.checkNotNull(r38);
        ((com.bytedance.live.kmp.core.c) r38).g(r27, r33, "bussiness_api_call", r28, r29, r30);
        e12.a.a = 0;
        Iterator r39 = da0.a.a.iterator();
    L59:
        if (r39.hasNext() == false) goto L61;
        ((ca0.p) r39.next()).j();
        goto L59
    L61:
        return;
    L48:
        r24 = System.currentTimeMillis();
        goto L49
    }

    public final void zq() {
        IRoom r0 = this.c;
        if (r0 != null) goto L5;
        return;
    L5:
        if (((n0) nz1.a.b0.getValue(null, nz1.a.a[52])).a() == true) goto L7;
    L9:
        int r6 = 2;
    L10:
        IGiftService r2 = com.bytedance.android.live.revenue.core.util.f.a(IGiftService.class);
        long r4 = r0.getRoomId();
        boolean r7 = com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.h();
        IBaseUser r1 = r0.getOwner();
        if (r1 == null) goto L14;
        Intrinsics.checkNotNullParameter(r1, "$this$secUidExt");
        String r3 = r1.getCastSecUid();
        if (r3 == null) goto L14;
    L15:
        r2.syncGiftList(null, r4, r6, r7, r3);
        return;
    L14:
        r3 = BuildConfig.FLAVOR;
        goto L15
    L7:
        if (com.bytedance.android.livesdk.gift.platform.core.utils.u.r() == true) goto L9;
        r6 = 13;
        goto L10
    }

    public final View getContentView() {
        return findViewById(2131392305);
    }

    public final Boolean uk() {
        return this.b;
    }

    public static final void wq(GiftWidgetKt r5) {
        r5.getClass();
        boolean r1 = false;
        if (h.e() == false) goto L14;
        AssetsService r0 = (AssetsService) com.bytedance.android.live.revenue.core.util.f.a(AssetsService.class);
        com.bytedance.android.live.revenue.core.a r3 = com.bytedance.android.live.revenue.core.util.k.a();
        if (r3 == null) goto L9;
        yz0.k r4 = com.bytedance.android.live.revenue.core.util.f.c(r3, yz0.k.class);
        if (r4 == null) goto L9;
        r1 = r4.isAnchor();
    L9:
        IRoom r6 = r5.c;
        if (r6 == null) goto L12;
        String r7 = String.valueOf(r6.getRoomId());
    L13:
        r0.S0(2, r1, r7, "GiftWidgetKt1");
        return;
    L12:
        r7 = null;
        goto L13
    L14:
        AssetsService r8 = (AssetsService) com.bytedance.android.live.revenue.core.util.f.a(AssetsService.class);
        com.bytedance.android.live.revenue.core.a r2 = com.bytedance.android.live.revenue.core.util.k.a();
        if (r2 == null) goto L19;
        yz0.k r9 = com.bytedance.android.live.revenue.core.util.f.c(r2, yz0.k.class);
        if (r9 == null) goto L19;
        r1 = r9.isAnchor();
    L19:
        r8.L0(2, r1, "GiftWidgetKt2");
    }

    public final void onChanged(Object r6) {
        KVData r7 = (KVData) r6;
        Intrinsics.checkNotNullParameter(r7, "kvData");
        if (TextUtils.isEmpty(r7.getKey()) == true) goto L115;
        String r0 = r7.getKey();
        long r2 = 0;
        switch(r0.hashCode()) {
            case -1836833765: goto L77;
            case -1357019912: goto L72;
            case -1326907447: goto L65;
            case -763908145: goto L60;
            case 279172201: goto L51;
            case 333436001: goto L33;
            case 373304631: goto L25;
            case 948744782: goto L23;
            case 2110232702: goto L9;
            default: goto L116;
        };
    L23:
        r0.equals("cmd_stop_special_gift");
        return;
    L116:
        return;
    L9:
        if (r0.equals("data_scale_video_gift") == false) goto L83;
        Pair r8 = (Pair) r7.getData();
        if (r8 == null) goto L117;
        BaseVideoGiftWidget r1 = this.e;
        if (r1 == null) goto L84;
        final float r3 = ((Number) r8.getFirst()).floatValue();
        final int r9 = ((Number) r8.getSecond()).intValue();
        final VideoGiftView r4 = r1.e;
        if (r4 == null) goto L85;
        Intrinsics.checkNotNull(r4);
        if (r3 > 0.0f) goto L20;
        return;
    L20:
        if (r3 >= 1.0f) goto L118;
        r4.a.post(new com.bytedance.android.livesdk.gift.platform.business.effect.giftview.h(r4, r3, r9));
        return;
    L118:
        return;
    L85:
        return;
    L84:
        return;
    L117:
        return;
    L83:
        return;
    L25:
        if (r0.equals("cmd_specific_view_loaded") == true) goto L27;
        return;
    L27:
        if ("cmd_first_chat_view_loaded".equals(((Widget) this).dataCenter.get("cmd_specific_view_loaded", BuildConfig.FLAVOR)) == false) goto L90;
        yz0.k r10 = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        if (r10 == null) goto L31;
        r2 = r10.Hl();
    L31:
        this.o = System.currentTimeMillis() - r2;
        return;
    L90:
        return;
    L33:
        if (r0.equals("cmd_gift_dialog_switch") == true) goto L35;
        return;
    L35:
        if (this.r == false) goto L93;
        zg1.f0 r11 = (zg1.f0) r7.getData();
        if (r11 != null) goto L39;
        return;
    L39:
        if (r11.b == true) goto L41;
        return;
    L41:
        if (this.l != 1) goto L46;
        Disposable r13 = this.j;
        if (r13 == null) goto L46;
        r13.dispose();
    L46:
        if (this.m != 1) goto L96;
        Disposable r14 = this.k;
        if (r14 == null) goto L97;
        r14.dispose();
        return;
    L97:
        return;
    L96:
        return;
    L93:
        return;
    L51:
        if (r0.equals("cmd_show_screen") == false) goto L99;
        Boolean r15 = (Boolean) r7.getData(Boolean.TRUE);
        if (r15 == null) goto L100;
        BaseVideoGiftWidget r5 = this.e;
        if (r5 == null) goto L101;
        boolean r16 = r15.booleanValue();
        Intrinsics.checkNotNullParameter("CMD_SHOW_SCREEN", "reason");
        if (r5.e == null) goto L102;
        com.bytedance.android.livesdk.gift.platform.core.utils.c.c(r5.b, "showGiftView " + r16 + " reason:CMD_SHOW_SCREEN");
        r5.er(r16, "CMD_SHOW_SCREEN");
        return;
    L102:
        return;
    L101:
        return;
    L100:
        return;
    L99:
        return;
    L60:
        if (r0.equals("cmd_clear_gift_message") == false) goto L104;
        BaseVideoGiftWidget r17 = this.e;
        if (r17 == null) goto L105;
        r17.Cq();
        return;
    L105:
        return;
    L104:
        return;
    L65:
        if (r0.equals("cmd_reset_video_gift") == false) goto L107;
        BaseVideoGiftWidget r18 = this.e;
        if (r18 == null) goto L108;
        final VideoGiftView r19 = r18.e;
        if (r19 == null) goto L109;
        Intrinsics.checkNotNull(r19);
        r19.a.post(new com.bytedance.android.livesdk.gift.platform.business.effect.giftview.c(r19));
        return;
    L109:
        return;
    L108:
        return;
    L107:
        return;
    L72:
        if (r0.equals("data_pre_show_keyboard") == false) goto L111;
        ViewGroup r20 = ((Widget) this).containerView;
        if (r20 == null) goto L112;
        r20.requestFocus();
        return;
    L112:
        return;
    L111:
        return;
    L77:
        if (r0.equals("cmd_widget_loaded") == false) goto L114;
        yz0.k r21 = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        if (r21 == null) goto L81;
        r2 = r21.Hl();
    L81:
        this.n = System.currentTimeMillis() - r2;
        return;
    L114:
        return;
    }

    public final void onEnterClear(int r5) {
        if (r5 != 1) goto L5;
    L10:
        View r1 = findViewById(2131392305);
        if (r1 == null) goto L13;
        ViewUtilsKt.e(r1);
    L13:
        com.bytedance.android.scope.j r2 = ((GiftRecyclableWidget) this).a;
        if (r2 == null) goto L19;
        com.bytedance.android.livesdk.gift.platform.core.scope.service.j r3 = (com.bytedance.android.livesdk.gift.platform.core.scope.service.j) com.bytedance.android.scope.m.e.d(r2, com.bytedance.android.livesdk.gift.platform.core.scope.service.j.class);
        if (r3 == null) goto L19;
        r3.a.setValue(Boolean.TRUE);
    L19:
        if (r5 != 128) goto L24;
        GiftMessageService r4 = this.d;
        if (r4 == null) goto L24;
        r4.r = true;
    L24:
        if (r5 != 256) goto L29;
        GiftMessageService r6 = this.d;
        if (r6 == null) goto L30;
        r6.r = true;
        return;
    L30:
        return;
    L29:
        return;
    L5:
        if (r5 == 4) goto L10;
        if (r5 == 64) goto L10;
        if (r5 != 16) goto L19;
        goto L10
    }

    public final void onExitClear(int r4) {
        if (r4 != 1) goto L5;
    L10:
        View r0 = findViewById(2131392305);
        if (r0 == null) goto L13;
        ViewUtilsKt.f(r0);
    L13:
        com.bytedance.android.scope.j r1 = ((GiftRecyclableWidget) this).a;
        if (r1 == null) goto L19;
        com.bytedance.android.livesdk.gift.platform.core.scope.service.j r2 = (com.bytedance.android.livesdk.gift.platform.core.scope.service.j) com.bytedance.android.scope.m.e.d(r1, com.bytedance.android.livesdk.gift.platform.core.scope.service.j.class);
        if (r2 == null) goto L19;
        r2.a.setValue(Boolean.FALSE);
    L19:
        if (r4 != 128) goto L24;
        GiftMessageService r3 = this.d;
        if (r3 == null) goto L24;
        r3.r = false;
    L24:
        if (r4 != 256) goto L29;
        GiftMessageService r5 = this.d;
        if (r5 == null) goto L30;
        r5.r = false;
        return;
    L30:
        return;
    L29:
        return;
    L5:
        if (r4 == 4) goto L10;
        if (r4 == 64) goto L10;
        if (r4 != 16) goto L19;
        goto L10
    }

    public final void onLoad(Object[] r17) {
        ((GiftRecyclableWidget) this).a = this.t;
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.j(((Widget) this).dataCenter) == true) goto L5;
    L12:
        enableSubWidgetManager();
        com.bytedance.android.scope.j r1 = ((GiftRecyclableWidget) this).a;
        if (r1 == null) goto L15;
        ((Widget) this).subWidgetManager.setWidgetConfigHandler(new f6.e(r1));
    L15:
        Context r2 = ((Widget) this).context;
        boolean r7 = true;
        if (com.bytedance.android.livesdk.gift.util.b.c(false) == null) goto L81;
        if (r2 == null) goto L81;
        if ((((Widget) this).contentView instanceof ViewGroup) == false) goto L81;
        ArrayList r3 = new ArrayList();
        com.bytedance.android.livesdk.gift.platform.business.g r5 = com.bytedance.android.livesdk.gift.util.b.c(false);
        if (r5 == null) goto L24;
        List<j> r6 = r5.d();
    L25:
        if (r6 == null) goto L41;
        com.bytedance.android.livesdk.gift.platform.business.g r8 = com.bytedance.android.livesdk.gift.util.b.c(false);
        if (r8 == null) goto L29;
        List<j> r9 = r8.d();
    L30:
        Intrinsics.checkNotNull(r9);
        int r10 = r9.size();
        int r11 = 0;
    L31:
        if (r11 >= r10) goto L41;
        com.bytedance.android.livesdk.gift.platform.business.g r13 = com.bytedance.android.livesdk.gift.util.b.c(false);
        if (r13 == null) goto L37;
        List<j> r14 = r13.d();
        if (r14 == null) goto L37;
        j r15 = (j) ListProtector.get(r14, r11);
    L38:
        if (r15 == null) goto L40;
        r3.add(r15);
    L40:
        r11 = r11 + 1;
    L37:
        r15 = null;
        goto L38
    L29:
        r9 = null;
    L41:
        boolean r16 = k60.b.a();
        if (com.bytedance.android.livesdk.gift.platform.core.utils.u.n() == false) goto L44;
        BaseVideoGiftWidget r18 = new VideoGiftWidgetVS();
    L45:
        this.e = r18;
        jy0.b.a("GiftWidgetKt", "VideoGiftWidget " + this.e);
        BaseVideoGiftWidget r19 = this.e;
        Intrinsics.checkNotNull(r19);
        r3.add(new j(r19, 4, r16));
        DataCenter r20 = ((Widget) this).dataCenter;
        n01.a r110 = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), n01.a.class);
        if (r110 == null) goto L48;
        boolean r21 = r110.Q0(r20);
    L49:
        if (r21 == true) goto L51;
    L52:
        com.bytedance.android.livesdk.gift.platform.business.g r23 = com.bytedance.android.livesdk.gift.util.b.c(false);
        if (r23 == null) goto L55;
        com.bytedance.android.livesdk.gift.platform.business.tray.k r24 = r23.a(((Widget) this).dataCenter);
    L56:
        this.f = r24;
        if (r24 != null) goto L60;
        this.f = new GiftTrayWidget();
    L60:
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.j(((Widget) this).dataCenter) == true) goto L67;
        Widget r111 = this.f;
        if (r111 == null) goto L65;
        r3.add(new j(r111, 2, r16));
        goto L67
    L65:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.ies.sdk.widgets.Widget");
    L67:
        if (r3.size() <= 1) goto L70;
        CollectionsKt.sortWith(r3, new v());
    L70:
        if ((((Widget) this).contentView instanceof ViewGroup) == false) goto L81;
        int r25 = r3.size();
        int r26 = 0;
    L72:
        if (r26 >= r25) goto L81;
        j r112 = (j) ListProtector.get(r3, r26);
        ViewGroup r113 = r112.b;
        if (r113 != null) goto L76;
        Context r114 = getContext();
        RelativeLayout.LayoutParams r115 = new RelativeLayout.LayoutParams(-1, -1);
        FrameLayout r116 = new FrameLayout(r114);
        r116.setLayoutParams(r115);
        r116.setId(r26);
        r113 = r116;
    L76:
        r113.setId(View.generateViewId());
        View r117 = ((Widget) this).contentView;
        if (r117 == null) goto L80;
        ((ViewGroup) r117).addView(r113);
        ((Widget) this).subWidgetManager.load(r113, r112.a, r112.d);
        r26 = r26 + 1;
        goto L72
    L80:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L55:
        r24 = null;
        goto L56
    L51:
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.k() == true) goto L67;
    L48:
        r21 = false;
        goto L49
    L44:
        r18 = new VideoGiftWidgetV2();
        goto L45
    L24:
        r6 = null;
    L81:
        GiftContext r4 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r4 == null) goto L88;
        com.bytedance.live.datacontext.m<Boolean> r27 = r4.getNeedSendCloseMessageSwitch();
        if (r27 == null) goto L88;
        if (((Boolean) r27.getValue()).booleanValue() == true) goto L88;
    L125:
        zr2.c r28 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.toolbar.e.class).b9(((Widget) this).dataCenter);
        this.h = new com.bytedance.android.livesdk.gift.platform.business.toolbar.f(com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.h(), com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.k());
        if (com.bytedance.android.livesdk.gift.platform.core.utils.u.t() == false) goto L139;
        DataCenter r29 = ((Widget) this).dataCenter;
        if (r29 == null) goto L130;
        Boolean r30 = (Boolean) r29.get("data_is_portrait", Boolean.TRUE);
    L132:
        if (Intrinsics.areEqual(r30, Boolean.TRUE) == false) goto L137;
        if (this.p == true) goto L139;
        com.bytedance.android.livesdk.gift.platform.core.utils.h.Y();
        this.p = true;
        goto L139
    L137:
        if (this.q == true) goto L139;
        com.bytedance.android.livesdk.gift.platform.core.utils.h.Y();
        this.q = true;
        goto L139
    L130:
        r30 = null;
    L139:
        RevToolbarButton r31 = RevToolbarButton.GiftAnimation;
        com.bytedance.android.livesdk.gift.platform.business.toolbar.f r118 = this.h;
        Intrinsics.checkNotNull(r118);
        r28.e(r31, r118);
        boolean r33 = GiftEffectManager.a;
        DataCenter r34 = ((Widget) this).dataCenter;
        Context r35 = ((Widget) this).context;
        Intrinsics.checkNotNullParameter(r35, "context");
        if (r34 != null) goto L143;
    L146:
        IRoom r36 = com.bytedance.android.livesdk.gift.platform.core.utils.x.a();
        if (r36 != null) goto L149;
        return;
    L149:
        this.c = r36;
        if (r36.isSofaRoom() == true) goto L152;
        jc1.k.n(IRechargeService.class).rechargeCenter().syncFromEnterRoom();
    L152:
        this.r = com.bytedance.android.livesdk.gift.platform.business.a.b().i();
        this.i.clear();
        if (((com.bytedance.android.livesdk.gift.configmodel.d0) h.H0.getValue(null, h.a[84])).e() == true) goto L220;
        com.bytedance.android.livesdk.gift.configmodel.p r37 = com.bytedance.android.livesdk.gift.platform.business.a.b();
        if (r37.d() <= 0) goto L220;
        if (com.bytedance.android.livesdk.gift.platform.core.utils.u.r() == true) goto L220;
        KmpEnv r38 = KmpEnv.a;
        if (KmpEnv.b() == false) goto L189;
        yz0.k r39 = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        if (r39 == null) goto L178;
        List r40 = r39.getToolbarDataList();
        if (r40 == null) goto L178;
        Iterator r41 = r40.iterator();
    L167:
        if (r41.hasNext() == false) goto L174;
        Object r119 = r41.next();
        if (((IToolbarComponentData) r119).getId() != 30) goto L171;
        boolean r120 = true;
    L172:
        if (r120 == false) goto L167;
    L176:
        if (((IToolbarComponentData) r119) == null) goto L178;
        Boolean r43 = Boolean.TRUE;
    L179:
        long r121 = r37.e();
        if (r121 > 0) goto L182;
    L184:
        long r122 = r37.b();
        if (r122 <= 0) goto L220;
        if (Intrinsics.areEqual(r43, Boolean.TRUE) == false) goto L220;
        xq(r122);
        goto L220
    L182:
        if (Intrinsics.areEqual(r43, Boolean.TRUE) == false) goto L184;
        yq(r121, false);
        goto L184
    L171:
        r120 = false;
        goto L172
    L174:
        r119 = null;
    L178:
        r43 = null;
        goto L179
    L189:
        long r123 = r37.e();
        if (r37.c() == false) goto L200;
        i12.e r44 = this.t;
        if (r44 == null) goto L200;
        SendGiftRelationService r45 = (SendGiftRelationService) com.bytedance.android.scope.m.e.d(r44, SendGiftRelationService.class);
        if (r45 == null) goto L200;
        IRoom r46 = this.c;
        if (r46 == null) goto L198;
        String r47 = r46.getAnchorId();
    L199:
        boolean r48 = r45.f(r47);
    L201:
        IRoom r49 = this.c;
        if (r49 == null) goto L215;
        IBaseUser r50 = r49.getOwner();
        if (r50 == null) goto L215;
        if (r50.isFollowing() != true) goto L215;
        IRoom r51 = this.c;
        if (r51 == null) goto L210;
        String r53 = r51.isEcomCart();
    L212:
        if ((!Intrinsics.areEqual(r53, "1")) == false) goto L215;
        r123 = r37.f();
        r48 = r37.c();
        goto L215
    L210:
        r53 = null;
    L215:
        if (r123 <= 0) goto L217;
        yq(r123, r48);
    L217:
        long r54 = r37.b();
        if (r54 <= 0) goto L220;
        xq(r54);
        goto L220
    L198:
        r47 = null;
    L200:
        r48 = false;
    L220:
        ReadOnlyProperty r55 = com.bytedance.android.livesdk.gift.platform.business.b.L;
        KProperty[] r56 = com.bytedance.android.livesdk.gift.platform.business.b.a;
        x1 r57 = (x1) r55.getValue(null, r56[36]);
        if (r57.b() == false) goto L235;
        int r58 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class).getCurrentScene();
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.h() == false) goto L226;
    L234:
        this.i.add(Observable.timer(r57.c(), TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(w.a));
        goto L235
    L226:
        if (r58 == 5) goto L234;
        if (r58 == 16) goto L234;
        if (r58 != 0) goto L235;
        IRoom r59 = this.c;
        if (r59 == null) goto L235;
        if (r59.isLiveTypeAudio() == true) goto L234;
    L235:
        ((Widget) this).dataCenter.observeForever("cmd_clear_gift_message", this).observe("cmd_stop_special_gift", this).observe("cmd_do_send_gift", this).observe("cmd_gift_entry_click", this).observe("data_pre_show_keyboard", this).observe("data_scale_video_gift", this).observe("cmd_reset_video_gift", this).observe("cmd_show_screen", this).observe("data_online_changed_list", this).observe("cmd_widget_loaded", this).observe("cmd_gift_dialog_switch", this).observe("cmd_specific_view_loaded", this);
        boolean r60 = GiftEffectManager.a;
        DataCenter r61 = ((Widget) this).dataCenter;
        Context r124 = ((Widget) this).context;
        IRoom r125 = this.c;
        Intrinsics.checkNotNull(r125);
        long r126 = r125.getId();
        Intrinsics.checkNotNullParameter(r61, "dataCenter");
        Intrinsics.checkNotNullParameter(r124, "context");
        Disposable r63 = vh6.c.b(cr2.a.class).t4().subscribe(com.bytedance.android.livesdk.gift.platform.core.manager.c.a, com.bytedance.android.livesdk.gift.platform.core.manager.d.a);
        CompositeDisposable r127 = GiftEffectManager.f;
        RxUtilKt.c(r63, r127);
        RxUtilKt.c(vh6.c.b(tq2.b.class).Yf().subscribe(com.bytedance.android.livesdk.gift.platform.core.manager.e.a, com.bytedance.android.livesdk.gift.platform.core.manager.f.a), r127);
        GiftEffectManager.b = new WeakReference(r61);
        new WeakReference(r124);
        if (GiftEffectManager.c == r126) goto L238;
        GiftEffectManager.a = true;
    L238:
        GiftEffectManager.e = false;
        GiftEffectManager.d = false;
        GiftEffectManager.c = r126;
        Lazy r64 = GiftEffectManager.g;
        r61.removeObserver("cmd_gift_effect_is_open", (Observer) r64.getValue());
        r61.put("cmd_gift_effect_is_open", Boolean.valueOf(GiftEffectManager.a));
        WeakReference<DataCenter> r128 = GiftEffectManager.b;
        if (r128 == null) goto L242;
        DataCenter r129 = r128.get();
    L242:
        if (com.bytedance.android.livesdk.gift.platform.core.utils.x.b() == true) goto L244;
        r61.observe("cmd_gift_effect_is_open", (Observer) r64.getValue());
    L244:
        com.bytedance.android.live.revenue.core.util.j.a r65 = com.bytedance.android.live.revenue.core.util.j.C0;
        yz0.k r66 = com.bytedance.android.live.revenue.core.util.f.d(r65.a(), yz0.k.class);
        if (r66 != null) goto L247;
    L254:
        yz0.k r67 = com.bytedance.android.live.revenue.core.util.f.d(r65.a(), yz0.k.class);
        if (r67 == null) goto L260;
        if (r67.isAnchor() != true) goto L260;
    L283:
        FragmentActivity r68 = ((Widget) this).context;
        if (r68 == null) goto L405;
        ((GiftViewModelManager) ViewModelProviders.of(r68).get(GiftViewModelManager.class)).setDataCenter(((Widget) this).dataCenter);
        DataCenter r69 = ((Widget) this).dataCenter;
        if (r69 == null) goto L290;
        Boolean r70 = (Boolean) r69.get("data_is_portrait", Boolean.TRUE);
        if (r70 == null) goto L290;
        boolean r71 = r70.booleanValue();
    L292:
        if (com.bytedance.android.livesdk.gift.platform.core.utils.u.p() == false) goto L302;
        if (r71 == false) goto L302;
        IRoom r73 = this.c;
        if (r73 == null) goto L299;
        IRoomAuthStatus r74 = r73.getRoomAuthStatus();
        if (r74 == null) goto L299;
        boolean r75 = r74.getEnableGift();
    L300:
        if (r75 == false) goto L302;
        com.bytedance.android.livesdk.gift.util.b.f(new GiftStateMachineConfig.Event.v(false, false, 2, false));
    L299:
        r75 = true;
    L302:
        com.bytedance.android.scope.j r76 = ((GiftRecyclableWidget) this).a;
        if (r76 == null) goto L305;
        GiftMessageService r77 = (GiftMessageService) com.bytedance.android.scope.m.e.d(r76, GiftMessageService.class);
    L306:
        this.d = r77;
        if (r77 == null) goto L311;
        NextLiveData<k6> r78 = r77.b;
        if (r78 == null) goto L311;
        r78.observe(this, new m(this));
    L311:
        GiftMessageService r79 = this.d;
        if (r79 == null) goto L316;
        NextLiveData<i6> r80 = r79.a;
        if (r80 == null) goto L316;
        r80.observe(this, new n(this));
    L316:
        GiftMessageService r81 = this.d;
        if (r81 == null) goto L321;
        NextLiveData<o7> r83 = r81.e;
        if (r83 == null) goto L321;
        r83.observe(this, new o(this));
    L321:
        GiftMessageService r84 = this.d;
        if (r84 == null) goto L326;
        NextLiveData<o7> r85 = r84.f;
        if (r85 == null) goto L326;
        r85.observe(this, new p(this));
    L326:
        GiftMessageService r86 = this.d;
        if (r86 == null) goto L331;
        NextLiveData<o7> r87 = r86.g;
        if (r87 == null) goto L331;
        r87.observe(this, new q(this));
    L331:
        GiftMessageService r88 = this.d;
        if (r88 == null) goto L336;
        NextLiveData<q8> r89 = r88.c;
        if (r89 == null) goto L336;
        r89.observe(this, new r(this));
    L336:
        GiftMessageService r90 = this.d;
        if (r90 == null) goto L341;
        NextLiveData<Long> r91 = r90.h;
        if (r91 == null) goto L341;
        r91.observe(this, new s(this));
    L341:
        GiftMessageService r93 = this.d;
        if (r93 == null) goto L346;
        NextLiveData<gm2.g> r94 = r93.d;
        if (r94 == null) goto L346;
        r94.observe(this, new t(this));
    L346:
        com.bytedance.android.scope.j r95 = ((GiftRecyclableWidget) this).a;
        if (r95 == null) goto L349;
        r0 r96 = (r0) com.bytedance.android.scope.m.e.d(r95, r0.class);
    L350:
        if (r96 == null) goto L355;
        NextLiveData<h2> r97 = r96.c;
        if (r97 == null) goto L355;
        r97.observe(this, new u(this));
    L355:
        if (((Boolean) this.s.getValue()).booleanValue() == true) goto L366;
        Context r98 = ((Widget) this).context;
        if (r98 == null) goto L366;
        long r99 = System.currentTimeMillis();
        long r100 = com.bytedance.android.livesdk.gift.platform.core.utils.y.a;
        if (r100 == 0) goto L363;
        if ((r99 - r100) <= 86400000) goto L366;
    L363:
        if (((Boolean) com.bytedance.android.livesdk.gift.platform.business.b.D.getValue(null, r56[28])).booleanValue() == true) goto L366;
        r98.getApplicationContext().getSharedPreferences("clean_storage_pref", 0).edit().putLong("live_enter_date", r99).apply();
        com.bytedance.android.livesdk.gift.platform.core.utils.y.a = r99;
    L366:
        if (d0.b == false) goto L398;
        com.bytedance.tools.kcp.spongepreference.runtime.a r101 = ay1.b.Q;
        KProperty[] r102 = ay1.b.a;
        long r103 = ((Number) r101.getValue(null, r102[54])).longValue();
        if (r103 != 0) goto L371;
        r101.setValue(null, r102[54], Long.valueOf(System.currentTimeMillis()));
        goto L398
    L371:
        Calendar r104 = Calendar.getInstance();
        r104.setTimeInMillis(r103);
        int r105 = r104.get(11);
        int r130 = r104.get(6);
        r104.setTimeInMillis(System.currentTimeMillis());
        int r106 = r104.get(11);
        if (r104.get(6) == r130) goto L375;
        r101.setValue(null, r102[54], Long.valueOf(System.currentTimeMillis()));
        ay1.b.R.setValue(null, r102[55], Boolean.FALSE);
        goto L398
    L375:
        if (r105 > 17) goto L398;
        if (r106 < 18) goto L398;
        com.bytedance.tools.kcp.spongepreference.runtime.a r131 = ay1.b.R;
        if (((Boolean) r131.getValue(null, r102[55])).booleanValue() == true) goto L398;
        if (1 > r105) goto L390;
        if (17 < r105) goto L390;
        if (18 > r106) goto L390;
        if (23 < r106) goto L390;
    L391:
        if (r7 == false) goto L398;
        r131.setValue(null, r102[55], Boolean.TRUE);
        JSONObject r107 = new JSONObject();
        d0.o(r107, "today_first_play_time", Integer.valueOf(r105));
        d0.o(r107, "today_second_play_time", Integer.valueOf(r106));
        String r132 = com.bytedance.android.livesdk.gift.platform.core.utils.z.a("ttlive_user_play_mode_status");
        JSONObject r133 = new JSONObject();
        JSONObject r134 = new JSONObject();
        JSONObject r135 = new JSONObject();
        Intrinsics.checkNotNullParameter(r135, "extra");
        Intrinsics.checkNotNullParameter(r134, "metric");
        EventModule r108 = EventModule.LIVE_GIFT;
        Intrinsics.checkNotNullParameter(r108, "eventModule");
        String r136 = r108.getValue();
        r134.put("status", String.valueOf(0));
        Intrinsics.checkNotNullParameter(r135, "map");
        Iterator<String> r109 = r107.keys();
    L395:
        if (r109.hasNext() == false) goto L397;
        String r137 = r109.next();
        Object r138 = r107.get(r137);
        Intrinsics.checkNotNullParameter(r137, "key");
        Intrinsics.checkNotNullParameter(r138, "value");
        r135.put(r137, r138);
        goto L395
    L397:
        cy0.e.a.getClass();
        cy0.j r139 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r140 = com.bytedance.android.scope.m.b(r139).b(n97.a.class);
        Intrinsics.checkNotNull(r140);
        ((com.bytedance.live.kmp.core.c) r140).g(r132, r136, "bussiness_api_call", r133, r134, r135);
    L390:
        r7 = false;
    L398:
        int r141 = e12.a.b;
        e12.a.a = System.currentTimeMillis();
        Iterator r142 = da0.a.a.iterator();
    L400:
        if (r142.hasNext() == false) goto L402;
        ((ca0.p) r142.next()).n();
        goto L400
    L402:
        jy0.b.a("GiftWidgetKt", "GiftWidgetKt = " + System.currentTimeMillis());
        return;
    L349:
        r96 = null;
        goto L350
    L305:
        r77 = null;
    L290:
        r71 = true;
        goto L292
    L405:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    L260:
        if (h.j().d() == false) goto L283;
        i12.e r143 = i12.o.b();
        if (r143 == null) goto L265;
        Object r144 = com.bytedance.android.scope.m.e.d(r143, i2.class);
    L267:
        if (((i2) r144) == null) goto L269;
        boolean r145 = i2.d();
    L270:
        GiftEffectManager.a = r145;
        WeakReference<DataCenter> r146 = GiftEffectManager.b;
        if (r146 == null) goto L275;
        DataCenter r147 = r146.get();
        if (r147 == null) goto L275;
        Boolean r148 = (Boolean) r147.get("cmd_gift_effect_is_open", Boolean.TRUE);
    L277:
        if ((!Intrinsics.areEqual(r148, Boolean.valueOf(r145))) == false) goto L283;
        WeakReference<DataCenter> r149 = GiftEffectManager.b;
        if (r149 == null) goto L283;
        DataCenter r150 = r149.get();
        if (r150 == null) goto L283;
        r150.put("cmd_gift_effect_is_open", Boolean.valueOf(r145));
    L275:
        r148 = null;
        goto L277
    L269:
        r145 = true;
        goto L270
    L265:
        r144 = null;
        goto L267
    L247:
        if (r66.isAnchor() != true) goto L254;
        WeakReference<DataCenter> r151 = GiftEffectManager.b;
        if (r151 == null) goto L254;
        DataCenter r152 = r151.get();
        if (r152 == null) goto L254;
        r152.observe("cmd_widget_loaded", com.bytedance.android.livesdk.gift.platform.core.manager.b.a);
        goto L254
    L143:
        if (h.j().d() == false) goto L145;
        vh6.c.b(com.bytedance.android.livesdk.revenue.service.toolbar.e.class).tg(r34).e(RevToolbarButton.GiftEffect, new com.bytedance.android.livesdk.gift.platform.business.toolbar.b(r34, r35));
        goto L146
    L145:
        vh6.c.b(com.bytedance.android.livesdk.revenue.service.toolbar.e.class).tg(r34).e(RevToolbarButton.GiftEffect, new com.bytedance.android.livesdk.gift.platform.business.toolbar.k(r34));
    L88:
        DataCenter r153 = ((Widget) this).dataCenter;
        if (r153 == null) goto L91;
        IRoom r154 = (IRoom) r153.get("data_room", null);
    L92:
        if (r154 == null) goto L125;
        IRoomAuthStatus r155 = r154.getRoomAuthStatus();
        if (r155 == null) goto L125;
        if (r155.getEnableGift() == true) goto L125;
        IMainRoom r156 = r154.castToOrNull(IMainRoom.class);
        if (r156 == null) goto L102;
        Map r157 = r156.getAnchorAbMap();
        if (r157 == null) goto L102;
        String r158 = (String) r157.get("gift_hide_tip");
    L104:
        if (Intrinsics.areEqual(r158, "2") == false) goto L125;
        IRoomIMInfo r159 = r154.getRoomIMInfo();
        if (r159 == null) goto L108;
        String r160 = r159.getHideGiftMessage();
    L110:
        if (TextUtils.isEmpty(r160) == true) goto L116;
        IRoomIMInfo r161 = r154.getRoomIMInfo();
        if (r161 == null) goto L115;
        String r162 = r161.getHideGiftMessage();
        if (r162 == null) goto L115;
    L117:
        String r163 = r162;
        gz0.b r164 = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), gz0.b.class);
        if (r164 == null) goto L120;
        r164.t0(PublicScreenMessageType.DISABLE_GIFT_NOTICE, r163, null, false, false, true);
    L120:
        GiftContext r165 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r165 == null) goto L125;
        com.bytedance.live.datacontext.m<Boolean> r166 = r165.getNeedSendCloseMessageSwitch();
        if (r166 == null) goto L125;
        r166.setValue(Boolean.FALSE);
    L115:
        r162 = s1.B(2131915839);
        goto L117
    L116:
        r162 = s1.B(2131915839);
        goto L117
    L108:
        r160 = null;
    L102:
        r158 = null;
        goto L104
    L91:
        r154 = null;
        goto L92
    L5:
        if (((Boolean) com.bytedance.android.livesdk.gift.platform.business.b.y.getValue(null, com.bytedance.android.livesdk.gift.platform.business.b.a[23])).booleanValue() == false) goto L12;
        if (this.g != null) goto L9;
        this.g = new GiftTrayWidget();
    L9:
        GiftTrayWidget r167 = this.g;
        if (r167 == null) goto L12;
        ((Widget) this).widgetCallback.getWidgetManager().load(this.u, r167);
        goto L12
    }

    public final void qo(Boolean r1) {
        this.b = r1;
    }

    public final void xq(long r6) {
        if (com.bytedance.android.livesdk.gift.platform.business.a.b().g() == true) goto L9;
        long r0 = Long.valueOf(((e1) com.bytedance.android.live.revenue.core.util.f.a(e1.class)).a).longValue();
        IRoom r2 = this.c;
        if (r2 == null) goto L9;
        if (r0 != r2.getRoomId()) goto L9;
        return;
    L9:
        Ref.ObjectRef r1 = new Ref.ObjectRef();
        i12.e r3 = i12.o.b();
        if (r3 == null) goto L12;
        Object r4 = com.bytedance.android.scope.m.e.d(r3, GiftDataStorageService.class);
    L13:
        GiftDataStorageService r5 = (GiftDataStorageService) r4;
        r1.element = r5;
        if (this.r == true) goto L16;
    L21:
        this.m = 1;
        Disposable r7 = Observable.timer(r6, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this, r1));
        this.k = r7;
        CompositeDisposable r8 = this.i;
        Intrinsics.checkNotNull(r7);
        r8.add(r7);
        return;
    L16:
        if (r5 == null) goto L18;
        int r9 = r5.p;
    L19:
        if (r9 <= 0) goto L21;
        return;
    L18:
        r9 = 0;
        goto L19
    L12:
        r4 = null;
        goto L13
    }

    public GiftWidgetKt(i12.e r1, int r2) {
        this.t = r1;
        this.u = r2;
        this.b = Boolean.FALSE;
        this.i = new CompositeDisposable();
        this.s = LazyKt.lazy(GiftWidgetKt$offlineEnterRoomTime$2.INSTANCE);
    }

    public final void yq(long r6, boolean r8) {
        if (com.bytedance.android.livesdk.gift.platform.business.a.b().h() == true) goto L9;
        long r0 = Long.valueOf(((e1) com.bytedance.android.live.revenue.core.util.f.a(e1.class)).a).longValue();
        IRoom r2 = this.c;
        if (r2 == null) goto L9;
        if (r0 != r2.getRoomId()) goto L9;
        return;
    L9:
        Ref.ObjectRef r1 = new Ref.ObjectRef();
        i12.e r3 = i12.o.b();
        if (r3 == null) goto L12;
        Object r4 = com.bytedance.android.scope.m.e.d(r3, GiftDataStorageService.class);
    L13:
        GiftDataStorageService r5 = (GiftDataStorageService) r4;
        r1.element = r5;
        if (this.r == true) goto L16;
    L21:
        if (r8 == false) goto L24;
        zq();
        return;
    L24:
        this.l = 1;
        Disposable r7 = Observable.timer(r6, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(this, r1));
        this.j = r7;
        CompositeDisposable r9 = this.i;
        Intrinsics.checkNotNull(r7);
        r9.add(r7);
        return;
    L16:
        if (r5 == null) goto L18;
        int r10 = r5.p;
    L19:
        if (r10 <= 0) goto L21;
        return;
    L18:
        r10 = 0;
        goto L19
    L12:
        r4 = null;
        goto L13
    }
}
