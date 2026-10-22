package com.bytedance.android.live.profit.format.voicechat.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/profit/format/voicechat/view/BlurBackgroundImageView;", "Landroid/widget/ImageView;", "", "radius", "", "setBlurRadius", "resId", "setBlurBackgroundRes", "Landroid/graphics/Bitmap;", "bitmap", "setBlurBackground", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BlurBackgroundImageView extends ImageView {
    public static final /* synthetic */ int c = 0;
    public int a;
    public Disposable b;

    public static final class a implements Runnable {
        public final /* synthetic */ BlurBackgroundImageView a;
        public final /* synthetic */ Bitmap b;

        /* JADX INFO: renamed from: com.bytedance.android.live.profit.format.voicechat.view.BlurBackgroundImageView$a$a, reason: collision with other inner class name */
        public static final class C0022a<T> implements Consumer {
            public final /* synthetic */ a a;

            public C0022a(a r1) {
                this.a = r1;
            }

            public final void accept(Object r3) {
                BlurBackgroundImageView r0 = this.a.a;
                int r1 = BlurBackgroundImageView.c;
                r0.setBackground((Drawable) r3);
            }
        }

        public static final class b<T> implements Consumer {
            public static final b a = null;

            static {
                a = new b();
            }

            public b() {
            }

            public final void accept(Object r1) {
                ((Throwable) r1).getMessage();
            }
        }

        public a(BlurBackgroundImageView r1, Bitmap r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            Disposable r0 = this.a.b;
            if (r0 == null) goto L5;
            r0.dispose();
        L5:
            BlurBackgroundImageView r1 = this.a;
            Bitmap r2 = this.b;
            r1.getClass();
            Observable r3 = Observable.create(new com.bytedance.android.live.profit.format.voicechat.view.a(r1, r2));
            if (r3 == null) goto L12;
            Observable r4 = r3.subscribeOn(Schedulers.io());
            if (r4 == null) goto L12;
            Observable r5 = r4.observeOn(AndroidSchedulers.mainThread());
            if (r5 == null) goto L12;
            Disposable r6 = r5.subscribe(new C0022a(this), b.a);
        L13:
            r1.b = r6;
            return;
        L12:
            r6 = null;
            goto L13
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public BlurBackgroundImageView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public BlurBackgroundImageView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Disposable r0 = this.b;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.b = null;
    }

    public final void setBlurBackground(Bitmap r2) {
        Intrinsics.checkNotNullParameter(r2, "bitmap");
        post(new a(this, r2));
    }

    public final void setBlurBackgroundRes(int r2) {
        setBlurBackground(BitmapFactory.decodeResource(getResources(), r2));
    }

    public final void setBlurRadius(int r1) {
        this.a = r1;
    }

    public BlurBackgroundImageView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = 10;
    }

    public /* synthetic */ BlurBackgroundImageView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
