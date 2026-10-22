package com.bytedance.android.live.liveinteract.interactivesong.impl;

import com.bytedance.live.datacontext.m;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a implements of0.a {
    public a() {
    }

    @Override // wi0.a
    public final String a() {
        InteractiveSongContext r0 = InteractiveSongContext.Companion.getContext();
        if (r0 == null) goto L8;
        m<String> r1 = r0.getSingingGuestId();
        if (r1 == null) goto L8;
        String r2 = (String) r1.getValue();
        if (r2 == null) goto L8;
        return r2;
    L8:
        return "";
    }

    @Override // of0.a
    public final InteractiveSongWidget b() {
        return new InteractiveSongWidget();
    }

    @Override // wi0.a
    public final void y5(String r2) {
        InteractiveSongContext r0 = InteractiveSongContext.Companion.getContext();
        if (r0 == null) goto L10;
        com.bytedance.live.datacontext.j<of0.b> r1 = r0.getInteractiveSongWidget();
        if (r1 == null) goto L11;
        of0.b r3 = (of0.b) r1.getValue();
        if (r3 == null) goto L12;
        r3.y5(r2);
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // wi0.a
    public final void I0(String r8, long r9, boolean r11, Map<String, String> r12) {
        Intrinsics.checkNotNullParameter(r8, "toUserId");
        Intrinsics.checkNotNullParameter(r12, "logMap");
        InteractiveSongContext r0 = InteractiveSongContext.Companion.getContext();
        if (r0 == null) goto L10;
        com.bytedance.live.datacontext.j<of0.b> r1 = r0.getInteractiveSongWidget();
        if (r1 == null) goto L11;
        of0.b r2 = (of0.b) r1.getValue();
        if (r2 == null) goto L12;
        r2.I0(r8, r9, r11, r12);
        return;
    L12:
        return;
    L11:
        return;
    }
}
