package com.larus.dora.impl.device.settings.media;

import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.platform.api.x2;
import com.larus.platform.model.LocateScene;
import com.larus.platform.service.l1;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.device.settings.media.MediaSettingsFragment$handleMediaAlbumConfig$1$3$1", f = "MediaSettingsFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MediaSettingsFragment$handleMediaAlbumConfig$1$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public MediaSettingsFragment$handleMediaAlbumConfig$1$3$1(Continuation<? super MediaSettingsFragment$handleMediaAlbumConfig$1$3$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new MediaSettingsFragment$handleMediaAlbumConfig$1$3$1(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L17;
        ResultKt.throwOnFailure(r6);
        if (DoraAdapterExtKt.t(kj4.a.g()) == false) goto L13;
        int[] r7 = kj4.a.g().C();
        g49.d.d("MediaSettingsFragment", "budsWearState[0]=" + r7[0] + " ,budsWearState[1]= " + r7[1]);
        if (r7[0] != 1) goto L9;
    L12:
        g49.d.d("MediaSettingsFragment", "start locate DORA_G_WEAR");
        l1 r8 = l1.a;
        x2.a.a(LocateScene.DORA_G_WEAR);
    L15:
        return Unit.INSTANCE;
    L9:
        if (r7[1] == 1) goto L12;
        g49.d.d("MediaSettingsFragment", "start locate DORA_G_CONNECT");
        l1 r9 = l1.a;
        x2.a.a(LocateScene.DORA_G_CONNECT);
        goto L15
    L13:
        g49.d.d("MediaSettingsFragment", "dora not connected");
        goto L15
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
