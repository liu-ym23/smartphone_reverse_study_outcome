package com.bytedance.android.live.revlink.impl.pk.feedview;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.revenue.common.ViewUtilsKt;
import com.bytedance.android.live.revlink.impl.pk.feedview.layout.FeedPkWindowManager;
import com.bytedance.android.live.revlink.impl.pk.feedview.machine.FeedPkStateMachine;
import com.bytedance.android.live.revlink.impl.pk.feedview.machine.v;
import com.bytedance.android.livesdk.link.model.IBattleConfigSetting;
import com.bytedance.android.livesdk.link.model.api.IBaseBattleSetting;
import com.bytedance.android.livesdk.link.model.h9;
import com.bytedance.android.livesdk.link.model.v2;
import com.bytedance.android.livesdk.link.model.w2;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.disposables.CompositeDisposable;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import w20.v9;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class FeedPkWidget implements qc0.c, com.bytedance.android.live.revlink.impl.pk.feedview.layout.b, com.bytedance.android.live.revlink.impl.pk.scopeservice.a {
    public final FeedPkStateMachine a;
    public final com.bytedance.android.live.revlink.impl.pk.feedview.viewstate.b b;
    public final com.bytedance.android.live.revlink.impl.pk.feedview.bridge.c c;
    public final FeedPkWindowManager d;
    public final b e;
    public final com.bytedance.android.live.revlink.impl.pk.feedview.breakthrough.a f;
    public boolean g;
    public qc0.e h;
    public final CompositeDisposable i;
    public final FeedPkLynxWidget j;
    public final FeedPkWidget$onPKStateChange$1 k;
    public final c41.a l;
    public final boolean m;

    public static final class a {
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ FeedPkWidget a;

        public b(FeedPkWidget r1) {
            this.a = r1;
        }

        public final void onChanged(Object r4) {
            g90.a r5 = (g90.a) r4;
            FeedPkWidget r0 = this.a;
            if (r5 != null) goto L5;
            r0.getClass();
            return;
        L5:
            FeedPkWindowManager r1 = r0.d;
            xx0.a r2 = new xx0.a(r5);
            r1.getClass();
            Intrinsics.checkNotNullParameter(r2, "draw");
            a41.c r3 = (a41.c) r1.b.getValue();
            r3.getClass();
            Intrinsics.checkNotNullParameter(r2, "draw");
            r3.a = r2;
            r1.b().c();
        }
    }

    static {
    }

    public final void getPkExpandType() {
    }

    public final void getProgressAnimUrl() {
    }

    public final void getTeamTaskExtendView() {
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.feedview.layout.b
    public final boolean c() {
        com.bytedance.android.live.revlink.impl.pk.feedview.machine.l r0 = this.b.e;
        if (r0 != null) goto L5;
        return false;
    L5:
        if ((r0 instanceof com.bytedance.android.live.revlink.impl.pk.feedview.machine.l.c) == false) goto L21;
        v r1 = ((com.bytedance.android.live.revlink.impl.pk.feedview.machine.l.c) r0).c;
        if (r1 == null) goto L15;
        IBaseBattleSetting r2 = r1.e;
        if (r2 == null) goto L15;
        IBattleConfigSetting r3 = r2.getBattleConfigSetting();
        if (r3 == null) goto L15;
        w2 r4 = r3.getShellConfig();
        if (r4 == null) goto L15;
        long r5 = r4.getType();
    L17:
        if (r5 <= 0) goto L22;
        return true;
    L22:
        return false;
    L15:
        r5 = 0;
        goto L17
    L21:
        return false;
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.feedview.layout.b
    public final boolean isNormalPk() {
        com.bytedance.android.live.revlink.impl.pk.feedview.machine.l r0 = this.b.e;
        if (r0 != null) goto L5;
        return false;
    L5:
        if ((r0 instanceof com.bytedance.android.live.revlink.impl.pk.feedview.machine.l.c) == false) goto L31;
        IBaseBattleSetting r1 = ((com.bytedance.android.live.revlink.impl.pk.feedview.machine.l.c) r0).c.e;
        if (r1 == null) goto L32;
        IBattleConfigSetting r2 = r1.getBattleConfigSetting();
        if (r2 == null) goto L33;
        w2 r3 = r2.getShellConfig();
        if (r3 == null) goto L13;
        long r5 = r3.getType();
    L15:
        if (r5 != 0) goto L34;
        v2 r4 = r2.getSelfSettingRate();
        if (r4 == null) goto L19;
        int r6 = (int) r4.getPkValueType();
    L20:
        if (r6 != 0) goto L35;
        h9 r7 = r2.getSpecifyGiftConfig();
        if (r7 == null) goto L26;
        List r8 = r7.getGiftIds();
        if (r8 == null) goto L26;
        int r9 = r8.size();
    L27:
        if (r9 != 0) goto L36;
        return true;
    L36:
        return false;
    L26:
        r9 = 0;
        goto L27
    L35:
        return false;
    L19:
        r6 = 0;
        goto L20
    L34:
        return false;
    L13:
        r5 = 0;
        goto L15
    L33:
        return false;
    L32:
        return false;
    L31:
        return false;
    }

    public final com.bytedance.android.live.revlink.impl.pk.feedview.viewstate.b getViewState() {
        return this.b;
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.scopeservice.a
    public final void a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "tag");
        int r0 = r3.hashCode();
        if (r0 != (-524189039)) goto L5;
        r3.equals("pk_time");
        return;
    L5:
        if (r0 == (-204359949)) goto L11;
        if (r0 != 1759912825) goto L21;
        r3.equals("pk_guest_info");
        return;
    L21:
        return;
    L11:
        if (r3.equals("pve_bar") == false) goto L18;
        FeedPkWindowManager r4 = this.b.a;
        if (r4 == null) goto L19;
        r4.h(null);
        return;
    L19:
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.scopeservice.a
    public final void b(String r3) {
        Intrinsics.checkNotNullParameter(r3, "tag");
        if (r3.hashCode() == (-204359949)) goto L6;
    L8:
        this.d.b().c();
        return;
    L6:
        if (r3.equals("pve_bar") == false) goto L8;
        this.b.e();
        this.b.f(0);
        goto L8
    }

    public final void d(pc0.a r8) {
        this.d.g(r8);
        com.bytedance.android.live.revlink.impl.pk.feedview.breakthrough.a r0 = this.f;
        if (r0 == null) goto L7;
        r0.a = r8;
        if (r0.e() == false) goto L7;
        r0.d();
    L7:
        FeedPkLynxWidget r1 = this.j;
        r1.p = r8;
        FrameLayout r2 = r1.y;
        if (r8 != null) goto L10;
    L12:
        boolean r3 = false;
    L13:
        ViewUtilsKt.g(r2, r3);
        com.bytedance.android.live.revlink.impl.pk.feedview.viewstate.a r4 = r1.d;
        r4.getClass();
        if (r8 == null) goto L16;
        String r5 = r8.getChannelId();
    L18:
        if ((!Intrinsics.areEqual(r5, (String) r4.a.getValue())) == false) goto L24;
        MutableLiveData<String> r6 = r4.a;
        if (r8 == null) goto L22;
        String r7 = r8.getChannelId();
    L23:
        r6.setValue(r7);
        goto L24
    L22:
        r7 = null;
    L24:
        if (r8 == null) goto L27;
        JSONObject r9 = new JSONObject();
        JSONObject r10 = new JSONObject();
        com.bytedance.android.anniex.container.util.i r12 = com.bytedance.android.anniex.container.util.i.a;
        r10.put("screen_width", r12.b().widthPixels);
        r10.put("screen_height", r12.d());
        r10.put("container_width", r4.j.getWidth());
        r10.put("container_height", r4.j.getHeight());
        r10.put("player_width", ((Number) ((Pair) r4.m.invoke()).getFirst()).intValue());
        r10.put("player_height", ((Number) ((Pair) r4.m.invoke()).getSecond()).intValue());
        r9.put("extra_info", r10);
        JSONObject r13 = new JSONObject();
        r13.put("anchor_interact_info", null);
        r13.put("canvas", r8.getCanvas());
        r13.put("grids", r8.e());
        r13.put("channel_id", r8.getChannelId());
        r9.put("app_data", r13);
        r9.put("meta_sei", r8);
        r4.b.setValue(r9);
        return;
    L27:
        return;
    L16:
        r5 = null;
        goto L18
    L10:
        if (r8.d() != 0) goto L12;
        r3 = true;
        goto L13
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.scopeservice.a
    public final void handleBattleBgImage(v9 r7) {
        Intrinsics.checkNotNullParameter(r7, "params");
        FeedPkWindowManager r0 = this.d;
        String r1 = r7.a;
        String r8 = r7.b;
        a41.b r2 = (a41.b) r0.d.getValue();
        r2.getClass();
        t41.a r3 = t41.a.m;
        r3.getClass();
        if (((Boolean) t41.a.k.getValue(r3, t41.a.a[9])).booleanValue() == false) goto L7;
        r2.a(r1, r8);
        r2.a = r1;
        r2.b = r8;
        return;
    }

    /* JADX WARN: Type inference failed for: r0v10, types: [com.bytedance.android.live.revlink.impl.pk.feedview.FeedPkWidget$onPKStateChange$1] */
    public FeedPkWidget(c41.a r13, FrameLayout r14, boolean r15, boolean r16, boolean r17) {
        Intrinsics.checkNotNullParameter(r13, "scope");
        Intrinsics.checkNotNullParameter(r14, "container");
        this.l = r13;
        this.m = r15;
        Context r0 = r14.getContext();
        if (r0 != null) goto L5;
        r0 = s1.getContext();
    L5:
        Context r10 = r0;
        FeedPkStateMachine r1 = new FeedPkStateMachine(new FeedPkWidget$machine$1(this));
        this.a = r1;
        com.bytedance.android.live.revlink.impl.pk.feedview.viewstate.b r2 = new com.bytedance.android.live.revlink.impl.pk.feedview.viewstate.b();
        this.b = r2;
        com.bytedance.android.live.revlink.impl.pk.feedview.bridge.c r3 = new com.bytedance.android.live.revlink.impl.pk.feedview.bridge.c(r2, r1);
        this.c = r3;
        FeedPkWindowManager r8 = new FeedPkWindowManager(r14, r15, r16, r17);
        this.d = r8;
        this.e = new b(this);
        this.i = new CompositeDisposable();
        FrameLayout r4 = r8.c().i;
        if (r4 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("lynxContainer");
    L8:
        FeedPkLynxWidget r12 = new FeedPkLynxWidget(r4, r2, r3, this, r15, r16, new FeedPkWidget$lynxWidget$1(this), r8);
        this.j = r12;
        this.f = new com.bytedance.android.live.revlink.impl.pk.feedview.breakthrough.a(r10, r12);
        this.k = new FeedPkWidget$onPKStateChange$1(this);
    }
}
