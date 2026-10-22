package com.obric.memorydata.middleware.impl.device;

import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.bytedance.crash.entity.EventBody;
import com.obric.aikernel.phx.sdk.AIKernelManager;
import com.obric.aikernel.phx.sdk.IAIKernelManager;
import com.obric.aikernel.sdk.config.RequestParams;
import com.obric.aikernel.sdk.data.PackageResource;
import com.obric.aikernel.sdk.ext.ParamsKt;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.device.IDeviceInfoState;
import com.obric.memorydata.middleware.api.device.SelfCollectionSupportType;
import com.obric.memorydata.middleware.api.device.b;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.settings.ProductPlatformConstantsKt;
import com.obric.memorydata.middleware.api.store.IStore;
import com.obric.memorydata.middleware.api.store.IStoreManager;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.obric.memorydata.utils.am;
import com.obric.memorydata.utils.c;
import com.obric.memorydata.utils.handler.GlobalHandlerUtil;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.al;
import kotlinx.coroutines.flow.ae;
import kotlinx.coroutines.flow.ar;
import kotlinx.coroutines.flow.at;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010,\u001a\u00020\u0000H\u0007J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010-\u001a\u00020#H\u0016J\u000e\u0010.\u001a\u0004\u0018\u00010#*\u00020/H\u0002J\f\u00100\u001a\u000201*\u00020\u0005H\u0002J\b\u0010\u0016\u001a\u00020\u0014H\u0016J\b\u0010\u0018\u001a\u00020\u0014H\u0016J\u0010\u00102\u001a\u0002032\u0006\u00104\u001a\u000205H\u0002J\b\u00106\u001a\u00020\u0014H\u0016J\b\u0010$\u001a\u00020\u0014H\u0016J\b\u00107\u001a\u00020\u0014H\u0002J\b\u00108\u001a\u00020\u0014H\u0002J\b\u00109\u001a\u00020\u0014H\u0002J\b\u0010:\u001a\u00020\u0005H\u0016J\b\u0010;\u001a\u00020\u0014H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0015R\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0015R$\u0010\u0018\u001a\u0004\u0018\u00010\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0014@BX\u0082\u000e¢\u0006\n\n\u0002\u0010\u0015\"\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u001eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0012\u0010!\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0015R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010$\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0015R\u000e\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020&X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020&X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020&X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020&X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020&X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lcom/obric/memorydata/middleware/impl/device/DeviceInfoStateImpl;", "Lcom/obric/memorydata/middleware/api/device/IDeviceInfoState;", "<init>", "()V", "KEY_OF_IS_OBRIC_OS_DEVICE", "", "KEY_OF_IS_AI_KERNEL_AVAILABLE", "KEY_OF_IS_SUPPORT_VLM", "KEY_OF_IS_SUPPORT_VLM_EMBEDDING", "KEY_OF_SELF_COLLECTION_SUPPORT_TYPE", "KEY_OF_SELF_COLLECTION_SUPPORTED_TYPES", "KEY_OF_SELF_COLLECTION_CONTACT_PKG", "KEY_OF_SELF_COLLECTION_CALL_PKG", "KEY_OF_SELF_COLLECTION_MESSAGE_PKG", "KEY_OF_SELF_COLLECTION_PHOTO_PKG", "KEY_OF_SELF_COLLECTION_FILE_PKG", "KEY_OF_SELF_COLLECTION_SCHEDULE_PKG", "KEY_OF_IS_GLOBAL_MEMORY_DISABLED", "TAG", "isObricOsDevice", "", "Ljava/lang/Boolean;", "isAIKernelAvailable", EventBody.KEY_VALUE, "isSupportVLM", "setSupportVLM", "(Ljava/lang/Boolean;)V", "mutableVlmSupportState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "vlmSupportState", "Lkotlinx/coroutines/flow/StateFlow;", "getVlmSupportState", "()Lkotlinx/coroutines/flow/StateFlow;", "isSupportVlmEmbedding", "selfCollectionSupport", "Lcom/obric/memorydata/middleware/api/device/SelfCollectionConfig;", "isGlobalMemoryDisabled", "obricOsDevicelock", "Ljava/util/concurrent/locks/ReentrantLock;", "aiKernelAvailableLock", "supportVlmLock", "supportVlmEmbeddingLock", "selfCollectionSupportLock", "globalMemoryDisabledLock", "getInst", "getSelfCollectionEntitySupport", "getSelfCollectionConfig", "Lcom/obric/aiagent/product/feature/api/IFeatureService;", "toType", "Lcom/obric/memorydata/middleware/api/device/SelfCollectionSupportType;", "retryGetVlmState", "", "currentCount", "", "isSupportVLMEmbedding", "determineIsVLMAvailable", "isVLMAvailable", "getIsObricOsDevice", "getDeviceModel", "isAIkernelAppInstalled", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DeviceInfoStateImpl implements IDeviceInfoState {
    public static final DeviceInfoStateImpl INSTANCE = null;
    public static final String KEY_OF_IS_AI_KERNEL_AVAILABLE = "device_info_isAIKernelAvailable";
    public static final String KEY_OF_IS_GLOBAL_MEMORY_DISABLED = "device_info_isGlobalMemoryDisabled";
    public static final String KEY_OF_IS_OBRIC_OS_DEVICE = "device_info_isObricOsDevice";
    public static final String KEY_OF_IS_SUPPORT_VLM = "device_info_isSupportVLM";
    public static final String KEY_OF_IS_SUPPORT_VLM_EMBEDDING = "device_info_isSupportVLMEmbedding";
    public static final String KEY_OF_SELF_COLLECTION_CALL_PKG = "device_info_selfCollectionCallPkg";
    public static final String KEY_OF_SELF_COLLECTION_CONTACT_PKG = "device_info_selfCollectionContactPkg";
    public static final String KEY_OF_SELF_COLLECTION_FILE_PKG = "device_info_selfCollectionFilePkg";
    public static final String KEY_OF_SELF_COLLECTION_MESSAGE_PKG = "device_info_selfCollectionMessagePkg";
    public static final String KEY_OF_SELF_COLLECTION_PHOTO_PKG = "device_info_selfCollectionPhotoPkg";
    public static final String KEY_OF_SELF_COLLECTION_SCHEDULE_PKG = "device_info_selfCollectionSchedulePkg";
    public static final String KEY_OF_SELF_COLLECTION_SUPPORTED_TYPES = "device_info_selfCollectionSupportedTypes";
    public static final String KEY_OF_SELF_COLLECTION_SUPPORT_TYPE = "device_info_selfCollectionSupportType";
    private static final String TAG = "DeviceInfoStateImpl";
    private static final ReentrantLock aiKernelAvailableLock = null;
    private static final ReentrantLock globalMemoryDisabledLock = null;
    private static Boolean isAIKernelAvailable;
    private static Boolean isGlobalMemoryDisabled;
    private static Boolean isObricOsDevice;
    private static volatile Boolean isSupportVLM;
    private static Boolean isSupportVlmEmbedding;
    private static final ae<Boolean> mutableVlmSupportState = null;
    private static final ReentrantLock obricOsDevicelock = null;
    private static com.obric.memorydata.middleware.api.device.a selfCollectionSupport;
    private static final ReentrantLock selfCollectionSupportLock = null;
    private static final ReentrantLock supportVlmEmbeddingLock = null;
    private static final ReentrantLock supportVlmLock = null;
    private static final ar<Boolean> vlmSupportState = null;

    /* JADX INFO: renamed from: com.obric.memorydata.middleware.impl.device.DeviceInfoStateImpl$isVLMAvailable$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.middleware.impl.device.DeviceInfoStateImpl$isVLMAvailable$1", f = "DeviceInfoStateImpl.kt", i = {}, l = {359, 367}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<al, Continuation<? super Boolean>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> r3) {
            super(2, (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass1((Continuation) ZeusTransformUtils.wrapperContextForParams(r2, Continuation.class, "com.obric.memorydata.plugin")), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Boolean> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Boolean> r4) {
            return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r14) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            boolean r3 = false;
            Object r4 = null;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            ResultKt.throwOnFailure(r14);
            Object r13 = ((Result) ZeusTransformUtils.preCheckCast(r14, Result.class, "com.obric.memorydata.plugin")).m1430unboximpl();
        L33:
            Result r15 = Result.m1420boximpl(r13);
        L35:
            if (r15 == null) goto L46;
            Object r16 = r15.m1430unboximpl();
            if (Result.m1427isFailureimpl(r16) == true) goto L40;
            r4 = r16;
        L40:
            PackageResource r17 = (PackageResource) ZeusTransformUtils.preCheckCast(r4, PackageResource.class, "com.obric.memorydata.plugin");
            if (r17 == null) goto L46;
            if (r17.isProvisioned() != true) goto L46;
        L24:
            r3 = true;
        L46:
            return Boxing.boxBoolean(r3);
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r14);
            Object r18 = ((Result) ZeusTransformUtils.preCheckCast(r14, Result.class, "com.obric.memorydata.plugin")).m1430unboximpl();
        L14:
            if (Result.m1427isFailureimpl(r18) == false) goto L16;
            Object r2 = null;
        L17:
            PackageResource r5 = (PackageResource) ZeusTransformUtils.preCheckCast(r2, PackageResource.class, "com.obric.memorydata.plugin");
            if (r5 != null) goto L20;
        L22:
            boolean r6 = false;
        L23:
            if (r6 == true) goto L24;
            RequestParams r7 = new RequestParams(null, null, 3, null);
            ParamsKt.setUpdateParams(r7, true);
            if (Result.m1427isFailureimpl(r18) == false) goto L28;
            r18 = null;
        L28:
            PackageResource r19 = (PackageResource) ZeusTransformUtils.preCheckCast(r18, PackageResource.class, "com.obric.memorydata.plugin");
            if (r19 == null) goto L34;
            AIKernelManager r8 = AIKernelManager.INSTANCE;
            this.label = 2;
            r13 = r8.mo189updatePackage0E7RQCE(r19, r7, this);
            if (r13 != r0) goto L33;
            return r0;
        L34:
            r15 = null;
            goto L35
        L20:
            if (r5.isProvisioned() != true) goto L22;
            r6 = true;
            goto L23
        L16:
            r2 = r18;
            goto L17
        L10:
            ResultKt.throwOnFailure(r14);
            IAIKernelManager r9 = (IAIKernelManager) ZeusTransformUtils.preCheckCast(AIKernelManager.INSTANCE, IAIKernelManager.class, "com.obric.memorydata.plugin");
            Continuation r10 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            r18 = IAIKernelManager.DefaultImpls.m190getPackage0E7RQCE$default(r9, "vlm_local", null, r10, 2, null);
            if (r18 != r0) goto L14;
            return r0;
        }
    }

    static {
        INSTANCE = new DeviceInfoStateImpl();
        ae<Boolean> r0 = at.a(null);
        mutableVlmSupportState = r0;
        vlmSupportState = (ar) ZeusTransformUtils.preCheckCast(r0, ar.class, "com.obric.memorydata.plugin");
        obricOsDevicelock = new ReentrantLock();
        aiKernelAvailableLock = new ReentrantLock();
        supportVlmLock = new ReentrantLock();
        supportVlmEmbeddingLock = new ReentrantLock();
        selfCollectionSupportLock = new ReentrantLock();
        globalMemoryDisabledLock = new ReentrantLock();
    }

    private DeviceInfoStateImpl() {
    }

    private final boolean determineIsVLMAvailable() {
        if (isAIKernelAvailable() == true) goto L5;
    L7:
        return false;
    L5:
        if (isVLMAvailable() == false) goto L7;
        return true;
    }

    @JvmStatic
    public static final DeviceInfoStateImpl getInst() {
        return INSTANCE;
    }

    private final boolean getIsObricOsDevice() {
        com.obric.aiagent.product.feature.a.a r10 = am.f13169a.b();
        if (r10 == null) goto L5;
        Boolean r0 = Boolean.valueOf(r10.e());
    L6:
        boolean r1 = true;
        if (r0 == null) goto L9;
        boolean r2 = r0.booleanValue();
    L10:
        IRunLog r4 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r3 = new StringBuilder().append("isObricOs=").append(r2).append(",platform:[service==null:");
        if (r10 == null) goto L14;
        r1 = false;
    L14:
        IRunLog.a.a(r4, TAG, r3.append(r1).append(",value=").append(r0).append(']').toString(), false, 4, null);
        return r2;
    L9:
        r2 = true;
        goto L10
    L5:
        r0 = null;
        goto L6
    }

    private final com.obric.memorydata.middleware.api.device.a getSelfCollectionConfig(com.obric.aiagent.product.feature.a.a r21) {
        com.obric.aiagent.product.feature.a.a r0 = (com.obric.aiagent.product.feature.a.a) ZeusTransformUtils.wrapperContextForParams(r21, com.obric.aiagent.product.feature.a.a.class, "com.obric.memorydata.plugin");
        String r2 = r0.b(ProductPlatformConstantsKt.FEATURE_KEY_SELF_COLLECTION_TYPE);
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
        boolean r3 = true;
    L6:
        if (r3 == false) goto L9;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "getSelfCollectionConfig from feature: type is empty", null, 4, null);
        return null;
    L9:
        SelfCollectionSupportType r4 = toType(r2);
        if (r4 != SelfCollectionSupportType.NONE) goto L14;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "getSelfCollectionConfig from feature: type=" + r2 + ", not support method return", false, 4, null);
        return new com.obric.memorydata.middleware.api.device.a(SelfCollectionSupportType.NONE, null, null, 6, null);
    L14:
        if (r4 != SelfCollectionSupportType.ALL) goto L16;
        Set<Integer> r5 = a.f11709a.a();
        String r6 = "";
    L23:
        String r9 = r0.b(ProductPlatformConstantsKt.FEATURE_KEY_SELF_COLLECTION_CONTACT_PKG);
        String r11 = r0.b(ProductPlatformConstantsKt.FEATURE_KEY_SELF_COLLECTION_MESSAGE_PKG);
        String r10 = r0.b(ProductPlatformConstantsKt.FEATURE_KEY_SELF_COLLECTION_CALL_HISTORY_PKG);
        String r12 = r0.b(ProductPlatformConstantsKt.FEATURE_KEY_SELF_COLLECTION_PHOTO_PKG);
        String r13 = r0.b(ProductPlatformConstantsKt.FEATURE_KEY_SELF_COLLECTION_FILE_PKG);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "getSelfCollectionConfig from feature: type=" + r2 + ",entityTypes=" + r6 + ",pkgName:[contact=" + r9 + ",message=" + r11 + ",call=" + r10 + ",photo=" + r12 + ",file=" + r13 + ']', false, 4, null);
        return new com.obric.memorydata.middleware.api.device.a(r4, r5, new b(r9, r10, r11, r12, r13, null, 32, null));
    L16:
        List<String> r7 = r0.c(ProductPlatformConstantsKt.FEATURE_KEY_SELF_COLLECTION_PARTIAL_ENTITY_TYPES);
        r6 = r7.toString();
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin");
        Collection r14 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r15 = r8.iterator();
    L18:
        if (r15.hasNext() == false) goto L22;
        Integer r16 = StringsKt.toIntOrNull((String) ZeusTransformUtils.preCheckCast(r15.next(), String.class, "com.obric.memorydata.plugin"));
        if (r16 == null) goto L18;
        r14.add(r16);
        goto L18
    L22:
        r5 = CollectionsKt.intersect((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r14, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast(a.f11709a.a(), Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin"));
        goto L23
    L5:
        r3 = false;
        goto L6
    }

    private final boolean isAIkernelAppInstalled() {
        return c.f13193a.a("com.obric.aikernel");
    }

    private final boolean isVLMAvailable() {
        String r8 = getDeviceModel();
        if (SetsKt.setOf(new String[]{"Genesis-M", "Genesis-R"}).contains(r8) == false) goto L7;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "default supported VLM device: " + r8, false, 4, null);
        return true;
    L7:
        return ((Boolean) ZeusTransformUtils.preCheckCast(i.a(null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(null), Function2.class, "com.obric.memorydata.plugin"), 1, null), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    }

    public static /* synthetic */ void lambda$KAJSk6BPjLe7jEUlZ7RSLCplSi0(int r0) {
        retryGetVlmState$lambda$12(r0);
    }

    private final void retryGetVlmState(final int r7) {
        if (r7 <= 3) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "finish retry get vlm state", false, 4, null);
        return;
    L6:
        GlobalHandlerUtil.Companion.getInstance().postDelay(6000, new $$Lambda$DeviceInfoStateImpl$KAJSk6BPjLe7jEUlZ7RSLCplSi0(r7));
    }

    private static final void retryGetVlmState$lambda$12(int r8) {
        DeviceInfoStateImpl r0 = INSTANCE;
        boolean r1 = r0.determineIsVLMAvailable();
        if (r1 == false) goto L5;
        r0.setSupportVLM(Boolean.valueOf(r1));
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "isSupportVLM state error", null, 4, null);
        return;
    L5:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "retry get vlm state next times", false, 4, null);
        r0.retryGetVlmState(r8 + 1);
    }

    private final void setSupportVLM(Boolean r1) {
        isSupportVLM = r1;
        mutableVlmSupportState.b(r1);
    }

    private final SelfCollectionSupportType toType(String r2) {
        Locale r1 = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(r1, "ROOT");
        String r3 = r2.toLowerCase(r1);
        Intrinsics.checkNotNullExpressionValue(r3, "toLowerCase(...)");
        int r4 = r3.hashCode();
        if (r4 == (-792934015)) goto L15;
        if (r4 != 96673) goto L7;
        r3.equals(LocationAnnotation.LightLocationType.LIGHT_LOCATION_ALL);
    L20:
        return SelfCollectionSupportType.ALL;
    L7:
        if (r4 != 3387192) goto L20;
        if (r3.equals("none") == false) goto L20;
        return SelfCollectionSupportType.NONE;
    L15:
        if (r3.equals("partial") == false) goto L20;
        return SelfCollectionSupportType.PARTIAL;
    }

    @Override // com.obric.memorydata.middleware.api.device.IDeviceInfoState
    public String getDeviceModel() {
        com.obric.aiagent.product.feature.a.a r0 = am.f13169a.b();
        if (r0 == null) goto L5;
        String r1 = r0.c();
    L6:
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1;
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.obric.memorydata.middleware.api.device.IDeviceInfoState
    public com.obric.memorydata.middleware.api.device.a getSelfCollectionEntitySupport() {
        String r0 = "default";
        com.obric.memorydata.middleware.api.device.a r2 = selfCollectionSupport;
        if (r2 == null) goto L5;
        return r2;
    L5:
        ReentrantLock r3 = selfCollectionSupportLock;
        r3.lock();
        com.obric.memorydata.middleware.api.device.a r4 = selfCollectionSupport;     // Catch: Throwable -> L43
        if (r4 == null) goto L10;
        r3.unlock();
        return r4;
    L10:
        boolean r5 = false;
        IStore r6 = IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null);     // Catch: Throwable -> L43
        String r7 = r6.getString(KEY_OF_SELF_COLLECTION_SUPPORT_TYPE, "default");     // Catch: Throwable -> L43
        if (Intrinsics.areEqual(r7, "default") == true) goto L30;
        r0 = "debugSetting";
        SelfCollectionSupportType r14 = toType(r7);     // Catch: Throwable -> L43
        String r8 = r6.getString(KEY_OF_SELF_COLLECTION_SUPPORTED_TYPES, "");     // Catch: Throwable -> L43
        if (r14 != SelfCollectionSupportType.PARTIAL) goto L26;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L17;
        r5 = true;
    L17:
        if (r5 == false) goto L26;
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin"), new String[]{","}, false, 0, 6, null), Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L43
        Collection r10 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L43
        Iterator r11 = r9.iterator();     // Catch: Throwable -> L43
    L20:
        if (r11.hasNext() == false) goto L24;
        Integer r12 = StringsKt.toIntOrNull((String) ZeusTransformUtils.preCheckCast(r11.next(), String.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L43
        if (r12 == null) goto L20;
        r10.add(r12);     // Catch: Throwable -> L43
        goto L20
    L24:
        Set<Integer> r13 = CollectionsKt.intersect((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.toMutableSet((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r10, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast(a.f11709a.a(), Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L43
    L29:
        com.obric.memorydata.middleware.api.device.a r15 = new com.obric.memorydata.middleware.api.device.a(r14, r13, new b(r6.getString(KEY_OF_SELF_COLLECTION_CONTACT_PKG, null), r6.getString(KEY_OF_SELF_COLLECTION_CALL_PKG, null), r6.getString(KEY_OF_SELF_COLLECTION_MESSAGE_PKG, null), r6.getString(KEY_OF_SELF_COLLECTION_PHOTO_PKG, null), r6.getString(KEY_OF_SELF_COLLECTION_FILE_PKG, null), r6.getString(KEY_OF_SELF_COLLECTION_SCHEDULE_PKG, null)));     // Catch: Throwable -> L43
    L40:
        selfCollectionSupport = r15;     // Catch: Throwable -> L43
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "getSelfCollectionEntitySupport(from=" + r0 + "): type=" + r15.a() + ", types=" + r15.b() + ", pkgSpec=" + r15.c(), false, 4, null);     // Catch: Throwable -> L43
        selfCollectionSupportLock.unlock();
        return r15;
    L26:
        if (r14 != SelfCollectionSupportType.ALL) goto L28;
        r13 = a.f11709a.a();     // Catch: Throwable -> L43
        goto L29
    L28:
        r13 = SetsKt.emptySet();     // Catch: Throwable -> L43
        goto L29
    L30:
        com.obric.aiagent.product.feature.a.a r16 = am.f13169a.b();     // Catch: Throwable -> L43
        if (r16 == null) goto L36;
        r15 = getSelfCollectionConfig(r16);     // Catch: Throwable -> L43
        if (r15 == null) goto L36;
        r0 = "feature";
    L36:
        if (INSTANCE.isObricOsDevice() == false) goto L38;
        com.obric.memorydata.middleware.api.device.a r17 = new com.obric.memorydata.middleware.api.device.a(SelfCollectionSupportType.NONE, SetsKt.emptySet(), new b(null, null, null, null, null, null, 63, null));     // Catch: Throwable -> L43
    L39:
        r15 = r17;
        goto L40
    L38:
        r17 = new com.obric.memorydata.middleware.api.device.a(SelfCollectionSupportType.ALL, a.f11709a.a(), new b(null, null, null, null, null, null, 63, null));     // Catch: Throwable -> L43
    L43:
        th = move-exception;
        selfCollectionSupportLock.unlock();
        throw th;
    }

    @Override // com.obric.memorydata.middleware.api.device.IDeviceInfoState
    public ar<Boolean> getVlmSupportState() {
        return vlmSupportState;
    }

    @Override // com.obric.memorydata.middleware.api.device.IDeviceInfoState
    public boolean isAIKernelAvailable() {
        Boolean r2 = isAIKernelAvailable;
        if (r2 != null) goto L5;
        ReentrantLock r3 = aiKernelAvailableLock;
        r3.lock();
        Boolean r4 = isAIKernelAvailable;     // Catch: Throwable -> L20
        if (r4 == null) goto L12;
        boolean r9 = r4.booleanValue();     // Catch: Throwable -> L20
        r3.unlock();
        return r9;
    L12:
        String r5 = IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).getString(KEY_OF_IS_AI_KERNEL_AVAILABLE, "default");     // Catch: Throwable -> L20
        if (Intrinsics.areEqual(r5, "default") == true) goto L16;
        boolean r10 = Boolean.parseBoolean(r5);     // Catch: Throwable -> L20
        isAIKernelAvailable = Boolean.valueOf(r10);     // Catch: Throwable -> L20
        IRunLog r6 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
        String r7 = TAG;
        String r8 = "isAIKernelAvailable debug: " + r10;     // Catch: Throwable -> L20
    L15:
        IRunLog.a.a(r6, r7, r8, false, 4, null);     // Catch: Throwable -> L20
        r3.unlock();
        return r10;
    L16:
        r10 = isAIkernelAppInstalled();     // Catch: Throwable -> L20
        isAIKernelAvailable = Boolean.valueOf(r10);     // Catch: Throwable -> L20
        r6 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
        r7 = TAG;
        r8 = "isAIKernelAvailable: " + r10;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        aiKernelAvailableLock.unlock();
        throw th;
    L5:
        return r2.booleanValue();
    }

    @Override // com.obric.memorydata.middleware.api.device.IDeviceInfoState
    public boolean isGlobalMemoryDisabled() {
        Boolean r1 = isGlobalMemoryDisabled;
        if (r1 != null) goto L5;
        ReentrantLock r2 = globalMemoryDisabledLock;
        r2.lock();
        Boolean r3 = isGlobalMemoryDisabled;     // Catch: Throwable -> L22
        if (r3 == null) goto L12;
        boolean r13 = r3.booleanValue();     // Catch: Throwable -> L22
        r2.unlock();
        return r13;
    L12:
        boolean r6 = false;
        String r4 = IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).getString(KEY_OF_IS_GLOBAL_MEMORY_DISABLED, "default");     // Catch: Throwable -> L22
        if (Intrinsics.areEqual(r4, "default") == true) goto L16;
        boolean r14 = Boolean.parseBoolean(r4);     // Catch: Throwable -> L22
        isGlobalMemoryDisabled = Boolean.valueOf(r14);     // Catch: Throwable -> L22
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "isGlobalMemoryDisabled debug: " + r14, false, 4, null);     // Catch: Throwable -> L22
    L20:
        r2.unlock();
        return r14;
    L16:
        if (am.f13169a.a(ProductPlatformConstantsKt.FEATURE_KEY_GLOBAL_MEMORY, true) == true) goto L18;
        r6 = true;
    L18:
        isGlobalMemoryDisabled = Boolean.valueOf(r6);     // Catch: Throwable -> L22
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "isGlobalMemoryDisabled: " + r6, false, 4, null);     // Catch: Throwable -> L22
        r14 = r6;
    L22:
        th = move-exception;
        globalMemoryDisabledLock.unlock();
        throw th;
    L5:
        return r1.booleanValue();
    }

    @Override // com.obric.memorydata.middleware.api.device.IDeviceInfoState
    public boolean isObricOsDevice() {
        Boolean r2 = isObricOsDevice;
        if (r2 != null) goto L5;
        ReentrantLock r3 = obricOsDevicelock;
        r3.lock();
        Boolean r4 = isObricOsDevice;     // Catch: Throwable -> L20
        if (r4 == null) goto L12;
        boolean r9 = r4.booleanValue();     // Catch: Throwable -> L20
        r3.unlock();
        return r9;
    L12:
        String r5 = IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).getString(KEY_OF_IS_OBRIC_OS_DEVICE, "default");     // Catch: Throwable -> L20
        if (Intrinsics.areEqual(r5, "default") == true) goto L16;
        boolean r10 = Boolean.parseBoolean(r5);     // Catch: Throwable -> L20
        isObricOsDevice = Boolean.valueOf(r10);     // Catch: Throwable -> L20
        IRunLog r6 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
        String r7 = TAG;
        String r8 = "isObricOsDevice debug: " + r10;     // Catch: Throwable -> L20
    L15:
        IRunLog.a.a(r6, r7, r8, false, 4, null);     // Catch: Throwable -> L20
        r3.unlock();
        return r10;
    L16:
        r10 = getIsObricOsDevice();     // Catch: Throwable -> L20
        isObricOsDevice = Boolean.valueOf(r10);     // Catch: Throwable -> L20
        r6 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
        r7 = TAG;
        r8 = "isObricOsDevice: " + r10;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        obricOsDevicelock.unlock();
        throw th;
    L5:
        return r2.booleanValue();
    }

    @Override // com.obric.memorydata.middleware.api.device.IDeviceInfoState
    public boolean isSupportVLM() {
        Boolean r2 = isSupportVLM;
        if (r2 != null) goto L5;
        ReentrantLock r3 = supportVlmLock;
        r3.lock();
        Boolean r4 = isSupportVLM;     // Catch: Throwable -> L20
        if (r4 == null) goto L12;
        boolean r9 = r4.booleanValue();     // Catch: Throwable -> L20
        r3.unlock();
        return r9;
    L12:
        String r5 = IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).getString(KEY_OF_IS_SUPPORT_VLM, "default");     // Catch: Throwable -> L20
        if (Intrinsics.areEqual(r5, "default") == true) goto L15;
        boolean r0 = Boolean.parseBoolean(r5);     // Catch: Throwable -> L20
        setSupportVLM(Boolean.valueOf(r0));     // Catch: Throwable -> L20
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "isSupportVLM debug: " + r0, false, 4, null);     // Catch: Throwable -> L20
    L18:
        r3.unlock();
        return r0;
    L15:
        r0 = determineIsVLMAvailable();     // Catch: Throwable -> L20
        setSupportVLM(Boolean.valueOf(r0));     // Catch: Throwable -> L20
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "isSupportVLM: " + r0, false, 4, null);     // Catch: Throwable -> L20
        if (r0 == true) goto L18;
        retryGetVlmState(1);     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        supportVlmLock.unlock();
        throw th;
    L5:
        return r2.booleanValue();
    }

    @Override // com.obric.memorydata.middleware.api.device.IDeviceInfoState
    public boolean isSupportVLMEmbedding() {
        Boolean r1 = isSupportVlmEmbedding;
        if (r1 != null) goto L5;
        ReentrantLock r2 = supportVlmEmbeddingLock;
        r2.lock();
        Boolean r3 = isSupportVlmEmbedding;     // Catch: Throwable -> L20
        if (r3 == null) goto L12;
        boolean r8 = r3.booleanValue();     // Catch: Throwable -> L20
        r2.unlock();
        return r8;
    L12:
        String r4 = IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).getString(KEY_OF_IS_SUPPORT_VLM_EMBEDDING, "default");     // Catch: Throwable -> L20
        if (Intrinsics.areEqual(r4, "default") == true) goto L16;
        boolean r9 = Boolean.parseBoolean(r4);     // Catch: Throwable -> L20
        isSupportVlmEmbedding = Boolean.valueOf(r9);     // Catch: Throwable -> L20
        IRunLog r5 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
        String r6 = TAG;
        String r7 = "isSupportVLMEmbedding debug: " + r9;     // Catch: Throwable -> L20
    L15:
        IRunLog.a.a(r5, r6, r7, false, 4, null);     // Catch: Throwable -> L20
        r2.unlock();
        return r9;
    L16:
        r9 = am.f13169a.a(ProductPlatformConstantsKt.FEATURE_KEY_VLM_EMBEDDING, true);     // Catch: Throwable -> L20
        isSupportVlmEmbedding = Boolean.valueOf(r9);     // Catch: Throwable -> L20
        r5 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
        r6 = TAG;
        r7 = "isSupportVLMEmbedding: " + r9;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        supportVlmEmbeddingLock.unlock();
        throw th;
    L5:
        return r1.booleanValue();
    }
}
