package com.bytedance.android.live.openplatform.impl.base.utils;

import android.content.Context;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.openplatform.impl.base.api.OpenPlatformApi;
import com.bytedance.retrofit2.mime.MultipartTypedOutput;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class ImageUtils {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static Disposable a(MultipartTypedOutput r2, Function2 r3, Function1 r4) {
        Lazy r0 = LiveOpenPlatformClient.c;
        return ((OpenPlatformApi) LiveOpenPlatformClient.a.a().a(OpenPlatformApi.class)).uploadImage(r2).compose(RxUtil.rxSchedulerHelper()).subscribe(new i(r4, r3), new j(r4));
    }

    public static void b(final Context r7, final String r8, final Function2 r9, final Function1 r10, final boolean r11) {
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r8, "imagePath");
        Intrinsics.checkNotNullParameter(r9, "onUploadSuccess");
        if ((!StringsKt.isBlank(r8)) == false) goto L5;
        Observable.create(new ImageUtils$uploadImage$1(r11, r8, r7, r10, r9)).subscribeOn(Schedulers.io()).subscribe();
        return;
    L5:
        if (r10 == null) goto L9;
        Unit r12 = (Unit) r10.invoke(new Throwable("image path is empty"));
        return;
    }
}
