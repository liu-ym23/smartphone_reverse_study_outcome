package com.larus.dorag.widget.provider;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.RemoteViews;
import com.larus.dora.api.DoraEnableScope;
import com.larus.dora.api.DoraServerResourceType;
import com.larus.dora.api.IDoraService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.io.File;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import t39.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class b {
    public static final b a = null;

    static {
        a = new b();
    }

    public b() {
    }

    public static void a(RemoteViews r7) {
        Intrinsics.checkNotNullParameter(r7, "views");
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L26
        IDoraService r2 = (IDoraService) ServiceManager.get().getService(IDoraService.class);     // Catch: Throwable -> L26
        File r3 = null;
        if (r2 == null) goto L6;
        f r4 = r2.B(DoraEnableScope.G1, DoraServerResourceType.DRAWABLE, "pic_dora_widget_glass.png");     // Catch: Throwable -> L26
    L8:
        if ((r4 instanceof f.b) == false) goto L10;
        f.b r5 = (f.b) r4;     // Catch: Throwable -> L26
    L11:
        if (r5 == null) goto L13;
        r3 = r5.a;     // Catch: Throwable -> L26
    L13:
        if (r3 != null) goto L15;
    L23:
        FLogger.a.i("DoraWidgetGlassImageLoader", "applyGlassImage: dynamic glass image not ready, keep existing image");     // Catch: Throwable -> L26
    L24:
        Object r8 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L26
    L28:
        Throwable r9 = Result.exceptionOrNull-impl(r8);
        if (r9 == null) goto L34;
        FLogger.a.e("DoraWidgetGlassImageLoader", "applyGlassImage failed", r9);
        return;
    L34:
        return;
    L15:
        if (r3.exists() == false) goto L23;
        if (r3.length() == 0) goto L23;
        Bitmap r6 = BitmapFactory.decodeFile(r3.getAbsolutePath());     // Catch: Throwable -> L26
        if (r6 != null) goto L22;
        FLogger.a.i("DoraWidgetGlassImageLoader", "applyGlassImage: decode failed, keep existing image");     // Catch: Throwable -> L26
        goto L24
    L22:
        r7.setImageViewBitmap(2131369501, r6);     // Catch: Throwable -> L26
        FLogger.a.i("DoraWidgetGlassImageLoader", "applyGlassImage: dynamic glass image applied");     // Catch: Throwable -> L26
        goto L24
    L10:
        r5 = null;
        goto L11
    L6:
        r4 = null;
    L26:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L28
    }
}
