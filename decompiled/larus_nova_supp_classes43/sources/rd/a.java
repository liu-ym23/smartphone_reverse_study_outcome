package rd;

import android.content.Context;
import td.d;
import td.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface a {
    void a(com.bytedance.android.ec.adapter.api.state.a r1);

    void b(d r1);

    void businessType();

    void c(Context r1, com.bytedance.android.ec.adapter.api.state.a r10);

    void d(td.c r1);

    void e(e r1);

    void f(td.b r1);

    void onActivityCreated();

    void onContextAttached(Context r1);

    void onCreate();

    void onDestroy();

    void onDestroyView();

    void onEnterRoomPrepared();

    void onExitRoom();

    void onRoomVisible();

    void onSpecificBehaviorLoad(String r1, boolean r10, boolean r11, String r12);

    void onSpecificBehaviorUnload(String r1, boolean r10, boolean r11);

    void onSpecificWidgetLoadFinished(String r1);

    void onStart();

    void onStop();

    void onWidgetLoadFinished();
}
