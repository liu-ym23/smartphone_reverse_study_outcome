package com.obric.memorydata.memory.intent;

import android.os.Parcelable;
import androidx.core.view.PointerIconCompat;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.intent.BaseMemoryDeleteIntent;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.common.intent.MemoryDeleteParams;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.memorydata.memory.review.trace.g;
import com.obric.memorydata.memory.tracker.MemoryEventTracker;
import com.obric.memorydata.memory.utils.f;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0096@¢\u0006\u0002\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/obric/memorydata/memory/intent/DeleteMemoryIntent;", "Lcom/obric/capabilitykit/common/intent/BaseMemoryDeleteIntent;", "<init>", "()V", "doAction", "Lcom/obric/capabilitykit/common/intent/IntentResult;", "", "Lcom/obric/capabilitykit/entity/app/AppEntity;", TrackerImpl.PARAMS, "Lcom/obric/capabilitykit/common/intent/MemoryDeleteParams;", "dispatchContext", "Lcom/obric/capabilitykit/common/DispatchContext;", "(Lcom/obric/capabilitykit/common/intent/MemoryDeleteParams;Lcom/obric/capabilitykit/common/DispatchContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DeleteMemoryIntent extends BaseMemoryDeleteIntent {
    public static final a Companion = null;
    private static final String TAG = "DeleteMemoryIntent";

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/memory/intent/DeleteMemoryIntent$Companion;", "", "<init>", "()V", "TAG", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.intent.DeleteMemoryIntent$doAction$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.intent.DeleteMemoryIntent", f = "DeleteMemoryIntent.kt", i = {}, l = {26}, m = "doAction", n = {}, s = {})
    static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ DeleteMemoryIntent this$0;

        AnonymousClass1(DeleteMemoryIntent r3, Continuation<? super AnonymousClass1> r4) {
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

    public DeleteMemoryIntent() {
    }

    @Override // com.obric.capabilitykit.common.intent.BaseMemoryDeleteIntent, com.obric.capabilitykit.common.intent.IntentFunction
    public /* synthetic */ Object doAction(Parcelable r3, DispatchContext r4, Continuation<? super IntentResult<AppEntity[]>> r5) {
        Parcelable r6 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.memorydata.plugin");
        Continuation<? super IntentResult<AppEntity[]>> r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        return doAction((MemoryDeleteParams) ZeusTransformUtils.preCheckCast(r6, MemoryDeleteParams.class, "com.obric.memorydata.plugin"), r4, r7);
    }

    @Override // com.obric.capabilitykit.common.intent.BaseMemoryDeleteIntent
    public Object doAction(MemoryDeleteParams r18, DispatchContext r19, Continuation<? super IntentResult<AppEntity[]>> r20) {
        Continuation r0 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r20, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r0, AnonymousClass1.class) == false) goto L7;
        AnonymousClass1 r2 = (AnonymousClass1) ZeusTransformUtils.preCheckCast(r0, AnonymousClass1.class, "com.obric.memorydata.plugin");
        if ((r2.label & Integer.MIN_VALUE) == 0) goto L7;
        r2.label -= Integer.MIN_VALUE;
    L8:
        Object r1 = r2.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r2.label;
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L13;
        ResultKt.throwOnFailure(r1);
    L20:
        List r5 = (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin");
        g.f10488a.a((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.memorydata.plugin"));
        return new IntentResult(0, ((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.memorydata.plugin")).toArray(new AppEntity[0]), null, null, false, false, 0, null, null, null, PointerIconCompat.TYPE_GRAB, null);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r1);
        RunLog.INSTANCE.debug(TAG, "DeleteMemoryIntent doAction params: " + r18.getTargets());
        TargetEntity.a r6 = TargetEntity.Companion;
        String r7 = r18.getTargets();
        if (r7 != null) goto L17;
        r7 = "";
    L17:
        List<TargetEntity> r8 = r6.a(r7);
        f r9 = f.f11537a;
        String r10 = MemoryEventTracker.DeleteMethod.QUERY_DELETE.getValue();
        r2.label = 1;
        r1 = r9.a(r8, r10, r2);
        if (r1 != r3) goto L20;
        return r3;
    L7:
        r2 = new AnonymousClass1(this, r0);
        goto L8
    }
}
