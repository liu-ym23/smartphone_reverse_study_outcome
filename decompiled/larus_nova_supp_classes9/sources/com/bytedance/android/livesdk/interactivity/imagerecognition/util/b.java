package com.bytedance.android.livesdk.interactivity.imagerecognition.util;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerView;
import h80.c;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.jvm.internal.Intrinsics;
import s32.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b<T> implements ObservableOnSubscribe {
    public final /* synthetic */ LivePlayerView a;
    public final /* synthetic */ Bitmap b;
    public final /* synthetic */ Integer c;

    public b(LivePlayerView r1, Bitmap r2, Integer r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void subscribe(ObservableEmitter<c<Bitmap>> r15) {
        Intrinsics.checkNotNullParameter(r15, "emitter");
        long r0 = System.currentTimeMillis();
        int r2 = this.a.getWidth();
        int r3 = this.a.getHeight();
        int r4 = this.b.getWidth();
        int r5 = this.b.getHeight();
        int r7 = UtilityKotlinExtentionsKt.i(12);
        int r6 = UtilityKotlinExtentionsKt.i(12);
        int r8 = UtilityKotlinExtentionsKt.i(140);
        int r9 = UtilityKotlinExtentionsKt.i(36);
        if ((r5 / r4) <= (r3 / r2)) goto L5;
        float r10 = r2 / r4;
        float r11 = (((r5 * r10) - r3) * 0.5f) + r8;
        float r13 = 0.0f;
    L6:
        Bitmap r14 = this.b;
        if (r14 != null) goto L9;
        return;
    L9:
        if (r14.getConfig() == null) goto L27;
        int r16 = (r2 - r7) - r6;
        int r17 = (r3 - r8) - r9;
        Integer r18 = null;
        Matrix r19 = new Matrix();     // Catch: IllegalArgumentException -> L13
        r19.setScale(r10, r10);     // Catch: IllegalArgumentException -> L13
        r19.postTranslate(-r13, -r11);     // Catch: IllegalArgumentException -> L13
        Bitmap.Config r20 = this.b.getConfig();     // Catch: IllegalArgumentException -> L13
        Intrinsics.checkNotNull(r20);     // Catch: IllegalArgumentException -> L13
        Bitmap r21 = Bitmap.createBitmap(r16, r17, r20);     // Catch: IllegalArgumentException -> L13
        Canvas r23 = new Canvas(r21);     // Catch: IllegalArgumentException -> L13
        r23.concat(r19);     // Catch: IllegalArgumentException -> L13
        r23.drawBitmap(this.b, 0.0f, 0.0f, new Paint(6));     // Catch: IllegalArgumentException -> L13
    L15:
        long r24 = System.currentTimeMillis() - r0;
        int r1 = f.a;
        StringBuilder r25 = new StringBuilder("cropDuration=");
        r25.append(r24);
        r25.append(" frameSize=");
        r25.append(this.b.getWidth());
        r25.append('*');
        r25.append(this.b.getHeight());
        r25.append(" playerViewSize=");
        r25.append(r2);
        r25.append('*');
        r25.append(r3);
        r25.append(" cropSize=");
        if (r21 == null) goto L18;
        Integer r26 = Integer.valueOf(r21.getWidth());
    L19:
        r25.append(r26);
        r25.append('*');
        if (r21 == null) goto L22;
        r18 = Integer.valueOf(r21.getHeight());
    L22:
        r25.append(r18);
        r25.append(" scaleType=");
        r25.append(this.c);
        f.b(r25.toString());
        r15.onNext(c.c(r21));
        return;
    L18:
        r26 = null;
    L13:
        e = move-exception;
        int r27 = f.a;
        Intrinsics.checkNotNullParameter("crop image failed", "info");
        Intrinsics.checkNotNullParameter(e, "t");
        ALogger.e("ImageRecognition", "crop image failed", e);
        r21 = null;
        goto L15
    L27:
        return;
    L5:
        r10 = r3 / r5;
        r13 = (((r4 * r10) - r2) * 0.5f) + r7;
        r11 = 0.0f;
        goto L6
    }
}
