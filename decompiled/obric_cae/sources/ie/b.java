package ie;

import he.i;
import java.util.Random;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends ie.a {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final a f8326m;

    public static final class a extends ThreadLocal<Random> {
        @Override // java.lang.ThreadLocal
        public final Random initialValue() {
            return new Random();
        }
    }

    public b() {
        this.f8326m = new a();
    }

    @Override // ie.a
    public final Random c() {
        Random r8 = this.f8326m.get();
        i.e(r8, "implStorage.get()");
        return r8;
    }
}
