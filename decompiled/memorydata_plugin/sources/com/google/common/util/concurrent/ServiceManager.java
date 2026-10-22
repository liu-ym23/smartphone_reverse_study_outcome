package com.google.common.util.concurrent;

import com.google.common.base.Predicates;
import com.google.common.collect.ImmutableList;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public final class ServiceManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Logger f4827a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final o.a<a> f4828b = null;
    private static final o.a<a> c = null;
    private final ImmutableList<Service> d;

    private static final class EmptyServiceManagerWarning extends Throwable {
        private EmptyServiceManagerWarning() {
        }

        /* synthetic */ EmptyServiceManagerWarning(AnonymousClass1 r1) {
            this();
        }
    }

    private static final class FailedService extends Throwable {
        FailedService(Service r3) {
            Service r4 = (Service) ZeusTransformUtils.wrapperContextForParams(r3, Service.class, "com.obric.memorydata.plugin");
            super(r4.toString(), r4.b(), false, false);
        }
    }

    public static abstract class a {
        public a() {
        }

        public void a() {
        }

        public void b() {
        }
    }

    private static final class b extends com.google.common.util.concurrent.b {
        private b() {
        }
    }

    static {
        f4827a = Logger.getLogger(ServiceManager.class.getName());
        f4828b = new AnonymousClass1();
        c = new AnonymousClass2();
    }

    public String toString() {
        return com.google.common.base.i.a(ServiceManager.class).a("services", com.google.common.collect.q.a(this.d, Predicates.a(Predicates.a(b.class)))).toString();
    }
}
