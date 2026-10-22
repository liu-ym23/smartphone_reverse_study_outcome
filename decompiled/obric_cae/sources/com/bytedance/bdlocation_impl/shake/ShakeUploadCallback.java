package com.bytedance.bdlocation_impl.shake;

import com.bytedance.bdlocation.callback.UploadCallback;
import com.bytedance.bdlocation.exception.BDLocationException;

/* JADX INFO: loaded from: classes.dex */
public interface ShakeUploadCallback extends UploadCallback {
    void onError(BDLocationException r8);

    void onSuccess();
}
