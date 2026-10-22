package luc;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlinx.serialization.ExperimentalSerializationApi;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public interface f {
    boolean a();

    @ExperimentalSerializationApi
    String b(int r1);

    int d();

    @ExperimentalSerializationApi
    List<Annotation> e(int r1);

    String f();

    @ExperimentalSerializationApi
    int g(String r1);

    List<Annotation> getAnnotations();

    o getKind();

    @ExperimentalSerializationApi
    f h(int r1);

    @ExperimentalSerializationApi
    boolean i(int r1);

    boolean isInline();
}
