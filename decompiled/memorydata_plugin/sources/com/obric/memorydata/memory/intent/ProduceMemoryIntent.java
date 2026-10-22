package com.obric.memorydata.memory.intent;

import android.os.Parcelable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.ErrorCode;
import com.obric.capabilitykit.common.intent.BaseMemoryProduceIntent;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.common.intent.MemoryProduceParams;
import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.utils.at;
import com.ttnet.org.chromium.net.NetError;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.da;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J*\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0096@¢\u0006\u0002\u0010\u000eJ\u001c\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u001c\u0010\u0010\u001a\u00020\u00112\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013H\u0002¨\u0006\u0017"}, d2 = {"Lcom/obric/memorydata/memory/intent/ProduceMemoryIntent;", "Lcom/obric/capabilitykit/common/intent/BaseMemoryProduceIntent;", "<init>", "()V", "isBlock", "", "doAction", "Lcom/obric/capabilitykit/common/intent/IntentResult;", "", "Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", TrackerImpl.PARAMS, "Lcom/obric/capabilitykit/common/intent/MemoryProduceParams;", "dispatchContext", "Lcom/obric/capabilitykit/common/DispatchContext;", "(Lcom/obric/capabilitykit/common/intent/MemoryProduceParams;Lcom/obric/capabilitykit/common/DispatchContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processIntent", "convertErrorCode", "", "extraMap", "", "", "", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ProduceMemoryIntent extends BaseMemoryProduceIntent {
    public static final a Companion = null;
    private static final String TAG = "ProduceMemoryIntent";

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/memory/intent/ProduceMemoryIntent$Companion;", "", "<init>", "()V", "TAG", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.intent.ProduceMemoryIntent$doAction$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.intent.ProduceMemoryIntent", f = "ProduceMemoryIntent.kt", i = {0, 0}, l = {38}, m = "doAction", n = {"this", TrackerImpl.PARAMS}, s = {"L$0", "L$1"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ ProduceMemoryIntent this$0;

        AnonymousClass1(ProduceMemoryIntent r3, Continuation<? super AnonymousClass1> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.doAction(null, null, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        Companion = new a(null);
    }

    public ProduceMemoryIntent() {
    }

    private final int convertErrorCode(Map<String, ? extends Object> r2) {
        Object r1 = ((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin")).get("errorCode");
        if (Intrinsics.areEqual(r1, Integer.valueOf(NetError.ERR_INVALID_URL)) == false) goto L7;
        return ErrorCode.Memory.ERROR_CLASSIFY;
    L7:
        if (Intrinsics.areEqual(r1, Integer.valueOf(NetError.ERR_CACHE_MISS)) == false) goto L11;
        return ErrorCode.Memory.ERROR_UPDATE_BUT_TYPE_NOT_SUPPORT;
    L11:
        if (Intrinsics.areEqual(r1, Integer.valueOf(NetError.ERR_CACHE_READ_FAILURE)) == false) goto L15;
        return ErrorCode.Memory.ERROR_UPDATE_BUT_RECALL_EMPTY;
    L15:
        if (Intrinsics.areEqual(r1, Integer.valueOf(NetError.ERR_CACHE_WRITE_FAILURE)) == false) goto L18;
        return ErrorCode.Memory.ERROR_UPDATE_BUT_RESULT_CREATE;
    L18:
        return 1;
    }

    private final IntentResult<MemoryEntity[]> processIntent(MemoryProduceParams r14) {
        return new IntentResult(1, new MemoryEntity[0], null, at.a(ZeusTransformUtils.mapRes(R.string.memory_build_failed_text, TypedValues.Custom.S_STRING, "memory_build_failed_text")), false, false, 0, null, null, null, 1012, null);
    }

    @Override // com.obric.capabilitykit.common.intent.BaseMemoryProduceIntent, com.obric.capabilitykit.common.intent.IntentFunction
    public /* synthetic */ Object doAction(Parcelable r3, DispatchContext r4, Continuation<? super IntentResult<MemoryEntity[]>> r5) {
        Parcelable r6 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.memorydata.plugin");
        Continuation<? super IntentResult<MemoryEntity[]>> r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        return doAction((MemoryProduceParams) ZeusTransformUtils.preCheckCast(r6, MemoryProduceParams.class, "com.obric.memorydata.plugin"), r4, r7);
    }

    @Override // com.obric.capabilitykit.common.intent.BaseMemoryProduceIntent
    public Object doAction(MemoryProduceParams r21, DispatchContext r22, Continuation<? super IntentResult<MemoryEntity[]>> r23) {
        ProduceMemoryIntent r0 = this;
        Continuation r1 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r23, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1, AnonymousClass1.class) == false) goto L7;
        AnonymousClass1 r3 = (AnonymousClass1) ZeusTransformUtils.preCheckCast(r1, AnonymousClass1.class, "com.obric.memorydata.plugin");
        if ((r3.label & Integer.MIN_VALUE) == 0) goto L7;
        r3.label -= Integer.MIN_VALUE;
    L8:
        Object r2 = r3.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r3.label;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        MemoryProduceParams r6 = (MemoryProduceParams) ZeusTransformUtils.preCheckCast(r3.L$1, MemoryProduceParams.class, "com.obric.memorydata.plugin");
        ProduceMemoryIntent r7 = (ProduceMemoryIntent) ZeusTransformUtils.preCheckCast(r3.L$0, ProduceMemoryIntent.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r2);
        MemoryProduceParams r8 = r6;
        r0 = r7;
    L19:
        Boolean r9 = (Boolean) ZeusTransformUtils.preCheckCast(r2, Boolean.class, "com.obric.memorydata.plugin");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "user agree result: " + r9, false, 4, null);
        if (Intrinsics.areEqual(r9, Boxing.boxBoolean(true)) == true) goto L26;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "PRIVACY_STATEMENT_NOT_AGREE_ERROR", false, 4, null);
        return new IntentResult(201, new MemoryEntity[0], null, null, false, false, 256, null, null, null, 956, null);
    L26:
        return r0.processIntent(r8);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r2);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "doAction", false, 4, null);
        if (UserSettings.INSTANCE.hasAgreePrivacyAndLogin() == true) goto L25;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "user need agree privacy.", false, 4, null);
        Function2 r10 = (Function2) ZeusTransformUtils.preCheckCast(new ProduceMemoryIntent$doAction$agree$1(null), Function2.class, "com.obric.memorydata.plugin");
        r3.L$0 = r0;
        r8 = r21;
        r3.L$1 = r8;
        r3.label = 1;
        r2 = da.b(10000, r10, r3);
        if (r2 != r4) goto L19;
        return r4;
    L25:
        return processIntent(r21);
    L7:
        r3 = new AnonymousClass1(r0, r1);
        goto L8
    }

    @Override // com.obric.capabilitykit.common.intent.BaseMemoryProduceIntent, com.obric.capabilitykit.common.intent.IntentFunction
    public boolean isBlock() {
        return true;
    }
}
