package wbb;

import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.callback.OnUpdateProgressListener;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface d {

    public static class a<T> {
        public final OnUpdateProgressListener a;
        public final IGetDataCallback<T> b;
        public final String c;

        public a(OnUpdateProgressListener r1, IGetDataCallback<T> r2, String r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static class b {
        public final String a;
        public final boolean b;

        public b(String r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static class c {
        public final boolean a;

        public c(boolean r1) {
            this.a = r1;
        }
    }
}
