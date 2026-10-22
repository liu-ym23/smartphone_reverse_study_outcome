package d0;

import ai.j0;

/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f16553a;

    public j(String r5) {
        this.f16553a = r5;
    }

    public final boolean equals(Object r5) {
        if ((r5 instanceof j) == true) goto L5;
        return false;
    L5:
        return this.f16553a.equals(((j) r5).f16553a);
    }

    public final int hashCode() {
        return this.f16553a.hashCode();
    }

    public final String toString() {
        return j0.q(new StringBuilder("StringHeaderFactory{value='"), this.f16553a, "'}");
    }
}
