package com.ss.android.lark.officesdk;

import android.app.Application;
import dagger.hilt.android.internal.managers.ApplicationComponentManager;
import dagger.hilt.android.internal.managers.ComponentSupplier;
import dagger.hilt.android.internal.migration.HasCustomInject;
import dagger.hilt.android.internal.modules.ApplicationContextModule;
import dagger.hilt.internal.GeneratedComponentManager;
import dagger.hilt.internal.GeneratedComponentManagerHolder;
import dagger.hilt.internal.UnsafeCasts;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public abstract class Hilt_HiltRoot extends Application implements GeneratedComponentManagerHolder, HasCustomInject {
    public boolean a;
    public final ApplicationComponentManager b;

    public class a implements ComponentSupplier {
        public final /* synthetic */ Hilt_HiltRoot a;

        public final Object get() {
            h r0 = new h();
            r0.b = (ApplicationContextModule) Preconditions.checkNotNull(new ApplicationContextModule(this.a));
            return r0.a();
        }

        public a(Hilt_HiltRoot r1) {
            this.a = r1;
        }
    }

    public final void customInject() {
        if (this.a == true) goto L6;
        this.a = true;
        z r0 = (z) generatedComponent();
        HiltRoot r1 = (HiltRoot) UnsafeCasts.unsafeCast(this);
        r0.g();
        return;
    }

    public final Object generatedComponent() {
        return this.b.generatedComponent();
    }

    public Hilt_HiltRoot() {
        this.a = false;
        this.b = new ApplicationComponentManager(new a(this));
    }

    public final GeneratedComponentManager componentManager() {
        return this.b;
    }
}
