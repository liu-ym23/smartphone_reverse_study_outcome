package com.ss.android.lark.officesdk.integrator.im.sdk.service;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/ss/android/lark/officesdk/integrator/im/sdk/service/ImSdkImageProxy$compressImage$1", "Lcom/larksuite/framework/callback/IGetDataCallback;", "Lcom/ss/android/lark/image/entity/ImageFileInfo;", "onSuccess", "", "imageFileInfo", "onError", "err", "Lcom/larksuite/framework/callback/Entity/ErrorResult;", "officesdk-integrator-im_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class ImSdkImageProxy$compressImage$1 implements IGetDataCallback<com.ss.android.lark.image.entity.d> {
    final /* synthetic */ IGetDataCallback<dcb.b> $callback;

    public ImSdkImageProxy$compressImage$1(IGetDataCallback<dcb.b> r1) {
        this.$callback = r1;
    }

    public void onError(ErrorResult r2) {
        Intrinsics.checkNotNullParameter(r2, "err");
        IGetDataCallback<dcb.b> r0 = this.$callback;
        if (r0 == null) goto L6;
        r0.onError(r2);
        return;
    }

    public void onSuccess(com.ss.android.lark.image.entity.d r4) {
        Intrinsics.checkNotNullParameter(r4, "imageFileInfo");
        File r0 = r4.a;
        if (r0 == null) goto L5;
        String r1 = r0.getPath();
    L6:
        dcb.b r2 = new dcb.b(r1, r4.a, r4.b);
        IGetDataCallback<dcb.b> r5 = this.$callback;
        if (r5 == null) goto L10;
        r5.onSuccess(r2);
        return;
    L10:
        return;
    L5:
        r1 = "";
        goto L6
    }

    public /* bridge */ /* synthetic */ void onError(Object r1) {
        onError((ErrorResult) r1);
    }

    public /* bridge */ /* synthetic */ void onSuccess(Object r1) {
        onSuccess((com.ss.android.lark.image.entity.d) r1);
    }
}
