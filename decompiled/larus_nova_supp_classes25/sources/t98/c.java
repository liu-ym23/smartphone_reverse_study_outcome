package t98;

import com.larus.avlink.gallery.power.policy.AlbumPowerLevel;
import com.larus.avlink.gallery.power.policy.AlbumThermalLevel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class c {

    public static final class a {
    }

    public static final class b {
        public final AlbumPowerLevel a;
        public final int b;
        public final String c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.a.hashCode() * 31) + this.b) * 31) + this.c.hashCode();
        }

        public final String toString() {
            return "PolicyLane(level=" + this.a + ", threadCount=" + this.b + ", reason=" + this.c + ')';
        }

        public b(AlbumPowerLevel r2, int r3, String r4) {
            Intrinsics.checkNotNullParameter(r2, "level");
            Intrinsics.checkNotNullParameter(r4, "reason");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    /* JADX INFO: renamed from: t98.c$c, reason: collision with other inner class name */
    public /* synthetic */ class C0085c {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[AlbumThermalLevel.values().length];
            r0[AlbumThermalLevel.CRITICAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L23:
            r0[AlbumThermalLevel.EMERGENCY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L35:
            r0[AlbumThermalLevel.SHUTDOWN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L25:
            r0[AlbumThermalLevel.SEVERE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L27:
            r0[AlbumThermalLevel.MODERATE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L21:
            r0[AlbumThermalLevel.LIGHT.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L29:
            r0[AlbumThermalLevel.NONE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L31:
            r0[AlbumThermalLevel.UNKNOWN.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L11:
            a = r0;
        }
    }

    static {
    }

    public c() {
    }
}
