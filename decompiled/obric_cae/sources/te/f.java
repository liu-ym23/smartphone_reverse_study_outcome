package te;

import ge.p;
import he.j;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends j implements p<Integer, ae.f.b, Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f12393a = null;

    static {
        f12393a = new f();
    }

    public f() {
        super(2);
    }

    @Override // ge.p
    public final Integer invoke(Integer r8, ae.f.b r10) {
        return Integer.valueOf(r8.intValue() + 1);
    }
}
