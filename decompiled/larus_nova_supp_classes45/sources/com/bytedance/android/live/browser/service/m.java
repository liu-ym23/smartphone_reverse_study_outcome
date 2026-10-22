package com.bytedance.android.live.browser.service;

import android.graphics.Rect;
import com.bytedance.android.live.browser.webview.fragment.LiveAnnieXDialogImpl;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.android.livesdk.chatroom.widget.i0;
import com.bytedance.android.livesdk.chatroom.widget.k0;
import com.bytedance.android.livesdk.chatroom.widget.m0;
import com.bytedance.android.livesdk.m1;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.ies.sdk.widgets.info.WidgetInfo;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class m implements d9.b {
    public boolean a;
    public int b;

    public m() {
    }

    public static boolean H1() {
        lm1.b r0 = pm1.f.d(null);
        if (r0 == null) goto L11;
        com.bytedance.live.datacontext.n r1 = r0.getEpisode();
        if (r1 == null) goto L11;
        Episode r2 = (Episode) r1.getValue();
        if (r2 == null) goto L11;
        if (r2.isMatchEpisode() != true) goto L11;
        return true;
    L11:
        if (Intrinsics.areEqual(o3.f().isMatchRoom(), Boolean.TRUE) == true) goto L16;
        return false;
    L16:
        return true;
    }

    public final com.bytedance.android.annie.container.dialog.l P() {
        return new LiveAnnieXDialogImpl();
    }

    public final void W() {
        Integer r0 = Integer.valueOf(this.b);
        if (r0.intValue() != 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L9;
        r0 = null;
    L9:
        if (r0 == null) goto L12;
        int r2 = r0.intValue();
        xs2.b.a().post(new com.bytedance.android.live.core.tetris.widgets.y(false, r2));
        return;
    L12:
        return;
    L5:
        r1 = false;
        goto L6
    }

    public final Integer f1(Map<String, ? extends Object> r7) {
        Intrinsics.checkNotNullParameter(r7, "map");
        Map<String, Object> r0 = new LinkedHashMap();
        Object r2 = null;
        if (e5.n() == true) goto L59;
        MiddlewareRoomContext r1 = MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, null, 0, 3);
        if (r1 == null) goto L18;
        com.bytedance.live.datacontext.j r3 = r1.getRoomUISizeGetter();
        if (r3 == null) goto L18;
        m0 r4 = (m0) r3.getValue();
        if (r4 == null) goto L18;
        Rect r5 = r4.a();
        Rect r6 = r4.c();
        if (r5 == null) goto L18;
        if (r6 == null) goto L18;
        int r8 = r6.bottom - r5.bottom;
        if (r5.height() < r5.width()) goto L16;
        boolean r9 = true;
    L17:
        this.a = r9;
        r0 = I1(r7, r8);
        goto L18
    L16:
        r9 = false;
    L18:
        lm1.b r11 = pm1.f.d(null);
        if (r11 == null) goto L32;
        com.bytedance.live.datacontext.j r12 = r11.getReplayUISizeGetter();
        if (r12 == null) goto L32;
        k0 r13 = (k0) r12.getValue();
        if (r13 == null) goto L32;
        if (r13.a() == null) goto L32;
        WidgetInfo r14 = r13.a();
        if (r14 == null) goto L29;
        int r15 = r14.getContentViewHeight();
    L30:
        this.a = false;
        r0 = I1(r7, r15);
        goto L32
    L29:
        r15 = 0;
    L32:
        if (H1() == false) goto L59;
        if (Intrinsics.areEqual(m1.a.getValue(), Boolean.TRUE) == false) goto L59;
        com.bytedance.live.datacontext.j r16 = o3.f().m2();
        if (r16 == null) goto L43;
        m0 r17 = (m0) r16.getValue();
        if (r17 == null) goto L43;
        Rect r18 = r17.a();
        Rect r19 = r17.c();
        if (r18 == null) goto L43;
        if (r19 == null) goto L43;
        int r21 = r19.bottom - r18.bottom;
    L44:
        com.bytedance.live.datacontext.j r22 = o3.f().O2();
        if (r22 == null) goto L59;
        i0 r23 = (i0) r22.getValue();
        if (r23 == null) goto L59;
        if (r23.a() == null) goto L59;
        WidgetInfo r24 = r23.a();
        if (r24 == null) goto L53;
        int r25 = r24.getContentViewHeight();
    L54:
        this.a = false;
        if (r25 <= 0) goto L58;
        if (r21 > 0) goto L58;
        r0 = I1(r7, r25);
    L58:
        ALogger.i("AnnnieInitHelper", "multitab_height = " + r25);
        goto L59
    L53:
        r25 = 0;
    L43:
        r21 = 0;
    L59:
        Object r26 = r0.get("height_behind_player_widget");
        if ((r26 instanceof Integer) == false) goto L64;
        r2 = r26;
    L64:
        return (Integer) r2;
    }

    public final void p(float r6) {
        double r0 = r6;
        boolean r7 = false;
        if (r0 < 0.5d) goto L6;
        int r1 = 4;
    L9:
        Integer r2 = Integer.valueOf(r1);
        if (r2.intValue() != 0) goto L12;
        r7 = true;
    L12:
        if (r7 == false) goto L15;
        r2 = null;
    L15:
        if (r2 == null) goto L18;
        int r8 = r2.intValue();
        this.b = r8;
        xs2.b.a().post(new com.bytedance.android.live.core.tetris.widgets.y(true, r8));
        return;
    L18:
        return;
    L6:
        if (r0 >= 0.5d) goto L8;
        r1 = 32;
        goto L9
    L8:
        r1 = 0;
        goto L9
    }

    public final Map<String, Object> I1(Map<String, ? extends Object> r4, int r5) {
        LinkedHashMap r0 = new LinkedHashMap();
        if (e5.n() == false) goto L5;
    L22:
        return r0;
    L5:
        if (PadConfigUtils.c() == false) goto L14;
        if (r4.containsKey("margin_bottom") == false) goto L14;
        Object r6 = r4.get("margin_bottom");
        if (r6 == null) goto L12;
        r5 = r5 - ((int) UtilityKotlinExtentionsKt.h(((Integer) r6).intValue()));
        goto L14
    L12:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L14:
        if (PadConfigUtils.c() == true) goto L16;
    L18:
        if (r5 <= 0) goto L22;
        if (this.a == true) goto L22;
        r0.put("height_behind_player_widget", Integer.valueOf(r5));
        goto L22
    L16:
        if (H1() == false) goto L18;
        r5 = r5 - ((int) UtilityKotlinExtentionsKt.h(38));
        goto L18
    }
}
