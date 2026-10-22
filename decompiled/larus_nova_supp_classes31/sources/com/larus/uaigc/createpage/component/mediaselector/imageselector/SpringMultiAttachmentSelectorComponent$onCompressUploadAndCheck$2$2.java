package com.larus.uaigc.createpage.component.mediaselector.imageselector;

import android.app.Application;
import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.MimeTypeMap;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.chat.bean.ProcessFileResultCode;
import com.larus.bmhome.view.resourcebar.bean.ItemStatus;
import com.larus.bmhome.view.resourcebar.bean.ResourceItemBean;
import com.larus.bmhome.view.resourcebar.bean.ResourceType;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Image;
import com.larus.platform.api.creation.IBachDetectCenterAbility;
import com.larus.platform.spi.IAIChatUploadMediaService;
import com.larus.uaigc.bean.createpage.component.mediacontainer.UIStatus;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.io.File;
import java.util.UUID;
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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.mediaselector.imageselector.SpringMultiAttachmentSelectorComponent$onCompressUploadAndCheck$2$2", f = "SpringMultiAttachmentSelectorComponent.kt", i = {1}, l = {416, 436, 464}, m = "invokeSuspend", n = {"result"}, s = {"L$0"})
final class SpringMultiAttachmentSelectorComponent$onCompressUploadAndCheck$2$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ File $albumFile;
    final /* synthetic */ ResourceItemBean $bean;
    Object L$0;
    int label;
    final /* synthetic */ SpringMultiAttachmentSelectorComponent this$0;

    /* JADX INFO: renamed from: com.larus.uaigc.createpage.component.mediaselector.imageselector.SpringMultiAttachmentSelectorComponent$onCompressUploadAndCheck$2$2$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.uaigc.createpage.component.mediaselector.imageselector.SpringMultiAttachmentSelectorComponent$onCompressUploadAndCheck$2$2$1", f = "SpringMultiAttachmentSelectorComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ResourceItemBean $resourceItemBean;
        final /* synthetic */ String $resourceKey;
        final /* synthetic */ ic8.n0 $result;
        int label;
        final /* synthetic */ SpringMultiAttachmentSelectorComponent this$0;

        public AnonymousClass1(SpringMultiAttachmentSelectorComponent r1, String r2, ResourceItemBean r3, ic8.n0 r4, Continuation<? super AnonymousClass1> r5) {
            this.this$0 = r1;
            this.$resourceKey = r2;
            this.$resourceItemBean = r3;
            this.$result = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
            return new AnonymousClass1(this.this$0, this.$resourceKey, this.$resourceItemBean, this.$result, r8);
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
            this.this$0.A.setValue(new ry9.f(this.$resourceKey, 0, this.$resourceItemBean, UIStatus.STATUS_COMPRESS_SUCCESS, 2));
            FLogger.a.i("MultiAttachmentSelector", "[onCreationUploadAndCheck] filePath = $ resourceKey = " + this.$resourceKey);
            ic8.m0 r10 = this.$result.a;
            if (r10 == null) goto L9;
            String r11 = r10.e;
            if (r11 == null) goto L9;
            SpringMultiAttachmentSelectorComponent.P2(this.this$0, this.$resourceKey, r11);
            return Unit.INSTANCE;
        L9:
            return null;
        L12:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.uaigc.createpage.component.mediaselector.imageselector.SpringMultiAttachmentSelectorComponent$onCompressUploadAndCheck$2$2$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.uaigc.createpage.component.mediaselector.imageselector.SpringMultiAttachmentSelectorComponent$onCompressUploadAndCheck$2$2$3", f = "SpringMultiAttachmentSelectorComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ResourceItemBean $bean;
        final /* synthetic */ ic8.n0 $result;
        int label;
        final /* synthetic */ SpringMultiAttachmentSelectorComponent this$0;

        public AnonymousClass3(SpringMultiAttachmentSelectorComponent r1, ic8.n0 r2, ResourceItemBean r3, Continuation<? super AnonymousClass3> r4) {
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
            if (this.label != 0) goto L23;
            ResultKt.throwOnFailure(r9);
            SpringMultiAttachmentSelectorComponent r10 = this.this$0;
            ic8.n0 r0 = this.$result;
            int r1 = SpringMultiAttachmentSelectorComponent.L;
            r10.getClass();
            ProcessFileResultCode r11 = r0.b;
            if (r11 != null) goto L7;
            int r12 = -1;
        L9:
            if (r12 != 1) goto L11;
            FLogger.a.e("MultiAttachmentSelector", "tryAttachmentUpload ProcessResult for OverSize");
            t19.s r13 = t19.s.a;
            Application r2 = AppHost.a.getApplication();
            r13.getClass();
            t19.s.s(r2, 2131906513);
        L15:
            SpringMultiAttachmentSelectorComponent r14 = this.this$0;
            String r3 = this.$bean.getKey();
            Image r4 = this.$bean.getImage();
            if (r4 == null) goto L19;
            String r5 = r4.localResPath;
            if (r5 == null) goto L19;
        L20:
            r14.w60(r3, r5, null);
            this.this$0.A.setValue(new ry9.f(this.$bean.getKey(), 0, null, UIStatus.STATUS_DELETE, 6));
            return Unit.INSTANCE;
        L19:
            r5 = "";
            goto L20
        L11:
            if (r12 == 2) goto L13;
            t19.s r15 = t19.s.a;
            Application r6 = AppHost.a.getApplication();
            r15.getClass();
            t19.s.s(r6, 2131908214);
            goto L15
        L13:
            FLogger.a.e("MultiAttachmentSelector", "tryAttachmentUpload ProcessResult for PREPARE_TYPE_NO_MATCH");
            t19.s r16 = t19.s.a;
            Application r7 = AppHost.a.getApplication();
            r16.getClass();
            t19.s.s(r7, 2131906526);
            goto L15
        L7:
            r12 = SpringMultiAttachmentSelectorComponent.b.a[r11.ordinal()];
            goto L9
        L23:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public SpringMultiAttachmentSelectorComponent$onCompressUploadAndCheck$2$2(SpringMultiAttachmentSelectorComponent r1, File r2, ResourceItemBean r3, Continuation<? super SpringMultiAttachmentSelectorComponent$onCompressUploadAndCheck$2$2> r4) {
        this.this$0 = r1;
        this.$albumFile = r2;
        this.$bean = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new SpringMultiAttachmentSelectorComponent$onCompressUploadAndCheck$2$2(this.this$0, this.$albumFile, this.$bean, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r55) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r12 = true;
        Uri r13 = null;
        if (r1 == 0) goto L12;
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L10;
        if (r1 != 3) goto L9;
        ResultKt.throwOnFailure(r55);
    L82:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ic8.n0 r2 = (ic8.n0) this.L$0;
        ResultKt.throwOnFailure(r55);
    L60:
        if (IBachDetectCenterAbility.a.b() == false) goto L82;
        ic8.m0 r3 = r2.a;
        if (r3 == null) goto L82;
        String r4 = r3.e;
        if (r4 == null) goto L82;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L70
        PolarisFileWrapper r6 = new PolarisFileWrapper(r4);     // Catch: Throwable -> L70
        if (r6.exists() == false) goto L68;
        r13 = Uri.fromFile(r6);     // Catch: Throwable -> L70
    L68:
        Object r7 = Result.constructor-impl(r13);     // Catch: Throwable -> L70
    L73:
        if (Result.isSuccess-impl(r7) == false) goto L77;
        Uri r8 = (Uri) r7;
        if (r8 == null) goto L77;
        IBachDetectCenterAbility.a.a(r8);
    L77:
        Result.box-impl(r7);
    L70:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L73
    L11:
        ResultKt.throwOnFailure(r55);
        Object r10 = r55;
    L15:
        ic8.n0 r11 = (ic8.n0) r10;
        ProcessFileResultCode r14 = r11.b;
        if (r14 != null) goto L18;
    L20:
        r12 = false;
    L21:
        if (r12 == false) goto L78;
        ic8.m0 r15 = r11.a;
        if (r15 == null) goto L25;
        String r16 = r15.e;
    L27:
        if (com.larus.utils.o0.d(r16) == false) goto L78;
        String r17 = this.$bean.getKey();
        ic8.m0 r18 = r11.a;
        if (r18 == null) goto L36;
        String r19 = r18.e;
        if (r19 == null) goto L36;
        String r20 = StringsKt.substringAfterLast$default(r19, '.', null, 2, null);
        if (r20 == null) goto L36;
        String r110 = r20;
    L37:
        MimeTypeMap r21 = MimeTypeMap.getSingleton();
        ic8.m0 r22 = r11.a;
        if (r22 == null) goto L42;
        String r23 = r22.e;
        if (r23 == null) goto L42;
        String r24 = StringsKt.substringAfterLast$default(r23, '.', null, 2, null);
    L43:
        String r25 = r21.getMimeTypeFromExtension(r24);
        if (r25 != null) goto L46;
        String r111 = "";
    L47:
        ItemStatus r26 = ItemStatus.UPLINKING;
        ResourceType r27 = ResourceType.IMAGE;
        String r38 = UUID.randomUUID().toString();
        ic8.m0 r28 = r11.a;
        if (r28 == null) goto L50;
        String r39 = r28.f;
    L52:
        if (r28 == null) goto L54;
        String r43 = r28.e;
    L55:
        ResourceItemBean r29 = new ResourceItemBean(r17, null, r110, r111, new Image(r38, r39, null, null, null, r43, null, null, null, null, null, null, null, null, 16348, null), null, 0, r26, false, r27, i5.w0(), 0, 0, 0, false, false, false, false, 0, this.$bean.getExt(), 522530, null);
        MainCoroutineDispatcher r30 = Dispatchers.getMain();
        AnonymousClass1 r112 = new AnonymousClass1(this.this$0, r17, r29, r11, null);
        this.L$0 = r11;
        this.label = 2;
        if (BuildersKt.withContext(r30, r112, this) != r0) goto L58;
        return r0;
    L58:
        r2 = r11;
        goto L60
    L54:
        r43 = null;
        goto L55
    L50:
        r39 = null;
        goto L52
    L46:
        r111 = r25;
    L42:
        r24 = null;
    L36:
        r110 = "";
        goto L37
    L25:
        r16 = null;
    L78:
        MainCoroutineDispatcher r31 = Dispatchers.getMain();
        AnonymousClass3 r32 = new AnonymousClass3(this.this$0, r11, this.$bean, null);
        this.label = 3;
        if (BuildersKt.withContext(r31, r32, this) != r0) goto L82;
        return r0;
    L18:
        if (r14.isSuccess() != true) goto L20;
    L12:
        ResultKt.throwOnFailure(r55);
        SpringMultiAttachmentSelectorComponent r33 = this.this$0;
        Uri r34 = Uri.fromFile(this.$albumFile);
        this.label = 1;
        int r35 = SpringMultiAttachmentSelectorComponent.L;
        r33.getClass();
        hq9.s1 r36 = com.larus.platform.service.z2.a.getImageEditUploadConfig();
        r10 = IAIChatUploadMediaService.a.a(IAIChatUploadMediaService.a, r34, new ns8.a(Boxing.boxInt(r36.a), Boxing.boxInt(r36.b), Boxing.boxInt(r36.c), Bitmap.CompressFormat.PNG, false, 240), false, false, null, this, 60);
        if (r10 != r0) goto L15;
        return r0;
    }
}
