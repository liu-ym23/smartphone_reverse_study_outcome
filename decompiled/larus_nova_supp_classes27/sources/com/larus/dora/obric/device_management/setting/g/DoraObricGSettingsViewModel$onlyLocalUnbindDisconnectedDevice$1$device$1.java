package com.larus.dora.obric.device_management.setting.g;

import com.bytedance.dora.device.DoraDevice;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/bytedance/dora/device/DoraDevice;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.obric.device_management.setting.g.DoraObricGSettingsViewModel$onlyLocalUnbindDisconnectedDevice$1$device$1", f = "DoraObricGSettingsViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DoraObricGSettingsViewModel$onlyLocalUnbindDisconnectedDevice$1$device$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super DoraDevice>, Object> {
    final /* synthetic */ String $targetMac;
    int label;

    public DoraObricGSettingsViewModel$onlyLocalUnbindDisconnectedDevice$1$device$1(String r1, Continuation<? super DoraObricGSettingsViewModel$onlyLocalUnbindDisconnectedDevice$1$device$1> r2) {
        this.$targetMac = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DoraObricGSettingsViewModel$onlyLocalUnbindDisconnectedDevice$1$device$1(this.$targetMac, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super DoraDevice> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L18;
        ResultKt.throwOnFailure(r5);
        List r6 = DoraAdapterExtKt.k(kj4.a.g());
        String r0 = this.$targetMac;
        Iterator r7 = r6.iterator();
    L6:
        if (r7.hasNext() == false) goto L15;
        Object r1 = r7.next();
        DoraDevice r2 = (DoraDevice) r1;
        if (Intrinsics.areEqual(r2.mac, r0) == true) goto L10;
    L12:
        boolean r3 = false;
    L13:
        if (r3 == false) goto L6;
        return r1;
    L10:
        if (o59.a.p(r2) == false) goto L12;
        r3 = true;
        goto L13
    L15:
        return null;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
