package com.bytedance.android.live.liveinteract.api.utils;

import com.bytedance.android.livesdk.chatroom.u;
import com.bytedance.live.livelink.kmp.api.base.config.Vendor;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
import uf2.d0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class o<T> implements Consumer {
    public final /* synthetic */ p a;
    public final /* synthetic */ int b;
    public final /* synthetic */ long c;

    public o(p r1, long r2) {
        this.a = r1;
        this.b = 3;
        this.c = r2;
    }

    public final void accept(Object r9) {
        Long r10 = (Long) r9;
        this.a.getClass();
        int r0 = 0;
        if (m.d() == null) goto L13;
        com.bytedance.live.datacontext.j r11 = m.d().s();
        com.bytedance.android.livesdk.chatroom.viewmodel.f r1 = null;
        if (r11 == null) goto L7;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r12 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r11.getValue();
    L8:
        if (r12 == null) goto L13;
        com.bytedance.live.datacontext.j r13 = m.d().s();
        if (r13 == null) goto L12;
        r1 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r13.getValue();
    L12:
        Intrinsics.checkNotNull(r1);
        int r14 = r1.t().a;
    L14:
        JSONObject r2 = new JSONObject();
        r2.put("ver", this.b);
        this.a.getClass();
        com.bytedance.live.datacontext.j r3 = m.d().s();
        if (r3 == null) goto L21;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r4 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r3.getValue();
        if (r4 == null) goto L21;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r5 = r4.t();
        if (r5 == null) goto L21;
        int r6 = r5.b;
    L22:
        r2.put("ui_layout", r6);
        r2.put("vendor", Vendor.BYTE.getValue());
        r2.put("timestamp", System.currentTimeMillis());
        r2.put("channel_id", String.valueOf(this.c));
        r2.put("sub_scene", r14);
        this.a.getClass();
        u r7 = m.d();
        if (r7 == null) goto L31;
        com.bytedance.live.datacontext.j r8 = r7.s();
        if (r8 == null) goto L31;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r15 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r8.getValue();
        if (r15 == null) goto L31;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r16 = r15.t();
        if (r16 == null) goto L31;
        r0 = r16.b;
    L31:
        r2.put("ui_layout", r0);
        r2.put("grids", new JSONArray());
        com.bytedance.android.live.pushstream.d r17 = this.a.b;
        if (r17 == null) goto L34;
        r17.c1("app_data", r2.toString(), -1, true, true);
    L34:
        if (r14 != 0) goto L40;
        com.bytedance.android.live.pushstream.d r18 = this.a.b;
        if (r18 == null) goto L46;
        d0 r19 = r18.A();
        if (r19 == null) goto L47;
        r19.c0();
        return;
    L47:
        return;
    L46:
        return;
    L40:
        com.bytedance.android.live.pushstream.d r20 = this.a.b;
        if (r20 == null) goto L49;
        d0 r21 = r20.A();
        if (r21 == null) goto L50;
        r21.c0();
        return;
    L50:
        return;
    L49:
        return;
    L21:
        r6 = 0;
        goto L22
    L7:
        r12 = null;
    L13:
        r14 = 0;
        goto L14
    }
}
