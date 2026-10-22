package com.obric.assistant.cocreationreview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Build;
import android.util.LruCache;
import android.widget.ImageView;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class p {
    public static final ExecutorService a = null;
    public static final b b = null;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[FeedbackMediaType.values().length];
            r0[FeedbackMediaType.IMAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[FeedbackMediaType.VIDEO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public static final class b extends LruCache<String, Bitmap> {
        public b(int r1) {
            super(r1);
        }

        @Override // android.util.LruCache
        public final int sizeOf(String r2, Bitmap r3) {
            Bitmap r4 = r3;
            Intrinsics.checkNotNullParameter(r2, "key");
            Intrinsics.checkNotNullParameter(r4, "value");
            return RangesKt.coerceAtLeast(r4.getByteCount() / 1024, 1);
        }
    }

    static {
        a = PThreadExecutorsUtils.newFixedThreadPool(2, new DefaultThreadFactory("CocreationFeedbackMediaThumbnailLoader"));
        b = new b(RangesKt.coerceAtLeast((int) ((Runtime.getRuntime().maxMemory() / ((long) 1024)) / ((long) 16)), 4096));
    }

    public static Bitmap b(MediaMetadataRetriever r8, int r9) {
        if (Build.VERSION.SDK_INT >= 27) goto L5;
        Bitmap r10 = r8.getFrameAtTime(0, 2);
        if (r10 == null) goto L16;
        int r0 = Math.max(r10.getWidth(), r10.getHeight());
        if (r0 <= r9) goto L18;
        if (r0 <= 0) goto L20;
        float r11 = r9 / r0;
        Bitmap r12 = Bitmap.createScaledBitmap(r10, RangesKt.coerceAtLeast((int) (r10.getWidth() * r11), 1), RangesKt.coerceAtLeast((int) (r10.getHeight() * r11), 1), true);
        if (r12 == r10) goto L19;
        r10.recycle();
    L19:
        return r12;
    L20:
        return r10;
    L18:
        return r10;
    L16:
        return null;
    L5:
        return r8.getScaledFrameAtTime(0, 2, r9, r9);
    }

    public static Bitmap a(Context r6, Uri r7, int r8) {
        BitmapFactory.Options r0 = new BitmapFactory.Options();
        int r1 = 1;
        r0.inJustDecodeBounds = true;
        InputStream r2 = ContentResolverWrapper.openInputStream(r6.getContentResolver(), r7);
        BitmapFactory.decodeStream(r2, null, r0);     // Catch: Throwable -> L21
        CloseableKt.closeFinally(r2, null);
        BitmapFactory.Options r4 = new BitmapFactory.Options();
    L5:
        int r5 = r8 * 2;
        if ((r0.outWidth / r1) > r5) goto L20;
        if ((r0.outHeight / r1) > r5) goto L20;
        r4.inSampleSize = r1;
        InputStream r9 = ContentResolverWrapper.openInputStream(r6.getContentResolver(), r7);
        if (r9 != null) goto L32;
        return null;
    L32:
        Bitmap r10 = BitmapFactory.decodeStream(r9, null, r4);     // Catch: Throwable -> L14
        CloseableKt.closeFinally(r9, null);
        return r10;
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        CloseableKt.closeFinally(r9, th);
        throw th;
    L20:
        r1 = r1 * 2;
    L21:
        th = move-exception;
        throw th;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        CloseableKt.closeFinally(r2, th);
        throw th;
    }

    public static void c(final ImageView r10, final b5 r11, final int r12) {
        Intrinsics.checkNotNullParameter(r10, "imageView");
        Intrinsics.checkNotNullParameter(r11, "media");
        final String r0 = CollectionsKt.joinToString$default(CollectionsKt.listOf(new Object[]{r11.getType().name(), r11.b, Integer.valueOf(r12)}), "|", null, null, 0, null, null, 62, null);
        r10.setTag(r0);
        Bitmap r1 = b.get(r0);
        if (r1 == null) goto L6;
        r10.setImageBitmap(r1);
        return;
    L6:
        a.execute(new n(r0, r10, r11, r12));
    }

    public static Bitmap d(b5 r5, Uri r6, int r7) {
        String r8 = r6.getPath();
        if (r8 != null) goto L5;
        r8 = r5.b;
    L5:
        FeedbackMediaType r9 = r5.getType();
        int r10 = a.a[r9.ordinal()];
        int r0 = 1;
        if (r10 == 1) goto L16;
        if (r10 != 2) goto L15;
        MediaMetadataRetriever r11 = new MediaMetadataRetriever();
        r11.setDataSource(r8);     // Catch: Throwable -> L11
        Bitmap r12 = b(r11, r7);     // Catch: Throwable -> L11
        r11.release();
        return r12;
    L11:
        th = move-exception;
        r11.release();
        throw th;
    L15:
        throw new NoWhenBranchMatchedException();
    L16:
        BitmapFactory.Options r13 = new BitmapFactory.Options();
        r13.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(r8, r13);
        BitmapFactory.Options r2 = new BitmapFactory.Options();
    L17:
        int r4 = r7 * 2;
        if ((r13.outWidth / r0) > r4) goto L24;
        if ((r13.outHeight / r0) > r4) goto L24;
        r2.inSampleSize = r0;
        return BitmapFactory.decodeFile(r8, r2);
    L24:
        r0 = r0 * 2;
        goto L17
    }
}
