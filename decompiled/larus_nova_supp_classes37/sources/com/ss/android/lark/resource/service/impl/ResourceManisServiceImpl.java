package com.ss.android.lark.resource.service.impl;

import android.content.Context;
import com.ss.android.lark.manis.annotation.RemoteServiceImpl;
import com.ss.android.lark.resource.service.IResourceManisService;
import com.suite.lark.platform.service.resourcerepository.api.Resource;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@RemoteServiceImpl(service = IResourceManisService.class)
public class ResourceManisServiceImpl implements IResourceManisService {
    private Context mContext;
    private ImageService mImageService;

    private ImageService getRealService() {
        if (this.mImageService != null) goto L6;
        this.mImageService = new ImageService();
    L6:
        return this.mImageService;
    }

    public ResourceManisServiceImpl(Context r1) {
        this.mContext = r1;
    }

    @Override // com.ss.android.lark.resource.service.IResourceManisService
    public String getAvatarPath(String r2, String r3, int r4, float r5) {
        return getRealService().getAvatarPathInMainProcess(r2, r3, r4, r5);
    }

    @Override // com.ss.android.lark.resource.service.IResourceManisService
    public Resource getEncryptImage(String r8, String r9, String r10, String r11, String r12, boolean r13) {
        return getRealService().getEncryptImageInMainProcess(r8, r9, r10, ByteString.encodeUtf8(r11), r12, r13);
    }

    @Override // com.ss.android.lark.resource.service.IResourceManisService
    public Resource getEncryptImage(String r9, String r10, String r11, String r12, String r13, boolean r14, int r15) {
        return getRealService().getEncryptImageInMainProcess(r9, r10, r11, ByteString.encodeUtf8(r12), r13, r14, r15);
    }
}
