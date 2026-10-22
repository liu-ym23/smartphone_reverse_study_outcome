package com.obric.memorydata.awareness.impl.producer;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.entity.EventBody;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.task.impl.TaskRequest;
import com.obric.memorydata.task.impl.TaskResult;
import com.obric.memorydata.utils.y;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\u0006H\u0016J2\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\r2\u0016\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\fH\u0016J \u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u000e\u001a\u00020\u0006H\u0016R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0019"}, d2 = {"Lcom/obric/memorydata/awareness/impl/producer/PapayaFeatureProducer;", "Lcom/obric/memorydata/awareness/impl/producer/AbstractFeatureProducer;", "<init>", "()V", "features", "", "", "getFeatures", "()Ljava/util/Set;", "needCacheFeatures", "getNeedCacheFeatures", "getFeatureExtra", "", "", "featureName", "setFeature", "", EventBody.KEY_VALUE, WsConstants.KEY_EXTRA, "buildPreciseHarExtra", "output", "Lorg/json/JSONObject;", "hasDefineFeature", "", "Companion", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class e extends com.obric.memorydata.awareness.impl.producer.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f8748b = null;
    private final Set<String> c;
    private final Set<String> d;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/obric/memorydata/awareness/impl/producer/PapayaFeatureProducer$Companion;", "", "<init>", "()V", "TAG", "", "PAPAYA_FEATURE_PREFIX", "TASK_PROCESS_HAR_STATUS", "PARAM_TYPE", "PARAM_TYPE_GET_PRECISE_STATE", "PRECISE_HAR_STATE_EMPTY", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f8748b = new a(null);
    }

    public e() {
        this.c = (Set) ZeusTransformUtils.preCheckCast(SetsKt.hashSetOf(new String[]{"ohr_hand", "har_activity_state", "wake_sleep_state", "precise_har_state"}), Set.class, "com.obric.memorydata.plugin");
        this.d = (Set) ZeusTransformUtils.preCheckCast(new HashSet(), Set.class, "com.obric.memorydata.plugin");
    }

    private static final Map a(String r4, Map r5, Exception r6) {
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "it");
        RunLog.INSTANCE.error("PapayaFeatureProducer", "getFeatureExtra(" + r4 + ") exception", (Throwable) ZeusTransformUtils.preCheckCast(r6, Throwable.class, "com.obric.memorydata.plugin"));
        return r7;
    }

    private static final Map a(Map r7, e r8) {
        Map r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.memorydata.plugin");
        JSONObject r0 = new JSONObject().put("type", "get_precise_state");
        TaskRequest.Builder r2 = new TaskRequest.Builder("process_har_status");
        Intrinsics.checkNotNull(r0);
        TaskResult r1 = ((TaskRequest) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(r2.setInputParam(r0), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).build(), TaskRequest.class, "com.obric.memorydata.plugin")).execute();
        if (r1.getCode() == 0) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PapayaFeatureProducer", "process_har_status failed: code=" + r1.getCode() + " msg=" + r1.getMsg(), null, 4, null);
        return r9;
    L6:
        return r8.a(r1.getOutput());
    }

    private final Map<String, Object> a(JSONObject r2) {
        JSONObject r1 = r2.optJSONObject(WsConstants.KEY_EXTRA);
        if (r1 != null) goto L5;
        return null;
    L5:
        JSONObject r3 = r1.optJSONObject("total_exercise_duration");
        if (r3 != null) goto L9;
        return null;
    L9:
        return MapsKt.mapOf(TuplesKt.to("total_exercise_duration", r3.toString()));
    }

    public static /* synthetic */ Map lambda$9eXfMdqk5cM_Ib8_2fun5PE9B1Q(String r0, Map r1, Exception r2) {
        return a(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$rATHSo-3QktD4BBhhhcRrHMS3_0, reason: not valid java name */
    public static /* synthetic */ Map m523lambda$rATHSo3QktD4BBhhhcRrHMS3_0(Map r0, e r1) {
        return a(r0, r1);
    }

    @Override // com.obric.memorydata.awareness.impl.producer.a
    public Set<String> b() {
        return this.c;
    }

    @Override // com.obric.memorydata.awareness.impl.producer.a, com.obric.memorydata.awareness.api.b
    public Map<String, Object> getFeatureExtra(final String r3) {
        Intrinsics.checkNotNullParameter(r3, "featureName");
        if (Intrinsics.areEqual(r3, "precise_har_state") == false) goto L7;
        final Map<String, Object> r0 = super.getFeatureExtra(r3);
        return (Map) ZeusTransformUtils.preCheckCast(y.a(new $$Lambda$e$9eXfMdqk5cM_Ib8_2fun5PE9B1Q(r3, r0), new $$Lambda$e$rATHSo3QktD4BBhhhcRrHMS3_0(r0, this)), Map.class, "com.obric.memorydata.plugin");
    L7:
        return super.getFeatureExtra(r3);
    }

    @Override // com.obric.memorydata.awareness.impl.producer.a, com.obric.memorydata.awareness.api.b
    public boolean hasDefineFeature(String r4) {
        Intrinsics.checkNotNullParameter(r4, "featureName");
        if (b().contains(r4) == false) goto L7;
        return true;
    L7:
        return StringsKt.startsWith$default(r4, "papaya", false, 2, null);
    }

    @Override // com.obric.memorydata.awareness.impl.producer.a, com.obric.memorydata.awareness.api.b
    public void setFeature(String r3, Object r4, Map<String, ? extends Object> r5) {
        Map<String, ? extends Object> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "featureName");
        if (Intrinsics.areEqual(r3, "precise_har_state") == false) goto L13;
        if (r4 != null) goto L13;
        Object r7 = super.getFeature(r3);
        if (ZeusTransformUtils.instanceOf(r7, String.class) == false) goto L8;
        String r8 = (String) ZeusTransformUtils.preCheckCast(r7, String.class, "com.obric.memorydata.plugin");
    L9:
        if (r8 != null) goto L11;
        r8 = "";
    L11:
        super.setFeature(r3, r8, r6);
        return;
    L8:
        r8 = null;
    L13:
        super.setFeature(r3, r4, r6);
    }
}
