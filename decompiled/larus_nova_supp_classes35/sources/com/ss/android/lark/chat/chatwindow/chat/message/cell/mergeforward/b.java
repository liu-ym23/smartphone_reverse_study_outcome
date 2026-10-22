package com.ss.android.lark.chat.chatwindow.chat.message.cell.mergeforward;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.v0;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.api.SimpleTarget;
import com.ss.android.lark.image.entity.AvatarImage;
import com.ss.android.lark.image.utils.e;
import com.ss.android.lark.utils.UIHelper;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b extends ImageSpan {
    public final Context a;
    public final Drawable b;
    public final com.ss.android.lark.chat.chatwindow.chat.message.cell.mergeforward.c c;
    public final int d;
    public final int e;
    public final String f;
    public final String g;
    public final Lazy h;
    public final int i;
    public final Lazy j;
    public boolean k;

    public static final class a extends Drawable {
        public final Drawable a;
        public final Drawable b;
        public final Path c;
        public final RectF d;
        public final Paint e;

        @Override // android.graphics.drawable.Drawable
        public final int getOpacity() {
            return -3;
        }

        @Override // android.graphics.drawable.Drawable
        public final void setAlpha(int r1) {
        }

        @Override // android.graphics.drawable.Drawable
        public final void setColorFilter(ColorFilter r1) {
        }

        @Override // android.graphics.drawable.Drawable
        public final void draw(Canvas r6) {
            Intrinsics.checkNotNullParameter(r6, "canvas");
            Drawable r0 = this.a;
            if ((r0 instanceof BitmapDrawable) == true) goto L5;
            return;
        L5:
            Bitmap r1 = ((BitmapDrawable) r0).getBitmap();
            if (r1 != null) goto L8;
        L12:
            this.b.draw(r6);
            return;
        L8:
            if (r1.isRecycled() == true) goto L12;
            int r2 = r6.getSaveCount();
            r6.save();
            this.c.reset();
            this.c.addOval(this.d, Path.Direction.CW);
            r6.clipPath(this.c);
            r6.drawBitmap(r1, null, this.d, this.e);
            r6.restoreToCount(r2);
        }

        public a(Drawable r2, Drawable r3, float r4) {
            Intrinsics.checkNotNullParameter(r2, "srcDrawable");
            Intrinsics.checkNotNullParameter(r3, "placeHolder");
            this.a = r2;
            this.b = r3;
            this.c = new Path();
            this.d = new RectF(0.0f, 0.0f, r4, r4);
            this.e = new Paint(2);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.message.cell.mergeforward.b$b, reason: collision with other inner class name */
    public static final class C0040b {
    }

    public final class c extends SimpleTarget<Drawable> {
        public final /* synthetic */ b a;

        public c(b r1) {
            this.a = r1;
        }

        public final void onLoadFailed(Drawable r2) {
            super.onLoadFailed(r2);
            this.a.k = true;
        }

        public final void onResourceReady(Object r5) {
            Drawable r6 = (Drawable) r5;
            super.onResourceReady(r6);
            if (r6 == null) goto L5;
            b r1 = this.a;
            a r0 = new a(r6, r1.b, r1.e);
            int r7 = this.a.a();
            b r2 = this.a;
            r0.setBounds(0, r7, r2.e, r2.a() + this.a.e);
            e.b(this.a, "mDrawable", r0);
            e.b(this.a, "mDrawableRef", null);
        L5:
            b r8 = this.a;
            r8.k = true;
            r8.c.a();
        }
    }

    static {
    }

    public final int a() {
        return ((Number) this.h.getValue()).intValue();
    }

    @Override // android.text.style.ImageSpan, android.text.style.DynamicDrawableSpan
    public final Drawable getDrawable() {
        if (this.k == true) goto L6;
        ImageLoader.with(this.a).load((AvatarImage) this.j.getValue()).asDrawable().into(new c(this));
    L6:
        return super.getDrawable();
    }

    public b(Context r2, Drawable r3, v0 r4, int r5, int r6, String r7, String r8) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "placeHolder");
        Intrinsics.checkNotNullParameter(r4, "onAvatarReadyListener");
        Intrinsics.checkNotNullParameter(r7, "avatarKey");
        Intrinsics.checkNotNullParameter(r8, "entityId");
        super(r3);
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = LazyKt.lazy(new GroupAvatarSpan$top$2(this));
        this.i = UIHelper.dp2px(1.0f);
        r3.setBounds(0, a(), r6, a() + r6);
        this.j = LazyKt.lazy(new GroupAvatarSpan$avatarImage$2(this));
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public final void draw(Canvas r1, CharSequence r2, int r3, int r4, float r5, int r6, int r7, int r8, Paint r9) {
        Intrinsics.checkNotNullParameter(r1, "canvas");
        Intrinsics.checkNotNullParameter(r9, "paint");
        Drawable r10 = getDrawable();
        r1.save();
        r1.translate(r5, ((r6 + ((r8 - r6) / 2)) - (r10.getBounds().height() / 2.0f)) + this.i);
        r10.draw(r1);
        r1.restore();
    }
}
