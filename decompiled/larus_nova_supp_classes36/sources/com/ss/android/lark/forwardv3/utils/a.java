package com.ss.android.lark.forwardv3.utils;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.URLUtil;
import android.widget.ImageView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.api.DiskCacheStrategy;
import com.ss.android.lark.image.api.IRequestCreator;
import com.ss.android.lark.image.entity.AvatarImage;
import com.ss.android.lark.image.entity.EncryptImage;
import com.ss.android.lark.image.entity.Image;
import com.ss.android.lark.log.Log;
import java.util.List;
import jp.wasabeef.glide.transformations.CropCircleTransformation;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    static {
    }

    @JvmStatic
    public static final void a(Context r6, ImageView r7, boolean r8, Image r9, boolean r10, boolean r11, int r12, int r13) {
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "imageView");
        Log.i("DialogContentUtils", "start load image");
        if (r8 == false) goto L5;
        int r14 = 2131100556;
    L6:
        if (r9 == null) goto L30;
        String r2 = r9.getKey();
        if (TextUtils.isEmpty(r2) == false) goto L18;
        Log.i("DialogContentUtils", "load local image");
        List<String> r3 = r9.getUrls();
        if (CollectionUtils.isEmpty(r3) == true) goto L18;
        r2 = (String) ListProtector.get(r3, 0);
        if (URLUtil.isNetworkUrl(r2) == true) goto L18;
        if (new PolarisFileWrapper(r2).exists() == false) goto L18;
        ImageLoader.with(r6).placeholder(2131100556).error(r14).load(r2).dontAnimate(false).override(y9c.d.a(80), y9c.d.a(80)).into(r7);
        return;
    L18:
        if (TextUtils.isEmpty(r2) == true) goto L29;
        if (r10 == false) goto L21;
        Object r15 = new EncryptImage(r9);
    L22:
        IRequestCreator r16 = ImageLoader.with(r6).load(r15).placeholder(2131100556).dontAnimate(false).diskCacheStrategy(DiskCacheStrategy.SOURCE).error(r14).centerCrop();
        if (r12 == 0) goto L26;
        if (r13 == 0) goto L26;
        r16.override(r12, r13);
    L26:
        if (r11 == false) goto L28;
        r16.transform(new CropCircleTransformation());
    L28:
        Log.i("DialogContentUtils", "do load image from net - isCircle:" + r11);
        r16.into(r7);
        return;
    L21:
        r15 = AvatarImage.Builder.obtain(r2, r9.getToken(), r12, r13).build();
        goto L22
    L29:
        Log.i("DialogContentUtils", "do load image from net key is null");
        ImageLoader.with(r6).load(Integer.valueOf(r14)).centerCrop().dontAnimate(false).into(r7);
        return;
    L30:
        Log.i("DialogContentUtils", "imageView display by placeholder");
        r7.setImageResource(2131100556);
        return;
    L5:
        r14 = 2131233586;
        goto L6
    }
}
