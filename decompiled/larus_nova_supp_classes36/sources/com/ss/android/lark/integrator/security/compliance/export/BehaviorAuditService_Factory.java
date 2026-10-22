package com.ss.android.lark.integrator.security.compliance.export;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class BehaviorAuditService_Factory implements Factory<com.ss.android.lark.integrator.security.compliance.export.a> {

    public static final class a {
        public static final BehaviorAuditService_Factory a = null;

        static {
            a = new BehaviorAuditService_Factory();
        }
    }

    public BehaviorAuditService_Factory() {
    }

    public static com.ss.android.lark.integrator.security.compliance.export.a newInstance() {
        return new com.ss.android.lark.integrator.security.compliance.export.a();
    }

    public com.ss.android.lark.integrator.security.compliance.export.a get() {
        return newInstance();
    }

    public static BehaviorAuditService_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m939get() {
        return get();
    }
}
