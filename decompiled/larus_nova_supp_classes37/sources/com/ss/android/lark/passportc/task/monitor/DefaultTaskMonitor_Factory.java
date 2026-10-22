package com.ss.android.lark.passportc.task.monitor;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class DefaultTaskMonitor_Factory implements Factory<l0c.a> {

    public static final class a {
        public static final DefaultTaskMonitor_Factory a = null;

        static {
            a = new DefaultTaskMonitor_Factory();
        }
    }

    public DefaultTaskMonitor_Factory() {
    }

    public static l0c.a newInstance() {
        return new l0c.a();
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m754get();
    }

    public static DefaultTaskMonitor_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public l0c.a m754get() {
        return newInstance();
    }
}
