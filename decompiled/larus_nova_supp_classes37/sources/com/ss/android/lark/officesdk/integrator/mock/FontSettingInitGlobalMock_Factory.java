package com.ss.android.lark.officesdk.integrator.mock;

import dagger.internal.Factory;
import ytb.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class FontSettingInitGlobalMock_Factory implements Factory<l> {

    public static final class a {
        public static final FontSettingInitGlobalMock_Factory a = null;

        static {
            a = new FontSettingInitGlobalMock_Factory();
        }
    }

    public FontSettingInitGlobalMock_Factory() {
    }

    public static l newInstance() {
        return new l();
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m100get();
    }

    public static FontSettingInitGlobalMock_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public l m100get() {
        return newInstance();
    }
}
