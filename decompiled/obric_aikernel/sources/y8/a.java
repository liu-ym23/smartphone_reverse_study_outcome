package y8;

import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.download.base.DownloadTask;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f13697a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<String> f13698b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f13699c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f13700d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f13701e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f13702f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f13703g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f13704h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f13705i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Map<String, String> f13706j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f13707k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f13708l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f13709m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f13710n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private long[] f13711o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f13712p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private String f13713q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f13714r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f13715s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private String f13716t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f13717u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final String f13718v;

    public a(String r10) {
        Intrinsics.checkNotNullParameter(r10, "url");
        this.f13718v = r10;
        this.f13697a = "";
        this.f13700d = "";
        this.f13713q = "";
        this.f13714r = 500;
    }

    public final DownloadTask a() {
        return new DownloadTask(this.f13718v, this.f13697a, this.f13698b, this.f13699c, this.f13700d, this.f13701e, this.f13702f, this.f13703g, this.f13704h, this.f13705i, this.f13706j, this.f13707k, this.f13708l, this.f13709m, this.f13710n, this.f13712p, this.f13713q, this.f13711o, "", -1, this.f13715s, this.f13714r, this.f13716t, this.f13717u);
    }

    public final a b(String r10) {
        Intrinsics.checkNotNullParameter(r10, "md5");
        this.f13707k = r10;
        return this;
    }

    public final a c(String r10) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        this.f13697a = r10;
        return this;
    }

    public final a d(boolean r10) {
        this.f13704h = r10;
        return this;
    }

    public final a e(boolean r10) {
        this.f13715s = r10;
        return this;
    }

    public final a f(int r10) {
        this.f13709m = r10;
        return this;
    }

    public final a g(String r10) {
        Intrinsics.checkNotNullParameter(r10, "savePath");
        this.f13700d = r10;
        return this;
    }

    public final a h(int r10) {
        this.f13701e = r10;
        return this;
    }
}
