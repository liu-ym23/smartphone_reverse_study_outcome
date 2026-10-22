package com.bytedance.android.livesdk.chatroom.view;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bytedance.android.livesdk.utils.e0;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a<T> implements ObservableOnSubscribe {
    public final /* synthetic */ BlurImageView a;
    public final /* synthetic */ Bitmap b;

    public a(BlurImageView r1, Bitmap r2) {
        this.a = r1;
        this.b = r2;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [android.view.ViewGroup, com.bytedance.android.livesdk.chatroom.view.BlurImageView] */
    public final void subscribe(ObservableEmitter<Drawable> r10) {
        Intrinsics.checkNotNullParameter(r10, "it");
        if (this.b == null) goto L8;
        ?? r0 = this.a;
        if (r0.a <= 0) goto L8;
        float r1 = r0.getWidth() / this.b.getWidth();
        float r2 = this.a.getHeight() / this.b.getHeight();
        Matrix r7 = new Matrix();
        r7.postScale(r1, r2);
        Bitmap r3 = this.b;
        Bitmap r4 = Bitmap.createBitmap(r3, 0, 0, r3.getWidth(), this.b.getHeight(), r7, true);
        Bitmap r5 = Bitmap.createBitmap(this.a.getWidth(), this.a.getHeight(), Bitmap.Config.ARGB_8888);
        e0.a(r4, r5, this.a.a);
        r10.onNext(new BitmapDrawable(this.a.getContext().getResources(), r5));
        return;
    L8:
        r10.onError(new Throwable("getBlurDrawable fail: bitmap=" + this.b + ", mBlurRadius=" + this.a.a));
    }
}
