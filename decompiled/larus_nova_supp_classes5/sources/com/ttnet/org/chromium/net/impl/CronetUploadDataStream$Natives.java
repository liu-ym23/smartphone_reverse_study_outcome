package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.base.annotations.NativeClassQualifiedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public interface CronetUploadDataStream$Natives {
    long attachUploadDataToRequest(CronetUploadDataStream r1, long r2, long r4);

    long createAdapterForTesting(CronetUploadDataStream r1);

    long createUploadDataStreamForTesting(CronetUploadDataStream r1, long r2, long r4);

    @NativeClassQualifiedName("CronetUploadDataStreamAdapter")
    void destroy(long r1);

    @NativeClassQualifiedName("CronetUploadDataStreamAdapter")
    void onReadSucceeded(long r1, CronetUploadDataStream r3, int r4, boolean r5);

    @NativeClassQualifiedName("CronetUploadDataStreamAdapter")
    void onRewindSucceeded(long r1, CronetUploadDataStream r3);
}
