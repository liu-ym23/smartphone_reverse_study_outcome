package oa2;

import am2.x;
import android.view.View;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.carnival.ui.ChatCarnivalView;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.live.datacontext.m;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f implements View.OnClickListener {
    public final /* synthetic */ ChatCarnivalView a;

    public f(ChatCarnivalView r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r9) {
        ChatCarnivalView r10 = this.a;
        r10.c = !r10.c;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.b r11 = r10.d;
        if (r11 == null) goto L12;
        if (r11 != null) goto L6;
    L7:
        com.bytedance.android.livesdk.interactivity.api.publicscreen.b r13 = this.a.d;
        if (r13 == null) goto L12;
        m<Boolean> r14 = r13.isDanmakuVisible();
        if (r14 == null) goto L12;
        r14.setValue(Boolean.valueOf(this.a.c));
        goto L12
    L6:
        if (r11.hasCleared() != true) goto L7;
    L12:
        ChatCarnivalView r15 = this.a;
        if (r15.c == false) goto L15;
        r15.m.setBackground(s1.m(2131250553));
    L16:
        ChatCarnivalView r16 = this.a;
        com.bytedance.android.livesdk.interactivity.api.barrage.model.a r0 = r16.a;
        if (r0 == null) goto L19;
        Long r1 = Long.valueOf(r0.h());
    L20:
        boolean r2 = this.a.c;
        r16.getClass();
        HashMap r17 = new HashMap();
        if (r1 != null) goto L24;
    L26:
        if (r1 != null) goto L29;
    L31:
        String r3 = BuildConfig.FLAVOR;
    L32:
        r17.put("trigger_type", r3);
        if (r2 == false) goto L35;
        String r4 = "show";
    L36:
        r17.put("type", r4);
        j0.l().sendLog("livesdk_comment_carnival_hide", r17, new Object[]{new x(), IRoom.class});
        return;
    L35:
        r4 = "hide";
        goto L36
    L29:
        if (r1.longValue() != 2) goto L31;
        r3 = com.bytedance.android.livesdk.gift.model.e.FETCH_FROM_SETTING;
        goto L32
    L24:
        if (r1.longValue() != 1) goto L26;
        r3 = "prop";
        goto L32
    L19:
        r1 = null;
        goto L20
    L15:
        r15.m.setBackground(s1.m(2131250552));
        goto L16
    }
}
