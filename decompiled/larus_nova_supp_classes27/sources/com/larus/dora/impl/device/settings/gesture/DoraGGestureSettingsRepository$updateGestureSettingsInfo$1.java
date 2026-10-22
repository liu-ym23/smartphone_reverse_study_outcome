package com.larus.dora.impl.device.settings.gesture;

import com.larus.dora.impl.sysinfo.DoraSystemInfoManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.device.settings.gesture.DoraGGestureSettingsRepository$updateGestureSettingsInfo$1", f = "DoraGGestureSettingsRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DoraGGestureSettingsRepository$updateGestureSettingsInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public DoraGGestureSettingsRepository$updateGestureSettingsInfo$1(Continuation<? super DoraGGestureSettingsRepository$updateGestureSettingsInfo$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new DoraGGestureSettingsRepository$updateGestureSettingsInfo$1(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L47;
        ResultKt.throwOnFailure(r10);
        ArrayList r11 = new ArrayList();     // Catch: Exception -> L42
        Iterator r2 = CollectionsKt.plus(DoraGGestureSettingsRepository.c, DoraGGestureSettingsRepository.d).iterator();     // Catch: Exception -> L42
    L8:
        if (r2.hasNext() == false) goto L14;
        DoraGGestureSettings r3 = (DoraGGestureSettings) r2.next();     // Catch: Exception -> L42
        r11.add(new Pair(a.b(r3), a.a(r3)));     // Catch: Exception -> L12
    L12:
        e = move-exception;
        g49.d.e("DoraGGestureSettingsRepository", "Failed to process gesture settings: " + r3 + ", exception: " + e);     // Catch: Exception -> L42
        goto L8
    L14:
        r11.add(new Pair("left_doubao_single_click", "end_response"));     // Catch: Exception -> L42
        r11.add(new Pair("right_doubao_single_click", "end_response"));     // Catch: Exception -> L42
        r11.add(new Pair("left_button_single_click", "take_photo"));     // Catch: Exception -> L42
        List<DoraGGestureSettings> r0 = DoraGGestureSettingsRepository.e;     // Catch: Exception -> L42
        boolean r4 = false;
        if ((r0 instanceof Collection) == true) goto L17;
    L19:
        Iterator<T> r1 = r0.iterator();     // Catch: Exception -> L42
    L21:
        if (r1.hasNext() == false) goto L30;
        DoraGGestureSettings r5 = (DoraGGestureSettings) r1.next();     // Catch: Exception -> L42
        if (r5.b == 4) goto L25;
    L27:
        boolean r6 = false;
    L28:
        if (r6 == false) goto L21;
        r4 = true;
        goto L30
    L25:
        if (r5.c != 2) goto L27;
        r6 = true;
    L30:
        Iterator<T> r7 = DoraGGestureSettingsRepository.e.iterator();     // Catch: Exception -> L42
    L32:
        if (r7.hasNext() == false) goto L38;
        DoraGGestureSettings r8 = (DoraGGestureSettings) r7.next();     // Catch: Exception -> L42
        r11.add(new Pair(a.b(r8), a.a(r8)));     // Catch: Exception -> L36
    L36:
        e = move-exception;
        g49.d.e("DoraGGestureSettingsRepository", "Failed to process gesture settings: " + r8 + ", exception: " + e);     // Catch: Exception -> L42
        goto L32
    L38:
        if (r4 == true) goto L40;
        r11.add(new Pair("left_button_double_click", "none"));     // Catch: Exception -> L42
    L40:
        g49.d.d("DoraGGestureSettingsRepository", "uploadGestureSettingsToServer, Uploading gesture settings to server: " + r11);     // Catch: Exception -> L42
        DoraSystemInfoManager r9 = DoraSystemInfoManager.a;     // Catch: Exception -> L42
        Intrinsics.checkNotNullParameter(r11, "list");     // Catch: Exception -> L42
        DoraSystemInfoManager.t = r11;     // Catch: Exception -> L42
    L45:
        return Unit.INSTANCE;
    L17:
        if (r0.isEmpty() == false) goto L19;
    L42:
        e = move-exception;
        g49.d.e("DoraGGestureSettingsRepository", "uploadGestureSettingsToServer, exception:" + e);
        goto L45
    L47:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
