package l9a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import kotlin.Deprecated;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    /* JADX INFO: renamed from: l9a.a$a, reason: collision with other inner class name */
    public static final class C0098a extends Drawable {
        public final Drawable a;
        public final int b;
        public final boolean c;
        public final boolean d;
        public final Paint e;
        public final Paint f;
        public final Paint g;
        public final Rect h;
        public Bitmap i;
        public Bitmap j;
        public int k;

        @Override // android.graphics.drawable.Drawable
        @Deprecated(message = "Deprecated in Java", replaceWith = @ReplaceWith(expression = "PixelFormat.TRANSLUCENT", imports = {}))
        public final int getOpacity() {
            return -3;
        }

        @Override // android.graphics.drawable.Drawable
        public final int getIntrinsicHeight() {
            return this.a.getIntrinsicHeight();
        }

        @Override // android.graphics.drawable.Drawable
        public final int getIntrinsicWidth() {
            return this.a.getIntrinsicWidth();
        }

        @Override // android.graphics.drawable.Drawable
        public final void draw(Canvas r27) {
            Intrinsics.checkNotNullParameter(r27, "canvas");
            Rect r2 = getBounds();
            if (r2.isEmpty() == false) goto L5;
            return;
        L5:
            this.g.setAlpha(this.k);
            int r3 = r2.width();
            int r4 = r2.height();
            Bitmap r5 = this.j;
            if (r5 != null) goto L8;
        L12:
            int r6 = RangesKt.coerceAtLeast(r3, 1);
            int r7 = RangesKt.coerceAtLeast(r4, 1);
            Bitmap r8 = Bitmap.createBitmap(r6, r7, Bitmap.Config.ARGB_8888);
            Canvas r13 = new Canvas(r8);
            if (this.d == false) goto L16;
            int r22 = this.b;
            int r23 = r22;
        L20:
            float r11 = r7;
            this.e.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, r11, r22, r23, Shader.TileMode.CLAMP));
            this.e.setAlpha(255);
            r13.drawRect(0.0f, 0.0f, r6, r11, this.e);
            Bitmap r9 = this.i;
            if (r9 != null) goto L23;
        L27:
            r9 = Bitmap.createBitmap(RangesKt.coerceAtLeast(r6, 1), RangesKt.coerceAtLeast(r7, 1), Bitmap.Config.ARGB_8888);
            Canvas r10 = new Canvas(r9);
            this.a.setBounds(0, 0, r9.getWidth(), r9.getHeight());
            this.a.setAlpha(255);
            this.a.setColorFilter(new PorterDuffColorFilter(-1, PorterDuff.Mode.SRC_IN));
            this.a.draw(r10);
            this.i = r9;
        L28:
            r13.drawBitmap(r9, 0.0f, 0.0f, this.f);
            this.j = r8;
            r5 = r8;
        L29:
            r27.drawBitmap(r5, null, r2, this.g);
            return;
        L23:
            if (r9.getWidth() != r6) goto L27;
            if (r9.getHeight() != r7) goto L27;
        L16:
            if (this.c == false) goto L18;
            int r12 = this.b;
            int r14 = a.a;
            int r15 = RangesKt.coerceIn(Math.round(Color.alpha(-16777216) * 0.16f), 0, 255);
            int r16 = Color.argb(Color.alpha(r12), RangesKt.coerceAtLeast((Color.red(r12) + ((Color.red(-16777216) * r15) / 255)) - r15, 0), RangesKt.coerceAtLeast((Color.green(r12) + ((Color.green(-16777216) * r15) / 255)) - r15, 0), RangesKt.coerceAtLeast((Color.blue(r12) + ((Color.blue(-16777216) * r15) / 255)) - r15, 0));
        L19:
            r23 = r16;
            r22 = r12;
            goto L20
        L18:
            int r17 = a.a;
            int r18 = this.b;
            int r19 = RangesKt.coerceIn(Math.round(Color.alpha(-1) * 0.16f), 0, 255);
            r12 = Color.argb(Color.alpha(r18), RangesKt.coerceAtMost(Color.red(r18) + ((Color.red(-1) * r19) / 255), 255), RangesKt.coerceAtMost(Color.green(r18) + ((Color.green(-1) * r19) / 255), 255), RangesKt.coerceAtMost(Color.blue(r18) + ((Color.blue(-1) * r19) / 255), 255));
            r16 = this.b;
            goto L19
        L8:
            if (r5.getWidth() != r3) goto L12;
            if (r5.getHeight() != r4) goto L12;
            goto L12
        }

        @Override // android.graphics.drawable.Drawable
        public final void onBoundsChange(Rect r3) {
            Intrinsics.checkNotNullParameter(r3, "bounds");
            super.onBoundsChange(r3);
            if (this.h.width() == r3.width()) goto L5;
        L6:
            this.i = null;
            this.j = null;
        L7:
            this.h.set(r3);
            return;
        L5:
            if (this.h.height() == r3.height()) goto L7;
            goto L6
        }

        @Override // android.graphics.drawable.Drawable
        public final void setAlpha(int r2) {
            if (this.k != r2) goto L5;
            return;
        L5:
            this.k = r2;
            invalidateSelf();
        }

        @Override // android.graphics.drawable.Drawable
        public final void setColorFilter(ColorFilter r2) {
            this.g.setColorFilter(r2);
            invalidateSelf();
        }

        public C0098a(Drawable r2, int r3, boolean r4, boolean r5) {
            Intrinsics.checkNotNullParameter(r2, "source");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = new Paint(1);
            Paint r6 = new Paint(1);
            this.f = r6;
            this.g = new Paint(3);
            this.h = new Rect();
            this.k = 255;
            r6.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        }
    }

    static {
    }
}
