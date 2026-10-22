package mc;

import androidx.core.view.PointerIconCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;

/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f11143a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int[] f11144b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final byte[] f11145c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final a f11146d = null;

    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final a[] f11147a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f11148b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f11149c;

        public a() {
            this.f11147a = new a[256];
            this.f11148b = 0;
            this.f11149c = 0;
        }

        public a(int r10, int r11) {
            this.f11147a = null;
            this.f11148b = r10;
            int r12 = r11 & 7;
            if (r12 != 0) goto L5;
            r12 = 8;
        L5:
            this.f11149c = r12;
        }

        public final a[] a() {
            return this.f11147a;
        }

        public final int b() {
            return this.f11148b;
        }

        public final int c() {
            return this.f11149c;
        }
    }

    static {
        f11143a = new e();
        f11144b = new int[]{8184, 8388568, 268435426, 268435427, 268435428, 268435429, 268435430, 268435431, 268435432, 16777194, 1073741820, 268435433, 268435434, 1073741821, 268435435, 268435436, 268435437, 268435438, 268435439, 268435440, 268435441, 268435442, 1073741822, 268435443, 268435444, 268435445, 268435446, 268435447, 268435448, 268435449, 268435450, 268435451, 20, PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW, PointerIconCompat.TYPE_TOP_LEFT_DIAGONAL_DOUBLE_ARROW, 4090, 8185, 21, 248, 2042, PointerIconCompat.TYPE_ZOOM_IN, PointerIconCompat.TYPE_ZOOM_OUT, 249, 2043, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 22, 23, 24, 0, 1, 2, 25, 26, 27, 28, 29, 30, 31, 92, 251, 32764, 32, 4091, PointerIconCompat.TYPE_GRAB, 8186, 33, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 252, 115, 253, 8187, 524272, 8188, 16380, 34, 32765, 3, 35, 4, 36, 5, 37, 38, 39, 6, 116, 117, 40, 41, 42, 7, 43, 118, 44, 8, 9, 45, 119, 120, 121, 122, 123, 32766, 2044, 16381, 8189, 268435452, 1048550, 4194258, 1048551, 1048552, 4194259, 4194260, 4194261, 8388569, 4194262, 8388570, 8388571, 8388572, 8388573, 8388574, 16777195, 8388575, 16777196, 16777197, 4194263, 8388576, 16777198, 8388577, 8388578, 8388579, 8388580, 2097116, 4194264, 8388581, 4194265, 8388582, 8388583, 16777199, 4194266, 2097117, 1048553, 4194267, 4194268, 8388584, 8388585, 2097118, 8388586, 4194269, 4194270, 16777200, 2097119, 4194271, 8388587, 8388588, 2097120, 2097121, 4194272, 2097122, 8388589, 4194273, 8388590, 8388591, 1048554, 4194274, 4194275, 4194276, 8388592, 4194277, 4194278, 8388593, 67108832, 67108833, 1048555, 524273, 4194279, 8388594, 4194280, 33554412, 67108834, 67108835, 67108836, 134217694, 134217695, 67108837, 16777201, 33554413, 524274, 2097123, 67108838, 134217696, 134217697, 67108839, 134217698, 16777202, 2097124, 2097125, 67108840, 67108841, 268435453, 134217699, 134217700, 134217701, 1048556, 16777203, 1048557, 2097126, 4194281, 2097127, 2097128, 8388595, 4194282, 4194283, 33554414, 33554415, 16777204, 16777205, 67108842, 8388596, 67108843, 134217702, 67108844, 67108845, 134217703, 134217704, 134217705, 134217706, 134217707, 268435454, 134217708, 134217709, 134217710, 134217711, 134217712, 67108846};
        byte[] r10 = {13, 23, 28, 28, 28, 28, 28, 28, 28, 24, 30, 28, 28, 30, 28, 28, 28, 28, 28, 28, 28, 28, 30, 28, 28, 28, 28, 28, 28, 28, 28, 28, 6, 10, 10, 12, 13, 6, 8, 11, 10, 10, 8, 11, 8, 6, 6, 6, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 7, 8, 15, 6, 12, 10, 13, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 7, 8, 13, 19, 13, 14, 6, 15, 5, 6, 5, 6, 5, 6, 6, 6, 5, 7, 7, 6, 6, 6, 5, 6, 7, 6, 5, 5, 6, 7, 7, 7, 7, 7, 15, 11, 14, 13, 28, 20, 22, 20, 20, 22, 22, 22, 23, 22, 23, 23, 23, 23, 23, 24, 23, 24, 24, 22, 23, 24, 23, 23, 23, 23, 21, 22, 23, 22, 23, 23, 24, 22, 21, 20, 22, 22, 23, 23, 21, 23, 22, 22, 24, 21, 22, 23, 23, 21, 21, 22, 21, 23, 22, 23, 23, 20, 22, 22, 22, 23, 22, 22, 23, 26, 26, 20, 19, 22, 23, 22, 25, 26, 26, 26, 27, 27, 26, 24, 25, 19, 21, 26, 27, 27, 26, 27, 24, 21, 21, 26, 26, 28, 27, 27, 27, 20, 24, 20, 21, 22, 21, 21, 23, 22, 22, 25, 25, 24, 24, 26, 23, 26, 27, 26, 26, 27, 27, 27, 27, 27, 28, 27, 27, 27, 27, 27, 26};
        f11145c = r10;
        f11146d = new a();
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        f11143a.a(r12, f11144b[r12], f11145c[r12]);
        r12 = r12 + 1;
        goto L3
    }

    private e() {
    }

    private final void a(int r10, int r11, int r12) {
        a r13 = new a(r10, r12);
        a r14 = f11146d;
    L4:
        if (r12 <= 8) goto L9;
        r12 = r12 - 8;
        int r15 = (r11 >>> r12) & 255;
        a[] r16 = r14.a();
        Intrinsics.checkNotNull(r16);
        a r17 = r16[r15];
        if (r17 != null) goto L8;
        r17 = new a();
        r16[r15] = r17;
    L8:
        r14 = r17;
        goto L4
    L9:
        int r18 = 8 - r12;
        int r19 = (r11 << r18) & 255;
        a[] r20 = r14.a();
        Intrinsics.checkNotNull(r20);
        ArraysKt.fill(r20, r13, r19, (1 << r18) + r19);
    }

    public final void b(okio.f r10, long r11, okio.e r12) {
        Intrinsics.checkNotNullParameter(r10, "source");
        Intrinsics.checkNotNullParameter(r12, "sink");
        a r13 = f11146d;
        int r14 = 0;
        long r15 = 0;
        int r16 = 0;
    L4:
        if (r15 >= r11) goto L13;
        r14 = (r14 << 8) | hc.e.d(r10.readByte(), 255);
        r16 = r16 + 8;
    L7:
        if (r16 < 8) goto L12;
        a[] r17 = r13.a();
        Intrinsics.checkNotNull(r17);
        r13 = r17[(r14 >>> (r16 - 8)) & 255];
        Intrinsics.checkNotNull(r13);
        if (r13.a() == null) goto L10;
        r16 = r16 - 8;
        goto L7
    L10:
        r12.writeByte(r13.b());
        r16 = r16 - r13.c();
        r13 = f11146d;
        goto L7
    L12:
        r15 = r15 + 1;
    L13:
        if (r16 <= 0) goto L31;
        a[] r18 = r13.a();
        Intrinsics.checkNotNull(r18);
        a r19 = r18[(r14 << (8 - r16)) & 255];
        Intrinsics.checkNotNull(r19);
        if (r19.a() != null) goto L32;
        if (r19.c() > r16) goto L20;
        r12.writeByte(r19.b());
        r16 = r16 - r19.c();
        r13 = f11146d;
        goto L13
    L20:
        return;
    L32:
        return;
    }

    public final void c(ByteString r10, okio.e r11) {
        Intrinsics.checkNotNullParameter(r10, "source");
        Intrinsics.checkNotNullParameter(r11, "sink");
        int r12 = r10.size();
        int r13 = 0;
        long r14 = 0;
        int r15 = 0;
    L3:
        if (r13 >= r12) goto L9;
        int r16 = hc.e.d(r10.getByte(r13), 255);
        int r17 = f11144b[r16];
        byte r18 = f11145c[r16];
        r14 = (r14 << r18) | ((long) r17);
        r15 = r15 + r18;
    L6:
        if (r15 < 8) goto L8;
        r15 = r15 - 8;
        r11.writeByte((int) (r14 >> r15));
        goto L6
    L8:
        r13 = r13 + 1;
        goto L3
    L9:
        if (r15 <= 0) goto L14;
        r11.writeByte((int) ((r14 << (8 - r15)) | (255 >>> r15)));
        return;
    }

    public final int d(ByteString r10) {
        Intrinsics.checkNotNullParameter(r10, "bytes");
        int r11 = r10.size();
        long r12 = 0;
        int r13 = 0;
    L3:
        if (r13 >= r11) goto L6;
        int r14 = hc.e.d(r10.getByte(r13), 255);
        r12 = r12 + ((long) f11145c[r14]);
        r13 = r13 + 1;
        goto L3
    L6:
        return (int) ((r12 + ((long) 7)) >> 3);
    }
}
