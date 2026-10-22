package gd2;

import android.content.res.Configuration;
import com.bytedance.android.live.liveinteract.jsbridge.method.h;
import com.bytedance.android.livesdk.chorusconcert.VSChorusConcertWidget;
import com.google.gson.JsonObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public interface f {
    void a(VSChorusConcertWidget.b r1);

    boolean b();

    void c(VSChorusConcertWidget.b r1);

    boolean d();

    void e(hd2.b r1);

    void f();

    JsonObject g(hd2.a r1);

    d getConcertEarMonitor();

    void h(hd2.c r1, h.b r2);

    void onConfigurationChanged(Configuration r1);

    void onPause();

    void onResume();

    void setMainSingerInteractId(String r1);
}
