package bi;

import ai.i0;
import com.bytedance.retrofit2.client.Request;
import fi.j;
import java.util.AbstractList;
import java.util.Map;
import okhttp3.q0;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f917a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f918b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AbstractList f919c;
    public j d;
    public q0 e;
    public int f;
    public int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f920h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f921i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f922j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Object f923k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f924l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public i0 f925m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Map f926n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f927o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f928p;

    public final Request a() {
        if (this.f918b == null) goto L7;
        return new Request(this);
    L7:
        throw new IllegalStateException("url == null");
    }

    public final void b(String r5) {
        if (r5 == null) goto L6;
        this.f918b = r5;
        return;
    L6:
        throw new NullPointerException("url == null");
    }
}
