package com.ss.android.lark.image.impl;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.api.IRequestCreator;
import com.ss.android.lark.image.entity.AvatarImage;
import com.ss.android.lark.image.entity.EncryptImage;
import com.ss.android.lark.image.entity.ListenerParams;
import com.ss.android.lark.image.entity.LoadParams;
import com.ss.android.lark.image.impl.resource.ResourceGlideListener;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.rxjava.RxScheduledExecutor;
import rkb.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class LarkImageUtil {

    /* JADX INFO: renamed from: com.ss.android.lark.image.impl.LarkImageUtil$6, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass6 {
        static final /* synthetic */ int[] $SwitchMap$android$widget$ImageView$ScaleType = null;

        static {
            int[] r0 = new int[ImageView.ScaleType.values().length];
            $SwitchMap$android$widget$ImageView$ScaleType = r0;
            r0[ImageView.ScaleType.CENTER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L20:
            $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.FIT_XY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L24:
            $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.MATRIX.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L34:
            $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.FIT_END.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L22:
            $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.FIT_START.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L26:
            $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L28:
            $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.FIT_CENTER.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L30:
            $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.CENTER_CROP.ordinal()] = 8;     // Catch: NoSuchFieldError -> L19
            return;
        }
    }

    public static class ImageLoadParams {
        public Object model;
        public g requestListener;

        private ImageLoadParams() {
        }

        public /* synthetic */ ImageLoadParams(AnonymousClass1 r1) {
            this();
        }
    }

    public static /* synthetic */ ImageLoadParams access$100(LoadParams r0, Object r1) {
        return getRequestListener(r0, r1);
    }

    public static /* synthetic */ void access$300(ImageView r0, ImageView.ScaleType r1) {
        setScaleType(r0, r1);
    }

    private static ImageLoadParams getRequestListener(final LoadParams r3, Object r4) {
        ImageLoadParams r0 = new ImageLoadParams(null);
        r0.model = r4;
        ListenerParams r1 = r3.l;
        if (r1 != null) goto L6;
        return r0;
    L6:
        if (r1.a == false) goto L9;
        r0.requestListener = new ResourceGlideListener(r1, r4);
    L11:
        return r0;
    L9:
        if (r1.h == null) goto L11;
        r0.requestListener = new AnonymousClass4(r3);
        goto L11
    }

    private static void setScaleType(ImageView r0, ImageView.ScaleType r1) {
        r0.setScaleType(r1);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public static void loadImage(final Context r9, final ImageView r10, final Object r11, final LoadParams r12) {
        if (r12 != null) goto L4;
        return;
    L4:
        if (r9 == null) goto L25;
        if (r10 != null) goto L8;
        return;
    L8:
        if (UIUtils.canLoadImage(r9) == true) goto L10;
        return;
    L10:
        if (r11 != null) goto L12;
    L19:
        Log.e("LarkImageUtil", "Key and Url is all empty, data is error");
    L20:
        final int r0 = r12.a;
        final int r1 = r12.b;
        if (r12.k == true) goto L23;
        final ImageLoadParams r3 = getRequestListener(r12, r11);
        UICallbackExecutor.execute(new AnonymousClass1(r3, r9, r12, r10, r0, r1));
        return;
    L23:
        RxScheduledExecutor.execInIO(new AnonymousClass2(r12, r11), new AnonymousClass3(r9, r12, r10, r0, r1));
        return;
    L12:
        if ((r11 instanceof EncryptImage) == false) goto L16;
        if (TextUtils.isEmpty(((EncryptImage) r11).getEncryptKey()) == true) goto L19;
    L16:
        if ((r11 instanceof AvatarImage) == false) goto L20;
        if (TextUtils.isEmpty(((AvatarImage) r11).getKey()) == false) goto L20;
    }

    public static /* synthetic */ void access$000(ImageLoadParams r0, Context r1, LoadParams r2, ImageView r3, int r4, int r5) {
        loadImageCore(r0, r1, r2, r3, r4, r5);
    }

    private static void loadImageCore(final ImageLoadParams r2, Context r3, final LoadParams r4, final ImageView r5, int r6, int r7) {
        if ((r3 instanceof Activity) == true) goto L5;
    L7:
        IRequestCreator r8 = ImageLoader.with(r3).load(r2.model);
        r8.diskCacheStrategy(r4.h);
        Drawable r0 = r4.d;
        if (r0 == null) goto L10;
        r8.error(r0);
    L10:
        Drawable r1 = r4.c;
        if (r1 == null) goto L14;
        r8.placeholder(r1);
    L14:
        switch(AnonymousClass6.$SwitchMap$android$widget$ImageView$ScaleType[r4.e.ordinal()]) {
            case 1: goto L20;
            case 2: goto L20;
            case 3: goto L20;
            case 4: goto L20;
            case 5: goto L20;
            case 6: goto L20;
            case 7: goto L18;
            default: goto L15;
        };
    L15:
        if (r6 != Integer.MIN_VALUE) goto L19;
        if (r7 == Integer.MIN_VALUE) goto L20;
    L19:
        r8.centerCrop();
        goto L20
    L18:
        r8.fitCenter();
    L20:
        r8.dontAnimate(r4.j);
        r8.transform(null);
        if (r6 <= 0) goto L23;
        if (r7 <= 0) goto L23;
    L25:
        r8.override(r6, r7);
    L26:
        r8.setErrorScaleType(r4.f);
        r8.listener(new AnonymousClass5(r2, r5, r4));
        r8.into(r5);
        return;
    L23:
        if (r6 != Integer.MIN_VALUE) goto L26;
        if (r7 != Integer.MIN_VALUE) goto L26;
    L5:
        if (UIUtils.isActivityRunning((Activity) r3) == true) goto L7;
    }
}
