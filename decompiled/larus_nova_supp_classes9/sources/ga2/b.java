package ga2;

import com.bytedance.android.livesdk.interactivity.api.entity.f;
import com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.view.aiagent.k;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.message.IPublicAreaCommon;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b implements a {
    public static final b a = null;

    public b() {
    }

    static {
        a = new b();
    }

    @Override // ga2.a
    public final void a(f<?> r4, k r5) {
        if (((HashMap) r4.m).containsKey("show_tag_for_public_screen_track_stat") == false) goto L5;
        return;
    L5:
        Map<String, String> r0 = r4.m;
        if (r0 == null) goto L8;
        ((HashMap) r0).put("show_tag_for_public_screen_track_stat", "has_show");
    L8:
        LinkedHashMap r1 = new LinkedHashMap();
        IPublicAreaCommon r6 = r4.v();
        String r2 = BuildConfig.FLAVOR;
        if (r6 == null) goto L14;
        Map r7 = r6.getTrackingParams();
        if (r7 == null) goto L14;
        String r8 = (String) r7.get("msg_type");
        if (r8 == null) goto L14;
    L15:
        r1.put("msg_type", r8);
        if (r5 == null) goto L21;
        String r9 = r5.c();
        if (r9 == null) goto L21;
        r2 = r9;
    L21:
        r1.put("selected_mode_type", r2);
        int r10 = com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.b.a;
        if (r5 == null) goto L26;
        WeakReference<DataCenter> r11 = r5.getDataCenter();
        if (r11 == null) goto L26;
        DataCenter r13 = r11.get();
    L27:
        com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.b.a(r1, r13);
        j0.l().sendLog("livesdk_selected_msg_layer_msg_show", r1, new Object[]{Room.class});
        return;
    L26:
        r13 = null;
    L14:
        r8 = BuildConfig.FLAVOR;
        goto L15
    }
}
