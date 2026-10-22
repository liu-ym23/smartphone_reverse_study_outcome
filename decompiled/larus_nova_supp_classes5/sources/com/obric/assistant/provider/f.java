package com.obric.assistant.provider;

import android.content.ContentResolver;
import android.content.Context;
import android.content.UriMatcher;
import com.bytedance.keva.Keva;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final /* synthetic */ class f implements Keva.OnChangeListener {
    public final /* synthetic */ ObricLocalDataSearchDomainProvider a;

    public /* synthetic */ f(ObricLocalDataSearchDomainProvider r1) {
        this.a = r1;
    }

    public final void onChanged(Keva r4, String r5) {
        ObricLocalDataSearchDomainProvider r6 = this.a;
        UriMatcher r0 = ObricLocalDataSearchDomainProvider.f;
        FLogger.a.i("ObricLocalDataSearchDomainProvider", "personal context local data search domain changed, key: " + r5);
        Context r7 = r6.getContext();
        if (r7 == null) goto L8;
        ContentResolver r8 = r7.getContentResolver();
        if (r8 == null) goto L9;
        r8.notifyChange(ObricLocalDataSearchDomainProvider.g, null);
        return;
    L9:
        return;
    }
}
