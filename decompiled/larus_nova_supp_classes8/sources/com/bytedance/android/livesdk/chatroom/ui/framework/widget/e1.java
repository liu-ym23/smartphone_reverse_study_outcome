package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e1 extends com.bytedance.android.livesdk.user.h<Object> {
    public final /* synthetic */ ShareCompositeWidget a;

    public e1(ShareCompositeWidget r1) {
        this.a = r1;
    }

    public final void onSubscribe(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "d");
        this.a.g.add(r2);
    }
}
