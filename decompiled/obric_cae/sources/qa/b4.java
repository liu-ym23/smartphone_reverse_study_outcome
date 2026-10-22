package qa;

import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/* JADX INFO: loaded from: classes.dex */
public class b4 {

    public static class a extends ThreadLocal<CharsetDecoder> {
        @Override // java.lang.ThreadLocal
        public final CharsetDecoder initialValue() {
            return Charset.forName("UTF-8").newDecoder();
        }
    }

    public static class b extends ThreadLocal<Charset> {
        @Override // java.lang.ThreadLocal
        public final Charset initialValue() {
            return Charset.forName("UTF-8");
        }
    }

    static {
        new a();
        new b();
        new ThreadLocal();
    }
}
