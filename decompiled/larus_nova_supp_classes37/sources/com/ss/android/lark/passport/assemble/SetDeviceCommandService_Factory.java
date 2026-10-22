package com.ss.android.lark.passport.assemble;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class SetDeviceCommandService_Factory implements Factory<k> {

    public static final class a {
        public static final SetDeviceCommandService_Factory a = null;

        static {
            a = new SetDeviceCommandService_Factory();
        }
    }

    public SetDeviceCommandService_Factory() {
    }

    public static k newInstance() {
        return new k();
    }

    public k get() {
        return newInstance();
    }

    public static SetDeviceCommandService_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m596get() {
        return get();
    }
}
