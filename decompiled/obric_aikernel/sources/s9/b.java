package s9;

import android.graphics.Bitmap;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static b f12766d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f12767e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f12768a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f12769b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Bitmap[] f12770c;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final b a(String r10) {
            Intrinsics.checkNotNullParameter(r10, "letter");
            return new b(0, r10, null, 0 == true ? 1 : 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final b b(String r10) {
            Intrinsics.checkNotNullParameter(r10, "letter");
            return new b(1, r10, null, 0 == true ? 1 : 0);
        }

        public final b c(String r10, Bitmap[] r11) {
            Intrinsics.checkNotNullParameter(r10, "symbol");
            Intrinsics.checkNotNullParameter(r11, "letterBitmaps");
            return new b(2, r10, r11, null);
        }

        public final b d() {
            return b.a();
        }
    }

    static {
        a r10 = new a(null);
        f12767e = r10;
        f12766d = r10.a("#");
    }

    private b(int r10, String r11, Bitmap[] r12) {
        this.f12768a = r10;
        this.f12769b = r11;
        this.f12770c = r12;
        if (r10 != 2) goto L15;
        boolean r13 = false;
        if (r12 == null) goto L7;
        int r14 = r12.length;
    L9:
        if (r14 != 3) goto L11;
        r13 = true;
    L11:
        if (r13 == false) goto L14;
        this.f12770c = r12;
        return;
    L14:
        throw new IllegalStateException("symbol must have 3 bitmaps!".toString());
    L7:
        r14 = 0;
        goto L9
    }

    public /* synthetic */ b(int r10, String r11, Bitmap[] r12, DefaultConstructorMarker r13) {
        this(r10, r11, r12);
    }

    public static final /* synthetic */ b a() {
        return f12766d;
    }

    public final String b() {
        return this.f12769b;
    }

    public final Bitmap[] c() {
        return this.f12770c;
    }

    public final int d() {
        return this.f12768a;
    }
}
