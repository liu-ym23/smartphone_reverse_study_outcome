package com.bytedance.ug.cloud;

import android.util.Log;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class o implements j {
    o() {
        Log.e("UGCloud", "找不到相关AppLog实现");
    }

    @Override // com.bytedance.ug.cloud.j
    public void a(String r2, JSONObject r3) {
        Log.e("UGCloud", "丢失事件： name = " + r2 + ", param = " + r3);
    }
}
