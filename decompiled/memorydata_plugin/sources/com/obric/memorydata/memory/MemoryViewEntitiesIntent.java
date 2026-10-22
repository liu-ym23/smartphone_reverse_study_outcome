package com.obric.memorydata.memory;

import android.content.Context;
import android.os.Parcelable;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.intent.BaseCommonViewEntitiesIntent;
import com.obric.capabilitykit.common.intent.CommonViewEntitiesParams;
import com.obric.capabilitykit.common.intent.Empty;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.AuditoryRecordingEntity;
import com.obric.capabilitykit.entity.app.ProactiveMemoryEntity;
import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.obric.memorydata.database.entity.AutoMemoryProEntity;
import com.obric.memorydata.database.entity.fj;
import com.obric.memorydata.memory.tracker.MemoryEventTracker;
import com.obric.memorydata.memory.ui.automemory.AutoMemoryDetailActivity;
import com.obric.memorydata.memory.ui.detail.MemoryDetailActivity;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0096@¢\u0006\u0002\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/memory/MemoryViewEntitiesIntent;", "Lcom/obric/capabilitykit/common/intent/BaseCommonViewEntitiesIntent;", "<init>", "()V", "doAction", "Lcom/obric/capabilitykit/common/intent/IntentResult;", "Lcom/obric/capabilitykit/common/intent/Empty;", TrackerImpl.PARAMS, "Lcom/obric/capabilitykit/common/intent/CommonViewEntitiesParams;", "dispatchContext", "Lcom/obric/capabilitykit/common/DispatchContext;", "(Lcom/obric/capabilitykit/common/intent/CommonViewEntitiesParams;Lcom/obric/capabilitykit/common/DispatchContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MemoryViewEntitiesIntent extends BaseCommonViewEntitiesIntent {
    public static final a Companion = null;
    private static final String TAG = "MemoryViewEntitiesIntent";

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/memory/MemoryViewEntitiesIntent$Companion;", "", "<init>", "()V", "TAG", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new a(null);
    }

    public MemoryViewEntitiesIntent() {
    }

    private static final boolean doAction$lambda$2$lambda$0(Exception r1) {
        Intrinsics.checkNotNullParameter(r1, "error");
        return false;
    }

    private static final boolean doAction$lambda$2$lambda$1(String r2) {
        return new JSONObject(r2).optBoolean(AutoMemoryProEntity.IS_AUTO_MEMORY_PRO_EXTRA_KEY, false);
    }

    public static /* synthetic */ boolean lambda$0r_9ay445FYPmtA4IenEWEYjaUc(Exception r0) {
        return doAction$lambda$2$lambda$0(r0);
    }

    /* JADX INFO: renamed from: lambda$vp-b9Yqx0idcsqf1UFcH89CALRs, reason: not valid java name */
    public static /* synthetic */ boolean m689lambda$vpb9Yqx0idcsqf1UFcH89CALRs(String r0) {
        return doAction$lambda$2$lambda$1(r0);
    }

    @Override // com.obric.capabilitykit.common.intent.BaseCommonViewEntitiesIntent, com.obric.capabilitykit.common.intent.IntentFunction
    public /* synthetic */ Object doAction(Parcelable r3, DispatchContext r4, Continuation<? super IntentResult<Empty>> r5) {
        Parcelable r6 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.memorydata.plugin");
        Continuation<? super IntentResult<Empty>> r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        return doAction((CommonViewEntitiesParams) ZeusTransformUtils.preCheckCast(r6, CommonViewEntitiesParams.class, "com.obric.memorydata.plugin"), r4, r7);
    }

    @Override // com.obric.capabilitykit.common.intent.BaseCommonViewEntitiesIntent
    public Object doAction(CommonViewEntitiesParams r37, DispatchContext r38, Continuation<? super IntentResult<Empty>> r39) {
        Continuation r0 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r39, Continuation.class, "com.obric.memorydata.plugin");
        Integer r1 = r37.getIndex();
        AppEntity[] r11 = r37.getEntities();
        RunLog r12 = RunLog.INSTANCE;
        StringBuilder r13 = new StringBuilder().append("entities: ");
        AppEntity r14 = null;
        if (r11 == null) goto L5;
        String r2 = ArraysKt.joinToString$default(r11, null, null, null, 0, null, null, 63, null);
    L6:
        r12.debug(TAG, r13.append(r2).toString());
        if (r1 == null) goto L69;
        boolean r3 = false;
        if (r11 != null) goto L11;
    L17:
        boolean r4 = true;
    L18:
        if (r4 == true) goto L69;
        if (r1.intValue() < 0) goto L69;
        if (r1.intValue() >= r11.length) goto L69;
        AppEntity r5 = r11[r1.intValue()];
        if (ZeusTransformUtils.instanceOf(r5, MemoryEntity.class) == false) goto L32;
        MemoryEntity r6 = com.obric.memorydata.memory.utils.f.f11537a.a(r5.getId(), Boxing.boxInt(r5.getType()));
        if (r6 == null) goto L30;
        MemoryDetailActivity.Companion.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r38.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r6, MemoryEventTracker.SourceType.ASSISTANT_AGENT.getValue(), true);
        return new IntentResult(0, null, null, null, false, false, 9, null, null, null, 958, null);
    L30:
        return new IntentResult(200, null, null, null, false, false, 0, null, null, null, 1022, null);
    L32:
        if (ZeusTransformUtils.instanceOf(r5, AuditoryRecordingEntity.class) == false) goto L43;
        fj r7 = com.obric.memorydata.memory.utils.f.f11537a.b(r5.getId());
        if (r7 == null) goto L36;
        r14 = r7.convertToAppEntity();
    L36:
        AppEntity r8 = r14;
        if (r8 == null) goto L41;
        MemoryEventTracker.f10515a.a(r8, MemoryEventTracker.ReactionType.DETAIL.getValue(), MemoryEventTracker.SourceType.ASSISTANT_AGENT.getValue());
        com.obric.memorydata.memory.utils.f.f11537a.b(r8);
        MemoryEventTracker.a(MemoryEventTracker.f10515a, r8, MemoryEventTracker.SourceType.ASSISTANT_AGENT.getValue(), MemoryEventTracker.MemoryPage.MEMORY_DETAIL.getValue(), null, null, null, null, 120, null);
        return new IntentResult(0, null, null, null, false, false, 9, null, null, null, 958, null);
    L41:
        return new IntentResult(200, null, null, null, false, false, 0, null, null, null, 1022, null);
    L43:
        if (ZeusTransformUtils.instanceOf(r5, ProactiveMemoryEntity.class) == false) goto L69;
        final String r9 = r5.getExtraData();
        if (r9 != null) goto L47;
    L55:
        if (r3 == false) goto L62;
        AutoMemoryProEntity r10 = com.obric.memorydata.memory.utils.f.f11537a.d(r5.getId());
        if (r10 == null) goto L60;
        AutoMemoryDetailActivity.Companion.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r38.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r10.getId(), true);
        return new IntentResult(0, null, null, null, false, false, 9, null, null, null, 958, null);
    L60:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "auto memory pro entity not exist, entityId: " + r5.getId(), null, 4, null);
        return new IntentResult(200, null, null, null, false, false, 0, null, null, null, 1022, null);
    L62:
        ProactiveMemoryEntity r15 = com.obric.memorydata.memory.utils.f.f11537a.c(r5.getId());
        if (r15 == null) goto L67;
        MemoryDetailActivity.Companion.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r38.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r15.getId(), MemoryEventTracker.SourceType.ASSISTANT_AGENT.getValue(), true);
        return new IntentResult(0, null, null, null, false, false, 9, null, null, null, 958, null);
    L67:
        return new IntentResult(200, null, null, null, false, false, 0, null, null, null, 1022, null);
    L47:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L49;
        boolean r16 = true;
    L50:
        if (r16 == false) goto L52;
        Boolean r17 = (Boolean) ZeusTransformUtils.preCheckCast(com.obric.memorydata.utils.y.a($$Lambda$MemoryViewEntitiesIntent$0r_9ay445FYPmtA4IenEWEYjaUc.INSTANCE, new $$Lambda$MemoryViewEntitiesIntent$vpb9Yqx0idcsqf1UFcH89CALRs(r9)), Boolean.class, "com.obric.memorydata.plugin");
    L53:
        if (r17 == null) goto L55;
        r3 = r17.booleanValue();
        goto L55
    L52:
        r17 = Boxing.boxBoolean(false);
        goto L53
    L49:
        r16 = false;
        goto L50
    L11:
        if (r11.length != 0) goto L13;
        boolean r18 = true;
    L14:
        if (r18 == true) goto L17;
        r4 = false;
        goto L18
    L13:
        r18 = false;
    L69:
        return new IntentResult(103, null, null, null, false, false, 0, null, null, null, 1022, null);
    L5:
        r2 = null;
        goto L6
    }
}
