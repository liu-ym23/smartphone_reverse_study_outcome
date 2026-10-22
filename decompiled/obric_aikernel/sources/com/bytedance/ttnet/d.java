package com.bytedance.ttnet;

import android.content.Context;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public interface d {
    @Deprecated
    void a(Context r10, JSONObject r11);

    void b(Context r10, Map<String, ?> r11);

    void c(String r10, JSONObject r11);

    void d(Context r10, String r11, String r12, JSONObject r13);

    void e(String r10);

    String[] f();

    boolean g();

    int getAppId();

    Context getContext();

    String h(Context r10, String r11, String r12);

    int i(Context r10, String r11, int r12);

    Map<String, String> j();

    String k();

    String l();

    ArrayList<String> m();

    void onColdStartFinish();
}
