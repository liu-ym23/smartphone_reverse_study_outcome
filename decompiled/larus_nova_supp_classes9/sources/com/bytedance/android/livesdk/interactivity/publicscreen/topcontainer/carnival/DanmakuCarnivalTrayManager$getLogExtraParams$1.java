package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.carnival;

import kotlin.Metadata;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class DanmakuCarnivalTrayManager$getLogExtraParams$1 extends MutablePropertyReference0Impl {
    public DanmakuCarnivalTrayManager$getLogExtraParams$1(DanmakuCarnivalTrayManager r7) {
        super(r7, DanmakuCarnivalTrayManager.class, "container", "getContainer()Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/topcontainer/IPSTopContainer;", 0);
    }

    public Object get() {
        f52.b r0 = ((DanmakuCarnivalTrayManager) ((CallableReference) this).receiver).a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("container");
    L5:
        return r0;
    }

    public void set(Object r2) {
        f52.b r3 = (f52.b) r2;
        ((DanmakuCarnivalTrayManager) ((CallableReference) this).receiver).a = r3;
    }
}
