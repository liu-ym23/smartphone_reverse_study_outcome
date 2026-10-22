package com.larus.uaigc.createpage.component.input;

import androidx.fragment.app.FragmentManager;
import com.larus.uaigc.createpage.component.digitalavatar.DigitalAvatarInfoManager;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.input.CreationInputComponent$tryShowUpdateDialog$1", f = "CreationInputComponent.kt", i = {}, l = {465}, m = "invokeSuspend", n = {}, s = {})
final class CreationInputComponent$tryShowUpdateDialog$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ CreationInputComponent this$0;

    public static final class a {
        public a(CreationInputComponent r1) {
        }
    }

    public CreationInputComponent$tryShowUpdateDialog$1(CreationInputComponent r1, Continuation<? super CreationInputComponent$tryShowUpdateDialog$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new CreationInputComponent$tryShowUpdateDialog$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L21:
        Integer r11 = (Integer) r10;
    L22:
        Integer r6 = r11;
        ny9.s r12 = this.this$0.C3();
        if (r12 == null) goto L36;
        Integer r13 = r12.l();
        if (r13 == null) goto L36;
        CreationInputComponent r8 = this.this$0;
        int r2 = r13.intValue();
        com.larus.platform.service.e0 r3 = com.larus.platform.service.e0.a;
        FragmentManager r4 = s1a.a.c(r8).getParentFragmentManager();
        ny9.u r14 = r8.H3();
        if (r14 == null) goto L29;
        String r15 = r14.getEnterMethod();
    L30:
        String r5 = r15;
        ny9.u r16 = r8.H3();
        if (r16 == null) goto L33;
        String r17 = r16.getBotId();
    L34:
        String r7 = r17;
        DigitalAvatarInfoManager.a.getClass();
        r8.D = r3.Y0(r2, r4, r5, r7, DigitalAvatarInfoManager.g(), r6, new a(r8));
        goto L36
    L33:
        r17 = null;
        goto L34
    L29:
        r15 = "";
    L36:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        CreationInputComponent r18 = this.this$0;
        long[] r9 = CreationInputComponent.F;
        ny9.u r19 = r18.H3();
        if (r19 != null) goto L11;
    L13:
        boolean r110 = false;
    L14:
        if (r110 == false) goto L36;
        DigitalAvatarInfoManager r111 = DigitalAvatarInfoManager.a;
        r111.getClass();
        com.larus.uaigc.api.a r20 = DigitalAvatarInfoManager.i;
        if (r20 == null) goto L18;
        r11 = Boxing.boxInt(r20.f());
        goto L22
    L18:
        this.label = 1;
        r10 = r111.b(this);
        if (r10 != r0) goto L21;
        return r0;
    L11:
        if (r19.l() != true) goto L13;
        r110 = true;
        goto L14
    }
}
