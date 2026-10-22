package com.bytedance.android.livesdk.chatroom.ui.framework.base;

import kotlin.Metadata;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class CompatComponentScheduler$stopLoadComponents$1 extends MutablePropertyReference0Impl {
    public CompatComponentScheduler$stopLoadComponents$1(CompatComponentScheduler r7) {
        super(r7, CompatComponentScheduler.class, "realScheduler", "getRealScheduler()Lcom/bytedance/android/livesdk/chatroom/ui/framework/base/IComponentLoader;", 0);
    }

    public Object get() {
        return CompatComponentScheduler.o((CompatComponentScheduler) ((CallableReference) this).receiver);
    }

    public void set(Object r2) {
        h r3 = (h) r2;
        ((CompatComponentScheduler) ((CallableReference) this).receiver).l = r3;
    }
}
