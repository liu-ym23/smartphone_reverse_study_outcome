package w8;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f13415a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f13416b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f13417c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f13418d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f13419e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f13420f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f13421g;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f13422a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f13423b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f13424c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f13425d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f13426e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private String f13427f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private String f13428g;

        public a() {
            this.f13422a = "";
            this.f13424c = "";
            this.f13426e = "";
            this.f13427f = "";
            this.f13428g = "";
        }

        public final d a() {
            return new d(this.f13422a, this.f13423b, this.f13424c, this.f13425d, this.f13426e, this.f13427f, this.f13428g, null);
        }

        public final a b(String r10) {
            Intrinsics.checkNotNullParameter(r10, "clientPkgName");
            this.f13428g = r10;
            return this;
        }

        public final a c(int r10) {
            this.f13425d = r10;
            return this;
        }

        public final a d(String r10) {
            Intrinsics.checkNotNullParameter(r10, "pkgName");
            this.f13422a = r10;
            return this;
        }
    }

    private d(String r10, int r11, String r12, int r13, String r14, String r15, String r16) {
        this.f13415a = r10;
        this.f13416b = r11;
        this.f13417c = r12;
        this.f13418d = r13;
        this.f13419e = r14;
        this.f13420f = r15;
        this.f13421g = r16;
    }

    public /* synthetic */ d(String r10, int r11, String r12, int r13, String r14, String r15, String r16, DefaultConstructorMarker r17) {
        this(r10, r11, r12, r13, r14, r15, r16);
    }

    public final String a() {
        return this.f13421g;
    }

    public final int b() {
        return this.f13418d;
    }

    public final String c() {
        return this.f13420f;
    }

    public final String d() {
        return this.f13415a;
    }

    public final String e() {
        return this.f13419e;
    }

    public String toString() {
        return "DownloadConfig(pkgName='" + this.f13415a + "', versionCode=" + this.f13416b + ", versionName='" + this.f13417c + "', concurrentNum=" + this.f13418d + ", receiverClassName='" + this.f13419e + "',clientPkgName='" + this.f13421g + "')";
    }
}
