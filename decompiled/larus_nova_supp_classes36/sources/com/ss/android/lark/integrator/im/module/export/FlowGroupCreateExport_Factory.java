package com.ss.android.lark.integrator.im.module.export;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FlowGroupCreateExport_Factory implements Factory<FlowGroupCreateExport> {

    public static final class a {
        public static final FlowGroupCreateExport_Factory a = null;

        static {
            a = new FlowGroupCreateExport_Factory();
        }
    }

    public FlowGroupCreateExport_Factory() {
    }

    public static FlowGroupCreateExport newInstance() {
        return new FlowGroupCreateExport();
    }

    public FlowGroupCreateExport get() {
        return newInstance();
    }

    public static FlowGroupCreateExport_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m927get() {
        return get();
    }
}
