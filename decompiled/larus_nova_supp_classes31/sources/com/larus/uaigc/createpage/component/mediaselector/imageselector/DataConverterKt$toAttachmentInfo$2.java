package com.larus.uaigc.createpage.component.mediaselector.imageselector;

import android.app.Activity;
import android.net.Uri;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.actionbar.model.ImageUploadInfo;
import com.larus.bmhome.actionbar.model.MediaAttachment;
import com.larus.bmhome.view.AttachmentInfo;
import com.larus.uaigc.createpage.utils.BitmapHelperKt;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/bmhome/view/AttachmentInfo;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.mediaselector.imageselector.DataConverterKt$toAttachmentInfo$2", f = "DataConverter.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DataConverterKt$toAttachmentInfo$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super AttachmentInfo>, Object> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ boolean $createNewPath;
    final /* synthetic */ MediaAttachment $this_toAttachmentInfo;
    int label;

    public DataConverterKt$toAttachmentInfo$2(MediaAttachment r1, boolean r2, Activity r3, Continuation<? super DataConverterKt$toAttachmentInfo$2> r4) {
        this.$this_toAttachmentInfo = r1;
        this.$createNewPath = r2;
        this.$activity = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new DataConverterKt$toAttachmentInfo$2(this.$this_toAttachmentInfo, this.$createNewPath, this.$activity, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super AttachmentInfo> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r30) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L67;
        ResultKt.throwOnFailure(r30);
        MediaAttachment r0 = this.$this_toAttachmentInfo;
        boolean r2 = this.$createNewPath;
        Activity r3 = this.$activity;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L59
        if (r0.getImageUploadInfo() == null) goto L8;
    L11:
        String r6 = r0.getLocalFilePath();     // Catch: Throwable -> L59
        if (r6 != null) goto L15;
        r6 = "";
    L15:
        boolean r7 = true;
        if (r2 == true) goto L18;
    L23:
        String r14 = r6;
        String r4 = r0.getUri();     // Catch: Throwable -> L59
        if (r4 != null) goto L26;
        String r11 = "";
    L27:
        ImageUploadInfo r8 = r0.getImageUploadInfo();     // Catch: Throwable -> L59
        if (r8 == null) goto L32;
        Long r9 = r8.getHeight();     // Catch: Throwable -> L59
        if (r9 == null) goto L32;
        Integer r12 = Boxing.boxInt((int) r9.longValue());     // Catch: Throwable -> L59
    L33:
        ImageUploadInfo r10 = r0.getImageUploadInfo();     // Catch: Throwable -> L59
        if (r10 == null) goto L38;
        Long r13 = r10.getWidth();     // Catch: Throwable -> L59
        if (r13 == null) goto L38;
        Integer r15 = Boxing.boxInt((int) r13.longValue());     // Catch: Throwable -> L59
    L39:
        String r17 = r0.getResourceId();     // Catch: Throwable -> L59
        String r18 = r0.getIdentifier();     // Catch: Throwable -> L59
        String r16 = r0.getOriginUrl();     // Catch: Throwable -> L59
        if (r16 != null) goto L42;
        r16 = r0.getUrl();     // Catch: Throwable -> L59
    L42:
        String r21 = r16;
        String r19 = r0.getPreviewUrl();     // Catch: Throwable -> L59
        if (r19 != null) goto L55;
        r19 = r0.getUrl();     // Catch: Throwable -> L59
        if (r19 != null) goto L47;
    L54:
        String r22 = null;
    L56:
        AttachmentInfo r1 = new AttachmentInfo(true, r11, r12, r15, r14, null, "", r17, r18, null, null, r21, r22, null, null, r0.getLocalMessageId(), r0.getAiCreationImage(), 26112, null);     // Catch: Throwable -> L59
    L57:
        Object r20 = Result.constructor-impl(r1);     // Catch: Throwable -> L59
    L62:
        if (Result.isFailure-impl(r20) == false) goto L65;
        return null;
    L65:
        return r20;
    L47:
        if (Intrinsics.areEqual(r0.getAiCreationImage(), Boxing.boxBoolean(true)) == true) goto L49;
    L51:
        r7 = false;
    L52:
        if (r7 == false) goto L54;
    L49:
        if (Intrinsics.areEqual(r19, r0.getOriginUrl()) == true) goto L51;
    L55:
        r22 = r19;
    L38:
        r15 = null;
    L32:
        r12 = null;
        goto L33
    L26:
        r11 = r4;
        goto L27
    L18:
        if ((!StringsKt.isBlank(r6)) == false) goto L23;
        r6 = BitmapHelperKt.b();     // Catch: Throwable -> L59
        String r23 = r0.getLocalFilePath();     // Catch: Throwable -> L59
        if (r23 != null) goto L22;
        r23 = "";
    L22:
        BitmapHelperKt.c(r3, Uri.fromFile(new PolarisFileWrapper(r23)), Uri.fromFile(new PolarisFileWrapper(r6)));     // Catch: Throwable -> L59
        goto L23
    L8:
        if (com.larus.utils.o0.d(r0.getLocalFilePath()) == true) goto L11;
        r1 = null;
    L59:
        th = move-exception;
        Result.Companion r24 = Result.Companion;
        r20 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L62
    L67:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
