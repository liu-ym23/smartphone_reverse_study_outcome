package com.larus.dora.impl.device_v2;

import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.dora.impl.databinding.LarusDoraExternalSmartDeviceBindPageBinding;
import com.larus.utils.e1;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.device_v2.DoraSmartDeviceBindFragment$setupPage$1$1", f = "DoraSmartDeviceBindFragment.kt", i = {}, l = {316}, m = "invokeSuspend", n = {}, s = {})
final class DoraSmartDeviceBindFragment$setupPage$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ c59.c0 $pageInfo;
    int label;
    final /* synthetic */ DoraSmartDeviceBindFragment this$0;

    public DoraSmartDeviceBindFragment$setupPage$1$1(DoraSmartDeviceBindFragment r1, c59.c0 r2, Continuation<? super DoraSmartDeviceBindFragment$setupPage$1$1> r3) {
        this.this$0 = r1;
        this.$pageInfo = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DoraSmartDeviceBindFragment$setupPage$1$1(this.this$0, this.$pageInfo, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L11:
        DoraSmartDeviceBindFragment.b r7 = (DoraSmartDeviceBindFragment.b) r6;
        final DoraSmartDeviceBindFragment r2 = this.this$0;
        LarusDoraExternalSmartDeviceBindPageBinding r3 = r2.g;
        if (r3 == null) goto L54;
        TextView r4 = r3.i;
        if (r7 == null) goto L20;
        c59.t r5 = r7.d();
        if (r5 == null) goto L20;
        String r8 = c59.p.b(r5);
        if (r8 == null) goto L20;
    L21:
        r4.setText(r8);
        TextView r9 = r3.g;
        if (r7 == null) goto L28;
        c59.t r10 = r7.b();
        if (r10 == null) goto L28;
        String r11 = c59.p.b(r10);
        if (r11 == null) goto L28;
    L29:
        r9.setText(r11);
        AppCompatTextView r12 = r3.d;
        if (r7 == null) goto L38;
        c59.h r13 = r7.a();
        if (r13 == null) goto L38;
        c59.t r14 = r13.b();
        if (r14 == null) goto L38;
        String r15 = c59.p.b(r14);
        if (r15 == null) goto L38;
    L39:
        r12.setText(r15);
        e1.d(r3.b, new h0(r2));
        if (r2.u.get() == true) goto L54;
        Object r16 = r2.v;
        monitor-enter(r16);
        SimpleDraweeView r17 = r3.f;     // Catch: Throwable -> L50
        if (r7 == null) goto L46;
        c59.u r18 = r7.c();     // Catch: Throwable -> L50
    L47:
        c59.p.e(r17, r18, null, r2.p, 2);     // Catch: Throwable -> L50
        Unit r20 = Unit.INSTANCE;     // Catch: Throwable -> L50
        monitor-exit(r16);
        goto L54
    L46:
        r18 = null;
    L50:
        th = move-exception;
        throw th;
    L38:
        r15 = "";
    L28:
        r11 = "";
    L20:
        r8 = "";
    L54:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        CoroutineDispatcher r21 = Dispatchers.getIO();
        DoraSmartDeviceBindFragment$setupPage$1$1$pageConfig$1 r22 = new DoraSmartDeviceBindFragment$setupPage$1$1$pageConfig$1(this.$pageInfo, null);
        this.label = 1;
        r6 = BuildersKt.withContext(r21, r22, this);
        if (r6 != r0) goto L11;
        return r0;
    }
}
