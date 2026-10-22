package com.bytedance.frameworks.baselib.network.http;

import com.bytedance.retrofit2.PriorityLevel;
import java.util.List;
import okhttp3.OkHttpClient;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class c {
    public b A;
    public List<C0124c> B;
    public JSONObject C;
    public int D;
    public int E;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f2365a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2366b;
    public long c;
    public long d;
    public long e;
    public long f;
    public long g;
    public long h;
    public long i;
    public boolean j;
    public boolean k;
    public boolean l;
    public int m;
    public boolean n;
    public int o;
    public boolean p;
    public int q;
    public int r;
    public long s;
    public boolean t;
    public boolean u;

    @Deprecated
    public boolean v;
    public boolean w;
    public boolean x;
    public boolean y;
    public a z;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f2367a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f2368b;

        public String toString() {
            return "AuthCredentials{username=" + this.f2367a + ", password=" + this.f2368b + '}';
        }
    }

    public interface b {
        void a(OkHttpClient.Builder r1);
    }

    /* JADX INFO: renamed from: com.bytedance.frameworks.baselib.network.http.c$c, reason: collision with other inner class name */
    public static class C0124c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f2369a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f2370b;

        public C0124c(String r1, String r2) {
            this.f2369a = r1;
            this.f2370b = r2;
        }

        public C0124c a() {
            return new C0124c(this.f2369a, this.f2370b);
        }

        public /* synthetic */ Object clone() {
            return a();
        }
    }

    public c() {
        this.l = false;
        this.m = 0;
        this.n = true;
        this.t = true;
        this.u = false;
        this.v = true;
        this.w = false;
        this.x = false;
        this.y = false;
        this.C = new JSONObject();
        this.D = PriorityLevel.INVALID;
        this.E = -1;
    }
}
