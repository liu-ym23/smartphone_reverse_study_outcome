package ka0;

import com.bytedance.android.live.browser.jsbridge.f;
import com.bytedance.ies.web.jsbridge2.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface c extends f {
    void loadUrl(String r1);

    void registerMethod(String r1, com.bytedance.ies.web.jsbridge2.f.b r2);

    <P, R> void registerMethod(String r1, g<P, R> r2);

    void release();

    void reload();
}
