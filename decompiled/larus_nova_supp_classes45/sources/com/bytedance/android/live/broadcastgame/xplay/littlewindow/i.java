package com.bytedance.android.live.broadcastgame.xplay.littlewindow;

import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.bytedance.android.live.broadcastgame.xplay.XplayLog;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.live.datacontext.n;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class i implements g10.a {

    public static final class a<T extends View> {
        public T a;
        public ViewGroup b;
        public ViewGroup.LayoutParams c;

        public a(T r2) {
            Intrinsics.checkNotNullParameter(r2, "sharedView");
            this.a = r2;
        }
    }

    public static final class b implements com.bytedance.android.live.broadcastgame.api.xplay.h {
        public a<SurfaceView> a;

        public b() {
        }

        @Override // com.bytedance.android.live.broadcastgame.api.xplay.h
        public final void onDestroyView() {
            a<SurfaceView> r0 = this.a;
            if (r0 == null) goto L26;
            View r1 = r0.a;
            if (r1 == null) goto L27;
            ViewParent r2 = r1.getParent();
            if (r2 != null) goto L10;
        L24:
            r0.a = null;
            r0.b = null;
            r0.c = null;
            return;
        L10:
            if ((!Intrinsics.areEqual(r2, r0.b)) == false) goto L24;
            if ((r2 instanceof ViewGroup) == true) goto L14;
            r2 = null;
        L14:
            ViewGroup r3 = (ViewGroup) r2;
            if (r3 == null) goto L17;
            r3.removeView(r1);
        L17:
            ViewGroup.LayoutParams r4 = r0.c;
            if (r4 == null) goto L20;
            r1.setLayoutParams(r4);
        L20:
            ViewGroup r5 = r0.b;
            if (r5 == null) goto L23;
            r5.addView(r1);
        L23:
            int r6 = XplayLog.a;
            XplayLog.a("SharedViewHolder", "released view " + r1);
            goto L24
        L27:
            return;
        }

        @Override // com.bytedance.android.live.broadcastgame.api.xplay.h
        public final void b(ViewGroup r6) {
            Intrinsics.checkNotNullParameter(r6, "parentView");
            View r4 = null;
            RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
            if (r0 == null) goto L11;
            n r1 = r0.getSurfaceView();
            if (r1 == null) goto L11;
            WeakReference r2 = (WeakReference) r1.getValue();
            if (r2 == null) goto L11;
            SurfaceView r3 = (SurfaceView) r2.get();
            if (r3 == null) goto L11;
            a<SurfaceView> r5 = new a(r3);
        L12:
            this.a = r5;
            if (r5 == null) goto L33;
            View r7 = r5.a;
            if (r7 != null) goto L18;
        L28:
            SurfaceView r8 = (SurfaceView) r4;
            if (r8 == null) goto L34;
            r8.setZOrderMediaOverlay(true);
            r6.addView(r8, -1, -1);
            return;
        L34:
            return;
        L18:
            if (r5.b != null) goto L27;
            ViewParent r9 = r7.getParent();
            if ((r9 instanceof ViewGroup) == true) goto L23;
            r9 = null;
        L23:
            ViewGroup r11 = (ViewGroup) r9;
            if (r11 == null) goto L28;
            r5.b = r11;
            r5.c = r7.getLayoutParams();
            r11.removeView(r7);
            int r12 = XplayLog.a;
            XplayLog.a("SharedViewHolder", "occupied view " + r7);
        L27:
            r4 = r7;
            goto L28
        L33:
            return;
        L11:
            r5 = null;
            goto L12
        }
    }

    public i() {
    }

    @Override // g10.a
    public final boolean isEnable() {
        return true;
    }

    @Override // g10.a
    public final com.bytedance.android.live.broadcastgame.api.xplay.h e(com.bytedance.android.live.broadcastgame.api.xplay.f r2) {
        Intrinsics.checkNotNullParameter(r2, "instance");
        return new b();
    }
}
