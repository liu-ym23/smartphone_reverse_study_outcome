package com.larus.voicecall.impl.component.bottom.more_btn;

import android.content.res.Resources;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.larus.av_call.model.RealtimePageMode;
import com.larus.av_call.util.RealtimeBottomMoreBtn;
import com.larus.voicecall.impl.component.vlm.ExitScreenShareReason;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class l extends c {
    public final String c;

    @Override // com.larus.voicecall.impl.component.bottom.more_btn.c
    public final void e() {
        super.e();
        w3a.k r0 = this.a.c();
        if (r0 == null) goto L12;
        RealtimePageMode r1 = RealtimePageMode.HALF_SCREEN;
        t1a.b r2 = this.a.b();
        if (r2 == null) goto L7;
        com.larus.voicecall.impl.component.vlm.a r3 = (com.larus.voicecall.impl.component.vlm.a) r2.o(Reflection.getOrCreateKotlinClass(com.larus.voicecall.impl.component.vlm.a.class));
    L8:
        if (r3 == null) goto L10;
        int r4 = r3.Li();
    L11:
        r0.b(r1, r4);
        goto L12
    L10:
        r4 = 0;
        goto L11
    L7:
        r3 = null;
    L12:
        Fragment r5 = this.a.getFragment();
        if (r5 == null) goto L19;
        Resources r6 = r5.getResources();
        if (r6 == null) goto L19;
        int r7 = r6.getColor(2131103256);
        RealtimeBottomMoreBtn r8 = this.a.getHostView();
        if (r8 == null) goto L19;
        r8.setBackground(i88.e.n(r7));
    L19:
        RealtimeBottomMoreBtn r9 = this.a.getHostView();
        if (r9 == null) goto L23;
        r9.setImageResource(2131241804);
        return;
    }

    @Override // com.larus.voicecall.impl.component.bottom.more_btn.c
    public final String b() {
        return this.c;
    }

    public l(d r2) {
        Intrinsics.checkNotNullParameter(r2, "ctx");
        super(r2);
        this.c = "MoreBtnScreenShareState";
    }

    @Override // com.larus.voicecall.impl.component.bottom.more_btn.c
    public final void c(View r5) {
        Intrinsics.checkNotNullParameter(r5, "v");
        t1a.b r6 = this.a.b();
        if (r6 == null) goto L5;
        com.larus.voicecall.impl.component.vlm.a r7 = (com.larus.voicecall.impl.component.vlm.a) r6.o(Reflection.getOrCreateKotlinClass(com.larus.voicecall.impl.component.vlm.a.class));
    L6:
        if (r7 == null) goto L8;
        r7.DW("click_exit_share_screen", ExitScreenShareReason.USER_CLICK, false, true);
    L8:
        i(new k(this.a));
        return;
    L5:
        r7 = null;
        goto L6
    }

    @Override // com.larus.voicecall.impl.component.bottom.more_btn.c
    public final void g(boolean r2) {
        if (r2 == true) goto L5;
        i(new k(this.a));
        return;
    }
}
