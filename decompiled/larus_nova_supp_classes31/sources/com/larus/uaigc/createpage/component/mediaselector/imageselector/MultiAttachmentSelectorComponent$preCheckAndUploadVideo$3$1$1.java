package com.larus.uaigc.createpage.component.mediaselector.imageselector;

import androidx.lifecycle.MutableLiveData;
import com.larus.bmhome.view.resourcebar.bean.ResourceItemBean;
import com.larus.im.bean.message.Image;
import com.larus.uaigc.bean.createpage.component.mediacontainer.UIStatus;
import com.larus.uaigc.createpage.component.helper.AlbumHelperKt;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.mediaselector.imageselector.MultiAttachmentSelectorComponent$preCheckAndUploadVideo$3$1$1", f = "MultiAttachmentSelectorComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MultiAttachmentSelectorComponent$preCheckAndUploadVideo$3$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ResourceItemBean $bean;
    final /* synthetic */ String $realLocalPath;
    final /* synthetic */ String $resourceKey;
    final /* synthetic */ mr9.e $videoMeta;
    int label;
    final /* synthetic */ MultiAttachmentSelectorComponent this$0;

    public MultiAttachmentSelectorComponent$preCheckAndUploadVideo$3$1$1(MultiAttachmentSelectorComponent r1, ResourceItemBean r2, mr9.e r3, String r4, String r5, Continuation<? super MultiAttachmentSelectorComponent$preCheckAndUploadVideo$3$1$1> r6) {
        this.this$0 = r1;
        this.$bean = r2;
        this.$videoMeta = r3;
        this.$realLocalPath = r4;
        this.$resourceKey = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new MultiAttachmentSelectorComponent$preCheckAndUploadVideo$3$1$1(this.this$0, this.$bean, this.$videoMeta, this.$realLocalPath, this.$resourceKey, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r20) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L26;
        ResultKt.throwOnFailure(r20);
        MutableLiveData<ry9.f> r1 = this.this$0.N;
        UIStatus r7 = UIStatus.STATUS_COMPRESS_SUCCESS;
        ResourceItemBean r2 = this.$bean;
        mt8.b r8 = r2.getVideo();
        if (r8 == null) goto L19;
        mr9.e r4 = this.$videoMeta;
        Image r9 = r4.a;
        Long r5 = r4.d();
        if (r5 == null) goto L9;
        long r6 = r5.longValue();
    L10:
        float r10 = r6 / 1000.0f;
        Integer r11 = this.$videoMeta.j();
        if (r11 == null) goto L13;
        int r12 = r11.intValue();
    L14:
        Integer r13 = this.$videoMeta.h();
        if (r13 == null) goto L17;
        int r14 = r13.intValue();
    L18:
        mt8.b r15 = mt8.b.a(r8, r9, r10, r12, r14, this.$realLocalPath, null, null, null, null, 480);
    L20:
        ResourceItemBean r16 = AlbumHelperKt.c(r2, null, r15, 1);
        MultiAttachmentSelectorComponent r3 = this.this$0;
        String r17 = this.$resourceKey;
        com.larus.uaigc.helper.f.a.getClass();
        if (Intrinsics.areEqual(com.larus.uaigc.helper.f.c().d(), Boxing.boxBoolean(true)) == false) goto L23;
        r16.getExt().put("ext_silent_upload", Boxing.boxBoolean(true));
    L23:
        r3.y.put(r17, r16);
        r1.setValue(new ry9.f(this.$resourceKey, 0, r16, r7, 2));
        return Unit.INSTANCE;
    L17:
        r14 = 0;
        goto L18
    L13:
        r12 = 0;
        goto L14
    L9:
        r6 = 0;
        goto L10
    L19:
        r15 = null;
        goto L20
    L26:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
