package b;

import android.content.Intent;
import androidx.activity.ComponentActivity;
import he.i;

/* JADX INFO: loaded from: classes.dex */
public abstract class a<I, O> {

    /* JADX INFO: renamed from: b.a$a, reason: collision with other inner class name */
    public static final class C0027a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final T f2967a;

        public C0027a(T r8) {
            this.f2967a = r8;
        }
    }

    public abstract Intent a(ComponentActivity r8, Object r10);

    public C0027a b(ComponentActivity r8, Object r10) {
        i.f(r8, "context");
        return null;
    }

    public abstract Object c(Intent r8, int r10);
}
