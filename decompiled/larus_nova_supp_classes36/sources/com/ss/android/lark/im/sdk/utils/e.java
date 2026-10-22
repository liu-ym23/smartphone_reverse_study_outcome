package com.ss.android.lark.im.sdk.utils;

import com.bytedance.lark.rustclient.api.t;
import com.larksuite.framework.callback.IGetDataCallback;
import io.reactivex.Observable;
import kotlin.Deprecated;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e {
    @Deprecated(message = "rust client don't return ErrorResult", replaceWith = @ReplaceWith(expression = "subscribeCallback2", imports = {}))
    public static final void a(Observable r2, IGetDataCallback r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        r2.subscribe(new a(r3), new b(r3));
    }

    public static final void b(Observable r3, final IGetDataCallback r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        t.a(r3, new ExtensionsKt$subscribeCallback2$1(r4), new ExtensionsKt$subscribeCallback2$2(r4), new ExtensionsKt$subscribeCallback2$3(r4));
    }
}
