package com.obric.assistant.settings.autogui;

import android.content.Context;
import com.bytedance.keva.Keva;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.settings.IObricAutoBlacklistSettingsNotifier;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.settings.autogui.ObricAutoGuiSettingsImpl$cleanupKevaAgainstInstalledAppsIfNeeded$1", f = "ObricAutoGuiSettingsImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ObricAutoGuiSettingsImpl$cleanupKevaAgainstInstalledAppsIfNeeded$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ObricAutoGuiSettingsImpl this$0;

    public ObricAutoGuiSettingsImpl$cleanupKevaAgainstInstalledAppsIfNeeded$1(ObricAutoGuiSettingsImpl r1, Continuation<? super ObricAutoGuiSettingsImpl$cleanupKevaAgainstInstalledAppsIfNeeded$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        ObricAutoGuiSettingsImpl$cleanupKevaAgainstInstalledAppsIfNeeded$1 r0 = new ObricAutoGuiSettingsImpl$cleanupKevaAgainstInstalledAppsIfNeeded$1(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L56;
        ResultKt.throwOnFailure(r10);
        CoroutineScope r11 = (CoroutineScope) this.L$0;
        ObricAutoGuiSettingsImpl r12 = this.this$0;     // Catch: Exception -> L52
        Context r1 = AppHost.a.getApplication().getApplicationContext();     // Catch: Exception -> L52
        Set r2 = ObricAutoGuiSettingsImpl.i;     // Catch: Exception -> L52
        HashSet r13 = CollectionsKt.toHashSet(r12.p(r1));     // Catch: Exception -> L52
        if (r13.isEmpty() == false) goto L59;
        FLogger.a.i("ObricAutoGuiSettingsImpl", "cleanupKevaAgainstInstalledAppsIfNeeded: installed list is empty, skip");
        return Unit.INSTANCE;
    L59:
        Keva r3 = this.this$0.a;     // Catch: Exception -> L49
        if (r3 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("keva");     // Catch: Exception -> L49
        r3 = null;
    L14:
        Set r4 = r3.getAll().keySet();     // Catch: Exception -> L49
        ArrayList r5 = new ArrayList();     // Catch: Exception -> L49
        Iterator r6 = r4.iterator();     // Catch: Exception -> L49
    L15:
        if (r6.hasNext() == false) goto L27;
        Object r7 = r6.next();     // Catch: Exception -> L49
        String r8 = (String) r7;     // Catch: Exception -> L49
        if (ObricAutoGuiSettingsImpl.i.contains(r8) == false) goto L20;
    L22:
        boolean r9 = false;
    L23:
        if (r9 == false) goto L15;
        r5.add(r7);     // Catch: Exception -> L49
        goto L15
    L20:
        if (r13.contains(r8) == true) goto L22;
        r9 = true;
        goto L23
    L27:
        if (r5.isEmpty() == false) goto L30;
        FLogger.a.i("ObricAutoGuiSettingsImpl", "cleanupKevaAgainstInstalledAppsIfNeeded: no stale key");
        return Unit.INSTANCE;
    L30:
        FLogger.a.i("ObricAutoGuiSettingsImpl", "cleanupKevaAgainstInstalledAppsIfNeeded: erase " + r5.size() + " stale keys: " + r5);
        ObricAutoGuiSettingsImpl r14 = this.this$0;
        Iterator r15 = r5.iterator();
    L32:
        if (r15.hasNext() == false) goto L44;
        String r16 = (String) r15.next();
        Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L39
        Keva r18 = r14.a;     // Catch: Throwable -> L39
        if (r18 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("keva");     // Catch: Throwable -> L39
        r18 = null;
    L37:
        r18.erase(r16);     // Catch: Throwable -> L39
        Object r19 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L39
    L41:
        Throwable r20 = Result.exceptionOrNull-impl(r19);
        if (r20 == null) goto L32;
        FLogger.a.w("ObricAutoGuiSettingsImpl", "cleanupKevaAgainstInstalledAppsIfNeeded: erase " + r16 + " failed", r20);
    L39:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r19 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L41
    L44:
        IObricAutoBlacklistSettingsNotifier r110 = (IObricAutoBlacklistSettingsNotifier) ServiceManager.get().getService(IObricAutoBlacklistSettingsNotifier.class);
        if (r110 == null) goto L48;
        r110.a();
    L48:
        return Unit.INSTANCE;
    L49:
        e = move-exception;
        FLogger.a.w("ObricAutoGuiSettingsImpl", "cleanupKevaAgainstInstalledAppsIfNeeded: read keva failed", e);
        return Unit.INSTANCE;
    L52:
        e = move-exception;
        FLogger.a.w("ObricAutoGuiSettingsImpl", "cleanupKevaAgainstInstalledAppsIfNeeded: query installed failed", e);
        return Unit.INSTANCE;
    L56:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
