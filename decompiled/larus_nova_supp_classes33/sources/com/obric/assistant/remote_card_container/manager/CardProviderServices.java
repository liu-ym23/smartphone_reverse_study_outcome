package com.obric.assistant.remote_card_container.manager;

import android.app.Application;
import android.content.Context;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.common.apphost.AppHost;
import com.obric.aiagent.assistant_card.provider_core.ICardProviderService;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.w1;
import p9a.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class CardProviderServices {
    public static final CardProviderServices a = null;
    public static final Map<String, Pair<ICardProviderService, a>> b = null;
    public static final Map<String, Job> c = null;
    public static final CoroutineScope d = null;
    public static Deferred<? extends ICardProviderService> e;

    public static abstract class a implements ServiceConnection {
        public final AtomicBoolean a;

        public a() {
            this.a = new AtomicBoolean(false);
        }
    }

    public CardProviderServices() {
    }

    static {
        a = new CardProviderServices();
        b = new LinkedHashMap();
        c = new LinkedHashMap();
        d = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(w1.a(1, "CardProviderServices")));
    }

    public static final void a(String r8) {
        p9a.e r1 = p9a.b.a;
        p9a.b.a("CardProviderServices", "cancel connection " + r8);
        Pair<ICardProviderService, a> r2 = b.remove(r8);
        if (r2 == null) goto L31;
        ICardProviderService r3 = (ICardProviderService) r2.component1();
        a r4 = (a) r2.component2();
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L7
        Bundle r6 = new Bundle();     // Catch: Throwable -> L7
        r6.putBinder("host_api", null);     // Catch: Throwable -> L7
        r3.setHostApi(r6);     // Catch: Throwable -> L7
        Object r7 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L9:
        Throwable r9 = Result.exceptionOrNull-impl(r7);
        if (r9 == null) goto L13;
        p9a.e r10 = p9a.b.a;
        p9a.b.c("CardProviderServices", "clear host api failed: " + r8 + ", " + r9.getMessage(), r9);
    L13:
        if (Result.isSuccess-impl(r7) == false) goto L27;
        Unit r11 = (Unit) r7;
        p9a.e r12 = p9a.b.a;
        p9a.b.a("CardProviderServices", "clear host api succeed " + r8);
    L27:
        p9a.e r13 = p9a.b.a;     // Catch: Throwable -> L17
        p9a.b.a("CardProviderServices", "unbindService " + r8);     // Catch: Throwable -> L17
        AppHost.a.getApplication().unbindService(r4);     // Catch: Throwable -> L17
        Object r0 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L17
    L19:
        Throwable r14 = Result.exceptionOrNull-impl(r0);
        if (r14 == null) goto L23;
        p9a.e r15 = p9a.b.a;
        p9a.b.c("CardProviderServices", "unbindService failed: " + r8 + ", " + r14.getMessage(), r14);
    L23:
        if (Result.isSuccess-impl(r0) == false) goto L25;
        Unit r16 = (Unit) r0;
        p9a.e r17 = p9a.b.a;
        p9a.b.a("CardProviderServices", "unbindService success: " + r8);
    L25:
        Result.box-impl(r0);
        return;
    L17:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r0 = Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L9
    }

    public static void d(String r10) {
        Map<String, Job> r0 = c;
        if (r0 == null) goto L7;
        Job r2 = r0.remove(r10);
        if (r2 == null) goto L7;
        Job.DefaultImpls.cancel$default(r2, null, 1, null);
    L7:
        p9a.e r3 = p9a.b.a;
        p9a.b.a("CardProviderServices", "keep bind with " + r10 + " for 60000 ms");
        r0.put(r10, BuildersKt.launch$default(d, null, null, new CardProviderServices$setTimeoutJob$1(r10, null), 3, null));
    }

    public final Object c(Context r16, String r17, Continuation<? super ICardProviderService> r18) {
        if ((r18 instanceof CardProviderServices$getCardProviderService$1) == false) goto L7;
        CardProviderServices$getCardProviderService$1 r1 = (CardProviderServices$getCardProviderService$1) r18;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        Object r0 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r1.label;
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L13;
        String r5 = (String) r1.L$0;
        ResultKt.throwOnFailure(r0);
    L26:
        ICardProviderService r6 = (ICardProviderService) r0;
        d(r5);
        return r0;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r0);
        p9a.e r7 = p9a.b.a;
        p9a.b.a("CardProviderServices", "getCardProviderService " + r17);
        Uri r8 = UriProtector.parse(r17);
        String r9 = f.b(r8);
        if (r9.length() != 0) goto L17;
        boolean r10 = true;
    L19:
        if (r10 == false) goto L22;
        p9a.b.b("CardProviderServices", "providerPkgName is null or empty");
        return null;
    L22:
        Deferred r11 = BuildersKt.async$default(d, null, null, new CardProviderServices$getCardProviderService$2(r9, r16, r8, null), 3, null);
        r1.L$0 = r9;
        r1.label = 1;
        r0 = r11.await(r1);
        if (r0 != r3) goto L25;
        return r3;
    L25:
        r5 = r9;
        goto L26
    L17:
        r10 = false;
    L7:
        r1 = new CardProviderServices$getCardProviderService$1(this, r18);
        goto L8
    }

    public static final Object b(CardProviderServices r17, Context r18, Uri r19, Continuation r20) {
        r17.getClass();
        if ((r20 instanceof CardProviderServices$createConnection$1) == false) goto L7;
        CardProviderServices$createConnection$1 r1 = (CardProviderServices$createConnection$1) r20;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        Object r0 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r1.label;
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L13;
        Deferred<? extends ICardProviderService> r5 = (Deferred) r1.L$0;
        ResultKt.throwOnFailure(r0);
    L18:
        ICardProviderService r6 = (ICardProviderService) r0;
        if (Intrinsics.areEqual(r5, e) == false) goto L21;
        p9a.b.a("CardProviderServices", "last job done, set lastJob to null");
        e = null;
    L21:
        p9a.e r7 = p9a.b.a;
        p9a.b.a("CardProviderServices", "createConnection wait connect done. result = " + r6);
        return r0;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r0);
        p9a.e r8 = p9a.b.a;
        p9a.b.a("CardProviderServices", "createConnection " + r19);
        Context r9 = r18.getApplicationContext();
        Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type android.app.Application");
        String r10 = f.b(r19);
        Deferred<? extends ICardProviderService> r11 = e;
        Deferred<? extends ICardProviderService> r12 = BuildersKt.async$default(d, null, CoroutineStart.LAZY, new CardProviderServices$createConnection$connectingJob$1(r11, r10, (Application) r9, r19, null), 1, null);
        e = r12;
        p9a.b.a("CardProviderServices", "createConnection wait connect");
        r1.L$0 = r12;
        r1.label = 1;
        Object r13 = r12.await(r1);
        if (r13 == r3) goto L23;
        r5 = r12;
        r0 = r13;
        goto L18
    L23:
        return r3;
    L7:
        r1 = new CardProviderServices$createConnection$1(r17, r20);
        goto L8
    }
}
