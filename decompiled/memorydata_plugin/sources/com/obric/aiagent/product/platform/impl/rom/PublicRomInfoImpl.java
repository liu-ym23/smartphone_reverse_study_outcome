package com.obric.aiagent.product.platform.impl.rom;

import android.content.Context;
import com.obric.aiagent.platform.a.d;
import com.obric.aiagent.product.platform.api.rom.IRomInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.i;
import kotlinx.coroutines.sync.a;
import kotlinx.coroutines.sync.c;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0016J\n\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0016J\u001c\u0010\u000b\u001a\u00020\t2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\rH\u0016J\t\u0010\u000e\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u000f\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0010\u001a\u00020\u0011H\u0096\u0001J\t\u0010\u0012\u001a\u00020\u0011H\u0096\u0001J\t\u0010\u0013\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0014\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0015\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0016\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0096\u0001J\t\u0010\u001b\u001a\u00020\u0018H\u0096\u0001J\t\u0010\u001c\u001a\u00020\u0018H\u0096\u0001R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/obric/aiagent/product/platform/impl/rom/PublicRomInfoImpl;", "Lcom/obric/aiagent/product/platform/api/rom/IRomInfo;", "<init>", "()V", "sysDeviceId", "", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "tryInit", "", "getOSDeviceIdFromCache", "getOSDeviceIdAsync", "callback", "Lkotlin/Function1;", "getDeviceBrand", "getDeviceModel", "getFwkApiVersion", "", "getOSReleaseDate", "getOSVersion", "getRomBuildType", "getRomReleaseRegion", "getShortOSVersion", "isOautoModelPreinstalled", "", "context", "Landroid/content/Context;", "isUTRom", "useAssistantApi", "Companion", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PublicRomInfoImpl implements IRomInfo {
    public static final Companion Companion = null;
    private static final String TAG = "PublicRomInfoImpl";
    private final /* synthetic */ CommonRomInfoImpl $$delegate_0;
    private final a mutex;
    private volatile String sysDeviceId;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/aiagent/product/platform/impl/rom/PublicRomInfoImpl$Companion;", "", "<init>", "()V", "TAG", "", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.obric.aiagent.product.platform.impl.rom.PublicRomInfoImpl$getOSDeviceIdAsync$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.aiagent.product.platform.impl.rom.PublicRomInfoImpl$getOSDeviceIdAsync$1", f = "PublicRomInfoImpl.kt", i = {0}, l = {84}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv"}, s = {"L$0"})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<String, Unit> $callback;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ PublicRomInfoImpl this$0;

        AnonymousClass1(PublicRomInfoImpl r3, Function1<? super String, Unit> r4, Continuation<? super AnonymousClass1> r5) {
            Function1<String, Unit> r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
            Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            this.$callback = r6;
            super(2, r7);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.this$0, this.$callback, r5), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r8) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            final PublicRomInfoImpl r2 = (PublicRomInfoImpl) ZeusTransformUtils.preCheckCast(this.L$2, PublicRomInfoImpl.class, "com.obric.memorydata.plugin");
            final Function1<String, Unit> r3 = (Function1) ZeusTransformUtils.preCheckCast(this.L$1, Function1.class, "com.obric.memorydata.plugin");
            a r7 = (a) ZeusTransformUtils.preCheckCast(this.L$0, a.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r8);
        L22:
            com.obric.matrixpro.sdk.deviceinfoclient.a.f8260a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.obric.aiagent.platform.a.a.f5948a.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), (com.obric.matrixpro.sdk.deviceinfoclient.a.InterfaceC0407a) ZeusTransformUtils.preCheckCast(new PublicRomInfoImpl$getOSDeviceIdAsync$1$1$1(r2, r3), com.obric.matrixpro.sdk.deviceinfoclient.a.InterfaceC0407a.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L14
        L16:
            Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L19
            r7.b(null);
            return Unit.INSTANCE;
        L14:
            th = move-exception;
            r3.invoke("");     // Catch: Throwable -> L19
            d.f5954a.b(PublicRomInfoImpl.TAG, "catch getOSDeviceIdAsync crash", th);     // Catch: Throwable -> L19
        L19:
            th = move-exception;
            r7.b(null);
            throw th;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r8);
            a r10 = PublicRomInfoImpl.access$getMutex$p(this.this$0);
            r3 = this.$callback;
            PublicRomInfoImpl r5 = this.this$0;
            Continuation<? super Unit> r6 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.L$0 = r10;
            this.L$1 = r3;
            this.L$2 = r5;
            this.label = 1;
            if (r10.a(null, r6) != r0) goto L11;
            return r0;
        L11:
            r7 = r10;
            r2 = r5;
            goto L22
        }
    }

    static {
        Companion = new Companion(null);
    }

    public PublicRomInfoImpl() {
        this.$$delegate_0 = new CommonRomInfoImpl();
        this.mutex = c.a(false, 1, null);
    }

    public static final /* synthetic */ a access$getMutex$p(PublicRomInfoImpl r0) {
        return r0.mutex;
    }

    public static final /* synthetic */ String access$getSysDeviceId$p(PublicRomInfoImpl r0) {
        return r0.sysDeviceId;
    }

    public static final /* synthetic */ void access$setSysDeviceId$p(PublicRomInfoImpl r0, String r1) {
        r0.sysDeviceId = r1;
    }

    public static /* synthetic */ Unit lambda$UdVzHQMEyv9gzMoo9qNoBzd1g60(String r0) {
        return tryInit$lambda$0(r0);
    }

    private static final Unit tryInit$lambda$0(String r1) {
        Intrinsics.checkNotNullParameter(r1, "it");
        return Unit.INSTANCE;
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public String getDeviceBrand() {
        return this.$$delegate_0.getDeviceBrand();
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public String getDeviceModel() {
        return this.$$delegate_0.getDeviceModel();
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public int getFwkApiVersion() {
        return this.$$delegate_0.getFwkApiVersion();
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public void getOSDeviceIdAsync(Function1<? super String, Unit> r9) {
        Function1 r10 = (Function1) ZeusTransformUtils.wrapperContextForParams(r9, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, "callback");
        i.a(am.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin")), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this, r10, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public String getOSDeviceIdFromCache() {
        d.f5954a.b(TAG, "getOSDeviceIdFromCache: " + this.sysDeviceId);
        return this.sysDeviceId;
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public int getOSReleaseDate() {
        return this.$$delegate_0.getOSReleaseDate();
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public String getOSVersion() {
        return this.$$delegate_0.getOSVersion();
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public String getRomBuildType() {
        return this.$$delegate_0.getRomBuildType();
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public String getRomReleaseRegion() {
        return this.$$delegate_0.getRomReleaseRegion();
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public String getShortOSVersion() {
        return this.$$delegate_0.getShortOSVersion();
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public boolean isOautoModelPreinstalled(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "context");
        return this.$$delegate_0.isOautoModelPreinstalled(r4);
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public boolean isUTRom() {
        return this.$$delegate_0.isUTRom();
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public void tryInit() {
        getOSDeviceIdAsync($$Lambda$PublicRomInfoImpl$UdVzHQMEyv9gzMoo9qNoBzd1g60.INSTANCE);
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public boolean useAssistantApi() {
        return this.$$delegate_0.useAssistantApi();
    }
}
