package com.larus.bmhome.bot.share;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.immerse.k0;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 ,2\u00020\u0001:\u0002+,B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ7\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u00172\b\u0010\"\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010#J\u0010\u0010$\u001a\u00020 2\u0006\u0010%\u001a\u00020&H\u0014J \u0010'\u001a\u00020\u00172\u0006\u0010(\u001a\u00020\u00172\u0006\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u0007H\u0002R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/larus/bmhome/bot/share/ImmerseBgBitmapImageView;", "Landroid/view/View;", "aContext", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "getAContext", "()Landroid/content/Context;", "setAContext", "(Landroid/content/Context;)V", "getAttrs", "()Landroid/util/AttributeSet;", "setAttrs", "(Landroid/util/AttributeSet;)V", "getDefStyleAttr", "()I", "setDefStyleAttr", "(I)V", "immersiveBgBitmap", "Landroid/graphics/Bitmap;", "immersiveBgColor", "footerContainerHeight", "immersiveBgMaskHeight", "paint", "Landroid/graphics/Paint;", "drawBitmapCacheInfo", "Lcom/larus/bmhome/bot/share/ImmerseBgBitmapImageView$DrawBitmapCacheInfo;", "setImmerseAvatarAndColor", "", "bgAvatar", "bgColor", "(Landroid/graphics/Bitmap;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "onDraw", "canvas", "Landroid/graphics/Canvas;", "getDrawBitmap", "bitmap", "canvasHeight", "canvasWidth", "DrawBitmapCacheInfo", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class ImmerseBgBitmapImageView extends View {
    public Context a;
    public AttributeSet b;
    public int c;
    public Bitmap d;
    public int e;
    public int f;
    public int g;
    public final Paint h;
    public b i;

    public static final class a {
    }

    public static final class b {
        public final int a;
        public final int b;
        public final Bitmap c;
        public final boolean d;

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
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r0 = ((((this.a * 31) + this.b) * 31) + this.c.hashCode()) * 31;
            if (this.d == false) goto L5;
            int r1 = 1231;
        L7:
            return r0 + r1;
        L5:
            r1 = 1237;
            goto L7
        }

        public final String toString() {
            return "DrawBitmapCacheInfo(height=" + this.a + ", width=" + this.b + ", bitmap=" + this.c + ", isScaledBitmap=" + this.d + ')';
        }

        public b(int r2, int r3, Bitmap r4, boolean r5) {
            Intrinsics.checkNotNullParameter(r4, "bitmap");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    static {
    }

    public ImmerseBgBitmapImageView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "aContext");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ImmerseBgBitmapImageView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "aContext");
        this(r3, r4, 4, 0);
    }

    public final Context getAContext() {
        return this.a;
    }

    public final AttributeSet getAttrs() {
        return this.b;
    }

    public final int getDefStyleAttr() {
        return this.c;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r14) {
        Intrinsics.checkNotNullParameter(r14, "canvas");
        super.onDraw(r14);
        FLogger r0 = FLogger.a;
        r0.d("ImmerseBgBitmapImageView", "onDraw: " + Integer.valueOf(r14.getHeight()) + "   " + Integer.valueOf(r14.getWidth()));
        Bitmap r1 = this.d;
        if (r1 != null) goto L5;
        r0.d("ImmerseBgBitmapImageView", "buildImmersiveBg: immersiveBgBitmap is null");
        int r2 = this.e;
        Rect r3 = new Rect(0, 0, r14.getWidth(), r14.getHeight());
        Paint r4 = this.h;
        r4.reset();
        r4.setColor(r2);
        Unit r5 = Unit.INSTANCE;
        r14.drawRect(r3, r4);
        return;
    L5:
        if (r1 != null) goto L7;
        return;
    L7:
        int r6 = r14.getHeight();
        int r7 = r14.getWidth();
        b r8 = this.i;
        if (r8 == null) goto L15;
        if (r8.a != r6) goto L15;
        if (r8.b != r7) goto L15;
        r0.d("ImmerseBgBitmapImageView", "getDrawBitmap from cache");
        Bitmap r9 = r8.c;
    L19:
        r14.drawBitmap(r9, 0.0f, 0.0f, null);
        int r10 = ColorUtils.setAlphaComponent(this.e, 255);
        int r11 = ColorUtils.setAlphaComponent(this.e, 0);
        int r12 = Math.min(r9.getHeight(), r14.getHeight() - this.f);
        int r13 = r12 - this.g;
        LinearGradient r15 = new LinearGradient(0.0f, r12, 0.0f, r13, r10, r11, Shader.TileMode.CLAMP);
        Rect r16 = new Rect(0, r13, r14.getWidth(), r12);
        Paint r17 = this.h;
        r17.reset();
        r17.setShader(r15);
        Unit r18 = Unit.INSTANCE;
        r14.drawRect(r16, r17);
        Rect r19 = new Rect(0, r12, r14.getWidth(), r14.getHeight());
        Paint r20 = this.h;
        r20.reset();
        r20.setColor(r10);
        r14.drawRect(r19, r20);
        return;
    L15:
        if (r1.getWidth() == getWidth()) goto L17;
        boolean r21 = true;
        r1 = Bitmap.createScaledBitmap(r1, getWidth(), (int) (r1.getHeight() * (getWidth() / r1.getWidth())), true);
        r0.d("ImmerseBgBitmapImageView", "getDrawBitmap createScaledBitmap");
    L18:
        this.i = new b(r6, r7, r1, r21);
        r9 = r1;
        goto L19
    L17:
        r21 = false;
        goto L18
    }

    public final void setAContext(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.a = r2;
    }

    public final void setAttrs(AttributeSet r1) {
        this.b = r1;
    }

    public final void setDefStyleAttr(int r1) {
        this.c = r1;
    }

    public ImmerseBgBitmapImageView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "aContext");
        super(r2, r3, r4);
        this.a = r2;
        this.b = r3;
        this.c = r4;
        int r5 = k0.a;
        this.e = k0.a(ContextCompat.getColor(getContext(), v19.c.b(2130972082, null, 2131103146)), 0.4f, 0.15f);
        this.f = i5.i();
        this.g = i5.R();
        this.h = new Paint();
    }

    public static void a(ImmerseBgBitmapImageView r1, Bitmap r2, Integer r3) {
        r1.d = r2;
        if (r3 == null) goto L5;
        r1.e = k0.a(r3.intValue(), 0.4f, 0.15f);
    L5:
        r1.invalidate();
    }

    public /* synthetic */ ImmerseBgBitmapImageView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
