package org.apache.commons.io.function;

/* JADX INFO: loaded from: classes6.dex */
@FunctionalInterface
public interface IOConsumer<T> {
    public static final IOConsumer<?> NOOP_IO_CONSUMER = null;

    static {
        NOOP_IO_CONSUMER = $$Lambda$IOConsumer$QCJxqcoIMMx1cnJzixOrvr6Gtmc.INSTANCE;
    }

    static /* synthetic */ void lambda$static$0(Object r0) {
    }

    void accept(T r1);
}
