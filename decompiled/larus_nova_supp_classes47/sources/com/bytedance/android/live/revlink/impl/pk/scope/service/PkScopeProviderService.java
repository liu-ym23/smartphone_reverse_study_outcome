package com.bytedance.android.live.revlink.impl.pk.scope.service;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.revlink.impl.global.c;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.e;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.PkBaseStateMachine;
import com.bytedance.android.scope.o;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class PkScopeProviderService implements o {
    public final MutableLiveData<q11.b> a;
    public final MutableLiveData<IBaseUser> b;
    public final MutableLiveData<Long> c;
    public final MutableLiveData<String> d;
    public final PkScopeProviderService$pkStateObserver$1 e;
    public final PkScopeProviderService$pkGuestUserObserver$1 f;
    public final PkScopeProviderService$pkTimeLeftObserver$1 g;
    public final PkScopeProviderService$battleEffectInfo$1 h;
    public final c i;

    public final void onStart() {
    }

    public final void onStop() {
    }

    public final e a() {
        return this.i.Ig();
    }

    public final void c() {
        e r0 = a();
        if (r0 == null) goto L7;
        LiveData<PkBaseStateMachine.c> r1 = r0.getPkBaseState();
        if (r1 == null) goto L7;
        r1.observeForever(this.e);
    L7:
        com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c r2 = this.i.getPkUtils().g();
        if (r2 == null) goto L12;
        LiveData<IBaseUser> r3 = r2.getGuestUser();
        if (r3 == null) goto L12;
        r3.observeForever(this.f);
    L12:
        e r4 = a();
        if (r4 == null) goto L17;
        LiveData<Long> r5 = r4.getBaseTimeLeft();
        if (r5 == null) goto L17;
        r5.observeForever(this.g);
    L17:
        e r6 = a();
        if (r6 == null) goto L23;
        LiveData<String> r7 = r6.getBattleEffectInfo();
        if (r7 == null) goto L24;
        r7.observeForever(this.h);
        return;
    L24:
        return;
    }

    /* JADX WARN: Type inference failed for: r2v5, types: [com.bytedance.android.live.revlink.impl.pk.scope.service.PkScopeProviderService$pkStateObserver$1] */
    /* JADX WARN: Type inference failed for: r2v6, types: [com.bytedance.android.live.revlink.impl.pk.scope.service.PkScopeProviderService$pkGuestUserObserver$1] */
    /* JADX WARN: Type inference failed for: r2v7, types: [com.bytedance.android.live.revlink.impl.pk.scope.service.PkScopeProviderService$pkTimeLeftObserver$1] */
    /* JADX WARN: Type inference failed for: r2v8, types: [com.bytedance.android.live.revlink.impl.pk.scope.service.PkScopeProviderService$battleEffectInfo$1] */
    public PkScopeProviderService(c r2) {
        Intrinsics.checkNotNullParameter(r2, "linkFakeGlobalService");
        this.i = r2;
        this.a = new MutableLiveData();
        this.b = new MutableLiveData();
        this.c = new MutableLiveData();
        this.d = new MutableLiveData();
        this.e = new PkScopeProviderService$pkStateObserver$1(this);
        this.f = new PkScopeProviderService$pkGuestUserObserver$1(this);
        this.g = new PkScopeProviderService$pkTimeLeftObserver$1(this);
        this.h = new PkScopeProviderService$battleEffectInfo$1(this);
    }
}
