package zh0;

import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.radio.impl.RadioWidget;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g0 implements Observer<KVData> {
    public final /* synthetic */ RadioWidget a;

    public g0(RadioWidget r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        KVData r4 = (KVData) r3;
        if (r4 == null) goto L6;
        ALogger.i("[FM]RadioWidget", "UiLayoutOnChanged.curScene:" + this.a.a + ",key:" + r4.getKey() + ",data:" + r4.getData());
    L6:
        if (this.a.a != 5) goto L21;
        if (r4 != null) goto L9;
        return;
    L9:
        if (r4.getKey() != null) goto L11;
        return;
    L11:
        if (r4.getKey().equals("data_room_audio_chat_ui_layout") == false) goto L24;
        int r5 = ((Integer) r4.getData()).intValue();
        RadioWidget r0 = this.a;
        int r1 = r0.H;
        if (r5 == r1) goto L19;
        if (r1 == 0) goto L19;
        r0.H = r5;
        View r6 = ((Widget) r0).contentView;
        if (r6 == null) goto L25;
        r6.post(new f0(this));
        return;
    L25:
        return;
    L19:
        r0.H = r5;
        return;
    L24:
        return;
    }
}
