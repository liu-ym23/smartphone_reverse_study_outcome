package com.larus.avlink.e;

import com.larus.avlink.api.model.DoraEvent;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.VisionService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Lazy;
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
@DebugMetadata(c = "com.larus.avlink.e.DoraECameraDelegate$notifyDoraTakePicture$1", f = "DoraECameraDelegate.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DoraECameraDelegate$notifyDoraTakePicture$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $messageId;
    final /* synthetic */ int $mode;
    final /* synthetic */ int $quality;
    int label;

    public DoraECameraDelegate$notifyDoraTakePicture$1(int r1, int r2, String r3, Continuation<? super DoraECameraDelegate$notifyDoraTakePicture$1> r4) {
        this.$mode = r1;
        this.$quality = r2;
        this.$messageId = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new DoraECameraDelegate$notifyDoraTakePicture$1(this.$mode, this.$quality, this.$messageId, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r18) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L24;
        ResultKt.throwOnFailure(r18);
        FLogger r1 = FLogger.a;
        r1.i("DoraE_Camera", "notifyDoraTakePicture, mode: " + this.$mode + ", quality: " + this.$quality);
        Lazy r2 = ia8.m.a;
        DoraEvent r3 = DoraEvent.TriggerTakeImage;
        r3.setExtra("{\"mode\": " + this.$mode + ",\"quality\": " + this.$quality + '}');
        ia8.m.b(r3);
        long r4 = System.currentTimeMillis();
        l r5 = l.a;
        int r11 = this.$mode;
        String r14 = this.$messageId;
        r1.i("DoraE_Camera", "buildDoraPicModel, mode: " + r11 + ", messageId: " + r14 + ", localImageId: " + String.valueOf(r4));
        com.larus.avlink.model.a r6 = new com.larus.avlink.model.a(null, 0, 0, 0, r11, null, null, r14, -4097, 61);
        r6.c(DoraImageEvent.TAKE_PHOTO_CMD_SEND, true, System.currentTimeMillis());
        l.g = r6;
        IDoraService r7 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r7 == null) goto L9;
        VisionService r8 = r7.V();
        if (r8 == null) goto L9;
        int r9 = r8.m();
    L10:
        com.larus.avlink.e.mock.e r10 = com.larus.avlink.e.mock.e.a;
        int r12 = this.$mode;
        int r13 = r9 * 1000;
        r10.a();
        com.larus.avlink.e.mock.g r15 = com.larus.avlink.e.mock.e.b;
        if (r15 != null) goto L13;
    L16:
        IDoraService r16 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r16 == null) goto L22;
        VisionService r17 = r16.V();
        if (r17 == null) goto L22;
        Boxing.boxInt(r17.x(this.$mode, r13, this.$quality));
    L22:
        return Unit.INSTANCE;
    L13:
        if (r15.b.get() == false) goto L16;
        r15.c.set(r12);
        r1.i("CameraMockRecorder", "🎬 Recording mode set: mode=" + r12 + ", dataSetId=" + r15.d.get());
    L9:
        r9 = 5;
        goto L10
    L24:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
