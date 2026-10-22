package com.ss.android.lark.officesdk;

import dagger.hilt.android.ActivityRetainedLifecycle;
import dagger.hilt.android.internal.builders.ActivityComponentBuilder;
import dagger.hilt.android.internal.managers.ActivityRetainedComponentManager_Lifecycle_Factory;
import dagger.internal.DoubleCheck;
import dagger.internal.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class g extends c0 {
    public final o a;
    public final g b;
    public Provider c;

    public static final class a<T> implements Provider<T> {
        public final T get() {
            return (T) ActivityRetainedComponentManager_Lifecycle_Factory.newInstance();
        }

        public a() {
        }
    }

    public final ActivityComponentBuilder activityComponentBuilder() {
        return new d(this.a, this.b);
    }

    public final ActivityRetainedLifecycle getActivityRetainedLifecycle() {
        return (ActivityRetainedLifecycle) this.c.get();
    }

    public g(o r1) {
        this.b = this;
        this.a = r1;
        this.c = DoubleCheck.provider(new a());
    }
}
