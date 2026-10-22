package com.lynx.devtool.recorder;

import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public interface LynxRecorderReplayDataProvider {
    JSONObject getCallbackData();

    JSONArray getFunctionCall();

    JSONArray getJsbIgnoredInfo();

    JSONObject getJsbSettings();

    JSONObject getSharedData();
}
