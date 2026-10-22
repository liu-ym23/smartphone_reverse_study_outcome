package yx8;

import com.larus.camera.impl.ui.component.result.general.ResultConfirmControlStyle;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public abstract class b {

    public static final class a extends b {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }
    }

    /* JADX INFO: renamed from: yx8.b$b, reason: collision with other inner class name */
    public static final class C0145b extends b {
        public static final C0145b a = null;

        static {
            a = new C0145b();
        }

        public C0145b() {
        }
    }

    public static final class c extends b {
        public final ResultConfirmControlStyle a;

        public c() {
            this(0);
        }

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof c) == true) goto L9;
            return false;
        L9:
            if (this.a == ((c) r4).a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "ResultTab(confirmControlStyle=" + this.a + ')';
        }

        public c(ResultConfirmControlStyle r2) {
            Intrinsics.checkNotNullParameter(r2, "confirmControlStyle");
            this.a = r2;
        }

        public /* synthetic */ c(int r1) {
            this(ResultConfirmControlStyle.GENERAL);
        }
    }

    public b() {
    }
}
