package li0;

import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.base.i;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.livesdk.config.nh0;
import com.bytedance.android.livesdk.model.h0;
import com.bytedance.android.livesdk.utils.u6;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.datacontext.m;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    public static String a() {
        if (com.bytedance.android.live.liveinteract.revenue.common.b.a(2) == null) goto L8;
        String r0 = com.bytedance.android.live.liveinteract.revenue.common.b.a(2);
        if (r0 != null) goto L12;
        return "";
    L12:
        return r0;
    L8:
        if (d.g(null) == false) goto L10;
        return "https://p3-webcast.douyinpic.com/img/webcast/790cc1846778234a9e87c38bc38be527.png~tplv-obj.image";
    L10:
        return "https://p6-webcast.douyinpic.com/img/webcast/425a524914422ad929a14066090ef97c.png~tplv-obj.image";
    }

    public static String c() {
        if (com.bytedance.android.live.liveinteract.revenue.common.b.a(3) == null) goto L7;
        String r0 = com.bytedance.android.live.liveinteract.revenue.common.b.a(3);
        if (r0 != null) goto L9;
        return "";
    L9:
        return r0;
    L7:
        return "https://p3-webcast.douyinpic.com/img/webcast/7e93881a73b694e52872aacd90829022.png~tplv-obj.image";
    }

    public static String b() {
        String r0 = com.bytedance.android.live.liveinteract.revenue.common.b.c();
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L12;
        String r2 = com.bytedance.android.live.liveinteract.revenue.common.b.c();
        Intrinsics.checkNotNull(r2);
        return r2;
    L12:
        return ((h0) nh0.a.getValue()).a();
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r1 = false;
        goto L9
    }

    static {
    }

    public static void d(u6 r5) {
        m r0 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        Long r1 = null;
        if (r0 == null) goto L5;
        IRoom r2 = (IRoom) r0.getValue();
    L6:
        LinkedHashMap r3 = new LinkedHashMap();
        if (r2 == null) goto L9;
        r1 = Long.valueOf(r2.getId());
    L9:
        r3.put("room_id", String.valueOf(r1));
        if (r2 == null) goto L13;
        String r4 = r2.getOwnerUserIdString();
        if (r4 == null) goto L13;
    L14:
        r3.put("anchor_id", r4);
        i<ILinkPlayerInfoBridge> r6 = ((IInteractService) k.n(IInteractService.class)).getLinkUserInfoCenter();
        if (r6 == null) goto L18;
        String r7 = String.valueOf(r6.b());
        if (r7 == null) goto L18;
    L19:
        r3.put("user_cnt", r7);
        r3.put("action_from", "start");
        r3.put("function_type", ((IInteractService) k.n(IInteractService.class)).getCurrentFunctionType());
        if (r2 != null) goto L22;
    L24:
        String r8 = "video_live";
    L25:
        r3.put("live_type", r8);
        Iterator r9 = r3.entrySet().iterator();
    L27:
        if (r9.hasNext() == false) goto L29;
        Map.Entry r10 = (Map.Entry) r9.next();
        r5.b((String) r10.getKey(), (String) r10.getValue());
        goto L27
    L29:
        return;
    L22:
        if (r2.isLiveTypeAudio() != true) goto L24;
        r8 = "voice_live";
    L18:
        r7 = "0";
    L13:
        r4 = "";
        goto L14
    L5:
        r2 = null;
        goto L6
    }
}
