package com.bytedance.android.annie.bridge.method;

import com.bytedance.android.annie.api.container.HybridDialog;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class l0 implements com.bytedance.ies.web.jsbridge2.f.b {
    public final /* synthetic */ HybridDialog a;

    public l0(HybridDialog r1) {
        this.a = r1;
    }

    public final com.bytedance.ies.web.jsbridge2.f a() {
        return new w0(new WeakReference(this.a.getActivity()), this.a);
    }
}
