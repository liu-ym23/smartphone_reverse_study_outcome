package od0;

import android.text.TextUtils;
import com.bytedance.android.live.core.monitor.BaseMonitor;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import java.util.Iterator;
import java.util.List;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d {
    static {
    }

    public static void a(JSONObject r7) {
        Intrinsics.checkNotNullParameter(r7, "extra");
        int r0 = ((IInteractService) k.n(IInteractService.class)).getCurrentScene();
        pd0.b r1 = pd0.b.a;
        BaseMonitor.add(r7, "current_scene", pd0.b.e(r0));
        BaseMonitor.add(r7, "current_ui_layout", pd0.b.f(((IInteractService) k.n(IInteractService.class)).getCurrentUiLayout()));
        List<Integer> r2 = ((IInteractService) k.n(IInteractService.class)).getCurrentPlayModes();
        if (r2 != null) goto L5;
        String r3 = "null";
    L38:
        BaseMonitor.add(r7, "current_play_modes", r3);
        return;
    L5:
        StringBuilder r4 = new StringBuilder();
        Iterator<Integer> r5 = r2.iterator();
    L6:
        String r6 = "";
        if (r5.hasNext() == false) goto L34;
        Integer r8 = r5.next();
        pd0.b r9 = pd0.b.a;
        int r10 = r8.intValue();
        Intrinsics.checkNotNullParameter(r9, "$this$getLinkMicPlayModeDescription");
        if (r10 != 0) goto L11;
        r6 = "unknown(" + r10 + ')';
    L33:
        r4.append(r6);
        r4.append(",");
        goto L6
    L11:
        if (r10 != 29) goto L13;
        r6 = "meetgame";
        goto L33
    L13:
        if (r10 == 13) goto L33;
        if (r10 != 14) goto L17;
    L30:
        r6 = "team_fight";
        goto L33
    L17:
        if (r10 != 16) goto L19;
        r6 = "cross_room_battle";
        goto L33
    L19:
        if (r10 == 17) goto L28;
        switch(r10) {
            case 5: goto L27;
            case 6: goto L26;
            case 7: goto L30;
            case 8: goto L25;
            case 9: goto L24;
            case 10: goto L23;
            case 11: goto L22;
            default: goto L21;
        };
    L21:
        r6 = "unknown(" + r10 + ')';
        goto L33
    L22:
        r6 = "normal_paid_link_mic";
        goto L33
    L23:
        r6 = "video_ktv";
        goto L33
    L24:
        r6 = "anchor_bgm_ktv";
        goto L33
    L25:
        r6 = "anchor_normal_ktv";
        goto L33
    L26:
        r6 = "ktv_challenge";
        goto L33
    L27:
        r6 = "guest_battle";
        goto L33
    L28:
        r6 = "self_discipline";
        goto L33
    L34:
        String r11 = r4.toString();
        if (TextUtils.isEmpty(r11) == true) goto L37;
        r3 = r11.substring(0, r11.length() - 1);
        goto L38
    L37:
        r3 = "";
        goto L38
    }
}
