package com.bytedance.android.live.revlink.link.domain.streammix;

import android.graphics.RectF;
import com.bytedance.android.live.revlink.impl.pk.service.IPKLinkBizDataService;
import com.bytedance.android.live.revlink.impl.region.RevLinkWindowRegionContext;
import com.bytedance.android.live.revlink.link.core.service.AnchorUILayoutManager;
import com.bytedance.android.live.revlink.link.domain.service.RevLinkDomainAnchorService;
import com.bytedance.android.live.revlink.link.streaminteract.biz.StreamMixDescriptor;
import com.bytedance.android.livesdk.revenue.service.livecore.IConfig;
import com.bytedance.android.livesdk.revenue.service.livecore.IRegion;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKtKt;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomSpecificSceneTypeInfo;
import com.bytedance.android.livesdkapi.depend.model.live.IStreamUrlExtraKt;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.live.datacontext.j;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import gr2.k;
import gr2.m;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.properties.ReadOnlyProperty;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements b, com.bytedance.android.live.revlink.link.biz.service.a {
    public long a;
    public List<? extends IRegion> b;
    public String c;
    public List<m11.b> d;
    public final com.bytedance.android.live.revlink.link.infra.lifecontrol.context.a e;
    public final com.bytedance.android.livesdk.revenue.service.room.c f;
    public final IConfig.e g;
    public final RevLinkDomainAnchorService h;
    public final AnchorUILayoutManager i;

    @Override // com.bytedance.android.live.revlink.link.domain.streammix.b
    public final void U(IRegion r2) {
        Intrinsics.checkNotNullParameter(r2, "region");
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
        return this.e;
    }

    @Override // com.bytedance.android.live.revlink.link.domain.streammix.b
    public final void T(IRegion r2) {
        Intrinsics.checkNotNullParameter(r2, "region");
        com.bytedance.android.live.revlink.link.biz.service.i.d0(this).getClass();
    }

    @Override // com.bytedance.android.live.revlink.link.domain.streammix.b
    public final boolean V(IRegion r2) {
        Intrinsics.checkNotNullParameter(r2, "region");
        return !Intrinsics.areEqual(r2.getInteractId(), getContext().Zl());
    }

    @Override // com.bytedance.android.live.revlink.link.domain.streammix.b
    public final void W(IRegion r2) {
        Intrinsics.checkNotNullParameter(r2, "region");
        o51.e r3 = (o51.e) getContext().getUiLayout().getValue();
        if (r3 != null) goto L5;
        return;
    L5:
        boolean r4 = r3 instanceof o51.e.i;
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

    @Override // com.bytedance.android.live.revlink.link.domain.streammix.b
    public final boolean S(m r1, k r2) {
        o51.e r3 = (o51.e) getContext().getUiLayout().getValue();
        if (r3 != null) goto L5;
        return false;
    L5:
        boolean r4 = r3 instanceof o51.e.i;
        com.bytedance.android.live.revlink.link.biz.service.i.d0(this).getClass();
        return false;
    }

    public final void b(List<? extends IRegion> r8, String r9, List<m11.b> r10) {
        if (this.a == 0) goto L47;
        List<? extends IRegion> r0 = this.b;
        boolean r2 = false;
        if (r0.isEmpty() == true) goto L19;
        ArrayList r1 = (ArrayList) r8;
        if (r1.isEmpty() == true) goto L19;
        if (r0.size() != r1.size()) goto L19;
        int r3 = r0.size();
        int r4 = 0;
    L13:
        if (r4 >= r3) goto L18;
        if (c.a((IRegion) ListProtector.get(r0, r4), (IRegion) ListProtector.get(r8, r4)) == false) goto L19;
        r4 = r4 + 1;
        goto L13
    L18:
        boolean r5 = true;
    L20:
        if (r5 == false) goto L47;
        List<m11.b> r6 = this.d;
        List<m11.b> r7 = r10;
        if (r7.isEmpty() == false) goto L24;
        boolean r12 = true;
    L25:
        if (r12 == true) goto L44;
        List<m11.b> r13 = r6;
        if (r13 != null) goto L29;
    L32:
        boolean r14 = true;
    L33:
        if (r14 == true) goto L44;
        if (r10.size() != r6.size()) goto L44;
        int r15 = r7.size();
        int r16 = 0;
    L38:
        if (r16 >= r15) goto L43;
        if (c.b((m11.b) ListProtector.get(r10, r16), (m11.b) ListProtector.get(r6, r16)) == false) goto L44;
        r16 = r16 + 1;
        goto L38
    L43:
        r2 = true;
        goto L44
    L29:
        if (r13.isEmpty() == true) goto L32;
        r14 = false;
    L44:
        if (r2 == false) goto L47;
        if ((!Intrinsics.areEqual(this.c, r9)) == true) goto L47;
    L48:
        this.b = r8;
        List<m11.b> r17 = r10;
        ArrayList r18 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r17, 10));
        Iterator<T> r19 = r17.iterator();
    L50:
        if (r19.hasNext() == false) goto L52;
        r18.add(m11.b.a((m11.b) r19.next()));
        goto L50
    L52:
        this.d = CollectionsKt.toMutableList(r18);
        this.c = r9;
        return;
    L24:
        r12 = false;
    L19:
        r5 = false;
    L47:
        i97.a r20 = i97.a.a;
        this.a = System.currentTimeMillis();
        goto L48
    }

    public final void c(IRegion r9, JSONArray r10, RectF r12, float r13) {
        if (r9.d2() == true) goto L5;
        return;
    L5:
        Intrinsics.checkNotNullParameter(r9, "region");
        RectF r14 = com.bytedance.android.live.revlink.impl.rtc.c.a(new RectF((float) r9.getX(), (float) r9.getY(), (float) (r9.getX() + r9.getWidth()), (float) (r9.getY() + r9.getHeight())), r12);
        JSONObject r0 = new JSONObject();
        r0.put("type", r9.getMediaType().toSeiFormat());
        int r2 = 1;
        r0.put("alpha", 1);
        r0.put("w", CastDoubleProtector.parseDouble(com.bytedance.android.live.revlink.impl.rtc.b.a(r14.width())));
        if (Intrinsics.areEqual(r9.getInteractId(), getContext().getPkLinkUtils().b()) == false) goto L8;
        r0.put("h", CastDoubleProtector.parseDouble(com.bytedance.android.live.revlink.impl.rtc.b.a(r13)));
    L9:
        r0.put("x", CastDoubleProtector.parseDouble(com.bytedance.android.live.revlink.impl.rtc.b.a(r14.left)));
        r0.put("y", CastDoubleProtector.parseDouble(com.bytedance.android.live.revlink.impl.rtc.b.a(r14.top)));
        r0.put("account", 0);
        r0.put("uid", 0);
        r0.put("uid_str", r9.getInteractId());
        r0.put("zorder", 0);
        r0.put("stat", r9.getStatus().toSeiFormat());
        Intrinsics.checkNotNullParameter(r9, "$this$talkField");
        if (r9.z4() == true) goto L12;
        int r15 = 0;
    L13:
        r0.put("talk", r15);
        r0.put("talk_volume", r9.M4());
        r0.put("mute_audio", r9.C1() ? 1 : 0);
        IPKLinkBizDataService r16 = getContext().mk();
        if (r16 == null) goto L20;
        IRoom r17 = r16.getGuestRoom();
        if (r17 == null) goto L20;
        if (r17.isLiveTypeAudio() != true) goto L20;
    L21:
        r0.put("is_audio", r2);
        r10.put(r0);
        return;
    L20:
        r2 = 0;
        goto L21
    L12:
        r15 = 2;
        goto L13
    L8:
        r0.put("h", CastDoubleProtector.parseDouble(com.bytedance.android.live.revlink.impl.rtc.b.a(r14.height())));
        goto L9
    }

    public a(com.bytedance.android.live.revlink.link.infra.lifecontrol.context.g r2, com.bytedance.android.livesdk.revenue.service.room.c r3, IConfig.e r4, RevLinkDomainAnchorService r5, AnchorUILayoutManager r6) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r5, "domainService");
        Intrinsics.checkNotNullParameter(r6, "uiLayoutManager");
        this.e = r2;
        this.f = r3;
        this.g = r4;
        this.h = r5;
        this.i = r6;
        this.b = new ArrayList();
        this.d = new ArrayList();
    }

    @Override // com.bytedance.android.live.revlink.link.domain.streammix.b
    public final String X(List r12, Map r13, StreamMixDescriptor r14, k41.b r15, d r16) {
        Intrinsics.checkNotNullParameter(r12, "regions");
        Intrinsics.checkNotNullParameter(r13, "seiRegionMap");
        Intrinsics.checkNotNullParameter(r14, "descriptor");
        Intrinsics.checkNotNullParameter(r15, "mixStrategy");
        ArrayList r0 = new ArrayList();
        Iterator r1 = r12.iterator();
    L3:
        boolean r3 = true;
        int r4 = 0;
        if (r1.hasNext() == false) goto L13;
        IRegion r2 = (IRegion) r1.next();
        if (Intrinsics.areEqual(r2.getInteractId(), getContext().getPkLinkUtils().b()) == true) goto L11;
        StringCompanionObject r5 = StringCompanionObject.INSTANCE;
        if (Intrinsics.areEqual(String.format("%.2f", Arrays.copyOf(new Object[]{Double.valueOf(r2.getY())}, 1)), String.format("%.2f", Arrays.copyOf(new Object[]{Float.valueOf(r14.b)}, 1))) == true) goto L11;
        r0.add(r2);
    L11:
        ListProtector.add(r0, 0, r2);
        goto L3
    L13:
        if (z41.g.o.b() == true) goto L18;
        t51.b r17 = (t51.b) ((LinkedHashMap) r13).get(getContext().getPkLinkUtils().b());
        if (r17 == null) goto L18;
        RectF r18 = o51.a.c(r17);
        float r6 = r18.left;
        float r7 = r14.c;
        float r8 = r18.top;
        float r19 = r14.b;
        float r110 = r15.a(new RectF(r6 - r7, (r8 - r19) / 0.5625f, r18.right - r7, (r18.bottom - r19) / 0.5625f)).height();
    L19:
        o51.e r111 = this.i.e;
        JSONObject r9 = new JSONObject();
        String r10 = o51.g.b(r111);
        String r20 = "";
        if (r10 == null) goto L25;
        s51.c r22 = this.h.d(r10, r10);
        if (r22 == null) goto L25;
        String r23 = r22.f();
        if (r23 == null) goto L25;
    L26:
        r9.put("focus_id", r23);
        r9.put("layout_type", r111.a.b);
        r9.put("ui_layout", r111.a.d);
        r9.put("ui_layout_kmp", r111.a.c);
        Iterator r112 = ((ArrayList) r12).iterator();
        int r113 = 0;
    L28:
        if (r112.hasNext() == false) goto L33;
        if (Intrinsics.areEqual(((IRegion) r112.next()).getInteractId(), getContext().Zl()) == true) goto L34;
        r113 = r113 + 1;
    L34:
        r9.put("owner_index", RangesKt.coerceAtLeast(r113, 0));
        g.a(r16, r9);
        JSONObject r114 = null;
        JSONObject r115 = new JSONObject();     // Catch: Throwable -> L104
        r115.put("ver", 2);     // Catch: Throwable -> L104
        r115.put(Constants.OperatorKey.KEY_VENDOR, IConfig.IVendor.BYTE.getName());     // Catch: Throwable -> L104
        r115.put("anchor_interact_info", r9);     // Catch: Throwable -> L104
        List<m11.b> r24 = (List) getContext().getLinkDataSet().q2().getValue();     // Catch: Throwable -> L104
        if (r24 != null) goto L38;
        r24 = new ArrayList();     // Catch: Throwable -> L104
    L38:
        JSONArray r25 = a(r24);     // Catch: Throwable -> L104
        if (r25.length() <= 0) goto L41;
        r115.put("ai_user_infos", r25);     // Catch: Throwable -> L104
    L41:
        RevLinkWindowRegionContext r26 = getContext().P8();     // Catch: Throwable -> L104
        if (r26 == null) goto L46;
        j<com.bytedance.android.live.revlink.impl.multianchor.service.g> r27 = r26.getPartnerService();     // Catch: Throwable -> L104
        if (r27 == null) goto L46;
        com.bytedance.android.live.revlink.impl.multianchor.service.g r28 = (com.bytedance.android.live.revlink.impl.multianchor.service.g) r27.getValue();     // Catch: Throwable -> L104
    L47:
        if (r28 != null) goto L49;
    L51:
        if (r20 != null) goto L53;
    L56:
        boolean r29 = true;
    L57:
        if (r29 == false) goto L59;
    L63:
        b(r0, r20, r24);     // Catch: Throwable -> L104
        r115.put("timestamp", this.a);     // Catch: Throwable -> L104
        r115.put("channel_id", String.valueOf(getContext().G()));     // Catch: Throwable -> L104
        JSONArray r30 = new JSONArray();     // Catch: Throwable -> L104
        Iterator r32 = r0.iterator();     // Catch: Throwable -> L104
    L65:
        if (r32.hasNext() == false) goto L67;
        c((IRegion) r32.next(), r30, r15.b, r110);     // Catch: Throwable -> L104
        goto L65
    L67:
        r115.put("grids", r30);     // Catch: Throwable -> L104
        r115.put("mix_grids", r16.a);     // Catch: Throwable -> L104
        JSONObject r116 = new JSONObject();     // Catch: Throwable -> L104
        com.bytedance.android.livesdk.revenue.service.room.c r117 = this.f;     // Catch: Throwable -> L104
        if (r117 == null) goto L72;
        com.bytedance.android.livesdk.revenue.room.a r118 = r117.getRoomContext();     // Catch: Throwable -> L104
        if (r118 == null) goto L72;
        IRoomBase r119 = r118.getCommonRoom();     // Catch: Throwable -> L104
    L73:
        IRoom r120 = (IRoom) r119;     // Catch: Throwable -> L104
        com.bytedance.android.live.revlink.impl.settings.live.a r33 = com.bytedance.android.live.revlink.impl.settings.live.a.j;     // Catch: Throwable -> L104
        r33.getClass();     // Catch: Throwable -> L104
        ReadOnlyProperty r34 = com.bytedance.android.live.revlink.impl.settings.live.a.f;     // Catch: Throwable -> L104
        KProperty[] r35 = com.bytedance.android.live.revlink.impl.settings.live.a.a;     // Catch: Throwable -> L104
        HashMap r36 = (HashMap) r34.getValue(r33, r35[4]);     // Catch: Throwable -> L104
        if (r120 == null) goto L96;
        int r37 = (int) IStreamUrlExtraKt.getHeightFlex(IRoomKtKt.getStreamUrlExtraSafely(r120));     // Catch: Throwable -> L104
        r116.put("height", r37);     // Catch: Throwable -> L104
        if (r120.getSceneTypeInfo() == null) goto L85;
        IRoomSpecificSceneTypeInfo r38 = r120.getSceneTypeInfo();     // Catch: Throwable -> L104
        if (r38 == null) goto L83;
        if (r38.isLandscapeVerticalRoom() == 1) goto L85;
    L83:
        if (((Boolean) com.bytedance.android.live.revlink.impl.settings.live.a.g.getValue(r33, r35[5])).booleanValue() == false) goto L85;
    L86:
        if (r3 == true) goto L88;
    L95:
        r116.put("width", IStreamUrlExtraKt.getWidthFlex(IRoomKtKt.getStreamUrlExtraSafely(r120)));     // Catch: Throwable -> L104
    L97:
        r116.put("background", "#000000");     // Catch: Throwable -> L104
        r115.put("canvas", r116);     // Catch: Throwable -> L104
        RectF r121 = r15.b;     // Catch: Throwable -> L104
        if (r121 == null) goto L100;
        int r122 = JSONObjectProtectorUtils.getInt(r116, "width");     // Catch: Throwable -> L104
        int r123 = JSONObjectProtectorUtils.getInt(r116, "height");     // Catch: Throwable -> L104
        JSONObject r39 = new JSONObject();     // Catch: Throwable -> L104
        float r40 = r122;
        r39.put("crop_x", (int) (r121.left * r40));     // Catch: Throwable -> L104
        float r42 = r123;
        r39.put("crop_y", (int) (r121.top * r42));     // Catch: Throwable -> L104
        r39.put("crop_w", (int) (r40 * r121.width()));     // Catch: Throwable -> L104
        r39.put("crop_h", (int) (r42 * r121.height()));     // Catch: Throwable -> L104
        r39.put("stride_w", r122);     // Catch: Throwable -> L104
        r39.put("stride_h", r123);     // Catch: Throwable -> L104
        r115.put("linkmic_crop", r39);     // Catch: Throwable -> L104
    L100:
        new HashMap().put("sei", r115.toString());     // Catch: Throwable -> L104
        r114 = r115;
        goto L103
    L88:
        if (r36.get(String.valueOf(r37)) == null) goto L95;
        String r124 = (String) r36.get(String.valueOf(r37));     // Catch: Throwable -> L104
        if (r124 == null) goto L94;
        Integer r125 = StringsKt.toIntOrNull(r124);     // Catch: Throwable -> L104
        if (r125 == null) goto L94;
        r4 = r125.intValue();     // Catch: Throwable -> L104
    L94:
        r116.put("width", r4);     // Catch: Throwable -> L104
    L85:
        r3 = false;
        goto L86
    L96:
        r116.put("width", 720);     // Catch: Throwable -> L104
        r116.put("height", 1280);     // Catch: Throwable -> L104
    L72:
        r119 = null;
        goto L73
    L59:
        if (r28 == null) goto L61;
        String r43 = r28.mo696c();     // Catch: Throwable -> L104
    L62:
        r115.put("layout_key", r43);     // Catch: Throwable -> L104
        goto L63
    L61:
        r43 = null;
        goto L62
    L53:
        if (r20.length() == 0) goto L56;
        r29 = false;
        goto L57
    L49:
        if (r28.n() != true) goto L51;
        r20 = r28.mo696c();     // Catch: Throwable -> L104
    L46:
        r28 = null;
    L103:
        return String.valueOf(r114);
    L33:
        r113 = -1;
    L25:
        r23 = "";
    L18:
        r110 = 0.40625f;
        goto L19
    }
}
