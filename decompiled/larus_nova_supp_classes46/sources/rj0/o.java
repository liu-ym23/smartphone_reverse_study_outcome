package rj0;

import android.view.MotionEvent;
import android.view.View;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.ToolbarVideoInteractBehavior;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.Widget;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public interface o {
    void Li(ToolbarVideoInteractBehavior r1);

    void U0(IRoom r1);

    void a(View r1, MotionEvent r2);

    Widget getWidget();

    void h0(IRoom r1);

    boolean interceptCloseRoom(Runnable r1, boolean r2);

    void j1(int r1, Integer r2, String r3, Boolean r4);

    void onSei(String r1, ye1.a r2);

    void setSource(String r1);

    void sg();
}
