package com.larus.dora.impl.onboarding;

import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.DoraServiceImpl;
import com.larus.dora.impl.network.DoraNetworkApi;
import com.larus.im.bean.bot.BotModel;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.sync.MutexImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class OnboardingAvatarProvider {
    public static final OnboardingAvatarProvider a = null;
    public static final MutexImpl b = null;
    public static String c;
    public static CompletableDeferred<String> d;

    public OnboardingAvatarProvider() {
    }

    static {
        a = new OnboardingAvatarProvider();
        b = kotlinx.coroutines.sync.b.a();
    }

    public final Object a(Continuation<? super String> r11) {
        if ((r11 instanceof OnboardingAvatarProvider$getAvatarUrl$1) == false) goto L7;
        OnboardingAvatarProvider$getAvatarUrl$1 r0 = (OnboardingAvatarProvider$getAvatarUrl$1) r11;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r12 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        boolean r4 = false;
        if (r3 == 0) goto L20;
        if (r3 == 1) goto L19;
        if (r3 == 2) goto L18;
        if (r3 == 3) goto L17;
        if (r3 != 4) goto L16;
        kotlinx.coroutines.sync.a r5 = (kotlinx.coroutines.sync.a) r0.L$2;
        String r6 = (String) r0.L$1;
        CompletableDeferred<String> r7 = (CompletableDeferred) r0.L$0;
        ResultKt.throwOnFailure(r12);
    L57:
        if (r6 != null) goto L77;
    L63:
        r4 = true;
    L64:
        if (r4 == true) goto L67;
        c = r6;     // Catch: Throwable -> L61
    L67:
        if (d != r7) goto L69;
        d = null;     // Catch: Throwable -> L61
    L69:
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L61
        r5.unlock(null);
        r7.complete(r6);
        return r6;
    L61:
        th = move-exception;
        r5.unlock(null);
        throw th;
    L77:
        if (r6.length() != 0) goto L64;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        CompletableDeferred<String> r8 = (CompletableDeferred) r0.L$0;
        ResultKt.throwOnFailure(r12);
    L53:
        String r14 = (String) r12;
        kotlinx.coroutines.sync.a r9 = b;
        r0.L$0 = r8;
        r0.L$1 = r14;
        r0.L$2 = r9;
        r0.label = 4;
        if (r9.a(null, r0) != r2) goto L56;
        return r2;
    L56:
        r7 = r8;
        r5 = r9;
        r6 = r14;
        goto L57
    L18:
        ResultKt.throwOnFailure(r12);
    L49:
        return r12;
    L19:
        kotlinx.coroutines.sync.a r10 = (kotlinx.coroutines.sync.a) r0.L$0;
        ResultKt.throwOnFailure(r12);
    L79:
        String r15 = c;     // Catch: Throwable -> L74
        if (r15 != null) goto L29;
    L32:
        boolean r16 = true;
    L33:
        if (r16 == true) goto L35;
        CompletableDeferred r17 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);     // Catch: Throwable -> L74
        r17.complete(r15);     // Catch: Throwable -> L74
        Pair r18 = TuplesKt.to(r17, Boxing.boxBoolean(false));     // Catch: Throwable -> L74
    L44:
        r10.unlock(null);
        r8 = (CompletableDeferred) r18.component1();
        if (((Boolean) r18.component2()).booleanValue() == true) goto L50;
        r0.L$0 = null;
        r0.label = 2;
        r12 = r8.await(r0);
        if (r12 != r2) goto L49;
        return r2;
    L50:
        r0.L$0 = r8;
        r0.label = 3;
        r12 = b(r0);
        if (r12 != r2) goto L53;
        return r2;
    L35:
        CompletableDeferred<String> r110 = d;     // Catch: Throwable -> L74
        if (r110 != null) goto L38;
    L40:
        r110 = null;
    L41:
        if (r110 == null) goto L43;
        r18 = TuplesKt.to(r110, Boxing.boxBoolean(false));     // Catch: Throwable -> L74
        goto L44
    L43:
        CompletableDeferred<String> r111 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);     // Catch: Throwable -> L74
        d = r111;     // Catch: Throwable -> L74
        r18 = TuplesKt.to(r111, Boxing.boxBoolean(true));     // Catch: Throwable -> L74
        goto L44
    L38:
        if (r110.isActive() == false) goto L40;
    L29:
        if (r15.length() == 0) goto L32;
        r16 = false;
    L74:
        th = move-exception;
        r10.unlock(null);
        throw th;
    L20:
        ResultKt.throwOnFailure(r12);
        String r112 = c;
        if (r112 == null) goto L23;
        return r112;
    L23:
        r10 = b;
        r0.L$0 = r10;
        r0.label = 1;
        if (r10.a(null, r0) != r2) goto L79;
        return r2;
    L7:
        r0 = new OnboardingAvatarProvider$getAvatarUrl$1(this, r11);
        goto L8
    }

    public final Object b(Continuation<? super String> r12) {
        if ((r12 instanceof OnboardingAvatarProvider$requestAvatarUrl$1) == false) goto L7;
        OnboardingAvatarProvider$requestAvatarUrl$1 r0 = (OnboardingAvatarProvider$requestAvatarUrl$1) r12;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r13 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        Ref.ObjectRef r4 = (Ref.ObjectRef) r0.L$0;
        ResultKt.throwOnFailure(r13);
        Object r14 = ((Result) r13).unbox-impl();
    L19:
        if (Result.isSuccess-impl(r14) == false) goto L63;
        com.larus.dora.impl.network.e0 r5 = (com.larus.dora.impl.network.e0) r14;
        StringBuilder r6 = new StringBuilder("userLaunch success: ");
        List<com.larus.dora.impl.network.c> r7 = r5.a();
        String r8 = null;
        if (r7 == null) goto L23;
        Integer r9 = Boxing.boxInt(r7.size());
    L24:
        r6.append(r9);
        g49.d.d("OnboardingAvatarProvider", r6.toString());
        Object r10 = ServiceManager.get().getService(IDoraService.class);
        if ((r10 instanceof DoraServiceImpl) == false) goto L27;
        DoraServiceImpl r11 = (DoraServiceImpl) r10;
    L28:
        if (r11 == null) goto L30;
        BotModel r15 = r11.F;
    L31:
        if (r15 == null) goto L37;
        String r16 = r15.getBotIconMappedAppIcon();
        if (r16 == null) goto L37;
        Integer r17 = StringsKt.toIntOrNull(r16);
        if (r17 == null) goto L37;
        int r18 = r17.intValue();
    L38:
        List<com.larus.dora.impl.network.c> r20 = r5.a();
        if (r20 == null) goto L56;
        Iterator<T> r21 = r20.iterator();
    L42:
        if (r21.hasNext() == false) goto L53;
        Object r22 = r21.next();
        com.larus.dora.impl.network.c r23 = (com.larus.dora.impl.network.c) r22;
        boolean r24 = false;
        if (r23 == null) goto L51;
        Integer r25 = r23.a();
        if (r25 == null) goto L51;
        if (r25.intValue() != r18) goto L51;
        r24 = true;
    L51:
        if (r24 == false) goto L42;
    L54:
        com.larus.dora.impl.network.c r26 = (com.larus.dora.impl.network.c) r22;
        if (r26 == null) goto L56;
    L60:
        if (r26 == null) goto L62;
        r8 = r26.b();
    L62:
        r4.element = r8;
        goto L63
    L53:
        r22 = null;
    L56:
        List<com.larus.dora.impl.network.c> r27 = r5.a();
        if (r27 == null) goto L59;
        r26 = (com.larus.dora.impl.network.c) CollectionsKt.firstOrNull(r27);
        goto L60
    L59:
        r26 = null;
    L37:
        r18 = 1;
        goto L38
    L30:
        r15 = null;
        goto L31
    L27:
        r11 = null;
        goto L28
    L23:
        r9 = null;
    L63:
        Throwable r110 = Result.exceptionOrNull-impl(r14);
        if (r110 == null) goto L67;
        g49.d.c("OnboardingAvatarProvider", "userLaunch failure", r110);
    L67:
        return r4.element;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r13);
        Ref.ObjectRef r111 = new Ref.ObjectRef();
        DoraNetworkApi r28 = DoraNetworkApi.a;
        r0.L$0 = r111;
        r0.label = 1;
        Object r30 = r28.M(r0);
        if (r30 != r2) goto L17;
        return r2;
    L17:
        r4 = r111;
        r14 = r30;
    L7:
        r0 = new OnboardingAvatarProvider$requestAvatarUrl$1(this, r12);
        goto L8
    }
}
