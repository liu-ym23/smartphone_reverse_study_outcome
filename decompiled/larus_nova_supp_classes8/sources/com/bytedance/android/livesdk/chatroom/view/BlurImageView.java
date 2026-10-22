package com.bytedance.android.livesdk.chatroom.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\t¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/view/BlurImageView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/graphics/Bitmap;", "bitmap", "", "setBlurBackground", "Landroid/graphics/drawable/Drawable;", "background", "setBackground", "", "radius", "setBlurRadius", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BlurImageView extends ConstraintLayout {
    public int a;
    public Disposable b;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ BlurImageView a;

        public a(BlurImageView r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            BlurImageView r0 = this.a;
            BlurImageView.R5(r0, (Drawable) r2);
        }
    }

    public static final class b<T> implements Consumer {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final void accept(Object r2) {
            ALogger.i("BlurImageView", String.valueOf(((Throwable) r2).getMessage()));
        }
    }

    public BlurImageView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public BlurImageView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        super/*android.view.ViewGroup*/.onDetachedFromWindow();
        Disposable r0 = this.b;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.b = null;
    }

    private final void setBlurBackground(Bitmap r3) {
        Disposable r0 = this.b;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        Observable r4 = Observable.create(new com.bytedance.android.livesdk.chatroom.view.a(this, r3));
        if (r4 == null) goto L12;
        Observable r5 = r4.subscribeOn(Schedulers.io());
        if (r5 == null) goto L12;
        Observable r6 = r5.observeOn(AndroidSchedulers.mainThread());
        if (r6 == null) goto L12;
        Disposable r7 = r6.subscribe(new a(this), b.a);
    L13:
        this.b = r7;
        return;
    L12:
        r7 = null;
        goto L13
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setBackground(Drawable r2) {
        if ((r2 instanceof BitmapDrawable) == true) goto L5;
        Drawable r0 = null;
    L6:
        BitmapDrawable r1 = (BitmapDrawable) r0;
        if (r1 == null) goto L12;
        Bitmap r3 = r1.getBitmap();
        if (r3 == null) goto L12;
        setBlurBackground(r3);
        return;
    L12:
        super/*android.view.ViewGroup*/.setBackground(r2);
        return;
    L5:
        r0 = r2;
        goto L6
    }

    public final void setBlurRadius(int r1) {
        this.a = r1;
    }

    public final void setBackground(Bitmap r1) {
        if (r1 == null) goto L5;
        setBlurBackground(r1);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ void R5(BlurImageView r0, Drawable r1) {
        super/*android.view.ViewGroup*/.setBackground(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BlurImageView(Context r4, AttributeSet r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r5, r6);
        TypedArray r7 = r4.obtainStyledAttributes(r5, new int[]{2130974699}, r6, 0);
        this.a = r7.getDimensionPixelSize(0, 0);
        r7.recycle();
        Drawable r8 = getBackground();
        if ((r8 instanceof BitmapDrawable) == true) goto L5;
        r8 = null;
    L5:
        BitmapDrawable r9 = (BitmapDrawable) r8;
        if (r9 == null) goto L11;
        Bitmap r10 = r9.getBitmap();
        if (r10 == null) goto L12;
        setBlurBackground(r10);
        return;
    L12:
        return;
    }

    public /* synthetic */ BlurImageView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
