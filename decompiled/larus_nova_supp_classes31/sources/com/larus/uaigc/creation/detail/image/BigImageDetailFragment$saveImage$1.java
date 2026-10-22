package com.larus.uaigc.creation.detail.image;

import com.larus.bmhome.bigimg.download.ImageDownloadLoadingMgr;
import com.larus.home.impl.sdk.b1;
import com.larus.home.impl.sdk.k1;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.creation.UserCreationFromIM;
import com.larus.uaigc.service.IUgcAIGCService;
import com.larus.uaigc.utils.DataConverterKt;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.creation.detail.image.BigImageDetailFragment$saveImage$1", f = "BigImageDetailFragment.kt", i = {}, l = {1140}, m = "invokeSuspend", n = {}, s = {})
final class BigImageDetailFragment$saveImage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $imageUrl;
    final /* synthetic */ String $messageId;
    int label;
    final /* synthetic */ BigImageDetailFragment this$0;

    /* JADX INFO: renamed from: com.larus.uaigc.creation.detail.image.BigImageDetailFragment$saveImage$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.uaigc.creation.detail.image.BigImageDetailFragment$saveImage$1$1", f = "BigImageDetailFragment.kt", i = {}, l = {1148}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ String $messageId;
        final /* synthetic */ UserCreationFromIM $userCreationIm;
        int label;
        final /* synthetic */ BigImageDetailFragment this$0;

        public AnonymousClass1(UserCreationFromIM r1, BigImageDetailFragment r2, String r3, Continuation<? super AnonymousClass1> r4) {
            this.$userCreationIm = r1;
            this.this$0 = r2;
            this.$messageId = r3;
            super(1, r4);
        }

        public final Continuation<Unit> create(Continuation<?> r5) {
            return new AnonymousClass1(this.$userCreationIm, this.this$0, this.$messageId, r5);
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
            UserCreationFromIM r2 = this.$userCreationIm;
            if (r2 == null) goto L13;
            String r3 = r2.getCreationId();
        L14:
            BigImageDetailFragment r4 = this.this$0;
            int r5 = BigImageDetailFragment.I;
            String r9 = r4.Z90();
            String r10 = this.$messageId;
            this.label = 1;
            if (r8.h1(r3, r9, r10, this) != r0) goto L18;
            return r0;
        L13:
            r3 = null;
            goto L14
        }
    }

    /* JADX INFO: renamed from: com.larus.uaigc.creation.detail.image.BigImageDetailFragment$saveImage$1$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.uaigc.creation.detail.image.BigImageDetailFragment$saveImage$1$3", f = "BigImageDetailFragment.kt", i = {}, l = {1169}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass3 extends SuspendLambda implements Function1<Continuation<? super String>, Object> {
        final /* synthetic */ String $imageResourceKey;
        final /* synthetic */ String $imageUrl;
        final /* synthetic */ String $subScene;
        int label;

        public AnonymousClass3(String r1, String r2, String r3, Continuation<? super AnonymousClass3> r4) {
            this.$subScene = r1;
            this.$imageResourceKey = r2;
            this.$imageUrl = r3;
            super(1, r4);
        }

        public final Continuation<Unit> create(Continuation<?> r5) {
            return new AnonymousClass3(this.$subScene, this.$imageResourceKey, this.$imageUrl, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((Continuation) r1);
        }

        public final Object invoke(Continuation<? super String> r2) {
            return create(r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r13) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r13);
        L11:
            String r14 = (String) r13;
            FLogger.a.i("BigImagePhotoViewer", "onInterceptUrl no-watermark resolve done, changed=" + (true ^ Intrinsics.areEqual(r14, this.$imageUrl)) + ", resolvedUrl=" + r14);
            return r14;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r13);
            FLogger.a.i("BigImagePhotoViewer", "onInterceptUrl no-watermark resolve start, subScene=" + this.$subScene + ", resourceKey=" + this.$imageResourceKey + ", originUrl=" + this.$imageUrl);
            IUgcAIGCService.Companion r4 = IUgcAIGCService.a;
            String r5 = this.$imageUrl;
            String r7 = this.$subScene;
            String r10 = this.$imageResourceKey;
            this.label = 1;
            r13 = r4.D(r5, "Creation", r7, "image", true, r10, this);
            if (r13 != r0) goto L11;
            return r0;
        }
    }

    public BigImageDetailFragment$saveImage$1(BigImageDetailFragment r1, String r2, String r3, Continuation<? super BigImageDetailFragment$saveImage$1> r4) {
        this.this$0 = r1;
        this.$messageId = r2;
        this.$imageUrl = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new BigImageDetailFragment$saveImage$1(this.this$0, this.$messageId, this.$imageUrl, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r11);
    L11:
        final UserCreationFromIM r12 = (UserCreationFromIM) r11;
        IFlowSdkDepend r2 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r2 == null) goto L14;
        r2.D0();
        b1.a.c("profile_creation_thumbnail_download");
    L14:
        BigImageDetailFragment r3 = this.this$0;
        int r4 = BigImageDetailFragment.I;
        Integer r5 = r3.aa0();
        if (r5 == null) goto L17;
        String r6 = DataConverterKt.h(r5.intValue());
    L18:
        if (r6 != null) goto L20;
        r6 = "";
    L20:
        Object r7 = CollectionsKt.firstOrNull(this.this$0.F.a);
        if ((r7 instanceof zo8.b) == false) goto L23;
        zo8.b r8 = (zo8.b) r7;
    L24:
        if (r8 == null) goto L26;
        String r9 = r8.i;
    L27:
        ImageDownloadLoadingMgr r10 = ImageDownloadLoadingMgr.a;
        String r13 = this.$imageUrl;
        if (r12 == null) goto L30;
        iz9.c r14 = iz9.c.a;
        String r15 = this.this$0.Z90();
        r14.getClass();
        Map r16 = iz9.c.e(r12, r15);
    L31:
        AnonymousClass1 r17 = new AnonymousClass1(r12, this.this$0, this.$messageId, null);
        final String r18 = this.$messageId;
        ImageDownloadLoadingMgr.b(r13, r16, r17, new b0(r12, r18), true, new AnonymousClass3(r6, r9, this.$imageUrl, null));
        return Unit.INSTANCE;
    L30:
        r16 = null;
        goto L31
    L26:
        r9 = null;
        goto L27
    L23:
        r8 = null;
        goto L24
    L17:
        r6 = null;
        goto L18
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        BigImageDetailFragment r19 = this.this$0;
        String r20 = this.$messageId;
        this.label = 1;
        int r21 = BigImageDetailFragment.I;
        r11 = r19.ea0(r20, this);
        if (r11 != r0) goto L11;
        return r0;
    }
}
