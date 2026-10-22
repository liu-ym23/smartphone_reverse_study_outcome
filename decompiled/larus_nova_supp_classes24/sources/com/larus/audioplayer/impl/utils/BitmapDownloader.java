package com.larus.audioplayer.impl.utils;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.imagepipeline.image.CloseableImage;
import com.larus.utils.logger.FLogger;
import com.larus.utils.z0;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class BitmapDownloader {

    public static final class a extends BaseDataSubscriber<CloseableReference<CloseableImage>> {
        public final /* synthetic */ Function1<Bitmap, Unit> a;
        public final /* synthetic */ Function1<String, Unit> b;
        public final /* synthetic */ String c;

        public final void onFailureImpl(DataSource<CloseableReference<CloseableImage>> r3) {
            Intrinsics.checkNotNullParameter(r3, "dataSource");
            FLogger.a.e("BitmapDownloader", "Bitmap download fails. url: " + this.c);
            Function1<String, Unit> r4 = this.b;
            if (r4 == null) goto L6;
            r4.invoke("Bitmap download fails.");
            return;
        }

        public final void onNewResultImpl(DataSource<CloseableReference<CloseableImage>> r5) {
            Intrinsics.checkNotNullParameter(r5, "dataSource");
            if (r5.isFinished() == false) goto L21;
            CloseableReference r6 = (CloseableReference) r5.getResult();
            if (r6 == null) goto L26;
            Object r0 = r6.get();     // Catch: Throwable -> L12 Exception -> L14
            Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.facebook.imagepipeline.image.CloseableBitmap");     // Catch: Throwable -> L12 Exception -> L14
            Bitmap r1 = ((CloseableBitmap) r0).getUnderlyingBitmap();     // Catch: Throwable -> L12 Exception -> L14
            if (r1 != null) goto L9;
        L18:
            r6.close();
            return;
        L9:
            if (r1.isRecycled() == true) goto L18;
            Bitmap r2 = r1.copy(z0.b(r1.getConfig()), r1.isMutable());     // Catch: Throwable -> L12 Exception -> L14
            Function1<Bitmap, Unit> r3 = this.a;     // Catch: Throwable -> L12 Exception -> L14
            Intrinsics.checkNotNull(r2);     // Catch: Throwable -> L12 Exception -> L14
            r3.invoke(r2);     // Catch: Throwable -> L12 Exception -> L14
        L14:
            e = move-exception;
            FLogger.a.e("BitmapDownloader", e.toString());     // Catch: Throwable -> L12
            Function1<String, Unit> r4 = this.b;     // Catch: Throwable -> L12
            if (r4 == null) goto L18;
            r4.invoke(e.toString());     // Catch: Throwable -> L12
            goto L18
        L26:
            return;
        L12:
            th = move-exception;
            r6.close();
            throw th;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(Function1<? super Bitmap, Unit> r1, Function1<? super String, Unit> r2, String r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    static {
    }

    public static void a(String r7, Function1 r8, Function1 r9) {
        Intrinsics.checkNotNullParameter(r7, "url");
        Intrinsics.checkNotNullParameter(r8, "onSuccess");
        a r0 = new a(r8, r9, r7);
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new BitmapDownloader$downloadByUrl$1(r7, r0, null), 3, null);
    }
}
