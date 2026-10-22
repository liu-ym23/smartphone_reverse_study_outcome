package com.miui.easygo.manager;

import android.content.Context;
import android.os.Bundle;
import com.miui.easygo.callback.IEasyGoCallback;
import com.miui.easygo.sdk.module.EasyGoRet;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class EasyGoManager {
    private static final String TAG = "EasyGoManager";
    private Context mContext;

    private int initFunction(String r1) {
        return 560;
    }

    public int getRomSupStatus(Context r1, String r2) {
        return 0;
    }

    public List<Integer> init(String[] r1) {
        return null;
    }

    public void invokeAsync(String r1, String r2, JSONObject r3, Bundle r4, IEasyGoCallback r5) {
    }

    public EasyGoRet invokeSync(String r1, String r2, JSONObject r3, Bundle r4) {
        return null;
    }

    public void release() {
    }

    public EasyGoManager(Context r2) {
        this.mContext = null;
        this.mContext = r2;
    }
}
