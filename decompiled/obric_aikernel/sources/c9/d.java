package c9;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f643a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f644b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f645c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f646d;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f647a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f648b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f649c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f650d;

        public a() {
            this.f647a = "";
            this.f649c = "";
        }

        public final d a() {
            return new d(this.f647a, this.f648b, this.f649c, this.f650d, null);
        }

        public final a b(String r10) {
            Intrinsics.checkNotNullParameter(r10, "pkgName");
            this.f647a = r10;
            return this;
        }

        public final a c(int r10) {
            this.f648b = r10;
            return this;
        }

        public final a d(String r10) {
            Intrinsics.checkNotNullParameter(r10, "versionName");
            this.f649c = r10;
            return this;
        }
    }

    private d(String r10, int r11, String r12, boolean r13) {
        this.f643a = r10;
        this.f644b = r11;
        this.f645c = r12;
        this.f646d = r13;
    }

    public /* synthetic */ d(String r10, int r11, String r12, boolean r13, DefaultConstructorMarker r14) {
        this(r10, r11, r12, r13);
    }

    public final String a() {
        return this.f643a;
    }

    public final int b() {
        return this.f644b;
    }

    public final String c() {
        return this.f645c;
    }

    public final boolean d() {
        return this.f646d;
    }
}
