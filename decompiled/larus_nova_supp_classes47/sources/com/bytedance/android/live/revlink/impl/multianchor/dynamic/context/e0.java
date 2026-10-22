package com.bytedance.android.live.revlink.impl.multianchor.dynamic.context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.link.data.RevPkResult;
import com.bytedance.android.live.link.data.RevPkState;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revenue.common.player.vendor.link.RevSeiFrame;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.PkBaseDataContext;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.PkBaseStateMachine;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.PkBaseResult;
import com.bytedance.android.live.revlink.impl.monitor.LiveFullLinkPKMonitor;
import com.bytedance.android.live.revlink.impl.multianchor.dynamic.FormatType;
import com.bytedance.android.live.revlink.impl.multianchor.profit.ProfitInteractionDataContext;
import com.bytedance.android.live.revlink.impl.multianchor.ui.UILayout;
import com.bytedance.android.live.revlink.impl.multianchor.utils.MultiEnterRoomTracer;
import com.bytedance.android.live.revlink.impl.plantform.AnchorLinkUserCenterV2;
import com.bytedance.android.live.revlink.impl.region.RevLinkWindowRegionContext;
import com.bytedance.android.live.revlink.link.domain.dependencyimpl.DynamicContextDependencyImpl;
import com.bytedance.android.livesdk.link.model.IBattleConfigSetting;
import com.bytedance.android.livesdk.link.model.IBattleUserInfo;
import com.bytedance.android.livesdk.link.model.api.IBaseBattleSetting;
import com.bytedance.android.livesdk.link.model.c8;
import com.bytedance.android.livesdk.link.model.n3;
import com.bytedance.android.livesdk.link.model.x2;
import com.bytedance.android.livesdk.model.RevSeiRegion;
import com.bytedance.android.livesdk.revenue.service.livecore.IRegion;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e0 implements d {
    public final Map<String, LiveData<Pair<String, JSONObject>>> A;
    public List<? extends IRegion> B;
    public final Function0<Integer> C;
    public final ld.a D;
    public final com.bytedance.android.livesdk.revenue.service.room.c E;
    public final com.bytedance.android.live.revlink.impl.global.c F;
    public final com.bytedance.android.live.revlink.impl.mergepk.pkbase.e G;
    public final e H;
    public final i11.c I;
    public final o J;
    public final com.bytedance.android.live.revlink.impl.multianchor.ui.i K;
    public final String L;
    public final com.bytedance.android.live.revlink.impl.global.c M;
    public final MutableLiveData<JSONObject> a;
    public final MutableLiveData<String> b;
    public final MutableLiveData<f31.i> c;
    public final CompositeDisposable d;
    public String e;
    public final MutableLiveData<JSONObject> f;
    public final MutableLiveData<Long> g;
    public final MutableLiveData<String> h;
    public final MutableLiveData<String> i;
    public final MutableLiveData<String> j;
    public final MutableLiveData<JSONObject> k;
    public final MutableLiveData<Integer> l;
    public final MutableLiveData<Boolean> m;
    public final boolean n;
    public final MutableLiveData<JSONObject> o;
    public final MutableLiveData<List<com.bytedance.android.livesdk.link.model.e>> p;
    public final MutableLiveData<List<com.bytedance.android.livesdk.link.model.p>> q;
    public final MutableLiveData<Boolean> r;
    public final w s;
    public final RevLinkDynamicDataContext$needShowLastResultObserver$1 t;
    public final RevLinkDynamicDataContext$onPartnerEnableObserver$1 u;
    public final RevLinkDynamicDataContext$onMixStreamObserver$1 v;
    public final d0 w;
    public final r x;
    public final RevLinkDynamicDataContext$pkStateObserver$1 y;
    public final HashMap<String, LiveData<?>> z;

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.d
    public final void g(zy0.b r1) {
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.d
    public final com.bytedance.android.live.revlink.impl.monitor.b a() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.F;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getPkEnterRoomTracer();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.d
    public final LiveFullLinkPKMonitor d() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.F;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getLiveFullLinkPKMonitor();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.d
    public final MultiEnterRoomTracer e() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.F;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.i7();
    }

    public final JSONArray j() {
        JSONArray r0 = new JSONArray();
        ld.a r1 = this.D;
        if (r1 == null) goto L12;
        NextLiveData r2 = r1.q2();
        if (r2 == null) goto L12;
        List r3 = (List) r2.getValue();
        if (r3 == null) goto L12;
        Iterator r4 = r3.iterator();
    L10:
        if (r4.hasNext() == false) goto L12;
        m11.b r5 = (m11.b) r4.next();
        JSONObject r6 = new JSONObject();
        r6.put("id", r5.c());
        r6.put("talking", r5.e());
        r6.put("silence_status", r5.d());
        r6.put("belong_user_id", r5.b());
        r0.put(r6);
    L12:
        return r0;
    }

    public final String k() {
        com.bytedance.android.livesdk.revenue.service.room.c r0 = this.E;
        if (r0 == null) goto L12;
        com.bytedance.android.livesdk.revenue.room.a r1 = r0.getRoomContext();
        if (r1 == null) goto L12;
        IRoomBase r2 = r1.getCommonRoom();
        if (r2 == null) goto L12;
        IBaseUser r3 = r2.getOwnerKt();
        if (r3 == null) goto L12;
        String r4 = r3.getIdString();
        if (r4 == null) goto L12;
        return r4;
    L12:
        return "";
    }

    public final ProfitInteractionDataContext l() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.F;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.vj();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.d
    public final HashMap<String, LiveData<?>> b() {
        return this.z;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.d
    public final LiveData getChangeScreenEvent() {
        return this.r;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.d
    public final LiveData getWindowStatus() {
        return this.c;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.d
    public final Map<String, LiveData<Pair<String, JSONObject>>> h() {
        return this.A;
    }

    public static final void i(e0 r8) {
        r8.getClass();
        JSONObject r0 = new JSONObject();
        ld.a r1 = r8.D;
        Integer r2 = null;
        if (r1 == null) goto L7;
        NextLiveData r3 = r1.Fc();
        if (r3 == null) goto L7;
        Boolean r4 = (Boolean) r3.getValue();
    L8:
        Boolean r5 = Boolean.TRUE;
        if (Intrinsics.areEqual(r4, r5) == false) goto L11;
        List r6 = vh6.c.b(qr2.c.class).yi(true);
    L12:
        ld.a r7 = r8.D;
        if (r7 == null) goto L17;
        NextLiveData r9 = r7.z9();
        if (r9 == null) goto L17;
        Boolean r10 = (Boolean) r9.getValue();
    L19:
        if (Intrinsics.areEqual(r10, r5) == false) goto L21;
        List r12 = vh6.c.b(qr2.c.class).yi(false);
    L22:
        if (r6 == null) goto L24;
        Integer r13 = Integer.valueOf(r6.size());
    L25:
        r0.put("left_guest_count", r13);
        if (r6 == null) goto L31;
        List r14 = r6;
        ArrayList r15 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10));
        Iterator r16 = r14.iterator();
    L29:
        if (r16.hasNext() == false) goto L32;
        r15.add(new JSONObject(com.bytedance.android.live.revlink.impl.multianchor.dynamic.e.e((ILinkPlayerInfoBridge) r16.next())));
    L32:
        int r17 = com.bytedance.revenue.platform.api.core.b.a;
        List r18 = r15;
        if (r15 != null) goto L35;
        r18 = CollectionsKt.emptyList();
    L35:
        r0.put("left_guest_list", JSONObject.wrap(r18));
        if (r12 == null) goto L41;
        List r19 = r12;
        ArrayList r20 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r19, 10));
        Iterator r22 = r19.iterator();
    L39:
        if (r22.hasNext() == false) goto L42;
        r20.add(new JSONObject(com.bytedance.android.live.revlink.impl.multianchor.dynamic.e.e((ILinkPlayerInfoBridge) r22.next())));
    L42:
        int r23 = com.bytedance.revenue.platform.api.core.b.a;
        List r24 = r20;
        if (r20 != null) goto L45;
        r24 = CollectionsKt.emptyList();
    L45:
        r0.put("right_guest_list", JSONObject.wrap(r24));
        if (r12 == null) goto L48;
        r2 = Integer.valueOf(r12.size());
    L48:
        r0.put("right_guest_count", r2);
        r8.o.setValue(r0);
        return;
    L41:
        r20 = null;
        goto L42
    L31:
        r15 = null;
        goto L32
    L24:
        r13 = null;
        goto L25
    L21:
        r12 = CollectionsKt.emptyList();
    L17:
        r10 = null;
        goto L19
    L11:
        r6 = CollectionsKt.emptyList();
    L7:
        r4 = null;
        goto L8
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.d
    public final String f(String r4) {
        Intrinsics.checkNotNullParameter(r4, "key");
        if (this.z.containsKey(r4) == false) goto L35;
        LiveData<?> r0 = this.z.get(r4);
        Object r2 = null;
        if (r0 == null) goto L7;
        Object r1 = r0.getValue();
    L9:
        if ((r1 instanceof String) == false) goto L17;
        LiveData<?> r5 = this.z.get(r4);
        if (r5 == null) goto L13;
        r2 = r5.getValue();
    L13:
        if (r2 == null) goto L16;
        return (String) r2;
    L16:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    L17:
        LiveData<?> r3 = this.z.get(r4);
        if (r3 == null) goto L20;
        Object r6 = r3.getValue();
    L22:
        if ((r6 instanceof JSONObject) == false) goto L30;
        LiveData<?> r7 = this.z.get(r4);
        if (r7 == null) goto L79;
        Object r8 = r7.getValue();
        if (r8 == null) goto L80;
        String r9 = r8.toString();
        if (r9 != null) goto L86;
        return "";
    L86:
        return r9;
    L80:
        return "";
    L79:
        return "";
    L30:
        LiveData<?> r10 = this.z.get(r4);
        if (r10 == null) goto L33;
        r2 = r10.getValue();
    L33:
        r9 = GsonProtectorUtils.toJson(l97.a.a, r2);
        goto L86
    L20:
        r6 = null;
        goto L22
    L7:
        r1 = null;
        goto L9
    L35:
        if (Intrinsics.areEqual(r4, "linkmic_score") == false) goto L47;
        ProfitInteractionDataContext r12 = l();
        if (r12 == null) goto L44;
        com.bytedance.live.datacontext.n<c8> r13 = r12.getCurrentMessage();
        if (r13 == null) goto L44;
        c8 r14 = (c8) r13.getValue();
        if (r14 == null) goto L44;
        Object r15 = r14.getAnchorInfoMap();
        if (r15 == null) goto L44;
    L81:
        return r15.toString();
    L44:
        r15 = new JSONObject();
        goto L81
    L47:
        if (Intrinsics.areEqual(r4, "prop_card_info") == false) goto L56;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r16 = this.G;
        if (r16 == null) goto L82;
        LiveData<String> r17 = r16.getBattleEffectInfo();
        if (r17 == null) goto L83;
        r9 = (String) r17.getValue();
        if (r9 != null) goto L86;
        return "";
    L83:
        return "";
    L82:
        return "";
    L56:
        if (Intrinsics.areEqual(r4, "battle_settings") == false) goto L66;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r18 = this.G;
        if (r18 == null) goto L84;
        IBattleConfigSetting r19 = r18.getConfigSetting();
        if (r19 == null) goto L85;
        r9 = r19.toString();
        if (r9 != null) goto L86;
        return "";
    L85:
        return "";
    L84:
        return "";
    L66:
        if (Intrinsics.areEqual(r4, "play_anchor_list") == false) goto L75;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r20 = this.G;
        if (r20 == null) goto L87;
        Map<String, IBattleUserInfo> r22 = r20.getUserInfoMap();
        if (r22 == null) goto L88;
        r9 = r22.toString();
        if (r9 != null) goto L86;
        return "";
    L88:
        return "";
    L87:
        return "";
    L75:
        if (Intrinsics.areEqual(r4, "play_duration") == true) goto L77;
        return "";
    L77:
        return String.valueOf(l51.a.j());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v1, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* JADX WARN: Type inference failed for: r17v0, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r17v1 */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.lang.Object, org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r4v7, types: [java.lang.Object, org.json.JSONArray] */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5, types: [int] */
    /* JADX WARN: Type inference failed for: r7v8, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v9 */
    /* JADX WARN: Type inference failed for: r9v8, types: [java.lang.Object, org.json.JSONObject] */
    public final void m(f31.i r27) {
        e0 r0 = this;
        com.bytedance.android.live.revlink.impl.global.c r2 = r0.F;
        if (r2 == null) goto L7;
        LinkCrossRoomDataHolder r3 = r2.getLinkCrossRoomDataHolder();
        if (r3 == null) goto L7;
        String r4 = String.valueOf(r3.c());
    L9:
        if ((!Intrinsics.areEqual(r4, (String) r0.b.getValue())) == false) goto L17;
        MutableLiveData<String> r5 = r0.b;
        com.bytedance.android.live.revlink.impl.global.c r6 = r0.F;
        if (r6 == null) goto L15;
        LinkCrossRoomDataHolder r7 = r6.getLinkCrossRoomDataHolder();
        if (r7 == null) goto L15;
        String r8 = String.valueOf(r7.c());
    L16:
        r5.setValue(r8);
    L15:
        r8 = null;
    L17:
        if (r27 == null) goto L19;
        List<f31.k> r9 = r27.a;
    L20:
        List<f31.k> r10 = r9;
        if (r10 != null) goto L23;
    L26:
        boolean r12 = true;
    L27:
        if (r12 == false) goto L29;
        return;
    L29:
        JSONObject r13 = new JSONObject();
        JSONObject r14 = r27.e;
        RevSeiFrame r15 = r27.d;
        d51.b r16 = d51.b.m;
        r16.getClass();
        String r17 = "";
        String r18 = "ai_user_infos";
        if (((Boolean) d51.b.k.getValue(r16, d51.b.a[9])).booleanValue() == false) goto L36;
        if (r14 == null) goto L36;
        JSONArray r19 = j();
        if (r19.length() <= 0) goto L35;
        r14.put("ai_user_infos", r19);
    L35:
        List<f31.k> r110 = r9;
        JSONObject r111 = r13;
        String r22 = "";
        e0 r20 = r0;
        ?? r23 = r14;
    L158:
        ?? r1 = r111;
        r1.put("app_data", r23);
        int r24 = f31.l.e(r110);
        int r25 = f31.l.a(r110);
        f31.l.c(r110);
        f31.l.d(r110);
        JSONObject r26 = new JSONObject();
        b03.a r28 = b03.a.a;
        r26.put("screen_width", Float.valueOf(b03.c.c(s1.y())));
        r26.put("screen_height", Float.valueOf(b03.c.c(s1.w())));
        r26.put("container_width", r24);
        r26.put("container_height", r25);
        com.bytedance.android.live.revlink.impl.global.c r29 = r20.F;
        if (r29 == null) goto L164;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r30 = r29.Ig();
        if (r30 == null) goto L164;
        List<String> r32 = r30.getAudioPunishUserIds();
        if (r32 == null) goto L164;
    L165:
        r26.put("punish_user_ids", new JSONArray(r32));
        Integer r33 = r27.f;
        if (r33 == null) goto L168;
        r26.put("meta_sei_container_height", r33.intValue());
    L168:
        Integer r34 = r27.g;
        if (r34 == null) goto L171;
        r26.put("meta_sei_container_width", r34.intValue());
    L171:
        String r35 = r27.b;
        if (r35 != null) goto L174;
        r35 = r20.e;
    L174:
        if (r35 != null) goto L176;
        String r112 = r22;
    L177:
        r1.put("meta_sei", r112);
        r1.put("extra_info", r26);
        r20.a.setValue(r1);
        return;
    L176:
        r112 = r35;
    L164:
        r32 = CollectionsKt.emptyList();
    L36:
        if (r14 == null) goto L38;
        com.bytedance.android.livesdk.model.p0 r36 = com.bytedance.android.live.revlink.impl.utils.h.a(r14);
    L39:
        ?? r113 = new JSONObject();
        r113.put("ver", 6);
        o r114 = r0.J;
        if (r114 == null) goto L42;
        String r115 = r114.c();
    L43:
        JSONObject r116 = new JSONObject();
        if (r115 != null) goto L46;
        r115 = DataType.FALSE;
    L46:
        r116.put("focus_id", r115);
        o r117 = r0.J;
        if (r117 == null) goto L49;
        Integer r118 = r117.a();
    L50:
        r116.put("layout_type", r118);
        o r119 = r0.J;
        if (r119 == null) goto L53;
        Integer r120 = r119.b();
    L54:
        r116.put("layout_range", r120);
        Iterator<f31.k> r121 = r9.iterator();
        int r122 = 0;
    L56:
        if (r121.hasNext() == false) goto L68;
        f31.k r37 = r121.next();
        String r38 = r0.L;
        if (r38 != null) goto L60;
    L64:
        boolean r39 = false;
    L65:
        if (r39 == true) goto L69;
        r122 = r122 + 1;
    L69:
        r116.put("owner_index", RangesKt.coerceAtLeast(r122, 0));
        com.bytedance.android.live.revlink.impl.global.c r40 = r0.F;
        if (r40 == null) goto L74;
        com.bytedance.android.live.revlink.impl.multianchor.utils.w r42 = r40.getMultiLinkUtil();
        if (r42 == null) goto L74;
        UILayout r43 = r42.b();
    L76:
        if (r43 != UILayout.FULL_RECORD) goto L78;
        r116.put("is_horizontal", 1);
    L78:
        r113.put("anchor_interact_info", r116);
        if (r15 == null) goto L89;
        if (r15.p() != true) goto L89;
        com.bytedance.android.livesdk.model.p0 r44 = r15.b();
        if (r44 == null) goto L86;
        String r45 = r44.c();
        if (r45 == null) goto L86;
    L87:
        r113.put("layout_key", r45);
    L105:
        ?? r46 = new JSONArray();
        Iterator r47 = r9.iterator();
        JSONObject r48 = r14;
        ?? r123 = r113;
    L107:
        if (r47.hasNext() == false) goto L132;
        f31.k r49 = (f31.k) r47.next();
        String r124 = r49.a;
        double r125 = r49.c;
        List<f31.k> r126 = r9;
        double r50 = r49.d;
        JSONObject r127 = r13;
        Iterator r210 = r47;
        double r52 = r49.e;
        String r211 = r17;
        String r212 = r18;
        double r128 = r49.f;
        boolean r53 = r49.g;
        JSONObject r213 = r48;
        com.bytedance.android.live.revlink.impl.multianchor.ui.i r54 = r0.K;
        if (r54 == null) goto L111;
        ?? r55 = r54.j(null, r124);
    L112:
        if (r36 == null) goto L126;
        List r129 = r36.h();
        if (r129 == null) goto L126;
        Iterator r130 = r129.iterator();
    L117:
        if (r130.hasNext() == false) goto L122;
        Object r214 = r130.next();
        com.bytedance.android.livesdk.model.p0 r215 = r36;
        if (Intrinsics.areEqual(((RevSeiRegion) r214).getUidStr(), r49.a) == true) goto L123;
        r36 = r215;
    L123:
        RevSeiRegion r216 = (RevSeiRegion) r214;
        if (r216 == null) goto L127;
        int r56 = r216.getTalkVolume();
    L128:
        IRegion.Status r57 = IRegion.Status.FOREGROUND;
        Intrinsics.checkNotNullParameter(r57, "status");
        ?? r58 = new JSONObject();
        ?? r131 = r123;
        if (r124 != null) goto L131;
        r124 = r211;
    L131:
        r58.put("uid_str", r124);
        r58.put("loading", r53 ? 1 : 0);
        r58.put("x", r125);
        r58.put("y", r50);
        r58.put("w", r52);
        r58.put("h", r128);
        r58.put("mute_audio", r55);
        r58.put("talk_volume", r56);
        r58.put("stat", r57.toSeiFormat());
        r46.put(r58);
        r0 = this;
        r123 = r131;
        r9 = r126;
        r13 = r127;
        r47 = r210;
        r17 = r211;
        r18 = r212;
        r48 = r213;
        r36 = r215;
    L127:
        r56 = 0;
        goto L128
    L122:
        r215 = r36;
        r214 = null;
    L126:
        r215 = r36;
        goto L127
    L111:
        r55 = 0;
        goto L112
    L132:
        r110 = r9;
        r111 = r13;
        JSONObject r217 = r48;
        r22 = r17;
        String r218 = r18;
        ?? r132 = r123;
        r132.put("grids", r46);
        Object r59 = null;
        r20 = this;
        e r60 = r20.H;
        if (r60 == null) goto L139;
        com.bytedance.live.datacontext.m<Long> r62 = r60.getChannelId();
        if (r62 == null) goto L139;
        Long r63 = (Long) r62.getValue();
        if (r63 == null) goto L139;
        long r64 = r63.longValue();
    L140:
        r132.put("channel_id", r64);
        if (r20.n == false) goto L146;
        JSONArray r65 = j();
        if (r65.length() <= 0) goto L157;
        r132.put(r218, r65);
    L157:
        r23 = r132;
        goto L158
    L146:
        if (r217 == null) goto L148;
        Object r66 = r217.opt(r218);
    L150:
        if ((r66 instanceof JSONArray) == false) goto L153;
        r59 = r66;
    L153:
        JSONArray r67 = (JSONArray) r59;
        if (r67 != null) goto L156;
        r67 = new JSONArray();
    L156:
        r132.put(r218, r67);
        goto L157
    L148:
        r66 = null;
    L139:
        r64 = 0;
    L86:
        r45 = "";
    L89:
        if (r0.n == false) goto L105;
        com.bytedance.android.live.revlink.impl.global.c r68 = r0.F;
        if (r68 == null) goto L97;
        RevLinkWindowRegionContext r69 = r68.P8();
        if (r69 == null) goto L97;
        com.bytedance.live.datacontext.j<com.bytedance.android.live.revlink.impl.multianchor.service.g> r70 = r69.getPartnerService();
        if (r70 == null) goto L97;
        com.bytedance.android.live.revlink.impl.multianchor.service.g r72 = (com.bytedance.android.live.revlink.impl.multianchor.service.g) r70.getValue();
    L98:
        if (r72 == null) goto L105;
        if (r72.n() != true) goto L105;
        String r73 = r72.mo696c();
        if (r73 != null) goto L104;
        r73 = "";
    L104:
        r113.put("layout_key", r73);
    L97:
        r72 = null;
    L74:
        r43 = null;
        goto L76
    L60:
        if ((!StringsKt.isBlank(r38)) != true) goto L64;
        if (Intrinsics.areEqual(r0.L, r37.a) == false) goto L64;
        r39 = true;
        goto L65
    L68:
        r122 = -1;
        goto L69
    L53:
        r120 = null;
        goto L54
    L49:
        r118 = null;
        goto L50
    L42:
        r115 = null;
        goto L43
    L38:
        r36 = null;
        goto L39
    L23:
        if (r10.isEmpty() == true) goto L26;
        r12 = false;
        goto L27
    L19:
        r9 = null;
    L7:
        r4 = null;
        goto L9
    }

    public static final JSONObject c(e0 r10, int r12) {
        r10.getClass();
        JSONObject r0 = new JSONObject();
        r0.put("state", r12);
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r1 = r10.G;
        if (r1 == null) goto L7;
        IBaseBattleSetting r2 = r1.getBattleSettings();
        if (r2 == null) goto L7;
        JSONObject r3 = com.bytedance.android.live.revlink.impl.multianchor.dynamic.e.c(r2);
    L8:
        r0.put("battle_settings", r3);
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r4 = r10.G;
        if (r4 == null) goto L11;
        Map<String, IBattleUserInfo> r5 = r4.getUserInfoMap();
    L12:
        if (r5 == null) goto L14;
        JSONObject r6 = com.bytedance.android.live.revlink.impl.multianchor.dynamic.e.c(r5);
    L15:
        r0.put("play_anchor_list", r6);
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r7 = r10.G;
        if (r7 == null) goto L20;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.b r8 = r7.getPkSkinConfig();
        if (r8 == null) goto L20;
        Long r9 = Long.valueOf(r8.a);
    L21:
        r0.put("skin_type", r9.longValue());
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r13 = r10.G;
        if (r13 == null) goto L28;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.b r14 = r13.getPkSkinConfig();
        if (r14 == null) goto L28;
        x2 r15 = r14.b;
        if (r15 == null) goto L28;
        JSONObject r16 = com.bytedance.android.live.revlink.impl.multianchor.dynamic.e.c(r15);
    L29:
        r0.put("skin_config", r16);
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r17 = r10.G;
        if (r17 == null) goto L34;
        LiveData<Long> r18 = r17.getBaseTimeLeft();
        if (r18 == null) goto L34;
        Long r19 = (Long) r18.getValue();
    L35:
        r0.put("remain_time", r19);
        Map<String, PkBaseResult> r20 = r10.G.getCurPkResultMap();
        if (r20 == null) goto L40;
        PkBaseResult r22 = r20.get(r10.k());
        if (r22 == null) goto L40;
        Integer r23 = Integer.valueOf(r22.ordinal());
    L41:
        r0.put("result", r23);
        Map<String, PkBaseResult> r24 = r10.G.getCurPkResultMap();
        if (r24 == null) goto L46;
        PkBaseResult r25 = r24.get(r10.k());
        if (r25 == null) goto L46;
        Integer r26 = Integer.valueOf(r25.ordinal());
    L48:
        if (r26 != null) goto L93;
        if (r12 == RevPkState.PK.ordinal()) goto L93;
        if (r5 == null) goto L55;
        IBattleUserInfo r110 = r5.get(r10.k());
        if (r110 == null) goto L55;
        Integer r111 = Integer.valueOf(r110.getPkResult());
    L57:
        if (r5 == null) goto L59;
        int r27 = r5.size();
    L61:
        if (r27 <= 2) goto L86;
        if (r5 == null) goto L76;
        Iterator<Map.Entry<String, IBattleUserInfo>> r28 = r5.entrySet().iterator();
        boolean r29 = true;
    L65:
        if (r28.hasNext() == false) goto L77;
        Map.Entry<String, IBattleUserInfo> r30 = r28.next();
        String r32 = r30.getKey();
        IBattleUserInfo r33 = r30.getValue();
        if (r33 == null) goto L69;
        Integer r34 = Integer.valueOf(r33.getPkResult());
    L70:
        int r35 = r34.intValue();
        if (r111 == null) goto L75;
        if (r35 == r111.intValue()) goto L65;
    L75:
        r29 = false;
        goto L65
    L69:
        r34 = null;
    L77:
        if (r29 == false) goto L79;
        int r112 = RevPkResult.EVEN.ordinal();
    L83:
        Integer r113 = Integer.valueOf(r112);
    L85:
        r0.put("result", r113);
        goto L93
    L79:
        if (r5 == null) goto L84;
        IBattleUserInfo r114 = r5.get(r10.k());
        if (r114 == null) goto L84;
        r112 = r114.getPkResult();
    L84:
        r113 = null;
        goto L85
    L76:
        r29 = true;
        goto L77
    L86:
        if (r5 == null) goto L90;
        IBattleUserInfo r115 = r5.get(r10.k());
        if (r115 == null) goto L90;
        Integer r116 = Integer.valueOf(r115.getPkResult());
    L91:
        r0.put("result", r116);
    L90:
        r116 = null;
        goto L91
    L59:
        r27 = 0;
    L55:
        r111 = null;
    L93:
        if (r10.G.getUserIdToTeamId() == null) goto L102;
        Map<String, Long> r117 = r10.G.getUserIdToTeamId();
        if (r117 == null) goto L100;
        LinkedHashMap r36 = new LinkedHashMap(MapsKt.mapCapacity(r117.size()));
        Iterator<T> r118 = r117.entrySet().iterator();
    L98:
        if (r118.hasNext() == false) goto L101;
        Map.Entry r37 = (Map.Entry) r118.next();
        r36.put(r37.getKey(), Integer.valueOf(((int) ((Number) r37.getValue()).longValue()) - 1));
    L101:
        r0.put("team_info", new JSONObject(GsonProtectorUtils.toJson(l97.a.a, r36)));
        goto L102
    L100:
        r36 = null;
    L102:
        JSONObject r119 = new JSONObject();
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.a r38 = (com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.a) r10.G.getBattleScoreData().getValue();
        if (r38 == null) goto L106;
        List<af2.b> r39 = r38.b();
        if (r39 == null) goto L106;
    L107:
        List<af2.b> r40 = r39;
        ArrayList r42 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r40, 10));
        Iterator<T> r43 = r40.iterator();
    L109:
        if (r43.hasNext() == false) goto L111;
        r42.add(new JSONObject(GsonProtectorUtils.toJson(l97.a.a, r43.next())));
        goto L109
    L111:
        int r44 = com.bytedance.revenue.platform.api.core.b.a;
        r119.put("battle_scores", JSONObject.wrap(r42));
        LiveData<com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.a> r45 = r10.G.getBattleScoreData();
        if (r45 == null) goto L118;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.a r46 = (com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.a) r45.getValue();
        if (r46 == null) goto L118;
        n3 r47 = r46.a();
        if (r47 == null) goto L118;
        JSONObject r48 = com.bytedance.android.live.revlink.impl.multianchor.dynamic.e.c(r47);
    L119:
        r119.put("pve_data", r48);
        LiveData<com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.a> r49 = r10.G.getBattleScoreData();
        if (r49 == null) goto L146;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.a r50 = (com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.a) r49.getValue();
        if (r50 == null) goto L146;
        int r52 = r50.c();
        if (r52 != PkBaseStateMachine.Source.Init.ordinal()) goto L126;
    L144:
        int r53 = 5;
    L145:
        r119.put("source", r53);
        goto L146
    L126:
        if (r52 == PkBaseStateMachine.Source.ChangeMode.ordinal()) goto L144;
        if (r52 == PkBaseStateMachine.Source.NormalToMultiple.ordinal()) goto L144;
        if (r52 == PkBaseStateMachine.Source.RelinkSuccess.ordinal()) goto L144;
        if (r52 == PkBaseStateMachine.Source.DoublePkLinkInPeak.ordinal()) goto L144;
        if (r52 != PkBaseStateMachine.Source.BattleMsg.ordinal()) goto L138;
        r53 = 3;
        goto L145
    L138:
        if (r52 == PkBaseStateMachine.Source.MetaUpdate.ordinal()) goto L140;
        r53 = 6;
        goto L145
    L140:
        if (r10.n == true) goto L144;
        r53 = 7;
    L146:
        r0.put("play_scores", r119);
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r120 = r10.G;
        if (r120 == null) goto L151;
        LiveData<String> r121 = r120.getTeamTaskLynxData();
        if (r121 == null) goto L151;
        String r122 = (String) r121.getValue();
    L152:
        r0.put("team_task", r122);
        r0.put("contribution_list", null);
        r0.put("channel_id", r10.b.getValue());
        return r0;
    L151:
        r122 = null;
    L118:
        r48 = null;
    L106:
        r39 = CollectionsKt.emptyList();
    L46:
        r26 = null;
    L40:
        r23 = null;
    L34:
        r19 = null;
    L28:
        r16 = null;
    L20:
        r9 = null;
        goto L21
    L14:
        r6 = null;
        goto L15
    L11:
        r5 = null;
    L7:
        r3 = null;
        goto L8
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.RevLinkDynamicDataContext$needShowLastResultObserver$1] */
    /* JADX WARN: Type inference failed for: r2v4, types: [com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.RevLinkDynamicDataContext$onPartnerEnableObserver$1] */
    /* JADX WARN: Type inference failed for: r2v5, types: [com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.RevLinkDynamicDataContext$onMixStreamObserver$1] */
    /* JADX WARN: Type inference failed for: r2v8, types: [com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.RevLinkDynamicDataContext$pkStateObserver$1] */
    public e0(Function0 r17, ld.a r18, com.bytedance.android.livesdk.revenue.service.room.c r19, com.bytedance.android.live.revlink.impl.global.c r20, PkBaseDataContext r22, DynamicContextDependencyImpl r23, AnchorLinkUserCenterV2 r24, DynamicContextDependencyImpl r25, com.bytedance.android.live.revlink.link.domain.dependencyimpl.a r26, com.bytedance.android.live.revlink.impl.multianchor.ui.i r27, String r28, com.bytedance.android.live.revlink.impl.global.c r29) {
        Intrinsics.checkNotNullParameter(r17, "scene");
        Intrinsics.checkNotNullParameter(r22, "pkBaseDataContext");
        this.C = r17;
        this.D = r18;
        this.E = r19;
        this.F = r20;
        this.G = r22;
        this.H = r23;
        this.I = r24;
        this.J = r26;
        this.K = r27;
        this.L = r28;
        this.M = r29;
        LiveData<?> r3 = new MutableLiveData();
        this.a = r3;
        LiveData<?> r4 = new MutableLiveData();
        this.b = r4;
        this.c = new MutableLiveData();
        this.d = new CompositeDisposable();
        LiveData<?> r5 = new MutableLiveData();
        this.f = r5;
        LiveData<?> r6 = new MutableLiveData();
        this.g = r6;
        LiveData<?> r7 = new MutableLiveData();
        this.h = r7;
        LiveData<?> r8 = new MutableLiveData();
        this.i = r8;
        LiveData<?> r9 = new MutableLiveData();
        this.j = r9;
        LiveData<?> r10 = new MutableLiveData();
        this.k = r10;
        MutableLiveData<Integer> r12 = new MutableLiveData();
        this.l = r12;
        LiveData<?> r13 = new MutableLiveData();
        this.m = r13;
        com.bytedance.android.livesdk.revenue.room.a r1 = r19.getRoomContext();
        if (r1 == null) goto L7;
        boolean r14 = true;
        if (r1.getCommonIsAnchor() != true) goto L7;
    L8:
        this.n = r14;
        LiveData<?> r2 = new MutableLiveData();
        this.o = r2;
        MutableLiveData<List<com.bytedance.android.livesdk.link.model.e>> r15 = new MutableLiveData();
        this.p = r15;
        MutableLiveData<List<com.bytedance.android.livesdk.link.model.p>> r16 = new MutableLiveData();
        this.q = r16;
        LiveData<?> r110 = new MutableLiveData();
        this.r = new MutableLiveData();
        this.s = new w(this);
        this.t = new RevLinkDynamicDataContext$needShowLastResultObserver$1(this);
        this.u = new RevLinkDynamicDataContext$onPartnerEnableObserver$1(this);
        this.v = new RevLinkDynamicDataContext$onMixStreamObserver$1(this);
        this.w = new d0(this);
        this.x = new r(this);
        this.y = new RevLinkDynamicDataContext$pkStateObserver$1(this);
        HashMap<String, LiveData<?>> r30 = new HashMap();
        r30.put("channel_id", r4);
        r30.put("sei", r3);
        r30.put("screen_info", r5);
        r30.put("interact_timer_count", r7);
        r30.put("interact_start_time", r6);
        r30.put("clean_screen", r13);
        r30.put("team_task", r22.getTeamTaskLynxData());
        LiveData<Long> r32 = r22.getBaseTimeLeft();
        MediatorLiveData r33 = new MediatorLiveData();
        r33.addSource(r32, new s(r33, this));
        r30.put("play_remain_time", r33);
        r30.put("show_last_result", r8);
        r30.put("double_mute_status", r9);
        r30.put("intercom_data", r10);
        MediatorLiveData r34 = new MediatorLiveData();
        r34.addSource(r12, new RevLinkDynamicDataContext$packagePlayStatus$$inlined$also$lambda$1(r34, this));
        r30.put("play_status", r34);
        MediatorLiveData r35 = new MediatorLiveData();
        r35.addSource(r16, new RevLinkDynamicDataContext$transformLinkAnchorInfo$$inlined$also$lambda$1(r35, this));
        r30.put("link_anchor_list", r35);
        r30.put("game_data", r110);
        r30.put("intercom_data", r10);
        r30.put("guest_info", r2);
        MediatorLiveData r36 = new MediatorLiveData();
        r36.addSource(r15, new RevLinkDynamicDataContext$transformAIAnchorList$$inlined$also$lambda$1(r36, this));
        r30.put("ai_anchor_list", r36);
        Unit r37 = Unit.INSTANCE;
        this.z = r30;
        LinkedHashMap r38 = new LinkedHashMap(MapsKt.mapCapacity(r30.size()));
        Iterator<T> r39 = r30.entrySet().iterator();
    L10:
        if (r39.hasNext() == false) goto L12;
        Map.Entry r40 = (Map.Entry) r39.next();
        Object r42 = r40.getKey();
        String r43 = (String) r40.getKey();
        r38.put(r42, com.bytedance.android.live.revlink.impl.multianchor.dynamic.e.b((LiveData) r40.getValue(), r43, FormatType.NEW));
        goto L10
    L12:
        this.A = r38;
        return;
    L7:
        r14 = false;
        goto L8
    }
}
