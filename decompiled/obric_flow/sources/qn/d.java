package qn;

import c7.e;
import com.lynx.tasm.behavior.LynxContext;
import java.lang.ref.WeakReference;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference f21547a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f21548b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public al.a f21549c;
    public e d;
    public LinkedList e;
    public long f;
    public long g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f21550h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f21551i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f21552j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f21553k;

    public d(LynxContext r5) {
        this.f21548b = false;
        this.f = -1;
        this.g = -1;
        this.f21550h = 0;
        this.f21553k = -1;
        this.f21547a = new WeakReference(r5);
        this.e = new LinkedList();
    }
}
