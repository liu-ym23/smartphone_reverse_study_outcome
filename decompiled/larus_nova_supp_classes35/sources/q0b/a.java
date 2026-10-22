package q0b;

import com.ss.android.lark.chameleon.ChameleonConfig;
import com.ss.android.lark.chameleon.WebViewPoolConfig;
import com.ss.android.lark.chameleonv2.container.webcontainer.view.ChameleonWebView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface a {

    /* JADX INFO: renamed from: q0b.a$a, reason: collision with other inner class name */
    public interface InterfaceC0279a {
        void a(ChameleonWebView r1);

        void b(ChameleonWebView r1);
    }

    WebViewPoolConfig a();

    ChameleonWebView b(ChameleonConfig r1, Object r2);

    ChameleonWebView c(Object r1);

    ChameleonWebView d(Object r1);

    void destroyAll();

    ChameleonWebView detachWebView(Object r1);

    void e(ChameleonWebView r1);

    ChameleonWebView getOverMaxUsedWebView(int r1);

    int occupiedSize();

    int poolSize();
}
