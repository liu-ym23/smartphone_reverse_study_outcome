package com.bytedance.ai.widget;

import com.bytedance.ai.widget.contianer.WidgetContainer;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.widget.GlobalWidgetCache$1$onCompleteUpdate$1", f = "GlobalWidgetCache.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class GlobalWidgetCache$1$onCompleteUpdate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f2910a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f2911b;

    public GlobalWidgetCache$1$onCompleteUpdate$1(String r5, String r10, Continuation r11) {
        this.f2910a = r5;
        this.f2911b = r10;
        super(2, r11);
    }

    public static final boolean a(String r5, String r10, Map.Entry r11) {
        com.bytedance.ai.widget.contianer.h r12 = ((WidgetContainer) ((com.bytedance.ai.widget.contianer.f) r11.getValue())).f;
        String r13 = null;
        if (r12 == null) goto L5;
        String r14 = r12.f3047a;
    L7:
        if (Intrinsics.areEqual(r14, r5) == false) goto L15;
        com.bytedance.ai.widget.contianer.h r15 = ((WidgetContainer) ((com.bytedance.ai.widget.contianer.f) r11.getValue())).f;
        if (r15 == null) goto L12;
        r13 = r15.f3048b;
    L12:
        if (Intrinsics.areEqual(r13, r10) == false) goto L17;
        return true;
    L17:
        return false;
    L15:
        return false;
    L5:
        r14 = null;
        goto L7
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object r5, Continuation r10) {
        return new GlobalWidgetCache$1$onCompleteUpdate$1(this.f2910a, this.f2911b, r10);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
        String r11 = this.f2910a;
        String r12 = this.f2911b;
        return new GlobalWidgetCache$1$onCompleteUpdate$1(r11, r12, r10).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(r5);
        Lazy r10 = c.f2935a;
        StringBuilder r11 = new StringBuilder("onCompleteUpdate ");
        r11.append(this.f2910a);
        r11.append(' ');
        String r12 = androidx.room.jarjarred.org.antlr.runtime.a.v(r11, this.f2911b, "WidgetGlobalCache", "tag");
        t0.d r13 = com.bytedance.ai.utils.c.f2846a;
        if (r13 == null) goto L5;
        r13.d("WidgetGlobalCache", r12);
    L5:
        c.a(new k(this.f2910a, this.f2911b));
        return Unit.INSTANCE;
    }
}
