package com.bytedance.applog.c;

import android.accounts.Account;
import android.app.Application;
import android.content.Context;
import android.os.Looper;
import com.bytedance.bdinstall.Env;
import com.bytedance.bdinstall.IBDInstallApi;
import com.bytedance.bdinstall.IExtraParams;
import com.bytedance.bdinstall.InstallInfo;
import com.bytedance.bdinstall.InstallOptions;
import com.bytedance.bdinstall.Level;
import com.bytedance.bdinstall.OnResetListener;
import com.bytedance.bdinstall.service.NUApi;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public interface e {
    String a(Context r1, StringBuilder r2, boolean r3, Level r4);

    void a();

    void a(Account r1);

    void a(Application r1, String r2);

    void a(Context r1, Env r2, long r3, OnResetListener r5);

    void a(Context r1, String r2);

    void a(Context r1, String r2, String r3);

    void a(Context r1, Map<String, String> r2, boolean r3, Level r4);

    void a(Context r1, JSONObject r2);

    void a(Context r1, boolean r2);

    void a(c.b r1);

    void a(com.bytedance.applog.k.b r1, Env r2, Looper r3, com.bytedance.applog.c r4);

    void a(Env r1);

    void a(IExtraParams r1);

    void a(String r1);

    void a(HashMap<String, Object> r1);

    boolean a(Context r1);

    boolean a(JSONObject r1);

    NUApi b(Context r1);

    void b(Context r1, Env r2, long r3, OnResetListener r5);

    void b(Context r1, JSONObject r2);

    void b(Env r1);

    boolean b();

    InstallInfo c();

    void c(Env r1);

    String d();

    String e();

    String f();

    String g();

    String h();

    boolean i();

    InstallOptions j();

    boolean k();

    Map<String, String> l();

    void m();

    IBDInstallApi n();
}
