package com.obric.aikernel.legacy;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.obric.aikernel.InferEntryHolder;

/* JADX INFO: loaded from: classes2.dex */
public final class InferService extends Service {
    public InferService() {
    }

    @Override // android.app.Service
    public IBinder onBind(Intent r10) {
        return InferEntryHolder.b(InferEntryHolder.f4392a, null, 1, null);
    }
}
