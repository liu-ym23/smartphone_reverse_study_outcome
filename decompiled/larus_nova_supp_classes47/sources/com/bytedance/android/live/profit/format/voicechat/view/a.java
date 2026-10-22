package com.bytedance.android.live.profit.format.voicechat.view;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bytedance.android.livesdk.utils.e0;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a<T> implements ObservableOnSubscribe {
    public final /* synthetic */ BlurBackgroundImageView a;
    public final /* synthetic */ Bitmap b;

    public a(BlurBackgroundImageView r1, Bitmap r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void subscribe(ObservableEmitter<Drawable> r10) {
        Intrinsics.checkNotNullParameter(r10, "it");
        if (this.b == null) goto L12;
        BlurBackgroundImageView r0 = this.a;
        if (r0.a <= 0) goto L12;
        if (r0.getWidth() == 0) goto L12;
        if (this.a.getHeight() == 0) goto L12;
        Bitmap r1 = Bitmap.createBitmap(this.b.getWidth(), this.b.getHeight(), Bitmap.Config.ARGB_8888);
        e0.a(this.b, r1, this.a.a);
        BlurBackgroundImageView r2 = this.a;
        int r3 = r2.getWidth();
        int r4 = this.a.getHeight();
        r2.getClass();
        Bitmap r5 = Bitmap.createBitmap(r3, r4, Bitmap.Config.ARGB_8888);
        Canvas r6 = new Canvas(r5);
        Matrix r7 = new Matrix();
        float r8 = r3;
        float r9 = r4;
        float r12 = Math.max(r8 / r1.getWidth(), r9 / r1.getHeight());
        r7.setScale(r12, r12);
        r7.postTranslate((r8 - (r1.getWidth() * r12)) * 0.5f, (r9 - (r1.getHeight() * r12)) * 0.5f);
        r6.drawBitmap(r1, r7, new Paint(2));
        r10.onNext(new BitmapDrawable(this.a.getContext().getResources(), r5));
        return;
    L12:
        r10.onError(new Throwable("getBlurDrawable fail: bitmap=" + this.b + ", mBlurRadius=" + this.a.a));
    }
}
