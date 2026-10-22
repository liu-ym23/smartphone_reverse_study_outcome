package com.bytedance.android.livesdk.interactivity.seek;

import android.content.Context;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.progress.context.PlayerProgressServiceContext;
import com.bytedance.android.livesdk.chatroom.progress.service.IPlayerProgressService;
import com.bytedance.android.livesdk.chatroom.vsplayer.api.IVSPlayerService;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeHighLight;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import ec2.u1;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import jc1.k;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b {
    public final ArrayList<jc1.h> a;
    public IVSPlayerService b;
    public RoomContext c;
    public Disposable d;
    public final a e;
    public final long f;
    public boolean g;
    public final Context h;
    public final DataCenter i;

    public static final class a implements com.bytedance.android.livesdk.chatroom.vsplayer.api.d {
        public long a;
        public final /* synthetic */ b b;

        public final void E5() {
        }

        public final void P1() {
        }

        public final void onRenderStart() {
        }

        public final void v2(EpisodeHighLight r2) {
            Intrinsics.checkNotNullParameter(r2, "episodeHighLight");
        }

        public final void z() {
        }

        public final void C5() {
            b r0 = this.b;
            if (r0.c != null) goto L6;
            return;
        L6:
            if (b.a(r0) == false) goto L11;
            Iterator<T> r1 = this.b.a.iterator();
        L9:
            if (r1.hasNext() == false) goto L13;
            ((jc1.h) r1.next()).e(b.b(this.b));
            goto L9
        L13:
            return;
        }

        public final void D5() {
            Iterator<T> r0 = this.b.a.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            ((jc1.h) r0.next()).f(b.b(this.b));
            goto L4
        }

        public final void H5() {
            Iterator<T> r0 = this.b.a.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            ((jc1.h) r0.next()).h(b.b(this.b));
            goto L4
        }

        public final void g5() {
            b r0 = this.b;
            if (r0.c != null) goto L6;
            return;
        L6:
            if (b.a(r0) == false) goto L11;
            Iterator<T> r1 = this.b.a.iterator();
        L9:
            if (r1.hasNext() == false) goto L13;
            ((jc1.h) r1.next()).c(b.b(this.b));
            goto L9
        L13:
            return;
        }

        public final void k2() {
            b r0 = this.b;
            if (r0.c != null) goto L6;
            return;
        L6:
            if (b.a(r0) == false) goto L11;
            Iterator<T> r1 = this.b.a.iterator();
        L9:
            if (r1.hasNext() == false) goto L13;
            ((jc1.h) r1.next()).a(b.b(this.b));
            goto L9
        L13:
            return;
        }

        public final void l3() {
            b r0 = this.b;
            if (r0.c != null) goto L6;
            return;
        L6:
            if (b.a(r0) == false) goto L11;
            Iterator<T> r1 = this.b.a.iterator();
        L9:
            if (r1.hasNext() == false) goto L13;
            ((jc1.h) r1.next()).b(b.b(this.b));
            goto L9
        L13:
            return;
        }

        public a(b r3) {
            this.b = r3;
            this.a = -1;
        }

        public final void G5(boolean r6) {
            if (r6 == false) goto L4;
            return;
        L4:
            b r7 = this.b;
            if (r7.c != null) goto L7;
            return;
        L7:
            long r0 = b.b(r7);
            if (this.a != r0) goto L10;
        L15:
            this.a = r0;
            return;
        L10:
            if (b.a(this.b) == false) goto L15;
            Iterator<jc1.h> r8 = this.b.a.iterator();
        L13:
            if (r8.hasNext() == false) goto L15;
            r8.next().d(b.b(this.b));
            goto L13
        }

        public final void F5(EpisodeHighLight r2, Pair<Integer, Boolean> r3) {
            Intrinsics.checkNotNullParameter(r2, "episodeHighLight");
            Intrinsics.checkNotNullParameter(r3, "pair");
            com.bytedance.android.livesdk.chatroom.vsplayer.api.d.a.a(r2, r3);
        }

        public final void I5(EpisodeHighLight r2, Pair<Integer, Boolean> r3) {
            Intrinsics.checkNotNullParameter(r2, "episodeHighLight");
            Intrinsics.checkNotNullParameter(r3, "pair");
            com.bytedance.android.livesdk.chatroom.vsplayer.api.d.a.b(r2, r3);
        }
    }

    public final Context getContext() {
        return this.h;
    }

    public static final boolean a(b r2) {
        r2.getClass();
        IVSPlayerService r0 = k.f(IVSPlayerService.class);
        if (r0 == null) goto L13;
        IPlayerProgressService r1 = r0.provideVSProgressService(r2.i);
        if (r1 == null) goto L13;
        PlayerProgressServiceContext r3 = r1.provideContext(r2.i);
        if (r3 == null) goto L13;
        m r4 = r3.getVsRoomEnableSeek();
        if (r4 == null) goto L13;
        if (((Boolean) r4.getValue()).booleanValue() != true) goto L13;
        return true;
    L13:
        return false;
    }

    public static final long b(b r4) {
        return com.bytedance.android.livesdk.interactivity.common.utils.f.b(r4.i) / ((long) IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW);
    }

    public b(Context r3, DataCenter r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "dataCenter");
        this.h = r3;
        this.i = r4;
        this.a = new ArrayList();
        this.e = new a(this);
        this.f = ((long) ((Number) u1.a.getValue()).intValue()) * ((long) IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW);
    }
}
