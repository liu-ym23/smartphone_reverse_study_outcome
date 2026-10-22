package com.larus.uaigc.chat.markdown.helper;

import com.larus.common_ui.video.VideoPlayView;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a0 implements VideoPlayView.a {
    public final /* synthetic */ iy9.b a;

    public a0(iy9.b r1) {
        this.a = r1;
    }

    public final void a(String r3) {
        iy9.b r0 = this.a;
        if (r0 == null) goto L8;
        Function2<String, Boolean, Unit> r1 = r0.c;
        if (r1 == null) goto L9;
        r1.invoke(r3, Boolean.TRUE);
        return;
    L9:
        return;
    }

    public final void onPause(String r3) {
        iy9.b r0 = this.a;
        if (r0 == null) goto L8;
        Function2<String, Boolean, Unit> r1 = r0.c;
        if (r1 == null) goto L9;
        r1.invoke(r3, Boolean.FALSE);
        return;
    L9:
        return;
    }
}
