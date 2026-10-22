package com.lynx.jsbridge;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a implements IModuleCreator {
    public final ConcurrentHashMap<String, LynxModuleWrapper> a;
    public volatile b b;

    public a(b r2) {
        this.a = new ConcurrentHashMap();
        this.b = r2;
    }
}
