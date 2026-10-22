package com.obric.memorydata.awareness.api;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0004H&J \u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0004H&J \u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0004H&J4\u0010\b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u00012\u0018\b\u0002\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0006H&J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0004H&J\u001e\u0010\u000e\u001a\u00020\t2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00102\u0006\u0010\u0011\u001a\u00020\rH&¨\u0006\u0012"}, d2 = {"Lcom/obric/memorydata/awareness/api/IFeatureProducer;", "", "getFeature", "featureName", "", "getFeatureExtra", "", "getFeatureValueAndExtra", "setFeature", "", EventBody.KEY_VALUE, WsConstants.KEY_EXTRA, "hasDefineFeature", "", "collectFeatures", "featureNames", "", "collect", "awareness_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface b {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        public static /* synthetic */ void a(b r2, String r3, Object r4, Map r5, int r6, Object r7) {
            b r8 = (b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.memorydata.plugin");
            Map<String, ? extends Object> r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
            if (r7 != null) goto L10;
            if ((r6 & 4) == 0) goto L7;
            r9 = null;
        L7:
            r8.setFeature(r3, r4, r9);
            return;
        L10:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setFeature");
        }
    }

    void collectFeatures(List<String> r1, boolean r2);

    Object getFeature(String r1);

    Map<String, Object> getFeatureExtra(String r1);

    Map<String, Object> getFeatureValueAndExtra(String r1);

    boolean hasDefineFeature(String r1);

    void setFeature(String r1, Object r2, Map<String, ? extends Object> r3);
}
