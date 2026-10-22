package com.bytedance.android.livesdk.interactivity.common.enterAnim;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a implements c {
    public boolean a;
    public boolean b;
    public final Function0<Unit> c;

    @Override // com.bytedance.android.livesdk.interactivity.common.enterAnim.c
    public final void a() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.common.enterAnim.c
    public final void b() {
        this.a = true;
        if (this.b == false) goto L7;
        this.c.invoke();
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.common.enterAnim.c
    public final void c() {
        this.b = true;
        if (this.a == false) goto L6;
        this.c.invoke();
        return;
    }

    public a(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "onRenderEndCallBack");
        this.c = r2;
    }
}
