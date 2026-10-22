package com.ss.android.lark.resource.service;

import com.ss.android.lark.manis.annotation.RemoteService;
import com.suite.lark.platform.service.resourcerepository.api.Resource;
import ee.android.framework.manis.interfaces.IHookInterface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@RemoteService
public interface IResourceManisService extends IHookInterface {
    String getAvatarPath(String r1, String r2, int r3, float r4);

    Resource getEncryptImage(String r1, String r2, String r3, String r4, String r5, boolean r6);

    Resource getEncryptImage(String r1, String r2, String r3, String r4, String r5, boolean r6, int r7);
}
