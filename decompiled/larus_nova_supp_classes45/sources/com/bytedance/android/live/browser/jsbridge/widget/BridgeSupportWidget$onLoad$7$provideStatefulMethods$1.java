package com.bytedance.android.live.browser.jsbridge.widget;

import com.bytedance.android.live.browser.jsbridge.newmethods.g7;
import com.bytedance.ies.web.jsbridge2.f;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class BridgeSupportWidget$onLoad$7$provideStatefulMethods$1 implements f.b {
    public final Lazy a;
    public final /* synthetic */ BridgeSupportWidget.AnonymousClass7 b;

    public final f<?, ?> a() {
        return (g7) this.a.getValue();
    }

    public BridgeSupportWidget$onLoad$7$provideStatefulMethods$1(BridgeSupportWidget.AnonymousClass7 r2) {
        this.b = r2;
        this.a = LazyKt.lazy(LazyThreadSafetyMode.NONE, new BridgeSupportWidget$onLoad$7$provideStatefulMethods$1$registerMethod$2(this));
    }
}
