package org.apache.logging.log4j.spi;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.apache.logging.log4j.util.PropertiesUtil;
import org.apache.logging.log4j.util.ReadOnlyStringMap;
import org.apache.logging.log4j.util.SortedArrayStringMap;
import org.apache.logging.log4j.util.StringMap;

/* JADX INFO: loaded from: classes6.dex */
class d implements k, m {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile int f17900b;
    private static volatile boolean c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final ThreadLocal<StringMap> f17901a;

    static {
        a();
    }

    public d() {
        this.f17901a = b();
    }

    static void a() {
        PropertiesUtil r0 = PropertiesUtil.a();
        f17900b = r0.a("log4j2.ThreadContext.initial.capacity", 16);
        c = r0.a(DefaultThreadContextMap.INHERITABLE_MAP);
    }

    private ThreadLocal<StringMap> b() {
        if (c == false) goto L7;
        return new AnonymousClass1(this);
    L7:
        return new ThreadLocal();
    }

    public StringMap a(ReadOnlyStringMap r2) {
        return new SortedArrayStringMap((ReadOnlyStringMap) ZeusTransformUtils.wrapperContextForParams(r2, ReadOnlyStringMap.class, "com.obric.memorydata.plugin"));
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L6;
        return true;
    L6:
        if (r3 != null) goto L9;
        return false;
    L9:
        if (ZeusTransformUtils.instanceOf(r3, n.class) == true) goto L11;
        return false;
    L11:
        n r4 = (n) ZeusTransformUtils.preCheckCast(r3, n.class, "com.obric.memorydata.plugin");
        return Objects.equals(getImmutableMapOrNull(), r4.getImmutableMapOrNull());
    }

    @Override // org.apache.logging.log4j.spi.n
    public Map<String, String> getCopy() {
        StringMap r2 = (StringMap) ZeusTransformUtils.preCheckCast(this.f17901a.get(), StringMap.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L6;
        return new HashMap();
    L6:
        return r2.toMap();
    }

    @Override // org.apache.logging.log4j.spi.n
    public Map<String, String> getImmutableMapOrNull() {
        StringMap r2 = (StringMap) ZeusTransformUtils.preCheckCast(this.f17901a.get(), StringMap.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L6;
        return null;
    L6:
        return Collections.unmodifiableMap(r2.toMap());
    }

    public int hashCode() {
        StringMap r2 = (StringMap) ZeusTransformUtils.preCheckCast(this.f17901a.get(), StringMap.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L5;
        int r3 = 0;
    L7:
        return 31 + r3;
    L5:
        r3 = r2.hashCode();
        goto L7
    }

    public String toString() {
        StringMap r2 = (StringMap) ZeusTransformUtils.preCheckCast(this.f17901a.get(), StringMap.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L6;
        return "{}";
    L6:
        return r2.toString();
    }
}
