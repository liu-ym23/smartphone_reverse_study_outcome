package fd2;

import com.bytedance.android.livesdk.message.model.KtvMusic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public abstract class y {

    public static final class a extends y {
        public final KtvMusic a;

        @Override // fd2.y
        public final Long a() {
            KtvMusic.a r0 = KtvMusic.Companion;
            KtvMusic r1 = this.a;
            r0.getClass();
            return Long.valueOf(KtvMusic.a.a(r1) * 1000);
        }

        public final int hashCode() {
            KtvMusic r0 = this.a;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.hashCode();
        }

        public final String toString() {
            return "CountDown(music=" + this.a + ")";
        }

        @Override // fd2.y
        public final KtvMusic b() {
            return this.a;
        }

        public a(KtvMusic r2) {
            Intrinsics.checkNotNullParameter(r2, "music");
            this.a = r2;
        }

        public final boolean equals(Object r2) {
            if (this != r2) goto L4;
            return true;
        L4:
            if ((r2 instanceof a) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.a, ((a) r2).a) == true) goto L13;
            return false;
        L13:
            return true;
        }
    }

    public static final class b extends y {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }
    }

    public static final class c extends y {
        public final KtvMusic a;
        public final long b;

        @Override // fd2.y
        public final Long a() {
            return Long.valueOf(this.b);
        }

        public final int hashCode() {
            KtvMusic r0 = this.a;
            if (r0 == null) goto L5;
            int r1 = r0.hashCode();
        L6:
            long r2 = a().longValue();
            return (r1 * 31) + ((int) (r2 ^ (r2 >>> 32)));
        L5:
            r1 = 0;
            goto L6
        }

        public final String toString() {
            return "Paused(music=" + this.a + ", durationLeft=" + a() + ")";
        }

        @Override // fd2.y
        public final KtvMusic b() {
            return this.a;
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L4;
            return true;
        L4:
            if ((r5 instanceof c) == false) goto L10;
            c r6 = (c) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L8;
            return false;
        L8:
            if (a().longValue() == r6.a().longValue()) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public c(KtvMusic r2, long r3) {
            Intrinsics.checkNotNullParameter(r2, "music");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class d extends y {
        public KtvMusic a;
        public long b;

        @Override // fd2.y
        public final Long a() {
            return Long.valueOf(this.b);
        }

        @Override // fd2.y
        public final KtvMusic b() {
            return this.a;
        }

        public d(KtvMusic r2, long r3) {
            Intrinsics.checkNotNullParameter(r2, "music");
            this.a = r2;
            this.b = r3;
        }
    }

    public y() {
    }

    public Long a() {
        return null;
    }

    public KtvMusic b() {
        return null;
    }
}
