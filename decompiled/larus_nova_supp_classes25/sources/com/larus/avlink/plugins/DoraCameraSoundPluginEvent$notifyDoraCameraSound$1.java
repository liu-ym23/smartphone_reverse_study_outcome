package com.larus.avlink.plugins;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.dora.api.IDoraService;
import com.larus.dora.api.config.IDoraPageConfig;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.dora.impl.serviceimpl.VisionService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.plugins.DoraCameraSoundPluginEvent$notifyDoraCameraSound$1", f = "DoraCameraSoundPluginEvent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DoraCameraSoundPluginEvent$notifyDoraCameraSound$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DoraCameraSoundPluginEvent this$0;

    public DoraCameraSoundPluginEvent$notifyDoraCameraSound$1(DoraCameraSoundPluginEvent r1, Continuation<? super DoraCameraSoundPluginEvent$notifyDoraCameraSound$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DoraCameraSoundPluginEvent$notifyDoraCameraSound$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L30;
        ResultKt.throwOnFailure(r6);
        DoraCameraSoundPluginEvent r7 = this.this$0;
        r7.f = false;
        boolean r1 = true;
        r7.g = true;
        FLogger r8 = FLogger.a;
        r8.i("DoraCameraSoundPlugin", "notifyDoraCameraSound 3, canCameraSoundPlay: " + this.this$0.f);
        IDoraService r2 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r2 == null) goto L11;
        DeviceService r3 = r2.device();
        if (r3 == null) goto L11;
        if (r3.w() != 2) goto L11;
        boolean r4 = true;
    L12:
        if (r4 == true) goto L26;
        IDoraPageConfig r5 = (IDoraPageConfig) ServiceManager.get().getService(IDoraPageConfig.class);
        if (r5 != null) goto L16;
    L18:
        r1 = false;
    L19:
        if (r1 == false) goto L25;
        this.this$0.getClass();
        r8.i("DoraCameraSoundPlugin", "photo CameraSound ");
        IDoraService r9 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r9 == null) goto L28;
        VisionService r10 = r9.V();
        if (r10 == null) goto L28;
        Boxing.boxInt(r10.x(11, 0, 0));
    L28:
        return Unit.INSTANCE;
    L25:
        this.this$0.getClass();
        r8.i("DoraCameraSoundPlugin", "notifyDoraTakePicture, take picture skipped by unable...");
        goto L28
    L16:
        if (r5.b(false) != true) goto L18;
    L26:
        this.this$0.getClass();
        r8.i("DoraCameraSoundPlugin", "notifyDoraTakePicture, take picture skipped by HFP occupied..");
    L11:
        r4 = false;
        goto L12
    L30:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
