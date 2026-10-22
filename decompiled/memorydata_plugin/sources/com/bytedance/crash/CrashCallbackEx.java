package com.bytedance.crash;

import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class CrashCallbackEx {
    public CrashCallbackEx() {
    }

    public abstract void onCrash(int r1, String r2, CrashType r3, long r4, long r6, String r8, String r9, JSONObject r10, List<String> r11);
}
