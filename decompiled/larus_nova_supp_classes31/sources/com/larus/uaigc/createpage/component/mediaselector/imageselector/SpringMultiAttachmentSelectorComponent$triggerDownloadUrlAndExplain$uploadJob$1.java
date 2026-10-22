package com.larus.uaigc.createpage.component.mediaselector.imageselector;

import android.graphics.Bitmap;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.actionbar.model.ImageUploadInfo;
import com.larus.bmhome.actionbar.model.MediaAttachment;
import com.larus.uaigc.createpage.utils.BitmapHelperKt;
import com.tencent.open.log.TraceLevel;
import java.io.File;
import java.util.UUID;
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
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.mediaselector.imageselector.SpringMultiAttachmentSelectorComponent$triggerDownloadUrlAndExplain$uploadJob$1", f = "SpringMultiAttachmentSelectorComponent.kt", i = {0}, l = {873}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
public final class SpringMultiAttachmentSelectorComponent$triggerDownloadUrlAndExplain$uploadJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $identifier;
    final /* synthetic */ boolean $isAvatar;
    final /* synthetic */ boolean $isPrivate;
    final /* synthetic */ String $localFilePath;
    final /* synthetic */ String $resourceId;
    final /* synthetic */ String $resourceKey;
    final /* synthetic */ String $uri;
    final /* synthetic */ String $url;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ SpringMultiAttachmentSelectorComponent this$0;

    /* JADX INFO: renamed from: com.larus.uaigc.createpage.component.mediaselector.imageselector.SpringMultiAttachmentSelectorComponent$triggerDownloadUrlAndExplain$uploadJob$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.uaigc.createpage.component.mediaselector.imageselector.SpringMultiAttachmentSelectorComponent$triggerDownloadUrlAndExplain$uploadJob$1$1", f = "SpringMultiAttachmentSelectorComponent.kt", i = {0}, l = {901}, m = "invokeSuspend", n = {"resultPath"}, s = {"L$0"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Bitmap $bitmap;
        final /* synthetic */ String $identifier;
        final /* synthetic */ boolean $isAvatar;
        final /* synthetic */ boolean $isPrivate;
        final /* synthetic */ String $localFilePath;
        final /* synthetic */ String $resourceId;
        final /* synthetic */ String $resourceKey;
        final /* synthetic */ String $uri;
        final /* synthetic */ String $url;
        Object L$0;
        int label;
        final /* synthetic */ SpringMultiAttachmentSelectorComponent this$0;

        public AnonymousClass1(String r1, String r2, SpringMultiAttachmentSelectorComponent r3, Bitmap r4, String r5, String r6, String r7, String r8, boolean r9, boolean r10, Continuation<? super AnonymousClass1> r11) {
            this.$identifier = r1;
            this.$localFilePath = r2;
            this.this$0 = r3;
            this.$bitmap = r4;
            this.$url = r5;
            this.$uri = r6;
            this.$resourceId = r7;
            this.$resourceKey = r8;
            this.$isPrivate = r9;
            this.$isAvatar = r10;
            super(2, r11);
        }

        public final Continuation<Unit> create(Object r13, Continuation<?> r14) {
            return new AnonymousClass1(this.$identifier, this.$localFilePath, this.this$0, this.$bitmap, this.$url, this.$uri, this.$resourceId, this.$resourceKey, this.$isPrivate, this.$isAvatar, r14);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r26) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            String r3 = "";
            if (r2 == 0) goto L8;
            if (r2 != 1) goto L7;
            Ref.ObjectRef r4 = (Ref.ObjectRef) this.L$0;
            ResultKt.throwOnFailure(r26);
            Object r5 = r26;
        L25:
            File r6 = (File) r5;
            if (r6 != null) goto L28;
        L31:
            Ref.ObjectRef r7 = r4;
        L32:
            final ry9.j.c r9 = new ry9.j.c(new ry9.i.a(new MediaAttachment(this.$url, this.$uri, new ImageUploadInfo(Boxing.boxLong(this.$bitmap.getWidth()), Boxing.boxLong(this.$bitmap.getHeight())), null, (String) r7.element, this.$identifier, this.$resourceId, null, null, null, null, null, 3976, null), null));
            final SpringMultiAttachmentSelectorComponent r8 = this.this$0;
            final String r10 = this.$resourceKey;
            final boolean r11 = this.$isPrivate;
            final boolean r12 = this.$isAvatar;
            com.larus.utils.t0.e(new w4(r8, r10, r9, r11, r12));
            return Unit.INSTANCE;
        L28:
            if (r6.exists() == false) goto L30;
            r3 = r6.getAbsolutePath();
            Intrinsics.checkNotNull(r3);
        L30:
            r4.element = r3;
            goto L31
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r26);
            final SpringMultiAttachmentSelectorComponent r13 = this.this$0;
            final String r14 = this.$resourceKey;
            final boolean r15 = this.$isPrivate;
            final boolean r16 = this.$isAvatar;
            com.larus.utils.t0.e(new v4(r13, r14, r15, r16));
            String r17 = this.$identifier;
            boolean r18 = false;
            if (r17.length() != 0) goto L11;
            boolean r19 = true;
        L12:
            if (r19 == false) goto L14;
            StringBuilder r20 = new StringBuilder();
            r20.append(UUID.randomUUID());
            r20.append('_');
            r20.append(System.currentTimeMillis());
            r17 = r20.toString();
        L14:
            r7 = new Ref.ObjectRef();
            r7.element = "";
            if (this.$localFilePath.length() <= 0) goto L17;
            r18 = true;
        L17:
            if (r18 == true) goto L19;
        L21:
            this.this$0.getContext();
            this.L$0 = r7;
            this.label = 1;
            r5 = BitmapHelperKt.f(this.$bitmap, "image_attachment_image_" + r17 + ".jpeg", this);
            if (r5 != r1) goto L24;
            return r1;
        L24:
            r4 = r7;
            goto L25
        L19:
            if (new PolarisFileWrapper(this.$localFilePath).exists() == false) goto L21;
            r7.element = this.$localFilePath;
            goto L32
        L11:
            r19 = false;
            goto L12
        }
    }

    public SpringMultiAttachmentSelectorComponent$triggerDownloadUrlAndExplain$uploadJob$1(String r1, SpringMultiAttachmentSelectorComponent r2, String r3, String r4, String r5, String r6, String r7, boolean r8, boolean r9, Continuation<? super SpringMultiAttachmentSelectorComponent$triggerDownloadUrlAndExplain$uploadJob$1> r10) {
        this.$url = r1;
        this.this$0 = r2;
        this.$identifier = r3;
        this.$localFilePath = r4;
        this.$uri = r5;
        this.$resourceId = r6;
        this.$resourceKey = r7;
        this.$isPrivate = r8;
        this.$isAvatar = r9;
        super(2, r10);
    }

    public final Continuation<Unit> create(Object r13, Continuation<?> r14) {
        SpringMultiAttachmentSelectorComponent$triggerDownloadUrlAndExplain$uploadJob$1 r11 = new SpringMultiAttachmentSelectorComponent$triggerDownloadUrlAndExplain$uploadJob$1(this.$url, this.this$0, this.$identifier, this.$localFilePath, this.$uri, this.$resourceId, this.$resourceKey, this.$isPrivate, this.$isAvatar, r14);
        r11.L$0 = r13;
        return r11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r18) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        CoroutineScope r3 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r18);
        Object r4 = r18;
        CoroutineScope r5 = r3;
    L12:
        Bitmap r9 = (Bitmap) r4;
        if (r9 == null) goto L15;
        BuildersKt.launch$default(r5, Dispatchers.getMain(), null, new AnonymousClass1(this.$identifier, this.$localFilePath, this.this$0, r9, this.$url, this.$uri, this.$resourceId, this.$resourceKey, this.$isPrivate, this.$isAvatar, null), 2, null);
        return Unit.INSTANCE;
    L15:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r18);
        CoroutineScope r6 = (CoroutineScope) this.L$0;
        CoroutineDispatcher r7 = Dispatchers.getIO();
        SpringMultiAttachmentSelectorComponent$triggerDownloadUrlAndExplain$uploadJob$1$bitmap$1 r8 = new SpringMultiAttachmentSelectorComponent$triggerDownloadUrlAndExplain$uploadJob$1$bitmap$1(this.$url, this.this$0, null);
        this.L$0 = r6;
        this.label = 1;
        r4 = BuildersKt.withContext(r7, r8, this);
        if (r4 != r1) goto L11;
        return r1;
    L11:
        r5 = r6;
        goto L12
    }
}
