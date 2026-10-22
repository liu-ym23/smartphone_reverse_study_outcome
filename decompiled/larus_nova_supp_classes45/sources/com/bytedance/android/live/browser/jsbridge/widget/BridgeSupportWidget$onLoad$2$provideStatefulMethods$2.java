package com.bytedance.android.live.browser.jsbridge.widget;

import com.bytedance.android.live.browser.jsbridge.newmethods.ga;
import com.bytedance.ies.web.jsbridge2.f;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class BridgeSupportWidget$onLoad$2$provideStatefulMethods$2 implements f.b {
    public final Lazy a;
    public final /* synthetic */ BridgeSupportWidget.AnonymousClass2 b;

    public final f<?, ?> a() {
        return (ga) this.a.getValue();
    }

    public BridgeSupportWidget$onLoad$2$provideStatefulMethods$2(BridgeSupportWidget.AnonymousClass2 r2) {
        this.b = r2;
        this.a = LazyKt.lazy(LazyThreadSafetyMode.NONE, new BridgeSupportWidget$onLoad$2$provideStatefulMethods$2$method$2(this));
    }
}
