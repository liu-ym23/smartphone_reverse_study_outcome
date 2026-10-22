package com.ss.android.lark.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bytedance.i18n.claymore.ClaymoreServiceLoader;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.callback.OnUpdateProgressListener;
import com.ss.android.lark.image.entity.AvatarImage;
import com.ss.android.lark.image.entity.EncryptImageData;
import com.ss.android.lark.image.entity.LoadParams;
import com.ss.android.lark.image.impl.LarkImageUtil;
import com.ss.android.lark.image.impl.image_compress.Luban;
import com.ss.android.lark.utils.ImageUtils;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.io.File;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class ImageModule {
    public static final a a = null;

    static {
        a = (a) ClaymoreServiceLoader.loadFirstOrNull(a.class);
    }

    public ImageModule() {
    }

    public static void a(Context r2, ImageView r3, String r4, String r5, LoadParams r6) {
        LarkImageUtil.loadImage(r2, r3, AvatarImage.Builder.obtain(r4, r5, r6.a, r6.b).isOnlyLocal(false).build(), r6);
    }

    public final void b(Context r11, final String r12, boolean r13, final boolean r14, final boolean r15, final OnUpdateProgressListener r16, final IGetDataCallback<EncryptImageData> r17) {
        if (r16 == null) goto L4;
        r16.onUpdateProgress(100, 0, 0);
    L4:
        if (r14 == true) goto L8;
        if (r13 == true) goto L8;
        boolean r7 = false;
    L9:
        IGetDataCallback<com.ss.android.lark.image.entity.d> r8 = new AnonymousClass3(this, r12, r16, r14, r15, r17);
        long r4 = System.currentTimeMillis();
        PolarisFileWrapper r0 = new PolarisFileWrapper(r12);
        if (r7 == false) goto L12;
    L25:
        Observable<File> r1 = Observable.just(r0).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    L26:
        r1.subscribe(new g(r7, r12, r4, r8), new h(r8));
        return;
    L12:
        if (ImageUtils.e(r0) == true) goto L25;
        Luban r2 = Luban.compress(r11, r0).setMaxSize(400).putGear(4);
        if (TextUtils.isEmpty(r12) == false) goto L17;
        Bitmap.CompressFormat r3 = Bitmap.CompressFormat.JPEG;
    L24:
        r1 = r2.setCompressFormat(r3).asObservable();
        goto L26
    L17:
        String r5 = r12.toLowerCase();
        if (r5.endsWith(".png") == false) goto L21;
        r3 = Bitmap.CompressFormat.PNG;
        goto L24
    L21:
        if (r5.endsWith(".webp") == false) goto L23;
        r3 = Bitmap.CompressFormat.WEBP;
        goto L24
    L23:
        r3 = Bitmap.CompressFormat.JPEG;
    L8:
        r7 = true;
        goto L9
    }
}
