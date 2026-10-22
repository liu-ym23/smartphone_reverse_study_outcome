package ut1;

import am2.x;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdkapi.ILiveOntologyInfoManager;
import com.bytedance.android.livesdkapi.TTLiveService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.service.ILiveService;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class h {
    public static final /* synthetic */ int a = 0;

    public static void c() {
        HashMap r0 = new HashMap();
        r0.put("user_id", jc1.k.n(IUserService.class).user().n());
        u.l().sendLog("livesdk_user_screenshift_show", r0, new Object[]{Room.class});
    }

    static {
    }

    public static void a(String r4) {
        Intrinsics.checkNotNullParameter(r4, "eventType");
        if (Intrinsics.areEqual("button", r4) == false) goto L6;
        r4 = "click";
    L8:
        HashMap r0 = new HashMap();
        r0.put("action_type", r4);
        if (e5.n() == false) goto L11;
        String r5 = "landscape";
    L12:
        r0.put("screen_direction", r5);
        u.l().sendLog("livesdk_drawer_close", r0, new Object[]{x.class});
        return;
    L11:
        r5 = "portrait";
        goto L12
    L6:
        if (Intrinsics.areEqual("draw", r4) == false) goto L8;
        r4 = "pull";
        goto L8
    }

    public static void b(String r3, Map r4) {
        Intrinsics.checkNotNullParameter(r3, "eventType");
        if (Intrinsics.areEqual("button", r3) == false) goto L6;
        r3 = "click";
    L8:
        HashMap r0 = new HashMap();
        r0.put("action_type", r3);
        if (e5.n() == false) goto L11;
        String r5 = "landscape";
    L12:
        r0.put("screen_direction", r5);
        ILiveService r6 = TTLiveService.getLiveService();
        if (r6 == null) goto L18;
        ILiveOntologyInfoManager r7 = r6.getLiveOntologyRecord();
        if (r7 == null) goto L18;
        String r8 = r7.getEnterFromMerge();
        if (r8 == null) goto L18;
    L19:
        r0.put("drawer_page", r8);
        if (r4 == null) goto L22;
        r0.putAll(r4);
    L22:
        u.l().sendLog("livesdk_drawer_entrance_click", r0, new Object[]{Room.class, x.class});
        return;
    L18:
        r8 = "";
        goto L19
    L11:
        r5 = "portrait";
        goto L12
    L6:
        if (Intrinsics.areEqual("draw", r3) == false) goto L8;
        r3 = "pull";
        goto L8
    }
}
