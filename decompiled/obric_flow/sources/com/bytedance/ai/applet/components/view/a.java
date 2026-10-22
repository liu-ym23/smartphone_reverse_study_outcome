package com.bytedance.ai.applet.components.view;

import com.bytedance.ai.bridge.ContainerType;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.a2;
import kotlinx.coroutines.internal.z;
import ym.h;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class a implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1720a;

    public /* synthetic */ a(int r5) {
        this.f1720a = r5;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo2invoke(Object r5, Object r10) {
        switch(this.f1720a) {
            case 0: goto L38;
            case 1: goto L36;
            case 2: goto L35;
            case 3: goto L33;
            case 4: goto L30;
            case 5: goto L16;
            case 6: goto L8;
            default: goto L4;
        };
    L4:
        z r11 = (z) r5;
        CoroutineContext.Element r12 = (CoroutineContext.Element) r10;
        if ((r12 instanceof a2) == false) goto L7;
        a2 r13 = (a2) r12;
        Object r14 = r13.updateThreadContext(r11.f18962a);
        int r15 = r11.d;
        r11.f18963b[r15] = r14;
        r11.d = r15 + 1;
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        r11.f18964c[r15] = r13;
    L7:
        return r11;
    L8:
        a2 r16 = (a2) r5;
        CoroutineContext.Element r17 = (CoroutineContext.Element) r10;
        if (r16 == null) goto L12;
        return r16;
    L12:
        if ((r17 instanceof a2) == false) goto L15;
        return (a2) r17;
    L15:
        return null;
    L16:
        CoroutineContext.Element r18 = (CoroutineContext.Element) r10;
        if ((r18 instanceof a2) == true) goto L19;
        return r5;
    L19:
        if ((r5 instanceof Integer) == false) goto L21;
        Integer r19 = (Integer) r5;
    L23:
        if (r19 == null) goto L25;
        int r20 = r19.intValue();
    L26:
        if (r20 != 0) goto L29;
        return r18;
    L29:
        return Integer.valueOf(r20 + 1);
    L25:
        r20 = 1;
        goto L26
    L21:
        r19 = null;
        goto L23
    L30:
        CoroutineContext.Element r21 = (CoroutineContext.Element) r10;
        return Integer.valueOf(((Integer) r5).intValue() + 1);
    L36:
        Boolean r22 = (Boolean) r5;
        r22.booleanValue();
        CoroutineContext.Element r23 = (CoroutineContext.Element) r10;
        return r22;
    L38:
        String r24 = (String) r5;
        ContainerType r25 = (ContainerType) r10;
        Intrinsics.checkNotNullParameter(r24, "schema");
        Intrinsics.checkNotNullParameter(r25, "containerType");
        return Boolean.valueOf(h.h(r24, r25));
    L33:
        return ((CoroutineContext) r5).plus((CoroutineContext.Element) r10);
    L35:
        return ((CoroutineContext) r5).plus((CoroutineContext.Element) r10);
    }
}
