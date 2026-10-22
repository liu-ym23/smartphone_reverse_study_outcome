package com.ttnet.org.chromium.net;

import com.ttnet.org.chromium.base.annotations.NativeClassQualifiedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public interface ProxyChangeListener$Natives {
    @NativeClassQualifiedName("ProxyConfigServiceAndroid::JNIDelegate")
    void proxySettingsChanged(long r1, ProxyChangeListener r3);

    @NativeClassQualifiedName("ProxyConfigServiceAndroid::JNIDelegate")
    void proxySettingsChangedTo(long r1, ProxyChangeListener r3, String r4, int r5, String r6, String[] r7);
}
