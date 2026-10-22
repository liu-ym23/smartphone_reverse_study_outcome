package com.bytedance.android.livesdk.feed.squarefeed;

import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class h<T> implements Observer {
    public final /* synthetic */ Function1 a;

    public h(Function1 r1) {
        this.a = r1;
    }

    public final void onChanged(T r2) {
        if (r2 == null) goto L5;
        this.a.invoke(r2);
        return;
    }
}
