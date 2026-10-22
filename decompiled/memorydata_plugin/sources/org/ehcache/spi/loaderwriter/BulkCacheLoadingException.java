package org.ehcache.spi.loaderwriter;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public class BulkCacheLoadingException extends CacheLoadingException {
    private static final long serialVersionUID = -5296309607929568779L;
    private final Map<?, Exception> failures;
    private final Map<?, ?> successes;

    public BulkCacheLoadingException(String r3, Map<Object, Exception> r4, Map<Object, Object> r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        super(r3);
        this.failures = Collections.unmodifiableMap(r6);
        this.successes = Collections.unmodifiableMap(r7);
    }

    public BulkCacheLoadingException(Map<?, Exception> r3, Map<?, ?> r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        this.failures = Collections.unmodifiableMap(r5);
        this.successes = Collections.unmodifiableMap(r6);
    }

    public Map<?, Exception> getFailures() {
        return this.failures;
    }

    public Map<?, ?> getSuccesses() {
        return this.successes;
    }
}
