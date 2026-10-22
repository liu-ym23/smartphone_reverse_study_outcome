package com.obric.memorydata.awareness;

import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\u0016B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005J\u000e\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005J\u0006\u0010\u0010\u001a\u00020\fJ\u001e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u00052\u000e\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/obric/memorydata/awareness/GeoFenceCallbackPolicy;", "", "<init>", "()V", "TAG", "", "INITIAL_STATE_SYNC_DURATION_MS", "", "FIRST_BREACH_MIN_AAR_VERSION", "classifier", "Lcom/obric/memorydata/awareness/GeoFenceCallbackClassifier;", "onBeforeUpsert", "", "fenceId", "runtimeVersion", "clear", "clearAll", "classifyCallback", "Lcom/obric/memorydata/awareness/GeoFenceCallbackPolicy$CallbackType;", "firstBreachProvider", "Lkotlin/Function0;", "", "CallbackType", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class GeoFenceCallbackPolicy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final GeoFenceCallbackPolicy f8500a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final b f8501b = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/awareness/GeoFenceCallbackPolicy$CallbackType;", "", "<init>", "(Ljava/lang/String;I)V", "INITIAL_STATE", "REAL_TRANSITION", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final enum CallbackType extends Enum<CallbackType> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ CallbackType[] $VALUES = null;
        public static final CallbackType INITIAL_STATE = null;
        public static final CallbackType REAL_TRANSITION = null;

        private static final /* synthetic */ CallbackType[] $values() {
            return new CallbackType[]{INITIAL_STATE, REAL_TRANSITION};
        }

        static {
            INITIAL_STATE = new CallbackType("INITIAL_STATE", 0);
            REAL_TRANSITION = new CallbackType("REAL_TRANSITION", 1);
            CallbackType[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
        }

        private CallbackType(String r1, int r2) {
            super(r1, r2);
        }

        public static EnumEntries<CallbackType> getEntries() {
            return $ENTRIES;
        }

        public static CallbackType valueOf(String r2) {
            return (CallbackType) ZeusTransformUtils.preCheckCast(Enum.valueOf(CallbackType.class, r2), CallbackType.class, "com.obric.memorydata.plugin");
        }

        public static CallbackType[] values() {
            return (CallbackType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), CallbackType[].class, "com.obric.memorydata.plugin");
        }
    }

    static {
        f8500a = new GeoFenceCallbackPolicy();
        f8501b = new b(60000, null, 2, null);
    }

    private GeoFenceCallbackPolicy() {
    }

    public final CallbackType a(String r7, Function0<Boolean> r8) {
        Function0<Boolean> r6 = (Function0) ZeusTransformUtils.wrapperContextForParams(r8, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "fenceId");
        Intrinsics.checkNotNullParameter(r6, "firstBreachProvider");
        CallbackType r9 = f8501b.a(r7, r6);
        if (r9 != CallbackType.INITIAL_STATE) goto L5;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "GeoFenceCallbackPolicy", "围栏回调按首次状态处理，fenceId=" + r7, false, 4, null);
    L5:
        return r9;
    }

    public final void a() {
        f8501b.a();
    }

    public final void a(String r1) {
        Intrinsics.checkNotNullParameter(r1, "fenceId");
        f8501b.a(r1);
    }

    public final void a(String r8, String r9) {
        Intrinsics.checkNotNullParameter(r8, "fenceId");
        boolean r7 = false;
        if (r9 != null) goto L5;
    L7:
        f8501b.a(r8, r7);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "GeoFenceCallbackPolicy", "围栏首次回调门控已登记，fenceId=" + r8 + "，firstBreachSupported=" + r7 + "，runtimeVersion=" + r9, false, 4, null);
        return;
    L5:
        if (com.obric.memorydata.utils.d.f13204a.a(r9, "1.0.10.15") < 0) goto L7;
        r7 = true;
        goto L7
    }
}
