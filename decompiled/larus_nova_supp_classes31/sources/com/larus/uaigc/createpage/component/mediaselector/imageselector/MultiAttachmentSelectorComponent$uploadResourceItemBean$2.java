package com.larus.uaigc.createpage.component.mediaselector.imageselector;

import android.net.Uri;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.view.resourcebar.bean.ResourceItemBean;
import com.larus.bmhome.view.resourcebar.bean.ResourceType;
import com.larus.im.bean.message.Image;
import com.larus.uaigc.createpage.component.helper.AlbumHelperKt;
import com.larus.utils.logger.FLogger;
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
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.mediaselector.imageselector.MultiAttachmentSelectorComponent$uploadResourceItemBean$2", f = "MultiAttachmentSelectorComponent.kt", i = {}, l = {949}, m = "invokeSuspend", n = {}, s = {})
public final class MultiAttachmentSelectorComponent$uploadResourceItemBean$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ResourceItemBean $bean;
    int label;
    final /* synthetic */ MultiAttachmentSelectorComponent this$0;

    public MultiAttachmentSelectorComponent$uploadResourceItemBean$2(ResourceItemBean r1, MultiAttachmentSelectorComponent r2, Continuation<? super MultiAttachmentSelectorComponent$uploadResourceItemBean$2> r3) {
        this.$bean = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new MultiAttachmentSelectorComponent$uploadResourceItemBean$2(this.$bean, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r13);
    L57:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r13);
        Object r5 = null;
        if (this.$bean.getResourceType() != ResourceType.IMAGE) goto L23;
        final MultiAttachmentSelectorComponent r14 = this.this$0;
        final ResourceItemBean r2 = this.$bean;
        int r3 = MultiAttachmentSelectorComponent.Z;
        r14.getClass();
        Image r4 = r2.getImage();
        if (r4 == null) goto L57;
        String r6 = r4.localResPath;
        if (r6 == null) goto L57;
        PolarisFileWrapper r7 = new PolarisFileWrapper(r6);
        if (r7.exists() == false) goto L57;
        nz9.b.h("creation_page/album_upload", "creation_page", r2.getKey(), null, 24);
        com.larus.uaigc.helper.f.a.getClass();
        if (com.larus.uaigc.helper.f.a() == false) goto L21;
        r14.f5(r2.getKey(), r6, null);
        goto L57
    L21:
        com.larus.utils.t0.e(new o2(r14, r2));
        BuildersKt.async$default(LifecycleOwnerKt.getLifecycleScope(r14), Dispatchers.getIO(), null, new MultiAttachmentSelectorComponent$compressAndUploadImage$2(r2, r14, r7, null), 2, null);
        goto L57
    L23:
        if (this.$bean.getResourceType() != ResourceType.VIDEO) goto L57;
        com.larus.uaigc.helper.f.a.getClass();
        if (com.larus.uaigc.helper.f.a() == false) goto L29;
        MultiAttachmentSelectorComponent r15 = this.this$0;
        ResourceItemBean r8 = this.$bean;
        this.label = 1;
        if (MultiAttachmentSelectorComponent.p3(r15, r8, this) != r0) goto L57;
        return r0;
    L29:
        final MultiAttachmentSelectorComponent r16 = this.this$0;
        final ResourceItemBean r9 = this.$bean;
        int r10 = MultiAttachmentSelectorComponent.Z;
        r16.getClass();
        nz9.b.h("creation_page/album_upload/video", "creation_page", r9.getKey(), null, 24);
        com.larus.utils.t0.e(new e2(r16, r9));
        final String r11 = r9.getKey();
        Object r12 = r9.getExt().get("ext_video_local_uri");
        if ((r12 instanceof String) == false) goto L32;
        String r17 = (String) r12;
    L58:
        Result.Companion r18 = Result.Companion;     // Catch: Throwable -> L39
        if (r17 != null) goto L36;
        String r19 = "";
    L37:
        Object r20 = Result.constructor-impl(UriProtector.parse(r19));     // Catch: Throwable -> L39
    L42:
        if (Result.isFailure-impl(r20) == true) goto L45;
        r5 = r20;
    L45:
        Uri r21 = (Uri) r5;
        FLogger r22 = FLogger.a;
        StringBuilder r23 = new StringBuilder("[preCheckAndUploadVideo] hasUri=");
        if (r17 != null) goto L48;
    L51:
        boolean r24 = true;
    L52:
        r23.append(!r24);
        r22.i("MultiAttachmentSelector", r23.toString());
        if (r21 != null) goto L55;
        com.larus.utils.t0.e(new f2(r16, r11));
        r16.T4(false, "upload", "video");
        goto L57
    L55:
        r16.E.put(r11, AlbumHelperKt.g(LifecycleOwnerKt.getLifecycleScope(r16), Dispatchers.getIO(), new MultiAttachmentSelectorComponent$preCheckAndUploadVideo$3(r16, r21, r9, r11, null), 2));
        goto L57
    L48:
        if (StringsKt.isBlank(r17) == true) goto L51;
        r24 = false;
        goto L52
    L36:
        r19 = r17;
    L39:
        th = move-exception;
        Result.Companion r25 = Result.Companion;
        r20 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L42
    L32:
        r17 = null;
        goto L58
    }
}
