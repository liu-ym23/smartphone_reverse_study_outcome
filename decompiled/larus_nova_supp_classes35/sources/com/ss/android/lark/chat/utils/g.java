package com.ss.android.lark.chat.utils;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.webkit.URLUtil;
import android.widget.ImageView;
import androidx.collection.LruCache;
import com.bumptech.glide.load.DecodeFormat;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.joooonho.SelectableRoundedImageView;
import com.larksuite.framework.utils.CollectionUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.appreciablelib.Biz;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.image.ImageSet;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.api.DiskCacheStrategy;
import com.ss.android.lark.image.api.IRequestCreator;
import com.ss.android.lark.image.entity.AvatarImage;
import com.ss.android.lark.image.entity.EncryptImage;
import com.ss.android.lark.image.entity.Image;
import com.ss.android.lark.image.entity.ListenerParams;
import com.ss.android.lark.image.entity.LoadParams;
import com.ss.android.lark.image.impl.InlineRequestCreator;
import com.ss.android.lark.image.impl.resource.ResourceGlideListener;
import com.ss.android.lark.image.utils.ChatImageSettings;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.ImageUtils;
import com.ss.android.lark.utils.UIHelper;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class g {
    public static boolean c() {
        Context r0 = ChatCoreModule.a().getContext();
        int r1 = ChatImageSettings.getMessageImageRemote().getTarget().getThumbWidthMax();
        if (UIHelper.getWindowWidth(r0) <= r1) goto L5;
        return true;
    L5:
        return false;
    }

    public static Image b(ImageSet r3) {
        if (r3 != null) goto L5;
        return null;
    L5:
        Image r1 = r3.getOrigin();
        if (r1 != null) goto L9;
        return null;
    L9:
        if (CollectionUtils.isNotEmpty(r1.getUrls()) == false) goto L14;
        if (URLUtil.isNetworkUrl((String) ListProtector.get(r1.getUrls(), 0)) == true) goto L14;
        return r1;
    L14:
        if (c() == true) goto L16;
    L20:
        Image r4 = r3.getThumbnail();
    L21:
        if (r4 != null) goto L23;
        return r1;
    L23:
        if (r4.isEmpty() == false) goto L25;
        return r1;
    L25:
        return r4;
    L16:
        if (r3.getMiddle() == null) goto L20;
        if (r3.getMiddle().isEmpty() == true) goto L20;
        r4 = r3.getMiddle();
        goto L21
    }

    public static boolean d(y6b.a r2) {
        if (r2 != null) goto L4;
    L8:
        return false;
    L4:
        if (r2.P() == false) goto L6;
    L7:
        Log.e("ChatImageUtil", "msg:" + r2.getId() + " is deleted");
        return true;
    L6:
        if (r2.j() == false) goto L8;
        goto L7
    }

    public static void f(Context r4, ImageView r5) {
        int r0 = r5.getWidth();
        int r1 = r5.getHeight();
        if (r0 == 0) goto L5;
        if (r1 == 0) goto L5;
    L6:
        ImageLoader.with(r4).load(2131233569).diskCacheStrategy(DiskCacheStrategy.NONE).override(r0, r1).into(r5);
        return;
    L5:
        LruCache r2 = ImageUtils.a;
        int r3 = UIUtils.dp2px(r4, 100.0f);
        r1 = UIUtils.dp2px(r4, 100.0f);
        r0 = r3;
        goto L6
    }

    public static GradientDrawable a(Context r2, int r3, int r4, int r5) {
        GradientDrawable r0 = new GradientDrawable();
        r0.setShape(0);
        r0.setCornerRadius(r5);
        r0.setColor(UIUtils.getColor(r2, 2131100549));
        r0.setSize(r3, r4);
        return r0;
    }

    public static void g(Context r10, ImageView r11, Image r12, LoadParams r13, ByteString r14, v r15) {
        String r0 = r12.getKey();
        if (CollectionUtils.isNotEmpty(r12.getUrls()) == false) goto L5;
        String r1 = (String) ListProtector.get(r12.getUrls(), 0);
    L7:
        if (TextUtils.isEmpty(r0) == true) goto L13;
        String r4 = new EncryptImage(r0, r12.getFsUnit(), r12.getCrypto());
        r4.setStoreToPrivatePath(r13.i);
        r4.setNeedCollectTrace(true);
        r4.setContextId(com.ss.android.lark.sdk.a.a());
        if (r14 == null) goto L11;
        Log.i("ChatImageUtil", "loadImage imageKey:" + r0 + " inline size:" + r14.size());
    L20:
        DiskCacheStrategy r5 = r13.h;
        if (com.ss.android.lark.image.utils.a.f() == false) goto L23;
        r5 = DiskCacheStrategy.NONE;
    L23:
        if (r4 == null) goto L44;
        if (r15 == null) goto L26;
        r15.onStart();
    L26:
        IRequestCreator r16 = ImageLoader.with(r10).load(r4).override(r13.a, r13.b).placeholder(r13.c).error(r13.d).dontAnimate(false).centerCrop().setErrorScaleType(r13.f);
        ListenerParams r6 = r13.l;
        if (r6 == null) goto L29;
        ResourceGlideListener r7 = new ResourceGlideListener(r6, r4);
    L30:
        IRequestCreator r17 = r16.listener(r7).diskCacheStrategy(r5).transform(null).transforms(r13.g).gifFileSize(r13.m).gifMaxHeight(r13.o).gifMaxWidth(r13.n).thumbnail(0.0f);
        File r18 = r12.getThumbnailCache();
        if (r18 == null) goto L36;
        if (r18.exists() == false) goto L36;
        r17.thumbnail(ImageLoader.with(r10).load(r18)).diskCacheStrategy(DiskCacheStrategy.NONE).override(r13.a, r13.b).dontAnimate(false).centerCrop();
    L41:
        if (ChatCoreModule.a().getFeatureGatingDependency().isEnable("lark.image.config.565") == false) goto L43;
        r17.decodeFormat(DecodeFormat.PREFER_RGB_565);
    L43:
        r17.isAsync(r13.k);
        r17.into(r11);
        return;
    L36:
        if (TextUtils.isEmpty(r0) == false) goto L39;
        r0 = r1;
    L39:
        r17.thumbnail(InlineRequestCreator.generate(r10, r0, r14));
        goto L41
    L29:
        r7 = null;
        goto L30
    L44:
        Log.e("ChatImageUtil", "Key and Url is all empty, data is error");
        f(r10, r11);
        return;
    L11:
        Log.i("ChatImageUtil", "loadImage imageKey:" + r0 + " inline is null.");
        goto L20
    L13:
        if (TextUtils.isEmpty(r1) == false) goto L15;
        r4 = null;
        goto L20
    L15:
        if (r14 == null) goto L17;
        Log.i("ChatImageUtil", "loadImage imageUrl:" + r1 + " inline size:" + r14.size());
    L18:
        r4 = r1;
        goto L20
    L17:
        Log.i("ChatImageUtil", "loadImage imageUrl:" + r1 + " inline is null.");
        goto L18
    L5:
        r1 = null;
        goto L7
    }

    public static void e(Context r2, ImageView r3, String r4, String r5, int r6, int r7, Scene r8) {
        AvatarImage r9 = AvatarImage.Builder.obtain(r4, r5, r6, r7).build();
        com.ss.android.lark.image.entity.a r10 = new com.ss.android.lark.image.entity.a();
        r10.setShape(1);
        if ((r3 instanceof SelectableRoundedImageView) == false) goto L5;
        float r0 = ((SelectableRoundedImageView) r3).getCornerRadius();
    L6:
        r10.setCornerRadius(r0);
        r10.setColor(UIUtils.getColor(r2, 2131100549));
        r10.setSize(r6, r7);
        IRequestCreator r11 = ImageLoader.with(r2).load(r9).placeholder(r10).override(r6, r7);
        ListenerParams.a r1 = new ListenerParams.a();
        r1.a(Biz.Messenger);
        Intrinsics.checkNotNullParameter(r8, "scene");
        r1.j = r8;
        r1.c(ListenerParams.FromType.AVATAR);
        r1.a = false;
        r1.b = false;
        r1.c = r6;
        r1.d = r7;
        r11.listener(new ResourceGlideListener(r1.b(), r9)).into(r3);
        return;
    L5:
        r0 = 0.0f;
        goto L6
    }
}
