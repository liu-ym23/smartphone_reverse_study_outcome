package com.obric.aikernel;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import com.obric.aikernel.multiusr.BaseMultiUsrService;
import com.obric.aikernel.multiusr.LLMLifeCycleServiceEntry;

/* JADX INFO: loaded from: classes2.dex */
public class LLMLifeCycleService extends BaseMultiUsrService {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Binder f4404g;

    public LLMLifeCycleService() {
        this.f4404g = new Binder();
    }

    @Override // com.obric.aikernel.multiusr.BaseMultiUsrService
    protected ComponentName b() {
        return new ComponentName(getApplicationContext(), LLMLifeCycleServiceEntry.class);
    }

    @Override // com.obric.aikernel.multiusr.BaseMultiUsrService
    public IBinder c(Intent r10) {
        return this.f4404g;
    }
}
