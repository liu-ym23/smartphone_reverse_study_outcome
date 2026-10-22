package com.larus.chat.gallery.impl.preview.toolbar.action;

import com.larus.uaigc.service.IUgcAIGCService;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.chat.gallery.impl.preview.toolbar.action.DownloadAction$downloadImageViaCreationRecord$3", f = "DownloadAction.kt", i = {}, l = {287}, m = "invokeSuspend", n = {}, s = {})
final class DownloadAction$downloadImageViaCreationRecord$3 extends SuspendLambda implements Function1<Continuation<? super String>, Object> {
    final /* synthetic */ String $downloadUrl;
    final /* synthetic */ String $imageUri;
    final /* synthetic */ String $subScene;
    int label;

    public DownloadAction$downloadImageViaCreationRecord$3(String r1, String r2, String r3, Continuation<? super DownloadAction$downloadImageViaCreationRecord$3> r4) {
        this.$downloadUrl = r1;
        this.$subScene = r2;
        this.$imageUri = r3;
        super(1, r4);
    }

    public final Continuation<Unit> create(Continuation<?> r5) {
        return new DownloadAction$downloadImageViaCreationRecord$3(this.$downloadUrl, this.$subScene, this.$imageUri, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super String> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L11:
        return r10;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        IUgcAIGCService.Companion r2 = IUgcAIGCService.a;
        String r11 = this.$downloadUrl;
        String r4 = this.$subScene;
        String r7 = this.$imageUri;
        this.label = 1;
        r10 = r2.D(r11, "Creation", r4, "image", true, r7, this);
        if (r10 != r0) goto L11;
        return r0;
    }
}
