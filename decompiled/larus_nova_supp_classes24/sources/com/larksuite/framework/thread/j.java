package com.larksuite.framework.thread;

import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class j extends g {
    public j(String r3, n r4) {
        super(r3, 1, r4);
        setKeepAliveTime(10, TimeUnit.SECONDS);
        allowCoreThreadTimeOut(true);
        this.b = 5000;
    }
}
