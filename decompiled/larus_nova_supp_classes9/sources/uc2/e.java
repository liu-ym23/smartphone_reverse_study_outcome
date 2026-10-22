package uc2;

import android.text.TextUtils;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.dynamicstrategy.api.IDynamicStrategyContext;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.interactivity.api.settings.config.p;
import com.bytedance.android.livesdk.interactivity.zdanmaku.attributes.DanmakuType;
import com.bytedance.android.livesdk.interactivity.zdanmaku.binder.m;
import com.bytedance.android.livesdk.interactivity.zdanmaku.layout.danmakuline.IHeatChangeController;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.live.artist.render.RenderEntity;
import com.bytedance.live.zdanmaku.data.Danmaku;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import ju1.n;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import r52.b0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e extends a implements IHeatChangeController {
    public final ArrayList<b> a;
    public final ArrayList<Integer> b;
    public final com.bytedance.android.livesdk.interactivity.zdanmaku.layout.b c;
    public final e d;
    public IHeatChangeController.DanmakuHeat e;
    public final boolean f;

    public final boolean d() {
        int r0 = this.a.size();
        int r3 = 0;
        boolean r4 = true;
    L3:
        if (r3 >= r0) goto L10;
        if (((b) ListProtector.get(this.a, r3)).c() == false) goto L8;
        if (r4 == false) goto L8;
        r4 = true;
    L9:
        r3 = r3 + 1;
    L8:
        r4 = false;
        goto L9
    L10:
        int r1 = this.a.size();
        int r5 = 0;
        boolean r6 = true;
    L11:
        if (r5 >= r1) goto L18;
        if (((b) ListProtector.get(this.a, r5)).f() == false) goto L16;
        if (r6 == false) goto L16;
        r6 = true;
    L17:
        r5 = r5 + 1;
    L16:
        r6 = false;
        goto L17
    L18:
        if (r4 == true) goto L20;
        if (r6 == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final void g() {
        IntProgression r0 = RangesKt.step(RangesKt.until(1, this.a.size()), 2);
        int r1 = r0.getFirst();
        int r2 = r0.getLast();
        int r3 = r0.getStep();
        if (r3 < 0) goto L6;
        if (r1 <= r2) goto L7;
        return;
    L7:
        ((b) ListProtector.get(this.a, r1)).e = false;
        if (r1 == r2) goto L14;
        r1 = r1 + r3;
        goto L7
    L14:
        return;
    L6:
        if (r1 >= r2) goto L7;
    }

    public final boolean h() {
        IntProgression r0 = RangesKt.step(RangesKt.until(1, this.a.size()), 2);
        int r2 = r0.getFirst();
        int r3 = r0.getLast();
        int r1 = r0.getStep();
        if (r1 < 0) goto L6;
        if (r2 <= r3) goto L8;
        return false;
    L8:
        if (((b) ListProtector.get(this.a, r2)).e == false) goto L11;
        if (r2 == r3) goto L19;
        r2 = r2 + r1;
        goto L8
    L19:
        return false;
    L11:
        ((b) ListProtector.get(this.a, r2)).e = true;
        return true;
    L6:
        if (r2 >= r3) goto L8;
        return false;
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.layout.danmakuline.IHeatChangeController
    public final IHeatChangeController.DanmakuHeat a() {
        return this.e;
    }

    public final float b(int r2) {
        if (i(r2) == false) goto L6;
        return Float.MAX_VALUE;
    L6:
        com.bytedance.android.livesdk.interactivity.zdanmaku.i r3 = c(r2);
        if (r3 != null) goto L11;
        return 0.0f;
    L11:
        return r3.c();
    }

    public final com.bytedance.android.livesdk.interactivity.zdanmaku.i c(int r2) {
        if (i(r2) == false) goto L7;
        return null;
    L7:
        return ((b) ListProtector.get(this.a, r2)).c;
    }

    public final void f(int[] r5) {
        Intrinsics.checkNotNullParameter(r5, "locklines");
        int r0 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L10;
        int r2 = r5[r1];
        if (r2 >= this.a.size()) goto L9;
        if (((b) ListProtector.get(this.a, r2)).f == true) goto L9;
        ((b) ListProtector.get(this.a, r2)).f = true;
    L9:
        r1 = r1 + 1;
        goto L3
    }

    public final boolean i(int r2) {
        if (r2 < this.a.size()) goto L5;
        return true;
    L5:
        return false;
    }

    public final void j(int[] r6) {
        Intrinsics.checkNotNullParameter(r6, "locklines");
        int r0 = r6.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L10;
        int r3 = r6[r2];
        if (r3 >= this.a.size()) goto L9;
        if (((b) ListProtector.get(this.a, r3)).f == false) goto L9;
        ((b) ListProtector.get(this.a, r3)).f = false;
    L9:
        r2 = r2 + 1;
        goto L3
    }

    public e(com.bytedance.android.livesdk.interactivity.zdanmaku.layout.b r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r5, "initialConfig");
        this.f = r6;
        this.a = new ArrayList();
        this.b = new ArrayList();
        this.c = r5;
        this.d = this;
        this.e = IHeatChangeController.DanmakuHeat.LOW;
        int r7 = r5.a;
        int r0 = 0;
    L3:
        if (r0 >= r7) goto L9;
        ArrayList<b> r1 = this.a;
        if ((r0 % 2) != 0) goto L7;
        boolean r3 = true;
    L8:
        r1.add(new h(r0, r3, false, this));
        r0 = r0 + 1;
        goto L3
    L7:
        r3 = false;
        goto L8
    }

    public final void e(int r13, com.bytedance.android.livesdk.interactivity.zdanmaku.i r14) {
        Intrinsics.checkNotNullParameter(r14, "danmaku");
        boolean r1 = false;
        if (r13 < this.c.b.a) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L11;
        return;
    L11:
        r14.d = this.c.b.g;
        if (r14.getType() == DanmakuType.Privilege) goto L14;
    L16:
        float r2 = this.c.b.d;
        RenderEntity r3 = ((Danmaku) r14).c;
        if (r3 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("renderEntity");
    L19:
        float r4 = (r2 - r3.c.b) / 2;
    L20:
        com.bytedance.android.livesdk.interactivity.zdanmaku.layout.a r5 = this.c.b;
        float r6 = r5.b;
        int r7 = r5.e;
        r14.e(r6, (r4 + r7) + ((r5.d + r7) * r13));
        r14.f = r13;
        r14.e = (b) ListProtector.get(this.a, r13);
        k(r13, r14);
        r14.g = ((b) ListProtector.get(this.a, r13)).a();
        r14.h = ((b) ListProtector.get(this.a, r13)).b();
        b r15 = (b) ListProtector.get(this.a, r13);
        boolean r8 = this.f;
        String r9 = BuildConfig.FLAVOR;
        if (r8 == false) goto L79;
        m r16 = (m) r14.b().e(m.class);
        if (r16 == null) goto L28;
        String r17 = r16.j();
        if (r17 == null) goto L28;
        r9 = r17;
    L28:
        int r18 = r9.length();
        String r10 = com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.j.a;
        float r11 = ((p) b0.a.getValue()).a();
        float r19 = IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW;
        float r20 = r11 / r19;
        if (TextUtils.isEmpty(com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.j.a) == true) goto L77;
        IRoomContextService r21 = jc1.k.f(IRoomContextService.class);
        o r23 = null;
        if (r21 == null) goto L34;
        r23 = IRoomContextService.a.a(r21, null, 0, 3);
    L34:
        if (r23 == null) goto L40;
        com.bytedance.live.datacontext.m r24 = r23.getRoom();
        if (r24 == null) goto L40;
        IRoom r25 = (IRoom) r24.getValue();
        if (r25 == null) goto L40;
        r1 = r25.isMergeVSRoom();
    L40:
        if (r23 == null) goto L77;
        com.bytedance.live.datacontext.j r26 = r23.r2();
        if (r26 == null) goto L77;
        IDynamicStrategyContext r27 = (IDynamicStrategyContext) r26.getValue();
        if (r27 == null) goto L77;
        PropertyOwner r28 = r27.getStrategy("danmaku_speed_strategy");
        if (r28 == null) goto L77;
        n r29 = (n) r28.a;
        if (r29 == null) goto L77;
        int r30 = r29.b(3);
        if (r1 == false) goto L62;
        if (r30 == 1) goto L61;
        if (r30 == 2) goto L60;
        if (r30 == 3) goto L59;
        if (r30 == 4) goto L58;
        if (r30 == 5) goto L57;
        float r31 = com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.j.b.c();
    L73:
        if (r18 <= 10) goto L76;
        if (r30 == 5) goto L76;
        r31 = r31 * 1.1f;
    L76:
        r20 = r31 / r19;
        goto L77
    L57:
        r31 = com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.j.b.b();
        goto L73
    L58:
        r31 = com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.j.b.a();
        goto L73
    L59:
        r31 = com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.j.b.c();
        goto L73
    L60:
        r31 = com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.j.b.d();
        goto L73
    L61:
        r31 = com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.j.b.d();
        goto L73
    L62:
        if (r30 == 1) goto L72;
        if (r30 == 2) goto L71;
        if (r30 == 3) goto L70;
        if (r30 == 4) goto L69;
        if (r30 == 5) goto L68;
        r31 = com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.j.c.c();
        goto L73
    L68:
        r31 = com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.j.c.b();
        goto L73
    L69:
        r31 = com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.j.c.a();
        goto L73
    L70:
        r31 = com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.j.c.c();
        goto L73
    L71:
        r31 = com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.j.c.d();
        goto L73
    L72:
        r31 = com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.j.c.d();
    L77:
        r14.d = r20;
        return;
    L79:
        if (this.e == IHeatChangeController.DanmakuHeat.LOW) goto L94;
        m r33 = (m) r14.b().e(m.class);
        if (r33 == null) goto L86;
        String r34 = r33.j();
        if (r34 == null) goto L86;
        r9 = r34;
    L86:
        int r35 = r9.length();
        if (6 > r35) goto L92;
        if (10 < r35) goto L92;
        r14.d *= 1.05f;
    L92:
        if (r9.length() <= 10) goto L94;
        r14.d *= 1.1f;
    L94:
        r14.d *= r15.a;
        return;
    L14:
        if (r14.l() == false) goto L16;
        r4 = 0.0f;
        goto L20
    L5:
        if (i(r13) == true) goto L8;
        r0 = false;
        goto L9
    }

    public final void k(int r3, com.bytedance.android.livesdk.interactivity.zdanmaku.i r4) {
        Intrinsics.checkNotNullParameter(r4, "danmaku");
        if (i(r3) == false) goto L6;
        return;
    L6:
        if (r4.c() <= b(r3)) goto L9;
        ((b) ListProtector.get(this.a, r3)).c = r4;
        return;
    }
}
