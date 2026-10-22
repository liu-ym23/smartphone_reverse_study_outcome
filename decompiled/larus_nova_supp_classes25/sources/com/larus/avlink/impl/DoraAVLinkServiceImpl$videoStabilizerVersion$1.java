package com.larus.avlink.impl;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.mirabridge.api.pluginservice.IDoraPluginService;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.impl.DoraAVLinkServiceImpl$videoStabilizerVersion$1", f = "DoraAVLinkServiceImpl.kt", i = {}, l = {544}, m = "invokeSuspend", n = {}, s = {})
public final class DoraAVLinkServiceImpl$videoStabilizerVersion$1 extends SuspendLambda implements Function1<Continuation<? super String>, Object> {
    int label;

    public DoraAVLinkServiceImpl$videoStabilizerVersion$1(Continuation<? super DoraAVLinkServiceImpl$videoStabilizerVersion$1> r2) {
        super(1, r2);
    }

    public final Continuation<Unit> create(Continuation<?> r2) {
        return new DoraAVLinkServiceImpl$videoStabilizerVersion$1(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super String> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L11:
        IDoraPluginService r5 = (IDoraPluginService) r4;
        if (r5 == null) goto L15;
        String r6 = r5.videoStabilizerVersion();
        if (r6 == null) goto L15;
        return r6;
    L15:
        return "";
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        this.label = 1;
        r4 = com.larus.avlink.gallery.plugin.f.a(this);
        if (r4 != r0) goto L11;
        return r0;
    }
}
