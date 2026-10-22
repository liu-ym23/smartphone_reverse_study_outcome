package org.ehcache.impl.config;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;
import org.ehcache.config.ResourceType;
import org.ehcache.config.h;

/* JADX INFO: loaded from: classes7.dex */
public abstract class a<P extends h, T extends ResourceType<P>> implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final T f18064a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f18065b;

    public a(T r3, boolean r4) {
        T r5 = (T) ZeusTransformUtils.wrapperContextForParams(r3, ResourceType.class, "com.obric.memorydata.plugin");
        Objects.requireNonNull(r5, "ResourceType may not be null");
        this.f18064a = r5;
        this.f18065b = r4;
    }

    @Override // org.ehcache.config.h
    public boolean a() {
        return this.f18065b;
    }

    @Override // org.ehcache.config.h
    public T getType() {
        return this.f18064a;
    }
}
