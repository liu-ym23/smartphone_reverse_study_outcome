package com.ss.android.lark.image.impl;

import android.content.Context;
import com.ss.android.lark.image.ImageModule;
import com.ss.android.lark.image.service.IImageManisService;
import com.ss.android.lark.manis.annotation.RemoteServiceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@RemoteServiceImpl(service = IImageManisService.class)
public class ImageManisService implements IImageManisService {
    private Context mContext;

    public ImageManisService(Context r1) {
        this.mContext = r1;
    }

    @Override // com.ss.android.lark.image.service.IImageManisService
    public void uploadEncryptImage(String r9, boolean r10, boolean r11, final IImageManisService.a r12) {
        new ImageModule().b(this.mContext, r9, r10, r11, true, null, new AnonymousClass1(this, r12));
    }
}
