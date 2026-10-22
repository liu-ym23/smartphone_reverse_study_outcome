package com.xiphias.browser.scanner.a;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.net.Uri;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/xiphias/browser/scanner/document/DocumentImageDecoder;", "", "<init>", "()V", "decode", "Landroid/graphics/Bitmap;", "contentResolver", "Landroid/content/ContentResolver;", "uri", "Landroid/net/Uri;", "MAX_LONG_EDGE", "", "scanner_selectedRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f16318a = null;

    static {
        f16318a = new a();
    }

    private a() {
    }

    private static final void a(ImageDecoder r2, ImageDecoder.ImageInfo r3, ImageDecoder.Source r4) {
        Intrinsics.checkNotNullParameter(r2, "decoder");
        Intrinsics.checkNotNullParameter(r3, "info");
        Intrinsics.checkNotNullParameter(r4, "<unused var>");
        r2.setAllocator(1);
        int r0 = Math.max(r3.getSize().getWidth(), r3.getSize().getHeight());
        if (r0 <= 4096) goto L6;
        float r1 = 4096.0f / r0;
        r2.setTargetSize(RangesKt.coerceAtLeast(MathKt.roundToInt(r3.getSize().getWidth() * r1), 1), RangesKt.coerceAtLeast(MathKt.roundToInt(r3.getSize().getHeight() * r1), 1));
        return;
    }

    public static /* synthetic */ void lambda$LOqUn6czERW9dFKNhWX0l661TZI(ImageDecoder r0, ImageDecoder.ImageInfo r1, ImageDecoder.Source r2) {
        a(r0, r1, r2);
    }

    public final Bitmap a(ContentResolver r1, Uri r2) {
        Intrinsics.checkNotNullParameter(r1, "contentResolver");
        Intrinsics.checkNotNullParameter(r2, "uri");
        ImageDecoder.Source r0 = ImageDecoder.createSource(r1, r2);
        Intrinsics.checkNotNullExpressionValue(r0, "createSource(...)");
        Bitmap r3 = ImageDecoder.decodeBitmap(r0, $$Lambda$a$LOqUn6czERW9dFKNhWX0l661TZI.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(r3, "decodeBitmap(...)");
        return r3;
    }
}
