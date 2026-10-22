package com.bytedance.apm;

import com.bytedance.crash.n;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3835a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ JSONObject f3836b;

    public a(JSONObject r5) {
        this.f3835a = 1;
        this.f3836b = r5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.f3835a) {
            case 0: goto L12;
            default: goto L4;
        };
    L4:
        String r5 = n.f4062j.getJavaCrashUploadUrl();
        JSONObject r10 = this.f3836b;
        String r11 = com.bytedance.crash.upload.b.i(r5, r10.optJSONObject("header"));
        r10.put("upload_scene", "direct");     // Catch: JSONException -> L7
    L9:
        com.bytedance.crash.upload.b.b(r11, r10.toString(), true);
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L9
    L12:
        throw null;
    }

    public a(e6.c r5, JSONObject r10) {
        this.f3835a = 0;
        this.f3836b = r10;
    }
}
