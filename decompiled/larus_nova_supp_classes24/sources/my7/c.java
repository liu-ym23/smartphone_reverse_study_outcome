package my7;

import android.app.Activity;
import android.app.Application;
import android.content.res.Resources;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public interface c {
    void a();

    void b();

    Resources getResources(Activity r1, Resources r2);

    Resources getResources(Application r1, Resources r2);

    void onDestroy();
}
