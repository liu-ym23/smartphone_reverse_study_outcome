package com.bytedance.android.livesdk.gamesticker.hok.anim;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public abstract class a {
    public TaskState a;
    public d b;
    public g c;

    public abstract void a();

    public abstract void d();

    public abstract String e();

    public a() {
        this.a = TaskState.CREATE;
    }

    public final void b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
        e();
    }

    public final void c(TaskState r2) {
        Intrinsics.checkNotNullParameter(r2, "value");
        this.a = r2;
        if (r2 != TaskState.END) goto L8;
        d r3 = this.b;
        if (r3 == null) goto L13;
        r3.a(this);
        return;
    L13:
        return;
    L8:
        if (r2 != TaskState.START) goto L15;
        d r4 = this.b;
        if (r4 == null) goto L16;
        r4.b(this);
        return;
    L16:
        return;
    }
}
