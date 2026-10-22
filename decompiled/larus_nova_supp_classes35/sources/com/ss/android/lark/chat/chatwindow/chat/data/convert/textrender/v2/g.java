package com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.v2;

import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class g<R> extends e implements Function0<R> {
    public final Function0<R> c;

    public final R invoke() {
        return (R) this.c.invoke();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public g(a r2, String r3, Function0<? extends R> r4) {
        Intrinsics.checkNotNullParameter(r2, "scope");
        Intrinsics.checkNotNullParameter(r3, "role");
        Intrinsics.checkNotNullParameter(r4, Keys.API_PARAM_KEY_ACTION);
        super(r2, r3);
        this.c = r4;
    }
}
