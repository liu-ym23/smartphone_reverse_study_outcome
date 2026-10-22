package f92;

import android.text.TextUtils;
import com.bytedance.android.live.core.monitor.LiveSlardarMonitor;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.interactivity.medialink.ui.window.MediaMultiLinkAnchorWindowManager;
import com.bytedance.android.livesdk.interactivity.medialink.widget.mixer.MediaLinkSeiCreator;
import com.bytedance.android.livesdk.interactivity.medialink.widget.mixer.WindowsPosition;
import com.bytedance.android.livesdk.log.b0;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.interact.data.LinkConstant;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.common.utility.Lists;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import jc1.k;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import nc0.r;
import nc0.s;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import ti6.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c implements j {
    public static final /* synthetic */ int i = 0;
    public final HashMap<String, Boolean> a;
    public final MediaLinkSeiCreator b;
    public String c;
    public String d;
    public com.bytedance.android.live.revenuelink.e e;
    public boolean f;
    public final b g;
    public final gy.f h;

    public static final class a {
    }

    static {
    }

    public final /* synthetic */ boolean b(aj6.d r1, aj6.b r2) {
        ti6.a.a(r1, r2);
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v30 */
    /* JADX WARN: Type inference failed for: r6v31, types: [int] */
    /* JADX WARN: Type inference failed for: r6v47 */
    public final String c(List<ti6.f> r14) {
        com.bytedance.android.live.revenuelink.e r0 = this.e;
        if (r0 == null) goto L13;
        if ((!r14.isEmpty()) == false) goto L10;
        r0.a(false);
        if (this.f == true) goto L13;
        r0.b("rtc_init");
        this.f = true;
        goto L13
    L10:
        if (this.f == false) goto L13;
        r0.dispose();
        this.f = false;
    L13:
        if (r14.size() <= 4) goto L24;
        HashMap r1 = new HashMap();
        if (com.bytedance.android.live.liveinteract.api.utils.g.l("multi_anchor_too_much") == true) goto L24;
        r1.put("event", "multi_anchor_too_much");
        com.bytedance.android.livesdk.user.e r4 = k.f(IMiddlewareUserService.class).user();
        Room r5 = m.i().getCurrentRoom();
        if (r5 == null) goto L21;
        if (r4 == null) goto L21;
        r1.put("room_id", r5.getIdStr());
        r1.put("anchor_id", r5.getOwnerUserIdString());
        boolean r6 = Objects.equals(r5.getOwnerUserIdString(), r4.n());
    L22:
        LiveSlardarMonitor.monitorStatus("ttlive_interact_event_api_all", com.bytedance.android.live.liveinteract.api.utils.d.a("multi_anchor_too_much", k.f(IInteractService.class).getCurrentScene(), r6), r1);
        b0.o().j("ttlive_link", r1);
    L21:
        r6 = false;
    L24:
        if (TextUtils.isEmpty(this.c) == true) goto L26;
    L28:
        HashMap r2 = new HashMap();
        r2.put("self", this.c);
        r2.put("region_size", Integer.valueOf(r14.size()));
        StringBuilder r3 = new StringBuilder();
        Iterator<ti6.f> r7 = r14.iterator();
    L30:
        if (r7.hasNext() == false) goto L32;
        r3.append(r7.next().b);
        r3.append("，");
        goto L30
    L32:
        r2.put("regions", r3.toString());
        b r8 = this.g;
        JSONObject r9 = null;
        if (r8 == null) goto L35;
        Map<String, WindowsPosition> r10 = r8.e();
    L36:
        r2.put("window_position", r10);
        b0.o().j("ttlive_anchor", r2);
        x82.e.A2.getClass();
        x82.e r11 = x82.e.a.a();
        if (r11 == null) goto L40;
        f r13 = r11.Q8();
        if (r13 == null) goto L40;
    L41:
        Iterator<ti6.f> r15 = r14.iterator();
    L43:
        if (r15.hasNext() == false) goto L73;
        ti6.f r16 = r15.next();
        b r17 = this.g;
        if (r17 == null) goto L47;
        WindowsPosition r18 = r17.o(r16.b);
    L48:
        if (r18 == null) goto L49;
        i r19 = r13.c(r18);
        double r20 = r19.e();
        double r110 = r19.f();
        r16.d = r20;
        r16.e = r110;
        double r21 = r19.d();
        double r111 = r19.a();
        r16.f = r21;
        r16.g = r111;
        r16.a = 1;
        if (r18 == WindowsPosition.IGNORE) goto L53;
        boolean r23 = true;
    L54:
        r16.l = r23;
        String r24 = r16.b;
        if (this.a.containsKey(r24) == false) goto L59;
        Boolean r25 = this.a.get(r24);
        if (r25 == null) goto L59;
        ?? r26 = r25.booleanValue();
    L60:
        r16.i = r26;
        if (TextUtils.equals(this.c, r16.b) == true) goto L43;
        gy.f r27 = this.h;
        if (r27 == null) goto L71;
        s r28 = r27.L();
        if (r28 == null) goto L71;
        r r29 = r28.e(r16.b);
        if (r29 == null) goto L71;
        if (r29.a.g != true) goto L71;
        boolean r30 = true;
    L72:
        r16.m = r30;
    L71:
        r30 = false;
    L59:
        r26 = 0;
        goto L60
    L53:
        r23 = false;
        goto L54
    L49:
        r16.l = false;
        r16.d = 1.0d;
        r16.e = 1.0d;
        r16.f = 0.1d;
        r16.g = 0.1d;
        goto L43
    L47:
        r18 = null;
        goto L48
    L73:
        JSONObject r31 = new JSONObject();
        x82.d.z2.getClass();
        x82.d r33 = x82.d.a.a();
        if (r33 == null) goto L77;
        String r34 = r33.zd();
        if (r34 == null) goto L77;
    L78:
        r31.put("focus_id", r34);
        r31.put("layout_type", e92.m.a().ordinal());
        ArrayList r35 = new ArrayList(r14);
        CollectionsKt.sortWith(r35, d.a);
        Iterator r112 = r35.iterator();
    L80:
        if (r112.hasNext() == false) goto L84;
        Object r36 = r112.next();
        if (TextUtils.equals(this.c, ((ti6.f) r36).b) == false) goto L80;
    L85:
        ti6.f r37 = (ti6.f) r36;
        if (r37 == null) goto L88;
        r35.remove(r37);
        ListProtector.add(r35, 0, r37);
    L88:
        Iterator r113 = r35.iterator();
        int r38 = 0;
    L90:
        if (r113.hasNext() == false) goto L95;
        if (TextUtils.equals(this.c, ((ti6.f) r113.next()).b) == true) goto L96;
        r38 = r38 + 1;
    L96:
        r31.put("owner_index", RangesKt.coerceAtLeast(r38, 0));
        MediaLinkSeiCreator r114 = this.b;
        long r39 = e92.m.b();
        r114.getClass();
        JSONObject r40 = new JSONObject();     // Catch: JSONException -> L149
        r40.put("ver", 19);     // Catch: JSONException -> L149
        r40.put("vendor", "byte");     // Catch: JSONException -> L149
        r40.put("anchor_interact_info", r31);     // Catch: JSONException -> L149
        if (r114.b == 0) goto L120;
        List<ti6.f> r41 = r114.c;     // Catch: JSONException -> L149
        if (Lists.isEmpty(r41) == false) goto L103;
    L116:
        boolean r43 = false;
    L117:
        if (r43 == false) goto L120;
        r40.put("timestamp", r114.b);     // Catch: JSONException -> L149
    L121:
        r114.c = r35;     // Catch: JSONException -> L149
        r40.put("channel_id", String.valueOf(r39));     // Catch: JSONException -> L149
        JSONArray r115 = new JSONArray();     // Catch: JSONException -> L149
        Iterator r44 = r35.iterator();     // Catch: JSONException -> L149
    L123:
        if (r44.hasNext() == false) goto L138;
        ti6.f r45 = (ti6.f) r44.next();     // Catch: JSONException -> L149
        if (r45.l == false) goto L123;
        JSONObject r46 = new JSONObject();     // Catch: JSONException -> L149
        r46.put("type", r45.a);     // Catch: JSONException -> L149
        r46.put("alpha", 1);     // Catch: JSONException -> L149
        r46.put("w", r45.f);     // Catch: JSONException -> L149
        r46.put("h", r45.g);     // Catch: JSONException -> L149
        r46.put(sz1.a.KEY_X, r45.d);     // Catch: JSONException -> L149
        r46.put(sz1.a.KEY_Y, r45.e);     // Catch: JSONException -> L149
        r46.put("account", 0);     // Catch: JSONException -> L149
        r46.put("uid", 0);     // Catch: JSONException -> L149
        r46.put("uid_str", r45.b);     // Catch: JSONException -> L149
        r46.put("zorder", 0);     // Catch: JSONException -> L149
        r46.put("stat", r45.i);     // Catch: JSONException -> L149
        if (r45.j == true) goto L132;
        int r47 = 0;
    L133:
        r46.put("talk", r47);     // Catch: JSONException -> L149
        if (r45.m == false) goto L136;
        int r48 = 1;
    L137:
        r46.put("mute_audio", r48);     // Catch: JSONException -> L149
        r115.put(r46);     // Catch: JSONException -> L149
        goto L123
    L136:
        r48 = 0;
        goto L137
    L132:
        r47 = 2;
        goto L133
    L138:
        r40.put("grids", r115);     // Catch: JSONException -> L149
        JSONObject r116 = new JSONObject();     // Catch: JSONException -> L149
        Room r49 = k.f(IRoomService.class).getCurrentRoom();     // Catch: JSONException -> L149
        if (r49 != null) goto L142;
    L144:
        r116.put(sz1.a.KEY_WIDTH, 720);     // Catch: JSONException -> L149
        r116.put(sz1.a.KEY_HEIGHT, 1280);     // Catch: JSONException -> L149
    L145:
        r116.put("background", LinkConstant.STREAM_BACKGROUND);     // Catch: JSONException -> L149
        r40.put("canvas", r116);     // Catch: JSONException -> L149
        new HashMap().put("sei", r40.toString());     // Catch: JSONException -> L149
        r9 = r40;
        goto L148
    L142:
        if (r49.getStreamUrlExtra() == null) goto L144;
        r116.put(sz1.a.KEY_WIDTH, r49.getStreamUrlExtra().getWidth());     // Catch: JSONException -> L149
        r116.put(sz1.a.KEY_HEIGHT, r49.getStreamUrlExtra().getHeight());     // Catch: JSONException -> L149
        goto L145
    L103:
        if (Lists.isEmpty(r35) == true) goto L116;
        if (r41.size() != r35.size()) goto L116;
        int r50 = 0;
    L110:
        if (r50 >= r41.size()) goto L115;
        if (r114.a.a((ti6.f) ListProtector.get(r41, r50), (ti6.f) ListProtector.get(r35, r50)) == false) goto L116;
        r50 = r50 + 1;     // Catch: JSONException -> L149
        goto L110
    L115:
        r43 = true;
    L120:
        long r51 = System.currentTimeMillis();     // Catch: JSONException -> L149
        r114.b = r51;     // Catch: JSONException -> L149
        r40.put("timestamp", r51);     // Catch: JSONException -> L149
    L148:
        return r9.toString();
    L95:
        r38 = -1;
        goto L96
    L84:
        r36 = null;
    L77:
        r34 = "0";
    L40:
        r13 = new g();
        goto L41
    L35:
        r10 = null;
        goto L36
    L26:
        if (Lists.isEmpty(r14) == true) goto L28;
        this.c = ((ti6.f) ListProtector.get(r14, 0)).b;
        goto L28
    }

    public c(MediaMultiLinkAnchorWindowManager r1, gy.f r2, hy.e r3) {
        this.g = r1;
        this.h = r2;
        this.a = new HashMap();
        this.d = BuildConfig.FLAVOR;
        this.b = new MediaLinkSeiCreator();
        this.c = String.valueOf(e92.m.b());
    }

    public final String a(int r1, int r2, List<ti6.f> r3) {
        Intrinsics.checkNotNullParameter(r3, "mixRegions");
        String r4 = c(r3);     // Catch: Throwable -> L5
        this.d = r4;     // Catch: Throwable -> L5
        return r4;
    L6:
        return this.d;
    }
}
