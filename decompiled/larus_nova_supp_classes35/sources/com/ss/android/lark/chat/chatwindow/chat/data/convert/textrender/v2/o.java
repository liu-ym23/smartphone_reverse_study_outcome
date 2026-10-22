package com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.v2;

import android.content.Context;
import com.ss.android.lark.chat.utils.y0;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class o implements com.ss.android.lark.movable.selection.h {
    public final /* synthetic */ Function2<String, Context, Unit> a;
    public final /* synthetic */ m2b.a b;

    /* JADX WARN: Multi-variable type inference failed */
    public o(Function2<? super String, ? super Context, Unit> r1, m2b.a r2) {
        this.a = r1;
        this.b = r2;
    }

    public final boolean a(String r2, String r3, Context r4) {
        Intrinsics.checkNotNullParameter(r2, "text");
        Intrinsics.checkNotNullParameter(r3, "markdownStr");
        Intrinsics.checkNotNullParameter(r4, "context");
        int r5 = y0.a;
        if (y0.a(this.b.getChat()) == false) goto L6;
        return false;
    L6:
        y0.f(r4);
        return true;
    }

    public final void b(String r2, String r3, Context r4) {
        Intrinsics.checkNotNullParameter(r2, "text");
        Intrinsics.checkNotNullParameter(r3, "markdownStr");
        Intrinsics.checkNotNullParameter(r4, "context");
        this.a.invoke(r3, r4);
    }
}
