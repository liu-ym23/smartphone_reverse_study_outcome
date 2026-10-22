package com.bytedance.android.live.revlink.impl.multianchor.dynamic.context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revenue.common.player.vendor.link.RevSeiFrame;
import com.bytedance.android.live.revlink.impl.monitor.LiveFullLinkPKMonitor;
import com.bytedance.android.live.revlink.impl.multianchor.dynamic.FormatType;
import com.bytedance.android.live.revlink.impl.multianchor.feed.wm.FeedMultiWindowManager;
import com.bytedance.android.live.revlink.impl.multianchor.utils.MultiEnterRoomTracer;
import com.bytedance.android.livesdk.link.model.IBattleUserInfo;
import com.bytedance.android.livesdk.link.model.api.IBaseBattleSetting;
import com.bytedance.android.livesdk.link.model.n3;
import com.bytedance.android.livesdk.link.model.x2;
import com.bytedance.android.livesdk.model.RevSeiRegion;
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
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class o0 implements com.bytedance.android.live.revlink.impl.multianchor.feed.machine.presenter.i, d {
    public final CompositeDisposable a;
    public final MutableLiveData<String> b;
    public final MutableLiveData<JSONObject> c;
    public final MutableLiveData<List<com.bytedance.android.livesdk.link.model.p>> d;
    public com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.a e;
    public final MediatorLiveData f;
    public final MutableLiveData g;
    public final HashMap<String, LiveData<?>> h;
    public final Map<String, LiveData<Pair<String, JSONObject>>> i;
    public final com.bytedance.android.live.revlink.impl.multianchor.feed.bridge.c j;
    public final FeedMultiWindowManager k;
    public final com.bytedance.android.live.revlink.impl.pk.scopeservice.a l;
    public final Function0<Pair<Integer, Integer>> m;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.d
    public final com.bytedance.android.live.revlink.impl.monitor.b a() {
        return null;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.d
    public final String f(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        return "";
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.d
    public final LiveFullLinkPKMonitor d() {
        com.bytedance.android.live.revlink.impl.global.c r0 = com.bytedance.android.live.revlink.impl.global.b.k();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getLiveFullLinkPKMonitor();
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
        return this.h;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.d
    public final LiveData<Boolean> getChangeScreenEvent() {
        return this.g;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.d
    public final LiveData<f31.i> getWindowStatus() {
        return this.f;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.d
    public final Map<String, LiveData<Pair<String, JSONObject>>> h() {
        return this.i;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.feed.machine.presenter.i
    public final void c(List<? extends com.bytedance.android.livesdk.link.model.p> r6) {
        com.bytedance.android.live.revlink.impl.settings.dynamic.b r0 = com.bytedance.android.live.revlink.impl.settings.dynamic.b.m;
        r0.getClass();
        if (((Boolean) com.bytedance.android.live.revlink.impl.settings.dynamic.b.i.getValue(r0, com.bytedance.android.live.revlink.impl.settings.dynamic.b.a[7])).booleanValue() == false) goto L12;
        if (r6 != null) goto L6;
    L9:
        boolean r1 = true;
    L10:
        if (r1 == false) goto L12;
        return;
    L6:
        if (r6.isEmpty() == true) goto L9;
        r1 = false;
    L12:
        StringBuilder r2 = new StringBuilder("onOnlineListRefresh list = ");
        ArrayList r3 = null;
        if (r6 == null) goto L15;
        String r4 = r6.toString();
    L16:
        r2.append(r4);
        r2.append(", wrappedList = ");
        if (r6 == null) goto L22;
        r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
        Iterator<T> r5 = r6.iterator();
    L20:
        if (r5.hasNext() == false) goto L22;
        r3.add(new com.bytedance.android.live.revlink.impl.multianchor.dynamic.f((com.bytedance.android.livesdk.link.model.p) r5.next()));
    L22:
        r2.append(String.valueOf(r3));
        jy0.b.d("multi_lynx", r2.toString());
        this.d.setValue(r6);
        return;
    L15:
        r4 = null;
        goto L16
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.d
    public final void g(zy0.b r2) {
        com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.a r0 = this.e;
        if (r0 == null) goto L6;
        r0.b(r2);
        return;
    }

    public final JSONObject j(k31.f r12) {
        JSONObject r0 = new JSONObject();
        RevSeiFrame.a r1 = RevSeiFrame.G;
        String r2 = r12.c;
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        int r5 = 0;
        RevSeiFrame r3 = RevSeiFrame.a.a(r1, r2, false, 6);
        List r4 = (List) this.k.a.getValue();
        if (r4 == null) goto L8;
        int r6 = f31.l.e(r4);
    L9:
        if (r4 == null) goto L11;
        r5 = f31.l.a(r4);
    L11:
        JSONObject r7 = new JSONObject();
        r7.put("screen_width", s1.y());
        r7.put("screen_height", s1.w());
        r7.put("container_width", r6);
        r7.put("container_height", r5);
        r7.put("player_width", ((Number) ((Pair) this.m.invoke()).getFirst()).intValue());
        r7.put("player_height", ((Number) ((Pair) this.m.invoke()).getSecond()).intValue());
        r0.put("extra_info", r7);
        JSONObject r8 = new JSONObject();
        r8.put("ver", r3.n());
        JSONObject r9 = new JSONObject();
        com.bytedance.android.livesdk.model.p0 r10 = r12.b;
        if (r10 == null) goto L17;
        com.bytedance.android.livesdk.model.m0 r13 = r10.f();
        if (r13 == null) goto L17;
        String r14 = r13.b();
        if (r14 == null) goto L17;
    L18:
        r9.put("focus_id", r14);
        com.bytedance.android.livesdk.model.p0 r15 = r12.b;
        if (r15 == null) goto L23;
        com.bytedance.android.livesdk.model.m0 r16 = r15.f();
        if (r16 == null) goto L23;
        Integer r17 = Integer.valueOf(r16.c());
    L24:
        r9.put("layout_type", r17);
        com.bytedance.android.livesdk.model.p0 r18 = r12.b;
        if (r18 == null) goto L29;
        com.bytedance.android.livesdk.model.m0 r19 = r18.f();
        if (r19 == null) goto L29;
        Integer r20 = Integer.valueOf(r19.d());
    L30:
        r9.put("owner_index", r20);
        com.bytedance.android.livesdk.model.p0 r22 = r12.b;
        if (r22 == null) goto L37;
        com.bytedance.android.livesdk.model.m0 r23 = r22.f();
        if (r23 == null) goto L37;
        if (r23.c() != o51.f.d.e.b) goto L37;
        r9.put("is_horizontal", 1);
    L37:
        r8.put("anchor_interact_info", r9);
        JSONArray r24 = new JSONArray();
        com.bytedance.android.livesdk.model.p0 r25 = r12.b;
        if (r25 == null) goto L50;
        List r26 = r25.e();
        if (r26 == null) goto L50;
        Iterator r27 = r26.iterator();
    L43:
        if (r27.hasNext() == false) goto L50;
        String r28 = l97.a.a.toJson((RevSeiRegion) r27.next());     // Catch: Exception -> L47
    L49:
        r24.put(new JSONObject(r28));
    L47:
        e = move-exception;
        jy0.b.c("RevNewDynamicFeedDataContext", "parse object failed " + e, null, 4);
        r28 = "";
    L50:
        r8.put("grids", r24);
        r8.put("channel_id", r12.a());
        r0.put("app_data", r8);
        r0.put("meta_sei", r12.c);
        return r0;
    L29:
        r20 = null;
    L23:
        r17 = null;
    L17:
        r14 = DataType.FALSE;
        goto L18
    L8:
        r6 = 0;
        goto L9
    }

    public static final JSONObject i(o0 r7, int r8) {
        r7.getClass();
        JSONObject r0 = new JSONObject();
        r0.put("state", r8);
        com.bytedance.android.live.revlink.impl.multianchor.feed.bridge.c r9 = r7.j;
        String r1 = null;
        if (r9 == null) goto L7;
        IBaseBattleSetting r10 = r9.g;
        if (r10 == null) goto L7;
        JSONObject r12 = com.bytedance.android.live.revlink.impl.multianchor.dynamic.e.c(r10);
    L8:
        r0.put("battle_settings", r12);
        com.bytedance.android.live.revlink.impl.multianchor.feed.bridge.c r13 = r7.j;
        if (r13 == null) goto L11;
        Map<String, ? extends IBattleUserInfo> r14 = r13.s;
    L12:
        if (r14 == null) goto L14;
        JSONObject r15 = com.bytedance.android.live.revlink.impl.multianchor.dynamic.e.c(r14);
    L15:
        r0.put("play_anchor_list", r15);
        com.bytedance.android.live.revlink.impl.multianchor.feed.bridge.c r16 = r7.j;
        if (r16 == null) goto L20;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.b r17 = r16.r;
        if (r17 == null) goto L20;
        Long r18 = Long.valueOf(r17.a);
    L21:
        r0.put("skin_type", r18);
        com.bytedance.android.live.revlink.impl.multianchor.feed.bridge.c r19 = r7.j;
        if (r19 == null) goto L28;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.b r20 = r19.r;
        if (r20 == null) goto L28;
        x2 r22 = r20.b;
        if (r22 == null) goto L28;
        JSONObject r23 = com.bytedance.android.live.revlink.impl.multianchor.dynamic.e.c(r22);
    L29:
        r0.put("skin_config", r23);
        com.bytedance.android.live.revlink.impl.multianchor.feed.bridge.c r24 = r7.j;
        if (r24 == null) goto L34;
        MutableLiveData<Long> r25 = r24.k;
        if (r25 == null) goto L34;
        Long r26 = (Long) r25.getValue();
    L35:
        r0.put("remain_time", r26);
        r0.put("result", r7.j.n.getValue());
        com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.e r27 = r7.j.F.e;
        if ((r27 instanceof com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.h) == true) goto L38;
        r27 = null;
    L38:
        com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.h r28 = (com.bytedance.android.live.revlink.impl.multianchor.feed.viewstate.h) r27;
        if (r28 == null) goto L41;
        Map<String, Long> r29 = r28.a;
    L42:
        if (r29 == null) goto L48;
        LinkedHashMap r2 = new LinkedHashMap(MapsKt.mapCapacity(r29.size()));
        Iterator<T> r30 = r29.entrySet().iterator();
    L45:
        if (r30.hasNext() == false) goto L47;
        Map.Entry r3 = (Map.Entry) r30.next();
        r2.put(r3.getKey(), Integer.valueOf(((int) ((Number) r3.getValue()).longValue()) - 1));
        goto L45
    L47:
        r0.put("team_info", new JSONObject(r2));
    L48:
        JSONObject r32 = new JSONObject();
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.a r4 = (com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.a) r7.j.m.getValue();
        if (r4 == null) goto L52;
        List<af2.b> r5 = r4.b();
        if (r5 == null) goto L52;
    L53:
        List<af2.b> r6 = r5;
        ArrayList r33 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
        Iterator<T> r34 = r6.iterator();
    L55:
        if (r34.hasNext() == false) goto L57;
        r33.add(new JSONObject(GsonProtectorUtils.toJson(l97.a.a, r34.next())));
        goto L55
    L57:
        int r35 = com.bytedance.revenue.platform.api.core.b.a;
        r32.put("battle_scores", JSONObject.wrap(r33));
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.a r36 = (com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.a) r7.j.m.getValue();
        if (r36 == null) goto L62;
        n3 r37 = r36.a();
        if (r37 == null) goto L62;
        JSONObject r38 = com.bytedance.android.live.revlink.impl.multianchor.dynamic.e.c(r37);
    L63:
        r32.put("pve_data", r38);
        r0.put("play_scores", r32);
        com.bytedance.android.live.revlink.impl.multianchor.feed.bridge.c r39 = r7.j;
        if (r39 == null) goto L68;
        MutableLiveData<String> r40 = r39.o;
        if (r40 == null) goto L68;
        r1 = (String) r40.getValue();
    L68:
        r0.put("team_task", r1);
        r0.put("channel_id", r7.b.getValue());
        return r0;
    L62:
        r38 = null;
    L52:
        r5 = CollectionsKt.emptyList();
        goto L53
    L41:
        r29 = null;
    L34:
        r26 = null;
    L28:
        r23 = null;
    L20:
        r18 = null;
        goto L21
    L14:
        r15 = null;
        goto L15
    L11:
        r14 = null;
    L7:
        r12 = null;
        goto L8
    }

    public o0(com.bytedance.android.live.revlink.impl.multianchor.feed.bridge.c r3, FeedMultiWindowManager r4, com.bytedance.android.live.revlink.impl.pk.scopeservice.a r5, FeedMultiWindowManager r6, Function0 r7) {
        Intrinsics.checkNotNullParameter(r3, "bridge");
        Intrinsics.checkNotNullParameter(r4, "windowManager");
        Intrinsics.checkNotNullParameter(r6, "dynamicWindowManager");
        Intrinsics.checkNotNullParameter(r7, "getPlayerWH");
        this.j = r3;
        this.k = r4;
        this.l = r5;
        this.m = r7;
        this.a = new CompositeDisposable();
        LiveData<?> r8 = new MutableLiveData();
        this.b = r8;
        LiveData<?> r9 = new MutableLiveData();
        this.c = r9;
        MutableLiveData<List<com.bytedance.android.livesdk.link.model.p>> r10 = new MutableLiveData();
        this.d = r10;
        MediatorLiveData r0 = new MediatorLiveData();
        r0.addSource(r4.a, new y0(r0));
        Unit r12 = Unit.INSTANCE;
        this.f = r0;
        this.g = new MutableLiveData();
        HashMap<String, LiveData<?>> r13 = new HashMap();
        r13.put("channel_id", r8);
        r13.put("sei", r9);
        r13.put("team_task", r3.o);
        r13.put("interact_timer_count", r3.p);
        r13.put("interact_start_time", r3.l);
        MutableLiveData<Long> r14 = r3.k;
        final MediatorLiveData r15 = new MediatorLiveData();
        r15.addSource(r14, new RevNewDynamicFeedDataContext$packPkReMainTime$$inlined$also$lambda$1(r15, this));
        r13.put("play_remain_time", r15);
        MutableLiveData<Integer> r16 = r3.h;
        MediatorLiveData r17 = new MediatorLiveData();
        r17.addSource(r16, new RevNewDynamicFeedDataContext$packagePlayStatus$$inlined$also$lambda$1(r17, this));
        r13.put("play_status", r17);
        MediatorLiveData r18 = new MediatorLiveData();
        r18.addSource(r10, new RevNewDynamicFeedDataContext$transformLinkAnchorInfo$$inlined$also$lambda$1(r18, this));
        r13.put("link_anchor_list", r18);
        this.h = r13;
        LinkedHashMap r19 = new LinkedHashMap(MapsKt.mapCapacity(r13.size()));
        Iterator<T> r20 = r13.entrySet().iterator();
    L4:
        if (r20.hasNext() == false) goto L6;
        Map.Entry r22 = (Map.Entry) r20.next();
        Object r23 = r22.getKey();
        String r24 = (String) r22.getKey();
        r19.put(r23, com.bytedance.android.live.revlink.impl.multianchor.dynamic.e.b((LiveData) r22.getValue(), r24, FormatType.NEW));
        goto L4
    L6:
        this.i = r19;
    }
}
