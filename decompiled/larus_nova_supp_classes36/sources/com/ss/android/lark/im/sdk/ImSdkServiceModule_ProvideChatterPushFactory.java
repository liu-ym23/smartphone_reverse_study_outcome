package com.ss.android.lark.im.sdk;

import com.ss.android.lark.im.sdk.usercontainer.ImSdkChatterPushProxy;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.h;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.internal.v;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import m6b.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class ImSdkServiceModule_ProvideChatterPushFactory implements Factory<t> {
    private final Provider<v> accessorProvider;
    private final b module;
    private final Provider<j> passportProvider;

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public t m723get() {
        return provideChatterPush(this.module, (j) this.passportProvider.get(), (v) this.accessorProvider.get());
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m723get();
    }

    public ImSdkServiceModule_ProvideChatterPushFactory(b r1, Provider<j> r2, Provider<v> r3) {
        this.module = r1;
        this.passportProvider = r2;
        this.accessorProvider = r3;
    }

    public static ImSdkServiceModule_ProvideChatterPushFactory create(b r1, Provider<j> r2, Provider<v> r3) {
        return new ImSdkServiceModule_ProvideChatterPushFactory(r1, r2, r3);
    }

    public static t provideChatterPush(b r1, j r2, v r3) {
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "passport");
        Intrinsics.checkNotNullParameter(r3, "accessor");
        String r4 = r2.g();
        if (r4 != null) goto L5;
        r4 = "";
    L5:
        Log.i("ImSdkServiceModule", "provide ImSdkChatterPush, foregroundUid is ".concat(r4));
        ImSdkChatterPushProxy r5 = new ImSdkChatterPushProxy(r2, r3);
        h.a(r5);
        return (t) Preconditions.checkNotNullFromProvides(r5);
    }
}
