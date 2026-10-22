package com.bytedance.android.live.revlink.impl.pk.feedview;

import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revenue.model.extension.IRoomLinkExt;
import com.bytedance.android.live.revenue.platform.hybrid.api.HybridType;
import com.bytedance.android.live.revlink.impl.lynxcontainer.PkLynxDataContextKt$convertPkResultToInt$1$1;
import com.bytedance.android.live.revlink.impl.lynxcontainer.PkLynxDataContextKt$sendDataToLynx$$inlined$also$lambda$1;
import com.bytedance.android.live.revlink.impl.monitor.LiveFullLinkPKMonitor;
import com.bytedance.android.live.revlink.impl.multianchor.dynamic.FormatType;
import com.bytedance.android.live.revlink.impl.multianchor.dynamic.MultiRegisterViewListenContext;
import com.bytedance.android.live.revlink.impl.pk.feedview.layout.FeedPkWindowManager;
import com.bytedance.android.live.revlink.impl.pk.ui.PKMeasureOptFrameLayout;
import com.bytedance.android.live.revlink.impl.settings.dynamic.LinkMultiDynamicSettingsKt;
import com.bytedance.android.livesdk.link.model.IBattleUserInfo;
import com.bytedance.android.livesdk.link.model.ILinkMicBattleSetting;
import com.bytedance.android.livesdk.link.model.a9;
import com.bytedance.android.livesdk.link.model.api.IBaseBattleSetting;
import com.bytedance.android.livesdk.utils.u6;
import com.bytedance.android.livesdk.widget.opt.MeasureOptFrameLayout;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.common.utility.Logger;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import w20.ae;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class FeedPkLynxWidget implements com.bytedance.android.live.revlink.impl.lynxcontainer.a {
    public static final /* synthetic */ int G = 0;
    public final com.bytedance.android.live.revlink.impl.pk.feedview.bridge.c A;
    public final com.bytedance.android.live.revlink.impl.pk.scopeservice.a B;
    public final boolean C;
    public final boolean D;
    public final Function0<Pair<Integer, Integer>> E;
    public final com.bytedance.android.live.revlink.impl.pk.feedview.layout.c F;
    public final HashMap<String, zy0.b> a;
    public final HashMap<String, com.bytedance.android.live.revlink.impl.lynxcontainer.b> b;
    public final HashMap<String, PKMeasureOptFrameLayout> c;
    public final com.bytedance.android.live.revlink.impl.pk.feedview.viewstate.a d;
    public final HashMap<String, ArrayList<JSONObject>> e;
    public final ArrayList<String> f;
    public final CompositeDisposable g;
    public e41.a h;
    public final HashMap<String, LiveData<?>> i;
    public final MultiRegisterViewListenContext j;
    public final HashMap<String, LiveData<? extends Object>> k;
    public final Context l;
    public zy0.b m;
    public final com.bytedance.android.live.revlink.impl.lynxcontainer.b n;
    public final HashMap<IBaseBattleSetting, JsonElement> o;
    public pc0.a p;
    public IRoom q;
    public final ArrayList<JSONObject> r;
    public final HashMap<String, com.bytedance.ies.web.jsbridge2.f.b> s;
    public boolean t;
    public boolean u;
    public final Lazy v;
    public final j w;
    public final Map<String, LiveData<Pair<String, JSONObject>>> x;
    public final FrameLayout y;
    public final com.bytedance.android.live.revlink.impl.pk.feedview.viewstate.b z;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ FeedPkLynxWidget a;
        public final /* synthetic */ String b;

        public b(FeedPkLynxWidget r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.bytedance.android.live.revlink.impl.pk.feedview.layout.c r0 = this.a.F;     // Catch: Throwable -> L9
            if (r0 != null) goto L5;
            return;
        L5:
            if (r0.a() != true) goto L16;
            this.a.t(this.b);     // Catch: Throwable -> L9
            return;
        L16:
            return;
        L9:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L17;
            throw th;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ zy0.b a;
        public final /* synthetic */ String b;

        public c(zy0.b r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r3) {
            String r4 = (String) r3;
            zy0.b r0 = this.a;
            if (r0 == null) goto L5;
            xy0.a<?> r1 = r0.g();
        L6:
            if (r1 != null) goto L8;
            return;
        L8:
            if (r1.isDisposed() == true) goto L12;
            r1.sendJsEvent(this.b, r4);
            return;
        L12:
            return;
        L5:
            r1 = null;
            goto L6
        }
    }

    public static final class d<T> implements Consumer {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final void accept(Object r3) {
            jy0.b.b("FeedPkLynxWidget", "sendJsEvent error", (Throwable) r3);
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.revlink.impl.lynxcontainer.a
    public final void e() {
    }

    @Override // com.bytedance.android.live.revlink.impl.lynxcontainer.a
    public final void k() {
    }

    public final boolean u() {
        return ((Boolean) this.v.getValue()).booleanValue();
    }

    public static String s() {
        if (com.bytedance.android.live.revlink.impl.settings.dynamic.a.H.g() == false) goto L6;
        return "H5_revenueInteractData";
    L6:
        return "H5_webcastNotification";
    }

    private final HybridType getType(zy0.b r1) {
        if (r1 == null) goto L6;
        xy0.a<?> r2 = r1.g();
        if (r2 == null) goto L6;
        return r2.o();
    L6:
        return null;
    }

    @Override // com.bytedance.android.live.revlink.impl.lynxcontainer.a
    public final void a(List<String> r8) {
        List<String> r0 = r8;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        return;
    L11:
        Iterator<String> r9 = r8.iterator();
    L13:
        if (r9.hasNext() == false) goto L38;
        com.bytedance.android.live.revlink.impl.lynxcontainer.b r2 = com.bytedance.android.live.revlink.impl.lynxcontainer.d.a(r9.next());
        zy0.b r3 = this.a.get(r2.o());
        if (r3 == null) goto L13;
        View r4 = r3.c();
        if (r4 == null) goto L13;
        ViewGroup.LayoutParams r5 = r4.getLayoutParams();
        ViewGroup.LayoutParams r6 = null;
        if ((r5 instanceof FrameLayout.LayoutParams) == true) goto L22;
        r5 = null;
    L22:
        FrameLayout.LayoutParams r7 = (FrameLayout.LayoutParams) r5;
        if (r7 == null) goto L13;
        if (u() == false) goto L27;
        View r10 = (View) this.c.get(r2.o());
    L28:
        if (r10 == null) goto L37;
        ViewGroup.LayoutParams r12 = r10.getLayoutParams();
        if ((r12 instanceof FrameLayout.LayoutParams) == false) goto L34;
        r6 = r12;
    L34:
        FrameLayout.LayoutParams r13 = (FrameLayout.LayoutParams) r6;
        if (r13 == null) goto L37;
        com.bytedance.android.live.revlink.impl.lynxcontainer.c.a(r2, r13, this.y.getWidth(), this.y.getHeight());
        r10.setLayoutParams(r13);
    L37:
        r4.setLayoutParams(r7);
        goto L13
    L27:
        r10 = r4;
        goto L28
    L38:
        return;
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    @Override // com.bytedance.android.live.revlink.impl.lynxcontainer.a
    public final String c(List<String> r6) {
        if (r6 != null) goto L5;
    L42:
        return "";
    L5:
        if (r6.size() == 0) goto L42;
        JSONObject r1 = new JSONObject();
        Iterator<T> r7 = r6.iterator();
    L9:
        if (r7.hasNext() == false) goto L41;
        String r2 = (String) r7.next();
        JSONObject r4 = null;
        if (this.i.containsKey(r2) == false) goto L20;
        LiveData<?> r3 = this.i.get(r2);
        if (r3 == null) goto L17;
        Object r5 = r3.getValue();
        if (r5 == null) goto L17;
        JSONObject r8 = com.bytedance.android.live.revlink.impl.multianchor.dynamic.e.c(r5);
    L18:
        r1.put(r2, r8);
    L17:
        r8 = null;
    L20:
        if (Intrinsics.areEqual(r2, "linkmic_score") == false) goto L23;
        IBattleUserInfo r9 = this.A;
    L37:
        if (r9 == null) goto L39;
        r4 = com.bytedance.android.live.revlink.impl.multianchor.dynamic.e.c(r9);
    L39:
        r1.put(r2, r4);
        goto L9
    L23:
        if (Intrinsics.areEqual(r2, "play_scores") == false) goto L29;
        MutableLiveData<com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.a> r10 = this.A.f;
        if (r10 == null) goto L27;
        r9 = (com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.a) r10.getValue();
        goto L37
    L27:
        r9 = null;
        goto L37
    L29:
        if (Intrinsics.areEqual(r2, "contribution_list") == false) goto L32;
    L30:
        r9 = "";
        goto L37
    L32:
        if (Intrinsics.areEqual(r2, "battle_settings") == false) goto L35;
        r9 = this.z.b();
        goto L37
    L35:
        if (Intrinsics.areEqual(r2, "play_anchor_list") == false) goto L30;
        r9 = this.z.f;
        goto L37
    L41:
        return r1.toString();
    }

    @Override // com.bytedance.android.live.revlink.impl.lynxcontainer.a
    public final JSONObject f(List<String> r4) {
        JSONObject r0 = new JSONObject();
        List<String> r1 = r4;
        if (r1 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L11;
        return r0;
    L11:
        Iterator<String> r5 = r4.iterator();
    L13:
        if (r5.hasNext() == false) goto L15;
        String r3 = r5.next();
        r0.put(r3, r(r3));
        goto L13
    L15:
        return r0;
    L5:
        if (r1.isEmpty() == true) goto L8;
        r2 = false;
        goto L9
    }

    @Override // com.bytedance.android.live.revlink.impl.lynxcontainer.a
    public final void g(List<String> r4) {
        List<String> r0 = r4;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        return;
    L11:
        Iterator<String> r5 = r4.iterator();
    L13:
        if (r5.hasNext() == false) goto L15;
        com.bytedance.android.live.revlink.impl.lynxcontainer.b r2 = com.bytedance.android.live.revlink.impl.lynxcontainer.d.a(r5.next());
        this.b.put(r2.o(), r2);
        goto L13
    L15:
        return;
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    @Override // com.bytedance.android.live.revlink.impl.lynxcontainer.a
    public final void h(List<String> r5) {
        List<String> r0 = r5;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        return;
    L11:
        Iterator<String> r6 = r5.iterator();
    L13:
        if (r6.hasNext() == false) goto L19;
        com.bytedance.android.live.revlink.impl.lynxcontainer.b r2 = com.bytedance.android.live.revlink.impl.lynxcontainer.d.a(r6.next());
        this.b.remove(r2.o());
        zy0.b r3 = this.a.remove(r2.o());
        if (r3 == null) goto L13;
        w(r2, this.y, r3.c());
        if (r3.isDisposed() == true) goto L13;
        r3.dispose();
        goto L13
    L19:
        return;
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    @Override // com.bytedance.android.live.revlink.impl.lynxcontainer.a
    public final void i(List<String> r7) {
        List<String> r0 = r7;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        return;
    L11:
        Iterator<String> r8 = r7.iterator();
    L13:
        if (r8.hasNext() == false) goto L35;
        com.bytedance.android.live.revlink.impl.lynxcontainer.b r2 = com.bytedance.android.live.revlink.impl.lynxcontainer.d.a(r8.next());
        if (this.a.containsKey(r2.o()) == true) goto L16;
        u6 r3 = new u6(r2.e());
        u6 r4 = r3.d("url");
        Iterator<String> r5 = r2.d().iterator();
    L28:
        if (r5.hasNext() == false) goto L30;
        String r6 = r5.next();
        r4.b(r6, r(r6));
        goto L28
    L30:
        this.f.add(r2.o());
        com.bytedance.android.live.revenue.platform.hybrid.impl.ui.e r9 = ((vy0.c) com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class)).J8(this.l, r3.c(), new FeedPkLynxWidget$addLynxView$hybridCard$1(this, r2));
        this.a.put(r2.o(), r9);
        this.b.put(r2.o(), r2);
        if (r9 == null) goto L13;
        xy0.a<?> r10 = r9.g();
        if (r10 == null) goto L13;
        ((com.bytedance.android.live.revenue.platform.hybrid.impl.component.b) r10).load(null, null);
        goto L13
    L16:
        zy0.b r12 = this.a.get(r2.o());
        if (r12 == null) goto L13;
        View r13 = r12.c();
        if (r13 == null) goto L13;
        w(r2, this.y, r13);
        zy0.b r14 = this.a.get(r2.o());
        if (r14 == null) goto L13;
        xy0.a<?> r15 = r14.g();
        if (r15 == null) goto L13;
        r15.load();
        goto L13
    L35:
        return;
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    @Override // com.bytedance.android.live.revlink.impl.lynxcontainer.a
    public final void l(CallContext r2) {
        Intrinsics.checkNotNullParameter(r2, "callContext");
        this.j.d(r2);
    }

    @Override // com.bytedance.android.live.revlink.impl.lynxcontainer.a
    public final int m(ae r7) {
        Intrinsics.checkNotNullParameter(r7, "params");
        List r0 = r7.b;
        int r1 = 0;
        if (r0 == null) goto L11;
        Iterator r2 = r0.iterator();
    L6:
        if (r2.hasNext() == false) goto L11;
        String r3 = (String) r2.next();
        JSONObject r4 = new JSONObject();
        r4.put("type", "message_from_other");
        r4.put("from", r7.a);
        r4.put(Constants.Keys.DATA, r7.c);
        if (this.a.get(r3) == null) goto L9;
        x(this.a.get(r3), s(), r4.toString());
        goto L6
    L9:
        r1 = 1;
    L11:
        return r1;
    }

    public final void q(String r6) {
        if (this.h != null) goto L5;
    L11:
        t(r6);
        return;
    L5:
        if (com.bytedance.android.live.revlink.impl.settings.dynamic.a.H.d() <= 0) goto L11;
        e41.a r0 = this.h;
        if (r0 == null) goto L13;
        r0.b(new b(this, r6));
        return;
    }

    public final String r(String r5) {
        Gson r0 = GsonHelper.get();
        Object r3 = null;
        if (this.i.containsKey(r5) == false) goto L23;
        LiveData<?> r1 = this.i.get(r5);
        if (r1 == null) goto L7;
        Object r2 = r1.getValue();
    L9:
        if ((r2 instanceof String) == false) goto L17;
        LiveData<?> r6 = this.i.get(r5);
        if (r6 == null) goto L13;
        r3 = r6.getValue();
    L13:
        if (r3 == null) goto L16;
        return (String) r3;
    L16:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    L17:
        LiveData<?> r7 = this.i.get(r5);
        if (r7 == null) goto L21;
        r3 = r7.getValue();
    L21:
        return GsonProtectorUtils.toJson(r0, r3);
    L7:
        r2 = null;
        goto L9
    L23:
        if (this.k.containsKey(r5) == false) goto L43;
        LiveData<? extends Object> r4 = this.k.get(r5);
        if (r4 == null) goto L27;
        Object r8 = r4.getValue();
    L29:
        if ((r8 instanceof String) == false) goto L37;
        LiveData<? extends Object> r9 = this.k.get(r5);
        if (r9 == null) goto L33;
        r3 = r9.getValue();
    L33:
        if (r3 == null) goto L36;
        return (String) r3;
    L36:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    L37:
        LiveData<? extends Object> r10 = this.k.get(r5);
        if (r10 == null) goto L41;
        r3 = r10.getValue();
    L41:
        return GsonProtectorUtils.toJson(r0, r3);
    L27:
        r8 = null;
        goto L29
    L43:
        if (Intrinsics.areEqual(r5, "channel_id") == false) goto L45;
    L75:
        pc0.a r12 = this.p;
        if (r12 == null) goto L93;
        String r13 = r12.getChannelId();
        if (r13 != null) goto L81;
        return "";
    L81:
        return r13;
    L93:
        return "";
    L45:
        if (Intrinsics.areEqual(r5, "channel_id_str") == true) goto L75;
        if (Intrinsics.areEqual(r5, "scene") == false) goto L52;
        return DataType.TRUE;
    L52:
        if (Intrinsics.areEqual(r5, "skin_type") == false) goto L56;
        return String.valueOf(this.z.d());
    L56:
        if (Intrinsics.areEqual(r5, "skin_config") == true) goto L58;
        IBaseBattleSetting r14 = this.z.b();
        if (this.o.get(r14) != null) goto L83;
        this.o.put(r14, GsonProtectorUtils.toJsonTree(r0, r14));
    L83:
        HashMap<IBaseBattleSetting, JsonElement> r15 = this.o;     // Catch: Exception -> L82
        if (r15 == null) goto L87;
        JsonElement r16 = r15.get(r14);     // Catch: Exception -> L82
        if (r16 == null) goto L88;
        JsonObject r17 = r16.getAsJsonObject();     // Catch: Exception -> L82
        if (r17 == null) goto L89;
        JsonElement r18 = r17.get(r5);     // Catch: Exception -> L82
        if (r18 == null) goto L90;
        String r19 = r18.toString();     // Catch: Exception -> L82
        if (r19 != null) goto L74;
        return "";
    L74:
        return r19;
    L90:
        return "";
    L89:
        return "";
    L88:
        return "";
    L87:
        return "";
    L92:
        return "";
    L58:
        return GsonProtectorUtils.toJson(r0, this.z.c());
    }

    public final void t(String r10) {
        com.bytedance.android.live.revlink.impl.settings.dynamic.a r0 = com.bytedance.android.live.revlink.impl.settings.dynamic.a.H;
        if (r0.f() == true) goto L5;
        return;
    L5:
        if (this.q != null) goto L7;
        return;
    L7:
        if (this.u == true) goto L9;
        return;
    L9:
        if (this.t == true) goto L12;
        return;
    L12:
        if (this.m == null) goto L14;
        return;
    L14:
        String r1 = this.n.e();
        u6 r2 = new u6(r1);
        u6 r3 = r2.d("url");
        boolean r4 = this.C;
        String r5 = DataType.TRUE;
        if (r4 == false) goto L18;
        String r6 = "2";
    L21:
        r3.b("load_source", r6);
        r3.b("interact_time_cnt", String.valueOf(LinkMultiDynamicSettingsKt.a()));
        r3.b("from_type", "");
        if (r0.e() == false) goto L24;
        String r7 = DataType.TRUE;
    L25:
        r3.b("control_native_enable", r7);
        IRoom r8 = this.q;
        if (r8 == null) goto L28;
        String r9 = r8.getAnchorId();
    L29:
        r3.b("anchor_id", r9);
        IRoom r12 = this.q;
        if (r12 == null) goto L39;
        IRoomLinkExt r13 = (IRoomLinkExt) r12.castToOrNull(IRoomLinkExt.class);
        if (r13 == null) goto L39;
        a9 r14 = r13.getLinkMicInfo();
        if (r14 == null) goto L39;
        ILinkMicBattleSetting r15 = r14.getBattleSetting();
        if (r15 == null) goto L39;
        r3.b("battle_id", String.valueOf(r15.getBattleId()));
        r3.b("base_play_mode", String.valueOf(r15.getPlayMode()));
        r3.b("base_team_mode", String.valueOf(r15.getTeamMode()));
        r3.b("base_activity_mode", String.valueOf(r15.getActivityMode()));
    L39:
        if (r0.g() == false) goto L41;
        String r16 = DataType.TRUE;
    L42:
        r3.b("live_revenue_interact_dynamic_data_format", r16);
        if (r41.f.a == true) goto L46;
        r5 = DataType.FALSE;
    L46:
        r3.b("support_nine_linker", r5);
        jy0.b.d("FeedPkLynxWidget", "init lynx from " + r10);
        long r17 = SystemClock.elapsedRealtime();
        if (u() == false) goto L49;
        this.m = ((vy0.c) com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class)).q8(this.l, r2.c(), new FeedPkLynxWidget$initHubLynx$2(this, r17, r1));
    L50:
        zy0.b r18 = this.m;
        if (r18 == null) goto L55;
        xy0.a<?> r19 = r18.g();
        if (r19 == null) goto L55;
        r19.load();
    L55:
        zy0.b r110 = this.m;
        if (r110 == null) goto L58;
        r110.l1(new FeedPkLynxWidget$initHubLynx$4(this));
    L58:
        this.z.v = new FeedPkLynxWidget$initHubLynx$5(this);
        this.z.t = this.m;
        return;
    L49:
        this.m = ((vy0.c) com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class)).J8(this.l, r2.c(), new FeedPkLynxWidget$initHubLynx$3(this, r17, r1));
        goto L50
    L41:
        r16 = DataType.FALSE;
        goto L42
    L28:
        r9 = null;
        goto L29
    L24:
        r7 = DataType.FALSE;
        goto L25
    L18:
        if (this.D == false) goto L20;
        r6 = "3";
        goto L21
    L20:
        r6 = DataType.TRUE;
        goto L21
    }

    public static final /* synthetic */ HybridType j(FeedPkLynxWidget r0, zy0.b r1) {
        return r0.getType(r1);
    }

    @Override // com.bytedance.android.live.revlink.impl.lynxcontainer.a
    public final void b(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "event");
        Intrinsics.checkNotNullParameter(r4, "action");
        Intrinsics.checkNotNullParameter(r3, "event");
        Intrinsics.checkNotNullParameter(r4, "action");
    }

    @Override // com.bytedance.android.live.revlink.impl.lynxcontainer.a
    public final void d(CallContext r2, List<String> r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "tags");
        MultiRegisterViewListenContext r0 = this.j;
        if (r0 == null) goto L6;
        r0.c(r2, r3);
        return;
    }

    public final boolean v(com.bytedance.android.live.revlink.impl.lynxcontainer.b r2, String r3) {
        if (r2 == null) goto L10;
        List<String> r4 = r2.n();
        if (r4 == null) goto L10;
        if (r4.contains(r3) != true) goto L10;
        if (ArraysKt.contains(com.bytedance.android.live.revlink.impl.settings.dynamic.a.H.a(), r3) == true) goto L10;
        return true;
    L10:
        return false;
    }

    public static final void n(FeedPkLynxWidget r8, String r9, String r10) {
        if (r8.C == false) goto L6;
        int r6 = 2;
    L9:
        com.bytedance.android.live.revlink.impl.global.c r0 = com.bytedance.android.live.revlink.impl.global.b.k();
        if (r0 == null) goto L21;
        LiveFullLinkPKMonitor r1 = r0.getLiveFullLinkPKMonitor();
        if (r1 == null) goto L21;
        if (r9 != null) goto L16;
        String r3 = "";
    L17:
        if (r10 != null) goto L19;
        String r4 = "";
    L20:
        LiveFullLinkPKMonitor.o(r1, "link_dynamic_central_load_failed", r3, r4, 0, r6, 8);
        goto L21
    L19:
        r4 = r10;
        goto L20
    L16:
        r3 = r9;
    L21:
        jy0.b.c("LynxContainerWidget", "lynx load error errMsg = " + r10, null, 4);
        FrameLayout r12 = r8.y;
        if (r12 == null) goto L24;
        r12.removeAllViews();
    L24:
        r8.z.u = false;
        return;
    L6:
        if (r8.D == false) goto L8;
        r6 = 3;
        goto L9
    L8:
        r6 = 1;
        goto L9
    }

    public final void w(com.bytedance.android.live.revlink.impl.lynxcontainer.b r2, ViewGroup r3, View r4) {
        if (u() == false) goto L9;
        MeasureOptFrameLayout r5 = (PKMeasureOptFrameLayout) this.c.get(r2.o());
        if (r5 == null) goto L17;
        if (r3 == null) goto L8;
        r3.removeView(r5);
    L8:
        this.c.remove(r2.o());
        return;
    L17:
        return;
    L9:
        if (r4 == null) goto L11;
        ViewParent r6 = r4.getParent();
    L13:
        if (Intrinsics.areEqual(r6, r3) == false) goto L19;
        if (r3 == null) goto L20;
        r3.removeView(r4);
        return;
    L20:
        return;
    L19:
        return;
    L11:
        r6 = null;
        goto L13
    }

    public final void x(zy0.b r2, String r3, String r4) {
        if (r2 != null) goto L5;
        return;
    L5:
        if (u() == true) goto L10;
        xy0.a<?> r5 = r2.g();
        if (r5 == null) goto L17;
        r5.sendJsEvent(r3, r4);
        return;
    L17:
        return;
    L10:
        xy0.a<?> r0 = r2.g();
        if (r0 != null) goto L13;
        return;
    L13:
        if (r0.isDisposed() == true) goto L19;
        RxUtilKt.c(Observable.just(r4).observeOn(Schedulers.single()).subscribe(new c(r2, r3), d.a), this.g);
        return;
    }

    public static final void o(FeedPkLynxWidget r6, View r7, long r8, String r10) {
        r6.getClass();
        com.bytedance.android.live.revlink.impl.settings.dynamic.a r0 = com.bytedance.android.live.revlink.impl.settings.dynamic.a.H;
        r0.getClass();
        boolean r1 = false;
        if (((Boolean) com.bytedance.android.live.revlink.impl.settings.dynamic.a.f.getValue(r0, com.bytedance.android.live.revlink.impl.settings.dynamic.a.a[4])).booleanValue() == false) goto L15;
        com.bytedance.android.live.revlink.impl.global.c r2 = com.bytedance.android.live.revlink.impl.global.b.k();
        if (r2 == null) goto L15;
        LiveFullLinkPKMonitor r3 = r2.getLiveFullLinkPKMonitor();
        if (r3 == null) goto L15;
        com.bytedance.android.live.revlink.impl.pk.utils.q r4 = com.bytedance.android.live.revlink.impl.global.b.W();
        if (r4 == null) goto L13;
        com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c r5 = r4.g();
        if (r5 == null) goto L13;
        int r9 = r5.isBattleStatsObtained();
    L14:
        LiveFullLinkPKMonitor.n(r3, r9, SystemClock.elapsedRealtime() - r8, 0);
    L13:
        r9 = 0;
    L15:
        Logger.i("FeedPkLynxWidget", "load success time = " + SystemClock.elapsedRealtime());
        jy0.b.d("FeedPkLynxWidget", "lynx load success ");
        HybridType r12 = r6.getType(r6.m);
        zy0.b r13 = r6.m;
        if (r13 == null) goto L18;
        View r14 = r13.c();
    L20:
        if (r12 != HybridType.H5) goto L25;
        if (r7 == null) goto L24;
        ((WebView) r7).setBackgroundColor(0);
        goto L25
    L24:
        throw new NullPointerException("null cannot be cast to non-null type android.webkit.WebView");
    L25:
        FrameLayout.LayoutParams r15 = new FrameLayout.LayoutParams(-2, -2);
        if (r6.y.getWidth() != 0) goto L28;
    L31:
        r6.y.post(new i(r6, r15, r14));
    L33:
        if (r12 != HybridType.LYNX) goto L35;
        char r16 = 1;
    L36:
        Iterator<String> r17 = r6.i.keySet().iterator();
    L38:
        if (r17.hasNext() == false) goto L52;
        String r18 = r17.next();
        if (com.bytedance.android.live.revlink.impl.settings.dynamic.a.H.g() == false) goto L42;
        LiveData r19 = (LiveData) ((LinkedHashMap) r6.x).get(r18);
    L46:
        if (r19 == null) goto L38;
        Pair r20 = (Pair) r19.getValue();
        if (r20 == null) goto L38;
        if (r6.v(r6.n, (String) r20.getFirst()) == false) goto L38;
        r6.x(r6.m, s(), ((JSONObject) r20.getSecond()).toString());
        goto L38
    L42:
        LiveData<?> r22 = r6.i.get(r18);
        if (r22 == null) goto L45;
        Intrinsics.checkNotNullParameter(r22, "$this$sendDataToLynx");
        Intrinsics.checkNotNullParameter(r18, "tag");
        LiveData r23 = new MediatorLiveData();
        r23.addSource(r22, new PkLynxDataContextKt$sendDataToLynx$$inlined$also$lambda$1(r23, r18));
        r19 = r23;
        goto L46
    L45:
        r19 = null;
        goto L46
    L52:
        Iterator<JSONObject> r24 = r6.r.iterator();
    L54:
        if (r24.hasNext() == false) goto L56;
        r6.x(r6.m, s(), r24.next().toString());
        goto L54
    L56:
        ArrayList<JSONObject> r25 = r6.r;
        if (r25 == null) goto L59;
        r25.clear();
    L59:
        FrameLayout r26 = r6.y;
        if (r26 == null) goto L65;
        vy0.c r27 = (vy0.c) com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class);
        Context r28 = r6.l;
        if (r16 != 1) goto L64;
        r1 = true;
    L64:
        r27.addHybridDebugTool(r28, r26, r10, r1);
    L65:
        r6.z.u = true;
        MultiRegisterViewListenContext r29 = r6.j;
        if (r29 == null) goto L79;
        r29.a();
        return;
    L79:
        return;
    L35:
        r16 = 2;
        goto L36
    L28:
        if (r6.y.getHeight() == 0) goto L31;
        com.bytedance.android.live.revlink.impl.lynxcontainer.c.a(r6.n, r15, r6.y.getWidth(), r6.y.getHeight());
        r6.p(r6.n, r15, r6.y, r14);
        goto L33
    L18:
        r14 = null;
        goto L20
    }

    public final void p(com.bytedance.android.live.revlink.impl.lynxcontainer.b r6, FrameLayout.LayoutParams r7, ViewGroup r8, View r9) {
        if (r9 != null) goto L4;
        return;
    L4:
        ViewParent r1 = null;
        if (u() == false) goto L18;
        MeasureOptFrameLayout r0 = (PKMeasureOptFrameLayout) this.c.remove(r6.o());
        if (r0 == null) goto L9;
        r8.removeView(r0);
    L9:
        MeasureOptFrameLayout r2 = new PKMeasureOptFrameLayout(r8.getContext());
        ViewParent r3 = r9.getParent();
        if ((r3 instanceof ViewGroup) == false) goto L13;
        r1 = r3;
    L13:
        ViewGroup r4 = (ViewGroup) r1;
        if (r4 == null) goto L16;
        r4.removeView(r9);
    L16:
        r2.addView(r9, new FrameLayout.LayoutParams(-1, -1));
        r2.setHasFixSize(true);
        this.c.put(r6.o(), (PKMeasureOptFrameLayout) r2);
        r2.setTranslationZ(r6.s());
        Unit r10 = Unit.INSTANCE;
        r8.addView(r2, r7);
        return;
    L18:
        if ((!Intrinsics.areEqual(r9.getParent(), r8)) == false) goto L27;
        ViewParent r5 = r9.getParent();
        if ((r5 instanceof ViewGroup) == false) goto L23;
        r1 = r5;
    L23:
        ViewGroup r12 = (ViewGroup) r1;
        if (r12 == null) goto L26;
        r12.removeView(r9);
    L26:
        r8.addView(r9, r7);
    L27:
        r9.setTranslationZ(r6.s());
    }

    public FeedPkLynxWidget(FrameLayout r17, com.bytedance.android.live.revlink.impl.pk.feedview.viewstate.b r18, com.bytedance.android.live.revlink.impl.pk.feedview.bridge.c r19, com.bytedance.android.live.revlink.impl.pk.scopeservice.a r20, boolean r22, boolean r23, Function0 r24, FeedPkWindowManager r25) {
        Intrinsics.checkNotNullParameter(r17, "lynxContainer");
        Intrinsics.checkNotNullParameter(r18, "viewState");
        Intrinsics.checkNotNullParameter(r19, "bridget");
        Intrinsics.checkNotNullParameter(r20, "service");
        Intrinsics.checkNotNullParameter(r24, "getPlayerWH");
        this.y = r17;
        this.z = r18;
        this.A = r19;
        this.B = r20;
        this.C = r22;
        this.D = r23;
        this.E = r24;
        this.F = r25;
        this.a = new HashMap();
        this.b = new HashMap();
        this.c = new HashMap();
        com.bytedance.android.live.revlink.impl.pk.feedview.viewstate.a r12 = new com.bytedance.android.live.revlink.impl.pk.feedview.viewstate.a(r17, r18, r19, r20, r24);
        this.d = r12;
        this.e = new HashMap();
        this.f = new ArrayList();
        CompositeDisposable r1 = new CompositeDisposable();
        this.g = r1;
        HashMap<String, LiveData<?>> r2 = new HashMap();
        com.bytedance.android.live.revlink.impl.settings.dynamic.a r3 = com.bytedance.android.live.revlink.impl.settings.dynamic.a.H;
        if (r3.g() == true) goto L5;
        r2.put("pk_status", q.b(r19.e, r18, new FeedPkLynxWidget$$special$$inlined$apply$lambda$1(this)));
        r2.put("remain_time", r19.d);
        r2.put("pk_score", r19.f);
        MutableLiveData<q11.a> r4 = r19.h;
        Intrinsics.checkNotNullParameter(r4, "$this$convertPkResultToInt");
        final MediatorLiveData r5 = new MediatorLiveData();
        r5.addSource(r4, new PkLynxDataContextKt$convertPkResultToInt$1$1(r5));
        r2.put("pk_result", r5);
        r2.put("team_task", r19.g);
        r2.put("pk_prop_card_info", r19.i);
    L6:
        Unit r6 = Unit.INSTANCE;
        this.i = r2;
        this.j = new MultiRegisterViewListenContext(r2);
        HashMap<String, LiveData<? extends Object>> r7 = new HashMap();
        if (r3.g() == false) goto L9;
        r7.put("pk_status", q.b(r19.e, r18, new FeedPkLynxWidget$$special$$inlined$apply$lambda$2(this)));
        r7.put("remain_time", r19.d);
        r7.put("pk_score", r19.f);
        MutableLiveData<q11.a> r8 = r19.h;
        Intrinsics.checkNotNullParameter(r8, "$this$convertPkResultToInt");
        final MediatorLiveData r9 = new MediatorLiveData();
        r9.addSource(r8, new PkLynxDataContextKt$convertPkResultToInt$1$1(r9));
        r7.put("pk_result", r9);
        r7.put("team_task", r19.g);
        r7.put("pk_prop_card_info", r19.i);
    L9:
        this.k = r7;
        this.l = r17.getContext();
        com.bytedance.android.live.revlink.impl.settings.dynamic.b.m.getClass();
        this.n = com.bytedance.android.live.revlink.impl.lynxcontainer.d.a(com.bytedance.android.live.revlink.impl.settings.dynamic.b.e(true));
        this.o = new HashMap();
        this.r = new ArrayList();
        this.s = new HashMap();
        this.u = true;
        this.v = LazyKt.lazy(FeedPkLynxWidget$isFeedOpt$2.INSTANCE);
        this.w = new j(this);
        LinkedHashMap r10 = new LinkedHashMap(MapsKt.mapCapacity(r2.size()));
        Iterator<T> r13 = r2.entrySet().iterator();
    L11:
        if (r13.hasNext() == false) goto L13;
        Map.Entry r14 = (Map.Entry) r13.next();
        Object r15 = r14.getKey();
        String r16 = (String) r14.getKey();
        r10.put(r15, com.bytedance.android.live.revlink.impl.multianchor.dynamic.e.b((LiveData) r14.getValue(), r16, FormatType.NEW));
        goto L11
    L13:
        this.x = r10;
        return;
    L5:
        r2.put("channel_id", r12.a);
        r2.put("sei", r12.b);
        r2.put("screen_info", r12.c);
        r2.put("interact_timer_count", r12.e);
        r2.put("interact_start_time", r12.d);
        r2.put("clean_screen", r12.f);
        r2.put("team_task", r12.k.g);
        MutableLiveData<Integer> r26 = r19.d;
        Intrinsics.checkNotNullParameter(r26, "$this$packagePkRemainTime");
        Intrinsics.checkNotNullParameter(r19, "bridge");
        MediatorLiveData r27 = new MediatorLiveData();
        r27.addSource(r26, new l(r27, r19));
        r2.put("play_remain_time", r27);
        MutableLiveData<com.bytedance.android.live.revlink.impl.pk.feedview.machine.l> r28 = r19.e;
        Intrinsics.checkNotNullParameter(r28, "$this$packagePlayStatus");
        Intrinsics.checkNotNullParameter(r19, "bridget");
        Intrinsics.checkNotNullParameter(r18, "viewState");
        MediatorLiveData r29 = new MediatorLiveData();
        r29.addSource(r28, new o(r29, r19, r18, r1));
        r2.put("play_status", r29);
        goto L6
    }
}
