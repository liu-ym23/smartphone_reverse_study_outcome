package org.ehcache.impl.internal.store.offheap;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public abstract class a<V> extends org.ehcache.core.spi.store.a<V> {
    abstract void a();

    @Override // org.ehcache.core.spi.store.a
    public boolean equals(Object r4) {
        if (this != r4) goto L7;
        return true;
    L7:
        if (r4 != null) goto L9;
    L16:
        return false;
    L9:
        if (ZeusTransformUtils.instanceOf(r4, a.class) == false) goto L16;
        a r5 = (a) ZeusTransformUtils.preCheckCast(r4, a.class, "com.obric.memorydata.plugin");
        if (super.equals(r5) == true) goto L15;
        return false;
    L15:
        return get().equals(r5.get());
    }

    @Override // org.ehcache.core.spi.store.a
    public int hashCode() {
        return ((get().hashCode() + 31) * 31) + super.hashCode();
    }
}
