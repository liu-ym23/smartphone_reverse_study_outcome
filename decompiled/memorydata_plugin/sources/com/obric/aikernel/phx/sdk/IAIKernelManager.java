package com.obric.aikernel.phx.sdk;

import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.aikernel.phx.sdk.api.IBaseModel;
import com.obric.aikernel.sdk.config.RequestParams;
import com.obric.aikernel.sdk.data.PackageResource;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\bg\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017J\u001b\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0006J4\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u0004\u001a\u00020\u0005H¦@ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ/\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u000b2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0004\u001a\u00020\u0005H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0013J4\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u0004\u001a\u00020\u0005H¦@ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u0082\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u0018"}, d2 = {"Lcom/obric/aikernel/phx/sdk/IAIKernelManager;", "", "clearAIKernelData", "", TrackerImpl.PARAMS, "Lcom/obric/aikernel/sdk/config/RequestParams;", "(Lcom/obric/aikernel/sdk/config/RequestParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPackage", "Lkotlin/Result;", "Lcom/obric/aikernel/sdk/data/PackageResource;", "business", "", "getPackage-0E7RQCE", "(Ljava/lang/String;Lcom/obric/aikernel/sdk/config/RequestParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadPackage", "Lcom/obric/aikernel/phx/sdk/api/IBaseModel;", ActivityLifecycle.NAME, "useCloud", "", "(Ljava/lang/String;ZLcom/obric/aikernel/sdk/config/RequestParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updatePackage", "updatePackage-0E7RQCE", "(Lcom/obric/aikernel/sdk/data/PackageResource;Lcom/obric/aikernel/sdk/config/RequestParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface IAIKernelManager {
    public static final Companion Companion = null;
    public static final String PACKAGE_NAME_AIK = "com.obric.aikernel";
    public static final String PACKAGE_NAME_ASSIST = "com.larus.nova";
    public static final String SERVICE_NAME = "com.obric.aikernel.AIKernelService";
    public static final String TAG = "AIKernelManager";

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/obric/aikernel/phx/sdk/IAIKernelManager$Companion;", "", "()V", "PACKAGE_NAME_AIK", "", "PACKAGE_NAME_ASSIST", "SERVICE_NAME", "TAG", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        public static final String PACKAGE_NAME_AIK = "com.obric.aikernel";
        public static final String PACKAGE_NAME_ASSIST = "com.larus.nova";
        public static final String SERVICE_NAME = "com.obric.aikernel.AIKernelService";
        public static final String TAG = "AIKernelManager";

        static {
            $$INSTANCE = new Companion();
        }

        private Companion() {
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ Object clearAIKernelData$default(IAIKernelManager r2, RequestParams r3, Continuation r4, int r5, Object r6) {
            IAIKernelManager r7 = (IAIKernelManager) ZeusTransformUtils.wrapperContextForParams(r2, IAIKernelManager.class, "com.obric.memorydata.plugin");
            Continuation<? super Unit> r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            if (r6 != null) goto L10;
            if ((r5 & 1) == 0) goto L8;
            r3 = new RequestParams(null, null, 3, null);
        L8:
            return r7.clearAIKernelData(r3, r8);
        L10:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: clearAIKernelData");
        }

        /* JADX INFO: renamed from: getPackage-0E7RQCE$default, reason: not valid java name */
        public static /* synthetic */ Object m190getPackage0E7RQCE$default(IAIKernelManager r2, String r3, RequestParams r4, Continuation r5, int r6, Object r7) {
            IAIKernelManager r8 = (IAIKernelManager) ZeusTransformUtils.wrapperContextForParams(r2, IAIKernelManager.class, "com.obric.memorydata.plugin");
            Continuation<? super Result<PackageResource>> r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            if (r7 != null) goto L10;
            if ((r6 & 2) == 0) goto L8;
            r4 = new RequestParams(null, null, 3, null);
        L8:
            return r8.mo188getPackage0E7RQCE(r3, r4, r9);
        L10:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getPackage-0E7RQCE");
        }

        public static /* synthetic */ Object loadPackage$default(IAIKernelManager r2, String r3, boolean r4, RequestParams r5, Continuation r6, int r7, Object r8) {
            IAIKernelManager r9 = (IAIKernelManager) ZeusTransformUtils.wrapperContextForParams(r2, IAIKernelManager.class, "com.obric.memorydata.plugin");
            Continuation<? super IBaseModel> r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
            if (r8 != null) goto L13;
            if ((r7 & 2) == 0) goto L8;
            r4 = false;
        L8:
            if ((r7 & 4) == 0) goto L11;
            r5 = new RequestParams(null, null, 3, null);
        L11:
            return r9.loadPackage(r3, r4, r5, r10);
        L13:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadPackage");
        }

        /* JADX INFO: renamed from: updatePackage-0E7RQCE$default, reason: not valid java name */
        public static /* synthetic */ Object m191updatePackage0E7RQCE$default(IAIKernelManager r2, PackageResource r3, RequestParams r4, Continuation r5, int r6, Object r7) {
            IAIKernelManager r8 = (IAIKernelManager) ZeusTransformUtils.wrapperContextForParams(r2, IAIKernelManager.class, "com.obric.memorydata.plugin");
            Continuation<? super Result<PackageResource>> r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            if (r7 != null) goto L10;
            if ((r6 & 2) == 0) goto L8;
            r4 = new RequestParams(null, null, 3, null);
        L8:
            return r8.mo189updatePackage0E7RQCE(r3, r4, r9);
        L10:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updatePackage-0E7RQCE");
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    Object clearAIKernelData(RequestParams r1, Continuation<? super Unit> r2);

    /* JADX INFO: renamed from: getPackage-0E7RQCE */
    Object mo188getPackage0E7RQCE(String r1, RequestParams r2, Continuation<? super Result<PackageResource>> r3);

    Object loadPackage(String r1, boolean r2, RequestParams r3, Continuation<? super IBaseModel> r4);

    /* JADX INFO: renamed from: updatePackage-0E7RQCE */
    Object mo189updatePackage0E7RQCE(PackageResource r1, RequestParams r2, Continuation<? super Result<PackageResource>> r3);
}
