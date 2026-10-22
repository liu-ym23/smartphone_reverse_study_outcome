package com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.v2;

import android.content.Context;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class f extends e implements com.ss.android.lark.movable.selection.h {
    public final /* synthetic */ com.ss.android.lark.movable.selection.h c;

    public final boolean a(String r2, String r3, Context r4) {
        Intrinsics.checkNotNullParameter(r2, "text");
        Intrinsics.checkNotNullParameter(r3, "markdownStr");
        Intrinsics.checkNotNullParameter(r4, "context");
        return this.c.a(r2, r3, r4);
    }

    public final void b(String r2, String r3, Context r4) {
        Intrinsics.checkNotNullParameter(r2, "text");
        Intrinsics.checkNotNullParameter(r3, "markdownStr");
        Intrinsics.checkNotNullParameter(r4, "context");
        this.c.b(r2, r3, r4);
    }

    public f(a r2, com.ss.android.lark.movable.selection.h r3) {
        Intrinsics.checkNotNullParameter(r2, "scope");
        Intrinsics.checkNotNullParameter(r3, Keys.API_PARAM_KEY_ACTION);
        super(r2, "copy");
        this.c = r3;
    }
}
