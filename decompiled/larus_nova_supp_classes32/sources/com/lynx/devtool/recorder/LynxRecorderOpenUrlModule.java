package com.lynx.devtool.recorder;

import android.content.Context;
import com.lynx.jsbridge.LynxMethod;
import com.lynx.jsbridge.LynxModule;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.base.LLog;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LynxRecorderOpenUrlModule extends LynxModule {
    private static final String TAG = "LynxRecorderOpenUrlModule";

    public LynxRecorderOpenUrlModule(Context r1) {
        super(r1);
    }

    @LynxMethod
    public void openSchema(ReadableMap r3) {
        LLog.e(TAG, r3.toString());
        LynxRecorderPageManager.getInstance().replayPageFromOpenSchema(r3);
    }
}
