package androidx.activity;

import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f498a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList<c> f499b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ge.a<xd.j> f500c;

    public n() {
        this.f498a = false;
        this.f499b = new CopyOnWriteArrayList();
    }

    public abstract void a();
}
