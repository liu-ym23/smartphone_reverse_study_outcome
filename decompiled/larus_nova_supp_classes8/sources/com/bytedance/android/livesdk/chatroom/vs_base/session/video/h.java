package com.bytedance.android.livesdk.chatroom.vs_base.session.video;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.base.model.user.o0;
import com.bytedance.android.live.base.model.user.q0;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.android.livesdk.chatroom.vs_base.base.model.ReplayRoomState;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.ReplayRoomFragmentScopeUtil;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.q;
import com.bytedance.android.livesdkapi.depend.live.vs.VSConstants;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.List;
import jc1.k;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mq1.d0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class h {
    public Bundle A;
    public Function0<? extends Fragment> a;
    public ReplayRoomState b;
    public com.bytedance.android.livesdk.chatroom.vs_base.session.video.a c;
    public final ReplayEventHub d;
    public final ReplayVideoMetrics e;
    public Episode f;
    public boolean g;
    public final List<String> h;
    public final List<String> i;
    public int j;
    public boolean k;
    public boolean l;
    public boolean m;
    public boolean n;
    public boolean o;
    public String p;
    public String q;
    public String r;
    public vq1.b s;
    public vq1.b t;
    public pq1.a u;
    public final Context v;
    public long w;
    public String x;
    public final DataCenter y;
    public final LifecycleOwner z;

    public static final class a {
        public Context a;
        public long b;
        public String c;
        public DataCenter d;
        public LifecycleOwner e;
        public Bundle f;

        public a() {
            this.a = k.n(IMiddleWareHostContext.class).context();
            this.c = "0";
            this.f = new Bundle();
        }
    }

    public final Context getContext() {
        return this.v;
    }

    public final void a(ReplayRoomState r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.b = r2;
    }

    public final void b(Episode r4) {
        d0 r0 = ReplayRoomFragmentScopeUtil.b();
        if (r0 == null) goto L11;
        if (r4 != null) goto L6;
    L9:
        boolean r1 = true;
    L10:
        r0.d(r1);
        goto L11
    L6:
        if (r4.style != 2) goto L9;
        r1 = false;
    L11:
        Episode r2 = this.f;
        if (r2 == null) goto L14;
        String r3 = r2.getPlayVideoModel();
    L15:
        this.q = r3;
        this.f = r4;
        return;
    L14:
        r3 = null;
        goto L15
    }

    public final boolean c(Bundle r6) {
        if (this.w <= 0) goto L5;
        return false;
    L5:
        if (q0.a(this.x) == true) goto L23;
        if (r6 != null) goto L8;
        return false;
    L8:
        if (r6.containsKey(VSConstants.EXTRA_ITEM_ID) == false) goto L11;
        this.w = r6.getLong(VSConstants.EXTRA_ITEM_ID, 0);
    L11:
        if (r6.containsKey(VSConstants.EXTRA_USER_ID) == false) goto L14;
        this.x = o0.a.d(o0.a, r6, VSConstants.EXTRA_USER_ID);
    L14:
        if (r6.containsKey(VSConstants.EXTRA_ENTER_FROM_USER_ID) == false) goto L17;
        com.bytedance.android.livesdk.chatroom.vs_base.session.video.a r0 = this.c;
        r6.getLong(VSConstants.EXTRA_ENTER_FROM_USER_ID, 0);
        r0.getClass();
    L17:
        if (r6.containsKey("live.SCREEN_ORIENTATION") == false) goto L19;
        this.j = r6.getInt("live.SCREEN_ORIENTATION");
    L19:
        this.A = r6;
        return true;
    L23:
        return false;
    }

    public h(Context r2, long r3, String r5, DataCenter r6, LifecycleOwner r7, Bundle r8) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r5, "userId");
        Intrinsics.checkNotNullParameter(r6, "dataCenter");
        Intrinsics.checkNotNullParameter(r8, "extra");
        this.v = r2;
        this.w = r3;
        this.x = r5;
        this.y = r6;
        this.z = r7;
        this.A = r8;
        if (r3 == 0) goto L5;
    L8:
        ReplayRoomState r4 = ReplayRoomState.INITIALIZED;
    L9:
        this.b = r4;
        this.c = new com.bytedance.android.livesdk.chatroom.vs_base.session.video.a(this.A);
        ReplayEventHub r9 = new ReplayEventHub();
        this.d = r9;
        this.e = new ReplayVideoMetrics(this, r9);
        List<String> r10 = this.A.getStringArrayList(VSConstants.EXTRA_BG_URLS);
        if (r10 != null) goto L13;
        r10 = CollectionsKt.emptyList();
    L13:
        this.h = r10;
        List<String> r11 = this.A.getStringArrayList(VSConstants.EXTRA_VS_EPISODE_COVER_URL);
        if (r11 != null) goto L17;
        r11 = CollectionsKt.emptyList();
    L17:
        this.i = r11;
        this.j = this.A.getInt(VSConstants.EXTRA_VS_ORIENTATION, 1);
        this.k = this.A.getBoolean(VSConstants.EXTRA_VS_SHARE_VIEW);
        mq1.c r12 = q.a();
        if (r12 == null) goto L20;
        String r13 = r12.getCachedVideoId(this.w);
    L21:
        this.p = r13;
        this.q = this.A.getString(VSConstants.EXTRA_VIDEO_MODEL);
        this.r = this.A.getString(VSConstants.EXTRA_VS_VIDEO_ID);
        if (this.c.m == true) goto L24;
        return;
    L24:
        if (q0.a(this.x) == false) goto L28;
        this.w = 0;
        return;
    L28:
        return;
    L20:
        r13 = null;
        goto L21
    L5:
        if (q0.a(r5) == true) goto L8;
        r4 = ReplayRoomState.IDLE;
        goto L9
    }
}
