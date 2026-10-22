package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.base.annotations.NativeClassQualifiedName;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public interface CronetUrlRequest$Natives {
    @NativeClassQualifiedName("CronetURLRequestAdapter")
    void abortWhenUploadException(long r1, CronetUrlRequest r3);

    @NativeClassQualifiedName("CronetURLRequestAdapter")
    void addRequestCookieHeader(long r1, CronetUrlRequest r3, String r4, String r5);

    @NativeClassQualifiedName("CronetURLRequestAdapter")
    boolean addRequestHeader(long r1, CronetUrlRequest r3, String r4, String r5);

    @NativeClassQualifiedName("CronetURLRequestAdapter")
    void appTimeout(long r1, CronetUrlRequest r3);

    long createRequestAdapter(CronetUrlRequest r1, long r2, String r4, int r5, int r6, boolean r7, boolean r8, boolean r9, int r10, boolean r11, int r12, int r13, long r14);

    @NativeClassQualifiedName("CronetURLRequestAdapter")
    void destroy(long r1, CronetUrlRequest r3, boolean r4);

    @NativeClassQualifiedName("CronetURLRequestAdapter")
    void followDeferredRedirect(long r1, CronetUrlRequest r3);

    @NativeClassQualifiedName("CronetURLRequestAdapter")
    void getStatus(long r1, CronetUrlRequest r3, VersionSafeCallbacks.UrlRequestStatusListener r4);

    @NativeClassQualifiedName("CronetURLRequestAdapter")
    boolean readData(long r1, CronetUrlRequest r3, ByteBuffer r4, int r5, int r6);

    @NativeClassQualifiedName("CronetURLRequestAdapter")
    void removeRequestCookieHeader(long r1, CronetUrlRequest r3);

    @NativeClassQualifiedName("CronetURLRequestAdapter")
    void setAuthCredentials(long r1, CronetUrlRequest r3, String r4, String r5);

    @NativeClassQualifiedName("CronetURLRequestAdapter")
    boolean setHttpMethod(long r1, CronetUrlRequest r3, String r4);

    @NativeClassQualifiedName("CronetURLRequestAdapter")
    void setRequestTimeout(long r1, CronetUrlRequest r3, int r4);

    @NativeClassQualifiedName("CronetURLRequestAdapter")
    void setRequestTypeFlags(long r1, CronetUrlRequest r3, int r4);

    @NativeClassQualifiedName("CronetURLRequestAdapter")
    void setSocketTimeout(long r1, CronetUrlRequest r3, int r4, int r5, int r6);

    @NativeClassQualifiedName("CronetURLRequestAdapter")
    void setThrottleNetSpeed(long r1, CronetUrlRequest r3, long r4);

    @NativeClassQualifiedName("CronetURLRequestAdapter")
    void start(long r1, CronetUrlRequest r3);
}
