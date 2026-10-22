package com.bytedance.android.live.revlink.link.domain.streammix;

import android.graphics.RectF;
import com.bytedance.android.live.revlink.impl.multianchor.utils.v;
import com.bytedance.android.live.revlink.impl.region.RevLinkWindowRegionContext;
import com.bytedance.android.live.revlink.impl.utils.u;
import com.bytedance.android.live.revlink.link.core.service.AnchorUILayoutManager;
import com.bytedance.android.live.revlink.link.core.service.o;
import com.bytedance.android.live.revlink.link.domain.service.RevLinkDomainAnchorService;
import com.bytedance.android.live.revlink.link.streaminteract.biz.StreamMixDescriptor;
import com.bytedance.android.livesdk.revenue.service.livecore.IConfig;
import com.bytedance.android.livesdk.revenue.service.livecore.IRegion;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKtKt;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomSpecificSceneTypeInfo;
import com.bytedance.android.livesdkapi.depend.model.live.IStreamUrlExtraKt;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.live.datacontext.j;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import gr2.k;
import gr2.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.ExceptionsKt;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class i implements b, com.bytedance.android.live.revlink.link.biz.service.a {
    public long a;
    public List<com.bytedance.android.live.revlink.link.domain.service.d> b;
    public List<m11.b> c;
    public String d;
    public boolean e;
    public final com.bytedance.android.live.revlink.link.infra.lifecontrol.context.a f;
    public final AnchorUILayoutManager g;
    public final RevLinkDomainAnchorService h;
    public final com.bytedance.android.livesdk.revenue.service.room.c i;
    public final IConfig.e j;

    @Override // com.bytedance.android.live.revlink.link.domain.streammix.b
    public final void T(IRegion r2) {
        Intrinsics.checkNotNullParameter(r2, "region");
    }

    @Override // com.bytedance.android.live.revlink.link.domain.streammix.b
    public final void U(IRegion r2) {
        Intrinsics.checkNotNullParameter(r2, "region");
    }

    @Override // com.bytedance.android.live.revlink.link.domain.streammix.b
    public final boolean V(IRegion r2) {
        Intrinsics.checkNotNullParameter(r2, "region");
        return true;
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.a, com.bytedance.android.live.revlink.link.biz.service.j
    public /* bridge */ /* synthetic */ com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d getContext() {
        return getContext();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.k
    public final com.bytedance.android.live.revlink.impl.global.c getLinkInstanceService() {
        return getContext();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.a, com.bytedance.android.live.revlink.link.biz.service.j
    public com.bytedance.android.live.revlink.link.infra.lifecontrol.context.a getContext() {
        return this.f;
    }

    @Override // com.bytedance.android.live.revlink.link.domain.streammix.b
    public final void W(IRegion r2) {
        Intrinsics.checkNotNullParameter(r2, "region");
        o51.e r3 = (o51.e) getContext().getUiLayout().getValue();
        if (r3 != null) goto L5;
        return;
    L5:
        boolean r4 = r3 instanceof o51.e.c;
        com.bytedance.android.live.revlink.link.biz.service.i.d0(this).getClass();
    }

    public final JSONArray a(List<m11.b> r6) {
        JSONArray r0 = new JSONArray();
        Iterator<T> r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        m11.b r1 = (m11.b) r7.next();
        JSONObject r2 = new JSONObject();
        r2.put("id", r1.c());
        r2.put("talking", r1.e());
        r2.put("silence_status", r1.d());
        r2.put("belong_user_id", r1.b());
        r0.put(r2);
        goto L4
    L6:
        return r0;
    }

    public final void b(JSONObject r26) {
        o51.e r2 = this.g.e;
        if ((r2 instanceof o51.e.C0283e) == true) goto L5;
        return;
    L5:
        if (((o51.e.C0283e) r2).e == false) goto L41;
        JSONObject r8 = JSONObjectProtectorUtils.getJSONObject(r26, "anchor_interact_info");
        r8.put("layout_type", 2);
        r8.put("is_horizontal", 1);
        r26.put("anchor_interact_info", r8);
        JSONObject r7 = new JSONObject();
        JSONObject r9 = new JSONObject();
        Pair<Integer, Integer> r10 = u.f();
        if (r10 != null) goto L9;
        r10 = new Pair(0, 0);
    L9:
        int r14 = ((Number) r10.getFirst()).intValue();
        int r15 = ((Number) r10.getSecond()).intValue();
        if (u.f() != null) goto L12;
        String r18 = "canvas";
        double r1 = com.bytedance.android.live.revlink.impl.settings.live.b.p.c();
    L20:
        double r12 = ((((double) 13) * r1) * ((Number) r10.getFirst()).doubleValue()) / ((double) (((Number) r10.getSecond()).intValue() * 9));
        double r3 = 1;
        double r13 = r3 - r1;
        double r23 = r1;
        double r0 = ((((Number) r10.getFirst()).doubleValue() * r13) * ((double) r15)) / ((double) (r14 * ((Number) r10.getSecond()).intValue()));
        r7.put("x", 0);     // Catch: Exception -> L35
        double r4 = 2;
        r7.put("y", (r3 - r0) / r4);     // Catch: Exception -> L35
        r7.put("w", r13);     // Catch: Exception -> L35
        r7.put("h", r0);     // Catch: Exception -> L35
        r9.put("x", r13);     // Catch: Exception -> L35
        r9.put("y", (r3 - r12) / r4);     // Catch: Exception -> L35
        r9.put("w", r23);     // Catch: Exception -> L35
        r9.put("h", r12);     // Catch: Exception -> L35
        r26.put("game_clip", r7);     // Catch: Exception -> L35
        r26.put("camera_clip", r9);     // Catch: Exception -> L35
        String r5 = r18;
        JSONObject r6 = JSONObjectProtectorUtils.getJSONObject(r26, r5);     // Catch: Exception -> L35
        Pair<Integer, Integer> r16 = u.f();     // Catch: Exception -> L35
        if (r16 == null) goto L26;
        Integer r17 = (Integer) r16.getSecond();     // Catch: Exception -> L35
        if (r17 == null) goto L26;
        int r19 = r17.intValue();     // Catch: Exception -> L35
    L27:
        r6.put("height", r19);     // Catch: Exception -> L35
        Pair<Integer, Integer> r20 = u.f();     // Catch: Exception -> L35
        if (r20 == null) goto L32;
        Integer r22 = (Integer) r20.getFirst();     // Catch: Exception -> L35
        if (r22 == null) goto L32;
        int r110 = r22.intValue();     // Catch: Exception -> L35
    L33:
        r6.put("width", r110);     // Catch: Exception -> L35
        r26.put(r5, r6);     // Catch: Exception -> L35
        return;
    L32:
        r110 = 0;
    L26:
        r19 = 0;
    L35:
        e = move-exception;
        jy0.b.c("MultiAnchorStreamMixer", e.toString(), null, 4);
        return;
    L12:
        Pair<Integer, Integer> r111 = u.f();
        if (r111 != null) goto L15;
        r111 = new Pair(0, 0);
    L15:
        r18 = "canvas";
        double r112 = ((double) ((Number) r111.getSecond()).intValue()) / ((double) ((Number) r111.getFirst()).intValue());
        r1 = r112 / (1.7777777777777777d + r112);
        com.bytedance.android.live.revlink.impl.settings.live.b r113 = com.bytedance.android.live.revlink.impl.settings.live.b.p;
        r113.getClass();
        if (((Boolean) com.bytedance.android.live.revlink.impl.settings.live.b.n.getValue(r113, com.bytedance.android.live.revlink.impl.settings.live.b.a[12])).booleanValue() == true) goto L18;
    L19:
        r1 = r113.c();
        goto L20
    L18:
        if (r1 <= 1) goto L20;
    }

    @Override // com.bytedance.android.live.revlink.link.domain.streammix.b
    public final boolean S(m r1, k r2) {
        o51.e r3 = (o51.e) getContext().getUiLayout().getValue();
        if (r3 != null) goto L5;
        return false;
    L5:
        boolean r4 = r3 instanceof o51.e.c;
        com.bytedance.android.live.revlink.link.biz.service.i.d0(this).getClass();
        return false;
    }

    public i(com.bytedance.android.live.revlink.link.infra.lifecontrol.context.g r2, AnchorUILayoutManager r3, RevLinkDomainAnchorService r4, com.bytedance.android.livesdk.revenue.service.room.c r5, IConfig.e r6) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "uiLayoutManager");
        Intrinsics.checkNotNullParameter(r4, "domainService");
        this.f = r2;
        this.g = r3;
        this.h = r4;
        this.i = r5;
        this.j = r6;
        this.b = CollectionsKt.emptyList();
        this.c = new ArrayList();
        this.e = true;
    }

    @Override // com.bytedance.android.live.revlink.link.domain.streammix.b
    public final String X(List r20, Map r22, StreamMixDescriptor r23, k41.b r24, d r25) {
        Intrinsics.checkNotNullParameter(r20, "regions");
        Intrinsics.checkNotNullParameter(r22, "seiRegionMap");
        Intrinsics.checkNotNullParameter(r23, "descriptor");
        Intrinsics.checkNotNullParameter(r24, "mixStrategy");
        ArrayList r1 = new ArrayList(r22.size());
        Iterator r3 = ((LinkedHashMap) r22).entrySet().iterator();
    L4:
        if (r3.hasNext() == false) goto L13;
        Map.Entry r4 = (Map.Entry) r3.next();
        String r5 = (String) r4.getKey();
        t51.b r6 = (t51.b) r4.getValue();
        Iterator r12 = r20.iterator();
    L7:
        if (r12.hasNext() == false) goto L11;
        Object r13 = r12.next();
        if (Intrinsics.areEqual(((IRegion) r13).getInteractId(), (String) r4.getKey()) == false) goto L7;
        Object r14 = r13;
    L12:
        r1.add(new com.bytedance.android.live.revlink.link.domain.service.d(r5, r6, (IRegion) r14));
        goto L4
    L11:
        r14 = null;
        goto L12
    L13:
        ArrayList r2 = new ArrayList(r1);
        CollectionsKt.sortWith(r2, h.a);
        Iterator r7 = r2.iterator();
    L15:
        if (r7.hasNext() == false) goto L19;
        Object r8 = r7.next();
        if (Intrinsics.areEqual(getContext().Zl(), ((com.bytedance.android.live.revlink.link.domain.service.d) r8).a) == false) goto L15;
    L20:
        com.bytedance.android.live.revlink.link.domain.service.d r9 = (com.bytedance.android.live.revlink.link.domain.service.d) r8;
        if (r9 == null) goto L23;
        r2.remove(r9);
        ListProtector.add(r2, 0, r9);
    L23:
        List<com.bytedance.android.live.revlink.link.domain.service.d> r10 = CollectionsKt.toList(r2);
        o51.e r15 = this.g.e;
        JSONObject r16 = new JSONObject();
        String r17 = o51.g.b(r15);
        if (r17 == null) goto L29;
        s51.c r18 = this.h.d(r17, r17);
        if (r18 == null) goto L29;
        String r19 = r18.f();
        if (r19 == null) goto L29;
    L30:
        r16.put("focus_id", r19);
        r16.put("layout_type", r15.a.b);
        r16.put("ui_layout", r15.a.d);
        r16.put("ui_layout_kmp", r15.a.c);
        Iterator<com.bytedance.android.live.revlink.link.domain.service.d> r26 = r10.iterator();
        int r27 = 0;
    L32:
        if (r26.hasNext() == false) goto L37;
        if (Intrinsics.areEqual(r26.next().a, getContext().Zl()) == true) goto L38;
        r27 = r27 + 1;
    L38:
        r16.put("owner_index", RangesKt.coerceAtLeast(r27, 0));
        g.a(r25, r16);
        JSONObject r28 = new JSONObject();     // Catch: JSONException -> L156
        r28.put("ver", 6);     // Catch: JSONException -> L156
        r28.put(Constants.OperatorKey.KEY_VENDOR, IConfig.IVendor.BYTE.getName());     // Catch: JSONException -> L156
        r28.put("anchor_interact_info", r16);     // Catch: JSONException -> L156
        RevLinkWindowRegionContext r29 = getContext().P8();     // Catch: JSONException -> L156
        if (r29 == null) goto L44;
        j<com.bytedance.android.live.revlink.impl.multianchor.service.g> r30 = r29.getPartnerService();     // Catch: JSONException -> L156
        if (r30 == null) goto L44;
        com.bytedance.android.live.revlink.impl.multianchor.service.g r32 = (com.bytedance.android.live.revlink.impl.multianchor.service.g) r30.getValue();     // Catch: JSONException -> L156
    L45:
        if (r32 == null) goto L47;
        String r33 = r32.mo696c();     // Catch: JSONException -> L156
    L48:
        if (r33 != null) goto L50;
    L53:
        boolean r34 = true;
    L54:
        if (r34 == true) goto L56;
        r28.put("layout_key", r33);     // Catch: JSONException -> L156
    L56:
        List<m11.b> r35 = (List) getContext().getLinkDataSet().q2().getValue();     // Catch: JSONException -> L156
        if (r35 != null) goto L59;
        r35 = new ArrayList();     // Catch: JSONException -> L156
    L59:
        JSONArray r36 = a(r35);     // Catch: JSONException -> L156
        if (r36.length() <= 0) goto L64;
        r28.put("ai_user_infos", r36);     // Catch: JSONException -> L156
    L64:
        if (this.a == 0) goto L102;
        List<com.bytedance.android.live.revlink.link.domain.service.d> r37 = this.b;     // Catch: JSONException -> L156
        if (r10.size() != r37.size()) goto L72;
        int r38 = r10.size();     // Catch: JSONException -> L156
        int r110 = 0;
    L69:
        if (r110 >= r38) goto L74;
        if (c.a(((com.bytedance.android.live.revlink.link.domain.service.d) ListProtector.get(r10, r110)).c, ((com.bytedance.android.live.revlink.link.domain.service.d) ListProtector.get(r37, r110)).c) == false) goto L72;
        r110 = r110 + 1;     // Catch: JSONException -> L156
        goto L69
    L74:
        boolean r39 = true;
    L75:
        if (r39 == false) goto L102;
        List<m11.b> r40 = this.c;     // Catch: JSONException -> L156
        if (r35.isEmpty() == true) goto L96;
        List<m11.b> r42 = r40;     // Catch: JSONException -> L156
        if (r42 != null) goto L81;
    L84:
        boolean r43 = true;
    L85:
        if (r43 == true) goto L96;
        if (r35.size() != r40.size()) goto L96;
        int r44 = r35.size();     // Catch: JSONException -> L156
        int r111 = 0;
    L90:
        if (r111 >= r44) goto L95;
        if (c.b((m11.b) ListProtector.get(r35, r111), (m11.b) ListProtector.get(r40, r111)) == false) goto L96;
        r111 = r111 + 1;     // Catch: JSONException -> L156
        goto L90
    L95:
        boolean r45 = true;
    L97:
        if (r45 == false) goto L102;
        if ((!Intrinsics.areEqual(this.d, r33)) == true) goto L102;
        r28.put("timestamp", this.a);     // Catch: JSONException -> L156
    L103:
        this.b = r10;     // Catch: JSONException -> L156
        this.d = r33;     // Catch: JSONException -> L156
        List<m11.b> r46 = r35;     // Catch: JSONException -> L156
        ArrayList r47 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r46, 10));     // Catch: JSONException -> L156
        Iterator r48 = r46.iterator();     // Catch: JSONException -> L156
    L105:
        if (r48.hasNext() == false) goto L107;
        r47.add(m11.b.a((m11.b) r48.next()));     // Catch: JSONException -> L156
        goto L105
    L107:
        this.c = CollectionsKt.toMutableList(r47);     // Catch: JSONException -> L156
        r28.put("channel_id", String.valueOf(getContext().G()));     // Catch: JSONException -> L156
        JSONArray r112 = new JSONArray();     // Catch: JSONException -> L156
        Iterator<T> r113 = r10.iterator();     // Catch: JSONException -> L156
    L109:
        if (r113.hasNext() == false) goto L111;
        c(r22, (com.bytedance.android.live.revlink.link.domain.service.d) r113.next(), r23, r24, r112);     // Catch: JSONException -> L156
        r28 = r28;
        goto L109
    L111:
        JSONObject r114 = r28;
        r114.put("grids", r112);     // Catch: JSONException -> L156
        r114.put("mix_grids", r25.a);     // Catch: JSONException -> L156
        JSONObject r0 = new JSONObject();     // Catch: JSONException -> L156
        com.bytedance.android.livesdk.revenue.service.room.c r49 = this.i;     // Catch: JSONException -> L156
        if (r49 == null) goto L119;
        com.bytedance.android.livesdk.revenue.room.a r50 = r49.getRoomContext();     // Catch: JSONException -> L156
        if (r50 == null) goto L119;
        IRoomBase r52 = r50.getCommonRoom();     // Catch: JSONException -> L156
        if (r52 == null) goto L119;
        IRoom r53 = (IRoom) r52;     // Catch: JSONException -> L156
    L121:
        if (r53 == null) goto L139;
        long r54 = IStreamUrlExtraKt.getHeightFlex(IRoomKtKt.getStreamUrlExtraSafely(r53));     // Catch: JSONException -> L156
        r0.put("height", IStreamUrlExtraKt.getHeightFlex(IRoomKtKt.getStreamUrlExtraSafely(r53)));     // Catch: JSONException -> L156
        IRoomSpecificSceneTypeInfo r55 = r53.getSceneTypeInfo();     // Catch: JSONException -> L156
        if (r55 != null) goto L125;
    L126:
        com.bytedance.android.live.revlink.impl.settings.live.a r56 = com.bytedance.android.live.revlink.impl.settings.live.a.j;     // Catch: JSONException -> L156
        r56.getClass();     // Catch: JSONException -> L156
        if (((Boolean) com.bytedance.android.live.revlink.impl.settings.live.a.g.getValue(r56, com.bytedance.android.live.revlink.impl.settings.live.a.a[5])).booleanValue() == false) goto L129;
        boolean r57 = true;
    L130:
        if (r57 == false) goto L138;
        com.bytedance.android.live.revlink.impl.settings.live.a r58 = com.bytedance.android.live.revlink.impl.settings.live.a.j;     // Catch: JSONException -> L156
        r58.getClass();     // Catch: JSONException -> L156
        ReadOnlyProperty r59 = com.bytedance.android.live.revlink.impl.settings.live.a.f;     // Catch: JSONException -> L156
        KProperty[] r60 = com.bytedance.android.live.revlink.impl.settings.live.a.a;     // Catch: JSONException -> L156
        if (((HashMap) r59.getValue(r58, r60[4])).containsKey(String.valueOf(r54)) == false) goto L138;
        String r62 = (String) ((HashMap) r59.getValue(r58, r60[4])).get(String.valueOf(r54));     // Catch: JSONException -> L156
        if (r62 == null) goto L136;
        Integer r63 = StringsKt.toIntOrNull(r62);     // Catch: JSONException -> L156
    L137:
        r0.put("width", r63);     // Catch: JSONException -> L156
    L140:
        if (r53 == null) goto L142;
        LiveMode r64 = IRoomKtKt.getStreamType(r53);     // Catch: JSONException -> L156
    L144:
        if (r64 != LiveMode.SCREEN_RECORD) goto L154;
        Pair<Integer, Integer> r65 = u.f();     // Catch: JSONException -> L156
        if (r65 == null) goto L148;
        Integer r66 = (Integer) r65.getSecond();     // Catch: JSONException -> L156
    L149:
        r0.put("height", r66);     // Catch: JSONException -> L156
        Pair<Integer, Integer> r67 = u.f();     // Catch: JSONException -> L156
        if (r67 == null) goto L152;
        Integer r68 = (Integer) r67.getFirst();     // Catch: JSONException -> L156
    L153:
        r0.put("width", r68);     // Catch: JSONException -> L156
        goto L154
    L152:
        r68 = null;
        goto L153
    L148:
        r66 = null;
    L154:
        r0.put("background", "#000000");     // Catch: JSONException -> L156
        r114.put("canvas", r0);     // Catch: JSONException -> L156
        b(r114);     // Catch: JSONException -> L156
        JSONObject r69 = r114;
        com.bytedance.android.live.revlink.impl.multianchor.service.g r70 = null;
    L162:
        String r72 = String.valueOf(r69);
        RevLinkWindowRegionContext r73 = getContext().P8();
        if (r73 == null) goto L167;
        j<com.bytedance.android.live.revlink.impl.multianchor.service.g> r74 = r73.getPartnerService();
        if (r74 == null) goto L167;
        com.bytedance.android.live.revlink.impl.multianchor.service.g r75 = (com.bytedance.android.live.revlink.impl.multianchor.service.g) r74.getValue();
    L168:
        if (r75 == null) goto L170;
        String r115 = r75.mo696c();
    L171:
        if (r115 != null) goto L173;
    L176:
        boolean r76 = true;
    L177:
        if (r76 == true) goto L182;
        this.e = false;
        if (r75 == null) goto L186;
        r75.m(getContext().Ab(), r72);
    L186:
        return r72;
    L182:
        if (this.e == true) goto L186;
        this.e = true;
        if (r75 == null) goto L186;
        r75.m(getContext().Ab(), "");
        goto L186
    L173:
        if (r115.length() == 0) goto L176;
        r76 = false;
        goto L177
    L170:
        r115 = r70;
    L167:
        r75 = r70;
        goto L168
    L142:
        r64 = null;
        goto L144
    L136:
        r63 = null;
    L138:
        r0.put("width", IStreamUrlExtraKt.getWidthFlex(IRoomKtKt.getStreamUrlExtraSafely(r53)));     // Catch: JSONException -> L156
    L129:
        r57 = false;
        goto L130
    L125:
        if (r55.isLandscapeVerticalRoom() == 1) goto L129;
    L139:
        r0.put("width", 720);     // Catch: JSONException -> L156
        r0.put("height", 1280);     // Catch: JSONException -> L156
    L119:
        r53 = null;
        goto L121
    L81:
        if (r42.isEmpty() == true) goto L84;
        r43 = false;
    L96:
        r45 = false;
    L72:
        r39 = false;
    L102:
        i97.a r77 = i97.a.a;     // Catch: JSONException -> L156
        long r78 = System.currentTimeMillis();     // Catch: JSONException -> L156
        this.a = r78;     // Catch: JSONException -> L156
        r28.put("timestamp", r78);     // Catch: JSONException -> L156
        goto L103
    L50:
        if (r33.length() == 0) goto L53;
        r34 = false;
        goto L54
    L47:
        r33 = null;
    L44:
        r32 = null;
    L156:
        e = move-exception;
        r70 = null;
        jy0.b.c("NormalStreamMixStrategy", "createSei crashed with " + ExceptionsKt.stackTraceToString(e), null, 4);
        v r79 = getContext().getMultiLinkMonitor();
        r79.getClass();
        Intrinsics.checkNotNullParameter(e, "e");
        i97.a r80 = i97.a.a;
        if ((System.currentTimeMillis() - r79.g) < 10000) goto L161;
        r79.g = System.currentTimeMillis();
        Map<String, Object> r82 = new LinkedHashMap();
        r82.put("exception", e.toString());
        r79.H("anchor_link_create_sei_exception", r82);
    L161:
        r69 = null;
        goto L162
    L37:
        r27 = -1;
    L29:
        r19 = "";
        goto L30
    L19:
        r8 = null;
        goto L20
    }

    public final void c(Map r12, com.bytedance.android.live.revlink.link.domain.service.d r13, StreamMixDescriptor r14, k41.b r15, JSONArray r16) {
        t51.b r17 = (t51.b) ((LinkedHashMap) r12).get(r13.a);
        if (r17 == null) goto L36;
        RectF r18 = o51.a.c(r17);
        if ((this.g.e instanceof o51.e.C0283e) == true) goto L8;
        float r1 = r18.left;
        float r2 = r14.c;
        float r3 = r18.top;
        float r19 = r14.b;
        r18 = r15.a(new RectF(r1 - r2, (r3 - r19) / 0.5625f, r18.right - r2, (r18.bottom - r19) / 0.5625f));
    L8:
        IRegion r110 = r13.c;
        if (r110 == null) goto L37;
        JSONObject r111 = new JSONObject();
        r111.put("type", r110.getMediaType().toSeiFormat());
        r111.put("alpha", 1);
        r111.put("w", CastDoubleProtector.parseDouble(com.bytedance.android.live.revlink.impl.rtc.b.a(r18.width())));
        r111.put("h", CastDoubleProtector.parseDouble(com.bytedance.android.live.revlink.impl.rtc.b.a(r18.height())));
        r111.put("x", CastDoubleProtector.parseDouble(com.bytedance.android.live.revlink.impl.rtc.b.a(r18.left)));
        r111.put("y", CastDoubleProtector.parseDouble(com.bytedance.android.live.revlink.impl.rtc.b.a(r18.top)));
        com.bytedance.android.live.revlink.impl.settings.live.c r112 = com.bytedance.android.live.revlink.impl.settings.live.c.D;
        r112.getClass();
        ReadOnlyProperty r4 = com.bytedance.android.live.revlink.impl.settings.live.c.C;
        KProperty[] r5 = com.bytedance.android.live.revlink.impl.settings.live.c.a;
        int r6 = 0;
        if (((Boolean) r4.getValue(r112, r5[27])).booleanValue() == false) goto L27;
        RevLinkDomainAnchorService r7 = this.h;
        s51.c r8 = RevLinkDomainAnchorService.f(this.h, null, r110.getInteractId(), 1);
        if (r8 == null) goto L17;
        String r9 = r8.d;
        if (r9 == null) goto L17;
    L18:
        r7.getClass();
        Intrinsics.checkNotNullParameter(r9, "uid");
        o r10 = (o) r7.n.b.getValue();
        if (r10 == null) goto L25;
        Map<String, com.bytedance.android.livesdk.link.model.bridge.g> r20 = r10.a;
        if (r20 == null) goto L25;
        com.bytedance.android.livesdk.link.model.bridge.g r22 = r20.get(r9);
        if (r22 == null) goto L25;
        int r23 = (int) r22.getPosition();
    L26:
        r111.put("p", r23 - 1);
    L25:
        r23 = 0;
    L17:
        r9 = "";
    L27:
        jy0.b.c("xuzr_region_check", "linkerID: " + r110.getInteractId() + " hashCode: " + r110.hashCode() + " region: {x: " + r110.getX() + ", y: " + r110.getY() + ", w: " + r110.getWidth() + ", h: " + r110.getHeight() + "}, sei: {x: " + r18.left + ", y: " + r18.top + ", w: " + r18.width() + ", h: " + r18.height() + '}', null, 4);
        if (((Boolean) com.bytedance.android.live.revlink.impl.settings.live.c.v.getValue(r112, r5[20])).booleanValue() == true) goto L30;
        r111.put("account", 0);
        r111.put("uid", 0);
    L30:
        r111.put("uid_str", r110.getInteractId());
        r111.put("zorder", 0);
        r111.put("stat", r110.getStatus().toSeiFormat());
        if (r110.z4() == false) goto L34;
        r6 = 2;
    L34:
        r111.put("talk", r6);
        r111.put("talk_volume", r110.M4());
        r111.put("mute_audio", r110.C1() ? 1 : 0);
        r16.put(r111);
        return;
    L37:
        return;
    }
}
