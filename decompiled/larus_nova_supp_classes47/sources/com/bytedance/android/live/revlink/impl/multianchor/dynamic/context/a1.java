package com.bytedance.android.live.revlink.impl.multianchor.dynamic.context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revlink.impl.monitor.LiveFullLinkPKMonitor;
import com.bytedance.android.live.revlink.impl.multianchor.constants.PlayMode;
import com.bytedance.android.live.revlink.impl.multianchor.dynamic.DynamicUtilsKt$packagePlayStatus$$inlined$also$lambda$1;
import com.bytedance.android.live.revlink.impl.multianchor.dynamic.FormatType;
import com.bytedance.android.live.revlink.impl.multianchor.feed.wm.FeedMultiWindowManager;
import com.bytedance.android.live.revlink.impl.multianchor.utils.MultiEnterRoomTracer;
import com.bytedance.android.livesdk.link.model.IBattleUserInfo;
import com.bytedance.android.livesdk.link.model.api.IBaseBattleSetting;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.NotImplementedError;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Deprecated(message = "老的多人预览流数据context")
public final class a1 implements b, com.bytedance.android.live.revlink.impl.multianchor.feed.machine.presenter.i, d {
    public final MutableLiveData<String> a;
    public final MutableLiveData<List<com.bytedance.android.livesdk.link.model.p>> b;
    public final MediatorLiveData c;
    public final MutableLiveData d;
    public final MutableLiveData e;
    public a f;
    public final HashMap<String, LiveData<?>> g;
    public final Map<String, LiveData<Pair<String, JSONObject>>> h;
    public final com.bytedance.android.live.revlink.impl.multianchor.feed.bridge.c i;
    public final FeedMultiWindowManager j;
    public final com.bytedance.android.live.revlink.impl.pk.scopeservice.a k;
    public final Function0<Pair<Integer, Integer>> l;

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.b
    public final long G() {
        return 0;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.d
    public final com.bytedance.android.live.revlink.impl.monitor.b a() {
        return null;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.b
    public final LiveData<PlayMode> H() {
        return this.i.i;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.b
    public final LiveData<Long> I() {
        return this.i.k;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.b
    public final String getAnchorId() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.b
    public final IBaseBattleSetting getBattleSettings() {
        return this.i.g;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.b
    public final Map<String, IBattleUserInfo> getBattleUserInfoMap() {
        return this.i.s;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.b
    public final LiveData<Integer> getPkResult() {
        return this.i.n;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.b
    public final LiveData<com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.a> getScoreState() {
        return this.i.m;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.b
    public final com.bytedance.android.live.revlink.impl.mergepk.pkbase.b getSkinConfig() {
        return this.i.r;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.b
    public final LiveData<String> getTeamTaskLynxData() {
        return this.i.o;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.b
    public final Map<String, Long> getUserIdToTeamId() {
        com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.e r0 = this.i.F.e;
        if ((r0 instanceof com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.h) == true) goto L5;
        r0 = null;
    L5:
        com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.h r1 = (com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.h) r0;
        if (r1 != null) goto L8;
        return null;
    L8:
        return r1.a;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.d
    public final LiveFullLinkPKMonitor d() {
        return com.bytedance.android.live.revlink.impl.global.b.q();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.d
    public final MultiEnterRoomTracer e() {
        com.bytedance.android.live.revlink.impl.global.c r0 = com.bytedance.android.live.revlink.impl.global.b.k();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.i7();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.d
    public final HashMap<String, LiveData<?>> b() {
        return this.g;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.d
    public final LiveData<Boolean> getChangeScreenEvent() {
        return this.e;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.d
    public final LiveData<f31.i> getWindowStatus() {
        return this.c;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.d
    public final Map<String, LiveData<Pair<String, JSONObject>>> h() {
        return this.h;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.feed.machine.presenter.i
    public final void c(List<? extends com.bytedance.android.livesdk.link.model.p> r6) {
        StringBuilder r0 = new StringBuilder("onOnlineListRefresh list = ");
        ArrayList r1 = null;
        if (r6 == null) goto L5;
        String r2 = r6.toString();
    L6:
        r0.append(r2);
        r0.append(", wrappedList = ");
        if (r6 == null) goto L12;
        r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
        Iterator<T> r3 = r6.iterator();
    L10:
        if (r3.hasNext() == false) goto L12;
        r1.add(new com.bytedance.android.live.revlink.impl.multianchor.dynamic.f((com.bytedance.android.livesdk.link.model.p) r3.next()));
    L12:
        r0.append(String.valueOf(r1));
        jy0.b.d("multi_lynx", r0.toString());
        this.b.setValue(r6);
        return;
    L5:
        r2 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.d
    public final String f(String r6) {
        Intrinsics.checkNotNullParameter(r6, "key");
        Object r2 = null;
        if (this.g.containsKey(r6) == false) goto L35;
        LiveData<?> r0 = this.g.get(r6);
        if (r0 == null) goto L7;
        Object r1 = r0.getValue();
    L9:
        if ((r1 instanceof String) == false) goto L17;
        LiveData<?> r7 = this.g.get(r6);
        if (r7 == null) goto L13;
        r2 = r7.getValue();
    L13:
        if (r2 == null) goto L16;
        return (String) r2;
    L16:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    L17:
        LiveData<?> r3 = this.g.get(r6);
        if (r3 == null) goto L20;
        Object r4 = r3.getValue();
    L22:
        if ((r4 instanceof JSONObject) == false) goto L30;
        LiveData<?> r8 = this.g.get(r6);
        if (r8 == null) goto L91;
        Object r9 = r8.getValue();
        if (r9 == null) goto L92;
        String r10 = r9.toString();
        if (r10 != null) goto L94;
        return "";
    L94:
        return r10;
    L92:
        return "";
    L91:
        return "";
    L30:
        LiveData<?> r12 = this.g.get(r6);
        if (r12 == null) goto L33;
        r2 = r12.getValue();
    L33:
        r10 = GsonProtectorUtils.toJson(l97.a.a, r2);
        goto L94
    L20:
        r4 = null;
        goto L22
    L7:
        r1 = null;
        goto L9
    L35:
        if (Intrinsics.areEqual(r6, "channel_id") == true) goto L88;
        if (Intrinsics.areEqual(r6, "channel_id_str") == true) goto L88;
        if (Intrinsics.areEqual(r6, "lynx_data") == false) goto L48;
        IBaseBattleSetting r13 = this.i.g;
        if (r13 == null) goto L93;
        r10 = r13.getLynxData();
        if (r10 != null) goto L94;
        return "";
    L93:
        return "";
    L48:
        if (Intrinsics.areEqual(r6, "skin_type") == false) goto L55;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.b r14 = this.i.r;
        if (r14 == null) goto L66;
        String r5 = String.valueOf(r14.a);
        if (r5 == null) goto L66;
        return r5;
    L66:
        return DataType.FALSE;
    L55:
        if (Intrinsics.areEqual(r6, "skin_config") == false) goto L61;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.b r15 = this.i.r;
        if (r15 != null) goto L59;
        return "";
    L59:
        return GsonProtectorUtils.toJson(l97.a.a, r15.b);
    L61:
        if (Intrinsics.areEqual(r6, "need_last_result") == false) goto L68;
        MutableLiveData r16 = this.d;
        if (r16 == null) goto L66;
        r10 = (String) r16.getValue();
        if (r10 != null) goto L94;
    L68:
        if (Intrinsics.areEqual(r6, "interact_start_time") == false) goto L78;
        com.bytedance.android.live.revlink.impl.multianchor.feed.bridge.c r17 = this.i;
        if (r17 == null) goto L75;
        MutableLiveData<Long> r18 = r17.l;
        if (r18 == null) goto L75;
        Long r19 = (Long) r18.getValue();
        if (r19 == null) goto L75;
    L97:
        return String.valueOf(r19.longValue());
    L75:
        r19 = 0L;
        goto L97
    L78:
        if (Intrinsics.areEqual(r6, "user_infos") == false) goto L81;
        return GsonProtectorUtils.toJson(l97.a.a, this.i.s);
    L81:
        if (Intrinsics.areEqual(r6, "battle_config_setting") == false) goto L86;
        IBaseBattleSetting r20 = this.i.g;
        if (r20 == null) goto L99;
        r2 = r20.getBattleConfigSetting();
    L99:
        return GsonProtectorUtils.toJson(l97.a.a, r2);
    L86:
        return "";
    L88:
        return String.valueOf(0);
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.d
    public final void g(zy0.b r2) {
        a r0 = this.f;
        if (r0 == null) goto L6;
        r0.b(r2);
        return;
    }

    public a1(com.bytedance.android.live.revlink.impl.multianchor.feed.bridge.c r17, FeedMultiWindowManager r18, com.bytedance.android.live.revlink.impl.pk.scopeservice.a r19, FeedMultiWindowManager r20, Function0 r22) {
        Intrinsics.checkNotNullParameter(r17, "bridge");
        Intrinsics.checkNotNullParameter(r18, "windowManager");
        Intrinsics.checkNotNullParameter(r20, "dynamicWindowManager");
        Intrinsics.checkNotNullParameter(r22, "getPlayerWH");
        this.i = r17;
        this.j = r18;
        this.k = r19;
        this.l = r22;
        CompositeDisposable r3 = new CompositeDisposable();
        new MutableLiveData();
        LiveData<?> r4 = new MutableLiveData(DataType.FALSE);
        LiveData<?> r6 = new MutableLiveData();
        this.a = r6;
        LiveData<?> r7 = new MutableLiveData();
        this.b = r7;
        MediatorLiveData r8 = new MediatorLiveData();
        r8.addSource(r18.a, new z0(r8));
        Unit r2 = Unit.INSTANCE;
        this.c = r8;
        LiveData<?> r5 = new MutableLiveData();
        LiveData<?> r9 = new MutableLiveData();
        LiveData<?> r10 = new MutableLiveData();
        LiveData<?> r12 = new MutableLiveData();
        LiveData<?> r13 = new MutableLiveData(DataType.FALSE);
        this.d = r13;
        LiveData<?> r14 = new MutableLiveData();
        LiveData<?> r15 = new MutableLiveData();
        this.e = r15;
        HashMap<String, LiveData<?>> r16 = new HashMap();
        MutableLiveData<Integer> r110 = r17.h;
        final MediatorLiveData r111 = new MediatorLiveData();
        r111.addSource(r110, new RevOldDynamicFeedDataContext$packagePkState$$inlined$also$lambda$1(r111, this));
        r16.put("pk_status", r111);
        r16.put("remain_time", r17.k);
        r16.put("pk_score", r17.m);
        r16.put("pk_result", r17.n);
        r16.put("team_task", r17.o);
        r16.put("clean_screen", r4);
        r16.put("sei_data", r6);
        r16.put("interact_start_time", r17.l);
        r16.put("change_screen", r15);
        r16.put("link_anchor_info", r7);
        r16.put("link_record_time", r17.j);
        r16.put("need_last_result", r13);
        r16.put("left_mvp", r5);
        r16.put("right_mvp", r9);
        r16.put("pk_prop_card_info", r10);
        r16.put("pk_guest_info", r12);
        MutableLiveData<Integer> r1 = r17.h;
        Intrinsics.checkNotNullParameter(r1, "$this$packagePlayStatus");
        Intrinsics.checkNotNullParameter(this, "dynamicContext");
        MediatorLiveData r23 = new MediatorLiveData();
        r23.addSource(r1, new DynamicUtilsKt$packagePlayStatus$$inlined$also$lambda$1(r23, this, r3));
        r16.put("play_status", r23);
        r16.put("link_anchor_list", r7);
        r16.put("pk_audience_count", r14);
        this.g = r16;
        LinkedHashMap r24 = new LinkedHashMap(MapsKt.mapCapacity(r16.size()));
        Iterator<T> r25 = r16.entrySet().iterator();
    L4:
        if (r25.hasNext() == false) goto L6;
        Map.Entry r26 = (Map.Entry) r25.next();
        Object r27 = r26.getKey();
        String r28 = (String) r26.getKey();
        r24.put(r27, com.bytedance.android.live.revlink.impl.multianchor.dynamic.e.b((LiveData) r26.getValue(), r28, FormatType.OLD));
        goto L4
    L6:
        this.h = r24;
    }
}
