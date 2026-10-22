package com.larus.bmhome.video.save_share;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.larus.bmhome.share.ShareScene;
import com.larus.bmhome.share.api.IShareService;
import com.larus.bmhome.share.api.IShareService$a;
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
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.video.save_share.VideoGenerateShareHelper$shareVideo$1$6", f = "VideoGenerateShareHelper.kt", i = {}, l = {327}, m = "invokeSuspend", n = {}, s = {})
public final class VideoGenerateShareHelper$shareVideo$1$6 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ String $creationId;
    final /* synthetic */ String $messageId;
    final /* synthetic */ View $shareContainer;
    final /* synthetic */ jr9.a $shareItemConfig;
    final /* synthetic */ ShareScene $shareScene;
    final /* synthetic */ Ref.ObjectRef<String> $url;
    final /* synthetic */ nr9.g $videoContent;
    Object L$0;
    int label;

    public VideoGenerateShareHelper$shareVideo$1$6(Ref.ObjectRef<String> r1, View r2, ShareScene r3, String r4, nr9.g r5, String r6, Context r7, jr9.a r8, Continuation<? super VideoGenerateShareHelper$shareVideo$1$6> r9) {
        this.$url = r1;
        this.$shareContainer = r2;
        this.$shareScene = r3;
        this.$messageId = r4;
        this.$videoContent = r5;
        this.$creationId = r6;
        this.$context = r7;
        this.$shareItemConfig = r8;
        super(2, r9);
    }

    public final Continuation<Unit> create(Object r11, Continuation<?> r12) {
        return new VideoGenerateShareHelper$shareVideo$1$6(this.$url, this.$shareContainer, this.$shareScene, this.$messageId, this.$videoContent, this.$creationId, this.$context, this.$shareItemConfig, r12);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r38) {
        Object r9 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L8;
        if (r0 != 1) goto L7;
        Ref.ObjectRef<String> r1 = (Ref.ObjectRef) this.L$0;
        ResultKt.throwOnFailure(r38);
        Ref.ObjectRef<String> r10 = r1;
        Object r2 = r38;
    L18:
        r10.element = r2;
    L20:
        if (TextUtils.isEmpty((CharSequence) this.$url.element) == false) goto L23;
        s r3 = s.a;
        Context r4 = this.$context;
        r3.getClass();
        s.s(r4, 2131909350);
        return Unit.INSTANCE;
    L23:
        FLogger r5 = FLogger.a;
        VideoGenerateSaver r6 = VideoGenerateSaver.a;
        r5.e("VideoGenerateShareHelper", "DouYinEntryActivity share url ");
        IShareService r7 = (IShareService) ServiceManager.get().getService(IShareService.class);
        if (r7 == null) goto L33;
        Context r8 = this.$context;
        String r11 = this.$shareItemConfig.b();
        String r12 = this.$shareItemConfig.c();
        VideoGenerateShareHelper r13 = VideoGenerateShareHelper.a;
        String r17 = VideoGenerateShareHelper.e(r13, this.$shareContainer.getContext());
        nr9.g r14 = this.$videoContent;
        if (r14 == null) goto L30;
        nr9.f r15 = r14.g;
        if (r15 == null) goto L30;
        String r16 = r15.b;
    L31:
        String r18 = r16;
        String r19 = VideoGenerateShareHelper.d(r13, this.$shareContainer.getContext());
        IShareService$a.d(r7, r8, r11, r12, new com.larus.bmhome.share.panel.b(null, null, (String) this.$url.element, r18, "", null, null, r17, r19, null, null, null, null, null, null, null, false, false, null, null, false, false, null, false, null, null, 67108451), null, 48);
    L30:
        r16 = null;
    L33:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r38);
        if (TextUtils.isEmpty((CharSequence) this.$url.element) == false) goto L20;
        r10 = this.$url;
        VideoGenerateShareHelper r20 = VideoGenerateShareHelper.a;
        View r21 = this.$shareContainer;
        ShareScene r22 = this.$shareScene;
        String r23 = this.$messageId;
        nr9.g r24 = this.$videoContent;
        if (r24 == null) goto L14;
        String r25 = r24.a;
        if (r25 == null) goto L14;
    L15:
        String r26 = this.$creationId;
        this.L$0 = r10;
        this.label = 1;
        r2 = r20.g(r21, r22, r23, r25, true, r26, this);
        if (r2 != r9) goto L18;
        return r9;
    L14:
        r25 = "";
        goto L15
    }
}
