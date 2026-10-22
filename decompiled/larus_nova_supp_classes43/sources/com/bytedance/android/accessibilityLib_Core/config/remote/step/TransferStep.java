package com.bytedance.android.accessibilityLib_Core.config.remote.step;

import android.content.Context;
import com.bytedance.android.accessibilityLib_Core.config.base.IBaseConfig;
import com.bytedance.android.accessibilityLib_Core.config.remote.dsl.f;
import com.bytedance.android.accessibilityLib_Core.config.remote.dsl.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class TransferStep extends a<Boolean, List<? extends IBaseConfig>> {
    public boolean a;
    public final List<IBaseConfig> b;
    public final ViewIdReplaceStep c;

    public TransferStep(ViewIdReplaceStep r1) {
        this.c = r1;
        this.b = new ArrayList();
    }

    public final Object a(Boolean r10, Continuation<? super List<? extends IBaseConfig>> r11) {
        if ((r11 instanceof TransferStep$excute$1) == false) goto L7;
        TransferStep$excute$1 r0 = (TransferStep$excute$1) r11;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r12 = r0.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r14 = r0.label;
        if (r14 == 0) goto L14;
        if (r14 != 1) goto L13;
        TransferStep r15 = (TransferStep) r0.L$0;
        ResultKt.throwOnFailure(r12);
    L24:
        List r16 = (List) r12;
        if (r16 == null) goto L43;
        Iterator r17 = r16.iterator();
    L28:
        if (r17.hasNext() == false) goto L43;
        f r18 = (f) r17.next();
        if (("activity id = " + r18.a) == null) goto L32;
        Context r19 = com.bytedance.android.accessibilityLib_Core.helper.a.a;
    L32:
        r15.getClass();
        ArrayList r20 = new ArrayList();
        List<g> r21 = r18.b;
        if (r21 == null) goto L42;
        Iterator<T> r22 = r21.iterator();
    L36:
        if (r22.hasNext() == false) goto L42;
        final g r23 = (g) r22.next();
        int r24 = h6.a.a;
        String r25 = r18.a;
        if (r25 != null) goto L41;
        r25 = "defaultActivityPage";
    L41:
        g6.a r26 = new g6.a(r25.concat(":") + r23.a, r23.b.a, new TransferStep$transferConfig$1$config$1(r23));
        r26.build();
        r20.add(r26);
    L42:
        ((ArrayList) r15.b).addAll(r20);
    L43:
        r15.a = true;
        if (("TransferStep excute configList size = " + ((ArrayList) r15.b).size()) == null) goto L47;
        Context r110 = com.bytedance.android.accessibilityLib_Core.helper.a.a;
    L47:
        return r15.b;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r12);
        if (this.a == true) goto L17;
    L20:
        ((ArrayList) this.b).clear();
        Context r27 = com.bytedance.android.accessibilityLib_Core.helper.a.a;
        ViewIdReplaceStep r28 = this.c;
        Boolean r111 = Boxing.boxBoolean(true);
        r0.L$0 = this;
        r0.label = 1;
        r12 = r28.a(r111, r0);
        if (r12 != r13) goto L23;
        return r13;
    L23:
        r15 = this;
        goto L24
    L17:
        if (Intrinsics.areEqual(r10, Boxing.boxBoolean(false)) == false) goto L20;
        Context r29 = com.bytedance.android.accessibilityLib_Core.helper.a.a;
        return this.b;
    L7:
        r0 = new TransferStep$excute$1(this, r11);
        goto L8
    }
}
