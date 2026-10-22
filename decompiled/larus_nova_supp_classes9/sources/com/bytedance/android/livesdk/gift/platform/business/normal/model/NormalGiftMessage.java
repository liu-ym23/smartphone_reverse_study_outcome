package com.bytedance.android.livesdk.gift.platform.business.normal.model;

import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.message.b5;
import com.bytedance.android.live.base.model.message.c5;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.gift.configmodel.o2;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.h2;
import com.bytedance.android.livesdk.gift.model.j3;
import com.bytedance.android.livesdk.gift.model.n3;
import com.bytedance.android.livesdk.gift.model.o0;
import com.bytedance.android.livesdk.gift.model.u3;
import com.bytedance.android.livesdk.gift.model.v3;
import com.bytedance.android.livesdk.gift.model.w;
import com.bytedance.android.livesdk.gift.platform.business.e;
import com.bytedance.android.livesdk.gift.platform.business.j;
import com.bytedance.android.livesdk.gift.platform.business.tray.l;
import com.bytedance.android.livesdk.gift.platform.business.tray.m;
import com.bytedance.android.livesdk.gift.platform.core.utils.u;
import com.bytedance.android.livesdk.gift.util.b;
import com.bytedance.android.livesdk.message.model.i6;
import com.bytedance.android.livesdk.message.model.k6;
import com.bytedance.android.livesdk.message.model.m7;
import com.bytedance.android.livesdk.message.model.o7;
import com.bytedance.android.livesdk.message.model.q8;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import gm2.h;
import iy1.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.reflect.KProperty;
import py.k;
import v12.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class NormalGiftMessage implements h, Comparable<NormalGiftMessage>, d {
    public Map<Long, a> A;
    public int B;
    public List<String> C;
    public j3 D;
    public w E;
    public List<n3> F;
    public long G;
    public int H;
    public String I;
    public boolean J;
    public boolean K;
    public long L;
    public boolean M;
    public int N;
    public String O;
    public boolean P;
    public boolean Q;
    public final long a;
    public final long b;
    public String c;
    public a5 d;
    public IBaseUser e;
    public IBaseUser f;
    public int g;
    public long h;
    public boolean i;
    public Map<Integer, Long> j;
    public long k;
    public long l;
    public long m;
    public int n;
    public k o;
    public boolean p;
    public String q;
    public String r;
    public Map<String, Long> s;
    public gm2.d t;
    public m7 u;
    public boolean v;
    public h2 w;
    public long x;
    public int y;
    public a z;

    public static final enum GiftType extends Enum<GiftType> {
        public static final /* synthetic */ GiftType[] a = null;
        public static final GiftType group = null;
        public static final GiftType normal = null;

        static {
            GiftType r0 = new GiftType("normal", 0);
            normal = r0;
            GiftType r1 = new GiftType("group", 1);
            group = r1;
            a = new GiftType[]{r0, r1};
        }

        public static GiftType[] values() {
            return (GiftType[]) a.clone();
        }

        public static GiftType valueOf(String r1) {
            return (GiftType) r27.a.a(GiftType.class, r1);
        }

        public GiftType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public long getTotalMoney() {
        return t(false);
    }

    public final int hashCode() {
        return 0;
    }

    @Override // v12.d
    public final long getAssetId() {
        if ((this.t instanceof k6) == false) goto L7;
        return o().getAssetId();
    L7:
        if (n() == null) goto L11;
        return n().getAssetId();
    L11:
        if (s() == null) goto L17;
        h1 r0 = s().getGift();
        if (r0 != null) goto L15;
        return 0;
    L15:
        return r0.getPrimaryEffectId();
    L17:
        h2 r1 = this.w;
        if (r1 != null) goto L20;
        return 0;
    L20:
        return r1.getPrimaryEffectId();
    }

    @Override // v12.d
    public final String getFromUserId() {
        IBaseUser r0 = this.e;
        if (r0 != null) goto L7;
        return BuildConfig.FLAVOR;
    L7:
        return String.valueOf(r0.getIdString());
    }

    @Override // v12.d
    public final String getGiftInfo() {
        StringBuilder r0 = new StringBuilder("giftEnd: ");
        r0.append(this.p);
        r0.append(" ; comboCount: ");
        r0.append(this.m);
        r0.append(" ; combSurplus: ");
        r0.append(this.n);
        r0.append(" ; groupId: ");
        r0.append(this.l);
        r0.append(" ; groupCount");
        r0.append(this.k);
        r0.append(" ; repeatCount");
        if (r() == null) goto L5;
        Object r1 = Integer.valueOf(r().getRepeatEnd());
    L6:
        r0.append(r1);
        return r0.toString();
    L5:
        r1 = BuildConfig.FLAVOR;
        goto L6
    }

    @Override // v12.d
    public final String getLogId() {
        gm2.d r0 = this.t;
        if (r0 != null) goto L7;
        return BuildConfig.FLAVOR;
    L7:
        return r0.getLogId();
    }

    public final long getTotalCount() {
        return (this.m + ((long) this.n)) * this.k;
    }

    public final a5 getTrayDisplayText() {
        com.bytedance.android.livesdk.gift.configmodel.w r0 = (com.bytedance.android.livesdk.gift.configmodel.w) e.G.getValue(null, e.a[31]);
        if (r0 == null) goto L29;
        if (r0.a() == null) goto L29;
        if (r0.a().b() == false) goto L29;
        if (this.d == null) goto L29;
        String r1 = r0.a().a();
        if (r1 == null) goto L29;
        if (r1.matches("#[A-Fa-f0-9]+") == false) goto L29;
        b5 r2 = this.d.getDefaultFormat();
        if (r2 == null) goto L17;
        r2.setColor(r1);
    L17:
        List r3 = this.d.getPieces();
        if (r3 == null) goto L29;
        int r4 = 0;
    L21:
        if (r4 >= r3.size()) goto L29;
        c5 r5 = (c5) ListProtector.get(r3, r4);
        if (r5 == null) goto L27;
        if (r5.getFormat() == null) goto L27;
        r5.getFormat().setColor(r1);
    L27:
        r4 = r4 + 1;
    L29:
        return this.d;
    }

    public final String m() {
        if (this.x != 0) goto L6;
        this.x = p().longValue();
    L6:
        return "0" + String.valueOf(this.x);
    }

    public final i6 n() {
        i6 r0 = this.t;
        if ((r0 instanceof i6) == true) goto L7;
        return null;
    L7:
        return r0;
    }

    public final k6 o() {
        k6 r0 = this.t;
        if ((r0 instanceof k6) == true) goto L7;
        return null;
    L7:
        return r0;
    }

    public final String q() {
        if (((o2) t02.a.b.getValue(null, t02.a.a[0])).a() == true) goto L6;
        Boolean r0 = Boolean.FALSE;
    L22:
        if (r0.booleanValue() == true) goto L24;
        int r1 = b02.a.f(this);
        if (b02.a.d(this) == false) goto L35;
        if ((this instanceof com.bytedance.android.livesdk.gift.platform.business.tray.a) == false) goto L35;
        if (r1 <= 0) goto L35;
        if (this.m <= r1) goto L35;
        return String.format("%d+", new Object[]{Integer.valueOf(r1)});
    L35:
        return String.valueOf(this.m);
    L24:
        return String.format("%d+", new Object[]{Integer.valueOf(b02.a.g(this))});
    L6:
        if ((this instanceof com.bytedance.android.livesdk.gift.platform.business.tray.a) == false) goto L8;
    L12:
        boolean r2 = false;
    L13:
        int r3 = b02.a.g(this);
        if (r2 == false) goto L19;
        if (r3 <= 0) goto L19;
        if (this.m <= r3) goto L19;
        boolean r4 = true;
    L20:
        r0 = Boolean.valueOf(r4);
    L19:
        r4 = false;
        goto L20
    L8:
        if ((this instanceof l) == true) goto L12;
        if ((this instanceof m) == true) goto L12;
        r2 = true;
        goto L13
    }

    public final o7 r() {
        o7 r0 = this.t;
        if ((r0 instanceof o7) == true) goto L7;
        return null;
    L7:
        return r0;
    }

    public final q8 s() {
        q8 r0 = this.t;
        if ((r0 instanceof q8) == true) goto L7;
        return null;
    L7:
        return r0;
    }

    public final String u() {
        long r1 = 0;
        if ((this instanceof com.bytedance.android.livesdk.gift.platform.business.tray.a) == true) goto L5;
    L6:
        List<n3> r0 = this.F;
        if (r0 != null) goto L9;
    L15:
        StringBuilder r2 = new StringBuilder();
        r2.append(getFromUserId());
        r2.append("-");
        r2.append(String.valueOf(this.b));
        r2.append("-");
        r2.append(String.valueOf(this.l));
        r2.append("-");
        r2.append(String.valueOf(this.k));
        IBaseUser r3 = this.e;
        if (r3 != null) goto L18;
    L20:
        String r4 = BuildConfig.FLAVOR;
    L21:
        r2.append(r4);
        if (s() == null) goto L24;
        r1 = this.L;
    L24:
        r2.append(String.valueOf(r1));
        String r5 = r2.toString();
        IBaseUser r6 = this.f;
        if (r6 != null) goto L27;
        return r5;
    L27:
        return r5 + "_" + r6.getIdString();
    L18:
        if (r3.getWebcastUid() == null) goto L20;
        r4 = this.e.getWebcastUid();
        goto L21
    L9:
        if (r0.isEmpty() == true) goto L15;
    L11:
        if (this.x != 0) goto L14;
        this.x = p().longValue();
    L14:
        return String.valueOf(0) + String.valueOf(this.x);
    L5:
        if (b02.a.b(this) == false) goto L11;
        goto L6
    }

    public final String v() {
        if ((this instanceof com.bytedance.android.livesdk.gift.platform.business.tray.a) == true) goto L5;
    L11:
        StringBuilder r0 = new StringBuilder();
        r0.append(getFromUserId());
        r0.append("-");
        r0.append(String.valueOf(this.b));
        r0.append("-");
        r0.append(String.valueOf(this.l));
        IBaseUser r1 = this.e;
        if (r1 != null) goto L14;
    L16:
        String r2 = BuildConfig.FLAVOR;
    L17:
        r0.append(r2);
        String r3 = r0.toString();
        KProperty[] r4 = b02.a.a;
        if (((Boolean) j.c.getValue(null, j.a[1])).booleanValue() == false) goto L23;
        IBaseUser r5 = this.f;
        if (r5 != null) goto L22;
        return r3;
    L22:
        return r3 + "_" + r5.getIdString();
    L23:
        return r3;
    L14:
        if (r1.getWebcastUid() == null) goto L16;
        r2 = this.e.getWebcastUid();
        goto L17
    L5:
        if (b02.a.b(this) == true) goto L11;
        if (this.x != 0) goto L10;
        this.x = p().longValue();
    L10:
        return String.valueOf(0) + String.valueOf(this.x);
    }

    public static Long p() {
        if (b.b() == null) goto L11;
        if (b.b().getBigGiftKeyCount() == null) goto L11;
        if (b.b().getBigGiftKeyCount().getValue() == null) goto L11;
        Long r0 = Long.valueOf(((Long) b.b().getBigGiftKeyCount().getValue()).longValue() + 1);
        b.b().getBigGiftKeyCount().setValue(r0);
        return r0;
    L11:
        return 0L;
    }

    public final void b() {
        if (b.b() != null) goto L5;
    L8:
        this.m++;
        this.n--;
        return;
    L5:
        if (this.v == true) goto L8;
        x(this.m + ((long) this.n));
        this.n = 0;
    }

    @Override // v12.d
    public final String getTraceId() {
        if (r() != null) goto L7;
        return null;
    L7:
        return r().getTraceId();
    }

    public final Boolean i() {
        o7 r0 = r();
        if (r0 == null) goto L5;
        o0 r1 = r0.getTrayInfo();
        if (r1 == null) goto L9;
        u3 r2 = r1.getTrayPostEffect();
        if (r2 != null) goto L15;
        return Boolean.FALSE;
    L15:
        return Boolean.valueOf(v3.a(r2));
    L9:
        return Boolean.FALSE;
    L5:
        return Boolean.FALSE;
    }

    public final long l() {
        if (r() == null) goto L25;
        List<n3> r0 = this.F;
        if (r0 != null) goto L7;
    L18:
        h2 r1 = u.f(r());
        if (r1 != null) goto L21;
        return 0;
    L21:
        if ((this instanceof com.bytedance.android.livesdk.gift.platform.business.tray.a) == true) goto L23;
        return 0;
    L23:
        return r1.getDiamondCount();
    L7:
        if (r0.size() <= 0) goto L18;
        int r2 = 0;
        long r3 = 0;
    L10:
        if (r2 >= this.F.size()) goto L16;
        h1 r5 = ((n3) ListProtector.get(this.F, r2)).getGift();
        if (r5 == null) goto L14;
        r3 = r3 + ((long) r5.getDiamondCount());
    L14:
        r2 = r2 + 1;
        goto L10
    L16:
        if (r3 == 0) goto L18;
        return r3;
    L25:
        if (n() == null) goto L29;
        return n().getPrice();
    L29:
        if (s() == null) goto L39;
        h1 r4 = s().getGift();
        if (r4 != null) goto L33;
        return 0;
    L33:
        return r4.getDiamondCount();
    L39:
        return 0;
    }

    @Override // v12.d
    public final String a() {
        return this.q;
    }

    @Override // v12.d
    public final boolean d() {
        return this.p;
    }

    @Override // v12.d
    public final long e() {
        return this.m;
    }

    @Override // v12.d
    public final String f() {
        return this.r;
    }

    @Override // v12.d
    public final String getDescription() {
        return this.c;
    }

    @Override // v12.d
    public final long getGiftId() {
        return this.b;
    }

    @Override // v12.d
    public final long getGroupCount() {
        return this.k;
    }

    @Override // v12.d
    public final long getGroupId() {
        return this.l;
    }

    @Override // v12.d
    public final long getMsgId() {
        return this.a;
    }

    @Override // v12.d
    public final IBaseUser getToUser() {
        return this.f;
    }

    @Override // v12.d
    public final boolean isLocal() {
        return this.v;
    }

    public final int c(NormalGiftMessage r3) {
        if (o().getPlayPriority() != r3.o().getPlayPriority()) goto L7;
        return (int) 0;
    L7:
        return r3.o().getPlayPriority() - o().getPlayPriority();
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(NormalGiftMessage r1) {
        return h(r1);
    }

    public final boolean equals(Object r2) {
        if (r2 != null) goto L6;
        return false;
    L6:
        return u().equals(((NormalGiftMessage) r2).u());
    }

    public final int g(NormalGiftMessage r8) {
        if (n() == null) goto L7;
        if (n().getPrice() <= 0) goto L7;
    L10:
        long r0 = r8.n().getPrice();
        long r2 = n().getPrice();
    L12:
        return (int) (r0 - r2);
    L7:
        if (r8.n() == null) goto L14;
        if (r8.n().getPrice() > 0) goto L10;
    L14:
        if (n().getPriority() == r8.n().getPriority()) goto L16;
        r0 = r8.n().getPriority();
        r2 = n().getPriority();
        goto L12
    L16:
        return (int) 0;
    }

    public int h(NormalGiftMessage r9) {
        if (r9 != null) goto L6;
        return 0;
    L6:
        if (n() == null) goto L12;
        if (r9.n() == null) goto L12;
        return g(r9);
    L12:
        if (o() != null) goto L14;
    L17:
        long r1 = getTotalMoney();
        long r3 = r9.getTotalMoney();
        if (this.v == true) goto L20;
        long r2 = r1 - r3;
    L22:
        if (r2 != 0) goto L40;
        if ((r9 instanceof l) == false) goto L27;
        return -1;
    L27:
        if (this.J == false) goto L37;
        String r4 = r9.I;
        if (r4 != null) goto L32;
        r4 = r9.u();
    L32:
        String r5 = this.I;
        if (r5 != null) goto L36;
        r5 = u();
    L36:
        int r6 = r4.compareTo(r5);
    L38:
        r2 = r6;
        goto L40
    L37:
        r6 = r9.u().compareTo(u());
    L40:
        if (r2 >= 0) goto L42;
        return 1;
    L42:
        if (r2 != 0) goto L52;
        long r7 = this.G;
        long r8 = r9.G;
        if (r7 <= r8) goto L46;
        return -1;
    L46:
        if (r7 >= r8) goto L49;
        return 1;
    L49:
        if (this.K == false) goto L51;
        return -1;
    L51:
        return 0;
    L52:
        return -1;
    L20:
        r2 = 0;
        goto L22
    L14:
        if (r9.o() == null) goto L17;
        return c(r9);
    }

    public final long t(boolean r8) {
        if (r() == null) goto L31;
        List<n3> r0 = this.F;
        if (r0 != null) goto L7;
    L18:
        h2 r1 = u.f(r());
        if (r1 != null) goto L21;
        return 0;
    L21:
        if ((this instanceof com.bytedance.android.livesdk.gift.platform.business.tray.a) == true) goto L23;
    L26:
        if (r8 == false) goto L28;
        long r2 = this.m * this.k;
        int r9 = r1.getDiamondCount();
    L44:
        return r2 * ((long) r9);
    L28:
        r2 = (this.m + ((long) this.n)) * this.k;
        r9 = r1.getDiamondCount();
        goto L44
    L23:
        if (b02.a.b(this) == true) goto L26;
        return r1.getDiamondCount();
    L7:
        if (r0.size() <= 0) goto L18;
        int r3 = 0;
        long r4 = 0;
    L10:
        if (r3 >= this.F.size()) goto L16;
        h1 r5 = ((n3) ListProtector.get(this.F, r3)).getGift();
        if (r5 == null) goto L14;
        r4 = r4 + ((long) r5.getDiamondCount());
    L14:
        r3 = r3 + 1;
        goto L10
    L16:
        if (r4 == 0) goto L18;
        return r4;
    L31:
        if (n() == null) goto L35;
        return n().getPrice();
    L35:
        if (s() == null) goto L45;
        h1 r10 = s().getGift();
        if (r10 != null) goto L39;
        return 0;
    L39:
        return r10.getDiamondCount();
    L45:
        return 0;
    }

    public final void w(NormalGiftMessage r6) {
        long r0 = r6.m - this.m;
        int r7 = this.n;
        long r1 = r0 - ((long) r7);
        if (r1 <= 0) goto L8;
        this.n = (int) (((long) r7) + r1);
        if (b.b() == null) goto L9;
        b.b().getGiftTrayTempComboUpdateEvent().post(Boolean.TRUE);
        return;
    L9:
        return;
    }

    public final void x(long r5) {
        this.y = (int) (((long) this.y) + (r5 - this.m));
        this.m = r5;
    }

    public NormalGiftMessage(long r5, long r7) {
        this.g = 1;
        this.i = false;
        this.j = new HashMap();
        this.k = 1;
        this.l = 0;
        this.n = 0;
        this.x = 0;
        this.y = 0;
        this.A = new LinkedHashMap();
        this.B = -1;
        this.C = new ArrayList();
        this.K = false;
        this.L = 0;
        this.M = false;
        this.Q = false;
        this.a = r5;
        this.b = r7;
    }

    public final void setTimeStampMap(int r2, long r3) {
        this.j.put(Integer.valueOf(r2), Long.valueOf(r3));
    }
}
