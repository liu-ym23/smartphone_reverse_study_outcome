package com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.v2;

import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class h<A, R> extends e implements Function1<A, R> {
    public final Function1<A, R> c;

    public final R invoke(A r2) {
        return (R) this.c.invoke(r2);
    }

    public h(a r3, Function1 r4) {
        Intrinsics.checkNotNullParameter(r3, "scope");
        Intrinsics.checkNotNullParameter("longPress", "role");
        Intrinsics.checkNotNullParameter(r4, Keys.API_PARAM_KEY_ACTION);
        super(r3, "longPress");
        this.c = r4;
    }
}
