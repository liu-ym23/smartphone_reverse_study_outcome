package vq0;

import android.os.Bundle;
import com.bytedance.android.live.openplatform.impl.miniappcommon.context.MiniAppContext;
import com.bytedance.android.live.openplatform.impl.miniappcommon.context.OnMiniAppLifecycleChangeListener;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class c extends a {
    public c(MiniAppContext r2) {
        Intrinsics.checkNotNullParameter(r2, "miniAppContext");
        super(r2);
    }

    public Bundle onEvent(Bundle r2) {
        this.a.notifyMiniAppLifecycleChange(OnMiniAppLifecycleChangeListener.MiniAppLifecycle.OnStop);
        this.a.tryClearMiniAppInstance(MiniAppContext.StopType.ON_MINI_APP_STOP);
        return null;
    }
}
