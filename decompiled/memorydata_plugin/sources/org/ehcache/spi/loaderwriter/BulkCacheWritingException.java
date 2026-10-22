package org.ehcache.spi.loaderwriter;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes7.dex */
public class BulkCacheWritingException extends CacheWritingException {
    private static final long serialVersionUID = -9019459887947633422L;
    private final Map<?, Exception> failures;
    private final Set<?> successes;

    public BulkCacheWritingException(Map<?, Exception> r3, Set<?> r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        Set r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin");
        this.failures = Collections.unmodifiableMap(r5);
        this.successes = Collections.unmodifiableSet(r6);
    }

    static /* synthetic */ void lambda$getMessage$0(StringBuilder r1, Object r2, Exception r3) {
        r1.append("\n ").append(r2).append(" : ").append(r3);
    }

    public Map<?, Exception> getFailures() {
        return this.failures;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        final StringBuilder r0 = new StringBuilder((this.failures.size() * 20) + 13);
        r0.append("Failed keys:");
        this.failures.forEach(new $$Lambda$BulkCacheWritingException$kNljgnBXNFt1Rj5s422vEg4sBRg(r0));
        return r0.toString();
    }

    public Set<?> getSuccesses() {
        return this.successes;
    }
}
