package com.ss.android.lark.officesdk.integrator.mock;

import dagger.internal.Factory;
import ytb.v;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class TeamModuleExportMock_Factory implements Factory<v> {

    public static final class a {
        public static final TeamModuleExportMock_Factory a = null;

        static {
            a = new TeamModuleExportMock_Factory();
        }
    }

    public TeamModuleExportMock_Factory() {
    }

    public static v newInstance() {
        return new v();
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m110get();
    }

    public static TeamModuleExportMock_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public v m110get() {
        return newInstance();
    }
}
