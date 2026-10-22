package com.bytedance.android.live.browser.jsbridge.widget;

import com.bytedance.android.live.browser.jsbridge.newmethods.v7;
import com.bytedance.ies.web.jsbridge2.f;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class BridgeSupportWidget$onLoad$9$provideStatefulMethods$1 implements f.b {
    public final Lazy a;
    public final /* synthetic */ BridgeSupportWidget.AnonymousClass9 b;

    public final f<?, ?> a() {
        return (v7) this.a.getValue();
    }

    public BridgeSupportWidget$onLoad$9$provideStatefulMethods$1(BridgeSupportWidget.AnonymousClass9 r2) {
        this.b = r2;
        this.a = LazyKt.lazy(LazyThreadSafetyMode.NONE, new BridgeSupportWidget$onLoad$9$provideStatefulMethods$1$method$2(this));
    }
}
