package com.larus.voicecall.impl.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.widget.CircleSimpleDraweeView;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.platform.service.o2;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class j {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public j() {
    }

    public static void b(Bitmap r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Canvas r0 = new Canvas(r5);
        Path r1 = new Path();
        r1.addCircle(r5.getWidth() / 2, r5.getHeight() / 2, r5.getWidth() / 2, Path.Direction.CW);
        r1.toggleInverseFillType();
        Paint r6 = new Paint(1);
        r6.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        r0.drawPath(r1, r6);
    }

    public static void a(final CircleSimpleDraweeView r4, final CircleSimpleDraweeView r5, final boolean r6) {
        String r0 = "res://" + AppHost.a.getApplication().getPackageName() + '/' + o2.a.c();
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r5, "realtimeCallAvatarFirstFrame");
        Intrinsics.checkNotNullParameter(r0, "uriString");
        FLogger.a.i("RealtimeCallAvatarUtils", "default setAvatarWebp, uriString: " + r0);
        final ImageDecodeOptions r1 = ImageDecodeOptions.newBuilder().setForceStaticImage(r6).build();
        ImageLoaderKt.y(r4, r0, "realtime_call_bot_avatar", new g(r1, r4, r6, r5), 4);
    }
}
