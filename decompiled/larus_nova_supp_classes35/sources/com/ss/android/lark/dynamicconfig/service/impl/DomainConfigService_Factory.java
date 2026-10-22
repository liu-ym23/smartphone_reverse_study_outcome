package com.ss.android.lark.dynamicconfig.service.impl;

import dagger.internal.Factory;
import jcb.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class DomainConfigService_Factory implements Factory<b> {

    public static final class a {
        public static final DomainConfigService_Factory a = null;

        static {
            a = new DomainConfigService_Factory();
        }
    }

    public DomainConfigService_Factory() {
    }

    public static b newInstance() {
        return new b();
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m1142get();
    }

    public static DomainConfigService_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public b m1142get() {
        return newInstance();
    }
}
