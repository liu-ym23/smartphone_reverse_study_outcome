package com.bytedance.android.live.liveinteract.plantform.dynamicframe;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.dynamicframe.model.AnimUpdateType;
import com.bytedance.android.live.liveinteract.utils.MultiSceneEnterRoomStatisticsUtils;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class e implements kh0.a.InterfaceC0226a {
    public final JsonObject a;
    public final Map<String, h> b;
    public kh0.h c;
    public final Context d;
    public final ih0.b e;
    public final ViewGroup f;
    public final String g;
    public final IRoom h;
    public final boolean i;
    public final String j;
    public final DataCenter k;

    public static final class a {
    }

    static {
    }

    @Override // kh0.a.InterfaceC0226a
    public final boolean a() {
        JsonElement r0 = this.a.get("is_biz_showing");
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.getAsBoolean() != true) goto L7;
        return true;
    }

    public FrameLayout c() {
        View r0 = this.f.findViewById(2131388184);
        if (r0 != null) goto L7;
        return null;
    L7:
        return (FrameLayout) r0.findViewById(2131370477);
    }

    public FrameLayout d() {
        return (FrameLayout) this.f.findViewById(2131388184).findViewById(2131370478);
    }

    public FrameLayout e() {
        return (FrameLayout) this.f.findViewById(2131388184).findViewById(2131380433);
    }

    public final void f(String r5) {
        Intrinsics.checkNotNullParameter(r5, "source");
        ALogger.i("MultiLinkDynamicWidget", "onDestroy, mBizId: " + this.g);
        kh0.h r0 = this.c;
        if (r0 == null) goto L8;
        Iterator r1 = ((LinkedHashMap) r0.a).entrySet().iterator();
    L6:
        if (r1.hasNext() == false) goto L8;
        Map.Entry r2 = (Map.Entry) r1.next();
        String r3 = (String) r2.getKey();
        ((kh0.a) r2.getValue()).b();
    L8:
        Iterator r4 = ((LinkedHashMap) this.b).entrySet().iterator();
    L10:
        if (r4.hasNext() == false) goto L23;
        Map.Entry r6 = (Map.Entry) r4.next();
        ih0.c r7 = ((h) r6.getValue()).a;
        if (r7 == null) goto L22;
        View r8 = r7.S0();
        if (r8 == null) goto L22;
        ViewGroup r9 = UtilityKotlinExtentionsKt.p(r8);
        if (r9 == null) goto L22;
        ih0.c r10 = ((h) r6.getValue()).a;
        if (r10 == null) goto L20;
        View r11 = r10.S0();
    L21:
        r9.removeView(r11);
        goto L22
    L20:
        r11 = null;
    L22:
        ((h) r6.getValue()).b();
        goto L10
    L23:
        ((LinkedHashMap) this.b).clear();
        jh0.c r12 = jh0.b.a;
        String r13 = this.g;
        Intrinsics.checkNotNullParameter(r13, "bizId");
        if (Intrinsics.areEqual(r13, "adventure") == false) goto L26;
        ALogger.i("DynamicBizExtController", "adventure unload");
        com.bytedance.android.live.liveinteract.revenue.adventure.linkcore.a r14 = com.bytedance.android.live.liveinteract.revenue.adventure.linkcore.g.a;
        com.bytedance.android.live.liveinteract.revenue.adventure.linkcore.g.d("adventure unload");
    L26:
        int r15 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.s.a;
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.s.c(this.g, r5);
    }

    public final void g(String r3) {
        h r4 = this.b.remove(r3);
        if (r4 == null) goto L21;
        IInteractService r0 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r0 == null) goto L9;
        ih0.b r1 = r0.dynamicService(this.k);
        if (r1 == null) goto L9;
        r1.Tl(r4.a);
    L9:
        r4.b();
        ih0.c r2 = r4.a;
        if (r2 == null) goto L22;
        View r5 = r2.S0();
        if (r5 == null) goto L23;
        ViewGroup r6 = UtilityKotlinExtentionsKt.p(r5);
        if (r6 == null) goto L24;
        ih0.c r7 = r4.a;
        if (r7 == null) goto L18;
        View r8 = r7.S0();
    L19:
        r6.removeView(r8);
        return;
    L18:
        r8 = null;
        goto L19
    L24:
        return;
    L23:
        return;
    L22:
        return;
    }

    /* JADX WARN: Type inference failed for: r0v32, types: [com.bytedance.android.live.liveinteract.plantform.dynamicframe.MultiLinkBizHybridCardController$updateAnim$1] */
    public final void h(ih0.f r17) {
        Intrinsics.checkNotNullParameter(r17, "updateStatusData");
        int r2 = f.a[r17.getType().ordinal()];
        if (r2 == 1) goto L63;
        if (r2 != 2) goto L177;
        JsonObject r3 = r17.d;
        if (r3 != null) goto L161;
    L30:
        final nh0.b r4 = null;
    L31:
        if (r4 == null) goto L178;
        ALogger.i("MultiLinkDynamicWidget-Time", "start updateAnim");
        String r0 = r4.c;
        boolean r5 = false;
        if (r0 != null) goto L36;
    L39:
        boolean r1 = true;
    L40:
        if (r1 == false) goto L42;
        ALogger.i("MultiLinkDynamicWidget-Time", "start updateAnim webpUrl is null");
        return;
    L42:
        int r6 = f.e[r4.getType().ordinal()];
        if (r6 == 1) goto L62;
        if (r6 != 2) goto L179;
        ALogger.i("MultiLinkDynamicWidget", "START_Seat_ANIM :" + r4);
        String r7 = r4.e;
        if (r7 != null) goto L49;
        return;
    L49:
        if (r7.length() <= 0) goto L51;
        boolean r8 = true;
    L52:
        if (r8 != true) goto L164;
        String r9 = r4.c;
        if (r9 != null) goto L56;
        return;
    L56:
        if (r9.length() <= 0) goto L58;
        r5 = true;
    L58:
        if (r5 != true) goto L166;
        sh0.i0 r10 = sh0.j0.a(this.k);
        if (r10 == null) goto L167;
        r10.d0(sh0.b0.b, new sh0.c0(r4.b, r4.c, r4.e));
        return;
    L167:
        return;
    L166:
        return;
    L164:
        return;
    L51:
        r8 = false;
        goto L52
    L179:
        return;
    L62:
        new MultiLinkBizHybridCardController$updateAnim$1(this, r4).m230invoke();
        return;
    L36:
        if (r0.length() == 0) goto L39;
        r1 = false;
        goto L40
    L178:
        return;
    L161:
        String r11 = r3.get("type").getAsString();     // Catch: Exception -> L28
        Locale r12 = Locale.ROOT;     // Catch: Exception -> L28
        if (r11 == null) goto L27;
        AnimUpdateType r13 = AnimUpdateType.valueOf(r11.toUpperCase(r12));     // Catch: Exception -> L28
        String r14 = r3.get("item_id").getAsString();     // Catch: Exception -> L28
        JsonElement r15 = r3.get("extra");     // Catch: Exception -> L28
        if (r15 == null) goto L24;
        JsonObject r16 = r15.getAsJsonObject();     // Catch: Exception -> L28
        String r18 = r16.get("url").getAsString();     // Catch: Exception -> L28
        JsonElement r19 = r16.get("frame");     // Catch: Exception -> L28
        if (r19 == null) goto L15;
        JsonObject r20 = r19.getAsJsonObject();     // Catch: Exception -> L28
    L16:
        if (r20 == null) goto L18;
        nh0.a r110 = new nh0.a(r20.get("x").getAsInt(), r20.get("y").getAsInt(), r20.get("w").getAsInt(), r20.get("h").getAsInt());     // Catch: Exception -> L28
    L19:
        JsonElement r21 = r16.get("uid");     // Catch: Exception -> L28
        if (r21 == null) goto L22;
        String r111 = r21.getAsString();     // Catch: Exception -> L28
    L23:
        nh0.b r22 = new nh0.b(r13, r14, r18, r110, r111);     // Catch: Exception -> L28
    L25:
        r4 = r22;
        goto L31
    L22:
        r111 = null;
        goto L23
    L18:
        r110 = null;
        goto L19
    L15:
        r20 = null;
        goto L16
    L24:
        r22 = new nh0.b(r13, r14, "", null, null);     // Catch: Exception -> L28
        goto L25
    L27:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");     // Catch: Exception -> L28
    L28:
        e = move-exception;
        ALogger.e("MultiLinkDynamicWidget", "parseToAnimExtraObject: " + r3, e);
        goto L30
    L177:
        return;
    L63:
        nh0.o r23 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.f.b(r17.d);
        if (r23 == null) goto L180;
        ALogger.i("MultiLinkDynamicWidget-Time", "start load stage card loadTime=" + r23.g);
        String r24 = r23.b;
        int r25 = f.d[r23.getType().ordinal()];
        if (r25 == 1) goto L93;
        if (r25 == 2) goto L72;
        if (r25 != 3) goto L181;
        g(r24);
        return;
    L181:
        return;
    L72:
        h r26 = (h) ((LinkedHashMap) this.b).get(r24);
        if (r26 == null) goto L171;
        ih0.c r27 = r26.a;
        if (r27 == null) goto L182;
        nh0.n r28 = r23.f;
        if (r28 == null) goto L183;
        View r29 = r27.S0();
        if (r29 == null) goto L83;
        ViewGroup.LayoutParams r30 = r29.getLayoutParams();
    L85:
        if ((r30 instanceof FrameLayout.LayoutParams) == true) goto L87;
        r30 = null;
    L87:
        FrameLayout.LayoutParams r31 = (FrameLayout.LayoutParams) r30;
        if (r31 == null) goto L184;
        r31.topMargin = s1.f(r28.b);
        r31.leftMargin = s1.f(r28.a);
        View r32 = r27.S0();
        if (r32 == null) goto L172;
        r32.setLayoutParams(r31);
        return;
    L172:
        return;
    L184:
        return;
    L83:
        r30 = null;
        goto L85
    L183:
        return;
    L182:
        return;
    L171:
        return;
    L93:
        h r33 = (h) ((LinkedHashMap) this.b).get(r24);
        if (r33 != null) goto L96;
    L99:
        h r34 = new h(this.d, r23.c, r23.d, r23.h, this.g, new g(this, r23, r24));
        this.b.put(r24, r34);
        ih0.c r35 = r34.a(this.k);
        if (r35 == null) goto L186;
        this.e.fa(r35);
        nh0.n r36 = r23.f;
        if (r36 == null) goto L187;
        int r37 = f.c[r23.e.ordinal()];
        if (r37 == 1) goto L112;
        if (r37 == 2) goto L111;
        if (r37 == 3) goto L110;
        FrameLayout r38 = null;
    L113:
        if (r38 == null) goto L154;
        UtilityKotlinExtentionsKt.w(r38);
        FrameLayout.LayoutParams r39 = new FrameLayout.LayoutParams(s1.f(r36.c), s1.f(r36.d));
        r39.topMargin = s1.f(r36.b);
        r39.leftMargin = s1.f(r36.a);
        View r40 = r35.S0();
        if (r40 == null) goto L117;
        r40.setLayoutParams(r39);
    L117:
        r38.addView(r35.S0());
        if (je0.d.r() == true) goto L136;
        if (Intrinsics.areEqual(this.g, "team_fight") == false) goto L136;
        if (Intrinsics.areEqual(r23.b, "teamfight_foreground") == false) goto L136;
        com.bytedance.android.livesdk.chatroom.u r41 = com.bytedance.android.live.liveinteract.api.utils.m.h(this.k, null, 2);
        if (r41 == null) goto L128;
        com.bytedance.live.datacontext.n r42 = r41.x();
        if (r42 == null) goto L128;
        Object r43 = r42.getValue();
    L130:
        if ((r43 instanceof MultiSceneEnterRoomStatisticsUtils) == true) goto L132;
        r43 = null;
    L132:
        MultiSceneEnterRoomStatisticsUtils r44 = (MultiSceneEnterRoomStatisticsUtils) r43;
        if (r44 == null) goto L136;
        int r45 = MultiSceneEnterRoomStatisticsUtils.u;
        r44.j(null);
    L128:
        r43 = null;
    L136:
        if (je0.d.r() == true) goto L154;
        if (Intrinsics.areEqual(this.g, "room_battle") == false) goto L154;
        if (Intrinsics.areEqual(r23.b, "teamfight_foreground") == false) goto L154;
        com.bytedance.android.livesdk.chatroom.u r46 = com.bytedance.android.live.liveinteract.api.utils.m.h(this.k, null, 2);
        if (r46 == null) goto L146;
        com.bytedance.live.datacontext.n r47 = r46.x();
        if (r47 == null) goto L146;
        Object r48 = r47.getValue();
    L148:
        if ((r48 instanceof MultiSceneEnterRoomStatisticsUtils) == true) goto L150;
        r48 = null;
    L150:
        MultiSceneEnterRoomStatisticsUtils r49 = (MultiSceneEnterRoomStatisticsUtils) r48;
        if (r49 == null) goto L154;
        int r50 = MultiSceneEnterRoomStatisticsUtils.u;
        r49.j(null);
    L146:
        r48 = null;
    L154:
        if (r23.i == false) goto L174;
        IInteractService r51 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r51 == null) goto L175;
        ih0.b r52 = r51.dynamicService(this.k);
        if (r52 == null) goto L176;
        r52.Gb(r23.b, r35);
        return;
    L176:
        return;
    L175:
        return;
    L174:
        return;
    L110:
        r38 = d();
        goto L113
    L111:
        r38 = e();
        goto L113
    L112:
        r38 = c();
        goto L113
    L187:
        return;
    L186:
        return;
    L96:
        if (Intrinsics.areEqual(r33.d, r23.d) == true) goto L185;
        r33.b();
        h r53 = this.b.remove(r24);
        goto L99
    L185:
        return;
    }

    public static final void b(e r6, nh0.o r7, int r8) {
        r6.getClass();
        JsonObject r0 = new JsonObject();
        r0.addProperty("item_id", r7.b);
        r0.addProperty("status", Integer.valueOf(r8));
        ih0.b r1 = ((IInteractService) jc1.k.n(IInteractService.class)).dynamicService(r6.k);
        if (r1 == null) goto L6;
        r1.Dk(r6.g, "layer_element_result", r0, false);
    L6:
        if (je0.d.r() == true) goto L25;
        if (Intrinsics.areEqual(r6.g, "team_fight") == false) goto L25;
        if (Intrinsics.areEqual(r7.b, "teamfight_foreground") == false) goto L25;
        if (r8 != 1) goto L25;
        com.bytedance.android.livesdk.chatroom.u r2 = com.bytedance.android.live.liveinteract.api.utils.m.h(r6.k, null, 2);
        if (r2 == null) goto L17;
        com.bytedance.live.datacontext.n r3 = r2.x();
        if (r3 == null) goto L17;
        Object r4 = r3.getValue();
    L19:
        if ((r4 instanceof MultiSceneEnterRoomStatisticsUtils) == true) goto L21;
        r4 = null;
    L21:
        MultiSceneEnterRoomStatisticsUtils r5 = (MultiSceneEnterRoomStatisticsUtils) r4;
        if (r5 == null) goto L25;
        int r9 = MultiSceneEnterRoomStatisticsUtils.u;
        r5.i(null);
    L17:
        r4 = null;
    L25:
        if (je0.d.r() == false) goto L27;
        return;
    L27:
        if (Intrinsics.areEqual(r6.g, "room_battle") == true) goto L29;
        return;
    L29:
        if (Intrinsics.areEqual(r7.b, "teamfight_foreground") == false) goto L46;
        if (r8 != 1) goto L47;
        com.bytedance.android.livesdk.chatroom.u r10 = com.bytedance.android.live.liveinteract.api.utils.m.h(r6.k, null, 2);
        if (r10 == null) goto L36;
        com.bytedance.live.datacontext.n r11 = r10.x();
        if (r11 == null) goto L36;
        Object r12 = r11.getValue();
    L38:
        if ((r12 instanceof MultiSceneEnterRoomStatisticsUtils) == true) goto L40;
        r12 = null;
    L40:
        MultiSceneEnterRoomStatisticsUtils r13 = (MultiSceneEnterRoomStatisticsUtils) r12;
        if (r13 == null) goto L48;
        int r14 = MultiSceneEnterRoomStatisticsUtils.u;
        r13.i(null);
        return;
    L48:
        return;
    L36:
        r12 = null;
        goto L38
    L47:
        return;
    }

    public e(Context r2, ih0.b r3, ViewGroup r4, String r5, IRoom r6, boolean r7, String r8, DataCenter r9) {
        Intrinsics.checkNotNullParameter(r2, "mContext");
        Intrinsics.checkNotNullParameter(r3, "service");
        Intrinsics.checkNotNullParameter(r4, "mLinkRootView");
        Intrinsics.checkNotNullParameter(r5, "mBizId");
        Intrinsics.checkNotNullParameter(r6, "mRoom");
        this.d = r2;
        this.e = r3;
        this.f = r4;
        this.g = r5;
        this.h = r6;
        this.i = r7;
        this.j = r8;
        this.k = r9;
        this.a = new JsonObject();
        this.b = new LinkedHashMap();
    }
}
