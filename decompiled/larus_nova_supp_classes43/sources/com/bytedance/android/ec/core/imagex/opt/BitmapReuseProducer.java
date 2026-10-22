package com.bytedance.android.ec.core.imagex.opt;

import com.bytedance.common.utility.Logger;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.producers.Consumer;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.ProducerContext;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class BitmapReuseProducer implements Producer<CloseableReference<CloseableImage>> {
    public static final Lazy a = null;
    public static final a b = null;

    public static final class a {
        public a() {
        }
    }

    public BitmapReuseProducer() {
    }

    static {
        b = new a();
        a = LazyKt.lazy(BitmapReuseProducer$Companion$bitmapReuseProducer$2.INSTANCE);
    }

    public final void produceResults(Consumer<CloseableReference<CloseableImage>> r10, ProducerContext r11) {
        CloseableReference<CloseableImage> r0 = null;
        if (r11 == null) goto L11;
        r0 = i.b(((j) r11).a);     // Catch: Throwable -> L8
        if (r10 == null) goto L7;
        r10.onNewResult(r0, 1);     // Catch: Throwable -> L8
    L7:
        Logger.d("BitmapReuseProducer", "onReuse success");     // Catch: Throwable -> L8
    L13:
        CloseableReference.closeSafely(r0);
        return;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ec.core.imagex.opt.BitmapReuseSettableProducerContext");     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        com.bytedance.crash.d.c(th);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        CloseableReference.closeSafely(null);
        throw th;
    }
}
