package com.larus.bmhome.music.protocol;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.larus.bmhome.music.save_video.MusicVideoSaver;
import com.larus.bmhome.share.api.IShareService;
import com.larus.bmhome.share.api.IShareService$a;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.ImageObj;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.MusicCreationContent;
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
import kotlinx.coroutines.CoroutineScope;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.music.protocol.MusicShareApi$ShareCallback$onInterceptClick$1$4", f = "MusicShareApi.kt", i = {}, l = {231}, m = "invokeSuspend", n = {}, s = {})
public final class MusicShareApi$ShareCallback$onInterceptClick$1$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ jr9.a $shareItemConfig;
    Object L$0;
    int label;
    final /* synthetic */ MusicShareApi.ShareCallback this$0;

    public MusicShareApi$ShareCallback$onInterceptClick$1$4(MusicShareApi.ShareCallback r1, Context r2, jr9.a r3, Continuation<? super MusicShareApi$ShareCallback$onInterceptClick$1$4> r4) {
        this.this$0 = r1;
        this.$context = r2;
        this.$shareItemConfig = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new MusicShareApi$ShareCallback$onInterceptClick$1$4(this.this$0, this.$context, this.$shareItemConfig, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r41) {
        Object r8 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L8;
        if (r0 != 1) goto L7;
        MusicShareApi.ShareCallback r1 = (MusicShareApi.ShareCallback) this.L$0;
        ResultKt.throwOnFailure(r41);
        MusicShareApi.ShareCallback r9 = r1;
        Object r2 = r41;
    L13:
        r9.i = (String) r2;
    L15:
        if (TextUtils.isEmpty(this.this$0.i) == false) goto L18;
        s r3 = s.a;
        Context r4 = this.$context;
        r3.getClass();
        s.s(r4, 2131909350);
        return Unit.INSTANCE;
    L18:
        FLogger.a.e("MusicShareApi", "DouYinEntryActivity share url " + MusicVideoSaver.g);
        IShareService r10 = (IShareService) ServiceManager.get().getService(IShareService.class);
        if (r10 == null) goto L33;
        Context r11 = this.$context;
        String r12 = this.$shareItemConfig.b();
        String r13 = this.$shareItemConfig.c();
        String r20 = this.this$0.e.getTitle();
        Image r5 = this.this$0.e.getCover();
        if (r5 == null) goto L26;
        ImageObj r6 = r5.imageThumb;
        if (r6 == null) goto L26;
        String r7 = r6.url;
        if (r7 == null) goto L26;
    L27:
        String r16 = r7;
        Context r14 = this.this$0.a.getContext();
        if (r14 == null) goto L30;
        String r15 = r14.getString(2131909361);
    L31:
        String r17 = MusicVideoSaver.g;
        IShareService$a.d(r10, r11, r12, r13, new com.larus.bmhome.share.panel.b(null, null, this.this$0.i, r16, r17, null, null, r20, r15, null, null, null, null, null, null, null, false, false, null, null, false, false, null, false, null, null, 67108451), null, 48);
        goto L33
    L30:
        r15 = null;
    L26:
        r7 = "";
    L33:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r41);
        if (TextUtils.isEmpty(this.this$0.i) == false) goto L15;
        r9 = this.this$0;
        MusicShareApi r18 = MusicShareApi.a;
        ViewGroup r19 = r9.a;
        String r21 = r9.f;
        Message r22 = r9.g;
        MusicCreationContent r23 = r9.e;
        this.L$0 = r9;
        this.label = 1;
        r2 = r18.b(r19, r21, r22, r23, true, this);
        if (r2 != r8) goto L13;
        return r8;
    }
}
