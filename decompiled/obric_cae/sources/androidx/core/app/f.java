package androidx.core.app;

import android.content.res.Configuration;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f1589a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f1590b;

    public f() {
        this.f1589a = false;
        this.f1590b = Collections.newSetFromMap(new ConcurrentHashMap());
    }

    public f(boolean r8) {
        this.f1589a = r8;
        this.f1590b = null;
    }

    public f(boolean r8, Configuration r10) {
        this.f1589a = r8;
        this.f1590b = r10;
    }
}
