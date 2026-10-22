package com.larus.dora.impl.nl;

import com.bytedance.dora.device.DoraDevice;
import com.larus.dora.impl.network.DoraNetworkApi;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.nl.DoraUserSettingsManager$syncUserSettingV2$1", f = "DoraUserSettingsManager.kt", i = {}, l = {411}, m = "invokeSuspend", n = {}, s = {})
final class DoraUserSettingsManager$syncUserSettingV2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DoraDevice $device;
    final /* synthetic */ List<String> $filteredKeys;
    final /* synthetic */ List<String> $keys;
    final /* synthetic */ String $where;
    int label;

    public DoraUserSettingsManager$syncUserSettingV2$1(DoraDevice r1, List<String> r2, List<String> r3, String r4, Continuation<? super DoraUserSettingsManager$syncUserSettingV2$1> r5) {
        this.$device = r1;
        this.$filteredKeys = r2;
        this.$keys = r3;
        this.$where = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new DoraUserSettingsManager$syncUserSettingV2$1(this.$device, this.$filteredKeys, this.$keys, this.$where, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r13);
        Object r14 = ((Result) r13).unbox-impl();
    L11:
        List<String> r2 = this.$keys;
        String r3 = this.$where;
        if (Result.isSuccess-impl(r14) == false) goto L23;
        com.larus.dora.impl.network.d r4 = (com.larus.dora.impl.network.d) r14;
        Iterator<T> r5 = r2.iterator();
    L14:
        Object r6 = null;
        if (r5.hasNext() == false) goto L22;
        String r7 = (String) r5.next();
        Map<String, Object> r8 = r4.a();
        if (r8 == null) goto L19;
        r6 = r8.get(r7);
    L19:
        if (r6 != null) goto L20;
        g49.d.b("DoraUserSettingsManager", "syncUserSettingV2 failed, key=" + r7 + ", value=null, where=" + r3);
        goto L14
    L20:
        g49.d.d("DoraUserSettingsManager", "syncUserSettingV2 success, key=" + r7 + ", value=" + r6 + ", where=" + r3);
        com.larus.dora.impl.util.b0.a.getClass();
        com.larus.dora.impl.util.b0.O(r7, r6);
        goto L14
    L22:
        DoraUserSettingsManager r9 = DoraUserSettingsManager.a;
        BuildersKt.launch$default(DoraUserSettingsManager.b, null, null, new DoraUserSettingsManager.applyUserSettingsV2.1(null), 3, null);
    L23:
        String r10 = this.$where;
        Throwable r15 = Result.exceptionOrNull-impl(r14);
        if (r15 == null) goto L27;
        g49.d.c("DoraUserSettingsManager", "syncUserSettingV2 failed, where=" + r10, r15);
    L27:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r13);
        DoraNetworkApi r16 = DoraNetworkApi.a;
        DoraDevice r11 = this.$device;
        List<String> r12 = CollectionsKt.toList(this.$filteredKeys);
        this.label = 1;
        r14 = r16.l(r11, r12, this);
        if (r14 != r0) goto L11;
        return r0;
    }
}
