package com.bytedance.android.live.core.utils;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.widget.ImageView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.fresco.FrescoLoader;
import com.bytedance.common.utility.Lists;
import com.bytedance.common.utility.collection.CollectionUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.imagepipeline.image.ImageInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class ImageUtil {
    private static final String TAG = "ImageUtil";

    public interface LoadImageCallback {
        void onFailed(Exception r1);

        void onSuccess(Bitmap r1);
    }

    public class a implements p0 {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ ImageView b;

        @Override // com.bytedance.android.live.core.utils.p0
        public final /* synthetic */ void a(ImageInfo r1, Animatable r2) {
        }

        @Override // com.bytedance.android.live.core.utils.p0
        public final /* synthetic */ void d(ImageInfo r1) {
        }

        @Override // com.bytedance.android.live.core.utils.p0
        public final void e(py.k r4) {
            ALogger.i(ImageUtil.TAG, "[loadAntiFlink] load image stated " + r4.getUri() + " time " + System.currentTimeMillis());
        }

        public a(boolean r1, ImageView r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // com.bytedance.android.live.core.utils.p0
        public final void b(py.k r3, Exception r4) {
            ALogger.i(ImageUtil.TAG, "[loadAntiFlink] load image fail " + r3.getUri() + " Exception info" + r4.getMessage());
        }

        @Override // com.bytedance.android.live.core.utils.p0
        public final void c(py.k r3, int r4, int r5, boolean r6) {
            long r7 = System.currentTimeMillis();
            if (this.a == false) goto L5;
            this.b.setTag(2131389794, new Pair(r3, Long.valueOf(r7)));
        L5:
            ALogger.i(ImageUtil.TAG, "[loadAntiFlink] load image success " + r3.getUri() + " time " + r7);
        }
    }

    private ImageUtil() {
    }

    public static String getImageUrl(py.k r1) {
        if (r1 != null) goto L4;
        return "";
    L4:
        if (Lists.isEmpty(r1.getUrls()) == false) goto L7;
        return "";
    L7:
        return (String) ListProtector.get(r1.getUrls(), 0);
    }

    public static boolean isActivityOK(Context r3) {
        if (r3 != null) goto L6;
        return false;
    L6:
        if ((r3 instanceof Activity) == false) goto L8;
        Activity r4 = (Activity) r3;
        if (r4.isDestroyed() == false) goto L18;
        return false;
    L18:
        return !r4.isFinishing();
    L8:
        if ((r3 instanceof Application) == false) goto L10;
    L13:
        return true;
    L10:
        if ((r3 instanceof ContextWrapper) == false) goto L13;
        return isActivityOK(((ContextWrapper) r3).getBaseContext());
    }

    public static void loadGifImage(ImageView r3, String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L5;
        return;
    L5:
        if (isActivityOK(r3.getContext()) == false) goto L10;
        FrescoLoader.with(r3.getContext()).load(r4).actualScaleType(ImageView.ScaleType.CENTER_CROP).autoPlayAnimations(true).controllerListener(new ImageLoader.e(null, null, false)).into(r3);
        return;
    }

    public static void loadImage(ImageView r3, String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L5;
        return;
    L5:
        if (isActivityOK(r3.getContext()) == false) goto L10;
        FrescoLoader.with(r3.getContext()).load(r4).actualScaleType(ImageView.ScaleType.CENTER_CROP).controllerListener(new ImageLoader.e(null, null, false)).into(r3);
        return;
    }

    public static void loadRoundImage(ImageView r3, py.k r4) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (isActivityOK(r3.getContext()) == false) goto L9;
        FrescoLoader.with(r3.getContext()).load(r4).roundAsCircle().actualScaleType(ImageView.ScaleType.CENTER_CROP).controllerListener(new ImageLoader.e(null, null, false)).into(r3);
        return;
    }

    public static void loadImage(ImageView r3, Integer r4) {
        if (isActivityOK(r3.getContext()) == true) goto L5;
        return;
    L5:
        FrescoLoader.with(r3.getContext()).load(r4.intValue()).actualScaleType(ImageView.ScaleType.CENTER_CROP).controllerListener(new ImageLoader.e(null, null, false)).into(r3);
    }

    public static void loadImage(ImageView r1, py.k r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (CollectionUtils.isEmpty(r2.getUrls()) == true) goto L9;
        loadImage(r1, r2, 0);
        return;
    }

    public static void loadGifImage(ImageView r2, String r3, int r4) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return;
    L5:
        if (isActivityOK(r2.getContext()) == false) goto L10;
        FrescoLoader.with(r2.getContext()).load(r3).actualScaleType(ImageView.ScaleType.CENTER_CROP).placeholder(r4).autoPlayAnimations(true).controllerListener(new ImageLoader.e(null, null, false)).into(r2);
        return;
    }

    public static void loadImage(ImageView r2, String r3, ImageView.ScaleType r4) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return;
    L5:
        if (isActivityOK(r2.getContext()) == false) goto L10;
        FrescoLoader.with(r2.getContext()).load(r3).actualScaleType(r4).controllerListener(new ImageLoader.e(null, null, false)).into(r2);
        return;
    }

    public static void loadRoundImageAntiFlink(ImageView r9, py.k r11, long r12) {
        if (r9 == null) goto L24;
        if (r11 != null) goto L5;
        return;
    L5:
        if (isActivityOK(r9.getContext()) == false) goto L26;
        j40.x1 r0 = j40.x1.a;
        boolean r1 = r0.getValue().isAvatarLoadAntiFlink();
        long r2 = r0.getValue().getAntiFlinkDebounce();
        if (r1 == false) goto L22;
        Object r3 = r9.getTag(2131389794);
        if ((r3 instanceof Pair) == false) goto L22;
        Pair r4 = (Pair) r3;
        Object r5 = r4.first;
        Object r6 = r4.second;
        if ((r5 instanceof py.k) == false) goto L22;
        if ((r6 instanceof Long) == false) goto L22;
        long r7 = System.currentTimeMillis() - ((Long) r6).longValue();
        ALogger.i(TAG, "[loadAntiFlink] try load image " + r11.getUri() + " old " + ((py.k) r5).getUri() + " duration " + r7);
        boolean r8 = r11.equalsOnlyUri(r5);
        if (r7 >= r2) goto L21;
        ALogger.i(TAG, "[loadAntiFlink] try load image equals " + r8);
        if (r8 == false) goto L22;
        ALogger.e(TAG, "[loadAntiFlink] skip load image " + r11.getUri());
        return;
    L21:
        ALogger.i(TAG, "[loadAntiFlink] try load image equals " + r8 + ", duration = " + r7 + ", stack = " + Log.getStackTraceString(new Exception()));
    L22:
        FrescoLoader.with(r9.getContext()).fadeDuration((int) r12).load(r11).roundAsCircle().actualScaleType(ImageView.ScaleType.CENTER_CROP).controllerListener(new ImageLoader.e(r11, new a(r1, r9), false)).into(r9);
        return;
    L26:
        return;
    }

    public static void loadRoundImageWithRadius(ImageView r2, py.k r3, int r4) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (isActivityOK(r2.getContext()) == false) goto L9;
        FrescoLoader.with(r2.getContext()).load(r3).cornersRadius(r4).actualScaleType(ImageView.ScaleType.CENTER_CROP).controllerListener(new ImageLoader.e(null, null, false)).into(r2);
        return;
    }

    public static void loadImage(ImageView r2, Integer r3, ImageView.ScaleType r4) {
        if (isActivityOK(r2.getContext()) == true) goto L5;
        return;
    L5:
        FrescoLoader.with(r2.getContext()).load(r3.intValue()).actualScaleType(r4).controllerListener(new ImageLoader.e(null, null, false)).into(r2);
    }

    public static void loadImage(ImageView r6, py.k r7, int r8) {
        loadImage(r6, r7, -1, -1, r8, null);
    }

    public static void loadImage(ImageView r1, py.k r2, p0 r3) {
        loadImage(r1, r2, 0, r3);
    }

    public static void loadImage(ImageView r2, py.k r3, int r4, ImageView.ScaleType r5) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (r3 != null) goto L7;
        return;
    L7:
        if (CollectionUtils.isEmpty(r3.getUrls()) == false) goto L10;
        return;
    L10:
        if (isActivityOK(r2.getContext()) == true) goto L12;
        return;
    L12:
        FrescoLoader r6 = FrescoLoader.with(r2.getContext()).load(getImageUrl(r3)).load(r3).actualScaleType(ImageView.ScaleType.CENTER_CROP).placeholderScaleType(r5);
        if (r4 <= 0) goto L15;
        r6.placeholder(r4);
    L15:
        r6.controllerListener(new ImageLoader.e(r3, null, false));
        r6.into(r2);
    }

    public static void loadImageWithRadius(ImageView r2, py.k r3, int r4, int r5) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (isActivityOK(r2.getContext()) == false) goto L12;
        FrescoLoader r6 = FrescoLoader.with(r2.getContext()).load(getImageUrl(r3)).cornersRadius(s1.f(r5)).load(r3).actualScaleType(ImageView.ScaleType.CENTER_CROP);
        if (r4 == 0) goto L9;
        r6.placeholder(r4);
    L9:
        r6.controllerListener(new ImageLoader.e(r3, null, false));
        r6.into(r2);
        return;
    }

    public static void loadRoundResource(ImageView r3, int r4, int r5, int r6) {
        if (isActivityOK(r3.getContext()) == true) goto L5;
        return;
    L5:
        FrescoLoader r7 = FrescoLoader.with(r3.getContext()).load(r4).roundAsCircle().actualScaleType(ImageView.ScaleType.CENTER_CROP).controllerListener(new ImageLoader.e(null, null, false));
        if (r5 <= 0) goto L9;
        if (r6 <= 0) goto L9;
        r7.resize(r5, r6);
    L9:
        r7.into(r3);
    }

    public static void loadImage(ImageView r6, py.k r7, int r8, p0 r9) {
        loadImage(r6, r7, -1, -1, r8, r9);
    }

    public static void loadImage(ImageView r7, py.k r8, int r9, int r11, p0 r12) {
        if (r8 != null) goto L4;
        return;
    L4:
        if (CollectionUtils.isEmpty(r8.getUrls()) == false) goto L6;
        return;
    L6:
        if (isActivityOK(r7.getContext()) == false) goto L12;
        loadImage(r7, r8, r9, r11, -1, r12);
        return;
    }

    public static void loadImage(ImageView r7, py.k r8, int r9, int r11, int r12, p0 r13) {
        loadImage(r7, r8, r9, r11, false, r12, r13);
    }

    public static void loadRoundImage(ImageView r2, py.k r3, int r4, int r5, int r6, p0 r7) {
        if (isActivityOK(r2.getContext()) == true) goto L5;
        return;
    L5:
        FrescoLoader r0 = FrescoLoader.with(r2.getContext()).load(r3).roundAsCircle().actualScaleType(ImageView.ScaleType.CENTER_CROP);
        if (r4 <= 0) goto L9;
        if (r5 <= 0) goto L9;
        r0.resize(r4, r5);
    L9:
        if (r6 <= 0) goto L12;
        r0.placeholder(r6);
    L12:
        if (r7 == null) goto L14;
        r0.controllerListener(new ImageLoader.e(r3, r7, false));
    L15:
        r0.into(r2);
        return;
    L14:
        r0.controllerListener(new ImageLoader.e(null, null, false));
        goto L15
    }

    public static void loadRoundImageWithContentDetect(ImageView r2, py.k r3, int r4, int r5, int r6, p0 r7) {
        if (isActivityOK(r2.getContext()) == true) goto L5;
        return;
    L5:
        FrescoLoader r0 = FrescoLoader.with(r2.getContext()).load(r3).roundAsCircle().postProcessor(new rw2.a()).actualScaleType(ImageView.ScaleType.CENTER_CROP);
        if (r4 <= 0) goto L9;
        if (r5 <= 0) goto L9;
        r0.resize(r4, r5);
    L9:
        if (r6 <= 0) goto L12;
        r0.placeholder(r6);
    L12:
        if (r7 == null) goto L14;
        r0.controllerListener(new ImageLoader.e(r3, r7, false));
    L15:
        r0.into(r2);
        return;
    L14:
        r0.controllerListener(new ImageLoader.e(null, null, false));
        goto L15
    }

    public static void loadImage(ImageView r8, py.k r9, int r11, int r12, boolean r13, int r14, p0 r15) {
        loadImage(r8, r9, r11, r12, r13, r14, ImageView.ScaleType.CENTER_CROP, r15);
    }

    public static void loadImageWithRadii(ImageView r2, py.k r3, int r4, float r5, float r6, float r7, float r8) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (isActivityOK(r2.getContext()) == false) goto L12;
        FrescoLoader r9 = FrescoLoader.with(r2.getContext()).load(getImageUrl(r3)).cornersRadii(s1.f(r5), s1.f(r6), s1.f(r7), s1.f(r8)).load(r3).actualScaleType(ImageView.ScaleType.CENTER_CROP);
        if (r4 == 0) goto L9;
        r9.placeholder(r4);
    L9:
        r9.controllerListener(new ImageLoader.e(r3, null, false));
        r9.into(r2);
        return;
    }

    public static void loadImage(ImageView r11, py.k r12, int r13, int r14, boolean r15, int r16, boolean r17, p0 r18) {
        loadImage(r11, r12, r13, r14, r15, r16, ImageView.ScaleType.CENTER_CROP, r17, r18, null);
    }

    public static void loadImageWithRadiiAndScaleType(ImageView r2, py.k r3, int r4, float r5, float r6, float r7, float r8, ImageView.ScaleType r9) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (isActivityOK(r2.getContext()) == false) goto L12;
        FrescoLoader r11 = FrescoLoader.with(r2.getContext()).load(getImageUrl(r3)).cornersRadii(s1.f(r5), s1.f(r6), s1.f(r7), s1.f(r8)).load(r3).actualScaleType(r9);
        if (r4 == 0) goto L9;
        r11.placeholder(r4);
    L9:
        r11.controllerListener(new ImageLoader.e(r3, null, false));
        r11.into(r2);
        return;
    }

    public static void loadImage(ImageView r11, py.k r12, int r13, int r14, boolean r15, int r16, ImageView.ScaleType r17, p0 r18) {
        loadImage(r11, r12, r13, r14, r15, r16, r17, false, r18, null);
    }

    public static void loadRoundImageWithBorder(ImageView r1, py.k r2, int r3, int r4, int r5, int r6, float r7, boolean r8, p0 r9) {
        if (isActivityOK(r1.getContext()) == true) goto L5;
        return;
    L5:
        FrescoLoader r11 = FrescoLoader.with(r1.getContext()).load(r2).roundAsCircle().border(r6, r7, r8).actualScaleType(ImageView.ScaleType.CENTER_CROP);
        if (r3 <= 0) goto L9;
        if (r4 <= 0) goto L9;
        r11.resize(r3, r4);
    L9:
        if (r5 <= 0) goto L12;
        r11.placeholder(r5);
    L12:
        if (r9 == null) goto L14;
        r11.controllerListener(new ImageLoader.e(r2, r9, false));
    L15:
        r11.into(r1);
        return;
    L14:
        r11.controllerListener(new ImageLoader.e(null, null, false));
        goto L15
    }

    public static void loadImage(ImageView r2, py.k r3, int r4, int r5, boolean r6, Drawable r7, ImageView.ScaleType r8, boolean r9, p0 r11, String r12) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (r3 != null) goto L9;
        if (r11 == null) goto L31;
        r11.b(r3, new IllegalArgumentException("imageModel == null"));
        return;
    L31:
        return;
    L9:
        if (CollectionUtils.isEmpty(r3.getUrls()) == false) goto L14;
        if (r11 == null) goto L32;
        r11.b(r3, new IllegalArgumentException("CollectionUtils.isEmpty(imageModel.urls)"));
        return;
    L32:
        return;
    L14:
        if (isActivityOK(r2.getContext()) == true) goto L18;
        if (r11 == null) goto L33;
        r11.b(r3, new IllegalArgumentException("!isActivityOK(view.getContext())"));
        return;
    L33:
        return;
    L18:
        FrescoLoader r0 = FrescoLoader.with(r2.getContext()).load(getImageUrl(r3)).load(r3).actualScaleType(r8);
        if (r4 <= 0) goto L22;
        if (r5 <= 0) goto L22;
        r0.resize(r4, r5);
    L22:
        if (r7 == null) goto L24;
        r0.placeholder(r7);
        r0.placeholderScaleType(r8);
    L24:
        if (r6 == false) goto L27;
        r0.autoPlayAnimations(true);
    L27:
        if (TextUtils.isEmpty(r12) == true) goto L29;
        r0.customCacheName(r12);
    L29:
        r0.controllerListener(new ImageLoader.e(r3, r11, r9));
        r0.into(r2);
    }

    public static void loadImage(ImageView r2, py.k r3, int r4, int r5, boolean r6, int r7, ImageView.ScaleType r8, boolean r9, p0 r11, String r12) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (r3 != null) goto L9;
        if (r11 == null) goto L31;
        r11.b(r3, new IllegalArgumentException("imageModel == null"));
        return;
    L31:
        return;
    L9:
        if (CollectionUtils.isEmpty(r3.getUrls()) == false) goto L14;
        if (r11 == null) goto L32;
        r11.b(r3, new IllegalArgumentException("CollectionUtils.isEmpty(imageModel.urls)"));
        return;
    L32:
        return;
    L14:
        if (isActivityOK(r2.getContext()) == true) goto L18;
        if (r11 == null) goto L33;
        r11.b(r3, new IllegalArgumentException("!isActivityOK(view.getContext())"));
        return;
    L33:
        return;
    L18:
        FrescoLoader r13 = FrescoLoader.with(r2.getContext()).load(getImageUrl(r3)).load(r3).actualScaleType(r8);
        if (r4 <= 0) goto L22;
        if (r5 <= 0) goto L22;
        r13.resize(r4, r5);
    L22:
        if (r7 <= 0) goto L24;
        r13.placeholder(r7);
    L24:
        if (r6 == false) goto L27;
        r13.autoPlayAnimations(true);
    L27:
        if (TextUtils.isEmpty(r12) == true) goto L29;
        r13.customCacheName(r12);
    L29:
        r13.controllerListener(new ImageLoader.e(r3, r11, r9));
        r13.into(r2);
    }

    public static void loadImage(ImageView r2, py.k r3, int r4, int r5, boolean r6, Drawable r7, ImageView.ScaleType r8, boolean r9, p0 r11, String r12, int r13) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (r3 != null) goto L9;
        if (r11 == null) goto L31;
        r11.b(r3, new IllegalArgumentException("imageModel == null"));
        return;
    L31:
        return;
    L9:
        if (CollectionUtils.isEmpty(r3.getUrls()) == false) goto L14;
        if (r11 == null) goto L32;
        r11.b(r3, new IllegalArgumentException("CollectionUtils.isEmpty(imageModel.urls)"));
        return;
    L32:
        return;
    L14:
        if (isActivityOK(r2.getContext()) == true) goto L18;
        if (r11 == null) goto L33;
        r11.b(r3, new IllegalArgumentException("!isActivityOK(view.getContext())"));
        return;
    L33:
        return;
    L18:
        FrescoLoader r14 = FrescoLoader.with(r2.getContext()).load(getImageUrl(r3)).load(r3).cornersRadius(r13).actualScaleType(r8);
        if (r4 <= 0) goto L22;
        if (r5 <= 0) goto L22;
        r14.resize(r4, r5);
    L22:
        if (r7 == null) goto L24;
        r14.placeholder(r7);
        r14.placeholderScaleType(r8);
    L24:
        if (r6 == false) goto L27;
        r14.autoPlayAnimations(true);
    L27:
        if (TextUtils.isEmpty(r12) == true) goto L29;
        r14.customCacheName(r12);
    L29:
        r14.controllerListener(new ImageLoader.e(r3, r11, r9));
        r14.into(r2);
    }
}
