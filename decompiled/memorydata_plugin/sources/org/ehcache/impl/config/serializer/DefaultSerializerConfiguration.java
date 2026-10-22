package org.ehcache.impl.config.serializer;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.ehcache.impl.internal.a.a;
import org.ehcache.spi.serialization.b;
import org.ehcache.spi.service.d;

/* JADX INFO: loaded from: classes7.dex */
public class DefaultSerializerConfiguration<T> extends a<b<T>> implements d<org.ehcache.spi.serialization.a, Void> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Type f18073a;

    public static final enum Type extends Enum<Type> {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final Type KEY = null;
        public static final Type VALUE = null;

        static {
            Type r0 = new Type("KEY", 0);
            KEY = r0;
            Type r1 = new Type("VALUE", 1);
            VALUE = r1;
            $VALUES = new Type[]{r0, r1};
        }

        private Type(String r1, int r2) {
            super(r1, r2);
        }

        public static Type valueOf(String r2) {
            return (Type) ZeusTransformUtils.preCheckCast(Enum.valueOf(Type.class, r2), Type.class, "com.obric.memorydata.plugin");
        }

        public static Type[] values() {
            return (Type[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Type[].class, "com.obric.memorydata.plugin");
        }
    }

    @Override // org.ehcache.spi.service.d
    public boolean a(d<?, ?> r4) {
        d<?, ?> r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r5, DefaultSerializerConfiguration.class) == false) goto L7;
        return !getType().equals(((DefaultSerializerConfiguration) ZeusTransformUtils.preCheckCast(r5, DefaultSerializerConfiguration.class, "com.obric.memorydata.plugin")).getType());
    L7:
        return super.a(r5);
    }

    @Override // org.ehcache.spi.service.d
    public Class<org.ehcache.spi.serialization.a> b() {
        return org.ehcache.spi.serialization.a.class;
    }

    public Type getType() {
        return this.f18073a;
    }
}
