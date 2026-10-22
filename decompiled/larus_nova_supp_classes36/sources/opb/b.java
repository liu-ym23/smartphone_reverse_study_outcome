package opb;

import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.log.Log;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b {
    public b() {
    }

    public final void a(final Map<String, String> r8, final Map<String, jpb.a> r9, boolean r10, final boolean r11, final boolean r12) {
        if (r10 == false) goto L5;
        Log.i("AppConfigDataStore", "saveAppConfigs common_settings_opt_close: " + r12);
        CoreThreadPool.getDefault().getFixedThreadPool().execute(new a(this, r8, r9, r11, r12));
        return;
    }
}
