package uc2;

import com.bytedance.android.livesdk.interactivity.zdanmaku.layout.danmakuline.IHeatChangeController;
import java.util.Random;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h extends uc2.b {
    public final a g;
    public final Random h;
    public final b i;
    public final IHeatChangeController j;

    public static final class a implements com.bytedance.android.livesdk.interactivity.zdanmaku.f {
        public a() {
        }

        @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.f
        public final com.bytedance.android.livesdk.interactivity.zdanmaku.e a(float r2, com.bytedance.android.livesdk.interactivity.zdanmaku.i r3) {
            Intrinsics.checkNotNullParameter(r3, "danmaku");
            return new com.bytedance.android.livesdk.interactivity.zdanmaku.e((-r2) * r3.d);
        }
    }

    public static final class b implements com.bytedance.android.livesdk.interactivity.zdanmaku.g {
        public final /* synthetic */ h a;

        public b(h r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.g
        public final float a(com.bytedance.android.livesdk.interactivity.zdanmaku.i r2) {
            Intrinsics.checkNotNullParameter(r2, "danmakuWithLineDanmaku");
            IHeatChangeController r3 = this.a.j;
            if (r3 == null) goto L5;
            IHeatChangeController.DanmakuHeat r4 = r3.a();
        L6:
            if (r4 == null) goto L15;
            int r5 = g.a[r4.ordinal()];
            if (r5 == 1) goto L14;
            if (r5 != 2) goto L15;
        L14:
            return this.a.b;
        L15:
            return this.a.h.nextInt(6);
        L5:
            r4 = null;
            goto L6
        }
    }

    @Override // uc2.b
    public final boolean c() {
        if (this.b <= (-6.0f)) goto L6;
        this.b = -6.0f;
        return true;
    L6:
        return false;
    }

    @Override // uc2.b
    public final boolean d() {
        if (this.b >= 0.0f) goto L6;
        this.b = 0.0f;
        return true;
    L6:
        return false;
    }

    @Override // uc2.b
    public final boolean e() {
        if (this.a <= 1.0f) goto L6;
        this.a = 1.0f;
        return true;
    L6:
        return false;
    }

    @Override // uc2.b
    public final boolean f() {
        if (this.a >= 1.5f) goto L6;
        this.a = 1.5f;
        return true;
    L6:
        return false;
    }

    @Override // uc2.b
    public final a a() {
        return this.g;
    }

    @Override // uc2.b
    public final b b() {
        return this.i;
    }

    public h(int r1, boolean r2, boolean r3, IHeatChangeController r4) {
        super(r1, r2, r3);
        this.j = r4;
        this.g = new a();
        this.h = new Random();
        this.i = new b(this);
    }
}
