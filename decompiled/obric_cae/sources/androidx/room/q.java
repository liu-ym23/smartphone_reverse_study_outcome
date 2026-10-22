package androidx.room;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public final class q {
    public static final <T extends r> r.a<T> a(Context r8, Class<T> r10, String r11) {
        he.i.f(r8, "context");
        if (ne.g.s0(r11) == false) goto L5;
        boolean r12 = true;
    L7:
        if ((!r12) == false) goto L11;
        return new r.a(r8, r10, r11);
    L11:
        throw new IllegalArgumentException("Cannot build a database with null or empty name. If you are trying to create an in memory database, use Room.inMemoryDatabaseBuilder".toString());
    L5:
        r12 = false;
        goto L7
    }
}
