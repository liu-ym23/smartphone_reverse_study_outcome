package com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner;

import am2.x;
import android.os.Handler;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.h1;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.gift.model.b1;
import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.LinkedHashMap;
import java.util.List;
import jc1.k;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e implements View.OnClickListener {
    public final /* synthetic */ NativeTopRightComponent.NativeActivityTopRightAdapter.ViewHolder a;
    public final /* synthetic */ b1 b;
    public final /* synthetic */ int c;

    public e(NativeTopRightComponent.NativeActivityTopRightAdapter.ViewHolder r1, b1 r2, int r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r21) {
        IBaseLiveActionHandler r1 = k.f(IBaseLiveActionHandler.class);
        if (r1 == null) goto L5;
        r1.handle(((RecyclerView.ViewHolder) this.a).itemView.getContext(), this.b.getSchemaUrl());
    L5:
        NativeTopRightComponent r2 = this.a.a.b;
        if (r2 == null) goto L13;
        Runnable r3 = r2.b;
        if (r3 == null) goto L12;
        Handler r4 = r2.a;
        if (r4 == null) goto L12;
        r4.removeCallbacks(r3);
    L12:
        r2.d = false;
    L13:
        int r5 = so1.a.a;
        b1 r6 = (b1) ListProtector.get(this.a.a.d, this.c);
        int r7 = this.c;
        String r8 = this.a.a.c;
        LinkedHashMap r9 = new LinkedHashMap();
        if (r6 == null) goto L16;
        Long r10 = Long.valueOf(r6.getId());
    L17:
        r9.put("banner_id", String.valueOf(r10));
        r9.put("request_page", "top");
        o r11 = j0.l().c(x.class);
        String r12 = "";
        if (r11.getMap().containsKey("event_page") == false) goto L21;
        String r13 = (String) r11.getMap().get("event_page");
        if (r13 == null) goto L21;
    L22:
        r9.put("event_page", r13);
        com.bytedance.android.livesdk.chatroom.o r14 = z51.a.h(null, 3);
        if (r14 == null) goto L39;
        m r15 = r14.getRoom();
        if (r15 == null) goto L39;
        IRoom r16 = (IRoom) r15.getValue();
        if (r16 == null) goto L39;
        String r17 = r16.getAnchorId();
        if (r17 != null) goto L31;
        r17 = "";
    L31:
        r9.put("anchor_id", r17);
        IMiddlewareUserService r18 = k.f(IMiddlewareUserService.class);
        if (r18 == null) goto L37;
        com.bytedance.android.livesdk.user.e r19 = r18.user();
        if (r19 == null) goto L37;
        String r20 = r19.n();
        if (r20 == null) goto L37;
    L38:
        r9.put("user_id", r20);
        r9.put("room_id", r16.getIdStr());
        r9.put("room_type", h1.b(r16));
        r9.put("log_pb", r16.getLog_pb());
    L37:
        r20 = "";
    L39:
        r9.put("banner_action", "auto");
        r9.put("index", String.valueOf(r7));
        com.bytedance.android.livesdk.chatroom.o r22 = z51.a.h(null, 3);
        if (r22 == null) goto L44;
        Boolean r23 = r22.isAnchor();
        if (r23 == null) goto L44;
        boolean r24 = r23.booleanValue();
    L45:
        r9.put("is_anchor", String.valueOf(r24));
        r9.put("log_id", String.valueOf(r8));
        if (r6 == null) goto L53;
        List r25 = r6.getTrackingTypes();
        if (r25 == null) goto L53;
        String r26 = CollectionsKt.joinToString$default(r25, ",", null, null, 0, null, null, 62, null);
        if (r26 == null) goto L53;
        r12 = r26;
    L53:
        r9.put("tracking_type", r12);
        j0.l().sendLog("livesdk_live_banner_click", r9, new Object[0]);
        if (v.a() == false) goto L56;
        ALogger.i("BannerTeaLog", "livesdk_live_banner_click: " + r9);
    L56:
        ALogger.i("tag_banner_TOP", "native click: url =" + this.b.getSchemaUrl());
        return;
    L44:
        r24 = false;
    L21:
        r13 = "";
        goto L22
    L16:
        r10 = null;
        goto L17
    }
}
