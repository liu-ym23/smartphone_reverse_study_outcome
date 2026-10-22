package androidx.core.app;

import android.content.res.Configuration;

/* JADX INFO: loaded from: classes.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1668a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f1669b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Comparable f1670c;

    public p(String r8, boolean r10) {
        this.f1668a = 1;
        this.f1670c = r8;
        this.f1669b = r10;
    }

    public final String toString() {
        switch(this.f1668a) {
            case 1: goto L7;
            default: goto L5;
        };
    L5:
        return super.toString();
    L7:
        return "Oaid{id='" + ((String) this.f1670c) + "', maySupport=" + this.f1669b + '}';
    }

    public p(boolean r8) {
        this.f1668a = 0;
        this.f1669b = r8;
        this.f1670c = null;
    }

    public p(boolean r8, Configuration r10) {
        this.f1668a = 0;
        this.f1669b = r8;
        this.f1670c = r10;
    }
}
