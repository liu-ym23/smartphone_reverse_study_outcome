package ha;

import java.lang.reflect.Field;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Field f7962a;

    public b(Field r8) {
        Objects.requireNonNull(r8);
        this.f7962a = r8;
    }

    public final String toString() {
        return this.f7962a.toString();
    }
}
