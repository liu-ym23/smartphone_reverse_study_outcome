package je;

import he.i;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends ie.a {
    @Override // ie.a
    public final Random c() {
        ThreadLocalRandom r8 = ThreadLocalRandom.current();
        i.e(r8, "current()");
        return r8;
    }
}
