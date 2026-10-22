package y6;

import android.app.Activity;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.ies.web.jsbridge2.d0;
import com.bytedance.ies.web.jsbridge2.f;
import com.bytedance.ies.web.jsbridge2.f0;
import com.bytedance.ies.web.jsbridge2.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface c {
    f0 a();

    void b(Activity r1);

    IHybridComponent c();

    d0 d();

    Activity getActivity();

    void registerMethod(String r1, f.b r10);

    <P, R> void registerMethod(String r1, g<P, R> r10);

    void registerMethod(String r1, n56.c r10);

    void release();

    <T> void sendJSEvent(String r1, T r10);
}
