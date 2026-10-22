package com.ss.android.lark.passport.monitor;

import dagger.internal.Factory;
import zyb.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class NoopSwitchMonitorService_Factory implements Factory<g> {

    public static final class a {
        public static final NoopSwitchMonitorService_Factory a = null;

        static {
            a = new NoopSwitchMonitorService_Factory();
        }
    }

    public NoopSwitchMonitorService_Factory() {
    }

    public static g newInstance() {
        return new g();
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m683get();
    }

    public static NoopSwitchMonitorService_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public g m683get() {
        return newInstance();
    }
}
