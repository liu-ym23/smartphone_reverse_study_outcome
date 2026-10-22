package apb;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import java.util.Locale;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public interface b {
    boolean a();

    String b();

    void c(zob.b r1);

    String d(Locale r1);

    Locale e();

    void f(Application r1, yob.b r2);

    Locale g();

    Locale getCacheLanguageSetting();

    Locale getLanguageSetting();

    void h(Configuration r1);

    Context i(Context r1, Locale r2);

    boolean isGooglePlay();

    Context j(Context r1);

    void k(zob.b r1);

    void l(Application r1);

    boolean m(Application r1, Locale r2);
}
