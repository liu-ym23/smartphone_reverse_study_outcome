package jd2;

import com.bytedance.android.live.anchormodelink.impl.AnchorModeLinkDynamicWidget;
import com.bytedance.android.live.liveinteract.videotalk.utils.t;
import com.bytedance.android.livesdk.ktvapi.model.VideoChorusSource;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g {
    public final boolean a;
    public final boolean b;
    public final boolean c;
    public final int d;
    public final int e;
    public final String f;
    public final h80.a<Boolean> g;
    public final h80.a<Boolean> h;

    public static final class a<T> implements h80.a {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Boolean r2 = (Boolean) r1;
        }
    }

    public static final class b<T> implements h80.a {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Boolean r2 = (Boolean) r1;
        }
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof g) == false) goto L22;
        g r4 = (g) r3;
        if (this.a == r4.a) goto L8;
        return false;
    L8:
        if (this.b == r4.b) goto L10;
        return false;
    L10:
        if (this.c == r4.c) goto L12;
        return false;
    L12:
        if (this.d == r4.d) goto L14;
        return false;
    L14:
        if (this.e == r4.e) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f, r4.f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.g, r4.g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.h, r4.h) == true) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    public final int hashCode() {
        boolean r0 = this.a;
        ?? r1 = 1;
        ?? r2 = r0;
        if (r0 == false) goto L5;
        r2 = 1;
    L5:
        int r3 = r2 * 31;
        boolean r4 = this.b;
        ?? r5 = r4;
        if (r4 == false) goto L8;
        r5 = 1;
    L8:
        int r6 = (r3 + r5) * 31;
        boolean r7 = this.c;
        if (r7 == true) goto L12;
        r1 = r7;
    L12:
        int r8 = (((((r6 + r1) * 31) + this.d) * 31) + this.e) * 31;
        String r9 = this.f;
        int r10 = 0;
        if (r9 == null) goto L15;
        int r11 = r9.hashCode();
    L16:
        int r13 = (r8 + r11) * 31;
        h80.a<Boolean> r14 = this.g;
        if (r14 == null) goto L19;
        int r15 = r14.hashCode();
    L20:
        int r16 = (r13 + r15) * 31;
        h80.a<Boolean> r17 = this.h;
        if (r17 == null) goto L24;
        r10 = r17.hashCode();
    L24:
        return r16 + r10;
    L19:
        r15 = 0;
        goto L20
    L15:
        r11 = 0;
        goto L16
    }

    public final String toString() {
        return "VideoChorusToggleModel(isEnable=" + this.a + ", showConfirmDialog=" + this.b + ", closeInteract=" + this.c + ", scene=" + this.d + ", uiLayout=" + this.e + ", source=" + this.f + ", callback=" + this.g + ", closeInteractCallback=" + this.h + ")";
    }

    public /* synthetic */ g(boolean r13, boolean r14, int r15, int r16, String r17, t r18, AnchorModeLinkDynamicWidget.f.a r19, int r20) {
        if ((r20 & 2) == 0) goto L5;
        boolean r5 = true;
    L7:
        if ((r20 & 4) == 0) goto L9;
        boolean r6 = false;
    L11:
        if ((r20 & 8) == 0) goto L13;
        int r7 = 0;
    L15:
        if ((r20 & 16) == 0) goto L17;
        int r8 = 0;
    L19:
        if ((r20 & 32) == 0) goto L21;
        String r9 = VideoChorusSource.UNKNOWN.getValue();
    L23:
        if ((r20 & 64) == 0) goto L25;
        t r10 = a.a;
    L27:
        if ((r20 & 128) == 0) goto L29;
        AnchorModeLinkDynamicWidget.f.a r11 = b.a;
    L30:
        this(r13, r5, r6, r7, r8, r9, r10, r11);
        return;
    L29:
        r11 = r19;
        goto L30
    L25:
        r10 = r18;
        goto L27
    L21:
        r9 = r17;
        goto L23
    L17:
        r8 = r16;
        goto L19
    L13:
        r7 = r15;
        goto L15
    L9:
        r6 = r14;
        goto L11
    L5:
        r5 = false;
        goto L7
    }

    public g(boolean r2, boolean r3, boolean r4, int r5, int r6, String r7, h80.a<Boolean> r8, h80.a<Boolean> r9) {
        Intrinsics.checkNotNullParameter(r7, "source");
        Intrinsics.checkNotNullParameter(r8, "callback");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
    }
}
