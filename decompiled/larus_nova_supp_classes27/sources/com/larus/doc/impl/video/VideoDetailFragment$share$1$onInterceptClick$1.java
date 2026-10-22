package com.larus.doc.impl.video;

import android.content.Context;
import com.larus.bmhome.share.api.IShareService;
import com.larus.bmhome.share.api.ShareServiceDelegate;
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
@DebugMetadata(c = "com.larus.doc.impl.video.VideoDetailFragment$share$1$onInterceptClick$1", f = "VideoDetailFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class VideoDetailFragment$share$1$onInterceptClick$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ jr9.a $shareItemConfig;
    int label;
    final /* synthetic */ VideoDetailFragment this$0;

    public VideoDetailFragment$share$1$onInterceptClick$1(Context r1, jr9.a r2, VideoDetailFragment r3, Continuation<? super VideoDetailFragment$share$1$onInterceptClick$1> r4) {
        this.$context = r1;
        this.$shareItemConfig = r2;
        this.this$0 = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new VideoDetailFragment$share$1$onInterceptClick$1(this.$context, this.$shareItemConfig, this.this$0, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r35) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r35);
        ShareServiceDelegate r2 = ShareServiceDelegate.b;
        Context r3 = this.$context;
        String r4 = this.$shareItemConfig.b();
        String r5 = this.$shareItemConfig.c();
        VideoDetailFragment r14 = this.this$0;
        IShareService.a.d(r2, r3, r4, r5, new com.larus.bmhome.share.panel.b(null, null, r14.i, null, null, null, null, r14.getResources().getString(2131900789), null, null, null, null, null, null, null, null, false, false, null, null, false, false, null, false, null, null, 67108731), null, 48);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
