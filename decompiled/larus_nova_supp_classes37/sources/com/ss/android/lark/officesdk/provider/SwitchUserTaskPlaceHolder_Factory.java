package com.ss.android.lark.officesdk.provider;

import dagger.internal.Factory;
import nwb.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class SwitchUserTaskPlaceHolder_Factory implements Factory<h> {

    public static final class a {
        public static final SwitchUserTaskPlaceHolder_Factory a = null;

        static {
            a = new SwitchUserTaskPlaceHolder_Factory();
        }
    }

    public SwitchUserTaskPlaceHolder_Factory() {
    }

    public static h newInstance() {
        return new h();
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m552get();
    }

    public static SwitchUserTaskPlaceHolder_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public h m552get() {
        return newInstance();
    }
}
