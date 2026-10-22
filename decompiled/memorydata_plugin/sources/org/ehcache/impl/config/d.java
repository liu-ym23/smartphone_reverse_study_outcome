package org.ehcache.impl.config;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;
import org.ehcache.config.ResourceType;
import org.ehcache.config.j;
import org.ehcache.config.k;

/* JADX INFO: loaded from: classes7.dex */
public class d<P extends k> extends a<P, ResourceType<P>> implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f18071a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final j f18072b;

    public d(ResourceType<P> r3, long r4, j r6, boolean r7) {
        ResourceType r5 = (ResourceType) ZeusTransformUtils.wrapperContextForParams(r3, ResourceType.class, "com.obric.memorydata.plugin");
        j r8 = (j) ZeusTransformUtils.wrapperContextForParams(r6, j.class, "com.obric.memorydata.plugin");
        super(r5, r7);
        Objects.requireNonNull(r8, "ResourceUnit can not be null");
        if (r4 <= 0) goto L13;
        if (r5.isPersistable() == true) goto L10;
        if (r7 == false) goto L10;
        throw new IllegalStateException("Non-persistable resource cannot be configured persistent");
    L10:
        this.f18071a = r4;
        this.f18072b = r8;
        return;
    L13:
        throw new IllegalArgumentException("Size must be greater than 0");
    }

    @Override // org.ehcache.config.k
    public long b() {
        return this.f18071a;
    }

    @Override // org.ehcache.config.k
    public j c() {
        return this.f18072b;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder().append("Pool {").append(b()).append(" ").append(c()).append(" ").append(getType());
        if (a() == false) goto L5;
        String r3 = "(persistent)}";
    L7:
        return r0.append(r3).toString();
    L5:
        r3 = "}";
        goto L7
    }
}
