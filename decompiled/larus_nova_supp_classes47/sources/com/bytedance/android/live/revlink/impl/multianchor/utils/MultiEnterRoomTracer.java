package com.bytedance.android.live.revlink.impl.multianchor.utils;

import androidx.lifecycle.LiveData;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revlink.impl.global.LinkFakeGlobalService;
import com.bytedance.android.live.revlink.impl.multianchor.constants.PlayMode;
import com.bytedance.android.live.revlink.impl.service.internal.LinkRevInternalServiceContext;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class MultiEnterRoomTracer {
    public Boolean A;
    public boolean B;
    public final com.bytedance.android.live.revlink.impl.global.c C;
    public MultiLoadSource a;
    public long b;
    public long c;
    public long d;
    public long e;
    public long f;
    public long g;
    public long h;
    public long i;
    public long j;
    public long k;
    public long l;
    public long m;
    public long n;
    public long o;
    public long p;
    public long q;
    public boolean r;
    public boolean s;
    public boolean t;
    public boolean u;
    public String v;
    public FirstSeiType w;
    public long x;
    public long y;
    public boolean z;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/utils/MultiEnterRoomTracer$FirstSeiType;", "", "Empty", "InnerSei", "PlayerSei", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum FirstSeiType extends Enum<FirstSeiType> {
        public static final FirstSeiType Empty = null;
        public static final FirstSeiType InnerSei = null;
        public static final FirstSeiType PlayerSei = null;
        public static final /* synthetic */ FirstSeiType[] a = null;

        static {
            FirstSeiType r1 = new FirstSeiType("Empty", 0);
            Empty = r1;
            FirstSeiType r2 = new FirstSeiType("InnerSei", 1);
            InnerSei = r2;
            FirstSeiType r3 = new FirstSeiType("PlayerSei", 2);
            PlayerSei = r3;
            a = new FirstSeiType[]{r1, r2, r3};
        }

        public static FirstSeiType valueOf(String r1) {
            return (FirstSeiType) r27.a.a(FirstSeiType.class, r1);
        }

        public static FirstSeiType[] values() {
            return (FirstSeiType[]) a.clone();
        }

        public FirstSeiType(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/utils/MultiEnterRoomTracer$MultiLoadSource;", "", "RoomEnter", "LinkerEnter", "SeiBackUp", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum MultiLoadSource extends Enum<MultiLoadSource> {
        public static final MultiLoadSource LinkerEnter = null;
        public static final MultiLoadSource RoomEnter = null;
        public static final MultiLoadSource SeiBackUp = null;
        public static final /* synthetic */ MultiLoadSource[] a = null;

        static {
            MultiLoadSource r1 = new MultiLoadSource("RoomEnter", 0);
            RoomEnter = r1;
            MultiLoadSource r2 = new MultiLoadSource("LinkerEnter", 1);
            LinkerEnter = r2;
            MultiLoadSource r3 = new MultiLoadSource("SeiBackUp", 2);
            SeiBackUp = r3;
            a = new MultiLoadSource[]{r1, r2, r3};
        }

        public static MultiLoadSource valueOf(String r1) {
            return (MultiLoadSource) r27.a.a(MultiLoadSource.class, r1);
        }

        public static MultiLoadSource[] values() {
            return (MultiLoadSource[]) a.clone();
        }

        public MultiLoadSource(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    static {
    }

    public final boolean a() {
        if (this.m != 0) goto L5;
    L11:
        return false;
    L5:
        if (this.o == 0) goto L11;
        if (this.h == 0) goto L11;
        if (this.i == 0) goto L11;
        return true;
    }

    public final void e() {
        if (this.m != 0) goto L6;
        i97.a r0 = i97.a.a;
        this.m = System.currentTimeMillis();
        jy0.b.f("MultiEnterRoomTracer", "seiUpdateDone source=" + this.a, null, 4);
        g();
        return;
    }

    public final void f() {
        i97.a r0 = i97.a.a;
        this.l = System.currentTimeMillis();
        jy0.b.f("MultiEnterRoomTracer", "seiUpdateStart source=" + this.a, null, 4);
    }

    public final void g() {
        if (this.r == false) goto L5;
        return;
    L5:
        if (a() == false) goto L98;
        this.r = true;
        long r2 = Math.max(this.i, this.m);
        MultiLoadSource r4 = this.a;
        MultiLoadSource r5 = MultiLoadSource.RoomEnter;
        if (r4 != r5) goto L10;
        boolean r6 = true;
    L11:
        if (r6 == false) goto L14;
        r2 = RangesKt.coerceAtLeast(this.h, r2);
    L14:
        if (this.a != r5) goto L16;
        boolean r7 = true;
    L18:
        if (r7 == false) goto L22;
        long r8 = this.e;
        if (r8 <= 0) goto L22;
        long r9 = this.f - r8;
    L23:
        long r10 = this.g;
        long r12 = this.f;
        long r13 = r10 - r12;
        long r14 = this.h;
        long r15 = r14 - r10;
        long r17 = r2;
        long r16 = this.o - this.n;
        long r1 = this.m;
        long r18 = r1 - this.l;
        long r19 = this.j + this.k;
        this.x = r17 - r12;
        if (r1 < r14) goto L26;
    L28:
        boolean r3 = false;
    L29:
        long r20 = this.q;
        long r22 = r20 - this.p;
        long r23 = r20 - this.i;
        LinkedHashMap r110 = new LinkedHashMap();
        r110.put("control_waiting_duration", String.valueOf(r9));
        r110.put("link_waiting_duration", String.valueOf(r13));
        r110.put("link_load_duration", String.valueOf(r15));
        r110.put("link_total_duration", String.valueOf(r13 + r15));
        r110.put("layout_duration", String.valueOf(r16));
        r110.put("first_sei_update_duration", String.valueOf(r18));
        r110.put("api_call_duration", String.valueOf(r19));
        r110.put("link_mic_api_duration", String.valueOf(this.j));
        r110.put("total_duration", String.valueOf(this.x));
        r110.put("enter_room_total_duration", String.valueOf(this.x + r9));
        r110.put("is_switch", String.valueOf(false));
        r110.put("has_first_sei", String.valueOf(this.s));
        r110.put("first_sei_valid", String.valueOf(r3));
        r110.put("first_sei_type", String.valueOf(this.w.ordinal()));
        r110.put("is_pking", String.valueOf(this.t));
        com.bytedance.android.live.revlink.impl.global.c r24 = this.C;
        if (r24 == null) goto L32;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r25 = r24.Ig();
    L33:
        if (r25 == null) goto L40;
        LiveData<PlayMode> r26 = r25.getTeamMode();
        if (r26 == null) goto L40;
        PlayMode r27 = (PlayMode) r26.getValue();
        if (r27 == null) goto L40;
        String r28 = r27.toString();
        if (r28 == null) goto L40;
    L41:
        r110.put("pk_mode", r28);
        r110.put("enter_source", String.valueOf(this.a));
        r110.put("pk_widget_load_duration", String.valueOf(0));
        r110.put("list_response_duration", String.valueOf(this.k));
        com.bytedance.android.live.revlink.impl.global.c r29 = this.C;
        if (r29 == null) goto L44;
        com.bytedance.android.live.revlink.impl.multianchor.service.d r30 = r29.R8();
    L45:
        if (r30 == null) goto L49;
        i11.b r32 = r30.getLinkUserCenter();
        if (r32 == null) goto L49;
        int r33 = r32.c();
    L50:
        r110.put("anchor_connect_status", String.valueOf(r33));
        r110.put("link_list_failed", String.valueOf(this.u));
        r110.put("error_code", String.valueOf(this.y));
        r110.put("hit_cache", String.valueOf(this.z));
        r110.put("hit_view_cache", String.valueOf(this.A));
        r110.put("cache_from_register", String.valueOf(this.B));
        String r34 = this.v;
        if (r34 != null) goto L53;
        r34 = "";
    L53:
        r110.put("invalid_sei", r34);
        com.bytedance.android.live.revlink.impl.settings.dynamic.b r35 = com.bytedance.android.live.revlink.impl.settings.dynamic.b.m;
        if (r35.a().I6() == true) goto L56;
    L58:
        boolean r36 = false;
    L59:
        if (r36 == false) goto L61;
        r110.put("lynx_hub_load_duration", String.valueOf(r22));
        r110.put("lynx_hub_and_list_diff", String.valueOf(r23));
    L61:
        c(this.c, this.e, r110, "duration_from_p0_to_rev");
        c(this.b, r17, r110, "duration_from_start_room");
        c(this.c, r17, r110, "duration_from_load_p0");
        c(this.d, r17, r110, "duration_from_load_p1");
        com.bytedance.android.live.revlink.impl.global.c r37 = this.C;
        if (r37 == null) goto L64;
        LinkRevInternalServiceContext r38 = r37.Cj();
    L65:
        if (r38 != null) goto L67;
    L76:
        long r39 = this.x;
        u41.d r40 = u41.d.n;
        r40.getClass();
        ReadOnlyProperty r42 = u41.d.f;
        KProperty[] r43 = u41.d.a;
        if (r39 <= ((Number) r42.getValue(r40, r43[4])).intValue()) goto L87;
        if (((Boolean) u41.d.e.getValue(r40, r43[3])).booleanValue() == false) goto L87;
        com.bytedance.android.live.revlink.impl.global.c r44 = this.C;
        if (r44 == null) goto L83;
        v r45 = r44.getMultiLinkMonitor();
    L84:
        if (r45 == null) goto L87;
        Intrinsics.checkNotNullParameter(r110, "map");
        JSONObject r46 = new JSONObject(MapsKt.toMap(r110));
        r45.c(r46);
        r45.I("multi_audience_enter_duration_limited", r46, false);
        goto L87
    L83:
        r45 = null;
    L87:
        if (((Boolean) u41.d.e.getValue(r40, r43[3])).booleanValue() == false) goto L95;
        if (r3 == true) goto L95;
        com.bytedance.android.live.revlink.impl.global.c r47 = this.C;
        if (r47 == null) goto L92;
        v r48 = r47.getMultiLinkMonitor();
    L93:
        if (r48 == null) goto L95;
        Intrinsics.checkNotNullParameter(r110, "map");
        JSONObject r49 = new JSONObject(MapsKt.toMap(r110));
        r48.c(r49);
        r48.I("multi_audience_invalid_first_sei", r49, false);
        goto L95
    L92:
        r48 = null;
    L95:
        jy0.b.c("MultiEnterRoomTracer", r110.toString(), null, 4);
        mz0.n r50 = new mz0.n();
        Map<String, String> r52 = r50.a;
        Intrinsics.checkNotNullParameter(r52, "map");
        Intrinsics.checkNotNullParameter(r110, "map");
        r52.putAll(r110);
        mz0.m r53 = new mz0.m();
        r53.b(LogCommon.ROOM);
        r53.b(LogCommon.PAGE_SOURCE_LOG);
        ((ArrayList) r50.b).addAll(r53.a);
        cy0.e.a.getClass();
        cy0.j r54 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r55 = com.bytedance.android.scope.m.b(r54).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r55);
        ((mz0.i) ((f80.a) r55)).w3("livesdk_multi_load_duration", r50.a, r50.b);
        return;
    L67:
        if (((Boolean) r38.isAppBackground().getValue()).booleanValue() == false) goto L69;
        String r56 = "true";
    L75:
        r110.put("app_background", r56);
        r110.put("inner_feed_length", String.valueOf(r38.getCurrentFeedLength()));
        goto L76
    L69:
        com.bytedance.android.live.revlink.impl.service.internal.a r57 = (com.bytedance.android.live.revlink.impl.service.internal.a) r38.getService().getValue();
        if (r57 != null) goto L72;
    L74:
        r56 = "false";
        goto L75
    L72:
        if (r57.dc() != true) goto L74;
        r56 = "live";
        goto L75
    L64:
        r38 = null;
        goto L65
    L56:
        if (r35.a().N1() == false) goto L58;
        r36 = true;
    L49:
        r33 = 2;
        goto L50
    L44:
        r30 = null;
    L40:
        r28 = "none";
        goto L41
    L32:
        r25 = null;
        goto L33
    L26:
        if (this.s == false) goto L28;
        r3 = true;
    L22:
        r9 = 0;
        goto L23
    L16:
        r7 = false;
        goto L18
    L10:
        r6 = false;
        goto L11
    }

    public MultiEnterRoomTracer(LinkFakeGlobalService r1) {
        this.C = r1;
        this.w = FirstSeiType.Empty;
    }

    public final void d(MultiLoadSource r4) {
        Intrinsics.checkNotNullParameter(r4, "source");
        i97.a r0 = i97.a.a;
        this.f = System.currentTimeMillis();
        this.a = r4;
        jy0.b.f("MultiEnterRoomTracer", "multiLinkStart source=" + r4, null, 4);
    }

    public final void h(Map<String, String> r6) {
        Intrinsics.checkNotNullParameter(r6, "map");
        long r0 = this.m;
        if (r0 != 0) goto L5;
    L9:
        boolean r1 = false;
    L10:
        r6.put("enter_source", String.valueOf(this.a));
        String r2 = DataType.TRUE;
        if (r1 == false) goto L13;
        String r3 = DataType.TRUE;
    L14:
        r6.put("first_sei_valid", r3);
        if (a() == true) goto L18;
        r2 = DataType.FALSE;
    L18:
        r6.put("all_done", r2);
        r6.put("total_duration", String.valueOf(this.x));
        com.bytedance.android.live.revlink.impl.global.c r4 = this.C;
        if (r4 == null) goto L21;
        com.bytedance.android.live.revlink.impl.multianchor.vm.b r5 = r4.rb();
    L22:
        if (r5 == null) goto L27;
        com.bytedance.live.datacontext.m<String> r7 = r5.getConnectionSource();
        if (r7 == null) goto L27;
        String r8 = (String) r7.getValue();
        if (r8 == null) goto L27;
    L28:
        r6.put("live_source", r8);
        return;
    L27:
        r8 = "";
        goto L28
    L21:
        r5 = null;
        goto L22
    L13:
        r3 = DataType.FALSE;
        goto L14
    L5:
        if (r0 >= this.h) goto L9;
        if (this.s == false) goto L9;
        r1 = true;
        goto L10
    }

    public final void b(String r5, boolean r6, long r7) {
        Intrinsics.checkNotNullParameter(r5, "reqSrc");
        if ((!Intrinsics.areEqual(r5, "multi_anchor_link_widget_create")) == true) goto L5;
    L6:
        if (r6 == false) goto L9;
        return;
    L9:
        if (this.i != 0) goto L13;
        i97.a r8 = i97.a.a;
        this.i = System.currentTimeMillis();
        this.j = r7;
        this.k = 0;
        this.u = true;
        jy0.b.f("MultiEnterRoomTracer", "linkListDone source=" + this.a, null, 4);
        g();
        return;
    L13:
        return;
    L5:
        if ((!Intrinsics.areEqual(r5, "enter_room_preload")) == false) goto L6;
    }

    public static void c(long r3, long r5, Map r7, String r8) {
        Intrinsics.checkNotNullParameter(r7, "map");
        Intrinsics.checkNotNullParameter(r8, "key");
        if (r3 != 0) goto L5;
        return;
    L5:
        if (r5 == 0) goto L10;
        r7.put(r8, String.valueOf(RangesKt.coerceAtLeast(r5 - r3, 0)));
        return;
    }
}
