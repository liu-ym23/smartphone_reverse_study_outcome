package s3b;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c {

    public class a implements hya.c<String, f5b.b> {
        public final /* synthetic */ hya.b a;
        public final /* synthetic */ hya.a b;

        public final hya.a<f5b.b> a() {
            return this.b;
        }

        public final hya.b<String> b() {
            return this.a;
        }

        public a(hya.b r1, hya.a r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static List<hya.c<String, f5b.b>> a(hya.b<String> r2, hya.a<f5b.b> r3) {
        ArrayList r0 = new ArrayList();
        r0.add(new a(r2, r3));
        return r0;
    }
}
