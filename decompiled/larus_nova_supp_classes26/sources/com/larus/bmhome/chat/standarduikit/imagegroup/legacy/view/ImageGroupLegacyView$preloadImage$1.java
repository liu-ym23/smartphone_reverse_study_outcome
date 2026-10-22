package com.larus.bmhome.chat.standarduikit.imagegroup.legacy.view;

import com.larus.flowsdk.security.api.FlowFileProtectionService;
import com.larus.image.loader.ImageLoaderKt;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.standarduikit.imagegroup.legacy.view.ImageGroupLegacyView$preloadImage$1", f = "ImageGroupLegacyView.kt", i = {}, l = {496}, m = "invokeSuspend", n = {}, s = {})
final class ImageGroupLegacyView$preloadImage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $imageUrl;
    int label;

    public ImageGroupLegacyView$preloadImage$1(String r1, Continuation<? super ImageGroupLegacyView$preloadImage$1> r2) {
        this.$imageUrl = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ImageGroupLegacyView$preloadImage$1(this.$imageUrl, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L19:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        FlowFileProtectionService r11 = (FlowFileProtectionService) ServiceManager.get().getService(FlowFileProtectionService.class);
        if (r11 != null) goto L11;
    L13:
        boolean r12 = false;
    L14:
        if (r12 == true) goto L19;
        String r3 = this.$imageUrl;
        this.label = 1;
        if (ImageLoaderKt.C(r3, "markdown.image_group_cover_thumb", null, null, this, 60) != r0) goto L19;
        return r0;
    L11:
        if (r11.I0() != true) goto L13;
        r12 = true;
        goto L14
    }
}
