package com.bytedance.badger;

import com.bytedance.news.common.service.manager.IServiceProxy;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public class IBadger__ServiceProxy implements IServiceProxy {
    public IBadger__ServiceProxy() {
    }

    public void collectService(Map r3) {
        r3.put("com.bytedance.badger.IBadger", "com.bytedance.badger.BadgerCore");
    }

    public IBadger newInstance() {
        return new BadgerCore();
    }

    /* JADX INFO: renamed from: newInstance, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1158newInstance() {
        return newInstance();
    }
}
