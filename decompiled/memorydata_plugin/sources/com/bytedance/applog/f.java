package com.bytedance.applog;

import android.accounts.Account;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.bytedance.applog.isolate.DataIsolateKey;
import com.bytedance.bdinstall.IBDInstallApi;
import com.bytedance.bdinstall.IExtraParams;
import com.bytedance.bdinstall.ILogger;
import com.bytedance.bdinstall.INetworkClient;
import com.bytedance.bdinstall.Level;
import com.bytedance.bdinstall.OnResetListener;
import com.bytedance.bdinstall.service.NUApi;
import java.net.Proxy;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public interface f {
    m A();

    void A(boolean r1);

    int B();

    void B(boolean r1);

    com.bytedance.applog.filter.a C();

    void C(boolean r1);

    Map<String, String> D();

    void D(boolean r1);

    String E();

    void E(boolean r1);

    void F(boolean r1);

    boolean F();

    IBDAccountCallback G();

    void G(boolean r1);

    void H(boolean r1);

    boolean H();

    boolean I();

    boolean J();

    boolean K();

    boolean L();

    void M();

    com.bytedance.applog.filter.h O();

    void P();

    void Q();

    boolean R();

    void X();

    Integer Y();

    k Z();

    <T> T a(String r1, T r2, Class<T> r3);

    String a(Context r1, String r2, boolean r3, Level r4);

    String a(Context r1, StringBuilder r2, boolean r3, Level r4);

    void a(int r1);

    void a(int r1, h r2);

    void a(long r1);

    void a(long r1, OnResetListener r3);

    void a(Account r1);

    void a(Activity r1, int r2);

    void a(Context r1, o r2);

    void a(Context r1, Map<String, String> r2, boolean r3, Level r4);

    void a(Context r1, JSONObject r2);

    void a(Context r1, boolean r2);

    void a(Context r1, boolean r2, long r3, OnResetListener r5);

    void a(View r1, String r2, String r3, JSONObject r4);

    void a(IBDAccountCallback r1);

    void a(com.bytedance.applog.collector.b r1);

    void a(e r1);

    void a(g r1);

    void a(h r1);

    void a(com.bytedance.applog.i.a r1);

    void a(i r1);

    void a(DataIsolateKey r1);

    void a(com.bytedance.applog.isolate.b r1);

    void a(j r1);

    void a(k r1);

    void a(l r1);

    void a(m r1);

    void a(n r1);

    void a(com.bytedance.applog.o.b r1);

    void a(com.bytedance.applog.p.a r1);

    void a(p r1);

    void a(IExtraParams r1);

    void a(ILogger r1);

    void a(String r1);

    void a(String r1, int r2);

    void a(String r1, Bundle r2);

    void a(String r1, Bundle r2, String r3, String r4, String r5);

    void a(String r1, Object r2);

    void a(String r1, String r2);

    void a(String r1, String r2, int r3);

    void a(String r1, String r2, String r3, long r4, long r6);

    void a(String r1, String r2, String r3, long r4, long r6, JSONObject r8);

    void a(String r1, Throwable r2);

    void a(String r1, JSONObject r2);

    void a(String r1, JSONObject r2, String r3, String r4, String r5);

    void a(Proxy r1);

    void a(HashMap<String, Object> r1);

    void a(HashSet<String> r1, int r2, int r3);

    void a(List<String> r1, boolean r2);

    void a(Map<String, String> r1);

    void a(JSONObject r1);

    void a(boolean r1);

    void a(boolean r1, String r2);

    boolean a(Context r1);

    com.bytedance.applog.monitor.v3.e ab();

    IBDInstallApi ac();

    com.bytedance.applog.params.b ad();

    com.bytedance.applog.b.b ae();

    boolean af();

    boolean ag();

    com.bytedance.applog.g.b ah();

    com.bytedance.applog.l.e ai();

    void ak();

    NUApi b(Context r1);

    String b();

    void b(long r1);

    void b(com.bytedance.applog.collector.b r1);

    void b(g r1);

    void b(h r1);

    void b(j r1);

    void b(n r1);

    void b(String r1);

    void b(String r1, int r2);

    void b(String r1, String r2);

    void b(String r1, JSONObject r2);

    void b(boolean r1);

    void c();

    void c(int r1);

    void c(long r1);

    void c(Context r1);

    void c(String r1);

    void c(boolean r1);

    boolean c(String r1, JSONObject r2);

    void d();

    void d(int r1);

    void d(Context r1);

    void d(String r1);

    void d(String r1, String r2);

    void d(boolean r1);

    void e(int r1);

    void e(boolean r1);

    boolean e();

    o f();

    void f(int r1);

    void f(String r1);

    void f(boolean r1);

    void g();

    void g(int r1);

    void g(String r1);

    void g(boolean r1);

    Context getContext();

    void h();

    void h(String r1);

    void h(boolean r1);

    String i();

    void i(boolean r1);

    boolean i(String r1);

    String j();

    void j(String r1);

    void j(boolean r1);

    void k(String r1);

    void k(boolean r1);

    boolean k();

    void l(String r1);

    void l(boolean r1);

    boolean l();

    String m();

    void m(String r1);

    void m(boolean r1);

    String n();

    void n(boolean r1);

    String o();

    void o(boolean r1);

    String p();

    void p(boolean r1);

    String q();

    void q(boolean r1);

    String r();

    void r(boolean r1);

    String s();

    void s(boolean r1);

    void t(boolean r1);

    boolean t();

    void u();

    void u(boolean r1);

    INetworkClient v();

    void v(boolean r1);

    JSONObject w();

    void w(boolean r1);

    void x(boolean r1);

    boolean x();

    void y();

    void y(boolean r1);

    i z();

    void z(boolean r1);
}
