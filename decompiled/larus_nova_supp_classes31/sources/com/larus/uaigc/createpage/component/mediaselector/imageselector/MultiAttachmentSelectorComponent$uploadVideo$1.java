package com.larus.uaigc.createpage.component.mediaselector.imageselector;

import android.net.Uri;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.bmhome.rc.FlowResourceScene;
import com.larus.bmhome.rc.ResourceCenter;
import com.larus.bmhome.view.resourcebar.bean.ResourceItemBean;
import com.larus.im.bean.message.FileType;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.UplinkEntityContent;
import com.larus.im.bean.message.UplinkEntityType;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.im.bean.message.UplinkFileInfo;
import com.larus.im.bean.message.VideoExtension;
import com.larus.uaigc.service.ICreationResourceAccessService;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
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
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.mediaselector.imageselector.MultiAttachmentSelectorComponent$uploadVideo$1", f = "MultiAttachmentSelectorComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MultiAttachmentSelectorComponent$uploadVideo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $localResPath;
    final /* synthetic */ String $resourceKey;
    int label;
    final /* synthetic */ MultiAttachmentSelectorComponent this$0;

    public MultiAttachmentSelectorComponent$uploadVideo$1(String r1, MultiAttachmentSelectorComponent r2, String r3, Continuation<? super MultiAttachmentSelectorComponent$uploadVideo$1> r4) {
        this.$localResPath = r1;
        this.this$0 = r2;
        this.$resourceKey = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new MultiAttachmentSelectorComponent$uploadVideo$1(this.$localResPath, this.this$0, this.$resourceKey, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r53) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L45;
        ResultKt.throwOnFailure(r53);
        FLogger r0 = FLogger.a;
        StringBuilder r2 = new StringBuilder("[uploadVideo] start, hasLocalFile=");
        r2.append(!StringsKt.isBlank(this.$localResPath));
        r0.i("MultiAttachmentSelector", r2.toString());
        final MultiAttachmentSelectorComponent r1 = this.this$0;
        final String r3 = this.$resourceKey;
        com.larus.utils.t0.e(new v3(r1, r3));
        ResourceItemBean r4 = this.this$0.y.get(this.$resourceKey);
        if (r4 == null) goto L9;
        HashMap r5 = r4.getExt();
        if (r5 == null) goto L9;
        Object r6 = r5.get("ext_video_local_uri");
    L11:
        if ((r6 instanceof String) == false) goto L13;
        String r7 = (String) r6;
    L46:
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L19
        if (r7 != null) goto L17;
        r7 = "";
    L17:
        Object r9 = Result.constructor-impl(UriProtector.parse(r7));     // Catch: Throwable -> L19
    L22:
        if (Result.isFailure-impl(r9) == false) goto L24;
        r9 = null;
    L24:
        Uri r16 = (Uri) r9;
        ConcurrentHashMap<String, String> r10 = this.this$0.w;
        String r11 = this.$resourceKey;
        r10.put(r11, r11);
        tx9.l0.d(this.$resourceKey);
        ResourceCenter r12 = ResourceCenter.a;
        String r13 = this.$resourceKey;
        FlowResourceScene r14 = FlowResourceScene.CreationUserVideoV2;
        r12.getClass();
        ResourceCenter.k(r13, r14);
        int r15 = com.larus.uaigc.service.p0.x;
        String r23 = StringsKt.substringAfterLast$default(this.$localResPath, '.', null, 2, null);
        CountDownLatch r17 = new CountDownLatch(1);
        com.larus.bmhome.resource.access.d0 r30 = com.larus.uaigc.service.g.b;
        LifecycleCoroutineScope r31 = LifecycleOwnerKt.getLifecycleScope(this.this$0);
        boolean r18 = ResourceCenter.d(this.$resourceKey);
        int r19 = UplinkEntityType.EntityTypeFile.getValue();
        Integer r36 = Boxing.boxInt(FileType.FileTypeVideo.getValue());
        VideoExtension r20 = new VideoExtension(null, null, null, null, null, null, null, null, null, null, 1023, null);
        r20.setPath(this.$localResPath);
        if (r4 == null) goto L29;
        mt8.b r21 = r4.getVideo();
        if (r21 == null) goto L29;
        Image r22 = r21.a;
    L30:
        r20.setCover(r22);
        if (r4 == null) goto L35;
        mt8.b r24 = r4.getVideo();
        if (r24 == null) goto L35;
        Integer r25 = Boxing.boxInt(r24.c);
    L36:
        r20.setWidth(r25);
        if (r4 == null) goto L41;
        mt8.b r26 = r4.getVideo();
        if (r26 == null) goto L41;
        Integer r27 = Boxing.boxInt(r26.d);
    L42:
        r20.setHeight(r27);
        r20.setSource("upload");
        Unit r28 = Unit.INSTANCE;
        mr9.h r29 = new mr9.h(r18, null, new UplinkFileEntity(Boxing.boxInt(r19), new UplinkEntityContent(new UplinkFileInfo(null, null, null, r36, null, null, r20, null, null, null, 951, null), null, 2, null), this.$resourceKey, null, null, null, null, null, null, false, r16, null, null, null, 15352, null), 26);
        final String r32 = this.$localResPath;
        final String r33 = this.$resourceKey;
        final MultiAttachmentSelectorComponent r34 = this.this$0;
        ICreationResourceAccessService.a.b(com.larus.uaigc.service.p0.a.d(r32, r33, null, r29, true, r17, r23, null, new w3(r34, r33), new x3(r34, r33, r32), new y3(r34, r33, r32), null, null, r30, r31, 90888));
        return Unit.INSTANCE;
    L41:
        r27 = Boxing.boxInt(0);
    L35:
        r25 = Boxing.boxInt(0);
    L29:
        r22 = null;
    L19:
        th = move-exception;
        Result.Companion r35 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L22
    L13:
        r7 = null;
    L9:
        r6 = null;
        goto L11
    L45:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
