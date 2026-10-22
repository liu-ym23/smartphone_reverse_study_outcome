package bi0;

import android.content.Context;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.base.i;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.revenue.adventure.AdventureContext;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdk.sharedpref.d;
import com.bytedance.android.livesdk.sharedpref.e;
import com.bytedance.android.livesdk.sharedpref.f;
import com.bytedance.android.livesdk.utils.u6;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.datacontext.m;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import xh0.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public static String a;

    static {
        a = "";
    }

    public static void b(Context r5, Map r6) {
        Intrinsics.checkNotNullParameter(r5, "context");
        m r0 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        boolean r1 = true;
        if (r0 == null) goto L9;
        IRoom r2 = (IRoom) r0.getValue();
        if (r2 == null) goto L9;
        if (r2.isLiveTypeAudio() != true) goto L9;
        boolean r3 = true;
    L10:
        if (r3 == false) goto L12;
        boolean r4 = d.a();
    L13:
        if (r4 == true) goto L16;
        f2.b(2131914604, 0);
        return;
    L16:
        AdventureContext.Companion.getClass();
        if (AdventureContext.a.a() == false) goto L24;
        a(r5, vm2.d.n().closePanelSchema, vm2.d.n().closePanelUrl, r6);
        if (r6 == null) goto L22;
        String r7 = (String) r6.get("request_page");
        if (r7 == null) goto L22;
    L23:
        a = r7;
        return;
    L22:
        r7 = "";
        goto L23
    L24:
        IInteractService r8 = (IInteractService) k.f(IInteractService.class);
        g r9 = null;
        if (r8 == null) goto L29;
        xh0.d r10 = r8.getPlayModeService();
        if (r10 == null) goto L29;
        r9 = r10.a(29, null);
    L29:
        if (r9 != null) goto L31;
    L39:
        e r11 = b6.J;
        if (((Boolean) r11.getValue()).booleanValue() == false) goto L42;
        a(r5, vm2.d.n().startPanelSchema, vm2.d.n().startPanelUrl, r6);
        return;
    L42:
        a(r5, vm2.d.n().guidePanelSchema, vm2.d.n().guidePanelUrl, r6);
        f.d(r11, Boolean.TRUE);
        return;
    L31:
        if (r9.c == true) goto L39;
        if (r9.e.length() > 0) goto L36;
        r1 = false;
    L36:
        if (r1 == false) goto L39;
        f2.c(r9.e, 0);
        return;
    L12:
        r4 = d.b();
    L9:
        r3 = false;
        goto L10
    }

    public static void a(Context r5, String r6, String r7, Map r8) {
        ALogger.i("Adventure#ToolbarAdventureBehavior", "onClick#openStartPanel.schema:" + r6 + ",url:" + r7 + ",params:" + r8);
        boolean r1 = false;
        if (r6.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        if (r7.length() != 0) goto L10;
        r1 = true;
    L10:
        if (r1 == true) goto L50;
        u6 r2 = new u6(r6);
        r2.b("url", r7);
        u6 r9 = r2.d("url");
        if (r8 == null) goto L18;
        Iterator r10 = r8.entrySet().iterator();
    L16:
        if (r10.hasNext() == false) goto L18;
        Map.Entry r11 = (Map.Entry) r10.next();
        r9.b((String) r11.getKey(), (String) r11.getValue());
    L18:
        m r12 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        Long r13 = null;
        if (r12 == null) goto L21;
        IRoom r14 = (IRoom) r12.getValue();
    L22:
        LinkedHashMap r3 = new LinkedHashMap();
        if (r14 == null) goto L25;
        r13 = Long.valueOf(r14.getId());
    L25:
        r3.put("room_id", String.valueOf(r13));
        if (r14 == null) goto L29;
        String r15 = r14.getOwnerUserIdString();
        if (r15 == null) goto L29;
    L30:
        r3.put("anchor_id", r15);
        i<ILinkPlayerInfoBridge> r16 = ((IInteractService) k.n(IInteractService.class)).getLinkUserInfoCenter();
        if (r16 == null) goto L34;
        String r17 = String.valueOf(r16.b());
        if (r17 == null) goto L34;
    L35:
        r3.put("user_cnt", r17);
        r3.put("action_from", "start");
        r3.put("function_type", ((IInteractService) k.n(IInteractService.class)).getCurrentFunctionType());
        if (r14 != null) goto L38;
    L40:
        String r18 = "video_live";
    L41:
        r3.put("live_type", r18);
        Iterator r19 = r3.entrySet().iterator();
    L43:
        if (r19.hasNext() == false) goto L45;
        Map.Entry r20 = (Map.Entry) r19.next();
        r9.b((String) r20.getKey(), (String) r20.getValue());
        goto L43
    L45:
        k.n(IBaseLiveActionHandler.class).handle(r5, r2.c());
        return;
    L38:
        if (r14.isLiveTypeAudio() != true) goto L40;
        r18 = "voice_live";
    L34:
        r17 = "0";
    L29:
        r15 = "";
        goto L30
    L21:
        r14 = null;
        goto L22
    L50:
        return;
    L5:
        r0 = false;
        goto L6
    }
}
