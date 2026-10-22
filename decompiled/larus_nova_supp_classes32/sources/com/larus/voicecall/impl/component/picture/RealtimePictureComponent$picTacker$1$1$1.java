package com.larus.voicecall.impl.component.picture;

import android.net.Uri;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.camera.api.IFlowCamera;
import com.larus.camera.api.params.OutputParam;
import com.larus.platform.service.z2;
import com.larus.platform.spi.IAIChatUploadMediaService;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.impl.subtitle.RealtimeCallSubtitleLayout;
import com.larus.voicecall.impl.util.v0;
import com.obric.aivoice.core.data.NameKeys;
import ic8.m0;
import ic8.n0;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voicecall.impl.component.picture.RealtimePictureComponent$picTacker$1$1$1", f = "RealtimePictureComponent.kt", i = {3}, l = {151, 161, 170, 178, 190}, m = "invokeSuspend", n = {"imageWrapper"}, s = {"L$0"})
public final class RealtimePictureComponent$picTacker$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ OutputParam $outputParam;
    final /* synthetic */ IFlowCamera $takePictureService;
    Object L$0;
    int label;
    final /* synthetic */ RealtimePictureComponent this$0;

    /* JADX INFO: renamed from: com.larus.voicecall.impl.component.picture.RealtimePictureComponent$picTacker$1$1$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.voicecall.impl.component.picture.RealtimePictureComponent$picTacker$1$1$1$1", f = "RealtimePictureComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends String>>, Object> {
        final /* synthetic */ x3a.a $imageWrapper;
        final /* synthetic */ IFlowCamera $takePictureService;
        int label;
        final /* synthetic */ RealtimePictureComponent this$0;

        public AnonymousClass1(RealtimePictureComponent r1, x3a.a r2, IFlowCamera r3, Continuation<? super AnonymousClass1> r4) {
            this.this$0 = r1;
            this.$imageWrapper = r2;
            this.$takePictureService = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new AnonymousClass1(this.this$0, this.$imageWrapper, this.$takePictureService, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super List<String>> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L18;
            ResultKt.throwOnFailure(r2);
            RealtimePictureComponent r3 = this.this$0;
            int r0 = RealtimePictureComponent.B;
            g3a.a r4 = r3.p3();
            if (r4 == null) goto L9;
            RealtimeCallSubtitleLayout r5 = r4.ol();
            if (r5 == null) goto L9;
            r5.setScrollToEndDirectly(true);
        L9:
            com.larus.voicecall.impl.component.subtitle.a r6 = this.this$0.C3();
            if (r6 == null) goto L12;
            r6.Va(CollectionsKt.listOf(this.$imageWrapper));
        L12:
            String r7 = this.$imageWrapper.a.e;
            if (r7 != null) goto L19;
            return null;
        L19:
            return this.$takePictureService.z(CollectionsKt.listOf(r7));
        L18:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public RealtimePictureComponent$picTacker$1$1$1(RealtimePictureComponent r1, OutputParam r2, IFlowCamera r3, Continuation<? super RealtimePictureComponent$picTacker$1$1$1> r4) {
        this.this$0 = r1;
        this.$outputParam = r2;
        this.$takePictureService = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new RealtimePictureComponent$picTacker$1$1$1(this.this$0, this.$outputParam, this.$takePictureService, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r21) {
        Object r9 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L16;
        if (r0 == 1) goto L15;
        if (r0 == 2) goto L14;
        if (r0 == 3) goto L13;
        if (r0 == 4) goto L12;
        if (r0 != 5) goto L11;
        ResultKt.throwOnFailure(r21);
    L53:
        return Unit.INSTANCE;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        x3a.a r1 = (x3a.a) this.L$0;
        ResultKt.throwOnFailure(r21);
    L46:
        RealtimePictureComponent r2 = this.this$0;
        int r3 = RealtimePictureComponent.B;
        if (((h88.a) r2.m3()).k0 == false) goto L49;
        this.this$0.G3(r1);
        goto L53
    L49:
        RealtimePictureComponent r4 = this.this$0;
        OutputParam r5 = this.$outputParam;
        this.L$0 = null;
        this.label = 5;
        if (RealtimePictureComponent.h3(r4, r1, r5, this) != r9) goto L53;
        return r9;
    L13:
        ResultKt.throwOnFailure(r21);
        Object r6 = r21;
    L36:
        n0 r7 = (n0) r6;
    L41:
        m0 r8 = r7.a;
        if (r8 == null) goto L55;
        r1 = v0.b(r8, this.$outputParam.getDataSource());
        MainCoroutineDispatcher r10 = Dispatchers.getMain();
        AnonymousClass1 r11 = new AnonymousClass1(this.this$0, r1, this.$takePictureService, null);
        this.L$0 = r1;
        this.label = 4;
        if (BuildersKt.withContext(r10, r11, this) != r9) goto L46;
        return r9;
    L55:
        return Unit.INSTANCE;
    L14:
        ResultKt.throwOnFailure(r21);
        Object r12 = r21;
    L40:
        r7 = (n0) r12;
        goto L41
    L15:
        ResultKt.throwOnFailure(r21);
    L24:
        z2 r13 = z2.a;
        ns8.a r14 = new ns8.a(r13.getAppImageUploadConfig().b(), null, r13.getAppImageUploadConfig().c(), null, r13.d2(), 232);
        int r15 = this.$outputParam.getDataSource();
        if (r15 == 0) goto L37;
        if (r15 != 1) goto L28;
        PolarisFileWrapper r16 = new PolarisFileWrapper(this.$outputParam.getPath());
        if (r16.exists() == true) goto L33;
        FLogger.a.e("RealtimePictureComponent", "take photo from album, path is empty!");
        return Unit.INSTANCE;
    L33:
        Uri r17 = Uri.fromFile(r16);
        IAIChatUploadMediaService.Companion r18 = IAIChatUploadMediaService.a;
        Intrinsics.checkNotNull(r17);
        this.label = 3;
        r6 = IAIChatUploadMediaService.a.a(r18, r17, r14, true, false, null, this, 56);
        if (r6 != r9) goto L36;
        return r9;
    L28:
        return Unit.INSTANCE;
    L37:
        IAIChatUploadMediaService.Companion r19 = IAIChatUploadMediaService.a;
        String r20 = this.$outputParam.getPath();
        this.label = 2;
        r12 = r19.b(r20, r14, null, this);
        if (r12 != r9) goto L40;
        return r9;
    L16:
        ResultKt.throwOnFailure(r21);
        RealtimePictureComponent r22 = this.this$0;
        int r23 = RealtimePictureComponent.B;
        if (((h88.a) r22.m3()).k0 == true) goto L24;
        RealtimePictureComponent r24 = this.this$0;
        OutputParam r25 = this.$outputParam;
        this.label = 1;
        r24.getClass();
        Object r26 = BuildersKt.withContext(Dispatchers.getMain(), new RealtimePictureComponent$prepareForAni$2(r24, r25, null), this);
        if (r26 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L22;
        r26 = Unit.INSTANCE;
    L22:
        if (r26 != r9) goto L24;
        return r9;
    }
}
