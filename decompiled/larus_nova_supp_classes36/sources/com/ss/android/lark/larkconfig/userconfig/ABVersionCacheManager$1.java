package com.ss.android.lark.larkconfig.userconfig;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
class ABVersionCacheManager$1 implements IGetDataCallback<Map<String, String>> {
    final /* synthetic */ a this$0;
    final /* synthetic */ f.a val$initCallback;

    public /* bridge */ /* synthetic */ void onError(Object r1) {
        onError((ErrorResult) r1);
    }

    public void onSuccess(Map<String, String> r2) {
        ((ConcurrentHashMap) this.this$0.a).putAll(r2);
        throw null;
    }

    public void onError(ErrorResult r1) {
        throw null;
    }

    public /* bridge */ /* synthetic */ void onSuccess(Object r1) {
        onSuccess((Map) r1);
    }

    public ABVersionCacheManager$1(a r1, f.a r2) {
        this.this$0 = r1;
    }
}
