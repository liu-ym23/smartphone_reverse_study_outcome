package com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong;

import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.liveinteract.animator.LiveAnimator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class h implements fd0.b {
    public final /* synthetic */ RequestSongMicSeatView a;
    public final /* synthetic */ Function0 b;

    public static final class a implements fd0.b {
        public final /* synthetic */ h a;

        public a(h r1) {
            this.a = r1;
        }

        @Override // fd0.b
        public final void onStop() {
            Function0 r0 = this.a.b;
            if (r0 == null) goto L6;
            Unit r1 = (Unit) r0.invoke();
            return;
        }
    }

    public h(RequestSongMicSeatView r1, Function0 r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // fd0.b
    public final void onStop() {
        TextView r0 = this.a.k;
        if (r0 == null) goto L5;
        UtilityKotlinExtentionsKt.w(r0);
    L5:
        RequestSongMicSeatView r1 = this.a;
        View r2 = r1.h;
        if (r2 == null) goto L12;
        TextView r3 = r1.k;
        if (r3 == null) goto L10;
        CharSequence r4 = r3.getText();
    L11:
        q32.a.a(r2, (int) n.a(r3, String.valueOf(r4)));
        goto L12
    L10:
        r4 = null;
    L12:
        RequestSongMicSeatView r5 = this.a;
        fd0.f r6 = LiveAnimator.a(new View[]{r5.k, r5.g});
        r6.a.d = n.a;
        r6.d(new float[]{0.0f, 1.15f, 1.0f});
        r6.a.b = 500;
        r6.e().i = new a(this);
    }
}
