package com.bytedance.ttnet;

import android.content.Context;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public interface d {
    int a(Context r1, String r2, int r3);

    String a(Context r1, String r2, String r3);

    void a(Context r1, String r2, String r3, JSONObject r4);

    void a(Context r1, Map<String, ?> r2);

    @Deprecated
    void a(Context r1, JSONObject r2);

    void a(String r1);

    void a(String r1, JSONObject r2);

    boolean a();

    String[] b();

    String c();

    @Deprecated
    String d();

    String e();

    void f();

    ArrayList<String> g();

    Context getContext();

    int h();

    Map<String, String> i();
}
