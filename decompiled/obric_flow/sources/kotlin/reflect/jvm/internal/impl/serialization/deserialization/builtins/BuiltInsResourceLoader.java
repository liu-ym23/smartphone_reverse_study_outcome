package kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins;

import com.lynx.serval.svg.SVGRenderEngine;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nBuiltInsResourceLoader.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BuiltInsResourceLoader.kt\norg/jetbrains/kotlin/serialization/deserialization/builtins/BuiltInsResourceLoader\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,21:1\n1#2:22\n*E\n"})
public final class BuiltInsResourceLoader {
    public BuiltInsResourceLoader() {
    }

    public final InputStream loadResource(String r5) {
        Intrinsics.checkNotNullParameter(r5, SVGRenderEngine.PATH);
        ClassLoader r10 = BuiltInsResourceLoader.class.getClassLoader();
        if (r10 == null) goto L5;
        URL r11 = r10.getResource(r5);
        if (r11 != null) goto L10;
        return null;
    L10:
        URLConnection r12 = r11.openConnection();
        r12.setUseCaches(false);
        return r12.getInputStream();
    L5:
        return ClassLoader.getSystemResourceAsStream(r5);
    }
}
