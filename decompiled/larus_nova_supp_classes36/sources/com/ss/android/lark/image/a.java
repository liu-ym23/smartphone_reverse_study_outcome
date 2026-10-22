package com.ss.android.lark.image;

import com.suite.lark.platform.service.resourcerepository.api.Resource;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public interface a {

    /* JADX INFO: renamed from: com.ss.android.lark.image.a$a, reason: collision with other inner class name */
    public interface InterfaceC0090a {
        String getDeviceId();

        String getUserId();
    }

    String findResource(String r1);

    String getAvatarDir();

    Resource getEncryptImage(String r1, String r2, String r3, ByteString r4, String r5, boolean r6, int r7);

    InterfaceC0090a getPassPortDependency();

    boolean isReportImageLoad(int r1, int r2);
}
