package com.ss.android.lark.keyboard.plugin.tool.photo;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.OnUpdateProgressListener;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.image.entity.LoadParams;
import com.ss.android.lark.keyboard.dtocompat.Image;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\u0003H&¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/keyboard/plugin/tool/photo/PhotoKBPlugin$IOnUploadPhotoAPI$IUploadCallback;", "Lcom/larksuite/framework/callback/OnUpdateProgressListener;", "onSuccess", "", LoadParams.ImageFormat.IMAGE, "Lcom/ss/android/lark/keyboard/dtocompat/Image;", "onError", "err", "Lcom/larksuite/framework/callback/Entity/ErrorResult;", "onFinish", "keyboard-biz-photo_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public interface PhotoKBPlugin$IOnUploadPhotoAPI$IUploadCallback extends OnUpdateProgressListener {
    void onError(ErrorResult r1);

    void onFinish();

    void onSuccess(Image r1);
}
