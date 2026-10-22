package com.obric.aiagent.product.platform.impl.rom;

import android.content.Context;
import com.obric.aiagent.platform.a.d;
import com.obric.aiagent.product.a.b;
import com.obric.aiagent.product.platform.api.rom.IRomInfo;
import com.obric.matrix.platform.sdk.ones.a.e;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.i;
import kotlinx.coroutines.sync.a;
import kotlinx.coroutines.sync.c;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000  2\u00020\u0001:\u0001 B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016J\b\u0010\r\u001a\u00020\u0005H\u0016J\b\u0010\u000e\u001a\u00020\u0007H\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0005H\u0016J\u001c\u0010\u0010\u001a\u00020\u000b2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b0\u0012H\u0016J\u001c\u0010\u0013\u001a\u00020\u000b2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b0\u0012H\u0002J\b\u0010\u0014\u001a\u00020\u000bH\u0002J\b\u0010\u0015\u001a\u00020\u0005H\u0016J\t\u0010\u0016\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0017\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0018\u001a\u00020\u0019H\u0096\u0001J\t\u0010\u001a\u001a\u00020\u0019H\u0096\u0001J\t\u0010\u001b\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001eH\u0096\u0001J\t\u0010\u001f\u001a\u00020\u0007H\u0096\u0001R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/obric/aiagent/product/platform/impl/rom/PacificRomInfoImpl;", "Lcom/obric/aiagent/product/platform/api/rom/IRomInfo;", "<init>", "()V", "sysDeviceId", "", "isMatrixInit", "", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "tryInit", "", "getOSVersion", "getShortOSVersion", "isUTRom", "getOSDeviceIdFromCache", "getOSDeviceIdAsync", "callback", "Lkotlin/Function1;", "getOSDeviceIdAsyncInternal", "initMatrix", "getRomBuildType", "getDeviceBrand", "getDeviceModel", "getFwkApiVersion", "", "getOSReleaseDate", "getRomReleaseRegion", "isOautoModelPreinstalled", "context", "Landroid/content/Context;", "useAssistantApi", "Companion", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PacificRomInfoImpl implements IRomInfo {
    public static final Companion Companion = null;
    private static final String TAG = "PacificRomInfoImpl";
    private final /* synthetic */ CommonRomInfoImpl $$delegate_0;
    private volatile boolean isMatrixInit;
    private final a mutex;
    private volatile String sysDeviceId;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/aiagent/product/platform/impl/rom/PacificRomInfoImpl$Companion;", "", "<init>", "()V", "TAG", "", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.obric.aiagent.product.platform.impl.rom.PacificRomInfoImpl$getOSDeviceIdAsyncInternal$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.aiagent.product.platform.impl.rom.PacificRomInfoImpl$getOSDeviceIdAsyncInternal$1", f = "PacificRomInfoImpl.kt", i = {0}, l = {181}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv"}, s = {"L$0"})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<String, Unit> $callback;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ PacificRomInfoImpl this$0;

        AnonymousClass1(PacificRomInfoImpl r3, Function1<? super String, Unit> r4, Continuation<? super AnonymousClass1> r5) {
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
        public final Object invokeSuspend(Object r11) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            boolean r3 = true;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            final Function1<String, Unit> r2 = (Function1) ZeusTransformUtils.preCheckCast(this.L$2, Function1.class, "com.obric.memorydata.plugin");
            final PacificRomInfoImpl r4 = (PacificRomInfoImpl) ZeusTransformUtils.preCheckCast(this.L$1, PacificRomInfoImpl.class, "com.obric.memorydata.plugin");
            a r10 = (a) ZeusTransformUtils.preCheckCast(this.L$0, a.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r11);
        L43:
            String r12 = PacificRomInfoImpl.access$getSysDeviceId$p(r4);     // Catch: Throwable -> L39
            if (r12 != null) goto L16;
        L23:
            d.f5954a.b(PacificRomInfoImpl.TAG, "getOSDeviceIdAsyncInternal: " + PacificRomInfoImpl.access$isMatrixInit$p(r4));     // Catch: Throwable -> L39
            PacificRomInfoImpl.access$initMatrix(r4);     // Catch: Throwable -> L34
            String r13 = e.f8062a.a().c();     // Catch: Throwable -> L34
            CharSequence r8 = (CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L34
            if (r8 != null) goto L27;
        L30:
            if (r3 == true) goto L32;
            r2.invoke(r13);     // Catch: Throwable -> L34
            PacificRomInfoImpl.access$setSysDeviceId$p(r4, r13);     // Catch: Throwable -> L34
            d.f5954a.b(PacificRomInfoImpl.TAG, "getOSDeviceIdAsyncInternal cache: " + PacificRomInfoImpl.access$getSysDeviceId$p(r4));     // Catch: Throwable -> L34
        L36:
            Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L39
            r10.b(null);
            return Unit.INSTANCE;
        L32:
            e.f8062a.a().a((com.obric.matrix.platform.sdk.ones.a.a) ZeusTransformUtils.preCheckCast(new PacificRomInfoImpl$getOSDeviceIdAsyncInternal$1$1$2(r2, r4), com.obric.matrix.platform.sdk.ones.a.a.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L34
            goto L36
        L27:
            if (StringsKt.isBlank(r8) == true) goto L30;
            r3 = false;
        L34:
            th = move-exception;
            r2.invoke("");     // Catch: Throwable -> L39
            d.f5954a.b(PacificRomInfoImpl.TAG, "getOSDeviceIdAsyncInternal crash", th);     // Catch: Throwable -> L39
            goto L36
        L16:
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L18;
            boolean r9 = true;
        L19:
            if (r9 == false) goto L23;
            r2.invoke(r12);     // Catch: Throwable -> L39
            d.f5954a.b(PacificRomInfoImpl.TAG, "getOSDeviceIdAsyncInternal cache: " + PacificRomInfoImpl.access$getSysDeviceId$p(r4));     // Catch: Throwable -> L39
            Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L39
            r10.b(null);
            return r15;
        L18:
            r9 = false;
        L39:
            th = move-exception;
            r10.b(null);
            throw th;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r11);
            a r16 = PacificRomInfoImpl.access$getMutex$p(this.this$0);
            r4 = this.this$0;
            Function1<String, Unit> r5 = this.$callback;
            Continuation<? super Unit> r6 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.L$0 = r16;
            this.L$1 = r4;
            this.L$2 = r5;
            this.label = 1;
            if (r16.a(null, r6) != r0) goto L11;
            return r0;
        L11:
            r10 = r16;
            r2 = r5;
            goto L43
        }
    }

    static {
        Companion = new Companion(null);
    }

    public PacificRomInfoImpl() {
        this.$$delegate_0 = new CommonRomInfoImpl();
        this.mutex = c.a(false, 1, null);
    }

    public static final /* synthetic */ a access$getMutex$p(PacificRomInfoImpl r0) {
        return r0.mutex;
    }

    public static final /* synthetic */ String access$getSysDeviceId$p(PacificRomInfoImpl r0) {
        return r0.sysDeviceId;
    }

    public static final /* synthetic */ void access$initMatrix(PacificRomInfoImpl r0) {
        r0.initMatrix();
    }

    public static final /* synthetic */ boolean access$isMatrixInit$p(PacificRomInfoImpl r0) {
        return r0.isMatrixInit;
    }

    public static final /* synthetic */ void access$setSysDeviceId$p(PacificRomInfoImpl r0, String r1) {
        r0.sysDeviceId = r1;
    }

    private final void getOSDeviceIdAsyncInternal(Function1<? super String, Unit> r9) {
        Function1 r10 = (Function1) ZeusTransformUtils.wrapperContextForParams(r9, Function1.class, "com.obric.memorydata.plugin");
        i.a(am.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin")), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this, r10, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    private final void initMatrix() {
        d.f5954a.b(TAG, "initMatrix: " + this.isMatrixInit);
        if (this.isMatrixInit == false) goto L5;
        return;
    L5:
        e.f8062a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.obric.aiagent.platform.a.a.f5948a.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), new com.obric.matrix.platform.sdk.ones.a.d.a().a(com.obric.aiagent.platform.a.a.f5948a.b()).a(com.obric.aiagent.platform.a.a.f5948a.c()).b(com.obric.aiagent.platform.a.a.f5948a.d()).a(false).a());
        this.isMatrixInit = true;
    }

    public static /* synthetic */ Unit lambda$ZUg1W9qgolSIOPIsSr2tdwMbOGc(String r0) {
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
    public void getOSDeviceIdAsync(Function1<? super String, Unit> r3) {
        Function1<? super String, Unit> r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "callback");
        getOSDeviceIdAsyncInternal(r4);
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public String getOSDeviceIdFromCache() {
        d.f5954a.b(TAG, "getOSDeviceIdFromCache cache: " + this.sysDeviceId);
        return this.sysDeviceId;
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public int getOSReleaseDate() {
        return this.$$delegate_0.getOSReleaseDate();
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public String getOSVersion() {
        return com.obric.aiagent.product.a.c.f5967a.a("ro.os.ota.version", "");
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public String getRomBuildType() {
        String r8 = com.obric.aiagent.product.a.c.f5967a.a("ro.os.ota.version", "");
        String r3 = "userroot";
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("userroot", CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == false) goto L6;
    L12:
        d.f5954a.b(TAG, "getRomBuildType: buildType " + r3);
        return r3;
    L6:
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("userdebug", CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == false) goto L9;
        r3 = "userdebug";
        goto L12
    L9:
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("user", CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == false) goto L11;
        r3 = "user";
        goto L12
    L11:
        r3 = "unknown";
        goto L12
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public String getRomReleaseRegion() {
        return this.$$delegate_0.getRomReleaseRegion();
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public String getShortOSVersion() {
        String r4 = com.obric.aiagent.product.a.c.f5967a.a("ro.os.ota.version", "");
        String r0 = b.f5965a.c(r4);
        d.f5954a.b(TAG, "getShortOSVersion: fullVersion " + r4 + ", shortVersion " + r0);
        return r0;
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public boolean isOautoModelPreinstalled(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "context");
        return this.$$delegate_0.isOautoModelPreinstalled(r4);
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public boolean isUTRom() {
        String r6 = com.obric.aiagent.product.a.c.f5967a.a("ro.os.ota.version", "");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L30;
        List<String> r7 = new Regex("-").split((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin"), 0);
        if (r7.isEmpty() == true) goto L18;
        ListIterator<String> r1 = r7.listIterator(r7.size());
    L11:
        if (r1.hasPrevious() == false) goto L18;
        if (((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r1.previous(), String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L15;
        boolean r4 = true;
    L16:
        if (r4 == true) goto L11;
        List r8 = CollectionsKt.take((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin"), r1.nextIndex() + 1);
    L19:
        String[] r9 = (String[]) ZeusTransformUtils.preCheckCast(((Collection) ZeusTransformUtils.preCheckCast(r8, Collection.class, "com.obric.memorydata.plugin")).toArray(new String[0]), String[].class, "com.obric.memorydata.plugin");
        if (r9.length != 0) goto L22;
        boolean r2 = true;
    L24:
        if ((!r2) == false) goto L30;
        if (r9.length <= 1) goto L30;
        if (StringsKt.startsWith$default(r9[1], "ut", false, 2, null) == false) goto L30;
        return true;
    L22:
        r2 = false;
        goto L24
    L15:
        r4 = false;
    L18:
        r8 = CollectionsKt.emptyList();
    L30:
        return false;
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public void tryInit() {
        getOSDeviceIdAsyncInternal($$Lambda$PacificRomInfoImpl$ZUg1W9qgolSIOPIsSr2tdwMbOGc.INSTANCE);
    }

    @Override // com.obric.aiagent.product.platform.api.rom.IRomInfo
    public boolean useAssistantApi() {
        return this.$$delegate_0.useAssistantApi();
    }
}
