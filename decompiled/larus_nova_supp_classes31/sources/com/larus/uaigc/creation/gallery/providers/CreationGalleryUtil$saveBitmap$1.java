package com.larus.uaigc.creation.gallery.providers;

import android.content.Context;
import com.larus.bmhome.bigimg.download.ImageDownloadLoadingMgr;
import com.larus.bmhome.share.ShareScene;
import com.larus.home.impl.sdk.k1;
import com.larus.im.bean.message.Message;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.creation.UserCreationFromIM;
import com.larus.uaigc.creation.detail.image.BigImageDetailFragment;
import com.larus.uaigc.helper.EnterpriseFileDownloadHelper;
import com.larus.uaigc.helper.e0;
import com.larus.uaigc.service.ICreationShareService;
import com.larus.uaigc.utils.DataConverterKt;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.creation.gallery.providers.CreationGalleryUtil$saveBitmap$1", f = "CreationGalleryUtil.kt", i = {}, l = {341, 353}, m = "invokeSuspend", n = {}, s = {})
public final class CreationGalleryUtil$saveBitmap$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<Boolean, Long, Unit> $callback;
    final /* synthetic */ Context $context;
    final /* synthetic */ String $imageUrl;
    final /* synthetic */ sz9.c $params;
    final /* synthetic */ boolean $share;
    int label;

    /* JADX INFO: renamed from: com.larus.uaigc.creation.gallery.providers.CreationGalleryUtil$saveBitmap$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.uaigc.creation.gallery.providers.CreationGalleryUtil$saveBitmap$1$1", f = "CreationGalleryUtil.kt", i = {}, l = {359}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ String $creationTaskId;
        final /* synthetic */ sz9.c $params;
        int label;

        public AnonymousClass1(sz9.c r1, String r2, Continuation<? super AnonymousClass1> r3) {
            this.$params = r1;
            this.$creationTaskId = r2;
            super(1, r3);
        }

        public final Continuation<Unit> create(Continuation<?> r4) {
            return new AnonymousClass1(this.$params, this.$creationTaskId, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((Continuation) r1);
        }

        public final Object invoke(Continuation<? super Unit> r2) {
            return create(r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r6);
        L18:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            IFlowSdkDepend r7 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
            if (r7 == null) goto L18;
            r7.w();
            k1 r8 = k1.a;
            sz9.c r2 = this.$params;
            String r3 = r2.j;
            String r4 = this.$creationTaskId;
            Message r5 = r2.l;
            if (r5 == null) goto L13;
            String r9 = r5.getMessageId();
        L14:
            this.label = 1;
            if (r8.h1(r3, r4, r9, this) != r0) goto L18;
            return r0;
        L13:
            r9 = null;
            goto L14
        }
    }

    /* JADX INFO: renamed from: com.larus.uaigc.creation.gallery.providers.CreationGalleryUtil$saveBitmap$1$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.uaigc.creation.gallery.providers.CreationGalleryUtil$saveBitmap$1$3", f = "CreationGalleryUtil.kt", i = {}, l = {377}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass3 extends SuspendLambda implements Function1<Continuation<? super String>, Object> {
        final /* synthetic */ String $imageUrl;
        final /* synthetic */ sz9.c $params;
        int label;

        public AnonymousClass3(sz9.c r1, String r2, Continuation<? super AnonymousClass3> r3) {
            this.$params = r1;
            this.$imageUrl = r2;
            super(1, r3);
        }

        public final Continuation<Unit> create(Continuation<?> r4) {
            return new AnonymousClass3(this.$params, this.$imageUrl, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((Continuation) r1);
        }

        public final Object invoke(Continuation<? super String> r2) {
            return create(r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r11) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r11);
        L20:
            return r11;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r11);
            EnterpriseFileDownloadHelper r12 = EnterpriseFileDownloadHelper.a;
            Integer r2 = this.$params.q;
            if (r2 == null) goto L11;
            String r3 = DataConverterKt.h(r2.intValue());
        L12:
            if (r3 != null) goto L14;
            r3 = "";
        L14:
            String r5 = r3;
            String r4 = this.$imageUrl;
            r12.getClass();
            String r6 = EnterpriseFileDownloadHelper.a(r4);
            String r7 = com.larus.utils.b0.d();
            if (Intrinsics.areEqual(r7, "zh") == false) goto L17;
            r7 = "zh-cn";
        L17:
            String r8 = this.$imageUrl;
            e0 r9 = new e0(r8, r5, r6, r7, "Creation", "image");
            this.label = 1;
            r11 = r12.d(r9, this);
            if (r11 != r0) goto L20;
            return r0;
        L11:
            r3 = null;
            goto L12
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CreationGalleryUtil$saveBitmap$1(boolean r1, sz9.c r2, Context r3, String r4, Function2<? super Boolean, ? super Long, Unit> r5, Continuation<? super CreationGalleryUtil$saveBitmap$1> r6) {
        this.$share = r1;
        this.$params = r2;
        this.$context = r3;
        this.$imageUrl = r4;
        this.$callback = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new CreationGalleryUtil$saveBitmap$1(this.$share, this.$params, this.$context, this.$imageUrl, this.$callback, r9);
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
        String r5 = null;
        if (r2 == 0) goto L10;
        if (r2 == 1) goto L9;
        if (r2 != 2) goto L8;
        ResultKt.throwOnFailure(r18);
        Object r3 = r18;
    L36:
        final UserCreationFromIM r4 = (UserCreationFromIM) r3;
        JSONObject r6 = this.$params.f;
        if (r6 == null) goto L39;
        String r7 = r6.optString("creation_task_id");
    L40:
        ImageDownloadLoadingMgr r8 = ImageDownloadLoadingMgr.a;
        String r9 = this.$imageUrl;
        if (r4 == null) goto L43;
        iz9.c.a.getClass();
        Map r10 = iz9.c.e(r4, r7);
    L44:
        AnonymousClass1 r11 = new AnonymousClass1(this.$params, r7, null);
        final Function2<Boolean, Long, Unit> r12 = this.$callback;
        final sz9.c r13 = this.$params;
        ImageDownloadLoadingMgr.b(r9, r10, r11, new r(r12, r13, r4), true, new AnonymousClass3(r13, this.$imageUrl, null));
    L46:
        return Unit.INSTANCE;
    L43:
        r10 = null;
        goto L44
    L39:
        r7 = null;
        goto L40
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r18);
        Object r14 = r18;
    L21:
        UserCreationFromIM r15 = (UserCreationFromIM) r14;
        ICreationShareService.Companion r16 = ICreationShareService.a;
        Context r17 = this.$context;
        String r19 = this.$imageUrl;
        ShareScene r20 = ShareScene.IMAGE_VIEWER_REPORT;
        sz9.c r21 = this.$params;
        if (r21 == null) goto L26;
        Message r22 = r21.l;
        if (r22 == null) goto L26;
        r5 = r22.getMessageId();
    L26:
        BigImageDetailFragment.b r110 = new BigImageDetailFragment.b(String.valueOf(r5));
        CreationGalleryUtil r23 = CreationGalleryUtil.a;
        com.larus.bmhome.share.panel.h r111 = CreationGalleryUtil.b("picture_detail", this.$params);
        sz9.c r24 = this.$params;
        ICreationShareService.a.a(r16, r17, r19, r20, r110, r111, null, r15, r24.q, r24.e, 160);
        goto L46
    L10:
        ResultKt.throwOnFailure(r18);
        if (this.$share == false) goto L27;
        CreationGalleryUtil r25 = CreationGalleryUtil.a;
        sz9.c r26 = this.$params;
        if (r26 == null) goto L17;
        Message r27 = r26.l;
        if (r27 == null) goto L17;
        String r28 = r27.getMessageId();
    L18:
        String r29 = this.$params.i;
        this.label = 1;
        r14 = r25.e(r28, r29, this);
        if (r14 != r1) goto L21;
        return r1;
    L17:
        r28 = null;
        goto L18
    L27:
        CreationGalleryUtil r30 = CreationGalleryUtil.a;
        sz9.c r31 = this.$params;
        if (r31 == null) goto L32;
        Message r32 = r31.l;
        if (r32 == null) goto L32;
        String r33 = r32.getMessageId();
    L33:
        String r34 = this.$params.i;
        this.label = 2;
        r3 = r30.e(r33, r34, this);
        if (r3 != r1) goto L36;
        return r1;
    L32:
        r33 = null;
        goto L33
    }
}
