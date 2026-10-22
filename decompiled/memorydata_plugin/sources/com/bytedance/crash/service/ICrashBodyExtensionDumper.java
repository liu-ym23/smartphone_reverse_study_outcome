package com.bytedance.crash.service;

import com.bytedance.crash.CrashType;
import java.io.File;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public interface ICrashBodyExtensionDumper {
    void dump(File r1);

    JSONObject load(CrashType r1);

    void load(JSONObject r1, JSONObject r2, File r3);
}
