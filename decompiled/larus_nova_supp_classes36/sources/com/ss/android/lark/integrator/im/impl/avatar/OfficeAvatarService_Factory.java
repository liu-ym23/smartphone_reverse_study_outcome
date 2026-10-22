package com.ss.android.lark.integrator.im.impl.avatar;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class OfficeAvatarService_Factory implements Factory<rmb.a> {

    public static final class a {
        public static final OfficeAvatarService_Factory a = null;

        static {
            a = new OfficeAvatarService_Factory();
        }
    }

    public OfficeAvatarService_Factory() {
    }

    public static rmb.a newInstance() {
        return new rmb.a();
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m902get();
    }

    public static OfficeAvatarService_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public rmb.a m902get() {
        return newInstance();
    }
}
