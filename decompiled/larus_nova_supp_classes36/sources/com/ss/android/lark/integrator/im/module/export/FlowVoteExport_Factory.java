package com.ss.android.lark.integrator.im.module.export;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FlowVoteExport_Factory implements Factory<enb.a> {

    public static final class a {
        public static final FlowVoteExport_Factory a = null;

        static {
            a = new FlowVoteExport_Factory();
        }
    }

    public FlowVoteExport_Factory() {
    }

    public static enb.a newInstance() {
        return new enb.a();
    }

    public enb.a get() {
        return newInstance();
    }

    public static FlowVoteExport_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m928get() {
        return get();
    }
}
