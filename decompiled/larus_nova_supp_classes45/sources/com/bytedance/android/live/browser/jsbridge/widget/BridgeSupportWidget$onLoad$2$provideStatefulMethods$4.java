package com.bytedance.android.live.browser.jsbridge.widget;

import com.bytedance.android.live.browser.jsbridge.newmethods.wa;
import com.bytedance.ies.web.jsbridge2.f;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class BridgeSupportWidget$onLoad$2$provideStatefulMethods$4 implements f.b {
    public final Lazy a;
    public final /* synthetic */ BridgeSupportWidget.AnonymousClass2 b;

    public final f<?, ?> a() {
        return (wa) this.a.getValue();
    }

    public BridgeSupportWidget$onLoad$2$provideStatefulMethods$4(BridgeSupportWidget.AnonymousClass2 r2) {
        this.b = r2;
        this.a = LazyKt.lazy(LazyThreadSafetyMode.NONE, new BridgeSupportWidget$onLoad$2$provideStatefulMethods$4$method$2(this));
    }
}
