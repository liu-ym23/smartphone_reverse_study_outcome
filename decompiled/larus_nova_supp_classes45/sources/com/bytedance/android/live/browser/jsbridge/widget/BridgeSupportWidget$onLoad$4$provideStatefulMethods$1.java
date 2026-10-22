package com.bytedance.android.live.browser.jsbridge.widget;

import com.bytedance.android.live.browser.jsbridge.newmethods.i4;
import com.bytedance.ies.web.jsbridge2.f;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class BridgeSupportWidget$onLoad$4$provideStatefulMethods$1 implements f.b {
    public final Lazy a;
    public final /* synthetic */ BridgeSupportWidget.AnonymousClass4 b;

    public final f<?, ?> a() {
        return (i4) this.a.getValue();
    }

    public BridgeSupportWidget$onLoad$4$provideStatefulMethods$1(BridgeSupportWidget.AnonymousClass4 r2) {
        this.b = r2;
        this.a = LazyKt.lazy(LazyThreadSafetyMode.NONE, new BridgeSupportWidget$onLoad$4$provideStatefulMethods$1$registerMethod$2(this));
    }
}
