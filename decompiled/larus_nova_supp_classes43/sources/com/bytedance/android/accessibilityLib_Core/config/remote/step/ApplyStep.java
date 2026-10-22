package com.bytedance.android.accessibilityLib_Core.config.remote.step;

import android.content.Context;
import com.bytedance.android.accessibilityLib_Core.config.base.IBaseConfig;
import com.bytedance.android.accessibilityLib_Core.config.remote.dsl.d;
import com.bytedance.android.accessibilityLib_Core.config.remote.dsl.e;
import com.bytedance.android.accessibilityLib_Core.config.remote.dsl.h;
import com.bytedance.android.accessibilityLib_Core.engine.AccessibilityConfigEngine;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class ApplyStep extends a<Boolean, Unit> {
    public boolean a;
    public final List<IBaseConfig> b;
    public final TransferStep c;

    public ApplyStep(TransferStep r1) {
        this.c = r1;
        this.b = new ArrayList();
    }

    public final Object a(Boolean r10, Continuation<? super Unit> r11) {
        if ((r11 instanceof ApplyStep$excute$1) == false) goto L7;
        ApplyStep$excute$1 r0 = (ApplyStep$excute$1) r11;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r12 = r0.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r14 = r0.label;
        if (r14 == 0) goto L14;
        if (r14 != 1) goto L13;
        ApplyStep r15 = (ApplyStep) r0.L$0;
        ResultKt.throwOnFailure(r12);
    L27:
        List r16 = (List) r12;
        if (r16.isEmpty() == false) goto L32;
        Context r17 = com.bytedance.android.accessibilityLib_Core.helper.a.a;
        return Unit.INSTANCE;
    L32:
        if (((ArrayList) r15.b).isEmpty() == false) goto L34;
        ((ArrayList) r15.b).addAll(r16);
    L55:
        if (("after apply, remoteConfigList size = " + ((ArrayList) r15.b).size()) == null) goto L57;
        Context r18 = com.bytedance.android.accessibilityLib_Core.helper.a.a;
    L57:
        ArrayList<IBaseConfig> r19 = AccessibilityConfigEngine.a;
        List<IBaseConfig> r20 = r15.b;
        ArrayList<IBaseConfig> r21 = AccessibilityConfigEngine.b;
        r21.clear();
        r21.addAll(r20);
        AccessibilityConfigEngine.e.clear();
        Iterator<IBaseConfig> r22 = r21.iterator();
    L59:
        if (r22.hasNext() == false) goto L85;
        IBaseConfig r23 = r22.next();
        AccessibilityConfigEngine.c(r23);
        d r24 = r23.getVirtualNode().f;
        if (r24 == null) goto L59;
        Iterator<T> r25 = r24.a.iterator();
    L64:
        if (r25.hasNext() == false) goto L59;
        com.bytedance.android.accessibilityLib_Core.config.remote.dsl.c r26 = (com.bytedance.android.accessibilityLib_Core.config.remote.dsl.c) r25.next();
        Iterator<T> r27 = r26.a.iterator();
    L67:
        if (r27.hasNext() == false) goto L76;
        e r28 = (e) r27.next();
        if (r28.b == true) goto L67;
        h r29 = r28.c;
        if (r29 == null) goto L67;
        if (("add dynamic viewIdentifyDsl = " + r29) == null) goto L75;
        Context r30 = com.bytedance.android.accessibilityLib_Core.helper.a.a;
    L75:
        AccessibilityConfigEngine.e.add(r29);
        goto L67
    L76:
        List<h> r31 = r26.b;
        if (r31 == null) goto L64;
        Iterator<T> r32 = r31.iterator();
    L80:
        if (r32.hasNext() == false) goto L64;
        h r33 = (h) r32.next();
        if (("add dynamic viewidenfify for condition, viewidentify = " + r33) == null) goto L84;
        Context r34 = com.bytedance.android.accessibilityLib_Core.helper.a.a;
    L84:
        AccessibilityConfigEngine.e.add(r33);
        goto L80
    L85:
        AccessibilityConfigEngine.c = true;
        if (("need dynamic label viewidentify size = " + AccessibilityConfigEngine.e.size()) == null) goto L88;
        Context r35 = com.bytedance.android.accessibilityLib_Core.helper.a.a;
    L88:
        Context r36 = com.bytedance.android.accessibilityLib_Core.helper.a.a;
        r15.a = true;
        return Unit.INSTANCE;
    L34:
        ArrayList r37 = new ArrayList();
        Iterator r38 = r16.iterator();
    L36:
        if (r38.hasNext() == false) goto L51;
        IBaseConfig r39 = (IBaseConfig) r38.next();
        Integer r40 = r39.getVirtualNode().b;
        Iterator r41 = ((ArrayList) r15.b).iterator();
    L39:
        if (r41.hasNext() == false) goto L43;
        Object r42 = r41.next();
        if (Boxing.boxBoolean(Intrinsics.areEqual(((IBaseConfig) r42).getVirtualNode().b, r40)).booleanValue() == false) goto L39;
    L44:
        IBaseConfig r43 = (IBaseConfig) r42;
        if (r43 == null) goto L49;
        boolean r44 = ((ArrayList) r15.b).remove(r43);
        r37.add(r43);
        if (("ApplyStep remove old config, viewId = " + r39.getVirtualNode().b + ", name = " + r39.name() + ", removeSuccess = " + r44) == null) goto L49;
        Context r45 = com.bytedance.android.accessibilityLib_Core.helper.a.a;
    L49:
        ((ArrayList) r15.b).add(r39);
        goto L36
    L43:
        r42 = null;
        goto L44
    L51:
        if (("ApplyStep remove old config, removeConfigList size = " + r37.size()) == null) goto L53;
        Context r46 = com.bytedance.android.accessibilityLib_Core.helper.a.a;
    L53:
        AccessibilityConfigEngine.d(r37);
        goto L55
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r12);
        if (this.a == false) goto L21;
        if (Intrinsics.areEqual(r10, Boxing.boxBoolean(false)) == false) goto L21;
        return Unit.INSTANCE;
    L21:
        if (("ApplyStep excute now, remoteConfigSize = " + ((ArrayList) this.b).size()) == null) goto L23;
        Context r47 = com.bytedance.android.accessibilityLib_Core.helper.a.a;
    L23:
        TransferStep r48 = this.c;
        r0.L$0 = this;
        r0.label = 1;
        r12 = r48.a(r10, r0);
        if (r12 != r13) goto L26;
        return r13;
    L26:
        r15 = this;
    L7:
        r0 = new ApplyStep$excute$1(this, r11);
        goto L8
    }
}
