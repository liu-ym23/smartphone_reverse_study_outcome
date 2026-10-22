package c5a;

import com.lynx.clay.embedding.engine.loader.FlutterLoader;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b {
    public static b b;
    public final FlutterLoader a;

    public static b a() {
        if (b != null) goto L6;
        b = new b(new FlutterLoader());
    L6:
        return b;
    }

    public b(FlutterLoader r1) {
        this.a = r1;
    }
}
