package com.bytedance.crash;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public interface IUserCrashInfoCallback {
    Map<? extends String, ? extends String> getCrashInfo(CrashType r1, JSONObject r2);
}
