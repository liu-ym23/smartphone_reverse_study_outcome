package com.bytedance.android.livesdk.chatroom.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.util.JsonReader;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieListener;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.z5;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.android.livesdk.gecko.offline.OfflineResourceClient;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import java.io.File;
import java.util.zip.ZipInputStream;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class i2 {
    public static final String a = null;

    public static final class a implements com.airbnb.lottie.d {
        public final /* synthetic */ Pair a;

        public a(Pair r1) {
            this.a = r1;
        }

        public final Bitmap q(com.airbnb.lottie.h r3) {
            return BitmapFactory.decodeFile(((String) this.a.getFirst()) + '/' + r3.d);
        }
    }

    public static final class b implements OfflineResourceClient.a {
        public final /* synthetic */ String a;
        public final /* synthetic */ LottieAnimationView b;

        public static final class a<T> implements LottieListener {
            public final /* synthetic */ b a;
            public final /* synthetic */ Ref.ObjectRef b;

            public a(b r1, Ref.ObjectRef r2) {
                this.a = r1;
                this.b = r2;
            }

            public final void onResult(Object r2) {
                LottieComposition r3 = (LottieComposition) r2;
                if (r3 == null) goto L5;
                this.a.b.setComposition(r3);
                this.a.b.loop(true);
                this.a.b.playAnimation();
            L5:
                ((ZipInputStream) this.b.element).close();
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.utils.i2$b$b, reason: collision with other inner class name */
        public static final class C0033b<T> implements LottieListener {
            public final /* synthetic */ Ref.ObjectRef a;

            public C0033b(Ref.ObjectRef r1) {
                this.a = r1;
            }

            public final void onResult(Object r3) {
                Throwable r4 = (Throwable) r3;
                ((ZipInputStream) this.a.element).close();
                StringBuilder r0 = new StringBuilder("result:");
                if (r4 == null) goto L5;
                String r5 = r4.getMessage();
            L6:
                r0.append(r5);
                ALogger.d("OfflineImageUtils", r0.toString());
                return;
            L5:
                r5 = null;
                goto L6
            }
        }

        @Override // com.bytedance.android.livesdk.gecko.offline.OfflineResourceClient.a
        public final void onError(Throwable r3) {
            StringBuilder r0 = new StringBuilder("download ");
            r0.append(this.a);
            r0.append(" failed, ");
            if (r3 == null) goto L5;
            String r4 = r3.getMessage();
        L6:
            r0.append(r4);
            ALogger.e("OfflineImageUtils", r0.toString());
            return;
        L5:
            r4 = null;
            goto L6
        }

        @Override // com.bytedance.android.livesdk.gecko.offline.OfflineResourceClient.a
        public final void onSuccess(String r6) {
            ALogger.i("OfflineImageUtils", "download " + this.a + " success, filePath = " + r6);
            String r0 = i2.a;
            if (r6 != null) goto L5;
        L8:
            boolean r2 = true;
        L10:
            if ((true ^ r2) == false) goto L22;
            Ref.ObjectRef r1 = new Ref.ObjectRef();
            r1.element = null;
            ZipInputStream r3 = new ZipInputStream(new PolarisFileInputStreamWrapper(r6));     // Catch: Exception -> L14
            r1.element = r3;     // Catch: Exception -> L14
            ZipInputStream r7 = r3;     // Catch: Exception -> L14
            LottieCompositionFactory.fromZipStream(r3, null).addListener(new a(this, r1)).addFailureListener(new C0033b(r1));     // Catch: Exception -> L14
            return;
        L14:
            e = move-exception;
            ZipInputStream r4 = (ZipInputStream) r1.element;
            if (r4 == null) goto L18;
            r4.close();
        L18:
            ALogger.d("OfflineImageUtils", "e:" + e.getMessage());
            return;
        L22:
            return;
        L5:
            if (StringsKt.isBlank(r6) == true) goto L8;
            r2 = false;
            goto L10
        }

        public b(String r1, LottieAnimationView r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
        StringBuilder r0 = new StringBuilder("https://");
        IMiddleWareHostContext r1 = jc1.k.f(IMiddleWareHostContext.class);
        boolean r2 = false;
        if (r1 == null) goto L8;
        if (r1.isBoe() == false) goto L8;
        String r3 = "tosv-boe.byted.org";
    L14:
        r0.append(r3);
        r0.append("/obj/");
        IMiddleWareHostContext r4 = jc1.k.f(IMiddleWareHostContext.class);
        if (r4 == null) goto L20;
        if (r4.isBoe() == false) goto L20;
        String r5 = "gecko-internal/10893";
    L26:
        r0.append(r5);
        r0.append("/gecko/resource/webcast_native_resource_douyin");
        a = r0.toString();
        return;
    L20:
        if (((Boolean) z5.a.getValue()).booleanValue() == true) goto L23;
        r2 = com.bytedance.android.live.core.utils.v.a();
    L23:
        if (r2 == false) goto L25;
        r5 = "gecko-internal/10180";
        goto L26
    L25:
        r5 = "byte-gurd-source/10181";
    L8:
        if (((Boolean) z5.a.getValue()).booleanValue() == false) goto L10;
        boolean r6 = false;
    L11:
        if (r6 == false) goto L13;
        r3 = "tosv.byted.org";
        goto L14
    L13:
        r3 = "lf-webcast-sourcecdn-tos.bytegecko.com";
        goto L14
    L10:
        r6 = com.bytedance.android.live.core.utils.v.a();
        goto L11
    }

    public static Pair a(String r3) {
        if (r3 == null) goto L5;
        String r1 = b(r3);
        File r2 = com.bytedance.android.livesdk.gecko.offline.f.a(r1);
        if (r2 == null) goto L13;
        Bitmap r4 = BitmapFactory.decodeFile(r2.getAbsolutePath());
        if (r4 == null) goto L13;
        ALogger.e("OfflineImageUtils", r3.concat("_命中离线资源"));
        return TuplesKt.to(r4, r1);
    L13:
        return TuplesKt.to(null, r1);
    L5:
        return TuplesKt.to(null, null);
    }

    public static String b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        return a + r2;
    }

    @JvmStatic
    public static final Uri c(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        String r3 = b(r2);
        File r0 = com.bytedance.android.livesdk.gecko.offline.f.a(r3);
        if (r0 == null) goto L5;
        Uri r4 = Uri.fromFile(r0);
    L6:
        ALogger.i("OfflineImageUtils", "离线文件地址为" + r4);
        return r4;
    L5:
        r4 = UriProtector.parse(r3);
        goto L6
    }

    @JvmStatic
    public static final Uri d(String r4) {
        Intrinsics.checkNotNullParameter("/drawer/", "geckoPath");
        Intrinsics.checkNotNullParameter(r4, "assetFilePath");
        if (((Boolean) com.bytedance.android.live.core.setting.o.a.getValue()).booleanValue() == false) goto L6;
        return c("/drawer/" + StringsKt.substringAfterLast$default(r4, '/', null, 2, null));
    L6:
        return UriProtector.parse(r4);
    }

    public static void e(HSImageView r3, String r4) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r4 != null) goto L6;
    L9:
        boolean r1 = true;
    L10:
        if (r1 == true) goto L21;
        Pair r2 = a(r4);
        Bitmap r5 = (Bitmap) r2.component1();
        String r6 = (String) r2.component2();
        if (r5 == null) goto L15;
        ALogger.e("OfflineImageUtils", r4 + "_命中离线资源");
        r3.setImageBitmap(r5);
        return;
    L15:
        if (r6 != null) goto L17;
        return;
    L17:
        py.k r7 = vh7.f.c(py.k.class);
        r7.setUrls(CollectionsKt.listOf(r6));
        ImageUtil.loadImage(r3, r7, 0);
        return;
    L21:
        return;
    L6:
        if (r4.length() == 0) goto L9;
        r1 = false;
        goto L10
    }

    public static boolean f(LottieAnimationView r7, String r8) {
        Intrinsics.checkNotNullParameter(r7, "lottieView");
        Intrinsics.checkNotNullParameter(r8, "key");
        Pair r2 = com.bytedance.android.livesdk.gecko.offline.f.b(b(r8));     // Catch: Throwable -> L9
        if (r2 != null) goto L6;
        return false;
    L6:
        ALogger.e("OfflineImageUtils", r8.concat("_命中离线资源"));     // Catch: Throwable -> L9
        r7.setImageAssetsFolder((String) r2.getFirst());     // Catch: Throwable -> L9
        r7.setAnimation(new JsonReader(new PolarisFileReaderWrapper(((String) r2.getFirst()) + '/' + ((String) r2.getSecond()))), r8);     // Catch: Throwable -> L9
        r7.setImageAssetDelegate(new a(r2));     // Catch: Throwable -> L9
        return true;
    L9:
        th = move-exception;
        ALogger.e("OfflineImageUtils", th);
        return false;
    }

    public static void g(LottieAnimationView r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "lottieView");
        Intrinsics.checkNotNullParameter(r2, "zipKey");
        b r0 = new b(r2, r1);
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r0, "callback");
        boolean r3 = OfflineResourceClient.a;
        OfflineResourceClient.c(b(r2), r0);
    }

    public static void h(HSImageView r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$loadOfflineImg");
        Intrinsics.checkNotNullParameter(r2, "key");
        e(r1, r2);
    }
}
