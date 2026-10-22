package com.obric.assistant.provider;

import android.content.UriMatcher;
import f09.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class ObricLocalDataSearchDomainProvider$b implements a.b {
    public final /* synthetic */ ObricLocalDataSearchDomainProvider a;

    public final void onAllActivityDestroyed() {
    }

    public final void onAppBackground() {
    }

    public final void onAppForeground() {
        ObricLocalDataSearchDomainProvider r0 = this.a;
        UriMatcher r1 = ObricLocalDataSearchDomainProvider.f;
        r0.b("app_foreground");
    }

    public ObricLocalDataSearchDomainProvider$b(ObricLocalDataSearchDomainProvider r1) {
        this.a = r1;
    }
}
