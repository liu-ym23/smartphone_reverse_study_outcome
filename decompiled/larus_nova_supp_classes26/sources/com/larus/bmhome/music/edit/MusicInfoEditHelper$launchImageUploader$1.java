package com.larus.bmhome.music.edit;

import android.net.Uri;
import androidx.fragment.app.Fragment;
import com.larus.platform.model.upload.UploadDataType;
import com.larus.platform.spi.IAIChatUgcAIGCService;
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
@DebugMetadata(c = "com.larus.bmhome.music.edit.MusicInfoEditHelper$launchImageUploader$1", f = "MusicInfoEditHelper.kt", i = {}, l = {152}, m = "invokeSuspend", n = {}, s = {})
public final class MusicInfoEditHelper$launchImageUploader$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ a $callback;
    final /* synthetic */ Uri $imageFileUri;
    final /* synthetic */ Fragment $this_launchImageUploader;
    int label;

    public MusicInfoEditHelper$launchImageUploader$1(Uri r1, Fragment r2, a r3, Continuation<? super MusicInfoEditHelper$launchImageUploader$1> r4) {
        this.$imageFileUri = r1;
        this.$this_launchImageUploader = r2;
        this.$callback = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new MusicInfoEditHelper$launchImageUploader$1(this.$imageFileUri, this.$this_launchImageUploader, this.$callback, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r29) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r29);
    L15:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r29);
        IAIChatUgcAIGCService.Companion r3 = IAIChatUgcAIGCService.a;
        String r4 = this.$imageFileUri.getPath();
        if (r4 != null) goto L11;
        r4 = "";
    L11:
        String r26 = r4;
        UploadDataType r7 = UploadDataType.IMAGE;
        final Fragment r5 = this.$this_launchImageUploader;
        final a r11 = this.$callback;
        mr9.j r6 = new mr9.j(r26, "bot_chat", r7, new s(r5, r11), new t(), new u(r11), false, null, null, null, null, false, null, null, null, null, null, null, null, null, 2097088);
        this.label = 1;
        if (r3.I0(r6, this) != r1) goto L15;
        return r1;
    }
}
