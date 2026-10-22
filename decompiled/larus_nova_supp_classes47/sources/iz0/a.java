package iz0;

import io.reactivex.Completable;
import io.reactivex.Single;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface a {
    void a(String r1, String r2);

    void b(String r1, long r2);

    Completable c(Map<String, ?> r1);

    Completable clear();

    String d(String r1, String r2);

    long e(String r1, long r2);

    Completable f(String r1);

    Completable g(String r1);

    Single<Map<String, ?>> getAll();

    Single getString();

    boolean h(String r1);

    void i(String r1);
}
