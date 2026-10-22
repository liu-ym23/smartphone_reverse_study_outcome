package cpb;

import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.res.Configuration;
import com.ss.android.lark.language.api.LocaleWatchScene;
import com.ss.android.lark.log.LogLevel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements ComponentCallbacks {
    public final /* synthetic */ Application a;

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
    }

    public b(Application r1) {
        this.a = r1;
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r2) {
        Intrinsics.checkNotNullParameter(r2, "newConfig");
        int r3 = d.a;
        d.a.c(LocaleWatchScene.APPLICATION_CONFIGURE_CHANGE, this.a).a(LogLevel.INFO);
    }
}
