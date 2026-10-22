package com.ss.android.lark.keyboard.plugin.tool.photo;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.keyboard.dtocompat.FrameInfo;
import io.reactivex.disposables.Disposable;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class f extends com.ss.android.lark.utils.rxjava.d<Map<String, ? extends FrameInfo>> {
    public final /* synthetic */ d a;

    public final void onSubscribe(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "d");
    }

    public final void onComplete() {
        this.a.onFinish();
    }

    public f(l r1) {
        this.a = r1;
    }

    public final void a(Throwable r3) {
        d r0 = this.a;
        if (r3 == null) goto L5;
        String r4 = r3.getMessage();
    L6:
        r0.onError(new ErrorResult(r4));
        return;
    L5:
        r4 = null;
        goto L6
    }

    public final void onNext(Object r2) {
        Map<String, FrameInfo> r3 = (Map) r2;
        Intrinsics.checkNotNullParameter(r3, "t");
        this.a.onSuccess(r3);
    }
}
