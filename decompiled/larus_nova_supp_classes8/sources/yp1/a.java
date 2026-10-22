package yp1;

import com.bytedance.android.livesdk.chatroom.vs.gesture.VSGestureViewManagerHelper;
import com.bytedance.android.livesdk.chatroom.vs.widget.landscape.VSRoomLandscapeResetPlayerViewWidget;
import com.bytedance.android.scope.o;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import ko1.c;
import nm1.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a implements p, o {
    public a() {
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    public final void c() {
        c r0 = VSGestureViewManagerHelper.a;
        if (r0 == null) goto L6;
        r0.b("restore_button");
        return;
    }

    public final Class<? extends Widget> d() {
        return VSRoomLandscapeResetPlayerViewWidget.class;
    }

    public final boolean a(DataCenter r2) {
        aq1.c.c.getClass();
        return aq1.c.a.a(r2);
    }
}
