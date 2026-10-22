package com.obric.memorydata.aikernelcore.utils;

import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.aikernel.phx.sdk.AIKernelManager;
import com.obric.aikernel.phx.sdk.IAIKernelManager;
import com.obric.aikernel.sdk.data.PackageResource;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\rB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J0\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\u00052\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u000b\"\u00020\u0005H\u0086@¢\u0006\u0002\u0010\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/memorydata/aikernelcore/utils/ModelDataUtil;", "", "<init>", "()V", "TAG", "", "checkPackageModelReady", "", "Lcom/obric/memorydata/aikernelcore/utils/ModelDataUtil$ModelItem;", ObricMemoryConstants.KEY_PACKAGE_NAME, "modelNames", "", "(Ljava/lang/String;[Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ModelItem", "aikernel_core_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f8483a = null;

    /* JADX INFO: renamed from: com.obric.memorydata.aikernelcore.utils.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/obric/memorydata/aikernelcore/utils/ModelDataUtil$ModelItem;", "", ActivityLifecycle.NAME, "", "status", "type", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;I)V", "getName", "()Ljava/lang/String;", "getStatus", "getType", "()I", "aikernel_core_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class C0428a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f8484a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f8485b;
        private final int c;

        public C0428a(String r2, String r3, int r4) {
            Intrinsics.checkNotNullParameter(r2, ActivityLifecycle.NAME);
            Intrinsics.checkNotNullParameter(r3, "status");
            this.f8484a = r2;
            this.f8485b = r3;
            this.c = r4;
        }

        public final String a() {
            return this.f8484a;
        }

        public final String b() {
            return this.f8485b;
        }

        public final int getType() {
            return this.c;
        }
    }

    static {
        f8483a = new a();
    }

    private a() {
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x00b4 -> B:20:0x00b8). Please report as a decompilation issue!!! */
    public final Object a(String r13, String[] r14, Continuation<? super List<C0428a>> r15) {
        Continuation r16 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r15, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r16, ModelDataUtil$checkPackageModelReady$1.class) == false) goto L7;
        ModelDataUtil$checkPackageModelReady$1 r17 = (ModelDataUtil$checkPackageModelReady$1) ZeusTransformUtils.preCheckCast(r16, ModelDataUtil$checkPackageModelReady$1.class, "com.obric.memorydata.plugin");
        if ((r17.label & Integer.MIN_VALUE) == 0) goto L7;
        r17.label -= Integer.MIN_VALUE;
    L8:
        Object r12 = r17.result;
        Object r18 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = r17.label;
        if (r1 == 0) goto L14;
        if (r1 != 1) goto L13;
        int r19 = r17.I$1;
        int r2 = r17.I$0;
        ArrayList r4 = (ArrayList) ZeusTransformUtils.preCheckCast(r17.L$3, ArrayList.class, "com.obric.memorydata.plugin");
        String r5 = (String) ZeusTransformUtils.preCheckCast(r17.L$2, String.class, "com.obric.memorydata.plugin");
        String[] r6 = (String[]) ZeusTransformUtils.preCheckCast(r17.L$1, String[].class, "com.obric.memorydata.plugin");
        ArrayList r7 = (ArrayList) ZeusTransformUtils.preCheckCast(r17.L$0, ArrayList.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r12);
        Object r110 = ((Result) ZeusTransformUtils.preCheckCast(r12, Result.class, "com.obric.memorydata.plugin")).m1430unboximpl();
        ArrayList r10 = r7;
    L21:
        if (Result.m1427isFailureimpl(r110) == false) goto L23;
        r110 = null;
    L23:
        PackageResource r111 = (PackageResource) ZeusTransformUtils.preCheckCast(r110, PackageResource.class, "com.obric.memorydata.plugin");
        if (r111 != null) goto L26;
    L28:
        boolean r112 = false;
    L29:
        if (r112 == false) goto L31;
        String r113 = "Ready";
    L32:
        r4.add(new C0428a(r5, r113, 1));
        r2 = r2 + 1;
        String[] r114 = r6;
    L15:
        if (r2 >= r19) goto L33;
        String r11 = r114[r2];
        IAIKernelManager r8 = (IAIKernelManager) ZeusTransformUtils.preCheckCast(AIKernelManager.INSTANCE, IAIKernelManager.class, "com.obric.memorydata.plugin");
        r17.L$0 = r10;
        r17.L$1 = r114;
        r17.L$2 = r11;
        r17.L$3 = r10;
        r17.I$0 = r2;
        r17.I$1 = r19;
        r17.label = 1;
        Object r9 = IAIKernelManager.DefaultImpls.m190getPackage0E7RQCE$default(r8, r11, null, r17, 2, null);
        if (r9 != r18) goto L19;
        return r18;
    L19:
        r6 = r114;
        r110 = r9;
        r4 = r10;
        r5 = r11;
        goto L21
    L33:
        return r10;
    L31:
        r113 = "NotReady";
        goto L32
    L26:
        if (r111.isAvailable() != true) goto L28;
        r112 = true;
        goto L29
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r12);
        r10 = new ArrayList();
        r114 = r14;
        r19 = r14.length;
        r2 = 0;
    L7:
        r17 = new ModelDataUtil$checkPackageModelReady$1(this, r16);
        goto L8
    }
}
