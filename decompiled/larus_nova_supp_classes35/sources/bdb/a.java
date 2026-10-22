package bdb;

import android.view.View;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public final View.OnLongClickListener a;
    public final b b;
    public final vcb.b c;

    /* JADX INFO: renamed from: bdb.a$a, reason: collision with other inner class name */
    public static final class C0012a {
        public View.OnLongClickListener a;
        public b b;
        public vcb.b c;

        public C0012a() {
        }
    }

    public interface b {
        Object a(Class<? extends Object> r1);
    }

    public static final class c implements b {
        public final ConcurrentHashMap<Class<? extends Object>, Object> a;

        public c() {
            this.a = new ConcurrentHashMap();
        }

        @Override // bdb.a.b
        public final Object a(Class<? extends Object> r2) {
            Intrinsics.checkNotNullParameter(r2, "actionHandlerApiClass");
            return this.a.get(r2);
        }
    }

    public a(C0012a r2) {
        Intrinsics.checkNotNullParameter(r2, "builder");
        this.a = r2.a;
        this.b = r2.b;
        this.c = r2.c;
    }
}
