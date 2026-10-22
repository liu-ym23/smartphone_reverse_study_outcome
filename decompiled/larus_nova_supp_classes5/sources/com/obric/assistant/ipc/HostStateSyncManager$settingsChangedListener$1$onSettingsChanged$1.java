package com.obric.assistant.ipc;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.ipc.HostStateSyncManager$settingsChangedListener$1$onSettingsChanged$1", f = "HostStateSyncManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class HostStateSyncManager$settingsChangedListener$1$onSettingsChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $key;
    int label;

    public HostStateSyncManager$settingsChangedListener$1$onSettingsChanged$1(String r1, Continuation<? super HostStateSyncManager$settingsChangedListener$1$onSettingsChanged$1> r2) {
        this.$key = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new HostStateSyncManager$settingsChangedListener$1$onSettingsChanged$1(this.$key, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L17;
        ResultKt.throwOnFailure(r5);
        HostStateSyncManager r6 = HostStateSyncManager.a;
        String r0 = this.$key;
        if (r0 != null) goto L7;
        r0 = "";
    L7:
        String r1 = "settings_changed:".concat(r0);
        r6.getClass();
        HostStateSyncManager.d(r1);
        String r7 = this.$key;
        if (r7 != null) goto L10;
    L13:
        WakeupTruthCaptureSwitchRefresher.a.getClass();
        WakeupTruthCaptureSwitchRefresher.a("settings_changed");
    L15:
        return Unit.INSTANCE;
    L10:
        if (Intrinsics.areEqual(r7, "obric_wakeup_audio_capture_config") == true) goto L13;
        if (StringsKt.contains$default(this.$key, "obric_wakeup_audio_capture_config", false, 2, null) == false) goto L15;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
