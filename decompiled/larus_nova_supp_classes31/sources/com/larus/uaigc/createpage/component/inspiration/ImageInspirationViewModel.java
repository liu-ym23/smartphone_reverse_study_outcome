package com.larus.uaigc.createpage.component.inspiration;

import com.bytedance.keva.Keva;
import com.google.gson.reflect.TypeToken;
import com.larus.bmhome.instruction.repo.CreativityInspirationApi;
import com.larus.bmhome.instruction.repo.InspireScene;
import com.larus.network.FlowHttpConnection;
import com.larus.network.http.HttpExtKt;
import com.larus.platform.service.AccountService;
import com.larus.uaigc.api.ReviewUgcImageApi;
import com.larus.ui.arch.vm.ComponentViewModel;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0086@¢\u0006\u0002\u0010\u0015J\u0016\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0006H\u0086@¢\u0006\u0002\u0010\u0018J.\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\u00062\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\b\u0001\u0010\u001e\u001a\u00020\u001fH\u0002J$\u0010 \u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001a\u001a\u00020\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\u00062\b\b\u0001\u0010\u001e\u001a\u00020\u001fJ*\u0010!\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001e\u001a\u00020\u001fH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR#\u0010$\u001a\n &*\u0004\u0018\u00010%0%8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b'\u0010(¨\u0006+"}, d2 = {"Lcom/larus/uaigc/createpage/component/inspiration/ImageInspirationViewModel;", "Lcom/larus/ui/arch/vm/ComponentViewModel;", "Lcom/larus/uaigc/createpage/component/inspiration/ImageInspirationState;", "<init>", "()V", "tag", "", "_imgInspirationState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "imgInspirationState", "Lkotlinx/coroutines/flow/StateFlow;", "getImgInspirationState", "()Lkotlinx/coroutines/flow/StateFlow;", "_imgFaceDetectedState", "Lcom/larus/uaigc/createpage/component/inspiration/ImageFaceDetectState;", "imgFaceDetectedState", "getImgFaceDetectedState", "requestImgInspireRequest", "", "request", "Lcom/larus/bmhome/instruction/repo/CreativityInspireRequest;", "(Lcom/larus/bmhome/instruction/repo/CreativityInspireRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestFaceDetected", "imageUri", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateLocalCache", "langCode", "botId", "imgInspirePromptData", "Lcom/larus/bmhome/instruction/repo/ImgInspirePromptData;", "scene", "", "getLocalCache", "getCacheKey", "curUid", "lang", "cache", "Lcom/bytedance/keva/Keva;", "kotlin.jvm.PlatformType", "getCache", "()Lcom/bytedance/keva/Keva;", "cache$delegate", "Lkotlin/Lazy;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class ImageInspirationViewModel extends ComponentViewModel<ImageInspirationState> {
    private z0<g> _imgFaceDetectedState;
    private final z0<ImageInspirationState> _imgInspirationState;
    private final Lazy cache$delegate;
    private final i1<g> imgFaceDetectedState;
    private final i1<ImageInspirationState> imgInspirationState;
    private final String tag;

    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"com/larus/uaigc/createpage/component/inspiration/ImageInspirationViewModel$getLocalCache$1", "Lcom/google/gson/reflect/TypeToken;", "Lcom/larus/bmhome/instruction/repo/ImgInspirePromptData;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public static final class a extends TypeToken<fq8.f> {
        public a() {
        }
    }

    /* JADX INFO: renamed from: com.larus.uaigc.createpage.component.inspiration.ImageInspirationViewModel$requestFaceDetected$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.uaigc.createpage.component.inspiration.ImageInspirationViewModel", f = "ImageInspirationViewModel.kt", i = {}, l = {68}, m = "requestFaceDetected", n = {}, s = {})
    public static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ ImageInspirationViewModel this$0;

        public AnonymousClass1(ImageInspirationViewModel r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.requestFaceDetected(null, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.uaigc.createpage.component.inspiration.ImageInspirationViewModel$requestImgInspireRequest$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.uaigc.createpage.component.inspiration.ImageInspirationViewModel", f = "ImageInspirationViewModel.kt", i = {0}, l = {37}, m = "requestImgInspireRequest", n = {"request"}, s = {"L$0"})
    public static final class C01541 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ ImageInspirationViewModel this$0;

        public C01541(ImageInspirationViewModel r1, Continuation<? super C01541> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.requestImgInspireRequest(null, this);
        }
    }

    public static /* synthetic */ Keva No() {
        return cache_delegate$lambda$0();
    }

    private static final Keva cache_delegate$lambda$0() {
        return Keva.getRepo("image_inspiration_config");
    }

    private final Keva getCache() {
        return (Keva) this.cache$delegate.getValue();
    }

    public ImageInspirationViewModel() {
        this.tag = "ImageInspirationViewModel-" + hashCode() + '}';
        StateFlowImpl r0 = j1.a(new ImageInspirationState(null, null, null, 7, null));
        this._imgInspirationState = r0;
        this.imgInspirationState = kotlinx.coroutines.flow.e.b(r0);
        StateFlowImpl r1 = j1.a(new g(0));
        this._imgFaceDetectedState = r1;
        this.imgFaceDetectedState = kotlinx.coroutines.flow.e.b(r1);
        this.cache$delegate = LazyKt.lazy(new h());
    }

    public final i1<g> getImgFaceDetectedState() {
        return this.imgFaceDetectedState;
    }

    public final i1<ImageInspirationState> getImgInspirationState() {
        return this.imgInspirationState;
    }

    public final Object requestFaceDetected(String r7, Continuation<? super Unit> r8) {
        if ((r8 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) r8;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        Boolean r4 = null;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r9);
    L17:
        dm9.a.b r10 = (dm9.a) r9;
        if ((r10 instanceof dm9.a.b) == false) goto L34;
        dm9.a.b r11 = r10;
        if (r11.a.isSuccess() == false) goto L32;
        z0<g> r12 = this._imgFaceDetectedState;
        ReviewUgcImageApi.c r5 = (ReviewUgcImageApi.c) r11.a.getData();
        if (r5 == null) goto L24;
        boolean r6 = Intrinsics.areEqual(r5.b(), Boxing.boxBoolean(true));
    L25:
        if (r6 == false) goto L27;
        g r13 = new g(true, System.currentTimeMillis());
    L28:
        r12.setValue(r13);
        FLogger r14 = FLogger.a;
        String r15 = this.tag;
        StringBuilder r16 = new StringBuilder("faceDetected ");
        ReviewUgcImageApi.c r17 = (ReviewUgcImageApi.c) r11.a.getData();
        if (r17 == null) goto L31;
        r4 = r17.b();
    L31:
        r16.append(r4);
        r16.append(" imgFaceDetectedState is ");
        r16.append(this._imgFaceDetectedState.getValue());
        r14.d(r15, r16.toString());
    L37:
        return Unit.INSTANCE;
    L27:
        r13 = new g(false, System.currentTimeMillis());
        goto L28
    L24:
        r6 = false;
        goto L25
    L32:
        FLogger.a.e(this.tag, "failed in fetch template list code " + r11.a.getCode() + " message " + r11.a.getMsg());
        goto L37
    L34:
        if ((r10 instanceof dm9.a.a) == false) goto L37;
        FLogger.a.e(this.tag, "failed in fetch template list remote " + ((dm9.a.a) r10).c);
        goto L37
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r9);
        ReviewUgcImageApi.Companion r18 = ReviewUgcImageApi.a;
        ImageInspirationViewModel$requestFaceDetected$result$1 r19 = new ImageInspirationViewModel$requestFaceDetected$result$1(r7, null);
        r0.label = 1;
        r18.getClass();
        r9 = ReviewUgcImageApi.Companion.a(r19, r0);
        if (r9 != r2) goto L17;
        return r2;
    L7:
        r0 = new AnonymousClass1(this, r8);
        goto L8
    }

    public final Object requestImgInspireRequest(fq8.c r12, Continuation<? super Unit> r13) {
        if ((r13 instanceof C01541) == false) goto L7;
        C01541 r0 = (C01541) r13;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        C01541 r8 = r0;
        Object r14 = r8.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r8.label;
        List r10 = null;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r12 = (fq8.c) r8.L$0;
        ResultKt.throwOnFailure(r14);
    L17:
        dm9.a.b r15 = (dm9.a) r14;
        if ((r15 instanceof dm9.a.b) == false) goto L45;
        dm9.a.b r16 = r15;
        if (r16.a.isSuccess() == false) goto L43;
        z0<ImageInspirationState> r4 = this._imgInspirationState;
        int r5 = r12.c();
        fq8.b r6 = (fq8.b) r16.a.getData();
        if (r6 == null) goto L26;
        fq8.f r7 = r6.a();
        if (r7 == null) goto L26;
        Map r9 = r7.a();
    L27:
        fq8.b r11 = (fq8.b) r16.a.getData();
        if (r11 == null) goto L32;
        fq8.f r17 = r11.a();
        if (r17 == null) goto L32;
        List r18 = r17.b();
    L33:
        r4.setValue(new ImageInspirationState(Boxing.boxInt(r5), r18, r9));
        String r19 = r12.a();
        String r20 = String.valueOf(r12.b());
        fq8.b r21 = (fq8.b) r16.a.getData();
        if (r21 == null) goto L36;
        fq8.f r22 = r21.a();
    L37:
        updateLocalCache(r20, r19, r22, r12.c());
        FLogger r110 = FLogger.a;
        String r23 = this.tag;
        StringBuilder r24 = new StringBuilder("inspirationList ");
        fq8.b r111 = (fq8.b) r16.a.getData();
        if (r111 == null) goto L42;
        fq8.f r112 = r111.a();
        if (r112 == null) goto L42;
        r10 = r112.b();
    L42:
        r24.append(r10);
        r110.d(r23, r24.toString());
    L48:
        return Unit.INSTANCE;
    L36:
        r22 = null;
    L32:
        r18 = null;
    L26:
        r9 = null;
        goto L27
    L43:
        FLogger.a.e(this.tag, "failed in fetch inspirationList  code " + r16.a.getCode() + " message " + r16.a.getMsg());
        goto L48
    L45:
        if ((r15 instanceof dm9.a.a) == false) goto L48;
        FLogger.a.e(this.tag, "failed in fetch inspirationList remote " + ((dm9.a.a) r15).c);
        goto L48
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r14);
        CreativityInspirationApi.a r113 = CreativityInspirationApi.a;
        ImageInspirationViewModel$requestImgInspireRequest$result$1 r25 = new ImageInspirationViewModel$requestImgInspireRequest$result$1(r12, null);
        r8.L$0 = r12;
        r8.label = 1;
        r113.getClass();
        FlowHttpConnection r114 = FlowHttpConnection.a;
        r14 = FlowHttpConnection.g("Social", CreativityInspirationApi.class, r25, false, null, null, null, r8, 248);
        if (r14 != r2) goto L17;
        return r2;
    L7:
        r0 = new C01541(this, r13);
        goto L8
    }

    public final fq8.f getLocalCache(String r4, String r5, @InspireScene int r6) {
        Intrinsics.checkNotNullParameter(r4, "langCode");
        if (r5 != null) goto L5;
        return null;
    L5:
        String r7 = getCacheKey(AccountService.a.getUserId(), r4, r5, r6);
        FLogger r8 = FLogger.a;
        r8.i(this.tag, "getCacheConfig, cacheKey=" + r7);
        String r9 = getCache().getString(r7, "");
        if (r9 != null) goto L8;
    L11:
        boolean r10 = true;
    L12:
        if (r10 == false) goto L20;
        r8.i(this.tag, "getCacheConfig, has no cache");
        return null;
    L20:
        return (fq8.f) HttpExtKt.f.fromJson(r9, new a().getType());
    L17:
        e = move-exception;
        FLogger.a.e(this.tag, "getCacheConfig, err.msg=" + e.getMessage());
        return null;
    L8:
        if (r9.length() == 0) goto L11;
        r10 = false;
        goto L12
    }

    private final String getCacheKey(String r2, String r3, String r4, int r5) {
        return r2 + '-' + r3 + '-' + r4 + '-' + r5;
    }

    private final void updateLocalCache(String r3, String r4, fq8.f r5, @InspireScene int r6) {
        String r7 = getCacheKey(AccountService.a.getUserId(), r3, r4, r6);
        FLogger.a.i(this.tag, "updateLocalCache, cacheKey=" + r7);
        getCache().storeString(r7, HttpExtKt.f.toJson(r5));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        FLogger.a.e(this.tag, "save cache error=" + e.getMessage());
    }
}
