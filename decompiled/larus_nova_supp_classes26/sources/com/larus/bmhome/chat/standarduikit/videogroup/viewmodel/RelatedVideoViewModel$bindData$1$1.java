package com.larus.bmhome.chat.standarduikit.videogroup.viewmodel;

import com.larus.flowsdk.security.api.FlowFileProtectionService;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.utils.o0;
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
import zn8.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.standarduikit.videogroup.viewmodel.RelatedVideoViewModel$bindData$1$1", f = "RelatedVideoViewModel.kt", i = {}, l = {90}, m = "invokeSuspend", n = {}, s = {})
public final class RelatedVideoViewModel$bindData$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ q $firstVideoData;
    int label;

    public RelatedVideoViewModel$bindData$1$1(q r1, Continuation<? super RelatedVideoViewModel$bindData$1$1> r2) {
        this.$firstVideoData = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new RelatedVideoViewModel$bindData$1$1(this.$firstVideoData, r3);
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
    L27:
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
        if (r12 == true) goto L27;
        q r13 = this.$firstVideoData;
        if (o0.d(r13.m) == false) goto L20;
        String r14 = r13.m;
        if (r14 == null) goto L22;
    L23:
        this.label = 1;
        if (ImageLoaderKt.C(r14, "markdown.video_group_cover_thumb", null, null, this, 60) != r0) goto L27;
        return r0;
    L22:
        r14 = "";
        goto L23
    L20:
        r14 = r13.g;
        if (r14 != null) goto L23;
    L11:
        if (r11.I0() != true) goto L13;
        r12 = true;
        goto L14
    }
}
