package com.ss.android.lark.officesdk.minutes.assembly.hardware;

import dagger.internal.Factory;
import vub.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MmNoopHardwareCapacityImpl_Factory implements Factory<b> {

    public static final class a {
        public static final MmNoopHardwareCapacityImpl_Factory a = null;

        static {
            a = new MmNoopHardwareCapacityImpl_Factory();
        }
    }

    public MmNoopHardwareCapacityImpl_Factory() {
    }

    public static b newInstance() {
        return new b();
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m159get();
    }

    public static MmNoopHardwareCapacityImpl_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public b m159get() {
        return newInstance();
    }
}
