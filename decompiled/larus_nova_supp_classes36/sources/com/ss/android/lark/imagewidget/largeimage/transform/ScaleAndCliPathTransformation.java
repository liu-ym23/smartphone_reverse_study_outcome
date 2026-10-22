package com.ss.android.lark.imagewidget.largeimage.transform;

import android.graphics.Bitmap;
import android.graphics.Path;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.MessageDigest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J(\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0014J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0096\u0002J\b\u0010\u001b\u001a\u00020\u0015H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/ss/android/lark/imagewidget/largeimage/transform/ScaleAndCliPathTransformation;", "Lcom/bumptech/glide/load/resource/bitmap/BitmapTransformation;", "scaleX", "", "scaleY", "clipPath", "", "path", "Landroid/graphics/Path;", "<init>", "(FFLjava/lang/String;Landroid/graphics/Path;)V", "updateDiskCacheKey", "", "messageDigest", "Ljava/security/MessageDigest;", "transform", "Landroid/graphics/Bitmap;", "pool", "Lcom/bumptech/glide/load/engine/bitmap_recycle/BitmapPool;", "inBitmap", "width", "", "height", "equals", "", INotificationHitPoint.NoticeType.OTHER, "", "hashCode", "Companion", "imagewidget_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class ScaleAndCliPathTransformation extends BitmapTransformation {
    public static final a Companion = null;
    private static final String ID = "com.bytedance.ee.bear.thumbnail.ScaleAndCliPathTransformation";
    private static final byte[] ID_BYTES = null;
    private static final String TAG = "ScaleAndCliPathTransformation";
    private final String clipPath;
    private final Path path;
    private final float scaleX;
    private final float scaleY;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
        ID_BYTES = ID.getBytes(Key.CHARSET);
    }

    public int hashCode() {
        int r0 = ((Float.floatToIntBits(this.scaleX) * 31) + Float.floatToIntBits(this.scaleY)) * 31;
        String r1 = this.clipPath;
        if (r1 == null) goto L5;
        int r2 = r1.hashCode();
    L7:
        return r0 + r2;
    L5:
        r2 = 0;
        goto L7
    }

    public boolean equals(Object r5) {
        if ((r5 instanceof ScaleAndCliPathTransformation) == true) goto L5;
        return false;
    L5:
        ScaleAndCliPathTransformation r6 = (ScaleAndCliPathTransformation) r5;
        if (this.scaleX != r6.scaleX) goto L8;
        boolean r0 = true;
    L9:
        if (r0 == true) goto L12;
        return false;
    L12:
        if (this.scaleY != r6.scaleY) goto L14;
        boolean r1 = true;
    L15:
        if (r1 == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.clipPath, r6.clipPath) == true) goto L20;
        return false;
    L20:
        return true;
    L14:
        r1 = false;
        goto L15
    L8:
        r0 = false;
        goto L9
    }

    public void updateDiskCacheKey(MessageDigest r3) {
        Intrinsics.checkNotNullParameter(r3, "messageDigest");
        r3.update(ID_BYTES);
        ByteBuffer r0 = ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN);
        r0.putInt(Float.floatToIntBits(this.scaleX));
        r0.putInt(Float.floatToIntBits(this.scaleY));
        r3.update(r0.array());
        String r1 = this.clipPath;
        if (r1 == null) goto L6;
        byte[] r2 = r1.getBytes(Charsets.UTF_8);
        if (r2 == null) goto L6;
    L7:
        r3.update(r2);
        return;
    L6:
        r2 = new byte[0];
        goto L7
    }

    public ScaleAndCliPathTransformation(float r1, float r2, String r3, Path r4) {
        this.scaleX = r1;
        this.scaleY = r2;
        this.clipPath = r3;
        this.path = r4;
    }

    public Bitmap transform(final BitmapPool r7, Bitmap r8, int r9, int r10) {
        Intrinsics.checkNotNullParameter(r7, "pool");
        Intrinsics.checkNotNullParameter(r8, "inBitmap");
        int r11 = com.ss.android.lark.imagewidget.largeimage.transform.a.a;
        float r1 = this.scaleX;
        float r2 = this.scaleY;
        Path r3 = this.path;
        String r12 = this.clipPath;
        if (r12 != null) goto L5;
    L8:
        boolean r13 = true;
    L9:
        Bitmap r14 = com.ss.android.lark.imagewidget.largeimage.transform.a.a(r8, r1, r2, r3, !r13, new ScaleAndCliPathTransformation$transform$outBitmap$1(r7));
        Log.d(TAG, "transform result=" + r14.getWidth() + 'x' + r14.getHeight());
        return r14;
    L5:
        if (r12.length() == 0) goto L8;
        r13 = false;
        goto L9
    }
}
