package com.bytedance.android.live.revlink.impl.multianchor.dynamic.context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.live.link.data.RevPkState;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revlink.impl.lynxcontainer.PkLynxDataContextKt$convertPkBaseResultToInt$$inlined$also$lambda$1;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.PkBaseDataContext;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.PkBaseStateMachine;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.PkBaseResult;
import com.bytedance.android.live.revlink.impl.monitor.LiveFullLinkPKMonitor;
import com.bytedance.android.live.revlink.impl.multianchor.constants.PlayMode;
import com.bytedance.android.live.revlink.impl.multianchor.dynamic.DynamicUtilsKt$packagePlayStatus$$inlined$also$lambda$1;
import com.bytedance.android.live.revlink.impl.multianchor.dynamic.FormatType;
import com.bytedance.android.live.revlink.impl.multianchor.profit.ProfitInteractionDataContext;
import com.bytedance.android.live.revlink.impl.multianchor.ui.UILayout;
import com.bytedance.android.live.revlink.impl.multianchor.utils.MultiEnterRoomTracer;
import com.bytedance.android.live.revlink.impl.plantform.AnchorLinkUserCenterV2;
import com.bytedance.android.live.revlink.link.domain.dependencyimpl.DynamicContextDependencyImpl;
import com.bytedance.android.livesdk.link.model.IBattleConfigSetting;
import com.bytedance.android.livesdk.link.model.IBattleUserInfo;
import com.bytedance.android.livesdk.link.model.ILinkMicBattleInviteMessage;
import com.bytedance.android.livesdk.link.model.aa;
import com.bytedance.android.livesdk.link.model.api.IBaseBattleSetting;
import com.bytedance.android.livesdk.link.model.c3;
import com.bytedance.android.livesdk.link.model.e5;
import com.bytedance.android.livesdk.link.model.h7;
import com.bytedance.android.livesdk.revenue.service.livecore.IRegion;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.reactivex.disposables.CompositeDisposable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
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
@Deprecated(message = "此处只负责老的没对齐之前的数据")
public final class k0 implements b, c, d {
    public final com.bytedance.android.livesdk.revenue.service.room.c A;
    public final com.bytedance.android.live.revlink.impl.global.c B;
    public final com.bytedance.android.live.revlink.impl.mergepk.pkbase.e C;
    public final e D;
    public final i11.c E;
    public final com.bytedance.android.live.revlink.impl.multianchor.ui.b F;
    public final o G;
    public final com.bytedance.android.live.revlink.impl.multianchor.ui.i H;
    public final String I;
    public final com.bytedance.android.live.revlink.impl.global.c J;
    public final CompositeDisposable a;
    public final boolean b;
    public final Lazy c;
    public final MutableLiveData<JSONObject> d;
    public final MutableLiveData<Boolean> e;
    public final MutableLiveData<Long> f;
    public final MutableLiveData<f31.i> g;
    public final MutableLiveData<String> h;
    public final MutableLiveData<String> i;
    public final MutableLiveData<List<com.bytedance.android.livesdk.link.model.p>> j;
    public final MutableLiveData<String> k;
    public final NextLiveData<ILinkMicBattleInviteMessage> l;
    public final NextLiveData<e5> m;
    public final HashMap<IBaseBattleSetting, JsonElement> n;
    public final RevLinkOldDynamicDataContext$battleInviteMsgObserver$1 o;
    public final RevLinkOldDynamicDataContext$battleReplyMsgObserver$1 p;
    public final RevLinkOldDynamicDataContext$needShowLastResultObserver$1 q;
    public String r;
    public final j0 s;
    public final h0 t;
    public final MutableLiveData<JSONObject> u;
    public final HashMap<String, LiveData<?>> v;
    public final HashMap<String, FormatType> w;
    public final Map<String, LiveData<Pair<String, JSONObject>>> x;
    public final Function0<Integer> y;
    public final ld.a z;

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.d
    public final void g(zy0.b r1) {
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.b
    public final long G() {
        e r0 = this.D;
        if (r0 == null) goto L9;
        com.bytedance.live.datacontext.m<Long> r1 = r0.getChannelId();
        if (r1 == null) goto L9;
        Long r2 = (Long) r1.getValue();
        if (r2 == null) goto L9;
        return r2.longValue();
    L9:
        return 0;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.b
    public final LiveData<PlayMode> H() {
        return this.C.getTeamMode();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.b
    public final LiveData<Long> I() {
        return this.C.getBaseTimeLeft();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.d
    public final com.bytedance.android.live.revlink.impl.monitor.b a() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.B;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getPkEnterRoomTracer();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.d
    public final LiveFullLinkPKMonitor d() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.B;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getLiveFullLinkPKMonitor();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.d
    public final MultiEnterRoomTracer e() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.B;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.i7();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.b
    public final String getAnchorId() {
        com.bytedance.android.livesdk.revenue.service.room.c r0 = this.A;
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

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.b
    public final IBaseBattleSetting getBattleSettings() {
        return this.C.getBattleSettings();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.b
    public final Map<String, IBattleUserInfo> getBattleUserInfoMap() {
        return this.C.getUserInfoMap();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.b
    public final LiveData<Integer> getPkResult() {
        LiveData<Map<String, PkBaseResult>> r0 = this.C.getPkBaseResult();
        final com.bytedance.android.live.revlink.impl.global.c r1 = this.B;
        Intrinsics.checkNotNullParameter(r0, "$this$convertPkBaseResultToInt");
        final MediatorLiveData r2 = new MediatorLiveData();
        r2.addSource(r0, new PkLynxDataContextKt$convertPkBaseResultToInt$$inlined$also$lambda$1(r2, r1));
        return r2;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.b
    public final LiveData<com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.a> getScoreState() {
        return this.C.getBattleScoreData();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.b
    public final com.bytedance.android.live.revlink.impl.mergepk.pkbase.b getSkinConfig() {
        return this.C.getPkSkinConfig();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.b
    public final LiveData<String> getTeamTaskLynxData() {
        return this.C.getTeamTaskLynxData();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.b
    public final Map<String, Long> getUserIdToTeamId() {
        return this.C.getUserIdToTeamId();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.d
    public final HashMap<String, LiveData<?>> b() {
        return this.v;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.d
    public final LiveData getChangeScreenEvent() {
        return this.e;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.d
    public final LiveData getWindowStatus() {
        return this.g;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.d
    public final Map<String, LiveData<Pair<String, JSONObject>>> h() {
        return this.x;
    }

    public static final void i(k0 r7) {
        r7.getClass();
        JSONObject r0 = new JSONObject();
        ld.a r1 = r7.z;
        Boolean r2 = null;
        if (r1 == null) goto L7;
        NextLiveData r3 = r1.Fc();
        if (r3 == null) goto L7;
        Boolean r4 = (Boolean) r3.getValue();
    L8:
        Boolean r5 = Boolean.TRUE;
        boolean r6 = Intrinsics.areEqual(r4, r5);
        String r8 = DataType.TRUE;
        if (r6 == false) goto L11;
        Object r9 = DataType.TRUE;
    L12:
        r0.put("left", r9);
        ld.a r10 = r7.z;
        if (r10 == null) goto L18;
        NextLiveData r12 = r10.z9();
        if (r12 == null) goto L18;
        r2 = (Boolean) r12.getValue();
    L18:
        if (Intrinsics.areEqual(r2, r5) == true) goto L21;
        r8 = DataType.FALSE;
    L21:
        r0.put("right", r8);
        r7.d.setValue(r0);
        return;
    L11:
        r9 = DataType.FALSE;
    L7:
        r4 = null;
        goto L8
    }

    public static JSONObject l(boolean r3) {
        JSONObject r0 = new JSONObject();
        b03.a r1 = b03.a.a;
        r0.put("screen_width", Float.valueOf(b03.c.c(s1.y())));
        r0.put("screen_height", Float.valueOf(b03.c.c(s1.w())));
        int r2 = 1;
        if (r3 != true) goto L5;
        r2 = 0;
    L5:
        r0.put("screen_type", r2);
        r0.put("is_fold_full", FoldScreenUtils.f() ? 1 : 0);
        return r0;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.d
    public final String f(String r8) {
        Intrinsics.checkNotNullParameter(r8, "key");
        Object r1 = null;
        Integer r2 = null;
        r2 = null;
        r2 = null;
        r2 = null;
        Object r3 = null;
        Object r4 = null;
        com.bytedance.android.live.revlink.impl.utils.b r5 = null;
        ProfitInteractionDataContext r6 = null;
        Boolean r7 = null;
        r7 = null;
        if (Intrinsics.areEqual(r8, "pk_status") == false) goto L21;
        LiveData<?> r0 = this.v.get(r8);
        if (r0 == null) goto L7;
        Object r9 = r0.getValue();
    L8:
        if (r9 != null) goto L21;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r10 = this.C;
        if (r10 == null) goto L19;
        LiveData<PkBaseStateMachine.c> r12 = r10.getPkBaseState();
        if (r12 == null) goto L19;
        PkBaseStateMachine.c r13 = (PkBaseStateMachine.c) r12.getValue();
        if (r13 == null) goto L19;
        RevPkState r14 = r13.c();
        if (r14 == null) goto L19;
        r2 = Integer.valueOf(r14.ordinal());
    L19:
        return k(r2).toString();
    L7:
        r9 = null;
    L21:
        if (Intrinsics.areEqual(r8, "meta_data") == false) goto L32;
        LiveData<c3> r15 = this.C.getBattleStatsMeta();
        if (r15 == null) goto L208;
        c3 r16 = (c3) r15.getValue();
        if (r16 == null) goto L209;
        String r17 = r16.getMetaLynxData();
        if (r17 != null) goto L30;
        return "";
    L30:
        return r17;
    L209:
        return "";
    L208:
        return "";
    L32:
        if (this.v.containsKey(r8) == false) goto L64;
        LiveData<?> r18 = this.v.get(r8);
        if (r18 == null) goto L36;
        Object r19 = r18.getValue();
    L38:
        if ((r19 instanceof String) == false) goto L46;
        LiveData<?> r20 = this.v.get(r8);
        if (r20 == null) goto L42;
        r3 = r20.getValue();
    L42:
        if (r3 == null) goto L45;
        return (String) r3;
    L45:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    L46:
        LiveData<?> r22 = this.v.get(r8);
        if (r22 == null) goto L49;
        Object r23 = r22.getValue();
    L51:
        if ((r23 instanceof JSONObject) == false) goto L59;
        LiveData<?> r24 = this.v.get(r8);
        if (r24 == null) goto L213;
        Object r25 = r24.getValue();
        if (r25 == null) goto L214;
        String r26 = r25.toString();
        if (r26 != null) goto L217;
        return "";
    L217:
        return r26;
    L214:
        return "";
    L213:
        return "";
    L59:
        LiveData<?> r27 = this.v.get(r8);
        if (r27 == null) goto L62;
        r4 = r27.getValue();
    L62:
        r26 = GsonProtectorUtils.toJson(l97.a.a, r4);
        goto L217
    L49:
        r23 = null;
        goto L51
    L36:
        r19 = null;
        goto L38
    L64:
        if (Intrinsics.areEqual(r8, "channel_id") == true) goto L205;
        if (Intrinsics.areEqual(r8, "channel_id_str") == true) goto L205;
        if (Intrinsics.areEqual(r8, "scene") == false) goto L72;
        return String.valueOf(((Number) this.y.invoke()).intValue());
    L72:
        if (Intrinsics.areEqual(r8, "lynx_data") == false) goto L79;
        IBaseBattleSetting r28 = getBattleSettings();
        if (r28 == null) goto L216;
        r26 = r28.getLynxData();
        if (r26 != null) goto L217;
        return "";
    L216:
        return "";
    L79:
        boolean r29 = Intrinsics.areEqual(r8, "skin_type");
        String r30 = DataType.FALSE;
        if (r29 == false) goto L87;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.b r32 = getSkinConfig();
        if (r32 == null) goto L220;
        String r33 = String.valueOf(r32.a);
        if (r33 == null) goto L220;
        return r33;
    L220:
        return DataType.FALSE;
    L87:
        if (Intrinsics.areEqual(r8, "skin_config") == false) goto L93;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.b r34 = getSkinConfig();
        if (r34 != null) goto L91;
        return "";
    L91:
        return GsonProtectorUtils.toJson(l97.a.a, r34.b);
    L93:
        if (Intrinsics.areEqual(r8, "clean_screen") == false) goto L102;
        com.bytedance.android.live.revlink.impl.global.c r35 = this.B;
        if (r35 == null) goto L97;
        r5 = r35.getClearScreenLinkUtils();
    L97:
        if (r5 == null) goto L220;
        if (r5.b() != true) goto L220;
        return DataType.TRUE;
    L102:
        if (Intrinsics.areEqual(r8, "need_last_result") == false) goto L109;
        MutableLiveData<String> r36 = this.k;
        if (r36 == null) goto L220;
        r26 = (String) r36.getValue();
        if (r26 != null) goto L217;
    L109:
        if (Intrinsics.areEqual(r8, "interact_start_time") == false) goto L122;
        com.bytedance.android.live.revlink.impl.global.c r37 = this.B;
        if (r37 == null) goto L113;
        r6 = r37.vj();
    L113:
        if (r6 == null) goto L119;
        com.bytedance.live.datacontext.m<Long> r38 = r6.getLinkStartTimeStamp();
        if (r38 == null) goto L119;
        Long r39 = (Long) r38.getValue();
        if (r39 == null) goto L119;
        long r40 = r39.longValue();
    L221:
        return String.valueOf(r40);
    L119:
        r40 = 0;
        goto L221
    L122:
        if (Intrinsics.areEqual(r8, "user_infos") == false) goto L125;
        return GsonProtectorUtils.toJson(l97.a.a, getBattleUserInfoMap());
    L125:
        if (Intrinsics.areEqual(r8, "pk_audience_count") == false) goto L146;
        JSONObject r42 = new JSONObject();
        ld.a r43 = this.z;
        if (r43 == null) goto L131;
        NextLiveData r44 = r43.Fc();
        if (r44 == null) goto L131;
        Boolean r45 = (Boolean) r44.getValue();
    L132:
        Boolean r46 = Boolean.TRUE;
        if (Intrinsics.areEqual(r45, r46) == false) goto L135;
        Object r47 = DataType.TRUE;
    L136:
        r42.put("left", r47);
        ld.a r48 = this.z;
        if (r48 == null) goto L142;
        NextLiveData r49 = r48.z9();
        if (r49 == null) goto L142;
        r7 = (Boolean) r49.getValue();
    L142:
        if (Intrinsics.areEqual(r7, r46) == false) goto L144;
        r30 = DataType.TRUE;
    L144:
        r42.put("right", r30);
        return r42.toString();
    L135:
        r47 = DataType.FALSE;
    L131:
        r45 = null;
        goto L132
    L146:
        if (Intrinsics.areEqual(r8, "online_cnt") == false) goto L153;
        List r50 = (List) this.j.getValue();
        if (r50 == null) goto L150;
        int r52 = r50.size();
    L224:
        return String.valueOf(r52);
    L150:
        r52 = 0;
        goto L224
    L153:
        if (Intrinsics.areEqual(r8, "normal_to_multiple") == false) goto L162;
        com.bytedance.android.live.revlink.impl.global.c r53 = this.J;
        if (r53 == null) goto L160;
        com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c r54 = r53.K8();
        if (r54 == null) goto L160;
        String r55 = String.valueOf(r54.canSwitchMulti());
        if (r55 == null) goto L160;
        return r55;
    L160:
        return "false";
    L162:
        if (Intrinsics.areEqual(r8, "pk_guest_info") == false) goto L173;
        com.bytedance.android.live.revlink.impl.global.c r56 = this.J;
        if (r56 == null) goto L227;
        com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c r57 = r56.K8();
        if (r57 == null) goto L228;
        LiveData<String> r58 = r57.getPkGuestListStr();
        if (r58 == null) goto L229;
        r26 = (String) r58.getValue();
        if (r26 != null) goto L217;
        return "";
    L229:
        return "";
    L228:
        return "";
    L227:
        return "";
    L173:
        if (Intrinsics.areEqual(r8, "play_duration") == false) goto L176;
        return String.valueOf(l51.a.j());
    L176:
        if (Intrinsics.areEqual(r8, "pk_settings") == false) goto L181;
        aa r59 = vh7.f.c(aa.class);
        r59.setVoteType(l51.a.g());
        r59.setVoteDes((String) l51.a.D0.getValue(null, l51.a.a[91]));
        r59.setDurationTime(l51.a.f());
        HashMap r60 = new HashMap();
        r60.put("vote_setting", GsonProtectorUtils.toJson(l97.a.a, r59));
        if (com.bytedance.android.live.revlink.impl.settings.dynamic.a.H.c() == false) goto L180;
        r30 = DataType.TRUE;
    L180:
        r60.put("panel_list_opt", r30);
        return GsonProtectorUtils.toJson(l97.a.a, r60);
    L181:
        IBaseBattleSetting r62 = getBattleSettings();
        if (this.n.get(r62) != null) goto L206;
        this.n.clear();
        this.n.put(r62, GsonProtectorUtils.toJsonTree(l97.a.a, r62));
    L206:
        Result.Companion r63 = Result.Companion;     // Catch: Throwable -> L194
        JsonElement r64 = this.n.get(r62);     // Catch: Throwable -> L194
        if (r64 == null) goto L191;
        JsonObject r65 = r64.getAsJsonObject();     // Catch: Throwable -> L194
        if (r65 == null) goto L191;
        JsonElement r66 = r65.get(r8);     // Catch: Throwable -> L194
        if (r66 == null) goto L191;
        String r67 = r66.toString();     // Catch: Throwable -> L194
    L192:
        Object r68 = Result.constructor-impl(r67);     // Catch: Throwable -> L194
    L197:
        if (Result.isFailure-impl(r68) == true) goto L200;
        r1 = r68;
    L200:
        String r69 = (String) r1;
        if (r69 != null) goto L233;
        return "";
    L233:
        return r69;
    L191:
        r67 = null;
    L194:
        th = move-exception;
        Result.Companion r70 = Result.Companion;
        r68 = Result.constructor-impl(ResultKt.createFailure(th));
    L205:
        return String.valueOf(G());
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.c
    public final void j(int r2) {
        if (this.b == false) goto L8;
        com.bytedance.android.live.revlink.impl.multianchor.ui.b r3 = this.F;
        if (r3 == null) goto L13;
        r3.requestLayout("updateTopReserve");
        return;
    L13:
        return;
    L8:
        if (((Boolean) this.c.getValue()).booleanValue() == true) goto L15;
        com.bytedance.android.live.revlink.impl.multianchor.ui.b r4 = this.F;
        if (r4 == null) goto L16;
        r4.requestLayout("updateTopReserve");
        return;
    L16:
        return;
    }

    public final JSONObject k(Integer r7) {
        JSONObject r0 = new JSONObject();
        r0.put("state", com.bytedance.android.live.revlink.impl.multianchor.dynamic.e.f(r7));
        IBaseBattleSetting r8 = getBattleSettings();
        int r1 = 0;
        if (r8 == null) goto L7;
        IBattleConfigSetting r9 = r8.getBattleConfigSetting();
        if (r9 == null) goto L7;
        int r10 = r9.getModType();
    L8:
        r0.put("play_mode", r10);
        IBaseBattleSetting r12 = getBattleSettings();
        if (r12 == null) goto L13;
        IBattleConfigSetting r13 = r12.getBattleConfigSetting();
        if (r13 == null) goto L13;
        int r14 = r13.getPlayMode();
    L14:
        r0.put("battle_play_mode", r14);
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.b r15 = getSkinConfig();
        if (r15 == null) goto L17;
        int r16 = (int) r15.a;
    L18:
        r0.put("skin_type", r16);
        IBaseBattleSetting r17 = getBattleSettings();
        long r2 = 0;
        if (r17 == null) goto L21;
        long r4 = r17.getBattleId();
    L22:
        r0.put("battle_id", String.valueOf(r4));
        IBaseBattleSetting r18 = getBattleSettings();
        if (r18 == null) goto L25;
        r2 = r18.getBattleId();
    L25:
        r0.put("battle_id_str", String.valueOf(r2));
        r0.put("channel_id_str", String.valueOf(G()));
        IBaseBattleSetting r19 = getBattleSettings();
        if (r19 == null) goto L29;
        String r20 = r19.getLynxData();
        if (r20 == null) goto L29;
    L30:
        r0.put("lynx_data", r20);
        PlayMode r22 = (PlayMode) H().getValue();
        if (r22 == null) goto L33;
        r1 = r22.ordinal();
    L33:
        r0.put("team_mode", r1);
        Map<String, Long> r23 = getUserIdToTeamId();
        if (r23 == null) goto L39;
        Map r3 = new LinkedHashMap(MapsKt.mapCapacity(r23.size()));
        Iterator<T> r24 = r23.entrySet().iterator();
    L37:
        if (r24.hasNext() == false) goto L40;
        Map.Entry r5 = (Map.Entry) r24.next();
        r3.put(r5.getKey(), Integer.valueOf(((int) ((Number) r5.getValue()).longValue()) - 1));
    L40:
        r0.put("pk_team_info", com.bytedance.android.live.revlink.impl.multianchor.dynamic.e.d(r3));
        r0.put("pk_result", getPkResult().getValue());
        Map<String, IBattleUserInfo> r25 = getBattleUserInfoMap();
        if (r25 == null) goto L43;
        JSONObject r26 = com.bytedance.android.live.revlink.impl.multianchor.dynamic.e.d(r25);
    L44:
        r0.put("pk_user_info", r26);
        return r0;
    L43:
        r26 = new JSONObject();
        goto L44
    L39:
        r3 = MapsKt.emptyMap();
    L29:
        r20 = "";
        goto L30
    L21:
        r4 = 0;
        goto L22
    L17:
        r16 = 0;
    L13:
        r14 = 0;
    L7:
        r10 = 0;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v3 */
    /* JADX WARN: Type inference failed for: r15v4, types: [int] */
    /* JADX WARN: Type inference failed for: r15v6 */
    /* JADX WARN: Type inference failed for: r1v14, types: [java.lang.Object, org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r1v7, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.lang.Object, org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.lang.Object, org.json.JSONArray] */
    public static final void c(k0 r19, f31.i r20) {
        k0 r0 = r19;
        r19.getClass();
        if (r20 == null) goto L5;
        List<f31.k> r3 = r20.a;
    L6:
        List<f31.k> r4 = r3;
        if (r4 != null) goto L9;
    L12:
        boolean r5 = true;
    L13:
        if (r5 == true) goto L81;
        ?? r6 = new JSONObject();
        r6.put("ver", 6);
        String r7 = r0.G.c();
        JSONObject r8 = new JSONObject();
        if (r7 != null) goto L18;
        r7 = DataType.FALSE;
    L18:
        r8.put("focus_id", r7);
        r8.put("layout_type", r0.G.a());
        Iterator<f31.k> r9 = r3.iterator();
        int r10 = 0;
    L20:
        if (r9.hasNext() == false) goto L32;
        f31.k r12 = r9.next();
        String r13 = r0.I;
        if (r13 != null) goto L24;
    L28:
        boolean r14 = false;
    L29:
        if (r14 == true) goto L33;
        r10 = r10 + 1;
    L33:
        r8.put("owner_index", RangesKt.coerceAtLeast(r10, 0));
        com.bytedance.android.live.revlink.impl.global.c r15 = r0.B;
        if (r15 == null) goto L38;
        com.bytedance.android.live.revlink.impl.multianchor.utils.w r16 = r15.getMultiLinkUtil();
        if (r16 == null) goto L38;
        UILayout r17 = r16.b();
    L40:
        if (r17 != UILayout.FULL_RECORD) goto L42;
        r8.put("is_horizontal", 1);
    L42:
        r6.put("anchor_interact_info", r8);
        ?? r18 = new JSONArray();
        Iterator r22 = r3.iterator();
    L44:
        if (r22.hasNext() == false) goto L53;
        f31.k r23 = (f31.k) r22.next();
        String r110 = r23.a;
        double r111 = r23.c;
        double r112 = r23.d;
        Iterator r113 = r22;
        double r24 = r23.e;
        List<f31.k> r114 = r3;
        double r2 = r23.f;
        boolean r25 = r23.g;
        com.bytedance.android.live.revlink.impl.multianchor.ui.i r115 = r0.H;
        if (r115 == null) goto L48;
        ?? r116 = r115.j(null, r110);
    L49:
        IRegion.Status r26 = IRegion.Status.FOREGROUND;
        Intrinsics.checkNotNullParameter(r26, "status");
        ?? r1 = new JSONObject();
        if (r110 != null) goto L52;
        r110 = "";
    L52:
        r1.put("uid_str", r110);
        r1.put("loading", r25 ? 1 : 0);
        r1.put("x", r111);
        r1.put("y", r112);
        r1.put("w", r24);
        r1.put("h", r2);
        r1.put("mute_audio", r116);
        r1.put("talk_volume", 0);
        r1.put("stat", r26.toSeiFormat());
        r18.put(r1);
        r0 = r19;
        r22 = r113;
        r3 = r114;
        goto L44
    L48:
        r116 = 0;
        goto L49
    L53:
        List<f31.k> r117 = r3;
        r6.put("grids", r18);
        e r27 = r19.D;
        if (r27 == null) goto L60;
        com.bytedance.live.datacontext.m<Long> r28 = r27.getChannelId();
        if (r28 == null) goto L60;
        Long r29 = (Long) r28.getValue();
        if (r29 == null) goto L60;
        long r30 = r29.longValue();
    L61:
        r6.put("channel_id", r30);
        int r32 = f31.l.e(r117);
        int r33 = f31.l.a(r117);
        f31.l.c(r117);
        f31.l.d(r117);
        JSONObject r34 = new JSONObject();
        b03.a r35 = b03.a.a;
        r34.put("screen_width", Float.valueOf(b03.c.c(s1.y())));
        r34.put("screen_height", Float.valueOf(b03.c.c(s1.w())));
        r34.put("container_width", r32);
        r34.put("container_height", r33);
        com.bytedance.android.live.revlink.impl.global.c r36 = r19.B;
        if (r36 == null) goto L67;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r37 = r36.Ig();
        if (r37 == null) goto L67;
        List<String> r38 = r37.getAudioPunishUserIds();
        if (r38 == null) goto L67;
    L68:
        r34.put("punish_user_ids", new JSONArray(r38));
        ?? r39 = new JSONObject();
        r39.put("app_data", r6);
        String r40 = r20.b;
        if (r40 != null) goto L71;
        r40 = r19.r;
    L71:
        if (r40 != null) goto L73;
        String r42 = "";
    L74:
        r39.put("sei_raw", r42);
        r39.put("extra_data", r34);
        r19.i.setValue(r39.toString());
        return;
    L73:
        r42 = r40;
    L67:
        r38 = CollectionsKt.emptyList();
    L60:
        r30 = 0;
    L38:
        r17 = null;
        goto L40
    L24:
        if ((!StringsKt.isBlank(r13)) != true) goto L28;
        if (Intrinsics.areEqual(r0.I, r12.a) == false) goto L28;
        r14 = true;
        goto L29
    L32:
        r10 = -1;
        goto L33
    L81:
        return;
    L9:
        if (r4.isEmpty() == true) goto L12;
        r5 = false;
        goto L13
    L5:
        r3 = null;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.RevLinkOldDynamicDataContext$battleInviteMsgObserver$1] */
    /* JADX WARN: Type inference failed for: r3v3, types: [com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.RevLinkOldDynamicDataContext$battleReplyMsgObserver$1] */
    /* JADX WARN: Type inference failed for: r3v4, types: [com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.RevLinkOldDynamicDataContext$needShowLastResultObserver$1] */
    public k0(Function0 r17, ld.a r18, com.bytedance.android.livesdk.revenue.service.room.c r19, com.bytedance.android.live.revlink.impl.global.c r20, PkBaseDataContext r22, DynamicContextDependencyImpl r23, AnchorLinkUserCenterV2 r24, DynamicContextDependencyImpl r25, com.bytedance.android.live.revlink.link.domain.dependencyimpl.a r26, com.bytedance.android.live.revlink.impl.multianchor.ui.i r27, String r28, com.bytedance.android.live.revlink.impl.global.c r29) {
        Intrinsics.checkNotNullParameter(r17, "scene");
        Intrinsics.checkNotNullParameter(r22, "pkBaseDataContext");
        Intrinsics.checkNotNullParameter(r26, "seiDependencies");
        this.y = r17;
        this.z = r18;
        this.A = r19;
        this.B = r20;
        this.C = r22;
        this.D = r23;
        this.E = r24;
        this.F = r25;
        this.G = r26;
        this.H = r27;
        this.I = r28;
        this.J = r29;
        LiveData<List<h7.b>> r4 = r22.getLeftMvpRankList();
        LiveData<List<h7.b>> r5 = r22.getRightMvpRankList();
        LiveData<String> r6 = r22.getBattleEffectInfo();
        LiveData<String> r7 = r22.getPkGuestListStr();
        CompositeDisposable r8 = new CompositeDisposable();
        this.a = r8;
        com.bytedance.android.livesdk.revenue.room.a r1 = r19.getRoomContext();
        if (r1 == null) goto L7;
        boolean r9 = true;
        if (r1.getCommonIsAnchor() != true) goto L7;
    L8:
        this.b = r9;
        new MultiDynamicLocalContext();
        this.c = LazyKt.lazy(RevLinkOldDynamicDataContext$isRelayoutOpt$2.INSTANCE);
        LiveData<?> r2 = new MutableLiveData();
        this.d = r2;
        this.e = new MutableLiveData();
        LiveData<?> r10 = new MutableLiveData();
        this.f = r10;
        this.g = new MutableLiveData();
        LiveData<?> r12 = new MutableLiveData();
        this.h = r12;
        LiveData<?> r13 = new MutableLiveData();
        this.i = r13;
        LiveData<?> r14 = new MutableLiveData();
        this.j = r14;
        LiveData<?> r15 = new MutableLiveData();
        this.k = r15;
        LiveData<?> r16 = new NextLiveData();
        this.l = r16;
        LiveData<?> r110 = new NextLiveData();
        this.m = r110;
        this.n = new HashMap();
        this.o = new RevLinkOldDynamicDataContext$battleInviteMsgObserver$1(this);
        this.p = new RevLinkOldDynamicDataContext$battleReplyMsgObserver$1(this);
        this.q = new RevLinkOldDynamicDataContext$needShowLastResultObserver$1(this);
        this.s = new j0(this);
        this.t = new h0(this);
        LiveData<?> r3 = new MutableLiveData();
        this.u = r3;
        HashMap<String, LiveData<?>> r111 = new HashMap();
        LiveData<PkBaseStateMachine.c> r112 = r22.getPkBaseState();
        Intrinsics.checkNotNullParameter(r112, "$this$convertPkStateToMultiState");
        final MediatorLiveData r30 = new MediatorLiveData();
        r30.addSource(r112, new RevLinkOldDynamicDataContextKt$convertPkStateToMultiState$1$1(r30));
        MediatorLiveData r32 = new MediatorLiveData();
        r32.addSource(r30, new i0(r32, this));
        r111.put("pk_status", r32);
        r111.put("remain_time", I());
        r111.put("pk_score", getScoreState());
        r111.put("pk_result", getPkResult());
        r111.put("team_task", getTeamTaskLynxData());
        r111.put("clean_screen", r12);
        r111.put("sei_data", r13);
        r111.put("interact_start_time", r10);
        r111.put("change_screen", r3);
        r111.put("link_anchor_info", r14);
        if (r20 == null) goto L11;
        n21.a r33 = r20.ll();
    L12:
        if (r33 == null) goto L16;
        NextLiveData<Long> r34 = r33.linkRecordTime();
        if (r34 == null) goto L16;
    L17:
        r111.put("link_record_time", r34);
        r111.put("need_last_result", r15);
        r111.put("left_mvp", r4);
        r111.put("right_mvp", r5);
        r111.put("pk_prop_card_info", r6);
        r111.put("pk_guest_info", r7);
        LiveData<PkBaseStateMachine.c> r35 = r22.getPkBaseState();
        Intrinsics.checkNotNullParameter(r35, "$this$convertPkStateToMultiState");
        final MediatorLiveData r36 = new MediatorLiveData();
        r36.addSource(r35, new RevLinkOldDynamicDataContextKt$convertPkStateToMultiState$1$1(r36));
        Intrinsics.checkNotNullParameter(r36, "$this$packagePlayStatus");
        Intrinsics.checkNotNullParameter(this, "dynamicContext");
        MediatorLiveData r37 = new MediatorLiveData();
        r37.addSource(r36, new DynamicUtilsKt$packagePlayStatus$$inlined$also$lambda$1(r37, this, r8));
        r111.put("play_status", r37);
        Intrinsics.checkNotNullParameter(r14, "liveData");
        MediatorLiveData r38 = new MediatorLiveData();
        r38.addSource(r14, new RevLinkOldDynamicDataContextKt$transformLinkAnchorInfo$$inlined$also$lambda$1(r38, null));
        r111.put("link_anchor_list", r38);
        r111.put("pk_audience_count", r2);
        r111.put("battle_invite_msg", r16);
        r111.put("battle_reply_msg", r110);
        Unit r39 = Unit.INSTANCE;
        this.v = r111;
        HashMap<String, FormatType> r40 = new HashMap();
        FormatType r42 = FormatType.NEW;
        r40.put("link_anchor_list", r42);
        r40.put("play_status", r42);
        this.w = r40;
        LinkedHashMap r43 = new LinkedHashMap(MapsKt.mapCapacity(r111.size()));
        Iterator<T> r44 = r111.entrySet().iterator();
    L19:
        if (r44.hasNext() == false) goto L24;
        Map.Entry r45 = (Map.Entry) r44.next();
        Object r46 = r45.getKey();
        String r47 = (String) r45.getKey();
        LiveData r48 = (LiveData) r45.getValue();
        FormatType r49 = this.w.get(r47);
        if (r49 != null) goto L23;
        r49 = FormatType.OLD;
    L23:
        r43.put(r46, com.bytedance.android.live.revlink.impl.multianchor.dynamic.e.b(r48, r47, r49));
        goto L19
    L24:
        this.x = r43;
        return;
    L16:
        r34 = new MutableLiveData();
        goto L17
    L11:
        r33 = null;
    L7:
        r9 = false;
        goto L8
    }
}
