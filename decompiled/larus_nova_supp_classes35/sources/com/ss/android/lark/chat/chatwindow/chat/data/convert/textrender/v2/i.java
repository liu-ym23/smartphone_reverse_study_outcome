package com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.v2;

import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class i<A, B, C, R> extends e implements Function3<A, B, C, R> {
    public final Function3<A, B, C, R> c;

    public i(a r3, Function3 r4) {
        Intrinsics.checkNotNullParameter(r3, "scope");
        Intrinsics.checkNotNullParameter("image", "role");
        Intrinsics.checkNotNullParameter(r4, Keys.API_PARAM_KEY_ACTION);
        super(r3, "image");
        this.c = r4;
    }

    public final R invoke(A r2, B r3, C r4) {
        return (R) this.c.invoke(r2, r3, r4);
    }
}
