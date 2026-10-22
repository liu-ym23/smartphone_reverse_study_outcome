package com.larus.bmhome.taskskill.ui;

import android.content.Context;
import android.os.Bundle;
import com.larus.bmhome.taskskill.k2;
import com.larus.bmhome.taskskill.model.PcDevice;
import com.larus.bmhome.taskskill.network.PcDeviceRepository;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
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
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.json.JSONObject;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.taskskill.ui.PcDevicePanelFragment$loadDevices$1", f = "PcDevicePanelFragment.kt", i = {0, 1}, l = {210, 213}, m = "invokeSuspend", n = {"minLoadingJob", "result"}, s = {"L$0", "L$0"})
public final class PcDevicePanelFragment$loadDevices$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PcDevicePanelFragment this$0;

    public PcDevicePanelFragment$loadDevices$1(PcDevicePanelFragment r1, Continuation<? super PcDevicePanelFragment$loadDevices$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        PcDevicePanelFragment$loadDevices$1 r0 = new PcDevicePanelFragment$loadDevices$1(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
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
        int r2 = 0;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        Object r3 = this.L$0;
        ResultKt.throwOnFailure(r13);
    L39:
        Object r14 = r3;
    L40:
        PcDevicePanelFragment r4 = this.this$0;
        if (Result.isSuccess-impl(r14) == false) goto L57;
        List<PcDevice> r5 = (List) r14;
        r4.h = r5;
        r4.Y90(r5);
        if (r4.k == true) goto L57;
        r4.k = true;
        int r6 = k2.a;
        int r7 = !r5.isEmpty() ? 1 : 0;
        List<PcDevice> r8 = r5;
        if ((r8 instanceof Collection) == true) goto L48;
    L50:
        Iterator<T> r9 = r8.iterator();
    L52:
        if (r9.hasNext() == false) goto L56;
        if (Intrinsics.areEqual(((PcDevice) r9.next()).r(), Boolean.TRUE) == false) goto L52;
        r2 = 1;
    L56:
        Intrinsics.checkNotNullParameter("chat", "currentPage");
        com.larus.platform.service.o r10 = com.larus.platform.service.o.a;
        JSONObject r11 = new JSONObject();
        r11.put("current_page", "chat");
        r11.put("has_connected_pc", r7);
        r11.put("has_online_connected_pc", r2);
        Unit r12 = Unit.INSTANCE;
        r10.reportEvent("local_computer_connect_board_show", r11);
        goto L57
    L48:
        if (r8.isEmpty() == false) goto L50;
    L57:
        PcDevicePanelFragment r15 = this.this$0;
        if (Result.exceptionOrNull-impl(r14) == null) goto L60;
        s r16 = s.a;
        Context r17 = r15.getContext();
        r16.getClass();
        s.s(r17, 2131899435);
        r15.Y90(r15.h);
    L60:
        this.this$0.g = null;
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        Job r18 = (Job) this.L$0;
        ResultKt.throwOnFailure(r13);
    L33:
        r14 = ((Result) r13).unbox-impl();
        if (r18 == null) goto L40;
        this.L$0 = r14;
        this.label = 2;
        if (r18.join(this) != r0) goto L38;
        return r0;
    L38:
        r3 = r14;
        goto L39
    L10:
        ResultKt.throwOnFailure(r13);
        CoroutineScope r19 = (CoroutineScope) this.L$0;
        PcDeviceRepository r110 = PcDeviceRepository.a;
        List<PcDevice> r111 = PcDeviceRepository.b;
        if (r111 == null) goto L13;
        PcDevicePanelFragment r20 = this.this$0;
        r20.h = r111;
        r20.Y90(r111);
    L27:
        if (r111 != null) goto L29;
        r18 = BuildersKt.launch$default(r19, null, null, new PcDevicePanelFragment$loadDevices$1$minLoadingJob$1(null), 3, null);
    L30:
        CoroutineDispatcher r112 = Dispatchers.getIO();
        PcDevicePanelFragment$loadDevices$1$result$1 r21 = new PcDevicePanelFragment$loadDevices$1$result$1(null);
        this.L$0 = r18;
        this.label = 1;
        r13 = BuildersKt.withContext(r112, r21, this);
        if (r13 != r0) goto L33;
        return r0;
    L29:
        r18 = null;
        goto L30
    L13:
        PcDevicePanelFragment r22 = this.this$0;
        int r23 = PcDevicePanelFragment.o;
        r22.getClass();
        List<? extends i> r24 = CollectionsKt.mutableListOf(new i[]{i.d.a, i.a.a});
        Bundle r25 = r22.getArguments();
        if (r25 == null) goto L16;
        boolean r26 = r25.getBoolean("arg_show_cloud_computer", true);
    L17:
        if (r26 == false) goto L26;
        String r27 = r22.i;
        if (r27 != null) goto L21;
    L24:
        boolean r28 = true;
    L25:
        r24.add(new i.c(r28));
        goto L26
    L21:
        if (StringsKt.isBlank(r27) == true) goto L24;
        r28 = false;
    L26:
        r22.submitItems(r24);
        goto L27
    L16:
        r26 = true;
        goto L17
    }
}
