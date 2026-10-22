package com.bytedance.android.live.liveinteract.videotalk.avatarmix.bitmap;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Path;
import android.view.View;
import com.bytedance.android.live.liveinteract.videotalk.avatarmix.MicseatType;
import com.bytedance.android.live.liveinteract.videotalk.avatarmix.d;
import com.bytedance.android.live.liveinteract.videotalk.avatarmix.f;
import com.bytedance.android.live.liveinteract.videotalk.avatarmix.g;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.ui.image.FrescoImageView;
import io.reactivex.Single;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c {
    public final LynxView a;

    public static final class a {
    }

    static {
    }

    public c(LynxView r2) {
        Intrinsics.checkNotNullParameter(r2, "container");
        this.a = r2;
    }

    public final Single<Bitmap> a(d r13) {
        Intrinsics.checkNotNullParameter(r13, "micseatStruct");
        if (r13.getType() != MicseatType.Empty) goto L5;
        String r14 = r13.c;
        int r0 = g.a;
        Intrinsics.checkNotNullParameter(r14, "url");
        return Single.create(new f(r14));
    L5:
        LynxView r1 = this.a;
        int r15 = r13.f;
        View r2 = r1.findViewByName("micseat_container_" + r15);
        View r3 = r1.findViewByName("micseat_background_" + r15);
        final FrescoImageView r16 = r1.findViewByName("micseat_guest_avatar_" + r15);
        if (r2 == null) goto L33;
        if (r3 == null) goto L33;
        if (r16 == null) goto L33;
        if ((r3 instanceof FrescoImageView) == false) goto L41;
        if ((r16 instanceof FrescoImageView) == false) goto L41;
        if (r2.getWidth() <= 0) goto L40;
        if (r2.getHeight() <= 0) goto L40;
        int r4 = r2.getWidth();
        int r5 = r2.getHeight();
        Bitmap.Config r6 = Bitmap.Config.ARGB_8888;
        Intrinsics.checkNotNullParameter(r6, "config");
        Bitmap r7 = Bitmap.createBitmap(r4, r5, r6);
        Canvas r8 = new Canvas(r7);
        MicseatBitmapMakerKt.a(r3, r8);     // Catch: Throwable -> L28
        int[] r9 = new int[2];     // Catch: Throwable -> L28
        r16.getLocationInWindow(r9);     // Catch: Throwable -> L28
        int[] r10 = new int[2];     // Catch: Throwable -> L28
        r2.getLocationInWindow(r10);     // Catch: Throwable -> L28
        final int r11 = r9[0] - r10[0];     // Catch: Throwable -> L28
        final int r12 = r9[1] - r10[1];     // Catch: Throwable -> L28
        Path r17 = new Path();     // Catch: Throwable -> L28
        r17.addCircle((r16.getWidth() / 2) + r11, (r16.getHeight() / 2) + r12, RangesKt.coerceAtMost(r16.getWidth(), r16.getHeight()) / 2, Path.Direction.CW);     // Catch: Throwable -> L28
        Function1<Canvas, Unit> r18 = new MicseatBitmapMaker$makeGuestMicseatBitmap$1(r11, r12, r16);     // Catch: Throwable -> L28
        Intrinsics.checkNotNullParameter(r8, "$this$withClip");     // Catch: Throwable -> L28
        Intrinsics.checkNotNullParameter(r17, "clipPath");     // Catch: Throwable -> L28
        Intrinsics.checkNotNullParameter(r18, "block");     // Catch: Throwable -> L28
        int r19 = r8.save();     // Catch: Throwable -> L28
        r8.clipPath(r17);     // Catch: Throwable -> L28
        r18.invoke(r8);     // Catch: Throwable -> L25
        r8.restoreToCount(r19);     // Catch: Throwable -> L28
        r8.clipRect(0, 0, r2.getWidth(), r2.getHeight());     // Catch: Throwable -> L28
        return Single.just(r7);
    L25:
        th = move-exception;
        r8.restoreToCount(r19);     // Catch: Throwable -> L28
        throw th;     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        return Single.error(th);
    L40:
        return Single.error(new Throwable("micseat view size is invalid"));
    L41:
        return Single.error(new Throwable("micseat view type is invalid"));
    L33:
        return Single.error(new Throwable("micseat view is null"));
    }
}
