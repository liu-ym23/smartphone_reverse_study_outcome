package com.bytedance.ai.model.objects;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.LruCache;
import cn.nubia.neopush.commons.Constant;
import com.bytedance.ai.ex.widget.model.MiniAppWidgetAvailability;
import com.bytedance.ai.resource.e0;
import com.bytedance.ai.resource.f0;
import com.bytedance.ai.resource.j;
import com.bytedance.ai.utils.c;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import t0.d;
import w2.a;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001:\u0004\u0002\u0003\u0004\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ai/model/objects/AIPackage;", "Landroid/os/Parcelable;", "ym/a", "AIPackageType", "PackageStatus", "w2/a", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class AIPackage implements Parcelable {
    public boolean A;
    public String B;
    public String C;
    public final AtomicInteger D;
    public transient WeakReference E;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2258a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f2259b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f2260c;
    public final String d;
    public final String e;
    public final String f;
    public final Icons g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f2261h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f2262i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f2263j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final List f2264k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f2265l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f2266m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f2267n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f2268o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f2269p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f2270q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f2271r;
    public long s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f2272t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public long f2273u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f2274v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Integer f2275w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f2276x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public PackageStatus f2277y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f2278z;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ai/model/objects/AIPackage$AIPackageType;", "", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final enum AIPackageType extends Enum<AIPackageType> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final AIPackageType f2279a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final AIPackageType f2280b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final AIPackageType f2281c = null;
        public static final /* synthetic */ AIPackageType[] d = null;

        static {
            AIPackageType r5 = new AIPackageType("APPLET", 0);
            f2279a = r5;
            AIPackageType r10 = new AIPackageType("WIDGET", 1);
            f2280b = r10;
            AIPackageType r11 = new AIPackageType("UNKNOWN", 2);
            f2281c = r11;
            AIPackageType[] r12 = {r5, r10, r11};
            d = r12;
            EnumEntriesKt.enumEntries(r12);
        }

        public AIPackageType(String r5, int r10) {
            super(r5, r10);
        }

        public static AIPackageType valueOf(String r5) {
            return (AIPackageType) Enum.valueOf(AIPackageType.class, r5);
        }

        public static AIPackageType[] values() {
            return (AIPackageType[]) d.clone();
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ai/model/objects/AIPackage$PackageStatus;", "", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final enum PackageStatus extends Enum<PackageStatus> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final PackageStatus f2282a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final PackageStatus f2283b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final PackageStatus f2284c = null;
        public static final PackageStatus d = null;
        public static final /* synthetic */ PackageStatus[] e = null;

        static {
            PackageStatus r5 = new PackageStatus("READY", 0);
            f2282a = r5;
            PackageStatus r10 = new PackageStatus("UPDATING", 1);
            f2283b = r10;
            PackageStatus r11 = new PackageStatus(MiniAppWidgetAvailability.INSTALL_STATE_INSTALLING, 2);
            f2284c = r11;
            PackageStatus r12 = new PackageStatus("DELETING", 3);
            d = r12;
            PackageStatus[] r13 = {r5, r10, r11, r12};
            e = r13;
            EnumEntriesKt.enumEntries(r13);
        }

        public PackageStatus(String r5, int r10) {
            super(r5, r10);
        }

        public static PackageStatus valueOf(String r5) {
            return (PackageStatus) Enum.valueOf(PackageStatus.class, r5);
        }

        public static PackageStatus[] values() {
            return (PackageStatus[]) e.clone();
        }
    }

    public AIPackage(String r5, String r10, long r11, String r12, String r13, String r14, Icons r15, String r16, String r17, String r18, List r19, String r110) {
        Intrinsics.checkNotNullParameter(r5, "name");
        Intrinsics.checkNotNullParameter(r10, "packageName");
        Intrinsics.checkNotNullParameter(r13, "versionName");
        Intrinsics.checkNotNullParameter(r14, Constant.DESCRIPTION);
        Intrinsics.checkNotNullParameter(r16, "manifestVersion");
        Intrinsics.checkNotNullParameter(r17, "prop");
        Intrinsics.checkNotNullParameter(r18, "recommend");
        Intrinsics.checkNotNullParameter(r110, "appGroup");
        this.f2258a = r5;
        this.f2259b = r10;
        this.f2260c = r11;
        this.d = r12;
        this.e = r13;
        this.f = r14;
        this.g = r15;
        this.f2261h = r16;
        this.f2262i = r17;
        this.f2263j = r18;
        this.f2264k = r19;
        this.f2265l = r110;
        this.f2267n = "";
        this.f2268o = "";
        this.f2274v = "";
        this.f2275w = 0;
        this.f2277y = PackageStatus.f2282a;
        this.C = "";
        this.D = new AtomicInteger(0);
    }

    public abstract String c();

    public final void d(Parcel r5) {
        Intrinsics.checkNotNullParameter(r5, "parcel");
        this.f2266m = r5.readLong();
        String r10 = r5.readString();
        String r11 = "";
        if (r10 != null) goto L5;
        r10 = "";
    L5:
        this.f2267n = r10;
        String r12 = r5.readString();
        if (r12 != null) goto L8;
        r12 = "";
    L8:
        this.f2268o = r12;
        this.f2269p = r5.readLong();
        this.f2270q = r5.readLong();
        this.f2271r = r5.readLong();
        this.s = r5.readLong();
        this.f2272t = r5.readLong();
        this.f2273u = r5.readLong();
        String r13 = r5.readString();
        if (r13 != null) goto L11;
        r13 = "";
    L11:
        this.f2274v = r13;
        this.f2275w = Integer.valueOf(r5.readInt());
        this.f2276x = r5.readString();
        this.f2277y = PackageStatus.values()[r5.readInt()];
        boolean r14 = false;
        if (r5.readByte() == 0) goto L14;
        boolean r15 = true;
    L15:
        this.f2278z = r15;
        if (r5.readByte() == 0) goto L18;
        r14 = true;
    L18:
        this.A = r14;
        this.B = r5.readString();
        String r16 = r5.readString();     // Catch: Exception -> L23
        if (r16 == null) goto L27;
        r11 = r16;
    L27:
        this.C = r11;
        return;
    L23:
        e = move-exception;
        String r17 = "read runtimeVersion from parcel exception: " + e;
        Intrinsics.checkNotNullParameter("AIPackage", "tag");
        d r18 = c.f2846a;
        if (r18 == null) goto L27;
        r18.d("AIPackage", r17);
        goto L27
    L14:
        r15 = false;
        goto L15
    }

    public abstract AIPackageType e();

    public abstract String f();

    public final void g() {
        this.D.incrementAndGet();
        String r5 = "-------AIPackage " + e() + ' ' + hashCode() + ": " + this.f2259b + ' ' + c() + " markInUse: " + this.D.get();
        Intrinsics.checkNotNullParameter("AIManager", "tag");
        d r10 = c.f2846a;
        if (r10 == null) goto L5;
        r10.d("AIManager", r5);
    L5:
        WeakReference r11 = this.E;
        if (r11 == null) goto L31;
        a r12 = (a) r11.get();
        if (r12 == null) goto L34;
        String r13 = this.f2259b;
        String r14 = c();
        f0 r15 = (f0) r12;
        Intrinsics.checkNotNullParameter(r13, "packageName");
        Intrinsics.checkNotNullParameter(r14, Constant.APPID);
        if (Intrinsics.areEqual(r13, r15.f2717a) == true) goto L12;
        return;
    L12:
        if (r15.f2720h == false) goto L36;
        monitor-enter(r15);
    L24:
        th = move-exception;
        throw th;
    L15:
        if (r15.f2720h == false) goto L26;
        r15.d.incrementAndGet();     // Catch: Throwable -> L24
        if (r15.f2719c == false) goto L21;
        Intrinsics.checkNotNullParameter(r13, "packageName");     // Catch: Throwable -> L24
        Intrinsics.checkNotNullParameter(r14, Constant.APPID);     // Catch: Throwable -> L24
        if (com.bytedance.ai.multiprocess.d.f2406a == null) goto L21;
        Intrinsics.checkNotNullParameter(r13, "packageName");     // Catch: Throwable -> L24
        Intrinsics.checkNotNullParameter(r14, Constant.APPID);     // Catch: Throwable -> L24
        com.bytedance.ai.process.resource.d.b(r13, r14);     // Catch: Throwable -> L24
    L21:
        String r16 = "-------PackageInfoWithSession " + r15.hashCode() + ": " + r13 + " markInUse: " + r15.d.get() + ", isClient:" + r15.f2719c;     // Catch: Throwable -> L24
        Intrinsics.checkNotNullParameter("AIManager", "tag");     // Catch: Throwable -> L24
        d r17 = c.f2846a;     // Catch: Throwable -> L24
        if (r17 == null) goto L26;
        r17.d("AIManager", r16);     // Catch: Throwable -> L24
    L26:
        Unit r18 = Unit.INSTANCE;     // Catch: Throwable -> L24
        monitor-exit(r15);
        return;
    L36:
        return;
    L34:
        return;
    }

    public final void h() {
        this.D.decrementAndGet();
        String r5 = "-------AIPackage " + e() + ' ' + hashCode() + ": " + this.f2259b + ' ' + c() + " markOutOfUse: " + this.D.get();
        Intrinsics.checkNotNullParameter("AIManager", "tag");
        d r10 = c.f2846a;
        if (r10 == null) goto L5;
        r10.d("AIManager", r5);
    L5:
        WeakReference r11 = this.E;
        if (r11 == null) goto L39;
        a r12 = (a) r11.get();
        if (r12 == null) goto L42;
        String r13 = this.f2259b;
        String r14 = c();
        f0 r15 = (f0) r12;
        Intrinsics.checkNotNullParameter(r13, "packageName");
        Intrinsics.checkNotNullParameter(r14, Constant.APPID);
        if (Intrinsics.areEqual(r13, r15.f2717a) == true) goto L12;
        return;
    L12:
        if (r15.f2720h == false) goto L44;
        monitor-enter(r15);
    L24:
        th = move-exception;
        throw th;
    L15:
        if (r15.f2720h == false) goto L34;
        int r16 = r15.d.decrementAndGet();     // Catch: Throwable -> L24
        if (r15.f2719c == false) goto L21;
        Intrinsics.checkNotNullParameter(r13, "packageName");     // Catch: Throwable -> L24
        Intrinsics.checkNotNullParameter(r14, Constant.APPID);     // Catch: Throwable -> L24
        if (com.bytedance.ai.multiprocess.d.f2406a == null) goto L21;
        Intrinsics.checkNotNullParameter(r13, "packageName");     // Catch: Throwable -> L24
        Intrinsics.checkNotNullParameter(r14, Constant.APPID);     // Catch: Throwable -> L24
        com.bytedance.ai.process.resource.d.d(r13, r14);     // Catch: Throwable -> L24
    L21:
        String r17 = "-------PackageInfoWithSession " + r15.hashCode() + ": " + r13 + " markOutOfUse: " + r15.d.get() + ", isClient:" + r15.f2719c;     // Catch: Throwable -> L24
        Intrinsics.checkNotNullParameter("AIManager", "tag");     // Catch: Throwable -> L24
        d r18 = c.f2846a;     // Catch: Throwable -> L24
        if (r18 == null) goto L26;
        r18.d("AIManager", r17);     // Catch: Throwable -> L24
    L26:
        if (r16 != 0) goto L34;
        if (r15.f2718b == true) goto L34;
        r15.f2720h = false;     // Catch: Throwable -> L24
        LruCache r19 = e0.f2711a;     // Catch: Throwable -> L24
        e0.j(r15.e);     // Catch: Throwable -> L24
        WeakReference r20 = r15.g;     // Catch: Throwable -> L24
        if (r20 == null) goto L34;
        if (((com.bytedance.ai.resource.d) r20.get()) == null) goto L34;
        String r21 = r15.f2717a;     // Catch: Throwable -> L24
        Intrinsics.checkNotNullParameter(r21, "packageName");     // Catch: Throwable -> L24
        j.f2736c.remove(r21);     // Catch: Throwable -> L24
        j.q(r21);     // Catch: Throwable -> L24
    L34:
        Unit r22 = Unit.INSTANCE;     // Catch: Throwable -> L24
        monitor-exit(r15);
        return;
    L44:
        return;
    L42:
        return;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "parcel");
        r5.writeLong(this.f2266m);
        r5.writeString(this.f2267n);
        r5.writeString(this.f2268o);
        r5.writeLong(this.f2269p);
        r5.writeLong(this.f2270q);
        r5.writeLong(this.f2271r);
        r5.writeLong(this.s);
        r5.writeLong(this.f2272t);
        r5.writeLong(this.f2273u);
        r5.writeString(this.f2274v);
        Integer r11 = this.f2275w;
        if (r11 == null) goto L5;
        int r12 = r11.intValue();
    L6:
        r5.writeInt(r12);
        r5.writeString(this.f2276x);
        r5.writeInt(this.f2277y.ordinal());
        r5.writeByte(this.f2278z ? 1 : 0);
        r5.writeByte(this.A ? 1 : 0);
        r5.writeString(this.B);
        r5.writeString(this.C);
        return;
    L5:
        r12 = 0;
        goto L6
    }
}
