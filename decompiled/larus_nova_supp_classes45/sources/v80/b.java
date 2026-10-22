package v80;

import android.content.Context;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b extends v80.a {
    public final InterfaceC0287b g;
    public final HashMap<String, String> h;

    public static final class a {
        public Context a;
        public String b;
        public String c;
        public String d;
        public InterfaceC0287b e;
        public HashMap<String, String> f;

        public a() {
        }
    }

    /* JADX INFO: renamed from: v80.b$b, reason: collision with other inner class name */
    public interface InterfaceC0287b {
        void a(boolean r1, int r2, String r3, JSONObject r4);
    }

    public b(a r2) {
        this.a = r2.a;
        this.b = r2.b;
        this.c = r2.c;
        this.d = r2.d;
        this.g = r2.e;
        this.h = r2.f;
    }
}
