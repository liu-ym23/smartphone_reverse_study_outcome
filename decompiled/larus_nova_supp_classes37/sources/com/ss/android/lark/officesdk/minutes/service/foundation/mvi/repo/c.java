package com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo;

import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public interface c<Entity> extends fvb.a {

    public static final class a {
        public static <Entity> Entity a(c<Entity> r0) {
            return (Entity) r0.b().getValue();
        }
    }

    i1<Entity> b();

    Entity m();
}
