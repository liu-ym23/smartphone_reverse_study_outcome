package com.larus.voicecall.impl.component.picture;

import com.larus.platform.service.z2;
import com.larus.platform.spi.IAIChatUploadMediaService;
import com.larus.voicecall.impl.util.v0;
import com.mammon.speechaudiosdk.session.type.SpeechEvent;
import ic8.m0;
import ic8.n0;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voicecall.impl.component.picture.RealtimePictureComponent", f = "RealtimePictureComponent.kt", i = {}, l = {SpeechEvent.SERVER_DOWNLINK_EVENT_CHAT_ENDED}, m = "processAlbumImage", n = {}, s = {})
final class RealtimePictureComponent$processAlbumImage$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RealtimePictureComponent this$0;

    public RealtimePictureComponent$processAlbumImage$1(RealtimePictureComponent r1, Continuation<? super RealtimePictureComponent$processAlbumImage$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r20) {
        this.result = r20;
        this.label |= Integer.MIN_VALUE;
        RealtimePictureComponent r1 = this.this$0;
        int r3 = RealtimePictureComponent.B;
        r1.getClass();
        int r4 = this.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r4 - Integer.MIN_VALUE;
        RealtimePictureComponent$processAlbumImage$1 r9 = this;
    L6:
        Object r2 = r9.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r9.label;
        if (r6 == 0) goto L12;
        if (r6 != 1) goto L11;
        ResultKt.throwOnFailure(r2);
    L15:
        m0 r7 = ((n0) r2).a;
        if (r7 == null) goto L18;
        x3a.a r8 = v0.b(r7, 1);
    L20:
        return r8;
    L18:
        r8 = null;
        goto L20
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r2);
        z2 r10 = z2.a;
        ns8.a r11 = new ns8.a(r10.getAppImageUploadConfig().b(), null, r10.getAppImageUploadConfig().c(), null, r10.d2(), 232);
        IAIChatUploadMediaService.Companion r12 = IAIChatUploadMediaService.a;
        r9.label = 1;
        r2 = IAIChatUploadMediaService.a.a(r12, null, r11, true, false, null, r9, 56);
        if (r2 != r5) goto L15;
        return r5;
    L5:
        r9 = new RealtimePictureComponent$processAlbumImage$1(r1, this);
        goto L6
    }
}
