package com.bytedance.android.livesdk.chatroom.widget;

import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.eventbus.StickerInfo;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.effectmanager.common.utils.JsonExtKt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a implements Runnable {
    public final /* synthetic */ AnchorEffectStatusServiceWidget.b a;
    public final /* synthetic */ List b;

    public a(AnchorEffectStatusServiceWidget.b r1, List r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        ArrayList r0 = new ArrayList();
        ArrayList r1 = new ArrayList();
        Iterator r2 = this.b.iterator();
    L4:
        if (r2.hasNext() == false) goto L40;
        StickerInfo r3 = (StickerInfo) r2.next();
        int r4 = ln1.a.a.a;
        JSONObject r5 = ln1.a.a.b(r3.extra);
        if (r5 != null) goto L8;
    L26:
        r1.add(Long.valueOf(r3.effectID));
        if (this.a.a.d.contains(Long.valueOf(r3.effectID)) == true) goto L4;
        if (r5 == null) goto L32;
        String r6 = r5.optString("effect_type");
        if (r6 == null) goto L32;
    L33:
        HashMap r9 = new HashMap();
        if (r6.length() <= 0) goto L36;
        boolean r10 = true;
    L37:
        if (r10 == false) goto L39;
        r9.put("effect_type", r6);
    L39:
        r9.put("effect_id", String.valueOf(r3.effectID));
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_audience_effect_show", r9, new Object[]{Room.class, am2.x.class});
        goto L4
    L36:
        r10 = false;
    L32:
        r6 = "";
        goto L33
    L8:
        if (r5.optInt("carnival_interact_effect") != 1) goto L26;
        r0.add(Long.valueOf(r3.effectID));
        if (this.a.a.c.contains(Long.valueOf(r3.effectID)) == true) goto L26;
        HashMap r8 = new HashMap();
        JSONObject r11 = ln1.a.a.b(r5.optString("tea_log"));
        String r12 = null;
        if (r11 == null) goto L14;
        Map r13 = JsonExtKt.toMap(r11);
    L15:
        if (r13 == null) goto L20;
        Iterator r14 = r13.entrySet().iterator();
    L18:
        if (r14.hasNext() == false) goto L20;
        Map.Entry r15 = (Map.Entry) r14.next();
        r8.put(r15.getKey(), r15.getValue().toString());
    L20:
        r8.put("sticker_id", String.valueOf(r3.effectID));
        IUserService r16 = jc1.k.f(IUserService.class);
        if (r16 == null) goto L25;
        com.bytedance.android.livesdk.user.f r17 = r16.user();
        if (r17 == null) goto L25;
        r12 = r17.n();
    L25:
        r8.put("user_id", String.valueOf(r12));
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_live_carnival_sticker_audience_show", r8, new Object[]{Room.class, am2.x.class});
        goto L26
    L14:
        r13 = null;
        goto L15
    L40:
        this.a.a.c.clear();
        this.a.a.c.addAll(r0);
        this.a.a.d.clear();
        this.a.a.d.addAll(r1);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
