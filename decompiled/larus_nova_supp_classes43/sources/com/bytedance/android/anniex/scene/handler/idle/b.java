package com.bytedance.android.anniex.scene.handler.idle;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b extends c<Object> {
    public final /* synthetic */ c.a<Object> j;

    @Override // com.bytedance.android.anniex.scene.handler.idle.c
    public final void a(Object r10) {
        Function1<? super Object, Unit> r0 = this.j.h;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("runner");
        r0 = null;
    L5:
        r0.invoke(r10);
    }

    public b(TaskType r14, c.a<Object> r15, String r16, String r17, String r18, int r19, long r20, long r22, boolean r24, Object r25) {
        this.j = r15;
        super(r16, r14, r17, r18, r19, r20, r22, r24, r25);
    }
}
