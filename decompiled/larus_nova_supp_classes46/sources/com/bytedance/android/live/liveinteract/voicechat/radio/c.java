package com.bytedance.android.live.liveinteract.voicechat.radio;

import android.text.TextUtils;
import com.bytedance.android.live.base.model.user.User;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c implements he0.b.a {
    public final /* synthetic */ a a;

    @Override // he0.b.a
    public final int C0() {
        return 0;
    }

    @Override // he0.b.a
    public final boolean J8() {
        return false;
    }

    @Override // he0.b.a
    public final List<Integer> R4() {
        return null;
    }

    @Override // he0.b.a
    public final int getUILayout() {
        return 0;
    }

    @Override // he0.b.a
    public final int he() {
        return -1;
    }

    @Override // he0.b.a
    public final int me() {
        return 1;
    }

    @Override // he0.b.a
    public final void o9(List<ti6.f> r1) {
    }

    public c(a r1) {
        this.a = r1;
    }

    @Override // he0.b.a
    public final String N4(String r1) {
        String r2 = this.a.h.b();
        if (r2 != null) goto L6;
        return "";
    L6:
        return r2;
    }

    @Override // he0.b.a
    public final int q0(List<ti6.f> r9, Map<String, Integer> r10) {
        if (r9 == null) goto L18;
        if (r10 == null) goto L18;
        Iterator<ti6.f> r11 = r9.iterator();
    L8:
        if (r11.hasNext() == false) goto L18;
        ti6.f r1 = r11.next();
        String r2 = tc0.c.h().f;
        User r3 = com.bytedance.android.live.liveinteract.api.utils.m.i().getUser();
        if (r3 == null) goto L13;
        String r4 = r3.getUserId();
        if (r4 == null) goto L13;
    L14:
        r10.put(r1.b, 0);
        if (TextUtils.equals(r2, r1.b) == true) goto L16;
        r1.a = 2;
        r1.f = 0.1d;
        r1.g = 0.1d;
        r1.c(r4);
        r1.d = 1.0d;
        r1.e = 1.0d;
        goto L8
    L16:
        r1.a = 1;
        r1.f = 1.0d;
        r1.g = 1.0d;
        r1.c(r4);
        r1.d = 0.0d;
        r1.e = 0.0d;
        r1.i = 0;
    L13:
        r4 = "";
    L18:
        return 0;
    }
}
