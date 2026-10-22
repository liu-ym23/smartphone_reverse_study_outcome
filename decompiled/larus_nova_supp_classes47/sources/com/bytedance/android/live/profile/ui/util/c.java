package com.bytedance.android.live.profile.ui.util;

import android.graphics.drawable.Animatable;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.p0;
import com.bytedance.android.live.core.widget.HSImageView;
import com.facebook.imagepipeline.image.ImageInfo;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c implements Runnable {
    public final /* synthetic */ HSImageView a;
    public final /* synthetic */ py.k b;

    public static final class a implements p0 {
        public final /* synthetic */ c a;

        public a(c r1) {
            this.a = r1;
        }

        public final /* synthetic */ void a(ImageInfo r1, Animatable r2) {
        }

        public final /* synthetic */ void b(py.k r1, Exception r2) {
        }

        public final /* synthetic */ void d(ImageInfo r1) {
        }

        public final /* synthetic */ void e(py.k r1) {
        }

        public final void c(py.k r1, int r2, int r3, boolean r4) {
            if (r2 <= 0) goto L5;
            a1.p(this.a.a, UtilityKotlinExtentionsKt.i(r2 / 3));
            return;
        }
    }

    public c(HSImageView r1, py.k r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ImageUtil.loadImage(this.a, this.b, new a(this));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
