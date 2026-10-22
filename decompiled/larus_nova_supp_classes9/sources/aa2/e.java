package aa2;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.listener.ITextMessageView;
import com.bytedance.android.livesdk.interactivity.publicscreen.presenter.TransTextMessagePresenter;
import com.bytedance.android.livesdk.interactivity.textmessage.model.i0;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final /* synthetic */ class e implements r42.h.a {
    public final /* synthetic */ TransTextMessagePresenter a;

    public /* synthetic */ e(TransTextMessagePresenter r1) {
        this.a = r1;
    }

    public final void a(List r8) {
        TransTextMessagePresenter r0 = this.a;
        r0.X = false;
        ArrayList r2 = (ArrayList) r8;
        if (r2.isEmpty() == false) goto L26;
        return;
    L26:
    L23:
        r0.y = true;
        ALogger.e("HISTORY_COMMENT_TAG", "load more error," + r8.size() + "/" + ((ArrayList) r0.f).size());
    L24:
        HashMap r1 = new HashMap();
        r1.put("comment_send_num", String.valueOf(r8.size()));
        j0.l().sendLog("livesdk_history_comment_load", r1, new Object[]{new am2.x(), IRoom.class});
        return;
    L7:
        if ((((ArrayList) r0.f).size() + r2.size()) <= 200) goto L9;
        r8 = r2.subList(0, Math.max(200 - ((ArrayList) r0.f).size(), 0));     // Catch: Exception -> L23
        r0.y = true;     // Catch: Exception -> L23
    L9:
        Iterator r3 = r8.iterator();     // Catch: Exception -> L23
    L10:
        if (r3.hasNext() == false) goto L24;
        com.bytedance.android.livesdk.interactivity.api.entity.f<?> r4 = i0.e((com.bytedance.android.live.base.model.message.t) r3.next(), r0.l0().m, r0.e);     // Catch: Exception -> L23
        if (r4 == null) goto L10;
        r4.g = true;     // Catch: Exception -> L23
        if (r0.v0(r4) == true) goto L10;
        ListProtector.add(r0.f, 0, r4);     // Catch: Exception -> L23
        ITextMessageView r5 = ((q46.b) r0).a;     // Catch: Exception -> L23
        if (r5 == null) goto L10;
        r5.DD(0, 1, 0);     // Catch: Exception -> L23
        goto L10
    }
}
