package com.bytedance.android.live.liveinteract.chatroom.chatroom;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.DialogInterface;
import android.view.View;
import com.bytedance.android.live.broadcast.api.IMiddlewareBroadcastService;
import com.bytedance.android.live.core.utils.h;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.interact.LinkDialog;
import com.bytedance.android.scope.m;
import kotlin.jvm.internal.Intrinsics;
import nz.t;
import nz.v;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e implements js0.b {
    public final /* synthetic */ ToolbarVideoInteractBehavior a;
    public final /* synthetic */ LinkDialog b;

    public static final class a implements DialogInterface.OnDismissListener {
        public final /* synthetic */ e a;
        public final /* synthetic */ IMiddlewareBroadcastService b;

        public a(e r1, IMiddlewareBroadcastService r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface r9) {
            ToolbarVideoInteractBehavior r10 = this.a.a;
            String r0 = s1.B(2131920496);
            int r1 = ToolbarVideoInteractBehavior.F;
            r10.i(r0);
            View r11 = this.a.a.b;
            if (r11 == null) goto L6;
            AnimatorSet r2 = new AnimatorSet();
            r2.playSequentially(new Animator[]{h.c(r11, new float[]{0.1f}).setDuration(500), h.c(r11, new float[]{1.0f}).setDuration(500)});
            r2.start();
        L6:
            m r12 = m.e;
            f00.a.a r3 = f00.a.b;
            t r4 = (t) r12.d(r3, t.class);
            if (r4 != null) goto L9;
        L13:
            this.b.markPopupShown(19);
            return;
        L9:
            if (r4.isOpen() != true) goto L13;
            v r13 = (v) r12.d(r3, v.class);
            if (r13 == null) goto L15;
            r13.markPopupShown(19);
            return;
        }
    }

    @Override // js0.b
    public final void onSuccess(String r7) {
        Intrinsics.checkNotNullParameter(r7, "track");
        IMiddlewareBroadcastService r8 = (IMiddlewareBroadcastService) va1.b.a.a.a(IMiddlewareBroadcastService.class);
        r8.justReportRoomEvent(9, 0, 19, "");
        if (r8.shouldShowGuidePromptBubble(19) == false) goto L6;
        this.b.setOnDismissListener(new a(this, r8));
        return;
    }

    public e(ToolbarVideoInteractBehavior r1, LinkDialog r2) {
        this.a = r1;
        this.b = r2;
    }
}
