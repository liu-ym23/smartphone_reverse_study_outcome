package com.obric.assistant.special_input;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.special_input.OSkillExtensionSettingRepository$requestRemoteRead$1", f = "OSkillExtensionSettingRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class OSkillExtensionSettingRepository$requestRemoteRead$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $reason;
    int label;

    public OSkillExtensionSettingRepository$requestRemoteRead$1(String r1, Continuation<? super OSkillExtensionSettingRepository$requestRemoteRead$1> r2) {
        this.$reason = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new OSkillExtensionSettingRepository$requestRemoteRead$1(this.$reason, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L24;
        ResultKt.throwOnFailure(r7);
        Ref.ObjectRef r8 = new Ref.ObjectRef();
        r8.element = this.$reason;
    L27:
        AtomicBoolean r2 = OSkillExtensionSettingRepository.f;     // Catch: Throwable -> L18
        r2.set(false);     // Catch: Throwable -> L18
        ReentrantLock r3 = OSkillExtensionSettingRepository.d;     // Catch: Throwable -> L18
        r3.lock();     // Catch: Throwable -> L18
        OSkillExtensionSettingRepository r4 = OSkillExtensionSettingRepository.a;     // Catch: Throwable -> L15
        String r5 = (String) r8.element;     // Catch: Throwable -> L15
        r4.getClass();     // Catch: Throwable -> L15
        OSkillExtensionSettingRepository.f(r5);     // Catch: Throwable -> L15
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L15
        r3.unlock();     // Catch: Throwable -> L18
        r8.element = "pending_force_refresh";     // Catch: Throwable -> L18
        if (r2.get() == true) goto L27;
        OSkillExtensionSettingRepository.e.set(false);
        if (r2.get() == false) goto L14;
        OSkillExtensionSettingRepository.d("pending_force_refresh", false);
    L14:
        return Unit.INSTANCE;
    L15:
        th = move-exception;
        r3.unlock();     // Catch: Throwable -> L18
        throw th;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        OSkillExtensionSettingRepository.e.set(false);
        if (OSkillExtensionSettingRepository.f.get() == false) goto L22;
        OSkillExtensionSettingRepository.a.getClass();
        OSkillExtensionSettingRepository.d("pending_force_refresh", false);
    L22:
        throw th;
    L24:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
