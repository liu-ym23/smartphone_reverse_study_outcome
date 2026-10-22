package com.bytedance.android.ec.core.arch.state;

import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d<T> implements Observer {
    public final /* synthetic */ Function1 a;

    public d(Function1 r1) {
        this.a = r1;
    }

    public final void onChanged(Object r10) {
        A r11 = ((f) r10).a;
        this.a.invoke(r11);
    }
}
