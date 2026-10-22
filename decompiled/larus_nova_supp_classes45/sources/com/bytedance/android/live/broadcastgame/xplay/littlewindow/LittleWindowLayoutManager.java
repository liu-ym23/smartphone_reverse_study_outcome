package com.bytedance.android.live.broadcastgame.xplay.littlewindow;

import android.content.Context;
import android.graphics.Rect;
import com.bytedance.android.live.broadcastgame.api.xplay.LittleWindowPos;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class LittleWindowLayoutManager {
    public final HashMap<LayoutMode, d> a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public Rect g;
    public final Context h;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/xplay/littlewindow/LittleWindowLayoutManager$LayoutMode;", "", "LargeSize", "SmallSize", "CustomSize", "DragIndicator", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum LayoutMode extends Enum<LayoutMode> {
        public static final LayoutMode CustomSize = null;
        public static final LayoutMode DragIndicator = null;
        public static final LayoutMode LargeSize = null;
        public static final LayoutMode SmallSize = null;
        public static final /* synthetic */ LayoutMode[] a = null;

        static {
            LayoutMode r1 = new LayoutMode("LargeSize", 0);
            LargeSize = r1;
            LayoutMode r2 = new LayoutMode("SmallSize", 1);
            SmallSize = r2;
            LayoutMode r3 = new LayoutMode("CustomSize", 2);
            CustomSize = r3;
            LayoutMode r4 = new LayoutMode("DragIndicator", 3);
            DragIndicator = r4;
            a = new LayoutMode[]{r1, r2, r3, r4};
        }

        public static LayoutMode valueOf(String r1) {
            return (LayoutMode) r27.a.a(LayoutMode.class, r1);
        }

        public static LayoutMode[] values() {
            return (LayoutMode[]) a.clone();
        }

        public LayoutMode(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static abstract class a implements d {
        public final float a;
        public final Context b;

        public abstract int b();

        public abstract com.bytedance.android.live.broadcastgame.xplay.j c();

        public a(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            this.b = r2;
            this.a = d(375);
        }

        public final float d(int r2) {
            return fm3.e.a(this.b, r2);
        }

        @Override // com.bytedance.android.live.broadcastgame.xplay.littlewindow.LittleWindowLayoutManager.d
        public final Rect a(int r7, int r8, Rect r9, LittleWindowPos r11, com.bytedance.android.live.broadcastgame.api.xplay.c r12) {
            Intrinsics.checkNotNullParameter(r9, "safeArea");
            Intrinsics.checkNotNullParameter(r11, "position");
            float r0 = r7 / this.a;
            if (r11 != LittleWindowPos.CUSTOM) goto L5;
            com.bytedance.android.live.broadcastgame.xplay.j r1 = new com.bytedance.android.live.broadcastgame.xplay.j(c().a, c().b);
        L6:
            int r2 = MathKt.roundToInt(d(b()) * r0);
            int r3 = MathKt.roundToInt(d(r9.left) * r0);
            int r4 = MathKt.roundToInt(d(r9.right) * r0);
            int r13 = MathKt.roundToInt(d(r9.bottom) * r0);
            int r14 = com.bytedance.android.live.broadcastgame.xplay.littlewindow.f.a[r11.ordinal()];
            if (r14 == 1) goto L22;
            if (r14 == 2) goto L26;
            if (r14 == 3) goto L25;
            if (r14 == 4) goto L24;
            if (r14 != 5) goto L17;
            Intrinsics.checkNotNullParameter(r1, "$this$makeCustomRect");
            Rect r15 = new Rect();
            int r16 = r12.b;
            double r5 = ((double) (r8 - r16)) / 2.0d;
            double r17 = ((double) (r7 - r12.a)) / 2.0d;
            r15.top = MathKt.roundToInt(((double) (r16 * r12.d)) + r5);
            r15.left = MathKt.roundToInt(((double) (r12.a * r12.c)) + r17);
            r15.right = MathKt.roundToInt((r17 + ((double) (r12.a * r12.c))) + ((double) r1.a));
            r15.bottom = MathKt.roundToInt((r5 + ((double) (r12.b * r12.d))) + ((double) r1.b));
            return r15;
        L17:
            throw new NoWhenBranchMatchedException();
        L24:
            return com.bytedance.android.live.broadcastgame.xplay.b.a(r1, r7 - r4, r8 - r13, 12);
        L25:
            return com.bytedance.android.live.broadcastgame.xplay.b.a(r1, r7 - r4, r2, 6);
        L26:
            return com.bytedance.android.live.broadcastgame.xplay.b.a(r1, r3, r2, 3);
        L22:
            return com.bytedance.android.live.broadcastgame.xplay.b.a(r1, r7 / 2, 0, 7);
        L5:
            r1 = new com.bytedance.android.live.broadcastgame.xplay.j(MathKt.roundToInt(d(c().a) * r0), MathKt.roundToInt(d(c().b) * r0));
            goto L6
        }
    }

    public static final class b extends a {
        public final com.bytedance.android.live.broadcastgame.xplay.j c;

        @Override // com.bytedance.android.live.broadcastgame.xplay.littlewindow.LittleWindowLayoutManager.a
        public final int b() {
            return 0;
        }

        @Override // com.bytedance.android.live.broadcastgame.xplay.littlewindow.LittleWindowLayoutManager.a
        public final com.bytedance.android.live.broadcastgame.xplay.j c() {
            return this.c;
        }

        public b(Context r2, int r3, int r4) {
            Intrinsics.checkNotNullParameter(r2, "context");
            super(r2);
            this.c = new com.bytedance.android.live.broadcastgame.xplay.j(r3, r4);
        }
    }

    public static final class c extends a {
        public final com.bytedance.android.live.broadcastgame.xplay.j c;
        public final int d;

        @Override // com.bytedance.android.live.broadcastgame.xplay.littlewindow.LittleWindowLayoutManager.a
        public final int b() {
            return this.d;
        }

        @Override // com.bytedance.android.live.broadcastgame.xplay.littlewindow.LittleWindowLayoutManager.a
        public final com.bytedance.android.live.broadcastgame.xplay.j c() {
            return this.c;
        }

        public c(Context r3) {
            Intrinsics.checkNotNullParameter(r3, "context");
            super(r3);
            this.c = new com.bytedance.android.live.broadcastgame.xplay.j(105, 150);
            this.d = 124;
        }
    }

    public interface d {
        Rect a(int r1, int r2, Rect r3, LittleWindowPos r4, com.bytedance.android.live.broadcastgame.api.xplay.c r5);
    }

    public static final class e extends a {
        public final com.bytedance.android.live.broadcastgame.xplay.j c;
        public final int d;

        @Override // com.bytedance.android.live.broadcastgame.xplay.littlewindow.LittleWindowLayoutManager.a
        public final int b() {
            return this.d;
        }

        @Override // com.bytedance.android.live.broadcastgame.xplay.littlewindow.LittleWindowLayoutManager.a
        public final com.bytedance.android.live.broadcastgame.xplay.j c() {
            return this.c;
        }

        public e(Context r3) {
            Intrinsics.checkNotNullParameter(r3, "context");
            super(r3);
            this.c = new com.bytedance.android.live.broadcastgame.xplay.j(90, 130);
            this.d = 124;
        }
    }

    public static final class f extends a {
        public final com.bytedance.android.live.broadcastgame.xplay.j c;
        public final int d;

        @Override // com.bytedance.android.live.broadcastgame.xplay.littlewindow.LittleWindowLayoutManager.a
        public final int b() {
            return this.d;
        }

        @Override // com.bytedance.android.live.broadcastgame.xplay.littlewindow.LittleWindowLayoutManager.a
        public final com.bytedance.android.live.broadcastgame.xplay.j c() {
            return this.c;
        }

        public f(Context r3) {
            Intrinsics.checkNotNullParameter(r3, "context");
            super(r3);
            this.c = new com.bytedance.android.live.broadcastgame.xplay.j(90, 82);
            this.d = 148;
        }
    }

    public final Context getContext() {
        return this.h;
    }

    public LittleWindowLayoutManager(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        this.h = r4;
        HashMap<LayoutMode, d> r0 = new HashMap();
        this.a = r0;
        this.g = new Rect();
        r0.put(LayoutMode.LargeSize, new e(r4));
        r0.put(LayoutMode.SmallSize, new f(r4));
        r0.put(LayoutMode.DragIndicator, new c(r4));
    }

    public final Rect a(LayoutMode r8, LittleWindowPos r9, float r11, float r12) {
        Intrinsics.checkNotNullParameter(r8, "mode");
        Intrinsics.checkNotNullParameter(r9, "position");
        d r1 = this.a.get(r8);
        if (r1 == null) goto L7;
        return r1.a(this.b, this.c, this.g, r9, new com.bytedance.android.live.broadcastgame.api.xplay.c(this.d, this.e, r11, r12));
    L7:
        throw new IllegalArgumentException("no strategy for mode " + r8);
    }
}
