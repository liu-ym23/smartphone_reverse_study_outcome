package com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.v2;

import android.content.Context;
import android.view.View;
import androidx.core.util.Pools;
import com.ss.android.lark.widget.light.layout.TextLayoutViewHelperKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class k implements com.ss.android.lark.widget.light.viewstub.f {
    public final /* synthetic */ com.ss.android.lark.widget.light.viewstub.f.a b;
    public final /* synthetic */ TextLayoutCacheStoreImpl2 c;
    public final /* synthetic */ Context d;

    public final View a(com.ss.android.lark.widget.light.viewstub.h r4) {
        Intrinsics.checkNotNullParameter(r4, "stubSpan");
        TextLayoutCacheStoreImpl2 r0 = this.c;
        Context r1 = this.d;
        Pools.SynchronizedPool<View> r2 = r0.d.get(Integer.valueOf(r4.getClass().hashCode()));
        if (r2 == null) goto L7;
        View r3 = (View) r2.acquire();
        if (r3 == null) goto L7;
        return r3;
    L7:
        return r4.b(r1);
    }

    public k(TextLayoutCacheStoreImpl2 r1, Context r2) {
        this.c = r1;
        this.d = r2;
        this.b = com.ss.android.lark.widget.light.viewstub.f.a;
    }

    public final void b(View r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        this.b.getClass();
        Intrinsics.checkNotNullParameter(r3, "view");
        TextLayoutViewHelperKt.a(r3, r4);
    }
}
