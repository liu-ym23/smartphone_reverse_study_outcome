package org.ehcache.impl.internal.store.offheap;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.ByteBuffer;
import org.ehcache.spi.serialization.SerializerException;
import org.ehcache.spi.serialization.b;

/* JADX INFO: loaded from: classes7.dex */
public class LazyOffHeapValueHolder<V> extends a<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b<V> f18093a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ByteBuffer f18094b;
    private V c;

    private static final enum Mode extends Enum<Mode> {
        private static final /* synthetic */ Mode[] $VALUES = null;
        public static final Mode ATTACHED = null;
        public static final Mode DETACHED = null;

        static {
            Mode r0 = new Mode("ATTACHED", 0);
            ATTACHED = r0;
            Mode r1 = new Mode("DETACHED", 1);
            DETACHED = r1;
            $VALUES = new Mode[]{r0, r1};
        }

        private Mode(String r1, int r2) {
            super(r1, r2);
        }

        public static Mode valueOf(String r2) {
            return (Mode) ZeusTransformUtils.preCheckCast(Enum.valueOf(Mode.class, r2), Mode.class, "com.obric.memorydata.plugin");
        }

        public static Mode[] values() {
            return (Mode[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Mode[].class, "com.obric.memorydata.plugin");
        }
    }

    @Override // org.ehcache.impl.internal.store.offheap.a
    void a() {
        if (this.c != null) goto L6;
        this.c = b();
        return;
    }

    V b() {
        return this.f18093a.a(this.f18094b.duplicate());
    L7:
        e = move-exception;
        throw new SerializerException(e);
    L4:
        e = move-exception;
        throw new SerializerException("Seeing this exception and having no other serialization related issues is a red flag!", e);
    }

    @Override // org.ehcache.core.spi.store.Store.d, java.util.function.Supplier
    public V get() {
        a();
        return this.c;
    }
}
