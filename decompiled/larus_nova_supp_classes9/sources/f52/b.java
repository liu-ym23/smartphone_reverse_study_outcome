package f52;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.ies.sdk.widgets.DataCenter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public interface b {
    void a(j r1);

    void b(c r1, View r2, ViewGroup.LayoutParams r3);

    View c(c r1);

    void d(c r1);

    void e(d r1);

    void f(e r1);

    Context getContext();

    DataCenter getDataCenter();

    o getRoomContext();

    ViewGroup getRoot();

    void onCreate();

    void onDestroy();
}
