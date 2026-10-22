package com.ss.android.lark.conditional.access.nopermission.viewmodel;

import android.app.Activity;
import android.content.Context;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.lark.pb.basic.v1.LarkError;
import com.bytedance.lark.rustclient.api.RustClientException;
import com.larksuite.component.universe_design.toast.UDToast;
import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginList;
import com.ss.android.lark.conditional.access.network.service.ConditionalAccessNetDependency;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.ss.android.lark.utils.LarkContext;
import d0c.c;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import e0c.k;
import e0c.l;
import f0c.h;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class DialogUserScopeView implements c, d0c.a {
    public final UserSession a;
    public final Context b;
    public final CompositeDisposable c;
    public final CoroutineScope d;
    public final ConditionalAccessNetDependency e;
    public final k8b.c f;
    public final yyb.b g;

    public static final class a {
    }

    static {
    }

    public final void afterUserOffline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void afterUserOnline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final /* synthetic */ Object generatedComponent() {
        return DwarfComponentProvider.-CC.$default$generatedComponent(this);
    }

    public final /* synthetic */ m getPassport() {
        return d0c.b.a(this);
    }

    public final void onUserOffline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void onUserOnline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final /* synthetic */ l provideComponent() {
        return d0c.b.b(this);
    }

    /* JADX INFO: renamed from: provideComponent, reason: collision with other method in class */
    public final /* bridge */ /* synthetic */ Object m989provideComponent() {
        return provideComponent();
    }

    public final UserSession e9() {
        return this.a;
    }

    public Context getContext() {
        return this.b;
    }

    public DialogUserScopeView(UserSession r2, Context r3) {
        Intrinsics.checkNotNullParameter(r2, "session");
        Intrinsics.checkNotNullParameter(r3, "ctx");
        this.a = r2;
        this.b = r3;
        this.c = new CompositeDisposable();
        this.d = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain());
        this.e = (ConditionalAccessNetDependency) k.b(d0c.b.b(this), ConditionalAccessNetDependency.class);
        this.f = (k8b.c) k.b(d0c.b.b(this), k8b.c.class);
        this.g = (yyb.b) k.b(d0c.b.b(this), yyb.b.class);
    }

    public static final void a(DialogUserScopeView r1, Throwable r2) {
        r1.getClass();
        if ((r2 instanceof RustClientException) == false) goto L25;
        LarkError r3 = ((RustClientException) r2).getRustError();
        if (r3 == null) goto L7;
        Integer r4 = r3.code;
    L8:
        if (r4 != null) goto L11;
    L12:
        if (r4 != null) goto L15;
    L16:
        if (r4 != null) goto L19;
    L21:
        boolean r5 = false;
    L23:
        if (r5 == false) goto L25;
        UDToast.show(LarkContext.getApplication(), 2131890529);
        return;
    L19:
        if (r4.intValue() != 100054) goto L21;
    L22:
        r5 = true;
        goto L23
    L15:
        if (r4.intValue() == 100052) goto L22;
    L11:
        if (r4.intValue() == (-1001)) goto L22;
    L7:
        r4 = null;
    L25:
        UDToast.show(LarkContext.getApplication(), 2131890543);
    }

    public final Object c(String r4, final int r5, Continuation<? super Boolean> r6) {
        final SafeContinuation r0 = new SafeContinuation(IntrinsicsKt.intercepted(r6));
        ScsLogger.d("DialogUserScopeView", "userConfirm");
        t4c.a.b(t4c.a.a(this.e.d(r4)), this.c, new DialogUserScopeView$userConfirm$2$1(r5, r0), new DialogUserScopeView$userConfirm$2$2(this, r0));
        Object r7 = r0.getOrThrow();
        if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r6);
    L5:
        return r7;
    }

    public final Object b(Activity r6, String r7, JSONObject r8, String r9, final int r10, Continuation<? super Boolean> r11) {
        if ((r11 instanceof DialogUserScopeView$mfa$1) == false) goto L7;
        DialogUserScopeView$mfa$1 r0 = (DialogUserScopeView$mfa$1) r11;
        int r1 = r0.label;
        if ((r1 & PluginList.LEVEL_NOT_SET) == 0) goto L7;
        r0.label = r1 - PluginList.LEVEL_NOT_SET;
    L8:
        Object r12 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        String r13 = (String) r0.L$1;
        String r14 = (String) r0.L$0;
        ResultKt.throwOnFailure(r12);
    L33:
        return r12;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r10 = r0.I$0;
        r9 = (String) r0.L$3;
        JSONObject r15 = (JSONObject) r0.L$2;
        String r16 = (String) r0.L$1;
        Activity r17 = (Activity) r0.L$0;
        ResultKt.throwOnFailure(r12);
    L21:
        Object r18 = ((Result) r12).unbox-impl();
        if (Result.isFailure-impl(r18) == false) goto L24;
        r18 = null;
    L24:
        String r19 = (String) r18;
        if (r19 == null) goto L27;
        r0.L$0 = r9;
        r0.L$1 = r19;
        r0.L$2 = null;
        r0.L$3 = null;
        r0.I$0 = r10;
        r0.label = 2;
        final SafeContinuation r20 = new SafeContinuation(IntrinsicsKt.intercepted(r0));
        t4c.a.b(t4c.a.a(this.e.c(r19, r9)), this.c, new DialogUserScopeView$mfa$2$1(r10, r20), new DialogUserScopeView$mfa$2$2(r20, this));
        r12 = r20.getOrThrow();
        if (r12 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L31;
        DebugProbesKt.probeCoroutineSuspended(r0);
    L31:
        if (r12 != r2) goto L33;
        return r2;
    L27:
        return Boxing.boxBoolean(false);
    L16:
        ResultKt.throwOnFailure(r12);
        r0.L$0 = r6;
        r0.L$1 = r7;
        r0.L$2 = r8;
        r0.L$3 = r9;
        r0.I$0 = r10;
        r0.label = 1;
        final SafeContinuation r110 = new SafeContinuation(IntrinsicsKt.intercepted(r0));
        ScsLogger.d("DialogUserScopeView", "startNewMfaAuth");
        this.g.a(r6, r7, r8, new DialogUserScopeView$mfa$mfaRes$1$1(r110));
        r12 = r110.getOrThrow();
        if (r12 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L19;
        DebugProbesKt.probeCoroutineSuspended(r0);
    L19:
        if (r12 != r2) goto L21;
        return r2;
    L7:
        r0 = new DialogUserScopeView$mfa$1(this, r11);
        goto L8
    }
}
