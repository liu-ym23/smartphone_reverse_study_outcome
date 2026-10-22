package com.larus.shortcuts.impl.dynamic;

import android.content.pm.ShortcutManager;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.shortcuts.impl.dynamic.DynamicShortcutsManager$clearShortcuts$1", f = "DynamicShortcutsManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DynamicShortcutsManager$clearShortcuts$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public DynamicShortcutsManager$clearShortcuts$1(Continuation<? super DynamicShortcutsManager$clearShortcuts$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new DynamicShortcutsManager$clearShortcuts$1(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L14;
        ResultKt.throwOnFailure(r4);
        ShortcutManager r5 = (ShortcutManager) AppHost.a.getApplication().getApplicationContext().getSystemService("shortcut");     // Catch: Exception -> L9
        if (r5 == null) goto L12;
        r5.removeAllDynamicShortcuts();     // Catch: Exception -> L9
    L12:
        return Unit.INSTANCE;
    L9:
        e = move-exception;
        FLogger.a.e("DynamicShortcutsManager", "clear shortcut exception: " + e.getMessage());
        goto L12
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
