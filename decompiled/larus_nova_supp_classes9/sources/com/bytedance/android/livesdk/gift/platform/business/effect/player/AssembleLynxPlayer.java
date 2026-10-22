package com.bytedance.android.livesdk.gift.platform.business.effect.player;

import android.app.Activity;
import android.content.res.Resources;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.browser.jsbridge.base.CloseGiftWebViewResultModel;
import com.bytedance.android.live.revenue.common.ViewUtilsKt;
import com.bytedance.android.live.revenue.common.x0;
import com.bytedance.android.live.revlink.api.ILinkService;
import com.bytedance.android.livehostapi.TTMiddlewareLiveSDK;
import com.bytedance.android.livesdk.gift.configmodel.l2;
import com.bytedance.android.livesdk.gift.effect.model.EffectMessage;
import com.bytedance.android.livesdk.gift.model.ExtraEffectDisplayFrom;
import com.bytedance.android.livesdk.gift.model.a1;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.j3;
import com.bytedance.android.livesdk.gift.model.n3;
import com.bytedance.android.livesdk.gift.model.w;
import com.bytedance.android.livesdk.gift.platform.business.config.GiftConfigKey;
import com.bytedance.android.livesdk.gift.platform.business.effect.giftview.AssembleLynxGiftView;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.android.livesdk.gift.platform.core.a0;
import com.bytedance.android.livesdk.gift.platform.core.utils.GiftLynxEffectMonitor$findLynxView$$inlined$filterIsInstance$1;
import com.bytedance.android.livesdk.gift.platform.core.utils.g0;
import com.bytedance.android.livesdkapi.depend.live.gift.IPlayerActionListener;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.Gson;
import com.lynx.tasm.LynxView;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import gd0.v;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import w20.f8;
import w20.x;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class AssembleLynxPlayer implements com.bytedance.android.livesdk.gift.platform.business.effect.player.a {
    public final AssembleLynxGiftView a;
    public final Map<String, com.bytedance.ies.web.jsbridge2.f.b> b;
    public final Map<String, String> c;
    public IPlayerActionListener d;
    public final com.bytedance.android.livesdk.gift.platform.core.utils.j e;
    public final boolean f;
    public final b g;
    public final AssembleLynxPlayer$regionObserver$1 h;
    public final AssembleLynxPlayer$streamObserver$1 i;
    public int j;
    public final DataCenter k;
    public final ViewGroup l;
    public final Activity m;

    public static final class a implements com.bytedance.ies.web.jsbridge2.f.b {
        public final /* synthetic */ AssembleLynxPlayer a;

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.gift.platform.business.effect.player.AssembleLynxPlayer$a$a, reason: collision with other inner class name */
        public static final class C0055a extends x<f8, CloseGiftWebViewResultModel> {
            public final /* synthetic */ a a;

            public C0055a(a r1) {
                this.a = r1;
            }

            public final void invoke(Object r2, CallContext r3) {
                Intrinsics.checkNotNullParameter((f8) r2, "params");
                Intrinsics.checkNotNullParameter(r3, "context");
                AssembleLynxGiftView r4 = this.a.a.a;
                if (r4 == null) goto L5;
                r4.a();
            L5:
                IPlayerActionListener r5 = this.a.a.d;
                if (r5 == null) goto L8;
                r5.onEnd();
            L8:
                this.a.a.e.a("close_gift_jsb");
            }
        }

        public a(AssembleLynxPlayer r1) {
            this.a = r1;
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new C0055a(this);
        }
    }

    public static final class b extends com.bytedance.android.livesdk.gift.platform.business.effect.giftview.lynxView.a {
        public final /* synthetic */ AssembleLynxPlayer a;

        @Override // com.bytedance.android.livesdk.gift.platform.business.effect.giftview.lynxView.a
        public final void a() {
            IPlayerActionListener r0 = this.a.d;
            if (r0 == null) goto L5;
            r0.onEnd();
        L5:
            this.a.e.a("load_failed");
        }

        public b(AssembleLynxPlayer r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.livesdk.gift.platform.business.effect.giftview.lynxView.a
        public final void b(View r4) {
            Intrinsics.checkNotNullParameter(r4, "lynxView");
            Intrinsics.checkNotNullParameter(r4, "lynxView");
            IPlayerActionListener r0 = this.a.d;
            if (r0 == null) goto L5;
            r0.onStart();
        L5:
            com.bytedance.android.livesdk.gift.platform.core.utils.j r1 = this.a.e;
            r1.getClass();
            Intrinsics.checkNotNullParameter(r4, "view");
            r1.g = System.currentTimeMillis();
            r1.b.b();
            if ((r4 instanceof LynxView) == false) goto L8;
            View r2 = r4;
        L21:
            if (r2 == null) goto L23;
            r1.c = new g0();
            return;
        L23:
            Objects.toString(r4);
            return;
        L8:
            r2 = null;
            if ((r4 instanceof ViewGroup) == true) goto L11;
            View r3 = null;
        L12:
            ViewGroup r5 = (ViewGroup) r3;
            if (r5 == null) goto L21;
            Sequence r6 = ViewUtilsKt.a(r5);
            if (r6 == null) goto L21;
            Sequence r7 = SequencesKt.filter(r6, GiftLynxEffectMonitor$findLynxView$$inlined$filterIsInstance$1.INSTANCE);
            if (r7 == null) goto L20;
            r2 = (LynxView) SequencesKt.firstOrNull(r7);
            goto L21
        L20:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.sequences.Sequence<R>");
        L11:
            r3 = r4;
            goto L12
        }
    }

    public static int b() {
        com.bytedance.android.live.revenue.core.util.j.a r0 = com.bytedance.android.live.revenue.core.util.j.C0;
        com.bytedance.android.livesdk.revenue.service.room.c r1 = (dy0.b) com.bytedance.android.live.revenue.core.util.e.c(r0.a(), com.bytedance.android.livesdk.revenue.service.room.c.class);
        boolean r2 = false;
        if (r1 == null) goto L11;
        com.bytedance.android.livesdk.revenue.room.a r3 = r1.getRoomContext();
        if (r3 == null) goto L11;
        com.bytedance.live.datacontext.i r4 = r3.isAnchor();
        if (r4 == null) goto L11;
        Boolean r5 = (Boolean) r4.getValue();
        if (r5 == null) goto L11;
        boolean r6 = r5.booleanValue();
    L12:
        Integer r7 = null;
        if (r6 == false) goto L19;
        com.bytedance.android.livesdk.revenue.service.interact.d r8 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class);
        if (r8 == null) goto L18;
        r7 = Integer.valueOf(r8.getCurrentScene());
    L18:
        return r7.intValue();
    L19:
        com.bytedance.android.livesdk.revenue.service.room.c r9 = (dy0.b) com.bytedance.android.live.revenue.core.util.e.c(r0.a(), com.bytedance.android.livesdk.revenue.service.room.c.class);
        if (r9 == null) goto L28;
        com.bytedance.android.livesdk.revenue.room.a r10 = r9.getRoomContext();
        if (r10 == null) goto L28;
        com.bytedance.live.datacontext.m r11 = r10.getRoom();
        if (r11 == null) goto L28;
        IRoom r13 = (IRoom) r11.getValue();
        if (r13 == null) goto L28;
        LiveMode r14 = r13.getStreamType();
    L30:
        if (r14 != LiveMode.THIRD_PARTY) goto L32;
        r2 = true;
    L32:
        if (r2 == true) goto L38;
        com.bytedance.android.livesdk.revenue.service.interact.d r15 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class);
        if (r15 == null) goto L37;
        r7 = Integer.valueOf(r15.getCurrentScene());
    L37:
        return r7.intValue();
    L38:
        int r16 = x12.b.a();
        if (v.a(r16, 4) == false) goto L42;
        return 1;
    L42:
        if (v.a(r16, 64) == false) goto L45;
        return 7;
    L45:
        com.bytedance.android.livesdk.revenue.service.interact.d r17 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class);
        if (r17 == null) goto L49;
        r7 = Integer.valueOf(r17.getCurrentScene());
    L49:
        return r7.intValue();
    L28:
        r14 = null;
    L11:
        r6 = false;
        goto L12
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.player.a
    public final void onCancel() {
        AssembleLynxGiftView r0 = this.a;
        if (r0 == null) goto L5;
        r0.a();
    L5:
        kc0.i r1 = com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class).getLinkRegionServiceExternal();
        if (r1 == null) goto L8;
        r1.unRegisterRegionObserver(this.h);
    L8:
        kc0.i r2 = com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class).getLinkRegionServiceExternal();
        if (r2 == null) goto L12;
        r2.unRegisterRegionObserver(this.i);
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.player.a
    public final void onDestroy() {
        AssembleLynxGiftView r0 = this.a;
        if (r0 == null) goto L5;
        r0.a();
    L5:
        this.l.removeView(this.a);
        IPlayerActionListener r1 = this.d;
        if (r1 == null) goto L8;
        r1.onEnd();
    L8:
        this.e.a("unload");
        kc0.i r2 = com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class).getLinkRegionServiceExternal();
        if (r2 == null) goto L11;
        r2.unRegisterRegionObserver(this.h);
    L11:
        kc0.i r3 = com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class).getLinkRegionServiceExternal();
        if (r3 == null) goto L15;
        r3.unRegisterRegionObserver(this.i);
        return;
    }

    public final Activity getActivity() {
        return this.m;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.player.a
    public final i02.b a(EffectMessage r21, com.bytedance.android.live.core.resources.e r23) {
        Intrinsics.checkNotNullParameter(r21, "msg");
        Intrinsics.checkNotNullParameter(r23, "assets");
        long r4 = System.currentTimeMillis();
        Boolean r0 = (Boolean) this.k.get("data_is_portrait", Boolean.TRUE);
        boolean r6 = com.bytedance.android.livesdk.gift.platform.core.utils.u.s();
        if (com.bytedance.android.livesdk.gift.platform.core.utils.x.b() == false) goto L5;
    L13:
        boolean r1 = true;
    L15:
        if (r1 == false) goto L18;
        int r2 = i02.b.e;
        return i02.b.a.a(6);
    L18:
        String r3 = r21.d;
        if (r3 != null) goto L21;
    L24:
        boolean r5 = true;
    L26:
        if (r5 == false) goto L30;
        com.bytedance.android.livesdk.gift.platform.core.utils.c.b("AssembleLynxPlayer", "resourceLocalPath is empty and return false");
        int r7 = i02.b.e;
        return i02.b.a.a(7);
    L30:
        if (r21.e.isEmpty() == false) goto L33;
        com.bytedance.android.livesdk.gift.platform.core.utils.c.b("AssembleLynxPlayer", "assetsInfos is empty");
        int r8 = i02.b.e;
        return i02.b.a.a(8);
    L33:
        String r9 = String.valueOf(r21.l);
        String r11 = "1";
        if (r21.H == false) goto L36;
        Object r10 = "1";
    L37:
        IRoom r13 = com.bytedance.android.livesdk.gift.platform.core.utils.x.a();
        if (r13 == null) goto L40;
        long r16 = r13.getRoomId();
    L41:
        String r14 = String.valueOf(r16);
        HashMap r15 = new HashMap();
        r15.put("gift_id", r9);
        r15.put("is_own_room", r10);
        r15.put("show_room_id", r14);
        r15.put("room_link_status", "single");
        r15.put("asset_predownload", String.valueOf(r21.I));
        kc0.e r17 = com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class).getRevLinkControlService();
        if (r17 == null) goto L46;
        Map r18 = r17.h();
        if (r18 == null) goto L46;
        r15.putAll(r18);
    L46:
        r15.put("message_id", String.valueOf(r21.a));
        List<n3> r19 = r21.P;
        if (r19 != null) goto L49;
    L52:
        boolean r20 = true;
    L53:
        if (r20 == false) goto L55;
        Object r24 = "0";
    L56:
        r15.put("is_series_send", r24);
        IBaseUser r25 = r21.i;
        if (r25 == null) goto L59;
        String r26 = r25.getIdString();
    L60:
        IBaseUser r110 = com.bytedance.android.live.revenue.core.util.f.a(l01.d.class).b();
        if (Intrinsics.areEqual(r110.getIdString(), r26) == false) goto L63;
        Object r27 = "1";
        char r111 = 'n';
    L64:
        r15.put("is_gift_sender", r27);
        com.bytedance.android.livesdk.revenue.service.room.c r28 = (dy0.b) com.bytedance.android.live.revenue.core.util.e.c(com.bytedance.android.live.revenue.core.util.j.C0.a(), com.bytedance.android.livesdk.revenue.service.room.c.class);
        if (r28 == null) goto L73;
        com.bytedance.android.livesdk.revenue.room.a r29 = r28.getRoomContext();
        if (r29 == null) goto L73;
        com.bytedance.live.datacontext.i r30 = r29.isAnchor();
        if (r30 == null) goto L73;
        Boolean r31 = (Boolean) r30.getValue();
        if (r31 == null) goto L73;
        boolean r33 = r31.booleanValue();
    L74:
        List<String> r34 = r21.A;
        if (r34 != null) goto L77;
    L80:
        boolean r35 = true;
    L82:
        if (r35 == false) goto L84;
        if (r33 == false) goto L88;
    L87:
        Object r36 = "1";
        char r37 = 'd';
    L89:
        r15.put("is_gift_receiver", r36);
        r15.put("effect_id", String.valueOf(r21.b));
        r15.put("gift_type", String.valueOf(r21.u));
        r15.put("gift_effect_type", String.valueOf(r21.f));
        Long r38 = (Long) ((HashMap) r21.B).get(6);
        if (r38 == null) goto L92;
        long r39 = r38.longValue();
    L93:
        Long r40 = (Long) ((HashMap) r21.B).get(7);
        if (r40 == null) goto L96;
        long r41 = r40.longValue();
    L97:
        r15.put("download_time", String.valueOf(r41 - r39));
        if (r37 == 'x') goto L101;
        v12.e.a(r15, r21);
    L101:
        if (this.f == false) goto L107;
        if (r37 == 'd') goto L106;
        if (r37 != 'n') goto L107;
        String r43 = "livesdk_gift_effect_show_sender";
    L108:
        mz0.n r44 = new mz0.n();
        Map r45 = r44.a;
        Intrinsics.checkNotNullParameter(r45, "map");
        Intrinsics.checkNotNullParameter(r15, "map");
        r45.putAll(r15);
        cy0.e.a.getClass();
        cy0.j r46 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r47 = com.bytedance.android.scope.m.b(r46).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r47);
        ((f80.a) r47).w3(r43, r44.a, r44.b);
        ((LinkedHashMap) this.c).clear();
        this.c.put("modelPath", "file://" + r21.d);
        this.c.put("primaryEffectId", String.valueOf(r23.getId()));
        this.c.put("giftId", String.valueOf(r21.l));
        this.c.put("send_time", String.valueOf(r21.x));
        Map<String, String> r48 = this.c;
        IBaseUser r49 = r21.i;
        if (r49 == null) goto L111;
        String r50 = r49.getIdString();
    L112:
        String r51 = BuildConfig.FLAVOR;
        if (r50 != null) goto L115;
        r50 = BuildConfig.FLAVOR;
    L115:
        r48.put("sender_user_id", r50);
        Map<String, String> r53 = this.c;
        h1 r54 = r21.C;
        if (r54 == null) goto L118;
        Integer r55 = Integer.valueOf(r54.getDiamondCount());
    L119:
        r53.put("money", String.valueOf(r55));
        Map<String, String> r56 = this.c;
        String r57 = String.valueOf(r21.J);
        if (r57 != null) goto L122;
        r57 = "0";
    L122:
        r56.put("privilege_level", r57);
        p11.h r58 = com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class).getPkService();
        if (r58 == null) goto L125;
        Boolean r59 = Boolean.valueOf(r58.isInCloudCollaborate());
    L127:
        if (r59.booleanValue() == true) goto L138;
        GiftContext r60 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r60 == null) goto L137;
        com.bytedance.live.datacontext.m<ca0.i> r61 = r60.getGiftRenderFilterWrapper();
        if (r61 == null) goto L137;
        ca0.i r63 = (ca0.i) r61.getValue();
        if (r63 == null) goto L137;
        if (r63.i(a30.m.g()) == true) goto L138;
    L137:
        boolean r112 = false;
    L139:
        Map<String, String> r64 = this.c;
        if (r112 == true) goto L143;
        r11 = "0";
    L143:
        r64.put("effect_degrade", r11);
        j3 r65 = r21.E;
        if (r65 != null) goto L146;
    L199:
        p11.i r66 = com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class).getLinkRegionService();
        if (r66 == null) goto L202;
        Map r67 = r66.getRevRegions();
    L203:
        LinkedHashMap r68 = new LinkedHashMap();
        if (r67 == null) goto L227;
        Set r69 = r67.keySet();
        if (r69 == null) goto L227;
        Iterator r70 = r69.iterator();
    L209:
        if (r70.hasNext() == false) goto L227;
        String r113 = (String) r70.next();
        LinkedHashMap r114 = new LinkedHashMap();
        dq2.r r115 = (dq2.r) r67.get(r113);
        int r116 = com.bytedance.android.live.revenue.common.i.a;
        if (r115 == null) goto L213;
        float r117 = r115.d;
    L214:
        Resources r118 = TTMiddlewareLiveSDK.getContext().getApplicationContext().getResources();
        r114.put("w", Integer.valueOf((int) ((r117 / WindowDisplayMetricsOverride.apply(r118, r118.getDisplayMetrics()).density) + 0.5f)));
        if (r115 == null) goto L217;
        float r119 = r115.e;
    L218:
        Resources r120 = TTMiddlewareLiveSDK.getContext().getApplicationContext().getResources();
        r114.put("h", Integer.valueOf((int) ((r119 / WindowDisplayMetricsOverride.apply(r120, r120.getDisplayMetrics()).density) + 0.5f)));
        if (r115 == null) goto L221;
        float r121 = r115.b;
    L222:
        Resources r122 = TTMiddlewareLiveSDK.getContext().getApplicationContext().getResources();
        r114.put(sz1.a.KEY_X, Integer.valueOf((int) ((r121 / WindowDisplayMetricsOverride.apply(r122, r122.getDisplayMetrics()).density) + 0.5f)));
        if (r115 == null) goto L225;
        float r123 = r115.c;
    L226:
        Resources r124 = TTMiddlewareLiveSDK.getContext().getApplicationContext().getResources();
        r114.put(sz1.a.KEY_Y, Integer.valueOf((int) ((r123 / WindowDisplayMetricsOverride.apply(r124, r124.getDisplayMetrics()).density) + 0.5f)));
        r68.put(r113, r114);
        goto L209
    L225:
        r123 = 0.0f;
        goto L226
    L221:
        r121 = 0.0f;
        goto L222
    L217:
        r119 = 0.0f;
        goto L218
    L213:
        r117 = 0.0f;
    L227:
        Gson r71 = new Gson();
        this.c.put("linkedUsers", GsonProtectorUtils.toJson(r71, r68));
        this.c.put("is_source_room", String.valueOf(r21.H));
        this.c.put("interactive_scene", String.valueOf(b()));
        Map r73 = com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class).getUidToStreamRegionKeyMap();
        if (r73 == null) goto L254;
        this.c.put("areaKeyMap", GsonProtectorUtils.toJson(r71, r73));
        qr2.c r74 = vh6.c.b(qr2.c.class);
        if (r74 == null) goto L235;
        if (r74.isInSelfAnchorLink() != true) goto L235;
    L244:
        boolean r125 = true;
    L245:
        this.c.put("isGuest", String.valueOf(r125));
        GiftContext r75 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r75 == null) goto L252;
        com.bytedance.live.datacontext.i<Map<String, CopyOnWriteArrayList<String>>> r76 = r75.getLoadedEffectResourceMap();
        if (r76 == null) goto L252;
        Map r77 = (Map) r76.getValue();
        if (r77 == null) goto L252;
        CopyOnWriteArrayList r78 = (CopyOnWriteArrayList) r77.get(BuildConfig.FLAVOR);
    L253:
        this.c.put("giftLoadedEffectResource", GsonProtectorUtils.toJson(r71, r78));
    L252:
        r78 = null;
    L235:
        if (((Boolean) a0.h.getValue(null, a0.a[6])).booleanValue() == false) goto L244;
        GiftContext r79 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r79 == null) goto L244;
        com.bytedance.live.datacontext.m<Boolean> r80 = r79.getHasLinkEffectSo();
        if (r80 == null) goto L244;
        if (((Boolean) r80.getValue()).booleanValue() != true) goto L244;
        r125 = false;
    L254:
        kc0.i r81 = com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class).getLinkRegionServiceExternal();
        if (r81 == null) goto L257;
        r81.unRegisterRegionObserver(this.h);
    L257:
        kc0.i r83 = com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class).getLinkRegionServiceExternal();
        if (r83 == null) goto L260;
        r83.registerRegionObserver(this.h);
    L260:
        kc0.i r84 = com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class).getLinkRegionServiceExternal();
        if (r84 == null) goto L263;
        r84.unRegisterRegionObserver(this.i);
    L263:
        kc0.i r85 = com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class).getLinkRegionServiceExternal();
        if (r85 == null) goto L266;
        r85.registerRegionObserver(this.i);
    L266:
        w r86 = r21.F;
        if (r86 == null) goto L269;
        Long r87 = Long.valueOf(r86.getAssetId());
    L270:
        if (r87 == null) goto L280;
        w r88 = r21.F;
        if (r88 == null) goto L280;
        if (r88.getDisplayFrom() != ExtraEffectDisplayFrom.DisplayFormParalell.getValue()) goto L280;
        Map<String, String> r89 = this.c;
        w r90 = r21.F;
        if (r90 == null) goto L278;
        Long r91 = Long.valueOf(r90.getAssetId());
    L279:
        r89.put("atmosphereAssetId", String.valueOf(r91));
        goto L280
    L278:
        r91 = null;
    L280:
        String r93 = r21.s;
        if (r93 == null) goto L283;
        this.c.put("itemList", r93);
    L283:
        Map<String, String> r94 = this.c;
        a1 r95 = r21.t;
        if (r95 == null) goto L294;
        py.k r96 = r95.getAnchorDiyOriginImg();
        if (r96 == null) goto L294;
        List r97 = r96.getUrls();
        if (r97 == null) goto L294;
        if (r97.size() <= 0) goto L292;
        String r98 = Uri.encode((String) ListProtector.get(r97, 0));
    L293:
        if (r98 == null) goto L294;
    L295:
        r94.put("anchorImage", r98);
        Map<Long, iy1.a> r99 = r21.e;
        LinkedHashMap r100 = new LinkedHashMap();
        Iterator<Map.Entry<Long, iy1.a>> r101 = r99.entrySet().iterator();
    L297:
        if (r101.hasNext() == false) goto L299;
        Map.Entry<Long, iy1.a> r102 = r101.next();
        r100.put(r102.getKey(), "file://" + r102.getValue().a);
        goto L297
    L299:
        this.c.put("assetList", GsonProtectorUtils.toJson(GsonHelper.get(), r100));
        int r103 = m02.g.a;
        ReadOnlyProperty r104 = com.bytedance.android.livesdk.gift.platform.core.h.S;
        KProperty[] r105 = com.bytedance.android.livesdk.gift.platform.core.h.a;
        if (((l2) r104.getValue(null, r105[43])).a() == false) goto L312;
        long r126 = r23.getId();
        Map<Long, String> r106 = ((l2) r104.getValue(null, r105[43])).b();
        if (r106 == null) goto L312;
        if (r106.get(Long.valueOf(r126)) == null) goto L312;
        String r107 = r106.get(Long.valueOf(r126));
        Intrinsics.checkNotNull(r107);
        if (r107.length() <= 0) goto L308;
        boolean r127 = true;
    L309:
        if (r127 == false) goto L312;
        String r108 = r106.get(Long.valueOf(r126));
        Intrinsics.checkNotNull(r108);
        String r109 = r108;
    L311:
        r51 = r109;
    L314:
        Intrinsics.checkNotNullParameter(r51, "url");
        x0 r128 = new x0(r51);     // Catch: Exception -> L317
        m02.g.a(r128);     // Catch: Exception -> L317
        r51 = r128.toString();     // Catch: Exception -> L317
    L319:
        com.bytedance.android.livesdk.gift.platform.business.effect.giftview.lynxView.b r129 = new com.bytedance.android.livesdk.gift.platform.business.effect.giftview.lynxView.b(r51, this.c, this.b, this.g);
        this.j = b();
        AssembleLynxGiftView r130 = this.a;
        if (r130 == null) goto L322;
        r130.b(this.m, r129);
    L322:
        com.bytedance.android.livesdk.gift.platform.core.utils.j r131 = this.e;
        r131.getClass();
        Intrinsics.checkNotNullParameter(r21, "effectMsg");
        if (r131.d != null) goto L325;
    L327:
        boolean r132 = false;
    L328:
        if (r132 == false) goto L330;
        r131.a("next_gift_start");
    L330:
        r131.d = null;
        r131.e = 0;
        r131.f = 0;
        r131.g = 0;
        r131.b.a();
        r131.c = null;
        r131.h++;
        r131.d = r21;
        r131.e = r4;
        r131.f = System.currentTimeMillis();
        Iterator r133 = da0.a.a.iterator();
    L332:
        if (r133.hasNext() == false) goto L334;
        ((ca0.p) r133.next()).s();
        goto L332
    L334:
        int r134 = i02.b.e;
        return new i02.b(true, false, false, 0);
    L325:
        if (r131.e <= 0) goto L327;
        r132 = true;
    L317:
        e = move-exception;
        jy0.b.a("V8ConfigUtils", "resetV8ConfigFromSetting error " + e.getMessage());
        goto L319
    L308:
        r127 = false;
    L312:
        r109 = r23.getLynxSchema();
        if (r109 != null) goto L311;
    L292:
        r98 = BuildConfig.FLAVOR;
    L294:
        r98 = BuildConfig.FLAVOR;
        goto L295
    L269:
        r87 = null;
        goto L270
    L202:
        r67 = null;
        goto L203
    L146:
        if (r65.getId() == null) goto L152;
        Map<String, String> r135 = this.c;
        j3 r136 = r21.E;
        if (r136 == null) goto L150;
        String r137 = r136.getId();
    L151:
        r135.put("sendTogether", String.valueOf(r137));
        goto L152
    L150:
        r137 = null;
    L152:
        Map<String, String> r138 = this.c;
        h1 r139 = r21.C;
        if (r139 == null) goto L168;
        py.k r140 = r139.getImage();
        if (r140 == null) goto L168;
        List r141 = r140.getUrls();
        if (r141 == null) goto L168;
        if (r141.size() <= 0) goto L161;
        boolean r142 = true;
    L162:
        if (r142 == true) goto L165;
        r141 = null;
    L165:
        if (r141 == null) goto L168;
        String r143 = (String) ListProtector.get(r141, 0);
        if (r143 == null) goto L168;
    L169:
        r138.put("gift_icon", r143);
        Map<String, String> r144 = this.c;
        h1 r145 = r21.C;
        if (r145 == null) goto L174;
        String r146 = r145.getName();
        if (r146 == null) goto L174;
    L175:
        r144.put("gift_name", r146);
        Map<String, String> r147 = this.c;
        IBaseUser r148 = r21.i;
        if (r148 == null) goto L191;
        py.k r149 = r148.getAvatarThumbKt();
        if (r149 == null) goto L191;
        List r150 = r149.getUrls();
        if (r150 == null) goto L191;
        if (r150.size() <= 0) goto L184;
        boolean r151 = true;
    L185:
        if (r151 == true) goto L188;
        r150 = null;
    L188:
        if (r150 == null) goto L191;
        String r152 = (String) ListProtector.get(r150, 0);
        if (r152 == null) goto L191;
    L192:
        r147.put("sender_avatar", r152);
        Map<String, String> r153 = this.c;
        IBaseUser r154 = r21.i;
        if (r154 == null) goto L197;
        String r155 = r154.getNickName();
        if (r155 == null) goto L197;
    L198:
        r153.put("sender_name", r155);
    L197:
        r155 = BuildConfig.FLAVOR;
        goto L198
    L184:
        r151 = false;
    L191:
        r152 = BuildConfig.FLAVOR;
    L174:
        r146 = BuildConfig.FLAVOR;
        goto L175
    L161:
        r142 = false;
    L168:
        r143 = BuildConfig.FLAVOR;
    L138:
        r112 = true;
        goto L139
    L125:
        r59 = null;
        goto L127
    L118:
        r55 = null;
        goto L119
    L111:
        r50 = null;
        goto L112
    L106:
        r43 = "livesdk_gift_effect_show_anchor";
    L107:
        r43 = "livesdk_gift_effect_show";
        goto L108
    L96:
        r41 = 0;
        goto L97
    L92:
        r39 = 0;
    L88:
        r36 = "0";
        r37 = r111;
        goto L89
    L84:
        if (r21.A.contains(r110.getIdString()) == false) goto L88;
    L77:
        if (r34.isEmpty() == true) goto L80;
        r35 = false;
    L73:
        r33 = false;
        goto L74
    L63:
        r27 = "0";
        r111 = 'x';
        goto L64
    L59:
        r26 = null;
        goto L60
    L55:
        r24 = "1";
        goto L56
    L49:
        if (r19.isEmpty() == true) goto L52;
        r20 = false;
        goto L53
    L40:
        r16 = 0;
        goto L41
    L36:
        r10 = "0";
        goto L37
    L21:
        if (r3.length() == 0) goto L24;
        r5 = false;
        goto L26
    L5:
        if (r0.booleanValue() == true) goto L9;
        if (((Boolean) com.bytedance.android.livesdk.gift.util.b.a().c(GiftConfigKey.KEY_VIDEO_GIFT_ENABLE_LANDSCAPE_EFFECT, Boolean.FALSE)).booleanValue() == false) goto L13;
    L9:
        if (r21.o == true) goto L13;
        if (r6 == true) goto L13;
        r1 = false;
        goto L15
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.bytedance.android.livesdk.gift.platform.business.effect.player.AssembleLynxPlayer$regionObserver$1] */
    /* JADX WARN: Type inference failed for: r0v5, types: [com.bytedance.android.livesdk.gift.platform.business.effect.player.AssembleLynxPlayer$streamObserver$1] */
    public AssembleLynxPlayer(DataCenter r6, ViewGroup r7, Activity r8) {
        Intrinsics.checkNotNullParameter(r6, "dataCenter");
        Intrinsics.checkNotNullParameter(r7, "container");
        Intrinsics.checkNotNullParameter(r8, "activity");
        this.k = r6;
        this.l = r7;
        this.m = r8;
        LinkedHashMap r9 = new LinkedHashMap();
        this.b = r9;
        this.c = new LinkedHashMap();
        this.e = new com.bytedance.android.livesdk.gift.platform.core.utils.j();
        this.f = m12.b.a();
        a r10 = new a(this);
        this.g = new b(this);
        this.h = new AssembleLynxPlayer$regionObserver$1(this);
        this.i = new AssembleLynxPlayer$streamObserver$1(this);
        AssembleLynxGiftView r0 = new AssembleLynxGiftView(r7.getContext(), null, 6, 0);
        this.a = r0;
        r7.addView(r0);
        r9.put("closeGiftWebView", r10);
    }
}
