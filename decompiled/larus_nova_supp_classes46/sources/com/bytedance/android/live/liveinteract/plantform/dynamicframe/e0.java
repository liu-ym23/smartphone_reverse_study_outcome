package com.bytedance.android.live.liveinteract.plantform.dynamicframe;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.utils.MultiLinkLoadWidgetUtils;
import com.bytedance.android.live.liveinteract.utils.MultiSceneEnterRoomStatisticsUtils;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.live.network.response.EnterRoomInfoResult;
import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.android.livesdk.config.MultiLinkRevenueEnterRoomOptConfigV2;
import com.bytedance.android.livesdk.config.tp;
import com.bytedance.android.livesdk.gecko.LiveResourcesDistributionImpl;
import com.bytedance.android.livesdk.link.model.z5;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBasisData;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.live.core.utils.SettingUtilExtensionKt;
import com.bytedance.android.livesdkapi.util.IMultiSceneCommonStatistics;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e0 {
    public static final /* synthetic */ int o = 0;
    public final Context a;
    public DataCenter b;
    public ViewGroup c;
    public ih0.c d;
    public ih0.c e;
    public j f;
    public boolean g;
    public final ArrayList<JsonObject> h;
    public final ArrayList<JsonObject> i;
    public final ArrayList<JsonObject> j;
    public IRoom k;
    public JsonObject l;
    public final boolean m;
    public JSEventConsumer n;

    public static final class a {
        public static Context a(Context r1) {
            Intrinsics.checkNotNullParameter(r1, "context");
            if ((r1 instanceof MutableContextWrapper) == false) goto L5;
            return r1;
        L5:
            return new MutableContextWrapper(r1);
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ ih0.c a;
        public final /* synthetic */ Map b;

        public b(ih0.c r1, Map r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            ALogger.i("MultiLinkDynamicWidget-Time", ThreadMethodProxy.currentThread().getName() + ":load card start");
            ih0.c r0 = this.a;
            if (r0 == null) goto L5;
            ih0.c.a.a(r0, null, this.b, 3);
        L5:
            ALogger.i("MultiLinkDynamicWidget-Time", ThreadMethodProxy.currentThread().getName() + ":load card end");
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ e0 a;
        public final /* synthetic */ Map b;

        public c(e0 r1, Map r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            ALogger.i("MultiLinkDynamicWidget-Time", ThreadMethodProxy.currentThread().getName() + ":load micseat card start");
            ih0.c r0 = this.a.e;
            if (r0 == null) goto L5;
            ih0.c.a.a(r0, null, this.b, 3);
        L5:
            ALogger.i("MultiLinkDynamicWidget-Time", ThreadMethodProxy.currentThread().getName() + ":load micseat card end");
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public static JsonObject d() {
        JsonObject r0 = new JsonObject();
        int r1 = com.bytedance.android.live.liveinteract.utils.w0.a;
        Iterator r2 = ((List) vm2.h.i6.getValue(null, vm2.h.a[371(0x173, float:5.2E-43)])).iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        String r3 = (String) r2.next();
        r0.add(r3, SettingUtilExtensionKt.getRawSettingValue(r3));
        goto L4
    L6:
        return r0;
    }

    public static boolean j() {
        com.bytedance.android.livesdk.gecko.n r0 = com.bytedance.android.livesdk.gecko.n.b;
        r0.getClass();
        Intrinsics.checkNotNullParameter("social_linkmic_dynamic_lynx_saas", "channel");
        LiveResourcesDistributionImpl r1 = r0.a;
        r1.getClass();
        Intrinsics.checkNotNullParameter("social_linkmic_dynamic_lynx_saas", "channel");
        com.bytedance.android.livesdk.gecko.j r2 = r1.a;
        if (r2 == null) goto L5;
        Long r3 = r2.c();
    L7:
        if (r3 == null) goto L9;
        long r4 = r3.longValue();
    L10:
        ALogger.d("MultiLinkMainHybridCardManager", "isRenderWidgetStartEventOptGeckoSupportVersion: version=" + r4);
        if (r4 == 0) goto L18;
        if (r4 <= 0) goto L16;
        int r5 = com.bytedance.android.live.liveinteract.utils.w0.a;
        if (r4 < ((MultiLinkRevenueEnterRoomOptConfigV2) tp.a.getValue()).getStartEventOptVersion()) goto L21;
        return true;
    L21:
        return false;
    L16:
        return true;
    L18:
        return false;
    L9:
        r4 = 0;
        goto L10
    L5:
        r3 = null;
        goto L7
    }

    public final JsonObject h() {
        IRoom r0 = com.bytedance.android.live.core.utils.a0.o(this.b);
        z5 r2 = null;
        if (r0 != null) goto L7;
        f2.g();
        Lazy r1 = MultiLinkLoadWidgetUtils.a;
        MultiLinkLoadWidgetUtils.m(this.b, "MultiLinkMainHybridCardManager#geRoomJson", "roomInfo is null");
        return null;
    L7:
        if (this.m == false) goto L34;
        if (this.l == null) goto L27;
        IRoom r3 = this.k;
        if (r3 == null) goto L13;
        z5 r4 = r3.getLinkerDetail();
    L14:
        z5 r5 = r0.getLinkerDetail();
        if (r4 == null) goto L25;
        if (r5 == null) goto L25;
        if (r4 != r5) goto L21;
    L24:
        boolean r6 = true;
    L26:
        if (r6 == false) goto L27;
    L32:
        return this.l;
    L21:
        if (r4.getUiLayout() != r5.getUiLayout()) goto L25;
        if (Intrinsics.areEqual(r4.getPlayModes(), r5.getPlayModes()) == true) goto L24;
    L25:
        r6 = false;
        goto L26
    L13:
        r4 = null;
    L27:
        this.k = r0;
        JsonObject r7 = GsonProtectorUtils.toJsonTree(GsonHelper.getDefault(), r0).getAsJsonObject();
        this.l = r7;
        this.b.put("data_room_cache_json", r7);
        Lazy r8 = MultiLinkLoadWidgetUtils.a;
        DataCenter r9 = this.b;
        StringBuilder r10 = new StringBuilder("roomInfo有区别，更新roomInfoJson, linkerDetail=");
        r10.append(r0.getLinkerDetail());
        r10.append(", last=");
        IRoom r11 = this.k;
        if (r11 == null) goto L30;
        r2 = r11.getLinkerDetail();
    L30:
        r10.append(r2);
        MultiLinkLoadWidgetUtils.p(r9, "MultiLinkMainHybridCardManager#geRoomJson", r10.toString());
        goto L32
    L34:
        return GsonProtectorUtils.toJsonTree(GsonHelper.getDefault(), r0).getAsJsonObject();
    }

    public final void s() {
        if (com.bytedance.android.live.liveinteract.utils.w0.e() == false) goto L17;
        JSEventConsumer r0 = this.n;
        if (r0 != JSEventConsumer.Dual) goto L7;
    L8:
        Iterator<JsonObject> r1 = this.j.iterator();
    L10:
        if (r1.hasNext() == false) goto L15;
        JsonObject r2 = r1.next();
        ih0.c r3 = this.e;
        if (r3 == null) goto L14;
        r3.sendJsEvent("onLinkmicStatusChange", r2);
    L14:
        o(r2);
    L15:
        this.j.clear();
        return;
    L7:
        if (r0 != JSEventConsumer.RenderWidget) goto L15;
    L17:
        Iterator<JsonObject> r4 = this.j.iterator();
    L19:
        if (r4.hasNext() == false) goto L24;
        JsonObject r5 = r4.next();
        ih0.c r6 = this.e;
        if (r6 == null) goto L23;
        r6.sendJsEvent("onLinkmicStatusChange", r5);
    L23:
        o(r5);
        goto L19
    L24:
        this.j.clear();
    }

    public static final void a(e0 r4) {
        r4.getClass();
        if (com.bytedance.android.live.liveinteract.utils.w0.e() == false) goto L37;
        JSEventConsumer r0 = r4.n;
        if (r0 != JSEventConsumer.Dual) goto L7;
    L29:
        Iterator<JsonObject> r1 = r4.i.iterator();
    L31:
        if (r1.hasNext() == false) goto L36;
        JsonObject r2 = r1.next();
        ih0.c r3 = r4.d;
        if (r3 == null) goto L35;
        r3.sendJsEvent("onLinkmicStatusChange", r2);
    L35:
        r4.o(r2);
    L36:
        r4.i.clear();
        r4.h.clear();
        return;
    L7:
        if (r0 == JSEventConsumer.RootWidget) goto L29;
        if (r0 == JSEventConsumer.LogicWidget) goto L29;
        if (r0 == JSEventConsumer.FeedRootWidget) goto L29;
        if (r0 == JSEventConsumer.RenderWidget) goto L15;
    L22:
        Iterator<JsonObject> r5 = r4.h.iterator();
    L24:
        if (r5.hasNext() == false) goto L36;
        JsonObject r6 = r5.next();
        ih0.c r7 = r4.d;
        if (r7 == null) goto L28;
        r7.sendJsEvent("onLinkmicStatusChange", r6);
    L28:
        r4.o(r6);
        goto L24
    L15:
        if (MultiLinkLoadWidgetUtils.g() == true) goto L17;
    L19:
        boolean r8 = false;
    L20:
        if (r8 == false) goto L22;
    L17:
        if (vm2.h.W().installFix() == false) goto L19;
        r8 = true;
        goto L20
    L37:
        Iterator<JsonObject> r9 = r4.i.iterator();
    L39:
        if (r9.hasNext() == false) goto L43;
        JsonObject r10 = r9.next();
        ih0.c r11 = r4.d;
        if (r11 == null) goto L39;
        r11.sendJsEvent("onLinkmicStatusChange", r10);
        goto L39
    L43:
        r4.i.clear();
    }

    public static JsonObject f(IRoom r3) {
        JsonObject r0 = new JsonObject();
        if (r3 == null) goto L7;
        z5 r4 = r3.getLinkerDetail();
        if (r4 == null) goto L7;
        Integer r5 = Integer.valueOf(r4.getUiLayout());
    L8:
        r0.addProperty("ui_layout", r5);
        r0.addProperty("scene", Integer.valueOf(je0.d.f()));
        JsonArray r6 = new JsonArray();
        Iterator<T> r1 = com.bytedance.android.live.liveinteract.plantform.utils.u0.d().iterator();
    L10:
        if (r1.hasNext() == false) goto L12;
        r6.add(Integer.valueOf(((Number) r1.next()).intValue()));
        goto L10
    L12:
        r0.add("play_mode", r6);
        return r0;
    L7:
        r5 = je0.d.h();
        goto L8
    }

    public static Context g(MutableContextWrapper r1) {
        Context r2 = r1.getBaseContext();
        if ((r2 instanceof MutableContextWrapper) == true) goto L5;
        return r2;
    L5:
        return g((MutableContextWrapper) r2);
    }

    public final Map<String, String> e(Long r7) {
        LinkedHashMap r0 = new LinkedHashMap();
        String r1 = null;
        if (r7 != null) goto L10;
        com.bytedance.live.datacontext.m r2 = o3.j(this.b).getRoom();
        if (r2 == null) goto L9;
        IRoom r3 = (IRoom) r2.getValue();
        if (r3 == null) goto L9;
        Object r4 = r3.getIdStr();
    L11:
        com.bytedance.live.datacontext.m r5 = o3.j(this.b).getRoom();
        if (r5 == null) goto L16;
        IRoom r6 = (IRoom) r5.getValue();
        if (r6 == null) goto L16;
        String r8 = r6.getOwnerUserIdString();
    L17:
        String r9 = gh0.a.c();
        if (r4 == null) goto L20;
        r0.put("room_id", r4.toString());
    L20:
        if (r8 == null) goto L23;
        r0.put("anchor_id", r8);
    L23:
        if (r2.a(r9) == false) goto L25;
        r1 = r9;
    L25:
        if (r1 == null) goto L27;
        r0.put("user_id", r1);
    L27:
        r0.put("is_feed", "0");
        ALogger.i("MultiLinkMainHybridCardManager", "获取更新GlobalProps, mHybridCard=" + this.d + ", roomId=" + r7 + ", anchorId=" + r8 + ", userId=" + r9 + ", is_feed=0");
        return r0;
    L16:
        r8 = null;
    L9:
        r4 = null;
        goto L11
    L10:
        r4 = r7;
        goto L11
    }

    public final void i(JsonObject r7) {
        boolean r0 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.a;
        com.bytedance.live.datacontext.m r1 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r1 == null) goto L5;
        IRoom r2 = (IRoom) r1.getValue();
    L5:
        List r3 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.b(0);
        if (r3 != null) goto L8;
        r3 = CollectionsKt.emptyList();
    L8:
        JsonArray r4 = new JsonArray();
        Iterator r5 = r3.iterator();
    L10:
        if (r5.hasNext() == false) goto L13;
        r4.add(new JsonPrimitive((String) r5.next()));
        goto L10
    L13:
        if (MultiLinkLoadWidgetUtils.g() == true) goto L15;
    L17:
        boolean r6 = false;
    L19:
        if (r6 == true) goto L21;
        JsonObject r8 = h();
        if (r8 != null) goto L34;
        boolean r9 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.a;
        if (com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.h() == false) goto L34;
        f2.c("room_id异常 null", 0);
    L34:
        if (r8 == null) goto L36;
        r7.add(PbRequest.SwitchType.ROOM, r8);
    L36:
        r7.add("dynamic_seat_support_list", r4);
        r7.addProperty("dynamic_seat_support_all", Boolean.valueOf(vm2.d.d0().c()));
        return;
    L21:
        if (r7.has(PbRequest.SwitchType.ROOM) == true) goto L36;
        JsonObject r10 = h();
        if (r10 != null) goto L27;
        boolean r11 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.a;
        if (com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.h() == false) goto L27;
        f2.c("room_id异常 null", 0);
    L27:
        if (r10 == null) goto L36;
        r7.add(PbRequest.SwitchType.ROOM, r10);
        goto L36
    L15:
        if (vm2.h.W().startEventRoomOpt() == false) goto L17;
        r6 = true;
        goto L19
    }

    public final void l(Map<String, String> r5) {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.putAll(r5);
        if (je0.d.r() == true) goto L34;
        com.bytedance.live.datacontext.m r6 = o3.j(this.b).getRoom();
        boolean r2 = false;
        if (r6 == null) goto L16;
        IRoom r7 = (IRoom) r6.getValue();
        if (r7 == null) goto L16;
        IBaseUser r8 = r7.getOwner();
        if (r8 == null) goto L16;
        py.k r9 = r8.getAvatarMedium();
        if (r9 == null) goto L16;
        List r10 = r9.getUrls();
        if (r10 == null) goto L16;
        String r11 = (String) CollectionsKt.getOrNull(r10, 0);
        if (r11 == null) goto L16;
    L17:
        r0.put("anchor_avatar_url", r11);
        com.bytedance.live.datacontext.m r12 = o3.j(this.b).getRoom();
        if (r12 == null) goto L24;
        IRoom r13 = (IRoom) r12.getValue();
        if (r13 == null) goto L24;
        IRoomBasisData r14 = r13.getBasisRoomData();
        if (r14 == null) goto L24;
        Boolean r15 = r14.isCustomizeAudioRoom();
    L25:
        r0.put("is_customize_audio", String.valueOf(Intrinsics.areEqual(r15, Boolean.TRUE)));
        com.bytedance.live.datacontext.m r16 = o3.j(this.b).getRoom();
        if (r16 == null) goto L32;
        IRoom r17 = (IRoom) r16.getValue();
        if (r17 == null) goto L32;
        if (r17.isLiveTypeAudio() != true) goto L32;
        r2 = true;
    L32:
        r0.put("is_live_audio", String.valueOf(r2));
    L24:
        r15 = null;
    L16:
        r11 = "";
    L34:
        if (com.bytedance.android.live.liveinteract.utils.w0.a() == false) goto L36;
        Schedulers.io().scheduleDirect(new c(this, r0));
        return;
    L36:
        ALogger.i("MultiLinkDynamicWidget-Time", ThreadMethodProxy.currentThread().getName() + ":load micseat card 2 start");
        ih0.c r18 = this.e;
        if (r18 == null) goto L41;
        ih0.c.a.a(r18, null, r0, 3);
        return;
    }

    public final void n(JsonObject r7) {
        ih0.c r0 = this.d;
        Object r2 = null;
        if (r0 == null) goto L7;
        View r1 = r0.S0();
        if (r1 == null) goto L7;
        Object r3 = r1.getTag(2131389672);
    L9:
        if ((r3 instanceof Boolean) == true) goto L11;
        r3 = null;
    L11:
        Boolean r4 = (Boolean) r3;
        boolean r5 = false;
        if (r4 == null) goto L14;
        boolean r6 = r4.booleanValue();
    L15:
        ih0.c r8 = this.e;
        if (r8 == null) goto L20;
        View r9 = r8.S0();
        if (r9 == null) goto L20;
        Object r10 = r9.getTag(2131389672);
    L22:
        if ((r10 instanceof Boolean) == false) goto L25;
        r2 = r10;
    L25:
        Boolean r11 = (Boolean) r2;
        if (r11 == null) goto L28;
        r5 = r11.booleanValue();
    L28:
        r7.addProperty("root_widget_reuse", Boolean.valueOf(r6));
        r7.addProperty("render_widget_reuse", Boolean.valueOf(r5));
        int r12 = MultiSceneEnterRoomStatisticsUtils.u;
        DataCenter r13 = this.b;
        com.bytedance.live.datacontext.m r14 = o3.j(r13).getRoom();
        long r15 = 0;
        if (r14 == null) goto L33;
        IRoom r16 = (IRoom) r14.getValue();
        if (r16 == null) goto L33;
        long r17 = r16.getRoomId();
    L34:
        MultiSceneEnterRoomStatisticsUtils r18 = MultiSceneEnterRoomStatisticsUtils.a.a(r13, Long.valueOf(r17));
        if (r18 == null) goto L37;
        r18.i = r6;
    L37:
        DataCenter r19 = this.b;
        com.bytedance.live.datacontext.m r20 = o3.j(r19).getRoom();
        if (r20 == null) goto L42;
        IRoom r21 = (IRoom) r20.getValue();
        if (r21 == null) goto L42;
        r15 = r21.getRoomId();
    L42:
        MultiSceneEnterRoomStatisticsUtils r22 = MultiSceneEnterRoomStatisticsUtils.a.a(r19, Long.valueOf(r15));
        if (r22 == null) goto L46;
        r22.j = r5;
        return;
    L46:
        return;
    L33:
        r17 = 0;
    L20:
        r10 = null;
        goto L22
    L14:
        r6 = false;
    L7:
        r3 = null;
        goto L9
    }

    public final void o(JsonObject r8) {
        JsonElement r9 = r8.get("type");
        if (r9 == null) goto L6;
        String r10 = r9.getAsString();
        if (r10 == null) goto L6;
    L7:
        int r0 = r10.hashCode();
        long r2 = 0;
        if (r0 == (-1753865563)) goto L35;
        if (r0 == 177093645) goto L25;
        if (r0 == 2011270307) goto L15;
        return;
    L15:
        if (r10.equals("layout_info") == false) goto L45;
        int r11 = MultiSceneEnterRoomStatisticsUtils.u;
        DataCenter r12 = this.b;
        com.bytedance.live.datacontext.m r1 = o3.j(r12).getRoom();
        if (r1 == null) goto L21;
        IRoom r3 = (IRoom) r1.getValue();
        if (r3 == null) goto L21;
        r2 = r3.getRoomId();
    L21:
        MultiSceneEnterRoomStatisticsUtils r4 = MultiSceneEnterRoomStatisticsUtils.a.a(r12, Long.valueOf(r2));
        if (r4 == null) goto L46;
        IMultiSceneCommonStatistics.DefaultImpls.recordSubElementShow$default(r4, "native_send_layout_info", 0, 2, null);
        return;
    L46:
        return;
    L45:
        return;
    L25:
        if (r10.equals("linkmic") == false) goto L48;
        int r13 = MultiSceneEnterRoomStatisticsUtils.u;
        DataCenter r14 = this.b;
        com.bytedance.live.datacontext.m r5 = o3.j(r14).getRoom();
        if (r5 == null) goto L31;
        IRoom r6 = (IRoom) r5.getValue();
        if (r6 == null) goto L31;
        r2 = r6.getRoomId();
    L31:
        MultiSceneEnterRoomStatisticsUtils r7 = MultiSceneEnterRoomStatisticsUtils.a.a(r14, Long.valueOf(r2));
        if (r7 == null) goto L49;
        IMultiSceneCommonStatistics.DefaultImpls.recordSubElementShow$default(r7, "native_send_ui_layout", 0, 2, null);
        return;
    L49:
        return;
    L48:
        return;
    L35:
        if (r10.equals("guest_list") == false) goto L51;
        int r15 = MultiSceneEnterRoomStatisticsUtils.u;
        DataCenter r16 = this.b;
        com.bytedance.live.datacontext.m r17 = o3.j(r16).getRoom();
        if (r17 == null) goto L41;
        IRoom r18 = (IRoom) r17.getValue();
        if (r18 == null) goto L41;
        r2 = r18.getRoomId();
    L41:
        MultiSceneEnterRoomStatisticsUtils r19 = MultiSceneEnterRoomStatisticsUtils.a.a(r16, Long.valueOf(r2));
        if (r19 == null) goto L52;
        IMultiSceneCommonStatistics.DefaultImpls.recordSubElementShow$default(r19, "native_send_guest_list", 0, 2, null);
        return;
    L52:
        return;
    L51:
        return;
    L6:
        r10 = "";
        goto L7
    }

    public final void p(ih0.c r3) {
        if (MultiLinkLoadWidgetUtils.g() == true) goto L6;
        if (r3 == null) goto L6;
        r3.r1();
    L6:
        if (r3 == null) goto L8;
        r3.registerMethod("registerMessage", new j0(this));
    L8:
        if (r3 == null) goto L10;
        r3.registerMethod("live.unregisterMessage", new n0(this));
    L10:
        if (r3 == null) goto L12;
        r3.registerMethod("registerMessageLatch", new i0(this));
    L12:
        if (r3 == null) goto L14;
        r3.registerMethod("registerWrds", new k0(this));
    L14:
        if (r3 == null) goto L16;
        r3.registerMethod("live.unregisterWrds", new o0(this));
    L16:
        if (r3 == null) goto L18;
        r3.registerMethod("updateLinkmicStatus", new p0(this));
    L18:
        if (r3 == null) goto L20;
        r3.registerMethod("reportAggregateALog", l0.a);
    L20:
        if (r3 == null) goto L22;
        r3.registerMethod("getLinkmicStatus", new g0(this));
    L22:
        if (r3 == null) goto L24;
        r3.registerMethod("reportLinkmicStatus", m0.a);
    L24:
        if (r3 == null) goto L27;
        r3.registerMethod("getLiveNtpTime", new h0(this));
        return;
    }

    public final void r(boolean r19) {
        long r6 = System.currentTimeMillis();
        if (this.g == false) goto L8;
        if (r19 == false) goto L8;
        if (com.bytedance.android.live.liveinteract.utils.w0.b() == false) goto L8;
        return;
    L8:
        boolean r9 = false;
        if (r19 == false) goto L11;
        this.g = true;
    L97:
        JsonObject r10 = new JsonObject();     // Catch: JSONException -> L93
        JsonObject r11 = new JsonObject();     // Catch: JSONException -> L93
        if (r19 == false) goto L90;
        DataCenter r5 = this.b;     // Catch: JSONException -> L93
        z5 r15 = null;
        if (r5 == null) goto L18;
        IRoom r7 = com.bytedance.android.live.core.utils.a0.o(r5);     // Catch: JSONException -> L93
    L19:
        if (r7 == null) goto L30;
        String r16 = r7.getIdStr();     // Catch: JSONException -> L93
        if (r16 != null) goto L23;
    L27:
        r11.addProperty("room_id", String.valueOf(r7.getId()));     // Catch: JSONException -> L93
    L28:
        r11.addProperty("anchor_id", r7.getAnchorId());     // Catch: JSONException -> L93
        goto L30
    L23:
        if (r16.length() <= 0) goto L25;
        r9 = true;
    L25:
        if (r9 != true) goto L27;
        r11.addProperty("room_id", r7.getIdStr());     // Catch: JSONException -> L93
    L30:
        if (com.bytedance.android.live.liveinteract.utils.w0.b() == false) goto L65;
        r11.addProperty("dynamic_load_opt", Boolean.TRUE);     // Catch: JSONException -> L93
        r11.add(PbRequest.SwitchType.ROOM, GsonProtectorUtils.toJsonTree(GsonHelper.getDefault(), r7).getAsJsonObject());     // Catch: JSONException -> L93
        if (r7 != null) goto L34;
    L40:
        IInteractService r14 = (IInteractService) jc1.k.f(IInteractService.class);     // Catch: JSONException -> L93
        if (r14 == null) goto L45;
        rj0.m r17 = r14.getVideoTalkService();     // Catch: JSONException -> L93
        if (r17 == null) goto L45;
        JsonObject r18 = r17.getLinkmicSeatListInfo();     // Catch: JSONException -> L93
    L46:
        r11.add("seat_list_info", r18);     // Catch: JSONException -> L93
        r11.add("linkmic", f(r7));     // Catch: JSONException -> L93
        if (r7 == null) goto L65;
        if (r7.isLiveTypeAudio() == true) goto L65;
        if (r7.isLiveTypeAudio() != true) goto L57;
        IInteractService r12 = (IInteractService) jc1.k.f(IInteractService.class);     // Catch: JSONException -> L93
        if (r12 == null) goto L62;
        qd0.a r13 = r12.getAudioTalkService();     // Catch: JSONException -> L93
        if (r13 == null) goto L62;
        JsonObject r20 = r13.getLinkmicAreaFrameInfo();     // Catch: JSONException -> L93
    L63:
        if (r20 == null) goto L65;
        r11.add("frame_info", r20);     // Catch: JSONException -> L93
    L62:
        r20 = null;
        goto L63
    L57:
        IInteractService r21 = (IInteractService) jc1.k.f(IInteractService.class);     // Catch: JSONException -> L93
        if (r21 == null) goto L62;
        rj0.m r22 = r21.getVideoTalkService();     // Catch: JSONException -> L93
        if (r22 == null) goto L62;
        r20 = r22.getLinkmicAreaFrameInfo();     // Catch: JSONException -> L93
    L45:
        r18 = null;
        goto L46
    L34:
        if (r7.isLiveTypeAudio() != true) goto L40;
        IInteractService r110 = (IInteractService) jc1.k.f(IInteractService.class);     // Catch: JSONException -> L93
        if (r110 == null) goto L45;
        qd0.a r111 = r110.getAudioTalkService();     // Catch: JSONException -> L93
        if (r111 == null) goto L45;
        r18 = r111.getLinkmicSeatListInfo();     // Catch: JSONException -> L93
    L65:
        i(r11);     // Catch: JSONException -> L93
        n(r11);     // Catch: JSONException -> L93
        r11.add("client_settings_info", d());     // Catch: JSONException -> L93
        r11.addProperty("start_event_local_time", Long.valueOf(System.currentTimeMillis()));     // Catch: JSONException -> L93
        r11.addProperty("start_event_ntp_time", Long.valueOf(com.bytedance.android.livesdk.utils.ntp.e.a()));     // Catch: JSONException -> L93
        if (r7 == null) goto L68;
        z5 r23 = r7.getLinkerDetail();     // Catch: JSONException -> L93
    L69:
        if (r23 == null) goto L71;
        r11.add("linker_detail", GsonProtectorUtils.toJsonTree(GsonHelper.getDefault(), r23).getAsJsonObject());     // Catch: JSONException -> L93
    L71:
        DataCenter r8 = this.b;     // Catch: JSONException -> L93
        if (r8 == null) goto L74;
        EnterRoomInfoResult r24 = (EnterRoomInfoResult) r8.get("data_room_enter_info", null);     // Catch: JSONException -> L93
    L75:
        if (r24 == null) goto L77;
        r11.add("enter_info", GsonProtectorUtils.toJsonTree(GsonHelper.getDefault(), r24).getAsJsonObject());     // Catch: JSONException -> L93
    L77:
        r10.add("data", r11);     // Catch: JSONException -> L93
        r10.addProperty("type", "start");     // Catch: JSONException -> L93
        int r25 = MultiSceneEnterRoomStatisticsUtils.u;     // Catch: JSONException -> L93
        DataCenter r26 = this.b;     // Catch: JSONException -> L93
        com.bytedance.live.datacontext.m r112 = o3.j(r26).getRoom();     // Catch: JSONException -> L93
        if (r112 == null) goto L82;
        IRoom r113 = (IRoom) r112.getValue();     // Catch: JSONException -> L93
        if (r113 == null) goto L82;
        long r114 = r113.getRoomId();     // Catch: JSONException -> L93
    L83:
        MultiSceneEnterRoomStatisticsUtils r27 = MultiSceneEnterRoomStatisticsUtils.a.a(r26, Long.valueOf(r114));     // Catch: JSONException -> L93
        if (r27 == null) goto L86;
        r27.recordSubElementShow("send_start_event", System.currentTimeMillis());     // Catch: JSONException -> L93
    L86:
        Lazy r28 = MultiLinkLoadWidgetUtils.a;     // Catch: JSONException -> L93
        DataCenter r29 = this.b;     // Catch: JSONException -> L93
        StringBuilder r115 = new StringBuilder("逻辑主容器发送Start, open = ");     // Catch: JSONException -> L93
        r115.append(r19);     // Catch: JSONException -> L93
        r115.append(", roomInfo.LinkerDetail = ");     // Catch: JSONException -> L93
        if (r7 == null) goto L89;
        r15 = r7.getLinkerDetail();     // Catch: JSONException -> L93
    L89:
        r115.append(r15);     // Catch: JSONException -> L93
        r115.append(", enter_info = ");     // Catch: JSONException -> L93
        r115.append(r24);     // Catch: JSONException -> L93
        r115.append(", stack = ");     // Catch: JSONException -> L93
        r115.append(Log.getStackTraceString(new Throwable()));     // Catch: JSONException -> L93
        MultiLinkLoadWidgetUtils.n(r29, "MultiLinkMainHybridCardManager#sendMainWidgetStartInfo", r115.toString());     // Catch: JSONException -> L93
    L91:
        q(r10, true);     // Catch: JSONException -> L93
    L95:
        Lazy r0 = MultiLinkLoadWidgetUtils.a;
        MultiLinkLoadWidgetUtils.p(this.b, "MultiLinkMainHybridCardManager#sendMainWidgetStartInfo", "spendTime = " + (System.currentTimeMillis() - r6));
        return;
    L82:
        r114 = 0;
        goto L83
    L74:
        r24 = null;
        goto L75
    L68:
        r23 = null;
        goto L69
    L18:
        r7 = null;
        goto L19
    L90:
        r11.addProperty("room_id", "");     // Catch: JSONException -> L93
        r10.add("data", r11);     // Catch: JSONException -> L93
        r10.addProperty("type", "reset");     // Catch: JSONException -> L93
        Lazy r1 = MultiLinkLoadWidgetUtils.a;     // Catch: JSONException -> L93
        MultiLinkLoadWidgetUtils.n(this.b, "MultiLinkMainHybridCardManager#sendMainWidgetStartInfo", "逻辑主容器发送Reset, stack = " + Log.getStackTraceString(new Throwable()));     // Catch: JSONException -> L93
    L93:
        e = move-exception;
        ALogger.e("MainRootWidget", e.toString());
        goto L95
    L11:
        this.g = false;
        goto L97
    }

    public static final void b(e0 r4, ih0.c r5) {
        r4.getClass();
        LinkedHashMap r0 = new LinkedHashMap();
        if (je0.d.r() == true) goto L33;
        com.bytedance.live.datacontext.m r1 = o3.j(r4.b).getRoom();
        boolean r2 = false;
        if (r1 == null) goto L16;
        IRoom r3 = (IRoom) r1.getValue();
        if (r3 == null) goto L16;
        IBaseUser r6 = r3.getOwner();
        if (r6 == null) goto L16;
        py.k r7 = r6.getAvatarMedium();
        if (r7 == null) goto L16;
        List r8 = r7.getUrls();
        if (r8 == null) goto L16;
        String r9 = (String) CollectionsKt.getOrNull(r8, 0);
        if (r9 == null) goto L16;
    L17:
        r0.put("anchor_avatar_url", r9);
        com.bytedance.live.datacontext.m r10 = o3.j(r4.b).getRoom();
        if (r10 == null) goto L24;
        IRoom r11 = (IRoom) r10.getValue();
        if (r11 == null) goto L24;
        IRoomBasisData r12 = r11.getBasisRoomData();
        if (r12 == null) goto L24;
        Boolean r13 = r12.isCustomizeAudioRoom();
    L25:
        r0.put("is_customize_audio", String.valueOf(Intrinsics.areEqual(r13, Boolean.TRUE)));
        com.bytedance.live.datacontext.m r14 = o3.j(r4.b).getRoom();
        if (r14 == null) goto L32;
        IRoom r15 = (IRoom) r14.getValue();
        if (r15 == null) goto L32;
        if (r15.isLiveTypeAudio() != true) goto L32;
        r2 = true;
    L32:
        r0.put("is_live_audio", String.valueOf(r2));
    L24:
        r13 = null;
    L16:
        r9 = "";
    L33:
        if (r5 == null) goto L36;
        r5.updateData(r0);
        return;
    }

    public static void k(ih0.c r2, Map r3) {
        if (com.bytedance.android.live.liveinteract.utils.w0.a() == false) goto L5;
        Schedulers.io().scheduleDirect(new b(r2, r3));
        return;
    L5:
        ALogger.i("MultiLinkDynamicWidget-Time", ThreadMethodProxy.currentThread().getName() + ":load card 2 start");
        if (r2 == null) goto L10;
        ih0.c.a.a(r2, null, r3, 3);
        return;
    }

    public static void m(View r1, Context r2) {
        if (r1 == null) goto L4;
        Context r3 = r1.getContext();
    L6:
        if ((r3 instanceof MutableContextWrapper) == false) goto L14;
        MutableContextWrapper r4 = (MutableContextWrapper) r3;
        if ((!Intrinsics.areEqual(r4.getBaseContext(), r2)) == true) goto L10;
        return;
    L10:
        if ((r2 instanceof MutableContextWrapper) == false) goto L12;
        r2 = g((MutableContextWrapper) r2);
    L12:
        r4.setBaseContext(r2);
        return;
    L14:
        return;
    L4:
        r3 = null;
        goto L6
    }

    public final void q(JsonObject r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r5, "jsonData");
        if (com.bytedance.android.live.liveinteract.utils.w0.e() == false) goto L34;
        if (r6 == false) goto L8;
        ih0.c r0 = this.d;
        if (r0 == null) goto L40;
        r0.sendJsEvent("onLinkmicStatusChange", r5);
    L40:
        ih0.c r1 = this.d;
        Boolean r2 = null;
        if (r1 == null) goto L43;
        Boolean r3 = r1.A();
    L44:
        Boolean r4 = Boolean.TRUE;
        if ((!Intrinsics.areEqual(r3, r4)) == false) goto L49;
        this.i.add(r5);
        if (r6 == false) goto L49;
        this.h.add(r5);
    L49:
        ih0.c r7 = this.e;
        if (r7 == null) goto L52;
        Boolean r8 = r7.A();
    L54:
        if ((!Intrinsics.areEqual(r8, r4)) == false) goto L56;
        this.j.add(r5);
    L56:
        ih0.c r9 = this.d;
        if (r9 == null) goto L59;
        Boolean r10 = r9.A();
    L61:
        if (Intrinsics.areEqual(r10, r4) == true) goto L67;
        ih0.c r11 = this.e;
        if (r11 == null) goto L66;
        r2 = r11.A();
    L66:
        if (Intrinsics.areEqual(r2, r4) == true) goto L67;
        return;
    L67:
        o(r5);
        return;
    L59:
        r10 = null;
        goto L61
    L52:
        r8 = null;
        goto L54
    L43:
        r3 = null;
        goto L44
    L8:
        int r12 = f0.a[this.n.ordinal()];
        if (r12 != 1) goto L11;
    L31:
        ih0.c r13 = this.d;
        if (r13 == null) goto L40;
        r13.sendJsEvent("onLinkmicStatusChange", r5);
        goto L40
    L11:
        if (r12 == 2) goto L31;
        if (r12 == 3) goto L31;
        if (r12 != 4) goto L17;
        ih0.c r14 = this.d;
        if (r14 == null) goto L28;
        r14.sendJsEvent("onLinkmicStatusChange", r5);
    L28:
        ih0.c r15 = this.e;
        if (r15 == null) goto L40;
        r15.sendJsEvent("onLinkmicStatusChange", r5);
        goto L40
    L17:
        if (r12 != 5) goto L40;
        ih0.c r16 = this.d;
        if (r16 == null) goto L22;
        r16.sendJsEvent("onLinkmicStatusChange", r5);
    L22:
        ih0.c r17 = this.e;
        if (r17 == null) goto L40;
        r17.sendJsEvent("onLinkmicStatusChange", r5);
        goto L40
    L34:
        ih0.c r18 = this.d;
        if (r18 == null) goto L37;
        r18.sendJsEvent("onLinkmicStatusChange", r5);
    L37:
        ih0.c r19 = this.e;
        if (r19 == null) goto L40;
        r19.sendJsEvent("onLinkmicStatusChange", r5);
        goto L40
    }

    public final void t(nh0.f r2, JsonObject r3) {
        Intrinsics.checkNotNullParameter(r2, "event");
        Intrinsics.checkNotNullParameter(r3, "json");
        j r0 = this.f;
        if (r0 == null) goto L6;
        r0.c(r2, r3);
        return;
    }

    public e0(Context r2, DataCenter r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r2, "mContext");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        Intrinsics.checkNotNullParameter(r4, "mLinkRootView");
        this.h = new ArrayList();
        this.i = new ArrayList();
        this.j = new ArrayList();
        int r0 = com.bytedance.android.live.liveinteract.utils.w0.a;
        this.m = vm2.h.i().enableJsbTransferOpt();
        this.n = JSEventConsumer.Dual;
        this.a = a.a(r2);
        this.b = r3;
        this.c = r4;
    }

    public static final void c(e0 r7, ih0.c r8, Long r9) {
        r7.getClass();
        LinkedHashMap r0 = new LinkedHashMap();
        String r1 = null;
        if (r9 != null) goto L10;
        com.bytedance.live.datacontext.m r2 = o3.j(r7.b).getRoom();
        if (r2 == null) goto L9;
        IRoom r3 = (IRoom) r2.getValue();
        if (r3 == null) goto L9;
        Object r4 = r3.getIdStr();
    L11:
        com.bytedance.live.datacontext.m r5 = o3.j(r7.b).getRoom();
        if (r5 == null) goto L16;
        IRoom r6 = (IRoom) r5.getValue();
        if (r6 == null) goto L16;
        String r10 = r6.getOwnerUserIdString();
    L17:
        String r11 = gh0.a.c();
        ALogger.i("MultiLinkMainHybridCardManager", "更新GlobalProps, mHybridCard=" + r7.d + ", roomId=" + r9 + ", anchorId=" + r10 + ", userId=" + r11 + ", is_feed=0");
        if (r4 == null) goto L20;
        r0.put("room_id", r4.toString());
    L20:
        if (r10 == null) goto L23;
        r0.put("anchor_id", r10);
    L23:
        if (r2.a(r11) == false) goto L25;
        r1 = r11;
    L25:
        if (r1 == null) goto L27;
        r0.put("user_id", r1);
    L27:
        r0.put("is_feed", "0");
        if (r8 == null) goto L31;
        r8.updateGlobalProps(r0);
        return;
    L31:
        return;
    L16:
        r10 = null;
    L9:
        r4 = null;
        goto L11
    L10:
        r4 = r9;
        goto L11
    }
}
