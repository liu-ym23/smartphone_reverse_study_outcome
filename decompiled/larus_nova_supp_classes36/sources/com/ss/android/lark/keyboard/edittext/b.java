package com.ss.android.lark.keyboard.edittext;

import com.ss.android.lark.image.api.Target;
import com.ss.android.lark.keyboard.edittext2.KeyboardFunctionEditText;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b {
    public final KeyboardFunctionEditText a;
    public final com.ss.android.lark.keyboard.edittext2.copy.a.b b;
    public boolean c;
    public final CoroutineScope d;

    public static final class a {
    }

    static {
    }

    public b(KeyboardFunctionEditText r2) {
        Intrinsics.checkNotNullParameter(r2, "editText");
        this.a = r2;
        this.b = com.ss.android.lark.keyboard.edittext2.copy.a.a;
        this.d = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().getImmediate());
    }

    public static final Object a(b r4, Function1 r5, Continuation r6) {
        r4.getClass();
        if ((r6 instanceof FunctionEditTextCopyCoordinator$withPasteStrategy$1) == false) goto L7;
        FunctionEditTextCopyCoordinator$withPasteStrategy$1 r0 = (FunctionEditTextCopyCoordinator$withPasteStrategy$1) r6;
        int r1 = r0.label;
        if ((r1 & Target.SIZE_ORIGINAL) == 0) goto L7;
        r0.label = r1 - Target.SIZE_ORIGINAL;
    L8:
        Object r7 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        eob.a r8 = (eob.a) r0.L$0;
        ResultKt.throwOnFailure(r7);
    L17:
        com.ss.android.lark.keyboard.edittext2.edittors.anchor.paste.c r9 = com.ss.android.lark.keyboard.edittext2.edittors.anchor.paste.c.a;
        r8.X();
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r7);
        r8 = (eob.a) r4.a.q(eob.a.f);
        r8.U(com.ss.android.lark.keyboard.edittext2.edittors.anchor.paste.c.a);
        r0.L$0 = r8;
        r0.label = 1;
        if (r5.invoke(r0) != r2) goto L17;
        return r2;
    L7:
        r0 = new FunctionEditTextCopyCoordinator$withPasteStrategy$1(r4, r6);
        goto L8
    }
}
