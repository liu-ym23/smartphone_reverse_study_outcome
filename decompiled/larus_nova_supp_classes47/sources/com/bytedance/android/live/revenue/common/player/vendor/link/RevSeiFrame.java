package com.bytedance.android.live.revenue.common.player.vendor.link;

import com.bytedance.android.live.revenue.common.player.utils.LiveSeiUtil;
import com.bytedance.android.live.revenue.common.q0;
import com.bytedance.android.livesdk.model.n0;
import com.bytedance.android.livesdk.model.p0;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import o51.f;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class RevSeiFrame {
    public static final Lazy D = null;
    public static final Map<Integer, RevSeiFrame> E = null;
    public static final List<RevSeiFrame> F = null;
    public static final a G = null;
    public final Lazy A;
    public final Lazy B;
    public final String C;
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public final Lazy h;
    public final Lazy i;
    public final Lazy j;
    public final Lazy k;
    public final Lazy l;
    public final Lazy m;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
    public final Lazy q;
    public final Lazy r;
    public final Lazy s;
    public final Lazy t;
    public final Lazy u;
    public final Lazy v;
    public final Lazy w;
    public final Lazy x;
    public final Lazy y;
    public final Lazy z;

    public static final class a {
        public a() {
        }

        public static RevSeiFrame a(a r4, String r5, boolean r6, int r7) {
            boolean r2 = true;
            if ((r7 & 2) == 0) goto L5;
            boolean r0 = true;
        L7:
            if ((r7 & 4) == 0) goto L9;
            r6 = true;
        L9:
            r4.getClass();
            if (r5 != null) goto L12;
        L15:
            if (r2 == true) goto L50;
            if (r6 == false) goto L19;
        L29:
            if (r5 == null) goto L31;
            int r8 = r5.hashCode();
        L32:
            Map<Integer, RevSeiFrame> r9 = RevSeiFrame.E;
            Integer r10 = Integer.valueOf(r8);
            Intrinsics.checkNotNullParameter(r9, "$this$getOrNull");
            if (r9.containsKey(r10) == false) goto L35;
            Object r12 = ((LinkedHashMap) r9).get(r10);
        L36:
            RevSeiFrame r13 = (RevSeiFrame) r12;
            if (r13 == null) goto L39;
            return r13;
        L39:
            if (r5 != null) goto L41;
            r5 = "";
        L41:
            RevSeiFrame r14 = new RevSeiFrame(r5);
            if (r0 == false) goto L52;
            RevSeiFrame.G.getClass();
            List<RevSeiFrame> r15 = RevSeiFrame.F;
            ArrayList r16 = (ArrayList) r15;
            if (r16.size() <= 5) goto L46;
            r9.remove(Integer.valueOf(((Number) ((RevSeiFrame) ListProtector.remove(r15, 0)).a.getValue()).intValue()));
        L46:
            r9.put(Integer.valueOf(((Number) r14.a.getValue()).intValue()), r14);
            r16.add(r14);
            return r14;
        L52:
            return r14;
        L35:
            r12 = null;
            goto L36
        L31:
            r8 = 0;
            goto L32
        L19:
            if (Intrinsics.areEqual(new RevSeiFrame(r5).o(), Boolean.TRUE) == false) goto L29;
            b03.a r17 = b03.a.a;
            if (PadConfigUtils.a() == true) goto L29;
            JSONObject r18 = new JSONObject(r5);     // Catch: Exception -> L24
            JSONObject r19 = new JSONObject(JSONObjectProtectorUtils.getString(r18, "app_data"));     // Catch: Exception -> L24
            r19.put("grids", r19.get("horizontal_grids"));     // Catch: Exception -> L24
            r18.put("app_data", r19.toString());     // Catch: Exception -> L24
            r5 = r18.toString();     // Catch: Exception -> L24
        L24:
            e = move-exception;
            int r20 = w51.a.a;
            String r22 = q0.a(e);
            if (r22 != null) goto L28;
            r22 = "empty error msg";
        L28:
            w51.a.C0337a.b("Change Grids Info Error", r22);
            goto L29
        L50:
            return (RevSeiFrame) RevSeiFrame.D.getValue();
        L12:
            if (r5.length() == 0) goto L15;
            r2 = false;
            goto L15
        L5:
            r0 = false;
            goto L7
        }
    }

    public final p0 b() {
        return (p0) this.j.getValue();
    }

    public final int c() {
        return ((Number) this.B.getValue()).intValue();
    }

    public final JSONObject d() {
        return (JSONObject) this.h.getValue();
    }

    public final Long e() {
        return (Long) this.i.getValue();
    }

    public final float f() {
        return ((Number) this.r.getValue()).floatValue();
    }

    public final n0 g() {
        return (n0) this.n.getValue();
    }

    public final boolean h() {
        return ((Boolean) this.z.getValue()).booleanValue();
    }

    public final int i() {
        return ((Number) this.y.getValue()).intValue();
    }

    public final Integer m() {
        return (Integer) this.l.getValue();
    }

    public final Integer n() {
        return (Integer) this.d.getValue();
    }

    public final Boolean o() {
        return (Boolean) this.c.getValue();
    }

    public final boolean p() {
        return ((Boolean) this.k.getValue()).booleanValue();
    }

    static {
        G = new a();
        D = LazyKt.lazy(RevSeiFrame$Companion$emptyFrame$2.INSTANCE);
        E = new LinkedHashMap();
        F = new ArrayList();
    }

    public final JSONObject a() {
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L12
        Lazy r3 = LiveSeiUtil.a;     // Catch: Throwable -> L12
        JSONObject r4 = LiveSeiUtil.a(this.C);     // Catch: Throwable -> L12
        if (r4.has("info") == true) goto L6;
    L10:
        Object r0 = Result.constructor-impl(r4);     // Catch: Throwable -> L12
    L15:
        if (Result.isFailure-impl(r0) == false) goto L18;
        r0 = null;
    L18:
        return (JSONObject) r0;
    L6:
        if (r4.has("source") == false) goto L10;
        if (Intrinsics.areEqual(r4.optString("source"), "zego") == false) goto L10;
        r4 = JSONObjectProtectorUtils.getJSONObject(r4, "info");     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r0 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    }

    public final n0 r() {
        Object r1 = null;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L21
        if (StringsKt.contains$default(this.C, "linkmic_crop", false, 2, null) == false) goto L20;
        JSONObject r3 = d();     // Catch: Throwable -> L21
        if (r3 == null) goto L20;
        if (r3.has("linkmic_crop") != true) goto L20;
        int r4 = n0.a;     // Catch: Throwable -> L21
        JSONObject r5 = d();     // Catch: Throwable -> L21
        if (r5 == null) goto L13;
        JSONObject r0 = JSONObjectProtectorUtils.getJSONObject(r5, "linkmic_crop");     // Catch: Throwable -> L21
    L14:
        n0 r6 = n0.a.a(r0);     // Catch: Throwable -> L21
        if (r6 == null) goto L20;
        if (r6.g() == false) goto L20;
        return r6;
    L13:
        r0 = null;
    L20:
        return null;
    L21:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        Object r8 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r8) == true) goto L27;
        r1 = r8;
    L27:
        return (n0) r1;
    }

    public final n0 s() {
        Object r1 = null;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L21
        if (StringsKt.contains$default(this.C, "live_crop", false, 2, null) == false) goto L20;
        JSONObject r3 = (JSONObject) this.b.getValue();     // Catch: Throwable -> L21
        if (r3 == null) goto L20;
        if (r3.has("live_crop") != true) goto L20;
        int r4 = n0.a;     // Catch: Throwable -> L21
        JSONObject r5 = (JSONObject) this.b.getValue();     // Catch: Throwable -> L21
        if (r5 == null) goto L13;
        JSONObject r0 = JSONObjectProtectorUtils.getJSONObject(r5, "live_crop");     // Catch: Throwable -> L21
    L14:
        n0 r6 = n0.a.a(r0);     // Catch: Throwable -> L21
        if (r6 == null) goto L20;
        if (r6.g() == false) goto L20;
        return r6;
    L13:
        r0 = null;
    L20:
        return null;
    L21:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        Object r8 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r8) == true) goto L27;
        r1 = r8;
    L27:
        return (n0) r1;
    }

    public final f k() {
        p0 r0 = b();
        boolean r1 = false;
        if (r0 == null) goto L7;
        List r2 = r0.e();
        if (r2 == null) goto L7;
        int r3 = r2.size();
    L8:
        p0 r4 = b();
        if (r4 == null) goto L11;
        int r5 = r4.getGameType();
    L13:
        if (((Number) this.t.getValue()).intValue() == 0) goto L15;
        r1 = true;
    L15:
        if (r5 == 0) goto L19;
        if (r1 == false) goto L24;
        return f.m.e;
    L24:
        return f.l.e;
    L19:
        if (r3 <= 1) goto L22;
        return f.n.e;
    L22:
        return f.k.e;
    L11:
        r5 = 0;
    L7:
        r3 = 0;
        goto L8
    }

    public RevSeiFrame(String r1) {
        this.C = r1;
        this.a = LazyKt.lazy(new RevSeiFrame$rawHashCode$2(this));
        this.b = LazyKt.lazy(new RevSeiFrame$seiJsonObject$2(this));
        this.c = LazyKt.lazy(new RevSeiFrame$isGameLink$2(this));
        this.d = LazyKt.lazy(new RevSeiFrame$version$2(this));
        this.e = LazyKt.lazy(new RevSeiFrame$channelID$2(this));
        this.f = LazyKt.lazy(new RevSeiFrame$appDataStr$2(this));
        this.g = LazyKt.lazy(new RevSeiFrame$trimmedAppDataString$2(this));
        this.h = LazyKt.lazy(new RevSeiFrame$appDataJSONObject$2(this));
        this.i = LazyKt.lazy(new RevSeiFrame$appDataTs$2(this));
        this.j = LazyKt.lazy(new RevSeiFrame$appData$2(this));
        this.k = LazyKt.lazy(new RevSeiFrame$isPartnerLayout$2(this));
        this.l = LazyKt.lazy(new RevSeiFrame$uiLayoutServerIndex$2(this));
        this.m = LazyKt.lazy(new RevSeiFrame$isHorizontal$2(this));
        this.n = LazyKt.lazy(new RevSeiFrame$cropSeiData$2(this));
        this.o = LazyKt.lazy(new RevSeiFrame$isLiveCrop$2(this));
        this.p = LazyKt.lazy(new RevSeiFrame$isLinkCrop$2(this));
        this.q = LazyKt.lazy(new RevSeiFrame$canvasSize$2(this));
        this.r = LazyKt.lazy(new RevSeiFrame$canvasWHRatio$2(this));
        this.s = LazyKt.lazy(new RevSeiFrame$canvasWHRadioForScreenRecord$2(this));
        this.t = LazyKt.lazy(new RevSeiFrame$gameFull$2(this));
        this.u = LazyKt.lazy(new RevSeiFrame$gameType$2(this));
        this.v = LazyKt.lazy(new RevSeiFrame$gameMixStreamType$2(this));
        this.w = LazyKt.lazy(new RevSeiFrame$seiIndex$2(this));
        this.x = LazyKt.lazy(new RevSeiFrame$uiLayoutKMPIndex$2(this));
        this.y = LazyKt.lazy(new RevSeiFrame$layoutTypeIndex$2(this));
        this.z = LazyKt.lazy(new RevSeiFrame$hasMixGrids$2(this));
        this.A = LazyKt.lazy(new RevSeiFrame$anchorGridsCount$2(this));
        this.B = LazyKt.lazy(new RevSeiFrame$appDataIndex$2(this));
    }

    public final f l(int r3) {
        Long r4 = q(this.C, r3);
        if (r4 == null) goto L5;
        long r0 = r4.longValue();
    L6:
        int r5 = (int) r0;
        f.j r1 = f.j.e;
        if (r5 == r1.c) goto L41;
        f.b r2 = f.b.e;
        if (r5 == r2.c) goto L42;
        f.c r6 = f.c.e;
        if (r5 == r6.c) goto L43;
        f.d r7 = f.d.e;
        if (r5 == r7.c) goto L44;
        f.e r8 = f.e.e;
        if (r5 == r8.c) goto L45;
        f.k r9 = f.k.e;
        if (r5 == r9.c) goto L46;
        f.n r10 = f.n.e;
        if (r5 == r10.c) goto L47;
        f.l r12 = f.l.e;
        if (r5 == r12.c) goto L48;
        f.m r13 = f.m.e;
        if (r5 == r13.c) goto L49;
        f.i r14 = f.i.e;
        if (r5 == r14.c) goto L50;
        f.h r15 = f.h.e;
        if (r5 != r15.c) goto L40;
        return r15;
    L40:
        return new f.a(r5);
    L50:
        return r14;
    L49:
        return r13;
    L48:
        return r12;
    L47:
        return r10;
    L46:
        return r9;
    L45:
        return r8;
    L44:
        return r7;
    L43:
        return r6;
    L42:
        return r2;
    L41:
        return r1;
    L5:
        r0 = 0;
        goto L6
    }

    public static Long q(String r6, int r7) {
        Intrinsics.checkNotNullParameter(r6, "str");
        Object r0 = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L17
        int r2 = r6.length();     // Catch: Throwable -> L17
        if (r7 >= 0) goto L6;
        return null;
    L6:
        if (r7 >= r2) goto L10;
        if (Character.isDigit(r6.charAt(r7)) == true) goto L10;
        r7 = r7 + 1;     // Catch: Throwable -> L17
    L10:
        long r3 = 0;
    L11:
        if (r7 >= r2) goto L15;
        if (Character.isDigit(r6.charAt(r7)) == false) goto L15;
        r3 = (r3 * ((long) 10)) + ((long) (r6.charAt(r7) - '0'));     // Catch: Throwable -> L17
        r7 = r7 + 1;     // Catch: Throwable -> L17
    L15:
        return Long.valueOf(r3);
    L17:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        Object r9 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r9) == true) goto L23;
        r0 = r9;
    L23:
        return (Long) r0;
    }

    public final f t(boolean r6, boolean r7) {
        if (c() >= 0) goto L7;
        return f.j.e;
    L7:
        if (((Number) this.x.getValue()).intValue() < 0) goto L11;
        return l(((Number) this.x.getValue()).intValue());
    L11:
        if (i() >= 0) goto L31;
        Integer r8 = n();     // Catch: Throwable -> L51
        if (r8 != null) goto L16;
    L19:
        Integer r9 = n();     // Catch: Throwable -> L51
        if (r9 != null) goto L23;
    L30:
        return f.j.e;
    L23:
        if (r9.intValue() != 19) goto L30;
        if (f.b.e.b != 0) goto L28;
        return f.h.e;
    L28:
        return f.i.e;
    L16:
        if (r8.intValue() != 2) goto L19;
        return k();
    L31:
        Long r0 = q(this.C, i());     // Catch: Throwable -> L51
        if (r0 == null) goto L34;
        int r1 = (int) r0.longValue();     // Catch: Throwable -> L51
    L35:
        Integer r3 = n();     // Catch: Throwable -> L51
        if (r3 != null) goto L39;
    L41:
        if (r3 != null) goto L44;
    L50:
        return j(r1, r6, r7);
    L44:
        if (r3.intValue() != 19) goto L50;
        if (r1 != f.b.e.b) goto L57;
        return f.h.e;
    L57:
        return f.i.e;
    L39:
        if (r3.intValue() != 2) goto L41;
        return k();
    L34:
        r1 = 0;
        goto L35
    L52:
        return f.j.e;
    }

    public final f j(int r3, boolean r4, boolean r5) {
        f.j r0 = f.j.e;
        if (r3 != r0.b) goto L10;
        if (r5 == true) goto L7;
        return f.C0284f.e;
    L7:
        if (Intrinsics.areEqual(o(), Boolean.TRUE) == false) goto L25;
        if (r5 == true) goto L27;
        return r0;
    L27:
        return f.g.e;
    L25:
        return r0;
    L10:
        f r6 = f.b.e;
        if (r3 == r6.b) goto L28;
        r6 = f.c.e;
        if (r3 != r6.b) goto L29;
        Integer r7 = (Integer) this.m.getValue();
        if (r7 != null) goto L19;
    L21:
        if (r4 == false) goto L28;
        return f.e.e;
    L19:
        if (r7.intValue() != 1) goto L21;
        return f.d.e;
    L29:
        return r0;
    L28:
        return r6;
    }
}
