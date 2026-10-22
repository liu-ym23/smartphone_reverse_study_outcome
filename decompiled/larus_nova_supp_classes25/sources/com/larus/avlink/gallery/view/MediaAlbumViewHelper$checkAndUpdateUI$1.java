package com.larus.avlink.gallery.view;

import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.gallery.view.MediaAlbumViewHelper$checkAndUpdateUI$1", f = "MediaAlbumViewHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MediaAlbumViewHelper$checkAndUpdateUI$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MediaAlbumViewHelper this$0;

    public MediaAlbumViewHelper$checkAndUpdateUI$1(MediaAlbumViewHelper r1, Continuation<? super MediaAlbumViewHelper$checkAndUpdateUI$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new MediaAlbumViewHelper$checkAndUpdateUI$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L30;
        ResultKt.throwOnFailure(r8);
        IDoraService r9 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        boolean r0 = false;
        if (r9 == null) goto L11;
        DeviceService r10 = r9.device();
        if (r10 == null) goto L11;
        if (r10.u() != 2) goto L11;
        boolean r11 = true;
    L12:
        if (r11 == false) goto L28;
        AlbumSyncBanner r12 = this.this$0.f;
        if (r12 != null) goto L16;
    L18:
        if (r0 == false) goto L26;
        AlbumSyncBanner r13 = this.this$0.f;
        if (r13 == null) goto L28;
        LifecycleOwner r1 = r13.c;
        if (r1 == null) goto L28;
        LifecycleCoroutineScope r2 = LifecycleOwnerKt.getLifecycleScope(r1);
        if (r2 == null) goto L28;
        BuildersKt.launch$default(r2, null, null, new AlbumSyncBanner$eraseError$1(r13, null), 3, null);
        goto L28
    L26:
        this.this$0.c();
        goto L28
    L16:
        if (r12.V5() != true) goto L18;
        r0 = true;
    L28:
        return Unit.INSTANCE;
    L11:
        r11 = false;
        goto L12
    L30:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
