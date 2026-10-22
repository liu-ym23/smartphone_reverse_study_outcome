package com.bytedance.ai.bridge.method.login;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.time.Duration;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.bridge.method.login.LoginMethod", f = "LoginMethod.kt", i = {0}, l = {64, 68}, m = "fetchLoginCode-Kx4hsE0", n = {"timeout"}, s = {"L$0"})
public final class LoginMethod$fetchLoginCode$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Duration f1843a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f1844b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ LoginMethod f1845c;
    public int d;

    public LoginMethod$fetchLoginCode$1(LoginMethod r5, Continuation r10) {
        this.f1845c = r5;
        super(r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        this.f1844b = r5;
        this.d |= Integer.MIN_VALUE;
        return LoginMethod.m83access$fetchLoginCodeKx4hsE0(this.f1845c, null, null, this);
    }
}
