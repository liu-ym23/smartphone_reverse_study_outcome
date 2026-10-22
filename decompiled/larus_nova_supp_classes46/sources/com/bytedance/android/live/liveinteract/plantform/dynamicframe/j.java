package com.bytedance.android.live.liveinteract.plantform.dynamicframe;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkGuestViewBinder;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.utils.MultiLinkLoadWidgetUtils;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.live.core.utils.SettingUtilExtensionKt;
import com.bytedance.android.livesdkapi.util.IMultiSceneCommonStatistics;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class j {
    public ih0.c a;
    public boolean b;
    public boolean c;
    public Pair<nh0.f, JsonObject> d;
    public Pair<nh0.f, JsonObject> e;
    public Pair<nh0.f, JsonObject> f;
    public IRoom g;
    public final DataCenter h;
    public final IMultiSceneCommonStatistics i;

    public static final class a implements Runnable {
        public final /* synthetic */ j a;

        public a(j r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            IMultiSceneCommonStatistics r1 = this.a.i;     // Catch: Throwable -> L6
            if (r1 == null) goto L9;
            IMultiSceneCommonStatistics.DefaultImpls.recordSubElementShow$default(r1, "lynx_guest_seat_list", 0, 2, null);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public final void a() {
        this.c = true;
        Lazy r0 = MultiLinkLoadWidgetUtils.a;
        DataCenter r1 = this.h;
        StringBuilder r2 = new StringBuilder("RenderWidget(");
        ih0.c r3 = this.a;
        if (r3 == null) goto L5;
        Integer r4 = Integer.valueOf(r3.hashCode());
    L6:
        r2.append(r4);
        MultiLinkLoadWidgetUtils.p(r1, "FirstScreenManager#onDestroy", r2.toString());
        JsonObject r5 = new JsonObject();
        r5.addProperty("type", "first_screen_unmount");
        ih0.c r6 = this.a;
        if (r6 == null) goto L10;
        r6.sendJsEvent("__updateData", r5);
        return;
    L10:
        return;
    L5:
        r4 = null;
        goto L6
    }

    public final void b() {
        if (this.a != null) goto L5;
        return;
    L5:
        if (this.g != null) goto L7;
        return;
    L7:
        if (this.d != null) goto L9;
        return;
    L9:
        if (this.e != null) goto L11;
        return;
    L11:
        if (this.f != null) goto L13;
        return;
    L13:
        if (this.b == false) goto L15;
        return;
    L15:
        if (this.c == true) goto L141;
        JsonObject r0 = new JsonObject();
        r0.addProperty("type", "first_screen");
        JsonObject r1 = new JsonObject();
        Pair<nh0.f, JsonObject> r2 = this.d;
        String r3 = null;
        if (r2 == null) goto L19;
        JsonObject r4 = (JsonObject) r2.getSecond();
    L20:
        r1.add("layout_info", r4);
        Pair<nh0.f, JsonObject> r5 = this.e;
        if (r5 == null) goto L23;
        JsonObject r6 = (JsonObject) r5.getSecond();
    L24:
        r1.add("guest_list", r6);
        Pair<nh0.f, JsonObject> r7 = this.f;
        if (r7 == null) goto L27;
        JsonObject r8 = (JsonObject) r7.getSecond();
    L28:
        r1.add("linkmic_info", r8);
        IRoom r9 = this.g;
        JsonObject r10 = new JsonObject();
        if (r9 == null) goto L31;
        String r11 = String.valueOf(r9.getRoomId());
    L32:
        r10.addProperty("id_str", r11);
        if (r9 == null) goto L35;
        Boolean r12 = Boolean.valueOf(r9.isLiveTypeAudio());
    L36:
        r10.addProperty("live_type_audio", r12);
        if (r9 == null) goto L41;
        String r13 = r9.getAnchorId();
        if (r13 == null) goto L41;
    L42:
        r10.addProperty("owner_user_id", r13);
        JsonObject r14 = new JsonObject();
        if (r9 == null) goto L47;
        IBaseUser r15 = r9.getOwner();
        if (r15 == null) goto L47;
        String r16 = r15.getIdString();
    L48:
        r14.addProperty("id_str", r16);
        if (r9 == null) goto L53;
        IBaseUser r17 = r9.getOwner();
        if (r17 == null) goto L53;
        String r18 = r17.getNickName();
    L54:
        r14.addProperty("nickname", r18);
        Gson r19 = GsonHelper.getDefault();
        if (r9 == null) goto L59;
        IBaseUser r20 = r9.getOwner();
        if (r20 == null) goto L59;
        py.k r21 = r20.getAvatarMedium();
    L60:
        r14.add("avatar_medium", GsonProtectorUtils.toJsonTree(r19, r21));
        r10.add("owner", r14);
        Gson r22 = GsonHelper.getDefault();
        if (r9 == null) goto L63;
        Map r23 = r9.getAnchorABMap();
    L64:
        r10.add("AnchorABMap", GsonProtectorUtils.toJsonTree(r22, r23));
        r10.addProperty("current_user_id", gh0.a.c());
        r1.add("simple_room", r10);
        JsonObject r24 = new JsonObject();
        IBaseUser r25 = jc1.k.n(IMiddlewareUserService.class).user().b();
        if (r25 == null) goto L67;
        r24.addProperty("id", r25.getUserId());
        r24.addProperty("id_str", r25.getIdString());
        r24.addProperty("nickname", r25.getNickName());
        r24.add("avatar_medium", GsonProtectorUtils.toJsonTree(GsonHelper.getDefault(), r25.getAvatarMedium()));
    L67:
        r1.add("simple_user", r24);
        if (MultiLinkLoadWidgetUtils.k() == false) goto L74;
        JsonObject r26 = new JsonObject();
        int r27 = com.bytedance.android.live.liveinteract.utils.w0.a;
        Iterator r28 = ((List) vm2.h.i6.getValue(null, vm2.h.a[371(0x173, float:5.2E-43)])).iterator();
    L71:
        if (r28.hasNext() == false) goto L73;
        String r29 = (String) r28.next();
        r26.add(r29, SettingUtilExtensionKt.getRawSettingValue(r29));
        goto L71
    L73:
        r1.add("client_settings_info", r26);
    L74:
        r0.add("data", r1);
        ih0.c r30 = this.a;
        if (r30 == null) goto L77;
        r30.sendJsEvent("__updateData", r0);
    L77:
        boolean r31 = true;
        this.b = true;
        Pair<nh0.f, JsonObject> r32 = this.e;
        if (r32 == null) goto L91;
        nh0.f r33 = (nh0.f) r32.getFirst();
        if (r33 == null) goto L91;
        List<tf0.e> r34 = r33.d;
        if (r34 == null) goto L91;
        Iterator<T> r35 = r34.iterator();
    L85:
        if (r35.hasNext() == false) goto L89;
        Object r36 = r35.next();
        if ((((tf0.e) r36) instanceof MultiLinkGuestViewBinder.a) == false) goto L85;
    L90:
        tf0.e r37 = (tf0.e) r36;
    L93:
        if ((r37 instanceof MultiLinkGuestViewBinder.a) == true) goto L95;
        r37 = null;
    L95:
        MultiLinkGuestViewBinder.a r38 = (MultiLinkGuestViewBinder.a) r37;
        Lazy r39 = MultiLinkLoadWidgetUtils.a;
        DataCenter r40 = this.h;
        StringBuilder r41 = new StringBuilder("RenderWidget(");
        ih0.c r42 = this.a;
        if (r42 == null) goto L98;
        Integer r43 = Integer.valueOf(r42.hashCode());
    L99:
        r41.append(r43);
        r41.append(") SendFirstScreenData!, room=");
        IRoom r44 = this.g;
        if (r44 == null) goto L104;
        IBaseUser r45 = r44.getOwner();
        if (r45 == null) goto L104;
        String r46 = r45.getNickName();
    L105:
        r41.append(r46);
        r41.append(",layoutInfo=");
        Pair<nh0.f, JsonObject> r47 = this.d;
        if (r47 == null) goto L112;
        nh0.f r48 = (nh0.f) r47.getFirst();
        if (r48 == null) goto L112;
        sf0.b r49 = r48.e;
        if (r49 == null) goto L112;
        Integer r50 = r49.a;
    L113:
        r41.append(r50);
        r41.append(", guest=");
        if (r38 == null) goto L122;
        ch0.e r51 = r38.k;
        if (r51 == null) goto L122;
        ILinkPlayerInfoBridge r52 = r51.a;
        if (r52 == null) goto L122;
        IBaseUser r53 = r52.getUser();
        if (r53 == null) goto L122;
        r3 = r53.getNickName();
    L122:
        r41.append(r3);
        MultiLinkLoadWidgetUtils.p(r40, "FirstScreenManager#tryToSendFirstScreenData", r41.toString());
        if (MultiLinkLoadWidgetUtils.g() == true) goto L125;
    L127:
        r31 = false;
    L128:
        if (r31 == false) goto L142;
        new Handler(Looper.getMainLooper()).post(new a(this));
        return;
    L142:
        return;
    L125:
        if (vm2.h.W().preloadLynxGuestSeatListDurationOpt() == false) goto L127;
    L112:
        r50 = null;
    L104:
        r46 = null;
        goto L105
    L98:
        r43 = null;
        goto L99
    L89:
        r36 = null;
    L91:
        r37 = null;
        goto L93
    L63:
        r23 = null;
    L59:
        r21 = null;
    L53:
        r18 = null;
    L47:
        r16 = null;
    L41:
        r13 = null;
        goto L42
    L35:
        r12 = null;
        goto L36
    L31:
        r11 = null;
        goto L32
    L27:
        r8 = null;
        goto L28
    L23:
        r6 = null;
        goto L24
    L19:
        r4 = null;
        goto L20
    }

    public final void d(IRoom r5) {
        Lazy r0 = MultiLinkLoadWidgetUtils.a;
        DataCenter r1 = this.h;
        StringBuilder r2 = new StringBuilder("RenderWidget(");
        ih0.c r3 = this.a;
        String r4 = null;
        if (r3 == null) goto L5;
        Integer r6 = Integer.valueOf(r3.hashCode());
    L6:
        r2.append(r6);
        r2.append(") updateSimpleRoom, roomId=");
        if (r5 == null) goto L9;
        r4 = r5.getIdStr();
    L9:
        r2.append(r4);
        MultiLinkLoadWidgetUtils.p(r1, "FirstScreenManager#_updateSimpleRoom", r2.toString());
        this.g = r5;
        b();
        return;
    L5:
        r6 = null;
        goto L6
    }

    public j(DataCenter r2, IMultiSceneCommonStatistics r3) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        this.h = r2;
        this.i = r3;
    }

    public final void c(nh0.f r6, JsonObject r7) {
        Intrinsics.checkNotNullParameter(r6, "event");
        Intrinsics.checkNotNullParameter(r7, "jsonData");
        String r0 = r6.a;
        int r1 = r0.hashCode();
        Integer r3 = null;
        if (r1 == (-1753865563)) goto L22;
        if (r1 == 177093645) goto L16;
        if (r1 == 2011270307) goto L10;
        return;
    L10:
        if (r0.equals("layout_info") == false) goto L32;
        Lazy r2 = MultiLinkLoadWidgetUtils.a;
        DataCenter r4 = this.h;
        StringBuilder r5 = new StringBuilder("RenderWidget(");
        ih0.c r8 = this.a;
        if (r8 == null) goto L14;
        r3 = Integer.valueOf(r8.hashCode());
    L14:
        r5.append(r3);
        r5.append(") updateLayoutInfo");
        MultiLinkLoadWidgetUtils.p(r4, "FirstScreenManager#_updateLayoutInfo", r5.toString());
        this.d = new Pair(r6, r7);
        b();
        return;
    L32:
        return;
    L16:
        if (r0.equals("linkmic") == false) goto L34;
        Lazy r9 = MultiLinkLoadWidgetUtils.a;
        DataCenter r10 = this.h;
        StringBuilder r11 = new StringBuilder("RenderWidget(");
        ih0.c r12 = this.a;
        if (r12 == null) goto L20;
        r3 = Integer.valueOf(r12.hashCode());
    L20:
        r11.append(r3);
        r11.append(") updateLinkmicInfo, linkmicInfo=");
        r11.append(r6.b);
        MultiLinkLoadWidgetUtils.p(r10, "FirstScreenManager#_updateLinkmicInfo", r11.toString());
        this.f = new Pair(r6, r7);
        b();
        return;
    L34:
        return;
    L22:
        if (r0.equals("guest_list") == false) goto L36;
        Lazy r13 = MultiLinkLoadWidgetUtils.a;
        DataCenter r14 = this.h;
        StringBuilder r15 = new StringBuilder("RenderWidget(");
        ih0.c r16 = this.a;
        if (r16 == null) goto L26;
        Integer r17 = Integer.valueOf(r16.hashCode());
    L27:
        r15.append(r17);
        r15.append(") updateGuestList, size=");
        List<tf0.e> r18 = r6.d;
        if (r18 == null) goto L30;
        r3 = Integer.valueOf(r18.size());
    L30:
        r15.append(r3);
        MultiLinkLoadWidgetUtils.p(r14, "FirstScreenManager#_updateGuestList", r15.toString());
        this.e = new Pair(r6, r7);
        b();
        return;
    L26:
        r17 = null;
        goto L27
    }
}
