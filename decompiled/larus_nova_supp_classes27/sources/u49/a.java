package u49;

import android.content.Context;
import android.util.AttributeSet;
import com.larus.dora.impl.device.settings.lab.env.timer.reels.ReelPicker$HeightMode;
import com.larus.dora.impl.device.settings.lab.env.timer.reels.views.ReelPickerThreeReels;
import java.util.function.Consumer;
import kotlin.jvm.internal.Intrinsics;
import t49.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a implements t49.a<b> {
    public C0142a a;

    /* JADX INFO: renamed from: u49.a$a, reason: collision with other inner class name */
    public static final class C0142a {
        public boolean a;
        public boolean b;
        public boolean c;
        public Consumer<b> d;
        public ReelPicker$HeightMode e;
        public final b f;
        public final b g;
        public final b h;
        public ReelPickerThreeReels i;
        public final C0143a j;

        /* JADX INFO: renamed from: u49.a$a$a, reason: collision with other inner class name */
        public final class C0143a implements c {
            public final /* synthetic */ C0142a a;

            public C0143a(C0142a r1) {
                this.a = r1;
            }

            @Override // t49.c
            public final void a(int r3, int r4) {
                if (r3 != 0) goto L5;
                b(this, this.a.g.a + r4, 0, 0, 6);
            L12:
                C0142a r5 = this.a;
                Consumer<b> r6 = r5.d;
                if (r6 == null) goto L16;
                r6.accept(r5.f);
                return;
            L16:
                return;
            L5:
                if (r3 != 1) goto L7;
                b(this, 0, this.a.g.b + r4, 0, 5);
                goto L12
            L7:
                if (r3 != 2) goto L12;
                b(this, 0, 0, this.a.g.c + r4, 3);
                goto L12
            }

            public static void b(C0143a r2, int r3, int r4, int r5, int r6) {
                if ((r6 & 1) == 0) goto L6;
                r3 = -1;
            L6:
                if ((r6 & 2) == 0) goto L9;
                r4 = -1;
            L9:
                if ((r6 & 4) == 0) goto L11;
                r5 = -1;
            L11:
                if (r3 < 0) goto L13;
                r2.a.f.a = r3;
            L13:
                if (r4 < 0) goto L15;
                r2.a.f.b = r4;
            L15:
                if (r5 < 0) goto L17;
                r2.a.f.c = r5;
            L17:
                C0142a r7 = r2.a;
                Consumer<b> r8 = r7.d;
                if (r8 == null) goto L21;
                r8.accept(r7.f);
                return;
            }
        }

        public C0142a() {
            this.b = true;
            this.c = true;
            this.e = ReelPicker$HeightMode.FIVE_LINES;
            this.f = new b(0);
            this.g = new b(0);
            this.h = new b(0);
            this.j = new C0143a(this);
        }

        public final a a(Context r8, AttributeSet r9, int r10) {
            Intrinsics.checkNotNullParameter(r8, "context");
            ReelPickerThreeReels.a r0 = new ReelPickerThreeReels.a(this.e.getHeightInDp());
            t49.b r2 = null;
            if (this.a == true) goto L5;
            t49.b r3 = null;
        L6:
            if (r3 == null) goto L9;
            r0.a(r3);
        L9:
            if (this.b == true) goto L11;
            t49.b r4 = null;
        L12:
            if (r4 == null) goto L15;
            r0.a(r4);
        L15:
            if (this.c == false) goto L18;
            int r1 = u49.b.a;
            r2 = new t49.b(2, u49.b.a(this.g.c, this.h.c), this.f.c - this.g.c, this.j);
        L18:
            if (r2 == null) goto L20;
            r0.a(r2);
        L20:
            ReelPickerThreeReels r11 = r0.b(r8, r9, r10);
            a r12 = new a();
            this.i = r11;
            r12.a = this;
            return r12;
        L11:
            int r5 = u49.b.a;
            r4 = new t49.b(1, u49.b.a(this.g.b, this.h.b), this.f.b - this.g.b, this.j);
            goto L12
        L5:
            int r6 = u49.b.a;
            r3 = new t49.b(0, u49.b.a(this.g.a, this.h.a), this.f.a - this.g.a, this.j);
            goto L6
        }
    }

    public static final class b {
        public int a;
        public int b;
        public int c;

        public b() {
            this(0);
        }

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
            if (this.c == r6.c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.a * 31) + this.b) * 31) + this.c;
        }

        public final String toString() {
            return "TimeLength(hour=" + this.a + ", minute=" + this.b + ", second=" + this.c + ')';
        }

        public b(int r1) {
            this.a = 0;
            this.b = 0;
            this.c = 0;
        }
    }

    public a() {
    }

    @Override // t49.a
    public final ReelPickerThreeReels asView() {
        C0142a r0 = this.a;
        if (r0 == null) goto L7;
        ReelPickerThreeReels r1 = r0.i;
        if (r1 == null) goto L7;
        return r1;
    L7:
        return null;
    }
}
