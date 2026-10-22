package org.chromium;

import com.bytedance.frameworks.baselib.network.http.cronet.TTNetThreadConfig;
import com.ttnet.org.chromium.net.TTThreadConfigInfoProvider$Callback;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class CronetClient$2 implements TTThreadConfigInfoProvider$Callback {
    final /* synthetic */ CronetClient this$0;
    final /* synthetic */ TTNetThreadConfig.Callback val$threadBindCore;

    @Override // com.ttnet.org.chromium.net.TTThreadConfigInfoProvider$Callback
    public void bindBigCore(int r2) {
        this.val$threadBindCore.bindBigCore(r2);
    }

    @Override // com.ttnet.org.chromium.net.TTThreadConfigInfoProvider$Callback
    public void bindLittleCore(int r2) {
        this.val$threadBindCore.bindLittleCore(r2);
    }

    @Override // com.ttnet.org.chromium.net.TTThreadConfigInfoProvider$Callback
    public void resetCoreBind(int r2) {
        this.val$threadBindCore.resetCoreBind(r2);
    }

    public CronetClient$2(CronetClient r1, TTNetThreadConfig.Callback r2) {
        this.this$0 = r1;
        this.val$threadBindCore = r2;
    }
}
