package z52;

import am2.x;
import android.widget.CompoundButton;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ b a;

    public g(b r1) {
        this.a = r1;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton r5, boolean r6) {
        this.a.y.setLotteryOpen(r6);
        if (r6 == false) goto L5;
        String r0 = s1.B(2131920867);
        p61.a.a = true;
    L6:
        f2.c(r0, 0);
        b r1 = this.a;
        r1.e(r1.y);
        xs2.b.a().post(new q22.b(this.a.y));
        this.a.getClass();
        HashMap r2 = new HashMap();
        if (r6 == false) goto L9;
        String r7 = "open";
    L10:
        r2.put("mute_barrage_type", r7);
        j0.l().sendLog("livesdk_landscape_mute_lottery_barrage_click", r2, new Object[]{x.class, IRoom.class});
        return;
    L9:
        r7 = "close";
        goto L10
    L5:
        r0 = s1.B(2131915832);
        goto L6
    }
}
