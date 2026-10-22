package com.bytedance.geckox;

import android.util.Log;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f4740a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f4741b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f4742c;
    public Object d;
    public Object e;

    public AppSettingsManager$IGeckoAppSettings a() {
        if (((AppSettingsManager$IGeckoAppSettings) this.e) != null) goto L6;
        ServiceManager r5 = ServiceManager.a();
        this.e = (AppSettingsManager$IGeckoAppSettings) r5.a(AppSettingsManager$IGeckoAppSettings.class, r5.f16217b, true);
    L6:
        return (AppSettingsManager$IGeckoAppSettings) this.e;
    }

    public void b(um.a r5) {
        if (this.f4740a == true) goto L5;
        return;
    L5:
        if (this.f4741b == false) goto L16;
        this.f4742c = r5;
        r5.w();
        if (td.b.f22124a == false) goto L14;
        String r10 = "change cpu exception detect state: " + ((um.a) this.f4742c);
        if (td.b.f22124a == false) goto L15;
        Log.i("APM-CPU", r10);
        return;
    L15:
        return;
    L14:
        return;
    }
}
