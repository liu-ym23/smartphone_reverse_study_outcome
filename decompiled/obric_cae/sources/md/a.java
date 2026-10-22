package md;

import gd.b;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements b {
    @Override // gd.b
    public final String a(Object r8) {
        StringBuffer r10 = new StringBuffer("Thread: ");
        r10.append(((Thread) r8).getName());
        return r10.toString();
    }
}
