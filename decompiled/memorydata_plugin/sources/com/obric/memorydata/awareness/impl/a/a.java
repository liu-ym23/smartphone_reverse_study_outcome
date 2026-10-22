package com.obric.memorydata.awareness.impl.a;

import com.bytedance.common.wschannel.WsConstants;
import com.obric.memorydata.utils.u;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ<\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0016\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\u0011H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/obric/memorydata/awareness/impl/policy/AlgorithmPackageFeatureEventPolicy;", "Lcom/obric/memorydata/awareness/impl/policy/FeatureEventPolicy;", "packageConfig", "Lcom/obric/aikernel/res/metadata/config/PackageConfig;", "shouldRunAutoTrigger", "Lkotlin/Function0;", "", "<init>", "(Lcom/obric/aikernel/res/metadata/config/PackageConfig;Lkotlin/jvm/functions/Function0;)V", "evaluate", "", "feature", "", "oldValue", "", "newValue", "extras", "", "Companion", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final C0435a f8620a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.obric.aikernel.res.metadata.config.i f8621b;
    private final Function0<Boolean> c;

    /* JADX INFO: renamed from: com.obric.memorydata.awareness.impl.a.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/obric/memorydata/awareness/impl/policy/AlgorithmPackageFeatureEventPolicy$Companion;", "", "<init>", "()V", "TRIGGER_TYPE_FEATURE_EVENT_POLICY", "", "KEY_TRIGGER_TYPE", "KEY_FEATURE", "KEY_OLD_VALUE", "KEY_NEW_VALUE", "KEY_EXTRA", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class C0435a {
        private C0435a() {
        }

        public /* synthetic */ C0435a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f8620a = new C0435a(null);
    }

    public a(com.obric.aikernel.res.metadata.config.i r3, Function0<Boolean> r4) {
        Function0<Boolean> r5 = (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "packageConfig");
        Intrinsics.checkNotNullParameter(r5, "shouldRunAutoTrigger");
        this.f8621b = r3;
        this.c = r5;
    }

    @Override // com.obric.memorydata.awareness.impl.a.b
    public void a(String r5, Object r6, Object r7, Map<String, ? extends Object> r8) {
        Map r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "feature");
        JSONObject r1 = new JSONObject();
        r1.put("trigger_type", "feature_event_policy");
        r1.put("feature", r5);
        r1.put("oldValue", com.obric.memorydata.awareness.impl.g.a(r6));
        r1.put("newValue", com.obric.memorydata.awareness.impl.g.a(r7));
        if (r9 == null) goto L5;
        r1.put(WsConstants.KEY_EXTRA, new JSONObject(u.a(r9)));
    L5:
        com.obric.memorydata.awareness.task.b.f8794a.a(this.f8621b, r1, this.c);
    }
}
