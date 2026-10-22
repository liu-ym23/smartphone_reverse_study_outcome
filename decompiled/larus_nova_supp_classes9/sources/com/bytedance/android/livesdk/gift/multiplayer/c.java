package com.bytedance.android.livesdk.gift.multiplayer;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.livesdk.gift.platform.business.effect.player.t;
import com.bytedance.android.livesdk.gift.platform.business.effect.player.u;
import com.bytedance.android.livesdkapi.depend.live.gift.IPlayerActionListener;
import com.bytedance.android.livesdkapi.depend.live.gift.IPlayerProgressListener;
import com.bytedance.android.livesdkapi.depend.live.gift.IResultMonitor;
import com.ss.android.ugc.aweme.live.alphaplayer.listener.AlphaPlayerAction;
import com.ss.android.ugc.aweme.live.alphaplayer.listener.IMonitor;
import com.ss.android.ugc.aweme.live.alphaplayer.listener.IProgressListener;
import com.ss.android.ugc.aweme.live.alphaplayer.model.DataSource;
import com.ss.android.ugc.aweme.live.alphaplayer.multi_player.MultiPlayerController;
import com.ss.android.ugc.aweme.live.alphaplayer.player.AbsPlayer;
import com.ss.android.ugc.aweme.live.alphaplayer.player.DefaultSystemPlayer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c {
    public MultiPlayerController a;
    public boolean b;
    public IPlayerActionListener c;
    public IPlayerProgressListener d;
    public IResultMonitor e;
    public final d f;
    public final b g;
    public final e h;
    public final C0013c i;
    public final f j;
    public final LifecycleOwner k;

    public static final class a {
    }

    public static final class b implements AlphaPlayerAction {
        public final /* synthetic */ c a;

        public final void a() {
            c r0 = this.a;
            if (r0.b == false) goto L8;
            IPlayerActionListener r1 = r0.c;
            if (r1 == null) goto L9;
            r1.onStart();
            return;
        L9:
            return;
        }

        public final void b() {
            c r0 = this.a;
            if (r0.b == false) goto L8;
            IPlayerActionListener r1 = r0.c;
            if (r1 == null) goto L9;
            r1.onEnd();
            return;
        L9:
            return;
        }

        public b(c r1) {
            this.a = r1;
        }

        public final void c(int r8, int r9, DataSource.ScaleType r10) {
            MultiPlayerController r0 = this.a.a;
            if (r0 == null) goto L8;
            View r1 = r0.b.getView();
            if (r1 == null) goto L9;
            float r3 = r8;
            float r4 = r9;
            com.bytedance.android.livesdk.gift.multiplayer.b.a(r1, r3, r4, r10);
            com.bytedance.android.livesdk.gift.multiplayer.b.b(r1.getMeasuredWidth(), r1.getMeasuredHeight(), r3, r4, r10, this.a.c);
            return;
        L9:
            return;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.gift.multiplayer.c$c, reason: collision with other inner class name */
    public static final class C0013c implements IMonitor {
        public final /* synthetic */ c a;

        public C0013c(c r1) {
            this.a = r1;
        }

        public final void a(String r3, Exception r4) {
            jy0.b.b("LiveMultiPlayerController", "create " + r3 + " background failure, errorMsg: ", r4);
        }

        public final void monitor(boolean r8, String r9, int r10, int r11, String r13) {
            IResultMonitor r1 = this.a.e;
            if (r1 == null) goto L6;
            r1.monitor(r8, r9, r10, r11, "background error info: " + r13);
            return;
        }
    }

    public static final class d implements AlphaPlayerAction {
        public final /* synthetic */ c a;

        public final void a() {
            c r0 = this.a;
            if (r0.b == false) goto L5;
            return;
        L5:
            IPlayerActionListener r1 = r0.c;
            if (r1 == null) goto L9;
            r1.onStart();
            return;
        }

        public final void b() {
            c r0 = this.a;
            if (r0.b == false) goto L5;
            return;
        L5:
            IPlayerActionListener r1 = r0.c;
            if (r1 == null) goto L9;
            r1.onEnd();
            return;
        }

        public d(c r1) {
            this.a = r1;
        }

        public final void c(int r8, int r9, DataSource.ScaleType r10) {
            MultiPlayerController r0 = this.a.a;
            if (r0 == null) goto L8;
            View r1 = r0.getView();
            if (r1 == null) goto L9;
            float r3 = r8;
            float r4 = r9;
            com.bytedance.android.livesdk.gift.multiplayer.b.a(r1, r3, r4, r10);
            com.bytedance.android.livesdk.gift.multiplayer.b.b(r1.getMeasuredWidth(), r1.getMeasuredHeight(), r3, r4, r10, this.a.c);
            return;
        L9:
            return;
        }
    }

    public static final class e implements IMonitor {
        public final /* synthetic */ c a;

        public e(c r1) {
            this.a = r1;
        }

        public final void a(String r3, Exception r4) {
            jy0.b.b("LiveMultiPlayerController", "create " + r3 + " foreground failure, errorMsg: ", r4);
        }

        public final void monitor(boolean r8, String r9, int r10, int r11, String r13) {
            IResultMonitor r1 = this.a.e;
            if (r1 == null) goto L6;
            r1.monitor(r8, r9, r10, r11, "foreground error info: " + r13);
            return;
        }
    }

    public static final class f implements IProgressListener {
        public final /* synthetic */ c a;

        public f(c r1) {
            this.a = r1;
        }

        public final void onProgress(long r2) {
            IPlayerProgressListener r0 = this.a.d;
            if (r0 == null) goto L6;
            r0.onProgress(r2);
            return;
        }
    }

    static {
    }

    public c(LifecycleOwner r2) {
        Intrinsics.checkNotNullParameter(r2, "owner");
        this.k = r2;
        this.f = new d(this);
        this.g = new b(this);
        this.h = new e(this);
        this.i = new C0013c(this);
        this.j = new f(this);
    }

    public static AbsPlayer a(Context r2) {
        if (com.bytedance.android.livesdk.gift.platform.business.effect.a.g() != 1) goto L8;
        if (ay1.b.o() == true) goto L8;
        return new DefaultSystemPlayer();
    L8:
        if (com.bytedance.android.livesdk.gift.platform.business.effect.a.g() != 4) goto L10;
        AbsPlayer r0 = new t(r2);
    L12:
        return r0;
    L10:
        r0 = new u(r2);
        goto L12
    }

    public final void b(FrameLayout r2, FrameLayout r3) {
        Intrinsics.checkNotNullParameter(r2, "foregroundContainer");
        Intrinsics.checkNotNullParameter(r3, "backgroundContainer");
        MultiPlayerController r0 = this.a;
        if (r0 == null) goto L5;
        r0.detachAlphaView(r2);
        r0.j(r3);
        r0.release();
    L5:
        this.a = null;
    }
}
