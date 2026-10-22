package kc0;

import android.view.MotionEvent;
import android.view.View;
import com.bytedance.android.live.core.tetris.widgets.LiveWidget;
import com.bytedance.android.live.revlink.impl.control.LinkRevControlWidget;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.Widget;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface r {

    public interface a {
        void a(LiveWidget r1);

        void b(Widget r1);

        vc0.a getLiveVideoClientFactory();
    }

    void a(View r1, MotionEvent r2);

    void b0(String r1);

    LinkRevControlWidget getWidget();

    void onSei(String r1);

    void p3(IRoom r1);

    void q3(vc0.a r1);
}
