package com.bytedance.forest.model;

import android.webkit.WebResourceRequest;
import com.bytedance.forest.pollyfill.NetWorker;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes2.dex */
public class t {
    public NetWorker A;
    public boolean B;
    public int C;
    public boolean D;
    public final LinkedHashMap E;
    public Set F;
    public boolean G;
    public Scene H;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f4405a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f4406b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f4407c;
    public String d;
    public ArrayList e;
    public boolean f;
    public boolean g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f4408h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f4409i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f4410j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f4411k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f4412l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f4413m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f4414n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f4415o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f4416p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f4417q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Boolean f4418r;
    public Boolean s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f4419t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f4420u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Lazy f4421v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f4422w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f4423x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f4424y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public WebResourceRequest f4425z;

    public t(Scene r5) {
        this.H = r5;
        this.f4405a = b.f4359a;
        this.f4406b = "";
        this.f4410j = true;
        this.f4419t = "";
        this.f4421v = LazyKt.lazy(RequestParams$customParams$2.f4337a);
        this.E = new LinkedHashMap();
    }

    public t(t r5, boolean r10) {
        this(r5.H);
        this.f4405a = r5.f4405a;
        this.f4406b = r5.f4406b;
        this.f4407c = r5.f4407c;
        this.d = r5.d;
        this.e = r5.e;
        this.f = r5.f;
        this.g = r5.g;
        this.f4408h = r5.f4408h;
        this.f4409i = r5.f4409i;
        this.f4410j = r5.f4410j;
        this.f4411k = r5.f4411k;
        this.f4412l = r5.f4412l;
        this.f4413m = r5.f4413m;
        this.f4414n = r5.f4414n;
        this.f4415o = r5.f4415o;
        this.f4416p = r5.f4416p;
        this.f4417q = r5.f4417q;
        this.f4418r = r5.f4418r;
        this.s = r5.s;
        this.f4419t = r5.f4419t;
        this.f4420u = r5.f4420u;
        ((Map) this.f4421v.getValue()).putAll((Map) r5.f4421v.getValue());
        this.f4423x = r5.f4423x;
        this.f4424y = r5.f4424y;
        this.f4425z = r5.f4425z;
        this.A = r5.A;
        this.B = r5.B;
        this.C = r5.C;
        this.D = r5.D;
        this.f4422w = r10;
        this.E.putAll(r5.E);
        this.F = r5.F;
        this.G = r5.G;
    }
}
