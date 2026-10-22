package com.bytedance.android.annie.lynx.resource;

import android.os.AsyncTask;
import com.lynx.tasm.provider.LynxResourceCallback;
import com.lynx.tasm.provider.LynxResourceRequest;
import d8a.k;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class LynxExternalJSProvider extends k<Object, byte[]> implements com.bytedance.android.annie.card.base.d {
    public final com.bytedance.android.annie.service.resource.g a;
    public volatile boolean b;
    public final ConcurrentHashMap<String, com.bytedance.android.annie.service.resource.h> c;
    public com.bytedance.android.annie.card.base.c d;

    @Override // com.bytedance.android.annie.card.base.d
    public final ConcurrentHashMap<String, com.bytedance.android.annie.service.resource.h> a() {
        return this.c;
    }

    public LynxExternalJSProvider(com.bytedance.android.annie.service.resource.g r10) {
        Intrinsics.checkNotNullParameter(r10, "config");
        this.a = r10;
        this.c = new ConcurrentHashMap();
    }

    public final void request(final LynxResourceRequest<Object> r10, final LynxResourceCallback<byte[]> r11) {
        Intrinsics.checkNotNullParameter(r10, "request");
        Intrinsics.checkNotNullParameter(r11, "callback");
        if (this.b == false) goto L5;
        return;
    L5:
        AsyncTask.THREAD_POOL_EXECUTOR.execute(new AnonymousClass1(this, r10, r11));
    }
}
