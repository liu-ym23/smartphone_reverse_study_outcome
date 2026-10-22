package org.ehcache.impl.internal.events;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.atomic.AtomicReference;
import org.ehcache.core.spi.store.a.a;

/* JADX INFO: loaded from: classes7.dex */
class FireableStoreEventHolder<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicReference<Status> f18091a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f18092b;
    private final a<K, V> c;

    static final enum Status extends Enum<Status> {
        private static final /* synthetic */ Status[] $VALUES = null;
        public static final Status CREATED = null;
        public static final Status FIREABLE = null;
        public static final Status FIRED = null;

        static {
            Status r0 = new Status("CREATED", 0);
            CREATED = r0;
            Status r1 = new Status("FIREABLE", 1);
            FIREABLE = r1;
            Status r3 = new Status("FIRED", 2);
            FIRED = r3;
            $VALUES = new Status[]{r0, r1, r3};
        }

        private Status(String r1, int r2) {
            super(r1, r2);
        }

        public static Status valueOf(String r2) {
            return (Status) ZeusTransformUtils.preCheckCast(Enum.valueOf(Status.class, r2), Status.class, "com.obric.memorydata.plugin");
        }

        public static Status[] values() {
            return (Status[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Status[].class, "com.obric.memorydata.plugin");
        }
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder().append("FireableStoreEventHolder in state ").append(this.f18091a.get()).append(" of ").append(this.c);
        if (this.f18092b == false) goto L5;
        String r2 = " (failed)";
    L7:
        return r0.append(r2).toString();
    L5:
        r2 = " (not failed)";
        goto L7
    }
}
