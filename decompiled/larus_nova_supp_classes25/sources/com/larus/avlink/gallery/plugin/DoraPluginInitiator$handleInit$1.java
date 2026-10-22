package com.larus.avlink.gallery.plugin;

import com.larus.avlink.gallery.gecko.MorphoGeckoFileHelper;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.mirabridge.api.pluginservice.IDoraPluginService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.gallery.plugin.DoraPluginInitiator$handleInit$1", f = "DoraPluginInitiator.kt", i = {}, l = {98, 102}, m = "invokeSuspend", n = {}, s = {})
final class DoraPluginInitiator$handleInit$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public DoraPluginInitiator$handleInit$1(Continuation<? super DoraPluginInitiator$handleInit$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new DoraPluginInitiator$handleInit$1(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r6);
    L17:
        if (((IDoraPluginService) r6) == null) goto L23;
        IDoraService r7 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r7 == null) goto L23;
        DeviceService r8 = r7.device();
        if (r8 == null) goto L23;
        r8.x0(a.e);
    L23:
        MorphoGeckoFileHelper.a.getClass();
        MorphoGeckoFileHelper.d();
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r6);
    L13:
        FLogger.a.i("DoraPluginInitiator", "DoraLink connected, try load plugin");
        this.label = 2;
        r6 = f.a(this);
        if (r6 != r0) goto L17;
        return r0;
    L10:
        ResultKt.throwOnFailure(r6);
        this.label = 1;
        if (DelayKt.delay(3000, this) != r0) goto L13;
        return r0;
    }
}
