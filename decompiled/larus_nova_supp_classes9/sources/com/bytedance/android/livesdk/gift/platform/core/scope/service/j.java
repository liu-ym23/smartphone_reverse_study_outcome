package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import com.bytedance.ies.sdk.widgets.NextLiveData;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class j implements com.bytedance.android.scope.o {
    public final NextLiveData<Boolean> a;

    public final void onStop() {
    }

    public final void onStart() {
        this.a.setValue(Boolean.FALSE);
    }

    public j() {
        this.a = new NextLiveData();
    }
}
