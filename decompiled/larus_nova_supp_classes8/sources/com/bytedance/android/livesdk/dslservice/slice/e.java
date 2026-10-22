package com.bytedance.android.livesdk.dslservice.slice;

import com.bytedance.android.livesdk.dslservice.util.o;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ SliceDSLProcess$wrapInnerCallback$1 a;
    public final /* synthetic */ String b;

    public e(SliceDSLProcess$wrapInnerCallback$1 r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r5) {
        o.f.i(((Long) r5).longValue(), this.a.a.a, this.b);
    }
}
