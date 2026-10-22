package kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class BuiltInsResourceLoader {
    public BuiltInsResourceLoader() {
    }

    public final InputStream loadResource(String r10) {
        Intrinsics.checkNotNullParameter(r10, "path");
        ClassLoader r11 = BuiltInsResourceLoader.class.getClassLoader();
        if (r11 == null) goto L5;
        URL r12 = r11.getResource(r10);
        if (r12 != null) goto L10;
        return null;
    L10:
        URLConnection r13 = r12.openConnection();
        r13.setUseCaches(false);
        return r13.getInputStream();
    L5:
        return ClassLoader.getSystemResourceAsStream(r10);
    }
}
