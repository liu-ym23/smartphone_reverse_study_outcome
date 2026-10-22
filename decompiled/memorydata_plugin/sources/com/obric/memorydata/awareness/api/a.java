package com.obric.memorydata.awareness.api;

import com.bytedance.common.wschannel.WsConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J*\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0018\b\u0002\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\tH&J<\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u00012\b\u0010\r\u001a\u0004\u0018\u00010\u00012\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\tH&J<\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u00012\b\u0010\r\u001a\u0004\u0018\u00010\u00012\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\tH\u0016¨\u0006\u000f"}, d2 = {"Lcom/obric/memorydata/awareness/api/EventListener;", "", "observable", "", "onEvent", "", "eventName", "", WsConstants.KEY_EXTRA, "", "onFeatureChanged", "feature", "oldValue", "newValue", "onFeatureEvent", "awareness_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface a {

    /* JADX INFO: renamed from: com.obric.memorydata.awareness.api.a$a, reason: collision with other inner class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class C0430a {
        public static void a(a r0, String r1, Object r2, Object r3, Map<String, ? extends Object> r4) {
            a r5 = (a) ZeusTransformUtils.wrapperContextForParams(r0, a.class, "com.obric.memorydata.plugin");
            Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r1, "feature");
        }

        public static boolean a(a r2) {
            a r3 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.memorydata.plugin");
            return false;
        }
    }

    void a(String r1, Object r2, Object r3, Map<String, ? extends Object> r4);

    void a(String r1, Map<String, ? extends Object> r2);

    boolean a();

    void b(String r1, Object r2, Object r3, Map<String, ? extends Object> r4);
}
