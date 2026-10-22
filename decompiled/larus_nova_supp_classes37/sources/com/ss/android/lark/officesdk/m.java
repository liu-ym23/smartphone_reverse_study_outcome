package com.ss.android.lark.officesdk;

import android.app.Service;
import dagger.hilt.android.components.ServiceComponent;
import dagger.hilt.android.internal.builders.ServiceComponentBuilder;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class m implements ServiceComponentBuilder {
    public Service a;

    public final ServiceComponent build() {
        Preconditions.checkBuilderRequirement(this.a, Service.class);
        return new n();
    }

    public m(o r1) {
    }

    public final ServiceComponentBuilder service(Service r1) {
        this.a = (Service) Preconditions.checkNotNull(r1);
        return this;
    }
}
