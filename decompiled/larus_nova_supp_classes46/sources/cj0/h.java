package cj0;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.liveinteract.plantform.monitor.MultiLinkEventModule;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.plantform.utils.u0;
import com.bytedance.android.live.liveinteract.revenue.paid.viewmodel.PaidLinkMicContext;
import com.bytedance.android.live.liveinteract.videotalk.utils.b0;
import com.bytedance.android.livesdk.config.wd1;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.util.url.UrlBuilder;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.UriProtector;
import hh1.t0;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import org.json.JSONObject;
import tf0.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class h {
    public static final boolean a() {
        xh0.d r0 = ((IInteractService) jc1.k.n(IInteractService.class)).getPlayModeService();
        xh0.g r1 = null;
        if (r0 == null) goto L6;
        r1 = r0.a(11, null);
    L6:
        if (r1 != null) goto L8;
    L16:
        return false;
    L8:
        if (r1.c == true) goto L16;
        if (r1.e.length() <= 0) goto L12;
        boolean r2 = true;
    L13:
        if (r2 == false) goto L16;
        f2.c(r1.e, 0);
        return true;
    L12:
        r2 = false;
        goto L13
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void b(Context r18, String r19) {
        ReadOnlyProperty r1 = vm2.d.x4;
        KProperty[] r2 = vm2.d.a;
        IRoom r5 = null;
        String r4 = ((wd1) r1.getValue(null, r2[281(0x119, float:3.94E-43)])).b();
        String r3 = ((wd1) r1.getValue(null, r2[281(0x119, float:3.94E-43)])).a();
        LinkedHashMap r6 = new LinkedHashMap();
        r6.put("scene", String.valueOf(((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene()));
        String r7 = "1";
        String r8 = "0";
        if (fj0.e.k() == false) goto L5;
        Object[] r9 = "1";
    L6:
        r6.put("isOpen", r9);
        m r10 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r10 == null) goto L9;
        IRoom r11 = (IRoom) r10.getValue();
    L11:
        if (fj0.e.g(r11) == false) goto L13;
        Object[] r12 = "1";
    L14:
        r6.put("optran_paid_linkmic", r12);
        r6.put("showLinkmicMode", "0");
        PaidLinkMicContext.a r13 = PaidLinkMicContext.Companion;
        boolean r14 = true;
        if (r13 == null) goto L21;
        c r15 = r13.a();
        if (r15 == null) goto L21;
        if (r15.isPaidLinkOn() != true) goto L21;
        r6.put("linkmicMode", "2");
    L21:
        m r16 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r16 == null) goto L27;
        IRoom r17 = (IRoom) r16.getValue();
        if (r17 == null) goto L27;
        String r20 = String.valueOf(r17.getId());
        if (r20 == null) goto L27;
    L28:
        r6.put("room_id", r20);
        if (je0.d.u() == false) goto L31;
        String r21 = "voice_live";
    L32:
        r6.put("live_type", r21);
        r6.put("function_type", TalkRoomLogUtils.g());
        String r22 = u0.j(je0.d.h());
        if (r22 == null) goto L35;
        r6.put("layout_type", r22);
    L35:
        r6.put("function_type2", TalkRoomLogUtils.h);
        o r23 = b0.c();
        if (r23 == null) goto L42;
        t0 r24 = r23.C();
        if (r24 == null) goto L42;
        if (r24.isDynamic() != true) goto L42;
    L43:
        if (r14 == true) goto L46;
        r7 = "0";
    L46:
        r6.put("seat_fit_status", r7);
        r6.put("source", r19);
        Integer r25 = je0.d.h();
        if (r25 == null) goto L52;
        String r26 = String.valueOf(r25.intValue());
        if (r26 == null) goto L52;
        r8 = r26;
    L52:
        r6.put("ui_layout", r8);
        UrlBuilder r27 = new UrlBuilder(r4);
        Iterator r28 = r6.entrySet().iterator();
    L54:
        if (r28.hasNext() == false) goto L56;
        Map.Entry r29 = (Map.Entry) r28.next();
        r27.addParam((String) r29.getKey(), (String) r29.getValue());
        goto L54
    L56:
        String r30 = r27.build();
        Uri.Builder r31 = UriProtector.parse(r3).buildUpon();
        if (je0.d.u() == true) goto L59;
        boolean r32 = tb1.d.a;
        int r33 = 380;
    L60:
        m r34 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r34 == null) goto L64;
        r5 = (IRoom) r34.getValue();
    L64:
        if (fj0.e.g(r5) == false) goto L66;
        r33 = r33 + 20;
    L66:
        jc1.k.n(IBaseLiveActionHandler.class).handle(r18, r31.appendQueryParameter("height", String.valueOf(r33)).appendQueryParameter("url", r30).build().toString());
        if (fj0.e.k() == true) goto L69;
        fj0.a r35 = fj0.b.a;
        r35.getClass();
        Intrinsics.checkNotNullParameter(r19, "<set-?>");
        r35.a = r19;
    L69:
        fj0.a r36 = fj0.b.a;
        if (fj0.e.k() == false) goto L72;
        String r37 = "change";
    L73:
        r36.getClass();
        Intrinsics.checkNotNullParameter(r37, "<set-?>");
        MultiLinkEventModule r38 = com.bytedance.android.live.liveinteract.api.fulllink.revenue.g.a;
        boolean r39 = fj0.e.k();
        Intrinsics.checkNotNullParameter(r19, "source");
        JSONObject r110 = new JSONObject();
        r110.put("source", r19);
        r110.put("isOpen", r39 ? 1 : 0);
        nd0.c.p(nd0.c.a, LinkMonitorData.OpenPaidLinkMicLynxPanel, r110, com.bytedance.android.live.liveinteract.api.fulllink.revenue.g.a, 0, null, false, null, 120);
        return;
    L72:
        r37 = "open";
        goto L73
    L59:
        r33 = 290;
    L42:
        r14 = false;
        goto L43
    L31:
        r21 = "video_live";
    L27:
        r20 = "";
        goto L28
    L13:
        r12 = "0";
        goto L14
    L9:
        r11 = null;
        goto L11
    L5:
        r9 = "0";
        goto L6
    }
}
