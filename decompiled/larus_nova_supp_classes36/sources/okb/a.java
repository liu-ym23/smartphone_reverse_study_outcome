package okb;

import android.app.Activity;
import com.ss.android.lark.chat.service.impl.MonitorMessageSendCallback;
import java.util.Locale;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public interface a extends ikb.a {

    /* JADX INFO: renamed from: okb.a$a, reason: collision with other inner class name */
    public interface InterfaceC0305a {
        void b();
    }

    public interface b {
        void a();
    }

    long a();

    boolean b();

    Locale c();

    void d(b r1);

    void e(b r1);

    void f(MonitorMessageSendCallback.b r1);

    Locale getCacheLanguageSetting();

    int getCurNetWorkLevel();

    Activity getTopActivity();
}
