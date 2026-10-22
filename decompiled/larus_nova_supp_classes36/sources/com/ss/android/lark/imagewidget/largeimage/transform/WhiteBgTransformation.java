package com.ss.android.lark.imagewidget.largeimage.transform;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import com.ss.android.lark.utils.UIHelper;
import java.security.MessageDigest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0096\u0002J\b\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J(\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\rH\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u001a"}, d2 = {"Lcom/ss/android/lark/imagewidget/largeimage/transform/WhiteBgTransformation;", "Lcom/bumptech/glide/load/resource/bitmap/BitmapTransformation;", "<init>", "()V", "paint", "Landroid/graphics/Paint;", "getPaint", "()Landroid/graphics/Paint;", "equals", "", INotificationHitPoint.NoticeType.OTHER, "", "hashCode", "", "updateDiskCacheKey", "", "messageDigest", "Ljava/security/MessageDigest;", "transform", "Landroid/graphics/Bitmap;", "bitmapPool", "Lcom/bumptech/glide/load/engine/bitmap_recycle/BitmapPool;", "toTransform", "outWidth", "outHeight", "Companion", "imagewidget_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class WhiteBgTransformation extends BitmapTransformation {
    public static final a Companion = null;
    private static final String ID = "AlphaTransformation";
    private static final byte[] ID_BYTES = null;
    private final Paint paint;

    public static final class a {
        public a() {
        }
    }

    public int hashCode() {
        return -2144298009;
    }

    static {
        Companion = new a();
        ID_BYTES = ID.getBytes(Key.CHARSET);
    }

    public WhiteBgTransformation() {
        this.paint = new Paint();
    }

    public final Paint getPaint() {
        return this.paint;
    }

    public boolean equals(Object r1) {
        return r1 instanceof WhiteBgTransformation;
    }

    public void updateDiskCacheKey(MessageDigest r2) {
        Intrinsics.checkNotNullParameter(r2, "messageDigest");
        r2.update(ID_BYTES);
    }

    public Bitmap transform(BitmapPool r2, Bitmap r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "bitmapPool");
        Intrinsics.checkNotNullParameter(r3, "toTransform");
        int r6 = r3.getWidth();
        int r7 = r3.getHeight();
        if (r3.getConfig() == null) goto L5;
        Bitmap.Config r0 = r3.getConfig();
    L6:
        Bitmap r8 = r2.get(r6, r7, r0);
        r8.setHasAlpha(true);
        Canvas r9 = new Canvas(r8);
        r9.drawColor(UIHelper.getColor(2131106521));
        r9.drawBitmap(r3, 0.0f, 0.0f, this.paint);
        return r8;
    L5:
        r0 = Bitmap.Config.ARGB_8888;
        goto L6
    }
}
