package com.bytedance.android.live.liveinteract.plantform.widgt.voicelink;

import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c {
    public static final boolean a() {
        ReadOnlyProperty r0 = vm2.d.a6;
        KProperty[] r1 = vm2.d.a;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r3 = null;
        if (((Boolean) r0.getValue(null, r1[362(0x16a, float:5.07E-43)])).booleanValue() == true) goto L6;
        return false;
    L6:
        if (((Boolean) vm2.d.c6.getValue(null, r1[364(0x16c, float:5.1E-43)])).booleanValue() == false) goto L8;
    L10:
        com.bytedance.live.datacontext.j r2 = com.bytedance.android.live.liveinteract.api.utils.m.d().s();
        if (r2 == null) goto L15;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r4 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r2.getValue();
        if (r4 == null) goto L15;
        r3 = r4.t();
    L15:
        if (r3 != null) goto L17;
    L22:
        return false;
    L17:
        if (r3.a != 9) goto L22;
        if (r3.b != 61) goto L22;
        return true;
    L8:
        if (tc0.c.h().A == null) goto L10;
        return false;
    }
}
