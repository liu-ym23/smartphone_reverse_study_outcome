package com.larus.uaigc.createpage.component.mediaselector.imageselector;

import android.net.Uri;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.upload.ResourceUploader;
import com.larus.platform.api.creation.IBachDetectCenterAbility;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.mediaselector.imageselector.SpringMultiAttachmentSelectorComponent$handleAttachmentRemove$1", f = "SpringMultiAttachmentSelectorComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class SpringMultiAttachmentSelectorComponent$handleAttachmentRemove$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $localResPath;
    final /* synthetic */ String $resourceKey;
    int label;
    final /* synthetic */ SpringMultiAttachmentSelectorComponent this$0;

    public SpringMultiAttachmentSelectorComponent$handleAttachmentRemove$1(SpringMultiAttachmentSelectorComponent r1, String r2, String r3, Continuation<? super SpringMultiAttachmentSelectorComponent$handleAttachmentRemove$1> r4) {
        this.this$0 = r1;
        this.$resourceKey = r2;
        this.$localResPath = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new SpringMultiAttachmentSelectorComponent$handleAttachmentRemove$1(this.this$0, this.$resourceKey, this.$localResPath, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L36;
        ResultKt.throwOnFailure(r4);
        Job r5 = this.this$0.x.get(this.$resourceKey);
        boolean r0 = true;
        Uri r1 = null;
        if (r5 == null) goto L7;
        Job.DefaultImpls.cancel$default(r5, null, 1, null);
    L7:
        this.this$0.x.remove(this.$resourceKey);
        SpringMultiAttachmentSelectorComponent r6 = this.this$0;
        r6.q.remove(this.$resourceKey);
        this.this$0.m3(this.$resourceKey);
        String r7 = this.this$0.t.get(this.$resourceKey);
        if (r7 == null) goto L10;
        ResourceUploader.c(r7);
    L10:
        this.this$0.t.remove(this.$resourceKey);
        if (IBachDetectCenterAbility.a.b() == false) goto L34;
        String r8 = this.$localResPath;
        if (r8.length() > 0) goto L16;
        r0 = false;
    L16:
        if (r0 == true) goto L19;
        r8 = null;
    L19:
        if (r8 == null) goto L34;
        PolarisFileWrapper r2 = new PolarisFileWrapper(r8);
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L26
        if (r2.exists() == false) goto L24;
        r1 = Uri.fromFile(r2);     // Catch: Throwable -> L26
    L24:
        Object r10 = Result.constructor-impl(r1);     // Catch: Throwable -> L26
    L29:
        if (Result.isSuccess-impl(r10) == false) goto L34;
        Uri r11 = (Uri) r10;
        if (r11 == null) goto L34;
        IBachDetectCenterAbility.a.d(r11);
    L26:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
    L34:
        return Unit.INSTANCE;
    L36:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
