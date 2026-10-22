package com.larus.uaigc.createpage.component.mediaselector.imageselector;

import android.graphics.Bitmap;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.uaigc.createpage.utils.BitmapHelperKt;
import com.tencent.open.log.TraceLevel;
import java.io.File;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
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
@DebugMetadata(c = "com.larus.uaigc.createpage.component.mediaselector.imageselector.MultiAttachmentSelectorComponent$triggerDownloadUrlAndExplain$uploadJob$1", f = "MultiAttachmentSelectorComponent.kt", i = {0}, l = {3542}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
public final class MultiAttachmentSelectorComponent$triggerDownloadUrlAndExplain$uploadJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
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
    final /* synthetic */ MultiAttachmentSelectorComponent this$0;

    /* JADX INFO: renamed from: com.larus.uaigc.createpage.component.mediaselector.imageselector.MultiAttachmentSelectorComponent$triggerDownloadUrlAndExplain$uploadJob$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.uaigc.createpage.component.mediaselector.imageselector.MultiAttachmentSelectorComponent$triggerDownloadUrlAndExplain$uploadJob$1$1", f = "MultiAttachmentSelectorComponent.kt", i = {0, 0}, l = {3577, 3601, 3603}, m = "invokeSuspend", n = {"targetIdentifier", "resultPath"}, s = {"L$0", "L$1"})
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
        Object L$1;
        int label;
        final /* synthetic */ MultiAttachmentSelectorComponent this$0;

        public AnonymousClass1(MultiAttachmentSelectorComponent r1, String r2, String r3, Bitmap r4, String r5, String r6, String r7, String r8, boolean r9, boolean r10, Continuation<? super AnonymousClass1> r11) {
            this.this$0 = r1;
            this.$identifier = r2;
            this.$localFilePath = r3;
            this.$bitmap = r4;
            this.$resourceKey = r5;
            this.$url = r6;
            this.$uri = r7;
            this.$resourceId = r8;
            this.$isPrivate = r9;
            this.$isAvatar = r10;
            super(2, r11);
        }

        public final Continuation<Unit> create(Object r13, Continuation<?> r14) {
            return new AnonymousClass1(this.this$0, this.$identifier, this.$localFilePath, this.$bitmap, this.$resourceKey, this.$url, this.$uri, this.$resourceId, this.$isPrivate, this.$isAvatar, r14);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r32) {
            Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r0 = this.label;
            String r1 = "";
            if (r0 == 0) goto L12;
            if (r0 == 1) goto L11;
            if (r0 == 2) goto L10;
            if (r0 == 3) goto L10;
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            ResultKt.throwOnFailure(r32);
        L46:
            return Unit.INSTANCE;
        L11:
            Ref.ObjectRef r2 = (Ref.ObjectRef) this.L$1;
            String r3 = (String) this.L$0;
            ResultKt.throwOnFailure(r32);
            Object r4 = r32;
        L30:
            File r5 = (File) r4;
            if (r5 != null) goto L33;
        L36:
            String r6 = r3;
            final ry9.j.c r28 = MultiAttachmentSelectorComponent.H3(this.this$0, this.$resourceKey, this.$url, this.$uri, r6, this.$resourceId, (String) r2.element, this.$bitmap.getWidth(), this.$bitmap.getHeight(), false, 256);
            if (r28 == null) goto L39;
            final MultiAttachmentSelectorComponent r7 = this.this$0;
            final String r8 = this.$resourceKey;
            final boolean r9 = this.$isPrivate;
            final boolean r10 = this.$isAvatar;
            com.larus.utils.t0.e(new r3(r7, r8, r28, r9, r10));
        L39:
            MultiAttachmentSelectorComponent r12 = this.this$0;
            String r13 = this.$resourceKey;
            String r14 = this.$url;
            Bitmap r15 = this.$bitmap;
            String r16 = this.$resourceId;
            String r17 = (String) r2.element;
            boolean r18 = this.$isPrivate;
            boolean r19 = this.$isAvatar;
            this.L$0 = null;
            this.L$1 = null;
            this.label = 2;
            if (MultiAttachmentSelectorComponent.N2(r12, r13, r14, r15, r6, r16, r17, r18, r19, this) != r11) goto L46;
            return r11;
        L33:
            if (r5.exists() == false) goto L35;
            r1 = r5.getAbsolutePath();
            Intrinsics.checkNotNull(r1);
        L35:
            r2.element = r1;
            goto L36
        L12:
            ResultKt.throwOnFailure(r32);
            final MultiAttachmentSelectorComponent r20 = this.this$0;
            final String r21 = this.$resourceKey;
            final boolean r22 = this.$isPrivate;
            final boolean r23 = this.$isAvatar;
            com.larus.utils.t0.e(new q3(r20, r21, r22, r23));
            MultiAttachmentSelectorComponent r24 = this.this$0;
            if (r24.s == false) goto L42;
            String r25 = this.$identifier;
            boolean r26 = false;
            if (r25.length() != 0) goto L17;
            boolean r27 = true;
        L18:
            if (r27 == false) goto L20;
            StringBuilder r29 = new StringBuilder();
            r29.append(UUID.randomUUID());
            r29.append('_');
            r29.append(System.currentTimeMillis());
            r25 = r29.toString();
        L20:
            r3 = r25;
            r2 = new Ref.ObjectRef();
            r2.element = "";
            if (this.$localFilePath.length() <= 0) goto L23;
            r26 = true;
        L23:
            if (r26 == true) goto L25;
        L27:
            this.this$0.getContext();
            this.L$0 = r3;
            this.L$1 = r2;
            this.label = 1;
            r4 = BitmapHelperKt.f(this.$bitmap, "image_attachment_image_" + r3 + ".jpeg", this);
            if (r4 != r11) goto L30;
            return r11;
        L25:
            if (new PolarisFileWrapper(this.$localFilePath).exists() == false) goto L27;
            r2.element = this.$localFilePath;
            goto L36
        L17:
            r27 = false;
            goto L18
        L42:
            String r30 = this.$resourceKey;
            Bitmap r31 = this.$bitmap;
            boolean r33 = this.$isPrivate;
            boolean r34 = this.$isAvatar;
            this.label = 3;
            if (r24.h5(r30, r31, r33, r34, this) != r11) goto L46;
            return r11;
        }
    }

    public MultiAttachmentSelectorComponent$triggerDownloadUrlAndExplain$uploadJob$1(String r1, MultiAttachmentSelectorComponent r2, String r3, String r4, String r5, String r6, String r7, boolean r8, boolean r9, Continuation<? super MultiAttachmentSelectorComponent$triggerDownloadUrlAndExplain$uploadJob$1> r10) {
        this.$url = r1;
        this.this$0 = r2;
        this.$identifier = r3;
        this.$localFilePath = r4;
        this.$resourceKey = r5;
        this.$uri = r6;
        this.$resourceId = r7;
        this.$isPrivate = r8;
        this.$isAvatar = r9;
        super(2, r10);
    }

    public final Continuation<Unit> create(Object r13, Continuation<?> r14) {
        MultiAttachmentSelectorComponent$triggerDownloadUrlAndExplain$uploadJob$1 r11 = new MultiAttachmentSelectorComponent$triggerDownloadUrlAndExplain$uploadJob$1(this.$url, this.this$0, this.$identifier, this.$localFilePath, this.$resourceKey, this.$uri, this.$resourceId, this.$isPrivate, this.$isAvatar, r14);
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
        BuildersKt.launch$default(r5, Dispatchers.getMain(), null, new AnonymousClass1(this.this$0, this.$identifier, this.$localFilePath, r9, this.$resourceKey, this.$url, this.$uri, this.$resourceId, this.$isPrivate, this.$isAvatar, null), 2, null);
        return Unit.INSTANCE;
    L15:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r18);
        CoroutineScope r6 = (CoroutineScope) this.L$0;
        CoroutineDispatcher r7 = Dispatchers.getIO();
        MultiAttachmentSelectorComponent$triggerDownloadUrlAndExplain$uploadJob$1$bitmap$1 r8 = new MultiAttachmentSelectorComponent$triggerDownloadUrlAndExplain$uploadJob$1$bitmap$1(this.$url, this.this$0, null);
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
