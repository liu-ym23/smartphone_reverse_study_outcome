package com.obric.aikernel.api.impl.security;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.obric.aikernel.middleware.api.log.AIKLog;
import kotlinx.coroutines.h;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.z0;

/* JADX INFO: loaded from: classes2.dex */
public final class CertProvisionImpl$conn$1 implements ServiceConnection {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private IBinder f4458c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ CertProvisionImpl f4459g;

    CertProvisionImpl$conn$1(CertProvisionImpl r10) {
        this.f4459g = r10;
    }

    public final IBinder a() {
        return this.f4458c;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName r10, IBinder r11) {
        AIKLog.INSTANCE.d("CertProvisionImpl", "onServiceConnected " + r11 + ", " + r10);
        this.f4458c = r11;
        h.d(m0.a(z0.b()), null, null, new CertProvisionImpl$conn$1$onServiceConnected$1(this.f4459g, null), 3, null);
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName r10) {
        AIKLog.INSTANCE.d("CertProvisionImpl", "onServiceDisconnected " + r10);
        this.f4458c = null;
    }
}
