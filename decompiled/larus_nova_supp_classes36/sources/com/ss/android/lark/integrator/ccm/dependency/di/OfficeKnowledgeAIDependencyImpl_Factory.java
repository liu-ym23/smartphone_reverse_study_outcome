package com.ss.android.lark.integrator.ccm.dependency.di;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class OfficeKnowledgeAIDependencyImpl_Factory implements Factory<y0> {

    public static final class a {
        public static final OfficeKnowledgeAIDependencyImpl_Factory a = null;

        static {
            a = new OfficeKnowledgeAIDependencyImpl_Factory();
        }
    }

    public OfficeKnowledgeAIDependencyImpl_Factory() {
    }

    public static y0 newInstance() {
        return new y0();
    }

    public y0 get() {
        return newInstance();
    }

    public static OfficeKnowledgeAIDependencyImpl_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m872get() {
        return get();
    }
}
