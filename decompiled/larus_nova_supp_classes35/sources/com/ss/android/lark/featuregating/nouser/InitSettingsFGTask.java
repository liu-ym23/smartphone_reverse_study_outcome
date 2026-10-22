package com.ss.android.lark.featuregating.nouser;

import android.content.Context;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.launch.task.AsyncLaunchTask;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.log.Log;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class InitSettingsFGTask extends AsyncLaunchTask {
    public InitSettingsFGTask() {
    }

    public final void a(Context r4) {
        IGetDataCallback<Map<String, Boolean>> r0 = new AnonymousClass1(this);
        Log.i("InitSettingsFGTask", "fetchAndUpdateSettingsFGData call");
        FeatureGatingModule.getDependency().ic(r4, r0);
    }
}
