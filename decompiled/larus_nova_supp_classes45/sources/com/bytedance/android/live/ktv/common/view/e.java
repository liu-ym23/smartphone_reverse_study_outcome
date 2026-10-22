package com.bytedance.android.live.ktv.common.view;

import android.view.View;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdkapi.TTLiveServiceMiddleware;
import com.bytedance.android.livesdkapi.service.IMiddlewareLiveService;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.json.JSONArray;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e implements View.OnClickListener {
    public final /* synthetic */ HSImageView a;
    public final /* synthetic */ LiveOnlineAvatarView b;
    public final /* synthetic */ List c;
    public final /* synthetic */ long d;

    public e(HSImageView r1, LiveOnlineAvatarView r2, List r3, long r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        Function0<Unit> r6 = this.b.getOnClickAvatarCb();
        if (r6 == null) goto L5;
        Unit r7 = (Unit) r6.invoke();
    L5:
        JSONArray r8 = new JSONArray();
        Iterator r0 = this.c.iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        r8.put(((Number) r0.next()).longValue());
        goto L7
    L9:
        String r9 = ("sslocal://webcast_room?room_id=" + this.d + "&enter_from_merge=chat&enter_method=ktv_friend_live_link&room_id_list=") + r8.toString();
        HashMap<String, String> r1 = this.b.d;
        if (r1 == null) goto L15;
        Iterator<Map.Entry<String, String>> r2 = r1.entrySet().iterator();
    L13:
        if (r2.hasNext() == false) goto L15;
        Map.Entry<String, String> r3 = r2.next();
        StringBuilder r4 = new StringBuilder();
        r4.append(r9);
        r4.append("&" + r3.getKey() + "=" + r3.getValue());
        r9 = r4.toString();
    L15:
        IMiddlewareLiveService r11 = TTLiveServiceMiddleware.getLiveService();
        if (r11 == null) goto L21;
        r11.handleSchema(this.a.getContext(), UriProtector.parse(r9));
        return;
    }
}
