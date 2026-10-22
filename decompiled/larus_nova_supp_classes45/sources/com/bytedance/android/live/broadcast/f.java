package com.bytedance.android.live.broadcast;

import am2.x;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.broadcast.api.BubblePosition;
import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.x1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.broadcast.CommonBubble;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ Context a;
    public final /* synthetic */ View b;
    public final /* synthetic */ CommonBubble c;
    public final /* synthetic */ String d;
    public final /* synthetic */ BubblePosition e;

    public f(Context r1, View r2, CommonBubble r3, BubblePosition r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = "room_toolbar_anchor";
        this.e = r4;
    }

    /* JADX WARN: Type inference failed for: r15v2, types: [android.widget.ImageView, com.bytedance.android.live.core.widget.HSImageView] */
    public final void accept(Object r18) {
        Long r1 = (Long) r18;
        g r2 = g.a;
        Context r3 = this.a;
        View r4 = this.b;
        CommonBubble r8 = this.c;
        String r9 = this.d;
        BubblePosition r5 = this.e;
        View r6 = LayoutInflater.from(r4.getContext()).inflate(2131565274, null);
        TextView r7 = (TextView) r6.findViewById(2131382780);
        View r11 = r6.findViewById(2131382771);
        View r12 = r6.findViewById(2131382774);
        View r13 = r6.findViewById(2131382776);
        View r14 = r6.findViewById(2131382775);
        View r15 = r6.findViewById(2131382773);
        View r16 = r6.findViewById(2131382772);
        ?? r17 = (HSImageView) r6.findViewById(2131382782);
        ImageView r19 = (ImageView) r6.findViewById(2131382792);
        r19.setVisibility(8);
        if (r7 == null) goto L6;
        r7.setText(r8.getText());
    L6:
        if (r8.getIcon().length() != 0) goto L8;
        boolean r0 = true;
    L9:
        if (r0 == false) goto L11;
        r17.setVisibility(8);
    L13:
        if (r8.getSchema().length() <= 0) goto L15;
        boolean r21 = true;
    L16:
        if (r21 == false) goto L18;
        r19.setVisibility(0);
        r6.setOnClickListener(new b(r3, r8, r9));
    L18:
        int[] r110 = new int[2];
        r4.getLocationInWindow(r110);
        int r22 = 4;
        if ((r110[0] + (r4.getWidth() / 2)) >= (x1.h() / 3)) goto L34;
        if (r5 != BubblePosition.Bottom) goto L27;
        int r23 = 0;
        if (r14 == null) goto L25;
        r14.setVisibility(0);
    L25:
        if (r13 == null) goto L32;
        r13.setVisibility(4);
    L32:
        r22 = 3;
    L54:
        yo2.e r24 = new yo2.e(r3);
        ((yo2.d) r24).d = r6;
        ((yo2.d) r24).e = r23;
        ((yo2.d) r24).m = 5;
        ((yo2.d) r24).n = true;
        ((yo2.d) r24).l = true;
        r24.x = c.a;
        r24.a();
        if (r5 != BubblePosition.Bottom) goto L57;
        int r25 = 2;
    L58:
        r24.i(r4, r25, r22, 0, 0);
        com.bytedance.android.livesdk.sharedpref.e r26 = com.bytedance.android.livesdk.sharedpref.b.Y1;
        HashMap r27 = (HashMap) r26.getValue();
        r27.put(String.valueOf(r8.getId()), Boolean.TRUE);
        com.bytedance.android.livesdk.sharedpref.f.d(r26, r27);
        LinkedHashMap r28 = new LinkedHashMap();
        RoomContext.a r29 = RoomContext.Companion;
        if (r29 == null) goto L67;
        RoomContext r31 = RoomContext.a.c(r29, null, 0, 3);
        if (r31 == null) goto L67;
        com.bytedance.live.datacontext.i r32 = r31.isAnchor();
        if (r32 == null) goto L67;
        if (((Boolean) r32.getValue()).booleanValue() != true) goto L67;
        String r33 = GamePromoteDataContext.GAME_TYPE_MOBILE;
    L68:
        r28.put("is_anchor", r33);
        if (Intrinsics.areEqual(r9, "create_page") == false) goto L71;
        String r34 = "live_take_page";
    L72:
        r28.put("event_page", r34);
        r28.put("text_detail", r8.getText());
        String r35 = String.valueOf(Long.valueOf(r8.getId()).longValue());
        if (r35 != null) goto L75;
        r35 = "";
    L75:
        r28.put("bubble_id", r35);
        r28.putAll(r8.getExtra());
        u.l().sendLog("livesdk_anchor_guide_bubble_show", r28, new Object[]{Room.class, x.class});
        return;
    L71:
        r34 = "live_detail";
    L67:
        r33 = "0";
        goto L68
    L57:
        r25 = 1;
        goto L58
    L27:
        r23 = 0;
        if (r12 == null) goto L30;
        r12.setVisibility(0);
    L30:
        if (r11 == null) goto L32;
        r11.setVisibility(4);
        goto L32
    L34:
        if ((r110[0] + (r4.getWidth() / 2)) > ((x1.h() * 2) / 3)) goto L36;
        r23 = 0;
        if (r5 != BubblePosition.Bottom) goto L51;
        if (r15 == null) goto L53;
        r15.setVisibility(0);
    L53:
        r22 = 0;
        goto L54
    L51:
        if (r16 == null) goto L53;
        r16.setVisibility(0);
        goto L53
    L36:
        if (r5 != BubblePosition.Bottom) goto L42;
        if (r14 == null) goto L39;
        r14.setVisibility(4);
    L39:
        r23 = 0;
        if (r13 == null) goto L54;
        r13.setVisibility(0);
        goto L54
    L42:
        r23 = 0;
        if (r12 == null) goto L45;
        r12.setVisibility(4);
    L45:
        if (r11 == null) goto L54;
        r11.setVisibility(0);
        goto L54
    L15:
        r21 = false;
        goto L16
    L11:
        r17.setVisibility(0);
        ImageLoader.bindImage(r17, r8.getIcon());
        goto L13
    L8:
        r0 = false;
        goto L9
    }
}
