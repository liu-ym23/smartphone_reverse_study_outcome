package com.ss.android.lark.officesdk.integrator.mock;

import dagger.internal.Factory;
import ytb.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class FontSettingInitMock_Factory implements Factory<m> {

    public static final class a {
        public static final FontSettingInitMock_Factory a = null;

        static {
            a = new FontSettingInitMock_Factory();
        }
    }

    public FontSettingInitMock_Factory() {
    }

    public static m newInstance() {
        return new m();
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m101get();
    }

    public static FontSettingInitMock_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public m m101get() {
        return newInstance();
    }
}
