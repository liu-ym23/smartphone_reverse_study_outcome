package com.larus.uaigc.createpage.component.input;

import android.os.Bundle;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.input.CreationInputComponent$initInputContent$1$1", f = "CreationInputComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class CreationInputComponent$initInputContent$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $it;
    int label;
    final /* synthetic */ CreationInputComponent this$0;

    public CreationInputComponent$initInputContent$1$1(CreationInputComponent r1, String r2, Continuation<? super CreationInputComponent$initInputContent$1$1> r3) {
        this.this$0 = r1;
        this.$it = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new CreationInputComponent$initInputContent$1$1(this.this$0, this.$it, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L48;
        ResultKt.throwOnFailure(r11);
        ny9.s r12 = this.this$0.C3();
        if (r12 == null) goto L12;
        Bundle r13 = r12.a;
        if (r13 == null) goto L9;
        boolean r14 = r13.getBoolean("no_ime_when_init", false);
    L10:
        if (r14 != true) goto L12;
        boolean r15 = true;
    L13:
        if (r15 == false) goto L15;
    L17:
        boolean r16 = false;
    L18:
        ICoreInputAbility r2 = this.this$0.D3();
        if (r2 == null) goto L41;
        String r3 = this.$it;
        if (r16 == true) goto L23;
    L25:
        boolean r5 = false;
    L26:
        ny9.s r0 = this.this$0.C3();
        if (r0 == null) goto L33;
        Bundle r1 = r0.a;
        if (r1 == null) goto L31;
        Integer r4 = Integer.valueOf(r1.getInt("select_start_position", -1));
    L32:
        Integer r6 = r4;
    L34:
        ny9.s r7 = this.this$0.C3();
        if (r7 == null) goto L39;
        Bundle r8 = r7.a;
        if (r8 == null) goto L39;
        Integer r9 = Integer.valueOf(r8.getInt("select_end_position", -1));
    L40:
        ICoreInputAbility.b.d(r2, r3, r16, r5, r6, r9, false, 32);
    L39:
        r9 = null;
        goto L40
    L31:
        r4 = null;
        goto L32
    L33:
        r6 = null;
        goto L34
    L23:
        if (this.this$0.Z3() == true) goto L25;
        r5 = true;
    L41:
        if (r16 == false) goto L46;
        if (this.this$0.Z3() == false) goto L46;
        CreationInputComponent r17 = this.this$0;
        r17.h4("setTextAndShowIme", 100, r17.h3());
    L46:
        return Unit.INSTANCE;
    L15:
        if (this.this$0.k4() == true) goto L17;
        r16 = true;
        goto L18
    L9:
        r14 = false;
    L12:
        r15 = false;
        goto L13
    L48:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
