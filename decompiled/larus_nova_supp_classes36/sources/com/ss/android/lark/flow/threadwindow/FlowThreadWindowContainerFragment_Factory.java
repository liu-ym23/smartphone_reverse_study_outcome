package com.ss.android.lark.flow.threadwindow;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FlowThreadWindowContainerFragment_Factory implements Factory<FlowThreadWindowContainerFragment> {

    public static final class a {
        public static final FlowThreadWindowContainerFragment_Factory a = null;

        static {
            a = new FlowThreadWindowContainerFragment_Factory();
        }
    }

    public FlowThreadWindowContainerFragment_Factory() {
    }

    public static FlowThreadWindowContainerFragment newInstance() {
        return new FlowThreadWindowContainerFragment();
    }

    public FlowThreadWindowContainerFragment get() {
        return newInstance();
    }

    public static FlowThreadWindowContainerFragment_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m516get() {
        return get();
    }
}
