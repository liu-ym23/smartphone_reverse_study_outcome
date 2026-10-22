package com.larus.bmhome.clarification;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.larus.bmhome.utils.c4;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.ImageObj;
import com.larus.im.bean.message.UplinkEntityContent;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.im.bean.message.UplinkFileInfo;
import com.larus.im.bean.message.VideoExtension;
import com.larus.platform.spi.IAIChatService;
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
@DebugMetadata(c = "com.larus.bmhome.clarification.ClarificationAttachmentPreviewer$openVideo$1", f = "ClarificationAttachmentPreviewer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ClarificationAttachmentPreviewer$openVideo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FragmentActivity $activity;
    final /* synthetic */ UplinkFileEntity $entity;
    final /* synthetic */ c4 $eventParam;
    int label;
    final /* synthetic */ t this$0;

    public ClarificationAttachmentPreviewer$openVideo$1(FragmentActivity r1, t r2, UplinkFileEntity r3, c4 r4, Continuation<? super ClarificationAttachmentPreviewer$openVideo$1> r5) {
        this.$activity = r1;
        this.this$0 = r2;
        this.$entity = r3;
        this.$eventParam = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new ClarificationAttachmentPreviewer$openVideo$1(this.$activity, this.this$0, this.$entity, this.$eventParam, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r25) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L60;
        ResultKt.throwOnFailure(r25);
        IAIChatService.Companion r1 = IAIChatService.a;
        FragmentManager r2 = this.$activity.getSupportFragmentManager();
        t r3 = this.this$0;
        UplinkFileEntity r4 = this.$entity;
        r3.getClass();
        UplinkEntityContent r5 = r4.getUplinkEntityContent();
        String r6 = null;
        if (r5 == null) goto L9;
        UplinkFileInfo r7 = r5.getUplinkFileInfo();
        if (r7 == null) goto L9;
        VideoExtension r8 = r7.getVideo();
    L10:
        if (r8 == null) goto L12;
        String r9 = r8.getVid();
    L13:
        if (r8 == null) goto L15;
        String r10 = r8.getDownloadUrl();
    L16:
        if (r8 == null) goto L18;
        String r11 = r8.getDownloadFilehash();
    L19:
        if (r8 == null) goto L23;
        Float r12 = r8.getDuration();
        if (r12 == null) goto L23;
        Double r13 = Double.valueOf(r12.floatValue());
    L24:
        if (r8 == null) goto L26;
        String r14 = r8.getFormat();
    L27:
        if (r8 == null) goto L29;
        String r15 = r8.getPath();
    L31:
        if (r8 == null) goto L37;
        Image r16 = r8.getCover();
        if (r16 == null) goto L37;
        ImageObj r17 = r16.imageOri;
        if (r17 == null) goto L37;
        String r18 = r17.url;
    L38:
        if (r8 == null) goto L42;
        Image r19 = r8.getCover();
        if (r19 == null) goto L42;
        r6 = r19.key;
    L42:
        String r110 = r6;
        int r20 = 0;
        if (r8 == null) goto L49;
        Image r21 = r8.getCover();
        if (r21 == null) goto L49;
        ImageObj r22 = r21.imageOri;
        if (r22 == null) goto L49;
        int r23 = r22.height;
    L50:
        Integer r24 = Integer.valueOf(r23);
        if (r8 == null) goto L57;
        Image r26 = r8.getCover();
        if (r26 == null) goto L57;
        ImageObj r27 = r26.imageOri;
        if (r27 == null) goto L57;
        r20 = r27.width;
    L57:
        r1.K7(r2, new nr9.g(r9, null, r10, r11, r13, r14, new nr9.f(null, r18, r110, r24, Integer.valueOf(r20), null, 33), r15, yc9.l1.g(r4), null, 514), this.$eventParam);
        return Unit.INSTANCE;
    L49:
        r23 = 0;
    L37:
        r18 = null;
        goto L38
    L29:
        r15 = null;
        goto L31
    L26:
        r14 = null;
    L23:
        r13 = null;
        goto L24
    L18:
        r11 = null;
        goto L19
    L15:
        r10 = null;
        goto L16
    L12:
        r9 = null;
    L9:
        r8 = null;
        goto L10
    L60:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
