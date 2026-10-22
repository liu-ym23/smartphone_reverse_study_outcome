package com.larus.dorag.widget;

import com.larus.home.api.main.IHomeApi;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class c implements f09.a.b {
    public c() {
    }

    public final void onAllActivityDestroyed() {
    }

    public final void onAppForeground() {
    }

    public final void onAppBackground() {
        String r0 = f.a;
        f.a();
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new DoraWidgetCenter$pullNoteUrl$1(null), 3, null);
        if (f.e == false) goto L8;
        IHomeApi r1 = (IHomeApi) ServiceManager.get().getService(IHomeApi.class);
        if (r1 == null) goto L9;
        FLogger.a.i("DoraWidgetCenter", "recover hot launch");
        r1.C(true);
        f.e = false;
        return;
    L9:
        return;
    }
}
