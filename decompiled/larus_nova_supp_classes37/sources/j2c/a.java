package j2c;

import android.content.res.ColorStateList;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import com.ss.android.lark.utils.UIHelper;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a {
    public boolean a;

    /* JADX INFO: renamed from: j2c.a$a, reason: collision with other inner class name */
    public static abstract class AbstractC0151a {

        /* JADX INFO: renamed from: j2c.a$a$a, reason: collision with other inner class name */
        public static final class C0152a extends AbstractC0151a {
            public static final C0152a a = null;

            static {
                a = new C0152a();
            }

            public C0152a() {
            }
        }

        /* JADX INFO: renamed from: j2c.a$a$b */
        public static final class b extends AbstractC0151a {
        }

        public AbstractC0151a() {
        }
    }

    public static final class b {
        public b() {
            e.b r0 = e.b.a;
            new d.C0154a();
        }
    }

    public static final class c {
        public final int a;
        public final int b;
        public final ColorStateList c;
        public final Function1<ViewGroup, View> d;

        /* JADX INFO: renamed from: j2c.a$c$a, reason: collision with other inner class name */
        public static final class C0153a {
            public final int a;
            public final int b;
            public final ColorStateList c;
            public Function1<? super ViewGroup, ? extends View> d;

            public C0153a() {
                this.a = UIHelper.getColor(2131105604);
                this.b = UIHelper.getDimens(2131168089);
                this.c = ContextCompat.getColorStateList(UIHelper.getContext(), 2131105603);
            }
        }

        public c(int r1, int r2, ColorStateList r3, Function1 r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    public static final class d {
        public final int a;
        public final Integer b;

        /* JADX INFO: renamed from: j2c.a$d$a, reason: collision with other inner class name */
        public static final class C0154a {
            public int a;
            public Integer b;

            public C0154a() {
                this.a = 2131236142;
            }
        }

        public d(int r1, Integer r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static abstract class e {

        /* JADX INFO: renamed from: j2c.a$e$a, reason: collision with other inner class name */
        public static final class C0155a extends e {
            public final c a;

            public C0155a() {
                c.C0153a r0 = new c.C0153a();
                this(new c(r0.a, r0.b, r0.c, r0.d));
            }

            public C0155a(c r2) {
                Intrinsics.checkNotNullParameter(r2, "buttonAttrs");
                this.a = r2;
            }
        }

        public static final class b extends e {
            public static final b a = null;

            static {
                a = new b();
            }

            public b() {
            }
        }

        public e() {
        }
    }

    public final d a() {
        return null;
    }

    public final boolean b() {
        throw null;
    }
}
