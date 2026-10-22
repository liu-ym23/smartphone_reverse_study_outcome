package com.facebook.imagepipeline.blurhash;

import android.graphics.Bitmap;
import com.facebook.imagepipeline.core.PriorityThreadFactory;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes2.dex */
public class BlurDecodeProducer {
    public static final int d = 0;
    public static ExecutorService e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f7990a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BlurHashConfig f7991b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final BlurDecodeCallBack f7992c;

    public interface BlurDecodeCallBack {
        void a(Bitmap r5);
    }

    static {
        d = Runtime.getRuntime().availableProcessors();
    }

    public BlurDecodeProducer(String r5, BlurHashConfig r10, BlurDecodeCallBack r11) {
        Runnable r12 = new AnonymousClass1(this);
        if (e != null) goto L5;
        e = Executors.newFixedThreadPool(d, new PriorityThreadFactory("BlurDecodeExecutor"));
    L5:
        this.f7990a = r5;
        this.f7991b = r10;
        this.f7992c = r11;
        e.execute(r12);
    }
}
