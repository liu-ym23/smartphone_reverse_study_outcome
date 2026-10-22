package com.obric.aikernel;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import com.obric.aikernel.multiusr.BaseMultiUsrService;
import com.obric.aikernel.multiusr.InferLifeCycleServiceEntry;

/* JADX INFO: loaded from: classes2.dex */
public class InferLifeCycleService extends BaseMultiUsrService {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Binder f4394g;

    public InferLifeCycleService() {
        this.f4394g = new Binder();
    }

    @Override // com.obric.aikernel.multiusr.BaseMultiUsrService
    protected ComponentName b() {
        return new ComponentName(getApplicationContext(), InferLifeCycleServiceEntry.class);
    }

    @Override // com.obric.aikernel.multiusr.BaseMultiUsrService
    public IBinder c(Intent r10) {
        return this.f4394g;
    }
}
