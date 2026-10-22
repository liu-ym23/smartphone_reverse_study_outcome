package com.larus.enterprise.impl.apptheme.repo;

import com.bytedance.keva.Keva;
import com.google.gson.Gson;
import com.larus.network.http.f;
import com.larus.network.http.y;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import z89.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.enterprise.impl.apptheme.repo.ThemeConfigRepo$requestThemeConfig$1", f = "ThemeConfigRepo.kt", i = {}, l = {100}, m = "invokeSuspend", n = {}, s = {})
public final class ThemeConfigRepo$requestThemeConfig$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AtomicReference<ThemeConfigRepo.RequestState> $requestState;
    final /* synthetic */ String $scene;
    int label;

    public ThemeConfigRepo$requestThemeConfig$1(String r1, AtomicReference<ThemeConfigRepo.RequestState> r2, Continuation<? super ThemeConfigRepo$requestThemeConfig$1> r3) {
        this.$scene = r1;
        this.$requestState = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ThemeConfigRepo$requestThemeConfig$1(this.$scene, this.$requestState, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = this.label;
        if (r3 == 0) goto L9;
        if (r3 != 1) goto L8;
        ResultKt.throwOnFailure(r7);     // Catch: Throwable -> L18
    L13:
        y r8 = (com.larus.network.http.a) r7;     // Catch: Throwable -> L18
        if ((r8 instanceof y) == false) goto L22;
        c r9 = (c) ((com.larus.network.http.a) r8).b;     // Catch: Throwable -> L18
        Lazy r0 = ThemeConfigRepo.a;     // Catch: Throwable -> L18
        Keva r1 = Keva.getRepo("repo_name_theme_config_".concat(AccountService.a.getUserId()), 0);     // Catch: Throwable -> L18
        if (r1 == null) goto L20;
        r1.storeString("theme_config_" + this.$scene, ((Gson) ThemeConfigRepo.a.getValue()).toJson(r9));     // Catch: Throwable -> L18
    L20:
        ThemeConfigRepo.a(this.$scene).a = r9;     // Catch: Throwable -> L18
        this.$requestState.set(ThemeConfigRepo.RequestState.SUCCESS);     // Catch: Throwable -> L18
    L25:
        if (this.$requestState.get() != ThemeConfigRepo.RequestState.IN_FLIGHT) goto L32;
        this.$requestState.set(ThemeConfigRepo.RequestState.IDLE);
    L32:
        return Unit.INSTANCE;
    L22:
        if ((r8 instanceof f) == false) goto L25;
        this.$requestState.set(ThemeConfigRepo.RequestState.IDLE);     // Catch: Throwable -> L18
        FLogger.a.e("ThemeConfigRepo", "requestThemeConfig: get theme config fail error=" + ((f) r8).d);     // Catch: Throwable -> L18
        goto L25
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r7);
        ThemeConfigApi r10 = (ThemeConfigApi) ThemeConfigApi.a.getValue();     // Catch: Throwable -> L18
        String r4 = this.$scene;     // Catch: Throwable -> L18
        this.label = 1;     // Catch: Throwable -> L18
        r7 = r10.a(r4, this);     // Catch: Throwable -> L18
        if (r7 != r2) goto L13;
        return r2;
    L18:
        th = move-exception;
        AtomicReference<ThemeConfigRepo.RequestState> r5 = this.$requestState;     // Catch: Throwable -> L33
        ThemeConfigRepo.RequestState r6 = ThemeConfigRepo.RequestState.IDLE;     // Catch: Throwable -> L33
        r5.set(r6);     // Catch: Throwable -> L33
        FLogger.a.e("ThemeConfigRepo", "requestThemeConfig: get theme config throwable error=" + th.getMessage());     // Catch: Throwable -> L33
        if (this.$requestState.get() != ThemeConfigRepo.RequestState.IN_FLIGHT) goto L32;
        this.$requestState.set(r6);
    L33:
        th = move-exception;
        if (this.$requestState.get() != ThemeConfigRepo.RequestState.IN_FLIGHT) goto L37;
        this.$requestState.set(ThemeConfigRepo.RequestState.IDLE);
    L37:
        throw th;
    }
}
