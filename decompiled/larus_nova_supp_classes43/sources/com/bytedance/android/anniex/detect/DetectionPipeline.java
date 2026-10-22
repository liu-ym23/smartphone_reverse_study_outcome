package com.bytedance.android.anniex.detect;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class DetectionPipeline {
    public final List<h> a;
    public final boolean b;
    public final Function1<c, Boolean> c;

    /* JADX INFO: renamed from: com.bytedance.android.anniex.detect.DetectionPipeline$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/anniex/detect/c;", "it", "", "invoke", "(Lcom/bytedance/android/anniex/detect/c;)Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    final class AnonymousClass1 extends Lambda implements Function1<c, Boolean> {
        public static final AnonymousClass1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass1();
        }

        public AnonymousClass1() {
            super(1);
        }

        public final Boolean invoke(c r10) {
            Intrinsics.checkNotNullParameter(r10, "it");
            return Boolean.valueOf(!(r10 instanceof c.C0092c));
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((c) r1);
        }
    }

    public DetectionPipeline() {
        throw null;
    }

    public DetectionPipeline(List r10, Function1 r11) {
        Intrinsics.checkNotNullParameter(r10, "steps");
        Intrinsics.checkNotNullParameter(r11, "shouldInterrupt");
        this.a = r10;
        this.b = false;
        this.c = r11;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0071 -> B:25:0x0074). Please report as a decompilation issue!!! */
    public final Object a(f r10, Continuation<? super c> r11) {
        if ((r11 instanceof DetectionPipeline$run$1) == false) goto L7;
        DetectionPipeline$run$1 r0 = (DetectionPipeline$run$1) r11;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r12 = r0.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r14 = r0.label;
        if (r14 == 0) goto L16;
        if (r14 == 1) goto L15;
        if (r14 != 2) goto L14;
        ResultKt.throwOnFailure(r12);
    L34:
        return r12;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        Iterator<h> r15 = (Iterator) r0.L$2;
        f r16 = (f) r0.L$1;
        DetectionPipeline r17 = (DetectionPipeline) r0.L$0;
        ResultKt.throwOnFailure(r12);
    L25:
        c r18 = (c) r12;
        if (((Boolean) r17.c.invoke(r18)).booleanValue() == false) goto L28;
        return r18;
    L28:
        f r19 = r16;
    L20:
        if (r15.hasNext() == false) goto L30;
        h r20 = r15.next();
        r0.L$0 = r17;
        r0.L$1 = r19;
        r0.L$2 = r15;
        r0.label = 1;
        Object r21 = r20.a(r19, r0);
        if (r21 != r13) goto L24;
        return r13;
    L24:
        r16 = r19;
        r12 = r21;
        goto L25
    L30:
        return new c.C0092c();
    L16:
        ResultKt.throwOnFailure(r12);
        if (this.b == true) goto L31;
        Iterator<h> r22 = this.a.iterator();
        r17 = this;
        r19 = r10;
        r15 = r22;
        goto L20
    L31:
        DetectionPipeline$run$2 r23 = new DetectionPipeline$run$2(this, r10, null);
        r0.label = 2;
        r12 = CoroutineScopeKt.coroutineScope(r23, r0);
        if (r12 != r13) goto L34;
        return r13;
    L7:
        r0 = new DetectionPipeline$run$1(this, r11);
        goto L8
    }
}
