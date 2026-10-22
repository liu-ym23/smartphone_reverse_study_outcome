package com.ss.android.lark.im.sdk.message.resend;

import com.bytedance.lark.rustclient.api.s;
import com.bytedance.lark.rustclient.api.t;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class f<T, R> implements Function {
    public static final f<T, R> a = null;

    static {
        a = new f();
    }

    public f() {
    }

    public final Object apply(Object r2) {
        s r3 = (s) r2;
        Intrinsics.checkNotNullParameter(r3, "it");
        return t.e(r3, FinalResendMessageStepV2$callSdkPreResendMessage$1$1.INSTANCE);
    }
}
