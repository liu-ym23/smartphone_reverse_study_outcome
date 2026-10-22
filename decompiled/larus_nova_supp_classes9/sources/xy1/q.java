package xy1;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.livesdk.message.model.z7;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.kmp.core.KmpEnv;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class q extends ga0.a {
    public final DataCenter b;
    public final IRoom c;
    public final boolean d;
    public p e;
    public vlc.d f;

    public final void detachView() {
        ga0.c r0 = ((q46.b) this).a;
        if (r0 == null) goto L5;
        r0.om();
    L5:
        this.e = null;
        ((q46.b) this).a = null;
    }

    public q(DataCenter r3) {
        this.b = r3;
        this.c = (IRoom) r3.get("data_room");
        this.d = Boolean.TRUE.equals(r3.get("data_is_anchor"));
    }

    public final void a0(q46.a r2) {
        ((q46.b) this).a = (ga0.c) r2;
        this.f = (vlc.d) this.b.get("data_message_manager");
        this.e = new p(this);
    }

    public final boolean c0(z7 r14) {
        if (((q46.b) this).a == null) goto L36;
        KmpEnv r0 = KmpEnv.a;
        if (KmpEnv.a() == true) goto L7;
    L9:
        com.bytedance.tools.kcp.spongepreference.runtime.a r1 = ay1.b.d;
        KProperty[] r2 = ay1.b.a;
        String r4 = (String) r1.getValue(null, r2[3]);
        if (((q46.b) this).a == null) goto L36;
        if (this.d == true) goto L36;
        if (String.valueOf(this.c.getId()).equals(r4) == true) goto L36;
        Fragment r5 = ((q46.b) this).a.getParentFragment();
        if (r5 != null) goto L19;
        return false;
    L19:
        FragmentActivity r6 = r5.getActivity();
        if (r6 != null) goto L22;
        return false;
    L22:
        Fragment r7 = r6.getSupportFragmentManager().findFragmentByTag("login_dialog");
        if (r7 == null) goto L28;
        if (r7.isVisible() == false) goto L28;
        return false;
    L28:
        if (((q46.b) this).a.G20(this.e, r14.getGiftId(), r14.getDescription(), r14.getGuideType()) == true) goto L30;
        com.bytedance.android.live.revenue.core.util.e.a(com.bytedance.android.livesdk.revenue.service.message.e.class).b3();
    L30:
        HashMap r3 = new HashMap();
        r3.put("room_id", String.valueOf(this.c.getId()));
        r3.put("anchor_id", String.valueOf(this.c.getAnchorId()));
        if (r14.getGuideType() != 3) goto L33;
        String r8 = "charge";
    L34:
        r3.put("guide_style", r8);
        r3.put("gift_id", String.valueOf(r14.getGiftId()));
        com.bytedance.android.livesdk.gift.platform.core.utils.h.d0("gift_guide_popup_show", r3);
        String r15 = String.valueOf(this.c.getId());
        Intrinsics.checkNotNullParameter(r15, "<set-?>");
        r1.setValue(null, r2[3], r15);
        return true;
    L33:
        r8 = "convenient_gift";
        goto L34
    L7:
        if (com.bytedance.android.live.revenue.core.util.f.a(l01.d.class).isLogin() == true) goto L9;
    L36:
        return false;
    }
}
