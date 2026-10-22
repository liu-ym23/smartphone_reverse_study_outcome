package com.bytedance.ai.bridge.method.phoneNum;

import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.l;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ai.applet.login.c f1897a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f1898b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ l f1899c;

    public b(com.bytedance.ai.applet.login.c r5, AtomicBoolean r10, l r11) {
        this.f1897a = r5;
        this.f1898b = r10;
        this.f1899c = r11;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        Intrinsics.checkNotNullParameter(GetPhoneNumMethod.TAG, "tag");
        t0.d r5 = com.bytedance.ai.utils.c.f2846a;
        if (r5 == null) goto L5;
        r5.d(GetPhoneNumMethod.TAG, "User clicked reject");
    L5:
        this.f1897a.a();
        l r10 = this.f1899c;
        GetPhoneNumMethod.UserAction r11 = GetPhoneNumMethod.UserAction.f1886b;
        GetPhoneNumMethod.access$showDialogAndAwaitAction$lambda$2$safeResume(this.f1898b, r10, r11);
        return Unit.INSTANCE;
    }
}
