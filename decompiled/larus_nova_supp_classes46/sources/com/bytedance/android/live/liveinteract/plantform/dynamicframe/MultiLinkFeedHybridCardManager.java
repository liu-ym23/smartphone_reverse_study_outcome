package com.bytedance.android.live.liveinteract.plantform.dynamicframe;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.browser.IBaseBrowserService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.feedv2.feedview.MultiLinkRadioFeedView;
import com.bytedance.android.live.liveinteract.utils.MultiLinkLoadWidgetUtils;
import com.bytedance.android.live.liveinteract.utils.MultiScenePreviewStatisticsUtils;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.livesdk.config.l51;
import com.bytedance.android.livesdk.config.na0;
import com.bytedance.android.livesdk.config.y50;
import com.bytedance.android.livesdk.j1;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBasisData;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.live.core.utils.SettingUtilExtensionKt;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.LiveMemLeakConfig;
import com.bytedance.android.livesdkapi.util.IMultiScenePreviewStatistics;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class MultiLinkFeedHybridCardManager {
    public ih0.c a;
    public ih0.c b;
    public j c;
    public final ArrayList<JsonObject> d;
    public final ArrayList<JsonObject> e;
    public JsonObject f;
    public final boolean g;
    public final DataCenter h;
    public final ViewGroup i;
    public final com.bytedance.android.live.liveinteract.plantform.dynamicframe.b j;
    public final int k;
    public final IMultiScenePreviewStatistics l;
    public final ih0.b m;
    public final String n;

    public static final class a {
    }

    public static final class b implements com.bytedance.ies.web.jsbridge2.f.b {
    }

    static {
    }

    public static JsonObject a() {
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

    public final Map<String, String> b() {
        LinkedHashMap r0 = new LinkedHashMap();
        IRoom r1 = this.j.r();
        String r2 = null;
        if (r1 == null) goto L5;
        Long r3 = Long.valueOf(r1.getRoomId());
    L6:
        if (r1 == null) goto L8;
        String r4 = r1.getAnchorId();
    L9:
        String r5 = gh0.a.c();
        if (r3 == null) goto L12;
        r0.put("room_id", String.valueOf(r3.longValue()));
    L12:
        if (r4 == null) goto L15;
        r0.put("anchor_id", r4);
    L15:
        if (r2.a(r5) == false) goto L17;
        r2 = r5;
    L17:
        if (r2 == null) goto L19;
        r0.put("user_id", r2);
    L19:
        r0.put("is_feed", "1");
        String r6 = this.n;
        if (r6 != null) goto L22;
        r6 = "";
    L22:
        r0.put("enter_from", r6);
        ALogger.i("MultiLinkFeedHybridCardManager", "获取更新GlobalProps, mHybridCard=" + this.a + ", roomId=" + r3 + ", anchorId=" + r4 + ", userId=" + r5 + ", is_feed=1, props=" + r0);
        return r0;
    L8:
        r4 = null;
        goto L9
    L5:
        r3 = null;
        goto L6
    }

    public final void j() {
        Iterator<T> r0 = this.d.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        JsonObject r1 = (JsonObject) r0.next();
        ih0.c r2 = this.a;
        if (r2 == null) goto L4;
        r2.sendJsEvent("onLinkmicStatusChange", r1);
        goto L4
    L8:
        this.d.clear();
    }

    public final void k() {
        Iterator<T> r0 = this.e.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        JsonObject r1 = (JsonObject) r0.next();
        ih0.c r2 = this.b;
        if (r2 == null) goto L4;
        r2.sendJsEvent("onLinkmicStatusChange", r1);
        goto L4
    L8:
        this.e.clear();
    }

    public static Context c(MutableContextWrapper r1) {
        Context r2 = r1.getBaseContext();
        if ((r2 instanceof MutableContextWrapper) == true) goto L5;
        return r2;
    L5:
        return c((MutableContextWrapper) r2);
    }

    public static Context d(Context r1) {
        if ((r1 instanceof MutableContextWrapper) == false) goto L5;
        return r1;
    L5:
        return new MutableContextWrapper(r1);
    }

    public final void e(Map<String, String> r4) {
        IRoom r0 = this.j.r();
        boolean r1 = false;
        if (r0 == null) goto L12;
        IBaseUser r2 = r0.getOwner();
        if (r2 == null) goto L12;
        py.k r3 = r2.getAvatarMedium();
        if (r3 == null) goto L12;
        List r5 = r3.getUrls();
        if (r5 == null) goto L12;
        String r6 = (String) CollectionsKt.getOrNull(r5, 0);
        if (r6 == null) goto L12;
    L13:
        r4.put("anchor_avatar_url", r6);
        if (this.j.i() == 0) goto L16;
    L17:
        r4.put("scene", String.valueOf(this.j.i()));
    L18:
        IRoom r7 = this.j.r();
        if (r7 == null) goto L23;
        IRoomBasisData r8 = r7.getBasisRoomData();
        if (r8 == null) goto L23;
        Boolean r9 = r8.isCustomizeAudioRoom();
    L24:
        r4.put("is_customize_audio", String.valueOf(Intrinsics.areEqual(r9, Boolean.TRUE)));
        IRoom r10 = this.j.r();
        if (r10 != null) goto L27;
    L29:
        r4.put("is_live_audio", String.valueOf(r1));
        return;
    L27:
        if (r10.isLiveTypeAudio() != true) goto L29;
        r1 = true;
    L23:
        r9 = null;
        goto L24
    L16:
        if ((this.j instanceof MultiLinkRadioFeedView) == false) goto L18;
    L12:
        r6 = "";
        goto L13
    }

    public final void f(JsonObject r5) {
        boolean r0 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.a;
        this.j.r();
        List r1 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.b(this.k);
        if (r1 != null) goto L5;
        r1 = CollectionsKt.emptyList();
    L5:
        JsonArray r2 = new JsonArray();
        Iterator r3 = r1.iterator();
    L7:
        if (r3.hasNext() == false) goto L9;
        r2.add(new JsonPrimitive((String) r3.next()));
        goto L7
    L9:
        r5.add("dynamic_seat_support_list", r2);
        IRoom r4 = this.j.r();
        if (this.g == true) goto L12;
        if (r4 == null) goto L20;
        r5.add(PbRequest.SwitchType.ROOM, GsonProtectorUtils.toJsonTree(GsonHelper.getDefault(), r4).getAsJsonObject());
    L20:
        r5.addProperty("dynamic_seat_support_all", Boolean.valueOf(vm2.d.d0().c()));
        return;
    L12:
        if (this.f != null) goto L15;
        if (r4 == null) goto L15;
        this.f = GsonProtectorUtils.toJsonTree(GsonHelper.getDefault(), r4).getAsJsonObject();
    L15:
        JsonObject r6 = this.f;
        if (r6 == null) goto L20;
        r5.add(PbRequest.SwitchType.ROOM, r6);
        goto L20
    }

    public final void h(ih0.c r3) {
        if (r3 == null) goto L4;
        r3.registerMethod("registerMessage", new MultiLinkFeedHybridCardManager$registerMethods$1(this));
    L4:
        if (r3 == null) goto L6;
        r3.r1();
    L6:
        if (r3 == null) goto L8;
        r3.registerMethod("registerMessageLatch", new q(this));
    L8:
        if (r3 == null) goto L10;
        r3.registerMethod("registerWrds", new r(this));
    L10:
        if (r3 == null) goto L12;
        r3.registerMethod("updateLinkmicStatus", new u(this));
    L12:
        if (r3 == null) goto L14;
        r3.registerMethod("reportAggregateALog", s.a);
    L14:
        if (r3 == null) goto L16;
        r3.registerMethod("getLinkmicStatus", new p(this));
    L16:
        if (r3 == null) goto L18;
        r3.registerMethod("reportLinkmicStatus", t.a);
    L18:
        if (r3 == null) goto L21;
        r3.registerMethod("live.updateViewInLiveBg", new v(this));
        return;
    }

    public final void i(JsonObject r4) {
        Intrinsics.checkNotNullParameter(r4, "jsonData");
        ih0.c r0 = this.a;
        if (r0 == null) goto L5;
        r0.sendJsEvent("onLinkmicStatusChange", r4);
    L5:
        ih0.c r1 = this.b;
        if (r1 == null) goto L8;
        r1.sendJsEvent("onLinkmicStatusChange", r4);
    L8:
        ih0.c r2 = this.a;
        Boolean r3 = null;
        if (r2 == null) goto L11;
        Boolean r5 = r2.A();
    L12:
        Boolean r6 = Boolean.TRUE;
        if ((!Intrinsics.areEqual(r5, r6)) == false) goto L15;
        this.d.add(r4);
    L15:
        ih0.c r7 = this.b;
        if (r7 == null) goto L19;
        r3 = r7.A();
    L19:
        if ((!Intrinsics.areEqual(r3, r6)) == false) goto L22;
        this.e.add(r4);
        return;
    L22:
        return;
    L11:
        r5 = null;
        goto L12
    }

    public final void m(ih0.c r9) {
        LinkedHashMap r0 = new LinkedHashMap();
        IRoom r1 = this.j.r();
        String r2 = null;
        if (r1 == null) goto L5;
        Long r3 = Long.valueOf(r1.getRoomId());
    L6:
        if (r1 == null) goto L8;
        String r4 = r1.getAnchorId();
    L9:
        String r5 = gh0.a.c();
        if (r3 == null) goto L12;
        r0.put("room_id", String.valueOf(r3.longValue()));
    L12:
        if (r4 == null) goto L15;
        r0.put("anchor_id", r4);
    L15:
        if (r2.a(r5) == false) goto L17;
        r2 = r5;
    L17:
        if (r2 == null) goto L19;
        r0.put("user_id", r2);
    L19:
        r0.put("is_feed", "1");
        String r6 = this.n;
        if (r6 != null) goto L22;
        r6 = "";
    L22:
        r0.put("enter_from", r6);
        ALogger.i("MultiLinkFeedHybridCardManager", "更新GlobalProps, mHybridCard=" + this.a + ", roomId=" + r3 + ", anchorId=" + r4 + ", userId=" + r5 + ", is_feed=1, props=" + r0);
        if (r9 == null) goto L26;
        r9.updateGlobalProps(r0);
        return;
    L26:
        return;
    L8:
        r4 = null;
        goto L9
    L5:
        r3 = null;
        goto L6
    }

    public static void g(View r1, Context r2) {
        if (r1 == null) goto L4;
        Context r3 = r1.getContext();
    L6:
        if ((r3 instanceof MutableContextWrapper) == false) goto L14;
        MutableContextWrapper r4 = (MutableContextWrapper) r3;
        if ((!Intrinsics.areEqual(r4.getBaseContext(), r2)) == true) goto L10;
        return;
    L10:
        if ((r2 instanceof MutableContextWrapper) == false) goto L12;
        r2 = c((MutableContextWrapper) r2);
    L12:
        r4.setBaseContext(r2);
        return;
    L14:
        return;
    L4:
        r3 = null;
        goto L6
    }

    public final void l(nh0.f r2, JsonObject r3) {
        Intrinsics.checkNotNullParameter(r2, "event");
        Intrinsics.checkNotNullParameter(r3, "json");
        j r0 = this.c;
        if (r0 == null) goto L6;
        r0.c(r2, r3);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public MultiLinkFeedHybridCardManager(Context r37, DataCenter r38, ViewGroup r39, com.bytedance.android.live.liveinteract.plantform.dynamicframe.b r40, int r41, IMultiScenePreviewStatistics r42, ih0.b r43, String r44) {
        Intrinsics.checkNotNullParameter(r37, "mContext");
        Intrinsics.checkNotNullParameter(r38, "dataCenter");
        Intrinsics.checkNotNullParameter(r39, "mLinkRootView");
        Intrinsics.checkNotNullParameter(r40, "feedInfoProvider");
        this.h = r38;
        this.i = r39;
        this.j = r40;
        this.k = r41;
        this.l = r42;
        this.m = r43;
        this.n = r44;
        this.d = new ArrayList();
        this.e = new ArrayList();
        if (MultiLinkLoadWidgetUtils.g() == true) goto L5;
    L7:
        boolean r7 = false;
    L8:
        if (r7 == false) goto L11;
        this.c = new j(r38, r42);
    L11:
        if (this.a == null) goto L13;
        String r4 = "MultiLinkDynamicWidget-Time";
        String r14 = "lifecycle";
        String r15 = "source";
        String r11 = PbRequest.SwitchType.FEED;
        String r6 = "start";
        View r12 = null;
    L137:
        if (com.bytedance.android.live.liveinteract.utils.h.e(r41) == false) goto L139;
    L140:
        ih0.c r8 = this.b;
        if (r8 == null) goto L148;
        View r9 = r8.S0();
        if (r9 == null) goto L145;
        Object r10 = r9.getParent();
    L146:
        if (r10 == null) goto L148;
    L251:
        if (r40.i() == 0) goto L286;
        JsonObject r1 = new JsonObject();
        JsonObject r2 = new JsonObject();
        ih0.c r3 = this.a;
        if (r3 == null) goto L257;
        View r5 = r3.S0();
        if (r5 == null) goto L257;
        Object r13 = r5.getTag(2131389672);
    L259:
        if ((r13 instanceof Boolean) == true) goto L261;
        r13 = null;
    L261:
        Boolean r16 = (Boolean) r13;
        if (r16 == null) goto L264;
        boolean r17 = r16.booleanValue();
    L265:
        ih0.c r18 = this.b;
        if (r18 == null) goto L270;
        View r19 = r18.S0();
        if (r19 == null) goto L270;
        Object r110 = r19.getTag(2131389672);
    L272:
        if ((r110 instanceof Boolean) == true) goto L274;
        r110 = null;
    L274:
        Boolean r111 = (Boolean) r110;
        if (r111 == null) goto L277;
        boolean r112 = r111.booleanValue();
    L279:
        if ((r42 instanceof MultiScenePreviewStatisticsUtils) == true) goto L281;
        IMultiScenePreviewStatistics r113 = null;
    L282:
        MultiScenePreviewStatisticsUtils r20 = (MultiScenePreviewStatisticsUtils) r113;
        if (r20 == null) goto L285;
        r20.l = r17;
        r20.m = r112;
    L285:
        r2.add("client_settings_info", a());
        r2.addProperty("root_widget_reuse", Boolean.valueOf(r17));
        r2.addProperty("render_widget_reuse", Boolean.valueOf(r112));
        r1.add("data", r2);
        r1.addProperty("type", r6);
        i(r1);
        goto L286
    L281:
        r113 = r42;
        goto L282
    L277:
        r112 = false;
    L270:
        r110 = null;
        goto L272
    L264:
        r17 = false;
    L257:
        r13 = null;
    L286:
        int r21 = com.bytedance.android.live.liveinteract.utils.w0.a;
        this.g = vm2.h.i().enableJsbTransferOpt();
        return;
    L145:
        r10 = r12;
    L148:
        boolean r22 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.a;
        String r23 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.d();
        String r24 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.c();
        IRoom r25 = r40.r();
        if (r25 == null) goto L151;
        Long r26 = Long.valueOf(r25.getRoomId());
    L152:
        Uri r27 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.j.a(r23, r24, r26, true, 0, false, 48);
        a0 r114 = new a0(this);
        if (vm2.h.O().e() == false) goto L157;
        int r115 = z0.b;
        if (z0.c() == false) goto L157;
        boolean r28 = true;
    L158:
        if (r28 == false) goto L197;
        z0 r29 = z0.g;
        Context r116 = d(r37);
        IRoom r117 = r40.r();
        if (r117 == null) goto L162;
        Long r30 = Long.valueOf(r117.getRoomId());
    L163:
        new MultiLinkFeedHybridCardManager$obtainRenderHybridComponent$1(this);
        ih0.c r31 = r29.b(r116, r30, r38);
        if (r31 == null) goto L251;
        this.b = r31;
        h(r31);
        m(this.b);
        ih0.c r32 = this.b;
        LinkedHashMap r33 = new LinkedHashMap();
        e(r33);
        if (r32 == null) goto L169;
        r32.updateData(r33);
    L169:
        ih0.c r34 = this.b;
        if (r34 == null) goto L172;
        r34.J();
    L172:
        JsonObject r35 = new JsonObject();
        r35.addProperty(r14, r6);
        r35.addProperty(r15, r11);
        if (MultiLinkLoadWidgetUtils.k() == false) goto L175;
        r35.add("client_settings_info", a());
    L175:
        f(r35);
        ih0.c r36 = this.b;
        if (r36 == null) goto L178;
        r36.sendJsEvent("renderWidgetLifecycle", r35);
    L178:
        ih0.c r45 = this.b;
        if (r45 == null) goto L183;
        View r46 = r45.S0();
        if (r46 == null) goto L183;
        UtilityKotlinExtentionsKt.w(r46);
    L183:
        k();
        if (((LiveMemLeakConfig) j1.a.getValue()).getOpenFixV2() == false) goto L220;
        ih0.c r47 = this.b;
        if ((r47 instanceof com.bytedance.android.live.liveinteract.plantform.dynamicframe.anniex.c) == false) goto L220;
        if (r47 == null) goto L195;
        ((com.bytedance.android.live.liveinteract.plantform.dynamicframe.anniex.c) r47).h.setTag(2131362966, r114);
        ih0.c r48 = this.b;
        if (r48 == null) goto L193;
        ((com.bytedance.android.live.liveinteract.plantform.dynamicframe.anniex.c) r48).j = new z(r114, r27);
        goto L220
    L193:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.plantform.dynamicframe.anniex.AnnieXCardImpl");
    L195:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.plantform.dynamicframe.anniex.AnnieXCardImpl");
    L220:
        if ((r39 instanceof ConstraintLayout) == false) goto L226;
        ViewGroup.LayoutParams r49 = new ConstraintLayout.LayoutParams(-1, -1);
        ((ConstraintLayout.LayoutParams) r49).topToTop = 2131388184;
        ih0.c r50 = this.b;
        if (r50 == null) goto L231;
        View r51 = r50.S0();
        if (r51 == null) goto L231;
        r51.setLayoutParams(r49);
    L231:
        ViewGroup r52 = (ViewGroup) r39.findViewById(2131380433);
        if (r52 == null) goto L238;
        ih0.c r53 = this.b;
        if (r53 == null) goto L236;
        View r118 = r53.S0();
    L237:
        r52.addView(r118);
        goto L238
    L236:
        r118 = null;
    L238:
        ih0.c r54 = this.a;
        if (r54 == null) goto L241;
        View r119 = r54.getHybridView();
    L242:
        g(r119, r37);
        ih0.c r55 = this.b;
        if (r55 == null) goto L247;
        j r56 = this.c;
        if (r56 == null) goto L247;
        Intrinsics.checkNotNullParameter(r55, "widget");
        r56.a = r55;
    L247:
        j r57 = this.c;
        if (r57 == null) goto L251;
        r57.d(r40.r());
        goto L251
    L241:
        r119 = null;
        goto L242
    L226:
        FrameLayout.LayoutParams r58 = new FrameLayout.LayoutParams(-1, -1);
        ih0.c r59 = this.b;
        if (r59 == null) goto L231;
        View r60 = r59.S0();
        if (r60 == null) goto L231;
        r60.setLayoutParams(r58);
        goto L231
    L162:
        r30 = r12;
        goto L163
    L197:
        if (((Boolean) na0.a.getValue()).booleanValue() == false) goto L199;
        int r61 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.q.a;
        ih0.c r62 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.q.b(d(r37), r27, r114, 0, null, 24);
    L205:
        this.b = r62;
        View r63 = r62.S0();
        if (r63 == null) goto L208;
        UtilityKotlinExtentionsKt.u(r63);
    L208:
        h(this.b);
        Map<String, String> r65 = b();
        LinkedHashMap r66 = new LinkedHashMap();
        e(r66);
        if (com.bytedance.android.live.liveinteract.utils.w0.a() == false) goto L211;
        Schedulers.io().scheduleDirect(new x(this, r66, r65));
    L214:
        m(this.b);
        ih0.c r67 = this.b;
        if (r67 == null) goto L220;
        View r68 = r67.S0();
        if (r68 == null) goto L220;
        r68.setTag(2131389672, Boolean.FALSE);
        goto L220
    L211:
        ALogger.i(r4, ThreadMethodProxy.currentThread().getName() + ":load micseat card 2 start");
        ih0.c r69 = this.b;
        if (r69 == null) goto L214;
        r69.h(r66, r65);
        goto L214
    L199:
        IBaseBrowserService r70 = jc1.k.f(IBaseBrowserService.class);
        if (r70 == null) goto L251;
        HybridCard r71 = r70.getHybridCard(d(r37), r27, r114);
        if (r71 == null) goto L251;
        r62 = new com.bytedance.android.live.liveinteract.plantform.dynamicframe.anniex.b(r71);
    L157:
        r28 = false;
        goto L158
    L151:
        r26 = r12;
        goto L152
    L139:
        if (vm2.d.d0().i() == false) goto L251;
    L13:
        boolean r72 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.a;
        List r73 = vm2.d.d0().f();
        if (r73 != null) goto L16;
    L18:
        String r74 = "";
    L19:
        if (r74 != null) goto L21;
    L25:
        r74 = "https://lf-webcast-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/webcast/mono/lynx/social_linkmic_dynamic_lynx_saas/pages/feed_root_widget/template.js?business_type=livelinkmic&business_group=livelinkmic_feed&initialProps=%5B%22current_user%22%2C%22current_room%22%2C%22linkmic%22%5D";
    L26:
        String r120 = (String) y50.a.getValue();
        if (r2.a(r120) == false) goto L30;
        r74 = "http://" + r120 + ":60001/pages/logic_widget/template.js?business_type=livelinkmic&business_group=livelinkmic_feed&initialProps=%5B%22current_user%22%2C%22current_room%22%2C%22linkmic%22%5D";
    L30:
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L32;
        r74 = r74 + "&enable_debug=true";
    L32:
        String r121 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.e();
        IRoom r122 = r40.r();
        if (r122 == null) goto L35;
        Long r123 = Long.valueOf(r122.getRoomId());
    L36:
        r14 = "lifecycle";
        r15 = "source";
        r4 = "MultiLinkDynamicWidget-Time";
        r6 = "start";
        Uri r75 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.j.a(r74, r121, r123, true, r41, false, 32);
        ALogger.i("MultiLinkFeedHybridCardManager", "main lynx url: " + r75);
        y r76 = new y(this);
        if (vm2.h.O().a() == false) goto L41;
        int r124 = z0.b;
        if (z0.c() == false) goto L41;
        boolean r125 = true;
    L42:
        if (r125 == false) goto L65;
        d0 r77 = d0.f;
        Context r78 = d(r37);
        IRoom r126 = r40.r();
        if (r126 == null) goto L46;
        Long r127 = Long.valueOf(r126.getRoomId());
    L47:
        new MultiLinkFeedHybridCardManager$obtainMainHybridComponent$1(this);
        ih0.c r79 = r77.b(r78, r127, r38);
        this.a = r79;
        if (r79 == null) goto L53;
        View r80 = r79.S0();
        if (r80 == null) goto L53;
        r80.setTag(2131389672, Boolean.TRUE);
    L53:
        h(this.a);
        m(this.a);
        ih0.c r81 = this.a;
        if (r81 == null) goto L56;
        r81.J();
    L56:
        JsonObject r82 = new JsonObject();
        r82.addProperty(r14, r6);
        r11 = PbRequest.SwitchType.FEED;
        r82.addProperty(r15, r11);
        f(r82);
        ih0.c r83 = this.a;
        if (r83 == null) goto L59;
        r83.sendJsEvent("logicWidgetLifecycle", r82);
    L59:
        ih0.c r84 = this.b;
        if (r84 == null) goto L64;
        View r85 = r84.S0();
        if (r85 == null) goto L64;
        UtilityKotlinExtentionsKt.w(r85);
    L64:
        j();
        r12 = null;
    L81:
        if (com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.h() == false) goto L83;
        float r86 = 100.0f;
    L84:
        ih0.c r87 = this.a;
        if (r87 == null) goto L131;
        View r88 = r87.S0();
        if (r88 == null) goto L89;
        Object r89 = r88.getParent();
    L91:
        if ((r89 instanceof ViewGroup) == true) goto L93;
        r89 = r12;
    L93:
        ViewGroup r90 = (ViewGroup) r89;
        if (r90 == null) goto L101;
        ih0.c r128 = this.a;
        if (r128 == null) goto L98;
        View r129 = r128.S0();
    L99:
        r90.removeView(r129);
        goto L101
    L98:
        r129 = r12;
    L101:
        if ((r39 instanceof ConstraintLayout) == false) goto L107;
        ConstraintLayout.LayoutParams r91 = new ConstraintLayout.LayoutParams(s1.f(r86), s1.f(r86));
        ((ViewGroup.MarginLayoutParams) r91).topMargin = s1.f(164.0f);
        r91.topToTop = 2131388184;
        ih0.c r92 = this.a;
        if (r92 == null) goto L113;
        View r93 = r92.S0();
        if (r93 == null) goto L113;
        r93.setLayoutParams(r91);
    L113:
        if (com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.h() == false) goto L119;
        ih0.c r94 = this.a;
        if (r94 == null) goto L125;
        View r95 = r94.S0();
        if (r95 == null) goto L125;
        r95.setBackgroundColor(ColorProtector.parseColor("#55FF0000"));
    L125:
        ih0.c r96 = this.a;
        if (r96 == null) goto L128;
        View r97 = r96.S0();
    L129:
        r39.addView(r97);
        ALogger.i("MultiLinkFeedHybridCardManager", "start add feed main HybridCard");
        goto L131
    L128:
        r97 = r12;
        goto L129
    L119:
        ih0.c r98 = this.a;
        if (r98 == null) goto L125;
        View r99 = r98.S0();
        if (r99 == null) goto L125;
        r99.setBackgroundColor(0);
        goto L125
    L107:
        FrameLayout.LayoutParams r100 = new FrameLayout.LayoutParams(s1.f(r86), s1.f(r86));
        r100.topMargin = s1.f(164.0f);
        ih0.c r101 = this.a;
        if (r101 == null) goto L113;
        View r102 = r101.S0();
        if (r102 == null) goto L113;
        r102.setLayoutParams(r100);
        goto L113
    L89:
        r89 = r12;
    L131:
        ih0.c r103 = this.a;
        if (r103 == null) goto L134;
        View r104 = r103.getHybridView();
    L135:
        g(r104, r37);
        goto L137
    L134:
        r104 = r12;
        goto L135
    L83:
        r86 = 0.01f;
        goto L84
    L46:
        r127 = null;
        goto L47
    L65:
        r11 = PbRequest.SwitchType.FEED;
        if (((Boolean) na0.a.getValue()).booleanValue() == false) goto L68;
        int r130 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.q.a;
        ih0.c r105 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.q.b(d(r37), r75, r76, 0, null, 24);
    L69:
        this.a = r105;
        View r106 = r105.S0();
        if (r106 == null) goto L72;
        r106.setTag(2131389672, Boolean.FALSE);
    L72:
        h(this.a);
        ALogger.i(r4, ThreadMethodProxy.currentThread().getName() + ":load card 2 start");
        Map<String, String> r107 = b();
        ih0.c r131 = this.a;
        if (com.bytedance.android.live.liveinteract.utils.w0.a() == false) goto L75;
        Schedulers.io().scheduleDirect(new w(r131, r107));
    L78:
        r12 = null;
    L79:
        m(this.a);
        goto L81
    L75:
        ALogger.i(r4, ThreadMethodProxy.currentThread().getName() + ":load card 2 start");
        if (r131 == null) goto L78;
        r12 = null;
        ih0.c.a.a(r131, null, r107, 3);
        goto L79
    L68:
        r105 = new com.bytedance.android.live.liveinteract.plantform.dynamicframe.anniex.b(jc1.k.n(IBaseBrowserService.class).getHybridCard(d(r37), r75, r76));
    L41:
        r125 = false;
        goto L42
    L35:
        r123 = null;
        goto L36
    L21:
        if (r74.length() != 0) goto L23;
        boolean r132 = true;
    L24:
        if (r132 == false) goto L26;
    L23:
        r132 = false;
        goto L24
    L16:
        if ((!r73.isEmpty()) == false) goto L18;
        r74 = ((l51) ListProtector.get(r73, 0)).b();
        goto L19
    L5:
        if (vm2.h.W().lynxFirstScreen() == false) goto L7;
        r7 = true;
        goto L8
    }
}
