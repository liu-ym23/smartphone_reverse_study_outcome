package com.bytedance.android.livesdk.chatroom.vs_base.player.seekbar;

import android.content.Context;
import com.bytedance.android.livesdk.chatroom.progress.context.PlayerProgressServiceContext;
import com.bytedance.android.livesdk.chatroom.replay.floatwindow.ReplayFloatWindowManager;
import com.ss.android.videoshop.context.VideoContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import mq1.g;
import nic.l;
import nic.p;
import oic.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b {
    public VideoContext a;
    public final a b;
    public final Lazy c;
    public final List<com.bytedance.android.livesdk.chatroom.vs_base.player.seekbar.a> d;
    public final Context e;

    public final class a extends l.a {
        public final PlayerProgressServiceContext a;
        public final /* synthetic */ b b;

        public a(b r1, PlayerProgressServiceContext r2) {
            this.b = r1;
            this.a = r2;
        }

        public final void B(p r2, tic.a r3) {
            g r4 = (g) this.b.c.getValue();
            if (r4 == null) goto L9;
            ReplayFloatWindowManager r5 = r4.c();
            if (r5 == null) goto L9;
            if (r5.c() != true) goto L9;
            return;
        L9:
            Iterator r6 = ((ArrayList) this.b.d).iterator();
        L11:
            if (r6.hasNext() == false) goto L13;
            ((com.bytedance.android.livesdk.chatroom.vs_base.player.seekbar.a) r6.next()).onRenderStart();
            goto L11
        L13:
            PlayerProgressServiceContext r7 = this.a;
            if (r7 == null) goto L19;
            if (r3 == null) goto L20;
            r7.getPlayEntity().setValue(r3);
            return;
        L20:
            return;
        }

        public final void b(f r1, tic.a r2) {
            g r3 = (g) this.b.c.getValue();
            if (r3 == null) goto L9;
            ReplayFloatWindowManager r4 = r3.c();
            if (r4 == null) goto L9;
            if (r4.c() != true) goto L9;
            return;
        L9:
            Iterator r5 = ((ArrayList) this.b.d).iterator();
        L11:
            if (r5.hasNext() == false) goto L13;
            ((com.bytedance.android.livesdk.chatroom.vs_base.player.seekbar.a) r5.next()).z();
            goto L11
        }

        public final void w(f r1, tic.a r2, long r3) {
            g r4 = (g) this.b.c.getValue();
            if (r4 == null) goto L9;
            ReplayFloatWindowManager r5 = r4.c();
            if (r5 == null) goto L9;
            if (r5.c() != true) goto L9;
            return;
        L9:
            Iterator r6 = ((ArrayList) this.b.d).iterator();
        L11:
            if (r6.hasNext() == false) goto L13;
            ((com.bytedance.android.livesdk.chatroom.vs_base.player.seekbar.a) r6.next()).B();
            goto L11
        }

        public final void x(f r5, tic.a r6, boolean r7) {
            g r8 = (g) this.b.c.getValue();
            if (r8 == null) goto L9;
            ReplayFloatWindowManager r9 = r8.c();
            if (r9 == null) goto L9;
            if (r9.c() != true) goto L9;
            return;
        L9:
            Iterator r10 = ((ArrayList) this.b.d).iterator();
        L11:
            if (r10.hasNext() == false) goto L16;
            com.bytedance.android.livesdk.chatroom.vs_base.player.seekbar.a r11 = (com.bytedance.android.livesdk.chatroom.vs_base.player.seekbar.a) r10.next();
            if (r5 == null) goto L15;
            r11.A(r5.getCurrentPosition(), r5.getDuration());
        L15:
            r11.C();
            goto L11
        }

        public final void q(f r6, tic.a r7, int r8, int r9) {
            g r0 = (g) this.b.c.getValue();
            if (r0 == null) goto L9;
            ReplayFloatWindowManager r1 = r0.c();
            if (r1 == null) goto L9;
            if (r1.c() != true) goto L9;
            return;
        L9:
            if (r6 == null) goto L11;
            r8 = r6.getCurrentPosition();
        L11:
            if (r6 == null) goto L13;
            r9 = r6.getDuration();
        L13:
            Iterator r10 = ((ArrayList) this.b.d).iterator();
        L15:
            if (r10.hasNext() == false) goto L17;
            ((com.bytedance.android.livesdk.chatroom.vs_base.player.seekbar.a) r10.next()).A(r8, r9);
            goto L15
        L17:
            PlayerProgressServiceContext r11 = this.a;
            if (r11 == null) goto L23;
            if (r7 == null) goto L24;
            r11.getPlayEntity().setValue(r7);
            return;
        L24:
            return;
        }
    }

    public b(Context r2, PlayerProgressServiceContext r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.e = r2;
        this.b = new a(this, r3);
        this.c = com.bytedance.android.livesdk.chatroom.vs_base.base.a.a(ReplayPlayerProgressBridge$commonBrickService$2.INSTANCE);
        this.d = new ArrayList();
    }
}
