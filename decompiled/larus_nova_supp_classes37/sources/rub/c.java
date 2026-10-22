package rub;

import android.content.Context;
import android.graphics.drawable.Drawable;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public abstract class c {

    public static final class a extends c {
        public final Function1<Context, Drawable> a;

        /* JADX WARN: Multi-variable type inference failed */
        public a(Function1<? super Context, ? extends Drawable> r2) {
            Intrinsics.checkNotNullParameter(r2, "drawableProvider");
            this.a = r2;
        }
    }

    public static final class b extends c {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }
    }

    /* JADX INFO: renamed from: rub.c$c, reason: collision with other inner class name */
    public static final class C0185c extends c {
        public static final C0185c a = null;

        static {
            a = new C0185c();
        }

        public C0185c() {
        }
    }

    public c() {
    }
}
