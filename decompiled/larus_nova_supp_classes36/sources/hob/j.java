package hob;

import com.ss.android.lark.utils.UIHelper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class j extends b {
    public boolean d;
    public String e;
    public a f;
    public boolean g;

    public static final class a {
        public int a;
        public String b;
        public String c;
        public String d;
        public boolean e;
        public int f;

        public a() {
            this.a = 2131255012;
            this.b = "";
            this.f = UIHelper.getColor(2131106616);
        }
    }

    public j(String r2) {
        Intrinsics.checkNotNullParameter(r2, "href");
        super(r2);
        this.d = true;
        this.e = "";
        this.f = new a();
    }
}
