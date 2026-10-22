package com.bytedance.android.live.liveinteract.plantform.core;

import com.bytedance.android.live.liveinteract.plantform.model.w0;
import com.bytedance.android.livesdk.config.xb0;
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkUserFirstUpdateEvent;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a0<T> implements Consumer {
    public final /* synthetic */ y a;
    public final /* synthetic */ boolean b;

    public a0(y r1) {
        this.a = r1;
        this.b = true;
    }

    public final void accept(Object r3) {
        w0 r4 = (w0) r3;
        Intrinsics.checkNotNullParameter(r4, "response");
        y r0 = this.a;
        r0.l = false;
        r0.s(r4, "WRDS");
        if (((Boolean) xb0.a.getValue()).booleanValue() == false) goto L6;
        xs2.b.a().post(new LinkUserFirstUpdateEvent());
    L6:
        if (this.b == false) goto L11;
        y r5 = this.a;
        if (r5.I == true) goto L12;
        y.f(r5, r5.c);
        return;
    L12:
        return;
    }
}
