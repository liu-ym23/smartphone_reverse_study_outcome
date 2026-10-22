package com.ss.android.lark.image.service;

import com.ss.android.lark.image.entity.EncryptImageData;
import com.ss.android.lark.manis.annotation.RemoteCallback;
import com.ss.android.lark.manis.annotation.RemoteService;
import ee.android.framework.manis.interfaces.IHookInterface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@RemoteService
public interface IImageManisService extends IHookInterface {

    @RemoteCallback
    public interface a {
        void onError(ErrorResultWrapper r1);

        void onSuccess(EncryptImageData r1);
    }

    void uploadEncryptImage(String r1, boolean r2, boolean r3, a r4);
}
