package com.ss.android.lark.keyboard.biz.send.inject;

import com.bytedance.lark.pb.im.v1.PushUploadResourceStatus;
import com.bytedance.lark.pb.im.v1.UploadComplete;
import com.bytedance.lark.pb.im.v1.Uploading;
import com.ss.android.lark.biz.im.api.extension.keyboard.attachment.Image;
import com.ss.android.lark.biz.im.api.extension.keyboard.attachment.UpLinkState;
import com.ss.android.lark.biz.im.api.extension.keyboard.attachment.UplinkEntityContent;
import com.ss.android.lark.biz.im.api.extension.keyboard.attachment.UplinkFileEntity;
import com.ss.android.lark.biz.im.api.extension.keyboard.attachment.UplinkFileInfo;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.keyboard.viewmodel.KeyboardModel;
import com.ss.android.lark.log.Log;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.keyboard.biz.send.inject.SendInnerEndPlugin$initUploadPush$1", f = "SendInnerEndPlugin.kt", i = {}, l = {246}, m = "invokeSuspend", n = {}, s = {})
final class SendInnerEndPlugin$initUploadPush$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ SendInnerEndPlugin this$0;

    public SendInnerEndPlugin$initUploadPush$1(SendInnerEndPlugin r1, Continuation<? super SendInnerEndPlugin$initUploadPush$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new SendInnerEndPlugin$initUploadPush$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x004c -> B:13:0x0051). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        com.larksuite.rucket.job.extension.a r2 = (com.larksuite.rucket.job.extension.a) this.L$0;
        ResultKt.throwOnFailure(r14);
        com.larksuite.rucket.job.extension.a r3 = r2;
        Object r4 = r0;
        SendInnerEndPlugin$initUploadPush$1 r5 = this;
    L14:
        if (((Boolean) r14).booleanValue() == false) goto L59;
        com.larksuite.rucket.job.base.b r15 = r3.a();
        SendInnerEndPlugin r6 = r5.this$0;
        PushUploadResourceStatus r16 = (PushUploadResourceStatus) r15.b();
        SendInnerEndPlugin.a r7 = SendInnerEndPlugin.q;
        r6.getClass();
        String r8 = r16.upload_id;
        if (r8 != null) goto L18;
    L21:
        boolean r9 = true;
    L22:
        if (r9 == true) goto L57;
        wxa.a r10 = (wxa.a) r6.m.getValue();
        if (r10 == null) goto L57;
        List r11 = r10.q1();
        if (r11 == null) goto L57;
        Iterator r12 = r11.iterator();
    L30:
        if (r12.hasNext() == false) goto L34;
        Object r13 = r12.next();
        if (Intrinsics.areEqual(((UplinkFileEntity) r13).getFileIdentifier(), r8) == false) goto L30;
    L35:
        UplinkFileEntity r17 = (UplinkFileEntity) r13;
        if (r17 == null) goto L57;
        Uploading r18 = r16.uploading;
        if (r18 == null) goto L41;
        r17.setUpLinkStatus(Integer.valueOf(UpLinkState.PROCESSING.getValue()));
        r17.setUpLinkProcess(Integer.valueOf(r18.progress.intValue()));
        r6.h.remove(r8);
        r6.i.remove(r8);
    L41:
        UploadComplete r19 = r16.complete;
        if (r19 == null) goto L55;
        r17.setUpLinkStatus(Integer.valueOf(UpLinkState.SUCCESS.getValue()));
        r17.setUpLinkProcess(100);
        UplinkEntityContent r110 = r17.getUplinkEntityContent();
        if (r110 == null) goto L48;
        UplinkFileInfo r111 = r110.getUplinkFileInfo();
        if (r111 == null) goto L48;
        r111.setTosKey(r19.res_key);
    L48:
        UplinkEntityContent r112 = r17.getUplinkEntityContent();
        if (r112 == null) goto L53;
        Image r113 = r112.getUplinkImageInfo();
        if (r113 == null) goto L53;
        r113.key = r19.res_key;
    L53:
        r6.h.remove(r8);
        r6.i.add(r8);
        Log.i("SendInnerEndPlugin", "[UPLOAD_PUSH] complete id=" + r8 + " res_key=" + r19.res_key);
    L55:
        if (r16.failed == null) goto L57;
        r6.g.remove(r8);
        r6.h.add(r8);
        r6.i.remove(r8);
        r17.setUpLinkStatus(Integer.valueOf(UpLinkState.FAIL.getValue()));
        r17.setUpLinkProcess(0);
        Log.e("SendInnerEndPlugin", "[UPLOAD_PUSH] failed id=" + r8);
        goto L57
    L34:
        r13 = null;
    L57:
        SendInnerEndPlugin$initUploadPush$1 r114 = r5;
        r0 = r4;
        com.larksuite.rucket.job.extension.a r20 = r3;
    L9:
        r114.L$0 = r20;
        r114.label = 1;
        Object r21 = r20.hasNext(r114);
        if (r21 != r0) goto L12;
        return r0;
    L12:
        Object r115 = r0;
        r5 = r114;
        r14 = r21;
        r3 = r20;
        r4 = r115;
        goto L14
    L18:
        if (r8.length() == 0) goto L21;
        r9 = false;
        goto L22
    L59:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r14);
        SendInnerEndPlugin r116 = this.this$0;
        SendInnerEndPlugin.a r22 = SendInnerEndPlugin.q;
        KeyboardModel r117 = (KeyboardModel) r116.f.getValue();
        r20 = ((com.ss.android.lark.keyboard.viewmodel.a) b38.b.a.create(com.ss.android.lark.keyboard.viewmodel.a.class)).pushUploadResourceStatus().iterator();
        r114 = this;
        goto L9
    }
}
