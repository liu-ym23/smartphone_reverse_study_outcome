package n0;

import android.content.Context;
import android.view.LayoutInflater;

/* JADX INFO: loaded from: classes.dex */
public abstract class c extends a {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f9416r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final int f9417s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final LayoutInflater f9418t;

    @Deprecated
    public c(Context r8, int r10) {
        super(r8);
        this.f9417s = r10;
        this.f9416r = r10;
        this.f9418t = (LayoutInflater) r8.getSystemService("layout_inflater");
    }
}
