package com.bytedance.android.livesdk.chatroom.utils;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.widget.HSImageView;
import com.facebook.drawee.view.SimpleDraweeView;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class q2 implements z2 {
    public final py.k a;

    public static final class a<T, R> implements Function {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final Object apply(Object r2) {
            Bitmap r3 = (Bitmap) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            return new BitmapDrawable(r3);
        }
    }

    @Override // com.bytedance.android.livesdk.chatroom.utils.z2
    public final Observable<Drawable> a() {
        return a1.k(this.a).compose(RxUtil.rxSchedulerHelper()).map(a.a);
    }

    public q2(py.k r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.livesdk.chatroom.utils.z2
    public final Disposable b(View r10, SkinLoader$loopLoadImg$2 r11) {
        Intrinsics.checkNotNullParameter(r10, "view");
        py.k r2 = this.a;
        if (r2 != null) goto L6;
        r11.b(SkinLoadResultType.ERROR, "null");
        return null;
    L6:
        r11.b(SkinLoadResultType.START, "");
        if ((r10 instanceof HSImageView) == false) goto L11;
        ImageLoader.bindImage((SimpleDraweeView) r10, r2, null, -1, -1, null, new r2(r11), true);
        return null;
    L11:
        return a1.l(r2, -1, -1, false, null).compose(RxUtil.rxSchedulerHelper()).subscribe(new s2(r11, r10), new t2(r11));
    }
}
