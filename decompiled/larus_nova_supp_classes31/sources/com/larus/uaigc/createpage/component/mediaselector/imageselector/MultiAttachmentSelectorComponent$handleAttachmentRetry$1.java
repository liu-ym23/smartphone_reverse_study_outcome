package com.larus.uaigc.createpage.component.mediaselector.imageselector;

import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.larus.bmhome.view.resourcebar.bean.ResourceItemBean;
import com.larus.bmhome.view.resourcebar.bean.ResourceType;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.ImageObj;
import com.larus.uaigc.createpage.component.helper.AlbumHelperKt;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.mediaselector.imageselector.MultiAttachmentSelectorComponent$handleAttachmentRetry$1", f = "MultiAttachmentSelectorComponent.kt", i = {}, l = {2832}, m = "invokeSuspend", n = {}, s = {})
public final class MultiAttachmentSelectorComponent$handleAttachmentRetry$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $localResPath;
    final /* synthetic */ String $resourceKey;
    int label;
    final /* synthetic */ MultiAttachmentSelectorComponent this$0;

    public MultiAttachmentSelectorComponent$handleAttachmentRetry$1(MultiAttachmentSelectorComponent r1, String r2, String r3, Continuation<? super MultiAttachmentSelectorComponent$handleAttachmentRetry$1> r4) {
        this.this$0 = r1;
        this.$resourceKey = r2;
        this.$localResPath = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new MultiAttachmentSelectorComponent$handleAttachmentRetry$1(this.this$0, this.$resourceKey, this.$localResPath, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r2 = true;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r14);
    L22:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r14);
        MultiAttachmentSelectorComponent r15 = this.this$0;
        String r3 = this.$resourceKey;
        int r4 = MultiAttachmentSelectorComponent.Z;
        r15.e4(r3).observe(s1a.a.c(this.this$0).getViewLifecycleOwner(), (Observer) this.this$0.Y.getValue());
        if (this.this$0.z5(this.$resourceKey) != ResourceType.VIDEO) goto L11;
        boolean r16 = true;
    L12:
        String r5 = null;
        if (r16 == true) goto L15;
        String r17 = this.$localResPath;
        if ((!StringsKt.isBlank(r17)) == true) goto L29;
        r17 = null;
    L29:
        String r6 = "";
        if (r17 != null) goto L40;
        ResourceItemBean r18 = this.this$0.y.get(this.$resourceKey);
        if (r18 == null) goto L36;
        Image r19 = r18.getImage();
        if (r19 == null) goto L36;
        r17 = r19.localResPath;
    L37:
        if (r17 != null) goto L40;
        r17 = "";
    L36:
        r17 = null;
    L40:
        if ((!StringsKt.isBlank(r17)) == false) goto L43;
        this.this$0.f5(this.$resourceKey, r17, null);
        return Unit.INSTANCE;
    L43:
        MultiAttachmentSelectorComponent r110 = this.this$0;
        String r7 = this.$resourceKey;
        ResourceItemBean r8 = r110.y.get(r7);
        if (r8 == null) goto L69;
        Image r9 = r8.getImage();
        if (r9 == null) goto L52;
        ImageObj r10 = r9.imageThumb;
        if (r10 == null) goto L52;
        String r11 = r10.url;
        if (r11 == null) goto L52;
    L68:
        if (StringsKt.isBlank(r11) == true) goto L69;
        com.larus.uaigc.helper.f.a.getClass();
        boolean r12 = com.larus.uaigc.helper.f.a();
        MutableLiveData<ry9.k> r13 = r110.X3(r7);
        if (r13 == null) goto L73;
        ry9.k r20 = (ry9.k) r13.getValue();
    L74:
        Image r21 = r8.getImage();
        if (r21 == null) goto L77;
        String r22 = r21.identifier;
    L78:
        if (r22 != null) goto L80;
        r22 = "";
    L80:
        Image r111 = r8.getImage();
        if (r111 == null) goto L83;
        String r112 = r111.resourceId;
    L84:
        if (r112 != null) goto L86;
        r112 = "";
    L86:
        Image r23 = r8.getImage();
        if (r23 == null) goto L89;
        r5 = r23.localResPath;
    L89:
        if (r5 == null) goto L92;
        r6 = r5;
    L92:
        if (r12 == false) goto L100;
        if (r20 != null) goto L95;
    L97:
        boolean r24 = false;
    L98:
        if (r24 == false) goto L100;
        boolean r25 = true;
    L102:
        if (r110.z5(r7) != ResourceType.AVATAR) goto L104;
        boolean r113 = true;
    L105:
        r110.q00(r7, r11, r22, r112, r6, r25, r113, "");
    L106:
        if (r2 == true) goto L108;
        FLogger.a.w("MultiAttachmentSelector", "[handleAttachmentRetry] no retry input, resourceKey=" + this.$resourceKey);
        MutableLiveData<ry9.k> r114 = this.this$0.X3(this.$resourceKey);
        if (r114 == null) goto L113;
        r114.setValue(new ry9.k(this.$resourceKey, ry9.j.f.b, 0, false, false, false, 60));
    L113:
        return Unit.INSTANCE;
    L108:
        return Unit.INSTANCE;
    L104:
        r113 = false;
        goto L105
    L95:
        if (r20.d != true) goto L97;
        r24 = true;
    L100:
        r25 = false;
        goto L102
    L83:
        r112 = null;
        goto L84
    L77:
        r22 = null;
        goto L78
    L73:
        r20 = null;
    L52:
        Image r26 = r8.getImage();
        if (r26 == null) goto L57;
        ImageObj r27 = r26.imageOri;
        if (r27 == null) goto L57;
        r11 = r27.url;
    L58:
        if (r11 != null) goto L68;
        Image r28 = r8.getImage();
        if (r28 == null) goto L64;
        ImageObj r29 = r28.previewImage;
        if (r29 == null) goto L64;
        r11 = r29.url;
    L65:
        if (r11 != null) goto L68;
    L64:
        r11 = null;
    L57:
        r11 = null;
    L69:
        r2 = false;
        goto L106
    L15:
        if (this.this$0.G.remove(this.$resourceKey) == false) goto L23;
        ResourceItemBean r115 = this.this$0.y.get(this.$resourceKey);
        if (r115 == null) goto L22;
        MultiAttachmentSelectorComponent r30 = this.this$0;
        this.label = 1;
        if (MultiAttachmentSelectorComponent.p3(r30, r115, this) != r0) goto L22;
        return r0;
    L23:
        MultiAttachmentSelectorComponent r116 = this.this$0;
        String r31 = this.$resourceKey;
        String r32 = this.$localResPath;
        r116.E5(r31, "creation_page/album_upload/video");
        AlbumHelperKt.g(LifecycleOwnerKt.getLifecycleScope(r116), Dispatchers.getIO(), new MultiAttachmentSelectorComponent$uploadVideo$1(r32, r116, r31, null), 2);
        return Unit.INSTANCE;
    L11:
        r16 = false;
        goto L12
    }
}
