package com.ss.android.deviceregister;

import com.bytedance.bdinstall.intf.IAdIdConfig;

/* JADX INFO: loaded from: classes6.dex */
public interface j {

    public static class a implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        IAdIdConfig f15218a;

        public a() {
            this.f15218a = new IAdIdConfig.AdIdConfig();
        }

        @Override // com.ss.android.deviceregister.j
        public long a() {
            return this.f15218a.getAdIdWaitTime();
        }

        @Override // com.ss.android.deviceregister.j
        public boolean b() {
            return this.f15218a.enablePrefetchAdId();
        }
    }

    long a();

    boolean b();
}
