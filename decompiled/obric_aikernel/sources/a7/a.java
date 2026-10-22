package a7;

import com.obric.aikernel.qnn.QnnEnvInitHelper;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends c7.a {
    public a() {
    }

    @Override // c7.a
    public void a() {
        QnnEnvInitHelper.f4829a.a();
    }

    @Override // c7.a
    public void b() {
        QnnEnvInitHelper.f4829a.c();
    }

    @Override // c7.a
    public Object c(Continuation<? super Unit> r10) {
        Object r11 = QnnEnvInitHelper.f4829a.e(r10);
        if (r11 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r11;
    L6:
        return Unit.INSTANCE;
    }
}
