package com.bytedance.ai.bridge.method.phoneNum;

import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.l;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ai.applet.login.c f1900a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f1901b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ l f1902c;

    public c(com.bytedance.ai.applet.login.c r5, AtomicBoolean r10, l r11) {
        this.f1900a = r5;
        this.f1901b = r10;
        this.f1902c = r11;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        Intrinsics.checkNotNullParameter(GetPhoneNumMethod.TAG, "tag");
        t0.d r5 = com.bytedance.ai.utils.c.f2846a;
        if (r5 == null) goto L5;
        r5.d(GetPhoneNumMethod.TAG, "User clicked accept");
    L5:
        this.f1900a.a();
        l r10 = this.f1902c;
        GetPhoneNumMethod.UserAction r11 = GetPhoneNumMethod.UserAction.f1885a;
        GetPhoneNumMethod.access$showDialogAndAwaitAction$lambda$2$safeResume(this.f1901b, r10, r11);
        return Unit.INSTANCE;
    }
}
