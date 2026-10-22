package com.ss.android.lark.passport.monitor;

import dagger.internal.Factory;
import zyb.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class NoopEnterAppFlowMonitorService_Factory implements Factory<f> {

    public static final class a {
        public static final NoopEnterAppFlowMonitorService_Factory a = null;

        static {
            a = new NoopEnterAppFlowMonitorService_Factory();
        }
    }

    public NoopEnterAppFlowMonitorService_Factory() {
    }

    public static f newInstance() {
        return new f();
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m682get();
    }

    public static NoopEnterAppFlowMonitorService_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public f m682get() {
        return newInstance();
    }
}
