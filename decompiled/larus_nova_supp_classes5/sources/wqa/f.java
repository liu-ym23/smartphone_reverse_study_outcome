package wqa;

import android.content.Context;
import com.larus.account.saas.core.internal.init.d;
import com.larus.account.saas.core.internal.init.e;
import go2.g;
import sa7.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public interface f {
    String S();

    k a();

    int appId();

    d b();

    g c();

    void d();

    void e();

    com.larus.account.saas.core.internal.init.b f();

    Context getApplicationContext();

    e getLogger();

    com.bytedance.sdk.account.utils.g getMonitor();

    void isLocalTest();
}
