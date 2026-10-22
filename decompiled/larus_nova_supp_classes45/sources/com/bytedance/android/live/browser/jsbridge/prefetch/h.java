package com.bytedance.android.live.browser.jsbridge.prefetch;

import com.bytedance.android.live.browser.jsbridge.protobuf.ExternalProtobufMessageDefinitions;
import com.bytedance.android.live.browser.jsbridge.protobuf.ExternalProtobufShrinkConfigs;
import java.util.concurrent.Callable;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class h<V> implements Callable {
    public static final h a = null;

    static {
        a = new h();
    }

    public h() {
    }

    @Override // java.util.concurrent.Callable
    public final void call() {
        ExternalProtobufMessageDefinitions.b.a();
        ExternalProtobufShrinkConfigs.b.a();
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        call();
        return Unit.INSTANCE;
    }
}
