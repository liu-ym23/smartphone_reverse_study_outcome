package com.larus.uaigc.createpage.component.mediaselector.imageselector;

import android.net.Uri;
import android.webkit.MimeTypeMap;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.chat.bean.ProcessFileResultCode;
import com.larus.bmhome.view.resourcebar.bean.ItemStatus;
import com.larus.bmhome.view.resourcebar.bean.ResourceItemBean;
import com.larus.bmhome.view.resourcebar.bean.ResourceType;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.ImageObj;
import com.larus.platform.api.creation.IBachDetectCenterAbility;
import com.larus.uaigc.bean.createpage.component.mediacontainer.UIStatus;
import com.larus.uaigc.helper.CreationImageUploadPolicy;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.io.File;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.mediaselector.imageselector.MultiAttachmentSelectorComponent$onCompressUploadAndCheck$2$2", f = "MultiAttachmentSelectorComponent.kt", i = {1, 2}, l = {1850, 1877, 1911}, m = "invokeSuspend", n = {"result", "result"}, s = {"L$0", "L$0"})
final class MultiAttachmentSelectorComponent$onCompressUploadAndCheck$2$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ File $albumFile;
    final /* synthetic */ ResourceItemBean $bean;
    Object L$0;
    int label;
    final /* synthetic */ MultiAttachmentSelectorComponent this$0;

    /* JADX INFO: renamed from: com.larus.uaigc.createpage.component.mediaselector.imageselector.MultiAttachmentSelectorComponent$onCompressUploadAndCheck$2$2$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.uaigc.createpage.component.mediaselector.imageselector.MultiAttachmentSelectorComponent$onCompressUploadAndCheck$2$2$1", f = "MultiAttachmentSelectorComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ResourceItemBean $bean;
        final /* synthetic */ ResourceItemBean $resourceItemBean;
        final /* synthetic */ String $resourceKey;
        final /* synthetic */ ic8.n0 $result;
        int label;
        final /* synthetic */ MultiAttachmentSelectorComponent this$0;

        public AnonymousClass1(MultiAttachmentSelectorComponent r1, String r2, ResourceItemBean r3, ic8.n0 r4, ResourceItemBean r5, Continuation<? super AnonymousClass1> r6) {
            this.this$0 = r1;
            this.$resourceKey = r2;
            this.$resourceItemBean = r3;
            this.$result = r4;
            this.$bean = r5;
            super(2, r6);
        }

        public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
            return new AnonymousClass1(this.this$0, this.$resourceKey, this.$resourceItemBean, this.$result, this.$bean, r9);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r12) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L30;
            ResultKt.throwOnFailure(r12);
            this.this$0.N.setValue(new ry9.f(this.$resourceKey, 0, this.$resourceItemBean, UIStatus.STATUS_COMPRESS_SUCCESS, 2));
            FLogger.a.i("MultiAttachmentSelector", "[onCreationUploadAndCheck] local file ready");
            ic8.n0 r13 = this.$result;
            ic8.m0 r0 = r13.a;
            String r1 = null;
            if (r0 == null) goto L31;
            String r2 = r0.e;
            if (r2 == null) goto L32;
            MultiAttachmentSelectorComponent r3 = this.this$0;
            ResourceItemBean r4 = this.$bean;
            String r5 = this.$resourceKey;
            r3.E5(r4.getKey(), "creation_page/album_upload");
            ic8.m0 r6 = r13.a;
            if (r6 == null) goto L11;
            String r7 = Boxing.boxLong(r6.c).toString();
        L12:
            String r8 = "";
            if (r7 != null) goto L15;
            r7 = "";
        L15:
            nz9.b.c("upload", "file_size", r7, r4.getKey());
            Pair[] r9 = new Pair[2];
            ic8.m0 r10 = r13.a;
            if (r10 == null) goto L18;
            String r11 = Boxing.boxLong(r10.c).toString();
        L19:
            if (r11 != null) goto L21;
            r11 = "";
        L21:
            r9[0] = TuplesKt.to("file_size", r11);
            ic8.m0 r14 = r13.a;
            if (r14 == null) goto L24;
            r1 = r14.d;
        L24:
            if (r1 == null) goto L27;
            r8 = r1;
        L27:
            r9[1] = TuplesKt.to("file_type", r8);
            nz9.b.d("creation_page/album_upload", CollectionsKt.listOf(r9), r4.getKey());
            r3.f5(r5, r2, r13.a);
            return Unit.INSTANCE;
        L18:
            r11 = null;
            goto L19
        L11:
            r7 = null;
            goto L12
        L32:
            return null;
        L31:
            return null;
        L30:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.uaigc.createpage.component.mediaselector.imageselector.MultiAttachmentSelectorComponent$onCompressUploadAndCheck$2$2$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.uaigc.createpage.component.mediaselector.imageselector.MultiAttachmentSelectorComponent$onCompressUploadAndCheck$2$2$3", f = "MultiAttachmentSelectorComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ResourceItemBean $bean;
        final /* synthetic */ ic8.n0 $result;
        int label;
        final /* synthetic */ MultiAttachmentSelectorComponent this$0;

        public AnonymousClass3(MultiAttachmentSelectorComponent r1, ic8.n0 r2, ResourceItemBean r3, Continuation<? super AnonymousClass3> r4) {
            this.this$0 = r1;
            this.$result = r2;
            this.$bean = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new AnonymousClass3(this.this$0, this.$result, this.$bean, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r9) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L12;
            ResultKt.throwOnFailure(r9);
            MultiAttachmentSelectorComponent.X2(this.this$0, this.$result);
            MultiAttachmentSelectorComponent r10 = this.this$0;
            String r0 = this.$bean.getKey();
            Image r1 = this.$bean.getImage();
            if (r1 == null) goto L8;
            String r2 = r1.localResPath;
            if (r2 == null) goto L8;
        L9:
            r10.w60(r0, r2, null);
            this.this$0.N.setValue(new ry9.f(this.$bean.getKey(), 0, null, UIStatus.STATUS_DELETE, 6));
            return Unit.INSTANCE;
        L8:
            r2 = "";
            goto L9
        L12:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public MultiAttachmentSelectorComponent$onCompressUploadAndCheck$2$2(ResourceItemBean r1, MultiAttachmentSelectorComponent r2, File r3, Continuation<? super MultiAttachmentSelectorComponent$onCompressUploadAndCheck$2$2> r4) {
        this.$bean = r1;
        this.this$0 = r2;
        this.$albumFile = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new MultiAttachmentSelectorComponent$onCompressUploadAndCheck$2$2(this.$bean, this.this$0, this.$albumFile, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object invokeSuspend(Object r51) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        String r6 = "";
        boolean r8 = true;
        Object r9 = null;
        if (r2 == 0) goto L12;
        if (r2 == 1) goto L11;
        if (r2 == 2) goto L10;
        if (r2 != 3) goto L9;
        ic8.n0 r1 = (ic8.n0) this.L$0;
        ResultKt.throwOnFailure(r51);
    L99:
        ProcessFileResultCode r3 = r1.b;
        if (r3 == null) goto L102;
        r9 = r3.getValue();
    L102:
        if (r9 == null) goto L105;
        r6 = r9;
    L105:
        nz9.b.e("preprocess", r6, this.$bean.getKey());
        nz9.b.e("creation_page/album_upload", "-101", this.$bean.getKey());
    L107:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ic8.n0 r4 = (ic8.n0) this.L$0;
        ResultKt.throwOnFailure(r51);
    L77:
        if (IBachDetectCenterAbility.a.b() == false) goto L107;
        ic8.m0 r5 = r4.a;
        if (r5 == null) goto L107;
        String r7 = r5.e;
        if (r7 == null) goto L107;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L87
        PolarisFileWrapper r11 = new PolarisFileWrapper(r7);     // Catch: Throwable -> L87
        if (r11.exists() == false) goto L85;
        r9 = Uri.fromFile(r11);     // Catch: Throwable -> L87
    L85:
        Object r12 = Result.constructor-impl(r9);     // Catch: Throwable -> L87
    L90:
        if (Result.isSuccess-impl(r12) == false) goto L94;
        Uri r13 = (Uri) r12;
        if (r13 == null) goto L94;
        IBachDetectCenterAbility.a.a(r13);
    L94:
        Result.box-impl(r12);
    L87:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L90
    L11:
        ResultKt.throwOnFailure(r51);
        Object r15 = r51;
    L15:
        ic8.n0 r16 = (ic8.n0) r15;
        Pair[] r17 = new Pair[2];
        ic8.m0 r18 = r16.a;
        if (r18 == null) goto L18;
        String r19 = Boxing.boxLong(r18.c).toString();
    L19:
        if (r19 != null) goto L21;
        r19 = "";
    L21:
        r17[0] = TuplesKt.to("file_size", r19);
        ic8.m0 r110 = r16.a;
        if (r110 == null) goto L24;
        String r111 = r110.d;
    L25:
        if (r111 != null) goto L27;
        r111 = "";
    L27:
        r17[1] = TuplesKt.to("file_type", r111);
        nz9.b.d("preprocess", CollectionsKt.listOf(r17), this.$bean.getKey());
        nz9.b.e("preprocess", "0", this.$bean.getKey());
        ProcessFileResultCode r112 = r16.b;
        if (r112 != null) goto L30;
    L32:
        r8 = false;
    L33:
        if (r8 == false) goto L95;
        ic8.m0 r20 = r16.a;
        if (r20 == null) goto L37;
        String r21 = r20.e;
    L39:
        if (com.larus.utils.o0.d(r21) == false) goto L95;
        String r22 = this.$bean.getKey();
        ic8.m0 r23 = r16.a;
        if (r23 == null) goto L48;
        String r24 = r23.e;
        if (r24 == null) goto L48;
        String r25 = StringsKt.substringAfterLast$default(r24, '.', null, 2, null);
        if (r25 == null) goto L48;
        String r113 = r25;
    L49:
        MimeTypeMap r26 = MimeTypeMap.getSingleton();
        ic8.m0 r27 = r16.a;
        if (r27 == null) goto L54;
        String r28 = r27.e;
        if (r28 == null) goto L54;
        String r29 = StringsKt.substringAfterLast$default(r28, '.', null, 2, null);
    L55:
        String r30 = r26.getMimeTypeFromExtension(r29);
        if (r30 != null) goto L58;
        String r114 = "";
    L59:
        ItemStatus r115 = ItemStatus.UPLINKING;
        ResourceType r210 = ResourceType.IMAGE;
        String r34 = UUID.randomUUID().toString();
        ic8.m0 r31 = r16.a;
        if (r31 == null) goto L62;
        String r35 = r31.f;
    L63:
        if (r31 == null) goto L65;
        String r39 = r31.e;
    L66:
        Image r32 = this.$bean.getImage();
        if (r32 == null) goto L71;
        ImageObj r33 = r32.imageOri;
        if (r33 == null) goto L71;
        ImageObj r37 = ImageObj.copy$default(r33, null, 0, 0, null, null, 31, null);
    L72:
        ResourceItemBean r36 = new ResourceItemBean(r22, null, r113, r114, new Image(r34, r35, null, r37, null, r39, null, null, null, null, null, null, null, null, 16340, null), null, 0, r115, false, r210, i5.w0(), 0, 0, 0, false, false, false, false, 0, this.$bean.getExt(), 522530, null);
        this.this$0.y.put(r22, r36);
        MainCoroutineDispatcher r38 = Dispatchers.getMain();
        AnonymousClass1 r40 = new AnonymousClass1(this.this$0, r22, r36, r16, this.$bean, null);
        this.L$0 = r16;
        this.label = 2;
        if (BuildersKt.withContext(r38, r40, this) != r0) goto L75;
        return r0;
    L75:
        r4 = r16;
    L71:
        r37 = null;
        goto L72
    L65:
        r39 = null;
        goto L66
    L62:
        r35 = null;
        goto L63
    L58:
        r114 = r30;
    L54:
        r29 = null;
    L48:
        r113 = "";
        goto L49
    L37:
        r21 = null;
    L95:
        MainCoroutineDispatcher r41 = Dispatchers.getMain();
        AnonymousClass3 r42 = new AnonymousClass3(this.this$0, r16, this.$bean, null);
        this.L$0 = r16;
        this.label = 3;
        if (BuildersKt.withContext(r41, r42, this) != r0) goto L98;
        return r0;
    L98:
        r1 = r16;
        goto L99
    L30:
        if (r112.isSuccess() != true) goto L32;
    L24:
        r111 = null;
        goto L25
    L18:
        r19 = null;
        goto L19
    L12:
        ResultKt.throwOnFailure(r51);
        nz9.b.h("preprocess", "creation_page/album_upload", this.$bean.getKey(), this.$bean.getKey(), 16);
        MultiAttachmentSelectorComponent r43 = this.this$0;
        Uri r116 = Uri.fromFile(this.$albumFile);
        this.label = 1;
        int r117 = MultiAttachmentSelectorComponent.Z;
        r43.getClass();
        r15 = CreationImageUploadPolicy.a.a(r116, "ai_creation", null, this);
        if (r15 != r0) goto L15;
        return r0;
    }
}
