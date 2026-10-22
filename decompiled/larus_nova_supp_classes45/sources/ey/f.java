package ey;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class f {
    public final long a;
    public final int b;
    public final int c;
    public final int d;
    public final String e;
    public final String f;
    public final String g;

    public static final class a extends f {
        public a(long r11, int r12) {
            Intrinsics.checkNotNullParameter("", "linkMicId");
            Intrinsics.checkNotNullParameter("", "rtcInfo");
            super(r11, r12, 3, 3, "", "", "Applying");
        }
    }

    public static final class b extends f {
        public b(long r11, int r12, int r13, String r14, String r15) {
            Intrinsics.checkNotNullParameter(r14, "linkMicId");
            Intrinsics.checkNotNullParameter(r15, "rtcInfo");
            super(r11, r12, r13, 2, r14, r15, "BeInviting");
        }
    }

    public static final class c {
    }

    public static final class d extends f {
        public d() {
            this(0);
        }

        public d(int r11) {
            Intrinsics.checkNotNullParameter("", "linkMicId");
            Intrinsics.checkNotNullParameter("", "rtcInfo");
            super(0, 0, 0, 0, "", "", "Disable");
        }
    }

    public static final class e extends f {
        public e(long r11, int r12, int r13, String r14, String r15) {
            Intrinsics.checkNotNullParameter(r14, "linkMicId");
            Intrinsics.checkNotNullParameter(r15, "rtcInfo");
            super(r11, r12, r13, 1, r14, r15, "Inviting");
        }
    }

    /* JADX INFO: renamed from: ey.f$f, reason: collision with other inner class name */
    public static final class C0229f extends f {
        public C0229f(long r11, int r12, int r13, String r14, String r15) {
            Intrinsics.checkNotNullParameter(r14, "linkMicId");
            Intrinsics.checkNotNullParameter(r15, "rtcInfo");
            super(r11, r12, r13, 4, r14, r15, "Linking");
        }
    }

    static {
    }

    public final String toString() {
        return this.g + "(channelId=" + this.a + ", scene=" + this.b + ", bizType=" + this.c + ", state=" + this.d + ", linkMicId='" + this.e + "', name='" + this.g + "')";
    }

    public f(long r1, int r3, int r4, int r5, String r6, String r7, String r8) {
        this.a = r1;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
    }
}
