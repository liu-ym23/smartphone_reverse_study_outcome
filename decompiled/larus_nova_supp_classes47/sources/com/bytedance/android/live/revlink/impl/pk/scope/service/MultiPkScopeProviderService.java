package com.bytedance.android.live.revlink.impl.pk.scope.service;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.revlink.impl.global.c;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.e;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.PkBaseStateMachine;
import com.bytedance.android.scope.o;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class MultiPkScopeProviderService implements o {
    public e a;
    public final MutableLiveData<PkBaseStateMachine.c> b;
    public final MutableLiveData<Long> c;
    public final MultiPkScopeProviderService$pkStateObserver$1 d;
    public final MultiPkScopeProviderService$pkTimeLeftObserver$1 e;
    public final c f;

    public final void onStart() {
    }

    public final void onStop() {
    }

    public final void Ek() {
        e r0 = this.a;
        if (r0 == null) goto L7;
        LiveData<PkBaseStateMachine.c> r1 = r0.getPkBaseState();
        if (r1 == null) goto L7;
        r1.removeObserver(this.d);
    L7:
        e r2 = this.a;
        if (r2 == null) goto L12;
        LiveData<Long> r3 = r2.getBaseTimeLeft();
        if (r3 == null) goto L12;
        r3.removeObserver(this.e);
    L12:
        this.b.postValue(PkBaseStateMachine.c.a.d);
    }

    public final void a() {
        e r0 = this.f.Ig();
        this.a = r0;
        if (r0 == null) goto L7;
        LiveData<PkBaseStateMachine.c> r1 = r0.getPkBaseState();
        if (r1 == null) goto L7;
        r1.observeForever(this.d);
    L7:
        e r2 = this.a;
        if (r2 == null) goto L13;
        LiveData<Long> r3 = r2.getBaseTimeLeft();
        if (r3 == null) goto L14;
        r3.observeForever(this.e);
        return;
    L14:
        return;
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [com.bytedance.android.live.revlink.impl.pk.scope.service.MultiPkScopeProviderService$pkStateObserver$1] */
    /* JADX WARN: Type inference failed for: r2v4, types: [com.bytedance.android.live.revlink.impl.pk.scope.service.MultiPkScopeProviderService$pkTimeLeftObserver$1] */
    public MultiPkScopeProviderService(c r2) {
        Intrinsics.checkNotNullParameter(r2, "linkFakeGlobalService");
        this.f = r2;
        this.b = new MutableLiveData();
        this.c = new MutableLiveData();
        this.d = new MultiPkScopeProviderService$pkStateObserver$1(this);
        this.e = new MultiPkScopeProviderService$pkTimeLeftObserver$1(this);
    }
}
