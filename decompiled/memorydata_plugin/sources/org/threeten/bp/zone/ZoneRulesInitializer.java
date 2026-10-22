package org.threeten.bp.zone;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes8.dex */
public abstract class ZoneRulesInitializer {
    public static final ZoneRulesInitializer DO_NOTHING = null;
    private static final AtomicBoolean INITIALIZED = null;
    private static final AtomicReference<ZoneRulesInitializer> INITIALIZER = null;

    static class DoNothingZoneRulesInitializer extends ZoneRulesInitializer {
        DoNothingZoneRulesInitializer() {
        }

        @Override // org.threeten.bp.zone.ZoneRulesInitializer
        public void initializeProviders() {
        }
    }

    static class ServiceLoaderZoneRulesInitializer extends ZoneRulesInitializer {
        ServiceLoaderZoneRulesInitializer() {
        }

        @Override // org.threeten.bp.zone.ZoneRulesInitializer
        public void initializeProviders() {
            Iterator r3 = ServiceLoader.load(ZoneRulesProvider.class, ZoneRulesProvider.class.getClassLoader()).iterator();
        L4:
            if (r3.hasNext() == false) goto L13;
            ZoneRulesProvider.registerProvider((ZoneRulesProvider) ZeusTransformUtils.preCheckCast(r3.next(), ZoneRulesProvider.class, "com.obric.memorydata.plugin"));     // Catch: ServiceConfigurationError -> L8
        L8:
            e = move-exception;
            if (ZeusTransformUtils.instanceOf(e.getCause(), SecurityException.class) == true) goto L4;
            throw e;
        }
    }

    static {
        DO_NOTHING = new DoNothingZoneRulesInitializer();
        INITIALIZED = new AtomicBoolean(false);
        INITIALIZER = new AtomicReference();
    }

    public ZoneRulesInitializer() {
    }

    static void initialize() {
        if (INITIALIZED.getAndSet(true) == true) goto L7;
        AtomicReference<ZoneRulesInitializer> r0 = INITIALIZER;
        r0.compareAndSet(null, new ServiceLoaderZoneRulesInitializer());
        ((ZoneRulesInitializer) ZeusTransformUtils.preCheckCast(r0.get(), ZoneRulesInitializer.class, "com.obric.memorydata.plugin")).initializeProviders();
        return;
    L7:
        throw new IllegalStateException("Already initialized");
    }

    public abstract void initializeProviders();
}
