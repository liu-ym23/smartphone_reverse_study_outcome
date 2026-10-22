package com.ss.android.lark.image.impl;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.engine.GlideException;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.api.DataSource;
import com.ss.android.lark.image.api.DiskCacheStrategy;
import com.ss.android.lark.image.api.IRequestCreator;
import com.ss.android.lark.image.api.Target;
import com.ss.android.lark.image.utils.c;
import com.ss.android.lark.image.utils.d;
import com.ss.android.lark.log.Log;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;
import rkb.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\fB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/image/impl/InlineRequestCreator;", "", "<init>", "()V", "generate", "Lcom/ss/android/lark/image/api/IRequestCreator;", "context", "Landroid/content/Context;", "loadKey", "", "inlineString", "Lokio/ByteString;", "InlineRequestListener", "image_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class InlineRequestCreator {
    public static final InlineRequestCreator INSTANCE = null;

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000 \u001b2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001bB\u0011\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J:\u0010\u000e\u001a\u00020\u000f2\u000e\u0010\u0010\u001a\n\u0018\u00010\u0011j\u0004\u0018\u0001`\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00022\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u000fH\u0016J<\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u00022\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00152\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0016\u001a\u00020\u000fH\u0016R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/ss/android/lark/image/impl/InlineRequestCreator$InlineRequestListener;", "Lcom/ss/android/lark/image/api/RequestListener;", "", "Landroid/graphics/drawable/Drawable;", "loadKey", "", "<init>", "(Ljava/lang/String;)V", "getLoadKey", "()Ljava/lang/String;", "start", "", "inlineInfo", "Lcom/ss/android/lark/image/utils/InlineInfo;", "onLoadFailed", "", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "model", "target", "Lcom/ss/android/lark/image/api/Target;", "isFirstResource", "onResourceReady", "resource", "dataSource", "Lcom/ss/android/lark/image/api/DataSource;", "Companion", "image_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class InlineRequestListener implements g<byte[], Drawable> {
        public static final Companion Companion = null;
        private final d inlineInfo;
        private final String loadKey;
        private final long start;

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/image/impl/InlineRequestCreator$InlineRequestListener$Companion;", "", "<init>", "()V", "TAG", "", "image_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r1) {
                this();
            }
        }

        static {
            Companion = new Companion(null);
        }

        public InlineRequestListener(String r4) {
            this.loadKey = r4;
            this.start = System.currentTimeMillis();
            this.inlineInfo = new d(0, null, 63);
        }

        /* JADX INFO: renamed from: onLoadFailed, reason: avoid collision after fix types in other method */
        public boolean onLoadFailed2(Exception r3, byte[] r4, Target<Drawable> r5, boolean r6) {
            if ((r3 instanceof GlideException) == false) goto L5;
            int r7 = ((GlideException) r3).getErrorCode();
        L6:
            if (r3 == null) goto L9;
            String r8 = r3.getMessage();
            if (r8 == null) goto L9;
        L10:
            Log.e("InlineRequestListener", "onLoadFailed, loadKey:" + this.loadKey + ",errorCode:" + r7 + ",errorMsg:" + r8);
            d r9 = this.inlineInfo;
            r9.a = r7;
            Intrinsics.checkNotNullParameter(r8, "<set-?>");
            r9.b = r8;
            this.inlineInfo.c = (int) (System.currentTimeMillis() - this.start);
            d r10 = this.inlineInfo;
            if (r4 == null) goto L13;
            int r11 = r4.length;
        L14:
            r10.d = r11;
            c.a(r10);
            return false;
        L13:
            r11 = 0;
        L9:
            r8 = "no msg";
            goto L10
        L5:
            r7 = 2;
            goto L6
        }

        @Override // rkb.g
        public /* bridge */ /* synthetic */ boolean onLoadFailed(Exception r1, byte[] r2, Target<Drawable> r3, boolean r4) {
            return onLoadFailed2(r1, r2, r3, r4);
        }

        /* JADX INFO: renamed from: onResourceReady, reason: avoid collision after fix types in other method */
        public boolean onResourceReady2(Drawable r3, byte[] r4, Target<Drawable> r5, DataSource r6, boolean r7) {
            Intrinsics.checkNotNullParameter(r3, "resource");
            Log.i("InlineRequestListener", "onResourceReady, loadKey:" + this.loadKey);
            this.inlineInfo.c = (int) (System.currentTimeMillis() - this.start);
            d r8 = this.inlineInfo;
            if (r4 == null) goto L5;
            int r9 = r4.length;
        L6:
            r8.d = r9;
            r8.e = r3.getIntrinsicWidth();
            this.inlineInfo.f = r3.getIntrinsicHeight();
            int r10 = c.a;
            c.a(this.inlineInfo);
            return false;
        L5:
            r9 = 0;
            goto L6
        }

        @Override // rkb.g
        public /* bridge */ /* synthetic */ boolean onResourceReady(Drawable r1, byte[] r2, Target<Drawable> r3, DataSource r4, boolean r5) {
            return onResourceReady2(r1, r2, r3, r4, r5);
        }
    }

    static {
        INSTANCE = new InlineRequestCreator();
    }

    private InlineRequestCreator() {
    }

    @JvmStatic
    public static final IRequestCreator generate(Context r1, String r2, ByteString r3) {
        Intrinsics.checkNotNullParameter(r1, "context");
        if (r3 == null) goto L8;
        byte[] r4 = r3.toByteArray();
        if (r4 == null) goto L8;
        return ImageLoader.with(r1).load(r4).diskCacheStrategy(DiskCacheStrategy.NONE).listener(new InlineRequestListener(r2));
    L8:
        int r5 = c.a;
        c.a(new d(1, "inline is null", 60));
        return null;
    }
}
