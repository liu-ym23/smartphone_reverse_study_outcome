package com.bytedance.android.live.browser.service;

import android.content.Context;
import android.util.Pair;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import io.reactivex.subjects.PublishSubject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c implements com.bytedance.android.annie.bridge.p {
    public final /* synthetic */ AnnieAbilityProviderImpl a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ Ref.ObjectRef c;
    public final /* synthetic */ Fragment d;

    public final com.bytedance.ies.web.jsbridge2.f.b provide() {
        return this.a.c.h(this.b, (PublishSubject) this.c.element, this.d);
    }

    public final void onRequestPermissionsResult(int r2, String[] r3, int[] r4) {
        Intrinsics.checkNotNullParameter(r3, "permissions");
        Intrinsics.checkNotNullParameter(r4, "grantResults");
        ((PublishSubject) this.c.element).onNext(Pair.create(Integer.valueOf(r2), r4));
    }

    public c(AnnieAbilityProviderImpl r1, FragmentActivity r2, Ref.ObjectRef r3, Fragment r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
